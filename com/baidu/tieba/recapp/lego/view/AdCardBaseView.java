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
import com.baidu.tieba.recapp.t;
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
import tbclient.App;
/* loaded from: classes7.dex */
public abstract class AdCardBaseView extends BaseLegoCardView<AdCard> implements com.baidu.tieba.lego.card.a.a {
    private com.baidu.tieba.ad.download.a.d giA;
    private DownloadCacheKey giz;
    private a.C0782a ldc;
    private final int leK;
    protected int mMaxWidth;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    protected View mRootView;
    protected ViewStub mVO;
    protected View mVP;
    protected View mVQ;
    protected final int mVR;
    protected final int mVS;
    protected final int mVT;
    protected final int mVU;
    private final int mVV;
    private final int mVW;
    protected final int mVX;
    private final int mVY;
    protected final int mVZ;
    protected CustomMessageListener mWA;
    protected CustomMessageListener mWB;
    protected CustomMessageListener mWC;
    protected final int mWa;
    protected final int mWb;
    private final int mWc;
    private final int mWd;
    private final int mWe;
    private final int mWf;
    protected TextView mWg;
    protected TextView mWh;
    protected TextView mWi;
    private AdCloseView mWj;
    private LinearLayout mWk;
    protected ApkDownloadView mWl;
    protected TextView mWm;
    protected RelativeLayout mWn;
    protected View mWo;
    protected String mWp;
    private AdCard mWq;
    private AdThreadCommentAndPraiseInfoLayout mWr;
    protected AdThreadUserInfoLayout mWs;
    protected View mWt;
    protected View mWu;
    protected AdCard.b mWv;
    private FrameLayout mWw;
    private View mWx;
    private View mWy;
    private AdAppInfoView mWz;

    protected abstract void a(AdCard adCard);

