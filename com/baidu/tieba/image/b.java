package com.baidu.tieba.image;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.mvp.b;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.tieba.tbadkCore.y;
/* loaded from: classes21.dex */
public class b {
    private TBSpecificationBtn ajR;
    private DownloadCacheKey fMm;
    private DragImageView.d feG;
    private TbImageView ijK;
    private AdvertAppInfo krb;
    private AdCard krg;
    private RelativeLayout krj;
    public TextView krk;
    public TextView krl;
    public TextView krm;
    private UrlDragImageView kro;
    private RelativeLayout krp;
    private RelativeLayout krq;
    public TbImageView krr;
    private ApkDownloadView krs;
    private Context mContext;
    public boolean krn = false;
    private com.baidu.tieba.ad.download.a.d fMn = null;

    public b(ViewGroup viewGroup, TbPageContext<?> tbPageContext) {
        this.krj = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.big_image_ad, (ViewGroup) null);
        this.ijK = (TbImageView) this.krj.findViewById(R.id.big_image_ad_image);
        this.ajR = (TBSpecificationBtn) this.krj.findViewById(R.id.image_ad_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bb(R.color.cp_link_tip_a, R.color.cp_cont_a);
        this.ajR.setConfig(bVar);
        this.krk = (TextView) this.krj.findViewById(R.id.ad_title);
        this.krl = (TextView) this.krj.findViewById(R.id.ad_brand);
        this.krm = (TextView) this.krj.findViewById(R.id.ad_tag);
        this.krp = (RelativeLayout) this.krj.findViewById(R.id.ad_info_container);
        this.krq = (RelativeLayout) this.krj.findViewById(R.id.bottom_container);
        this.krr = (TbImageView) this.krj.findViewById(R.id.video_ad_play_icon);
        this.mContext = viewGroup.getContext();
        this.krs = (ApkDownloadView) this.krj.findViewById(R.id.image_download_button);
        if (tbPageContext != null) {
            this.krs.x(tbPageContext.getUniqueId());
        }
        this.krs.setTextSize(R.dimen.tbds39);
        this.krs.setTextColorInitSkin(R.color.cp_cont_a);
        this.krs.setBackgroundSkin(R.drawable.pic_page_down_btn_bg);
        this.krs.changeSkin();
        cUG();
    }

    public View getView() {
        return this.krj;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.feG = dVar;
    }

    public void cUG() {
        this.ijK.setVisibility(4);
        this.kro = new UrlDragImageView(this.mContext);
        this.kro.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.kro.setIsCanDrag(true);
        this.kro.setCanScale(false);
        this.kro.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.1
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.feG != null) {
                    b.this.feG.onDragStart();
                }
                b.this.r(b.this.krk, 8);
                b.this.r(b.this.krl, 8);
                b.this.r(b.this.krm, 8);
                b.this.r(b.this.krp, 8);
                b.this.r(b.this.krr, 8);
                b.this.r(b.this.ajR, 8);
                b.this.r(b.this.krs, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragEnd() {
                if (b.this.feG != null) {
                    b.this.feG.onDragEnd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void bBL() {
                if (b.this.feG != null) {
                    b.this.feG.bBL();
                }
                b.this.r(b.this.krk, 0);
                b.this.r(b.this.krl, 0);
                b.this.r(b.this.krm, 0);
                b.this.r(b.this.krp, 0);
                if (b.this.krb != null) {
                    b.this.r(b.this.krr, b.this.krb.bhU() ? 0 : 8);
                    if (b.this.krb.bhT()) {
                        b.this.r(b.this.ajR, 0);
                    } else {
                        b.this.r(b.this.krs, 0);
                    }
                }
            }
        });
        this.krj.addView(this.kro, 0);
    }

    public UrlDragImageView cUH() {
        return this.kro;
    }

    public TbImageView cUI() {
        return this.ijK;
    }

