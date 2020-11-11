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
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
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
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.recapp.view.AdThreadUserInfoLayout;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.webkit.internal.ETAG;
import com.tencent.open.SocialConstants;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes26.dex */
public abstract class AdCardBaseView extends BaseLegoCardView<AdCard> implements com.baidu.tieba.lego.card.b.a {
    private DownloadCacheKey fSc;
    private com.baidu.tieba.ad.download.a.d fSd;
    protected View hYB;
    protected View hYe;
    private View jnu;
    private a.C0776a kEa;
    private final int kFH;
    private AdCard kxc;
    protected TextView kxg;
    protected TextView kxi;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    protected View mRootView;
    protected ViewStub muL;
    protected View muM;
    protected View muN;
    protected final int muO;
    protected final int muP;
    protected final int muQ;
    protected final int muR;
    protected final int muS;
    protected final int muT;
    protected final int muU;
    protected final int muV;
    private final int muW;
    private final int muX;
    private final int muY;
    private final int muZ;
    private int mva;
    private int mvb;
    private int mvc;
    protected TextView mvd;
    private AdCloseView mve;
    private LinearLayout mvf;
    protected ApkDownloadView mvg;
    protected TextView mvh;
    protected RelativeLayout mvi;
    protected View mvj;
    protected String mvk;
    private AdThreadCommentAndPraiseInfoLayout mvl;
    protected AdThreadUserInfoLayout mvm;
    protected View mvn;
    protected View mvo;
    protected AdCard.b mvp;
    private FrameLayout mvq;
    protected CustomMessageListener mvr;
    protected CustomMessageListener mvs;
    protected CustomMessageListener mvt;

    protected abstract void a(AdCard adCard);

    protected abstract void dD(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kFH = l.getEquipmentWidth(getContext());
        this.fSd = null;
        this.mvr = new a(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG, this);
        this.mvs = new d(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG, this);
        this.mvt = new c(CmdConfigCustom.CMD_USER_INFO_CHANGED, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.ds640);
        this.mImageHeight = (int) resources.getDimension(R.dimen.ds278);
        this.muO = (int) resources.getDimension(R.dimen.tbds92);
        this.muP = (int) resources.getDimension(R.dimen.tbds92);
        this.muQ = (int) resources.getDimension(R.dimen.tbds20);
        this.muT = (int) resources.getDimension(R.dimen.tbds90);
        this.muU = (int) resources.getDimension(R.dimen.tbds90);
        this.muV = (int) resources.getDimension(R.dimen.tbds22);
        this.muR = (int) resources.getDimension(R.dimen.tbds44);
        this.muS = (int) resources.getDimension(R.dimen.tbds44);
        this.mva = (int) resources.getDimension(R.dimen.ds12);
        this.mvb = (int) resources.getDimension(R.dimen.ds1);
        this.mvc = (int) resources.getDimension(R.dimen.ds18);
        this.muW = (int) resources.getDimension(R.dimen.tbds208);
        this.muX = (int) resources.getDimension(R.dimen.tbds33);
        this.muY = (int) resources.getDimension(R.dimen.tbds72);
        this.muZ = (int) resources.getDimension(R.dimen.tbds48);
    }

