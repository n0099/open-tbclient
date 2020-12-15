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
    private DownloadCacheKey fZU;
    private com.baidu.tieba.ad.download.a.d fZV;
    private a.C0795a kRJ;
    private final int kTq;
    protected final int mImageHeight;
    protected final int mImageWidth;
    private final int mJA;
    protected final int mJB;
    protected final int mJC;
    protected final int mJD;
    private final int mJE;
    private final int mJF;
    private final int mJG;
    private final int mJH;
    protected TextView mJI;
    protected TextView mJJ;
    protected TextView mJK;
    private AdCloseView mJL;
    private LinearLayout mJM;
    protected ApkDownloadView mJN;
    protected TextView mJO;
    protected RelativeLayout mJP;
    protected View mJQ;
    protected String mJR;
    private AdCard mJS;
    private AdThreadCommentAndPraiseInfoLayout mJT;
    protected AdThreadUserInfoLayout mJU;
    protected View mJV;
    protected View mJW;
    protected AdCard.b mJX;
    private FrameLayout mJY;
    private View mJZ;
    protected ViewStub mJq;
    protected View mJr;
    protected View mJs;
    protected final int mJt;
    protected final int mJu;
    protected final int mJv;
    protected final int mJw;
    private final int mJx;
    private final int mJy;
    protected final int mJz;
    private View mKa;
    protected CustomMessageListener mKb;
    protected CustomMessageListener mKc;
    protected CustomMessageListener mKd;
    protected int mMaxWidth;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void dS(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kTq = l.getEquipmentWidth(getContext());
        this.fZV = null;
        this.mKb = new a(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG, this);
        this.mKc = new d(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG, this);
        this.mKd = new c(CmdConfigCustom.CMD_USER_INFO_CHANGED, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.tbds648);
        this.mImageHeight = (int) resources.getDimension(R.dimen.tbds488);
        this.mJt = (int) resources.getDimension(R.dimen.tbds92);
        this.mJu = (int) resources.getDimension(R.dimen.tbds92);
        this.mJv = (int) resources.getDimension(R.dimen.M_W_X004);
        this.mJB = (int) resources.getDimension(R.dimen.tbds90);
        this.mJC = (int) resources.getDimension(R.dimen.tbds90);
        this.mJD = (int) resources.getDimension(R.dimen.tbds22);
        if (com.baidu.tbadk.a.d.bkA()) {
            this.mJw = (int) resources.getDimension(R.dimen.M_W_X007);
            this.mJz = 0;
        } else {
            this.mJw = (int) resources.getDimension(R.dimen.M_W_X005);
            this.mJz = (int) resources.getDimension(R.dimen.M_W_X004);
        }
        this.mJA = 0;
        this.mJx = (int) resources.getDimension(R.dimen.M_W_X007);
        this.mJy = (int) resources.getDimension(R.dimen.M_H_X005);
        this.mJE = (int) resources.getDimension(R.dimen.tbds208);
        this.mJF = (int) resources.getDimension(R.dimen.tbds33);
        this.mJG = (int) resources.getDimension(R.dimen.tbds72);
        this.mJH = (int) resources.getDimension(R.dimen.tbds48);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ddW() {
        MessageManager.getInstance().registerListener(this.mKb);
        MessageManager.getInstance().registerListener(this.mKc);
        MessageManager.getInstance().registerListener(this.mKd);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.mJZ = this.mRootView.findViewById(R.id.banner_top_divider);
        this.mJs = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.mJs.setClickable(true);
        this.mJI = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.mJJ = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.mJN = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.mJO = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.mJP = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.mJN.x(this.eNx.getUniqueId());
        this.mKb.setTag(this.eNx.getUniqueId());
        this.mJQ = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.mKc.setTag(this.eNx.getUniqueId());
        this.mKd.setTag(this.eNx.getUniqueId());
        this.mJT = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.mJT.setStyle(1);
        this.mJU = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        this.mJY = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        this.mJM = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mJL = (AdCloseView) this.mJM.findViewById(R.id.ad_close_view);
        ViewGroup.LayoutParams layoutParams = this.mJL.mOc.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.mJL.mOc.getLayoutParams();
        int dimens = l.getDimens(getContext(), R.dimen.tbds62);
        layoutParams2.width = dimens;
        layoutParams.height = dimens;
        this.mJK = (TextView) this.mJM.findViewById(R.id.feed_tag);
        this.mJK.setVisibility(8);
        this.mJU.addAdTagView(this.mJM);
        this.mJq = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.mJq.setLayoutResource(getCustomLayout());
        this.mJr = this.mJq.inflate();
        this.mJV = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.mJW = this.mRootView.findViewById(R.id.frs_bottom_view);
        this.mKa = this.mRootView.findViewById(R.id.pb_ad_bottom_divider);
        dS(this.mJr);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(AdCard adCard) {
        this.mJS = adCard;
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mJQ.getLayoutParams();
        layoutParams.topMargin = this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        this.mJQ.setPadding(0, 0, 0, 0);
        ((RelativeLayout.LayoutParams) this.mJN.getLayoutParams()).addRule(11, -1);
        ((RelativeLayout.LayoutParams) this.mJJ.getLayoutParams()).addRule(11, -1);
        this.mJY.setVisibility(8);
        this.mJP.requestLayout();
        this.mJZ.setVisibility(8);
        if (dFz()) {
            this.mRootView.setPadding(this.mJx, this.mJy, this.mJx, 0);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mJQ.getLayoutParams();
            this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - (this.mJA * 2)) - (this.mJx * 2)) - this.mJt) - this.mJv;
            layoutParams2.leftMargin = this.mJt + this.mJv;
            this.mKa.setVisibility(0);
            dU(this.mJM);
            if (e(adCard)) {
                this.mKa.setVisibility(8);
                this.mRootView.setPadding(0, 0, 0, 0);
                this.mJQ.setPadding(this.mJx, 0, this.mJx, 0);
                layoutParams2.leftMargin = 0;
                this.mMaxWidth = (l.getEquipmentWidth(getContext()) - (this.mJx * 2)) - (this.mJA * 2);
                layoutParams.topMargin = this.eNx.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
                this.mJZ.setVisibility(0);
                ap.setBackgroundColor(this.mJZ, R.color.CAM_X0204);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mJN.getLayoutParams();
                layoutParams3.addRule(11, 0);
                layoutParams3.addRule(0, this.mJY.getId());
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mJJ.getLayoutParams();
                layoutParams4.addRule(11, 0);
                layoutParams4.addRule(0, this.mJY.getId());
                this.mJP.requestLayout();
                dT(this.mJM);
                return;
            }
            return;
        }
        this.mRootView.setPadding(this.mJw, this.mJy, this.mJw, 0);
        this.mMaxWidth = (l.getEquipmentWidth(getContext()) - (this.mJw * 2)) - (this.mJz * 2);
        if ((com.baidu.tieba.frs.b.cBe().cAY() || com.baidu.tieba.frs.a.cAX().cAY()) && isInFrsAllThread()) {
            this.mJs.setVisibility(0);
            ap.setBackgroundColor(this.mJs, R.color.CAM_X0201);
        } else {
            this.mJs.setVisibility(8);
        }
        this.mKa.setVisibility(8);
    }

    private void a(final AdCard adCard, final AdvertAppInfo advertAppInfo, b bVar) {
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 != null) {
            advertAppInfo2.Bb(au.dS(adCard.time));
        }
        this.mJU.setShowFlag(1413);
        this.mJU.setData(advertAppInfo2);
        ((TextView) this.mJU.getUserName()).setText(adCard.userName);
        com.baidu.tbadk.a.b.a.e((TextView) this.mJU.getUserName());
        this.mJU.getUserName().setOnClickListener(bVar);
        this.mJU.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.mJU.getUserName()).setText(adCard.userName);
            }
        });
        this.mJU.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
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
        a(this.mJU.getHeaderImg(), adCard.portraitClick, bVar);
        if (e(adCard)) {
            this.mJU.setVisibility(8);
        }
    }

    private void b(AdCard adCard, AdvertAppInfo advertAppInfo, b bVar) {
        if (adCard == null || advertAppInfo == null) {
            this.mJP.setVisibility(8);
            return;
        }
        this.mJP.setVisibility(0);
        if (advertAppInfo.bmE()) {
            a(advertAppInfo, adCard, bVar);
            b(adCard, advertAppInfo);
        } else if (advertAppInfo.bmF()) {
            a(adCard, bVar);
        }
    }

    private void a(AdvertAppInfo advertAppInfo, AdCard adCard, b bVar) {
        this.mJJ.setVisibility(8);
        this.mJN.setVisibility(0);
        this.mJN.setClickable(true);
        this.mJR = advertAppInfo.eEg;
        DownloadData d2 = d(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
        a(adCard, d2);
        this.mJN.setData(d2);
        c(adCard, bVar);
    }

    private void a(final AdCard adCard, b bVar) {
        this.mJN.setVisibility(8);
        String str = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        final String str2 = bVar2 == null ? "" : bVar2.scheme;
        if (k.isEmpty(str) || (!TextUtils.isEmpty(adCard.buttonTextDone) && 1 != adCard.buttonStatus)) {
            this.mJJ.setVisibility(8);
            this.mJJ.setClickable(false);
            return;
        }
        this.mJJ.setVisibility(0);
        this.mJJ.setClickable(true);
        this.mJJ.setText(str);
        ap.setViewTextColor(this.mJJ, R.color.CAM_X0304, 1);
        ap.setBackgroundResource(this.mJJ, R.drawable.ad_download_progress_button_bg);
        if (k.isEmpty(str2)) {
            this.mJJ.setClickable(false);
        } else {
            this.mJJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AdCardBaseView.this.kTj != null && adCard.buttonClick != null && !v.RT(adCard.buttonClick.scheme)) {
                        AdCardBaseView.this.kTj.a(adCard.buttonClick.mIZ, adCard.buttonClick.mJa, null);
                    }
                    if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                        if (TextUtils.isEmpty(adCard.popWindowText)) {
                            int c2 = s.c(AdCardBaseView.this.eNx, str2, (AdCardBaseView.this.mJS == null || AdCardBaseView.this.mJS.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.d(AdCardBaseView.this.mJS.getAdvertAppInfo()));
                            if ((c2 == 1 || c2 == 2) && AdCardBaseView.this.kTj != null) {
                                AdCardBaseView.this.kTj.d(c2, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.eNx.getPageActivity());
                        aVar.Bq(adCard.popWindowText);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int c3 = s.c(AdCardBaseView.this.eNx, str2, (AdCardBaseView.this.mJS == null || AdCardBaseView.this.mJS.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.d(AdCardBaseView.this.mJS.getAdvertAppInfo()));
                                if ((c3 == 1 || c3 == 2) && AdCardBaseView.this.kTj != null) {
                                    AdCardBaseView.this.kTj.d(c3, null);
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
        int i = (this.mMaxWidth - this.mJE) - this.mJH;
        int i2 = dFz() ? i - (this.mJF + this.mJG) : i;
        String str = null;
        if (advertAppInfo != null && advertAppInfo.bmE()) {
            str = adCard.userName.concat("APP");
        } else if (advertAppInfo != null && advertAppInfo.bmF()) {
            str = TextUtils.isEmpty(adCard.userName) ? "广告" : adCard.userName;
        }
        this.mJO.setText(com.baidu.tieba.recapp.lego.a.a.a(str, "广告", i2, this.mJO.getPaint()));
    }

    /* renamed from: d  reason: avoid collision after fix types in other method */
    private void d2(AdCard adCard) {
        String str = adCard.threadTitle;
        if (TextUtils.isEmpty(str)) {
            this.mJI.setVisibility(8);
            return;
        }
        this.mJI.setMaxLines(adCard.titleLines <= 0 ? 4 : adCard.titleLines);
        this.mJI.setText(str);
        this.mJI.setVisibility(0);
    }

    private void b(AdCard adCard, b bVar) {
        this.mJT.setType(TbadkCoreApplication.getInst().getCardShowType());
        if (dFz()) {
            this.mJT.setVisibility(8);
            this.mJT.setBarNameClickEnabled(false);
            this.mJT.setShareVisible(false);
            this.mJT.setShowPraiseNum(false);
            this.mJT.setCommentNumEnable(false);
            this.mJT.setReplyTimeVisible(false);
            this.mJV.setVisibility(0);
            this.mJW.setVisibility(8);
            return;
        }
        d(adCard, bVar);
    }

    private void k(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.eEm != null && advertAppInfo.eEm.adCloseInfo != null && advertAppInfo.eEm.adCloseInfo.support_close.intValue() > 0) {
            this.mJL.setVisibility(0);
            this.mJL.setPage(getBusinessType());
            this.mJL.setData(advertAppInfo);
            l.addToParentArea(this.eNx.getPageActivity(), this.mJM, 40, 40, 40, 120);
            this.mJM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.mJL.performClick();
                }
            });
            return;
        }
        this.mJL.setVisibility(8);
        this.mJK.setOnClickListener(null);
    }

    private void dT(View view) {
        if (view != null && view.getVisibility() == 0) {
            this.mJY.setVisibility(0);
            if (view.getParent() == null || view.getParent() != this.mJY) {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                this.mJY.removeAllViews();
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                this.mJY.addView(view);
            }
        }
    }

    private void dU(View view) {
        if (view != null && view.getVisibility() == 0) {
            this.mJY.setVisibility(8);
            if (view.getParent() == null || view.getParent() != this.mJU) {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                this.mJU.addAdTagView(this.mJM);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bMr();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bMs();
    }

    private void a(AdCard adCard, DownloadData downloadData) {
        if (adCard.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.mJN.getDownloadStatus());
        }
    }

    private void c(AdCard adCard, b bVar) {
        if (adCard.directDownload) {
            this.mJN.setOnClickListener(bVar);
        } else {
            this.mJN.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public boolean bZ(View view) {
                    AdCardBaseView.this.dFy();
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
                FB = com.baidu.tieba.ad.download.d.bMy().FA(d2);
            } else {
                FB = com.baidu.tieba.ad.download.d.bMy().FB(scheme);
            }
            if (FB == null) {
                FB = DownloadCacheKey.create(d2, advertAppInfo.apkUrl, advertAppInfo.eEg);
                com.baidu.tieba.ad.download.d.bMy().a(FB, null);
            }
            i(FB);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.fZU = downloadCacheKey;
            bMs();
            this.fZV = null;
            AdDownloadData d2 = com.baidu.tieba.ad.download.d.bMy().d(downloadCacheKey);
            if (d2 != null) {
                this.mJN.a(d2.getCurrentState());
            } else {
                this.mJN.a(DownloadStatus.STATUS_NONE);
            }
            String str = "";
            if (this.mJS != null && this.mJS.getAdvertAppInfo() != null) {
                str = this.mJS.getAdvertAppInfo().page;
                d2.setExtInfo(this.mJS.getAdvertAppInfo().extensionInfo);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mJN, d2, str);
            this.fZV = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d2.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d2);
            }
            bMr();
        }
    }

    private void bMr() {
        if (this.fZU != null && this.fZV != null) {
            com.baidu.tieba.ad.download.d.bMy().a(this.fZU, this.fZV);
        }
    }

    private void bMs() {
        if (this.fZU != null && this.fZV != null) {
            com.baidu.tieba.ad.download.d.bMy().b(this.fZU, this.fZV);
        }
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void d(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.mJW.setVisibility(0);
            this.mJT.setVisibility(8);
            return;
        }
        this.mJW.setVisibility(8);
        this.mJT.setVisibility(0);
        this.mJT.setBarNameClickEnabled(false);
        this.mJT.setReplyTimeVisible(false);
        this.mJT.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.mJT.setAgreeClickable(true);
            this.mJT.setPraiseContainerBgGray(false);
        } else {
            this.mJT.setAgreeClickable(false);
            this.mJT.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.mJT.setShareClickable(true);
            this.mJT.setShareContainerBgGray(false);
        } else {
            this.mJT.setShareClickable(false);
            this.mJT.setShareContainerBgGray(true);
        }
        if (this.mJT.getCommentContainer() != null) {
            this.mJT.getCommentContainer().setOnClickListener(bVar);
        }
        this.mJT.setNeedAddReplyIcon(true);
        this.mJT.setCommentNumEnable(false);
        this.mJT.setCommentClickable(true);
        this.mJT.setReplayContainerBgGray(true);
        this.mJT.setOnClickListener(bVar);
        this.mJT.setShareData(adCard);
        this.mJT.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        this.mJL.onChangeSkinType();
        this.mJU.onChangeSkinType(this.eNx, TbadkCoreApplication.getInst().getSkinType());
        this.mJT.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            com.baidu.tbadk.core.elementsMaven.c.bm(this.mRootView).pA(com.baidu.tbadk.a.d.bkA() ? R.string.J_X02 : R.string.J_X06).aP(R.color.CAM_X0205, R.color.cp_bg_line_e_alpha50);
        }
        com.baidu.tbadk.a.b.a.f((TextView) this.mJU.getUserName());
        ap.setViewTextColor(this.mJI, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.mJO, R.color.CAM_X0109);
        ap.setViewTextColor(this.mJK, R.color.CAM_X0109, 1);
        ap.setViewTextColor(this.mJJ, R.color.CAM_X0304, 1);
        ap.setBackgroundResource(this.mJJ, R.drawable.ad_download_progress_button_bg);
        ap.setBackgroundColor(this.mKa, R.color.CAM_X0203);
        ap.setBackgroundColor(this.mJZ, R.color.CAM_X0204);
        this.mJN.onChangeSkinType(i);
    }

    protected void a(AdCard.b bVar) {
        int c2;
        if (bVar != null) {
            if (b(bVar) && !v.RT(bVar.scheme)) {
                if (this.kTj != null) {
                    this.kTj.a(bVar.mIZ, bVar.mJa, null);
                }
            } else if (this.mJS != null && this.mJS.getAdvertAppInfo() != null) {
                String Sc = Sc(bVar.scheme);
                String d2 = d(this.mJS.getAdvertAppInfo());
                if (!this.mJS.directDownload && this.mJS.getAdvertAppInfo().bmE()) {
                    c2 = s.d(this.eNx, Sc, d2);
                } else {
                    c2 = s.c(this.eNx, Sc, d2);
                }
                if (c2 == 1 || c2 == 2) {
                    if (this.kTj != null) {
                        this.kTj.d(c2, null);
                    }
                } else if (this.kTj != null) {
                    this.kTj.a(bVar.mIZ, bVar.mJa, null);
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
                        if (AdCardBaseView.this.mJS.hasAnimation()) {
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
        this.kRJ = new a.C0795a();
        this.kRJ.picUrl = tbImageView.getUrl();
        this.kRJ.bHi = rect;
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
                    com.baidu.adp.lib.e.c.mS().a(jSONObject.optString("pic_url"), 17, null, this.kTq, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.kTq), this.eNx.getUniqueId(), new Object[0]);
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
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.eNx.getPageActivity()) && this.kTk != null) {
                this.kTk.c(advertAppInfo, i);
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
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.mJN);
                        if (AdCardBaseView.this.mJN != null) {
                            AdCardBaseView.this.mJN.q(AdCardBaseView.this.d(advertAppInfo, i));
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
                    a(advertAppInfo, i, this.mJN);
                    apkDownloadView.s(d2);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.bMy().aG(this.eNx.getPageActivity(), advertAppInfo.eEg);
                    return;
            }
        }
    }

    public a.C0795a getAnimationInfo() {
        return this.kRJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public class b implements View.OnClickListener {
        private AdCard mKm;

        public b(AdCard adCard) {
            this.mKm = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdCardBaseView.this.eNx.showToast(R.string.neterror);
            } else if (this.mKm != null && view != null && view.getId() != R.id.thread_info_commont_container) {
                AdvertAppInfo advertAppInfo = this.mKm.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.mJN;
                if (advertAppInfo != null && advertAppInfo.bmE()) {
                    a(advertAppInfo, z);
                } else {
                    l(advertAppInfo);
                }
            }
        }

        private void a(AdvertAppInfo advertAppInfo, boolean z) {
            if (this.mKm.directDownload || z) {
                b(advertAppInfo, z);
            } else {
                m(advertAppInfo);
            }
        }

        private void l(AdvertAppInfo advertAppInfo) {
            String scheme = this.mKm.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.eEf;
            }
            if (this.mKm.hasAnimation()) {
            }
            int c = s.c(AdCardBaseView.this.eNx, AdCardBaseView.this.Sc(scheme), AdCardBaseView.this.d(advertAppInfo));
            if (AdCardBaseView.this.kTj != null) {
                AdCardBaseView.this.kTj.d(c, null);
            }
        }

        private void b(AdvertAppInfo advertAppInfo, boolean z) {
            int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
            int status = ApkDownloadView.getStatus(AdCardBaseView.this.d(advertAppInfo, i));
            if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                return;
            }
            AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.mJN, z);
            AdCardBaseView.this.dFy();
        }

        private void m(AdvertAppInfo advertAppInfo) {
            String scheme = this.mKm.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.eEf;
            }
            int d = s.d(AdCardBaseView.this.eNx, scheme, AdCardBaseView.this.d(advertAppInfo));
            if (AdCardBaseView.this.kTj != null) {
                AdCardBaseView.this.kTj.d(d, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dFy() {
        if (this.kTj != null) {
            this.kTj.d(3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Sc(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.kRJ != null && this.kRJ.isValid()) {
            String c0795a = this.kRJ.toString();
            if (!TextUtils.isEmpty(c0795a)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append("=");
                sb.append(URLEncoder.encode(c0795a));
            }
        }
        if (!TextUtils.isEmpty(this.mJS.getPreLoadData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append("=");
            sb.append(URLEncoder.encode(this.mJS.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.mJS.getNextPageData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append("=");
            sb.append(URLEncoder.encode(this.mJS.getNextPageData()));
        }
        if (this.mJS.hasAnimation()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append("=");
            sb.append("1");
        }
        if (this.mJS.isGoLandingPage()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append("=");
            sb.append("1");
        }
        if (this.mJS.isImmersiveStyle()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append("=");
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes26.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mKl;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mKl = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.mKl.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.mJR) && adCardBaseView.mJR.equals(downloadData.getId())) {
                int status = e.getStatus(downloadData);
                if (status == 7) {
                    adCardBaseView.mJJ.setText(R.string.pause_load);
                } else if (status == 1 || status == 2) {
                    adCardBaseView.mJJ.setText(R.string.pb_download_pause);
                }
            }
        }
    }

    /* loaded from: classes26.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mKl;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mKl = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.mKl.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.mJR) && adCardBaseView.mJR.equals(downloadData.getId())) {
                adCardBaseView.mJN.t(downloadData);
            }
        }
    }

    /* loaded from: classes26.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mKl;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mKl = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.mKl.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                String str = null;
                if (adCardBaseView.mJS != null && adCardBaseView.mJS.getAdvertAppInfo() != null) {
                    str = TextUtils.isEmpty(adCardBaseView.mJS.getAdvertAppInfo().eEg) ? adCardBaseView.mJS.getAdvertAppInfo().eEd : adCardBaseView.mJS.getAdvertAppInfo().eEg;
                }
                s.c(adCardBaseView.eNx, adCardBaseView.mJX.scheme, str);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void dec() {
        if (dFz()) {
            this.mJI.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.mJb != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.mJX = bVar;
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

    protected boolean dFz() {
        return getBusinessType() == 4;
    }

    protected boolean e(AdCard adCard) {
        return dFz() && adCard.isPBBanner;
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
