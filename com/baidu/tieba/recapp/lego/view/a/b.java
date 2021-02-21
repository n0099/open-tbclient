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
import androidx.annotation.NonNull;
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
import com.baidu.tieba.recapp.t;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.tieba.tbadkCore.z;
import java.util.HashMap;
import tbclient.App;
import tbclient.VideoInfo;
/* loaded from: classes8.dex */
public class b extends a implements j {
    private TBSpecificationBtn aku;
    public ImageView alA;
    private DragImageView.d fyu;
    private DownloadCacheKey ggV;
    private d ggW;
    private TbImageView iOS;
    private final View.OnClickListener mClickListener;
    private RelativeLayout mRootView;
    public TextView mTV;
    public TextView mTX;
    public TextView mWI;
    public boolean mWJ;
    private UrlDragImageView mWK;
    private RelativeLayout mWL;
    private RelativeLayout mWN;
    private ApkDownloadView mWO;
    private VideoInfo mWP;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mWJ = false;
        this.ggW = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int dEi;
                String str;
                if (b.this.kTV != null && b.this.mUg != null) {
                    if (!b.this.mWJ || view.getId() != R.id.big_image_ad_image) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        if (view.getId() == R.id.image_ad_button) {
                            dEi = b.this.ee(view);
                            str = "button";
                        } else if (view.getId() == R.id.bottom_container) {
                            dEi = b.this.dEj();
                            str = "title";
                        } else {
                            dEi = b.this.dEi();
                            str = b.this.kTV.blG() ? "image" : "video";
                        }
                        hashMap.put("da_area", str);
                        b.this.mWH.d(dEi, hashMap);
                    }
                }
            }
        };
    }

    @Override // com.baidu.tieba.recapp.lego.view.a.a
    protected void dbX() {
        if (this.mPageContext != null) {
            this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.ad_pic_page_layout, (ViewGroup) null);
            this.iOS = (TbImageView) this.mRootView.findViewById(R.id.big_image_ad_image);
            this.aku = (TBSpecificationBtn) this.mRootView.findViewById(R.id.image_ad_button);
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.aY(R.color.CAM_X0302, R.color.CAM_X0101);
            this.aku.setConfig(bVar);
            this.mTV = (TextView) this.mRootView.findViewById(R.id.ad_title);
            this.mWI = (TextView) this.mRootView.findViewById(R.id.ad_brand);
            this.mTX = (TextView) this.mRootView.findViewById(R.id.ad_tag);
            this.mWL = (RelativeLayout) this.mRootView.findViewById(R.id.ad_info_container);
            this.mWN = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_container);
            this.alA = (ImageView) this.mRootView.findViewById(R.id.video_ad_play_icon);
            this.alA.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_play44, ap.getColor(R.color.CAM_X0101), (WebPManager.ResourceStateType) null));
            this.mWO = (ApkDownloadView) this.mRootView.findViewById(R.id.image_download_button);
            if (this.mPageContext != null) {
                this.mWO.y(this.mPageContext.getUniqueId());
            }
            this.mWO.setTextSize(R.dimen.tbds39);
            this.mWO.setTextColorInitSkin(R.color.CAM_X0101);
            this.mWO.setBackgroundSkin(R.drawable.pic_page_down_btn_bg);
            this.mWO.buo();
            dEh();
            af(this.mClickListener);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.a.a
    public void b(AdCard adCard) {
        super.b(adCard);
        if (this.kTV != null && this.kTV.eLC != null) {
            this.mWP = this.mUg.videoInfo;
            dEf();
            b(this.kTV, this.mUg);
            if (!TextUtils.isEmpty(this.kTV.eLC.userName)) {
                this.mWI.setText(this.kTV.eLC.userName);
                if (!TextUtils.isEmpty(this.kTV.eLC.tagName)) {
                    this.mTX.setText(this.kTV.eLC.tagName);
                } else {
                    this.mTX.setText(this.mContext.getString(R.string.advert_label));
                }
            }
            if (!TextUtils.isEmpty(this.kTV.eLC.eLN)) {
                this.mTV.setText(this.kTV.eLC.eLN);
            }
            this.alA.setVisibility(this.kTV.isVideoAd() ? 0 : 8);
            af(this.mClickListener);
        }
    }

    private void dEf() {
        String str;
        this.iOS.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.recapp.lego.view.a.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str2, boolean z) {
                if (z) {
                    b.this.dEg();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        if (this.kTV.isVideoAd() && this.mWP != null) {
            str = this.mWP.thumbnail_url;
        } else {
            str = this.kTV.eLC.eLP;
        }
        this.iOS.a(str, this.fwJ ? 30 : 31, 720, 720, false);
        if (this.mWK != null) {
            this.mWK.setIsCdn(this.fwJ);
            this.mWK.setUrl(str, true);
        }
    }

    public void dEg() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams layoutParams = this.iOS.getLayoutParams();
            double loadedHeight = this.iOS.getLoadedHeight() / this.iOS.getLoadedWidth();
            if (loadedHeight > 1.0d) {
                layoutParams.height = width;
                layoutParams.width = (int) (width / loadedHeight);
            } else {
                layoutParams.height = (int) (loadedHeight * width);
                layoutParams.width = width;
            }
            this.iOS.setLayoutParams(layoutParams);
        }
    }

    public void dEh() {
        this.iOS.setVisibility(4);
        this.mWK = new UrlDragImageView(this.mContext);
        this.mWK.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mWK.setIsCanDrag(true);
        this.mWK.setCanScale(false);
        this.mWK.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.recapp.lego.view.a.b.2
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.fyu != null) {
                    b.this.fyu.onDragStart();
                }
                b.this.mTV.setVisibility(8);
                b.this.mWI.setVisibility(8);
                b.this.mTX.setVisibility(8);
                b.this.mWL.setVisibility(8);
                b.this.alA.setVisibility(8);
                b.this.aku.setVisibility(8);
                b.this.mWO.setVisibility(8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragEnd() {
                if (b.this.fyu != null) {
                    b.this.fyu.onDragEnd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void bGa() {
                if (b.this.fyu != null) {
                    b.this.fyu.bGa();
                }
                b.this.mTV.setVisibility(0);
                b.this.mWI.setVisibility(0);
                b.this.mTX.setVisibility(0);
                b.this.mWL.setVisibility(0);
                if (b.this.kTV != null) {
                    b.this.alA.setVisibility(b.this.kTV.isVideoAd() ? 0 : 8);
                    if (b.this.kTV.blF()) {
                        b.this.aku.setVisibility(0);
                    } else {
                        b.this.mWO.setVisibility(0);
                    }
                }
            }
        });
        this.mRootView.addView(this.mWK, 0);
    }

    public void af(final View.OnClickListener onClickListener) {
        if (this.aku != null) {
            this.aku.setOnClickListener(onClickListener);
        }
        if (this.iOS != null) {
            this.iOS.setOnClickListener(onClickListener);
        }
        if (this.mWN != null) {
            this.mWN.setOnClickListener(onClickListener);
        }
        if (this.alA != null) {
            this.alA.setOnClickListener(onClickListener);
        }
        this.mWK.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.recapp.lego.view.a.b.3
            private float mWR = 0.0f;
            private float mWS = 0.0f;
            private float mWT = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.mWJ = false;
                        this.mWR = motionEvent.getX();
                        this.mWS = motionEvent.getY();
                        this.mWT = 0.0f;
                        break;
                    case 1:
                        b.this.mWJ = 10.0f < this.mWT;
                        if (!b.this.mWJ) {
                            onClickListener.onClick(b.this.iOS);
                            break;
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.mWR;
                        float y = motionEvent.getY() - this.mWS;
                        this.mWT = (float) (Math.sqrt((x * x) + (y * y)) + this.mWT);
                        this.mWR = motionEvent.getX();
                        this.mWS = motionEvent.getY();
                        break;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dEi() {
        return this.kTV.blG() ? dEk() : dEl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dEj() {
        return dEk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ee(View view) {
        return dEk();
    }

    private int dEk() {
        String scheme = this.mUg.getScheme() != null ? this.mUg.getScheme() : this.kTV.eLv;
        return t.i(this.mContext, scheme, this.mUg.getAdvertAppInfo() != null ? d(this.mUg.getAdvertAppInfo()) : scheme, this.mUg.getAdvertAppInfo() != null ? this.mUg.getAdvertAppInfo().extensionInfo : "");
    }

    private int dEl() {
        if (this.kTV == null || this.mUg == null || this.mWP == null) {
            return 0;
        }
        return t.a(this.mContext, this.mUg.getScheme(), this.kTV);
    }

    public void b(AdvertAppInfo advertAppInfo, AdCard adCard) {
        if (advertAppInfo != null && adCard != null) {
            this.kTV = advertAppInfo;
            this.mUg = adCard;
            if (this.kTV.blF()) {
                String str = this.kTV.eLC.buttonText;
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.check_immediately);
                }
                this.aku.setText(str);
                this.mWO.setVisibility(8);
                this.aku.setVisibility(0);
                return;
            }
            this.mWO.setClickable(true);
            this.mWO.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.a.b.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public boolean ce(View view) {
                    com.baidu.tieba.lego.card.a.c.a(com.baidu.tieba.lego.card.a.c.c(b.this.kTV));
                    if (b.this.mContext != null && t.Rv(b.this.mUg.getScheme()) && t.Ru(b.this.kTV.eLw)) {
                        t.i(b.this.mContext, b.this.mUg.getScheme(), b.this.kTV.eLw, b.this.kTV.extensionInfo);
                        return true;
                    }
                    if (b.this.mContext != null && !com.baidu.tieba.a.bJg().bJo() && !z.at((Activity) b.this.mContext)) {
                        l.showToast((Activity) b.this.mContext, R.string.write_external_storage_permission_denied_fun_disable);
                    }
                    return false;
                }
            });
            DownloadData d = d(this.kTV, com.baidu.adp.lib.f.b.toInt(this.kTV.adPosition, -1));
            n(d);
            this.mWO.setData(d);
            this.mWO.setVisibility(0);
            this.aku.setVisibility(8);
            b(adCard, advertAppInfo);
        }
    }

    private void b(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey EK;
        DownloadCacheKey downloadCacheKey;
        if (advertAppInfo != null && advertAppInfo.blE() && adCard != null) {
            String scheme = adCard.getScheme();
            String str = TextUtils.isEmpty(advertAppInfo.eLw) ? advertAppInfo.eLt : advertAppInfo.eLw;
            if (!TextUtils.isEmpty(str)) {
                EK = com.baidu.tieba.ad.download.d.bLy().EJ(str);
            } else {
                EK = com.baidu.tieba.ad.download.d.bLy().EK(scheme);
            }
            if (EK == null) {
                downloadCacheKey = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.eLw);
                com.baidu.tieba.ad.download.d.bLy().a(downloadCacheKey, null);
            } else {
                downloadCacheKey = EK;
            }
            i(downloadCacheKey);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.ggV = downloadCacheKey;
            bLr();
            this.ggW = null;
            AdDownloadData d = com.baidu.tieba.ad.download.d.bLy().d(downloadCacheKey);
            String str = "";
            if (this.mUg != null && this.mUg.getAdvertAppInfo() != null) {
                str = this.mUg.getAdvertAppInfo().page;
                d.setExtInfo(this.mUg.getAdvertAppInfo().extensionInfo);
                d.setDownloadKey(this.mUg.getDownloadKey());
                d.setAppJson(App.toJson(this.mUg.getAdvertAppInfo().eLI).toString());
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mWO, d, str);
            this.ggW = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d != null && d.extra() != null && d.extra().getPercent() > 0) {
                aVar.c((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            this.mWO.a(d.getCurrentState());
            bLq();
        }
    }

    private void n(DownloadData downloadData) {
        if (downloadData != null) {
            downloadData.setStatus(this.mWO.getDownloadStatus());
        }
    }

    DownloadData d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo == null) {
            return new DownloadData();
        }
        DownloadData downloadData = new DownloadData(advertAppInfo.eLw);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.eLu);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.eLt, 0));
        return downloadData;
    }

    private void bLq() {
        if (this.ggV != null && this.ggW != null) {
            com.baidu.tieba.ad.download.d.bLy().a(this.ggV, this.ggW);
        }
    }

    private void bLr() {
        if (this.ggV != null && this.ggW != null) {
            com.baidu.tieba.ad.download.d.bLy().b(this.ggV, this.ggW);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void setDragToExitListener(DragImageView.d dVar) {
        this.fyu = dVar;
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public View dcE() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        bLr();
    }

    protected String d(@NonNull AdvertAppInfo advertAppInfo) {
        return TextUtils.isEmpty(advertAppInfo.eLw) ? advertAppInfo.eLt : advertAppInfo.eLw;
    }
}