    public void cUJ() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams layoutParams = this.ijK.getLayoutParams();
            double loadedHeight = this.ijK.getLoadedHeight() / this.ijK.getLoadedWidth();
            if (loadedHeight > 1.0d) {
                layoutParams.height = width;
                layoutParams.width = (int) (width / loadedHeight);
            } else {
                layoutParams.height = (int) (loadedHeight * width);
                layoutParams.width = width;
            }
            this.ijK.setLayoutParams(layoutParams);
        }
    }

    public void E(final View.OnClickListener onClickListener) {
        if (this.ajR != null) {
            this.ajR.setOnClickListener(onClickListener);
        }
        if (this.ijK != null) {
            this.ijK.setOnClickListener(onClickListener);
        }
        if (this.krq != null) {
            this.krq.setOnClickListener(onClickListener);
        }
        if (this.krr != null) {
            this.krr.setOnClickListener(onClickListener);
        }
        this.kro.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.2
            private float kru = 0.0f;
            private float krv = 0.0f;
            private float krw = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.krn = false;
                        this.kru = motionEvent.getX();
                        this.krv = motionEvent.getY();
                        this.krw = 0.0f;
                        break;
                    case 1:
                        b.this.krn = 10.0f < this.krw;
                        if (!b.this.krn) {
                            onClickListener.onClick(b.this.ijK);
                            break;
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.kru;
                        float y = motionEvent.getY() - this.krv;
                        this.krw = (float) (Math.sqrt((x * x) + (y * y)) + this.krw);
                        this.kru = motionEvent.getX();
                        this.krv = motionEvent.getY();
                        break;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(@NonNull View view, int i) {
        view.setVisibility(i);
    }

    public void a(AdvertAppInfo advertAppInfo, AdCard adCard) {
        if (advertAppInfo != null && adCard != null) {
            this.krb = advertAppInfo;
            this.krg = adCard;
            if (this.krb.bhT()) {
                String str = this.krb.ete.buttonText;
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.check_immediately);
                }
                this.ajR.setText(str);
                this.krs.setVisibility(8);
                this.ajR.setVisibility(0);
                return;
            }
            this.krs.setClickable(true);
            this.krs.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.image.b.3
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public boolean bL(View view) {
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.d(b.this.krb));
                    if (b.this.mContext == null || !s.QY(b.this.krg.getScheme()) || !s.isInstalledPackage(b.this.mContext, b.this.krb.esX)) {
                        if (b.this.mContext != null && !y.ax((Activity) b.this.mContext)) {
                            l.showToast((Activity) b.this.mContext, R.string.write_external_storage_permission_denied_fun_disable);
                        }
                        return false;
                    }
                    s.aY(b.this.mContext, b.this.krg.getScheme());
                    return true;
                }
            });
            DownloadData b = b(this.krb, com.baidu.adp.lib.f.b.toInt(this.krb.adPosition, -1));
            h(b);
            this.krs.setData(b);
            this.krs.setVisibility(0);
            this.ajR.setVisibility(8);
            a(adCard, advertAppInfo);
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey EY;
        if (advertAppInfo != null && advertAppInfo.bhS() && adCard != null) {
            String scheme = adCard.getScheme();
            String str = advertAppInfo.esU;
            if (!TextUtils.isEmpty(str)) {
                EY = com.baidu.tieba.ad.download.d.bGX().EX(str);
            } else {
                EY = com.baidu.tieba.ad.download.d.bGX().EY(scheme);
            }
            if (EY == null) {
                EY = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.esX);
                com.baidu.tieba.ad.download.d.bGX().a(EY, null);
            }
            i(EY);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.fMm = downloadCacheKey;
            bGR();
            this.fMn = null;
            AdDownloadData d = com.baidu.tieba.ad.download.d.bGX().d(downloadCacheKey);
            this.krs.a(d.getCurrentState());
            String str = "";
            if (this.krg != null && this.krg.getAdvertAppInfo() != null) {
                str = this.krg.getAdvertAppInfo().page;
                d.setExtInfo(this.krg.getAdvertAppInfo().extensionInfo);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.krs, d, str);
            this.fMn = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d != null && d.extra() != null && d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bGQ();
        }
    }

    private void h(DownloadData downloadData) {
        if (downloadData != null) {
            downloadData.setStatus(this.krs.getDownloadStatus());
        }
    }

    DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo == null) {
            return new DownloadData();
        }
        DownloadData downloadData = new DownloadData(advertAppInfo.esX);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.esV);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.esU, 0));
        return downloadData;
    }

    private void bGQ() {
        if (this.fMm != null && this.fMn != null) {
            com.baidu.tieba.ad.download.d.bGX().a(this.fMm, this.fMn);
        }
    }

    private void bGR() {
        if (this.fMm != null && this.fMn != null) {
            com.baidu.tieba.ad.download.d.bGX().b(this.fMm, this.fMn);
        }
    }

    public void onDestroy() {
        bGR();
    }

    public void onCreate() {
        bGQ();
    }
}
