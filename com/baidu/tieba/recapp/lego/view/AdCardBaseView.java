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
import androidx.annotation.StringRes;
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
import com.baidu.tieba.lego.card.a.a;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.download.e;
import com.baidu.tieba.recapp.download.h;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.view.AdAppInfoView;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.recapp.view.AdThreadUserInfoLayout;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.tieba.tbadkCore.v;
import com.tencent.open.SocialConstants;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class AdCardBaseView extends BaseLegoCardView<AdCard> implements com.baidu.tieba.lego.card.a.a {
    private DownloadCacheKey ggP;
    private com.baidu.tieba.ad.download.a.d ggQ;
    private a.C0775a laL;
    private final int lcs;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    protected View mRootView;
    protected ApkDownloadView mTA;
    protected TextView mTB;
    protected RelativeLayout mTC;
    protected View mTD;
    protected String mTE;
    private AdCard mTF;
    private AdThreadCommentAndPraiseInfoLayout mTG;
    protected AdThreadUserInfoLayout mTH;
    protected View mTI;
    protected View mTJ;
    protected AdCard.b mTK;
    private FrameLayout mTL;
    private View mTM;
    private View mTN;
    private AdAppInfoView mTO;
    protected CustomMessageListener mTP;
    protected CustomMessageListener mTQ;
    protected CustomMessageListener mTR;
    protected ViewStub mTb;
    protected View mTc;
    protected View mTd;
    protected final int mTe;
    protected final int mTf;
    protected final int mTg;
    protected final int mTh;
    private final int mTi;
    private final int mTk;
    protected final int mTl;
    private final int mTm;
    protected final int mTn;
    protected final int mTp;
    protected final int mTq;
    private final int mTr;
    private final int mTs;
    private final int mTt;
    private final int mTu;
    protected TextView mTv;
    protected TextView mTw;
    protected TextView mTx;
    private AdCloseView mTy;
    private LinearLayout mTz;

    protected abstract void a(AdCard adCard);

    protected abstract void ea(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lcs = l.getEquipmentWidth(getContext());
        this.ggQ = null;
        this.mTP = new a(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG, this);
        this.mTQ = new d(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG, this);
        this.mTR = new c(CmdConfigCustom.CMD_USER_INFO_CHANGED, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.tbds648);
        this.mImageHeight = (int) resources.getDimension(R.dimen.tbds488);
        this.mTe = (int) resources.getDimension(R.dimen.tbds92);
        this.mTf = (int) resources.getDimension(R.dimen.tbds92);
        this.mTg = (int) resources.getDimension(R.dimen.M_W_X004);
        this.mTn = (int) resources.getDimension(R.dimen.tbds90);
        this.mTp = (int) resources.getDimension(R.dimen.tbds90);
        this.mTq = (int) resources.getDimension(R.dimen.tbds22);
        this.mTh = (int) resources.getDimension(R.dimen.M_W_X005);
        this.mTl = (int) resources.getDimension(R.dimen.M_W_X004);
        this.mTm = 0;
        this.mTi = (int) resources.getDimension(R.dimen.M_W_X007);
        this.mTk = (int) resources.getDimension(R.dimen.M_H_X005);
        this.mTr = (int) resources.getDimension(R.dimen.tbds208);
        this.mTs = (int) resources.getDimension(R.dimen.tbds33);
        this.mTt = (int) resources.getDimension(R.dimen.tbds72);
        this.mTu = (int) resources.getDimension(R.dimen.tbds48);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dbO() {
        MessageManager.getInstance().registerListener(this.mTP);
        MessageManager.getInstance().registerListener(this.mTQ);
        MessageManager.getInstance().registerListener(this.mTR);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.mTM = this.mRootView.findViewById(R.id.banner_top_divider);
        this.mTd = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.mTd.setClickable(true);
        this.mTv = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.mTw = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.mTA = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.mTB = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.mTC = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.mTA.y(this.eUY.getUniqueId());
        this.mTP.setTag(this.eUY.getUniqueId());
        this.mTD = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.mTQ.setTag(this.eUY.getUniqueId());
        this.mTR.setTag(this.eUY.getUniqueId());
        this.mTG = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.mTG.setStyle(1);
        this.mTH = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        this.mTL = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        this.mTz = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mTy = (AdCloseView) this.mTz.findViewById(R.id.ad_close_view);
        ViewGroup.LayoutParams layoutParams = this.mTy.mYb.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.mTy.mYb.getLayoutParams();
        int dimens = l.getDimens(getContext(), R.dimen.tbds62);
        layoutParams2.width = dimens;
        layoutParams.height = dimens;
        this.mTx = (TextView) this.mTz.findViewById(R.id.feed_tag);
        this.mTx.setVisibility(8);
        this.mTH.addAdTagView(this.mTz);
        this.mTb = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.mTb.setLayoutResource(getCustomLayout());
        this.mTc = this.mTb.inflate();
        this.mTI = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.mTJ = this.mRootView.findViewById(R.id.frs_bottom_view);
        this.mTN = this.mRootView.findViewById(R.id.pb_ad_bottom_divider);
        this.mTO = (AdAppInfoView) this.mRootView.findViewById(R.id.app_info_view);
        com.baidu.tbadk.core.elementsMaven.c.br(this.mTO).og(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
        ea(this.mTc);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(AdCard adCard) {
        this.mTF = adCard;
        if (adCard != null) {
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            b bVar = new b(adCard);
            c(adCard);
            a(adCard, advertAppInfo, bVar);
            e(adCard);
            b(adCard, advertAppInfo, bVar);
            a(adCard, advertAppInfo);
            m(advertAppInfo);
            b(adCard, bVar);
            this.mRootView.setOnClickListener(bVar);
            if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
                Ru(adCard.getPreLoadData());
            }
            a(adCard);
            a(adCard, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void c(AdCard adCard) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTD.getLayoutParams();
        layoutParams.topMargin = this.eUY.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        this.mTD.setPadding(0, 0, 0, 0);
        this.mTL.setVisibility(8);
        this.mTM.setVisibility(8);
        if (dDF()) {
            this.mRootView.setPadding(this.mTi, this.mTk, this.mTi, 0);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTD.getLayoutParams();
            this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - (this.mTm * 2)) - (this.mTi * 2)) - this.mTe) - this.mTg;
            layoutParams2.leftMargin = this.mTe + this.mTg;
            this.mTN.setVisibility(0);
            ec(this.mTz);
            if (f(adCard)) {
                this.mTN.setVisibility(8);
                this.mRootView.setPadding(0, 0, 0, 0);
                this.mTD.setPadding(this.mTi, 0, this.mTi, 0);
                layoutParams2.leftMargin = 0;
                this.mMaxWidth = (l.getEquipmentWidth(getContext()) - (this.mTi * 2)) - (this.mTm * 2);
                layoutParams.topMargin = this.eUY.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
                this.mTM.setVisibility(0);
                ap.setBackgroundColor(this.mTM, R.color.CAM_X0204);
                eb(this.mTz);
                return;
            }
            return;
        }
        this.mRootView.setPadding(this.mTh, this.mTk, this.mTh, 0);
        this.mMaxWidth = (l.getEquipmentWidth(getContext()) - (this.mTh * 2)) - (this.mTl * 2);
        if ((com.baidu.tieba.frs.b.cBr().cBl() || com.baidu.tieba.frs.a.cBk().cBl()) && isInFrsAllThread()) {
            this.mTd.setVisibility(0);
            ap.setBackgroundColor(this.mTd, R.color.CAM_X0201);
        } else {
            this.mTd.setVisibility(8);
        }
        this.mTN.setVisibility(8);
    }

    private void a(final AdCard adCard, final AdvertAppInfo advertAppInfo, b bVar) {
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 != null) {
            advertAppInfo2.Af(au.dY(adCard.time));
        }
        this.mTH.setShowFlag(1413);
        this.mTH.setData(advertAppInfo2);
        ((TextView) this.mTH.getUserName()).setText(adCard.userName);
        com.baidu.tbadk.a.b.b.g((TextView) this.mTH.getUserName());
        this.mTH.getUserName().setOnClickListener(bVar);
        this.mTH.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.mTH.getUserName()).setText(adCard.userName);
            }
        });
        this.mTH.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.bwc() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.eUY.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        a(this.mTH.getHeaderImg(), adCard.portraitClick, bVar);
        if (f(adCard)) {
            this.mTH.setVisibility(8);
        }
    }

    private void b(AdCard adCard, AdvertAppInfo advertAppInfo, b bVar) {
        if (adCard == null || advertAppInfo == null) {
            this.mTC.setVisibility(8);
            return;
        }
        this.mTC.setVisibility(0);
        if (advertAppInfo.blE()) {
            a(advertAppInfo, adCard, bVar);
            b(adCard, advertAppInfo);
        } else if (advertAppInfo.blF()) {
            a(adCard, bVar);
        }
    }

    private void a(AdvertAppInfo advertAppInfo, AdCard adCard, b bVar) {
        d2(adCard);
        this.mTw.setVisibility(8);
        this.mTA.setVisibility(0);
        this.mTA.setClickable(true);
        this.mTE = advertAppInfo.eLx;
        DownloadData d2 = d(advertAppInfo, advertAppInfo.position);
        if (s.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), this.mTE)) {
            d2.setStatus(8);
        } else {
            a(adCard, d2);
        }
        this.mTA.setData(d2);
        c(adCard, bVar);
    }

    /* renamed from: d  reason: avoid collision after fix types in other method */
    private void d2(AdCard adCard) {
        com.baidu.tbadk.core.data.c appInfoModel = adCard.getAppInfoModel();
        RelativeLayout downloadButtonContainer = this.mTO.getDownloadButtonContainer();
        if (com.baidu.tbadk.core.data.c.b(appInfoModel)) {
            this.mTO.setVisibility(0);
            this.mTO.setAppInfo(appInfoModel);
            this.mTO.setAd(adCard.getAdvertAppInfo());
            if (!e(this.mTA, downloadButtonContainer)) {
                d(this.mTA, downloadButtonContainer);
                return;
            }
            return;
        }
        this.mTO.setVisibility(8);
        if (!e(this.mTA, this.mTC)) {
            d(this.mTA, this.mTC);
        }
    }

    private void a(final AdCard adCard, b bVar) {
        this.mTA.setVisibility(8);
        this.mTO.setVisibility(8);
        String str = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        final String str2 = bVar2 == null ? "" : bVar2.scheme;
        if (k.isEmpty(str) || (!TextUtils.isEmpty(adCard.buttonTextDone) && 1 != adCard.buttonStatus)) {
            this.mTw.setVisibility(8);
            this.mTw.setClickable(false);
            return;
        }
        this.mTw.setVisibility(0);
        this.mTw.setClickable(true);
        this.mTw.setText(str);
        ap.setViewTextColor(this.mTw, R.color.CAM_X0304, 1);
        ap.setBackgroundResource(this.mTw, R.drawable.ad_download_progress_button_bg);
        if (k.isEmpty(str2)) {
            this.mTw.setClickable(false);
        } else {
            this.mTw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AdCardBaseView.this.lcl != null && adCard.buttonClick != null && !s.Rm(str2)) {
                        AdCardBaseView.this.lcl.b(adCard.buttonClick.mSK, adCard.buttonClick.mSL, null);
                    }
                    if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                        if (TextUtils.isEmpty(adCard.popWindowText)) {
                            int c2 = s.c(AdCardBaseView.this.eUY, str2, (AdCardBaseView.this.mTF == null || AdCardBaseView.this.mTF.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.d(AdCardBaseView.this.mTF.getAdvertAppInfo()));
                            if (s.HL(c2) && AdCardBaseView.this.lcl != null) {
                                AdCardBaseView.this.lcl.d(c2, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.eUY.getPageActivity());
                        aVar.Au(adCard.popWindowText);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int c3 = s.c(AdCardBaseView.this.eUY, str2, (AdCardBaseView.this.mTF == null || AdCardBaseView.this.mTF.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.d(AdCardBaseView.this.mTF.getAdvertAppInfo()));
                                if (s.HL(c3) && AdCardBaseView.this.lcl != null) {
                                    AdCardBaseView.this.lcl.d(c3, null);
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
                        aVar.b(AdCardBaseView.this.eUY).bqx();
                    }
                }
            });
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        int i = (this.mMaxWidth - this.mTr) - this.mTu;
        int i2 = dDF() ? i - (this.mTs + this.mTt) : i;
        String str = null;
        if (advertAppInfo != null && advertAppInfo.blE()) {
            str = adCard.userName.concat("APP");
        } else if (advertAppInfo != null && advertAppInfo.blF()) {
            str = TextUtils.isEmpty(adCard.userName) ? "广告" : adCard.userName;
        }
        this.mTB.setText(com.baidu.tieba.recapp.lego.a.a.a(str, "广告", i2, this.mTB.getPaint()));
    }

    private void e(AdCard adCard) {
        String str = adCard.threadTitle;
        if (TextUtils.isEmpty(str)) {
            this.mTv.setVisibility(8);
            return;
        }
        this.mTv.setMaxLines(adCard.titleLines <= 0 ? 4 : adCard.titleLines);
        this.mTv.setText(str);
        this.mTv.setVisibility(0);
    }

    private void b(AdCard adCard, b bVar) {
        this.mTG.setType(TbadkCoreApplication.getInst().getCardShowType());
        if (dDF()) {
            this.mTG.setVisibility(8);
            this.mTG.setBarNameClickEnabled(false);
            this.mTG.setShareVisible(false);
            this.mTG.setShowPraiseNum(false);
            this.mTG.setCommentNumEnable(false);
            this.mTG.setReplyTimeVisible(false);
            this.mTI.setVisibility(0);
            this.mTJ.setVisibility(8);
            return;
        }
        d(adCard, bVar);
    }

    private void m(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.eLD != null && advertAppInfo.eLD.adCloseInfo != null && advertAppInfo.eLD.adCloseInfo.support_close.intValue() > 0) {
            this.mTy.setVisibility(0);
            this.mTy.setPage(getBusinessType());
            this.mTy.setData(advertAppInfo);
            l.addToParentArea(this.eUY.getPageActivity(), this.mTz, 40, 40, 40, 120);
            this.mTz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.mTy.performClick();
                }
            });
            return;
        }
        this.mTy.setVisibility(8);
        this.mTx.setOnClickListener(null);
    }

    private void eb(View view) {
        if (view != null && view.getVisibility() == 0) {
            this.mTL.setVisibility(0);
            if (!e(view, this.mTL)) {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                this.mTL.removeAllViews();
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                this.mTL.addView(view);
            }
        }
    }

    private void ec(View view) {
        if (view != null && view.getVisibility() == 0) {
            this.mTL.setVisibility(8);
            if (!e(view, this.mTH)) {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                this.mTH.addAdTagView(this.mTz);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bLl();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bLm();
    }

    private void a(AdCard adCard, DownloadData downloadData) {
        if (adCard.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.mTA.getDownloadStatus());
        }
    }

    private void c(AdCard adCard, b bVar) {
        if (adCard.directDownload) {
            this.mTA.setOnClickListener(bVar);
        } else {
            this.mTA.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public boolean ce(View view) {
                    AdCardBaseView.this.dDE();
                    return false;
                }
            });
        }
    }

    private void b(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey EL;
        if (!adCard.directDownload) {
            String scheme = adCard.getScheme();
            String d2 = d(advertAppInfo);
            if (!TextUtils.isEmpty(d2)) {
                EL = com.baidu.tieba.ad.download.d.bLt().EK(d2);
            } else {
                EL = com.baidu.tieba.ad.download.d.bLt().EL(scheme);
            }
            if (EL == null) {
                EL = DownloadCacheKey.create(d2, advertAppInfo.apkUrl, advertAppInfo.eLx);
                com.baidu.tieba.ad.download.d.bLt().a(EL, null);
            }
            i(EL);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.ggP = downloadCacheKey;
            bLm();
            this.ggQ = null;
            AdDownloadData d2 = com.baidu.tieba.ad.download.d.bLt().d(downloadCacheKey);
            if (s.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), d2.getPkgName())) {
                d2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            }
            this.mTA.a(d2.getCurrentState());
            String str = "";
            if (this.mTF != null && this.mTF.getAdvertAppInfo() != null) {
                str = this.mTF.getAdvertAppInfo().page;
                d2.setExtInfo(this.mTF.getAdvertAppInfo().extensionInfo);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mTA, d2, str);
            this.ggQ = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d2.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d2);
            }
            bLl();
        }
    }

    private void bLl() {
        if (this.ggP != null && this.ggQ != null) {
            com.baidu.tieba.ad.download.d.bLt().a(this.ggP, this.ggQ);
        }
    }

    private void bLm() {
        if (this.ggP != null && this.ggQ != null) {
            com.baidu.tieba.ad.download.d.bLt().b(this.ggP, this.ggQ);
        }
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void d(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.mTJ.setVisibility(0);
            this.mTG.setVisibility(8);
            return;
        }
        this.mTJ.setVisibility(8);
        this.mTG.setVisibility(0);
        this.mTG.setBarNameClickEnabled(false);
        this.mTG.setReplyTimeVisible(false);
        this.mTG.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.mTG.setAgreeClickable(true);
            this.mTG.setPraiseContainerBgGray(false);
        } else {
            this.mTG.setAgreeClickable(false);
            this.mTG.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.mTG.setShareClickable(true);
            this.mTG.setShareContainerBgGray(false);
        } else {
            this.mTG.setShareClickable(false);
            this.mTG.setShareContainerBgGray(true);
        }
        if (this.mTG.getCommentContainer() != null) {
            this.mTG.getCommentContainer().setOnClickListener(bVar);
        }
        this.mTG.setNeedAddReplyIcon(true);
        this.mTG.setCommentNumEnable(false);
        this.mTG.setCommentClickable(true);
        this.mTG.setReplayContainerBgGray(true);
        this.mTG.setOnClickListener(bVar);
        this.mTG.setShareData(adCard);
        this.mTG.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        this.mTy.onChangeSkinType();
        this.mTH.onChangeSkinType(this.eUY, TbadkCoreApplication.getInst().getSkinType());
        this.mTG.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            com.baidu.tbadk.core.elementsMaven.c.br(this.mRootView).og(R.string.J_X06).aJ(R.color.CAM_X0205, R.color.cp_bg_line_e_alpha50);
        }
        com.baidu.tbadk.a.b.b.h((TextView) this.mTH.getUserName());
        ap.setViewTextColor(this.mTv, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.mTB, R.color.CAM_X0109);
        ap.setViewTextColor(this.mTx, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.mTw, R.color.CAM_X0304, 1);
        ap.setBackgroundResource(this.mTw, R.drawable.ad_download_progress_button_bg);
        ap.setBackgroundColor(this.mTN, R.color.CAM_X0203);
        ap.setBackgroundColor(this.mTM, R.color.CAM_X0204);
        this.mTA.onChangeSkinType(i);
        com.baidu.tbadk.core.elementsMaven.c.br(this.mTO).og(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
        this.mTO.onChangeSkinType();
    }

    protected void a(AdCard.b bVar) {
        if (bVar != null) {
            if (b(bVar) && !v.Rm(bVar.scheme)) {
                if (this.lcl != null) {
                    this.lcl.b(bVar.mSK, bVar.mSL, null);
                }
            } else if (this.mTF != null && this.mTF.getAdvertAppInfo() != null) {
                String str = bVar.scheme;
                String d2 = d(this.mTF.getAdvertAppInfo());
                int i = 3;
                if (!this.mTF.directDownload && this.mTF.getAdvertAppInfo().blE()) {
                    if (!s.b(this.mTF.getAdvertAppInfo(), str)) {
                        i = s.c(this.eUY, str, d2);
                    }
                } else {
                    i = s.c(this.eUY, str, d2);
                }
                if (s.HL(i) && this.lcl != null) {
                    this.lcl.d(i, null);
                } else if (this.lcl != null) {
                    this.lcl.b(bVar.mSK, bVar.mSL, null);
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
                        if (AdCardBaseView.this.mTF.hasAnimation()) {
                            AdCardBaseView.this.j(tbImageView);
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
    public void j(TbImageView tbImageView) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        tbImageView.getLocationOnScreen(iArr);
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + tbImageView.getWidth();
        rect.bottom = rect.top + tbImageView.getHeight();
        this.laL = new a.C0775a();
        this.laL.picUrl = tbImageView.getUrl();
        this.laL.rect = rect;
    }

    private void Ru(String str) {
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
                    com.baidu.adp.lib.e.d.mw().a(jSONObject.optString("pic_url"), 17, null, this.lcs, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.lcs), this.eUY.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.blD() != 0) {
                l.showToast(this.eUY.getPageActivity(), R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.eUY.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.eUY.getPageActivity()) && this.lcm != null) {
                this.lcm.c(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(d(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.eUY.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.blE()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.eUY.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eUY.getPageActivity());
                aVar.Au(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.mTA);
                        if (AdCardBaseView.this.mTA != null) {
                            AdCardBaseView.this.mTA.q(AdCardBaseView.this.d(advertAppInfo, i));
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
                aVar.b(this.eUY).bqx();
            }
        }
    }

    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView, boolean z) {
        if (advertAppInfo != null) {
            DownloadData d2 = d(advertAppInfo, i);
            switch (ApkDownloadView.getStatus(d2)) {
                case 1:
                case 5:
                    if (z) {
                        h.i(advertAppInfo);
                        apkDownloadView.r(d2);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    h.installApp(this.eUY.getPageActivity(), advertAppInfo.eLx);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, this.mTA);
                    apkDownloadView.s(d2);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.bLt().aN(this.eUY.getPageActivity(), advertAppInfo.eLx);
                    return;
            }
        }
    }

    public a.C0775a getAnimationInfo() {
        return this.laL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        private AdCard mUb;

        public b(AdCard adCard) {
            this.mUb = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdCardBaseView.this.eUY.showToast(R.string.neterror);
            } else if (this.mUb != null && view != null && view.getId() != R.id.thread_info_commont_container) {
                AdvertAppInfo advertAppInfo = this.mUb.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.mTA;
                if (advertAppInfo != null && advertAppInfo.blE()) {
                    a(advertAppInfo, z);
                } else {
                    n(advertAppInfo);
                }
            }
        }

        private void a(AdvertAppInfo advertAppInfo, boolean z) {
            if (this.mUb.directDownload || z) {
                b(advertAppInfo, z);
            } else {
                o(advertAppInfo);
            }
        }

        private void n(AdvertAppInfo advertAppInfo) {
            String scheme = this.mUb.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.eLw;
            }
            if (this.mUb.hasAnimation()) {
            }
            int c = s.c(AdCardBaseView.this.eUY, scheme, AdCardBaseView.this.d(advertAppInfo));
            if (AdCardBaseView.this.lcl != null) {
                AdCardBaseView.this.lcl.d(c, null);
            }
        }

        private void b(AdvertAppInfo advertAppInfo, boolean z) {
            int i = advertAppInfo.position;
            int status = ApkDownloadView.getStatus(AdCardBaseView.this.d(advertAppInfo, i));
            if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                return;
            }
            AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.mTA, z);
            AdCardBaseView.this.dDE();
        }

        private void o(AdvertAppInfo advertAppInfo) {
            int i;
            String scheme = this.mUb.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.eLw;
            }
            if (!s.b(advertAppInfo, scheme)) {
                i = s.c(AdCardBaseView.this.eUY, scheme, AdCardBaseView.this.d(advertAppInfo));
            } else {
                i = 3;
            }
            if (AdCardBaseView.this.lcl != null) {
                AdCardBaseView.this.lcl.d(i, null);
            }
        }
    }

    protected void dDE() {
        if (this.lcl != null) {
            this.lcl.d(3, null);
        }
    }

    /* loaded from: classes8.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mTZ;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mTZ = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.mTZ.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.mTE) && adCardBaseView.mTE.equals(downloadData.getId())) {
                int status = e.getStatus(downloadData);
                if (status == 7) {
                    adCardBaseView.mTw.setText(R.string.pause_load);
                } else if (status == 1 || status == 2) {
                    adCardBaseView.mTw.setText(R.string.pb_download_pause);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mTZ;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mTZ = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.mTZ.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.mTE) && adCardBaseView.mTE.equals(downloadData.getId())) {
                adCardBaseView.mTA.t(downloadData);
            }
        }
    }

    /* loaded from: classes8.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mTZ;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mTZ = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.mTZ.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                String str = null;
                if (adCardBaseView.mTF != null && adCardBaseView.mTF.getAdvertAppInfo() != null) {
                    str = TextUtils.isEmpty(adCardBaseView.mTF.getAdvertAppInfo().eLx) ? adCardBaseView.mTF.getAdvertAppInfo().eLu : adCardBaseView.mTF.getAdvertAppInfo().eLx;
                }
                s.c(adCardBaseView.eUY, adCardBaseView.mTK.scheme, str);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void dbU() {
        if (dDF()) {
            this.mTv.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.mSM != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.mTK = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.eUY.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.eUY, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        return true;
    }

    DownloadData d(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(d(advertAppInfo));
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.eLv);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.eLu, 0));
        return downloadData;
    }

    protected boolean dDF() {
        return getBusinessType() == 4;
    }

    protected boolean f(AdCard adCard) {
        return dDF() && adCard.isPBBanner;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float HS(@StringRes int i) {
        try {
            return Float.parseFloat(TbadkCoreApplication.getInst().getContext().getResources().getString(i).split(",")[0]);
        } catch (Exception e) {
            return 0.0f;
        }
    }

    private void d(View view, ViewGroup viewGroup) {
        if (view != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
            viewGroup.addView(view);
        }
    }

    private boolean e(View view, ViewGroup viewGroup) {
        return (view == null || view.getParent() == null || view.getParent() != viewGroup) ? false : true;
    }
}
