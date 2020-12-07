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
    private DownloadCacheKey fZS;
    private d fZT;
    private DragImageView.d frg;
    private TbImageView iBp;
    private final View.OnClickListener mClickListener;
    public TextView mJG;
    public TextView mJI;
    public TextView mMq;
    public boolean mMr;
    private UrlDragImageView mMs;
    private RelativeLayout mMt;
    private RelativeLayout mMu;
    private ApkDownloadView mMv;
    private VideoInfo mMw;
    private RelativeLayout mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mMr = false;
        this.fZT = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int dFT;
                String str;
                if (b.this.kKY != null && b.this.mJQ != null) {
                    if (!b.this.mMr || view.getId() != R.id.big_image_ad_image) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        if (view.getId() == R.id.image_ad_button) {
                            dFT = b.this.dW(view);
                            str = "button";
                        } else if (view.getId() == R.id.bottom_container) {
                            dFT = b.this.dFU();
                            str = "title";
                        } else {
                            dFT = b.this.dFT();
                            str = b.this.kKY.bmH() ? "image" : "video";
                        }
                        hashMap.put("da_area", str);
                        b.this.mMp.d(dFT, hashMap);
                    }
                }
            }
        };
    }

    @Override // com.baidu.tieba.recapp.lego.view.a.a
    protected void ddX() {
        if (this.mPageContext != null) {
            this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.ad_pic_page_layout, (ViewGroup) null);
            this.iBp = (TbImageView) this.mRootView.findViewById(R.id.big_image_ad_image);
            this.akU = (TBSpecificationBtn) this.mRootView.findViewById(R.id.image_ad_button);
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.bd(R.color.CAM_X0302, R.color.CAM_X0101);
            this.akU.setConfig(bVar);
            this.mJG = (TextView) this.mRootView.findViewById(R.id.ad_title);
            this.mMq = (TextView) this.mRootView.findViewById(R.id.ad_brand);
            this.mJI = (TextView) this.mRootView.findViewById(R.id.ad_tag);
            this.mMt = (RelativeLayout) this.mRootView.findViewById(R.id.ad_info_container);
            this.mMu = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_container);
            this.alZ = (ImageView) this.mRootView.findViewById(R.id.video_ad_play_icon);
            this.alZ.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_play44, ap.getColor(R.color.CAM_X0101), (WebPManager.ResourceStateType) null));
            this.mMv = (ApkDownloadView) this.mRootView.findViewById(R.id.image_download_button);
            if (this.mPageContext != null) {
                this.mMv.x(this.mPageContext.getUniqueId());
            }
            this.mMv.setTextSize(R.dimen.tbds39);
            this.mMv.setTextColorInitSkin(R.color.CAM_X0101);
            this.mMv.setBackgroundSkin(R.drawable.pic_page_down_btn_bg);
            this.mMv.bvs();
            dFS();
            ad(this.mClickListener);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.a.a
    public void b(AdCard adCard) {
        super.b(adCard);
        if (this.kKY != null && this.kKY.eEm != null) {
            this.mMw = this.mJQ.videoInfo;
            dFQ();
            b(this.kKY, this.mJQ);
            if (!TextUtils.isEmpty(this.kKY.eEm.userName)) {
                this.mMq.setText(this.kKY.eEm.userName);
                if (!TextUtils.isEmpty(this.kKY.eEm.tagName)) {
                    this.mJI.setText(this.kKY.eEm.tagName);
                } else {
                    this.mJI.setText(this.mContext.getString(R.string.advert_label));
                }
            }
            if (!TextUtils.isEmpty(this.kKY.eEm.eEw)) {
                this.mJG.setText(this.kKY.eEm.eEw);
            }
            this.alZ.setVisibility(this.kKY.bmG() ? 0 : 8);
            ad(this.mClickListener);
        }
    }

    private void dFQ() {
        String str;
        this.iBp.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.lego.view.a.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z) {
                    b.this.dFR();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        if (this.kKY.bmG() && this.mMw != null) {
            str = this.mMw.thumbnail_url;
        } else {
            str = this.kKY.eEm.eEy;
        }
        this.iBp.a(str, this.fpu ? 30 : 31, 720, 720, false);
        if (this.mMs != null) {
            this.mMs.setIsCdn(this.fpu);
            this.mMs.setUrl(str, true);
        }
    }

    public void dFR() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams layoutParams = this.iBp.getLayoutParams();
            double loadedHeight = this.iBp.getLoadedHeight() / this.iBp.getLoadedWidth();
            if (loadedHeight > 1.0d) {
                layoutParams.height = width;
                layoutParams.width = (int) (width / loadedHeight);
            } else {
                layoutParams.height = (int) (loadedHeight * width);
                layoutParams.width = width;
            }
            this.iBp.setLayoutParams(layoutParams);
        }
    }

    public void dFS() {
        this.iBp.setVisibility(4);
        this.mMs = new UrlDragImageView(this.mContext);
        this.mMs.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mMs.setIsCanDrag(true);
        this.mMs.setCanScale(false);
        this.mMs.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.recapp.lego.view.a.b.2
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.frg != null) {
                    b.this.frg.onDragStart();
                }
                b.this.mJG.setVisibility(8);
                b.this.mMq.setVisibility(8);
                b.this.mJI.setVisibility(8);
                b.this.mMt.setVisibility(8);
                b.this.alZ.setVisibility(8);
                b.this.akU.setVisibility(8);
                b.this.mMv.setVisibility(8);
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
                b.this.mJG.setVisibility(0);
                b.this.mMq.setVisibility(0);
                b.this.mJI.setVisibility(0);
                b.this.mMt.setVisibility(0);
                if (b.this.kKY != null) {
                    b.this.alZ.setVisibility(b.this.kKY.bmG() ? 0 : 8);
                    if (b.this.kKY.bmF()) {
                        b.this.akU.setVisibility(0);
                    } else {
                        b.this.mMv.setVisibility(0);
                    }
                }
            }
        });
        this.mRootView.addView(this.mMs, 0);
    }

    public void ad(final View.OnClickListener onClickListener) {
        if (this.akU != null) {
            this.akU.setOnClickListener(onClickListener);
        }
        if (this.iBp != null) {
            this.iBp.setOnClickListener(onClickListener);
        }
        if (this.mMu != null) {
            this.mMu.setOnClickListener(onClickListener);
        }
        if (this.alZ != null) {
            this.alZ.setOnClickListener(onClickListener);
        }
        this.mMs.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.recapp.lego.view.a.b.3
            private float mMy = 0.0f;
            private float mMz = 0.0f;
            private float mMA = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.mMr = false;
                        this.mMy = motionEvent.getX();
                        this.mMz = motionEvent.getY();
                        this.mMA = 0.0f;
                        break;
                    case 1:
                        b.this.mMr = 10.0f < this.mMA;
                        if (!b.this.mMr) {
                            onClickListener.onClick(b.this.iBp);
                            break;
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.mMy;
                        float y = motionEvent.getY() - this.mMz;
                        this.mMA = (float) (Math.sqrt((x * x) + (y * y)) + this.mMA);
                        this.mMy = motionEvent.getX();
                        this.mMz = motionEvent.getY();
                        break;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dFT() {
        return this.kKY.bmH() ? dFV() : dFW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dFU() {
        return dFV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dW(View view) {
        return dFV();
    }

    private int dFV() {
        return s.aZ(this.mContext, this.mJQ.getScheme() != null ? this.mJQ.getScheme() : this.kKY.eEf);
    }

    private int dFW() {
        if (this.kKY == null || this.mJQ == null || this.mMw == null) {
            return 0;
        }
        return s.a(this.mContext, this.mJQ.getScheme(), this.kKY);
    }

    public void b(AdvertAppInfo advertAppInfo, AdCard adCard) {
        if (advertAppInfo != null && adCard != null) {
            this.kKY = advertAppInfo;
            this.mJQ = adCard;
            if (this.kKY.bmF()) {
                String str = this.kKY.eEm.buttonText;
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.check_immediately);
                }
                this.akU.setText(str);
                this.mMv.setVisibility(8);
                this.akU.setVisibility(0);
                return;
            }
            this.mMv.setClickable(true);
            this.mMv.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.a.b.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public boolean bZ(View view) {
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.c(b.this.kKY));
                    if (b.this.mContext != null && s.RT(b.this.mJQ.getScheme()) && s.isInstalledPackage(b.this.mContext, b.this.kKY.eEg)) {
                        s.aZ(b.this.mContext, b.this.mJQ.getScheme());
                        return true;
                    }
                    if (b.this.mContext != null && !z.ax((Activity) b.this.mContext)) {
                        l.showToast((Activity) b.this.mContext, R.string.write_external_storage_permission_denied_fun_disable);
                    }
                    return false;
                }
            });
            DownloadData d = d(this.kKY, com.baidu.adp.lib.f.b.toInt(this.kKY.adPosition, -1));
            o(d);
            this.mMv.setData(d);
            this.mMv.setVisibility(0);
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
                FB = com.baidu.tieba.ad.download.d.bMx().FA(str);
            } else {
                FB = com.baidu.tieba.ad.download.d.bMx().FB(scheme);
            }
            if (FB == null) {
                downloadCacheKey = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.eEg);
                com.baidu.tieba.ad.download.d.bMx().a(downloadCacheKey, null);
            } else {
                downloadCacheKey = FB;
            }
            i(downloadCacheKey);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.fZS = downloadCacheKey;
            bMr();
            this.fZT = null;
            AdDownloadData d = com.baidu.tieba.ad.download.d.bMx().d(downloadCacheKey);
            this.mMv.a(d.getCurrentState());
            String str = "";
            if (this.mJQ != null && this.mJQ.getAdvertAppInfo() != null) {
                str = this.mJQ.getAdvertAppInfo().page;
                d.setExtInfo(this.mJQ.getAdvertAppInfo().extensionInfo);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mMv, d, str);
            this.fZT = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d != null && d.extra() != null && d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bMq();
        }
    }

    private void o(DownloadData downloadData) {
        if (downloadData != null) {
            downloadData.setStatus(this.mMv.getDownloadStatus());
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

    private void bMq() {
        if (this.fZS != null && this.fZT != null) {
            com.baidu.tieba.ad.download.d.bMx().a(this.fZS, this.fZT);
        }
    }

    private void bMr() {
        if (this.fZS != null && this.fZT != null) {
            com.baidu.tieba.ad.download.d.bMx().b(this.fZS, this.fZT);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void setDragToExitListener(DragImageView.d dVar) {
        this.frg = dVar;
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public View deE() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        bMr();
    }
}
