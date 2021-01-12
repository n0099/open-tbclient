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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
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
/* loaded from: classes7.dex */
public abstract class AdCardBaseView extends BaseLegoCardView<AdCard> implements com.baidu.tieba.lego.card.a.a {
    private DownloadCacheKey geB;
    private com.baidu.tieba.ad.download.a.d geC;
    private a.C0773a kSI;
    private final int kUp;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected ViewStub mJS;
    protected View mJT;
    protected View mJU;
    protected final int mJV;
    protected final int mJW;
    protected final int mJX;
    protected final int mJY;
    private final int mJZ;
    private FrameLayout mKA;
    private View mKB;
    private View mKC;
    protected CustomMessageListener mKD;
    protected CustomMessageListener mKE;
    protected CustomMessageListener mKF;
    private final int mKa;
    protected final int mKb;
    private final int mKc;
    protected final int mKd;
    protected final int mKe;
    protected final int mKf;
    private final int mKg;
    private final int mKh;
    private final int mKi;
    private final int mKj;
    protected TextView mKk;
    protected TextView mKl;
    protected TextView mKm;
    private AdCloseView mKn;
    private LinearLayout mKo;
    protected ApkDownloadView mKp;
    protected TextView mKq;
    protected RelativeLayout mKr;
    protected View mKs;
    protected String mKt;
    private AdCard mKu;
    private AdThreadCommentAndPraiseInfoLayout mKv;
    protected AdThreadUserInfoLayout mKw;
    protected View mKx;
    protected View mKy;
    protected AdCard.b mKz;
    protected int mMaxWidth;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void ec(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kUp = l.getEquipmentWidth(getContext());
        this.geC = null;
        this.mKD = new a(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG, this);
        this.mKE = new d(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG, this);
        this.mKF = new c(CmdConfigCustom.CMD_USER_INFO_CHANGED, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.tbds648);
        this.mImageHeight = (int) resources.getDimension(R.dimen.tbds488);
        this.mJV = (int) resources.getDimension(R.dimen.tbds92);
        this.mJW = (int) resources.getDimension(R.dimen.tbds92);
        this.mJX = (int) resources.getDimension(R.dimen.M_W_X004);
        this.mKd = (int) resources.getDimension(R.dimen.tbds90);
        this.mKe = (int) resources.getDimension(R.dimen.tbds90);
        this.mKf = (int) resources.getDimension(R.dimen.tbds22);
        this.mJY = (int) resources.getDimension(R.dimen.M_W_X005);
        this.mKb = (int) resources.getDimension(R.dimen.M_W_X004);
        this.mKc = 0;
        this.mJZ = (int) resources.getDimension(R.dimen.M_W_X007);
        this.mKa = (int) resources.getDimension(R.dimen.M_H_X005);
        this.mKg = (int) resources.getDimension(R.dimen.tbds208);
        this.mKh = (int) resources.getDimension(R.dimen.tbds33);
        this.mKi = (int) resources.getDimension(R.dimen.tbds72);
        this.mKj = (int) resources.getDimension(R.dimen.tbds48);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cZQ() {
        MessageManager.getInstance().registerListener(this.mKD);
        MessageManager.getInstance().registerListener(this.mKE);
        MessageManager.getInstance().registerListener(this.mKF);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.mKB = this.mRootView.findViewById(R.id.banner_top_divider);
        this.mJU = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.mJU.setClickable(true);
        this.mKk = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.mKl = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.mKp = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.mKq = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.mKr = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.mKp.x(this.eSJ.getUniqueId());
        this.mKD.setTag(this.eSJ.getUniqueId());
        this.mKs = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.mKE.setTag(this.eSJ.getUniqueId());
        this.mKF.setTag(this.eSJ.getUniqueId());
        this.mKv = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.mKv.setStyle(1);
        this.mKw = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        this.mKA = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        this.mKo = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mKn = (AdCloseView) this.mKo.findViewById(R.id.ad_close_view);
        ViewGroup.LayoutParams layoutParams = this.mKn.mOD.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.mKn.mOD.getLayoutParams();
        int dimens = l.getDimens(getContext(), R.dimen.tbds62);
        layoutParams2.width = dimens;
        layoutParams.height = dimens;
        this.mKm = (TextView) this.mKo.findViewById(R.id.feed_tag);
        this.mKm.setVisibility(8);
        this.mKw.addAdTagView(this.mKo);
        this.mJS = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.mJS.setLayoutResource(getCustomLayout());
        this.mJT = this.mJS.inflate();
        this.mKx = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.mKy = this.mRootView.findViewById(R.id.frs_bottom_view);
        this.mKC = this.mRootView.findViewById(R.id.pb_ad_bottom_divider);
        ec(this.mJT);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(AdCard adCard) {
        this.mKu = adCard;
        if (adCard != null) {
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            b bVar = new b(adCard);
            c(adCard);
            a(adCard, advertAppInfo, bVar);
            d2(adCard);
            b(adCard, advertAppInfo, bVar);
            a(adCard, advertAppInfo);
            l(advertAppInfo);
            b(adCard, bVar);
            this.mRootView.setOnClickListener(bVar);
            if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
                Qy(adCard.getPreLoadData());
            }
            a(adCard);
            a(adCard, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void c(AdCard adCard) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mKs.getLayoutParams();
        layoutParams.topMargin = this.eSJ.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        this.mKs.setPadding(0, 0, 0, 0);
        ((RelativeLayout.LayoutParams) this.mKp.getLayoutParams()).addRule(11, -1);
        ((RelativeLayout.LayoutParams) this.mKl.getLayoutParams()).addRule(11, -1);
        this.mKA.setVisibility(8);
        this.mKr.requestLayout();
        this.mKB.setVisibility(8);
        if (dBx()) {
            this.mRootView.setPadding(this.mJZ, this.mKa, this.mJZ, 0);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mKs.getLayoutParams();
            this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - (this.mKc * 2)) - (this.mJZ * 2)) - this.mJV) - this.mJX;
            layoutParams2.leftMargin = this.mJV + this.mJX;
            this.mKC.setVisibility(0);
            ee(this.mKo);
            if (e(adCard)) {
                this.mKC.setVisibility(8);
                this.mRootView.setPadding(0, 0, 0, 0);
                this.mKs.setPadding(this.mJZ, 0, this.mJZ, 0);
                layoutParams2.leftMargin = 0;
                this.mMaxWidth = (l.getEquipmentWidth(getContext()) - (this.mJZ * 2)) - (this.mKc * 2);
                layoutParams.topMargin = this.eSJ.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
                this.mKB.setVisibility(0);
                ao.setBackgroundColor(this.mKB, R.color.CAM_X0204);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mKp.getLayoutParams();
                layoutParams3.addRule(11, 0);
                layoutParams3.addRule(0, this.mKA.getId());
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mKl.getLayoutParams();
                layoutParams4.addRule(11, 0);
                layoutParams4.addRule(0, this.mKA.getId());
                this.mKr.requestLayout();
                ed(this.mKo);
                return;
            }
            return;
        }
        this.mRootView.setPadding(this.mJY, this.mKa, this.mJY, 0);
        this.mMaxWidth = (l.getEquipmentWidth(getContext()) - (this.mJY * 2)) - (this.mKb * 2);
        if ((com.baidu.tieba.frs.b.cAg().cAa() || com.baidu.tieba.frs.a.czZ().cAa()) && isInFrsAllThread()) {
            this.mJU.setVisibility(0);
            ao.setBackgroundColor(this.mJU, R.color.CAM_X0201);
        } else {
            this.mJU.setVisibility(8);
        }
        this.mKC.setVisibility(8);
    }

