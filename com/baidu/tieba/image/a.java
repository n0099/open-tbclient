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
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.u;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements ImagePagerAdapter.a {
    private static int gRh = 7;
    private boolean cly;
    private DragImageView.d cno;
    private AdvertAppInfo gRj;
    private boolean gRk;
    private b gRl;
    private c gRm;
    private TbPageContext<?> mContext;
    private int gRi = 0;
    private boolean gRn = false;
    private final View.OnClickListener gRo = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gRj != null) {
                if (a.this.gRl == null || !a.this.gRl.gRy || a.this.gRl.bFM() != view) {
                    if (!u.aq((Activity) view.getContext())) {
                        l.showToast((Activity) view.getContext(), (int) R.string.write_external_storage_permission_denied_fun_disable);
                        return;
                    }
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.gRm.bFS();
                    } else {
                        a.this.gRm.bFR();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.gRj));
                    int i = a.this.gRj.bDS;
                    if (i == 0 || i == 3) {
                        if (!j.jS() || j.jT()) {
                            String str = a.this.gRj.bDU;
                            if (StringUtils.isNull(str)) {
                                str = a.this.mContext.getString(R.string.app_name);
                            }
                            a.this.gRm.bFU();
                            if (s.a(a.this.mContext.getPageActivity(), a.this.gRj, 0, str)) {
                                a.this.gRm.yZ(a.this.gRj.bDX);
                                return;
                            }
                            return;
                        }
                        a.this.c(a.this.gRj);
                    } else if (i == 1) {
                        s.f(a.this.gRj);
                        a.this.gRj.bDS = 3;
                        a.this.bFG();
                    } else if (i == 2) {
                        if (com.baidu.tieba.recapp.download.d.ceT().pK(a.this.gRj.bDX)) {
                            u.aF(a.this.mContext.getPageActivity(), a.this.gRj.bDX);
                            return;
                        }
                        a.this.gRj.bDS = 0;
                        a.this.bFG();
                    }
                }
            }
        }
    };
    private final View.OnClickListener gRp = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gRj != null) {
                if (a.this.gRl == null || !a.this.gRl.gRy || a.this.gRl.bFM() != view) {
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.gRm.bFS();
                    } else {
                        a.this.gRm.bFR();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.gRj));
                    r.ceM().ceJ().a(a.this.mContext.getPageActivity(), new String[]{a.this.gRj.bDV}, true);
                }
            }
        }
    };
    private final CustomMessageListener gRq = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.cly = false;
        this.gRk = false;
        this.cly = z;
        this.gRk = z2;
        this.mContext = tbPageContext;
        this.mContext.registerListener(2001118, this.gRq);
        this.gRm = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.gRj = advertAppInfo;
        this.gRi = i;
        this.gRm.d(this.gRj);
    }

    public boolean bFF() {
        if (!this.gRk || this.gRj == null) {
            return false;
        }
        return (this.gRj.abG() || this.gRj.abF()) && !u.isInstalledPackage(this.mContext.getPageActivity(), this.gRj.bDX);
    }

    public String getAdId() {
        if (this.gRj != null) {
            return this.gRj.bDT;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View h(ViewGroup viewGroup, int i) {
        if (vG(i)) {
            this.gRl = new b(viewGroup);
            this.gRl.setDragToExitListener(this.cno);
            bFG();
            viewGroup.addView(this.gRl.getView());
            return this.gRl.getView();
        }
        return null;
    }

    private boolean vG(int i) {
        return bFF() && this.gRi != 0 && i == this.gRi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFG() {
        if (this.gRj != null && this.gRj.bEd != null) {
            bFH();
            if (this.gRj.abG()) {
                this.gRl.bFN().setVisibility(8);
                this.gRl.y(this.gRp);
            } else if (this.gRj.abF()) {
                this.gRl.bFN().setVisibility(0);
                this.gRl.y(this.gRo);
                bFI();
            }
            if (!TextUtils.isEmpty(this.gRj.bEd.adSource)) {
                this.gRl.gRx.setText(this.gRj.bEd.adSource);
                this.gRl.gRu.setVisibility(0);
            } else {
                this.gRl.gRu.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.gRj.bEd.userName)) {
                if (!TextUtils.isEmpty(this.gRj.bEd.tagName)) {
                    this.gRl.gRw.setText(this.mContext.getResources().getString(R.string.big_image_ad_brand_and_tag, this.gRj.bEd.userName, this.gRj.bEd.tagName));
                } else {
                    this.gRl.gRw.setText(this.mContext.getResources().getString(R.string.big_image_ad_brand_and_tag, this.gRj.bEd.userName, this.mContext.getString(R.string.advert_label)));
                }
            }
            if (!TextUtils.isEmpty(this.gRj.bEd.bEm)) {
                this.gRl.gRv.setText(this.gRj.bEd.bEm);
            }
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.cno = dVar;
    }

    private void bFH() {
        this.gRl.bFM().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void O(String str, boolean z) {
                if (z) {
                    a.this.gRl.bFQ();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.gRl.bFM().startLoad(this.gRj.bEd.bEo, this.cly ? 30 : 31, 720, 720, false);
        if (this.gRl.bFL() != null) {
            this.gRl.bFL().setIsCdn(this.cly);
            this.gRl.bFL().setUrl(this.gRj.bEd.bEo, true);
        }
    }

    private void bFI() {
        if (this.gRj != null) {
            String str = this.gRj.bDU;
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(R.string.app_name);
            }
            if (com.baidu.tieba.recapp.download.d.ceT().pK(this.gRj.bDX)) {
                this.gRj.bDS = 2;
            } else if (com.baidu.tieba.recapp.download.d.ceT().dX(this.gRj.bDX, str)) {
                if (com.baidu.tieba.recapp.download.d.ceT().pI(this.gRj.bDX)) {
                    this.gRj.bDS = 1;
                } else {
                    this.gRj.bDS = 3;
                }
            }
            switch (this.gRj.bDS) {
                case 0:
                    String string = this.mContext.getString(R.string.install_app);
                    if (this.gRj.bEd != null && !StringUtils.isNull(this.gRj.bEd.buttonText)) {
                        string = this.gRj.bEd.buttonText;
                    }
                    if (string.length() > gRh) {
                        string = string.substring(0, gRh);
                    }
                    this.gRl.yY(string);
                    return;
                case 1:
                    this.gRl.bFO();
                    return;
                case 2:
                    this.gRl.bFP();
                    return;
                case 3:
                    this.gRl.yY(this.mContext.getString(R.string.pb_download_pause));
                    return;
                default:
                    this.gRl.bFN().setVisibility(8);
                    this.gRl.y(null);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(AdvertAppInfo advertAppInfo) {
        String string;
        if (advertAppInfo != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            if (j.jU()) {
                string = this.mContext.getString(R.string.frs_network_tips);
            } else {
                string = this.mContext.getString(R.string.confirm_download_app);
            }
            aVar.mD(string);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.gRj.bDU;
                    if (StringUtils.isNull(str)) {
                        str = a.this.mContext.getString(R.string.app_name);
                    }
                    a.this.gRm.bFU();
                    if (s.a(a.this.mContext.getPageActivity(), a.this.gRj, 0, str)) {
                        a.this.gRm.yZ(a.this.gRj.bDX);
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
            aVar.b(this.mContext).afG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.gRj != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.gRj.bDX, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.gRj.bDS = 2;
                    } else if (status == 2 || status == 4) {
                        if (!ap.isEmpty(downloadData.getStatusMsg())) {
                            this.mContext.showToast(downloadData.getStatusMsg());
                        }
                        this.gRj.bDS = 0;
                    } else if (status == 1) {
                        this.gRj.bDS = 1;
                    }
                    bFG();
                }
            }
        }
    }

    public void bFJ() {
        if (!this.gRn) {
            this.gRn = true;
            this.gRm.bFT();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.gRj));
        }
    }
}
