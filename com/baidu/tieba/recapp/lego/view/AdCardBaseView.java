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
/* loaded from: classes13.dex */
public abstract class AdCardBaseView extends BaseLegoCardView<AdCard> implements com.baidu.tieba.lego.card.b.a {
    private DownloadCacheKey dZC;
    private com.baidu.tieba.ad.download.a.d dZD;
    protected View fKI;
    protected View fLf;
    protected TextView hST;
    private a.C0547a hYR;
    private final int iax;
    private final int jJA;
    private final int jJB;
    private final int jJC;
    private final int jJD;
    private int jJE;
    private int jJF;
    private int jJG;
    protected TextView jJH;
    protected TextView jJI;
    private AdCloseView jJJ;
    private LinearLayout jJK;
    protected ApkDownloadView jJL;
    protected TextView jJM;
    protected RelativeLayout jJN;
    protected View jJO;
    protected String jJP;
    private AdCard jJQ;
    private AdThreadCommentAndPraiseInfoLayout jJR;
    protected AdThreadUserInfoLayout jJS;
    protected View jJT;
    protected View jJU;
    protected AdCard.b jJV;
    private FrameLayout jJW;
    protected CustomMessageListener jJX;
    protected CustomMessageListener jJY;
    protected CustomMessageListener jJZ;
    protected ViewStub jJp;
    protected View jJq;
    protected View jJr;
    protected final int jJs;
    protected final int jJt;
    protected final int jJu;
    protected final int jJv;
    protected final int jJw;
    protected final int jJx;
    protected final int jJy;
    protected final int jJz;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void cO(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iax = l.getEquipmentWidth(getContext());
        this.dZD = null;
        this.jJX = new a(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG, this);
        this.jJY = new d(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG, this);
        this.jJZ = new c(CmdConfigCustom.CMD_USER_INFO_CHANGED, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.ds640);
        this.mImageHeight = (int) resources.getDimension(R.dimen.ds278);
        this.jJs = (int) resources.getDimension(R.dimen.tbds92);
        this.jJt = (int) resources.getDimension(R.dimen.tbds92);
        this.jJu = (int) resources.getDimension(R.dimen.tbds20);
        this.jJx = (int) resources.getDimension(R.dimen.tbds90);
        this.jJy = (int) resources.getDimension(R.dimen.tbds90);
        this.jJz = (int) resources.getDimension(R.dimen.tbds22);
        this.jJv = (int) resources.getDimension(R.dimen.tbds44);
        this.jJw = (int) resources.getDimension(R.dimen.tbds44);
        this.jJE = (int) resources.getDimension(R.dimen.ds12);
        this.jJF = (int) resources.getDimension(R.dimen.ds1);
        this.jJG = (int) resources.getDimension(R.dimen.ds18);
        this.jJA = (int) resources.getDimension(R.dimen.tbds208);
        this.jJB = (int) resources.getDimension(R.dimen.tbds33);
        this.jJC = (int) resources.getDimension(R.dimen.tbds72);
        this.jJD = (int) resources.getDimension(R.dimen.tbds48);
    }

