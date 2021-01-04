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
/* loaded from: classes8.dex */
public class b extends a implements j {
    private TBSpecificationBtn alx;
    public ImageView amB;
    private DragImageView.d fAM;
    private DownloadCacheKey gjj;
    private d gjk;
    private TbImageView iND;
    private final View.OnClickListener mClickListener;
    public TextView mOP;
    public TextView mOR;
    public TextView mRB;
    public boolean mRC;
    private UrlDragImageView mRD;
    private RelativeLayout mRE;
    private RelativeLayout mRF;
    private ApkDownloadView mRG;
    private VideoInfo mRH;
    private RelativeLayout mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRC = false;
        this.gjk = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int dFJ;
                String str;
                if (b.this.kQj != null && b.this.mOZ != null) {
                    if (!b.this.mRC || view.getId() != R.id.big_image_ad_image) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        if (view.getId() == R.id.image_ad_button) {
                            dFJ = b.this.eg(view);
                            str = "button";
                        } else if (view.getId() == R.id.bottom_container) {
                            dFJ = b.this.dFK();
                            str = "title";
                        } else {
                            dFJ = b.this.dFJ();
                            str = b.this.kQj.bph() ? "image" : "video";
                        }
                        hashMap.put("da_area", str);
                        b.this.mRA.d(dFJ, hashMap);
                    }
                }
            }
        };
    }

    @Override // com.baidu.tieba.recapp.lego.view.a.a
    protected void ddJ() {
        if (this.mPageContext != null) {
            this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.ad_pic_page_layout, (ViewGroup) null);
            this.iND = (TbImageView) this.mRootView.findViewById(R.id.big_image_ad_image);
            this.alx = (TBSpecificationBtn) this.mRootView.findViewById(R.id.image_ad_button);
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.bb(R.color.CAM_X0302, R.color.CAM_X0101);
            this.alx.setConfig(bVar);
            this.mOP = (TextView) this.mRootView.findViewById(R.id.ad_title);
            this.mRB = (TextView) this.mRootView.findViewById(R.id.ad_brand);
            this.mOR = (TextView) this.mRootView.findViewById(R.id.ad_tag);
            this.mRE = (RelativeLayout) this.mRootView.findViewById(R.id.ad_info_container);
            this.mRF = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_container);
            this.amB = (ImageView) this.mRootView.findViewById(R.id.video_ad_play_icon);
            this.amB.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_play44, ao.getColor(R.color.CAM_X0101), (WebPManager.ResourceStateType) null));
            this.mRG = (ApkDownloadView) this.mRootView.findViewById(R.id.image_download_button);
            if (this.mPageContext != null) {
                this.mRG.x(this.mPageContext.getUniqueId());
            }
            this.mRG.setTextSize(R.dimen.tbds39);
            this.mRG.setTextColorInitSkin(R.color.CAM_X0101);
            this.mRG.setBackgroundSkin(R.drawable.pic_page_down_btn_bg);
            this.mRG.bxN();
            dFI();
            af(this.mClickListener);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.a.a
    public void b(AdCard adCard) {
        super.b(adCard);
        if (this.kQj != null && this.kQj.eOc != null) {
            this.mRH = this.mOZ.videoInfo;
            dFG();
            b(this.kQj, this.mOZ);
            if (!TextUtils.isEmpty(this.kQj.eOc.userName)) {
                this.mRB.setText(this.kQj.eOc.userName);
                if (!TextUtils.isEmpty(this.kQj.eOc.tagName)) {
                    this.mOR.setText(this.kQj.eOc.tagName);
                } else {
                    this.mOR.setText(this.mContext.getString(R.string.advert_label));
                }
            }
            if (!TextUtils.isEmpty(this.kQj.eOc.eOm)) {
                this.mOP.setText(this.kQj.eOc.eOm);
            }
            this.amB.setVisibility(this.kQj.isVideoAd() ? 0 : 8);
            af(this.mClickListener);
        }
    }

    private void dFG() {
        String str;
        this.iND.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.recapp.lego.view.a.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str2, boolean z) {
                if (z) {
                    b.this.dFH();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        if (this.kQj.isVideoAd() && this.mRH != null) {
            str = this.mRH.thumbnail_url;
        } else {
            str = this.kQj.eOc.eOo;
        }
        this.iND.a(str, this.fzb ? 30 : 31, 720, 720, false);
        if (this.mRD != null) {
            this.mRD.setIsCdn(this.fzb);
            this.mRD.setUrl(str, true);
        }
    }

    public void dFH() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams layoutParams = this.iND.getLayoutParams();
            double loadedHeight = this.iND.getLoadedHeight() / this.iND.getLoadedWidth();
            if (loadedHeight > 1.0d) {
                layoutParams.height = width;
                layoutParams.width = (int) (width / loadedHeight);
            } else {
                layoutParams.height = (int) (loadedHeight * width);
                layoutParams.width = width;
            }
            this.iND.setLayoutParams(layoutParams);
        }
    }

    public void dFI() {
        this.iND.setVisibility(4);
        this.mRD = new UrlDragImageView(this.mContext);
        this.mRD.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRD.setIsCanDrag(true);
        this.mRD.setCanScale(false);
        this.mRD.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.recapp.lego.view.a.b.2
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.fAM != null) {
                    b.this.fAM.onDragStart();
                }
                b.this.mOP.setVisibility(8);
                b.this.mRB.setVisibility(8);
                b.this.mOR.setVisibility(8);
                b.this.mRE.setVisibility(8);
                b.this.amB.setVisibility(8);
                b.this.alx.setVisibility(8);
                b.this.mRG.setVisibility(8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragEnd() {
                if (b.this.fAM != null) {
                    b.this.fAM.onDragEnd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void bJx() {
                if (b.this.fAM != null) {
                    b.this.fAM.bJx();
                }
                b.this.mOP.setVisibility(0);
                b.this.mRB.setVisibility(0);
                b.this.mOR.setVisibility(0);
                b.this.mRE.setVisibility(0);
                if (b.this.kQj != null) {
                    b.this.amB.setVisibility(b.this.kQj.isVideoAd() ? 0 : 8);
                    if (b.this.kQj.bpg()) {
                        b.this.alx.setVisibility(0);
                    } else {
                        b.this.mRG.setVisibility(0);
                    }
                }
            }
        });
        this.mRootView.addView(this.mRD, 0);
    }

    public void af(final View.OnClickListener onClickListener) {
        if (this.alx != null) {
            this.alx.setOnClickListener(onClickListener);
        }
        if (this.iND != null) {
            this.iND.setOnClickListener(onClickListener);
        }
        if (this.mRF != null) {
            this.mRF.setOnClickListener(onClickListener);
        }
        if (this.amB != null) {
            this.amB.setOnClickListener(onClickListener);
        }
        this.mRD.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.recapp.lego.view.a.b.3
            private float mRJ = 0.0f;
            private float mRK = 0.0f;
            private float mRL = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.mRC = false;
                        this.mRJ = motionEvent.getX();
                        this.mRK = motionEvent.getY();
                        this.mRL = 0.0f;
                        break;
                    case 1:
                        b.this.mRC = 10.0f < this.mRL;
                        if (!b.this.mRC) {
                            onClickListener.onClick(b.this.iND);
                            break;
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.mRJ;
                        float y = motionEvent.getY() - this.mRK;
                        this.mRL = (float) (Math.sqrt((x * x) + (y * y)) + this.mRL);
                        this.mRJ = motionEvent.getX();
                        this.mRK = motionEvent.getY();
                        break;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dFJ() {
        return this.kQj.bph() ? dFL() : dFM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dFK() {
        return dFL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int eg(View view) {
        return dFL();
    }

    private int dFL() {
        String scheme = this.mOZ.getScheme() != null ? this.mOZ.getScheme() : this.kQj.eNV;
        return s.x(this.mContext, scheme, this.mOZ.getAdvertAppInfo() != null ? d(this.mOZ.getAdvertAppInfo()) : scheme);
    }

    private int dFM() {
        if (this.kQj == null || this.mOZ == null || this.mRH == null) {
            return 0;
        }
        return s.a(this.mContext, this.mOZ.getScheme(), this.kQj);
    }

    public void b(AdvertAppInfo advertAppInfo, AdCard adCard) {
        if (advertAppInfo != null && adCard != null) {
            this.kQj = advertAppInfo;
            this.mOZ = adCard;
            if (this.kQj.bpg()) {
                String str = this.kQj.eOc.buttonText;
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.check_immediately);
                }
                this.alx.setText(str);
                this.mRG.setVisibility(8);
                this.alx.setVisibility(0);
                return;
            }
            this.mRG.setClickable(true);
            this.mRG.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.a.b.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public boolean ci(View view) {
                    com.baidu.tieba.lego.card.a.c.a(com.baidu.tieba.lego.card.a.c.c(b.this.kQj));
                    if (b.this.mContext != null && s.Rz(b.this.mOZ.getScheme()) && s.isInstalledPackage(b.this.mContext, b.this.kQj.eNW)) {
                        s.x(b.this.mContext, b.this.mOZ.getScheme(), b.this.kQj.eNW);
                        return true;
                    }
                    if (b.this.mContext != null && !z.aA((Activity) b.this.mContext)) {
                        l.showToast((Activity) b.this.mContext, R.string.write_external_storage_permission_denied_fun_disable);
                    }
                    return false;
                }
            });
            DownloadData d = d(this.kQj, com.baidu.adp.lib.f.b.toInt(this.kQj.adPosition, -1));
            o(d);
            this.mRG.setData(d);
            this.mRG.setVisibility(0);
            this.alx.setVisibility(8);
            b(adCard, advertAppInfo);
        }
    }

    private void b(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey Fz;
        DownloadCacheKey downloadCacheKey;
        if (advertAppInfo != null && advertAppInfo.bpf() && adCard != null) {
            String scheme = adCard.getScheme();
            String str = TextUtils.isEmpty(advertAppInfo.eNW) ? advertAppInfo.eNT : advertAppInfo.eNW;
            if (!TextUtils.isEmpty(str)) {
                Fz = com.baidu.tieba.ad.download.d.bOQ().Fy(str);
            } else {
                Fz = com.baidu.tieba.ad.download.d.bOQ().Fz(scheme);
            }
            if (Fz == null) {
                downloadCacheKey = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.eNW);
                com.baidu.tieba.ad.download.d.bOQ().a(downloadCacheKey, null);
            } else {
                downloadCacheKey = Fz;
            }
            i(downloadCacheKey);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.gjj = downloadCacheKey;
            bOJ();
            this.gjk = null;
            AdDownloadData d = com.baidu.tieba.ad.download.d.bOQ().d(downloadCacheKey);
            this.mRG.a(d.getCurrentState());
            String str = "";
            if (this.mOZ != null && this.mOZ.getAdvertAppInfo() != null) {
                str = this.mOZ.getAdvertAppInfo().page;
                d.setExtInfo(this.mOZ.getAdvertAppInfo().extensionInfo);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mRG, d, str);
            this.gjk = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d != null && d.extra() != null && d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bOI();
        }
    }

    private void o(DownloadData downloadData) {
        if (downloadData != null) {
            downloadData.setStatus(this.mRG.getDownloadStatus());
        }
    }

    DownloadData d(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo == null) {
            return new DownloadData();
        }
        DownloadData downloadData = new DownloadData(advertAppInfo.eNW);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.eNU);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.eNT, 0));
        return downloadData;
    }

    private void bOI() {
        if (this.gjj != null && this.gjk != null) {
            com.baidu.tieba.ad.download.d.bOQ().a(this.gjj, this.gjk);
        }
    }

    private void bOJ() {
        if (this.gjj != null && this.gjk != null) {
            com.baidu.tieba.ad.download.d.bOQ().b(this.gjj, this.gjk);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void setDragToExitListener(DragImageView.d dVar) {
        this.fAM = dVar;
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public View deq() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        bOJ();
    }

    protected String d(@NonNull AdvertAppInfo advertAppInfo) {
        return TextUtils.isEmpty(advertAppInfo.eNW) ? advertAppInfo.eNT : advertAppInfo.eNW;
    }
}
