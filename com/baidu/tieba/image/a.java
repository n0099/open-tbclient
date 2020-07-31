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
    private static int jrU = 7;
    private TbPageContext<?> dVN;
    private boolean evH;
    private DragImageView.d exr;
    private AdvertAppInfo jrW;
    private boolean jrX;
    private b jrY;
    private c jrZ;
    private int jrV = 0;
    private boolean jsa = false;
    private final View.OnClickListener jsb = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.jrW != null) {
                if (a.this.jrY == null || !a.this.jrY.jsl || a.this.jrY.czs() != view) {
                    if (!x.ar((Activity) view.getContext())) {
                        l.showToast((Activity) view.getContext(), R.string.write_external_storage_permission_denied_fun_disable);
                        return;
                    }
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand || view.getId() == R.id.big_image_ad_tag) {
                        a.this.jrZ.czy();
                    } else {
                        a.this.jrZ.czx();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.jrW));
                    int i = a.this.jrW.dMV;
                    if (i == 0 || i == 3) {
                        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() || com.baidu.adp.lib.util.j.isWifiNet()) {
                            String str = a.this.jrW.dMX;
                            if (StringUtils.isNull(str)) {
                                str = a.this.dVN.getString(R.string.app_name);
                            }
                            a.this.jrZ.czz();
                            if (s.a(a.this.dVN.getPageActivity(), a.this.jrW, 0, str)) {
                                a.this.jrZ.Ix(a.this.jrW.dMZ);
                                return;
                            }
                            return;
                        }
                        a.this.c(a.this.jrW);
                    } else if (i == 1) {
                        s.f(a.this.jrW);
                        a.this.jrW.dMV = 3;
                        a.this.czm();
                    } else if (i == 2) {
                        if (com.baidu.tieba.recapp.download.e.dcg().zu(a.this.jrW.dMZ)) {
                            x.aM(a.this.dVN.getPageActivity(), a.this.jrW.dMZ);
                            return;
                        }
                        a.this.jrW.dMV = 0;
                        a.this.czm();
                    }
                }
            }
        }
    };
    private final View.OnClickListener jsc = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (a.this.jrW != null) {
                if (a.this.jrY == null || !a.this.jrY.jsl || a.this.jrY.czs() != view) {
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand || view.getId() == R.id.big_image_ad_tag) {
                        a.this.jrZ.czy();
                    } else {
                        a.this.jrZ.czx();
                    }
                    ICardInfo IK = com.baidu.tieba.lego.card.b.IK(a.this.jrW.dNf.lego_card);
                    if (!(IK instanceof BaseLegoCardInfo)) {
                        str = a.this.jrW.dMY;
                    } else {
                        str = ((BaseLegoCardInfo) IK).getScheme();
                    }
                    int aN = s.aN(a.this.dVN.getPageActivity(), str);
                    if (aN == 1 || aN == 2) {
                        com.baidu.tieba.lego.card.b.c.IO(a.this.jrW.dMY);
                    }
                }
            }
        }
    };
    private final CustomMessageListener jsd = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.jrX = false;
        this.evH = z;
        this.jrX = z2;
        this.dVN = tbPageContext;
        this.dVN.registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.jsd);
        this.jrZ = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.jrW = advertAppInfo;
        this.jrV = i;
        this.jrZ.d(this.jrW);
    }

    public boolean czl() {
        if (!this.jrX || this.jrW == null) {
            return false;
        }
        return (this.jrW.aUg() || this.jrW.aUf()) && !x.isInstalledPackage(this.dVN.getPageActivity(), this.jrW.dMZ);
    }

    public String getAdId() {
        if (this.jrW != null) {
            return this.jrW.dMW;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View j(ViewGroup viewGroup, int i) {
        if (zG(i)) {
            this.jrY = new b(viewGroup);
            this.jrY.setDragToExitListener(this.exr);
            czm();
            viewGroup.addView(this.jrY.getView());
            return this.jrY.getView();
        }
        return null;
    }

    private boolean zG(int i) {
        return czl() && this.jrV != 0 && i == this.jrV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czm() {
        if (this.jrW != null && this.jrW.dNf != null) {
            czn();
            if (this.jrW.aUg()) {
                this.jrY.czt().setVisibility(8);
                this.jrY.D(this.jsc);
            } else if (this.jrW.aUf()) {
                this.jrY.czt().setVisibility(0);
                this.jrY.D(this.jsb);
                czo();
            }
            if (!TextUtils.isEmpty(this.jrW.dNf.adSource)) {
                this.jrY.jsk.setText(this.jrW.dNf.adSource);
                this.jrY.jsg.setVisibility(0);
            } else {
                this.jrY.jsg.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.jrW.dNf.userName)) {
                this.jrY.jsi.setText(this.jrW.dNf.userName);
                if (!TextUtils.isEmpty(this.jrW.dNf.tagName)) {
                    this.jrY.jsj.setText(this.jrW.dNf.tagName);
                } else {
                    this.jrY.jsj.setText(this.dVN.getString(R.string.advert_label));
                }
            }
            if (!TextUtils.isEmpty(this.jrW.dNf.dNo)) {
                this.jrY.jsh.setText(this.jrW.dNf.dNo);
            }
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.exr = dVar;
    }

    private void czn() {
        this.jrY.czs().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.jrY.czw();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.jrY.czs().a(this.jrW.dNf.dNq, this.evH ? 30 : 31, 720, 720, false);
        if (this.jrY.czr() != null) {
            this.jrY.czr().setIsCdn(this.evH);
            this.jrY.czr().setUrl(this.jrW.dNf.dNq, true);
        }
    }

    private void czo() {
        if (this.jrW != null) {
            String str = this.jrW.dMX;
            if (StringUtils.isNull(str)) {
                str = this.dVN.getString(R.string.app_name);
            }
            if (com.baidu.tieba.recapp.download.e.dcg().zu(this.jrW.dMZ)) {
                this.jrW.dMV = 2;
            } else if (com.baidu.tieba.recapp.download.e.dcg().fm(this.jrW.dMZ, str)) {
                if (com.baidu.tieba.recapp.download.e.dcg().zs(this.jrW.dMZ)) {
                    this.jrW.dMV = 1;
                } else {
                    this.jrW.dMV = 3;
                }
            }
            switch (this.jrW.dMV) {
                case 0:
                    String string = this.dVN.getString(R.string.install_app);
                    if (this.jrW.dNf != null && !StringUtils.isNull(this.jrW.dNf.buttonText)) {
                        string = this.jrW.dNf.buttonText;
                    }
                    if (string.length() > jrU) {
                        string = string.substring(0, jrU);
                    }
                    this.jrY.Iw(string);
                    return;
                case 1:
                    this.jrY.czu();
                    return;
                case 2:
                    this.jrY.czv();
                    return;
                case 3:
                    this.jrY.Iw(this.dVN.getString(R.string.pb_download_pause));
                    return;
                default:
                    this.jrY.czt().setVisibility(8);
                    this.jrY.D(null);
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
                    String str = a.this.jrW.dMX;
                    if (StringUtils.isNull(str)) {
                        str = a.this.dVN.getString(R.string.app_name);
                    }
                    a.this.jrZ.czz();
                    if (s.a(a.this.dVN.getPageActivity(), a.this.jrW, 0, str)) {
                        a.this.jrZ.Ix(a.this.jrW.dMZ);
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
        if ((responsedMessage instanceof DownloadMessage) && this.jrW != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.jrW.dMZ, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.jrW.dMV = 2;
                    } else if (status == 2 || status == 4) {
                        if (!as.isEmpty(downloadData.getStatusMsg())) {
                            this.dVN.showToast(downloadData.getStatusMsg());
                        }
                        this.jrW.dMV = 0;
                    } else if (status == 1) {
                        this.jrW.dMV = 1;
                    }
                    czm();
                }
            }
        }
    }

    public void czp() {
        if (!this.jsa) {
            this.jsa = true;
            this.jrZ.YW();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.jrW));
        }
    }
}
