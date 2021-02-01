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
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.tieba.tbadkCore.z;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes8.dex */
public class b extends a implements j {
    private TBSpecificationBtn aku;
    public ImageView alA;
    private DragImageView.d fyu;
    private DownloadCacheKey ggP;
    private d ggQ;
    private TbImageView iOE;
    private final View.OnClickListener mClickListener;
    private RelativeLayout mRootView;
    public TextView mTv;
    public TextView mTx;
    public TextView mWi;
    public boolean mWj;
    private UrlDragImageView mWk;
    private RelativeLayout mWl;
    private RelativeLayout mWm;
    private ApkDownloadView mWn;
    private VideoInfo mWo;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mWj = false;
        this.ggQ = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int dEa;
                String str;
                if (b.this.kTH != null && b.this.mTF != null) {
                    if (!b.this.mWj || view.getId() != R.id.big_image_ad_image) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        if (view.getId() == R.id.image_ad_button) {
                            dEa = b.this.ee(view);
                            str = "button";
                        } else if (view.getId() == R.id.bottom_container) {
                            dEa = b.this.dEb();
                            str = "title";
                        } else {
                            dEa = b.this.dEa();
                            str = b.this.kTH.blG() ? "image" : "video";
                        }
                        hashMap.put("da_area", str);
                        b.this.mWh.d(dEa, hashMap);
                    }
                }
            }
        };
    }

    @Override // com.baidu.tieba.recapp.lego.view.a.a
    protected void dbQ() {
        if (this.mPageContext != null) {
            this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.ad_pic_page_layout, (ViewGroup) null);
            this.iOE = (TbImageView) this.mRootView.findViewById(R.id.big_image_ad_image);
            this.aku = (TBSpecificationBtn) this.mRootView.findViewById(R.id.image_ad_button);
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.aY(R.color.CAM_X0302, R.color.CAM_X0101);
            this.aku.setConfig(bVar);
            this.mTv = (TextView) this.mRootView.findViewById(R.id.ad_title);
            this.mWi = (TextView) this.mRootView.findViewById(R.id.ad_brand);
            this.mTx = (TextView) this.mRootView.findViewById(R.id.ad_tag);
            this.mWl = (RelativeLayout) this.mRootView.findViewById(R.id.ad_info_container);
            this.mWm = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_container);
            this.alA = (ImageView) this.mRootView.findViewById(R.id.video_ad_play_icon);
            this.alA.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_play44, ap.getColor(R.color.CAM_X0101), (WebPManager.ResourceStateType) null));
            this.mWn = (ApkDownloadView) this.mRootView.findViewById(R.id.image_download_button);
            if (this.mPageContext != null) {
                this.mWn.y(this.mPageContext.getUniqueId());
            }
            this.mWn.setTextSize(R.dimen.tbds39);
            this.mWn.setTextColorInitSkin(R.color.CAM_X0101);
            this.mWn.setBackgroundSkin(R.drawable.pic_page_down_btn_bg);
            this.mWn.buo();
            dDZ();
            af(this.mClickListener);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.a.a
    public void b(AdCard adCard) {
        super.b(adCard);
        if (this.kTH != null && this.kTH.eLD != null) {
            this.mWo = this.mTF.videoInfo;
            dDX();
            b(this.kTH, this.mTF);
            if (!TextUtils.isEmpty(this.kTH.eLD.userName)) {
                this.mWi.setText(this.kTH.eLD.userName);
                if (!TextUtils.isEmpty(this.kTH.eLD.tagName)) {
                    this.mTx.setText(this.kTH.eLD.tagName);
                } else {
                    this.mTx.setText(this.mContext.getString(R.string.advert_label));
                }
            }
            if (!TextUtils.isEmpty(this.kTH.eLD.eLN)) {
                this.mTv.setText(this.kTH.eLD.eLN);
            }
            this.alA.setVisibility(this.kTH.isVideoAd() ? 0 : 8);
            af(this.mClickListener);
        }
    }

    private void dDX() {
        String str;
        this.iOE.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.recapp.lego.view.a.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str2, boolean z) {
                if (z) {
                    b.this.dDY();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        if (this.kTH.isVideoAd() && this.mWo != null) {
            str = this.mWo.thumbnail_url;
        } else {
            str = this.kTH.eLD.eLP;
        }
        this.iOE.a(str, this.fwJ ? 30 : 31, 720, 720, false);
        if (this.mWk != null) {
            this.mWk.setIsCdn(this.fwJ);
            this.mWk.setUrl(str, true);
        }
    }

    public void dDY() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams layoutParams = this.iOE.getLayoutParams();
            double loadedHeight = this.iOE.getLoadedHeight() / this.iOE.getLoadedWidth();
            if (loadedHeight > 1.0d) {
                layoutParams.height = width;
                layoutParams.width = (int) (width / loadedHeight);
            } else {
                layoutParams.height = (int) (loadedHeight * width);
                layoutParams.width = width;
            }
            this.iOE.setLayoutParams(layoutParams);
        }
    }

    public void dDZ() {
        this.iOE.setVisibility(4);
        this.mWk = new UrlDragImageView(this.mContext);
        this.mWk.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mWk.setIsCanDrag(true);
        this.mWk.setCanScale(false);
        this.mWk.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.recapp.lego.view.a.b.2
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.fyu != null) {
                    b.this.fyu.onDragStart();
                }
                b.this.mTv.setVisibility(8);
                b.this.mWi.setVisibility(8);
                b.this.mTx.setVisibility(8);
                b.this.mWl.setVisibility(8);
                b.this.alA.setVisibility(8);
                b.this.aku.setVisibility(8);
                b.this.mWn.setVisibility(8);
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
                b.this.mTv.setVisibility(0);
                b.this.mWi.setVisibility(0);
                b.this.mTx.setVisibility(0);
                b.this.mWl.setVisibility(0);
                if (b.this.kTH != null) {
                    b.this.alA.setVisibility(b.this.kTH.isVideoAd() ? 0 : 8);
                    if (b.this.kTH.blF()) {
                        b.this.aku.setVisibility(0);
                    } else {
                        b.this.mWn.setVisibility(0);
                    }
                }
            }
        });
        this.mRootView.addView(this.mWk, 0);
    }

    public void af(final View.OnClickListener onClickListener) {
        if (this.aku != null) {
            this.aku.setOnClickListener(onClickListener);
        }
        if (this.iOE != null) {
            this.iOE.setOnClickListener(onClickListener);
        }
        if (this.mWm != null) {
            this.mWm.setOnClickListener(onClickListener);
        }
        if (this.alA != null) {
            this.alA.setOnClickListener(onClickListener);
        }
        this.mWk.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.recapp.lego.view.a.b.3
            private float mWq = 0.0f;
            private float mWr = 0.0f;
            private float mWs = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.mWj = false;
                        this.mWq = motionEvent.getX();
                        this.mWr = motionEvent.getY();
                        this.mWs = 0.0f;
                        break;
                    case 1:
                        b.this.mWj = 10.0f < this.mWs;
                        if (!b.this.mWj) {
                            onClickListener.onClick(b.this.iOE);
                            break;
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.mWq;
                        float y = motionEvent.getY() - this.mWr;
                        this.mWs = (float) (Math.sqrt((x * x) + (y * y)) + this.mWs);
                        this.mWq = motionEvent.getX();
                        this.mWr = motionEvent.getY();
                        break;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dEa() {
        return this.kTH.blG() ? dEc() : dEd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dEb() {
        return dEc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ee(View view) {
        return dEc();
    }

    private int dEc() {
        String scheme = this.mTF.getScheme() != null ? this.mTF.getScheme() : this.kTH.eLw;
        return s.x(this.mContext, scheme, this.mTF.getAdvertAppInfo() != null ? d(this.mTF.getAdvertAppInfo()) : scheme);
    }

    private int dEd() {
        if (this.kTH == null || this.mTF == null || this.mWo == null) {
            return 0;
        }
        return s.a(this.mContext, this.mTF.getScheme(), this.kTH);
    }

    public void b(AdvertAppInfo advertAppInfo, AdCard adCard) {
        if (advertAppInfo != null && adCard != null) {
            this.kTH = advertAppInfo;
            this.mTF = adCard;
            if (this.kTH.blF()) {
                String str = this.kTH.eLD.buttonText;
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.check_immediately);
                }
                this.aku.setText(str);
                this.mWn.setVisibility(8);
                this.aku.setVisibility(0);
                return;
            }
            this.mWn.setClickable(true);
            this.mWn.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.a.b.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public boolean ce(View view) {
                    com.baidu.tieba.lego.card.a.c.a(com.baidu.tieba.lego.card.a.c.c(b.this.kTH));
                    if (b.this.mContext != null && s.Rm(b.this.mTF.getScheme()) && s.isInstalledPackage(b.this.mContext, b.this.kTH.eLx)) {
                        s.x(b.this.mContext, b.this.mTF.getScheme(), b.this.kTH.eLx);
                        return true;
                    }
                    if (b.this.mContext != null && !z.at((Activity) b.this.mContext)) {
                        l.showToast((Activity) b.this.mContext, R.string.write_external_storage_permission_denied_fun_disable);
                    }
                    return false;
                }
            });
            DownloadData d = d(this.kTH, com.baidu.adp.lib.f.b.toInt(this.kTH.adPosition, -1));
            o(d);
            this.mWn.setData(d);
            this.mWn.setVisibility(0);
            this.aku.setVisibility(8);
            b(adCard, advertAppInfo);
        }
    }

    private void b(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey EL;
        DownloadCacheKey downloadCacheKey;
        if (advertAppInfo != null && advertAppInfo.blE() && adCard != null) {
            String scheme = adCard.getScheme();
            String str = TextUtils.isEmpty(advertAppInfo.eLx) ? advertAppInfo.eLu : advertAppInfo.eLx;
            if (!TextUtils.isEmpty(str)) {
                EL = com.baidu.tieba.ad.download.d.bLt().EK(str);
            } else {
                EL = com.baidu.tieba.ad.download.d.bLt().EL(scheme);
            }
            if (EL == null) {
                downloadCacheKey = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.eLx);
                com.baidu.tieba.ad.download.d.bLt().a(downloadCacheKey, null);
            } else {
                downloadCacheKey = EL;
            }
            i(downloadCacheKey);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.ggP = downloadCacheKey;
            bLm();
            this.ggQ = null;
            AdDownloadData d = com.baidu.tieba.ad.download.d.bLt().d(downloadCacheKey);
            this.mWn.a(d.getCurrentState());
            String str = "";
            if (this.mTF != null && this.mTF.getAdvertAppInfo() != null) {
                str = this.mTF.getAdvertAppInfo().page;
                d.setExtInfo(this.mTF.getAdvertAppInfo().extensionInfo);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mWn, d, str);
            this.ggQ = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d != null && d.extra() != null && d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bLl();
        }
    }

    private void o(DownloadData downloadData) {
        if (downloadData != null) {
            downloadData.setStatus(this.mWn.getDownloadStatus());
        }
    }

    DownloadData d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo == null) {
            return new DownloadData();
        }
        DownloadData downloadData = new DownloadData(advertAppInfo.eLx);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.eLv);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.eLu, 0));
        return downloadData;
    }

    private void bLl() {
        if (this.ggP != null && this.ggQ != null) {
            com.baidu.tieba.ad.download.d.bLt().a(this.ggP, this.ggQ);
        }
    }

    private void bLm() {
        if (this.ggP != null && this.ggQ != null) {
            com.baidu.tieba.ad.download.d.bLt().b(this.ggP, this.ggQ);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void setDragToExitListener(DragImageView.d dVar) {
        this.fyu = dVar;
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public View dcx() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        bLm();
    }

    protected String d(@NonNull AdvertAppInfo advertAppInfo) {
        return TextUtils.isEmpty(advertAppInfo.eLx) ? advertAppInfo.eLu : advertAppInfo.eLx;
    }
}
