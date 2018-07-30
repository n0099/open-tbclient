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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.u;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements ImagePagerAdapter.a {
    private static int eJx = 7;
    private boolean aHv;
    private boolean eJA;
    private b eJB;
    private c eJC;
    private AdvertAppInfo eJz;
    private TbPageContext<?> mContext;
    private int eJy = 0;
    private boolean eJD = false;
    private final View.OnClickListener eJE = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eJz != null) {
                if (a.this.eJB == null || !a.this.eJB.eJM || a.this.eJB.aPA() != view) {
                    if (u.G((Activity) view.getContext())) {
                        a.this.eJC.aPG();
                        int i = a.this.eJz.adD;
                        if (i == 0 || i == 3) {
                            if (!j.jE() || j.jF()) {
                                String str = a.this.eJz.adF;
                                if (StringUtils.isNull(str)) {
                                    str = a.this.mContext.getString(d.j.app_name);
                                }
                                a.this.eJC.aPI();
                                if (s.a(a.this.mContext.getPageActivity(), a.this.eJz, 0, str)) {
                                    a.this.eJC.pa(a.this.eJz.adJ);
                                    return;
                                }
                                return;
                            }
                            a.this.c(a.this.eJz);
                            return;
                        } else if (i == 1) {
                            s.f(a.this.eJz);
                            a.this.eJz.adD = 3;
                            a.this.aPv();
                            return;
                        } else if (i == 2) {
                            if (com.baidu.tieba.recapp.download.d.bnu().gw(a.this.eJz.adJ)) {
                                u.an(a.this.mContext.getPageActivity(), a.this.eJz.adJ);
                                return;
                            }
                            a.this.eJz.adD = 0;
                            a.this.aPv();
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
    private final View.OnClickListener eJF = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eJz != null) {
                if (a.this.eJB == null || !a.this.eJB.eJM || a.this.eJB.aPA() != view) {
                    a.this.eJC.aPG();
                    r.bnn().bnk().a(a.this.mContext.getPageActivity(), new String[]{a.this.eJz.adH}, true);
                }
            }
        }
    };
    private final CustomMessageListener eJG = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.aHv = false;
        this.eJA = false;
        this.aHv = z;
        this.eJA = z2;
        this.mContext = tbPageContext;
        this.mContext.registerListener(2001118, this.eJG);
        this.eJC = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.eJz = advertAppInfo;
        this.eJy = i;
        this.eJC.d(this.eJz);
    }

    public boolean aPu() {
        if (!this.eJA || this.eJz == null) {
            return false;
        }
        return (this.eJz.tH() || this.eJz.tG()) && !u.isInstalledPackage(this.mContext.getPageActivity(), this.eJz.adJ);
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View f(ViewGroup viewGroup, int i) {
        if (oS(i)) {
            this.eJB = new b(viewGroup);
            aPv();
            viewGroup.addView(this.eJB.getView());
            return this.eJB.getView();
        }
        return null;
    }

    private boolean oS(int i) {
        return aPu() && this.eJy != 0 && i == this.eJy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPv() {
        if (this.eJz != null && this.eJz.adQ != null) {
            aPw();
            if (this.eJz.tH()) {
                this.eJB.aPB().setVisibility(8);
                this.eJB.t(this.eJF);
            } else if (this.eJz.tG()) {
                this.eJB.aPB().setVisibility(0);
                this.eJB.t(this.eJE);
                aPx();
            }
            s.a(this.eJz.adQ.aej, this.eJB.eJJ, this.eJz.adQ.tagRatio, l.f(this.mContext.getPageActivity(), d.e.ds26));
            if (!TextUtils.isEmpty(this.eJz.adQ.adSource)) {
                this.eJB.eJL.setText(this.eJz.adQ.adSource);
                this.eJB.eJK.setVisibility(0);
                return;
            }
            this.eJB.eJK.setVisibility(8);
        }
    }

    private void aPw() {
        this.eJB.aPA().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void m(String str, boolean z) {
                if (z) {
                    a.this.eJB.aPE();
                }
                a.this.eJB.aPF();
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                a.this.eJB.aPF();
            }
        });
        this.eJB.aPA().startLoad(this.eJz.adQ.aeb, this.aHv ? 30 : 31, 720, 720, false);
    }

    private void aPx() {
        if (this.eJz != null) {
            String str = this.eJz.adF;
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(d.j.app_name);
            }
            if (com.baidu.tieba.recapp.download.d.bnu().gw(this.eJz.adJ)) {
                this.eJz.adD = 2;
            } else if (com.baidu.tieba.recapp.download.d.bnu().bY(this.eJz.adJ, str)) {
                if (com.baidu.tieba.recapp.download.d.bnu().gu(this.eJz.adJ)) {
                    this.eJz.adD = 1;
                } else {
                    this.eJz.adD = 3;
                }
            }
            switch (this.eJz.adD) {
                case 0:
                    String string = this.mContext.getString(d.j.install_app);
                    if (this.eJz.adQ != null && !StringUtils.isNull(this.eJz.adQ.buttonText)) {
                        string = this.eJz.adQ.buttonText;
                    }
                    if (string.length() > eJx) {
                        string = string.substring(0, eJx);
                    }
                    this.eJB.oZ(string);
                    return;
                case 1:
                    this.eJB.aPC();
                    return;
                case 2:
                    this.eJB.aPD();
                    return;
                case 3:
                    this.eJB.oZ(this.mContext.getString(d.j.pb_download_pause));
                    return;
                default:
                    this.eJB.aPB().setVisibility(8);
                    this.eJB.t(null);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdvertAppInfo advertAppInfo) {
        String string;
        if (advertAppInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            if (j.jG()) {
                string = this.mContext.getString(d.j.frs_network_tips);
            } else {
                string = this.mContext.getString(d.j.confirm_download_app);
            }
            aVar.dB(string);
            aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.eJz.adF;
                    if (StringUtils.isNull(str)) {
                        str = a.this.mContext.getString(d.j.app_name);
                    }
                    a.this.eJC.aPI();
                    if (s.a(a.this.mContext.getPageActivity(), a.this.eJz, 0, str)) {
                        a.this.eJC.pa(a.this.eJz.adJ);
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
            aVar.b(this.mContext).xf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.eJz != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.eJz.adJ, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.eJz.adD = 2;
                    } else if (status == 2 || status == 4) {
                        if (!ap.isEmpty(downloadData.getStatusMsg())) {
                            this.mContext.showToast(downloadData.getStatusMsg());
                        }
                        this.eJz.adD = 0;
                    } else if (status == 1) {
                        this.eJz.adD = 1;
                    }
                    aPv();
                }
            }
        }
    }

    public void aPy() {
        if (!this.eJD) {
            this.eJD = true;
            this.eJC.aPH();
        }
    }
}
