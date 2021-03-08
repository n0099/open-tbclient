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
/* loaded from: classes7.dex */
public class b extends a implements j {
    private TBSpecificationBtn alN;
    public ImageView amS;
    private DragImageView.d fzT;
    private d giA;
    private DownloadCacheKey giz;
    private TbImageView iQB;
    private final View.OnClickListener mClickListener;
    private RelativeLayout mRootView;
    public TextView mWg;
    public TextView mWi;
    public TextView mYT;
    public boolean mYU;
    private UrlDragImageView mYV;
    private RelativeLayout mYW;
    private RelativeLayout mYX;
    private ApkDownloadView mYY;
    private VideoInfo mYZ;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mYU = false;
        this.giA = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int dEq;
                String str;
                if (b.this.kVX != null && b.this.mWq != null) {
                    if (!b.this.mYU || view.getId() != R.id.big_image_ad_image) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        if (view.getId() == R.id.image_ad_button) {
                            dEq = b.this.ee(view);
                            str = "button";
                        } else if (view.getId() == R.id.bottom_container) {
                            dEq = b.this.dEr();
                            str = "title";
                        } else {
                            dEq = b.this.dEq();
                            str = b.this.kVX.blI() ? "image" : "video";
                        }
                        hashMap.put("da_area", str);
                        b.this.mYS.d(dEq, hashMap);
                    }
                }
            }
        };
    }

    @Override // com.baidu.tieba.recapp.lego.view.a.a
    protected void dcg() {
        if (this.mPageContext != null) {
            this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.ad_pic_page_layout, (ViewGroup) null);
            this.iQB = (TbImageView) this.mRootView.findViewById(R.id.big_image_ad_image);
            this.alN = (TBSpecificationBtn) this.mRootView.findViewById(R.id.image_ad_button);
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.aY(R.color.CAM_X0302, R.color.CAM_X0101);
            this.alN.setConfig(bVar);
            this.mWg = (TextView) this.mRootView.findViewById(R.id.ad_title);
            this.mYT = (TextView) this.mRootView.findViewById(R.id.ad_brand);
            this.mWi = (TextView) this.mRootView.findViewById(R.id.ad_tag);
            this.mYW = (RelativeLayout) this.mRootView.findViewById(R.id.ad_info_container);
            this.mYX = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_container);
            this.amS = (ImageView) this.mRootView.findViewById(R.id.video_ad_play_icon);
            this.amS.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_play44, ap.getColor(R.color.CAM_X0101), (WebPManager.ResourceStateType) null));
            this.mYY = (ApkDownloadView) this.mRootView.findViewById(R.id.image_download_button);
            if (this.mPageContext != null) {
                this.mYY.z(this.mPageContext.getUniqueId());
            }
            this.mYY.setTextSize(R.dimen.tbds39);
            this.mYY.setTextColorInitSkin(R.color.CAM_X0101);
            this.mYY.setBackgroundSkin(R.drawable.pic_page_down_btn_bg);
            this.mYY.bur();
            dEp();
            ag(this.mClickListener);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.a.a
    public void b(AdCard adCard) {
        super.b(adCard);
        if (this.kVX != null && this.kVX.eNd != null) {
            this.mYZ = this.mWq.videoInfo;
            dEn();
            b(this.kVX, this.mWq);
            if (!TextUtils.isEmpty(this.kVX.eNd.userName)) {
                this.mYT.setText(this.kVX.eNd.userName);
                if (!TextUtils.isEmpty(this.kVX.eNd.tagName)) {
                    this.mWi.setText(this.kVX.eNd.tagName);
                } else {
                    this.mWi.setText(this.mContext.getString(R.string.advert_label));
                }
            }
            if (!TextUtils.isEmpty(this.kVX.eNd.eNo)) {
                this.mWg.setText(this.kVX.eNd.eNo);
            }
            this.amS.setVisibility(this.kVX.isVideoAd() ? 0 : 8);
            ag(this.mClickListener);
        }
    }

    private void dEn() {
        String str;
        this.iQB.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.recapp.lego.view.a.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str2, boolean z) {
                if (z) {
                    b.this.dEo();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        if (this.kVX.isVideoAd() && this.mYZ != null) {
            str = this.mYZ.thumbnail_url;
        } else {
            str = this.kVX.eNd.eNq;
        }
        this.iQB.a(str, this.fyi ? 30 : 31, 720, 720, false);
        if (this.mYV != null) {
            this.mYV.setIsCdn(this.fyi);
            this.mYV.setUrl(str, true);
        }
    }

    public void dEo() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams layoutParams = this.iQB.getLayoutParams();
            double loadedHeight = this.iQB.getLoadedHeight() / this.iQB.getLoadedWidth();
            if (loadedHeight > 1.0d) {
                layoutParams.height = width;
                layoutParams.width = (int) (width / loadedHeight);
            } else {
                layoutParams.height = (int) (loadedHeight * width);
                layoutParams.width = width;
            }
            this.iQB.setLayoutParams(layoutParams);
        }
    }

    public void dEp() {
        this.iQB.setVisibility(4);
        this.mYV = new UrlDragImageView(this.mContext);
        this.mYV.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mYV.setIsCanDrag(true);
        this.mYV.setCanScale(false);
        this.mYV.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.recapp.lego.view.a.b.2
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.fzT != null) {
                    b.this.fzT.onDragStart();
                }
                b.this.mWg.setVisibility(8);
                b.this.mYT.setVisibility(8);
                b.this.mWi.setVisibility(8);
                b.this.mYW.setVisibility(8);
                b.this.amS.setVisibility(8);
                b.this.alN.setVisibility(8);
                b.this.mYY.setVisibility(8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragEnd() {
                if (b.this.fzT != null) {
                    b.this.fzT.onDragEnd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void bGe() {
                if (b.this.fzT != null) {
                    b.this.fzT.bGe();
                }
                b.this.mWg.setVisibility(0);
                b.this.mYT.setVisibility(0);
                b.this.mWi.setVisibility(0);
                b.this.mYW.setVisibility(0);
                if (b.this.kVX != null) {
                    b.this.amS.setVisibility(b.this.kVX.isVideoAd() ? 0 : 8);
                    if (b.this.kVX.blH()) {
                        b.this.alN.setVisibility(0);
                    } else {
                        b.this.mYY.setVisibility(0);
                    }
                }
            }
        });
        this.mRootView.addView(this.mYV, 0);
    }

    public void ag(final View.OnClickListener onClickListener) {
        if (this.alN != null) {
            this.alN.setOnClickListener(onClickListener);
        }
        if (this.iQB != null) {
            this.iQB.setOnClickListener(onClickListener);
        }
        if (this.mYX != null) {
            this.mYX.setOnClickListener(onClickListener);
        }
        if (this.amS != null) {
            this.amS.setOnClickListener(onClickListener);
        }
        this.mYV.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.recapp.lego.view.a.b.3
            private float mZb = 0.0f;
            private float mZc = 0.0f;
            private float mZd = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.mYU = false;
                        this.mZb = motionEvent.getX();
                        this.mZc = motionEvent.getY();
                        this.mZd = 0.0f;
                        break;
                    case 1:
                        b.this.mYU = 10.0f < this.mZd;
                        if (!b.this.mYU) {
                            onClickListener.onClick(b.this.iQB);
                            break;
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.mZb;
                        float y = motionEvent.getY() - this.mZc;
                        this.mZd = (float) (Math.sqrt((x * x) + (y * y)) + this.mZd);
                        this.mZb = motionEvent.getX();
                        this.mZc = motionEvent.getY();
                        break;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dEq() {
        return this.kVX.blI() ? dEs() : dEt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dEr() {
        return dEs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ee(View view) {
        return dEs();
    }

    private int dEs() {
        String scheme = this.mWq.getScheme() != null ? this.mWq.getScheme() : this.kVX.eMW;
        return t.i(this.mContext, scheme, this.mWq.getAdvertAppInfo() != null ? d(this.mWq.getAdvertAppInfo()) : scheme, this.mWq.getAdvertAppInfo() != null ? this.mWq.getAdvertAppInfo().extensionInfo : "");
    }

    private int dEt() {
        if (this.kVX == null || this.mWq == null || this.mYZ == null) {
            return 0;
        }
        return t.a(this.mContext, this.mWq.getScheme(), this.kVX);
    }

    public void b(AdvertAppInfo advertAppInfo, AdCard adCard) {
        if (advertAppInfo != null && adCard != null) {
            this.kVX = advertAppInfo;
            this.mWq = adCard;
            if (this.kVX.blH()) {
                String str = this.kVX.eNd.buttonText;
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.check_immediately);
                }
                this.alN.setText(str);
                this.mYY.setVisibility(8);
                this.alN.setVisibility(0);
                return;
            }
            this.mYY.setClickable(true);
            this.mYY.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.a.b.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public boolean ce(View view) {
                    com.baidu.tieba.lego.card.a.c.a(com.baidu.tieba.lego.card.a.c.c(b.this.kVX));
                    if (b.this.mContext != null && t.RB(b.this.mWq.getScheme()) && t.RA(b.this.kVX.eMX)) {
                        t.i(b.this.mContext, b.this.mWq.getScheme(), b.this.kVX.eMX, b.this.kVX.extensionInfo);
                        return true;
                    }
                    if (b.this.mContext != null && !com.baidu.tieba.a.bJk().bJs() && !z.au((Activity) b.this.mContext)) {
                        l.showToast((Activity) b.this.mContext, R.string.write_external_storage_permission_denied_fun_disable);
                    }
                    return false;
                }
            });
            DownloadData d = d(this.kVX, com.baidu.adp.lib.f.b.toInt(this.kVX.adPosition, -1));
            n(d);
            this.mYY.setData(d);
            this.mYY.setVisibility(0);
            this.alN.setVisibility(8);
            b(adCard, advertAppInfo);
        }
    }

    private void b(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey ER;
        DownloadCacheKey downloadCacheKey;
        if (advertAppInfo != null && advertAppInfo.blG() && adCard != null) {
            String scheme = adCard.getScheme();
            String str = TextUtils.isEmpty(advertAppInfo.eMX) ? advertAppInfo.eMU : advertAppInfo.eMX;
            if (!TextUtils.isEmpty(str)) {
                ER = com.baidu.tieba.ad.download.d.bLC().EQ(str);
            } else {
                ER = com.baidu.tieba.ad.download.d.bLC().ER(scheme);
            }
            if (ER == null) {
                downloadCacheKey = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.eMX);
                com.baidu.tieba.ad.download.d.bLC().a(downloadCacheKey, null);
            } else {
                downloadCacheKey = ER;
            }
            i(downloadCacheKey);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.giz = downloadCacheKey;
            bLv();
            this.giA = null;
            AdDownloadData d = com.baidu.tieba.ad.download.d.bLC().d(downloadCacheKey);
            String str = "";
            if (this.mWq != null && this.mWq.getAdvertAppInfo() != null) {
                str = this.mWq.getAdvertAppInfo().page;
                d.setExtInfo(this.mWq.getAdvertAppInfo().extensionInfo);
                d.setDownloadKey(this.mWq.getDownloadKey());
                d.setAppJson(App.toJson(this.mWq.getAdvertAppInfo().eNj).toString());
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mYY, d, str);
            this.giA = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d != null && d.extra() != null && d.extra().getPercent() > 0) {
                aVar.c((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            this.mYY.a(d.getCurrentState());
            bLu();
        }
    }

    private void n(DownloadData downloadData) {
        if (downloadData != null) {
            downloadData.setStatus(this.mYY.getDownloadStatus());
        }
    }

    DownloadData d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo == null) {
            return new DownloadData();
        }
        DownloadData downloadData = new DownloadData(advertAppInfo.eMX);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.eMV);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.eMU, 0));
        return downloadData;
    }

    private void bLu() {
        if (this.giz != null && this.giA != null) {
            com.baidu.tieba.ad.download.d.bLC().a(this.giz, this.giA);
        }
    }

    private void bLv() {
        if (this.giz != null && this.giA != null) {
            com.baidu.tieba.ad.download.d.bLC().b(this.giz, this.giA);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void setDragToExitListener(DragImageView.d dVar) {
        this.fzT = dVar;
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public View dcN() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        bLv();
    }

    protected String d(@NonNull AdvertAppInfo advertAppInfo) {
        return TextUtils.isEmpty(advertAppInfo.eMX) ? advertAppInfo.eMU : advertAppInfo.eMX;
    }
}
