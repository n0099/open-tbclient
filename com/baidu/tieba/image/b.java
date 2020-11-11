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
    private TBSpecificationBtn ajR;
    private DownloadCacheKey fSc;
    private DragImageView.d fkz;
    private TbImageView ipJ;
    private AdvertAppInfo kwX;
    private AdCard kxc;
    private RelativeLayout kxf;
    public TextView kxg;
    public TextView kxh;
    public TextView kxi;
    private UrlDragImageView kxk;
    private RelativeLayout kxl;
    private RelativeLayout kxm;
    public TbImageView kxn;
    private ApkDownloadView kxo;
    private Context mContext;
    public boolean kxj = false;
    private com.baidu.tieba.ad.download.a.d fSd = null;

    public b(ViewGroup viewGroup, TbPageContext<?> tbPageContext) {
        this.kxf = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.big_image_ad, (ViewGroup) null);
        this.ipJ = (TbImageView) this.kxf.findViewById(R.id.big_image_ad_image);
        this.ajR = (TBSpecificationBtn) this.kxf.findViewById(R.id.image_ad_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bb(R.color.cp_link_tip_a, R.color.cp_cont_a);
        this.ajR.setConfig(bVar);
        this.kxg = (TextView) this.kxf.findViewById(R.id.ad_title);
        this.kxh = (TextView) this.kxf.findViewById(R.id.ad_brand);
        this.kxi = (TextView) this.kxf.findViewById(R.id.ad_tag);
        this.kxl = (RelativeLayout) this.kxf.findViewById(R.id.ad_info_container);
        this.kxm = (RelativeLayout) this.kxf.findViewById(R.id.bottom_container);
        this.kxn = (TbImageView) this.kxf.findViewById(R.id.video_ad_play_icon);
        this.mContext = viewGroup.getContext();
        this.kxo = (ApkDownloadView) this.kxf.findViewById(R.id.image_download_button);
        if (tbPageContext != null) {
            this.kxo.x(tbPageContext.getUniqueId());
        }
        this.kxo.setTextSize(R.dimen.tbds39);
        this.kxo.setTextColorInitSkin(R.color.cp_cont_a);
        this.kxo.setBackgroundSkin(R.drawable.pic_page_down_btn_bg);
        this.kxo.changeSkin();
        cXh();
    }

    public View getView() {
        return this.kxf;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.fkz = dVar;
    }

    public void cXh() {
        this.ipJ.setVisibility(4);
        this.kxk = new UrlDragImageView(this.mContext);
        this.kxk.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.kxk.setIsCanDrag(true);
        this.kxk.setCanScale(false);
        this.kxk.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.1
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.fkz != null) {
                    b.this.fkz.onDragStart();
                }
                b.this.r(b.this.kxg, 8);
                b.this.r(b.this.kxh, 8);
                b.this.r(b.this.kxi, 8);
                b.this.r(b.this.kxl, 8);
                b.this.r(b.this.kxn, 8);
                b.this.r(b.this.ajR, 8);
                b.this.r(b.this.kxo, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragEnd() {
                if (b.this.fkz != null) {
                    b.this.fkz.onDragEnd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void bEk() {
                if (b.this.fkz != null) {
                    b.this.fkz.bEk();
                }
                b.this.r(b.this.kxg, 0);
                b.this.r(b.this.kxh, 0);
                b.this.r(b.this.kxi, 0);
                b.this.r(b.this.kxl, 0);
                if (b.this.kwX != null) {
                    b.this.r(b.this.kxn, b.this.kwX.bku() ? 0 : 8);
                    if (b.this.kwX.bkt()) {
                        b.this.r(b.this.ajR, 0);
                    } else {
                        b.this.r(b.this.kxo, 0);
                    }
                }
            }
        });
        this.kxf.addView(this.kxk, 0);
    }

    public UrlDragImageView cXi() {
        return this.kxk;
    }

    public TbImageView cXj() {
        return this.ipJ;
    }

    public void cXk() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams layoutParams = this.ipJ.getLayoutParams();
            double loadedHeight = this.ipJ.getLoadedHeight() / this.ipJ.getLoadedWidth();
            if (loadedHeight > 1.0d) {
                layoutParams.height = width;
                layoutParams.width = (int) (width / loadedHeight);
            } else {
                layoutParams.height = (int) (loadedHeight * width);
                layoutParams.width = width;
            }
            this.ipJ.setLayoutParams(layoutParams);
        }
    }

    public void F(final View.OnClickListener onClickListener) {
        if (this.ajR != null) {
            this.ajR.setOnClickListener(onClickListener);
        }
        if (this.ipJ != null) {
            this.ipJ.setOnClickListener(onClickListener);
        }
        if (this.kxm != null) {
            this.kxm.setOnClickListener(onClickListener);
        }
        if (this.kxn != null) {
            this.kxn.setOnClickListener(onClickListener);
        }
        this.kxk.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.2
            private float kxq = 0.0f;
            private float kxr = 0.0f;
            private float kxs = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.kxj = false;
                        this.kxq = motionEvent.getX();
                        this.kxr = motionEvent.getY();
                        this.kxs = 0.0f;
                        break;
                    case 1:
                        b.this.kxj = 10.0f < this.kxs;
                        if (!b.this.kxj) {
                            onClickListener.onClick(b.this.ipJ);
                            break;
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.kxq;
                        float y = motionEvent.getY() - this.kxr;
                        this.kxs = (float) (Math.sqrt((x * x) + (y * y)) + this.kxs);
                        this.kxq = motionEvent.getX();
                        this.kxr = motionEvent.getY();
                        break;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(@NonNull View view, int i) {
        view.setVisibility(i);
    }

    public void a(AdvertAppInfo advertAppInfo, AdCard adCard) {
        if (advertAppInfo != null && adCard != null) {
            this.kwX = advertAppInfo;
            this.kxc = adCard;
            if (this.kwX.bkt()) {
                String str = this.kwX.eyX.buttonText;
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.check_immediately);
                }
                this.ajR.setText(str);
                this.kxo.setVisibility(8);
                this.ajR.setVisibility(0);
                return;
            }
            this.kxo.setClickable(true);
            this.kxo.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.image.b.3
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public boolean bP(View view) {
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.d(b.this.kwX));
                    if (b.this.mContext == null || !s.Rp(b.this.kxc.getScheme()) || !s.isInstalledPackage(b.this.mContext, b.this.kwX.eyR)) {
                        if (b.this.mContext != null && !y.ax((Activity) b.this.mContext)) {
                            l.showToast((Activity) b.this.mContext, (int) R.string.write_external_storage_permission_denied_fun_disable);
                        }
                        return false;
                    }
                    s.aY(b.this.mContext, b.this.kxc.getScheme());
                    return true;
                }
            });
            DownloadData b = b(this.kwX, com.baidu.adp.lib.f.b.toInt(this.kwX.adPosition, -1));
            h(b);
            this.kxo.setData(b);
            this.kxo.setVisibility(0);
            this.ajR.setVisibility(8);
            a(adCard, advertAppInfo);
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey Fm;
        if (advertAppInfo != null && advertAppInfo.bks() && adCard != null) {
            String scheme = adCard.getScheme();
            String str = advertAppInfo.eyO;
            if (!TextUtils.isEmpty(str)) {
                Fm = com.baidu.tieba.ad.download.d.bJw().Fl(str);
            } else {
                Fm = com.baidu.tieba.ad.download.d.bJw().Fm(scheme);
            }
            if (Fm == null) {
                Fm = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.eyR);
                com.baidu.tieba.ad.download.d.bJw().a(Fm, null);
            }
            i(Fm);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.fSc = downloadCacheKey;
            bJq();
            this.fSd = null;
            AdDownloadData d = com.baidu.tieba.ad.download.d.bJw().d(downloadCacheKey);
            this.kxo.a(d.getCurrentState());
            String str = "";
            if (this.kxc != null && this.kxc.getAdvertAppInfo() != null) {
                str = this.kxc.getAdvertAppInfo().page;
                d.setExtInfo(this.kxc.getAdvertAppInfo().extensionInfo);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.kxo, d, str);
            this.fSd = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d != null && d.extra() != null && d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bJp();
        }
    }

    private void h(DownloadData downloadData) {
        if (downloadData != null) {
            downloadData.setStatus(this.kxo.getDownloadStatus());
        }
    }

    DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo == null) {
            return new DownloadData();
        }
        DownloadData downloadData = new DownloadData(advertAppInfo.eyR);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.eyP);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.eyO, 0));
        return downloadData;
    }

    private void bJp() {
        if (this.fSc != null && this.fSd != null) {
            com.baidu.tieba.ad.download.d.bJw().a(this.fSc, this.fSd);
        }
    }

    private void bJq() {
        if (this.fSc != null && this.fSd != null) {
            com.baidu.tieba.ad.download.d.bJw().b(this.fSc, this.fSd);
        }
    }

    public void onDestroy() {
        bJq();
    }

    public void onCreate() {
        bJp();
    }
}