    private void a(final AdCard adCard, final AdvertAppInfo advertAppInfo, b bVar) {
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 != null) {
            advertAppInfo2.zO(at.dS(adCard.time));
        }
        this.mKw.setShowFlag(1413);
        this.mKw.setData(advertAppInfo2);
        ((TextView) this.mKw.getUserName()).setText(adCard.userName);
        com.baidu.tbadk.a.b.b.g((TextView) this.mKw.getUserName());
        this.mKw.getUserName().setOnClickListener(bVar);
        this.mKw.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.mKw.getUserName()).setText(adCard.userName);
            }
        });
        this.mKw.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.bvJ() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.eSJ.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        a(this.mKw.getHeaderImg(), adCard.portraitClick, bVar);
        if (e(adCard)) {
            this.mKw.setVisibility(8);
        }
    }

    private void b(AdCard adCard, AdvertAppInfo advertAppInfo, b bVar) {
        if (adCard == null || advertAppInfo == null) {
            this.mKr.setVisibility(8);
            return;
        }
        this.mKr.setVisibility(0);
        if (advertAppInfo.blm()) {
            a(advertAppInfo, adCard, bVar);
            b(adCard, advertAppInfo);
        } else if (advertAppInfo.bln()) {
            a(adCard, bVar);
        }
    }

    private void a(AdvertAppInfo advertAppInfo, AdCard adCard, b bVar) {
        this.mKl.setVisibility(8);
        this.mKp.setVisibility(0);
        this.mKp.setClickable(true);
        this.mKt = advertAppInfo.eJl;
        DownloadData d2 = d(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
        if (s.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), this.mKt)) {
            d2.setStatus(8);
        } else {
            a(adCard, d2);
        }
        this.mKp.setData(d2);
        c(adCard, bVar);
    }

    private void a(final AdCard adCard, b bVar) {
        this.mKp.setVisibility(8);
        String str = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        final String str2 = bVar2 == null ? "" : bVar2.scheme;
        if (k.isEmpty(str) || (!TextUtils.isEmpty(adCard.buttonTextDone) && 1 != adCard.buttonStatus)) {
            this.mKl.setVisibility(8);
            this.mKl.setClickable(false);
            return;
        }
        this.mKl.setVisibility(0);
        this.mKl.setClickable(true);
        this.mKl.setText(str);
        ao.setViewTextColor(this.mKl, R.color.CAM_X0304, 1);
        ao.setBackgroundResource(this.mKl, R.drawable.ad_download_progress_button_bg);
        if (k.isEmpty(str2)) {
            this.mKl.setClickable(false);
        } else {
            this.mKl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AdCardBaseView.this.kUi != null && adCard.buttonClick != null && !v.Qq(adCard.buttonClick.scheme)) {
                        AdCardBaseView.this.kUi.a(adCard.buttonClick.mJC, adCard.buttonClick.mJD, null);
                    }
                    if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                        if (TextUtils.isEmpty(adCard.popWindowText)) {
                            int c2 = s.c(AdCardBaseView.this.eSJ, str2, (AdCardBaseView.this.mKu == null || AdCardBaseView.this.mKu.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.d(AdCardBaseView.this.mKu.getAdvertAppInfo()));
                            if ((c2 == 1 || c2 == 2) && AdCardBaseView.this.kUi != null) {
                                AdCardBaseView.this.kUi.d(c2, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.eSJ.getPageActivity());
                        aVar.Ad(adCard.popWindowText);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int c3 = s.c(AdCardBaseView.this.eSJ, str2, (AdCardBaseView.this.mKu == null || AdCardBaseView.this.mKu.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.d(AdCardBaseView.this.mKu.getAdvertAppInfo()));
                                if ((c3 == 1 || c3 == 2) && AdCardBaseView.this.kUi != null) {
                                    AdCardBaseView.this.kUi.d(c3, null);
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
                        aVar.b(AdCardBaseView.this.eSJ).bqe();
                    }
                }
            });
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        int i = (this.mMaxWidth - this.mKg) - this.mKj;
        int i2 = dBx() ? i - (this.mKh + this.mKi) : i;
        String str = null;
        if (advertAppInfo != null && advertAppInfo.blm()) {
            str = adCard.userName.concat("APP");
        } else if (advertAppInfo != null && advertAppInfo.bln()) {
            str = TextUtils.isEmpty(adCard.userName) ? "广告" : adCard.userName;
        }
        this.mKq.setText(com.baidu.tieba.recapp.lego.a.a.a(str, "广告", i2, this.mKq.getPaint()));
    }

    /* renamed from: d  reason: avoid collision after fix types in other method */
    private void d2(AdCard adCard) {
        String str = adCard.threadTitle;
        if (TextUtils.isEmpty(str)) {
            this.mKk.setVisibility(8);
            return;
        }
        this.mKk.setMaxLines(adCard.titleLines <= 0 ? 4 : adCard.titleLines);
        this.mKk.setText(str);
        this.mKk.setVisibility(0);
    }

    private void b(AdCard adCard, b bVar) {
        this.mKv.setType(TbadkCoreApplication.getInst().getCardShowType());
        if (dBx()) {
            this.mKv.setVisibility(8);
            this.mKv.setBarNameClickEnabled(false);
            this.mKv.setShareVisible(false);
            this.mKv.setShowPraiseNum(false);
            this.mKv.setCommentNumEnable(false);
            this.mKv.setReplyTimeVisible(false);
            this.mKx.setVisibility(0);
            this.mKy.setVisibility(8);
            return;
        }
        d(adCard, bVar);
    }

    private void l(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.eJr != null && advertAppInfo.eJr.adCloseInfo != null && advertAppInfo.eJr.adCloseInfo.support_close.intValue() > 0) {
            this.mKn.setVisibility(0);
            this.mKn.setPage(getBusinessType());
            this.mKn.setData(advertAppInfo);
            l.addToParentArea(this.eSJ.getPageActivity(), this.mKo, 40, 40, 40, 120);
            this.mKo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.mKn.performClick();
                }
            });
            return;
        }
        this.mKn.setVisibility(8);
        this.mKm.setOnClickListener(null);
    }

    private void ed(View view) {
        if (view != null && view.getVisibility() == 0) {
            this.mKA.setVisibility(0);
            if (view.getParent() == null || view.getParent() != this.mKA) {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                this.mKA.removeAllViews();
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                this.mKA.addView(view);
            }
        }
    }

    private void ee(View view) {
        if (view != null && view.getVisibility() == 0) {
            this.mKA.setVisibility(8);
            if (view.getParent() == null || view.getParent() != this.mKw) {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                this.mKw.addAdTagView(this.mKo);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bKR();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bKS();
    }

    private void a(AdCard adCard, DownloadData downloadData) {
        if (adCard.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.mKp.getDownloadStatus());
        }
    }

    private void c(AdCard adCard, b bVar) {
        if (adCard.directDownload) {
            this.mKp.setOnClickListener(bVar);
        } else {
            this.mKp.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public boolean ci(View view) {
                    AdCardBaseView.this.dBw();
                    return false;
                }
            });
        }
    }

    private void b(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey En;
        if (!adCard.directDownload) {
            String scheme = adCard.getScheme();
            String d2 = d(advertAppInfo);
            if (!TextUtils.isEmpty(d2)) {
                En = com.baidu.tieba.ad.download.d.bKZ().Em(d2);
            } else {
                En = com.baidu.tieba.ad.download.d.bKZ().En(scheme);
            }
            if (En == null) {
                En = DownloadCacheKey.create(d2, advertAppInfo.apkUrl, advertAppInfo.eJl);
                com.baidu.tieba.ad.download.d.bKZ().a(En, null);
            }
            i(En);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.geB = downloadCacheKey;
            bKS();
            this.geC = null;
            AdDownloadData d2 = com.baidu.tieba.ad.download.d.bKZ().d(downloadCacheKey);
            if (s.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), d2.getPkgName())) {
                d2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            }
            this.mKp.a(d2.getCurrentState());
            String str = "";
            if (this.mKu != null && this.mKu.getAdvertAppInfo() != null) {
                str = this.mKu.getAdvertAppInfo().page;
                d2.setExtInfo(this.mKu.getAdvertAppInfo().extensionInfo);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mKp, d2, str);
            this.geC = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d2.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d2);
            }
            bKR();
        }
    }

    private void bKR() {
        if (this.geB != null && this.geC != null) {
            com.baidu.tieba.ad.download.d.bKZ().a(this.geB, this.geC);
        }
    }

    private void bKS() {
        if (this.geB != null && this.geC != null) {
            com.baidu.tieba.ad.download.d.bKZ().b(this.geB, this.geC);
        }
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void d(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.mKy.setVisibility(0);
            this.mKv.setVisibility(8);
            return;
        }
        this.mKy.setVisibility(8);
        this.mKv.setVisibility(0);
        this.mKv.setBarNameClickEnabled(false);
        this.mKv.setReplyTimeVisible(false);
        this.mKv.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.mKv.setAgreeClickable(true);
            this.mKv.setPraiseContainerBgGray(false);
        } else {
            this.mKv.setAgreeClickable(false);
            this.mKv.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.mKv.setShareClickable(true);
            this.mKv.setShareContainerBgGray(false);
        } else {
            this.mKv.setShareClickable(false);
            this.mKv.setShareContainerBgGray(true);
        }
        if (this.mKv.getCommentContainer() != null) {
            this.mKv.getCommentContainer().setOnClickListener(bVar);
        }
        this.mKv.setNeedAddReplyIcon(true);
        this.mKv.setCommentNumEnable(false);
        this.mKv.setCommentClickable(true);
        this.mKv.setReplayContainerBgGray(true);
        this.mKv.setOnClickListener(bVar);
        this.mKv.setShareData(adCard);
        this.mKv.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        this.mKn.onChangeSkinType();
        this.mKw.onChangeSkinType(this.eSJ, TbadkCoreApplication.getInst().getSkinType());
        this.mKv.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            com.baidu.tbadk.core.elementsMaven.c.bv(this.mRootView).od(R.string.J_X06).aM(R.color.CAM_X0205, R.color.cp_bg_line_e_alpha50);
        }
        com.baidu.tbadk.a.b.b.h((TextView) this.mKw.getUserName());
        ao.setViewTextColor(this.mKk, R.color.CAM_X0105, 1);
        ao.setViewTextColor(this.mKq, R.color.CAM_X0109);
        ao.setViewTextColor(this.mKm, R.color.CAM_X0109, 1);
        ao.setViewTextColor(this.mKl, R.color.CAM_X0304, 1);
        ao.setBackgroundResource(this.mKl, R.drawable.ad_download_progress_button_bg);
        ao.setBackgroundColor(this.mKC, R.color.CAM_X0203);
        ao.setBackgroundColor(this.mKB, R.color.CAM_X0204);
        this.mKp.onChangeSkinType(i);
    }

    protected void a(AdCard.b bVar) {
        if (bVar != null) {
            if (b(bVar) && !v.Qq(bVar.scheme)) {
                if (this.kUi != null) {
                    this.kUi.a(bVar.mJC, bVar.mJD, null);
                }
            } else if (this.mKu != null && this.mKu.getAdvertAppInfo() != null) {
                String str = bVar.scheme;
                String d2 = d(this.mKu.getAdvertAppInfo());
                int i = 3;
                if (!this.mKu.directDownload && this.mKu.getAdvertAppInfo().blm()) {
                    if (!s.b(this.mKu.getAdvertAppInfo(), str)) {
                        i = s.c(this.eSJ, str, d2);
                    }
                } else {
                    i = s.c(this.eSJ, str, d2);
                }
                if (i == 1 || i == 2) {
                    if (this.kUi != null) {
                        this.kUi.d(i, null);
                    }
                } else if (this.kUi != null) {
                    this.kUi.a(bVar.mJC, bVar.mJD, null);
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
                        if (AdCardBaseView.this.mKu.hasAnimation()) {
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
        this.kSI = new a.C0773a();
        this.kSI.picUrl = tbImageView.getUrl();
        this.kSI.rect = rect;
    }

    private void Qy(String str) {
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
                    com.baidu.adp.lib.e.d.mx().a(jSONObject.optString("pic_url"), 17, null, this.kUp, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.kUp), this.eSJ.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.bll() != 0) {
                l.showToast(this.eSJ.getPageActivity(), R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.eSJ.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.eSJ.getPageActivity()) && this.kUj != null) {
                this.kUj.c(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(d(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.eSJ.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.blm()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.eSJ.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eSJ.getPageActivity());
                aVar.Ad(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.mKp);
                        if (AdCardBaseView.this.mKp != null) {
                            AdCardBaseView.this.mKp.q(AdCardBaseView.this.d(advertAppInfo, i));
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
                aVar.b(this.eSJ).bqe();
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
                    h.installApp(this.eSJ.getPageActivity(), advertAppInfo.eJl);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, this.mKp);
                    apkDownloadView.s(d2);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.bKZ().aO(this.eSJ.getPageActivity(), advertAppInfo.eJl);
                    return;
            }
        }
    }

    public a.C0773a getAnimationInfo() {
        return this.kSI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        private AdCard mKO;

        public b(AdCard adCard) {
            this.mKO = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdCardBaseView.this.eSJ.showToast(R.string.neterror);
            } else if (this.mKO != null && view != null && view.getId() != R.id.thread_info_commont_container) {
                AdvertAppInfo advertAppInfo = this.mKO.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.mKp;
                if (advertAppInfo != null && advertAppInfo.blm()) {
                    a(advertAppInfo, z);
                } else {
                    m(advertAppInfo);
                }
            }
        }

        private void a(AdvertAppInfo advertAppInfo, boolean z) {
            if (this.mKO.directDownload || z) {
                b(advertAppInfo, z);
            } else {
                n(advertAppInfo);
            }
        }

        private void m(AdvertAppInfo advertAppInfo) {
            String scheme = this.mKO.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.eJk;
            }
            if (this.mKO.hasAnimation()) {
            }
            int c = s.c(AdCardBaseView.this.eSJ, scheme, AdCardBaseView.this.d(advertAppInfo));
            if (AdCardBaseView.this.kUi != null) {
                AdCardBaseView.this.kUi.d(c, null);
            }
        }

        private void b(AdvertAppInfo advertAppInfo, boolean z) {
            int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
            int status = ApkDownloadView.getStatus(AdCardBaseView.this.d(advertAppInfo, i));
            if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                return;
            }
            AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.mKp, z);
            AdCardBaseView.this.dBw();
        }

        private void n(AdvertAppInfo advertAppInfo) {
            int i;
            String scheme = this.mKO.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.eJk;
            }
            if (!s.b(advertAppInfo, scheme)) {
                i = s.c(AdCardBaseView.this.eSJ, scheme, AdCardBaseView.this.d(advertAppInfo));
            } else {
                i = 3;
            }
            if (AdCardBaseView.this.kUi != null) {
                AdCardBaseView.this.kUi.d(i, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dBw() {
        if (this.kUi != null) {
            this.kUi.d(3, null);
        }
    }

    /* loaded from: classes7.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mKN;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mKN = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.mKN.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.mKt) && adCardBaseView.mKt.equals(downloadData.getId())) {
                int status = e.getStatus(downloadData);
                if (status == 7) {
                    adCardBaseView.mKl.setText(R.string.pause_load);
                } else if (status == 1 || status == 2) {
                    adCardBaseView.mKl.setText(R.string.pb_download_pause);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mKN;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mKN = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.mKN.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.mKt) && adCardBaseView.mKt.equals(downloadData.getId())) {
                adCardBaseView.mKp.t(downloadData);
            }
        }
    }

    /* loaded from: classes7.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mKN;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mKN = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.mKN.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                String str = null;
                if (adCardBaseView.mKu != null && adCardBaseView.mKu.getAdvertAppInfo() != null) {
                    str = TextUtils.isEmpty(adCardBaseView.mKu.getAdvertAppInfo().eJl) ? adCardBaseView.mKu.getAdvertAppInfo().eJi : adCardBaseView.mKu.getAdvertAppInfo().eJl;
                }
                s.c(adCardBaseView.eSJ, adCardBaseView.mKz.scheme, str);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void cZW() {
        if (dBx()) {
            this.mKk.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.mJE != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.mKz = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.eSJ.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.eSJ, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        return true;
    }

    DownloadData d(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(d(advertAppInfo));
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.eJj);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.eJi, 0));
        return downloadData;
    }

    protected boolean dBx() {
        return getBusinessType() == 4;
    }

    protected boolean e(AdCard adCard) {
        return dBx() && adCard.isPBBanner;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float Hz(@StringRes int i) {
        try {
            return Float.parseFloat(TbadkCoreApplication.getInst().getContext().getResources().getString(i).split(",")[0]);
        } catch (Exception e) {
            return 0.0f;
        }
    }
}
