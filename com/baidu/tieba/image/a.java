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
    private static int fjq = 7;
    private boolean aTC;
    private AdvertAppInfo fjs;
    private boolean fjt;
    private b fju;
    private c fjv;
    private TbPageContext<?> mContext;
    private int fjr = 0;
    private boolean fjw = false;
    private final View.OnClickListener fjx = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fjs != null) {
                if (a.this.fju == null || !a.this.fju.fjF || a.this.fju.aXa() != view) {
                    if (u.R((Activity) view.getContext())) {
                        a.this.fjv.aXg();
                        com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.fjs));
                        int i = a.this.fjs.apo;
                        if (i == 0 || i == 3) {
                            if (!j.kV() || j.kW()) {
                                String str = a.this.fjs.apr;
                                if (StringUtils.isNull(str)) {
                                    str = a.this.mContext.getString(e.j.app_name);
                                }
                                a.this.fjv.aXi();
                                if (s.a(a.this.mContext.getPageActivity(), a.this.fjs, 0, str)) {
                                    a.this.fjv.qP(a.this.fjs.apv);
                                    return;
                                }
                                return;
                            }
                            a.this.c(a.this.fjs);
                            return;
                        } else if (i == 1) {
                            s.f(a.this.fjs);
                            a.this.fjs.apo = 3;
                            a.this.aWV();
                            return;
                        } else if (i == 2) {
                            if (com.baidu.tieba.recapp.download.d.bvr().hA(a.this.fjs.apv)) {
                                u.aG(a.this.mContext.getPageActivity(), a.this.fjs.apv);
                                return;
                            }
                            a.this.fjs.apo = 0;
                            a.this.aWV();
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
    private final View.OnClickListener fjy = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fjs != null) {
                if (a.this.fju == null || !a.this.fju.fjF || a.this.fju.aXa() != view) {
                    a.this.fjv.aXg();
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.fjs));
                    r.bvk().bvh().a(a.this.mContext.getPageActivity(), new String[]{a.this.fjs.apt}, true);
                }
            }
        }
    };
    private final CustomMessageListener fjz = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.aTC = false;
        this.fjt = false;
        this.aTC = z;
        this.fjt = z2;
        this.mContext = tbPageContext;
        this.mContext.registerListener(2001118, this.fjz);
        this.fjv = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.fjs = advertAppInfo;
        this.fjr = i;
        this.fjv.d(this.fjs);
    }

    public boolean aWU() {
        if (!this.fjt || this.fjs == null) {
            return false;
        }
        return (this.fjs.ye() || this.fjs.yd()) && !u.isInstalledPackage(this.mContext.getPageActivity(), this.fjs.apv);
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View f(ViewGroup viewGroup, int i) {
        if (qU(i)) {
            this.fju = new b(viewGroup);
            aWV();
            viewGroup.addView(this.fju.getView());
            return this.fju.getView();
        }
        return null;
    }

    private boolean qU(int i) {
        return aWU() && this.fjr != 0 && i == this.fjr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWV() {
        if (this.fjs != null && this.fjs.apB != null) {
            aWW();
            if (this.fjs.ye()) {
                this.fju.aXb().setVisibility(8);
                this.fju.v(this.fjy);
            } else if (this.fjs.yd()) {
                this.fju.aXb().setVisibility(0);
                this.fju.v(this.fjx);
                aWX();
            }
            s.a(this.fjs.apB.apU, this.fju.fjC, this.fjs.apB.tagRatio, l.h(this.mContext.getPageActivity(), e.C0210e.ds26));
            if (!TextUtils.isEmpty(this.fjs.apB.adSource)) {
                this.fju.fjE.setText(this.fjs.apB.adSource);
                this.fju.fjD.setVisibility(0);
                return;
            }
            this.fju.fjD.setVisibility(8);
        }
    }

    private void aWW() {
        this.fju.aXa().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z) {
                    a.this.fju.aXe();
                }
                a.this.fju.aXf();
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
                a.this.fju.aXf();
            }
        });
        this.fju.aXa().startLoad(this.fjs.apB.apM, this.aTC ? 30 : 31, 720, 720, false);
    }

    private void aWX() {
        if (this.fjs != null) {
            String str = this.fjs.apr;
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(e.j.app_name);
            }
            if (com.baidu.tieba.recapp.download.d.bvr().hA(this.fjs.apv)) {
                this.fjs.apo = 2;
            } else if (com.baidu.tieba.recapp.download.d.bvr().cy(this.fjs.apv, str)) {
                if (com.baidu.tieba.recapp.download.d.bvr().hy(this.fjs.apv)) {
                    this.fjs.apo = 1;
                } else {
                    this.fjs.apo = 3;
                }
            }
            switch (this.fjs.apo) {
                case 0:
                    String string = this.mContext.getString(e.j.install_app);
                    if (this.fjs.apB != null && !StringUtils.isNull(this.fjs.apB.buttonText)) {
                        string = this.fjs.apB.buttonText;
                    }
                    if (string.length() > fjq) {
                        string = string.substring(0, fjq);
                    }
                    this.fju.qO(string);
                    return;
                case 1:
                    this.fju.aXc();
                    return;
                case 2:
                    this.fju.aXd();
                    return;
                case 3:
                    this.fju.qO(this.mContext.getString(e.j.pb_download_pause));
                    return;
                default:
                    this.fju.aXb().setVisibility(8);
                    this.fju.v(null);
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
            aVar.eB(string);
            aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.fjs.apr;
                    if (StringUtils.isNull(str)) {
                        str = a.this.mContext.getString(e.j.app_name);
                    }
                    a.this.fjv.aXi();
                    if (s.a(a.this.mContext.getPageActivity(), a.this.fjs, 0, str)) {
                        a.this.fjv.qP(a.this.fjs.apv);
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
            aVar.b(this.mContext).BF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.fjs != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.fjs.apv, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.fjs.apo = 2;
                    } else if (status == 2 || status == 4) {
                        if (!ao.isEmpty(downloadData.getStatusMsg())) {
                            this.mContext.showToast(downloadData.getStatusMsg());
                        }
                        this.fjs.apo = 0;
                    } else if (status == 1) {
                        this.fjs.apo = 1;
                    }
                    aWV();
                }
            }
        }
    }

    public void aWY() {
        if (!this.fjw) {
            this.fjw = true;
            this.fjv.aXh();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.fjs));
        }
    }
}
