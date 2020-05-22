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
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
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
import com.baidu.tieba.recapp.r;
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
    private DownloadCacheKey eOe;
    private com.baidu.tieba.ad.download.a.d eOf;
    protected View gEH;
    protected View gEk;
    protected TextView iRD;
    protected TextView iRF;
    private a.C0655a iXO;
    private final int iZv;
    protected ViewStub kKZ;
    private AdThreadCommentAndPraiseInfoLayout kLA;
    protected AdThreadUserInfoLayout kLB;
    protected View kLC;
    protected View kLD;
    protected AdCard.b kLE;
    private FrameLayout kLF;
    private View kLG;
    protected CustomMessageListener kLH;
    protected CustomMessageListener kLI;
    protected CustomMessageListener kLJ;
    protected View kLa;
    protected View kLb;
    protected final int kLc;
    protected final int kLd;
    protected final int kLe;
    protected final int kLf;
    protected final int kLg;
    protected final int kLh;
    protected final int kLi;
    protected final int kLj;
    private final int kLk;
    private final int kLl;
    private final int kLm;
    private final int kLn;
    private int kLo;
    private int kLp;
    private int kLq;
    protected TextView kLr;
    private AdCloseView kLs;
    private LinearLayout kLt;
    protected ApkDownloadView kLu;
    protected TextView kLv;
    protected RelativeLayout kLw;
    protected View kLx;
    protected String kLy;
    private AdCard kLz;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void cX(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iZv = l.getEquipmentWidth(getContext());
        this.eOf = null;
        this.kLH = new a(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG, this);
        this.kLI = new d(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG, this);
        this.kLJ = new c(CmdConfigCustom.CMD_USER_INFO_CHANGED, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.ds640);
        this.mImageHeight = (int) resources.getDimension(R.dimen.ds278);
        this.kLc = (int) resources.getDimension(R.dimen.tbds92);
        this.kLd = (int) resources.getDimension(R.dimen.tbds92);
        this.kLe = (int) resources.getDimension(R.dimen.tbds20);
        this.kLh = (int) resources.getDimension(R.dimen.tbds90);
        this.kLi = (int) resources.getDimension(R.dimen.tbds90);
        this.kLj = (int) resources.getDimension(R.dimen.tbds22);
        this.kLf = (int) resources.getDimension(R.dimen.tbds44);
        this.kLg = (int) resources.getDimension(R.dimen.tbds44);
        this.kLo = (int) resources.getDimension(R.dimen.ds12);
        this.kLp = (int) resources.getDimension(R.dimen.ds1);
        this.kLq = (int) resources.getDimension(R.dimen.ds18);
        this.kLk = (int) resources.getDimension(R.dimen.tbds208);
        this.kLl = (int) resources.getDimension(R.dimen.tbds33);
        this.kLm = (int) resources.getDimension(R.dimen.tbds72);
        this.kLn = (int) resources.getDimension(R.dimen.tbds48);
    }

    protected void B(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.kLA.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ctA() {
        MessageManager.getInstance().registerListener(this.kLH);
        MessageManager.getInstance().registerListener(this.kLI);
        MessageManager.getInstance().registerListener(this.kLJ);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.gEH = this.mRootView.findViewById(R.id.bottom_line);
        this.kLG = this.mRootView.findViewById(R.id.top_line);
        this.kLb = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.kLb.setClickable(true);
        this.iRD = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.kLr = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.kLu = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.kLv = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.kLw = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.kLu.x(this.dIF.getUniqueId());
        this.kLH.setTag(this.dIF.getUniqueId());
        this.kLx = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.kLI.setTag(this.dIF.getUniqueId());
        this.kLJ.setTag(this.dIF.getUniqueId());
        this.kLA = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.kLA.setStyle(1);
        this.kLB = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        this.kLF = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        if (1 == getBusinessType()) {
            this.kLB.setShowFlag(1413);
        }
        this.kLt = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.kLs = (AdCloseView) this.kLt.findViewById(R.id.ad_close_view);
        this.iRF = (TextView) this.kLt.findViewById(R.id.feed_tag);
        this.iRF.setVisibility(8);
        this.kLA.addAdMoreView(this.kLt);
        this.gEk = this.mRootView.findViewById(R.id.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.kLf) - this.kLg) - this.kLc) - this.kLe;
            this.kLA.setVisibility(8);
        } else {
            this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.kLf) - this.kLg;
            this.kLA.setVisibility(0);
        }
        this.kKZ = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.kKZ.setLayoutResource(getCustomLayout());
        this.kLa = this.kKZ.inflate();
        this.kLC = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.kLD = this.mRootView.findViewById(R.id.frs_bottom_view);
        cX(this.kLa);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(final AdCard adCard) {
        final String str;
        int i;
        this.kLz = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.kLB.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.aXN() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.dIF.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        a(adCard, bVar);
        this.kLr.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kLx.getLayoutParams();
        if (4 == getBusinessType()) {
            if (adCard.isPBBanner) {
                layoutParams.leftMargin = 0;
                this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.kLf) - this.kLg;
            } else {
                layoutParams.leftMargin = this.kLc + this.kLe;
                this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.kLf) - this.kLg) - this.kLc) - this.kLe;
            }
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.kLB.getHeaderImg(), adCard.portraitClick, bVar);
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String Lk = Lk(str2);
            this.iRD.setMaxLines(adCard.titleLines <= 0 ? 4 : adCard.titleLines);
            if (4 == getBusinessType()) {
                this.iRD.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize42));
            } else {
                this.iRD.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize44));
            }
            this.iRD.setText(Lk);
            this.iRD.setVisibility(0);
        } else {
            this.iRD.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.aOA()) && k.isEmpty(str3);
        a(this.kLw, this.kLr, this.kLu, adCard);
        int i2 = (this.mMaxWidth - this.kLk) - this.kLn;
        if (4 == getBusinessType()) {
            this.kLv.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize30));
            i = i2 - (this.kLl + this.kLm);
        } else {
            i = i2;
        }
        String str4 = null;
        if (advertAppInfo != null && advertAppInfo.aOz()) {
            str4 = adCard.userName.concat("APP");
        } else if (advertAppInfo != null && advertAppInfo.aOA()) {
            str4 = TextUtils.isEmpty(adCard.userName) ? "广告" : adCard.userName;
        }
        this.kLv.setText(com.baidu.b.a.e.a.a(str4, "广告", i, this.kLv.getPaint()));
        if (advertAppInfo != null && advertAppInfo.aOz()) {
            this.kLy = advertAppInfo.dAx;
            this.kLu.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            a(adCard, c2);
            a(this.kLr, c2.getStatus(), str3);
            this.kLu.setData(c2);
            this.kLu.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    am.setViewTextColor(this.kLr, R.color.cp_link_tip_a, 1);
                    am.setBackgroundResource(this.kLr, R.drawable.ad_download_progress_button_bg);
                    this.kLr.setText(str3);
                    if (k.isEmpty(str)) {
                        this.kLr.setClickable(false);
                    } else {
                        this.kLr.setClickable(true);
                        this.kLr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.iZo != null && adCard.buttonClick != null && !t.Mt(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.iZo.a(adCard.buttonClick.anr, adCard.buttonClick.ans, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int b2 = r.b(AdCardBaseView.this.dIF, str, (AdCardBaseView.this.kLz == null || AdCardBaseView.this.kLz.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.kLz.getAdvertAppInfo().dAu);
                                        if ((b2 == 1 || b2 == 2) && AdCardBaseView.this.iZo != null) {
                                            AdCardBaseView.this.iZo.d(b2, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.dIF.getPageActivity());
                                    aVar.vO(adCard.popWindowText);
                                    aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int b3 = r.b(AdCardBaseView.this.dIF, str, (AdCardBaseView.this.kLz == null || AdCardBaseView.this.kLz.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.kLz.getAdvertAppInfo().dAu);
                                            if ((b3 == 1 || b3 == 2) && AdCardBaseView.this.iZo != null) {
                                                AdCardBaseView.this.iZo.d(b3, null);
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
                                    aVar.b(AdCardBaseView.this.dIF).aST();
                                }
                            }
                        });
                    }
                } else {
                    this.kLr.setClickable(false);
                    this.kLr.setText(adCard.buttonTextDone);
                    am.setBackgroundResource(this.kLr, R.drawable.ad_download_progress_button_bg);
                    am.setViewTextColor(this.kLr, R.color.cp_btn_a, 1);
                }
            }
            this.kLu.setVisibility(8);
        }
        a(adCard);
        B(com.baidu.tbadk.core.k.aNQ().isShowImages(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            Ll(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.dAD != null && advertAppInfo.dAD.adCloseInfo != null && advertAppInfo.dAD.adCloseInfo.support_close.intValue() > 0) {
            this.kLs.setVisibility(0);
            this.kLs.setPage(getBusinessType());
            this.kLs.setData(advertAppInfo);
            l.addToParentArea(this.dIF.getPageActivity(), this.kLt, 40, 40, 40, 120);
            this.kLt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.kLs.performClick();
                }
            });
        } else {
            this.kLs.setVisibility(8);
            this.iRF.setOnClickListener(null);
        }
        this.kLA.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.gEH.getLayoutParams();
        if (4 == getBusinessType()) {
            this.kLA.setVisibility(8);
            this.kLA.setBarNameClickEnabled(false);
            this.kLA.setShareVisible(false);
            this.kLA.setShowPraiseNum(false);
            this.kLA.setCommentNumEnable(false);
            this.kLA.setReplyTimeVisible(false);
            layoutParams2.height = this.kLp;
            this.kLC.setVisibility(0);
            this.kLD.setVisibility(8);
            this.gEH.setVisibility(8);
            cY(this.kLt);
        } else {
            b(adCard, bVar);
            this.gEH.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.kLu.getLayoutParams()).addRule(11, -1);
            ((RelativeLayout.LayoutParams) this.kLr.getLayoutParams()).addRule(11, -1);
            this.kLF.setVisibility(8);
            this.kLw.requestLayout();
        }
        a(adCard, this.gEk, getBusinessType());
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 instanceof AdvertAppInfo) {
            advertAppInfo2.vz(aq.cj(adCard.time));
        }
        this.kLB.setData(advertAppInfo2);
        ((TextView) this.kLB.getUserName()).setText(adCard.userName);
        this.kLB.getUserName().setOnClickListener(bVar);
        this.kLB.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.kLB.getUserName()).setText(adCard.userName);
            }
        });
        if (4 == getBusinessType() && adCard.isPBBanner) {
            this.kLG.setVisibility(0);
            this.kLG.setBackgroundResource(R.color.cp_bg_line_b);
            this.kLB.setVisibility(8);
        } else {
            this.kLG.setVisibility(8);
        }
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bTX().bTY()) {
            this.kLb.setVisibility(0);
            am.setBackgroundColor(this.kLb, R.color.cp_bg_line_d);
        } else {
            this.kLb.setVisibility(8);
        }
        a(adCard, advertAppInfo);
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private void cY(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((FrameLayout) view.getParent()).removeView(view);
            }
            this.kLF.setVisibility(0);
            this.kLF.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.kLF.addView(view);
            int dimension = (int) getResources().getDimension(R.dimen.tbds26);
            int dimension2 = (int) getResources().getDimension(R.dimen.tbds33);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kLu.getLayoutParams();
            layoutParams.setMargins(0, dimension, dimension2, dimension);
            layoutParams.addRule(11, 0);
            layoutParams.addRule(0, this.kLF.getId());
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kLr.getLayoutParams();
            layoutParams2.addRule(11, 0);
            layoutParams2.setMargins(0, dimension, dimension2, dimension);
            layoutParams2.addRule(0, this.kLF.getId());
            this.kLw.requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bmx();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bmy();
    }

    private void a(AdCard adCard, DownloadData downloadData) {
        if (adCard.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.kLu.getDownloadStatus());
        }
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.directDownload) {
            this.kLu.setOnClickListener(bVar);
        } else {
            this.kLu.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public void br(View view) {
                    AdCardBaseView.this.cUE();
                }
            });
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey zY;
        if (!adCard.directDownload && advertAppInfo != null && advertAppInfo.aOz()) {
            String scheme = adCard.getScheme();
            String str = advertAppInfo.dAu;
            if (!TextUtils.isEmpty(str)) {
                zY = com.baidu.tieba.ad.download.d.bmD().zX(str);
            } else {
                zY = com.baidu.tieba.ad.download.d.bmD().zY(scheme);
            }
            if (zY == null) {
                zY = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.dAx);
                com.baidu.tieba.ad.download.d.bmD().a(zY, null);
            }
            i(zY);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.eOe = downloadCacheKey;
            bmy();
            this.eOf = null;
            AdDownloadData d2 = com.baidu.tieba.ad.download.d.bmD().d(downloadCacheKey);
            if (d2 != null) {
                this.kLu.a(d2.getCurrentState());
            } else {
                this.kLu.a(DownloadStatus.STATUS_NONE);
            }
            String str = "";
            if (this.kLz != null && this.kLz.getAdvertAppInfo() != null) {
                str = this.kLz.getAdvertAppInfo().page;
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.kLu, d2, str);
            this.eOf = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d2.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d2);
            }
            bmx();
        }
    }

    private void bmx() {
        if (this.eOe != null && this.eOf != null) {
            com.baidu.tieba.ad.download.d.bmD().a(this.eOe, this.eOf);
        }
    }

    private void bmy() {
        if (this.eOe != null && this.eOf != null) {
            com.baidu.tieba.ad.download.d.bmD().b(this.eOe, this.eOf);
        }
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void b(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.kLD.setVisibility(0);
            this.kLA.setVisibility(8);
            return;
        }
        this.kLD.setVisibility(8);
        this.kLA.setVisibility(0);
        this.kLA.setBarNameClickEnabled(false);
        this.kLA.setReplyTimeVisible(false);
        this.kLA.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.kLA.setAgreeClickable(true);
            this.kLA.setPraiseContainerBgGray(false);
        } else {
            this.kLA.setAgreeClickable(false);
            this.kLA.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.kLA.setShareClickable(true);
            this.kLA.setShareContainerBgGray(false);
        } else {
            this.kLA.setShareClickable(false);
            this.kLA.setShareContainerBgGray(true);
        }
        if (this.kLA.getCommentContainer() != null) {
            this.kLA.getCommentContainer().setOnClickListener(bVar);
        }
        this.kLA.setNeedAddReplyIcon(true);
        this.kLA.setCommentNumEnable(false);
        this.kLA.setCommentClickable(true);
        this.kLA.setReplayContainerBgGray(true);
        this.kLA.setOnClickListener(bVar);
        this.kLA.setShareData(adCard);
        this.kLA.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        am.setBackgroundResource(this.gEH, R.color.cp_bg_line_b);
        this.kLs.onChangeSkinType();
        this.kLB.onChangeSkinType(this.dIF, TbadkCoreApplication.getInst().getSkinType());
        this.kLA.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.gEk, R.color.cp_bg_line_e);
        } else {
            am.setBackgroundColor(this.gEk, R.color.transparent);
        }
        am.setViewTextColor(this.iRD, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.kLv, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.iRF, R.color.cp_cont_d, 1);
        this.kLu.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String Lk(String str) {
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
        int b2;
        if (bVar != null) {
            if (b(bVar) && !t.Mt(bVar.scheme)) {
                if (this.iZo != null) {
                    this.iZo.a(bVar.anr, bVar.ans, null);
                }
            } else if (this.kLz != null && this.kLz.getAdvertAppInfo() != null) {
                String Lm = Lm(bVar.scheme);
                String str = this.kLz.getAdvertAppInfo().dAu;
                if (!this.kLz.directDownload && this.kLz.getAdvertAppInfo().aOz()) {
                    b2 = r.c(this.dIF, Lm, str);
                } else {
                    b2 = r.b(this.dIF, Lm, str);
                }
                if (b2 == 1 || b2 == 2) {
                    if (this.iZo != null) {
                        this.iZo.d(b2, null);
                    }
                } else if (this.iZo != null) {
                    this.iZo.a(bVar.anr, bVar.ans, null);
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
                        if (AdCardBaseView.this.kLz.hasAnimation()) {
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
        this.iXO = new a.C0655a();
        this.iXO.picUrl = tbImageView.getUrl();
        this.iXO.rect = rect;
    }

    private void Ll(String str) {
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
                    com.baidu.adp.lib.e.c.kX().a(jSONObject.optString("pic_url"), 17, null, this.iZv, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.iZv), this.dIF.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.aOy() != 0) {
                l.showToast(this.dIF.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.dIF.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.dIF.getPageActivity()) && this.iZp != null) {
                this.iZp.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.dIF.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aOz()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.dIF.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dIF.getPageActivity());
                aVar.vO(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.kLu);
                        if (AdCardBaseView.this.kLu != null) {
                            AdCardBaseView.this.kLu.q(AdCardBaseView.this.c(advertAppInfo, i));
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
                aVar.b(this.dIF).aST();
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
                    h.aN(this.dIF.getPageActivity(), advertAppInfo.dAx);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, this.kLu);
                    apkDownloadView.s(c2);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.bmD().aw(this.dIF.getPageActivity(), advertAppInfo.dAx);
                    return;
            }
        }
    }

    public a.C0655a getAnimationInfo() {
        return this.iXO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class b implements View.OnClickListener {
        private AdCard kLT;

        public b(AdCard adCard) {
            this.kLT = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdCardBaseView.this.dIF.showToast(R.string.neterror);
            } else if (this.kLT != null) {
                AdvertAppInfo advertAppInfo = this.kLT.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.kLu;
                if (advertAppInfo != null && advertAppInfo.aOz()) {
                    a(advertAppInfo, z);
                } else {
                    i(advertAppInfo);
                }
            }
        }

        private void a(AdvertAppInfo advertAppInfo, boolean z) {
            if (this.kLT.directDownload || z) {
                b(advertAppInfo, z);
            } else {
                j(advertAppInfo);
            }
        }

        private void i(AdvertAppInfo advertAppInfo) {
            String scheme = this.kLT.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.dAw;
            }
            if (this.kLT.hasAnimation()) {
            }
            int f = r.f(AdCardBaseView.this.dIF, AdCardBaseView.this.Lm(scheme));
            if (AdCardBaseView.this.iZo != null) {
                AdCardBaseView.this.iZo.d(f, null);
            }
        }

        private void b(AdvertAppInfo advertAppInfo, boolean z) {
            int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
            int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, i));
            if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                return;
            }
            AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.kLu, z);
            AdCardBaseView.this.cUE();
        }

        private void j(AdvertAppInfo advertAppInfo) {
            String scheme = this.kLT.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.dAw;
            }
            int c = r.c(AdCardBaseView.this.dIF, scheme, advertAppInfo.dAu);
            if (AdCardBaseView.this.iZo != null) {
                AdCardBaseView.this.iZo.d(c, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cUE() {
        if (this.iZo != null) {
            this.iZo.d(3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Lm(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.iXO != null && this.iXO.isValid()) {
            String c0655a = this.iXO.toString();
            if (!TextUtils.isEmpty(c0655a)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(c0655a));
            }
        }
        if (!TextUtils.isEmpty(this.kLz.getPreLoadData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.kLz.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.kLz.getNextPageData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.kLz.getNextPageData()));
        }
        if (this.kLz.hasAnimation()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.kLz.isGoLandingPage()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.kLz.isImmersiveStyle()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes13.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> kLS;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.kLS = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.kLS.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.kLy) ? false : true)) && adCardBaseView.kLy.equals(downloadData.getId())) {
                    int status = e.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.kLr.setText(R.string.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.kLr.setText(R.string.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> kLS;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.kLS = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.kLS.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.kLy) && adCardBaseView.kLy.equals(downloadData.getId())) {
                adCardBaseView.kLu.t(downloadData);
            }
        }
    }

    /* loaded from: classes13.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> kLS;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.kLS = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.kLS.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                String str = null;
                if (adCardBaseView.kLz != null && adCardBaseView.kLz.getAdvertAppInfo() != null) {
                    str = adCardBaseView.kLz.getAdvertAppInfo().dAu;
                }
                r.b(adCardBaseView.dIF, adCardBaseView.kLE.scheme, str);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void ctG() {
        if (4 == getBusinessType()) {
            this.iRD.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.kKJ != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.kLE = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.dIF.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.dIF, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        return true;
    }

    private void a(View view, TextView textView, ApkDownloadView apkDownloadView, AdCard adCard) {
        if (adCard == null) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        if (adCard.getAdvertAppInfo().aOz()) {
            textView.setVisibility(8);
            apkDownloadView.setVisibility(0);
        } else if (k.isEmpty(adCard.buttonText)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dAx);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dAv);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.dAu, 0));
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
