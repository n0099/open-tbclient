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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.x;
import java.util.List;
/* loaded from: classes15.dex */
public class a implements ImagePagerAdapter.a {
    private static int jrW = 7;
    private TbPageContext<?> dVN;
    private boolean evH;
    private DragImageView.d exr;
    private AdvertAppInfo jrY;
    private boolean jrZ;
    private b jsa;
    private c jsb;
    private int jrX = 0;
    private boolean jsc = false;
    private final View.OnClickListener jsd = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.jrY != null) {
                if (a.this.jsa == null || !a.this.jsa.jsn || a.this.jsa.czs() != view) {
                    if (!x.ar((Activity) view.getContext())) {
                        l.showToast((Activity) view.getContext(), R.string.write_external_storage_permission_denied_fun_disable);
                        return;
                    }
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand || view.getId() == R.id.big_image_ad_tag) {
                        a.this.jsb.czy();
                    } else {
                        a.this.jsb.czx();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.jrY));
                    int i = a.this.jrY.dMV;
                    if (i == 0 || i == 3) {
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || com.baidu.adp.lib.util.j.isWifiNet()) {
                            String str = a.this.jrY.dMX;
                            if (StringUtils.isNull(str)) {
                                str = a.this.dVN.getString(R.string.app_name);
                            }
                            a.this.jsb.czz();
                            if (s.a(a.this.dVN.getPageActivity(), a.this.jrY, 0, str)) {
                                a.this.jsb.Ix(a.this.jrY.dMZ);
                                return;
                            }
                            return;
                        }
                        a.this.c(a.this.jrY);
                    } else if (i == 1) {
                        s.f(a.this.jrY);
                        a.this.jrY.dMV = 3;
                        a.this.czm();
                    } else if (i == 2) {
                        if (com.baidu.tieba.recapp.download.e.dcg().zu(a.this.jrY.dMZ)) {
                            x.aM(a.this.dVN.getPageActivity(), a.this.jrY.dMZ);
                            return;
                        }
                        a.this.jrY.dMV = 0;
                        a.this.czm();
                    }
                }
            }
        }
    };
    private final View.OnClickListener jse = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (a.this.jrY != null) {
                if (a.this.jsa == null || !a.this.jsa.jsn || a.this.jsa.czs() != view) {
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand || view.getId() == R.id.big_image_ad_tag) {
                        a.this.jsb.czy();
                    } else {
                        a.this.jsb.czx();
                    }
                    ICardInfo IK = com.baidu.tieba.lego.card.b.IK(a.this.jrY.dNf.lego_card);
                    if (!(IK instanceof BaseLegoCardInfo)) {
                        str = a.this.jrY.dMY;
                    } else {
                        str = ((BaseLegoCardInfo) IK).getScheme();
                    }
                    int aN = s.aN(a.this.dVN.getPageActivity(), str);
                    if (aN == 1 || aN == 2) {
                        com.baidu.tieba.lego.card.b.c.IO(a.this.jrY.dMY);
                    }
                }
            }
        }
    };
    private final CustomMessageListener jsf = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.evH = false;
        this.jrZ = false;
        this.evH = z;
        this.jrZ = z2;
        this.dVN = tbPageContext;
        this.dVN.registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.jsf);
        this.jsb = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.jrY = advertAppInfo;
        this.jrX = i;
        this.jsb.d(this.jrY);
    }

    public boolean czl() {
        if (!this.jrZ || this.jrY == null) {
            return false;
        }
        return (this.jrY.aUg() || this.jrY.aUf()) && !x.isInstalledPackage(this.dVN.getPageActivity(), this.jrY.dMZ);
    }

    public String getAdId() {
        if (this.jrY != null) {
            return this.jrY.dMW;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View j(ViewGroup viewGroup, int i) {
        if (zG(i)) {
            this.jsa = new b(viewGroup);
            this.jsa.setDragToExitListener(this.exr);
            czm();
            viewGroup.addView(this.jsa.getView());
            return this.jsa.getView();
        }
        return null;
    }

    private boolean zG(int i) {
        return czl() && this.jrX != 0 && i == this.jrX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czm() {
        if (this.jrY != null && this.jrY.dNf != null) {
            czn();
            if (this.jrY.aUg()) {
                this.jsa.czt().setVisibility(8);
                this.jsa.D(this.jse);
            } else if (this.jrY.aUf()) {
                this.jsa.czt().setVisibility(0);
                this.jsa.D(this.jsd);
                czo();
            }
            if (!TextUtils.isEmpty(this.jrY.dNf.adSource)) {
                this.jsa.jsm.setText(this.jrY.dNf.adSource);
                this.jsa.jsi.setVisibility(0);
            } else {
                this.jsa.jsi.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.jrY.dNf.userName)) {
                this.jsa.jsk.setText(this.jrY.dNf.userName);
                if (!TextUtils.isEmpty(this.jrY.dNf.tagName)) {
                    this.jsa.jsl.setText(this.jrY.dNf.tagName);
                } else {
                    this.jsa.jsl.setText(this.dVN.getString(R.string.advert_label));
                }
            }
            if (!TextUtils.isEmpty(this.jrY.dNf.dNo)) {
                this.jsa.jsj.setText(this.jrY.dNf.dNo);
            }
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.exr = dVar;
    }

    private void czn() {
        this.jsa.czs().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.jsa.czw();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.jsa.czs().a(this.jrY.dNf.dNq, this.evH ? 30 : 31, 720, 720, false);
        if (this.jsa.czr() != null) {
            this.jsa.czr().setIsCdn(this.evH);
            this.jsa.czr().setUrl(this.jrY.dNf.dNq, true);
        }
    }

    private void czo() {
        if (this.jrY != null) {
            String str = this.jrY.dMX;
            if (StringUtils.isNull(str)) {
                str = this.dVN.getString(R.string.app_name);
            }
            if (com.baidu.tieba.recapp.download.e.dcg().zu(this.jrY.dMZ)) {
                this.jrY.dMV = 2;
            } else if (com.baidu.tieba.recapp.download.e.dcg().fm(this.jrY.dMZ, str)) {
                if (com.baidu.tieba.recapp.download.e.dcg().zs(this.jrY.dMZ)) {
                    this.jrY.dMV = 1;
                } else {
                    this.jrY.dMV = 3;
                }
            }
            switch (this.jrY.dMV) {
                case 0:
                    String string = this.dVN.getString(R.string.install_app);
                    if (this.jrY.dNf != null && !StringUtils.isNull(this.jrY.dNf.buttonText)) {
                        string = this.jrY.dNf.buttonText;
                    }
                    if (string.length() > jrW) {
                        string = string.substring(0, jrW);
                    }
                    this.jsa.Iw(string);
                    return;
                case 1:
                    this.jsa.czu();
                    return;
                case 2:
                    this.jsa.czv();
                    return;
                case 3:
                    this.jsa.Iw(this.dVN.getString(R.string.pb_download_pause));
                    return;
                default:
                    this.jsa.czt().setVisibility(8);
                    this.jsa.D(null);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdvertAppInfo advertAppInfo) {
        String string;
        if (advertAppInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dVN.getPageActivity());
            if (com.baidu.adp.lib.util.j.isMobileNet()) {
                string = this.dVN.getString(R.string.frs_network_tips);
            } else {
                string = this.dVN.getString(R.string.confirm_download_app);
            }
            aVar.xl(string);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.jrY.dMX;
                    if (StringUtils.isNull(str)) {
                        str = a.this.dVN.getString(R.string.app_name);
                    }
                    a.this.jsb.czz();
                    if (s.a(a.this.dVN.getPageActivity(), a.this.jrY, 0, str)) {
                        a.this.jsb.Ix(a.this.jrY.dMZ);
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
            aVar.b(this.dVN).aYL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.jrY != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.jrY.dMZ, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.jrY.dMV = 2;
                    } else if (status == 2 || status == 4) {
                        if (!as.isEmpty(downloadData.getStatusMsg())) {
                            this.dVN.showToast(downloadData.getStatusMsg());
                        }
                        this.jrY.dMV = 0;
                    } else if (status == 1) {
                        this.jrY.dMV = 1;
                    }
                    czm();
                }
            }
        }
    }

    public void czp() {
        if (!this.jsc) {
            this.jsc = true;
            this.jsb.YW();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.jrY));
        }
    }
}