    protected void H(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.mvl.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cZo() {
        MessageManager.getInstance().registerListener(this.mvr);
        MessageManager.getInstance().registerListener(this.mvs);
        MessageManager.getInstance().registerListener(this.mvt);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.hYB = this.mRootView.findViewById(R.id.bottom_line);
        this.jnu = this.mRootView.findViewById(R.id.top_line);
        this.muN = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.muN.setClickable(true);
        this.kxg = (TextView) this.mRootView.findViewById(R.id.ad_title);
        com.baidu.tbadk.a.b.a.d(this.kxg, R.dimen.tbds32, R.dimen.tbds20);
        this.mvd = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.mvg = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.mvh = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.mvi = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.mvg.x(this.eIc.getUniqueId());
        this.mvr.setTag(this.eIc.getUniqueId());
        this.mvj = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.mvs.setTag(this.eIc.getUniqueId());
        this.mvt.setTag(this.eIc.getUniqueId());
        this.mvl = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.mvl.setStyle(1);
        this.mvm = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        this.mvq = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        if (1 == getBusinessType()) {
            this.mvm.setShowFlag(1413);
        }
        this.mvf = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mve = (AdCloseView) this.mvf.findViewById(R.id.ad_close_view);
        ViewGroup.LayoutParams layoutParams = this.mve.mzi.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.mve.mzi.getLayoutParams();
        int dimens = l.getDimens(getContext(), R.dimen.tbds62);
        layoutParams2.width = dimens;
        layoutParams.height = dimens;
        this.kxi = (TextView) this.mvf.findViewById(R.id.feed_tag);
        this.kxi.setVisibility(8);
        this.mvm.addAdTagView(this.mvf);
        this.hYe = this.mRootView.findViewById(R.id.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.muR) - this.muS) - this.muO) - this.muQ;
            this.mvl.setVisibility(8);
        } else {
            this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.muR) - this.muS;
            this.mvl.setVisibility(0);
        }
        this.muL = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.muL.setLayoutResource(getCustomLayout());
        this.muM = this.muL.inflate();
        com.baidu.tbadk.a.b.a.d(this.muM, R.dimen.tbds32, R.dimen.tbds14);
        this.mvn = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.mvo = this.mRootView.findViewById(R.id.frs_bottom_view);
        dD(this.muM);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(final AdCard adCard) {
        final String str;
        int i;
        this.kxc = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.mvm.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.but() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.eIc.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        a(adCard, bVar);
        this.mvd.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mvj.getLayoutParams();
        if (4 == getBusinessType()) {
            if (adCard.isPBBanner) {
                layoutParams.leftMargin = 0;
                this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.muR) - this.muS;
            } else {
                layoutParams.leftMargin = this.muO + this.muQ;
                this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.muR) - this.muS) - this.muO) - this.muQ;
            }
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.mvm.getHeaderImg(), adCard.portraitClick, bVar);
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            this.kxg.setMaxLines(adCard.titleLines <= 0 ? 4 : adCard.titleLines);
            if (4 == getBusinessType()) {
                this.kxg.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize42));
            } else {
                this.kxg.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize44));
            }
            this.kxg.setText(str2);
            this.kxg.setVisibility(0);
        } else {
            this.kxg.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.bkt()) && k.isEmpty(str3);
        a(this.mvi, this.mvd, this.mvg, adCard);
        int i2 = (this.mMaxWidth - this.muW) - this.muZ;
        if (4 == getBusinessType()) {
            this.mvh.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize30));
            i = i2 - (this.muX + this.muY);
        } else {
            i = i2;
        }
        String str4 = null;
        if (advertAppInfo != null && advertAppInfo.bks()) {
            str4 = adCard.userName.concat("APP");
        } else if (advertAppInfo != null && advertAppInfo.bkt()) {
            str4 = TextUtils.isEmpty(adCard.userName) ? "广告" : adCard.userName;
        }
        this.mvh.setText(com.baidu.g.a.e.a.a(str4, "广告", i, this.mvh.getPaint()));
        if (advertAppInfo != null && advertAppInfo.bks()) {
            this.mvk = advertAppInfo.eyR;
            this.mvg.setClickable(true);
            DownloadData b2 = b(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            a(adCard, b2);
            a(this.mvd, b2.getStatus(), str3);
            this.mvg.setData(b2);
            this.mvg.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    ap.setViewTextColor(this.mvd, R.color.cp_link_tip_a, 1);
                    ap.setBackgroundResource(this.mvd, R.drawable.ad_download_progress_button_bg);
                    this.mvd.setText(str3);
                    if (k.isEmpty(str)) {
                        this.mvd.setClickable(false);
                    } else {
                        this.mvd.setClickable(true);
                        this.mvd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.kFA != null && adCard.buttonClick != null && !u.Rp(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.kFA.a(adCard.buttonClick.auR, adCard.buttonClick.auS, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int c2 = s.c(AdCardBaseView.this.eIc, str, (AdCardBaseView.this.kxc == null || AdCardBaseView.this.kxc.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.kxc.getAdvertAppInfo().eyO);
                                        if ((c2 == 1 || c2 == 2) && AdCardBaseView.this.kFA != null) {
                                            AdCardBaseView.this.kFA.d(c2, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.eIc.getPageActivity());
                                    aVar.Bo(adCard.popWindowText);
                                    aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int c3 = s.c(AdCardBaseView.this.eIc, str, (AdCardBaseView.this.kxc == null || AdCardBaseView.this.kxc.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.kxc.getAdvertAppInfo().eyO);
                                            if ((c3 == 1 || c3 == 2) && AdCardBaseView.this.kFA != null) {
                                                AdCardBaseView.this.kFA.d(c3, null);
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
                                    aVar.b(AdCardBaseView.this.eIc).bpc();
                                }
                            }
                        });
                    }
                } else {
                    this.mvd.setClickable(false);
                    this.mvd.setText(adCard.buttonTextDone);
                    ap.setBackgroundResource(this.mvd, R.drawable.ad_download_progress_button_bg);
                    ap.setViewTextColor(this.mvd, R.color.cp_btn_a, 1);
                }
            }
            this.mvg.setVisibility(8);
        }
        a(adCard);
        H(com.baidu.tbadk.core.k.bjH().isShowImages(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            Rx(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.eyX != null && advertAppInfo.eyX.adCloseInfo != null && advertAppInfo.eyX.adCloseInfo.support_close.intValue() > 0) {
            this.mve.setVisibility(0);
            this.mve.mzj = R.drawable.icon_home_delete_n;
            this.mve.setPage(getBusinessType());
            this.mve.setData(advertAppInfo);
            l.addToParentArea(this.eIc.getPageActivity(), this.mvf, 40, 40, 40, 120);
            this.mvf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.mve.performClick();
                }
            });
        } else {
            this.mve.setVisibility(8);
            this.kxi.setOnClickListener(null);
        }
        this.mvl.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.hYB.getLayoutParams();
        if (4 == getBusinessType()) {
            this.mvl.setVisibility(8);
            this.mvl.setBarNameClickEnabled(false);
            this.mvl.setShareVisible(false);
            this.mvl.setShowPraiseNum(false);
            this.mvl.setCommentNumEnable(false);
            this.mvl.setReplyTimeVisible(false);
            layoutParams2.height = this.mvb;
            this.mvn.setVisibility(0);
            this.mvo.setVisibility(8);
            this.hYB.setVisibility(8);
            dE(this.mvf);
        } else {
            b(adCard, bVar);
            this.hYB.setVisibility(0);
            com.baidu.tbadk.a.b.a.a(this.hYB, (AbsThreadDataSupport) null);
            ((RelativeLayout.LayoutParams) this.mvg.getLayoutParams()).addRule(11, -1);
            ((RelativeLayout.LayoutParams) this.mvd.getLayoutParams()).addRule(11, -1);
            this.mvq.setVisibility(8);
            this.mvi.requestLayout();
        }
        a(adCard, this.hYe, getBusinessType());
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 instanceof AdvertAppInfo) {
            advertAppInfo2.AZ(at.dt(adCard.time));
        }
        this.mvm.setData(advertAppInfo2);
        ((TextView) this.mvm.getUserName()).setText(adCard.userName);
        com.baidu.tbadk.a.b.a.e((TextView) this.mvm.getUserName());
        this.mvm.getUserName().setOnClickListener(bVar);
        this.mvm.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.mvm.getUserName()).setText(adCard.userName);
            }
        });
        if (4 == getBusinessType() && adCard.isPBBanner) {
            this.jnu.setVisibility(0);
            this.jnu.setBackgroundResource(R.color.cp_bg_line_b);
            this.mvm.setVisibility(8);
        } else {
            this.jnu.setVisibility(8);
        }
        if ((com.baidu.tieba.frs.b.cxm().cxg() || com.baidu.tieba.frs.a.cxf().cxg()) && isInFrsAllThread()) {
            this.muN.setVisibility(0);
            ap.setBackgroundColor(this.muN, R.color.cp_bg_line_d);
        } else {
            this.muN.setVisibility(8);
        }
        a(adCard, advertAppInfo);
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private void dE(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.mvq.setVisibility(0);
            this.mvq.removeAllViews();
            view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.mvq.addView(view);
            int dimension = (int) getResources().getDimension(R.dimen.tbds26);
            int dimension2 = (int) getResources().getDimension(R.dimen.tbds33);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mvg.getLayoutParams();
            layoutParams.setMargins(0, dimension, dimension2, dimension);
            layoutParams.addRule(11, 0);
            layoutParams.addRule(0, this.mvq.getId());
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mvd.getLayoutParams();
            layoutParams2.addRule(11, 0);
            layoutParams2.setMargins(0, dimension, dimension2, dimension);
            layoutParams2.addRule(0, this.mvq.getId());
            this.mvi.requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bJp();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bJq();
    }

    private void a(AdCard adCard, DownloadData downloadData) {
        if (adCard.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.mvg.getDownloadStatus());
        }
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.directDownload) {
            this.mvg.setOnClickListener(bVar);
        } else {
            this.mvg.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public boolean bP(View view) {
                    AdCardBaseView.this.dAG();
                    return false;
                }
            });
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey Fm;
        if (!adCard.directDownload && advertAppInfo != null && advertAppInfo.bks()) {
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
            AdDownloadData d2 = com.baidu.tieba.ad.download.d.bJw().d(downloadCacheKey);
            if (d2 != null) {
                this.mvg.a(d2.getCurrentState());
            } else {
                this.mvg.a(DownloadStatus.STATUS_NONE);
            }
            String str = "";
            if (this.kxc != null && this.kxc.getAdvertAppInfo() != null) {
                str = this.kxc.getAdvertAppInfo().page;
                d2.setExtInfo(this.kxc.getAdvertAppInfo().extensionInfo);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mvg, d2, str);
            this.fSd = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d2.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d2);
            }
            bJp();
        }
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

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void b(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.mvo.setVisibility(0);
            this.mvl.setVisibility(8);
            return;
        }
        this.mvo.setVisibility(8);
        this.mvl.setVisibility(0);
        this.mvl.setBarNameClickEnabled(false);
        this.mvl.setReplyTimeVisible(false);
        this.mvl.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.mvl.setAgreeClickable(true);
            this.mvl.setPraiseContainerBgGray(false);
        } else {
            this.mvl.setAgreeClickable(false);
            this.mvl.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.mvl.setShareClickable(true);
            this.mvl.setShareContainerBgGray(false);
        } else {
            this.mvl.setShareClickable(false);
            this.mvl.setShareContainerBgGray(true);
        }
        if (this.mvl.getCommentContainer() != null) {
            this.mvl.getCommentContainer().setOnClickListener(bVar);
        }
        this.mvl.setNeedAddReplyIcon(true);
        this.mvl.setCommentNumEnable(false);
        this.mvl.setCommentClickable(true);
        this.mvl.setReplayContainerBgGray(true);
        this.mvl.setOnClickListener(bVar);
        this.mvl.setShareData(adCard);
        this.mvl.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        ap.setBackgroundResource(this.hYB, R.color.cp_bg_line_b);
        com.baidu.tbadk.a.b.a.be(this.hYB);
        this.mve.onChangeSkinType();
        this.mvm.onChangeSkinType(this.eIc, TbadkCoreApplication.getInst().getSkinType());
        this.mvl.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            ap.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.hYe, R.color.cp_bg_line_e);
        } else {
            ap.setBackgroundColor(this.hYe, R.color.transparent);
        }
        com.baidu.tbadk.a.b.a.f((TextView) this.mvm.getUserName());
        ap.setViewTextColor(this.kxg, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.mvh, R.color.cp_cont_d);
        ap.setViewTextColor(this.kxi, R.color.cp_cont_d, 1);
        this.mvg.onChangeSkinType(i);
    }

    protected void a(AdCard.b bVar) {
        int c2;
        if (bVar != null) {
            if (b(bVar) && !u.Rp(bVar.scheme)) {
                if (this.kFA != null) {
                    this.kFA.a(bVar.auR, bVar.auS, null);
                }
            } else if (this.kxc != null && this.kxc.getAdvertAppInfo() != null) {
                String Ry = Ry(bVar.scheme);
                String str = this.kxc.getAdvertAppInfo().eyO;
                if (!this.kxc.directDownload && this.kxc.getAdvertAppInfo().bks()) {
                    c2 = s.d(this.eIc, Ry, str);
                } else {
                    c2 = s.c(this.eIc, Ry, str);
                }
                if (c2 == 1 || c2 == 2) {
                    if (this.kFA != null) {
                        this.kFA.d(c2, null);
                    }
                } else if (this.kFA != null) {
                    this.kFA.a(bVar.auR, bVar.auS, null);
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
                        if (AdCardBaseView.this.kxc.hasAnimation()) {
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
        this.kEa = new a.C0776a();
        this.kEa.picUrl = tbImageView.getUrl();
        this.kEa.bDL = rect;
    }

    private void Rx(String str) {
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
                    com.baidu.adp.lib.e.c.mS().a(jSONObject.optString("pic_url"), 17, null, this.kFH, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.kFH), this.eIc.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.bkr() != 0) {
                l.showToast(this.eIc.getPageActivity(), R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.eIc.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.eIc.getPageActivity()) && this.kFB != null) {
                this.kFB.c(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(b(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.eIc.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bks()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.eIc.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eIc.getPageActivity());
                aVar.Bo(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.mvg);
                        if (AdCardBaseView.this.mvg != null) {
                            AdCardBaseView.this.mvg.q(AdCardBaseView.this.b(advertAppInfo, i));
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
                aVar.b(this.eIc).bpc();
            }
        }
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView, boolean z) {
        if (advertAppInfo != null) {
            DownloadData b2 = b(advertAppInfo, i);
            switch (ApkDownloadView.getStatus(b2)) {
                case 1:
                case 5:
                    if (z) {
                        h.e(advertAppInfo);
                        apkDownloadView.r(b2);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    h.aX(this.eIc.getPageActivity(), advertAppInfo.eyR);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, this.mvg);
                    apkDownloadView.s(b2);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.bJw().aG(this.eIc.getPageActivity(), advertAppInfo.eyR);
                    return;
            }
        }
    }

    public a.C0776a getAnimationInfo() {
        return this.kEa;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public class b implements View.OnClickListener {
        private AdCard mvD;

        public b(AdCard adCard) {
            this.mvD = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdCardBaseView.this.eIc.showToast(R.string.neterror);
            } else if (this.mvD != null && view != null && view.getId() != R.id.thread_info_commont_container) {
                AdvertAppInfo advertAppInfo = this.mvD.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.mvg;
                if (advertAppInfo != null && advertAppInfo.bks()) {
                    a(advertAppInfo, z);
                } else {
                    h(advertAppInfo);
                }
            }
        }

        private void a(AdvertAppInfo advertAppInfo, boolean z) {
            if (this.mvD.directDownload || z) {
                b(advertAppInfo, z);
            } else {
                i(advertAppInfo);
            }
        }

        private void h(AdvertAppInfo advertAppInfo) {
            String scheme = this.mvD.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.eyQ;
            }
            if (this.mvD.hasAnimation()) {
            }
            int h = s.h(AdCardBaseView.this.eIc, AdCardBaseView.this.Ry(scheme));
            if (AdCardBaseView.this.kFA != null) {
                AdCardBaseView.this.kFA.d(h, null);
            }
        }

        private void b(AdvertAppInfo advertAppInfo, boolean z) {
            int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
            int status = ApkDownloadView.getStatus(AdCardBaseView.this.b(advertAppInfo, i));
            if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                return;
            }
            AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.mvg, z);
            AdCardBaseView.this.dAG();
        }

        private void i(AdvertAppInfo advertAppInfo) {
            String scheme = this.mvD.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.eyQ;
            }
            int d = s.d(AdCardBaseView.this.eIc, scheme, advertAppInfo.eyO);
            if (AdCardBaseView.this.kFA != null) {
                AdCardBaseView.this.kFA.d(d, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dAG() {
        if (this.kFA != null) {
            this.kFA.d(3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Ry(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.kEa != null && this.kEa.isValid()) {
            String c0776a = this.kEa.toString();
            if (!TextUtils.isEmpty(c0776a)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(c0776a));
            }
        }
        if (!TextUtils.isEmpty(this.kxc.getPreLoadData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.kxc.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.kxc.getNextPageData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.kxc.getNextPageData()));
        }
        if (this.kxc.hasAnimation()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.kxc.isGoLandingPage()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.kxc.isImmersiveStyle()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes26.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mvC;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mvC = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.mvC.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.mvk) ? false : true)) && adCardBaseView.mvk.equals(downloadData.getId())) {
                    int status = e.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.mvd.setText(R.string.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.mvd.setText(R.string.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes26.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mvC;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mvC = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.mvC.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.mvk) && adCardBaseView.mvk.equals(downloadData.getId())) {
                adCardBaseView.mvg.t(downloadData);
            }
        }
    }

    /* loaded from: classes26.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mvC;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mvC = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.mvC.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                String str = null;
                if (adCardBaseView.kxc != null && adCardBaseView.kxc.getAdvertAppInfo() != null) {
                    str = adCardBaseView.kxc.getAdvertAppInfo().eyO;
                }
                s.c(adCardBaseView.eIc, adCardBaseView.mvp.scheme, str);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void cZu() {
        if (4 == getBusinessType()) {
            this.kxg.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.muv != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.mvp = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.eIc.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.eIc, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        return true;
    }

    private void a(View view, TextView textView, ApkDownloadView apkDownloadView, AdCard adCard) {
        if (adCard == null) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        if (adCard.getAdvertAppInfo().bks()) {
            textView.setVisibility(8);
            apkDownloadView.setVisibility(0);
        } else if (k.isEmpty(adCard.buttonText)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.eyR);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.eyP);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.eyO, 0));
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
