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
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
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
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.recapp.view.AdThreadUserInfoLayout;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.tieba.tbadkCore.s;
import com.baidu.webkit.internal.ETAG;
import com.tencent.open.SocialConstants;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public abstract class AdCardBaseView extends BaseLegoCardView<AdCard> implements com.baidu.tieba.lego.card.b.a {
    private DownloadCacheKey dYY;
    private com.baidu.tieba.ad.download.a.d dYZ;
    protected View fJL;
    protected View fKi;
    protected TextView hRf;
    private a.C0546a hXd;
    private final int hYJ;
    protected ViewStub jHC;
    protected View jHD;
    protected View jHE;
    protected final int jHF;
    protected final int jHG;
    protected final int jHH;
    protected final int jHI;
    protected final int jHJ;
    protected final int jHK;
    protected final int jHL;
    protected final int jHM;
    private final int jHN;
    private final int jHO;
    private final int jHP;
    private final int jHQ;
    private int jHR;
    private int jHS;
    private int jHT;
    protected TextView jHU;
    protected TextView jHV;
    private AdCloseView jHW;
    private LinearLayout jHX;
    protected ApkDownloadView jHY;
    protected TextView jHZ;
    protected RelativeLayout jIa;
    protected View jIb;
    protected String jIc;
    private AdCard jId;
    private AdThreadCommentAndPraiseInfoLayout jIe;
    protected AdThreadUserInfoLayout jIf;
    protected View jIg;
    protected View jIh;
    protected AdCard.b jIi;
    private FrameLayout jIj;
    protected CustomMessageListener jIk;
    protected CustomMessageListener jIl;
    protected CustomMessageListener jIm;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void cO(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hYJ = l.getEquipmentWidth(getContext());
        this.dYZ = null;
        this.jIk = new a(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG, this);
        this.jIl = new d(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG, this);
        this.jIm = new c(CmdConfigCustom.CMD_USER_INFO_CHANGED, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.ds640);
        this.mImageHeight = (int) resources.getDimension(R.dimen.ds278);
        this.jHF = (int) resources.getDimension(R.dimen.tbds92);
        this.jHG = (int) resources.getDimension(R.dimen.tbds92);
        this.jHH = (int) resources.getDimension(R.dimen.tbds20);
        this.jHK = (int) resources.getDimension(R.dimen.tbds90);
        this.jHL = (int) resources.getDimension(R.dimen.tbds90);
        this.jHM = (int) resources.getDimension(R.dimen.tbds22);
        this.jHI = (int) resources.getDimension(R.dimen.tbds44);
        this.jHJ = (int) resources.getDimension(R.dimen.tbds44);
        this.jHR = (int) resources.getDimension(R.dimen.ds12);
        this.jHS = (int) resources.getDimension(R.dimen.ds1);
        this.jHT = (int) resources.getDimension(R.dimen.ds18);
        this.jHN = (int) resources.getDimension(R.dimen.tbds208);
        this.jHO = (int) resources.getDimension(R.dimen.tbds33);
        this.jHP = (int) resources.getDimension(R.dimen.tbds72);
        this.jHQ = (int) resources.getDimension(R.dimen.tbds48);
    }

    protected void x(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.jIe.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ccd() {
        MessageManager.getInstance().registerListener(this.jIk);
        MessageManager.getInstance().registerListener(this.jIl);
        MessageManager.getInstance().registerListener(this.jIm);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.fKi = this.mRootView.findViewById(R.id.bottom_line);
        this.jHE = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.jHE.setClickable(true);
        this.hRf = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.jHU = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.jHY = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.jHZ = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.jIa = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.jHY.u(this.cVg.getUniqueId());
        this.jIk.setTag(this.cVg.getUniqueId());
        this.jIb = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.jIl.setTag(this.cVg.getUniqueId());
        this.jIm.setTag(this.cVg.getUniqueId());
        this.jIe = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.jIe.setStyle(1);
        this.jIf = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        this.jIj = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        if (1 == getBusinessType()) {
            this.jIf.setShowFlag(1413);
        }
        this.jHX = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.jHW = (AdCloseView) this.jHX.findViewById(R.id.ad_close_view);
        this.jHV = (TextView) this.jHX.findViewById(R.id.feed_tag);
        this.jHV.setVisibility(8);
        this.jIe.addAdMoreView(this.jHX);
        this.fJL = this.mRootView.findViewById(R.id.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.jHI) - this.jHJ) - this.jHF) - this.jHH;
            this.jIe.setVisibility(8);
        } else {
            this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.jHI) - this.jHJ;
            this.jIe.setVisibility(0);
        }
        this.jHC = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.jHC.setLayoutResource(getCustomLayout());
        this.jHD = this.jHC.inflate();
        this.jIg = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.jIh = this.mRootView.findViewById(R.id.frs_bottom_view);
        cO(this.jHD);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(final AdCard adCard) {
        final String str;
        int i;
        this.jId = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.jIf.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.aJf() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.cVg.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        a(adCard, bVar);
        this.jHU.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jIb.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.jHF + this.jHH;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.jIf.getHeaderImg(), adCard.portraitClick, bVar);
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String HQ = HQ(str2);
            this.hRf.setMaxLines(adCard.titleLines <= 0 ? 4 : adCard.titleLines);
            if (4 == getBusinessType()) {
                this.hRf.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize42));
            } else {
                this.hRf.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize44));
            }
            this.hRf.setText(HQ);
            this.hRf.setVisibility(0);
        } else {
            this.hRf.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.aAp()) && k.isEmpty(str3);
        a(this.jIa, this.jHU, this.jHY, adCard);
        int i2 = (this.mMaxWidth - this.jHN) - this.jHQ;
        if (4 == getBusinessType()) {
            this.jHZ.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize30));
            i = i2 - (this.jHO + this.jHP);
        } else {
            i = i2;
        }
        String str4 = null;
        if (advertAppInfo != null && advertAppInfo.aAo()) {
            str4 = adCard.userName.concat("APP");
        } else if (advertAppInfo != null && advertAppInfo.aAp()) {
            str4 = TextUtils.isEmpty(adCard.userName) ? "广告" : adCard.userName;
        }
        this.jHZ.setText(com.baidu.c.a.e.a.a(str4, "广告", i, this.jHZ.getPaint()));
        if (advertAppInfo != null && advertAppInfo.aAo()) {
            this.jIc = advertAppInfo.cMY;
            this.jHY.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            a(adCard, c2);
            a(this.jHU, c2.getStatus(), str3);
            this.jHY.setData(c2);
            this.jHY.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    am.setViewTextColor(this.jHU, R.color.cp_link_tip_a, 1);
                    am.setBackgroundResource(this.jHU, R.drawable.ad_download_progress_button_bg);
                    this.jHU.setText(str3);
                    if (k.isEmpty(str)) {
                        this.jHU.setClickable(false);
                    } else {
                        this.jHU.setClickable(true);
                        this.jHU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.hYC != null && adCard.buttonClick != null && !s.IU(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.hYC.b(adCard.buttonClick.Tm, adCard.buttonClick.Tn, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int b2 = com.baidu.tieba.recapp.s.b(AdCardBaseView.this.cVg, str, (AdCardBaseView.this.jId == null || AdCardBaseView.this.jId.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.jId.getAdvertAppInfo().cMV);
                                        if ((b2 == 1 || b2 == 2) && AdCardBaseView.this.hYC != null) {
                                            AdCardBaseView.this.hYC.b(b2, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.cVg.getPageActivity());
                                    aVar.sS(adCard.popWindowText);
                                    aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int b3 = com.baidu.tieba.recapp.s.b(AdCardBaseView.this.cVg, str, (AdCardBaseView.this.jId == null || AdCardBaseView.this.jId.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.jId.getAdvertAppInfo().cMV);
                                            if ((b3 == 1 || b3 == 2) && AdCardBaseView.this.hYC != null) {
                                                AdCardBaseView.this.hYC.b(b3, null);
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
                                    aVar.b(AdCardBaseView.this.cVg).aEA();
                                }
                            }
                        });
                    }
                } else {
                    this.jHU.setClickable(false);
                    this.jHU.setText(adCard.buttonTextDone);
                    am.setBackgroundResource(this.jHU, R.drawable.ad_download_progress_button_bg);
                    am.setViewTextColor(this.jHU, R.color.cp_btn_a, 1);
                }
            }
            this.jHY.setVisibility(8);
        }
        a(adCard);
        x(i.azM().isShowImages(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            HR(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.cNe != null && advertAppInfo.cNe.adCloseInfo != null && advertAppInfo.cNe.adCloseInfo.support_close.intValue() > 0) {
            this.jHW.setVisibility(0);
            this.jHW.setPage(getBusinessType());
            this.jHW.setData(advertAppInfo);
            l.addToParentArea(this.cVg.getPageActivity(), this.jHX, 40, 40, 40, 120);
            this.jHX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.jHW.performClick();
                }
            });
        } else {
            this.jHW.setVisibility(8);
            this.jHV.setOnClickListener(null);
        }
        this.jIe.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.fKi.getLayoutParams();
        if (4 == getBusinessType()) {
            this.jIe.setVisibility(8);
            this.jIe.setBarNameClickEnabled(false);
            this.jIe.setShareVisible(false);
            this.jIe.setShowPraiseNum(false);
            this.jIe.setCommentNumEnable(false);
            this.jIe.setReplyTimeVisible(false);
            layoutParams2.height = this.jHS;
            this.jIg.setVisibility(0);
            this.jIh.setVisibility(8);
            this.fKi.setVisibility(8);
            cP(this.jHX);
        } else {
            b(adCard, bVar);
            this.fKi.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.jHY.getLayoutParams()).addRule(11, -1);
            ((RelativeLayout.LayoutParams) this.jHU.getLayoutParams()).addRule(11, -1);
            this.jIj.setVisibility(8);
            this.jIa.requestLayout();
        }
        a(adCard, this.fJL, getBusinessType());
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 instanceof AdvertAppInfo) {
            advertAppInfo2.sD(aq.bD(adCard.time));
        }
        this.jIf.setData(advertAppInfo2);
        ((TextView) this.jIf.getUserName()).setText(adCard.userName);
        this.jIf.getUserName().setOnClickListener(bVar);
        this.jIf.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.jIf.getUserName()).setText(adCard.userName);
            }
        });
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bCT().bCU()) {
            this.jHE.setVisibility(0);
            am.setBackgroundColor(this.jHE, R.color.cp_bg_line_d);
        } else {
            this.jHE.setVisibility(8);
        }
        a(adCard, advertAppInfo);
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private void cP(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((FrameLayout) view.getParent()).removeView(view);
            }
            this.jIj.setVisibility(0);
            this.jIj.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.jIj.addView(view);
            int dimension = (int) getResources().getDimension(R.dimen.tbds26);
            int dimension2 = (int) getResources().getDimension(R.dimen.tbds33);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jHY.getLayoutParams();
            layoutParams.setMargins(0, dimension, dimension2, dimension);
            layoutParams.addRule(11, 0);
            layoutParams.addRule(0, this.jIj.getId());
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jHU.getLayoutParams();
            layoutParams2.addRule(11, 0);
            layoutParams2.setMargins(0, dimension, dimension2, dimension);
            layoutParams2.addRule(0, this.jIj.getId());
            this.jIa.requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aYc();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aYd();
    }

    private void a(AdCard adCard, DownloadData downloadData) {
        if (adCard.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.jHY.getDownloadStatus());
        }
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.directDownload) {
            this.jHY.setOnClickListener(bVar);
        } else {
            this.jHY.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public void bp(View view) {
                    AdCardBaseView.this.cCL();
                }
            });
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey xb;
        if (!adCard.directDownload && advertAppInfo != null && advertAppInfo.aAo()) {
            String scheme = adCard.getScheme();
            String str = advertAppInfo.cMV;
            if (!TextUtils.isEmpty(str)) {
                xb = com.baidu.tieba.ad.download.d.aYi().xa(str);
            } else {
                xb = com.baidu.tieba.ad.download.d.aYi().xb(scheme);
            }
            if (xb == null) {
                xb = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.cMY);
                com.baidu.tieba.ad.download.d.aYi().a(xb, null);
            }
            i(xb);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.dYY = downloadCacheKey;
            aYd();
            this.dYZ = null;
            AdDownloadData d2 = com.baidu.tieba.ad.download.d.aYi().d(downloadCacheKey);
            if (d2 != null) {
                this.jHY.a(d2.getCurrentState());
            } else {
                this.jHY.a(DownloadStatus.STATUS_NONE);
            }
            String str = "";
            if (this.jId != null && this.jId.getAdvertAppInfo() != null) {
                str = this.jId.getAdvertAppInfo().page;
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.jHY, d2, str);
            this.dYZ = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d2.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d2);
            }
            aYc();
        }
    }

    private void aYc() {
        if (this.dYY != null && this.dYZ != null) {
            com.baidu.tieba.ad.download.d.aYi().a(this.dYY, this.dYZ);
        }
    }

    private void aYd() {
        if (this.dYY != null && this.dYZ != null) {
            com.baidu.tieba.ad.download.d.aYi().b(this.dYY, this.dYZ);
        }
    }

    private boolean isInFrsAllThread() {
        return this.hXG == 1;
    }

    private void b(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.jIh.setVisibility(0);
            this.jIe.setVisibility(8);
            return;
        }
        this.jIh.setVisibility(8);
        this.jIe.setVisibility(0);
        this.jIe.setBarNameClickEnabled(false);
        this.jIe.setReplyTimeVisible(false);
        this.jIe.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.jIe.setAgreeClickable(true);
            this.jIe.setPraiseContainerBgGray(false);
        } else {
            this.jIe.setAgreeClickable(false);
            this.jIe.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.jIe.setShareClickable(true);
            this.jIe.setShareContainerBgGray(false);
        } else {
            this.jIe.setShareClickable(false);
            this.jIe.setShareContainerBgGray(true);
        }
        if (this.jIe.getCommentContainer() != null) {
            this.jIe.getCommentContainer().setOnClickListener(bVar);
        }
        this.jIe.setNeedAddReplyIcon(true);
        this.jIe.setCommentNumEnable(false);
        this.jIe.setCommentClickable(true);
        this.jIe.setReplayContainerBgGray(true);
        this.jIe.setOnClickListener(bVar);
        this.jIe.setShareData(adCard);
        this.jIe.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        am.setBackgroundResource(this.fKi, R.color.cp_bg_line_b);
        this.jHW.onChangeSkinType();
        this.jIf.onChangeSkinType(this.cVg, TbadkCoreApplication.getInst().getSkinType());
        this.jIe.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.fJL, R.color.cp_bg_line_e);
        } else {
            am.setBackgroundColor(this.fJL, R.color.transparent);
        }
        am.setViewTextColor(this.hRf, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.jHZ, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.jHV, R.color.cp_cont_d, 1);
        this.jHY.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String HQ(String str) {
        if (!StringUtils.isNull(str)) {
            String replaceAll = str.replaceAll("，", "， ").replaceAll("。", "。 ").replaceAll("？", "？ ").replaceAll("！", "！ ").replaceAll("、", "、 ").replaceAll("‘", "’ ").replaceAll("“", "” ").replaceAll("【", "【 ").replaceAll("】", "】 ").replaceAll("；", "； ").replaceAll("：", "： ").replaceAll("（", "（ ").replaceAll("）", "） ").replaceAll("·", "· ").replaceAll(HanziToPinyin.Token.SEPARATOR, "  ");
            if (replaceAll.charAt(replaceAll.length() - 1) == ' ') {
                replaceAll = replaceAll.substring(0, replaceAll.length() - 1);
            }
            return replaceAll;
        }
        return str;
    }

    protected void a(AdCard.b bVar) {
        int b2;
        if (bVar != null) {
            if (b(bVar) && !s.IU(bVar.scheme)) {
                if (this.hYC != null) {
                    this.hYC.b(bVar.Tm, bVar.Tn, null);
                }
            } else if (this.jId != null && this.jId.getAdvertAppInfo() != null) {
                String HS = HS(bVar.scheme);
                String str = this.jId.getAdvertAppInfo().cMV;
                if (!this.jId.directDownload && this.jId.getAdvertAppInfo().aAo()) {
                    b2 = com.baidu.tieba.recapp.s.c(this.cVg, HS, str);
                } else {
                    b2 = com.baidu.tieba.recapp.s.b(this.cVg, HS, str);
                }
                if (b2 == 1 || b2 == 2) {
                    if (this.hYC != null) {
                        this.hYC.b(b2, null);
                    }
                } else if (this.hYC != null) {
                    this.hYC.b(bVar.Tm, bVar.Tn, null);
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
                        if (AdCardBaseView.this.jId.hasAnimation()) {
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
        this.hXd = new a.C0546a();
        this.hXd.picUrl = tbImageView.getUrl();
        this.hXd.rect = rect;
    }

    private void HR(String str) {
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
                    com.baidu.adp.lib.e.c.gr().a(jSONObject.optString("pic_url"), 17, null, this.hYJ, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.hYJ), this.cVg.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.aAn() != 0) {
                l.showToast(this.cVg.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.cVg.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.cVg.getPageActivity()) && this.hYD != null) {
                this.hYD.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.cVg.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aAo()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.cVg.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVg.getPageActivity());
                aVar.sS(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.jHY);
                        if (AdCardBaseView.this.jHY != null) {
                            AdCardBaseView.this.jHY.q(AdCardBaseView.this.c(advertAppInfo, i));
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
                aVar.b(this.cVg).aEA();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView, boolean z) {
        if (advertAppInfo != null) {
            DownloadData c2 = c(advertAppInfo, i);
            switch (ApkDownloadView.getStatus(c2)) {
                case 1:
                case 5:
                    if (z) {
                        h.f(advertAppInfo);
                        apkDownloadView.r(c2);
                        break;
                    }
                    break;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    break;
                case 6:
                case 7:
                    a(advertAppInfo, i, this.jHY);
                    apkDownloadView.s(c2);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.aYi().aN(this.cVg.getPageActivity(), advertAppInfo.cMY);
                    return;
            }
            h.bd(this.cVg.getPageActivity(), advertAppInfo.cMY);
        }
    }

    public a.C0546a getAnimationInfo() {
        return this.hXd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class b implements View.OnClickListener {
        private AdCard jIw;

        public b(AdCard adCard) {
            this.jIw = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdCardBaseView.this.cVg.showToast(R.string.neterror);
            } else if (this.jIw != null) {
                AdvertAppInfo advertAppInfo = this.jIw.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.jHY;
                if (advertAppInfo != null && advertAppInfo.aAo()) {
                    a(advertAppInfo, z);
                } else {
                    i(advertAppInfo);
                }
            }
        }

        private void a(AdvertAppInfo advertAppInfo, boolean z) {
            if (this.jIw.directDownload || z) {
                b(advertAppInfo, z);
            } else {
                j(advertAppInfo);
            }
        }

        private void i(AdvertAppInfo advertAppInfo) {
            String scheme = this.jIw.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.cMX;
            }
            if (this.jIw.hasAnimation()) {
            }
            int e = com.baidu.tieba.recapp.s.e(AdCardBaseView.this.cVg, AdCardBaseView.this.HS(scheme));
            if (AdCardBaseView.this.hYC != null) {
                AdCardBaseView.this.hYC.b(e, null);
            }
        }

        private void b(AdvertAppInfo advertAppInfo, boolean z) {
            int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
            int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, i));
            if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                return;
            }
            AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.jHY, z);
            AdCardBaseView.this.cCL();
        }

        private void j(AdvertAppInfo advertAppInfo) {
            String scheme = this.jIw.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.cMX;
            }
            int c = com.baidu.tieba.recapp.s.c(AdCardBaseView.this.cVg, scheme, advertAppInfo.cMV);
            if (AdCardBaseView.this.hYC != null) {
                AdCardBaseView.this.hYC.b(c, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cCL() {
        if (this.hYC != null) {
            this.hYC.b(3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String HS(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.hXd != null && this.hXd.isValid()) {
            String c0546a = this.hXd.toString();
            if (!TextUtils.isEmpty(c0546a)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(c0546a));
            }
        }
        if (!TextUtils.isEmpty(this.jId.getPreLoadData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.jId.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.jId.getNextPageData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.jId.getNextPageData()));
        }
        if (this.jId.hasAnimation()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.jId.isGoLandingPage()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.jId.isImmersiveStyle()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes13.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> jIv;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.jIv = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.jIv.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.jIc) ? false : true)) && adCardBaseView.jIc.equals(downloadData.getId())) {
                    int status = e.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.jHU.setText(R.string.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.jHU.setText(R.string.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> jIv;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.jIv = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.jIv.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.jIc) && adCardBaseView.jIc.equals(downloadData.getId())) {
                adCardBaseView.jHY.t(downloadData);
            }
        }
    }

    /* loaded from: classes13.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> jIv;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.jIv = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.jIv.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                String str = null;
                if (adCardBaseView.jId != null && adCardBaseView.jId.getAdvertAppInfo() != null) {
                    str = adCardBaseView.jId.getAdvertAppInfo().cMV;
                }
                com.baidu.tieba.recapp.s.b(adCardBaseView.cVg, adCardBaseView.jIi.scheme, str);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void ccj() {
        if (4 == getBusinessType()) {
            this.hRf.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.jHm != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.jIi = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.cVg.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.cVg, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        return true;
    }

    private void a(View view, TextView textView, ApkDownloadView apkDownloadView, AdCard adCard) {
        if (adCard == null) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        if (adCard.getAdvertAppInfo().aAo()) {
            textView.setVisibility(8);
            apkDownloadView.setVisibility(0);
        } else if (k.isEmpty(adCard.buttonText)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.cMY);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.cMW);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.cMV, 0));
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
