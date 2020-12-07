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
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.recapp.view.AdThreadUserInfoLayout;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.tieba.tbadkCore.v;
import com.baidu.webkit.internal.ETAG;
import com.tencent.open.SocialConstants;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes26.dex */
public abstract class AdCardBaseView extends BaseLegoCardView<AdCard> implements com.baidu.tieba.lego.card.b.a {
    private DownloadCacheKey fZS;
    private com.baidu.tieba.ad.download.a.d fZT;
    private a.C0795a kRH;
    private final int kTo;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected final int mJA;
    protected final int mJB;
    private final int mJC;
    private final int mJD;
    private final int mJE;
    private final int mJF;
    protected TextView mJG;
    protected TextView mJH;
    protected TextView mJI;
    private AdCloseView mJJ;
    private LinearLayout mJK;
    protected ApkDownloadView mJL;
    protected TextView mJM;
    protected RelativeLayout mJN;
    protected View mJO;
    protected String mJP;
    private AdCard mJQ;
    private AdThreadCommentAndPraiseInfoLayout mJR;
    protected AdThreadUserInfoLayout mJS;
    protected View mJT;
    protected View mJU;
    protected AdCard.b mJV;
    private FrameLayout mJW;
    private View mJX;
    private View mJY;
    protected CustomMessageListener mJZ;
    protected ViewStub mJo;
    protected View mJp;
    protected View mJq;
    protected final int mJr;
    protected final int mJs;
    protected final int mJt;
    protected final int mJu;
    private final int mJv;
    private final int mJw;
    protected final int mJx;
    private final int mJy;
    protected final int mJz;
    protected CustomMessageListener mKa;
    protected CustomMessageListener mKb;
    protected int mMaxWidth;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void dS(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kTo = l.getEquipmentWidth(getContext());
        this.fZT = null;
        this.mJZ = new a(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG, this);
        this.mKa = new d(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG, this);
        this.mKb = new c(CmdConfigCustom.CMD_USER_INFO_CHANGED, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.tbds648);
        this.mImageHeight = (int) resources.getDimension(R.dimen.tbds488);
        this.mJr = (int) resources.getDimension(R.dimen.tbds92);
        this.mJs = (int) resources.getDimension(R.dimen.tbds92);
        this.mJt = (int) resources.getDimension(R.dimen.M_W_X004);
        this.mJz = (int) resources.getDimension(R.dimen.tbds90);
        this.mJA = (int) resources.getDimension(R.dimen.tbds90);
        this.mJB = (int) resources.getDimension(R.dimen.tbds22);
        if (com.baidu.tbadk.a.d.bkA()) {
            this.mJu = (int) resources.getDimension(R.dimen.M_W_X007);
            this.mJx = 0;
        } else {
            this.mJu = (int) resources.getDimension(R.dimen.M_W_X005);
            this.mJx = (int) resources.getDimension(R.dimen.M_W_X004);
        }
        this.mJy = 0;
        this.mJv = (int) resources.getDimension(R.dimen.M_W_X007);
        this.mJw = (int) resources.getDimension(R.dimen.M_H_X005);
        this.mJC = (int) resources.getDimension(R.dimen.tbds208);
        this.mJD = (int) resources.getDimension(R.dimen.tbds33);
        this.mJE = (int) resources.getDimension(R.dimen.tbds72);
        this.mJF = (int) resources.getDimension(R.dimen.tbds48);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ddV() {
        MessageManager.getInstance().registerListener(this.mJZ);
        MessageManager.getInstance().registerListener(this.mKa);
        MessageManager.getInstance().registerListener(this.mKb);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.mJX = this.mRootView.findViewById(R.id.banner_top_divider);
        this.mJq = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.mJq.setClickable(true);
        this.mJG = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.mJH = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.mJL = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.mJM = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.mJN = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.mJL.x(this.eNx.getUniqueId());
        this.mJZ.setTag(this.eNx.getUniqueId());
        this.mJO = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.mKa.setTag(this.eNx.getUniqueId());
        this.mKb.setTag(this.eNx.getUniqueId());
        this.mJR = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.mJR.setStyle(1);
        this.mJS = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        this.mJW = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        this.mJK = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mJJ = (AdCloseView) this.mJK.findViewById(R.id.ad_close_view);
        ViewGroup.LayoutParams layoutParams = this.mJJ.mOa.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.mJJ.mOa.getLayoutParams();
        int dimens = l.getDimens(getContext(), R.dimen.tbds62);
        layoutParams2.width = dimens;
        layoutParams.height = dimens;
        this.mJI = (TextView) this.mJK.findViewById(R.id.feed_tag);
        this.mJI.setVisibility(8);
        this.mJS.addAdTagView(this.mJK);
        this.mJo = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.mJo.setLayoutResource(getCustomLayout());
        this.mJp = this.mJo.inflate();
        this.mJT = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.mJU = this.mRootView.findViewById(R.id.frs_bottom_view);
        this.mJY = this.mRootView.findViewById(R.id.pb_ad_bottom_divider);
        dS(this.mJp);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(AdCard adCard) {
        this.mJQ = adCard;
        if (adCard != null) {
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            b bVar = new b(adCard);
            c(adCard);
            a(adCard, advertAppInfo, bVar);
            d2(adCard);
            b(adCard, advertAppInfo, bVar);
            a(adCard, advertAppInfo);
            k(advertAppInfo);
            b(adCard, bVar);
            this.mRootView.setOnClickListener(bVar);
            if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
                Sb(adCard.getPreLoadData());
            }
            a(adCard);
            a(adCard, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void c(AdCard adCard) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mJO.getLayoutParams();
        layoutParams.topMargin = this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        this.mJO.setPadding(0, 0, 0, 0);
        ((RelativeLayout.LayoutParams) this.mJL.getLayoutParams()).addRule(11, -1);
        ((RelativeLayout.LayoutParams) this.mJH.getLayoutParams()).addRule(11, -1);
        this.mJW.setVisibility(8);
        this.mJN.requestLayout();
        this.mJX.setVisibility(8);
        if (dFy()) {
            this.mRootView.setPadding(this.mJv, this.mJw, this.mJv, 0);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mJO.getLayoutParams();
            this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - (this.mJy * 2)) - (this.mJv * 2)) - this.mJr) - this.mJt;
            layoutParams2.leftMargin = this.mJr + this.mJt;
            this.mJY.setVisibility(0);
            dU(this.mJK);
            if (e(adCard)) {
                this.mJY.setVisibility(8);
                this.mRootView.setPadding(0, 0, 0, 0);
                this.mJO.setPadding(this.mJv, 0, this.mJv, 0);
                layoutParams2.leftMargin = 0;
                this.mMaxWidth = (l.getEquipmentWidth(getContext()) - (this.mJv * 2)) - (this.mJy * 2);
                layoutParams.topMargin = this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
                this.mJX.setVisibility(0);
                ap.setBackgroundColor(this.mJX, R.color.CAM_X0204);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mJL.getLayoutParams();
                layoutParams3.addRule(11, 0);
                layoutParams3.addRule(0, this.mJW.getId());
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mJH.getLayoutParams();
                layoutParams4.addRule(11, 0);
                layoutParams4.addRule(0, this.mJW.getId());
                this.mJN.requestLayout();
                dT(this.mJK);
                return;
            }
            return;
        }
        this.mRootView.setPadding(this.mJu, this.mJw, this.mJu, 0);
        this.mMaxWidth = (l.getEquipmentWidth(getContext()) - (this.mJu * 2)) - (this.mJx * 2);
        if ((com.baidu.tieba.frs.b.cBd().cAX() || com.baidu.tieba.frs.a.cAW().cAX()) && isInFrsAllThread()) {
            this.mJq.setVisibility(0);
            ap.setBackgroundColor(this.mJq, R.color.CAM_X0201);
        } else {
            this.mJq.setVisibility(8);
        }
        this.mJY.setVisibility(8);
    }

