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
    private TBSpecificationBtn ajQ;
    private DragImageView.d eWk;
    private DownloadCacheKey fDR;
    private TbImageView hXk;
    private AdvertAppInfo keD;
    private AdCard keI;
    private RelativeLayout keL;
    public TextView keM;
    public TextView keN;
    public TextView keO;
    private UrlDragImageView keQ;
    private RelativeLayout keR;
    private RelativeLayout keS;
    public TbImageView keT;
    private ApkDownloadView keU;
    private Context mContext;
    public boolean keP = false;
    private com.baidu.tieba.ad.download.a.d fDS = null;

    public b(ViewGroup viewGroup, TbPageContext<?> tbPageContext) {
        this.keL = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.big_image_ad, (ViewGroup) null);
        this.hXk = (TbImageView) this.keL.findViewById(R.id.big_image_ad_image);
        this.ajQ = (TBSpecificationBtn) this.keL.findViewById(R.id.image_ad_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.ba(R.color.cp_link_tip_a, R.color.cp_cont_a);
        this.ajQ.setConfig(bVar);
        this.keM = (TextView) this.keL.findViewById(R.id.ad_title);
        this.keN = (TextView) this.keL.findViewById(R.id.ad_brand);
        this.keO = (TextView) this.keL.findViewById(R.id.ad_tag);
        this.keR = (RelativeLayout) this.keL.findViewById(R.id.ad_info_container);
        this.keS = (RelativeLayout) this.keL.findViewById(R.id.bottom_container);
        this.keT = (TbImageView) this.keL.findViewById(R.id.video_ad_play_icon);
        this.mContext = viewGroup.getContext();
        this.keU = (ApkDownloadView) this.keL.findViewById(R.id.image_download_button);
        if (tbPageContext != null) {
            this.keU.x(tbPageContext.getUniqueId());
        }
        this.keU.setTextSize(R.dimen.tbds39);
        this.keU.setTextColorInitSkin(R.color.cp_cont_a);
        this.keU.setBackgroundSkin(R.drawable.pic_page_down_btn_bg);
        this.keU.changeSkin();
        cRz();
    }

    public View getView() {
        return this.keL;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.eWk = dVar;
    }

    public void cRz() {
        this.hXk.setVisibility(4);
        this.keQ = new UrlDragImageView(this.mContext);
        this.keQ.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.keQ.setIsCanDrag(true);
        this.keQ.setCanScale(false);
        this.keQ.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.1
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.eWk != null) {
                    b.this.eWk.onDragStart();
                }
                b.this.q(b.this.keM, 8);
                b.this.q(b.this.keN, 8);
                b.this.q(b.this.keO, 8);
                b.this.q(b.this.keR, 8);
                b.this.q(b.this.keT, 8);
                b.this.q(b.this.ajQ, 8);
                b.this.q(b.this.keU, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragEnd() {
                if (b.this.eWk != null) {
                    b.this.eWk.onDragEnd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void bzS() {
                if (b.this.eWk != null) {
                    b.this.eWk.bzS();
                }
                b.this.q(b.this.keM, 0);
                b.this.q(b.this.keN, 0);
                b.this.q(b.this.keO, 0);
                b.this.q(b.this.keR, 0);
                if (b.this.keD != null) {
                    b.this.q(b.this.keT, b.this.keD.bgb() ? 0 : 8);
                    if (b.this.keD.bga()) {
                        b.this.q(b.this.ajQ, 0);
                    } else {
                        b.this.q(b.this.keU, 0);
                    }
                }
            }
        });
        this.keL.addView(this.keQ, 0);
    }

    public UrlDragImageView cRA() {
        return this.keQ;
    }

    public TbImageView cRB() {
        return this.hXk;
    }

    public void cRC() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams layoutParams = this.hXk.getLayoutParams();
            double loadedHeight = this.hXk.getLoadedHeight() / this.hXk.getLoadedWidth();
            if (loadedHeight > 1.0d) {
                layoutParams.height = width;
                layoutParams.width = (int) (width / loadedHeight);
            } else {
                layoutParams.height = (int) (loadedHeight * width);
                layoutParams.width = width;
            }
            this.hXk.setLayoutParams(layoutParams);
        }
    }

    public void E(final View.OnClickListener onClickListener) {
        if (this.ajQ != null) {
            this.ajQ.setOnClickListener(onClickListener);
        }
        if (this.hXk != null) {
            this.hXk.setOnClickListener(onClickListener);
        }
        if (this.keS != null) {
            this.keS.setOnClickListener(onClickListener);
        }
        if (this.keT != null) {
            this.keT.setOnClickListener(onClickListener);
        }
        this.keQ.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.2
            private float keW = 0.0f;
            private float keX = 0.0f;
            private float keY = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.keP = false;
                        this.keW = motionEvent.getX();
                        this.keX = motionEvent.getY();
                        this.keY = 0.0f;
                        break;
                    case 1:
                        b.this.keP = 10.0f < this.keY;
                        if (!b.this.keP) {
                            onClickListener.onClick(b.this.hXk);
                            break;
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.keW;
                        float y = motionEvent.getY() - this.keX;
                        this.keY = (float) (Math.sqrt((x * x) + (y * y)) + this.keY);
                        this.keW = motionEvent.getX();
                        this.keX = motionEvent.getY();
                        break;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(@NonNull View view, int i) {
        view.setVisibility(i);
    }

    public void a(AdvertAppInfo advertAppInfo, AdCard adCard) {
        if (advertAppInfo != null && adCard != null) {
            this.keD = advertAppInfo;
            this.keI = adCard;
            if (this.keD.bga()) {
                String str = this.keD.ekE.buttonText;
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.check_immediately);
                }
                this.ajQ.setText(str);
                this.keU.setVisibility(8);
                this.ajQ.setVisibility(0);
                return;
            }
            this.keU.setClickable(true);
            this.keU.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.image.b.3
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public boolean bK(View view) {
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.d(b.this.keD));
                    if (b.this.mContext == null || !s.QA(b.this.keI.getScheme()) || !s.isInstalledPackage(b.this.mContext, b.this.keD.eky)) {
                        if (b.this.mContext != null && !y.ax((Activity) b.this.mContext)) {
                            l.showToast((Activity) b.this.mContext, R.string.write_external_storage_permission_denied_fun_disable);
                        }
                        return false;
                    }
                    s.aW(b.this.mContext, b.this.keI.getScheme());
                    return true;
                }
            });
            DownloadData b = b(this.keD, com.baidu.adp.lib.f.b.toInt(this.keD.adPosition, -1));
            h(b);
            this.keU.setData(b);
            this.keU.setVisibility(0);
            this.ajQ.setVisibility(8);
            a(adCard, advertAppInfo);
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey EF;
        if (advertAppInfo != null && advertAppInfo.bfZ() && adCard != null) {
            String scheme = adCard.getScheme();
            String str = advertAppInfo.ekv;
            if (!TextUtils.isEmpty(str)) {
                EF = com.baidu.tieba.ad.download.d.bFe().EE(str);
            } else {
                EF = com.baidu.tieba.ad.download.d.bFe().EF(scheme);
            }
            if (EF == null) {
                EF = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.eky);
                com.baidu.tieba.ad.download.d.bFe().a(EF, null);
            }
            i(EF);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.fDR = downloadCacheKey;
            bEY();
            this.fDS = null;
            AdDownloadData d = com.baidu.tieba.ad.download.d.bFe().d(downloadCacheKey);
            this.keU.a(d.getCurrentState());
            String str = "";
            if (this.keI != null && this.keI.getAdvertAppInfo() != null) {
                str = this.keI.getAdvertAppInfo().page;
                d.setExtInfo(this.keI.getAdvertAppInfo().extensionInfo);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.keU, d, str);
            this.fDS = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d != null && d.extra() != null && d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bEX();
        }
    }

    private void h(DownloadData downloadData) {
        if (downloadData != null) {
            downloadData.setStatus(this.keU.getDownloadStatus());
        }
    }

    DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo == null) {
            return new DownloadData();
        }
        DownloadData downloadData = new DownloadData(advertAppInfo.eky);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.ekw);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.ekv, 0));
        return downloadData;
    }

    private void bEX() {
        if (this.fDR != null && this.fDS != null) {
            com.baidu.tieba.ad.download.d.bFe().a(this.fDR, this.fDS);
        }
    }

    private void bEY() {
        if (this.fDR != null && this.fDS != null) {
            com.baidu.tieba.ad.download.d.bFe().b(this.fDR, this.fDS);
        }
    }

    public void onDestroy() {
        bEY();
    }

    public void onCreate() {
        bEX();
    }
}
