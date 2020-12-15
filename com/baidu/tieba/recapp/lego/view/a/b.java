package com.baidu.tieba.recapp.lego.view.a;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.a.d;
import com.baidu.tieba.ad.download.mvp.b;
import com.baidu.tieba.lego.card.view.j;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.tieba.tbadkCore.z;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes26.dex */
public class b extends a implements j {
    private TBSpecificationBtn akU;
    public ImageView alZ;
    private DownloadCacheKey fZU;
    private d fZV;
    private DragImageView.d frg;
    private TbImageView iBr;
    private final View.OnClickListener mClickListener;
    public TextView mJI;
    public TextView mJK;
    public TextView mMs;
    public boolean mMt;
    private UrlDragImageView mMu;
    private RelativeLayout mMv;
    private RelativeLayout mMw;
    private ApkDownloadView mMx;
    private VideoInfo mMy;
    private RelativeLayout mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mMt = false;
        this.fZV = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int dFU;
                String str;
                if (b.this.kLa != null && b.this.mJS != null) {
                    if (!b.this.mMt || view.getId() != R.id.big_image_ad_image) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        if (view.getId() == R.id.image_ad_button) {
                            dFU = b.this.dW(view);
                            str = "button";
                        } else if (view.getId() == R.id.bottom_container) {
                            dFU = b.this.dFV();
                            str = "title";
                        } else {
                            dFU = b.this.dFU();
                            str = b.this.kLa.bmH() ? "image" : "video";
                        }
                        hashMap.put("da_area", str);
                        b.this.mMr.d(dFU, hashMap);
                    }
                }
            }
        };
    }

    @Override // com.baidu.tieba.recapp.lego.view.a.a
    protected void ddY() {
        if (this.mPageContext != null) {
            this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.ad_pic_page_layout, (ViewGroup) null);
            this.iBr = (TbImageView) this.mRootView.findViewById(R.id.big_image_ad_image);
            this.akU = (TBSpecificationBtn) this.mRootView.findViewById(R.id.image_ad_button);
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.bd(R.color.CAM_X0302, R.color.CAM_X0101);
            this.akU.setConfig(bVar);
            this.mJI = (TextView) this.mRootView.findViewById(R.id.ad_title);
            this.mMs = (TextView) this.mRootView.findViewById(R.id.ad_brand);
            this.mJK = (TextView) this.mRootView.findViewById(R.id.ad_tag);
            this.mMv = (RelativeLayout) this.mRootView.findViewById(R.id.ad_info_container);
            this.mMw = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_container);
            this.alZ = (ImageView) this.mRootView.findViewById(R.id.video_ad_play_icon);
            this.alZ.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_play44, ap.getColor(R.color.CAM_X0101), (WebPManager.ResourceStateType) null));
            this.mMx = (ApkDownloadView) this.mRootView.findViewById(R.id.image_download_button);
            if (this.mPageContext != null) {
                this.mMx.x(this.mPageContext.getUniqueId());
            }
            this.mMx.setTextSize(R.dimen.tbds39);
            this.mMx.setTextColorInitSkin(R.color.CAM_X0101);
            this.mMx.setBackgroundSkin(R.drawable.pic_page_down_btn_bg);
            this.mMx.bvs();
            dFT();
            ad(this.mClickListener);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.a.a
    public void b(AdCard adCard) {
        super.b(adCard);
        if (this.kLa != null && this.kLa.eEm != null) {
            this.mMy = this.mJS.videoInfo;
            dFR();
            b(this.kLa, this.mJS);
            if (!TextUtils.isEmpty(this.kLa.eEm.userName)) {
                this.mMs.setText(this.kLa.eEm.userName);
                if (!TextUtils.isEmpty(this.kLa.eEm.tagName)) {
                    this.mJK.setText(this.kLa.eEm.tagName);
                } else {
                    this.mJK.setText(this.mContext.getString(R.string.advert_label));
                }
            }
            if (!TextUtils.isEmpty(this.kLa.eEm.eEw)) {
                this.mJI.setText(this.kLa.eEm.eEw);
            }
            this.alZ.setVisibility(this.kLa.bmG() ? 0 : 8);
            ad(this.mClickListener);
        }
    }

    private void dFR() {
        String str;
        this.iBr.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.lego.view.a.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z) {
                    b.this.dFS();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        if (this.kLa.bmG() && this.mMy != null) {
            str = this.mMy.thumbnail_url;
        } else {
            str = this.kLa.eEm.eEy;
        }
        this.iBr.a(str, this.fpu ? 30 : 31, 720, 720, false);
        if (this.mMu != null) {
            this.mMu.setIsCdn(this.fpu);
            this.mMu.setUrl(str, true);
        }
    }

    public void dFS() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams layoutParams = this.iBr.getLayoutParams();
            double loadedHeight = this.iBr.getLoadedHeight() / this.iBr.getLoadedWidth();
            if (loadedHeight > 1.0d) {
                layoutParams.height = width;
                layoutParams.width = (int) (width / loadedHeight);
            } else {
                layoutParams.height = (int) (loadedHeight * width);
                layoutParams.width = width;
            }
            this.iBr.setLayoutParams(layoutParams);
        }
    }

    public void dFT() {
        this.iBr.setVisibility(4);
        this.mMu = new UrlDragImageView(this.mContext);
        this.mMu.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mMu.setIsCanDrag(true);
        this.mMu.setCanScale(false);
        this.mMu.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.recapp.lego.view.a.b.2
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.frg != null) {
                    b.this.frg.onDragStart();
                }
                b.this.mJI.setVisibility(8);
                b.this.mMs.setVisibility(8);
                b.this.mJK.setVisibility(8);
                b.this.mMv.setVisibility(8);
                b.this.alZ.setVisibility(8);
                b.this.akU.setVisibility(8);
                b.this.mMx.setVisibility(8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragEnd() {
                if (b.this.frg != null) {
                    b.this.frg.onDragEnd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void bHe() {
                if (b.this.frg != null) {
                    b.this.frg.bHe();
                }
                b.this.mJI.setVisibility(0);
                b.this.mMs.setVisibility(0);
                b.this.mJK.setVisibility(0);
                b.this.mMv.setVisibility(0);
                if (b.this.kLa != null) {
                    b.this.alZ.setVisibility(b.this.kLa.bmG() ? 0 : 8);
                    if (b.this.kLa.bmF()) {
                        b.this.akU.setVisibility(0);
                    } else {
                        b.this.mMx.setVisibility(0);
                    }
                }
            }
        });
        this.mRootView.addView(this.mMu, 0);
    }

    public void ad(final View.OnClickListener onClickListener) {
        if (this.akU != null) {
            this.akU.setOnClickListener(onClickListener);
        }
        if (this.iBr != null) {
            this.iBr.setOnClickListener(onClickListener);
        }
        if (this.mMw != null) {
            this.mMw.setOnClickListener(onClickListener);
        }
        if (this.alZ != null) {
            this.alZ.setOnClickListener(onClickListener);
        }
        this.mMu.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.recapp.lego.view.a.b.3
            private float mMA = 0.0f;
            private float mMB = 0.0f;
            private float mMC = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.mMt = false;
                        this.mMA = motionEvent.getX();
                        this.mMB = motionEvent.getY();
                        this.mMC = 0.0f;
                        break;
                    case 1:
                        b.this.mMt = 10.0f < this.mMC;
                        if (!b.this.mMt) {
                            onClickListener.onClick(b.this.iBr);
                            break;
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.mMA;
                        float y = motionEvent.getY() - this.mMB;
                        this.mMC = (float) (Math.sqrt((x * x) + (y * y)) + this.mMC);
                        this.mMA = motionEvent.getX();
                        this.mMB = motionEvent.getY();
                        break;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dFU() {
        return this.kLa.bmH() ? dFW() : dFX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dFV() {
        return dFW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dW(View view) {
        return dFW();
    }

    private int dFW() {
        return s.aZ(this.mContext, this.mJS.getScheme() != null ? this.mJS.getScheme() : this.kLa.eEf);
    }

    private int dFX() {
        if (this.kLa == null || this.mJS == null || this.mMy == null) {
            return 0;
        }
        return s.a(this.mContext, this.mJS.getScheme(), this.kLa);
    }

    public void b(AdvertAppInfo advertAppInfo, AdCard adCard) {
        if (advertAppInfo != null && adCard != null) {
            this.kLa = advertAppInfo;
            this.mJS = adCard;
            if (this.kLa.bmF()) {
                String str = this.kLa.eEm.buttonText;
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.check_immediately);
                }
                this.akU.setText(str);
                this.mMx.setVisibility(8);
                this.akU.setVisibility(0);
                return;
            }
            this.mMx.setClickable(true);
            this.mMx.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.a.b.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public boolean bZ(View view) {
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.c(b.this.kLa));
                    if (b.this.mContext != null && s.RT(b.this.mJS.getScheme()) && s.isInstalledPackage(b.this.mContext, b.this.kLa.eEg)) {
                        s.aZ(b.this.mContext, b.this.mJS.getScheme());
                        return true;
                    }
                    if (b.this.mContext != null && !z.ax((Activity) b.this.mContext)) {
                        l.showToast((Activity) b.this.mContext, R.string.write_external_storage_permission_denied_fun_disable);
                    }
                    return false;
                }
            });
            DownloadData d = d(this.kLa, com.baidu.adp.lib.f.b.toInt(this.kLa.adPosition, -1));
            o(d);
            this.mMx.setData(d);
            this.mMx.setVisibility(0);
            this.akU.setVisibility(8);
            b(adCard, advertAppInfo);
        }
    }

    private void b(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey FB;
        DownloadCacheKey downloadCacheKey;
        if (advertAppInfo != null && advertAppInfo.bmE() && adCard != null) {
            String scheme = adCard.getScheme();
            String str = TextUtils.isEmpty(advertAppInfo.eEg) ? advertAppInfo.eEd : advertAppInfo.eEg;
            if (!TextUtils.isEmpty(str)) {
                FB = com.baidu.tieba.ad.download.d.bMy().FA(str);
            } else {
                FB = com.baidu.tieba.ad.download.d.bMy().FB(scheme);
            }
            if (FB == null) {
                downloadCacheKey = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.eEg);
                com.baidu.tieba.ad.download.d.bMy().a(downloadCacheKey, null);
            } else {
                downloadCacheKey = FB;
            }
            i(downloadCacheKey);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.fZU = downloadCacheKey;
            bMs();
            this.fZV = null;
            AdDownloadData d = com.baidu.tieba.ad.download.d.bMy().d(downloadCacheKey);
            this.mMx.a(d.getCurrentState());
            String str = "";
            if (this.mJS != null && this.mJS.getAdvertAppInfo() != null) {
                str = this.mJS.getAdvertAppInfo().page;
                d.setExtInfo(this.mJS.getAdvertAppInfo().extensionInfo);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mMx, d, str);
            this.fZV = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d != null && d.extra() != null && d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bMr();
        }
    }

    private void o(DownloadData downloadData) {
        if (downloadData != null) {
            downloadData.setStatus(this.mMx.getDownloadStatus());
        }
    }

    DownloadData d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo == null) {
            return new DownloadData();
        }
        DownloadData downloadData = new DownloadData(advertAppInfo.eEg);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.eEe);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.eEd, 0));
        return downloadData;
    }

    private void bMr() {
        if (this.fZU != null && this.fZV != null) {
            com.baidu.tieba.ad.download.d.bMy().a(this.fZU, this.fZV);
        }
    }

    private void bMs() {
        if (this.fZU != null && this.fZV != null) {
            com.baidu.tieba.ad.download.d.bMy().b(this.fZU, this.fZV);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void setDragToExitListener(DragImageView.d dVar) {
        this.frg = dVar;
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public View deF() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        bMs();
    }
}