    protected abstract void ea(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.leK = l.getEquipmentWidth(getContext());
        this.giA = null;
        this.mWA = new a(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG, this);
        this.mWB = new d(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG, this);
        this.mWC = new c(CmdConfigCustom.CMD_USER_INFO_CHANGED, this);
        Resources resources = tbPageContext.getResources();
        this.mVR = (int) resources.getDimension(R.dimen.tbds92);
        this.mVS = (int) resources.getDimension(R.dimen.tbds92);
        this.mVT = (int) resources.getDimension(R.dimen.M_W_X004);
        this.mVZ = (int) resources.getDimension(R.dimen.tbds90);
        this.mWa = (int) resources.getDimension(R.dimen.tbds90);
        this.mWb = (int) resources.getDimension(R.dimen.tbds22);
        this.mVU = (int) resources.getDimension(R.dimen.M_W_X005);
        this.mVX = (int) resources.getDimension(R.dimen.M_W_X004);
        this.mVY = 0;
        this.mVV = (int) resources.getDimension(R.dimen.M_W_X007);
        this.mVW = (int) resources.getDimension(R.dimen.M_H_X005);
        this.mWc = (int) resources.getDimension(R.dimen.tbds208);
        this.mWd = (int) resources.getDimension(R.dimen.tbds33);
        this.mWe = (int) resources.getDimension(R.dimen.tbds72);
        this.mWf = (int) resources.getDimension(R.dimen.tbds48);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dce() {
        MessageManager.getInstance().registerListener(this.mWA);
        MessageManager.getInstance().registerListener(this.mWB);
        MessageManager.getInstance().registerListener(this.mWC);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.mWx = this.mRootView.findViewById(R.id.banner_top_divider);
        this.mVQ = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.mVQ.setClickable(true);
        this.mWg = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.mWh = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.mWl = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.mWm = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.mWn = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.mWl.z(this.eWx.getUniqueId());
        this.mWA.setTag(this.eWx.getUniqueId());
        this.mWo = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.mWB.setTag(this.eWx.getUniqueId());
        this.mWC.setTag(this.eWx.getUniqueId());
        this.mWr = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.mWr.setStyle(1);
        this.mWs = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        this.mWw = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        this.mWk = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mWj = (AdCloseView) this.mWk.findViewById(R.id.ad_close_view);
        ViewGroup.LayoutParams layoutParams = this.mWj.naM.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.mWj.naM.getLayoutParams();
        int dimens = l.getDimens(getContext(), R.dimen.tbds62);
        layoutParams2.width = dimens;
        layoutParams.height = dimens;
        this.mWi = (TextView) this.mWk.findViewById(R.id.feed_tag);
        this.mWi.setVisibility(8);
        this.mWs.addAdTagView(this.mWk);
        this.mVO = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.mVO.setLayoutResource(getCustomLayout());
        this.mVP = this.mVO.inflate();
        this.mWt = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.mWu = this.mRootView.findViewById(R.id.frs_bottom_view);
        this.mWy = this.mRootView.findViewById(R.id.pb_ad_bottom_divider);
        this.mWz = (AdAppInfoView) this.mRootView.findViewById(R.id.app_info_view);
        com.baidu.tbadk.core.elementsMaven.c.br(this.mWz).oh(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
        ea(this.mVP);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(AdCard adCard) {
        this.mWq = adCard;
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
                RM(adCard.getPreLoadData());
            }
            a(adCard);
            a(adCard, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void c(AdCard adCard) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mWo.getLayoutParams();
        layoutParams.topMargin = this.eWx.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        this.mWo.setPadding(0, 0, 0, 0);
        this.mWw.setVisibility(8);
        this.mWx.setVisibility(8);
        if (dDV()) {
            this.mRootView.setPadding(this.mVV, this.mVW, this.mVV, 0);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mWo.getLayoutParams();
            this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - (this.mVY * 2)) - (this.mVV * 2)) - this.mVR) - this.mVT;
            layoutParams2.leftMargin = this.mVR + this.mVT;
            this.mWy.setVisibility(0);
            ec(this.mWk);
            if (f(adCard)) {
                this.mWy.setVisibility(8);
                this.mRootView.setPadding(0, 0, 0, 0);
                this.mWo.setPadding(this.mVV, 0, this.mVV, 0);
                layoutParams2.leftMargin = 0;
                this.mMaxWidth = (l.getEquipmentWidth(getContext()) - (this.mVV * 2)) - (this.mVY * 2);
                layoutParams.topMargin = this.eWx.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
                this.mWx.setVisibility(0);
                ap.setBackgroundColor(this.mWx, R.color.CAM_X0204);
                eb(this.mWk);
                return;
            }
            return;
        }
        this.mRootView.setPadding(this.mVU, this.mVW, this.mVU, 0);
        this.mMaxWidth = (l.getEquipmentWidth(getContext()) - (this.mVU * 2)) - (this.mVX * 2);
        if ((com.baidu.tieba.frs.b.cBE().cBy() || com.baidu.tieba.frs.a.cBx().cBy()) && isInFrsAllThread()) {
            this.mVQ.setVisibility(0);
            ap.setBackgroundColor(this.mVQ, R.color.CAM_X0201);
        } else {
            this.mVQ.setVisibility(8);
        }
        this.mWy.setVisibility(8);
    }

