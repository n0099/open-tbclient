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
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.tieba.tbadkCore.y;
/* loaded from: classes15.dex */
public class b {
    private DragImageView.d eHS;
    private DownloadCacheKey fov;
    private TbImageView hBh;
    private AdvertAppInfo jGW;
    private AdCard jHb;
    private RelativeLayout jHe;
    public TextView jHf;
    public TextView jHg;
    public TextView jHh;
    private UrlDragImageView jHj;
    private RelativeLayout jHk;
    private RelativeLayout jHl;
    public TbImageView jHm;
    private ApkDownloadView jHn;
    private TBSpecificationBtn jpz;
    private Context mContext;
    public boolean jHi = false;
    private com.baidu.tieba.ad.download.a.d fow = null;

    public b(ViewGroup viewGroup, TbPageContext<?> tbPageContext) {
        this.jHe = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.big_image_ad, (ViewGroup) null);
        this.hBh = (TbImageView) this.jHe.findViewById(R.id.big_image_ad_image);
        this.jpz = (TBSpecificationBtn) this.jHe.findViewById(R.id.image_ad_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bb(R.color.cp_link_tip_a, R.color.cp_cont_a);
        this.jpz.setConfig(bVar);
        this.jHf = (TextView) this.jHe.findViewById(R.id.ad_title);
        this.jHg = (TextView) this.jHe.findViewById(R.id.ad_brand);
        this.jHh = (TextView) this.jHe.findViewById(R.id.ad_tag);
        this.jHk = (RelativeLayout) this.jHe.findViewById(R.id.ad_info_container);
        this.jHl = (RelativeLayout) this.jHe.findViewById(R.id.bottom_container);
        this.jHm = (TbImageView) this.jHe.findViewById(R.id.video_ad_play_icon);
        this.mContext = viewGroup.getContext();
        this.jHn = (ApkDownloadView) this.jHe.findViewById(R.id.image_download_button);
        if (tbPageContext != null) {
            this.jHn.y(tbPageContext.getUniqueId());
        }
        this.jHn.setTextSize(R.dimen.tbds39);
        this.jHn.setTextColorInitSkin(R.color.cp_cont_a);
        this.jHn.setBackgroundSkin(R.drawable.pic_page_down_btn_bg);
        this.jHn.changeSkin();
        cKk();
    }

    public View getView() {
        return this.jHe;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.eHS = dVar;
    }

    public void cKk() {
        this.hBh.setVisibility(4);
        this.jHj = new UrlDragImageView(this.mContext);
        this.jHj.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.jHj.setIsCanDrag(true);
        this.jHj.setCanScale(false);
        this.jHj.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.1
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.eHS != null) {
                    b.this.eHS.onDragStart();
                }
                b.this.o(b.this.jHf, 8);
                b.this.o(b.this.jHg, 8);
                b.this.o(b.this.jHh, 8);
                b.this.o(b.this.jHk, 8);
                b.this.o(b.this.jHm, 8);
                b.this.o(b.this.jpz, 8);
                b.this.o(b.this.jHn, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragEnd() {
                if (b.this.eHS != null) {
                    b.this.eHS.onDragEnd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void bvY() {
                b.this.o(b.this.jHf, 0);
                b.this.o(b.this.jHg, 0);
                b.this.o(b.this.jHh, 0);
                b.this.o(b.this.jHk, 0);
                if (b.this.jGW != null) {
                    b.this.o(b.this.jHm, b.this.jGW.bcy() ? 0 : 8);
                    if (b.this.jGW.bcx()) {
                        b.this.o(b.this.jpz, 0);
                    } else {
                        b.this.o(b.this.jHn, 0);
                    }
                }
            }
        });
        this.jHe.addView(this.jHj, 0);
    }

    public UrlDragImageView cKl() {
        return this.jHj;
    }

    public TbImageView cKm() {
        return this.hBh;
    }

