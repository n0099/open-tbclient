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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.view.c;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.u;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements c.a {
    private static int eUJ = 7;
    private TbPageContext<?> aRR;
    private boolean bmF;
    private AdvertAppInfo eUL;
    private boolean eUM;
    private b eUN;
    private c eUO;
    private int eUK = 0;
    private boolean eUP = false;
    private final View.OnClickListener eUQ = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eUL != null) {
                if (a.this.eUN == null || !a.this.eUN.eUY || a.this.eUN.aNY() != view) {
                    if (u.C((Activity) view.getContext())) {
                        a.this.eUO.aOe();
                        int i = a.this.eUL.aKE;
                        if (i == 0 || i == 3) {
                            if (!j.oJ() || j.oK()) {
                                String str = a.this.eUL.aKG;
                                if (StringUtils.isNull(str)) {
                                    str = a.this.aRR.getString(d.j.app_name);
                                }
                                a.this.eUO.aOg();
                                if (s.a(a.this.aRR.getPageActivity(), a.this.eUL, 0, str)) {
                                    a.this.eUO.oc(a.this.eUL.aKK);
                                    return;
                                }
                                return;
                            }
                            a.this.c(a.this.eUL);
                            return;
                        } else if (i == 1) {
                            s.e(a.this.eUL);
                            a.this.eUL.aKE = 3;
                            a.this.aNT();
                            return;
                        } else if (i == 2) {
                            if (com.baidu.tieba.recapp.download.d.bol().ge(a.this.eUL.aKK)) {
                                u.ao(a.this.aRR.getPageActivity(), a.this.eUL.aKK);
                                return;
                            }
                            a.this.eUL.aKE = 0;
                            a.this.aNT();
                            return;
                        } else {
                            return;
                        }
                    }
                    l.showToast((Activity) view.getContext(), d.j.write_external_storage_permission_denied_fun_disable);
                }
            }
        }
    };
    private final View.OnClickListener eUR = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eUL != null) {
                if (a.this.eUN == null || !a.this.eUN.eUY || a.this.eUN.aNY() != view) {
                    a.this.eUO.aOe();
                    r.bof().boc().a(a.this.aRR.getPageActivity(), new String[]{a.this.eUL.aKI}, true);
                }
            }
        }
    };
    private final CustomMessageListener eUS = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.bmF = false;
        this.eUM = false;
        this.bmF = z;
        this.eUM = z2;
        this.aRR = tbPageContext;
        this.aRR.registerListener(2001118, this.eUS);
        this.eUO = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.eUL = advertAppInfo;
        this.eUK = i;
        this.eUO.d(this.eUL);
    }

    public boolean aNS() {
        if (!this.eUM || this.eUL == null) {
            return false;
        }
        return (this.eUL.xL() || this.eUL.xK()) && !u.isInstalledPackage(this.aRR.getPageActivity(), this.eUL.aKK);
    }

    @Override // com.baidu.tbadk.coreExtra.view.c.a
    public View g(ViewGroup viewGroup, int i) {
        if (qP(i)) {
            this.eUN = new b(viewGroup);
            aNT();
            viewGroup.addView(this.eUN.getView());
            return this.eUN.getView();
        }
        return null;
    }

    private boolean qP(int i) {
        return aNS() && this.eUK != 0 && i == this.eUK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNT() {
        if (this.eUL != null && this.eUL.aKR != null) {
            aNU();
            if (this.eUL.xL()) {
                this.eUN.aNZ().setVisibility(8);
                this.eUN.n(this.eUR);
            } else if (this.eUL.xK()) {
                this.eUN.aNZ().setVisibility(0);
                this.eUN.n(this.eUQ);
                aNV();
            }
            s.a(this.eUL.aKR.aLj, this.eUN.eUV, this.eUL.aKR.tagRatio, l.t(this.aRR.getPageActivity(), d.e.ds26));
            if (!TextUtils.isEmpty(this.eUL.aKR.adSource)) {
                this.eUN.eUX.setText(this.eUL.aKR.adSource);
                this.eUN.eUW.setVisibility(0);
                return;
            }
            this.eUN.eUW.setVisibility(8);
        }
    }

    private void aNU() {
        this.eUN.aNY().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void q(String str, boolean z) {
                if (z) {
                    a.this.eUN.aOc();
                }
                a.this.eUN.aOd();
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                a.this.eUN.aOd();
            }
        });
        this.eUN.aNY().startLoad(this.eUL.aKR.aLb, this.bmF ? 30 : 31, 720, 720, false);
    }

    private void aNV() {
        if (this.eUL != null) {
            String str = this.eUL.aKG;
            if (StringUtils.isNull(str)) {
                str = this.aRR.getString(d.j.app_name);
            }
            if (com.baidu.tieba.recapp.download.d.bol().ge(this.eUL.aKK)) {
                this.eUL.aKE = 2;
            } else if (com.baidu.tieba.recapp.download.d.bol().an(this.eUL.aKK, str)) {
                if (com.baidu.tieba.recapp.download.d.bol().gc(this.eUL.aKK)) {
                    this.eUL.aKE = 1;
                } else {
                    this.eUL.aKE = 3;
                }
            }
            switch (this.eUL.aKE) {
                case 0:
                    String string = this.aRR.getString(d.j.install_app);
                    if (this.eUL.aKR != null && !StringUtils.isNull(this.eUL.aKR.buttonText)) {
                        string = this.eUL.aKR.buttonText;
                    }
                    if (string.length() > eUJ) {
                        string = string.substring(0, eUJ);
                    }
                    this.eUN.ob(string);
                    return;
                case 1:
                    this.eUN.aOa();
                    return;
                case 2:
                    this.eUN.aOb();
                    return;
                case 3:
                    this.eUN.ob(this.aRR.getString(d.j.pb_download_pause));
                    return;
                default:
                    this.eUN.aNZ().setVisibility(8);
                    this.eUN.n(null);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdvertAppInfo advertAppInfo) {
        String string;
        if (advertAppInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRR.getPageActivity());
            if (j.oL()) {
                string = this.aRR.getString(d.j.frs_network_tips);
            } else {
                string = this.aRR.getString(d.j.confirm_download_app);
            }
            aVar.dk(string);
            aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.eUL.aKG;
                    if (StringUtils.isNull(str)) {
                        str = a.this.aRR.getString(d.j.app_name);
                    }
                    a.this.eUO.aOg();
                    if (s.a(a.this.aRR.getPageActivity(), a.this.eUL, 0, str)) {
                        a.this.eUO.oc(a.this.eUL.aKK);
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.image.a.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.aRR).AU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.eUL != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.eUL.aKK, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.eUL.aKE = 2;
                    } else if (status == 2 || status == 4) {
                        if (!am.isEmpty(downloadData.getStatusMsg())) {
                            this.aRR.showToast(downloadData.getStatusMsg());
                        }
                        this.eUL.aKE = 0;
                    } else if (status == 1) {
                        this.eUL.aKE = 1;
                    }
                    aNT();
                }
            }
        }
    }

    public void aNW() {
        if (!this.eUP) {
            this.eUP = true;
            this.eUO.aOf();
        }
    }
}
