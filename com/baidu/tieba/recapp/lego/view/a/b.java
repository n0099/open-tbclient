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
    public TextView mOO;
    public TextView mOQ;
    public TextView mRA;
    public boolean mRB;
    private UrlDragImageView mRC;
    private RelativeLayout mRD;
    private RelativeLayout mRE;
    private ApkDownloadView mRF;
    private VideoInfo mRG;
    private RelativeLayout mRootView;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mRB = false;
        this.gjk = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int dFK;
                String str;
                if (b.this.kQj != null && b.this.mOY != null) {
                    if (!b.this.mRB || view.getId() != R.id.big_image_ad_image) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        if (view.getId() == R.id.image_ad_button) {
                            dFK = b.this.eg(view);
                            str = "button";
                        } else if (view.getId() == R.id.bottom_container) {
                            dFK = b.this.dFL();
                            str = "title";
                        } else {
                            dFK = b.this.dFK();
                            str = b.this.kQj.bpi() ? "image" : "video";
                        }
                        hashMap.put("da_area", str);
                        b.this.mRz.d(dFK, hashMap);
                    }
                }
            }
        };
    }

    @Override // com.baidu.tieba.recapp.lego.view.a.a
    protected void ddK() {
        if (this.mPageContext != null) {
            this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.ad_pic_page_layout, (ViewGroup) null);
            this.iND = (TbImageView) this.mRootView.findViewById(R.id.big_image_ad_image);
            this.alx = (TBSpecificationBtn) this.mRootView.findViewById(R.id.image_ad_button);
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.bb(R.color.CAM_X0302, R.color.CAM_X0101);
            this.alx.setConfig(bVar);
            this.mOO = (TextView) this.mRootView.findViewById(R.id.ad_title);
            this.mRA = (TextView) this.mRootView.findViewById(R.id.ad_brand);
            this.mOQ = (TextView) this.mRootView.findViewById(R.id.ad_tag);
            this.mRD = (RelativeLayout) this.mRootView.findViewById(R.id.ad_info_container);
            this.mRE = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_container);
            this.amB = (ImageView) this.mRootView.findViewById(R.id.video_ad_play_icon);
            this.amB.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_play44, ao.getColor(R.color.CAM_X0101), (WebPManager.ResourceStateType) null));
            this.mRF = (ApkDownloadView) this.mRootView.findViewById(R.id.image_download_button);
            if (this.mPageContext != null) {
                this.mRF.x(this.mPageContext.getUniqueId());
            }
            this.mRF.setTextSize(R.dimen.tbds39);
            this.mRF.setTextColorInitSkin(R.color.CAM_X0101);
            this.mRF.setBackgroundSkin(R.drawable.pic_page_down_btn_bg);
            this.mRF.bxO();
            dFJ();
            af(this.mClickListener);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.a.a
    public void b(AdCard adCard) {
        super.b(adCard);
        if (this.kQj != null && this.kQj.eOc != null) {
            this.mRG = this.mOY.videoInfo;
            dFH();
            b(this.kQj, this.mOY);
            if (!TextUtils.isEmpty(this.kQj.eOc.userName)) {
                this.mRA.setText(this.kQj.eOc.userName);
                if (!TextUtils.isEmpty(this.kQj.eOc.tagName)) {
                    this.mOQ.setText(this.kQj.eOc.tagName);
                } else {
                    this.mOQ.setText(this.mContext.getString(R.string.advert_label));
                }
            }
            if (!TextUtils.isEmpty(this.kQj.eOc.eOm)) {
                this.mOO.setText(this.kQj.eOc.eOm);
            }
            this.amB.setVisibility(this.kQj.isVideoAd() ? 0 : 8);
            af(this.mClickListener);
        }
    }

    private void dFH() {
        String str;
        this.iND.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.recapp.lego.view.a.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str2, boolean z) {
                if (z) {
                    b.this.dFI();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        if (this.kQj.isVideoAd() && this.mRG != null) {
            str = this.mRG.thumbnail_url;
        } else {
            str = this.kQj.eOc.eOo;
        }
        this.iND.a(str, this.fzb ? 30 : 31, 720, 720, false);
        if (this.mRC != null) {
            this.mRC.setIsCdn(this.fzb);
            this.mRC.setUrl(str, true);
        }
    }

    public void dFI() {
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

    public void dFJ() {
        this.iND.setVisibility(4);
        this.mRC = new UrlDragImageView(this.mContext);
        this.mRC.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRC.setIsCanDrag(true);
        this.mRC.setCanScale(false);
        this.mRC.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.recapp.lego.view.a.b.2
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.fAM != null) {
                    b.this.fAM.onDragStart();
                }
                b.this.mOO.setVisibility(8);
                b.this.mRA.setVisibility(8);
                b.this.mOQ.setVisibility(8);
                b.this.mRD.setVisibility(8);
                b.this.amB.setVisibility(8);
                b.this.alx.setVisibility(8);
                b.this.mRF.setVisibility(8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragEnd() {
                if (b.this.fAM != null) {
                    b.this.fAM.onDragEnd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void bJy() {
                if (b.this.fAM != null) {
                    b.this.fAM.bJy();
                }
                b.this.mOO.setVisibility(0);
                b.this.mRA.setVisibility(0);
                b.this.mOQ.setVisibility(0);
                b.this.mRD.setVisibility(0);
                if (b.this.kQj != null) {
                    b.this.amB.setVisibility(b.this.kQj.isVideoAd() ? 0 : 8);
                    if (b.this.kQj.bph()) {
                        b.this.alx.setVisibility(0);
                    } else {
                        b.this.mRF.setVisibility(0);
                    }
                }
            }
        });
        this.mRootView.addView(this.mRC, 0);
    }

    public void af(final View.OnClickListener onClickListener) {
        if (this.alx != null) {
            this.alx.setOnClickListener(onClickListener);
        }
        if (this.iND != null) {
            this.iND.setOnClickListener(onClickListener);
        }
        if (this.mRE != null) {
            this.mRE.setOnClickListener(onClickListener);
        }
        if (this.amB != null) {
            this.amB.setOnClickListener(onClickListener);
        }
        this.mRC.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.recapp.lego.view.a.b.3
            private float mRI = 0.0f;
            private float mRJ = 0.0f;
            private float mRK = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.mRB = false;
                        this.mRI = motionEvent.getX();
                        this.mRJ = motionEvent.getY();
                        this.mRK = 0.0f;
                        break;
                    case 1:
                        b.this.mRB = 10.0f < this.mRK;
                        if (!b.this.mRB) {
                            onClickListener.onClick(b.this.iND);
                            break;
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.mRI;
                        float y = motionEvent.getY() - this.mRJ;
                        this.mRK = (float) (Math.sqrt((x * x) + (y * y)) + this.mRK);
                        this.mRI = motionEvent.getX();
                        this.mRJ = motionEvent.getY();
                        break;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dFK() {
        return this.kQj.bpi() ? dFM() : dFN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dFL() {
        return dFM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int eg(View view) {
        return dFM();
    }

    private int dFM() {
        String scheme = this.mOY.getScheme() != null ? this.mOY.getScheme() : this.kQj.eNV;
        return s.x(this.mContext, scheme, this.mOY.getAdvertAppInfo() != null ? d(this.mOY.getAdvertAppInfo()) : scheme);
    }

    private int dFN() {
        if (this.kQj == null || this.mOY == null || this.mRG == null) {
            return 0;
        }
        return s.a(this.mContext, this.mOY.getScheme(), this.kQj);
    }

    public void b(AdvertAppInfo advertAppInfo, AdCard adCard) {
        if (advertAppInfo != null && adCard != null) {
            this.kQj = advertAppInfo;
            this.mOY = adCard;
            if (this.kQj.bph()) {
                String str = this.kQj.eOc.buttonText;
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.check_immediately);
                }
                this.alx.setText(str);
                this.mRF.setVisibility(8);
                this.alx.setVisibility(0);
                return;
            }
            this.mRF.setClickable(true);
            this.mRF.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.a.b.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public boolean ci(View view) {
                    com.baidu.tieba.lego.card.a.c.a(com.baidu.tieba.lego.card.a.c.c(b.this.kQj));
                    if (b.this.mContext != null && s.Ry(b.this.mOY.getScheme()) && s.isInstalledPackage(b.this.mContext, b.this.kQj.eNW)) {
                        s.x(b.this.mContext, b.this.mOY.getScheme(), b.this.kQj.eNW);
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
            this.mRF.setData(d);
            this.mRF.setVisibility(0);
            this.alx.setVisibility(8);
            b(adCard, advertAppInfo);
        }
    }

    private void b(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey Fy;
        DownloadCacheKey downloadCacheKey;
        if (advertAppInfo != null && advertAppInfo.bpg() && adCard != null) {
            String scheme = adCard.getScheme();
            String str = TextUtils.isEmpty(advertAppInfo.eNW) ? advertAppInfo.eNT : advertAppInfo.eNW;
            if (!TextUtils.isEmpty(str)) {
                Fy = com.baidu.tieba.ad.download.d.bOR().Fx(str);
            } else {
                Fy = com.baidu.tieba.ad.download.d.bOR().Fy(scheme);
            }
            if (Fy == null) {
                downloadCacheKey = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.eNW);
                com.baidu.tieba.ad.download.d.bOR().a(downloadCacheKey, null);
            } else {
                downloadCacheKey = Fy;
            }
            i(downloadCacheKey);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.gjj = downloadCacheKey;
            bOK();
            this.gjk = null;
            AdDownloadData d = com.baidu.tieba.ad.download.d.bOR().d(downloadCacheKey);
            this.mRF.a(d.getCurrentState());
            String str = "";
            if (this.mOY != null && this.mOY.getAdvertAppInfo() != null) {
                str = this.mOY.getAdvertAppInfo().page;
                d.setExtInfo(this.mOY.getAdvertAppInfo().extensionInfo);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mRF, d, str);
            this.gjk = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d != null && d.extra() != null && d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bOJ();
        }
    }

    private void o(DownloadData downloadData) {
        if (downloadData != null) {
            downloadData.setStatus(this.mRF.getDownloadStatus());
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

    private void bOJ() {
        if (this.gjj != null && this.gjk != null) {
            com.baidu.tieba.ad.download.d.bOR().a(this.gjj, this.gjk);
        }
    }

    private void bOK() {
        if (this.gjj != null && this.gjk != null) {
            com.baidu.tieba.ad.download.d.bOR().b(this.gjj, this.gjk);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void setDragToExitListener(DragImageView.d dVar) {
        this.fAM = dVar;
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public View der() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        bOK();
    }

    protected String d(@NonNull AdvertAppInfo advertAppInfo) {
        return TextUtils.isEmpty(advertAppInfo.eNW) ? advertAppInfo.eNT : advertAppInfo.eNW;
    }
}
