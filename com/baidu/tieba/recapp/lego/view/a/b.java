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
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.tieba.tbadkCore.y;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes25.dex */
public class b extends a implements j {
    private TBSpecificationBtn ajU;
    public ImageView akY;
    private DownloadCacheKey fRJ;
    private d fRK;
    private DragImageView.d fjH;
    private TbImageView iqx;
    private final View.OnClickListener mClickListener;
    private RelativeLayout mRootView;
    public TextView mvu;
    public TextView mvw;
    public TextView mye;
    public boolean myf;
    private UrlDragImageView myg;
    private RelativeLayout myh;
    private RelativeLayout myi;
    private ApkDownloadView myj;
    private VideoInfo myk;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.myf = false;
        this.fRK = null;
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int dAC;
                String str;
                if (b.this.kxG != null && b.this.mvE != null) {
                    if (!b.this.myf || view.getId() != R.id.big_image_ad_image) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        if (view.getId() == R.id.image_ad_button) {
                            dAC = b.this.dL(view);
                            str = "button";
                        } else if (view.getId() == R.id.bottom_container) {
                            dAC = b.this.dAD();
                            str = "title";
                        } else {
                            dAC = b.this.dAC();
                            str = b.this.kxG.bjx() ? "image" : "video";
                        }
                        hashMap.put("da_area", str);
                        b.this.myd.d(dAC, hashMap);
                    }
                }
            }
        };
    }

    @Override // com.baidu.tieba.recapp.lego.view.a.a
    protected void cYM() {
        if (this.mPageContext != null) {
            this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.ad_pic_page_layout, (ViewGroup) null);
            this.iqx = (TbImageView) this.mRootView.findViewById(R.id.big_image_ad_image);
            this.ajU = (TBSpecificationBtn) this.mRootView.findViewById(R.id.image_ad_button);
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.bb(R.color.CAM_X0302, R.color.CAM_X0101);
            this.ajU.setConfig(bVar);
            this.mvu = (TextView) this.mRootView.findViewById(R.id.ad_title);
            this.mye = (TextView) this.mRootView.findViewById(R.id.ad_brand);
            this.mvw = (TextView) this.mRootView.findViewById(R.id.ad_tag);
            this.myh = (RelativeLayout) this.mRootView.findViewById(R.id.ad_info_container);
            this.myi = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_container);
            this.akY = (ImageView) this.mRootView.findViewById(R.id.video_ad_play_icon);
            this.akY.setImageDrawable(WebPManager.a(R.drawable.icon_pure_video_play44, ap.getColor(R.color.CAM_X0101), (WebPManager.ResourceStateType) null));
            this.myj = (ApkDownloadView) this.mRootView.findViewById(R.id.image_download_button);
            if (this.mPageContext != null) {
                this.myj.x(this.mPageContext.getUniqueId());
            }
            this.myj.setTextSize(R.dimen.tbds39);
            this.myj.setTextColorInitSkin(R.color.CAM_X0101);
            this.myj.setBackgroundSkin(R.drawable.pic_page_down_btn_bg);
            this.myj.changeSkin();
            dAB();
            ad(this.mClickListener);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.a.a
    public void b(AdCard adCard) {
        super.b(adCard);
        if (this.kxG != null && this.kxG.exl != null) {
            this.myk = this.mvE.videoInfo;
            dAz();
            b(this.kxG, this.mvE);
            if (!TextUtils.isEmpty(this.kxG.exl.userName)) {
                this.mye.setText(this.kxG.exl.userName);
                if (!TextUtils.isEmpty(this.kxG.exl.tagName)) {
                    this.mvw.setText(this.kxG.exl.tagName);
                } else {
                    this.mvw.setText(this.mContext.getString(R.string.advert_label));
                }
            }
            if (!TextUtils.isEmpty(this.kxG.exl.exv)) {
                this.mvu.setText(this.kxG.exl.exv);
            }
            this.akY.setVisibility(this.kxG.bjw() ? 0 : 8);
            ad(this.mClickListener);
        }
    }

    private void dAz() {
        String str;
        this.iqx.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.recapp.lego.view.a.b.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z) {
                    b.this.dAA();
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        if (this.kxG.bjw() && this.myk != null) {
            str = this.myk.thumbnail_url;
        } else {
            str = this.kxG.exl.exx;
        }
        this.iqx.a(str, this.fhT ? 30 : 31, 720, 720, false);
        if (this.myg != null) {
            this.myg.setIsCdn(this.fhT);
            this.myg.setUrl(str, true);
        }
    }

    public void dAA() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams layoutParams = this.iqx.getLayoutParams();
            double loadedHeight = this.iqx.getLoadedHeight() / this.iqx.getLoadedWidth();
            if (loadedHeight > 1.0d) {
                layoutParams.height = width;
                layoutParams.width = (int) (width / loadedHeight);
            } else {
                layoutParams.height = (int) (loadedHeight * width);
                layoutParams.width = width;
            }
            this.iqx.setLayoutParams(layoutParams);
        }
    }

    public void dAB() {
        this.iqx.setVisibility(4);
        this.myg = new UrlDragImageView(this.mContext);
        this.myg.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.myg.setIsCanDrag(true);
        this.myg.setCanScale(false);
        this.myg.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.recapp.lego.view.a.b.2
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.fjH != null) {
                    b.this.fjH.onDragStart();
                }
                b.this.mvu.setVisibility(8);
                b.this.mye.setVisibility(8);
                b.this.mvw.setVisibility(8);
                b.this.myh.setVisibility(8);
                b.this.akY.setVisibility(8);
                b.this.ajU.setVisibility(8);
                b.this.myj.setVisibility(8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragEnd() {
                if (b.this.fjH != null) {
                    b.this.fjH.onDragEnd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void bDD() {
                if (b.this.fjH != null) {
                    b.this.fjH.bDD();
                }
                b.this.mvu.setVisibility(0);
                b.this.mye.setVisibility(0);
                b.this.mvw.setVisibility(0);
                b.this.myh.setVisibility(0);
                if (b.this.kxG != null) {
                    b.this.akY.setVisibility(b.this.kxG.bjw() ? 0 : 8);
                    if (b.this.kxG.bjv()) {
                        b.this.ajU.setVisibility(0);
                    } else {
                        b.this.myj.setVisibility(0);
                    }
                }
            }
        });
        this.mRootView.addView(this.myg, 0);
    }

    public void ad(final View.OnClickListener onClickListener) {
        if (this.ajU != null) {
            this.ajU.setOnClickListener(onClickListener);
        }
        if (this.iqx != null) {
            this.iqx.setOnClickListener(onClickListener);
        }
        if (this.myi != null) {
            this.myi.setOnClickListener(onClickListener);
        }
        if (this.akY != null) {
            this.akY.setOnClickListener(onClickListener);
        }
        this.myg.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.recapp.lego.view.a.b.3
            private float mym = 0.0f;
            private float myn = 0.0f;
            private float myo = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.myf = false;
                        this.mym = motionEvent.getX();
                        this.myn = motionEvent.getY();
                        this.myo = 0.0f;
                        break;
                    case 1:
                        b.this.myf = 10.0f < this.myo;
                        if (!b.this.myf) {
                            onClickListener.onClick(b.this.iqx);
                            break;
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.mym;
                        float y = motionEvent.getY() - this.myn;
                        this.myo = (float) (Math.sqrt((x * x) + (y * y)) + this.myo);
                        this.mym = motionEvent.getX();
                        this.myn = motionEvent.getY();
                        break;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dAC() {
        return this.kxG.bjx() ? dAE() : dAF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dAD() {
        return dAE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dL(View view) {
        return dAE();
    }

    private int dAE() {
        return r.aV(this.mContext, this.mvE.getScheme() != null ? this.mvE.getScheme() : this.kxG.exe);
    }

    private int dAF() {
        if (this.kxG == null || this.mvE == null || this.myk == null) {
            return 0;
        }
        return r.a(this.mContext, this.mvE.getScheme(), this.kxG);
    }

    public void b(AdvertAppInfo advertAppInfo, AdCard adCard) {
        if (advertAppInfo != null && adCard != null) {
            this.kxG = advertAppInfo;
            this.mvE = adCard;
            if (this.kxG.bjv()) {
                String str = this.kxG.exl.buttonText;
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.check_immediately);
                }
                this.ajU.setText(str);
                this.myj.setVisibility(8);
                this.ajU.setVisibility(0);
                return;
            }
            this.myj.setClickable(true);
            this.myj.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.a.b.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public boolean bS(View view) {
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.c(b.this.kxG));
                    if (b.this.mContext != null && r.QK(b.this.mvE.getScheme()) && r.isInstalledPackage(b.this.mContext, b.this.kxG.exf)) {
                        r.aV(b.this.mContext, b.this.mvE.getScheme());
                        return true;
                    }
                    if (b.this.mContext != null && !y.aw((Activity) b.this.mContext)) {
                        l.showToast((Activity) b.this.mContext, R.string.write_external_storage_permission_denied_fun_disable);
                    }
                    return false;
                }
            });
            DownloadData c = c(this.kxG, com.baidu.adp.lib.f.b.toInt(this.kxG.adPosition, -1));
            o(c);
            this.myj.setData(c);
            this.myj.setVisibility(0);
            this.ajU.setVisibility(8);
            b(adCard, advertAppInfo);
        }
    }

    private void b(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey EN;
        if (advertAppInfo != null && advertAppInfo.bju() && adCard != null) {
            String scheme = adCard.getScheme();
            String str = advertAppInfo.exc;
            if (!TextUtils.isEmpty(str)) {
                EN = com.baidu.tieba.ad.download.d.bIP().EM(str);
            } else {
                EN = com.baidu.tieba.ad.download.d.bIP().EN(scheme);
            }
            if (EN == null) {
                EN = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.exf);
                com.baidu.tieba.ad.download.d.bIP().a(EN, null);
            }
            i(EN);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.fRJ = downloadCacheKey;
            bIJ();
            this.fRK = null;
            AdDownloadData d = com.baidu.tieba.ad.download.d.bIP().d(downloadCacheKey);
            this.myj.a(d.getCurrentState());
            String str = "";
            if (this.mvE != null && this.mvE.getAdvertAppInfo() != null) {
                str = this.mvE.getAdvertAppInfo().page;
                d.setExtInfo(this.mvE.getAdvertAppInfo().extensionInfo);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.myj, d, str);
            this.fRK = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d != null && d.extra() != null && d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bII();
        }
    }

    private void o(DownloadData downloadData) {
        if (downloadData != null) {
            downloadData.setStatus(this.myj.getDownloadStatus());
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo == null) {
            return new DownloadData();
        }
        DownloadData downloadData = new DownloadData(advertAppInfo.exf);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.exd);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.exc, 0));
        return downloadData;
    }

    private void bII() {
        if (this.fRJ != null && this.fRK != null) {
            com.baidu.tieba.ad.download.d.bIP().a(this.fRJ, this.fRK);
        }
    }

    private void bIJ() {
        if (this.fRJ != null && this.fRK != null) {
            com.baidu.tieba.ad.download.d.bIP().b(this.fRJ, this.fRK);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void setDragToExitListener(DragImageView.d dVar) {
        this.fjH = dVar;
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public View cZt() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.lego.card.view.j
    public void onDestroy() {
        bIJ();
    }
}
