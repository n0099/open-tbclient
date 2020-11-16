package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Vibrator;
import android.support.annotation.StringRes;
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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
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
import com.baidu.tieba.tbadkCore.u;
import com.baidu.webkit.internal.ETAG;
import com.tencent.open.SocialConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public abstract class AdCardBaseView extends BaseLegoCardView<AdCard> implements com.baidu.tieba.lego.card.b.a {
    private DownloadCacheKey fRJ;
    private com.baidu.tieba.ad.download.a.d fRK;
    private a.C0779a kEp;
    private final int kFW;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    protected View mRootView;
    protected TextView mvA;
    protected RelativeLayout mvB;
    protected View mvC;
    protected String mvD;
    private AdCard mvE;
    private AdThreadCommentAndPraiseInfoLayout mvF;
    protected AdThreadUserInfoLayout mvG;
    protected View mvH;
    protected View mvI;
    protected AdCard.b mvJ;
    private FrameLayout mvK;
    private View mvL;
    private View mvM;
    protected CustomMessageListener mvN;
    protected CustomMessageListener mvO;
    protected CustomMessageListener mvP;
    protected ViewStub mvc;
    protected View mvd;
    protected View mve;
    protected final int mvf;
    protected final int mvg;
    protected final int mvh;
    protected final int mvi;
    private final int mvj;
    private final int mvk;
    protected final int mvl;
    private final int mvm;
    protected final int mvn;
    protected final int mvo;
    protected final int mvp;
    private final int mvq;
    private final int mvr;
    private final int mvs;
    private final int mvt;
    protected TextView mvu;
    protected TextView mvv;
    protected TextView mvw;
    private AdCloseView mvx;
    private LinearLayout mvy;
    protected ApkDownloadView mvz;

    protected abstract void a(AdCard adCard);

    protected abstract void dH(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kFW = l.getEquipmentWidth(getContext());
        this.fRK = null;
        this.mvN = new a(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG, this);
        this.mvO = new d(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG, this);
        this.mvP = new c(CmdConfigCustom.CMD_USER_INFO_CHANGED, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.tbds648);
        this.mImageHeight = (int) resources.getDimension(R.dimen.tbds488);
        this.mvf = (int) resources.getDimension(R.dimen.tbds92);
        this.mvg = (int) resources.getDimension(R.dimen.tbds92);
        this.mvh = (int) resources.getDimension(R.dimen.M_W_X004);
        this.mvn = (int) resources.getDimension(R.dimen.tbds90);
        this.mvo = (int) resources.getDimension(R.dimen.tbds90);
        this.mvp = (int) resources.getDimension(R.dimen.tbds22);
        if (com.baidu.tbadk.a.d.bhw()) {
            this.mvi = (int) resources.getDimension(R.dimen.M_W_X007);
            this.mvl = 0;
        } else {
            this.mvi = (int) resources.getDimension(R.dimen.M_W_X005);
            this.mvl = (int) resources.getDimension(R.dimen.M_W_X004);
        }
        this.mvm = 0;
        this.mvj = (int) resources.getDimension(R.dimen.M_W_X007);
        this.mvk = (int) resources.getDimension(R.dimen.M_H_X005);
        this.mvq = (int) resources.getDimension(R.dimen.tbds208);
        this.mvr = (int) resources.getDimension(R.dimen.tbds33);
        this.mvs = (int) resources.getDimension(R.dimen.tbds72);
        this.mvt = (int) resources.getDimension(R.dimen.tbds48);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cYK() {
        MessageManager.getInstance().registerListener(this.mvN);
        MessageManager.getInstance().registerListener(this.mvO);
        MessageManager.getInstance().registerListener(this.mvP);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.mvL = this.mRootView.findViewById(R.id.banner_top_divider);
        this.mve = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.mve.setClickable(true);
        this.mvu = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.mvv = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.mvz = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.mvA = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.mvB = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.mvz.x(this.eGu.getUniqueId());
        this.mvN.setTag(this.eGu.getUniqueId());
        this.mvC = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.mvO.setTag(this.eGu.getUniqueId());
        this.mvP.setTag(this.eGu.getUniqueId());
        this.mvF = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.mvF.setStyle(1);
        this.mvG = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        this.mvK = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        this.mvy = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mvx = (AdCloseView) this.mvy.findViewById(R.id.ad_close_view);
        ViewGroup.LayoutParams layoutParams = this.mvx.mzP.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.mvx.mzP.getLayoutParams();
        int dimens = l.getDimens(getContext(), R.dimen.tbds62);
        layoutParams2.width = dimens;
        layoutParams.height = dimens;
        this.mvw = (TextView) this.mvy.findViewById(R.id.feed_tag);
        this.mvw.setVisibility(8);
        this.mvG.addAdTagView(this.mvy);
        this.mvc = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.mvc.setLayoutResource(getCustomLayout());
        this.mvd = this.mvc.inflate();
        this.mvH = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.mvI = this.mRootView.findViewById(R.id.frs_bottom_view);
        this.mvM = this.mRootView.findViewById(R.id.pb_ad_bottom_divider);
        dH(this.mvd);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(AdCard adCard) {
        this.mvE = adCard;
        if (adCard != null) {
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            b bVar = new b(adCard);
            c(adCard);
            a(adCard, advertAppInfo, bVar);
            d2(adCard);
            b(adCard, advertAppInfo, bVar);
            a(adCard, advertAppInfo);
            g(advertAppInfo);
            b(adCard, bVar);
            this.mRootView.setOnClickListener(bVar);
            if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
                QS(adCard.getPreLoadData());
            }
            a(adCard);
            a(adCard, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void c(AdCard adCard) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mvC.getLayoutParams();
        layoutParams.topMargin = this.eGu.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        this.mvC.setPadding(0, 0, 0, 0);
        ((RelativeLayout.LayoutParams) this.mvz.getLayoutParams()).addRule(11, -1);
        ((RelativeLayout.LayoutParams) this.mvv.getLayoutParams()).addRule(11, -1);
        this.mvK.setVisibility(8);
        this.mvB.requestLayout();
        this.mvL.setVisibility(8);
        if (dAh()) {
            this.mRootView.setPadding(this.mvj, this.mvk, this.mvj, 0);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mvC.getLayoutParams();
            this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - (this.mvm * 2)) - (this.mvj * 2)) - this.mvf) - this.mvh;
            layoutParams2.leftMargin = this.mvf + this.mvh;
            this.mvM.setVisibility(0);
            dJ(this.mvy);
            if (e(adCard)) {
                this.mvM.setVisibility(8);
                this.mRootView.setPadding(0, 0, 0, 0);
                this.mvC.setPadding(this.mvj, 0, this.mvj, 0);
                layoutParams2.leftMargin = 0;
                this.mMaxWidth = (l.getEquipmentWidth(getContext()) - (this.mvj * 2)) - (this.mvm * 2);
                layoutParams.topMargin = this.eGu.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
                this.mvL.setVisibility(0);
                ap.setBackgroundColor(this.mvL, R.color.CAM_X0204);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mvz.getLayoutParams();
                layoutParams3.addRule(11, 0);
                layoutParams3.addRule(0, this.mvK.getId());
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mvv.getLayoutParams();
                layoutParams4.addRule(11, 0);
                layoutParams4.addRule(0, this.mvK.getId());
                this.mvB.requestLayout();
                dI(this.mvy);
                return;
            }
            return;
        }
        this.mRootView.setPadding(this.mvi, this.mvk, this.mvi, 0);
        this.mMaxWidth = (l.getEquipmentWidth(getContext()) - (this.mvi * 2)) - (this.mvl * 2);
        if ((com.baidu.tieba.frs.b.cwO().cwI() || com.baidu.tieba.frs.a.cwH().cwI()) && isInFrsAllThread()) {
            this.mve.setVisibility(0);
            ap.setBackgroundColor(this.mve, R.color.CAM_X0201);
        } else {
            this.mve.setVisibility(8);
        }
        this.mvM.setVisibility(8);
    }

    private void a(final AdCard adCard, final AdvertAppInfo advertAppInfo, b bVar) {
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 != null) {
            advertAppInfo2.Au(au.dt(adCard.time));
        }
        this.mvG.setShowFlag(1413);
        this.mvG.setData(advertAppInfo2);
        ((TextView) this.mvG.getUserName()).setText(adCard.userName);
        com.baidu.tbadk.a.b.a.e((TextView) this.mvG.getUserName());
        this.mvG.getUserName().setOnClickListener(bVar);
        this.mvG.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.mvG.getUserName()).setText(adCard.userName);
            }
        });
        this.mvG.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.btJ() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.eGu.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        a(this.mvG.getHeaderImg(), adCard.portraitClick, bVar);
        if (e(adCard)) {
            this.mvG.setVisibility(8);
        }
    }

    private void b(AdCard adCard, AdvertAppInfo advertAppInfo, b bVar) {
        if (adCard == null || advertAppInfo == null) {
            this.mvB.setVisibility(8);
            return;
        }
        this.mvB.setVisibility(0);
        if (advertAppInfo.bju()) {
            a(advertAppInfo, adCard, bVar);
            b(adCard, advertAppInfo);
        } else if (advertAppInfo.bjv()) {
            a(adCard, bVar);
        }
    }

    private void a(AdvertAppInfo advertAppInfo, AdCard adCard, b bVar) {
        this.mvv.setVisibility(8);
        this.mvz.setVisibility(0);
        this.mvz.setClickable(true);
        this.mvD = advertAppInfo.exf;
        DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
        a(adCard, c2);
        this.mvz.setData(c2);
        c(adCard, bVar);
    }

    private void a(final AdCard adCard, b bVar) {
        this.mvz.setVisibility(8);
        String str = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        final String str2 = bVar2 == null ? "" : bVar2.scheme;
        if (k.isEmpty(str) || (!TextUtils.isEmpty(adCard.buttonTextDone) && 1 != adCard.buttonStatus)) {
            this.mvv.setVisibility(8);
            this.mvv.setClickable(false);
            return;
        }
        this.mvv.setVisibility(0);
        this.mvv.setClickable(true);
        this.mvv.setText(str);
        ap.setViewTextColor(this.mvv, R.color.CAM_X0304, 1);
        ap.setBackgroundResource(this.mvv, R.drawable.ad_download_progress_button_bg);
        if (k.isEmpty(str2)) {
            this.mvv.setClickable(false);
        } else {
            this.mvv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AdCardBaseView.this.kFP != null && adCard.buttonClick != null && !u.QK(adCard.buttonClick.scheme)) {
                        AdCardBaseView.this.kFP.a(adCard.buttonClick.muL, adCard.buttonClick.muM, null);
                    }
                    if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                        if (TextUtils.isEmpty(adCard.popWindowText)) {
                            int c2 = r.c(AdCardBaseView.this.eGu, str2, (AdCardBaseView.this.mvE == null || AdCardBaseView.this.mvE.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.mvE.getAdvertAppInfo().exc);
                            if ((c2 == 1 || c2 == 2) && AdCardBaseView.this.kFP != null) {
                                AdCardBaseView.this.kFP.d(c2, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.eGu.getPageActivity());
                        aVar.AJ(adCard.popWindowText);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int c3 = r.c(AdCardBaseView.this.eGu, str2, (AdCardBaseView.this.mvE == null || AdCardBaseView.this.mvE.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.mvE.getAdvertAppInfo().exc);
                                if ((c3 == 1 || c3 == 2) && AdCardBaseView.this.kFP != null) {
                                    AdCardBaseView.this.kFP.d(c3, null);
                                }
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3.2
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(AdCardBaseView.this.eGu).bog();
                    }
                }
            });
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        int i = (this.mMaxWidth - this.mvq) - this.mvt;
        int i2 = dAh() ? i - (this.mvr + this.mvs) : i;
        String str = null;
        if (advertAppInfo != null && advertAppInfo.bju()) {
            str = adCard.userName.concat("APP");
        } else if (advertAppInfo != null && advertAppInfo.bjv()) {
            str = TextUtils.isEmpty(adCard.userName) ? "广告" : adCard.userName;
        }
        this.mvA.setText(com.baidu.tieba.recapp.lego.a.a.a(str, "广告", i2, this.mvA.getPaint()));
    }

    /* renamed from: d  reason: avoid collision after fix types in other method */
    private void d2(AdCard adCard) {
        String str = adCard.threadTitle;
        if (TextUtils.isEmpty(str)) {
            this.mvu.setVisibility(8);
            return;
        }
        this.mvu.setMaxLines(adCard.titleLines <= 0 ? 4 : adCard.titleLines);
        this.mvu.setText(str);
        this.mvu.setVisibility(0);
    }

    private void b(AdCard adCard, b bVar) {
        this.mvF.setType(TbadkCoreApplication.getInst().getCardShowType());
        if (dAh()) {
            this.mvF.setVisibility(8);
            this.mvF.setBarNameClickEnabled(false);
            this.mvF.setShareVisible(false);
            this.mvF.setShowPraiseNum(false);
            this.mvF.setCommentNumEnable(false);
            this.mvF.setReplyTimeVisible(false);
            this.mvH.setVisibility(0);
            this.mvI.setVisibility(8);
            return;
        }
        d(adCard, bVar);
    }

    private void g(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.exl != null && advertAppInfo.exl.adCloseInfo != null && advertAppInfo.exl.adCloseInfo.support_close.intValue() > 0) {
            this.mvx.setVisibility(0);
            this.mvx.setPage(getBusinessType());
            this.mvx.setData(advertAppInfo);
            l.addToParentArea(this.eGu.getPageActivity(), this.mvy, 40, 40, 40, 120);
            this.mvy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.mvx.performClick();
                }
            });
            return;
        }
        this.mvx.setVisibility(8);
        this.mvw.setOnClickListener(null);
    }

    private void dI(View view) {
        if (view != null && view.getVisibility() == 0) {
            this.mvK.setVisibility(0);
            if (view.getParent() == null || view.getParent() != this.mvK) {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                this.mvK.removeAllViews();
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                this.mvK.addView(view);
            }
        }
    }

    private void dJ(View view) {
        if (view != null && view.getVisibility() == 0) {
            this.mvK.setVisibility(8);
            if (view.getParent() == null || view.getParent() != this.mvG) {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                this.mvG.addAdTagView(this.mvy);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bII();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bIJ();
    }

    private void a(AdCard adCard, DownloadData downloadData) {
        if (adCard.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.mvz.getDownloadStatus());
        }
    }

    private void c(AdCard adCard, b bVar) {
        if (adCard.directDownload) {
            this.mvz.setOnClickListener(bVar);
        } else {
            this.mvz.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public boolean bS(View view) {
                    AdCardBaseView.this.dAg();
                    return false;
                }
            });
        }
    }

    private void b(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey EN;
        DownloadCacheKey downloadCacheKey;
        if (!adCard.directDownload) {
            String scheme = adCard.getScheme();
            String str = TextUtils.isEmpty(advertAppInfo.exf) ? advertAppInfo.exc : advertAppInfo.exf;
            if (!TextUtils.isEmpty(str)) {
                EN = com.baidu.tieba.ad.download.d.bIP().EM(str);
            } else {
                EN = com.baidu.tieba.ad.download.d.bIP().EN(scheme);
            }
            if (EN == null) {
                downloadCacheKey = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.exf);
                com.baidu.tieba.ad.download.d.bIP().a(downloadCacheKey, null);
            } else {
                downloadCacheKey = EN;
            }
            i(downloadCacheKey);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.fRJ = downloadCacheKey;
            bIJ();
            this.fRK = null;
            AdDownloadData d2 = com.baidu.tieba.ad.download.d.bIP().d(downloadCacheKey);
            if (d2 != null) {
                this.mvz.a(d2.getCurrentState());
            } else {
                this.mvz.a(DownloadStatus.STATUS_NONE);
            }
            String str = "";
            if (this.mvE != null && this.mvE.getAdvertAppInfo() != null) {
                str = this.mvE.getAdvertAppInfo().page;
                d2.setExtInfo(this.mvE.getAdvertAppInfo().extensionInfo);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mvz, d2, str);
            this.fRK = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d2.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d2);
            }
            bII();
        }
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

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void d(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.mvI.setVisibility(0);
            this.mvF.setVisibility(8);
            return;
        }
        this.mvI.setVisibility(8);
        this.mvF.setVisibility(0);
        this.mvF.setBarNameClickEnabled(false);
        this.mvF.setReplyTimeVisible(false);
        this.mvF.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.mvF.setAgreeClickable(true);
            this.mvF.setPraiseContainerBgGray(false);
        } else {
            this.mvF.setAgreeClickable(false);
            this.mvF.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.mvF.setShareClickable(true);
            this.mvF.setShareContainerBgGray(false);
        } else {
            this.mvF.setShareClickable(false);
            this.mvF.setShareContainerBgGray(true);
        }
        if (this.mvF.getCommentContainer() != null) {
            this.mvF.getCommentContainer().setOnClickListener(bVar);
        }
        this.mvF.setNeedAddReplyIcon(true);
        this.mvF.setCommentNumEnable(false);
        this.mvF.setCommentClickable(true);
        this.mvF.setReplayContainerBgGray(true);
        this.mvF.setOnClickListener(bVar);
        this.mvF.setShareData(adCard);
        this.mvF.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        this.mvx.onChangeSkinType();
        this.mvG.onChangeSkinType(this.eGu, TbadkCoreApplication.getInst().getSkinType());
        this.mvF.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            com.baidu.tbadk.core.elementsMaven.c.bj(this.mRootView).pb(com.baidu.tbadk.a.d.bhw() ? R.string.J_X02 : R.string.J_X06).aN(R.color.CAM_X0205, R.color.cp_bg_line_e_alpha50);
        }
        com.baidu.tbadk.a.b.a.f((TextView) this.mvG.getUserName());
        ap.setViewTextColor(this.mvu, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.mvA, R.color.CAM_X0109);
        ap.setViewTextColor(this.mvw, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.mvv, R.color.CAM_X0304, 1);
        ap.setBackgroundResource(this.mvv, R.drawable.ad_download_progress_button_bg);
        ap.setBackgroundColor(this.mvM, R.color.CAM_X0203);
        ap.setBackgroundColor(this.mvL, R.color.CAM_X0204);
        this.mvz.onChangeSkinType(i);
    }

    protected void a(AdCard.b bVar) {
        int c2;
        if (bVar != null) {
            if (b(bVar) && !u.QK(bVar.scheme)) {
                if (this.kFP != null) {
                    this.kFP.a(bVar.muL, bVar.muM, null);
                }
            } else if (this.mvE != null && this.mvE.getAdvertAppInfo() != null) {
                String QT = QT(bVar.scheme);
                String str = this.mvE.getAdvertAppInfo().exc;
                if (!this.mvE.directDownload && this.mvE.getAdvertAppInfo().bju()) {
                    c2 = r.d(this.eGu, QT, str);
                } else {
                    c2 = r.c(this.eGu, QT, str);
                }
                if (c2 == 1 || c2 == 2) {
                    if (this.kFP != null) {
                        this.kFP.d(c2, null);
                    }
                } else if (this.kFP != null) {
                    this.kFP.a(bVar.muL, bVar.muM, null);
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
                        if (AdCardBaseView.this.mvE.hasAnimation()) {
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
        this.kEp = new a.C0779a();
        this.kEp.picUrl = tbImageView.getUrl();
        this.kEp.bCa = rect;
    }

    private void QS(String str) {
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
                    com.baidu.adp.lib.e.c.mS().a(jSONObject.optString("pic_url"), 17, null, this.kFW, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.kFW), this.eGu.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.bjt() != 0) {
                l.showToast(this.eGu.getPageActivity(), R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.eGu.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.eGu.getPageActivity()) && this.kFQ != null) {
                this.kFQ.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.eGu.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bju()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.eGu.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eGu.getPageActivity());
                aVar.AJ(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.mvz);
                        if (AdCardBaseView.this.mvz != null) {
                            AdCardBaseView.this.mvz.q(AdCardBaseView.this.c(advertAppInfo, i));
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
                aVar.b(this.eGu).bog();
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
                        h.d(advertAppInfo);
                        apkDownloadView.r(c2);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    h.aU(this.eGu.getPageActivity(), advertAppInfo.exf);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, this.mvz);
                    apkDownloadView.s(c2);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.bIP().aD(this.eGu.getPageActivity(), advertAppInfo.exf);
                    return;
            }
        }
    }

    public a.C0779a getAnimationInfo() {
        return this.kEp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public class b implements View.OnClickListener {
        private AdCard mvY;

        public b(AdCard adCard) {
            this.mvY = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdCardBaseView.this.eGu.showToast(R.string.neterror);
            } else if (this.mvY != null && view != null && view.getId() != R.id.thread_info_commont_container) {
                AdvertAppInfo advertAppInfo = this.mvY.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.mvz;
                if (advertAppInfo != null && advertAppInfo.bju()) {
                    a(advertAppInfo, z);
                } else {
                    h(advertAppInfo);
                }
            }
        }

        private void a(AdvertAppInfo advertAppInfo, boolean z) {
            if (this.mvY.directDownload || z) {
                b(advertAppInfo, z);
            } else {
                i(advertAppInfo);
            }
        }

        private void h(AdvertAppInfo advertAppInfo) {
            String scheme = this.mvY.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.exe;
            }
            if (this.mvY.hasAnimation()) {
            }
            int c = r.c(AdCardBaseView.this.eGu, AdCardBaseView.this.QT(scheme), advertAppInfo.exf == null ? advertAppInfo.exc : advertAppInfo.exf);
            if (AdCardBaseView.this.kFP != null) {
                AdCardBaseView.this.kFP.d(c, null);
            }
        }

        private void b(AdvertAppInfo advertAppInfo, boolean z) {
            int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
            int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, i));
            if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                return;
            }
            AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.mvz, z);
            AdCardBaseView.this.dAg();
        }

        private void i(AdvertAppInfo advertAppInfo) {
            String scheme = this.mvY.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.exe;
            }
            int d = r.d(AdCardBaseView.this.eGu, scheme, advertAppInfo.exc);
            if (AdCardBaseView.this.kFP != null) {
                AdCardBaseView.this.kFP.d(d, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dAg() {
        if (this.kFP != null) {
            this.kFP.d(3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String QT(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.kEp != null && this.kEp.isValid()) {
            String c0779a = this.kEp.toString();
            if (!TextUtils.isEmpty(c0779a)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(c0779a));
            }
        }
        if (!TextUtils.isEmpty(this.mvE.getPreLoadData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.mvE.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.mvE.getNextPageData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.mvE.getNextPageData()));
        }
        if (this.mvE.hasAnimation()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.mvE.isGoLandingPage()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.mvE.isImmersiveStyle()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes25.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mvX;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mvX = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.mvX.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.mvD) && adCardBaseView.mvD.equals(downloadData.getId())) {
                int status = e.getStatus(downloadData);
                if (status == 7) {
                    adCardBaseView.mvv.setText(R.string.pause_load);
                } else if (status == 1 || status == 2) {
                    adCardBaseView.mvv.setText(R.string.pb_download_pause);
                }
            }
        }
    }

    /* loaded from: classes25.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mvX;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mvX = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.mvX.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.mvD) && adCardBaseView.mvD.equals(downloadData.getId())) {
                adCardBaseView.mvz.t(downloadData);
            }
        }
    }

    /* loaded from: classes25.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mvX;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mvX = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.mvX.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                String str = null;
                if (adCardBaseView.mvE != null && adCardBaseView.mvE.getAdvertAppInfo() != null) {
                    str = adCardBaseView.mvE.getAdvertAppInfo().exc;
                }
                r.c(adCardBaseView.eGu, adCardBaseView.mvJ.scheme, str);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void cYQ() {
        if (dAh()) {
            this.mvu.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.muN != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.mvJ = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.eGu.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.eGu, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        return true;
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.exf != null ? advertAppInfo.exf : advertAppInfo.exc);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.exd);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.exc, 0));
        return downloadData;
    }

    protected boolean dAh() {
        return getBusinessType() == 4;
    }

    protected boolean e(AdCard adCard) {
        return dAh() && adCard.isPBBanner;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float Iv(@StringRes int i) {
        try {
            return Float.parseFloat(TbadkCoreApplication.getInst().getContext().getResources().getString(i).split(Constants.ACCEPT_TIME_SEPARATOR_SP)[0]);
        } catch (Exception e) {
            return 0.0f;
        }
    }
}
