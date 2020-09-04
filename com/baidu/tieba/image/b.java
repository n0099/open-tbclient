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
/* loaded from: classes15.dex */
public class b {
    private DragImageView.d eHW;
    private DownloadCacheKey foz;
    private TbImageView hBn;
    private AdvertAppInfo jHc;
    private AdCard jHh;
    private RelativeLayout jHk;
    public TextView jHl;
    public TextView jHm;
    public TextView jHn;
    private UrlDragImageView jHp;
    private RelativeLayout jHq;
    private RelativeLayout jHr;
    public TbImageView jHs;
    private ApkDownloadView jHt;
    private TBSpecificationBtn jpF;
    private Context mContext;
    public boolean jHo = false;
    private com.baidu.tieba.ad.download.a.d foA = null;

    public b(ViewGroup viewGroup, TbPageContext<?> tbPageContext) {
        this.jHk = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.big_image_ad, (ViewGroup) null);
        this.hBn = (TbImageView) this.jHk.findViewById(R.id.big_image_ad_image);
        this.jpF = (TBSpecificationBtn) this.jHk.findViewById(R.id.image_ad_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bb(R.color.cp_link_tip_a, R.color.cp_cont_a);
        this.jpF.setConfig(bVar);
        this.jHl = (TextView) this.jHk.findViewById(R.id.ad_title);
        this.jHm = (TextView) this.jHk.findViewById(R.id.ad_brand);
        this.jHn = (TextView) this.jHk.findViewById(R.id.ad_tag);
        this.jHq = (RelativeLayout) this.jHk.findViewById(R.id.ad_info_container);
        this.jHr = (RelativeLayout) this.jHk.findViewById(R.id.bottom_container);
        this.jHs = (TbImageView) this.jHk.findViewById(R.id.video_ad_play_icon);
        this.mContext = viewGroup.getContext();
        this.jHt = (ApkDownloadView) this.jHk.findViewById(R.id.image_download_button);
        if (tbPageContext != null) {
            this.jHt.y(tbPageContext.getUniqueId());
        }
        this.jHt.setTextSize(R.dimen.tbds39);
        this.jHt.setTextColorInitSkin(R.color.cp_cont_a);
        this.jHt.setBackgroundSkin(R.drawable.pic_page_down_btn_bg);
        this.jHt.changeSkin();
        cKl();
    }

    public View getView() {
        return this.jHk;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.eHW = dVar;
    }

    public void cKl() {
        this.hBn.setVisibility(4);
        this.jHp = new UrlDragImageView(this.mContext);
        this.jHp.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.jHp.setIsCanDrag(true);
        this.jHp.setCanScale(false);
        this.jHp.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.1
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.eHW != null) {
                    b.this.eHW.onDragStart();
                }
                b.this.o(b.this.jHl, 8);
                b.this.o(b.this.jHm, 8);
                b.this.o(b.this.jHn, 8);
                b.this.o(b.this.jHq, 8);
                b.this.o(b.this.jHs, 8);
                b.this.o(b.this.jpF, 8);
                b.this.o(b.this.jHt, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragEnd() {
                if (b.this.eHW != null) {
                    b.this.eHW.onDragEnd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void bvZ() {
                b.this.o(b.this.jHl, 0);
                b.this.o(b.this.jHm, 0);
                b.this.o(b.this.jHn, 0);
                b.this.o(b.this.jHq, 0);
                if (b.this.jHc != null) {
                    b.this.o(b.this.jHs, b.this.jHc.bcy() ? 0 : 8);
                    if (b.this.jHc.bcx()) {
                        b.this.o(b.this.jpF, 0);
                    } else {
                        b.this.o(b.this.jHt, 0);
                    }
                }
            }
        });
        this.jHk.addView(this.jHp, 0);
    }

    public UrlDragImageView cKm() {
        return this.jHp;
    }

    public TbImageView cKn() {
        return this.hBn;
    }

