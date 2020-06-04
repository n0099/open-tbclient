package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.mvp.b;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.lego.card.b.a;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.download.e;
import com.baidu.tieba.recapp.download.h;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.recapp.view.AdThreadUserInfoLayout;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.webkit.internal.ETAG;
import com.tencent.open.SocialConstants;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public abstract class AdCardBaseView extends BaseLegoCardView<AdCard> implements com.baidu.tieba.lego.card.b.a {
    private DownloadCacheKey eOp;
    private com.baidu.tieba.ad.download.a.d eOq;
    protected View gES;
    protected View gEv;
    protected TextView iSq;
    protected TextView iSs;
    private a.C0655a iYB;
    private final int jai;
    protected TextView kMA;
    private AdCloseView kMB;
    private LinearLayout kMC;
    protected ApkDownloadView kMD;
    protected TextView kME;
    protected RelativeLayout kMF;
    protected View kMG;
    protected String kMH;
    private AdCard kMI;
    private AdThreadCommentAndPraiseInfoLayout kMJ;
    protected AdThreadUserInfoLayout kMK;
    protected View kML;
    protected View kMM;
    protected AdCard.b kMN;
    private FrameLayout kMO;
    private View kMP;
    protected CustomMessageListener kMQ;
    protected CustomMessageListener kMR;
    protected CustomMessageListener kMS;
    protected ViewStub kMi;
    protected View kMj;
    protected View kMk;
    protected final int kMl;
    protected final int kMm;
    protected final int kMn;
    protected final int kMo;
    protected final int kMp;
    protected final int kMq;
    protected final int kMr;
    protected final int kMs;
    private final int kMt;
    private final int kMu;
    private final int kMv;
    private final int kMw;
    private int kMx;
    private int kMy;
    private int kMz;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void cX(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.jai = l.getEquipmentWidth(getContext());
        this.eOq = null;
        this.kMQ = new a(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG, this);
        this.kMR = new d(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG, this);
        this.kMS = new c(CmdConfigCustom.CMD_USER_INFO_CHANGED, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.ds640);
        this.mImageHeight = (int) resources.getDimension(R.dimen.ds278);
        this.kMl = (int) resources.getDimension(R.dimen.tbds92);
        this.kMm = (int) resources.getDimension(R.dimen.tbds92);
        this.kMn = (int) resources.getDimension(R.dimen.tbds20);
        this.kMq = (int) resources.getDimension(R.dimen.tbds90);
        this.kMr = (int) resources.getDimension(R.dimen.tbds90);
        this.kMs = (int) resources.getDimension(R.dimen.tbds22);
        this.kMo = (int) resources.getDimension(R.dimen.tbds44);
        this.kMp = (int) resources.getDimension(R.dimen.tbds44);
        this.kMx = (int) resources.getDimension(R.dimen.ds12);
        this.kMy = (int) resources.getDimension(R.dimen.ds1);
        this.kMz = (int) resources.getDimension(R.dimen.ds18);
        this.kMt = (int) resources.getDimension(R.dimen.tbds208);
        this.kMu = (int) resources.getDimension(R.dimen.tbds33);
        this.kMv = (int) resources.getDimension(R.dimen.tbds72);
        this.kMw = (int) resources.getDimension(R.dimen.tbds48);
    }

    protected void B(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.kMJ.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ctJ() {
        MessageManager.getInstance().registerListener(this.kMQ);
        MessageManager.getInstance().registerListener(this.kMR);
        MessageManager.getInstance().registerListener(this.kMS);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.gES = this.mRootView.findViewById(R.id.bottom_line);
        this.kMP = this.mRootView.findViewById(R.id.top_line);
        this.kMk = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.kMk.setClickable(true);
        this.iSq = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.kMA = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.kMD = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.kME = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.kMF = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.kMD.x(this.dIF.getUniqueId());
        this.kMQ.setTag(this.dIF.getUniqueId());
        this.kMG = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.kMR.setTag(this.dIF.getUniqueId());
        this.kMS.setTag(this.dIF.getUniqueId());
        this.kMJ = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.kMJ.setStyle(1);
        this.kMK = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        this.kMO = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        if (1 == getBusinessType()) {
            this.kMK.setShowFlag(1413);
        }
        this.kMC = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.kMB = (AdCloseView) this.kMC.findViewById(R.id.ad_close_view);
        this.iSs = (TextView) this.kMC.findViewById(R.id.feed_tag);
        this.iSs.setVisibility(8);
        this.kMJ.addAdMoreView(this.kMC);
        this.gEv = this.mRootView.findViewById(R.id.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.kMo) - this.kMp) - this.kMl) - this.kMn;
            this.kMJ.setVisibility(8);
        } else {
            this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.kMo) - this.kMp;
            this.kMJ.setVisibility(0);
        }
        this.kMi = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.kMi.setLayoutResource(getCustomLayout());
        this.kMj = this.kMi.inflate();
        this.kML = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.kMM = this.mRootView.findViewById(R.id.frs_bottom_view);
        cX(this.kMj);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(final AdCard adCard) {
        final String str;
        int i;
        this.kMI = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.kMK.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.aXO() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.dIF.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        a(adCard, bVar);
        this.kMA.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kMG.getLayoutParams();
        if (4 == getBusinessType()) {
            if (adCard.isPBBanner) {
                layoutParams.leftMargin = 0;
                this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.kMo) - this.kMp;
            } else {
                layoutParams.leftMargin = this.kMl + this.kMn;
                this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.kMo) - this.kMp) - this.kMl) - this.kMn;
            }
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.kMK.getHeaderImg(), adCard.portraitClick, bVar);
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String Ll = Ll(str2);
            this.iSq.setMaxLines(adCard.titleLines <= 0 ? 4 : adCard.titleLines);
            if (4 == getBusinessType()) {
                this.iSq.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize42));
            } else {
                this.iSq.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize44));
            }
            this.iSq.setText(Ll);
            this.iSq.setVisibility(0);
        } else {
            this.iSq.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.aOA()) && k.isEmpty(str3);
        a(this.kMF, this.kMA, this.kMD, adCard);
        int i2 = (this.mMaxWidth - this.kMt) - this.kMw;
        if (4 == getBusinessType()) {
            this.kME.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize30));
            i = i2 - (this.kMu + this.kMv);
        } else {
            i = i2;
        }
        String str4 = null;
        if (advertAppInfo != null && advertAppInfo.aOz()) {
            str4 = adCard.userName.concat("APP");
        } else if (advertAppInfo != null && advertAppInfo.aOA()) {
            str4 = TextUtils.isEmpty(adCard.userName) ? "广告" : adCard.userName;
        }
        this.kME.setText(com.baidu.b.a.e.a.a(str4, "广告", i, this.kME.getPaint()));
        if (advertAppInfo != null && advertAppInfo.aOz()) {
            this.kMH = advertAppInfo.dAx;
            this.kMD.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            a(adCard, c2);
            a(this.kMA, c2.getStatus(), str3);
            this.kMD.setData(c2);
            this.kMD.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    am.setViewTextColor(this.kMA, R.color.cp_link_tip_a, 1);
                    am.setBackgroundResource(this.kMA, R.drawable.ad_download_progress_button_bg);
                    this.kMA.setText(str3);
                    if (k.isEmpty(str)) {
                        this.kMA.setClickable(false);
                    } else {
                        this.kMA.setClickable(true);
                        this.kMA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.jab != null && adCard.buttonClick != null && !t.Mu(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.jab.a(adCard.buttonClick.anr, adCard.buttonClick.ans, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int b2 = r.b(AdCardBaseView.this.dIF, str, (AdCardBaseView.this.kMI == null || AdCardBaseView.this.kMI.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.kMI.getAdvertAppInfo().dAu);
                                        if ((b2 == 1 || b2 == 2) && AdCardBaseView.this.jab != null) {
                                            AdCardBaseView.this.jab.d(b2, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.dIF.getPageActivity());
                                    aVar.vO(adCard.popWindowText);
                                    aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int b3 = r.b(AdCardBaseView.this.dIF, str, (AdCardBaseView.this.kMI == null || AdCardBaseView.this.kMI.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.kMI.getAdvertAppInfo().dAu);
                                            if ((b3 == 1 || b3 == 2) && AdCardBaseView.this.jab != null) {
                                                AdCardBaseView.this.jab.d(b3, null);
                                            }
                                            aVar2.dismiss();
                                        }
                                    });
                                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.2
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            aVar2.dismiss();
                                        }
                                    });
                                    aVar.b(AdCardBaseView.this.dIF).aST();
                                }
                            }
                        });
                    }
                } else {
                    this.kMA.setClickable(false);
                    this.kMA.setText(adCard.buttonTextDone);
                    am.setBackgroundResource(this.kMA, R.drawable.ad_download_progress_button_bg);
                    am.setViewTextColor(this.kMA, R.color.cp_btn_a, 1);
                }
            }
            this.kMD.setVisibility(8);
        }
        a(adCard);
        B(com.baidu.tbadk.core.k.aNQ().isShowImages(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            Lm(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.dAD != null && advertAppInfo.dAD.adCloseInfo != null && advertAppInfo.dAD.adCloseInfo.support_close.intValue() > 0) {
            this.kMB.setVisibility(0);
            this.kMB.setPage(getBusinessType());
            this.kMB.setData(advertAppInfo);
            l.addToParentArea(this.dIF.getPageActivity(), this.kMC, 40, 40, 40, 120);
            this.kMC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.kMB.performClick();
                }
            });
        } else {
            this.kMB.setVisibility(8);
            this.iSs.setOnClickListener(null);
        }
        this.kMJ.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.gES.getLayoutParams();
        if (4 == getBusinessType()) {
            this.kMJ.setVisibility(8);
            this.kMJ.setBarNameClickEnabled(false);
            this.kMJ.setShareVisible(false);
            this.kMJ.setShowPraiseNum(false);
            this.kMJ.setCommentNumEnable(false);
            this.kMJ.setReplyTimeVisible(false);
            layoutParams2.height = this.kMy;
            this.kML.setVisibility(0);
            this.kMM.setVisibility(8);
            this.gES.setVisibility(8);
            cY(this.kMC);
        } else {
            b(adCard, bVar);
            this.gES.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.kMD.getLayoutParams()).addRule(11, -1);
            ((RelativeLayout.LayoutParams) this.kMA.getLayoutParams()).addRule(11, -1);
            this.kMO.setVisibility(8);
            this.kMF.requestLayout();
        }
        a(adCard, this.gEv, getBusinessType());
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 instanceof AdvertAppInfo) {
            advertAppInfo2.vz(aq.cj(adCard.time));
        }
        this.kMK.setData(advertAppInfo2);
        ((TextView) this.kMK.getUserName()).setText(adCard.userName);
        this.kMK.getUserName().setOnClickListener(bVar);
        this.kMK.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.kMK.getUserName()).setText(adCard.userName);
            }
        });
        if (4 == getBusinessType() && adCard.isPBBanner) {
            this.kMP.setVisibility(0);
            this.kMP.setBackgroundResource(R.color.cp_bg_line_b);
            this.kMK.setVisibility(8);
        } else {
            this.kMP.setVisibility(8);
        }
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bTZ().bUa()) {
            this.kMk.setVisibility(0);
            am.setBackgroundColor(this.kMk, R.color.cp_bg_line_d);
        } else {
            this.kMk.setVisibility(8);
        }
        a(adCard, advertAppInfo);
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private void cY(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((FrameLayout) view.getParent()).removeView(view);
            }
            this.kMO.setVisibility(0);
            this.kMO.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.kMO.addView(view);
            int dimension = (int) getResources().getDimension(R.dimen.tbds26);
            int dimension2 = (int) getResources().getDimension(R.dimen.tbds33);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kMD.getLayoutParams();
            layoutParams.setMargins(0, dimension, dimension2, dimension);
            layoutParams.addRule(11, 0);
            layoutParams.addRule(0, this.kMO.getId());
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kMA.getLayoutParams();
            layoutParams2.addRule(11, 0);
            layoutParams2.setMargins(0, dimension, dimension2, dimension);
            layoutParams2.addRule(0, this.kMO.getId());
            this.kMF.requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bmz();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bmA();
    }

    private void a(AdCard adCard, DownloadData downloadData) {
        if (adCard.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.kMD.getDownloadStatus());
        }
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.directDownload) {
            this.kMD.setOnClickListener(bVar);
        } else {
            this.kMD.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public void br(View view) {
                    AdCardBaseView.this.cUU();
                }
            });
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey zY;
        if (!adCard.directDownload && advertAppInfo != null && advertAppInfo.aOz()) {
            String scheme = adCard.getScheme();
            String str = advertAppInfo.dAu;
            if (!TextUtils.isEmpty(str)) {
                zY = com.baidu.tieba.ad.download.d.bmF().zX(str);
            } else {
                zY = com.baidu.tieba.ad.download.d.bmF().zY(scheme);
            }
            if (zY == null) {
                zY = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.dAx);
                com.baidu.tieba.ad.download.d.bmF().a(zY, null);
            }
            i(zY);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.eOp = downloadCacheKey;
            bmA();
            this.eOq = null;
            AdDownloadData d2 = com.baidu.tieba.ad.download.d.bmF().d(downloadCacheKey);
            if (d2 != null) {
                this.kMD.a(d2.getCurrentState());
            } else {
                this.kMD.a(DownloadStatus.STATUS_NONE);
            }
            String str = "";
            if (this.kMI != null && this.kMI.getAdvertAppInfo() != null) {
                str = this.kMI.getAdvertAppInfo().page;
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.kMD, d2, str);
            this.eOq = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d2.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d2);
            }
            bmz();
        }
    }

    private void bmz() {
        if (this.eOp != null && this.eOq != null) {
            com.baidu.tieba.ad.download.d.bmF().a(this.eOp, this.eOq);
        }
    }

    private void bmA() {
        if (this.eOp != null && this.eOq != null) {
            com.baidu.tieba.ad.download.d.bmF().b(this.eOp, this.eOq);
        }
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void b(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.kMM.setVisibility(0);
            this.kMJ.setVisibility(8);
            return;
        }
        this.kMM.setVisibility(8);
        this.kMJ.setVisibility(0);
        this.kMJ.setBarNameClickEnabled(false);
        this.kMJ.setReplyTimeVisible(false);
        this.kMJ.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.kMJ.setAgreeClickable(true);
            this.kMJ.setPraiseContainerBgGray(false);
        } else {
            this.kMJ.setAgreeClickable(false);
            this.kMJ.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.kMJ.setShareClickable(true);
            this.kMJ.setShareContainerBgGray(false);
        } else {
            this.kMJ.setShareClickable(false);
            this.kMJ.setShareContainerBgGray(true);
        }
        if (this.kMJ.getCommentContainer() != null) {
            this.kMJ.getCommentContainer().setOnClickListener(bVar);
        }
        this.kMJ.setNeedAddReplyIcon(true);
        this.kMJ.setCommentNumEnable(false);
        this.kMJ.setCommentClickable(true);
        this.kMJ.setReplayContainerBgGray(true);
        this.kMJ.setOnClickListener(bVar);
        this.kMJ.setShareData(adCard);
        this.kMJ.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        am.setBackgroundResource(this.gES, R.color.cp_bg_line_b);
        this.kMB.onChangeSkinType();
        this.kMK.onChangeSkinType(this.dIF, TbadkCoreApplication.getInst().getSkinType());
        this.kMJ.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.gEv, R.color.cp_bg_line_e);
        } else {
            am.setBackgroundColor(this.gEv, R.color.transparent);
        }
        am.setViewTextColor(this.iSq, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.kME, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.iSs, R.color.cp_cont_d, 1);
        this.kMD.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String Ll(String str) {
        if (!StringUtils.isNull(str)) {
            String replaceAll = str.replaceAll("，", "， ").replaceAll("。", "。 ").replaceAll("？", "？ ").replaceAll("！", "！ ").replaceAll("、", "、 ").replaceAll("‘", "’ ").replaceAll("“", "” ").replaceAll("【", "【 ").replaceAll("】", "】 ").replaceAll("；", "； ").replaceAll("：", "： ").replaceAll("（", "（ ").replaceAll("）", "） ").replaceAll("·", "· ").replaceAll(" ", "  ");
            if (replaceAll.charAt(replaceAll.length() - 1) == ' ') {
                replaceAll = replaceAll.substring(0, replaceAll.length() - 1);
            }
            return replaceAll;
        }
        return str;
    }

    protected void a(AdCard.b bVar) {
        int b2;
        if (bVar != null) {
            if (b(bVar) && !t.Mu(bVar.scheme)) {
                if (this.jab != null) {
                    this.jab.a(bVar.anr, bVar.ans, null);
                }
            } else if (this.kMI != null && this.kMI.getAdvertAppInfo() != null) {
                String Ln = Ln(bVar.scheme);
                String str = this.kMI.getAdvertAppInfo().dAu;
                if (!this.kMI.directDownload && this.kMI.getAdvertAppInfo().aOz()) {
                    b2 = r.c(this.dIF, Ln, str);
                } else {
                    b2 = r.b(this.dIF, Ln, str);
                }
                if (b2 == 1 || b2 == 2) {
                    if (this.jab != null) {
                        this.jab.d(b2, null);
                    }
                } else if (this.jab != null) {
                    this.jab.a(bVar.anr, bVar.ans, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final TbImageView tbImageView, final AdCard.b bVar) {
        if (tbImageView != null) {
            if (bVar != null && !k.isEmpty(bVar.scheme)) {
                tbImageView.setClickable(true);
                tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (AdCardBaseView.this.kMI.hasAnimation()) {
                            AdCardBaseView.this.k(tbImageView);
                        }
                        AdCardBaseView.this.a(bVar);
                    }
                });
                return;
            }
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, final AdCard.b bVar, b bVar2) {
        if (view != null) {
            if (bVar != null && !k.isEmpty(bVar.scheme)) {
                view.setClickable(true);
                view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        AdCardBaseView.this.a(bVar);
                    }
                });
                return;
            }
            view.setClickable(true);
            view.setOnClickListener(bVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(TbImageView tbImageView) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        tbImageView.getLocationOnScreen(iArr);
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + tbImageView.getWidth();
        rect.bottom = rect.top + tbImageView.getHeight();
        this.iYB = new a.C0655a();
        this.iYB.picUrl = tbImageView.getUrl();
        this.iYB.rect = rect;
    }

    private void Lm(String str) {
        int i = 0;
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray(SocialConstants.PARAM_IMAGE);
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            while (true) {
                int i2 = i;
                if (i2 < optJSONArray.length()) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i2);
                    com.baidu.adp.lib.e.c.kX().a(jSONObject.optString("pic_url"), 17, null, this.jai, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.jai), this.dIF.getUniqueId(), new Object[0]);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        } catch (Throwable th) {
        }
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView) {
        if (advertAppInfo != null) {
            if (advertAppInfo.aOy() != 0) {
                l.showToast(this.dIF.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.dIF.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.dIF.getPageActivity()) && this.jac != null) {
                this.jac.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.dIF.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aOz()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.dIF.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dIF.getPageActivity());
                aVar.vO(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.kMD);
                        if (AdCardBaseView.this.kMD != null) {
                            AdCardBaseView.this.kMD.q(AdCardBaseView.this.c(advertAppInfo, i));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.9
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.dIF).aST();
            }
        }
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView, boolean z) {
        if (advertAppInfo != null) {
            DownloadData c2 = c(advertAppInfo, i);
            switch (ApkDownloadView.getStatus(c2)) {
                case 1:
                case 5:
                    if (z) {
                        h.f(advertAppInfo);
                        apkDownloadView.r(c2);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    h.aN(this.dIF.getPageActivity(), advertAppInfo.dAx);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, this.kMD);
                    apkDownloadView.s(c2);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.bmF().aw(this.dIF.getPageActivity(), advertAppInfo.dAx);
                    return;
            }
        }
    }

    public a.C0655a getAnimationInfo() {
        return this.iYB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class b implements View.OnClickListener {
        private AdCard kNc;

        public b(AdCard adCard) {
            this.kNc = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdCardBaseView.this.dIF.showToast(R.string.neterror);
            } else if (this.kNc != null) {
                AdvertAppInfo advertAppInfo = this.kNc.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.kMD;
                if (advertAppInfo != null && advertAppInfo.aOz()) {
                    a(advertAppInfo, z);
                } else {
                    i(advertAppInfo);
                }
            }
        }

        private void a(AdvertAppInfo advertAppInfo, boolean z) {
            if (this.kNc.directDownload || z) {
                b(advertAppInfo, z);
            } else {
                j(advertAppInfo);
            }
        }

        private void i(AdvertAppInfo advertAppInfo) {
            String scheme = this.kNc.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.dAw;
            }
            if (this.kNc.hasAnimation()) {
            }
            int f = r.f(AdCardBaseView.this.dIF, AdCardBaseView.this.Ln(scheme));
            if (AdCardBaseView.this.jab != null) {
                AdCardBaseView.this.jab.d(f, null);
            }
        }

        private void b(AdvertAppInfo advertAppInfo, boolean z) {
            int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
            int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, i));
            if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                return;
            }
            AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.kMD, z);
            AdCardBaseView.this.cUU();
        }

        private void j(AdvertAppInfo advertAppInfo) {
            String scheme = this.kNc.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.dAw;
            }
            int c = r.c(AdCardBaseView.this.dIF, scheme, advertAppInfo.dAu);
            if (AdCardBaseView.this.jab != null) {
                AdCardBaseView.this.jab.d(c, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cUU() {
        if (this.jab != null) {
            this.jab.d(3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Ln(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.iYB != null && this.iYB.isValid()) {
            String c0655a = this.iYB.toString();
            if (!TextUtils.isEmpty(c0655a)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(c0655a));
            }
        }
        if (!TextUtils.isEmpty(this.kMI.getPreLoadData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.kMI.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.kMI.getNextPageData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.kMI.getNextPageData()));
        }
        if (this.kMI.hasAnimation()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.kMI.isGoLandingPage()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.kMI.isImmersiveStyle()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes13.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> kNb;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.kNb = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.kNb.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.kMH) ? false : true)) && adCardBaseView.kMH.equals(downloadData.getId())) {
                    int status = e.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.kMA.setText(R.string.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.kMA.setText(R.string.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> kNb;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.kNb = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.kNb.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.kMH) && adCardBaseView.kMH.equals(downloadData.getId())) {
                adCardBaseView.kMD.t(downloadData);
            }
        }
    }

    /* loaded from: classes13.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> kNb;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.kNb = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.kNb.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                String str = null;
                if (adCardBaseView.kMI != null && adCardBaseView.kMI.getAdvertAppInfo() != null) {
                    str = adCardBaseView.kMI.getAdvertAppInfo().dAu;
                }
                r.b(adCardBaseView.dIF, adCardBaseView.kMN.scheme, str);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void ctP() {
        if (4 == getBusinessType()) {
            this.iSq.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.kLS != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.kMN = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.dIF.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.dIF, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        return true;
    }

    private void a(View view, TextView textView, ApkDownloadView apkDownloadView, AdCard adCard) {
        if (adCard == null) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        if (adCard.getAdvertAppInfo().aOz()) {
            textView.setVisibility(8);
            apkDownloadView.setVisibility(0);
        } else if (k.isEmpty(adCard.buttonText)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dAx);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dAv);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.dAu, 0));
        return downloadData;
    }

    protected void a(TextView textView, int i, String str) {
        switch (i) {
            case 1:
            case 5:
                textView.setText(R.string.pause_load);
                return;
            case 2:
            case 4:
            default:
                return;
            case 3:
                textView.setText(R.string.downloaded_install);
                return;
            case 6:
                textView.setText(R.string.install_app);
                return;
            case 7:
                textView.setText(R.string.pb_download_pause);
                return;
            case 8:
                textView.setText(R.string.immediately_open);
                return;
        }
    }
}