    private void a(final AdCard adCard, final AdvertAppInfo advertAppInfo, b bVar) {
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 != null) {
            advertAppInfo2.Am(au.dY(adCard.time));
        }
        this.mWs.setShowFlag(1413);
        this.mWs.setData(advertAppInfo2);
        ((TextView) this.mWs.getUserName()).setText(adCard.userName);
        com.baidu.tbadk.a.b.b.g((TextView) this.mWs.getUserName());
        this.mWs.getUserName().setOnClickListener(bVar);
        this.mWs.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.mWs.getUserName()).setText(adCard.userName);
            }
        });
        this.mWs.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.bwf() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.eWx.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        a(this.mWs.getHeaderImg(), adCard.portraitClick, bVar);
        if (f(adCard)) {
            this.mWs.setVisibility(8);
        }
    }

    private void b(AdCard adCard, AdvertAppInfo advertAppInfo, b bVar) {
        if (adCard == null || advertAppInfo == null) {
            this.mWn.setVisibility(8);
            return;
        }
        this.mWn.setVisibility(0);
        if (advertAppInfo.blG()) {
            a(advertAppInfo, adCard, bVar);
            b(adCard, advertAppInfo);
        } else if (advertAppInfo.blH()) {
            a(adCard, bVar);
        }
    }

    private void a(AdvertAppInfo advertAppInfo, AdCard adCard, b bVar) {
        d2(adCard);
        this.mWh.setVisibility(8);
        this.mWl.setVisibility(0);
        this.mWl.setClickable(true);
        this.mWp = advertAppInfo.eMX;
        DownloadData d2 = d(advertAppInfo, advertAppInfo.position);
        if (t.RA(this.mWp)) {
            d2.setStatus(8);
        } else {
            a(adCard, d2);
        }
        this.mWl.setData(d2);
        c(adCard, bVar);
    }

    /* renamed from: d  reason: avoid collision after fix types in other method */
    private void d2(AdCard adCard) {
        com.baidu.tbadk.core.data.c appInfoModel = adCard.getAppInfoModel();
        RelativeLayout downloadButtonContainer = this.mWz.getDownloadButtonContainer();
        if (com.baidu.tbadk.core.data.c.b(appInfoModel)) {
            this.mWz.setVisibility(0);
            this.mWz.setAppInfo(appInfoModel);
            this.mWz.setAd(adCard.getAdvertAppInfo());
            if (!e(this.mWl, downloadButtonContainer)) {
                d(this.mWl, downloadButtonContainer);
                return;
            }
            return;
        }
        this.mWz.setVisibility(8);
        if (!e(this.mWl, this.mWn)) {
            d(this.mWl, this.mWn);
        }
    }

    private void a(final AdCard adCard, b bVar) {
        this.mWl.setVisibility(8);
        this.mWz.setVisibility(8);
        String str = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        final String str2 = bVar2 == null ? "" : bVar2.scheme;
        if (k.isEmpty(str) || (!TextUtils.isEmpty(adCard.buttonTextDone) && 1 != adCard.buttonStatus)) {
            this.mWh.setVisibility(8);
            this.mWh.setClickable(false);
            return;
        }
        this.mWh.setVisibility(0);
        this.mWh.setClickable(true);
        this.mWh.setText(str);
        ap.setViewTextColor(this.mWh, R.color.CAM_X0304, 1);
        ap.setBackgroundResource(this.mWh, R.drawable.ad_download_progress_button_bg);
        if (k.isEmpty(str2)) {
            this.mWh.setClickable(false);
        } else {
            this.mWh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str3;
                    String str4;
                    if (AdCardBaseView.this.leD != null && adCard.buttonClick != null && !t.RB(str2)) {
                        AdCardBaseView.this.leD.b(adCard.buttonClick.mVs, adCard.buttonClick.mVt, null);
                    }
                    if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                        if (TextUtils.isEmpty(adCard.popWindowText)) {
                            if (AdCardBaseView.this.mWq == null || AdCardBaseView.this.mWq.getAdvertAppInfo() == null) {
                                str3 = null;
                                str4 = null;
                            } else {
                                str4 = AdCardBaseView.this.d(AdCardBaseView.this.mWq.getAdvertAppInfo());
                                str3 = AdCardBaseView.this.mWq.getAdvertAppInfo().extensionInfo;
                            }
                            int a2 = t.a(AdCardBaseView.this.eWx, str2, str4, str3);
                            if (t.HO(a2) && AdCardBaseView.this.leD != null) {
                                AdCardBaseView.this.leD.d(a2, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.eWx.getPageActivity());
                        aVar.AB(adCard.popWindowText);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                String str5;
                                String str6;
                                if (AdCardBaseView.this.mWq == null || AdCardBaseView.this.mWq.getAdvertAppInfo() == null) {
                                    str5 = null;
                                    str6 = null;
                                } else {
                                    str6 = AdCardBaseView.this.d(AdCardBaseView.this.mWq.getAdvertAppInfo());
                                    str5 = AdCardBaseView.this.mWq.getAdvertAppInfo().extensionInfo;
                                }
                                int a3 = t.a(AdCardBaseView.this.eWx, str2, str6, str5);
                                if (t.HO(a3) && AdCardBaseView.this.leD != null) {
                                    AdCardBaseView.this.leD.d(a3, null);
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
                        aVar.b(AdCardBaseView.this.eWx).bqz();
                    }
                }
            });
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        int i = (this.mMaxWidth - this.mWc) - this.mWf;
        int i2 = dDV() ? i - (this.mWd + this.mWe) : i;
        String str = null;
        if (advertAppInfo != null && advertAppInfo.blG()) {
            str = adCard.userName.concat("APP");
        } else if (advertAppInfo != null && advertAppInfo.blH()) {
            str = TextUtils.isEmpty(adCard.userName) ? "广告" : adCard.userName;
        }
        this.mWm.setText(com.baidu.tieba.recapp.lego.a.a.a(str, "广告", i2, this.mWm.getPaint()));
    }

    private void e(AdCard adCard) {
        String str = adCard.threadTitle;
        if (TextUtils.isEmpty(str)) {
            this.mWg.setVisibility(8);
            return;
        }
        this.mWg.setMaxLines(adCard.titleLines <= 0 ? 4 : adCard.titleLines);
        this.mWg.setText(str);
        this.mWg.setVisibility(0);
    }

    private void b(AdCard adCard, b bVar) {
        this.mWr.setType(TbadkCoreApplication.getInst().getCardShowType());
        if (dDV()) {
            this.mWr.setVisibility(8);
            this.mWr.setBarNameClickEnabled(false);
            this.mWr.setShareVisible(false);
            this.mWr.setShowPraiseNum(false);
            this.mWr.setCommentNumEnable(false);
            this.mWr.setReplyTimeVisible(false);
            this.mWt.setVisibility(0);
            this.mWu.setVisibility(8);
            return;
        }
        d(adCard, bVar);
    }

    private void m(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.eNd != null && advertAppInfo.eNd.adCloseInfo != null && advertAppInfo.eNd.adCloseInfo.support_close.intValue() > 0) {
            this.mWj.setVisibility(0);
            this.mWj.setPage(getBusinessType());
            this.mWj.setData(advertAppInfo);
            l.addToParentArea(this.eWx.getPageActivity(), this.mWk, 40, 40, 40, 120);
            this.mWk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.mWj.performClick();
                }
            });
            return;
        }
        this.mWj.setVisibility(8);
        this.mWi.setOnClickListener(null);
    }

    private void eb(View view) {
        if (view != null && view.getVisibility() == 0) {
            this.mWw.setVisibility(0);
            if (!e(view, this.mWw)) {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                this.mWw.removeAllViews();
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                this.mWw.addView(view);
            }
        }
    }

    private void ec(View view) {
        if (view != null && view.getVisibility() == 0) {
            this.mWw.setVisibility(8);
            if (!e(view, this.mWs)) {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                this.mWs.addAdTagView(this.mWk);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bLu();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bLv();
    }

    private void a(AdCard adCard, DownloadData downloadData) {
        if (adCard.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.mWl.getDownloadStatus());
        }
    }

    private void c(AdCard adCard, b bVar) {
        if (adCard.directDownload) {
            this.mWl.setOnClickListener(bVar);
        } else {
            this.mWl.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public boolean ce(View view) {
                    AdCardBaseView.this.dDU();
                    return false;
                }
            });
        }
    }

    private void b(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey ER;
        if (!adCard.directDownload) {
            String scheme = adCard.getScheme();
            String d2 = d(advertAppInfo);
            if (!TextUtils.isEmpty(d2)) {
                ER = com.baidu.tieba.ad.download.d.bLC().EQ(d2);
            } else {
                ER = com.baidu.tieba.ad.download.d.bLC().ER(scheme);
            }
            if (ER == null) {
                ER = DownloadCacheKey.create(d2, advertAppInfo.apkUrl, advertAppInfo.eMX);
                com.baidu.tieba.ad.download.d.bLC().a(ER, null);
            }
            i(ER);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.giz = downloadCacheKey;
            bLv();
            this.giA = null;
            AdDownloadData d2 = com.baidu.tieba.ad.download.d.bLC().d(downloadCacheKey);
            if (t.RA(d2.getPkgName())) {
                d2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            }
            String str = "";
            if (this.mWq != null && this.mWq.getAdvertAppInfo() != null) {
                str = this.mWq.getAdvertAppInfo().page;
                d2.setExtInfo(this.mWq.getAdvertAppInfo().extensionInfo);
                d2.setDownloadKey(this.mWq.getDownloadKey());
                d2.setAppJson(App.toJson(this.mWq.getAdvertAppInfo().eNj).toString());
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mWl, d2, str);
            this.giA = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d2.extra().getPercent() > 0) {
                aVar.c((com.baidu.tieba.ad.browser.newstyle.view.a) d2);
            }
            bLu();
            this.mWl.a(d2.getCurrentState());
        }
    }

    private void bLu() {
        if (this.giz != null && this.giA != null) {
            com.baidu.tieba.ad.download.d.bLC().a(this.giz, this.giA);
        }
    }

    private void bLv() {
        if (this.giz != null && this.giA != null) {
            com.baidu.tieba.ad.download.d.bLC().b(this.giz, this.giA);
        }
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void d(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.mWu.setVisibility(0);
            this.mWr.setVisibility(8);
            return;
        }
        this.mWu.setVisibility(8);
        this.mWr.setVisibility(0);
        this.mWr.setBarNameClickEnabled(false);
        this.mWr.setReplyTimeVisible(false);
        this.mWr.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.mWr.setAgreeClickable(true);
            this.mWr.setPraiseContainerBgGray(false);
        } else {
            this.mWr.setAgreeClickable(false);
            this.mWr.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.mWr.setShareClickable(true);
            this.mWr.setShareContainerBgGray(false);
        } else {
            this.mWr.setShareClickable(false);
            this.mWr.setShareContainerBgGray(true);
        }
        if (this.mWr.getCommentContainer() != null) {
            this.mWr.getCommentContainer().setOnClickListener(bVar);
        }
        this.mWr.setNeedAddReplyIcon(true);
        this.mWr.setCommentNumEnable(false);
        this.mWr.setCommentClickable(true);
        this.mWr.setReplayContainerBgGray(true);
        this.mWr.setOnClickListener(bVar);
        this.mWr.setShareData(adCard);
        this.mWr.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        this.mWj.onChangeSkinType();
        this.mWs.onChangeSkinType(this.eWx, TbadkCoreApplication.getInst().getSkinType());
        this.mWr.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            com.baidu.tbadk.core.elementsMaven.c.br(this.mRootView).oh(R.string.J_X06).aJ(R.color.CAM_X0205, R.color.cp_bg_line_e_alpha50);
        }
        com.baidu.tbadk.a.b.b.h((TextView) this.mWs.getUserName());
        ap.setViewTextColor(this.mWg, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.mWm, R.color.CAM_X0109);
        ap.setViewTextColor(this.mWi, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.mWh, R.color.CAM_X0304, 1);
        ap.setBackgroundResource(this.mWh, R.drawable.ad_download_progress_button_bg);
        ap.setBackgroundColor(this.mWy, R.color.CAM_X0203);
        ap.setBackgroundColor(this.mWx, R.color.CAM_X0204);
        this.mWl.onChangeSkinType(i);
        com.baidu.tbadk.core.elementsMaven.c.br(this.mWz).oh(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
        this.mWz.onChangeSkinType();
    }

    protected void a(AdCard.b bVar) {
        if (bVar != null) {
            if (b(bVar) && !v.RB(bVar.scheme)) {
                if (this.leD != null) {
                    this.leD.b(bVar.mVs, bVar.mVt, null);
                }
            } else if (this.mWq != null && this.mWq.getAdvertAppInfo() != null) {
                String str = bVar.scheme;
                String d2 = d(this.mWq.getAdvertAppInfo());
                String str2 = this.mWq.getAdvertAppInfo().extensionInfo;
                int i = 3;
                if (!this.mWq.directDownload && this.mWq.getAdvertAppInfo().blG()) {
                    if (!t.b(this.mWq.getAdvertAppInfo(), str)) {
                        i = t.a(this.eWx, str, d2, str2);
                    }
                } else {
                    i = t.a(this.eWx, str, d2, str2);
                }
                if (t.HO(i) && this.leD != null) {
                    this.leD.d(i, null);
                } else if (this.leD != null) {
                    this.leD.b(bVar.mVs, bVar.mVt, null);
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
                        if (AdCardBaseView.this.mWq.hasAnimation()) {
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
        this.ldc = new a.C0782a();
        this.ldc.picUrl = tbImageView.getUrl();
        this.ldc.rect = rect;
    }

    private void RM(String str) {
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
                    com.baidu.adp.lib.e.d.mw().a(jSONObject.optString("pic_url"), 17, null, this.leK, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.leK), this.eWx.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.blF() != 0) {
                l.showToast(this.eWx.getPageActivity(), R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.eWx.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.eWx.getPageActivity()) && this.leE != null) {
                this.leE.c(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.p(d(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.eWx.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.blG()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.eWx.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eWx.getPageActivity());
                aVar.AB(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.mWl);
                        if (AdCardBaseView.this.mWl != null) {
                            AdCardBaseView.this.mWl.p(AdCardBaseView.this.d(advertAppInfo, i));
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
                aVar.b(this.eWx).bqz();
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
                        apkDownloadView.q(d2);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    h.installApp(this.eWx.getPageActivity(), advertAppInfo.eMX);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, this.mWl);
                    apkDownloadView.r(d2);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.bLC().aL(this.eWx.getPageActivity(), advertAppInfo.eMX);
                    return;
            }
        }
    }

    public a.C0782a getAnimationInfo() {
        return this.ldc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        private AdCard mWL;

        public b(AdCard adCard) {
            this.mWL = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdCardBaseView.this.eWx.showToast(R.string.neterror);
            } else if (this.mWL != null && view != null && view.getId() != R.id.thread_info_commont_container) {
                AdvertAppInfo advertAppInfo = this.mWL.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.mWl;
                if (advertAppInfo != null && advertAppInfo.blG()) {
                    a(advertAppInfo, z);
                } else {
                    n(advertAppInfo);
                }
            }
        }

        private void a(AdvertAppInfo advertAppInfo, boolean z) {
            if (this.mWL.directDownload || z) {
                b(advertAppInfo, z);
            } else {
                o(advertAppInfo);
            }
        }

        private void n(AdvertAppInfo advertAppInfo) {
            String scheme = this.mWL.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.eMW;
            }
            if (this.mWL.hasAnimation()) {
            }
            String str = "";
            String str2 = "";
            if (advertAppInfo != null) {
                str2 = AdCardBaseView.this.d(advertAppInfo);
                str = advertAppInfo.extensionInfo;
            }
            int a2 = t.a(AdCardBaseView.this.eWx, scheme, str2, str);
            if (AdCardBaseView.this.leD != null) {
                AdCardBaseView.this.leD.d(a2, null);
            }
        }

        private void b(AdvertAppInfo advertAppInfo, boolean z) {
            int i = advertAppInfo.position;
            int status = ApkDownloadView.getStatus(AdCardBaseView.this.d(advertAppInfo, i));
            if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                return;
            }
            AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.mWl, z);
            AdCardBaseView.this.dDU();
        }

        private void o(AdvertAppInfo advertAppInfo) {
            int i;
            String scheme = this.mWL.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.eMW;
            }
            String str = "";
            String str2 = "";
            if (advertAppInfo != null) {
                str2 = AdCardBaseView.this.d(advertAppInfo);
                str = advertAppInfo.extensionInfo;
            }
            if (!t.b(advertAppInfo, scheme)) {
                i = t.a(AdCardBaseView.this.eWx, scheme, str2, str);
            } else {
                i = 3;
            }
            if (AdCardBaseView.this.leD != null) {
                AdCardBaseView.this.leD.d(i, null);
            }
        }
    }

    protected void dDU() {
        if (this.leD != null) {
            this.leD.d(3, null);
        }
    }

    /* loaded from: classes7.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mWK;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mWK = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.mWK.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.mWp) && adCardBaseView.mWp.equals(downloadData.getId())) {
                int status = e.getStatus(downloadData);
                if (status == 7) {
                    adCardBaseView.mWh.setText(R.string.pause_load);
                } else if (status == 1 || status == 2) {
                    adCardBaseView.mWh.setText(R.string.pb_download_pause);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mWK;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mWK = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.mWK.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.mWp) && adCardBaseView.mWp.equals(downloadData.getId())) {
                adCardBaseView.mWl.s(downloadData);
            }
        }
    }

    /* loaded from: classes7.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mWK;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mWK = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str;
            String str2;
            AdCardBaseView adCardBaseView = this.mWK.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                if (adCardBaseView.mWq == null || adCardBaseView.mWq.getAdvertAppInfo() == null) {
                    str = null;
                    str2 = null;
                } else {
                    str2 = TextUtils.isEmpty(adCardBaseView.mWq.getAdvertAppInfo().eMX) ? adCardBaseView.mWq.getAdvertAppInfo().eMU : adCardBaseView.mWq.getAdvertAppInfo().eMX;
                    str = adCardBaseView.mWq.getAdvertAppInfo().extensionInfo;
                }
                t.a(adCardBaseView.eWx, adCardBaseView.mWv.scheme, str2, str);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void dck() {
        if (dDV()) {
            this.mWg.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.mVu != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.mWv = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.eWx.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.eWx, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        return true;
    }

    DownloadData d(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(d(advertAppInfo));
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.eMV);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.eMU, 0));
        return downloadData;
    }

    protected boolean dDV() {
        return getBusinessType() == 4;
    }

    protected boolean f(AdCard adCard) {
        return dDV() && adCard.isPBBanner;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float HW(@StringRes int i) {
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
