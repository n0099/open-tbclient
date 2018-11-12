package com.baidu.tieba.image;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.u;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements ImagePagerAdapter.a {
    private static int eZI = 7;
    private boolean aQa;
    private AdvertAppInfo eZK;
    private boolean eZL;
    private b eZM;
    private c eZN;
    private TbPageContext<?> mContext;
    private int eZJ = 0;
    private boolean eZO = false;
    private final View.OnClickListener eZP = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eZK != null) {
                if (a.this.eZM == null || !a.this.eZM.eZX || a.this.eZM.aUv() != view) {
                    if (u.O((Activity) view.getContext())) {
                        a.this.eZN.aUB();
                        com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.eZK));
                        int i = a.this.eZK.alO;
                        if (i == 0 || i == 3) {
                            if (!j.kV() || j.kW()) {
                                String str = a.this.eZK.alQ;
                                if (StringUtils.isNull(str)) {
                                    str = a.this.mContext.getString(e.j.app_name);
                                }
                                a.this.eZN.aUD();
                                if (s.a(a.this.mContext.getPageActivity(), a.this.eZK, 0, str)) {
                                    a.this.eZN.qk(a.this.eZK.alU);
                                    return;
                                }
                                return;
                            }
                            a.this.c(a.this.eZK);
                            return;
                        } else if (i == 1) {
                            s.f(a.this.eZK);
                            a.this.eZK.alO = 3;
                            a.this.aUq();
                            return;
                        } else if (i == 2) {
                            if (com.baidu.tieba.recapp.download.d.bsN().hh(a.this.eZK.alU)) {
                                u.aD(a.this.mContext.getPageActivity(), a.this.eZK.alU);
                                return;
                            }
                            a.this.eZK.alO = 0;
                            a.this.aUq();
                            return;
                        } else {
                            return;
                        }
                    }
                    l.showToast((Activity) view.getContext(), e.j.write_external_storage_permission_denied_fun_disable);
                }
            }
        }
    };
    private final View.OnClickListener eZQ = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eZK != null) {
                if (a.this.eZM == null || !a.this.eZM.eZX || a.this.eZM.aUv() != view) {
                    a.this.eZN.aUB();
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.eZK));
                    r.bsG().bsD().a(a.this.mContext.getPageActivity(), new String[]{a.this.eZK.alS}, true);
                }
            }
        }
    };
    private final CustomMessageListener eZR = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && !customResponsedMessage.hasError()) {
                a.this.e(customResponsedMessage);
            }
        }
    };

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.aQa = false;
        this.eZL = false;
        this.aQa = z;
        this.eZL = z2;
        this.mContext = tbPageContext;
        this.mContext.registerListener(2001118, this.eZR);
        this.eZN = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.eZK = advertAppInfo;
        this.eZJ = i;
        this.eZN.d(this.eZK);
    }

    public boolean aUp() {
        if (!this.eZL || this.eZK == null) {
            return false;
        }
        return (this.eZK.xa() || this.eZK.wZ()) && !u.isInstalledPackage(this.mContext.getPageActivity(), this.eZK.alU);
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View f(ViewGroup viewGroup, int i) {
        if (qn(i)) {
            this.eZM = new b(viewGroup);
            aUq();
            viewGroup.addView(this.eZM.getView());
            return this.eZM.getView();
        }
        return null;
    }

    private boolean qn(int i) {
        return aUp() && this.eZJ != 0 && i == this.eZJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUq() {
        if (this.eZK != null && this.eZK.ama != null) {
            aUr();
            if (this.eZK.xa()) {
                this.eZM.aUw().setVisibility(8);
                this.eZM.v(this.eZQ);
            } else if (this.eZK.wZ()) {
                this.eZM.aUw().setVisibility(0);
                this.eZM.v(this.eZP);
                aUs();
            }
            s.a(this.eZK.ama.amt, this.eZM.eZU, this.eZK.ama.tagRatio, l.h(this.mContext.getPageActivity(), e.C0200e.ds26));
            if (!TextUtils.isEmpty(this.eZK.ama.adSource)) {
                this.eZM.eZW.setText(this.eZK.ama.adSource);
                this.eZM.eZV.setVisibility(0);
                return;
            }
            this.eZM.eZV.setVisibility(8);
        }
    }

    private void aUr() {
        this.eZM.aUv().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z) {
                    a.this.eZM.aUz();
                }
                a.this.eZM.aUA();
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                a.this.eZM.aUA();
            }
        });
        this.eZM.aUv().startLoad(this.eZK.ama.aml, this.aQa ? 30 : 31, 720, 720, false);
    }

    private void aUs() {
        if (this.eZK != null) {
            String str = this.eZK.alQ;
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(e.j.app_name);
            }
            if (com.baidu.tieba.recapp.download.d.bsN().hh(this.eZK.alU)) {
                this.eZK.alO = 2;
            } else if (com.baidu.tieba.recapp.download.d.bsN().ct(this.eZK.alU, str)) {
                if (com.baidu.tieba.recapp.download.d.bsN().hf(this.eZK.alU)) {
                    this.eZK.alO = 1;
                } else {
                    this.eZK.alO = 3;
                }
            }
            switch (this.eZK.alO) {
                case 0:
                    String string = this.mContext.getString(e.j.install_app);
                    if (this.eZK.ama != null && !StringUtils.isNull(this.eZK.ama.buttonText)) {
                        string = this.eZK.ama.buttonText;
                    }
                    if (string.length() > eZI) {
                        string = string.substring(0, eZI);
                    }
                    this.eZM.qj(string);
                    return;
                case 1:
                    this.eZM.aUx();
                    return;
                case 2:
                    this.eZM.aUy();
                    return;
                case 3:
                    this.eZM.qj(this.mContext.getString(e.j.pb_download_pause));
                    return;
                default:
                    this.eZM.aUw().setVisibility(8);
                    this.eZM.v(null);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdvertAppInfo advertAppInfo) {
        String string;
        if (advertAppInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            if (j.kX()) {
                string = this.mContext.getString(e.j.frs_network_tips);
            } else {
                string = this.mContext.getString(e.j.confirm_download_app);
            }
            aVar.ej(string);
            aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.eZK.alQ;
                    if (StringUtils.isNull(str)) {
                        str = a.this.mContext.getString(e.j.app_name);
                    }
                    a.this.eZN.aUD();
                    if (s.a(a.this.mContext.getPageActivity(), a.this.eZK, 0, str)) {
                        a.this.eZN.qk(a.this.eZK.alU);
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.image.a.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.mContext).AB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.eZK != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.eZK.alU, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.eZK.alO = 2;
                    } else if (status == 2 || status == 4) {
                        if (!ao.isEmpty(downloadData.getStatusMsg())) {
                            this.mContext.showToast(downloadData.getStatusMsg());
                        }
                        this.eZK.alO = 0;
                    } else if (status == 1) {
                        this.eZK.alO = 1;
                    }
                    aUq();
                }
            }
        }
    }

    public void aUt() {
        if (!this.eZO) {
            this.eZO = true;
            this.eZN.aUC();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.eZK));
        }
    }
}
