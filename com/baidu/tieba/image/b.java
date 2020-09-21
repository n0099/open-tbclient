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
/* loaded from: classes20.dex */
public class b {
    private TBSpecificationBtn ajy;
    private DragImageView.d eKd;
    private DownloadCacheKey frG;
    private TbImageView hIp;
    private AdvertAppInfo jPE;
    private AdCard jPJ;
    private RelativeLayout jPM;
    public TextView jPN;
    public TextView jPO;
    public TextView jPP;
    private UrlDragImageView jPR;
    private RelativeLayout jPS;
    private RelativeLayout jPT;
    public TbImageView jPU;
    private ApkDownloadView jPV;
    private Context mContext;
    public boolean jPQ = false;
    private com.baidu.tieba.ad.download.a.d frH = null;

    public b(ViewGroup viewGroup, TbPageContext<?> tbPageContext) {
        this.jPM = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.big_image_ad, (ViewGroup) null);
        this.hIp = (TbImageView) this.jPM.findViewById(R.id.big_image_ad_image);
        this.ajy = (TBSpecificationBtn) this.jPM.findViewById(R.id.image_ad_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bb(R.color.cp_link_tip_a, R.color.cp_cont_a);
        this.ajy.setConfig(bVar);
        this.jPN = (TextView) this.jPM.findViewById(R.id.ad_title);
        this.jPO = (TextView) this.jPM.findViewById(R.id.ad_brand);
        this.jPP = (TextView) this.jPM.findViewById(R.id.ad_tag);
        this.jPS = (RelativeLayout) this.jPM.findViewById(R.id.ad_info_container);
        this.jPT = (RelativeLayout) this.jPM.findViewById(R.id.bottom_container);
        this.jPU = (TbImageView) this.jPM.findViewById(R.id.video_ad_play_icon);
        this.mContext = viewGroup.getContext();
        this.jPV = (ApkDownloadView) this.jPM.findViewById(R.id.image_download_button);
        if (tbPageContext != null) {
            this.jPV.x(tbPageContext.getUniqueId());
        }
        this.jPV.setTextSize(R.dimen.tbds39);
        this.jPV.setTextColorInitSkin(R.color.cp_cont_a);
        this.jPV.setBackgroundSkin(R.drawable.pic_page_down_btn_bg);
        this.jPV.changeSkin();
        cNR();
    }

    public View getView() {
        return this.jPM;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.eKd = dVar;
    }

    public void cNR() {
        this.hIp.setVisibility(4);
        this.jPR = new UrlDragImageView(this.mContext);
        this.jPR.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.jPR.setIsCanDrag(true);
        this.jPR.setCanScale(false);
        this.jPR.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.1
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.eKd != null) {
                    b.this.eKd.onDragStart();
                }
                b.this.p(b.this.jPN, 8);
                b.this.p(b.this.jPO, 8);
                b.this.p(b.this.jPP, 8);
                b.this.p(b.this.jPS, 8);
                b.this.p(b.this.jPU, 8);
                b.this.p(b.this.ajy, 8);
                b.this.p(b.this.jPV, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragEnd() {
                if (b.this.eKd != null) {
                    b.this.eKd.onDragEnd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void bxi() {
                if (b.this.eKd != null) {
                    b.this.eKd.bxi();
                }
                b.this.p(b.this.jPN, 0);
                b.this.p(b.this.jPO, 0);
                b.this.p(b.this.jPP, 0);
                b.this.p(b.this.jPS, 0);
                if (b.this.jPE != null) {
                    b.this.p(b.this.jPU, b.this.jPE.bds() ? 0 : 8);
                    if (b.this.jPE.bdr()) {
                        b.this.p(b.this.ajy, 0);
                    } else {
                        b.this.p(b.this.jPV, 0);
                    }
                }
            }
        });
        this.jPM.addView(this.jPR, 0);
    }

    public UrlDragImageView cNS() {
        return this.jPR;
    }

    public TbImageView cNT() {
        return this.hIp;
    }