    protected void x(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.jJR.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ccz() {
        MessageManager.getInstance().registerListener(this.jJX);
        MessageManager.getInstance().registerListener(this.jJY);
        MessageManager.getInstance().registerListener(this.jJZ);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.fLf = this.mRootView.findViewById(R.id.bottom_line);
        this.jJr = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.jJr.setClickable(true);
        this.hST = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.jJH = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.jJL = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.jJM = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.jJN = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.jJL.u(this.cVv.getUniqueId());
        this.jJX.setTag(this.cVv.getUniqueId());
        this.jJO = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.jJY.setTag(this.cVv.getUniqueId());
        this.jJZ.setTag(this.cVv.getUniqueId());
        this.jJR = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.jJR.setStyle(1);
        this.jJS = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        this.jJW = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        if (1 == getBusinessType()) {
            this.jJS.setShowFlag(1413);
        }
        this.jJK = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.jJJ = (AdCloseView) this.jJK.findViewById(R.id.ad_close_view);
        this.jJI = (TextView) this.jJK.findViewById(R.id.feed_tag);
        this.jJI.setVisibility(8);
        this.jJR.addAdMoreView(this.jJK);
        this.fKI = this.mRootView.findViewById(R.id.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.jJv) - this.jJw) - this.jJs) - this.jJu;
            this.jJR.setVisibility(8);
        } else {
            this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.jJv) - this.jJw;
            this.jJR.setVisibility(0);
        }
        this.jJp = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.jJp.setLayoutResource(getCustomLayout());
        this.jJq = this.jJp.inflate();
        this.jJT = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.jJU = this.mRootView.findViewById(R.id.frs_bottom_view);
        cO(this.jJq);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(final AdCard adCard) {
        final String str;
        int i;
        this.jJQ = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.jJS.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.aJm() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.cVv.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        a(adCard, bVar);
        this.jJH.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jJO.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.jJs + this.jJu;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.jJS.getHeaderImg(), adCard.portraitClick, bVar);
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String HQ = HQ(str2);
            this.hST.setMaxLines(adCard.titleLines <= 0 ? 4 : adCard.titleLines);
            if (4 == getBusinessType()) {
                this.hST.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize42));
            } else {
                this.hST.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize44));
            }
            this.hST.setText(HQ);
            this.hST.setVisibility(0);
        } else {
            this.hST.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.aAu()) && k.isEmpty(str3);
        a(this.jJN, this.jJH, this.jJL, adCard);
        int i2 = (this.mMaxWidth - this.jJA) - this.jJD;
        if (4 == getBusinessType()) {
            this.jJM.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize30));
            i = i2 - (this.jJB + this.jJC);
        } else {
            i = i2;
        }
        String str4 = null;
        if (advertAppInfo != null && advertAppInfo.aAt()) {
            str4 = adCard.userName.concat("APP");
        } else if (advertAppInfo != null && advertAppInfo.aAu()) {
            str4 = TextUtils.isEmpty(adCard.userName) ? "广告" : adCard.userName;
        }
        this.jJM.setText(com.baidu.c.a.e.a.a(str4, "广告", i, this.jJM.getPaint()));
        if (advertAppInfo != null && advertAppInfo.aAt()) {
            this.jJP = advertAppInfo.cNn;
            this.jJL.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            a(adCard, c2);
            a(this.jJH, c2.getStatus(), str3);
            this.jJL.setData(c2);
            this.jJL.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    am.setViewTextColor(this.jJH, R.color.cp_link_tip_a, 1);
                    am.setBackgroundResource(this.jJH, R.drawable.ad_download_progress_button_bg);
                    this.jJH.setText(str3);
                    if (k.isEmpty(str)) {
                        this.jJH.setClickable(false);
                    } else {
                        this.jJH.setClickable(true);
                        this.jJH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.iaq != null && adCard.buttonClick != null && !t.IU(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.iaq.b(adCard.buttonClick.Tw, adCard.buttonClick.Tx, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int b2 = s.b(AdCardBaseView.this.cVv, str, (AdCardBaseView.this.jJQ == null || AdCardBaseView.this.jJQ.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.jJQ.getAdvertAppInfo().cNk);
                                        if ((b2 == 1 || b2 == 2) && AdCardBaseView.this.iaq != null) {
                                            AdCardBaseView.this.iaq.b(b2, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.cVv.getPageActivity());
                                    aVar.sR(adCard.popWindowText);
                                    aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int b3 = s.b(AdCardBaseView.this.cVv, str, (AdCardBaseView.this.jJQ == null || AdCardBaseView.this.jJQ.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.jJQ.getAdvertAppInfo().cNk);
                                            if ((b3 == 1 || b3 == 2) && AdCardBaseView.this.iaq != null) {
                                                AdCardBaseView.this.iaq.b(b3, null);
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
                                    aVar.b(AdCardBaseView.this.cVv).aEG();
                                }
                            }
                        });
                    }
                } else {
                    this.jJH.setClickable(false);
                    this.jJH.setText(adCard.buttonTextDone);
                    am.setBackgroundResource(this.jJH, R.drawable.ad_download_progress_button_bg);
                    am.setViewTextColor(this.jJH, R.color.cp_btn_a, 1);
                }
            }
            this.jJL.setVisibility(8);
        }
        a(adCard);
        x(i.azR().isShowImages(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            HR(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.cNt != null && advertAppInfo.cNt.adCloseInfo != null && advertAppInfo.cNt.adCloseInfo.support_close.intValue() > 0) {
            this.jJJ.setVisibility(0);
            this.jJJ.setPage(getBusinessType());
            this.jJJ.setData(advertAppInfo);
            l.addToParentArea(this.cVv.getPageActivity(), this.jJK, 40, 40, 40, 120);
            this.jJK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.jJJ.performClick();
                }
            });
        } else {
            this.jJJ.setVisibility(8);
            this.jJI.setOnClickListener(null);
        }
        this.jJR.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.fLf.getLayoutParams();
        if (4 == getBusinessType()) {
            this.jJR.setVisibility(8);
            this.jJR.setBarNameClickEnabled(false);
            this.jJR.setShareVisible(false);
            this.jJR.setShowPraiseNum(false);
            this.jJR.setCommentNumEnable(false);
            this.jJR.setReplyTimeVisible(false);
            layoutParams2.height = this.jJF;
            this.jJT.setVisibility(0);
            this.jJU.setVisibility(8);
            this.fLf.setVisibility(8);
            cP(this.jJK);
        } else {
            b(adCard, bVar);
            this.fLf.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.jJL.getLayoutParams()).addRule(11, -1);
            ((RelativeLayout.LayoutParams) this.jJH.getLayoutParams()).addRule(11, -1);
            this.jJW.setVisibility(8);
            this.jJN.requestLayout();
        }
        a(adCard, this.fKI, getBusinessType());
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 instanceof AdvertAppInfo) {
            advertAppInfo2.sC(aq.bD(adCard.time));
        }
        this.jJS.setData(advertAppInfo2);
        ((TextView) this.jJS.getUserName()).setText(adCard.userName);
        this.jJS.getUserName().setOnClickListener(bVar);
        this.jJS.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.jJS.getUserName()).setText(adCard.userName);
            }
        });
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bDd().bDe()) {
            this.jJr.setVisibility(0);
            am.setBackgroundColor(this.jJr, R.color.cp_bg_line_d);
        } else {
            this.jJr.setVisibility(8);
        }
        a(adCard, advertAppInfo);
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private void cP(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((FrameLayout) view.getParent()).removeView(view);
            }
            this.jJW.setVisibility(0);
            this.jJW.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.jJW.addView(view);
            int dimension = (int) getResources().getDimension(R.dimen.tbds26);
            int dimension2 = (int) getResources().getDimension(R.dimen.tbds33);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jJL.getLayoutParams();
            layoutParams.setMargins(0, dimension, dimension2, dimension);
            layoutParams.addRule(11, 0);
            layoutParams.addRule(0, this.jJW.getId());
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jJH.getLayoutParams();
            layoutParams2.addRule(11, 0);
            layoutParams2.setMargins(0, dimension, dimension2, dimension);
            layoutParams2.addRule(0, this.jJW.getId());
            this.jJN.requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aYj();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aYk();
    }

    private void a(AdCard adCard, DownloadData downloadData) {
        if (adCard.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.jJL.getDownloadStatus());
        }
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.directDownload) {
            this.jJL.setOnClickListener(bVar);
        } else {
            this.jJL.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public void bp(View view) {
                    AdCardBaseView.this.cDi();
                }
            });
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey xc;
        if (!adCard.directDownload && advertAppInfo != null && advertAppInfo.aAt()) {
            String scheme = adCard.getScheme();
            String str = advertAppInfo.cNk;
            if (!TextUtils.isEmpty(str)) {
                xc = com.baidu.tieba.ad.download.d.aYp().xb(str);
            } else {
                xc = com.baidu.tieba.ad.download.d.aYp().xc(scheme);
            }
            if (xc == null) {
                xc = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.cNn);
                com.baidu.tieba.ad.download.d.aYp().a(xc, null);
            }
            i(xc);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.dZC = downloadCacheKey;
            aYk();
            this.dZD = null;
            AdDownloadData d2 = com.baidu.tieba.ad.download.d.aYp().d(downloadCacheKey);
            if (d2 != null) {
                this.jJL.a(d2.getCurrentState());
            } else {
                this.jJL.a(DownloadStatus.STATUS_NONE);
            }
            String str = "";
            if (this.jJQ != null && this.jJQ.getAdvertAppInfo() != null) {
                str = this.jJQ.getAdvertAppInfo().page;
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.jJL, d2, str);
            this.dZD = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d2.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d2);
            }
            aYj();
        }
    }

    private void aYj() {
        if (this.dZC != null && this.dZD != null) {
            com.baidu.tieba.ad.download.d.aYp().a(this.dZC, this.dZD);
        }
    }

    private void aYk() {
        if (this.dZC != null && this.dZD != null) {
            com.baidu.tieba.ad.download.d.aYp().b(this.dZC, this.dZD);
        }
    }

    private boolean isInFrsAllThread() {
        return this.hZu == 1;
    }

    private void b(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.jJU.setVisibility(0);
            this.jJR.setVisibility(8);
            return;
        }
        this.jJU.setVisibility(8);
        this.jJR.setVisibility(0);
        this.jJR.setBarNameClickEnabled(false);
        this.jJR.setReplyTimeVisible(false);
        this.jJR.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.jJR.setAgreeClickable(true);
            this.jJR.setPraiseContainerBgGray(false);
        } else {
            this.jJR.setAgreeClickable(false);
            this.jJR.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.jJR.setShareClickable(true);
            this.jJR.setShareContainerBgGray(false);
        } else {
            this.jJR.setShareClickable(false);
            this.jJR.setShareContainerBgGray(true);
        }
        if (this.jJR.getCommentContainer() != null) {
            this.jJR.getCommentContainer().setOnClickListener(bVar);
        }
        this.jJR.setNeedAddReplyIcon(true);
        this.jJR.setCommentNumEnable(false);
        this.jJR.setCommentClickable(true);
        this.jJR.setReplayContainerBgGray(true);
        this.jJR.setOnClickListener(bVar);
        this.jJR.setShareData(adCard);
        this.jJR.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        am.setBackgroundResource(this.fLf, R.color.cp_bg_line_b);
        this.jJJ.onChangeSkinType();
        this.jJS.onChangeSkinType(this.cVv, TbadkCoreApplication.getInst().getSkinType());
        this.jJR.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.fKI, R.color.cp_bg_line_e);
        } else {
            am.setBackgroundColor(this.fKI, R.color.transparent);
        }
        am.setViewTextColor(this.hST, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.jJM, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.jJI, R.color.cp_cont_d, 1);
        this.jJL.onChangeSkinType(i);
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
            if (b(bVar) && !t.IU(bVar.scheme)) {
                if (this.iaq != null) {
                    this.iaq.b(bVar.Tw, bVar.Tx, null);
                }
            } else if (this.jJQ != null && this.jJQ.getAdvertAppInfo() != null) {
                String HS = HS(bVar.scheme);
                String str = this.jJQ.getAdvertAppInfo().cNk;
                if (!this.jJQ.directDownload && this.jJQ.getAdvertAppInfo().aAt()) {
                    b2 = s.c(this.cVv, HS, str);
                } else {
                    b2 = s.b(this.cVv, HS, str);
                }
                if (b2 == 1 || b2 == 2) {
                    if (this.iaq != null) {
                        this.iaq.b(b2, null);
                    }
                } else if (this.iaq != null) {
                    this.iaq.b(bVar.Tw, bVar.Tx, null);
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
                        if (AdCardBaseView.this.jJQ.hasAnimation()) {
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
        this.hYR = new a.C0547a();
        this.hYR.picUrl = tbImageView.getUrl();
        this.hYR.rect = rect;
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
                    com.baidu.adp.lib.e.c.gr().a(jSONObject.optString("pic_url"), 17, null, this.iax, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.iax), this.cVv.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.aAs() != 0) {
                l.showToast(this.cVv.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.cVv.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.cVv.getPageActivity()) && this.iar != null) {
                this.iar.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.cVv.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aAt()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.cVv.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVv.getPageActivity());
                aVar.sR(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.jJL);
                        if (AdCardBaseView.this.jJL != null) {
                            AdCardBaseView.this.jJL.q(AdCardBaseView.this.c(advertAppInfo, i));
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
                aVar.b(this.cVv).aEG();
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
                    a(advertAppInfo, i, this.jJL);
                    apkDownloadView.s(c2);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.aYp().aN(this.cVv.getPageActivity(), advertAppInfo.cNn);
                    return;
            }
            h.bd(this.cVv.getPageActivity(), advertAppInfo.cNn);
        }
    }

    public a.C0547a getAnimationInfo() {
        return this.hYR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class b implements View.OnClickListener {
        private AdCard jKj;

        public b(AdCard adCard) {
            this.jKj = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdCardBaseView.this.cVv.showToast(R.string.neterror);
            } else if (this.jKj != null) {
                AdvertAppInfo advertAppInfo = this.jKj.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.jJL;
                if (advertAppInfo != null && advertAppInfo.aAt()) {
                    a(advertAppInfo, z);
                } else {
                    i(advertAppInfo);
                }
            }
        }

        private void a(AdvertAppInfo advertAppInfo, boolean z) {
            if (this.jKj.directDownload || z) {
                b(advertAppInfo, z);
            } else {
                j(advertAppInfo);
            }
        }

        private void i(AdvertAppInfo advertAppInfo) {
            String scheme = this.jKj.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.cNm;
            }
            if (this.jKj.hasAnimation()) {
            }
            int e = s.e(AdCardBaseView.this.cVv, AdCardBaseView.this.HS(scheme));
            if (AdCardBaseView.this.iaq != null) {
                AdCardBaseView.this.iaq.b(e, null);
            }
        }

        private void b(AdvertAppInfo advertAppInfo, boolean z) {
            int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
            int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, i));
            if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                return;
            }
            AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.jJL, z);
            AdCardBaseView.this.cDi();
        }

        private void j(AdvertAppInfo advertAppInfo) {
            String scheme = this.jKj.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.cNm;
            }
            int c = s.c(AdCardBaseView.this.cVv, scheme, advertAppInfo.cNk);
            if (AdCardBaseView.this.iaq != null) {
                AdCardBaseView.this.iaq.b(c, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cDi() {
        if (this.iaq != null) {
            this.iaq.b(3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String HS(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.hYR != null && this.hYR.isValid()) {
            String c0547a = this.hYR.toString();
            if (!TextUtils.isEmpty(c0547a)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(c0547a));
            }
        }
        if (!TextUtils.isEmpty(this.jJQ.getPreLoadData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.jJQ.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.jJQ.getNextPageData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.jJQ.getNextPageData()));
        }
        if (this.jJQ.hasAnimation()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.jJQ.isGoLandingPage()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.jJQ.isImmersiveStyle()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes13.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> jKi;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.jKi = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.jKi.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.jJP) ? false : true)) && adCardBaseView.jJP.equals(downloadData.getId())) {
                    int status = e.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.jJH.setText(R.string.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.jJH.setText(R.string.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> jKi;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.jKi = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.jKi.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.jJP) && adCardBaseView.jJP.equals(downloadData.getId())) {
                adCardBaseView.jJL.t(downloadData);
            }
        }
    }

    /* loaded from: classes13.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> jKi;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.jKi = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.jKi.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                String str = null;
                if (adCardBaseView.jJQ != null && adCardBaseView.jJQ.getAdvertAppInfo() != null) {
                    str = adCardBaseView.jJQ.getAdvertAppInfo().cNk;
                }
                s.b(adCardBaseView.cVv, adCardBaseView.jJV.scheme, str);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void ccF() {
        if (4 == getBusinessType()) {
            this.hST.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.jIZ != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.jJV = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.cVv.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.cVv, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        return true;
    }

    private void a(View view, TextView textView, ApkDownloadView apkDownloadView, AdCard adCard) {
        if (adCard == null) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        if (adCard.getAdvertAppInfo().aAt()) {
            textView.setVisibility(8);
            apkDownloadView.setVisibility(0);
        } else if (k.isEmpty(adCard.buttonText)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.cNn);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.cNl);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.cNk, 0));
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
