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
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.u;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements ImagePagerAdapter.a {
    private static int eBN = 7;
    private boolean aGD;
    private AdvertAppInfo eBP;
    private boolean eBQ;
    private b eBR;
    private c eBS;
    private TbPageContext<?> mContext;
    private int eBO = 0;
    private boolean eBT = false;
    private final View.OnClickListener eBU = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eBP != null) {
                if (a.this.eBR == null || !a.this.eBR.eCc || a.this.eBR.aNU() != view) {
                    if (u.F((Activity) view.getContext())) {
                        a.this.eBS.aOa();
                        int i = a.this.eBP.adK;
                        if (i == 0 || i == 3) {
                            if (!j.jD() || j.jE()) {
                                String str = a.this.eBP.adM;
                                if (StringUtils.isNull(str)) {
                                    str = a.this.mContext.getString(d.k.app_name);
                                }
                                a.this.eBS.aOc();
                                if (s.a(a.this.mContext.getPageActivity(), a.this.eBP, 0, str)) {
                                    a.this.eBS.oX(a.this.eBP.adQ);
                                    return;
                                }
                                return;
                            }
                            a.this.c(a.this.eBP);
                            return;
                        } else if (i == 1) {
                            s.f(a.this.eBP);
                            a.this.eBP.adK = 3;
                            a.this.aNP();
                            return;
                        } else if (i == 2) {
                            if (com.baidu.tieba.recapp.download.d.bop().gu(a.this.eBP.adQ)) {
                                u.al(a.this.mContext.getPageActivity(), a.this.eBP.adQ);
                                return;
                            }
                            a.this.eBP.adK = 0;
                            a.this.aNP();
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
    private final View.OnClickListener eBV = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eBP != null) {
                if (a.this.eBR == null || !a.this.eBR.eCc || a.this.eBR.aNU() != view) {
                    a.this.eBS.aOa();
                    r.boj().bog().a(a.this.mContext.getPageActivity(), new String[]{a.this.eBP.adO}, true);
                }
            }
        }
    };
    private final CustomMessageListener eBW = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.aGD = false;
        this.eBQ = false;
        this.aGD = z;
        this.eBQ = z2;
        this.mContext = tbPageContext;
        this.mContext.registerListener(2001118, this.eBW);
        this.eBS = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.eBP = advertAppInfo;
        this.eBO = i;
        this.eBS.d(this.eBP);
    }

    public boolean aNO() {
        if (!this.eBQ || this.eBP == null) {
            return false;
        }
        return (this.eBP.tP() || this.eBP.tO()) && !u.isInstalledPackage(this.mContext.getPageActivity(), this.eBP.adQ);
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View g(ViewGroup viewGroup, int i) {
        if (ow(i)) {
            this.eBR = new b(viewGroup);
            aNP();
            viewGroup.addView(this.eBR.getView());
            return this.eBR.getView();
        }
        return null;
    }

    private boolean ow(int i) {
        return aNO() && this.eBO != 0 && i == this.eBO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNP() {
        if (this.eBP != null && this.eBP.adX != null) {
            aNQ();
            if (this.eBP.tP()) {
                this.eBR.aNV().setVisibility(8);
                this.eBR.p(this.eBV);
            } else if (this.eBP.tO()) {
                this.eBR.aNV().setVisibility(0);
                this.eBR.p(this.eBU);
                aNR();
            }
            s.a(this.eBP.adX.aeq, this.eBR.eBZ, this.eBP.adX.tagRatio, l.e(this.mContext.getPageActivity(), d.e.ds26));
            if (!TextUtils.isEmpty(this.eBP.adX.adSource)) {
                this.eBR.eCb.setText(this.eBP.adX.adSource);
                this.eBR.eCa.setVisibility(0);
                return;
            }
            this.eBR.eCa.setVisibility(8);
        }
    }

    private void aNQ() {
        this.eBR.aNU().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z) {
                    a.this.eBR.aNY();
                }
                a.this.eBR.aNZ();
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                a.this.eBR.aNZ();
            }
        });
        this.eBR.aNU().startLoad(this.eBP.adX.aei, this.aGD ? 30 : 31, 720, 720, false);
    }

    private void aNR() {
        if (this.eBP != null) {
            String str = this.eBP.adM;
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(d.k.app_name);
            }
            if (com.baidu.tieba.recapp.download.d.bop().gu(this.eBP.adQ)) {
                this.eBP.adK = 2;
            } else if (com.baidu.tieba.recapp.download.d.bop().as(this.eBP.adQ, str)) {
                if (com.baidu.tieba.recapp.download.d.bop().gr(this.eBP.adQ)) {
                    this.eBP.adK = 1;
                } else {
                    this.eBP.adK = 3;
                }
            }
            switch (this.eBP.adK) {
                case 0:
                    String string = this.mContext.getString(d.k.install_app);
                    if (this.eBP.adX != null && !StringUtils.isNull(this.eBP.adX.buttonText)) {
                        string = this.eBP.adX.buttonText;
                    }
                    if (string.length() > eBN) {
                        string = string.substring(0, eBN);
                    }
                    this.eBR.oW(string);
                    return;
                case 1:
                    this.eBR.aNW();
                    return;
                case 2:
                    this.eBR.aNX();
                    return;
                case 3:
                    this.eBR.oW(this.mContext.getString(d.k.pb_download_pause));
                    return;
                default:
                    this.eBR.aNV().setVisibility(8);
                    this.eBR.p(null);
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
            aVar.dB(string);
            aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.eBP.adM;
                    if (StringUtils.isNull(str)) {
                        str = a.this.mContext.getString(d.k.app_name);
                    }
                    a.this.eBS.aOc();
                    if (s.a(a.this.mContext.getPageActivity(), a.this.eBP, 0, str)) {
                        a.this.eBS.oX(a.this.eBP.adQ);
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
            aVar.b(this.mContext).xa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.eBP != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.eBP.adQ, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.eBP.adK = 2;
                    } else if (status == 2 || status == 4) {
                        if (!ao.isEmpty(downloadData.getStatusMsg())) {
                            this.mContext.showToast(downloadData.getStatusMsg());
                        }
                        this.eBP.adK = 0;
                    } else if (status == 1) {
                        this.eBP.adK = 1;
                    }
                    aNP();
                }
            }
        }
    }

    public void aNS() {
        if (!this.eBT) {
            this.eBT = true;
            this.eBS.aOb();
        }
    }
}
