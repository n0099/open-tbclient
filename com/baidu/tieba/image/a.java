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
import com.baidu.tieba.f;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.u;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements ImagePagerAdapter.a {
    private static int eJs = 7;
    private boolean aHu;
    private AdvertAppInfo eJu;
    private boolean eJv;
    private b eJw;
    private c eJx;
    private TbPageContext<?> mContext;
    private int eJt = 0;
    private boolean eJy = false;
    private final View.OnClickListener eJz = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eJu != null) {
                if (a.this.eJw == null || !a.this.eJw.eJH || a.this.eJw.aPx() != view) {
                    if (u.G((Activity) view.getContext())) {
                        a.this.eJx.aPD();
                        int i = a.this.eJu.adD;
                        if (i == 0 || i == 3) {
                            if (!j.jE() || j.jF()) {
                                String str = a.this.eJu.adF;
                                if (StringUtils.isNull(str)) {
                                    str = a.this.mContext.getString(f.j.app_name);
                                }
                                a.this.eJx.aPF();
                                if (s.a(a.this.mContext.getPageActivity(), a.this.eJu, 0, str)) {
                                    a.this.eJx.pc(a.this.eJu.adJ);
                                    return;
                                }
                                return;
                            }
                            a.this.c(a.this.eJu);
                            return;
                        } else if (i == 1) {
                            s.f(a.this.eJu);
                            a.this.eJu.adD = 3;
                            a.this.aPs();
                            return;
                        } else if (i == 2) {
                            if (com.baidu.tieba.recapp.download.d.bnv().gw(a.this.eJu.adJ)) {
                                u.an(a.this.mContext.getPageActivity(), a.this.eJu.adJ);
                                return;
                            }
                            a.this.eJu.adD = 0;
                            a.this.aPs();
                            return;
                        } else {
                            return;
                        }
                    }
                    l.showToast((Activity) view.getContext(), f.j.write_external_storage_permission_denied_fun_disable);
                }
            }
        }
    };
    private final View.OnClickListener eJA = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eJu != null) {
                if (a.this.eJw == null || !a.this.eJw.eJH || a.this.eJw.aPx() != view) {
                    a.this.eJx.aPD();
                    r.bno().bnl().a(a.this.mContext.getPageActivity(), new String[]{a.this.eJu.adH}, true);
                }
            }
        }
    };
    private final CustomMessageListener eJB = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.aHu = false;
        this.eJv = false;
        this.aHu = z;
        this.eJv = z2;
        this.mContext = tbPageContext;
        this.mContext.registerListener(2001118, this.eJB);
        this.eJx = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.eJu = advertAppInfo;
        this.eJt = i;
        this.eJx.d(this.eJu);
    }

    public boolean aPr() {
        if (!this.eJv || this.eJu == null) {
            return false;
        }
        return (this.eJu.tG() || this.eJu.tF()) && !u.isInstalledPackage(this.mContext.getPageActivity(), this.eJu.adJ);
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View f(ViewGroup viewGroup, int i) {
        if (oS(i)) {
            this.eJw = new b(viewGroup);
            aPs();
            viewGroup.addView(this.eJw.getView());
            return this.eJw.getView();
        }
        return null;
    }

    private boolean oS(int i) {
        return aPr() && this.eJt != 0 && i == this.eJt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPs() {
        if (this.eJu != null && this.eJu.adQ != null) {
            aPt();
            if (this.eJu.tG()) {
                this.eJw.aPy().setVisibility(8);
                this.eJw.t(this.eJA);
            } else if (this.eJu.tF()) {
                this.eJw.aPy().setVisibility(0);
                this.eJw.t(this.eJz);
                aPu();
            }
            s.a(this.eJu.adQ.aej, this.eJw.eJE, this.eJu.adQ.tagRatio, l.f(this.mContext.getPageActivity(), f.e.ds26));
            if (!TextUtils.isEmpty(this.eJu.adQ.adSource)) {
                this.eJw.eJG.setText(this.eJu.adQ.adSource);
                this.eJw.eJF.setVisibility(0);
                return;
            }
            this.eJw.eJF.setVisibility(8);
        }
    }

    private void aPt() {
        this.eJw.aPx().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void m(String str, boolean z) {
                if (z) {
                    a.this.eJw.aPB();
                }
                a.this.eJw.aPC();
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                a.this.eJw.aPC();
            }
        });
        this.eJw.aPx().startLoad(this.eJu.adQ.aeb, this.aHu ? 30 : 31, 720, 720, false);
    }

    private void aPu() {
        if (this.eJu != null) {
            String str = this.eJu.adF;
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(f.j.app_name);
            }
            if (com.baidu.tieba.recapp.download.d.bnv().gw(this.eJu.adJ)) {
                this.eJu.adD = 2;
            } else if (com.baidu.tieba.recapp.download.d.bnv().bY(this.eJu.adJ, str)) {
                if (com.baidu.tieba.recapp.download.d.bnv().gu(this.eJu.adJ)) {
                    this.eJu.adD = 1;
                } else {
                    this.eJu.adD = 3;
                }
            }
            switch (this.eJu.adD) {
                case 0:
                    String string = this.mContext.getString(f.j.install_app);
                    if (this.eJu.adQ != null && !StringUtils.isNull(this.eJu.adQ.buttonText)) {
                        string = this.eJu.adQ.buttonText;
                    }
                    if (string.length() > eJs) {
                        string = string.substring(0, eJs);
                    }
                    this.eJw.pb(string);
                    return;
                case 1:
                    this.eJw.aPz();
                    return;
                case 2:
                    this.eJw.aPA();
                    return;
                case 3:
                    this.eJw.pb(this.mContext.getString(f.j.pb_download_pause));
                    return;
                default:
                    this.eJw.aPy().setVisibility(8);
                    this.eJw.t(null);
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
                string = this.mContext.getString(f.j.frs_network_tips);
            } else {
                string = this.mContext.getString(f.j.confirm_download_app);
            }
            aVar.dB(string);
            aVar.a(f.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.eJu.adF;
                    if (StringUtils.isNull(str)) {
                        str = a.this.mContext.getString(f.j.app_name);
                    }
                    a.this.eJx.aPF();
                    if (s.a(a.this.mContext.getPageActivity(), a.this.eJu, 0, str)) {
                        a.this.eJx.pc(a.this.eJu.adJ);
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.image.a.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.mContext).xe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.eJu != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.eJu.adJ, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.eJu.adD = 2;
                    } else if (status == 2 || status == 4) {
                        if (!ap.isEmpty(downloadData.getStatusMsg())) {
                            this.mContext.showToast(downloadData.getStatusMsg());
                        }
                        this.eJu.adD = 0;
                    } else if (status == 1) {
                        this.eJu.adD = 1;
                    }
                    aPs();
                }
            }
        }
    }

    public void aPv() {
        if (!this.eJy) {
            this.eJy = true;
            this.eJx.aPE();
        }
    }
}
