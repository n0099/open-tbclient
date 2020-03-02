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
    private DownloadCacheKey dYZ;
    private com.baidu.tieba.ad.download.a.d dZa;
    protected View fJN;
    protected View fKk;
    protected TextView hRh;
    private a.C0546a hXf;
    private final int hYL;
    protected ViewStub jHE;
    protected View jHF;
    protected View jHG;
    protected final int jHH;
    protected final int jHI;
    protected final int jHJ;
    protected final int jHK;
    protected final int jHL;
    protected final int jHM;
    protected final int jHN;
    protected final int jHO;
    private final int jHP;
    private final int jHQ;
    private final int jHR;
    private final int jHS;
    private int jHT;
    private int jHU;
    private int jHV;
    protected TextView jHW;
    protected TextView jHX;
    private AdCloseView jHY;
    private LinearLayout jHZ;
    protected ApkDownloadView jIa;
    protected TextView jIb;
    protected RelativeLayout jIc;
    protected View jId;
    protected String jIe;
    private AdCard jIf;
    private AdThreadCommentAndPraiseInfoLayout jIg;
    protected AdThreadUserInfoLayout jIh;
    protected View jIi;
    protected View jIj;
    protected AdCard.b jIk;
    private FrameLayout jIl;
    protected CustomMessageListener jIm;
    protected CustomMessageListener jIn;
    protected CustomMessageListener jIo;
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
        this.hYL = l.getEquipmentWidth(getContext());
        this.dZa = null;
        this.jIm = new a(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG, this);
        this.jIn = new d(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG, this);
        this.jIo = new c(CmdConfigCustom.CMD_USER_INFO_CHANGED, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.ds640);
        this.mImageHeight = (int) resources.getDimension(R.dimen.ds278);
        this.jHH = (int) resources.getDimension(R.dimen.tbds92);
        this.jHI = (int) resources.getDimension(R.dimen.tbds92);
        this.jHJ = (int) resources.getDimension(R.dimen.tbds20);
        this.jHM = (int) resources.getDimension(R.dimen.tbds90);
        this.jHN = (int) resources.getDimension(R.dimen.tbds90);
        this.jHO = (int) resources.getDimension(R.dimen.tbds22);
        this.jHK = (int) resources.getDimension(R.dimen.tbds44);
        this.jHL = (int) resources.getDimension(R.dimen.tbds44);
        this.jHT = (int) resources.getDimension(R.dimen.ds12);
        this.jHU = (int) resources.getDimension(R.dimen.ds1);
        this.jHV = (int) resources.getDimension(R.dimen.ds18);
        this.jHP = (int) resources.getDimension(R.dimen.tbds208);
        this.jHQ = (int) resources.getDimension(R.dimen.tbds33);
        this.jHR = (int) resources.getDimension(R.dimen.tbds72);
        this.jHS = (int) resources.getDimension(R.dimen.tbds48);
    }

    protected void x(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.jIg.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ccf() {
        MessageManager.getInstance().registerListener(this.jIm);
        MessageManager.getInstance().registerListener(this.jIn);
        MessageManager.getInstance().registerListener(this.jIo);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.fKk = this.mRootView.findViewById(R.id.bottom_line);
        this.jHG = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.jHG.setClickable(true);
        this.hRh = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.jHW = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.jIa = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.jIb = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.jIc = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.jIa.u(this.cVh.getUniqueId());
        this.jIm.setTag(this.cVh.getUniqueId());
        this.jId = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.jIn.setTag(this.cVh.getUniqueId());
        this.jIo.setTag(this.cVh.getUniqueId());
        this.jIg = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.jIg.setStyle(1);
        this.jIh = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        this.jIl = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        if (1 == getBusinessType()) {
            this.jIh.setShowFlag(1413);
        }
        this.jHZ = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.jHY = (AdCloseView) this.jHZ.findViewById(R.id.ad_close_view);
        this.jHX = (TextView) this.jHZ.findViewById(R.id.feed_tag);
        this.jHX.setVisibility(8);
        this.jIg.addAdMoreView(this.jHZ);
        this.fJN = this.mRootView.findViewById(R.id.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.jHK) - this.jHL) - this.jHH) - this.jHJ;
            this.jIg.setVisibility(8);
        } else {
            this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.jHK) - this.jHL;
            this.jIg.setVisibility(0);
        }
        this.jHE = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.jHE.setLayoutResource(getCustomLayout());
        this.jHF = this.jHE.inflate();
        this.jIi = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.jIj = this.mRootView.findViewById(R.id.frs_bottom_view);
        cO(this.jHF);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(final AdCard adCard) {
        final String str;
        int i;
        this.jIf = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.jIh.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.aJh() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.cVh.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        a(adCard, bVar);
        this.jHW.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jId.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.jHH + this.jHJ;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.jIh.getHeaderImg(), adCard.portraitClick, bVar);
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String HQ = HQ(str2);
            this.hRh.setMaxLines(adCard.titleLines <= 0 ? 4 : adCard.titleLines);
            if (4 == getBusinessType()) {
                this.hRh.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize42));
            } else {
                this.hRh.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize44));
            }
            this.hRh.setText(HQ);
            this.hRh.setVisibility(0);
        } else {
            this.hRh.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.aAr()) && k.isEmpty(str3);
        a(this.jIc, this.jHW, this.jIa, adCard);
        int i2 = (this.mMaxWidth - this.jHP) - this.jHS;
        if (4 == getBusinessType()) {
            this.jIb.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize30));
            i = i2 - (this.jHQ + this.jHR);
        } else {
            i = i2;
        }
        String str4 = null;
        if (advertAppInfo != null && advertAppInfo.aAq()) {
            str4 = adCard.userName.concat("APP");
        } else if (advertAppInfo != null && advertAppInfo.aAr()) {
            str4 = TextUtils.isEmpty(adCard.userName) ? "广告" : adCard.userName;
        }
        this.jIb.setText(com.baidu.c.a.e.a.a(str4, "广告", i, this.jIb.getPaint()));
        if (advertAppInfo != null && advertAppInfo.aAq()) {
            this.jIe = advertAppInfo.cMZ;
            this.jIa.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            a(adCard, c2);
            a(this.jHW, c2.getStatus(), str3);
            this.jIa.setData(c2);
            this.jIa.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    am.setViewTextColor(this.jHW, R.color.cp_link_tip_a, 1);
                    am.setBackgroundResource(this.jHW, R.drawable.ad_download_progress_button_bg);
                    this.jHW.setText(str3);
                    if (k.isEmpty(str)) {
                        this.jHW.setClickable(false);
                    } else {
                        this.jHW.setClickable(true);
                        this.jHW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.hYE != null && adCard.buttonClick != null && !s.IU(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.hYE.b(adCard.buttonClick.Tm, adCard.buttonClick.Tn, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int b2 = com.baidu.tieba.recapp.s.b(AdCardBaseView.this.cVh, str, (AdCardBaseView.this.jIf == null || AdCardBaseView.this.jIf.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.jIf.getAdvertAppInfo().cMW);
                                        if ((b2 == 1 || b2 == 2) && AdCardBaseView.this.hYE != null) {
                                            AdCardBaseView.this.hYE.b(b2, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.cVh.getPageActivity());
                                    aVar.sS(adCard.popWindowText);
                                    aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int b3 = com.baidu.tieba.recapp.s.b(AdCardBaseView.this.cVh, str, (AdCardBaseView.this.jIf == null || AdCardBaseView.this.jIf.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.jIf.getAdvertAppInfo().cMW);
                                            if ((b3 == 1 || b3 == 2) && AdCardBaseView.this.hYE != null) {
                                                AdCardBaseView.this.hYE.b(b3, null);
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
                                    aVar.b(AdCardBaseView.this.cVh).aEC();
                                }
                            }
                        });
                    }
                } else {
                    this.jHW.setClickable(false);
                    this.jHW.setText(adCard.buttonTextDone);
                    am.setBackgroundResource(this.jHW, R.drawable.ad_download_progress_button_bg);
                    am.setViewTextColor(this.jHW, R.color.cp_btn_a, 1);
                }
            }
            this.jIa.setVisibility(8);
        }
        a(adCard);
        x(i.azO().isShowImages(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            HR(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.cNf != null && advertAppInfo.cNf.adCloseInfo != null && advertAppInfo.cNf.adCloseInfo.support_close.intValue() > 0) {
            this.jHY.setVisibility(0);
            this.jHY.setPage(getBusinessType());
            this.jHY.setData(advertAppInfo);
            l.addToParentArea(this.cVh.getPageActivity(), this.jHZ, 40, 40, 40, 120);
            this.jHZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.jHY.performClick();
                }
            });
        } else {
            this.jHY.setVisibility(8);
            this.jHX.setOnClickListener(null);
        }
        this.jIg.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.fKk.getLayoutParams();
        if (4 == getBusinessType()) {
            this.jIg.setVisibility(8);
            this.jIg.setBarNameClickEnabled(false);
            this.jIg.setShareVisible(false);
            this.jIg.setShowPraiseNum(false);
            this.jIg.setCommentNumEnable(false);
            this.jIg.setReplyTimeVisible(false);
            layoutParams2.height = this.jHU;
            this.jIi.setVisibility(0);
            this.jIj.setVisibility(8);
            this.fKk.setVisibility(8);
            cP(this.jHZ);
        } else {
            b(adCard, bVar);
            this.fKk.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.jIa.getLayoutParams()).addRule(11, -1);
            ((RelativeLayout.LayoutParams) this.jHW.getLayoutParams()).addRule(11, -1);
            this.jIl.setVisibility(8);
            this.jIc.requestLayout();
        }
        a(adCard, this.fJN, getBusinessType());
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 instanceof AdvertAppInfo) {
            advertAppInfo2.sD(aq.bD(adCard.time));
        }
        this.jIh.setData(advertAppInfo2);
        ((TextView) this.jIh.getUserName()).setText(adCard.userName);
        this.jIh.getUserName().setOnClickListener(bVar);
        this.jIh.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.jIh.getUserName()).setText(adCard.userName);
            }
        });
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bCV().bCW()) {
            this.jHG.setVisibility(0);
            am.setBackgroundColor(this.jHG, R.color.cp_bg_line_d);
        } else {
            this.jHG.setVisibility(8);
        }
        a(adCard, advertAppInfo);
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private void cP(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((FrameLayout) view.getParent()).removeView(view);
            }
            this.jIl.setVisibility(0);
            this.jIl.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.jIl.addView(view);
            int dimension = (int) getResources().getDimension(R.dimen.tbds26);
            int dimension2 = (int) getResources().getDimension(R.dimen.tbds33);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jIa.getLayoutParams();
            layoutParams.setMargins(0, dimension, dimension2, dimension);
            layoutParams.addRule(11, 0);
            layoutParams.addRule(0, this.jIl.getId());
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jHW.getLayoutParams();
            layoutParams2.addRule(11, 0);
            layoutParams2.setMargins(0, dimension, dimension2, dimension);
            layoutParams2.addRule(0, this.jIl.getId());
            this.jIc.requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aYe();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aYf();
    }

    private void a(AdCard adCard, DownloadData downloadData) {
        if (adCard.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.jIa.getDownloadStatus());
        }
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.directDownload) {
            this.jIa.setOnClickListener(bVar);
        } else {
            this.jIa.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public void bp(View view) {
                    AdCardBaseView.this.cCN();
                }
            });
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey xb;
        if (!adCard.directDownload && advertAppInfo != null && advertAppInfo.aAq()) {
            String scheme = adCard.getScheme();
            String str = advertAppInfo.cMW;
            if (!TextUtils.isEmpty(str)) {
                xb = com.baidu.tieba.ad.download.d.aYk().xa(str);
            } else {
                xb = com.baidu.tieba.ad.download.d.aYk().xb(scheme);
            }
            if (xb == null) {
                xb = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.cMZ);
                com.baidu.tieba.ad.download.d.aYk().a(xb, null);
            }
            i(xb);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.dYZ = downloadCacheKey;
            aYf();
            this.dZa = null;
            AdDownloadData d2 = com.baidu.tieba.ad.download.d.aYk().d(downloadCacheKey);
            if (d2 != null) {
                this.jIa.a(d2.getCurrentState());
            } else {
                this.jIa.a(DownloadStatus.STATUS_NONE);
            }
            String str = "";
            if (this.jIf != null && this.jIf.getAdvertAppInfo() != null) {
                str = this.jIf.getAdvertAppInfo().page;
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.jIa, d2, str);
            this.dZa = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d2.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d2);
            }
            aYe();
        }
    }

    private void aYe() {
        if (this.dYZ != null && this.dZa != null) {
            com.baidu.tieba.ad.download.d.aYk().a(this.dYZ, this.dZa);
        }
    }

    private void aYf() {
        if (this.dYZ != null && this.dZa != null) {
            com.baidu.tieba.ad.download.d.aYk().b(this.dYZ, this.dZa);
        }
    }

    private boolean isInFrsAllThread() {
        return this.hXI == 1;
    }

    private void b(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.jIj.setVisibility(0);
            this.jIg.setVisibility(8);
            return;
        }
        this.jIj.setVisibility(8);
        this.jIg.setVisibility(0);
        this.jIg.setBarNameClickEnabled(false);
        this.jIg.setReplyTimeVisible(false);
        this.jIg.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.jIg.setAgreeClickable(true);
            this.jIg.setPraiseContainerBgGray(false);
        } else {
            this.jIg.setAgreeClickable(false);
            this.jIg.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.jIg.setShareClickable(true);
            this.jIg.setShareContainerBgGray(false);
        } else {
            this.jIg.setShareClickable(false);
            this.jIg.setShareContainerBgGray(true);
        }
        if (this.jIg.getCommentContainer() != null) {
            this.jIg.getCommentContainer().setOnClickListener(bVar);
        }
        this.jIg.setNeedAddReplyIcon(true);
        this.jIg.setCommentNumEnable(false);
        this.jIg.setCommentClickable(true);
        this.jIg.setReplayContainerBgGray(true);
        this.jIg.setOnClickListener(bVar);
        this.jIg.setShareData(adCard);
        this.jIg.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        am.setBackgroundResource(this.fKk, R.color.cp_bg_line_b);
        this.jHY.onChangeSkinType();
        this.jIh.onChangeSkinType(this.cVh, TbadkCoreApplication.getInst().getSkinType());
        this.jIg.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.fJN, R.color.cp_bg_line_e);
        } else {
            am.setBackgroundColor(this.fJN, R.color.transparent);
        }
        am.setViewTextColor(this.hRh, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.jIb, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.jHX, R.color.cp_cont_d, 1);
        this.jIa.onChangeSkinType(i);
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
                if (this.hYE != null) {
                    this.hYE.b(bVar.Tm, bVar.Tn, null);
                }
            } else if (this.jIf != null && this.jIf.getAdvertAppInfo() != null) {
                String HS = HS(bVar.scheme);
                String str = this.jIf.getAdvertAppInfo().cMW;
                if (!this.jIf.directDownload && this.jIf.getAdvertAppInfo().aAq()) {
                    b2 = com.baidu.tieba.recapp.s.c(this.cVh, HS, str);
                } else {
                    b2 = com.baidu.tieba.recapp.s.b(this.cVh, HS, str);
                }
                if (b2 == 1 || b2 == 2) {
                    if (this.hYE != null) {
                        this.hYE.b(b2, null);
                    }
                } else if (this.hYE != null) {
                    this.hYE.b(bVar.Tm, bVar.Tn, null);
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
                        if (AdCardBaseView.this.jIf.hasAnimation()) {
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
        this.hXf = new a.C0546a();
        this.hXf.picUrl = tbImageView.getUrl();
        this.hXf.rect = rect;
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
                    com.baidu.adp.lib.e.c.gr().a(jSONObject.optString("pic_url"), 17, null, this.hYL, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.hYL), this.cVh.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.aAp() != 0) {
                l.showToast(this.cVh.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.cVh.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.cVh.getPageActivity()) && this.hYF != null) {
                this.hYF.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.cVh.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aAq()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.cVh.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVh.getPageActivity());
                aVar.sS(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.jIa);
                        if (AdCardBaseView.this.jIa != null) {
                            AdCardBaseView.this.jIa.q(AdCardBaseView.this.c(advertAppInfo, i));
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
                aVar.b(this.cVh).aEC();
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
                    a(advertAppInfo, i, this.jIa);
                    apkDownloadView.s(c2);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.aYk().aN(this.cVh.getPageActivity(), advertAppInfo.cMZ);
                    return;
            }
            h.bd(this.cVh.getPageActivity(), advertAppInfo.cMZ);
        }
    }

    public a.C0546a getAnimationInfo() {
        return this.hXf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class b implements View.OnClickListener {
        private AdCard jIy;

        public b(AdCard adCard) {
            this.jIy = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdCardBaseView.this.cVh.showToast(R.string.neterror);
            } else if (this.jIy != null) {
                AdvertAppInfo advertAppInfo = this.jIy.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.jIa;
                if (advertAppInfo != null && advertAppInfo.aAq()) {
                    a(advertAppInfo, z);
                } else {
                    i(advertAppInfo);
                }
            }
        }

        private void a(AdvertAppInfo advertAppInfo, boolean z) {
            if (this.jIy.directDownload || z) {
                b(advertAppInfo, z);
            } else {
                j(advertAppInfo);
            }
        }

        private void i(AdvertAppInfo advertAppInfo) {
            String scheme = this.jIy.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.cMY;
            }
            if (this.jIy.hasAnimation()) {
            }
            int e = com.baidu.tieba.recapp.s.e(AdCardBaseView.this.cVh, AdCardBaseView.this.HS(scheme));
            if (AdCardBaseView.this.hYE != null) {
                AdCardBaseView.this.hYE.b(e, null);
            }
        }

        private void b(AdvertAppInfo advertAppInfo, boolean z) {
            int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
            int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, i));
            if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                return;
            }
            AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.jIa, z);
            AdCardBaseView.this.cCN();
        }

        private void j(AdvertAppInfo advertAppInfo) {
            String scheme = this.jIy.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.cMY;
            }
            int c = com.baidu.tieba.recapp.s.c(AdCardBaseView.this.cVh, scheme, advertAppInfo.cMW);
            if (AdCardBaseView.this.hYE != null) {
                AdCardBaseView.this.hYE.b(c, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cCN() {
        if (this.hYE != null) {
            this.hYE.b(3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String HS(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.hXf != null && this.hXf.isValid()) {
            String c0546a = this.hXf.toString();
            if (!TextUtils.isEmpty(c0546a)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(c0546a));
            }
        }
        if (!TextUtils.isEmpty(this.jIf.getPreLoadData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.jIf.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.jIf.getNextPageData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.jIf.getNextPageData()));
        }
        if (this.jIf.hasAnimation()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.jIf.isGoLandingPage()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.jIf.isImmersiveStyle()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes13.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> jIx;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.jIx = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.jIx.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.jIe) ? false : true)) && adCardBaseView.jIe.equals(downloadData.getId())) {
                    int status = e.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.jHW.setText(R.string.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.jHW.setText(R.string.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> jIx;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.jIx = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.jIx.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.jIe) && adCardBaseView.jIe.equals(downloadData.getId())) {
                adCardBaseView.jIa.t(downloadData);
            }
        }
    }

    /* loaded from: classes13.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> jIx;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.jIx = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.jIx.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                String str = null;
                if (adCardBaseView.jIf != null && adCardBaseView.jIf.getAdvertAppInfo() != null) {
                    str = adCardBaseView.jIf.getAdvertAppInfo().cMW;
                }
                com.baidu.tieba.recapp.s.b(adCardBaseView.cVh, adCardBaseView.jIk.scheme, str);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void ccl() {
        if (4 == getBusinessType()) {
            this.hRh.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.jHo != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.jIk = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.cVh.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.cVh, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        return true;
    }

    private void a(View view, TextView textView, ApkDownloadView apkDownloadView, AdCard adCard) {
        if (adCard == null) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        if (adCard.getAdvertAppInfo().aAq()) {
            textView.setVisibility(8);
            apkDownloadView.setVisibility(0);
        } else if (k.isEmpty(adCard.buttonText)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.cMZ);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.cMX);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.cMW, 0));
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
