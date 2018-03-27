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
import com.baidu.tieba.tbadkCore.v;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements c.a {
    private static int eUL = 7;
    private TbPageContext<?> aRI;
    private boolean bmv;
    private AdvertAppInfo eUN;
    private boolean eUO;
    private b eUP;
    private c eUQ;
    private int eUM = 0;
    private boolean eUR = false;
    private final View.OnClickListener eUS = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eUN != null) {
                if (a.this.eUP == null || !a.this.eUP.eVa || a.this.eUP.aNY() != view) {
                    if (v.C((Activity) view.getContext())) {
                        a.this.eUQ.aOe();
                        int i = a.this.eUN.aKu;
                        if (i == 0 || i == 3) {
                            if (!j.oJ() || j.oK()) {
                                String str = a.this.eUN.aKw;
                                if (StringUtils.isNull(str)) {
                                    str = a.this.aRI.getString(d.j.app_name);
                                }
                                a.this.eUQ.aOg();
                                if (s.a(a.this.aRI.getPageActivity(), a.this.eUN, 0, str)) {
                                    a.this.eUQ.oc(a.this.eUN.aKA);
                                    return;
                                }
                                return;
                            }
                            a.this.c(a.this.eUN);
                            return;
                        } else if (i == 1) {
                            s.e(a.this.eUN);
                            a.this.eUN.aKu = 3;
                            a.this.aNT();
                            return;
                        } else if (i == 2) {
                            if (com.baidu.tieba.recapp.download.d.bol().ge(a.this.eUN.aKA)) {
                                v.ao(a.this.aRI.getPageActivity(), a.this.eUN.aKA);
                                return;
                            }
                            a.this.eUN.aKu = 0;
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
    private final View.OnClickListener eUT = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eUN != null) {
                if (a.this.eUP == null || !a.this.eUP.eVa || a.this.eUP.aNY() != view) {
                    a.this.eUQ.aOe();
                    r.bof().boc().a(a.this.aRI.getPageActivity(), new String[]{a.this.eUN.aKy}, true);
                }
            }
        }
    };
    private final CustomMessageListener eUU = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.bmv = false;
        this.eUO = false;
        this.bmv = z;
        this.eUO = z2;
        this.aRI = tbPageContext;
        this.aRI.registerListener(2001118, this.eUU);
        this.eUQ = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.eUN = advertAppInfo;
        this.eUM = i;
        this.eUQ.d(this.eUN);
    }

    public boolean aNS() {
        if (!this.eUO || this.eUN == null) {
            return false;
        }
        return (this.eUN.xL() || this.eUN.xK()) && !v.isInstalledPackage(this.aRI.getPageActivity(), this.eUN.aKA);
    }

    @Override // com.baidu.tbadk.coreExtra.view.c.a
    public View g(ViewGroup viewGroup, int i) {
        if (qQ(i)) {
            this.eUP = new b(viewGroup);
            aNT();
            viewGroup.addView(this.eUP.getView());
            return this.eUP.getView();
        }
        return null;
    }

    private boolean qQ(int i) {
        return aNS() && this.eUM != 0 && i == this.eUM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNT() {
        if (this.eUN != null && this.eUN.aKH != null) {
            aNU();
            if (this.eUN.xL()) {
                this.eUP.aNZ().setVisibility(8);
                this.eUP.n(this.eUT);
            } else if (this.eUN.xK()) {
                this.eUP.aNZ().setVisibility(0);
                this.eUP.n(this.eUS);
                aNV();
            }
            s.a(this.eUN.aKH.aKZ, this.eUP.eUX, this.eUN.aKH.tagRatio, l.t(this.aRI.getPageActivity(), d.e.ds26));
            if (!TextUtils.isEmpty(this.eUN.aKH.adSource)) {
                this.eUP.eUZ.setText(this.eUN.aKH.adSource);
                this.eUP.eUY.setVisibility(0);
                return;
            }
            this.eUP.eUY.setVisibility(8);
        }
    }

    private void aNU() {
        this.eUP.aNY().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void p(String str, boolean z) {
                if (z) {
                    a.this.eUP.aOc();
                }
                a.this.eUP.aOd();
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                a.this.eUP.aOd();
            }
        });
        this.eUP.aNY().startLoad(this.eUN.aKH.aKR, this.bmv ? 30 : 31, 720, 720, false);
    }

    private void aNV() {
        if (this.eUN != null) {
            String str = this.eUN.aKw;
            if (StringUtils.isNull(str)) {
                str = this.aRI.getString(d.j.app_name);
            }
            if (com.baidu.tieba.recapp.download.d.bol().ge(this.eUN.aKA)) {
                this.eUN.aKu = 2;
            } else if (com.baidu.tieba.recapp.download.d.bol().an(this.eUN.aKA, str)) {
                if (com.baidu.tieba.recapp.download.d.bol().gc(this.eUN.aKA)) {
                    this.eUN.aKu = 1;
                } else {
                    this.eUN.aKu = 3;
                }
            }
            switch (this.eUN.aKu) {
                case 0:
                    String string = this.aRI.getString(d.j.install_app);
                    if (this.eUN.aKH != null && !StringUtils.isNull(this.eUN.aKH.buttonText)) {
                        string = this.eUN.aKH.buttonText;
                    }
                    if (string.length() > eUL) {
                        string = string.substring(0, eUL);
                    }
                    this.eUP.ob(string);
                    return;
                case 1:
                    this.eUP.aOa();
                    return;
                case 2:
                    this.eUP.aOb();
                    return;
                case 3:
                    this.eUP.ob(this.aRI.getString(d.j.pb_download_pause));
                    return;
                default:
                    this.eUP.aNZ().setVisibility(8);
                    this.eUP.n(null);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdvertAppInfo advertAppInfo) {
        String string;
        if (advertAppInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRI.getPageActivity());
            if (j.oL()) {
                string = this.aRI.getString(d.j.frs_network_tips);
            } else {
                string = this.aRI.getString(d.j.confirm_download_app);
            }
            aVar.dk(string);
            aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.eUN.aKw;
                    if (StringUtils.isNull(str)) {
                        str = a.this.aRI.getString(d.j.app_name);
                    }
                    a.this.eUQ.aOg();
                    if (s.a(a.this.aRI.getPageActivity(), a.this.eUN, 0, str)) {
                        a.this.eUQ.oc(a.this.eUN.aKA);
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
            aVar.b(this.aRI).AV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.eUN != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.eUN.aKA, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.eUN.aKu = 2;
                    } else if (status == 2 || status == 4) {
                        if (!am.isEmpty(downloadData.getStatusMsg())) {
                            this.aRI.showToast(downloadData.getStatusMsg());
                        }
                        this.eUN.aKu = 0;
                    } else if (status == 1) {
                        this.eUN.aKu = 1;
                    }
                    aNT();
                }
            }
        }
    }

    public void aNW() {
        if (!this.eUR) {
            this.eUR = true;
            this.eUQ.aOf();
        }
    }
}