    public void cNU() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams layoutParams = this.hIp.getLayoutParams();
            double loadedHeight = this.hIp.getLoadedHeight() / this.hIp.getLoadedWidth();
            if (loadedHeight > 1.0d) {
                layoutParams.height = width;
                layoutParams.width = (int) (width / loadedHeight);
            } else {
                layoutParams.height = (int) (loadedHeight * width);
                layoutParams.width = width;
            }
            this.hIp.setLayoutParams(layoutParams);
        }
    }

    public void E(final View.OnClickListener onClickListener) {
        if (this.ajy != null) {
            this.ajy.setOnClickListener(onClickListener);
        }
        if (this.hIp != null) {
            this.hIp.setOnClickListener(onClickListener);
        }
        if (this.jPT != null) {
            this.jPT.setOnClickListener(onClickListener);
        }
        if (this.jPU != null) {
            this.jPU.setOnClickListener(onClickListener);
        }
        this.jPR.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.2
            private float jPX = 0.0f;
            private float jPY = 0.0f;
            private float jPZ = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.jPQ = false;
                        this.jPX = motionEvent.getX();
                        this.jPY = motionEvent.getY();
                        this.jPZ = 0.0f;
                        break;
                    case 1:
                        b.this.jPQ = 10.0f < this.jPZ;
                        if (!b.this.jPQ) {
                            onClickListener.onClick(b.this.hIp);
                            break;
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.jPX;
                        float y = motionEvent.getY() - this.jPY;
                        this.jPZ = (float) (Math.sqrt((x * x) + (y * y)) + this.jPZ);
                        this.jPX = motionEvent.getX();
                        this.jPY = motionEvent.getY();
                        break;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(@NonNull View view, int i) {
        view.setVisibility(i);
    }

    public void a(AdvertAppInfo advertAppInfo, AdCard adCard) {
        if (advertAppInfo != null && adCard != null) {
            this.jPE = advertAppInfo;
            this.jPJ = adCard;
            if (this.jPE.bdr()) {
                String str = this.jPE.dYC.buttonText;
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.check_immediately);
                }
                this.ajy.setText(str);
                this.jPV.setVisibility(8);
                this.ajy.setVisibility(0);
                return;
            }
            this.jPV.setClickable(true);
            this.jPV.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.image.b.3
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public boolean bG(View view) {
                    com.baidu.tieba.lego.card.b.c.a(com.baidu.tieba.lego.card.b.c.d(b.this.jPE));
                    if (b.this.mContext == null || !s.PL(b.this.jPJ.getScheme()) || !s.isInstalledPackage(b.this.mContext, b.this.jPE.dYw)) {
                        if (b.this.mContext != null && !y.aw((Activity) b.this.mContext)) {
                            l.showToast((Activity) b.this.mContext, (int) R.string.write_external_storage_permission_denied_fun_disable);
                        }
                        return false;
                    }
                    s.aU(b.this.mContext, b.this.jPJ.getScheme());
                    return true;
                }
            });
            DownloadData b = b(this.jPE, com.baidu.adp.lib.f.b.toInt(this.jPE.adPosition, -1));
            h(b);
            this.jPV.setData(b);
            this.jPV.setVisibility(0);
            this.ajy.setVisibility(8);
            a(adCard, advertAppInfo);
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey DU;
        if (advertAppInfo != null && advertAppInfo.bdq() && adCard != null) {
            String scheme = adCard.getScheme();
            String str = advertAppInfo.dYt;
            if (!TextUtils.isEmpty(str)) {
                DU = com.baidu.tieba.ad.download.d.bCs().DT(str);
            } else {
                DU = com.baidu.tieba.ad.download.d.bCs().DU(scheme);
            }
            if (DU == null) {
                DU = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.dYw);
                com.baidu.tieba.ad.download.d.bCs().a(DU, null);
            }
            i(DU);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.frG = downloadCacheKey;
            bCm();
            this.frH = null;
            AdDownloadData d = com.baidu.tieba.ad.download.d.bCs().d(downloadCacheKey);
            this.jPV.a(d.getCurrentState());
            String str = "";
            if (this.jPJ != null && this.jPJ.getAdvertAppInfo() != null) {
                str = this.jPJ.getAdvertAppInfo().page;
                d.setExtInfo(this.jPJ.getAdvertAppInfo().extensionInfo);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.jPV, d, str);
            this.frH = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d != null && d.extra() != null && d.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d);
            }
            bCl();
        }
    }

    private void h(DownloadData downloadData) {
        if (downloadData != null) {
            downloadData.setStatus(this.jPV.getDownloadStatus());
        }
    }

    DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        if (advertAppInfo == null) {
            return new DownloadData();
        }
        DownloadData downloadData = new DownloadData(advertAppInfo.dYw);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dYu);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.dYt, 0));
        return downloadData;
    }

    private void bCl() {
        if (this.frG != null && this.frH != null) {
            com.baidu.tieba.ad.download.d.bCs().a(this.frG, this.frH);
        }
    }

    private void bCm() {
        if (this.frG != null && this.frH != null) {
            com.baidu.tieba.ad.download.d.bCs().b(this.frG, this.frH);
        }
    }

    public void onDestroy() {
        bCm();
    }

    public void onCreate() {
        bCl();
    }
}
