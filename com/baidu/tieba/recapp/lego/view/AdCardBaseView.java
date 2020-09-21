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
/* loaded from: classes25.dex */
public abstract class AdCardBaseView extends BaseLegoCardView<AdCard> implements com.baidu.tieba.lego.card.b.a {
    private DownloadCacheKey frG;
    private com.baidu.tieba.ad.download.a.d frH;
    protected View hqQ;
    protected View hrn;
    private View iGj;
    private AdCard jPJ;
    protected TextView jPN;
    protected TextView jPP;
    private a.C0728a jWt;
    private final int jYa;
    protected ViewStub lMY;
    protected View lMZ;
    protected View lNA;
    protected View lNB;
    protected AdCard.b lNC;
    private FrameLayout lND;
    protected CustomMessageListener lNE;
    protected CustomMessageListener lNF;
    protected CustomMessageListener lNG;
    protected View lNa;
    protected final int lNb;
    protected final int lNc;
    protected final int lNd;
    protected final int lNe;
    protected final int lNf;
    protected final int lNg;
    protected final int lNh;
    protected final int lNi;
    private final int lNj;
    private final int lNk;
    private final int lNl;
    private final int lNm;
    private int lNn;
    private int lNo;
    private int lNp;
    protected TextView lNq;
    private AdCloseView lNr;
    private LinearLayout lNs;
    protected ApkDownloadView lNt;
    protected TextView lNu;
    protected RelativeLayout lNv;
    protected View lNw;
    protected String lNx;
    private AdThreadCommentAndPraiseInfoLayout lNy;
    protected AdThreadUserInfoLayout lNz;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void dq(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.jYa = l.getEquipmentWidth(getContext());
        this.frH = null;
        this.lNE = new a(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG, this);
        this.lNF = new d(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG, this);
        this.lNG = new c(CmdConfigCustom.CMD_USER_INFO_CHANGED, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.ds640);
        this.mImageHeight = (int) resources.getDimension(R.dimen.ds278);
        this.lNb = (int) resources.getDimension(R.dimen.tbds92);
        this.lNc = (int) resources.getDimension(R.dimen.tbds92);
        this.lNd = (int) resources.getDimension(R.dimen.tbds20);
        this.lNg = (int) resources.getDimension(R.dimen.tbds90);
        this.lNh = (int) resources.getDimension(R.dimen.tbds90);
        this.lNi = (int) resources.getDimension(R.dimen.tbds22);
        this.lNe = (int) resources.getDimension(R.dimen.tbds44);
        this.lNf = (int) resources.getDimension(R.dimen.tbds44);
        this.lNn = (int) resources.getDimension(R.dimen.ds12);
        this.lNo = (int) resources.getDimension(R.dimen.ds1);
        this.lNp = (int) resources.getDimension(R.dimen.ds18);
        this.lNj = (int) resources.getDimension(R.dimen.tbds208);
        this.lNk = (int) resources.getDimension(R.dimen.tbds33);
        this.lNl = (int) resources.getDimension(R.dimen.tbds72);
        this.lNm = (int) resources.getDimension(R.dimen.tbds48);
    }

