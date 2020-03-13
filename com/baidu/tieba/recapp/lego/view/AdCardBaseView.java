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
    private DownloadCacheKey dZm;
    private com.baidu.tieba.ad.download.a.d dZn;
    protected View fKa;
    protected View fKx;
    protected TextView hRt;
    private a.C0546a hXr;
    private final int hYX;
    protected ViewStub jHQ;
    protected View jHR;
    protected View jHS;
    protected final int jHT;
    protected final int jHU;
    protected final int jHV;
    protected final int jHW;
    protected final int jHX;
    protected final int jHY;
    protected final int jHZ;
    protected CustomMessageListener jIA;
    protected final int jIa;
    private final int jIb;
    private final int jIc;
    private final int jId;
    private final int jIe;
    private int jIf;
    private int jIg;
    private int jIh;
    protected TextView jIi;
    protected TextView jIj;
    private AdCloseView jIk;
    private LinearLayout jIl;
    protected ApkDownloadView jIm;
    protected TextView jIn;
    protected RelativeLayout jIo;
    protected View jIp;
    protected String jIq;
    private AdCard jIr;
    private AdThreadCommentAndPraiseInfoLayout jIs;
    protected AdThreadUserInfoLayout jIt;
    protected View jIu;
    protected View jIv;
    protected AdCard.b jIw;
    private FrameLayout jIx;
    protected CustomMessageListener jIy;
    protected CustomMessageListener jIz;
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
        this.hYX = l.getEquipmentWidth(getContext());
        this.dZn = null;
        this.jIy = new a(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG, this);
        this.jIz = new d(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG, this);
        this.jIA = new c(CmdConfigCustom.CMD_USER_INFO_CHANGED, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.ds640);
        this.mImageHeight = (int) resources.getDimension(R.dimen.ds278);
        this.jHT = (int) resources.getDimension(R.dimen.tbds92);
        this.jHU = (int) resources.getDimension(R.dimen.tbds92);
        this.jHV = (int) resources.getDimension(R.dimen.tbds20);
        this.jHY = (int) resources.getDimension(R.dimen.tbds90);
        this.jHZ = (int) resources.getDimension(R.dimen.tbds90);
        this.jIa = (int) resources.getDimension(R.dimen.tbds22);
        this.jHW = (int) resources.getDimension(R.dimen.tbds44);
        this.jHX = (int) resources.getDimension(R.dimen.tbds44);
        this.jIf = (int) resources.getDimension(R.dimen.ds12);
        this.jIg = (int) resources.getDimension(R.dimen.ds1);
        this.jIh = (int) resources.getDimension(R.dimen.ds18);
        this.jIb = (int) resources.getDimension(R.dimen.tbds208);
        this.jIc = (int) resources.getDimension(R.dimen.tbds33);
        this.jId = (int) resources.getDimension(R.dimen.tbds72);
        this.jIe = (int) resources.getDimension(R.dimen.tbds48);
    }

    protected void x(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.jIs.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ccg() {
        MessageManager.getInstance().registerListener(this.jIy);
        MessageManager.getInstance().registerListener(this.jIz);
        MessageManager.getInstance().registerListener(this.jIA);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.fKx = this.mRootView.findViewById(R.id.bottom_line);
        this.jHS = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.jHS.setClickable(true);
        this.hRt = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.jIi = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.jIm = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.jIn = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.jIo = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.jIm.u(this.cVi.getUniqueId());
        this.jIy.setTag(this.cVi.getUniqueId());
        this.jIp = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.jIz.setTag(this.cVi.getUniqueId());
        this.jIA.setTag(this.cVi.getUniqueId());
        this.jIs = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.jIs.setStyle(1);
        this.jIt = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        this.jIx = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        if (1 == getBusinessType()) {
            this.jIt.setShowFlag(1413);
        }
        this.jIl = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.jIk = (AdCloseView) this.jIl.findViewById(R.id.ad_close_view);
        this.jIj = (TextView) this.jIl.findViewById(R.id.feed_tag);
        this.jIj.setVisibility(8);
        this.jIs.addAdMoreView(this.jIl);
        this.fKa = this.mRootView.findViewById(R.id.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.jHW) - this.jHX) - this.jHT) - this.jHV;
            this.jIs.setVisibility(8);
        } else {
            this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.jHW) - this.jHX;
            this.jIs.setVisibility(0);
        }
        this.jHQ = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.jHQ.setLayoutResource(getCustomLayout());
        this.jHR = this.jHQ.inflate();
        this.jIu = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.jIv = this.mRootView.findViewById(R.id.frs_bottom_view);
        cO(this.jHR);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(final AdCard adCard) {
        final String str;
        int i;
        this.jIr = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.jIt.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.aJi() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.cVi.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        a(adCard, bVar);
        this.jIi.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jIp.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.jHT + this.jHV;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.jIt.getHeaderImg(), adCard.portraitClick, bVar);
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String HR = HR(str2);
            this.hRt.setMaxLines(adCard.titleLines <= 0 ? 4 : adCard.titleLines);
            if (4 == getBusinessType()) {
                this.hRt.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize42));
            } else {
                this.hRt.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize44));
            }
            this.hRt.setText(HR);
            this.hRt.setVisibility(0);
        } else {
            this.hRt.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.aAr()) && k.isEmpty(str3);
        a(this.jIo, this.jIi, this.jIm, adCard);
        int i2 = (this.mMaxWidth - this.jIb) - this.jIe;
        if (4 == getBusinessType()) {
            this.jIn.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize30));
            i = i2 - (this.jIc + this.jId);
        } else {
            i = i2;
        }
        String str4 = null;
        if (advertAppInfo != null && advertAppInfo.aAq()) {
            str4 = adCard.userName.concat("APP");
        } else if (advertAppInfo != null && advertAppInfo.aAr()) {
            str4 = TextUtils.isEmpty(adCard.userName) ? "广告" : adCard.userName;
        }
        this.jIn.setText(com.baidu.c.a.e.a.a(str4, "广告", i, this.jIn.getPaint()));
        if (advertAppInfo != null && advertAppInfo.aAq()) {
            this.jIq = advertAppInfo.cNa;
            this.jIm.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            a(adCard, c2);
            a(this.jIi, c2.getStatus(), str3);
            this.jIm.setData(c2);
            this.jIm.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    am.setViewTextColor(this.jIi, R.color.cp_link_tip_a, 1);
                    am.setBackgroundResource(this.jIi, R.drawable.ad_download_progress_button_bg);
                    this.jIi.setText(str3);
                    if (k.isEmpty(str)) {
                        this.jIi.setClickable(false);
                    } else {
                        this.jIi.setClickable(true);
                        this.jIi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.hYQ != null && adCard.buttonClick != null && !s.IV(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.hYQ.b(adCard.buttonClick.Tm, adCard.buttonClick.Tn, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int b2 = com.baidu.tieba.recapp.s.b(AdCardBaseView.this.cVi, str, (AdCardBaseView.this.jIr == null || AdCardBaseView.this.jIr.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.jIr.getAdvertAppInfo().cMX);
                                        if ((b2 == 1 || b2 == 2) && AdCardBaseView.this.hYQ != null) {
                                            AdCardBaseView.this.hYQ.b(b2, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.cVi.getPageActivity());
                                    aVar.sS(adCard.popWindowText);
                                    aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int b3 = com.baidu.tieba.recapp.s.b(AdCardBaseView.this.cVi, str, (AdCardBaseView.this.jIr == null || AdCardBaseView.this.jIr.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.jIr.getAdvertAppInfo().cMX);
                                            if ((b3 == 1 || b3 == 2) && AdCardBaseView.this.hYQ != null) {
                                                AdCardBaseView.this.hYQ.b(b3, null);
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
                                    aVar.b(AdCardBaseView.this.cVi).aEC();
                                }
                            }
                        });
                    }
                } else {
                    this.jIi.setClickable(false);
                    this.jIi.setText(adCard.buttonTextDone);
                    am.setBackgroundResource(this.jIi, R.drawable.ad_download_progress_button_bg);
                    am.setViewTextColor(this.jIi, R.color.cp_btn_a, 1);
                }
            }
            this.jIm.setVisibility(8);
        }
        a(adCard);
        x(i.azO().isShowImages(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            HS(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.cNg != null && advertAppInfo.cNg.adCloseInfo != null && advertAppInfo.cNg.adCloseInfo.support_close.intValue() > 0) {
            this.jIk.setVisibility(0);
            this.jIk.setPage(getBusinessType());
            this.jIk.setData(advertAppInfo);
            l.addToParentArea(this.cVi.getPageActivity(), this.jIl, 40, 40, 40, 120);
            this.jIl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.jIk.performClick();
                }
            });
        } else {
            this.jIk.setVisibility(8);
            this.jIj.setOnClickListener(null);
        }
        this.jIs.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.fKx.getLayoutParams();
        if (4 == getBusinessType()) {
            this.jIs.setVisibility(8);
            this.jIs.setBarNameClickEnabled(false);
            this.jIs.setShareVisible(false);
            this.jIs.setShowPraiseNum(false);
            this.jIs.setCommentNumEnable(false);
            this.jIs.setReplyTimeVisible(false);
            layoutParams2.height = this.jIg;
            this.jIu.setVisibility(0);
            this.jIv.setVisibility(8);
            this.fKx.setVisibility(8);
            cP(this.jIl);
        } else {
            b(adCard, bVar);
            this.fKx.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.jIm.getLayoutParams()).addRule(11, -1);
            ((RelativeLayout.LayoutParams) this.jIi.getLayoutParams()).addRule(11, -1);
            this.jIx.setVisibility(8);
            this.jIo.requestLayout();
        }
        a(adCard, this.fKa, getBusinessType());
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 instanceof AdvertAppInfo) {
            advertAppInfo2.sD(aq.bD(adCard.time));
        }
        this.jIt.setData(advertAppInfo2);
        ((TextView) this.jIt.getUserName()).setText(adCard.userName);
        this.jIt.getUserName().setOnClickListener(bVar);
        this.jIt.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.jIt.getUserName()).setText(adCard.userName);
            }
        });
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bCW().bCX()) {
            this.jHS.setVisibility(0);
            am.setBackgroundColor(this.jHS, R.color.cp_bg_line_d);
        } else {
            this.jHS.setVisibility(8);
        }
        a(adCard, advertAppInfo);
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private void cP(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((FrameLayout) view.getParent()).removeView(view);
            }
            this.jIx.setVisibility(0);
            this.jIx.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.jIx.addView(view);
            int dimension = (int) getResources().getDimension(R.dimen.tbds26);
            int dimension2 = (int) getResources().getDimension(R.dimen.tbds33);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jIm.getLayoutParams();
            layoutParams.setMargins(0, dimension, dimension2, dimension);
            layoutParams.addRule(11, 0);
            layoutParams.addRule(0, this.jIx.getId());
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jIi.getLayoutParams();
            layoutParams2.addRule(11, 0);
            layoutParams2.setMargins(0, dimension, dimension2, dimension);
            layoutParams2.addRule(0, this.jIx.getId());
            this.jIo.requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aYf();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aYg();
    }

    private void a(AdCard adCard, DownloadData downloadData) {
        if (adCard.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.jIm.getDownloadStatus());
        }
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.directDownload) {
            this.jIm.setOnClickListener(bVar);
        } else {
            this.jIm.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public void bp(View view) {
                    AdCardBaseView.this.cCO();
                }
            });
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey xc;
        if (!adCard.directDownload && advertAppInfo != null && advertAppInfo.aAq()) {
            String scheme = adCard.getScheme();
            String str = advertAppInfo.cMX;
            if (!TextUtils.isEmpty(str)) {
                xc = com.baidu.tieba.ad.download.d.aYl().xb(str);
            } else {
                xc = com.baidu.tieba.ad.download.d.aYl().xc(scheme);
            }
            if (xc == null) {
                xc = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.cNa);
                com.baidu.tieba.ad.download.d.aYl().a(xc, null);
            }
            i(xc);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.dZm = downloadCacheKey;
            aYg();
            this.dZn = null;
            AdDownloadData d2 = com.baidu.tieba.ad.download.d.aYl().d(downloadCacheKey);
            if (d2 != null) {
                this.jIm.a(d2.getCurrentState());
            } else {
                this.jIm.a(DownloadStatus.STATUS_NONE);
            }
            String str = "";
            if (this.jIr != null && this.jIr.getAdvertAppInfo() != null) {
                str = this.jIr.getAdvertAppInfo().page;
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.jIm, d2, str);
            this.dZn = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d2.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d2);
            }
            aYf();
        }
    }

    private void aYf() {
        if (this.dZm != null && this.dZn != null) {
            com.baidu.tieba.ad.download.d.aYl().a(this.dZm, this.dZn);
        }
    }

    private void aYg() {
        if (this.dZm != null && this.dZn != null) {
            com.baidu.tieba.ad.download.d.aYl().b(this.dZm, this.dZn);
        }
    }

    private boolean isInFrsAllThread() {
        return this.hXU == 1;
    }

    private void b(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.jIv.setVisibility(0);
            this.jIs.setVisibility(8);
            return;
        }
        this.jIv.setVisibility(8);
        this.jIs.setVisibility(0);
        this.jIs.setBarNameClickEnabled(false);
        this.jIs.setReplyTimeVisible(false);
        this.jIs.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.jIs.setAgreeClickable(true);
            this.jIs.setPraiseContainerBgGray(false);
        } else {
            this.jIs.setAgreeClickable(false);
            this.jIs.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.jIs.setShareClickable(true);
            this.jIs.setShareContainerBgGray(false);
        } else {
            this.jIs.setShareClickable(false);
            this.jIs.setShareContainerBgGray(true);
        }
        if (this.jIs.getCommentContainer() != null) {
            this.jIs.getCommentContainer().setOnClickListener(bVar);
        }
        this.jIs.setNeedAddReplyIcon(true);
        this.jIs.setCommentNumEnable(false);
        this.jIs.setCommentClickable(true);
        this.jIs.setReplayContainerBgGray(true);
        this.jIs.setOnClickListener(bVar);
        this.jIs.setShareData(adCard);
        this.jIs.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        am.setBackgroundResource(this.fKx, R.color.cp_bg_line_b);
        this.jIk.onChangeSkinType();
        this.jIt.onChangeSkinType(this.cVi, TbadkCoreApplication.getInst().getSkinType());
        this.jIs.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.fKa, R.color.cp_bg_line_e);
        } else {
            am.setBackgroundColor(this.fKa, R.color.transparent);
        }
        am.setViewTextColor(this.hRt, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.jIn, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.jIj, R.color.cp_cont_d, 1);
        this.jIm.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String HR(String str) {
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
            if (b(bVar) && !s.IV(bVar.scheme)) {
                if (this.hYQ != null) {
                    this.hYQ.b(bVar.Tm, bVar.Tn, null);
                }
            } else if (this.jIr != null && this.jIr.getAdvertAppInfo() != null) {
                String HT = HT(bVar.scheme);
                String str = this.jIr.getAdvertAppInfo().cMX;
                if (!this.jIr.directDownload && this.jIr.getAdvertAppInfo().aAq()) {
                    b2 = com.baidu.tieba.recapp.s.c(this.cVi, HT, str);
                } else {
                    b2 = com.baidu.tieba.recapp.s.b(this.cVi, HT, str);
                }
                if (b2 == 1 || b2 == 2) {
                    if (this.hYQ != null) {
                        this.hYQ.b(b2, null);
                    }
                } else if (this.hYQ != null) {
                    this.hYQ.b(bVar.Tm, bVar.Tn, null);
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
                        if (AdCardBaseView.this.jIr.hasAnimation()) {
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
        this.hXr = new a.C0546a();
        this.hXr.picUrl = tbImageView.getUrl();
        this.hXr.rect = rect;
    }

    private void HS(String str) {
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
                    com.baidu.adp.lib.e.c.gr().a(jSONObject.optString("pic_url"), 17, null, this.hYX, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.hYX), this.cVi.getUniqueId(), new Object[0]);
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
                l.showToast(this.cVi.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.cVi.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.cVi.getPageActivity()) && this.hYR != null) {
                this.hYR.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.cVi.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aAq()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.cVi.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cVi.getPageActivity());
                aVar.sS(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.jIm);
                        if (AdCardBaseView.this.jIm != null) {
                            AdCardBaseView.this.jIm.q(AdCardBaseView.this.c(advertAppInfo, i));
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
                aVar.b(this.cVi).aEC();
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
                    a(advertAppInfo, i, this.jIm);
                    apkDownloadView.s(c2);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.aYl().aN(this.cVi.getPageActivity(), advertAppInfo.cNa);
                    return;
            }
            h.bd(this.cVi.getPageActivity(), advertAppInfo.cNa);
        }
    }

    public a.C0546a getAnimationInfo() {
        return this.hXr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class b implements View.OnClickListener {
        private AdCard jIK;

        public b(AdCard adCard) {
            this.jIK = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdCardBaseView.this.cVi.showToast(R.string.neterror);
            } else if (this.jIK != null) {
                AdvertAppInfo advertAppInfo = this.jIK.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.jIm;
                if (advertAppInfo != null && advertAppInfo.aAq()) {
                    a(advertAppInfo, z);
                } else {
                    i(advertAppInfo);
                }
            }
        }

        private void a(AdvertAppInfo advertAppInfo, boolean z) {
            if (this.jIK.directDownload || z) {
                b(advertAppInfo, z);
            } else {
                j(advertAppInfo);
            }
        }

        private void i(AdvertAppInfo advertAppInfo) {
            String scheme = this.jIK.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.cMZ;
            }
            if (this.jIK.hasAnimation()) {
            }
            int e = com.baidu.tieba.recapp.s.e(AdCardBaseView.this.cVi, AdCardBaseView.this.HT(scheme));
            if (AdCardBaseView.this.hYQ != null) {
                AdCardBaseView.this.hYQ.b(e, null);
            }
        }

        private void b(AdvertAppInfo advertAppInfo, boolean z) {
            int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
            int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, i));
            if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                return;
            }
            AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.jIm, z);
            AdCardBaseView.this.cCO();
        }

        private void j(AdvertAppInfo advertAppInfo) {
            String scheme = this.jIK.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.cMZ;
            }
            int c = com.baidu.tieba.recapp.s.c(AdCardBaseView.this.cVi, scheme, advertAppInfo.cMX);
            if (AdCardBaseView.this.hYQ != null) {
                AdCardBaseView.this.hYQ.b(c, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cCO() {
        if (this.hYQ != null) {
            this.hYQ.b(3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String HT(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.hXr != null && this.hXr.isValid()) {
            String c0546a = this.hXr.toString();
            if (!TextUtils.isEmpty(c0546a)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(c0546a));
            }
        }
        if (!TextUtils.isEmpty(this.jIr.getPreLoadData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.jIr.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.jIr.getNextPageData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.jIr.getNextPageData()));
        }
        if (this.jIr.hasAnimation()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.jIr.isGoLandingPage()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.jIr.isImmersiveStyle()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes13.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> jIJ;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.jIJ = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.jIJ.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.jIq) ? false : true)) && adCardBaseView.jIq.equals(downloadData.getId())) {
                    int status = e.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.jIi.setText(R.string.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.jIi.setText(R.string.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> jIJ;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.jIJ = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.jIJ.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.jIq) && adCardBaseView.jIq.equals(downloadData.getId())) {
                adCardBaseView.jIm.t(downloadData);
            }
        }
    }

    /* loaded from: classes13.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> jIJ;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.jIJ = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.jIJ.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                String str = null;
                if (adCardBaseView.jIr != null && adCardBaseView.jIr.getAdvertAppInfo() != null) {
                    str = adCardBaseView.jIr.getAdvertAppInfo().cMX;
                }
                com.baidu.tieba.recapp.s.b(adCardBaseView.cVi, adCardBaseView.jIw.scheme, str);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void ccm() {
        if (4 == getBusinessType()) {
            this.hRt.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.jHA != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.jIw = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.cVi.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.cVi, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
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
        DownloadData downloadData = new DownloadData(advertAppInfo.cNa);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.cMY);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.cMX, 0));
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
