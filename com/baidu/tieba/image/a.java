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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.w;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements ImagePagerAdapter.a {
    private static int gYg = 7;
    private boolean cAJ;
    private DragImageView.d cCs;
    private TbPageContext<?> cfl;
    private AdvertAppInfo gYi;
    private boolean gYj;
    private b gYk;
    private c gYl;
    private int gYh = 0;
    private boolean gYm = false;
    private final View.OnClickListener gYn = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gYi != null) {
                if (a.this.gYk == null || !a.this.gYk.gYx || a.this.gYk.bGe() != view) {
                    if (!w.al((Activity) view.getContext())) {
                        l.showToast((Activity) view.getContext(), (int) R.string.write_external_storage_permission_denied_fun_disable);
                        return;
                    }
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.gYl.bGk();
                    } else {
                        a.this.gYl.bGj();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.gYi));
                    int i = a.this.gYi.bXj;
                    if (i == 0 || i == 3) {
                        if (!j.isNetWorkAvailable() || j.isWifiNet()) {
                            String str = a.this.gYi.bXl;
                            if (StringUtils.isNull(str)) {
                                str = a.this.cfl.getString(R.string.app_name);
                            }
                            a.this.gYl.bGm();
                            if (s.a(a.this.cfl.getPageActivity(), a.this.gYi, 0, str)) {
                                a.this.gYl.yC(a.this.gYi.bXo);
                                return;
                            }
                            return;
                        }
                        a.this.c(a.this.gYi);
                    } else if (i == 1) {
                        s.f(a.this.gYi);
                        a.this.gYi.bXj = 3;
                        a.this.bFY();
                    } else if (i == 2) {
                        if (com.baidu.tieba.recapp.download.e.cfS().pw(a.this.gYi.bXo)) {
                            w.aK(a.this.cfl.getPageActivity(), a.this.gYi.bXo);
                            return;
                        }
                        a.this.gYi.bXj = 0;
                        a.this.bFY();
                    }
                }
            }
        }
    };
    private final View.OnClickListener gYo = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gYi != null) {
                if (a.this.gYk == null || !a.this.gYk.gYx || a.this.gYk.bGe() != view) {
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.gYl.bGk();
                    } else {
                        a.this.gYl.bGj();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.gYi));
                    r.cfL().cfI().a(a.this.cfl.getPageActivity(), new String[]{a.this.gYi.bXm}, true);
                }
            }
        }
    };
    private final CustomMessageListener gYp = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.cAJ = false;
        this.gYj = false;
        this.cAJ = z;
        this.gYj = z2;
        this.cfl = tbPageContext;
        this.cfl.registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.gYp);
        this.gYl = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.gYi = advertAppInfo;
        this.gYh = i;
        this.gYl.d(this.gYi);
    }

    public boolean bFX() {
        if (!this.gYj || this.gYi == null) {
            return false;
        }
        return (this.gYi.agT() || this.gYi.agS()) && !w.isInstalledPackage(this.cfl.getPageActivity(), this.gYi.bXo);
    }

    public String getAdId() {
        if (this.gYi != null) {
            return this.gYi.bXk;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View f(ViewGroup viewGroup, int i) {
        if (uT(i)) {
            this.gYk = new b(viewGroup);
            this.gYk.setDragToExitListener(this.cCs);
            bFY();
            viewGroup.addView(this.gYk.getView());
            return this.gYk.getView();
        }
        return null;
    }

    private boolean uT(int i) {
        return bFX() && this.gYh != 0 && i == this.gYh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFY() {
        if (this.gYi != null && this.gYi.bXu != null) {
            bFZ();
            if (this.gYi.agT()) {
                this.gYk.bGf().setVisibility(8);
                this.gYk.B(this.gYo);
            } else if (this.gYi.agS()) {
                this.gYk.bGf().setVisibility(0);
                this.gYk.B(this.gYn);
                bGa();
            }
            if (!TextUtils.isEmpty(this.gYi.bXu.adSource)) {
                this.gYk.gYw.setText(this.gYi.bXu.adSource);
                this.gYk.gYt.setVisibility(0);
            } else {
                this.gYk.gYt.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.gYi.bXu.userName)) {
                if (!TextUtils.isEmpty(this.gYi.bXu.tagName)) {
                    this.gYk.gYv.setText(this.cfl.getResources().getString(R.string.big_image_ad_brand_and_tag, this.gYi.bXu.userName, this.gYi.bXu.tagName));
                } else {
                    this.gYk.gYv.setText(this.cfl.getResources().getString(R.string.big_image_ad_brand_and_tag, this.gYi.bXu.userName, this.cfl.getString(R.string.advert_label)));
                }
            }
            if (!TextUtils.isEmpty(this.gYi.bXu.bXD)) {
                this.gYk.gYu.setText(this.gYi.bXu.bXD);
            }
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.cCs = dVar;
    }

    private void bFZ() {
        this.gYk.bGe().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.gYk.bGi();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.gYk.bGe().a(this.gYi.bXu.bXF, this.cAJ ? 30 : 31, 720, 720, false);
        if (this.gYk.bGd() != null) {
            this.gYk.bGd().setIsCdn(this.cAJ);
            this.gYk.bGd().setUrl(this.gYi.bXu.bXF, true);
        }
    }

    private void bGa() {
        if (this.gYi != null) {
            String str = this.gYi.bXl;
            if (StringUtils.isNull(str)) {
                str = this.cfl.getString(R.string.app_name);
            }
            if (com.baidu.tieba.recapp.download.e.cfS().pw(this.gYi.bXo)) {
                this.gYi.bXj = 2;
            } else if (com.baidu.tieba.recapp.download.e.cfS().dL(this.gYi.bXo, str)) {
                if (com.baidu.tieba.recapp.download.e.cfS().pu(this.gYi.bXo)) {
                    this.gYi.bXj = 1;
                } else {
                    this.gYi.bXj = 3;
                }
            }
            switch (this.gYi.bXj) {
                case 0:
                    String string = this.cfl.getString(R.string.install_app);
                    if (this.gYi.bXu != null && !StringUtils.isNull(this.gYi.bXu.buttonText)) {
                        string = this.gYi.bXu.buttonText;
                    }
                    if (string.length() > gYg) {
                        string = string.substring(0, gYg);
                    }
                    this.gYk.yB(string);
                    return;
                case 1:
                    this.gYk.bGg();
                    return;
                case 2:
                    this.gYk.bGh();
                    return;
                case 3:
                    this.gYk.yB(this.cfl.getString(R.string.pb_download_pause));
                    return;
                default:
                    this.gYk.bGf().setVisibility(8);
                    this.gYk.B(null);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdvertAppInfo advertAppInfo) {
        String string;
        if (advertAppInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cfl.getPageActivity());
            if (j.isMobileNet()) {
                string = this.cfl.getString(R.string.frs_network_tips);
            } else {
                string = this.cfl.getString(R.string.confirm_download_app);
            }
            aVar.nn(string);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.gYi.bXl;
                    if (StringUtils.isNull(str)) {
                        str = a.this.cfl.getString(R.string.app_name);
                    }
                    a.this.gYl.bGm();
                    if (s.a(a.this.cfl.getPageActivity(), a.this.gYi, 0, str)) {
                        a.this.gYl.yC(a.this.gYi.bXo);
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
            aVar.b(this.cfl).akO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.gYi != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.gYi.bXo, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.gYi.bXj = 2;
                    } else if (status == 2 || status == 4) {
                        if (!aq.isEmpty(downloadData.getStatusMsg())) {
                            this.cfl.showToast(downloadData.getStatusMsg());
                        }
                        this.gYi.bXj = 0;
                    } else if (status == 1) {
                        this.gYi.bXj = 1;
                    }
                    bFY();
                }
            }
        }
    }

    public void bGb() {
        if (!this.gYm) {
            this.gYm = true;
            this.gYl.bGl();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.gYi));
        }
    }
}