    protected void E(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.lNy.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cPW() {
        MessageManager.getInstance().registerListener(this.lNE);
        MessageManager.getInstance().registerListener(this.lNF);
        MessageManager.getInstance().registerListener(this.lNG);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.hrn = this.mRootView.findViewById(R.id.bottom_line);
        this.iGj = this.mRootView.findViewById(R.id.top_line);
        this.lNa = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.lNa.setClickable(true);
        this.jPN = (TextView) this.mRootView.findViewById(R.id.ad_title);
        com.baidu.tbadk.a.b.a.d(this.jPN, R.dimen.tbds32, R.dimen.tbds20);
        this.lNq = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.lNt = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.lNu = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.lNv = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.lNt.x(this.ehG.getUniqueId());
        this.lNE.setTag(this.ehG.getUniqueId());
        this.lNw = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.lNF.setTag(this.ehG.getUniqueId());
        this.lNG.setTag(this.ehG.getUniqueId());
        this.lNy = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.lNy.setStyle(1);
        this.lNz = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        this.lND = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        if (1 == getBusinessType()) {
            this.lNz.setShowFlag(1413);
        }
        this.lNs = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.lNr = (AdCloseView) this.lNs.findViewById(R.id.ad_close_view);
        ViewGroup.LayoutParams layoutParams = this.lNr.lRv.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.lNr.lRv.getLayoutParams();
        int dimens = l.getDimens(getContext(), R.dimen.tbds62);
        layoutParams2.width = dimens;
        layoutParams.height = dimens;
        this.jPP = (TextView) this.lNs.findViewById(R.id.feed_tag);
        this.jPP.setVisibility(8);
        this.lNz.addAdTagView(this.lNs);
        this.hqQ = this.mRootView.findViewById(R.id.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.lNe) - this.lNf) - this.lNb) - this.lNd;
            this.lNy.setVisibility(8);
        } else {
            this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.lNe) - this.lNf;
            this.lNy.setVisibility(0);
        }
        this.lMY = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.lMY.setLayoutResource(getCustomLayout());
        this.lMZ = this.lMY.inflate();
        com.baidu.tbadk.a.b.a.d(this.lMZ, R.dimen.tbds32, R.dimen.tbds14);
        this.lNA = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.lNB = this.mRootView.findViewById(R.id.frs_bottom_view);
        dq(this.lMZ);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(final AdCard adCard) {
        final String str;
        int i;
        this.jPJ = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.lNz.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.bnq() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.ehG.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        a(adCard, bVar);
        this.lNq.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lNw.getLayoutParams();
        if (4 == getBusinessType()) {
            if (adCard.isPBBanner) {
                layoutParams.leftMargin = 0;
                this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.lNe) - this.lNf;
            } else {
                layoutParams.leftMargin = this.lNb + this.lNd;
                this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.lNe) - this.lNf) - this.lNb) - this.lNd;
            }
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.lNz.getHeaderImg(), adCard.portraitClick, bVar);
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String PT = PT(str2);
            this.jPN.setMaxLines(adCard.titleLines <= 0 ? 4 : adCard.titleLines);
            if (4 == getBusinessType()) {
                this.jPN.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize42));
            } else {
                this.jPN.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize44));
            }
            this.jPN.setText(PT);
            this.jPN.setVisibility(0);
        } else {
            this.jPN.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.bdr()) && k.isEmpty(str3);
        a(this.lNv, this.lNq, this.lNt, adCard);
        int i2 = (this.mMaxWidth - this.lNj) - this.lNm;
        if (4 == getBusinessType()) {
            this.lNu.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize30));
            i = i2 - (this.lNk + this.lNl);
        } else {
            i = i2;
        }
        String str4 = null;
        if (advertAppInfo != null && advertAppInfo.bdq()) {
            str4 = adCard.userName.concat("APP");
        } else if (advertAppInfo != null && advertAppInfo.bdr()) {
            str4 = TextUtils.isEmpty(adCard.userName) ? "广告" : adCard.userName;
        }
        this.lNu.setText(com.baidu.g.a.e.a.a(str4, "广告", i, this.lNu.getPaint()));
        if (advertAppInfo != null && advertAppInfo.bdq()) {
            this.lNx = advertAppInfo.dYw;
            this.lNt.setClickable(true);
            DownloadData b2 = b(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            a(adCard, b2);
            a(this.lNq, b2.getStatus(), str3);
            this.lNt.setData(b2);
            this.lNt.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    ap.setViewTextColor(this.lNq, R.color.cp_link_tip_a, 1);
                    ap.setBackgroundResource(this.lNq, R.drawable.ad_download_progress_button_bg);
                    this.lNq.setText(str3);
                    if (k.isEmpty(str)) {
                        this.lNq.setClickable(false);
                    } else {
                        this.lNq.setClickable(true);
                        this.lNq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.jXT != null && adCard.buttonClick != null && !u.PL(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.jXT.a(adCard.buttonClick.auh, adCard.buttonClick.aui, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int c2 = s.c(AdCardBaseView.this.ehG, str, (AdCardBaseView.this.jPJ == null || AdCardBaseView.this.jPJ.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.jPJ.getAdvertAppInfo().dYt);
                                        if ((c2 == 1 || c2 == 2) && AdCardBaseView.this.jXT != null) {
                                            AdCardBaseView.this.jXT.d(c2, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.ehG.getPageActivity());
                                    aVar.zV(adCard.popWindowText);
                                    aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int c3 = s.c(AdCardBaseView.this.ehG, str, (AdCardBaseView.this.jPJ == null || AdCardBaseView.this.jPJ.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.jPJ.getAdvertAppInfo().dYt);
                                            if ((c3 == 1 || c3 == 2) && AdCardBaseView.this.jXT != null) {
                                                AdCardBaseView.this.jXT.d(c3, null);
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
                                    aVar.b(AdCardBaseView.this.ehG).bia();
                                }
                            }
                        });
                    }
                } else {
                    this.lNq.setClickable(false);
                    this.lNq.setText(adCard.buttonTextDone);
                    ap.setBackgroundResource(this.lNq, R.drawable.ad_download_progress_button_bg);
                    ap.setViewTextColor(this.lNq, R.color.cp_btn_a, 1);
                }
            }
            this.lNt.setVisibility(8);
        }
        a(adCard);
        E(com.baidu.tbadk.core.k.bcG().isShowImages(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            PU(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.dYC != null && advertAppInfo.dYC.adCloseInfo != null && advertAppInfo.dYC.adCloseInfo.support_close.intValue() > 0) {
            this.lNr.setVisibility(0);
            this.lNr.lRw = R.drawable.icon_home_delete_n;
            this.lNr.setPage(getBusinessType());
            this.lNr.setData(advertAppInfo);
            l.addToParentArea(this.ehG.getPageActivity(), this.lNs, 40, 40, 40, 120);
            this.lNs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.lNr.performClick();
                }
            });
        } else {
            this.lNr.setVisibility(8);
            this.jPP.setOnClickListener(null);
        }
        this.lNy.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.hrn.getLayoutParams();
        if (4 == getBusinessType()) {
            this.lNy.setVisibility(8);
            this.lNy.setBarNameClickEnabled(false);
            this.lNy.setShareVisible(false);
            this.lNy.setShowPraiseNum(false);
            this.lNy.setCommentNumEnable(false);
            this.lNy.setReplyTimeVisible(false);
            layoutParams2.height = this.lNo;
            this.lNA.setVisibility(0);
            this.lNB.setVisibility(8);
            this.hrn.setVisibility(8);
            dr(this.lNs);
        } else {
            b(adCard, bVar);
            this.hrn.setVisibility(0);
            com.baidu.tbadk.a.b.a.a(this.hrn, (AbsThreadDataSupport) null);
            ((RelativeLayout.LayoutParams) this.lNt.getLayoutParams()).addRule(11, -1);
            ((RelativeLayout.LayoutParams) this.lNq.getLayoutParams()).addRule(11, -1);
            this.lND.setVisibility(8);
            this.lNv.requestLayout();
        }
        a(adCard, this.hqQ, getBusinessType());
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 instanceof AdvertAppInfo) {
            advertAppInfo2.zG(at.cN(adCard.time));
        }
        this.lNz.setData(advertAppInfo2);
        ((TextView) this.lNz.getUserName()).setText(adCard.userName);
        com.baidu.tbadk.a.b.a.a((TextView) this.lNz.getUserName());
        this.lNz.getUserName().setOnClickListener(bVar);
        this.lNz.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.lNz.getUserName()).setText(adCard.userName);
            }
        });
        if (4 == getBusinessType() && adCard.isPBBanner) {
            this.iGj.setVisibility(0);
            this.iGj.setBackgroundResource(R.color.cp_bg_line_b);
            this.lNz.setVisibility(8);
        } else {
            this.iGj.setVisibility(8);
        }
        if ((com.baidu.tieba.frs.b.cog().coa() || com.baidu.tieba.frs.a.cnZ().coa()) && isInFrsAllThread()) {
            this.lNa.setVisibility(0);
            ap.setBackgroundColor(this.lNa, R.color.cp_bg_line_d);
        } else {
            this.lNa.setVisibility(8);
        }
        a(adCard, advertAppInfo);
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private void dr(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.lND.setVisibility(0);
            this.lND.removeAllViews();
            view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.lND.addView(view);
            int dimension = (int) getResources().getDimension(R.dimen.tbds26);
            int dimension2 = (int) getResources().getDimension(R.dimen.tbds33);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lNt.getLayoutParams();
            layoutParams.setMargins(0, dimension, dimension2, dimension);
            layoutParams.addRule(11, 0);
            layoutParams.addRule(0, this.lND.getId());
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lNq.getLayoutParams();
            layoutParams2.addRule(11, 0);
            layoutParams2.setMargins(0, dimension, dimension2, dimension);
            layoutParams2.addRule(0, this.lND.getId());
            this.lNv.requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bCl();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bCm();
    }

    private void a(AdCard adCard, DownloadData downloadData) {
        if (adCard.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.lNt.getDownloadStatus());
        }
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.directDownload) {
            this.lNt.setOnClickListener(bVar);
        } else {
            this.lNt.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public boolean bG(View view) {
                    AdCardBaseView.this.drm();
                    return false;
                }
            });
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey DU;
        if (!adCard.directDownload && advertAppInfo != null && advertAppInfo.bdq()) {
            String scheme = adCard.getScheme();
            String str = advertAppInfo.dYt;
            if (!TextUtils.isEmpty(str)) {
                DU = com.baidu.tieba.ad.download.d.bCs().DT(str);
            } else {
                DU = com.baidu.tieba.ad.download.d.bCs().DU(scheme);
            }
            if (DU == null) {
                DU = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.dYw);
                com.baidu.tieba.ad.download.d.bCs().a(DU, null);
            }
            i(DU);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.frG = downloadCacheKey;
            bCm();
            this.frH = null;
            AdDownloadData d2 = com.baidu.tieba.ad.download.d.bCs().d(downloadCacheKey);
            if (d2 != null) {
                this.lNt.a(d2.getCurrentState());
            } else {
                this.lNt.a(DownloadStatus.STATUS_NONE);
            }
            String str = "";
            if (this.jPJ != null && this.jPJ.getAdvertAppInfo() != null) {
                str = this.jPJ.getAdvertAppInfo().page;
                d2.setExtInfo(this.jPJ.getAdvertAppInfo().extensionInfo);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.lNt, d2, str);
            this.frH = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d2.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d2);
            }
            bCl();
        }
    }

    private void bCl() {
        if (this.frG != null && this.frH != null) {
            com.baidu.tieba.ad.download.d.bCs().a(this.frG, this.frH);
        }
    }

    private void bCm() {
        if (this.frG != null && this.frH != null) {
            com.baidu.tieba.ad.download.d.bCs().b(this.frG, this.frH);
        }
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void b(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.lNB.setVisibility(0);
            this.lNy.setVisibility(8);
            return;
        }
        this.lNB.setVisibility(8);
        this.lNy.setVisibility(0);
        this.lNy.setBarNameClickEnabled(false);
        this.lNy.setReplyTimeVisible(false);
        this.lNy.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.lNy.setAgreeClickable(true);
            this.lNy.setPraiseContainerBgGray(false);
        } else {
            this.lNy.setAgreeClickable(false);
            this.lNy.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.lNy.setShareClickable(true);
            this.lNy.setShareContainerBgGray(false);
        } else {
            this.lNy.setShareClickable(false);
            this.lNy.setShareContainerBgGray(true);
        }
        if (this.lNy.getCommentContainer() != null) {
            this.lNy.getCommentContainer().setOnClickListener(bVar);
        }
        this.lNy.setNeedAddReplyIcon(true);
        this.lNy.setCommentNumEnable(false);
        this.lNy.setCommentClickable(true);
        this.lNy.setReplayContainerBgGray(true);
        this.lNy.setOnClickListener(bVar);
        this.lNy.setShareData(adCard);
        this.lNy.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        ap.setBackgroundResource(this.hrn, R.color.cp_bg_line_b);
        com.baidu.tbadk.a.b.a.aY(this.hrn);
        this.lNr.onChangeSkinType();
        this.lNz.onChangeSkinType(this.ehG, TbadkCoreApplication.getInst().getSkinType());
        this.lNy.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            ap.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.hqQ, R.color.cp_bg_line_e);
        } else {
            ap.setBackgroundColor(this.hqQ, R.color.transparent);
        }
        com.baidu.tbadk.a.b.a.b((TextView) this.lNz.getUserName());
        ap.setViewTextColor(this.jPN, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.lNu, R.color.cp_cont_d);
        ap.setViewTextColor(this.jPP, R.color.cp_cont_d, 1);
        this.lNt.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String PT(String str) {
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
            if (b(bVar) && !u.PL(bVar.scheme)) {
                if (this.jXT != null) {
                    this.jXT.a(bVar.auh, bVar.aui, null);
                }
            } else if (this.jPJ != null && this.jPJ.getAdvertAppInfo() != null) {
                String PV = PV(bVar.scheme);
                String str = this.jPJ.getAdvertAppInfo().dYt;
                if (!this.jPJ.directDownload && this.jPJ.getAdvertAppInfo().bdq()) {
                    c2 = s.d(this.ehG, PV, str);
                } else {
                    c2 = s.c(this.ehG, PV, str);
                }
                if (c2 == 1 || c2 == 2) {
                    if (this.jXT != null) {
                        this.jXT.d(c2, null);
                    }
                } else if (this.jXT != null) {
                    this.jXT.a(bVar.auh, bVar.aui, null);
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
                        if (AdCardBaseView.this.jPJ.hasAnimation()) {
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
        this.jWt = new a.C0728a();
        this.jWt.picUrl = tbImageView.getUrl();
        this.jWt.bry = rect;
    }

    private void PU(String str) {
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
                    com.baidu.adp.lib.e.c.mR().a(jSONObject.optString("pic_url"), 17, null, this.jYa, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.jYa), this.ehG.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.bdp() != 0) {
                l.showToast(this.ehG.getPageActivity(), R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.ehG.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.ehG.getPageActivity()) && this.jXU != null) {
                this.jXU.c(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(b(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.ehG.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bdq()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.ehG.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ehG.getPageActivity());
                aVar.zV(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.lNt);
                        if (AdCardBaseView.this.lNt != null) {
                            AdCardBaseView.this.lNt.q(AdCardBaseView.this.b(advertAppInfo, i));
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
                aVar.b(this.ehG).bia();
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
                    h.aT(this.ehG.getPageActivity(), advertAppInfo.dYw);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, this.lNt);
                    apkDownloadView.s(b2);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.bCs().aC(this.ehG.getPageActivity(), advertAppInfo.dYw);
                    return;
            }
        }
    }

    public a.C0728a getAnimationInfo() {
        return this.jWt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public class b implements View.OnClickListener {
        private AdCard lNQ;

        public b(AdCard adCard) {
            this.lNQ = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdCardBaseView.this.ehG.showToast(R.string.neterror);
            } else if (this.lNQ != null && view != null && view.getId() != R.id.thread_info_commont_container) {
                AdvertAppInfo advertAppInfo = this.lNQ.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.lNt;
                if (advertAppInfo != null && advertAppInfo.bdq()) {
                    a(advertAppInfo, z);
                } else {
                    h(advertAppInfo);
                }
            }
        }

        private void a(AdvertAppInfo advertAppInfo, boolean z) {
            if (this.lNQ.directDownload || z) {
                b(advertAppInfo, z);
            } else {
                i(advertAppInfo);
            }
        }

        private void h(AdvertAppInfo advertAppInfo) {
            String scheme = this.lNQ.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.dYv;
            }
            if (this.lNQ.hasAnimation()) {
            }
            int h = s.h(AdCardBaseView.this.ehG, AdCardBaseView.this.PV(scheme));
            if (AdCardBaseView.this.jXT != null) {
                AdCardBaseView.this.jXT.d(h, null);
            }
        }

        private void b(AdvertAppInfo advertAppInfo, boolean z) {
            int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
            int status = ApkDownloadView.getStatus(AdCardBaseView.this.b(advertAppInfo, i));
            if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                return;
            }
            AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.lNt, z);
            AdCardBaseView.this.drm();
        }

        private void i(AdvertAppInfo advertAppInfo) {
            String scheme = this.lNQ.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.dYv;
            }
            int d = s.d(AdCardBaseView.this.ehG, scheme, advertAppInfo.dYt);
            if (AdCardBaseView.this.jXT != null) {
                AdCardBaseView.this.jXT.d(d, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drm() {
        if (this.jXT != null) {
            this.jXT.d(3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String PV(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.jWt != null && this.jWt.isValid()) {
            String c0728a = this.jWt.toString();
            if (!TextUtils.isEmpty(c0728a)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(c0728a));
            }
        }
        if (!TextUtils.isEmpty(this.jPJ.getPreLoadData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.jPJ.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.jPJ.getNextPageData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.jPJ.getNextPageData()));
        }
        if (this.jPJ.hasAnimation()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.jPJ.isGoLandingPage()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.jPJ.isImmersiveStyle()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes25.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> lNP;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.lNP = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.lNP.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.lNx) ? false : true)) && adCardBaseView.lNx.equals(downloadData.getId())) {
                    int status = e.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.lNq.setText(R.string.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.lNq.setText(R.string.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes25.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> lNP;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.lNP = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.lNP.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.lNx) && adCardBaseView.lNx.equals(downloadData.getId())) {
                adCardBaseView.lNt.t(downloadData);
            }
        }
    }

    /* loaded from: classes25.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> lNP;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.lNP = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.lNP.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                String str = null;
                if (adCardBaseView.jPJ != null && adCardBaseView.jPJ.getAdvertAppInfo() != null) {
                    str = adCardBaseView.jPJ.getAdvertAppInfo().dYt;
                }
                s.c(adCardBaseView.ehG, adCardBaseView.lNC.scheme, str);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void cQc() {
        if (4 == getBusinessType()) {
            this.jPN.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.lMI != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.lNC = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.ehG.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.ehG, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        return true;
    }

    private void a(View view, TextView textView, ApkDownloadView apkDownloadView, AdCard adCard) {
        if (adCard == null) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        if (adCard.getAdvertAppInfo().bdq()) {
            textView.setVisibility(8);
            apkDownloadView.setVisibility(0);
        } else if (k.isEmpty(adCard.buttonText)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dYw);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dYu);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.dYt, 0));
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
