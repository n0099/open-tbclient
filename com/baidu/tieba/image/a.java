package com.baidu.tieba.image;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.q;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.x;
import java.util.List;
/* loaded from: classes8.dex */
public class a implements ImagePagerAdapter.a {
    private static int jjp = 7;
    private TbPageContext<?> dPv;
    private boolean eps;
    private DragImageView.d eqZ;
    private AdvertAppInfo jjr;
    private boolean jjs;
    private b jjt;
    private c jju;
    private int jjq = 0;
    private boolean jjv = false;
    private final View.OnClickListener jjw = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.jjr != null) {
                if (a.this.jjt == null || !a.this.jjt.jjG || a.this.jjt.cvu() != view) {
                    if (!x.aq((Activity) view.getContext())) {
                        l.showToast((Activity) view.getContext(), (int) R.string.write_external_storage_permission_denied_fun_disable);
                        return;
                    }
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand || view.getId() == R.id.big_image_ad_tag) {
                        a.this.jju.cvA();
                    } else {
                        a.this.jju.cvz();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.jjr));
                    int i = a.this.jjr.dGK;
                    if (i == 0 || i == 3) {
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || com.baidu.adp.lib.util.j.isWifiNet()) {
                            String str = a.this.jjr.dGM;
                            if (StringUtils.isNull(str)) {
                                str = a.this.dPv.getString(R.string.app_name);
                            }
                            a.this.jju.cvB();
                            if (r.a(a.this.dPv.getPageActivity(), a.this.jjr, 0, str)) {
                                a.this.jju.HI(a.this.jjr.dGO);
                                return;
                            }
                            return;
                        }
                        a.this.c(a.this.jjr);
                    } else if (i == 1) {
                        r.f(a.this.jjr);
                        a.this.jjr.dGK = 3;
                        a.this.cvo();
                    } else if (i == 2) {
                        if (com.baidu.tieba.recapp.download.e.cYZ().yo(a.this.jjr.dGO)) {
                            x.aN(a.this.dPv.getPageActivity(), a.this.jjr.dGO);
                            return;
                        }
                        a.this.jjr.dGK = 0;
                        a.this.cvo();
                    }
                }
            }
        }
    };
    private final View.OnClickListener jjx = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.jjr != null) {
                if (a.this.jjt == null || !a.this.jjt.jjG || a.this.jjt.cvu() != view) {
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand || view.getId() == R.id.big_image_ad_tag) {
                        a.this.jju.cvA();
                    } else {
                        a.this.jju.cvz();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.jjr));
                    q.cYT().cYQ().a(a.this.dPv.getPageActivity(), new String[]{a.this.jjr.dGN}, true);
                }
            }
        }
    };
    private final CustomMessageListener jjy = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            if (customResponsedMessage != null && !customResponsedMessage.hasError()) {
                a.this.f(customResponsedMessage);
            }
        }
    };

    public a(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        this.eps = false;
        this.jjs = false;
        this.eps = z;
        this.jjs = z2;
        this.dPv = tbPageContext;
        this.dPv.registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.jjy);
        this.jju = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.jjr = advertAppInfo;
        this.jjq = i;
        this.jju.d(this.jjr);
    }

    public boolean cvn() {
        if (!this.jjs || this.jjr == null) {
            return false;
        }
        return (this.jjr.aQk() || this.jjr.aQj()) && !x.isInstalledPackage(this.dPv.getPageActivity(), this.jjr.dGO);
    }

    public String getAdId() {
        if (this.jjr != null) {
            return this.jjr.dGL;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View j(ViewGroup viewGroup, int i) {
        if (zh(i)) {
            this.jjt = new b(viewGroup);
            this.jjt.setDragToExitListener(this.eqZ);
            cvo();
            viewGroup.addView(this.jjt.getView());
            return this.jjt.getView();
        }
        return null;
    }

    private boolean zh(int i) {
        return cvn() && this.jjq != 0 && i == this.jjq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvo() {
        if (this.jjr != null && this.jjr.dGU != null) {
            cvp();
            if (this.jjr.aQk()) {
                this.jjt.cvv().setVisibility(8);
                this.jjt.D(this.jjx);
            } else if (this.jjr.aQj()) {
                this.jjt.cvv().setVisibility(0);
                this.jjt.D(this.jjw);
                cvq();
            }
            if (!TextUtils.isEmpty(this.jjr.dGU.adSource)) {
                this.jjt.jjF.setText(this.jjr.dGU.adSource);
                this.jjt.jjB.setVisibility(0);
            } else {
                this.jjt.jjB.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.jjr.dGU.userName)) {
                this.jjt.jjD.setText(this.jjr.dGU.userName);
                if (!TextUtils.isEmpty(this.jjr.dGU.tagName)) {
                    this.jjt.jjE.setText(this.jjr.dGU.tagName);
                } else {
                    this.jjt.jjE.setText(this.dPv.getString(R.string.advert_label));
                }
            }
            if (!TextUtils.isEmpty(this.jjr.dGU.dHd)) {
                this.jjt.jjC.setText(this.jjr.dGU.dHd);
            }
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.eqZ = dVar;
    }

    private void cvp() {
        this.jjt.cvu().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.jjt.cvy();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.jjt.cvu().a(this.jjr.dGU.dHf, this.eps ? 30 : 31, 720, 720, false);
        if (this.jjt.cvt() != null) {
            this.jjt.cvt().setIsCdn(this.eps);
            this.jjt.cvt().setUrl(this.jjr.dGU.dHf, true);
        }
    }

    private void cvq() {
        if (this.jjr != null) {
            String str = this.jjr.dGM;
            if (StringUtils.isNull(str)) {
                str = this.dPv.getString(R.string.app_name);
            }
            if (com.baidu.tieba.recapp.download.e.cYZ().yo(this.jjr.dGO)) {
                this.jjr.dGK = 2;
            } else if (com.baidu.tieba.recapp.download.e.cYZ().fk(this.jjr.dGO, str)) {
                if (com.baidu.tieba.recapp.download.e.cYZ().ym(this.jjr.dGO)) {
                    this.jjr.dGK = 1;
                } else {
                    this.jjr.dGK = 3;
                }
            }
            switch (this.jjr.dGK) {
                case 0:
                    String string = this.dPv.getString(R.string.install_app);
                    if (this.jjr.dGU != null && !StringUtils.isNull(this.jjr.dGU.buttonText)) {
                        string = this.jjr.dGU.buttonText;
                    }
                    if (string.length() > jjp) {
                        string = string.substring(0, jjp);
                    }
                    this.jjt.HH(string);
                    return;
                case 1:
                    this.jjt.cvw();
                    return;
                case 2:
                    this.jjt.cvx();
                    return;
                case 3:
                    this.jjt.HH(this.dPv.getString(R.string.pb_download_pause));
                    return;
                default:
                    this.jjt.cvv().setVisibility(8);
                    this.jjt.D(null);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdvertAppInfo advertAppInfo) {
        String string;
        if (advertAppInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dPv.getPageActivity());
            if (com.baidu.adp.lib.util.j.isMobileNet()) {
                string = this.dPv.getString(R.string.frs_network_tips);
            } else {
                string = this.dPv.getString(R.string.confirm_download_app);
            }
            aVar.we(string);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.jjr.dGM;
                    if (StringUtils.isNull(str)) {
                        str = a.this.dPv.getString(R.string.app_name);
                    }
                    a.this.jju.cvB();
                    if (r.a(a.this.dPv.getPageActivity(), a.this.jjr, 0, str)) {
                        a.this.jju.HI(a.this.jjr.dGO);
                    }
                    aVar2.dismiss();
                }
            });
            aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.image.a.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.dPv).aUN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.jjr != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.jjr.dGO, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.jjr.dGK = 2;
                    } else if (status == 2 || status == 4) {
                        if (!ar.isEmpty(downloadData.getStatusMsg())) {
                            this.dPv.showToast(downloadData.getStatusMsg());
                        }
                        this.jjr.dGK = 0;
                    } else if (status == 1) {
                        this.jjr.dGK = 1;
                    }
                    cvo();
                }
            }
        }
    }

    public void cvr() {
        if (!this.jjv) {
            this.jjv = true;
            this.jju.ckp();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.jjr));
        }
    }
}
