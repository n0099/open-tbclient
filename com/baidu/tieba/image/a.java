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
    private static int eUx = 7;
    private TbPageContext<?> aRG;
    private boolean bms;
    private boolean eUA;
    private b eUB;
    private c eUC;
    private AdvertAppInfo eUz;
    private int eUy = 0;
    private boolean eUD = false;
    private final View.OnClickListener eUE = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eUz != null) {
                if (a.this.eUB == null || !a.this.eUB.eUM || a.this.eUB.aNX() != view) {
                    if (u.C((Activity) view.getContext())) {
                        a.this.eUC.aOd();
                        int i = a.this.eUz.aKt;
                        if (i == 0 || i == 3) {
                            if (!j.oJ() || j.oK()) {
                                String str = a.this.eUz.aKv;
                                if (StringUtils.isNull(str)) {
                                    str = a.this.aRG.getString(d.j.app_name);
                                }
                                a.this.eUC.aOf();
                                if (s.a(a.this.aRG.getPageActivity(), a.this.eUz, 0, str)) {
                                    a.this.eUC.oc(a.this.eUz.aKz);
                                    return;
                                }
                                return;
                            }
                            a.this.c(a.this.eUz);
                            return;
                        } else if (i == 1) {
                            s.e(a.this.eUz);
                            a.this.eUz.aKt = 3;
                            a.this.aNS();
                            return;
                        } else if (i == 2) {
                            if (com.baidu.tieba.recapp.download.d.bok().ge(a.this.eUz.aKz)) {
                                u.ao(a.this.aRG.getPageActivity(), a.this.eUz.aKz);
                                return;
                            }
                            a.this.eUz.aKt = 0;
                            a.this.aNS();
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
    private final View.OnClickListener eUF = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eUz != null) {
                if (a.this.eUB == null || !a.this.eUB.eUM || a.this.eUB.aNX() != view) {
                    a.this.eUC.aOd();
                    r.boe().bob().a(a.this.aRG.getPageActivity(), new String[]{a.this.eUz.aKx}, true);
                }
            }
        }
    };
    private final CustomMessageListener eUG = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.bms = false;
        this.eUA = false;
        this.bms = z;
        this.eUA = z2;
        this.aRG = tbPageContext;
        this.aRG.registerListener(2001118, this.eUG);
        this.eUC = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.eUz = advertAppInfo;
        this.eUy = i;
        this.eUC.d(this.eUz);
    }

    public boolean aNR() {
        if (!this.eUA || this.eUz == null) {
            return false;
        }
        return (this.eUz.xL() || this.eUz.xK()) && !u.isInstalledPackage(this.aRG.getPageActivity(), this.eUz.aKz);
    }

    @Override // com.baidu.tbadk.coreExtra.view.c.a
    public View g(ViewGroup viewGroup, int i) {
        if (qQ(i)) {
            this.eUB = new b(viewGroup);
            aNS();
            viewGroup.addView(this.eUB.getView());
            return this.eUB.getView();
        }
        return null;
    }

    private boolean qQ(int i) {
        return aNR() && this.eUy != 0 && i == this.eUy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNS() {
        if (this.eUz != null && this.eUz.aKG != null) {
            aNT();
            if (this.eUz.xL()) {
                this.eUB.aNY().setVisibility(8);
                this.eUB.n(this.eUF);
            } else if (this.eUz.xK()) {
                this.eUB.aNY().setVisibility(0);
                this.eUB.n(this.eUE);
                aNU();
            }
            s.a(this.eUz.aKG.aKY, this.eUB.eUJ, this.eUz.aKG.tagRatio, l.t(this.aRG.getPageActivity(), d.e.ds26));
            if (!TextUtils.isEmpty(this.eUz.aKG.adSource)) {
                this.eUB.eUL.setText(this.eUz.aKG.adSource);
                this.eUB.eUK.setVisibility(0);
                return;
            }
            this.eUB.eUK.setVisibility(8);
        }
    }

    private void aNT() {
        this.eUB.aNX().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void p(String str, boolean z) {
                if (z) {
                    a.this.eUB.aOb();
                }
                a.this.eUB.aOc();
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                a.this.eUB.aOc();
            }
        });
        this.eUB.aNX().startLoad(this.eUz.aKG.aKQ, this.bms ? 30 : 31, 720, 720, false);
    }

    private void aNU() {
        if (this.eUz != null) {
            String str = this.eUz.aKv;
            if (StringUtils.isNull(str)) {
                str = this.aRG.getString(d.j.app_name);
            }
            if (com.baidu.tieba.recapp.download.d.bok().ge(this.eUz.aKz)) {
                this.eUz.aKt = 2;
            } else if (com.baidu.tieba.recapp.download.d.bok().an(this.eUz.aKz, str)) {
                if (com.baidu.tieba.recapp.download.d.bok().gc(this.eUz.aKz)) {
                    this.eUz.aKt = 1;
                } else {
                    this.eUz.aKt = 3;
                }
            }
            switch (this.eUz.aKt) {
                case 0:
                    String string = this.aRG.getString(d.j.install_app);
                    if (this.eUz.aKG != null && !StringUtils.isNull(this.eUz.aKG.buttonText)) {
                        string = this.eUz.aKG.buttonText;
                    }
                    if (string.length() > eUx) {
                        string = string.substring(0, eUx);
                    }
                    this.eUB.ob(string);
                    return;
                case 1:
                    this.eUB.aNZ();
                    return;
                case 2:
                    this.eUB.aOa();
                    return;
                case 3:
                    this.eUB.ob(this.aRG.getString(d.j.pb_download_pause));
                    return;
                default:
                    this.eUB.aNY().setVisibility(8);
                    this.eUB.n(null);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdvertAppInfo advertAppInfo) {
        String string;
        if (advertAppInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRG.getPageActivity());
            if (j.oL()) {
                string = this.aRG.getString(d.j.frs_network_tips);
            } else {
                string = this.aRG.getString(d.j.confirm_download_app);
            }
            aVar.dk(string);
            aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.eUz.aKv;
                    if (StringUtils.isNull(str)) {
                        str = a.this.aRG.getString(d.j.app_name);
                    }
                    a.this.eUC.aOf();
                    if (s.a(a.this.aRG.getPageActivity(), a.this.eUz, 0, str)) {
                        a.this.eUC.oc(a.this.eUz.aKz);
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
            aVar.b(this.aRG).AU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.eUz != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.eUz.aKz, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.eUz.aKt = 2;
                    } else if (status == 2 || status == 4) {
                        if (!am.isEmpty(downloadData.getStatusMsg())) {
                            this.aRG.showToast(downloadData.getStatusMsg());
                        }
                        this.eUz.aKt = 0;
                    } else if (status == 1) {
                        this.eUz.aKt = 1;
                    }
                    aNS();
                }
            }
        }
    }

    public void aNV() {
        if (!this.eUD) {
            this.eUD = true;
            this.eUC.aOe();
        }
    }
}
