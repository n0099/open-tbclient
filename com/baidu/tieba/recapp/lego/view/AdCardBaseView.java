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
    private DownloadCacheKey fDR;
    private com.baidu.tieba.ad.download.a.d fDS;
    protected View hFK;
    protected View hGh;
    private View iUZ;
    private AdCard keI;
    protected TextView keM;
    protected TextView keO;
    private a.C0746a klJ;
    private final int knq;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    protected View mRootView;
    private final int mcA;
    private final int mcB;
    private final int mcC;
    private final int mcD;
    private int mcE;
    private int mcF;
    private int mcG;
    protected TextView mcH;
    private AdCloseView mcI;
    private LinearLayout mcJ;
    protected ApkDownloadView mcK;
    protected TextView mcL;
    protected RelativeLayout mcM;
    protected View mcN;
    protected String mcO;
    private AdThreadCommentAndPraiseInfoLayout mcP;
    protected AdThreadUserInfoLayout mcQ;
    protected View mcR;
    protected View mcS;
    protected AdCard.b mcT;
    private FrameLayout mcU;
    protected CustomMessageListener mcV;
    protected CustomMessageListener mcW;
    protected CustomMessageListener mcX;
    protected ViewStub mcp;
    protected View mcq;
    protected View mcr;
    protected final int mcs;
    protected final int mct;
    protected final int mcu;
    protected final int mcv;
    protected final int mcw;
    protected final int mcx;
    protected final int mcy;
    protected final int mcz;

    protected abstract void a(AdCard adCard);

    protected abstract void du(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.knq = l.getEquipmentWidth(getContext());
        this.fDS = null;
        this.mcV = new a(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG, this);
        this.mcW = new d(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG, this);
        this.mcX = new c(CmdConfigCustom.CMD_USER_INFO_CHANGED, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.ds640);
        this.mImageHeight = (int) resources.getDimension(R.dimen.ds278);
        this.mcs = (int) resources.getDimension(R.dimen.tbds92);
        this.mct = (int) resources.getDimension(R.dimen.tbds92);
        this.mcu = (int) resources.getDimension(R.dimen.tbds20);
        this.mcx = (int) resources.getDimension(R.dimen.tbds90);
        this.mcy = (int) resources.getDimension(R.dimen.tbds90);
        this.mcz = (int) resources.getDimension(R.dimen.tbds22);
        this.mcv = (int) resources.getDimension(R.dimen.tbds44);
        this.mcw = (int) resources.getDimension(R.dimen.tbds44);
        this.mcE = (int) resources.getDimension(R.dimen.ds12);
        this.mcF = (int) resources.getDimension(R.dimen.ds1);
        this.mcG = (int) resources.getDimension(R.dimen.ds18);
        this.mcA = (int) resources.getDimension(R.dimen.tbds208);
        this.mcB = (int) resources.getDimension(R.dimen.tbds33);
        this.mcC = (int) resources.getDimension(R.dimen.tbds72);
        this.mcD = (int) resources.getDimension(R.dimen.tbds48);
    }

    protected void H(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.mcP.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cTG() {
        MessageManager.getInstance().registerListener(this.mcV);
        MessageManager.getInstance().registerListener(this.mcW);
        MessageManager.getInstance().registerListener(this.mcX);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.hGh = this.mRootView.findViewById(R.id.bottom_line);
        this.iUZ = this.mRootView.findViewById(R.id.top_line);
        this.mcr = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.mcr.setClickable(true);
        this.keM = (TextView) this.mRootView.findViewById(R.id.ad_title);
        com.baidu.tbadk.a.b.a.d(this.keM, R.dimen.tbds32, R.dimen.tbds20);
        this.mcH = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.mcK = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.mcL = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.mcM = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.mcK.x(this.etO.getUniqueId());
        this.mcV.setTag(this.etO.getUniqueId());
        this.mcN = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.mcW.setTag(this.etO.getUniqueId());
        this.mcX.setTag(this.etO.getUniqueId());
        this.mcP = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.mcP.setStyle(1);
        this.mcQ = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        this.mcU = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        if (1 == getBusinessType()) {
            this.mcQ.setShowFlag(1413);
        }
        this.mcJ = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mcI = (AdCloseView) this.mcJ.findViewById(R.id.ad_close_view);
        ViewGroup.LayoutParams layoutParams = this.mcI.mgN.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.mcI.mgN.getLayoutParams();
        int dimens = l.getDimens(getContext(), R.dimen.tbds62);
        layoutParams2.width = dimens;
        layoutParams.height = dimens;
        this.keO = (TextView) this.mcJ.findViewById(R.id.feed_tag);
        this.keO.setVisibility(8);
        this.mcQ.addAdTagView(this.mcJ);
        this.hFK = this.mRootView.findViewById(R.id.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.mcv) - this.mcw) - this.mcs) - this.mcu;
            this.mcP.setVisibility(8);
        } else {
            this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.mcv) - this.mcw;
            this.mcP.setVisibility(0);
        }
        this.mcp = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.mcp.setLayoutResource(getCustomLayout());
        this.mcq = this.mcp.inflate();
        com.baidu.tbadk.a.b.a.d(this.mcq, R.dimen.tbds32, R.dimen.tbds14);
        this.mcR = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.mcS = this.mRootView.findViewById(R.id.frs_bottom_view);
        du(this.mcq);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(final AdCard adCard) {
        final String str;
        int i;
        this.keI = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.mcQ.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.bqa() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.etO.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        a(adCard, bVar);
        this.mcH.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mcN.getLayoutParams();
        if (4 == getBusinessType()) {
            if (adCard.isPBBanner) {
                layoutParams.leftMargin = 0;
                this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.mcv) - this.mcw;
            } else {
                layoutParams.leftMargin = this.mcs + this.mcu;
                this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.mcv) - this.mcw) - this.mcs) - this.mcu;
            }
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.mcQ.getHeaderImg(), adCard.portraitClick, bVar);
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            this.keM.setMaxLines(adCard.titleLines <= 0 ? 4 : adCard.titleLines);
            if (4 == getBusinessType()) {
                this.keM.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize42));
            } else {
                this.keM.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize44));
            }
            this.keM.setText(str2);
            this.keM.setVisibility(0);
        } else {
            this.keM.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.bga()) && k.isEmpty(str3);
        a(this.mcM, this.mcH, this.mcK, adCard);
        int i2 = (this.mMaxWidth - this.mcA) - this.mcD;
        if (4 == getBusinessType()) {
            this.mcL.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize30));
            i = i2 - (this.mcB + this.mcC);
        } else {
            i = i2;
        }
        String str4 = null;
        if (advertAppInfo != null && advertAppInfo.bfZ()) {
            str4 = adCard.userName.concat("APP");
        } else if (advertAppInfo != null && advertAppInfo.bga()) {
            str4 = TextUtils.isEmpty(adCard.userName) ? "广告" : adCard.userName;
        }
        this.mcL.setText(com.baidu.g.a.e.a.a(str4, "广告", i, this.mcL.getPaint()));
        if (advertAppInfo != null && advertAppInfo.bfZ()) {
            this.mcO = advertAppInfo.eky;
            this.mcK.setClickable(true);
            DownloadData b2 = b(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            a(adCard, b2);
            a(this.mcH, b2.getStatus(), str3);
            this.mcK.setData(b2);
            this.mcK.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    ap.setViewTextColor(this.mcH, R.color.cp_link_tip_a, 1);
                    ap.setBackgroundResource(this.mcH, R.drawable.ad_download_progress_button_bg);
                    this.mcH.setText(str3);
                    if (k.isEmpty(str)) {
                        this.mcH.setClickable(false);
                    } else {
                        this.mcH.setClickable(true);
                        this.mcH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.knj != null && adCard.buttonClick != null && !u.QA(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.knj.a(adCard.buttonClick.auQ, adCard.buttonClick.auR, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int c2 = s.c(AdCardBaseView.this.etO, str, (AdCardBaseView.this.keI == null || AdCardBaseView.this.keI.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.keI.getAdvertAppInfo().ekv);
                                        if ((c2 == 1 || c2 == 2) && AdCardBaseView.this.knj != null) {
                                            AdCardBaseView.this.knj.d(c2, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.etO.getPageActivity());
                                    aVar.AH(adCard.popWindowText);
                                    aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int c3 = s.c(AdCardBaseView.this.etO, str, (AdCardBaseView.this.keI == null || AdCardBaseView.this.keI.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.keI.getAdvertAppInfo().ekv);
                                            if ((c3 == 1 || c3 == 2) && AdCardBaseView.this.knj != null) {
                                                AdCardBaseView.this.knj.d(c3, null);
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
                                    aVar.b(AdCardBaseView.this.etO).bkJ();
                                }
                            }
                        });
                    }
                } else {
                    this.mcH.setClickable(false);
                    this.mcH.setText(adCard.buttonTextDone);
                    ap.setBackgroundResource(this.mcH, R.drawable.ad_download_progress_button_bg);
                    ap.setViewTextColor(this.mcH, R.color.cp_btn_a, 1);
                }
            }
            this.mcK.setVisibility(8);
        }
        a(adCard);
        H(com.baidu.tbadk.core.k.bfo().isShowImages(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            QI(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.ekE != null && advertAppInfo.ekE.adCloseInfo != null && advertAppInfo.ekE.adCloseInfo.support_close.intValue() > 0) {
            this.mcI.setVisibility(0);
            this.mcI.mgO = R.drawable.icon_home_delete_n;
            this.mcI.setPage(getBusinessType());
            this.mcI.setData(advertAppInfo);
            l.addToParentArea(this.etO.getPageActivity(), this.mcJ, 40, 40, 40, 120);
            this.mcJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.mcI.performClick();
                }
            });
        } else {
            this.mcI.setVisibility(8);
            this.keO.setOnClickListener(null);
        }
        this.mcP.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.hGh.getLayoutParams();
        if (4 == getBusinessType()) {
            this.mcP.setVisibility(8);
            this.mcP.setBarNameClickEnabled(false);
            this.mcP.setShareVisible(false);
            this.mcP.setShowPraiseNum(false);
            this.mcP.setCommentNumEnable(false);
            this.mcP.setReplyTimeVisible(false);
            layoutParams2.height = this.mcF;
            this.mcR.setVisibility(0);
            this.mcS.setVisibility(8);
            this.hGh.setVisibility(8);
            dv(this.mcJ);
        } else {
            b(adCard, bVar);
            this.hGh.setVisibility(0);
            com.baidu.tbadk.a.b.a.a(this.hGh, (AbsThreadDataSupport) null);
            ((RelativeLayout.LayoutParams) this.mcK.getLayoutParams()).addRule(11, -1);
            ((RelativeLayout.LayoutParams) this.mcH.getLayoutParams()).addRule(11, -1);
            this.mcU.setVisibility(8);
            this.mcM.requestLayout();
        }
        a(adCard, this.hFK, getBusinessType());
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 instanceof AdvertAppInfo) {
            advertAppInfo2.As(at.cV(adCard.time));
        }
        this.mcQ.setData(advertAppInfo2);
        ((TextView) this.mcQ.getUserName()).setText(adCard.userName);
        com.baidu.tbadk.a.b.a.a((TextView) this.mcQ.getUserName());
        this.mcQ.getUserName().setOnClickListener(bVar);
        this.mcQ.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.mcQ.getUserName()).setText(adCard.userName);
            }
        });
        if (4 == getBusinessType() && adCard.isPBBanner) {
            this.iUZ.setVisibility(0);
            this.iUZ.setBackgroundResource(R.color.cp_bg_line_b);
            this.mcQ.setVisibility(8);
        } else {
            this.iUZ.setVisibility(8);
        }
        if ((com.baidu.tieba.frs.b.crE().cry() || com.baidu.tieba.frs.a.crx().cry()) && isInFrsAllThread()) {
            this.mcr.setVisibility(0);
            ap.setBackgroundColor(this.mcr, R.color.cp_bg_line_d);
        } else {
            this.mcr.setVisibility(8);
        }
        a(adCard, advertAppInfo);
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private void dv(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.mcU.setVisibility(0);
            this.mcU.removeAllViews();
            view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.mcU.addView(view);
            int dimension = (int) getResources().getDimension(R.dimen.tbds26);
            int dimension2 = (int) getResources().getDimension(R.dimen.tbds33);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mcK.getLayoutParams();
            layoutParams.setMargins(0, dimension, dimension2, dimension);
            layoutParams.addRule(11, 0);
            layoutParams.addRule(0, this.mcU.getId());
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mcH.getLayoutParams();
            layoutParams2.addRule(11, 0);
            layoutParams2.setMargins(0, dimension, dimension2, dimension);
            layoutParams2.addRule(0, this.mcU.getId());
            this.mcM.requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bEX();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bEY();
    }

    private void a(AdCard adCard, DownloadData downloadData) {
        if (adCard.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.mcK.getDownloadStatus());
        }
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.directDownload) {
            this.mcK.setOnClickListener(bVar);
        } else {
            this.mcK.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public boolean bK(View view) {
                    AdCardBaseView.this.duX();
                    return false;
                }
            });
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey EF;
        if (!adCard.directDownload && advertAppInfo != null && advertAppInfo.bfZ()) {
            String scheme = adCard.getScheme();
            String str = advertAppInfo.ekv;
            if (!TextUtils.isEmpty(str)) {
                EF = com.baidu.tieba.ad.download.d.bFe().EE(str);
            } else {
                EF = com.baidu.tieba.ad.download.d.bFe().EF(scheme);
            }
            if (EF == null) {
                EF = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.eky);
                com.baidu.tieba.ad.download.d.bFe().a(EF, null);
            }
            i(EF);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.fDR = downloadCacheKey;
            bEY();
            this.fDS = null;
            AdDownloadData d2 = com.baidu.tieba.ad.download.d.bFe().d(downloadCacheKey);
            if (d2 != null) {
                this.mcK.a(d2.getCurrentState());
            } else {
                this.mcK.a(DownloadStatus.STATUS_NONE);
            }
            String str = "";
            if (this.keI != null && this.keI.getAdvertAppInfo() != null) {
                str = this.keI.getAdvertAppInfo().page;
                d2.setExtInfo(this.keI.getAdvertAppInfo().extensionInfo);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mcK, d2, str);
            this.fDS = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d2.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d2);
            }
            bEX();
        }
    }

    private void bEX() {
        if (this.fDR != null && this.fDS != null) {
            com.baidu.tieba.ad.download.d.bFe().a(this.fDR, this.fDS);
        }
    }

    private void bEY() {
        if (this.fDR != null && this.fDS != null) {
            com.baidu.tieba.ad.download.d.bFe().b(this.fDR, this.fDS);
        }
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void b(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.mcS.setVisibility(0);
            this.mcP.setVisibility(8);
            return;
        }
        this.mcS.setVisibility(8);
        this.mcP.setVisibility(0);
        this.mcP.setBarNameClickEnabled(false);
        this.mcP.setReplyTimeVisible(false);
        this.mcP.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.mcP.setAgreeClickable(true);
            this.mcP.setPraiseContainerBgGray(false);
        } else {
            this.mcP.setAgreeClickable(false);
            this.mcP.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.mcP.setShareClickable(true);
            this.mcP.setShareContainerBgGray(false);
        } else {
            this.mcP.setShareClickable(false);
            this.mcP.setShareContainerBgGray(true);
        }
        if (this.mcP.getCommentContainer() != null) {
            this.mcP.getCommentContainer().setOnClickListener(bVar);
        }
        this.mcP.setNeedAddReplyIcon(true);
        this.mcP.setCommentNumEnable(false);
        this.mcP.setCommentClickable(true);
        this.mcP.setReplayContainerBgGray(true);
        this.mcP.setOnClickListener(bVar);
        this.mcP.setShareData(adCard);
        this.mcP.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        ap.setBackgroundResource(this.hGh, R.color.cp_bg_line_b);
        com.baidu.tbadk.a.b.a.aZ(this.hGh);
        this.mcI.onChangeSkinType();
        this.mcQ.onChangeSkinType(this.etO, TbadkCoreApplication.getInst().getSkinType());
        this.mcP.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            ap.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.hFK, R.color.cp_bg_line_e);
        } else {
            ap.setBackgroundColor(this.hFK, R.color.transparent);
        }
        com.baidu.tbadk.a.b.a.b((TextView) this.mcQ.getUserName());
        ap.setViewTextColor(this.keM, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.mcL, R.color.cp_cont_d);
        ap.setViewTextColor(this.keO, R.color.cp_cont_d, 1);
        this.mcK.onChangeSkinType(i);
    }

    protected void a(AdCard.b bVar) {
        int c2;
        if (bVar != null) {
            if (b(bVar) && !u.QA(bVar.scheme)) {
                if (this.knj != null) {
                    this.knj.a(bVar.auQ, bVar.auR, null);
                }
            } else if (this.keI != null && this.keI.getAdvertAppInfo() != null) {
                String QJ = QJ(bVar.scheme);
                String str = this.keI.getAdvertAppInfo().ekv;
                if (!this.keI.directDownload && this.keI.getAdvertAppInfo().bfZ()) {
                    c2 = s.d(this.etO, QJ, str);
                } else {
                    c2 = s.c(this.etO, QJ, str);
                }
                if (c2 == 1 || c2 == 2) {
                    if (this.knj != null) {
                        this.knj.d(c2, null);
                    }
                } else if (this.knj != null) {
                    this.knj.a(bVar.auQ, bVar.auR, null);
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
                        if (AdCardBaseView.this.keI.hasAnimation()) {
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
        this.klJ = new a.C0746a();
        this.klJ.picUrl = tbImageView.getUrl();
        this.klJ.bvm = rect;
    }

    private void QI(String str) {
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
                    com.baidu.adp.lib.e.c.mS().a(jSONObject.optString("pic_url"), 17, null, this.knq, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.knq), this.etO.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.bfY() != 0) {
                l.showToast(this.etO.getPageActivity(), R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.etO.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.etO.getPageActivity()) && this.knk != null) {
                this.knk.c(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(b(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.etO.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bfZ()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.etO.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.etO.getPageActivity());
                aVar.AH(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.mcK);
                        if (AdCardBaseView.this.mcK != null) {
                            AdCardBaseView.this.mcK.q(AdCardBaseView.this.b(advertAppInfo, i));
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
                aVar.b(this.etO).bkJ();
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
                    h.aV(this.etO.getPageActivity(), advertAppInfo.eky);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, this.mcK);
                    apkDownloadView.s(b2);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.bFe().aF(this.etO.getPageActivity(), advertAppInfo.eky);
                    return;
            }
        }
    }

    public a.C0746a getAnimationInfo() {
        return this.klJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public class b implements View.OnClickListener {
        private AdCard mdh;

        public b(AdCard adCard) {
            this.mdh = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdCardBaseView.this.etO.showToast(R.string.neterror);
            } else if (this.mdh != null && view != null && view.getId() != R.id.thread_info_commont_container) {
                AdvertAppInfo advertAppInfo = this.mdh.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.mcK;
                if (advertAppInfo != null && advertAppInfo.bfZ()) {
                    a(advertAppInfo, z);
                } else {
                    h(advertAppInfo);
                }
            }
        }

        private void a(AdvertAppInfo advertAppInfo, boolean z) {
            if (this.mdh.directDownload || z) {
                b(advertAppInfo, z);
            } else {
                i(advertAppInfo);
            }
        }

        private void h(AdvertAppInfo advertAppInfo) {
            String scheme = this.mdh.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.ekx;
            }
            if (this.mdh.hasAnimation()) {
            }
            int h = s.h(AdCardBaseView.this.etO, AdCardBaseView.this.QJ(scheme));
            if (AdCardBaseView.this.knj != null) {
                AdCardBaseView.this.knj.d(h, null);
            }
        }

        private void b(AdvertAppInfo advertAppInfo, boolean z) {
            int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
            int status = ApkDownloadView.getStatus(AdCardBaseView.this.b(advertAppInfo, i));
            if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                return;
            }
            AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.mcK, z);
            AdCardBaseView.this.duX();
        }

        private void i(AdvertAppInfo advertAppInfo) {
            String scheme = this.mdh.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.ekx;
            }
            int d = s.d(AdCardBaseView.this.etO, scheme, advertAppInfo.ekv);
            if (AdCardBaseView.this.knj != null) {
                AdCardBaseView.this.knj.d(d, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void duX() {
        if (this.knj != null) {
            this.knj.d(3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String QJ(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.klJ != null && this.klJ.isValid()) {
            String c0746a = this.klJ.toString();
            if (!TextUtils.isEmpty(c0746a)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(c0746a));
            }
        }
        if (!TextUtils.isEmpty(this.keI.getPreLoadData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.keI.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.keI.getNextPageData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.keI.getNextPageData()));
        }
        if (this.keI.hasAnimation()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.keI.isGoLandingPage()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.keI.isImmersiveStyle()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes26.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mdg;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mdg = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.mdg.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.mcO) ? false : true)) && adCardBaseView.mcO.equals(downloadData.getId())) {
                    int status = e.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.mcH.setText(R.string.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.mcH.setText(R.string.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes26.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mdg;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mdg = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.mdg.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.mcO) && adCardBaseView.mcO.equals(downloadData.getId())) {
                adCardBaseView.mcK.t(downloadData);
            }
        }
    }

    /* loaded from: classes26.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mdg;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mdg = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.mdg.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                String str = null;
                if (adCardBaseView.keI != null && adCardBaseView.keI.getAdvertAppInfo() != null) {
                    str = adCardBaseView.keI.getAdvertAppInfo().ekv;
                }
                s.c(adCardBaseView.etO, adCardBaseView.mcT.scheme, str);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void cTM() {
        if (4 == getBusinessType()) {
            this.keM.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.mbZ != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.mcT = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.etO.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.etO, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        return true;
    }

    private void a(View view, TextView textView, ApkDownloadView apkDownloadView, AdCard adCard) {
        if (adCard == null) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        if (adCard.getAdvertAppInfo().bfZ()) {
            textView.setVisibility(8);
            apkDownloadView.setVisibility(0);
        } else if (k.isEmpty(adCard.buttonText)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.eky);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.ekw);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.ekv, 0));
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
