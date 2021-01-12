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
import com.baidu.tbadk.core.util.ao;
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
/* loaded from: classes7.dex */
public class b extends a implements j {
    private TBSpecificationBtn akF;
    public ImageView alK;
    private DragImageView.d fwe;
    private DownloadCacheKey geB;
    private d geC;
    private TbImageView iIW;
    private final View.OnClickListener mClickListener;
    public TextView mKk;
    public TextView mKm;
    public TextView mMU;
    public boolean mMV;
    private UrlDragImageView mMW;
    private RelativeLayout mMX;
    private RelativeLayout mMY;
    private ApkDownloadView mMZ;
    private VideoInfo mNa;
    private RelativeLayout mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mMV = false;
        this.geC = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int dBS;
                String str;
                if (b.this.kLE != null && b.this.mKu != null) {
                    if (!b.this.mMV || view.getId() != R.id.big_image_ad_image) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        if (view.getId() == R.id.image_ad_button) {
                            dBS = b.this.eg(view);
                            str = "button";
                        } else if (view.getId() == R.id.bottom_container) {
                            dBS = b.this.dBT();
                            str = "title";
                        } else {
                            dBS = b.this.dBS();
                            str = b.this.kLE.blo() ? "image" : "video";
                        }
                        hashMap.put("da_area", str);
                        b.this.mMT.d(dBS, hashMap);
                    }
                }
            }
        };
    }

    @Override // com.baidu.tieba.recapp.lego.view.a.a
    protected void cZS() {
        if (this.mPageContext != null) {
            this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.ad_pic_page_layout, (ViewGroup) null);
            this.iIW = (TbImageView) this.mRootView.findViewById(R.id.big_image_ad_image);
            this.akF = (TBSpecificationBtn) this.mRootView.findViewById(R.id.image_ad_button);
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.bb(R.color.CAM_X0302, R.color.CAM_X0101);
            this.akF.setConfig(bVar);
            this.mKk = (TextView) this.mRootView.findViewById(R.id.ad_title);
            this.mMU = (TextView) this.mRootView.findViewById(R.id.ad_brand);
            this.mKm = (TextView) this.mRootView.findViewById(R.id.ad_tag);
            this.mMX = (RelativeLayout) this.mRootView.findViewById(R.id.ad_info_container);
            this.mMY = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_container);
            this.alK = (ImageView) this.mRootView.findViewById(R.id.video_ad_play_icon);
            this.alK.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_play44, ao.getColor(R.color.CAM_X0101), (WebPManager.ResourceStateType) null));
            this.mMZ = (ApkDownloadView) this.mRootView.findViewById(R.id.image_download_button);
            if (this.mPageContext != null) {
                this.mMZ.x(this.mPageContext.getUniqueId());
            }
            this.mMZ.setTextSize(R.dimen.tbds39);
            this.mMZ.setTextColorInitSkin(R.color.CAM_X0101);
            this.mMZ.setBackgroundSkin(R.drawable.pic_page_down_btn_bg);
            this.mMZ.btU();
            dBR();
            af(this.mClickListener);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.a.a
    public void b(AdCard adCard) {
        super.b(adCard);
        if (this.kLE != null && this.kLE.eJr != null) {
            this.mNa = this.mKu.videoInfo;
            dBP();
            b(this.kLE, this.mKu);
            if (!TextUtils.isEmpty(this.kLE.eJr.userName)) {
                this.mMU.setText(this.kLE.eJr.userName);
                if (!TextUtils.isEmpty(this.kLE.eJr.tagName)) {
                    this.mKm.setText(this.kLE.eJr.tagName);
                } else {
                    this.mKm.setText(this.mContext.getString(R.string.advert_label));
                }
            }
            if (!TextUtils.isEmpty(this.kLE.eJr.eJB)) {
                this.mKk.setText(this.kLE.eJr.eJB);
            }
            this.alK.setVisibility(this.kLE.isVideoAd() ? 0 : 8);
            af(this.mClickListener);
        }
    }

    private void dBP() {
        String str;
        this.iIW.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.recapp.lego.view.a.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str2, boolean z) {
                if (z) {
                    b.this.dBQ();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        if (this.kLE.isVideoAd() && this.mNa != null) {
            str = this.mNa.thumbnail_url;
        } else {
            str = this.kLE.eJr.eJD;
        }
        this.iIW.a(str, this.fut ? 30 : 31, 720, 720, false);
        if (this.mMW != null) {
            this.mMW.setIsCdn(this.fut);
            this.mMW.setUrl(str, true);
        }
    }

    public void dBQ() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams layoutParams = this.iIW.getLayoutParams();
            double loadedHeight = this.iIW.getLoadedHeight() / this.iIW.getLoadedWidth();
            if (loadedHeight > 1.0d) {
                layoutParams.height = width;
                layoutParams.width = (int) (width / loadedHeight);
            } else {
                layoutParams.height = (int) (loadedHeight * width);
                layoutParams.width = width;
            }
            this.iIW.setLayoutParams(layoutParams);
        }
    }

    public void dBR() {
        this.iIW.setVisibility(4);
        this.mMW = new UrlDragImageView(this.mContext);
        this.mMW.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mMW.setIsCanDrag(true);
        this.mMW.setCanScale(false);
        this.mMW.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.recapp.lego.view.a.b.2
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.fwe != null) {
                    b.this.fwe.onDragStart();
                }
                b.this.mKk.setVisibility(8);
                b.this.mMU.setVisibility(8);
                b.this.mKm.setVisibility(8);
                b.this.mMX.setVisibility(8);
                b.this.alK.setVisibility(8);
                b.this.akF.setVisibility(8);
                b.this.mMZ.setVisibility(8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragEnd() {
                if (b.this.fwe != null) {
                    b.this.fwe.onDragEnd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void bFG() {
                if (b.this.fwe != null) {
                    b.this.fwe.bFG();
                }
                b.this.mKk.setVisibility(0);
                b.this.mMU.setVisibility(0);
                b.this.mKm.setVisibility(0);
                b.this.mMX.setVisibility(0);
                if (b.this.kLE != null) {
                    b.this.alK.setVisibility(b.this.kLE.isVideoAd() ? 0 : 8);
                    if (b.this.kLE.bln()) {
                        b.this.akF.setVisibility(0);
                    } else {
                        b.this.mMZ.setVisibility(0);
                    }
                }
            }
        });
        this.mRootView.addView(this.mMW, 0);
    }

    public void af(final View.OnClickListener onClickListener) {
        if (this.akF != null) {
            this.akF.setOnClickListener(onClickListener);
        }
        if (this.iIW != null) {
            this.iIW.setOnClickListener(onClickListener);
        }
        if (this.mMY != null) {
            this.mMY.setOnClickListener(onClickListener);
        }
        if (this.alK != null) {
            this.alK.setOnClickListener(onClickListener);
        }
        this.mMW.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.recapp.lego.view.a.b.3
            private float mNc = 0.0f;
            private float mNd = 0.0f;
            private float mNe = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.mMV = false;
                        this.mNc = motionEvent.getX();
                        this.mNd = motionEvent.getY();
                        this.mNe = 0.0f;
                        break;
                    case 1:
                        b.this.mMV = 10.0f < this.mNe;
                        if (!b.this.mMV) {
                            onClickListener.onClick(b.this.iIW);
                            break;
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.mNc;
                        float y = motionEvent.getY() - this.mNd;
                        this.mNe = (float) (Math.sqrt((x * x) + (y * y)) + this.mNe);
                        this.mNc = motionEvent.getX();
                        this.mNd = motionEvent.getY();
                        break;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dBS() {
        return this.kLE.blo() ? dBU() : dBV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dBT() {
        return dBU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int eg(View view) {
        return dBU();
    }

    private int dBU() {
        String scheme = this.mKu.getScheme() != null ? this.mKu.getScheme() : this.kLE.eJk;
        return s.x(this.mContext, scheme, this.mKu.getAdvertAppInfo() != null ? d(this.mKu.getAdvertAppInfo()) : scheme);
    }

    private int dBV() {
        if (this.kLE == null || this.mKu == null || this.mNa == null) {
            return 0;
        }
        return s.a(this.mContext, this.mKu.getScheme(), this.kLE);
    }

    public void b(AdvertAppInfo advertAppInfo, AdCard adCard) {
        if (advertAppInfo != null && adCard != null) {
            this.kLE = advertAppInfo;
            this.mKu = adCard;
            if (this.kLE.bln()) {
                String str = this.kLE.eJr.buttonText;
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.check_immediately);
                }
                this.akF.setText(str);
                this.mMZ.setVisibility(8);
                this.akF.setVisibility(0);
                return;
            }
            this.mMZ.setClickable(true);
            this.mMZ.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.a.b.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public boolean ci(View view) {
                    com.baidu.tieba.lego.card.a.c.a(com.baidu.tieba.lego.card.a.c.c(b.this.kLE));
                    if (b.this.mContext != null && s.Qq(b.this.mKu.getScheme()) && s.isInstalledPackage(b.this.mContext, b.this.kLE.eJl)) {
                        s.x(b.this.mContext, b.this.mKu.getScheme(), b.this.kLE.eJl);
                        return true;
                    }
                    if (b.this.mContext != null && !z.aA((Activity) b.this.mContext)) {
                        l.showToast((Activity) b.this.mContext, R.string.write_external_storage_permission_denied_fun_disable);
                    }
                    return false;
                }
            });
            DownloadData d = d(this.kLE, com.baidu.adp.lib.f.b.toInt(this.kLE.adPosition, -1));
            o(d);
            this.mMZ.setData(d);
            this.mMZ.setVisibility(0);
            this.akF.setVisibility(8);
            b(adCard, advertAppInfo);
        }
    }

    private void b(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey En;
        DownloadCacheKey downloadCacheKey;
        if (advertAppInfo != null && advertAppInfo.blm() && adCard != null) {
            String scheme = adCard.getScheme();
            String str = TextUtils.isEmpty(advertAppInfo.eJl) ? advertAppInfo.eJi : advertAppInfo.eJl;
            if (!TextUtils.isEmpty(str)) {
                En = com.baidu.tieba.ad.download.d.bKZ().Em(str);
            } else {
                En = com.baidu.tieba.ad.download.d.bKZ().En(scheme);
            }
            if (En == null) {
                downloadCacheKey = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.eJl);
                com.baidu.tieba.ad.download.d.bKZ().a(downloadCacheKey, null);
            } else {
                downloadCacheKey = En;
            }
            i(downloadCacheKey);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.geB = downloadCacheKey;
            bKS();
            this.geC = null;
            AdDownloadData d = com.baidu.tieba.ad.download.d.bKZ().d(downloadCacheKey);
            this.mMZ.a(d.getCurrentState());
            String str = "";
            if (this.mKu != null && this.mKu.getAdvertAppInfo() != null) {
                str = this.mKu.getAdvertAppInfo().page;
                d.setExtInfo(this.mKu.getAdvertAppInfo().extensionInfo);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mMZ, d, str);
            this.geC = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d != null && d.extra() != null && d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bKR();
        }
    }

    private void o(DownloadData downloadData) {
        if (downloadData != null) {
            downloadData.setStatus(this.mMZ.getDownloadStatus());
        }
    }

    DownloadData d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo == null) {
            return new DownloadData();
        }
        DownloadData downloadData = new DownloadData(advertAppInfo.eJl);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.eJj);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.eJi, 0));
        return downloadData;
    }

    private void bKR() {
        if (this.geB != null && this.geC != null) {
            com.baidu.tieba.ad.download.d.bKZ().a(this.geB, this.geC);
        }
    }

    private void bKS() {
        if (this.geB != null && this.geC != null) {
            com.baidu.tieba.ad.download.d.bKZ().b(this.geB, this.geC);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void setDragToExitListener(DragImageView.d dVar) {
        this.fwe = dVar;
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public View daz() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        bKS();
    }

    protected String d(@NonNull AdvertAppInfo advertAppInfo) {
        return TextUtils.isEmpty(advertAppInfo.eJl) ? advertAppInfo.eJi : advertAppInfo.eJl;
    }
}
