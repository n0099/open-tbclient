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
    private static int had = 7;
    private boolean cnO;
    private DragImageView.d cpD;
    private AdvertAppInfo haf;
    private boolean hag;
    private b hah;
    private c hai;
    private TbPageContext<?> mContext;
    private int hae = 0;
    private boolean haj = false;
    private final View.OnClickListener hak = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.haf != null) {
                if (a.this.hah == null || !a.this.hah.hau || a.this.hah.bJu() != view) {
                    if (!w.at((Activity) view.getContext())) {
                        l.showToast((Activity) view.getContext(), (int) R.string.write_external_storage_permission_denied_fun_disable);
                        return;
                    }
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.hai.bJA();
                    } else {
                        a.this.hai.bJz();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.haf));
                    int i = a.this.haf.bFr;
                    if (i == 0 || i == 3) {
                        if (!j.kc() || j.kd()) {
                            String str = a.this.haf.bFt;
                            if (StringUtils.isNull(str)) {
                                str = a.this.mContext.getString(R.string.app_name);
                            }
                            a.this.hai.bJC();
                            if (s.a(a.this.mContext.getPageActivity(), a.this.haf, 0, str)) {
                                a.this.hai.Ak(a.this.haf.bFw);
                                return;
                            }
                            return;
                        }
                        a.this.c(a.this.haf);
                    } else if (i == 1) {
                        s.f(a.this.haf);
                        a.this.haf.bFr = 3;
                        a.this.bJo();
                    } else if (i == 2) {
                        if (com.baidu.tieba.recapp.download.e.ciQ().qm(a.this.haf.bFw)) {
                            w.aN(a.this.mContext.getPageActivity(), a.this.haf.bFw);
                            return;
                        }
                        a.this.haf.bFr = 0;
                        a.this.bJo();
                    }
                }
            }
        }
    };
    private final View.OnClickListener hal = new View.OnClickListener() { // from class: com.baidu.tieba.image.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.haf != null) {
                if (a.this.hah == null || !a.this.hah.hau || a.this.hah.bJu() != view) {
                    if (view.getId() == R.id.big_image_ad_title || view.getId() == R.id.big_image_ad_brand) {
                        a.this.hai.bJA();
                    } else {
                        a.this.hai.bJz();
                    }
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.e(a.this.haf));
                    r.ciJ().ciG().a(a.this.mContext.getPageActivity(), new String[]{a.this.haf.bFu}, true);
                }
            }
        }
    };
    private final CustomMessageListener ham = new CustomMessageListener(0) { // from class: com.baidu.tieba.image.a.6
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
        this.cnO = false;
        this.hag = false;
        this.cnO = z;
        this.hag = z2;
        this.mContext = tbPageContext;
        this.mContext.registerListener(2001118, this.ham);
        this.hai = new c(tbPageContext.getPageActivity(), str, str2);
    }

    public void a(AdvertAppInfo advertAppInfo, int i) {
        this.haf = advertAppInfo;
        this.hae = i;
        this.hai.d(this.haf);
    }

    public boolean bJn() {
        if (!this.hag || this.haf == null) {
            return false;
        }
        return (this.haf.acN() || this.haf.acM()) && !w.isInstalledPackage(this.mContext.getPageActivity(), this.haf.bFw);
    }

    public String getAdId() {
        if (this.haf != null) {
            return this.haf.bFs;
        }
        return null;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View h(ViewGroup viewGroup, int i) {
        if (wn(i)) {
            this.hah = new b(viewGroup);
            this.hah.setDragToExitListener(this.cpD);
            bJo();
            viewGroup.addView(this.hah.getView());
            return this.hah.getView();
        }
        return null;
    }

    private boolean wn(int i) {
        return bJn() && this.hae != 0 && i == this.hae;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJo() {
        if (this.haf != null && this.haf.bFC != null) {
            bJp();
            if (this.haf.acN()) {
                this.hah.bJv().setVisibility(8);
                this.hah.A(this.hal);
            } else if (this.haf.acM()) {
                this.hah.bJv().setVisibility(0);
                this.hah.A(this.hak);
                bJq();
            }
            if (!TextUtils.isEmpty(this.haf.bFC.adSource)) {
                this.hah.hat.setText(this.haf.bFC.adSource);
                this.hah.haq.setVisibility(0);
            } else {
                this.hah.haq.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.haf.bFC.userName)) {
                if (!TextUtils.isEmpty(this.haf.bFC.tagName)) {
                    this.hah.has.setText(this.mContext.getResources().getString(R.string.big_image_ad_brand_and_tag, this.haf.bFC.userName, this.haf.bFC.tagName));
                } else {
                    this.hah.has.setText(this.mContext.getResources().getString(R.string.big_image_ad_brand_and_tag, this.haf.bFC.userName, this.mContext.getString(R.string.advert_label)));
                }
            }
            if (!TextUtils.isEmpty(this.haf.bFC.bFL)) {
                this.hah.har.setText(this.haf.bFC.bFL);
            }
        }
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.cpD = dVar;
    }

    private void bJp() {
        this.hah.bJu().setEvent(new TbImageView.a() { // from class: com.baidu.tieba.image.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z) {
                    a.this.hah.bJy();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.hah.bJu().startLoad(this.haf.bFC.bFN, this.cnO ? 30 : 31, 720, 720, false);
        if (this.hah.bJt() != null) {
            this.hah.bJt().setIsCdn(this.cnO);
            this.hah.bJt().setUrl(this.haf.bFC.bFN, true);
        }
    }

    private void bJq() {
        if (this.haf != null) {
            String str = this.haf.bFt;
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(R.string.app_name);
            }
            if (com.baidu.tieba.recapp.download.e.ciQ().qm(this.haf.bFw)) {
                this.haf.bFr = 2;
            } else if (com.baidu.tieba.recapp.download.e.ciQ().dZ(this.haf.bFw, str)) {
                if (com.baidu.tieba.recapp.download.e.ciQ().qk(this.haf.bFw)) {
                    this.haf.bFr = 1;
                } else {
                    this.haf.bFr = 3;
                }
            }
            switch (this.haf.bFr) {
                case 0:
                    String string = this.mContext.getString(R.string.install_app);
                    if (this.haf.bFC != null && !StringUtils.isNull(this.haf.bFC.buttonText)) {
                        string = this.haf.bFC.buttonText;
                    }
                    if (string.length() > had) {
                        string = string.substring(0, had);
                    }
                    this.hah.Aj(string);
                    return;
                case 1:
                    this.hah.bJw();
                    return;
                case 2:
                    this.hah.bJx();
                    return;
                case 3:
                    this.hah.Aj(this.mContext.getString(R.string.pb_download_pause));
                    return;
                default:
                    this.hah.bJv().setVisibility(8);
                    this.hah.A(null);
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
            aVar.mQ(string);
            aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.image.a.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    String str = a.this.haf.bFt;
                    if (StringUtils.isNull(str)) {
                        str = a.this.mContext.getString(R.string.app_name);
                    }
                    a.this.hai.bJC();
                    if (s.a(a.this.mContext.getPageActivity(), a.this.haf, 0, str)) {
                        a.this.hai.Ak(a.this.haf.bFw);
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
            aVar.b(this.mContext).agO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        if ((responsedMessage instanceof DownloadMessage) && this.haf != null && (data = ((DownloadMessage) responsedMessage).getData()) != null && data.size() != 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null && TextUtils.equals(this.haf.bFw, downloadData.getId())) {
                    int status = downloadData.getStatus();
                    if (status == 3 || status == 0) {
                        this.haf.bFr = 2;
                    } else if (status == 2 || status == 4) {
                        if (!aq.isEmpty(downloadData.getStatusMsg())) {
                            this.mContext.showToast(downloadData.getStatusMsg());
                        }
                        this.haf.bFr = 0;
                    } else if (status == 1) {
                        this.haf.bFr = 1;
                    }
                    bJo();
                }
            }
        }
    }

    public void bJr() {
        if (!this.haj) {
            this.haj = true;
            this.hai.bJB();
            com.baidu.tieba.lego.card.b.c.b(com.baidu.tieba.lego.card.b.c.e(this.haf));
        }
    }
}
