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
    private static int eQI = 7;
    private boolean aKI;
    private AdvertAppInfo eQK;
    private boolean eQL;
    private b eQM;
    private c eQN;
    private TbPageContext<?> mContext;
    private int eQJ = 0;
    private boolean eQO = false;
    private final View.OnClickListener eQP = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eQK != null) {
                if (a.this.eQM == null || !a.this.eQM.eQX || a.this.eQM.aRK() != view) {
                    if (u.I((Activity) view.getContext())) {
                        a.this.eQN.aRQ();
                        com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.eQK));
                        int i = a.this.eQK.agd;
                        if (i == 0 || i == 3) {
                            if (!j.kK() || j.kL()) {
                                String str = a.this.eQK.agg;
                                if (StringUtils.isNull(str)) {
                                    str = a.this.mContext.getString(e.j.app_name);
                                }
                                a.this.eQN.aRS();
                                if (s.a(a.this.mContext.getPageActivity(), a.this.eQK, 0, str)) {
                                    a.this.eQN.pH(a.this.eQK.agk);
                                    return;
                                }
                                return;
                            }
                            a.this.c(a.this.eQK);
                            return;
                        } else if (i == 1) {
                            s.f(a.this.eQK);
                            a.this.eQK.agd = 3;
                            a.this.aRF();
                            return;
                        } else if (i == 2) {
                            if (com.baidu.tieba.recapp.download.d.bqc().gS(a.this.eQK.agk)) {
                                u.aD(a.this.mContext.getPageActivity(), a.this.eQK.agk);
                                return;
                            }
                            a.this.eQK.agd = 0;
                            a.this.aRF();
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
    private final View.OnClickListener eQQ = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eQK != null) {
                if (a.this.eQM == null || !a.this.eQM.eQX || a.this.eQM.aRK() != view) {
                    a.this.eQN.aRQ();
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.eQK));
                    r.bpV().bpS().a(a.this.mContext.getPageActivity(), new String[]{a.this.eQK.agi}, true);
                }
            }
        }
    };
    private final CustomMessageListener eQR = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.aKI = false;
        this.eQL = false;
        this.aKI = z;
        this.eQL = z2;
        this.mContext = tbPageContext;
        this.mContext.registerListener(2001118, this.eQR);
        this.eQN = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.eQK = advertAppInfo;
        this.eQJ = i;
        this.eQN.d(this.eQK);
    }

    public boolean aRE() {
        if (!this.eQL || this.eQK == null) {
            return false;
        }
        return (this.eQK.uJ() || this.eQK.uI()) && !u.isInstalledPackage(this.mContext.getPageActivity(), this.eQK.agk);
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View f(ViewGroup viewGroup, int i) {
        if (pw(i)) {
            this.eQM = new b(viewGroup);
            aRF();
            viewGroup.addView(this.eQM.getView());
            return this.eQM.getView();
        }
        return null;
    }

    private boolean pw(int i) {
        return aRE() && this.eQJ != 0 && i == this.eQJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRF() {
        if (this.eQK != null && this.eQK.agr != null) {
            aRG();
            if (this.eQK.uJ()) {
                this.eQM.aRL().setVisibility(8);
                this.eQM.t(this.eQQ);
            } else if (this.eQK.uI()) {
                this.eQM.aRL().setVisibility(0);
                this.eQM.t(this.eQP);
                aRH();
            }
            s.a(this.eQK.agr.agK, this.eQM.eQU, this.eQK.agr.tagRatio, l.h(this.mContext.getPageActivity(), e.C0141e.ds26));
            if (!TextUtils.isEmpty(this.eQK.agr.adSource)) {
                this.eQM.eQW.setText(this.eQK.agr.adSource);
                this.eQM.eQV.setVisibility(0);
                return;
            }
            this.eQM.eQV.setVisibility(8);
        }
    }

    private void aRG() {
        this.eQM.aRK().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void k(String str, boolean z) {
                if (z) {
                    a.this.eQM.aRO();
                }
                a.this.eQM.aRP();
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                a.this.eQM.aRP();
            }
        });
        this.eQM.aRK().startLoad(this.eQK.agr.agC, this.aKI ? 30 : 31, 720, 720, false);
    }

    private void aRH() {
        if (this.eQK != null) {
            String str = this.eQK.agg;
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(e.j.app_name);
            }
            if (com.baidu.tieba.recapp.download.d.bqc().gS(this.eQK.agk)) {
                this.eQK.agd = 2;
            } else if (com.baidu.tieba.recapp.download.d.bqc().ci(this.eQK.agk, str)) {
                if (com.baidu.tieba.recapp.download.d.bqc().gQ(this.eQK.agk)) {
                    this.eQK.agd = 1;
                } else {
                    this.eQK.agd = 3;
                }
            }
            switch (this.eQK.agd) {
                case 0:
                    String string = this.mContext.getString(e.j.install_app);
                    if (this.eQK.agr != null && !StringUtils.isNull(this.eQK.agr.buttonText)) {
                        string = this.eQK.agr.buttonText;
                    }
                    if (string.length() > eQI) {
                        string = string.substring(0, eQI);
                    }
                    this.eQM.pG(string);
                    return;
                case 1:
                    this.eQM.aRM();
                    return;
                case 2:
                    this.eQM.aRN();
                    return;
                case 3:
                    this.eQM.pG(this.mContext.getString(e.j.pb_download_pause));
                    return;
                default:
                    this.eQM.aRL().setVisibility(8);
                    this.eQM.t(null);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdvertAppInfo advertAppInfo) {
        String string;
        if (advertAppInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            if (j.kM()) {
                string = this.mContext.getString(e.j.frs_network_tips);
            } else {
                string = this.mContext.getString(e.j.confirm_download_app);
            }
            aVar.dT(string);
            aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.eQK.agg;
                    if (StringUtils.isNull(str)) {
                        str = a.this.mContext.getString(e.j.app_name);
                    }
                    a.this.eQN.aRS();
                    if (s.a(a.this.mContext.getPageActivity(), a.this.eQK, 0, str)) {
                        a.this.eQN.pH(a.this.eQK.agk);
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
            aVar.b(this.mContext).yl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.eQK != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.eQK.agk, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.eQK.agd = 2;
                    } else if (status == 2 || status == 4) {
                        if (!ao.isEmpty(downloadData.getStatusMsg())) {
                            this.mContext.showToast(downloadData.getStatusMsg());
                        }
                        this.eQK.agd = 0;
                    } else if (status == 1) {
                        this.eQK.agd = 1;
                    }
                    aRF();
                }
            }
        }
    }

    public void aRI() {
        if (!this.eQO) {
            this.eQO = true;
            this.eQN.aRR();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.eQK));
        }
    }
}
