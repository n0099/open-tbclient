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
import com.baidu.tieba.tbadkCore.w;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements ImagePagerAdapter.a {
    private static int gYj = 7;
    private boolean cmS;
    private DragImageView.d coI;
    private AdvertAppInfo gYl;
    private boolean gYm;
    private b gYn;
    private c gYo;
    private TbPageContext<?> mContext;
    private int gYk = 0;
    private boolean gYp = false;
    private final View.OnClickListener gYq = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gYl != null) {
                if (a.this.gYn == null || !a.this.gYn.gYA || a.this.gYn.bIH() != view) {
                    if (!w.at((Activity) view.getContext())) {
                        l.showToast((Activity) view.getContext(), (int) R.string.write_external_storage_permission_denied_fun_disable);
                        return;
                    }
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.gYo.bIN();
                    } else {
                        a.this.gYo.bIM();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.gYl));
                    int i = a.this.gYl.bET;
                    if (i == 0 || i == 3) {
                        if (!j.kc() || j.kd()) {
                            String str = a.this.gYl.bEV;
                            if (StringUtils.isNull(str)) {
                                str = a.this.mContext.getString(R.string.app_name);
                            }
                            a.this.gYo.bIP();
                            if (s.a(a.this.mContext.getPageActivity(), a.this.gYl, 0, str)) {
                                a.this.gYo.zL(a.this.gYl.bEY);
                                return;
                            }
                            return;
                        }
                        a.this.c(a.this.gYl);
                    } else if (i == 1) {
                        s.f(a.this.gYl);
                        a.this.gYl.bET = 3;
                        a.this.bIB();
                    } else if (i == 2) {
                        if (com.baidu.tieba.recapp.download.d.cic().qb(a.this.gYl.bEY)) {
                            w.aG(a.this.mContext.getPageActivity(), a.this.gYl.bEY);
                            return;
                        }
                        a.this.gYl.bET = 0;
                        a.this.bIB();
                    }
                }
            }
        }
    };
    private final View.OnClickListener gYr = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gYl != null) {
                if (a.this.gYn == null || !a.this.gYn.gYA || a.this.gYn.bIH() != view) {
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.gYo.bIN();
                    } else {
                        a.this.gYo.bIM();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.gYl));
                    r.chV().chS().a(a.this.mContext.getPageActivity(), new String[]{a.this.gYl.bEW}, true);
                }
            }
        }
    };
    private final CustomMessageListener gYs = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.cmS = false;
        this.gYm = false;
        this.cmS = z;
        this.gYm = z2;
        this.mContext = tbPageContext;
        this.mContext.registerListener(2001118, this.gYs);
        this.gYo = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.gYl = advertAppInfo;
        this.gYk = i;
        this.gYo.d(this.gYl);
    }

    public boolean bIA() {
        if (!this.gYm || this.gYl == null) {
            return false;
        }
        return (this.gYl.acJ() || this.gYl.acI()) && !w.isInstalledPackage(this.mContext.getPageActivity(), this.gYl.bEY);
    }

    public String getAdId() {
        if (this.gYl != null) {
            return this.gYl.bEU;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View h(ViewGroup viewGroup, int i) {
        if (wk(i)) {
            this.gYn = new b(viewGroup);
            this.gYn.setDragToExitListener(this.coI);
            bIB();
            viewGroup.addView(this.gYn.getView());
            return this.gYn.getView();
        }
        return null;
    }

    private boolean wk(int i) {
        return bIA() && this.gYk != 0 && i == this.gYk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIB() {
        if (this.gYl != null && this.gYl.bFe != null) {
            bIC();
            if (this.gYl.acJ()) {
                this.gYn.bII().setVisibility(8);
                this.gYn.A(this.gYr);
            } else if (this.gYl.acI()) {
                this.gYn.bII().setVisibility(0);
                this.gYn.A(this.gYq);
                bID();
            }
            if (!TextUtils.isEmpty(this.gYl.bFe.adSource)) {
                this.gYn.gYz.setText(this.gYl.bFe.adSource);
                this.gYn.gYw.setVisibility(0);
            } else {
                this.gYn.gYw.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.gYl.bFe.userName)) {
                if (!TextUtils.isEmpty(this.gYl.bFe.tagName)) {
                    this.gYn.gYy.setText(this.mContext.getResources().getString(R.string.big_image_ad_brand_and_tag, this.gYl.bFe.userName, this.gYl.bFe.tagName));
                } else {
                    this.gYn.gYy.setText(this.mContext.getResources().getString(R.string.big_image_ad_brand_and_tag, this.gYl.bFe.userName, this.mContext.getString(R.string.advert_label)));
                }
            }
            if (!TextUtils.isEmpty(this.gYl.bFe.bFn)) {
                this.gYn.gYx.setText(this.gYl.bFe.bFn);
            }
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.coI = dVar;
    }

    private void bIC() {
        this.gYn.bIH().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z) {
                    a.this.gYn.bIL();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.gYn.bIH().startLoad(this.gYl.bFe.bFp, this.cmS ? 30 : 31, 720, 720, false);
        if (this.gYn.bIG() != null) {
            this.gYn.bIG().setIsCdn(this.cmS);
            this.gYn.bIG().setUrl(this.gYl.bFe.bFp, true);
        }
    }

    private void bID() {
        if (this.gYl != null) {
            String str = this.gYl.bEV;
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(R.string.app_name);
            }
            if (com.baidu.tieba.recapp.download.d.cic().qb(this.gYl.bEY)) {
                this.gYl.bET = 2;
            } else if (com.baidu.tieba.recapp.download.d.cic().dY(this.gYl.bEY, str)) {
                if (com.baidu.tieba.recapp.download.d.cic().pZ(this.gYl.bEY)) {
                    this.gYl.bET = 1;
                } else {
                    this.gYl.bET = 3;
                }
            }
            switch (this.gYl.bET) {
                case 0:
                    String string = this.mContext.getString(R.string.install_app);
                    if (this.gYl.bFe != null && !StringUtils.isNull(this.gYl.bFe.buttonText)) {
                        string = this.gYl.bFe.buttonText;
                    }
                    if (string.length() > gYj) {
                        string = string.substring(0, gYj);
                    }
                    this.gYn.zK(string);
                    return;
                case 1:
                    this.gYn.bIJ();
                    return;
                case 2:
                    this.gYn.bIK();
                    return;
                case 3:
                    this.gYn.zK(this.mContext.getString(R.string.pb_download_pause));
                    return;
                default:
                    this.gYn.bII().setVisibility(8);
                    this.gYn.A(null);
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
                    String str = a.this.gYl.bEV;
                    if (StringUtils.isNull(str)) {
                        str = a.this.mContext.getString(R.string.app_name);
                    }
                    a.this.gYo.bIP();
                    if (s.a(a.this.mContext.getPageActivity(), a.this.gYl, 0, str)) {
                        a.this.gYo.zL(a.this.gYl.bEY);
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
            aVar.b(this.mContext).agK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.gYl != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.gYl.bEY, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.gYl.bET = 2;
                    } else if (status == 2 || status == 4) {
                        if (!aq.isEmpty(downloadData.getStatusMsg())) {
                            this.mContext.showToast(downloadData.getStatusMsg());
                        }
                        this.gYl.bET = 0;
                    } else if (status == 1) {
                        this.gYl.bET = 1;
                    }
                    bIB();
                }
            }
        }
    }

    public void bIE() {
        if (!this.gYp) {
            this.gYp = true;
            this.gYo.bIO();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.gYl));
        }
    }
}
