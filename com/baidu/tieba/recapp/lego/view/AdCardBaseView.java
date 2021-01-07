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
/* loaded from: classes8.dex */
public abstract class AdCardBaseView extends BaseLegoCardView<AdCard> implements com.baidu.tieba.lego.card.a.a {
    private DownloadCacheKey gjj;
    private com.baidu.tieba.ad.download.a.d gjk;
    private a.C0790a kXn;
    private final int kYU;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    protected final int mOA;
    protected final int mOB;
    protected final int mOC;
    private final int mOD;
    private final int mOE;
    protected final int mOF;
    private final int mOG;
    protected final int mOH;
    protected final int mOI;
    protected final int mOJ;
    private final int mOK;
    private final int mOL;
    private final int mOM;
    private final int mON;
    protected TextView mOO;
    protected TextView mOP;
    protected TextView mOQ;
    private AdCloseView mOR;
    private LinearLayout mOS;
    protected ApkDownloadView mOT;
    protected TextView mOU;
    protected RelativeLayout mOV;
    protected View mOW;
    protected String mOX;
    private AdCard mOY;
    private AdThreadCommentAndPraiseInfoLayout mOZ;
    protected ViewStub mOw;
    protected View mOx;
    protected View mOy;
    protected final int mOz;
    protected AdThreadUserInfoLayout mPa;
    protected View mPb;
    protected View mPc;
    protected AdCard.b mPd;
    private FrameLayout mPe;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View mPf;
    private View mPg;
    protected CustomMessageListener mPh;
    protected CustomMessageListener mPi;
    protected CustomMessageListener mPj;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void ec(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kYU = l.getEquipmentWidth(getContext());
        this.gjk = null;
        this.mPh = new a(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG, this);
        this.mPi = new d(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG, this);
        this.mPj = new c(CmdConfigCustom.CMD_USER_INFO_CHANGED, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.tbds648);
        this.mImageHeight = (int) resources.getDimension(R.dimen.tbds488);
        this.mOz = (int) resources.getDimension(R.dimen.tbds92);
        this.mOA = (int) resources.getDimension(R.dimen.tbds92);
        this.mOB = (int) resources.getDimension(R.dimen.M_W_X004);
        this.mOH = (int) resources.getDimension(R.dimen.tbds90);
        this.mOI = (int) resources.getDimension(R.dimen.tbds90);
        this.mOJ = (int) resources.getDimension(R.dimen.tbds22);
        this.mOC = (int) resources.getDimension(R.dimen.M_W_X005);
        this.mOF = (int) resources.getDimension(R.dimen.M_W_X004);
        this.mOG = 0;
        this.mOD = (int) resources.getDimension(R.dimen.M_W_X007);
        this.mOE = (int) resources.getDimension(R.dimen.M_H_X005);
        this.mOK = (int) resources.getDimension(R.dimen.tbds208);
        this.mOL = (int) resources.getDimension(R.dimen.tbds33);
        this.mOM = (int) resources.getDimension(R.dimen.tbds72);
        this.mON = (int) resources.getDimension(R.dimen.tbds48);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ddI() {
        MessageManager.getInstance().registerListener(this.mPh);
        MessageManager.getInstance().registerListener(this.mPi);
        MessageManager.getInstance().registerListener(this.mPj);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.mPf = this.mRootView.findViewById(R.id.banner_top_divider);
        this.mOy = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.mOy.setClickable(true);
        this.mOO = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.mOP = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.mOT = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.mOU = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.mOV = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.mOT.x(this.eXu.getUniqueId());
        this.mPh.setTag(this.eXu.getUniqueId());
        this.mOW = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.mPi.setTag(this.eXu.getUniqueId());
        this.mPj.setTag(this.eXu.getUniqueId());
        this.mOZ = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.mOZ.setStyle(1);
        this.mPa = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        this.mPe = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        this.mOS = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mOR = (AdCloseView) this.mOS.findViewById(R.id.ad_close_view);
        ViewGroup.LayoutParams layoutParams = this.mOR.mTm.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.mOR.mTm.getLayoutParams();
        int dimens = l.getDimens(getContext(), R.dimen.tbds62);
        layoutParams2.width = dimens;
        layoutParams.height = dimens;
        this.mOQ = (TextView) this.mOS.findViewById(R.id.feed_tag);
        this.mOQ.setVisibility(8);
        this.mPa.addAdTagView(this.mOS);
        this.mOw = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.mOw.setLayoutResource(getCustomLayout());
        this.mOx = this.mOw.inflate();
        this.mPb = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.mPc = this.mRootView.findViewById(R.id.frs_bottom_view);
        this.mPg = this.mRootView.findViewById(R.id.pb_ad_bottom_divider);
        ec(this.mOx);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(AdCard adCard) {
        this.mOY = adCard;
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
                RG(adCard.getPreLoadData());
            }
            a(adCard);
            a(adCard, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void c(AdCard adCard) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mOW.getLayoutParams();
        layoutParams.topMargin = this.eXu.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
        this.mOW.setPadding(0, 0, 0, 0);
        ((RelativeLayout.LayoutParams) this.mOT.getLayoutParams()).addRule(11, -1);
        ((RelativeLayout.LayoutParams) this.mOP.getLayoutParams()).addRule(11, -1);
        this.mPe.setVisibility(8);
        this.mOV.requestLayout();
        this.mPf.setVisibility(8);
        if (dFp()) {
            this.mRootView.setPadding(this.mOD, this.mOE, this.mOD, 0);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mOW.getLayoutParams();
            this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - (this.mOG * 2)) - (this.mOD * 2)) - this.mOz) - this.mOB;
            layoutParams2.leftMargin = this.mOz + this.mOB;
            this.mPg.setVisibility(0);
            ee(this.mOS);
            if (e(adCard)) {
                this.mPg.setVisibility(8);
                this.mRootView.setPadding(0, 0, 0, 0);
                this.mOW.setPadding(this.mOD, 0, this.mOD, 0);
                layoutParams2.leftMargin = 0;
                this.mMaxWidth = (l.getEquipmentWidth(getContext()) - (this.mOD * 2)) - (this.mOG * 2);
                layoutParams.topMargin = this.eXu.getResources().getDimensionPixelOffset(R.dimen.M_H_X005);
                this.mPf.setVisibility(0);
                ao.setBackgroundColor(this.mPf, R.color.CAM_X0204);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mOT.getLayoutParams();
                layoutParams3.addRule(11, 0);
                layoutParams3.addRule(0, this.mPe.getId());
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.mOP.getLayoutParams();
                layoutParams4.addRule(11, 0);
                layoutParams4.addRule(0, this.mPe.getId());
                this.mOV.requestLayout();
                ed(this.mOS);
                return;
            }
            return;
        }
        this.mRootView.setPadding(this.mOC, this.mOE, this.mOC, 0);
        this.mMaxWidth = (l.getEquipmentWidth(getContext()) - (this.mOC * 2)) - (this.mOF * 2);
        if ((com.baidu.tieba.frs.b.cDY().cDS() || com.baidu.tieba.frs.a.cDR().cDS()) && isInFrsAllThread()) {
            this.mOy.setVisibility(0);
            ao.setBackgroundColor(this.mOy, R.color.CAM_X0201);
        } else {
            this.mOy.setVisibility(8);
        }
        this.mPg.setVisibility(8);
    }

    private void a(final AdCard adCard, final AdvertAppInfo advertAppInfo, b bVar) {
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 != null) {
            advertAppInfo2.AZ(at.dS(adCard.time));
        }
        this.mPa.setShowFlag(1413);
        this.mPa.setData(advertAppInfo2);
        ((TextView) this.mPa.getUserName()).setText(adCard.userName);
        com.baidu.tbadk.a.b.b.g((TextView) this.mPa.getUserName());
        this.mPa.getUserName().setOnClickListener(bVar);
        this.mPa.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.mPa.getUserName()).setText(adCard.userName);
            }
        });
        this.mPa.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.bzD() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.eXu.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        a(this.mPa.getHeaderImg(), adCard.portraitClick, bVar);
        if (e(adCard)) {
            this.mPa.setVisibility(8);
        }
    }

    private void b(AdCard adCard, AdvertAppInfo advertAppInfo, b bVar) {
        if (adCard == null || advertAppInfo == null) {
            this.mOV.setVisibility(8);
            return;
        }
        this.mOV.setVisibility(0);
        if (advertAppInfo.bpg()) {
            a(advertAppInfo, adCard, bVar);
            b(adCard, advertAppInfo);
        } else if (advertAppInfo.bph()) {
            a(adCard, bVar);
        }
    }

    private void a(AdvertAppInfo advertAppInfo, AdCard adCard, b bVar) {
        this.mOP.setVisibility(8);
        this.mOT.setVisibility(0);
        this.mOT.setClickable(true);
        this.mOX = advertAppInfo.eNW;
        DownloadData d2 = d(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
        if (s.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), this.mOX)) {
            d2.setStatus(8);
        } else {
            a(adCard, d2);
        }
        this.mOT.setData(d2);
        c(adCard, bVar);
    }

    private void a(final AdCard adCard, b bVar) {
        this.mOT.setVisibility(8);
        String str = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        final String str2 = bVar2 == null ? "" : bVar2.scheme;
        if (k.isEmpty(str) || (!TextUtils.isEmpty(adCard.buttonTextDone) && 1 != adCard.buttonStatus)) {
            this.mOP.setVisibility(8);
            this.mOP.setClickable(false);
            return;
        }
        this.mOP.setVisibility(0);
        this.mOP.setClickable(true);
        this.mOP.setText(str);
        ao.setViewTextColor(this.mOP, R.color.CAM_X0304, 1);
        ao.setBackgroundResource(this.mOP, R.drawable.ad_download_progress_button_bg);
        if (k.isEmpty(str2)) {
            this.mOP.setClickable(false);
        } else {
            this.mOP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AdCardBaseView.this.kYN != null && adCard.buttonClick != null && !v.Ry(adCard.buttonClick.scheme)) {
                        AdCardBaseView.this.kYN.a(adCard.buttonClick.mOg, adCard.buttonClick.mOh, null);
                    }
                    if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                        if (TextUtils.isEmpty(adCard.popWindowText)) {
                            int c2 = s.c(AdCardBaseView.this.eXu, str2, (AdCardBaseView.this.mOY == null || AdCardBaseView.this.mOY.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.d(AdCardBaseView.this.mOY.getAdvertAppInfo()));
                            if ((c2 == 1 || c2 == 2) && AdCardBaseView.this.kYN != null) {
                                AdCardBaseView.this.kYN.d(c2, null);
                                return;
                            }
                            return;
                        }
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.eXu.getPageActivity());
                        aVar.Bo(adCard.popWindowText);
                        aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                int c3 = s.c(AdCardBaseView.this.eXu, str2, (AdCardBaseView.this.mOY == null || AdCardBaseView.this.mOY.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.d(AdCardBaseView.this.mOY.getAdvertAppInfo()));
                                if ((c3 == 1 || c3 == 2) && AdCardBaseView.this.kYN != null) {
                                    AdCardBaseView.this.kYN.d(c3, null);
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
                        aVar.b(AdCardBaseView.this.eXu).btY();
                    }
                }
            });
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        int i = (this.mMaxWidth - this.mOK) - this.mON;
        int i2 = dFp() ? i - (this.mOL + this.mOM) : i;
        String str = null;
        if (advertAppInfo != null && advertAppInfo.bpg()) {
            str = adCard.userName.concat("APP");
        } else if (advertAppInfo != null && advertAppInfo.bph()) {
            str = TextUtils.isEmpty(adCard.userName) ? "广告" : adCard.userName;
        }
        this.mOU.setText(com.baidu.tieba.recapp.lego.a.a.a(str, "广告", i2, this.mOU.getPaint()));
    }

    /* renamed from: d  reason: avoid collision after fix types in other method */
    private void d2(AdCard adCard) {
        String str = adCard.threadTitle;
        if (TextUtils.isEmpty(str)) {
            this.mOO.setVisibility(8);
            return;
        }
        this.mOO.setMaxLines(adCard.titleLines <= 0 ? 4 : adCard.titleLines);
        this.mOO.setText(str);
        this.mOO.setVisibility(0);
    }

    private void b(AdCard adCard, b bVar) {
        this.mOZ.setType(TbadkCoreApplication.getInst().getCardShowType());
        if (dFp()) {
            this.mOZ.setVisibility(8);
            this.mOZ.setBarNameClickEnabled(false);
            this.mOZ.setShareVisible(false);
            this.mOZ.setShowPraiseNum(false);
            this.mOZ.setCommentNumEnable(false);
            this.mOZ.setReplyTimeVisible(false);
            this.mPb.setVisibility(0);
            this.mPc.setVisibility(8);
            return;
        }
        d(adCard, bVar);
    }

    private void l(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo != null && advertAppInfo.eOc != null && advertAppInfo.eOc.adCloseInfo != null && advertAppInfo.eOc.adCloseInfo.support_close.intValue() > 0) {
            this.mOR.setVisibility(0);
            this.mOR.setPage(getBusinessType());
            this.mOR.setData(advertAppInfo);
            l.addToParentArea(this.eXu.getPageActivity(), this.mOS, 40, 40, 40, 120);
            this.mOS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.mOR.performClick();
                }
            });
            return;
        }
        this.mOR.setVisibility(8);
        this.mOQ.setOnClickListener(null);
    }

    private void ed(View view) {
        if (view != null && view.getVisibility() == 0) {
            this.mPe.setVisibility(0);
            if (view.getParent() == null || view.getParent() != this.mPe) {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                this.mPe.removeAllViews();
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                this.mPe.addView(view);
            }
        }
    }

    private void ee(View view) {
        if (view != null && view.getVisibility() == 0) {
            this.mPe.setVisibility(8);
            if (view.getParent() == null || view.getParent() != this.mPa) {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                this.mPa.addAdTagView(this.mOS);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bOJ();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bOK();
    }

    private void a(AdCard adCard, DownloadData downloadData) {
        if (adCard.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.mOT.getDownloadStatus());
        }
    }

    private void c(AdCard adCard, b bVar) {
        if (adCard.directDownload) {
            this.mOT.setOnClickListener(bVar);
        } else {
            this.mOT.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public boolean ci(View view) {
                    AdCardBaseView.this.dFo();
                    return false;
                }
            });
        }
    }

    private void b(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey Fy;
        if (!adCard.directDownload) {
            String scheme = adCard.getScheme();
            String d2 = d(advertAppInfo);
            if (!TextUtils.isEmpty(d2)) {
                Fy = com.baidu.tieba.ad.download.d.bOR().Fx(d2);
            } else {
                Fy = com.baidu.tieba.ad.download.d.bOR().Fy(scheme);
            }
            if (Fy == null) {
                Fy = DownloadCacheKey.create(d2, advertAppInfo.apkUrl, advertAppInfo.eNW);
                com.baidu.tieba.ad.download.d.bOR().a(Fy, null);
            }
            i(Fy);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.gjj = downloadCacheKey;
            bOK();
            this.gjk = null;
            AdDownloadData d2 = com.baidu.tieba.ad.download.d.bOR().d(downloadCacheKey);
            if (s.isInstalledPackage(TbadkCoreApplication.getInst().getContext(), d2.getPkgName())) {
                d2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            }
            this.mOT.a(d2.getCurrentState());
            String str = "";
            if (this.mOY != null && this.mOY.getAdvertAppInfo() != null) {
                str = this.mOY.getAdvertAppInfo().page;
                d2.setExtInfo(this.mOY.getAdvertAppInfo().extensionInfo);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mOT, d2, str);
            this.gjk = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d2.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d2);
            }
            bOJ();
        }
    }

    private void bOJ() {
        if (this.gjj != null && this.gjk != null) {
            com.baidu.tieba.ad.download.d.bOR().a(this.gjj, this.gjk);
        }
    }

    private void bOK() {
        if (this.gjj != null && this.gjk != null) {
            com.baidu.tieba.ad.download.d.bOR().b(this.gjj, this.gjk);
        }
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void d(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.mPc.setVisibility(0);
            this.mOZ.setVisibility(8);
            return;
        }
        this.mPc.setVisibility(8);
        this.mOZ.setVisibility(0);
        this.mOZ.setBarNameClickEnabled(false);
        this.mOZ.setReplyTimeVisible(false);
        this.mOZ.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.mOZ.setAgreeClickable(true);
            this.mOZ.setPraiseContainerBgGray(false);
        } else {
            this.mOZ.setAgreeClickable(false);
            this.mOZ.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.mOZ.setShareClickable(true);
            this.mOZ.setShareContainerBgGray(false);
        } else {
            this.mOZ.setShareClickable(false);
            this.mOZ.setShareContainerBgGray(true);
        }
        if (this.mOZ.getCommentContainer() != null) {
            this.mOZ.getCommentContainer().setOnClickListener(bVar);
        }
        this.mOZ.setNeedAddReplyIcon(true);
        this.mOZ.setCommentNumEnable(false);
        this.mOZ.setCommentClickable(true);
        this.mOZ.setReplayContainerBgGray(true);
        this.mOZ.setOnClickListener(bVar);
        this.mOZ.setShareData(adCard);
        this.mOZ.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        this.mOR.onChangeSkinType();
        this.mPa.onChangeSkinType(this.eXu, TbadkCoreApplication.getInst().getSkinType());
        this.mOZ.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            com.baidu.tbadk.core.elementsMaven.c.bv(this.mRootView).pK(R.string.J_X06).aM(R.color.CAM_X0205, R.color.cp_bg_line_e_alpha50);
        }
        com.baidu.tbadk.a.b.b.h((TextView) this.mPa.getUserName());
        ao.setViewTextColor(this.mOO, R.color.CAM_X0105, 1);
        ao.setViewTextColor(this.mOU, R.color.CAM_X0109);
        ao.setViewTextColor(this.mOQ, R.color.CAM_X0109, 1);
        ao.setViewTextColor(this.mOP, R.color.CAM_X0304, 1);
        ao.setBackgroundResource(this.mOP, R.drawable.ad_download_progress_button_bg);
        ao.setBackgroundColor(this.mPg, R.color.CAM_X0203);
        ao.setBackgroundColor(this.mPf, R.color.CAM_X0204);
        this.mOT.onChangeSkinType(i);
    }

    protected void a(AdCard.b bVar) {
        if (bVar != null) {
            if (b(bVar) && !v.Ry(bVar.scheme)) {
                if (this.kYN != null) {
                    this.kYN.a(bVar.mOg, bVar.mOh, null);
                }
            } else if (this.mOY != null && this.mOY.getAdvertAppInfo() != null) {
                String str = bVar.scheme;
                String d2 = d(this.mOY.getAdvertAppInfo());
                int i = 3;
                if (!this.mOY.directDownload && this.mOY.getAdvertAppInfo().bpg()) {
                    if (!s.b(this.mOY.getAdvertAppInfo(), str)) {
                        i = s.c(this.eXu, str, d2);
                    }
                } else {
                    i = s.c(this.eXu, str, d2);
                }
                if (i == 1 || i == 2) {
                    if (this.kYN != null) {
                        this.kYN.d(i, null);
                    }
                } else if (this.kYN != null) {
                    this.kYN.a(bVar.mOg, bVar.mOh, null);
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
                        if (AdCardBaseView.this.mOY.hasAnimation()) {
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
        this.kXn = new a.C0790a();
        this.kXn.picUrl = tbImageView.getUrl();
        this.kXn.rect = rect;
    }

    private void RG(String str) {
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
                    com.baidu.adp.lib.e.d.mx().a(jSONObject.optString("pic_url"), 17, null, this.kYU, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.kYU), this.eXu.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.bpf() != 0) {
                l.showToast(this.eXu.getPageActivity(), R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.eXu.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.eXu.getPageActivity()) && this.kYO != null) {
                this.kYO.c(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(d(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.eXu.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bpg()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.eXu.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eXu.getPageActivity());
                aVar.Bo(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.mOT);
                        if (AdCardBaseView.this.mOT != null) {
                            AdCardBaseView.this.mOT.q(AdCardBaseView.this.d(advertAppInfo, i));
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
                aVar.b(this.eXu).btY();
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
                    h.installApp(this.eXu.getPageActivity(), advertAppInfo.eNW);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, this.mOT);
                    apkDownloadView.s(d2);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.bOR().aO(this.eXu.getPageActivity(), advertAppInfo.eNW);
                    return;
            }
        }
    }

    public a.C0790a getAnimationInfo() {
        return this.kXn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        private AdCard mPu;

        public b(AdCard adCard) {
            this.mPu = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdCardBaseView.this.eXu.showToast(R.string.neterror);
            } else if (this.mPu != null && view != null && view.getId() != R.id.thread_info_commont_container) {
                AdvertAppInfo advertAppInfo = this.mPu.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.mOT;
                if (advertAppInfo != null && advertAppInfo.bpg()) {
                    a(advertAppInfo, z);
                } else {
                    m(advertAppInfo);
                }
            }
        }

        private void a(AdvertAppInfo advertAppInfo, boolean z) {
            if (this.mPu.directDownload || z) {
                b(advertAppInfo, z);
            } else {
                n(advertAppInfo);
            }
        }

        private void m(AdvertAppInfo advertAppInfo) {
            String scheme = this.mPu.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.eNV;
            }
            if (this.mPu.hasAnimation()) {
            }
            int c = s.c(AdCardBaseView.this.eXu, scheme, AdCardBaseView.this.d(advertAppInfo));
            if (AdCardBaseView.this.kYN != null) {
                AdCardBaseView.this.kYN.d(c, null);
            }
        }

        private void b(AdvertAppInfo advertAppInfo, boolean z) {
            int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
            int status = ApkDownloadView.getStatus(AdCardBaseView.this.d(advertAppInfo, i));
            if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                return;
            }
            AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.mOT, z);
            AdCardBaseView.this.dFo();
        }

        private void n(AdvertAppInfo advertAppInfo) {
            int i;
            String scheme = this.mPu.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.eNV;
            }
            if (!s.b(advertAppInfo, scheme)) {
                i = s.c(AdCardBaseView.this.eXu, scheme, AdCardBaseView.this.d(advertAppInfo));
            } else {
                i = 3;
            }
            if (AdCardBaseView.this.kYN != null) {
                AdCardBaseView.this.kYN.d(i, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dFo() {
        if (this.kYN != null) {
            this.kYN.d(3, null);
        }
    }

    /* loaded from: classes8.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mPt;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mPt = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.mPt.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.mOX) && adCardBaseView.mOX.equals(downloadData.getId())) {
                int status = e.getStatus(downloadData);
                if (status == 7) {
                    adCardBaseView.mOP.setText(R.string.pause_load);
                } else if (status == 1 || status == 2) {
                    adCardBaseView.mOP.setText(R.string.pb_download_pause);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mPt;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mPt = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.mPt.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.mOX) && adCardBaseView.mOX.equals(downloadData.getId())) {
                adCardBaseView.mOT.t(downloadData);
            }
        }
    }

    /* loaded from: classes8.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mPt;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mPt = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.mPt.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                String str = null;
                if (adCardBaseView.mOY != null && adCardBaseView.mOY.getAdvertAppInfo() != null) {
                    str = TextUtils.isEmpty(adCardBaseView.mOY.getAdvertAppInfo().eNW) ? adCardBaseView.mOY.getAdvertAppInfo().eNT : adCardBaseView.mOY.getAdvertAppInfo().eNW;
                }
                s.c(adCardBaseView.eXu, adCardBaseView.mPd.scheme, str);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void ddO() {
        if (dFp()) {
            this.mOO.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.mOi != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.mPd = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.eXu.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.eXu, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        return true;
    }

    DownloadData d(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(d(advertAppInfo));
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.eNU);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.eNT, 0));
        return downloadData;
    }

    protected boolean dFp() {
        return getBusinessType() == 4;
    }

    protected boolean e(AdCard adCard) {
        return dFp() && adCard.isPBBanner;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float Jg(@StringRes int i) {
        try {
            return Float.parseFloat(TbadkCoreApplication.getInst().getContext().getResources().getString(i).split(",")[0]);
        } catch (Exception e) {
            return 0.0f;
        }
    }
}
