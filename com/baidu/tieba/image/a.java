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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.u;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements ImagePagerAdapter.a {
    private static int gXr = 7;
    private boolean cmL;
    private DragImageView.d coB;
    private AdvertAppInfo gXt;
    private boolean gXu;
    private b gXv;
    private c gXw;
    private TbPageContext<?> mContext;
    private int gXs = 0;
    private boolean gXx = false;
    private final View.OnClickListener gXy = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gXt != null) {
                if (a.this.gXv == null || !a.this.gXv.gXI || a.this.gXv.bIt() != view) {
                    if (!u.at((Activity) view.getContext())) {
                        l.showToast((Activity) view.getContext(), (int) R.string.write_external_storage_permission_denied_fun_disable);
                        return;
                    }
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.gXw.bIz();
                    } else {
                        a.this.gXw.bIy();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.gXt));
                    int i = a.this.gXt.bES;
                    if (i == 0 || i == 3) {
                        if (!j.kc() || j.kd()) {
                            String str = a.this.gXt.bEU;
                            if (StringUtils.isNull(str)) {
                                str = a.this.mContext.getString(R.string.app_name);
                            }
                            a.this.gXw.bIB();
                            if (s.a(a.this.mContext.getPageActivity(), a.this.gXt, 0, str)) {
                                a.this.gXw.zK(a.this.gXt.bEX);
                                return;
                            }
                            return;
                        }
                        a.this.c(a.this.gXt);
                    } else if (i == 1) {
                        s.f(a.this.gXt);
                        a.this.gXt.bES = 3;
                        a.this.bIn();
                    } else if (i == 2) {
                        if (com.baidu.tieba.recapp.download.d.chK().qb(a.this.gXt.bEX)) {
                            u.aG(a.this.mContext.getPageActivity(), a.this.gXt.bEX);
                            return;
                        }
                        a.this.gXt.bES = 0;
                        a.this.bIn();
                    }
                }
            }
        }
    };
    private final View.OnClickListener gXz = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gXt != null) {
                if (a.this.gXv == null || !a.this.gXv.gXI || a.this.gXv.bIt() != view) {
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.gXw.bIz();
                    } else {
                        a.this.gXw.bIy();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.gXt));
                    r.chD().chA().a(a.this.mContext.getPageActivity(), new String[]{a.this.gXt.bEV}, true);
                }
            }
        }
    };
    private final CustomMessageListener gXA = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.cmL = false;
        this.gXu = false;
        this.cmL = z;
        this.gXu = z2;
        this.mContext = tbPageContext;
        this.mContext.registerListener(2001118, this.gXA);
        this.gXw = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.gXt = advertAppInfo;
        this.gXs = i;
        this.gXw.d(this.gXt);
    }

    public boolean bIm() {
        if (!this.gXu || this.gXt == null) {
            return false;
        }
        return (this.gXt.acI() || this.gXt.acH()) && !u.isInstalledPackage(this.mContext.getPageActivity(), this.gXt.bEX);
    }

    public String getAdId() {
        if (this.gXt != null) {
            return this.gXt.bET;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View h(ViewGroup viewGroup, int i) {
        if (wi(i)) {
            this.gXv = new b(viewGroup);
            this.gXv.setDragToExitListener(this.coB);
            bIn();
            viewGroup.addView(this.gXv.getView());
            return this.gXv.getView();
        }
        return null;
    }

    private boolean wi(int i) {
        return bIm() && this.gXs != 0 && i == this.gXs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIn() {
        if (this.gXt != null && this.gXt.bFd != null) {
            bIo();
            if (this.gXt.acI()) {
                this.gXv.bIu().setVisibility(8);
                this.gXv.A(this.gXz);
            } else if (this.gXt.acH()) {
                this.gXv.bIu().setVisibility(0);
                this.gXv.A(this.gXy);
                bIp();
            }
            if (!TextUtils.isEmpty(this.gXt.bFd.adSource)) {
                this.gXv.gXH.setText(this.gXt.bFd.adSource);
                this.gXv.gXE.setVisibility(0);
            } else {
                this.gXv.gXE.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.gXt.bFd.userName)) {
                if (!TextUtils.isEmpty(this.gXt.bFd.tagName)) {
                    this.gXv.gXG.setText(this.mContext.getResources().getString(R.string.big_image_ad_brand_and_tag, this.gXt.bFd.userName, this.gXt.bFd.tagName));
                } else {
                    this.gXv.gXG.setText(this.mContext.getResources().getString(R.string.big_image_ad_brand_and_tag, this.gXt.bFd.userName, this.mContext.getString(R.string.advert_label)));
                }
            }
            if (!TextUtils.isEmpty(this.gXt.bFd.bFm)) {
                this.gXv.gXF.setText(this.gXt.bFd.bFm);
            }
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.coB = dVar;
    }

    private void bIo() {
        this.gXv.bIt().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z) {
                    a.this.gXv.bIx();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.gXv.bIt().startLoad(this.gXt.bFd.bFo, this.cmL ? 30 : 31, 720, 720, false);
        if (this.gXv.bIs() != null) {
            this.gXv.bIs().setIsCdn(this.cmL);
            this.gXv.bIs().setUrl(this.gXt.bFd.bFo, true);
        }
    }

    private void bIp() {
        if (this.gXt != null) {
            String str = this.gXt.bEU;
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(R.string.app_name);
            }
            if (com.baidu.tieba.recapp.download.d.chK().qb(this.gXt.bEX)) {
                this.gXt.bES = 2;
            } else if (com.baidu.tieba.recapp.download.d.chK().dY(this.gXt.bEX, str)) {
                if (com.baidu.tieba.recapp.download.d.chK().pZ(this.gXt.bEX)) {
                    this.gXt.bES = 1;
                } else {
                    this.gXt.bES = 3;
                }
            }
            switch (this.gXt.bES) {
                case 0:
                    String string = this.mContext.getString(R.string.install_app);
                    if (this.gXt.bFd != null && !StringUtils.isNull(this.gXt.bFd.buttonText)) {
                        string = this.gXt.bFd.buttonText;
                    }
                    if (string.length() > gXr) {
                        string = string.substring(0, gXr);
                    }
                    this.gXv.zJ(string);
                    return;
                case 1:
                    this.gXv.bIv();
                    return;
                case 2:
                    this.gXv.bIw();
                    return;
                case 3:
                    this.gXv.zJ(this.mContext.getString(R.string.pb_download_pause));
                    return;
                default:
                    this.gXv.bIu().setVisibility(8);
                    this.gXv.A(null);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdvertAppInfo advertAppInfo) {
        String string;
        if (advertAppInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            if (j.ke()) {
                string = this.mContext.getString(R.string.frs_network_tips);
            } else {
                string = this.mContext.getString(R.string.confirm_download_app);
            }
            aVar.mO(string);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.gXt.bEU;
                    if (StringUtils.isNull(str)) {
                        str = a.this.mContext.getString(R.string.app_name);
                    }
                    a.this.gXw.bIB();
                    if (s.a(a.this.mContext.getPageActivity(), a.this.gXt, 0, str)) {
                        a.this.gXw.zK(a.this.gXt.bEX);
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
            aVar.b(this.mContext).agI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.gXt != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.gXt.bEX, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.gXt.bES = 2;
                    } else if (status == 2 || status == 4) {
                        if (!aq.isEmpty(downloadData.getStatusMsg())) {
                            this.mContext.showToast(downloadData.getStatusMsg());
                        }
                        this.gXt.bES = 0;
                    } else if (status == 1) {
                        this.gXt.bES = 1;
                    }
                    bIn();
                }
            }
        }
    }

    public void bIq() {
        if (!this.gXx) {
            this.gXx = true;
            this.gXw.bIA();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.gXt));
        }
    }
}