    private void a(final AdCard adCard, final AdvertAppInfo advertAppInfo, b bVar) {
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 != null) {
            advertAppInfo2.Bb(au.dS(adCard.time));
        }
        this.mJS.setShowFlag(1413);
        this.mJS.setData(advertAppInfo2);
        ((TextView) this.mJS.getUserName()).setText(adCard.userName);
        com.baidu.tbadk.a.b.a.e((TextView) this.mJS.getUserName());
        this.mJS.getUserName().setOnClickListener(bVar);
        this.mJS.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.mJS.getUserName()).setText(adCard.userName);
            }
        });
        this.mJS.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.bxj() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.eNx.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        a(this.mJS.getHeaderImg(), adCard.portraitClick, bVar);
        if (e(adCard)) {
            this.mJS.setVisibility(8);
        }
    }

    private void b(AdCard adCard, AdvertAppInfo advertAppInfo, b bVar) {
        if (adCard == null || advertAppInfo == null) {
            this.mJN.setVisibility(8);
            return;
        }
        this.mJN.setVisibility(0);
        if (advertAppInfo.bmE()) {
            a(advertAppInfo, adCard, bVar);
            b(adCard, advertAppInfo);
        } else if (advertAppInfo.bmF()) {
            a(adCard, bVar);
        }
    }

    private void a(AdvertAppInfo advertAppInfo, AdCard adCard, b bVar) {
        this.mJH.setVisibility(8);
        this.mJL.setVisibility(0);
        this.mJL.setClickable(true);
        this.mJP = advertAppInfo.eEg;
        DownloadData d2 = d(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
        a(adCard, d2);
        this.mJL.setData(d2);
        c(adCard, bVar);
    }

    private void a(final AdCard adCard, b bVar) {
        this.mJL.setVisibility(8);
        String str = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        final String str2 = bVar2 == null ? "" : bVar2.scheme;
        if (k.isEmpty(str) || (!TextUtils.isEmpty(adCard.buttonTextDone) && 1 != adCard.buttonStatus)) {
            this.mJH.setVisibility(8);
            this.mJH.setClickable(false);
            return;
        }
        this.mJH.setVisibility(0);
        this.mJH.setClickable(true);
        this.mJH.setText(str);
        ap.setViewTextColor(this.mJH, R.color.CAM_X0304, 1);
        ap.setBackgroundResource(this.mJH, R.drawable.ad_download_progress_button_bg);
        if (k.isEmpty(str2)) {
            this.mJH.setClickable(false);
        } else {
            this.mJH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AdCardBaseView.this.kTh != null && adCard.buttonClick != null && !v.RT(adCard.buttonClick.scheme)) {
                        AdCardBaseView.this.kTh.a(adCard.buttonClick.mIX, adCard.buttonClick.mIY, null);
                    }
                    if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                        if (TextUtils.isEmpty(adCard.popWindowText)) {
                            int c2 = s.c(AdCardBaseView.this.eNx, str2, (AdCardBaseView.this.mJQ == null || AdCardBaseView.this.mJQ.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.d(AdCardBaseView.this.mJQ.getAdvertAppInfo()));
                            if ((c2 == 1 || c2 == 2) && AdCardBaseView.this.kTh != null) {
                                AdCardBaseView.this.kTh.d(c2, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.eNx.getPageActivity());
                        aVar.Bq(adCard.popWindowText);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int c3 = s.c(AdCardBaseView.this.eNx, str2, (AdCardBaseView.this.mJQ == null || AdCardBaseView.this.mJQ.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.d(AdCardBaseView.this.mJQ.getAdvertAppInfo()));
                                if ((c3 == 1 || c3 == 2) && AdCardBaseView.this.kTh != null) {
                                    AdCardBaseView.this.kTh.d(c3, null);
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
                        aVar.b(AdCardBaseView.this.eNx).brv();
                    }
                }
            });
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        int i = (this.mMaxWidth - this.mJC) - this.mJF;
        int i2 = dFy() ? i - (this.mJD + this.mJE) : i;
        String str = null;
        if (advertAppInfo != null && advertAppInfo.bmE()) {
            str = adCard.userName.concat("APP");
        } else if (advertAppInfo != null && advertAppInfo.bmF()) {
            str = TextUtils.isEmpty(adCard.userName) ? "广告" : adCard.userName;
        }
        this.mJM.setText(com.baidu.tieba.recapp.lego.a.a.a(str, "广告", i2, this.mJM.getPaint()));
    }

    /* renamed from: d  reason: avoid collision after fix types in other method */
    private void d2(AdCard adCard) {
        String str = adCard.threadTitle;
        if (TextUtils.isEmpty(str)) {
            this.mJG.setVisibility(8);
            return;
        }
        this.mJG.setMaxLines(adCard.titleLines <= 0 ? 4 : adCard.titleLines);
        this.mJG.setText(str);
        this.mJG.setVisibility(0);
    }

    private void b(AdCard adCard, b bVar) {
        this.mJR.setType(TbadkCoreApplication.getInst().getCardShowType());
        if (dFy()) {
            this.mJR.setVisibility(8);
            this.mJR.setBarNameClickEnabled(false);
            this.mJR.setShareVisible(false);
            this.mJR.setShowPraiseNum(false);
            this.mJR.setCommentNumEnable(false);
            this.mJR.setReplyTimeVisible(false);
            this.mJT.setVisibility(0);
            this.mJU.setVisibility(8);
            return;
        }
        d(adCard, bVar);
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.eEm != null && advertAppInfo.eEm.adCloseInfo != null && advertAppInfo.eEm.adCloseInfo.support_close.intValue() > 0) {
            this.mJJ.setVisibility(0);
            this.mJJ.setPage(getBusinessType());
            this.mJJ.setData(advertAppInfo);
            l.addToParentArea(this.eNx.getPageActivity(), this.mJK, 40, 40, 40, 120);
            this.mJK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.mJJ.performClick();
                }
            });
            return;
        }
        this.mJJ.setVisibility(8);
        this.mJI.setOnClickListener(null);
    }

    private void dT(View view) {
        if (view != null && view.getVisibility() == 0) {
            this.mJW.setVisibility(0);
            if (view.getParent() == null || view.getParent() != this.mJW) {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                this.mJW.removeAllViews();
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                this.mJW.addView(view);
            }
        }
    }

    private void dU(View view) {
        if (view != null && view.getVisibility() == 0) {
            this.mJW.setVisibility(8);
            if (view.getParent() == null || view.getParent() != this.mJS) {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                this.mJS.addAdTagView(this.mJK);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bMq();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bMr();
    }

    private void a(AdCard adCard, DownloadData downloadData) {
        if (adCard.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.mJL.getDownloadStatus());
        }
    }

    private void c(AdCard adCard, b bVar) {
        if (adCard.directDownload) {
            this.mJL.setOnClickListener(bVar);
        } else {
            this.mJL.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public boolean bZ(View view) {
                    AdCardBaseView.this.dFx();
                    return false;
                }
            });
        }
    }

    private void b(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey FB;
        if (!adCard.directDownload) {
            String scheme = adCard.getScheme();
            String d2 = d(advertAppInfo);
            if (!TextUtils.isEmpty(d2)) {
                FB = com.baidu.tieba.ad.download.d.bMx().FA(d2);
            } else {
                FB = com.baidu.tieba.ad.download.d.bMx().FB(scheme);
            }
            if (FB == null) {
                FB = DownloadCacheKey.create(d2, advertAppInfo.apkUrl, advertAppInfo.eEg);
                com.baidu.tieba.ad.download.d.bMx().a(FB, null);
            }
            i(FB);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.fZS = downloadCacheKey;
            bMr();
            this.fZT = null;
            AdDownloadData d2 = com.baidu.tieba.ad.download.d.bMx().d(downloadCacheKey);
            if (d2 != null) {
                this.mJL.a(d2.getCurrentState());
            } else {
                this.mJL.a(DownloadStatus.STATUS_NONE);
            }
            String str = "";
            if (this.mJQ != null && this.mJQ.getAdvertAppInfo() != null) {
                str = this.mJQ.getAdvertAppInfo().page;
                d2.setExtInfo(this.mJQ.getAdvertAppInfo().extensionInfo);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mJL, d2, str);
            this.fZT = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d2.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d2);
            }
            bMq();
        }
    }

    private void bMq() {
        if (this.fZS != null && this.fZT != null) {
            com.baidu.tieba.ad.download.d.bMx().a(this.fZS, this.fZT);
        }
    }

    private void bMr() {
        if (this.fZS != null && this.fZT != null) {
            com.baidu.tieba.ad.download.d.bMx().b(this.fZS, this.fZT);
        }
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void d(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.mJU.setVisibility(0);
            this.mJR.setVisibility(8);
            return;
        }
        this.mJU.setVisibility(8);
        this.mJR.setVisibility(0);
        this.mJR.setBarNameClickEnabled(false);
        this.mJR.setReplyTimeVisible(false);
        this.mJR.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.mJR.setAgreeClickable(true);
            this.mJR.setPraiseContainerBgGray(false);
        } else {
            this.mJR.setAgreeClickable(false);
            this.mJR.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.mJR.setShareClickable(true);
            this.mJR.setShareContainerBgGray(false);
        } else {
            this.mJR.setShareClickable(false);
            this.mJR.setShareContainerBgGray(true);
        }
        if (this.mJR.getCommentContainer() != null) {
            this.mJR.getCommentContainer().setOnClickListener(bVar);
        }
        this.mJR.setNeedAddReplyIcon(true);
        this.mJR.setCommentNumEnable(false);
        this.mJR.setCommentClickable(true);
        this.mJR.setReplayContainerBgGray(true);
        this.mJR.setOnClickListener(bVar);
        this.mJR.setShareData(adCard);
        this.mJR.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        this.mJJ.onChangeSkinType();
        this.mJS.onChangeSkinType(this.eNx, TbadkCoreApplication.getInst().getSkinType());
        this.mJR.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            com.baidu.tbadk.core.elementsMaven.c.bm(this.mRootView).pA(com.baidu.tbadk.a.d.bkA() ? R.string.J_X02 : R.string.J_X06).aP(R.color.CAM_X0205, R.color.cp_bg_line_e_alpha50);
        }
        com.baidu.tbadk.a.b.a.f((TextView) this.mJS.getUserName());
        ap.setViewTextColor(this.mJG, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.mJM, R.color.CAM_X0109);
        ap.setViewTextColor(this.mJI, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.mJH, R.color.CAM_X0304, 1);
        ap.setBackgroundResource(this.mJH, R.drawable.ad_download_progress_button_bg);
        ap.setBackgroundColor(this.mJY, R.color.CAM_X0203);
        ap.setBackgroundColor(this.mJX, R.color.CAM_X0204);
        this.mJL.onChangeSkinType(i);
    }

    protected void a(AdCard.b bVar) {
        int c2;
        if (bVar != null) {
            if (b(bVar) && !v.RT(bVar.scheme)) {
                if (this.kTh != null) {
                    this.kTh.a(bVar.mIX, bVar.mIY, null);
                }
            } else if (this.mJQ != null && this.mJQ.getAdvertAppInfo() != null) {
                String Sc = Sc(bVar.scheme);
                String d2 = d(this.mJQ.getAdvertAppInfo());
                if (!this.mJQ.directDownload && this.mJQ.getAdvertAppInfo().bmE()) {
                    c2 = s.d(this.eNx, Sc, d2);
                } else {
                    c2 = s.c(this.eNx, Sc, d2);
                }
                if (c2 == 1 || c2 == 2) {
                    if (this.kTh != null) {
                        this.kTh.d(c2, null);
                    }
                } else if (this.kTh != null) {
                    this.kTh.a(bVar.mIX, bVar.mIY, null);
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
                        if (AdCardBaseView.this.mJQ.hasAnimation()) {
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
        this.kRH = new a.C0795a();
        this.kRH.picUrl = tbImageView.getUrl();
        this.kRH.bHi = rect;
    }

    private void Sb(String str) {
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
                    com.baidu.adp.lib.e.c.mS().a(jSONObject.optString("pic_url"), 17, null, this.kTo, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.kTo), this.eNx.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.bmD() != 0) {
                l.showToast(this.eNx.getPageActivity(), R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.eNx.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.eNx.getPageActivity()) && this.kTi != null) {
                this.kTi.c(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(d(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.eNx.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bmE()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.eNx.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eNx.getPageActivity());
                aVar.Bq(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.mJL);
                        if (AdCardBaseView.this.mJL != null) {
                            AdCardBaseView.this.mJL.q(AdCardBaseView.this.d(advertAppInfo, i));
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
                aVar.b(this.eNx).brv();
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
                        h.h(advertAppInfo);
                        apkDownloadView.r(d2);
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    h.aY(this.eNx.getPageActivity(), advertAppInfo.eEg);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, this.mJL);
                    apkDownloadView.s(d2);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.bMx().aG(this.eNx.getPageActivity(), advertAppInfo.eEg);
                    return;
            }
        }
    }

    public a.C0795a getAnimationInfo() {
        return this.kRH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public class b implements View.OnClickListener {
        private AdCard mKk;

        public b(AdCard adCard) {
            this.mKk = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdCardBaseView.this.eNx.showToast(R.string.neterror);
            } else if (this.mKk != null && view != null && view.getId() != R.id.thread_info_commont_container) {
                AdvertAppInfo advertAppInfo = this.mKk.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.mJL;
                if (advertAppInfo != null && advertAppInfo.bmE()) {
                    a(advertAppInfo, z);
                } else {
                    l(advertAppInfo);
                }
            }
        }

        private void a(AdvertAppInfo advertAppInfo, boolean z) {
            if (this.mKk.directDownload || z) {
                b(advertAppInfo, z);
            } else {
                m(advertAppInfo);
            }
        }

        private void l(AdvertAppInfo advertAppInfo) {
            String scheme = this.mKk.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.eEf;
            }
            if (this.mKk.hasAnimation()) {
            }
            int c = s.c(AdCardBaseView.this.eNx, AdCardBaseView.this.Sc(scheme), AdCardBaseView.this.d(advertAppInfo));
            if (AdCardBaseView.this.kTh != null) {
                AdCardBaseView.this.kTh.d(c, null);
            }
        }

        private void b(AdvertAppInfo advertAppInfo, boolean z) {
            int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
            int status = ApkDownloadView.getStatus(AdCardBaseView.this.d(advertAppInfo, i));
            if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                return;
            }
            AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.mJL, z);
            AdCardBaseView.this.dFx();
        }

        private void m(AdvertAppInfo advertAppInfo) {
            String scheme = this.mKk.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.eEf;
            }
            int d = s.d(AdCardBaseView.this.eNx, scheme, AdCardBaseView.this.d(advertAppInfo));
            if (AdCardBaseView.this.kTh != null) {
                AdCardBaseView.this.kTh.d(d, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dFx() {
        if (this.kTh != null) {
            this.kTh.d(3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Sc(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.kRH != null && this.kRH.isValid()) {
            String c0795a = this.kRH.toString();
            if (!TextUtils.isEmpty(c0795a)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append("=");
                sb.append(URLEncoder.encode(c0795a));
            }
        }
        if (!TextUtils.isEmpty(this.mJQ.getPreLoadData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append("=");
            sb.append(URLEncoder.encode(this.mJQ.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.mJQ.getNextPageData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append("=");
            sb.append(URLEncoder.encode(this.mJQ.getNextPageData()));
        }
        if (this.mJQ.hasAnimation()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append("=");
            sb.append("1");
        }
        if (this.mJQ.isGoLandingPage()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append("=");
            sb.append("1");
        }
        if (this.mJQ.isImmersiveStyle()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append("=");
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes26.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mKj;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mKj = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.mKj.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.mJP) && adCardBaseView.mJP.equals(downloadData.getId())) {
                int status = e.getStatus(downloadData);
                if (status == 7) {
                    adCardBaseView.mJH.setText(R.string.pause_load);
                } else if (status == 1 || status == 2) {
                    adCardBaseView.mJH.setText(R.string.pb_download_pause);
                }
            }
        }
    }

    /* loaded from: classes26.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mKj;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mKj = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.mKj.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.mJP) && adCardBaseView.mJP.equals(downloadData.getId())) {
                adCardBaseView.mJL.t(downloadData);
            }
        }
    }

    /* loaded from: classes26.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mKj;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mKj = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.mKj.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                String str = null;
                if (adCardBaseView.mJQ != null && adCardBaseView.mJQ.getAdvertAppInfo() != null) {
                    str = TextUtils.isEmpty(adCardBaseView.mJQ.getAdvertAppInfo().eEg) ? adCardBaseView.mJQ.getAdvertAppInfo().eEd : adCardBaseView.mJQ.getAdvertAppInfo().eEg;
                }
                s.c(adCardBaseView.eNx, adCardBaseView.mJV.scheme, str);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void deb() {
        if (dFy()) {
            this.mJG.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.mIZ != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.mJV = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.eNx.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.eNx, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        return true;
    }

    DownloadData d(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(d(advertAppInfo));
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.eEe);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.eEd, 0));
        return downloadData;
    }

    protected boolean dFy() {
        return getBusinessType() == 4;
    }

    protected boolean e(AdCard adCard) {
        return dFy() && adCard.isPBBanner;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float Jm(@StringRes int i) {
        try {
            return Float.parseFloat(TbadkCoreApplication.getInst().getContext().getResources().getString(i).split(",")[0]);
        } catch (Exception e) {
            return 0.0f;
        }
    }
}