    public void cKn() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams layoutParams = this.hBh.getLayoutParams();
            double loadedHeight = this.hBh.getLoadedHeight() / this.hBh.getLoadedWidth();
            if (loadedHeight > 1.0d) {
                layoutParams.height = width;
                layoutParams.width = (int) (width / loadedHeight);
            } else {
                layoutParams.height = (int) (loadedHeight * width);
                layoutParams.width = width;
            }
            this.hBh.setLayoutParams(layoutParams);
        }
    }

    public void E(final View.OnClickListener onClickListener) {
        if (this.jpz != null) {
            this.jpz.setOnClickListener(onClickListener);
        }
        if (this.hBh != null) {
            this.hBh.setOnClickListener(onClickListener);
        }
        if (this.jHl != null) {
            this.jHl.setOnClickListener(onClickListener);
        }
        if (this.jHm != null) {
            this.jHm.setOnClickListener(onClickListener);
        }
        this.jHj.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.2
            private float jHp = 0.0f;
            private float jHq = 0.0f;
            private float jHr = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.jHi = false;
                        this.jHp = motionEvent.getX();
                        this.jHq = motionEvent.getY();
                        this.jHr = 0.0f;
                        break;
                    case 1:
                        b.this.jHi = 10.0f < this.jHr;
                        if (!b.this.jHi) {
                            onClickListener.onClick(b.this.hBh);
                            break;
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.jHp;
                        float y = motionEvent.getY() - this.jHq;
                        this.jHr = (float) (Math.sqrt((x * x) + (y * y)) + this.jHr);
                        this.jHp = motionEvent.getX();
                        this.jHq = motionEvent.getY();
                        break;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(@NonNull View view, int i) {
        view.setVisibility(i);
    }

    public void a(AdvertAppInfo advertAppInfo, AdCard adCard) {
        if (advertAppInfo != null && adCard != null) {
            this.jGW = advertAppInfo;
            this.jHb = adCard;
            if (this.jGW.bcx()) {
                String str = this.jGW.dWo.buttonText;
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.check_immediately);
                }
                this.jpz.setText(str);
                this.jHn.setVisibility(8);
                this.jpz.setVisibility(0);
                return;
            }
            this.jHn.setClickable(true);
            this.jHn.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.image.b.3
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public boolean bC(View view) {
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.d(b.this.jGW));
                    if (b.this.mContext == null || !s.Pk(b.this.jHb.getScheme()) || !s.isInstalledPackage(b.this.mContext, b.this.jGW.dWi)) {
                        if (b.this.mContext != null && !y.as((Activity) b.this.mContext)) {
                            l.showToast((Activity) b.this.mContext, (int) R.string.write_external_storage_permission_denied_fun_disable);
                        }
                        return false;
                    }
                    s.aR(b.this.mContext, b.this.jHb.getScheme());
                    return true;
                }
            });
            DownloadData b = b(this.jGW, com.baidu.adp.lib.f.b.toInt(this.jGW.adPosition, -1));
            h(b);
            this.jHn.setData(b);
            this.jHn.setVisibility(0);
            this.jpz.setVisibility(8);
            a(adCard, advertAppInfo);
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey Dw;
        if (advertAppInfo != null && advertAppInfo.bcw() && adCard != null) {
            String scheme = adCard.getScheme();
            String str = advertAppInfo.dWf;
            if (!TextUtils.isEmpty(str)) {
                Dw = com.baidu.tieba.ad.download.d.bBf().Dv(str);
            } else {
                Dw = com.baidu.tieba.ad.download.d.bBf().Dw(scheme);
            }
            if (Dw == null) {
                Dw = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.dWi);
                com.baidu.tieba.ad.download.d.bBf().a(Dw, null);
            }
            i(Dw);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.fov = downloadCacheKey;
            bAZ();
            this.fow = null;
            AdDownloadData d = com.baidu.tieba.ad.download.d.bBf().d(downloadCacheKey);
            if (d != null) {
                this.jHn.a(d.getCurrentState());
            } else {
                this.jHn.a(DownloadStatus.STATUS_NONE);
            }
            String str = "";
            if (this.jHb != null && this.jHb.getAdvertAppInfo() != null) {
                str = this.jHb.getAdvertAppInfo().page;
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.jHn, d, str);
            this.fow = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d != null && d.extra() != null && d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bAY();
        }
    }

    private void h(DownloadData downloadData) {
        if (downloadData != null) {
            downloadData.setStatus(this.jHn.getDownloadStatus());
        }
    }

    DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo == null) {
            return new DownloadData();
        }
        DownloadData downloadData = new DownloadData(advertAppInfo.dWi);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dWg);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.dWf, 0));
        return downloadData;
    }

    private void bAY() {
        if (this.fov != null && this.fow != null) {
            com.baidu.tieba.ad.download.d.bBf().a(this.fov, this.fow);
        }
    }

    private void bAZ() {
        if (this.fov != null && this.fow != null) {
            com.baidu.tieba.ad.download.d.bBf().b(this.fov, this.fow);
        }
    }

    public void onDestroy() {
        bAZ();
    }

    public void onCreate() {
        bAY();
    }
}
