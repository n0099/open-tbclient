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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
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
import com.baidu.tieba.tbadkCore.t;
import com.baidu.webkit.internal.ETAG;
import com.tencent.open.SocialConstants;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public abstract class AdCardBaseView extends BaseLegoCardView<AdCard> implements com.baidu.tieba.lego.card.b.a {
    private DownloadCacheKey fdc;
    private com.baidu.tieba.ad.download.a.d fdd;
    protected View gWQ;
    protected View gXn;
    private View ikC;
    protected TextView jsh;
    protected TextView jsj;
    private a.C0679a jyo;
    private final int jzV;
    protected final int lnA;
    protected final int lnB;
    private final int lnC;
    private final int lnD;
    private final int lnE;
    private final int lnF;
    private int lnG;
    private int lnH;
    private int lnI;
    protected TextView lnJ;
    private AdCloseView lnK;
    private LinearLayout lnL;
    protected ApkDownloadView lnM;
    protected TextView lnN;
    protected RelativeLayout lnO;
    protected View lnP;
    protected String lnQ;
    private AdCard lnR;
    private AdThreadCommentAndPraiseInfoLayout lnS;
    protected AdThreadUserInfoLayout lnT;
    protected View lnU;
    protected View lnV;
    protected AdCard.b lnW;
    private FrameLayout lnX;
    protected CustomMessageListener lnY;
    protected CustomMessageListener lnZ;
    protected ViewStub lnr;
    protected View lns;
    protected View lnt;
    protected final int lnu;
    protected final int lnv;
    protected final int lnw;
    protected final int lnx;
    protected final int lny;
    protected final int lnz;
    protected CustomMessageListener loa;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void de(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.jzV = l.getEquipmentWidth(getContext());
        this.fdd = null;
        this.lnY = new a(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG, this);
        this.lnZ = new d(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG, this);
        this.loa = new c(CmdConfigCustom.CMD_USER_INFO_CHANGED, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.ds640);
        this.mImageHeight = (int) resources.getDimension(R.dimen.ds278);
        this.lnu = (int) resources.getDimension(R.dimen.tbds92);
        this.lnv = (int) resources.getDimension(R.dimen.tbds92);
        this.lnw = (int) resources.getDimension(R.dimen.tbds20);
        this.lnz = (int) resources.getDimension(R.dimen.tbds90);
        this.lnA = (int) resources.getDimension(R.dimen.tbds90);
        this.lnB = (int) resources.getDimension(R.dimen.tbds22);
        this.lnx = (int) resources.getDimension(R.dimen.tbds44);
        this.lny = (int) resources.getDimension(R.dimen.tbds44);
        this.lnG = (int) resources.getDimension(R.dimen.ds12);
        this.lnH = (int) resources.getDimension(R.dimen.ds1);
        this.lnI = (int) resources.getDimension(R.dimen.ds18);
        this.lnC = (int) resources.getDimension(R.dimen.tbds208);
        this.lnD = (int) resources.getDimension(R.dimen.tbds33);
        this.lnE = (int) resources.getDimension(R.dimen.tbds72);
        this.lnF = (int) resources.getDimension(R.dimen.tbds48);
    }

    protected void E(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.lnS.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cBx() {
        MessageManager.getInstance().registerListener(this.lnY);
        MessageManager.getInstance().registerListener(this.lnZ);
        MessageManager.getInstance().registerListener(this.loa);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.gXn = this.mRootView.findViewById(R.id.bottom_line);
        this.ikC = this.mRootView.findViewById(R.id.top_line);
        this.lnt = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.lnt.setClickable(true);
        this.jsh = (TextView) this.mRootView.findViewById(R.id.ad_title);
        com.baidu.tbadk.a.b.a.e(this.jsh, R.dimen.tbds32, R.dimen.tbds20);
        this.lnJ = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.lnM = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.lnN = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.lnO = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.lnM.y(this.dVN.getUniqueId());
        this.lnY.setTag(this.dVN.getUniqueId());
        this.lnP = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.lnZ.setTag(this.dVN.getUniqueId());
        this.loa.setTag(this.dVN.getUniqueId());
        this.lnS = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.lnS.setStyle(1);
        this.lnT = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        this.lnX = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        if (1 == getBusinessType()) {
            this.lnT.setShowFlag(1413);
        }
        this.lnL = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.lnK = (AdCloseView) this.lnL.findViewById(R.id.ad_close_view);
        ViewGroup.LayoutParams layoutParams = this.lnK.lrR.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.lnK.lrR.getLayoutParams();
        int dimens = l.getDimens(getContext(), R.dimen.tbds62);
        layoutParams2.width = dimens;
        layoutParams.height = dimens;
        this.jsj = (TextView) this.lnL.findViewById(R.id.feed_tag);
        this.jsj.setVisibility(8);
        this.lnT.addAdTagView(this.lnL);
        this.gWQ = this.mRootView.findViewById(R.id.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.lnx) - this.lny) - this.lnu) - this.lnw;
            this.lnS.setVisibility(8);
        } else {
            this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.lnx) - this.lny;
            this.lnS.setVisibility(0);
        }
        this.lnr = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.lnr.setLayoutResource(getCustomLayout());
        this.lns = this.lnr.inflate();
        com.baidu.tbadk.a.b.a.e(this.lns, R.dimen.tbds32, R.dimen.tbds14);
        this.lnU = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.lnV = this.mRootView.findViewById(R.id.frs_bottom_view);
        de(this.lns);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(final AdCard adCard) {
        final String str;
        int i;
        this.lnR = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.lnT.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.bdQ() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.dVN.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        a(adCard, bVar);
        this.lnJ.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lnP.getLayoutParams();
        if (4 == getBusinessType()) {
            if (adCard.isPBBanner) {
                layoutParams.leftMargin = 0;
                this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.lnx) - this.lny;
            } else {
                layoutParams.leftMargin = this.lnu + this.lnw;
                this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.lnx) - this.lny) - this.lnu) - this.lnw;
            }
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.lnT.getHeaderImg(), adCard.portraitClick, bVar);
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String Mu = Mu(str2);
            this.jsh.setMaxLines(adCard.titleLines <= 0 ? 4 : adCard.titleLines);
            if (4 == getBusinessType()) {
                this.jsh.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize42));
            } else {
                this.jsh.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize44));
            }
            this.jsh.setText(Mu);
            this.jsh.setVisibility(0);
        } else {
            this.jsh.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.aUg()) && k.isEmpty(str3);
        a(this.lnO, this.lnJ, this.lnM, adCard);
        int i2 = (this.mMaxWidth - this.lnC) - this.lnF;
        if (4 == getBusinessType()) {
            this.lnN.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize30));
            i = i2 - (this.lnD + this.lnE);
        } else {
            i = i2;
        }
        String str4 = null;
        if (advertAppInfo != null && advertAppInfo.aUf()) {
            str4 = adCard.userName.concat("APP");
        } else if (advertAppInfo != null && advertAppInfo.aUg()) {
            str4 = TextUtils.isEmpty(adCard.userName) ? "广告" : adCard.userName;
        }
        this.lnN.setText(com.baidu.c.a.e.a.a(str4, "广告", i, this.lnN.getPaint()));
        if (advertAppInfo != null && advertAppInfo.aUf()) {
            this.lnQ = advertAppInfo.dMZ;
            this.lnM.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            a(adCard, c2);
            a(this.lnJ, c2.getStatus(), str3);
            this.lnM.setData(c2);
            this.lnM.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    ao.setViewTextColor(this.lnJ, R.color.cp_link_tip_a, 1);
                    ao.setBackgroundResource(this.lnJ, R.drawable.ad_download_progress_button_bg);
                    this.lnJ.setText(str3);
                    if (k.isEmpty(str)) {
                        this.lnJ.setClickable(false);
                    } else {
                        this.lnJ.setClickable(true);
                        this.lnJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.jzO != null && adCard.buttonClick != null && !t.NE(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.jzO.a(adCard.buttonClick.aoF, adCard.buttonClick.aoG, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int c3 = s.c(AdCardBaseView.this.dVN, str, (AdCardBaseView.this.lnR == null || AdCardBaseView.this.lnR.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.lnR.getAdvertAppInfo().dMW);
                                        if ((c3 == 1 || c3 == 2) && AdCardBaseView.this.jzO != null) {
                                            AdCardBaseView.this.jzO.d(c3, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.dVN.getPageActivity());
                                    aVar.xl(adCard.popWindowText);
                                    aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int c4 = s.c(AdCardBaseView.this.dVN, str, (AdCardBaseView.this.lnR == null || AdCardBaseView.this.lnR.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.lnR.getAdvertAppInfo().dMW);
                                            if ((c4 == 1 || c4 == 2) && AdCardBaseView.this.jzO != null) {
                                                AdCardBaseView.this.jzO.d(c4, null);
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
                                    aVar.b(AdCardBaseView.this.dVN).aYL();
                                }
                            }
                        });
                    }
                } else {
                    this.lnJ.setClickable(false);
                    this.lnJ.setText(adCard.buttonTextDone);
                    ao.setBackgroundResource(this.lnJ, R.drawable.ad_download_progress_button_bg);
                    ao.setViewTextColor(this.lnJ, R.color.cp_btn_a, 1);
                }
            }
            this.lnM.setVisibility(8);
        }
        a(adCard);
        E(com.baidu.tbadk.core.k.aTv().isShowImages(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            Mv(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.dNf != null && advertAppInfo.dNf.adCloseInfo != null && advertAppInfo.dNf.adCloseInfo.support_close.intValue() > 0) {
            this.lnK.setVisibility(0);
            this.lnK.lrS = R.drawable.icon_home_delete_n;
            this.lnK.setPage(getBusinessType());
            this.lnK.setData(advertAppInfo);
            l.addToParentArea(this.dVN.getPageActivity(), this.lnL, 40, 40, 40, 120);
            this.lnL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.lnK.performClick();
                }
            });
        } else {
            this.lnK.setVisibility(8);
            this.jsj.setOnClickListener(null);
        }
        this.lnS.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.gXn.getLayoutParams();
        if (4 == getBusinessType()) {
            this.lnS.setVisibility(8);
            this.lnS.setBarNameClickEnabled(false);
            this.lnS.setShareVisible(false);
            this.lnS.setShowPraiseNum(false);
            this.lnS.setCommentNumEnable(false);
            this.lnS.setReplyTimeVisible(false);
            layoutParams2.height = this.lnH;
            this.lnU.setVisibility(0);
            this.lnV.setVisibility(8);
            this.gXn.setVisibility(8);
            df(this.lnL);
        } else {
            b(adCard, bVar);
            this.gXn.setVisibility(0);
            com.baidu.tbadk.a.b.a.a(this.gXn, (AbsThreadDataSupport) null);
            ((RelativeLayout.LayoutParams) this.lnM.getLayoutParams()).addRule(11, -1);
            ((RelativeLayout.LayoutParams) this.lnJ.getLayoutParams()).addRule(11, -1);
            this.lnX.setVisibility(8);
            this.lnO.requestLayout();
        }
        a(adCard, this.gWQ, getBusinessType());
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 instanceof AdvertAppInfo) {
            advertAppInfo2.wW(as.cB(adCard.time));
        }
        this.lnT.setData(advertAppInfo2);
        ((TextView) this.lnT.getUserName()).setText(adCard.userName);
        com.baidu.tbadk.a.b.a.a((TextView) this.lnT.getUserName());
        this.lnT.getUserName().setOnClickListener(bVar);
        this.lnT.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.lnT.getUserName()).setText(adCard.userName);
            }
        });
        if (4 == getBusinessType() && adCard.isPBBanner) {
            this.ikC.setVisibility(0);
            this.ikC.setBackgroundResource(R.color.cp_bg_line_b);
            this.lnT.setVisibility(8);
        } else {
            this.ikC.setVisibility(8);
        }
        if ((com.baidu.tieba.frs.b.caw().caq() || com.baidu.tieba.frs.a.cap().caq()) && isInFrsAllThread()) {
            this.lnt.setVisibility(0);
            ao.setBackgroundColor(this.lnt, R.color.cp_bg_line_d);
        } else {
            this.lnt.setVisibility(8);
        }
        a(adCard, advertAppInfo);
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private void df(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.lnX.setVisibility(0);
            this.lnX.removeAllViews();
            view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.lnX.addView(view);
            int dimension = (int) getResources().getDimension(R.dimen.tbds26);
            int dimension2 = (int) getResources().getDimension(R.dimen.tbds33);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lnM.getLayoutParams();
            layoutParams.setMargins(0, dimension, dimension2, dimension);
            layoutParams.addRule(11, 0);
            layoutParams.addRule(0, this.lnX.getId());
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lnJ.getLayoutParams();
            layoutParams2.addRule(11, 0);
            layoutParams2.setMargins(0, dimension, dimension2, dimension);
            layoutParams2.addRule(0, this.lnX.getId());
            this.lnO.requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bsb();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bsc();
    }

    private void a(AdCard adCard, DownloadData downloadData) {
        if (adCard.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.lnM.getDownloadStatus());
        }
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.directDownload) {
            this.lnM.setOnClickListener(bVar);
        } else {
            this.lnM.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public void bA(View view) {
                    AdCardBaseView.this.dcs();
                }
            });
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey Bc;
        if (!adCard.directDownload && advertAppInfo != null && advertAppInfo.aUf()) {
            String scheme = adCard.getScheme();
            String str = advertAppInfo.dMW;
            if (!TextUtils.isEmpty(str)) {
                Bc = com.baidu.tieba.ad.download.d.bsi().Bb(str);
            } else {
                Bc = com.baidu.tieba.ad.download.d.bsi().Bc(scheme);
            }
            if (Bc == null) {
                Bc = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.dMZ);
                com.baidu.tieba.ad.download.d.bsi().a(Bc, null);
            }
            i(Bc);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.fdc = downloadCacheKey;
            bsc();
            this.fdd = null;
            AdDownloadData d2 = com.baidu.tieba.ad.download.d.bsi().d(downloadCacheKey);
            if (d2 != null) {
                this.lnM.a(d2.getCurrentState());
            } else {
                this.lnM.a(DownloadStatus.STATUS_NONE);
            }
            String str = "";
            if (this.lnR != null && this.lnR.getAdvertAppInfo() != null) {
                str = this.lnR.getAdvertAppInfo().page;
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.lnM, d2, str);
            this.fdd = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d2.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d2);
            }
            bsb();
        }
    }

    private void bsb() {
        if (this.fdc != null && this.fdd != null) {
            com.baidu.tieba.ad.download.d.bsi().a(this.fdc, this.fdd);
        }
    }

    private void bsc() {
        if (this.fdc != null && this.fdd != null) {
            com.baidu.tieba.ad.download.d.bsi().b(this.fdc, this.fdd);
        }
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void b(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.lnV.setVisibility(0);
            this.lnS.setVisibility(8);
            return;
        }
        this.lnV.setVisibility(8);
        this.lnS.setVisibility(0);
        this.lnS.setBarNameClickEnabled(false);
        this.lnS.setReplyTimeVisible(false);
        this.lnS.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.lnS.setAgreeClickable(true);
            this.lnS.setPraiseContainerBgGray(false);
        } else {
            this.lnS.setAgreeClickable(false);
            this.lnS.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.lnS.setShareClickable(true);
            this.lnS.setShareContainerBgGray(false);
        } else {
            this.lnS.setShareClickable(false);
            this.lnS.setShareContainerBgGray(true);
        }
        if (this.lnS.getCommentContainer() != null) {
            this.lnS.getCommentContainer().setOnClickListener(bVar);
        }
        this.lnS.setNeedAddReplyIcon(true);
        this.lnS.setCommentNumEnable(false);
        this.lnS.setCommentClickable(true);
        this.lnS.setReplayContainerBgGray(true);
        this.lnS.setOnClickListener(bVar);
        this.lnS.setShareData(adCard);
        this.lnS.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        ao.setBackgroundResource(this.gXn, R.color.cp_bg_line_b);
        com.baidu.tbadk.a.b.a.aU(this.gXn);
        this.lnK.onChangeSkinType();
        this.lnT.onChangeSkinType(this.dVN, TbadkCoreApplication.getInst().getSkinType());
        this.lnS.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            ao.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            ao.setBackgroundColor(this.gWQ, R.color.cp_bg_line_e);
        } else {
            ao.setBackgroundColor(this.gWQ, R.color.transparent);
        }
        com.baidu.tbadk.a.b.a.b((TextView) this.lnT.getUserName());
        ao.setViewTextColor(this.jsh, R.color.cp_cont_b, 1);
        ao.setViewTextColor(this.lnN, R.color.cp_cont_d);
        ao.setViewTextColor(this.jsj, R.color.cp_cont_d, 1);
        this.lnM.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String Mu(String str) {
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
            if (b(bVar) && !t.NE(bVar.scheme)) {
                if (this.jzO != null) {
                    this.jzO.a(bVar.aoF, bVar.aoG, null);
                }
            } else if (this.lnR != null && this.lnR.getAdvertAppInfo() != null) {
                String Mw = Mw(bVar.scheme);
                String str = this.lnR.getAdvertAppInfo().dMW;
                if (!this.lnR.directDownload && this.lnR.getAdvertAppInfo().aUf()) {
                    c2 = s.d(this.dVN, Mw, str);
                } else {
                    c2 = s.c(this.dVN, Mw, str);
                }
                if (c2 == 1 || c2 == 2) {
                    if (this.jzO != null) {
                        this.jzO.d(c2, null);
                    }
                } else if (this.jzO != null) {
                    this.jzO.a(bVar.aoF, bVar.aoG, null);
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
                        if (AdCardBaseView.this.lnR.hasAnimation()) {
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
        this.jyo = new a.C0679a();
        this.jyo.picUrl = tbImageView.getUrl();
        this.jyo.rect = rect;
    }

    private void Mv(String str) {
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
                    com.baidu.adp.lib.e.c.ln().a(jSONObject.optString("pic_url"), 17, null, this.jzV, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.jzV), this.dVN.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.aUe() != 0) {
                l.showToast(this.dVN.getPageActivity(), R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.dVN.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.dVN.getPageActivity()) && this.jzP != null) {
                this.jzP.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.dVN.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.aUf()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.dVN.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dVN.getPageActivity());
                aVar.xl(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.lnM);
                        if (AdCardBaseView.this.lnM != null) {
                            AdCardBaseView.this.lnM.q(AdCardBaseView.this.c(advertAppInfo, i));
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
                aVar.b(this.dVN).aYL();
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
                    h.aM(this.dVN.getPageActivity(), advertAppInfo.dMZ);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, this.lnM);
                    apkDownloadView.s(c2);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.bsi().av(this.dVN.getPageActivity(), advertAppInfo.dMZ);
                    return;
            }
        }
    }

    public a.C0679a getAnimationInfo() {
        return this.jyo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class b implements View.OnClickListener {
        private AdCard lom;

        public b(AdCard adCard) {
            this.lom = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdCardBaseView.this.dVN.showToast(R.string.neterror);
            } else if (this.lom != null && view != null && view.getId() != R.id.thread_info_commont_container) {
                AdvertAppInfo advertAppInfo = this.lom.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.lnM;
                if (advertAppInfo != null && advertAppInfo.aUf()) {
                    a(advertAppInfo, z);
                } else {
                    i(advertAppInfo);
                }
            }
        }

        private void a(AdvertAppInfo advertAppInfo, boolean z) {
            if (this.lom.directDownload || z) {
                b(advertAppInfo, z);
            } else {
                j(advertAppInfo);
            }
        }

        private void i(AdvertAppInfo advertAppInfo) {
            String scheme = this.lom.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.dMY;
            }
            if (this.lom.hasAnimation()) {
            }
            int h = s.h(AdCardBaseView.this.dVN, AdCardBaseView.this.Mw(scheme));
            if (AdCardBaseView.this.jzO != null) {
                AdCardBaseView.this.jzO.d(h, null);
            }
        }

        private void b(AdvertAppInfo advertAppInfo, boolean z) {
            int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
            int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, i));
            if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                return;
            }
            AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.lnM, z);
            AdCardBaseView.this.dcs();
        }

        private void j(AdvertAppInfo advertAppInfo) {
            String scheme = this.lom.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.dMY;
            }
            int d = s.d(AdCardBaseView.this.dVN, scheme, advertAppInfo.dMW);
            if (AdCardBaseView.this.jzO != null) {
                AdCardBaseView.this.jzO.d(d, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dcs() {
        if (this.jzO != null) {
            this.jzO.d(3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Mw(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.jyo != null && this.jyo.isValid()) {
            String c0679a = this.jyo.toString();
            if (!TextUtils.isEmpty(c0679a)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(c0679a));
            }
        }
        if (!TextUtils.isEmpty(this.lnR.getPreLoadData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.lnR.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.lnR.getNextPageData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.lnR.getNextPageData()));
        }
        if (this.lnR.hasAnimation()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.lnR.isGoLandingPage()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.lnR.isImmersiveStyle()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes20.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> lol;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.lol = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.lol.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.lnQ) ? false : true)) && adCardBaseView.lnQ.equals(downloadData.getId())) {
                    int status = e.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.lnJ.setText(R.string.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.lnJ.setText(R.string.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes20.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> lol;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.lol = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.lol.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.lnQ) && adCardBaseView.lnQ.equals(downloadData.getId())) {
                adCardBaseView.lnM.t(downloadData);
            }
        }
    }

    /* loaded from: classes20.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> lol;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.lol = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.lol.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                String str = null;
                if (adCardBaseView.lnR != null && adCardBaseView.lnR.getAdvertAppInfo() != null) {
                    str = adCardBaseView.lnR.getAdvertAppInfo().dMW;
                }
                s.c(adCardBaseView.dVN, adCardBaseView.lnW.scheme, str);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void cBD() {
        if (4 == getBusinessType()) {
            this.jsh.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.lna != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.lnW = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.dVN.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.dVN, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        return true;
    }

    private void a(View view, TextView textView, ApkDownloadView apkDownloadView, AdCard adCard) {
        if (adCard == null) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        if (adCard.getAdvertAppInfo().aUf()) {
            textView.setVisibility(8);
            apkDownloadView.setVisibility(0);
        } else if (k.isEmpty(adCard.buttonText)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dMZ);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dMX);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.dMW, 0));
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