    public void cKo() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams layoutParams = this.hBn.getLayoutParams();
            double loadedHeight = this.hBn.getLoadedHeight() / this.hBn.getLoadedWidth();
            if (loadedHeight > 1.0d) {
                layoutParams.height = width;
                layoutParams.width = (int) (width / loadedHeight);
            } else {
                layoutParams.height = (int) (loadedHeight * width);
                layoutParams.width = width;
            }
            this.hBn.setLayoutParams(layoutParams);
        }
    }

    public void E(final View.OnClickListener onClickListener) {
        if (this.jpF != null) {
            this.jpF.setOnClickListener(onClickListener);
        }
        if (this.hBn != null) {
            this.hBn.setOnClickListener(onClickListener);
        }
        if (this.jHr != null) {
            this.jHr.setOnClickListener(onClickListener);
        }
        if (this.jHs != null) {
            this.jHs.setOnClickListener(onClickListener);
        }
        this.jHp.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.2
            private float jHv = 0.0f;
            private float jHw = 0.0f;
            private float jHx = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.jHo = false;
                        this.jHv = motionEvent.getX();
                        this.jHw = motionEvent.getY();
                        this.jHx = 0.0f;
                        break;
                    case 1:
                        b.this.jHo = 10.0f < this.jHx;
                        if (!b.this.jHo) {
                            onClickListener.onClick(b.this.hBn);
                            break;
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.jHv;
                        float y = motionEvent.getY() - this.jHw;
                        this.jHx = (float) (Math.sqrt((x * x) + (y * y)) + this.jHx);
                        this.jHv = motionEvent.getX();
                        this.jHw = motionEvent.getY();
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
            this.jHc = advertAppInfo;
            this.jHh = adCard;
            if (this.jHc.bcx()) {
                String str = this.jHc.dWs.buttonText;
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.check_immediately);
                }
                this.jpF.setText(str);
                this.jHt.setVisibility(8);
                this.jpF.setVisibility(0);
                return;
            }
            this.jHt.setClickable(true);
            this.jHt.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.image.b.3
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public boolean bC(View view) {
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.d(b.this.jHc));
                    if (b.this.mContext == null || !s.Pl(b.this.jHh.getScheme()) || !s.isInstalledPackage(b.this.mContext, b.this.jHc.dWm)) {
                        if (b.this.mContext != null && !y.as((Activity) b.this.mContext)) {
                            l.showToast((Activity) b.this.mContext, (int) R.string.write_external_storage_permission_denied_fun_disable);
                        }
                        return false;
                    }
                    s.aR(b.this.mContext, b.this.jHh.getScheme());
                    return true;
                }
            });
            DownloadData b = b(this.jHc, com.baidu.adp.lib.f.b.toInt(this.jHc.adPosition, -1));
            h(b);
            this.jHt.setData(b);
            this.jHt.setVisibility(0);
            this.jpF.setVisibility(8);
            a(adCard, advertAppInfo);
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey Dx;
        if (advertAppInfo != null && advertAppInfo.bcw() && adCard != null) {
            String scheme = adCard.getScheme();
            String str = advertAppInfo.dWj;
            if (!TextUtils.isEmpty(str)) {
                Dx = com.baidu.tieba.ad.download.d.bBg().Dw(str);
            } else {
                Dx = com.baidu.tieba.ad.download.d.bBg().Dx(scheme);
            }
            if (Dx == null) {
                Dx = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.dWm);
                com.baidu.tieba.ad.download.d.bBg().a(Dx, null);
            }
            i(Dx);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.foz = downloadCacheKey;
            bBa();
            this.foA = null;
            AdDownloadData d = com.baidu.tieba.ad.download.d.bBg().d(downloadCacheKey);
            this.jHt.a(d.getCurrentState());
            String str = "";
            if (this.jHh != null && this.jHh.getAdvertAppInfo() != null) {
                str = this.jHh.getAdvertAppInfo().page;
                d.setExtInfo(this.jHh.getAdvertAppInfo().extensionInfo);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.jHt, d, str);
            this.foA = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d != null && d.extra() != null && d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bAZ();
        }
    }

    private void h(DownloadData downloadData) {
        if (downloadData != null) {
            downloadData.setStatus(this.jHt.getDownloadStatus());
        }
    }

    DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo == null) {
            return new DownloadData();
        }
        DownloadData downloadData = new DownloadData(advertAppInfo.dWm);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dWk);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.dWj, 0));
        return downloadData;
    }

    private void bAZ() {
        if (this.foz != null && this.foA != null) {
            com.baidu.tieba.ad.download.d.bBg().a(this.foz, this.foA);
        }
    }

    private void bBa() {
        if (this.foz != null && this.foA != null) {
            com.baidu.tieba.ad.download.d.bBg().b(this.foz, this.foA);
        }
    }

    public void onDestroy() {
        bBa();
    }

    public void onCreate() {
        bAZ();
    }
}
