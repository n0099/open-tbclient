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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
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
    private DownloadCacheKey eYA;
    private com.baidu.tieba.ad.download.a.d eYB;
    protected View gRI;
    protected View gRl;
    private View ieC;
    protected TextView jjC;
    protected TextView jjE;
    private a.C0668a jpL;
    private final int jrs;
    protected View lgA;
    protected String lgB;
    private AdCard lgC;
    private AdThreadCommentAndPraiseInfoLayout lgD;
    protected AdThreadUserInfoLayout lgE;
    protected View lgF;
    protected View lgG;
    protected AdCard.b lgH;
    private FrameLayout lgI;
    protected CustomMessageListener lgJ;
    protected CustomMessageListener lgK;
    protected CustomMessageListener lgL;
    protected ViewStub lgc;
    protected View lgd;
    protected View lge;
    protected final int lgf;
    protected final int lgg;
    protected final int lgh;
    protected final int lgi;
    protected final int lgj;
    protected final int lgk;
    protected final int lgl;
    protected final int lgm;
    private final int lgn;
    private final int lgo;
    private final int lgp;
    private final int lgq;
    private int lgr;
    private int lgs;
    private int lgt;
    protected TextView lgu;
    private AdCloseView lgv;
    private LinearLayout lgw;
    protected ApkDownloadView lgx;
    protected TextView lgy;
    protected RelativeLayout lgz;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void cY(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.jrs = l.getEquipmentWidth(getContext());
        this.eYB = null;
        this.lgJ = new a(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG, this);
        this.lgK = new d(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG, this);
        this.lgL = new c(CmdConfigCustom.CMD_USER_INFO_CHANGED, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.ds640);
        this.mImageHeight = (int) resources.getDimension(R.dimen.ds278);
        this.lgf = (int) resources.getDimension(R.dimen.tbds92);
        this.lgg = (int) resources.getDimension(R.dimen.tbds92);
        this.lgh = (int) resources.getDimension(R.dimen.tbds20);
        this.lgk = (int) resources.getDimension(R.dimen.tbds90);
        this.lgl = (int) resources.getDimension(R.dimen.tbds90);
        this.lgm = (int) resources.getDimension(R.dimen.tbds22);
        this.lgi = (int) resources.getDimension(R.dimen.tbds44);
        this.lgj = (int) resources.getDimension(R.dimen.tbds44);
        this.lgr = (int) resources.getDimension(R.dimen.ds12);
        this.lgs = (int) resources.getDimension(R.dimen.ds1);
        this.lgt = (int) resources.getDimension(R.dimen.ds18);
        this.lgn = (int) resources.getDimension(R.dimen.tbds208);
        this.lgo = (int) resources.getDimension(R.dimen.tbds33);
        this.lgp = (int) resources.getDimension(R.dimen.tbds72);
        this.lgq = (int) resources.getDimension(R.dimen.tbds48);
    }

    protected void E(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.lgD.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cxz() {
        MessageManager.getInstance().registerListener(this.lgJ);
        MessageManager.getInstance().registerListener(this.lgK);
        MessageManager.getInstance().registerListener(this.lgL);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.gRI = this.mRootView.findViewById(R.id.bottom_line);
        this.ieC = this.mRootView.findViewById(R.id.top_line);
        this.lge = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.lge.setClickable(true);
        this.jjC = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.lgu = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.lgx = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.lgy = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.lgz = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.lgx.x(this.dPv.getUniqueId());
        this.lgJ.setTag(this.dPv.getUniqueId());
        this.lgA = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.lgK.setTag(this.dPv.getUniqueId());
        this.lgL.setTag(this.dPv.getUniqueId());
        this.lgD = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.lgD.setStyle(1);
        this.lgE = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        this.lgI = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        if (1 == getBusinessType()) {
            this.lgE.setShowFlag(1413);
        }
        this.lgw = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.lgv = (AdCloseView) this.lgw.findViewById(R.id.ad_close_view);
        this.jjE = (TextView) this.lgw.findViewById(R.id.feed_tag);
        this.jjE.setVisibility(8);
        this.lgD.addAdMoreView(this.lgw);
        this.gRl = this.mRootView.findViewById(R.id.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.lgi) - this.lgj) - this.lgf) - this.lgh;
            this.lgD.setVisibility(8);
        } else {
            this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.lgi) - this.lgj;
            this.lgD.setVisibility(0);
        }
        this.lgc = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.lgc.setLayoutResource(getCustomLayout());
        this.lgd = this.lgc.inflate();
        this.lgF = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.lgG = this.mRootView.findViewById(R.id.frs_bottom_view);
        cY(this.lgd);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(final AdCard adCard) {
        final String str;
        int i;
        this.lgC = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.lgE.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.aZT() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.dPv.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        a(adCard, bVar);
        this.lgu.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lgA.getLayoutParams();
        if (4 == getBusinessType()) {
            if (adCard.isPBBanner) {
                layoutParams.leftMargin = 0;
                this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.lgi) - this.lgj;
            } else {
                layoutParams.leftMargin = this.lgf + this.lgh;
                this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.lgi) - this.lgj) - this.lgf) - this.lgh;
            }
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.lgE.getHeaderImg(), adCard.portraitClick, bVar);
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String LM = LM(str2);
            this.jjC.setMaxLines(adCard.titleLines <= 0 ? 4 : adCard.titleLines);
            if (4 == getBusinessType()) {
                this.jjC.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize42));
            } else {
                this.jjC.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize44));
            }
            this.jjC.setText(LM);
            this.jjC.setVisibility(0);
        } else {
            this.jjC.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.aQk()) && k.isEmpty(str3);
        a(this.lgz, this.lgu, this.lgx, adCard);
        int i2 = (this.mMaxWidth - this.lgn) - this.lgq;
        if (4 == getBusinessType()) {
            this.lgy.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize30));
            i = i2 - (this.lgo + this.lgp);
        } else {
            i = i2;
        }
        String str4 = null;
        if (advertAppInfo != null && advertAppInfo.aQj()) {
            str4 = adCard.userName.concat("APP");
        } else if (advertAppInfo != null && advertAppInfo.aQk()) {
            str4 = TextUtils.isEmpty(adCard.userName) ? "广告" : adCard.userName;
        }
        this.lgy.setText(com.baidu.b.a.e.a.a(str4, "广告", i, this.lgy.getPaint()));
        if (advertAppInfo != null && advertAppInfo.aQj()) {
            this.lgB = advertAppInfo.dGO;
            this.lgx.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            a(adCard, c2);
            a(this.lgu, c2.getStatus(), str3);
            this.lgx.setData(c2);
            this.lgx.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    an.setViewTextColor(this.lgu, R.color.cp_link_tip_a, 1);
                    an.setBackgroundResource(this.lgu, R.drawable.ad_download_progress_button_bg);
                    this.lgu.setText(str3);
                    if (k.isEmpty(str)) {
                        this.lgu.setClickable(false);
                    } else {
                        this.lgu.setClickable(true);
                        this.lgu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.jrl != null && adCard.buttonClick != null && !t.MW(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.jrl.a(adCard.buttonClick.aoJ, adCard.buttonClick.aoK, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int c3 = r.c(AdCardBaseView.this.dPv, str, (AdCardBaseView.this.lgC == null || AdCardBaseView.this.lgC.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.lgC.getAdvertAppInfo().dGL);
                                        if ((c3 == 1 || c3 == 2) && AdCardBaseView.this.jrl != null) {
                                            AdCardBaseView.this.jrl.d(c3, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.dPv.getPageActivity());
                                    aVar.we(adCard.popWindowText);
                                    aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int c4 = r.c(AdCardBaseView.this.dPv, str, (AdCardBaseView.this.lgC == null || AdCardBaseView.this.lgC.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.lgC.getAdvertAppInfo().dGL);
                                            if ((c4 == 1 || c4 == 2) && AdCardBaseView.this.jrl != null) {
                                                AdCardBaseView.this.jrl.d(c4, null);
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
                                    aVar.b(AdCardBaseView.this.dPv).aUN();
                                }
                            }
                        });
                    }
                } else {
                    this.lgu.setClickable(false);
                    this.lgu.setText(adCard.buttonTextDone);
                    an.setBackgroundResource(this.lgu, R.drawable.ad_download_progress_button_bg);
                    an.setViewTextColor(this.lgu, R.color.cp_btn_a, 1);
                }
            }
            this.lgx.setVisibility(8);
        }
        a(adCard);
        E(com.baidu.tbadk.core.k.aPA().isShowImages(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            LN(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.dGU != null && advertAppInfo.dGU.adCloseInfo != null && advertAppInfo.dGU.adCloseInfo.support_close.intValue() > 0) {
            this.lgv.setVisibility(0);
            this.lgv.setPage(getBusinessType());
            this.lgv.setData(advertAppInfo);
            l.addToParentArea(this.dPv.getPageActivity(), this.lgw, 40, 40, 40, 120);
            this.lgw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.lgv.performClick();
                }
            });
        } else {
            this.lgv.setVisibility(8);
            this.jjE.setOnClickListener(null);
        }
        this.lgD.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.gRI.getLayoutParams();
        if (4 == getBusinessType()) {
            this.lgD.setVisibility(8);
            this.lgD.setBarNameClickEnabled(false);
            this.lgD.setShareVisible(false);
            this.lgD.setShowPraiseNum(false);
            this.lgD.setCommentNumEnable(false);
            this.lgD.setReplyTimeVisible(false);
            layoutParams2.height = this.lgs;
            this.lgF.setVisibility(0);
            this.lgG.setVisibility(8);
            this.gRI.setVisibility(8);
            cZ(this.lgw);
        } else {
            b(adCard, bVar);
            this.gRI.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.lgx.getLayoutParams()).addRule(11, -1);
            ((RelativeLayout.LayoutParams) this.lgu.getLayoutParams()).addRule(11, -1);
            this.lgI.setVisibility(8);
            this.lgz.requestLayout();
        }
        a(adCard, this.gRl, getBusinessType());
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 instanceof AdvertAppInfo) {
            advertAppInfo2.vP(ar.ck(adCard.time));
        }
        this.lgE.setData(advertAppInfo2);
        ((TextView) this.lgE.getUserName()).setText(adCard.userName);
        this.lgE.getUserName().setOnClickListener(bVar);
        this.lgE.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.lgE.getUserName()).setText(adCard.userName);
            }
        });
        if (4 == getBusinessType() && adCard.isPBBanner) {
            this.ieC.setVisibility(0);
            this.ieC.setBackgroundResource(R.color.cp_bg_line_b);
            this.lgE.setVisibility(8);
        } else {
            this.ieC.setVisibility(8);
        }
        if ((com.baidu.tieba.frs.b.bXd().bWX() || com.baidu.tieba.frs.a.bWW().bWX()) && isInFrsAllThread()) {
            this.lge.setVisibility(0);
            an.setBackgroundColor(this.lge, R.color.cp_bg_line_d);
        } else {
            this.lge.setVisibility(8);
        }
        a(adCard, advertAppInfo);
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private void cZ(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((FrameLayout) view.getParent()).removeView(view);
            }
            this.lgI.setVisibility(0);
            this.lgI.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.lgI.addView(view);
            int dimension = (int) getResources().getDimension(R.dimen.tbds26);
            int dimension2 = (int) getResources().getDimension(R.dimen.tbds33);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lgx.getLayoutParams();
            layoutParams.setMargins(0, dimension, dimension2, dimension);
            layoutParams.addRule(11, 0);
            layoutParams.addRule(0, this.lgI.getId());
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lgu.getLayoutParams();
            layoutParams2.addRule(11, 0);
            layoutParams2.setMargins(0, dimension, dimension2, dimension);
            layoutParams2.addRule(0, this.lgI.getId());
            this.lgz.requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        boZ();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bpa();
    }

    private void a(AdCard adCard, DownloadData downloadData) {
        if (adCard.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.lgx.getDownloadStatus());
        }
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.directDownload) {
            this.lgx.setOnClickListener(bVar);
        } else {
            this.lgx.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public void bu(View view) {
                    AdCardBaseView.this.cZl();
                }
            });
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey Ar;
        if (!adCard.directDownload && advertAppInfo != null && advertAppInfo.aQj()) {
            String scheme = adCard.getScheme();
            String str = advertAppInfo.dGL;
            if (!TextUtils.isEmpty(str)) {
                Ar = com.baidu.tieba.ad.download.d.bpg().Aq(str);
            } else {
                Ar = com.baidu.tieba.ad.download.d.bpg().Ar(scheme);
            }
            if (Ar == null) {
                Ar = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.dGO);
                com.baidu.tieba.ad.download.d.bpg().a(Ar, null);
            }
            i(Ar);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.eYA = downloadCacheKey;
            bpa();
            this.eYB = null;
            AdDownloadData d2 = com.baidu.tieba.ad.download.d.bpg().d(downloadCacheKey);
            if (d2 != null) {
                this.lgx.a(d2.getCurrentState());
            } else {
                this.lgx.a(DownloadStatus.STATUS_NONE);
            }
            String str = "";
            if (this.lgC != null && this.lgC.getAdvertAppInfo() != null) {
                str = this.lgC.getAdvertAppInfo().page;
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.lgx, d2, str);
            this.eYB = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d2.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d2);
            }
            boZ();
        }
    }

    private void boZ() {
        if (this.eYA != null && this.eYB != null) {
            com.baidu.tieba.ad.download.d.bpg().a(this.eYA, this.eYB);
        }
    }

    private void bpa() {
        if (this.eYA != null && this.eYB != null) {
            com.baidu.tieba.ad.download.d.bpg().b(this.eYA, this.eYB);
        }
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void b(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.lgG.setVisibility(0);
            this.lgD.setVisibility(8);
            return;
        }
        this.lgG.setVisibility(8);
        this.lgD.setVisibility(0);
        this.lgD.setBarNameClickEnabled(false);
        this.lgD.setReplyTimeVisible(false);
        this.lgD.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.lgD.setAgreeClickable(true);
            this.lgD.setPraiseContainerBgGray(false);
        } else {
            this.lgD.setAgreeClickable(false);
            this.lgD.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.lgD.setShareClickable(true);
            this.lgD.setShareContainerBgGray(false);
        } else {
            this.lgD.setShareClickable(false);
            this.lgD.setShareContainerBgGray(true);
        }
        if (this.lgD.getCommentContainer() != null) {
            this.lgD.getCommentContainer().setOnClickListener(bVar);
        }
        this.lgD.setNeedAddReplyIcon(true);
        this.lgD.setCommentNumEnable(false);
        this.lgD.setCommentClickable(true);
        this.lgD.setReplayContainerBgGray(true);
        this.lgD.setOnClickListener(bVar);
        this.lgD.setShareData(adCard);
        this.lgD.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        an.setBackgroundResource(this.gRI, R.color.cp_bg_line_b);
        this.lgv.onChangeSkinType();
        this.lgE.onChangeSkinType(this.dPv, TbadkCoreApplication.getInst().getSkinType());
        this.lgD.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            an.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            an.setBackgroundColor(this.gRl, R.color.cp_bg_line_e);
        } else {
            an.setBackgroundColor(this.gRl, R.color.transparent);
        }
        an.setViewTextColor(this.jjC, R.color.cp_cont_b, 1);
        an.setViewTextColor(this.lgy, (int) R.color.cp_cont_d);
        an.setViewTextColor(this.jjE, R.color.cp_cont_d, 1);
        this.lgx.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String LM(String str) {
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
        int c2;
        if (bVar != null) {
            if (b(bVar) && !t.MW(bVar.scheme)) {
                if (this.jrl != null) {
                    this.jrl.a(bVar.aoJ, bVar.aoK, null);
                }
            } else if (this.lgC != null && this.lgC.getAdvertAppInfo() != null) {
                String LO = LO(bVar.scheme);
                String str = this.lgC.getAdvertAppInfo().dGL;
                if (!this.lgC.directDownload && this.lgC.getAdvertAppInfo().aQj()) {
                    c2 = r.d(this.dPv, LO, str);
                } else {
                    c2 = r.c(this.dPv, LO, str);
                }
                if (c2 == 1 || c2 == 2) {
                    if (this.jrl != null) {
                        this.jrl.d(c2, null);
                    }
                } else if (this.jrl != null) {
                    this.jrl.a(bVar.aoJ, bVar.aoK, null);
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
                        if (AdCardBaseView.this.lgC.hasAnimation()) {
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
        this.jpL = new a.C0668a();
        this.jpL.picUrl = tbImageView.getUrl();
        this.jpL.rect = rect;
    }

    private void LN(String str) {
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
                    com.baidu.adp.lib.e.c.ln().a(jSONObject.optString("pic_url"), 17, null, this.jrs, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.jrs), this.dPv.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.aQi() != 0) {
                l.showToast(this.dPv.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.dPv.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.dPv.getPageActivity()) && this.jrm != null) {
                this.jrm.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.dPv.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aQj()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.dPv.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dPv.getPageActivity());
                aVar.we(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.lgx);
                        if (AdCardBaseView.this.lgx != null) {
                            AdCardBaseView.this.lgx.q(AdCardBaseView.this.c(advertAppInfo, i));
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
                aVar.b(this.dPv).aUN();
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
                    h.aN(this.dPv.getPageActivity(), advertAppInfo.dGO);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, this.lgx);
                    apkDownloadView.s(c2);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.bpg().aw(this.dPv.getPageActivity(), advertAppInfo.dGO);
                    return;
            }
        }
    }

    public a.C0668a getAnimationInfo() {
        return this.jpL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class b implements View.OnClickListener {
        private AdCard lgV;

        public b(AdCard adCard) {
            this.lgV = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdCardBaseView.this.dPv.showToast(R.string.neterror);
            } else if (this.lgV != null) {
                AdvertAppInfo advertAppInfo = this.lgV.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.lgx;
                if (advertAppInfo != null && advertAppInfo.aQj()) {
                    a(advertAppInfo, z);
                } else {
                    i(advertAppInfo);
                }
            }
        }

        private void a(AdvertAppInfo advertAppInfo, boolean z) {
            if (this.lgV.directDownload || z) {
                b(advertAppInfo, z);
            } else {
                j(advertAppInfo);
            }
        }

        private void i(AdvertAppInfo advertAppInfo) {
            String scheme = this.lgV.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.dGN;
            }
            if (this.lgV.hasAnimation()) {
            }
            int f = r.f(AdCardBaseView.this.dPv, AdCardBaseView.this.LO(scheme));
            if (AdCardBaseView.this.jrl != null) {
                AdCardBaseView.this.jrl.d(f, null);
            }
        }

        private void b(AdvertAppInfo advertAppInfo, boolean z) {
            int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
            int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, i));
            if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                return;
            }
            AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.lgx, z);
            AdCardBaseView.this.cZl();
        }

        private void j(AdvertAppInfo advertAppInfo) {
            String scheme = this.lgV.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.dGN;
            }
            int d = r.d(AdCardBaseView.this.dPv, scheme, advertAppInfo.dGL);
            if (AdCardBaseView.this.jrl != null) {
                AdCardBaseView.this.jrl.d(d, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cZl() {
        if (this.jrl != null) {
            this.jrl.d(3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String LO(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.jpL != null && this.jpL.isValid()) {
            String c0668a = this.jpL.toString();
            if (!TextUtils.isEmpty(c0668a)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(c0668a));
            }
        }
        if (!TextUtils.isEmpty(this.lgC.getPreLoadData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.lgC.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.lgC.getNextPageData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.lgC.getNextPageData()));
        }
        if (this.lgC.hasAnimation()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.lgC.isGoLandingPage()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.lgC.isImmersiveStyle()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes13.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> lgU;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.lgU = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.lgU.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.lgB) ? false : true)) && adCardBaseView.lgB.equals(downloadData.getId())) {
                    int status = e.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.lgu.setText(R.string.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.lgu.setText(R.string.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> lgU;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.lgU = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.lgU.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.lgB) && adCardBaseView.lgB.equals(downloadData.getId())) {
                adCardBaseView.lgx.t(downloadData);
            }
        }
    }

    /* loaded from: classes13.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> lgU;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.lgU = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.lgU.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                String str = null;
                if (adCardBaseView.lgC != null && adCardBaseView.lgC.getAdvertAppInfo() != null) {
                    str = adCardBaseView.lgC.getAdvertAppInfo().dGL;
                }
                r.c(adCardBaseView.dPv, adCardBaseView.lgH.scheme, str);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void cxF() {
        if (4 == getBusinessType()) {
            this.jjC.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.lfM != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.lgH = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.dPv.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.dPv, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        return true;
    }

    private void a(View view, TextView textView, ApkDownloadView apkDownloadView, AdCard adCard) {
        if (adCard == null) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        if (adCard.getAdvertAppInfo().aQj()) {
            textView.setVisibility(8);
            apkDownloadView.setVisibility(0);
        } else if (k.isEmpty(adCard.buttonText)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dGO);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dGM);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.dGL, 0));
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
