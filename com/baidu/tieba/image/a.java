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
    private static int eFD = 7;
    private boolean aHv;
    private AdvertAppInfo eFF;
    private boolean eFG;
    private b eFH;
    private c eFI;
    private TbPageContext<?> mContext;
    private int eFE = 0;
    private boolean eFJ = false;
    private final View.OnClickListener eFK = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eFF != null) {
                if (a.this.eFH == null || !a.this.eFH.eFS || a.this.eFH.aOA() != view) {
                    if (u.F((Activity) view.getContext())) {
                        a.this.eFI.aOG();
                        int i = a.this.eFF.adZ;
                        if (i == 0 || i == 3) {
                            if (!j.jD() || j.jE()) {
                                String str = a.this.eFF.aeb;
                                if (StringUtils.isNull(str)) {
                                    str = a.this.mContext.getString(d.k.app_name);
                                }
                                a.this.eFI.aOI();
                                if (s.a(a.this.mContext.getPageActivity(), a.this.eFF, 0, str)) {
                                    a.this.eFI.oY(a.this.eFF.aef);
                                    return;
                                }
                                return;
                            }
                            a.this.c(a.this.eFF);
                            return;
                        } else if (i == 1) {
                            s.f(a.this.eFF);
                            a.this.eFF.adZ = 3;
                            a.this.aOv();
                            return;
                        } else if (i == 2) {
                            if (com.baidu.tieba.recapp.download.d.boQ().gy(a.this.eFF.aef)) {
                                u.al(a.this.mContext.getPageActivity(), a.this.eFF.aef);
                                return;
                            }
                            a.this.eFF.adZ = 0;
                            a.this.aOv();
                            return;
                        } else {
                            return;
                        }
                    }
                    l.showToast((Activity) view.getContext(), d.k.write_external_storage_permission_denied_fun_disable);
                }
            }
        }
    };
    private final View.OnClickListener eFL = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eFF != null) {
                if (a.this.eFH == null || !a.this.eFH.eFS || a.this.eFH.aOA() != view) {
                    a.this.eFI.aOG();
                    r.boJ().boG().a(a.this.mContext.getPageActivity(), new String[]{a.this.eFF.aed}, true);
                }
            }
        }
    };
    private final CustomMessageListener eFM = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.eFG = false;
        this.aHv = z;
        this.eFG = z2;
        this.mContext = tbPageContext;
        this.mContext.registerListener(2001118, this.eFM);
        this.eFI = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.eFF = advertAppInfo;
        this.eFE = i;
        this.eFI.d(this.eFF);
    }

    public boolean aOu() {
        if (!this.eFG || this.eFF == null) {
            return false;
        }
        return (this.eFF.tV() || this.eFF.tU()) && !u.isInstalledPackage(this.mContext.getPageActivity(), this.eFF.aef);
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View g(ViewGroup viewGroup, int i) {
        if (oD(i)) {
            this.eFH = new b(viewGroup);
            aOv();
            viewGroup.addView(this.eFH.getView());
            return this.eFH.getView();
        }
        return null;
    }

    private boolean oD(int i) {
        return aOu() && this.eFE != 0 && i == this.eFE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOv() {
        if (this.eFF != null && this.eFF.aem != null) {
            aOw();
            if (this.eFF.tV()) {
                this.eFH.aOB().setVisibility(8);
                this.eFH.s(this.eFL);
            } else if (this.eFF.tU()) {
                this.eFH.aOB().setVisibility(0);
                this.eFH.s(this.eFK);
                aOx();
            }
            s.a(this.eFF.aem.aeF, this.eFH.eFP, this.eFF.aem.tagRatio, l.e(this.mContext.getPageActivity(), d.e.ds26));
            if (!TextUtils.isEmpty(this.eFF.aem.adSource)) {
                this.eFH.eFR.setText(this.eFF.aem.adSource);
                this.eFH.eFQ.setVisibility(0);
                return;
            }
            this.eFH.eFQ.setVisibility(8);
        }
    }

    private void aOw() {
        this.eFH.aOA().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z) {
                    a.this.eFH.aOE();
                }
                a.this.eFH.aOF();
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                a.this.eFH.aOF();
            }
        });
        this.eFH.aOA().startLoad(this.eFF.aem.aex, this.aHv ? 30 : 31, 720, 720, false);
    }

    private void aOx() {
        if (this.eFF != null) {
            String str = this.eFF.aeb;
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(d.k.app_name);
            }
            if (com.baidu.tieba.recapp.download.d.boQ().gy(this.eFF.aef)) {
                this.eFF.adZ = 2;
            } else if (com.baidu.tieba.recapp.download.d.boQ().as(this.eFF.aef, str)) {
                if (com.baidu.tieba.recapp.download.d.boQ().gw(this.eFF.aef)) {
                    this.eFF.adZ = 1;
                } else {
                    this.eFF.adZ = 3;
                }
            }
            switch (this.eFF.adZ) {
                case 0:
                    String string = this.mContext.getString(d.k.install_app);
                    if (this.eFF.aem != null && !StringUtils.isNull(this.eFF.aem.buttonText)) {
                        string = this.eFF.aem.buttonText;
                    }
                    if (string.length() > eFD) {
                        string = string.substring(0, eFD);
                    }
                    this.eFH.oX(string);
                    return;
                case 1:
                    this.eFH.aOC();
                    return;
                case 2:
                    this.eFH.aOD();
                    return;
                case 3:
                    this.eFH.oX(this.mContext.getString(d.k.pb_download_pause));
                    return;
                default:
                    this.eFH.aOB().setVisibility(8);
                    this.eFH.s(null);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdvertAppInfo advertAppInfo) {
        String string;
        if (advertAppInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            if (j.jF()) {
                string = this.mContext.getString(d.k.frs_network_tips);
            } else {
                string = this.mContext.getString(d.k.confirm_download_app);
            }
            aVar.dE(string);
            aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.eFF.aeb;
                    if (StringUtils.isNull(str)) {
                        str = a.this.mContext.getString(d.k.app_name);
                    }
                    a.this.eFI.aOI();
                    if (s.a(a.this.mContext.getPageActivity(), a.this.eFF, 0, str)) {
                        a.this.eFI.oY(a.this.eFF.aef);
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.image.a.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.mContext).xn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.eFF != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.eFF.aef, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.eFF.adZ = 2;
                    } else if (status == 2 || status == 4) {
                        if (!ap.isEmpty(downloadData.getStatusMsg())) {
                            this.mContext.showToast(downloadData.getStatusMsg());
                        }
                        this.eFF.adZ = 0;
                    } else if (status == 1) {
                        this.eFF.adZ = 1;
                    }
                    aOv();
                }
            }
        }
    }

    public void aOy() {
        if (!this.eFJ) {
            this.eFJ = true;
            this.eFI.aOH();
        }
    }
}
