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
    private com.baidu.tieba.ad.download.a.d ezA;
    private DownloadCacheKey ezz;
    protected View gpM;
    protected View gpp;
    protected TextView iCK;
    private a.C0584a iIK;
    private final int iKr;
    protected View ktA;
    protected String ktB;
    private AdCard ktC;
    private AdThreadCommentAndPraiseInfoLayout ktD;
    protected AdThreadUserInfoLayout ktE;
    protected View ktF;
    protected View ktG;
    protected AdCard.b ktH;
    private FrameLayout ktI;
    private View ktJ;
    protected CustomMessageListener ktK;
    protected CustomMessageListener ktL;
    protected CustomMessageListener ktM;
    protected ViewStub ktb;
    protected View ktc;
    protected View ktd;
    protected final int kte;
    protected final int ktf;
    protected final int ktg;
    protected final int kth;
    protected final int kti;
    protected final int ktj;
    protected final int ktk;
    protected final int ktl;
    private final int ktm;
    private final int ktn;
    private final int kto;
    private final int ktp;
    private int ktq;
    private int ktr;
    private int kts;
    protected TextView ktt;
    protected TextView ktu;
    private AdCloseView ktv;
    private LinearLayout ktw;
    protected ApkDownloadView ktx;
    protected TextView kty;
    protected RelativeLayout ktz;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void cW(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iKr = l.getEquipmentWidth(getContext());
        this.ezA = null;
        this.ktK = new a(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG, this);
        this.ktL = new d(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG, this);
        this.ktM = new c(CmdConfigCustom.CMD_USER_INFO_CHANGED, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.ds640);
        this.mImageHeight = (int) resources.getDimension(R.dimen.ds278);
        this.kte = (int) resources.getDimension(R.dimen.tbds92);
        this.ktf = (int) resources.getDimension(R.dimen.tbds92);
        this.ktg = (int) resources.getDimension(R.dimen.tbds20);
        this.ktj = (int) resources.getDimension(R.dimen.tbds90);
        this.ktk = (int) resources.getDimension(R.dimen.tbds90);
        this.ktl = (int) resources.getDimension(R.dimen.tbds22);
        this.kth = (int) resources.getDimension(R.dimen.tbds44);
        this.kti = (int) resources.getDimension(R.dimen.tbds44);
        this.ktq = (int) resources.getDimension(R.dimen.ds12);
        this.ktr = (int) resources.getDimension(R.dimen.ds1);
        this.kts = (int) resources.getDimension(R.dimen.ds18);
        this.ktm = (int) resources.getDimension(R.dimen.tbds208);
        this.ktn = (int) resources.getDimension(R.dimen.tbds33);
        this.kto = (int) resources.getDimension(R.dimen.tbds72);
        this.ktp = (int) resources.getDimension(R.dimen.tbds48);
    }

    protected void y(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.ktD.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cna() {
        MessageManager.getInstance().registerListener(this.ktK);
        MessageManager.getInstance().registerListener(this.ktL);
        MessageManager.getInstance().registerListener(this.ktM);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.gpM = this.mRootView.findViewById(R.id.bottom_line);
        this.ktJ = this.mRootView.findViewById(R.id.top_line);
        this.ktd = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.ktd.setClickable(true);
        this.iCK = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.ktt = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.ktx = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.kty = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.ktz = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.ktx.u(this.duG.getUniqueId());
        this.ktK.setTag(this.duG.getUniqueId());
        this.ktA = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.ktL.setTag(this.duG.getUniqueId());
        this.ktM.setTag(this.duG.getUniqueId());
        this.ktD = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.ktD.setStyle(1);
        this.ktE = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        this.ktI = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        if (1 == getBusinessType()) {
            this.ktE.setShowFlag(1413);
        }
        this.ktw = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.ktv = (AdCloseView) this.ktw.findViewById(R.id.ad_close_view);
        this.ktu = (TextView) this.ktw.findViewById(R.id.feed_tag);
        this.ktu.setVisibility(8);
        this.ktD.addAdMoreView(this.ktw);
        this.gpp = this.mRootView.findViewById(R.id.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.kth) - this.kti) - this.kte) - this.ktg;
            this.ktD.setVisibility(8);
        } else {
            this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.kth) - this.kti;
            this.ktD.setVisibility(0);
        }
        this.ktb = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.ktb.setLayoutResource(getCustomLayout());
        this.ktc = this.ktb.inflate();
        this.ktF = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.ktG = this.mRootView.findViewById(R.id.frs_bottom_view);
        cW(this.ktc);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(final AdCard adCard) {
        final String str;
        int i;
        this.ktC = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.ktE.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.aRJ() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.duG.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        a(adCard, bVar);
        this.ktt.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ktA.getLayoutParams();
        if (4 == getBusinessType()) {
            if (adCard.isPBBanner) {
                layoutParams.leftMargin = 0;
                this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.kth) - this.kti;
            } else {
                layoutParams.leftMargin = this.kte + this.ktg;
                this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.kth) - this.kti) - this.kte) - this.ktg;
            }
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.ktE.getHeaderImg(), adCard.portraitClick, bVar);
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String Jv = Jv(str2);
            this.iCK.setMaxLines(adCard.titleLines <= 0 ? 4 : adCard.titleLines);
            if (4 == getBusinessType()) {
                this.iCK.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize42));
            } else {
                this.iCK.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize44));
            }
            this.iCK.setText(Jv);
            this.iCK.setVisibility(0);
        } else {
            this.iCK.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.aIH()) && k.isEmpty(str3);
        a(this.ktz, this.ktt, this.ktx, adCard);
        int i2 = (this.mMaxWidth - this.ktm) - this.ktp;
        if (4 == getBusinessType()) {
            this.kty.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize30));
            i = i2 - (this.ktn + this.kto);
        } else {
            i = i2;
        }
        String str4 = null;
        if (advertAppInfo != null && advertAppInfo.aIG()) {
            str4 = adCard.userName.concat("APP");
        } else if (advertAppInfo != null && advertAppInfo.aIH()) {
            str4 = TextUtils.isEmpty(adCard.userName) ? "广告" : adCard.userName;
        }
        this.kty.setText(com.baidu.b.a.e.a.a(str4, "广告", i, this.kty.getPaint()));
        if (advertAppInfo != null && advertAppInfo.aIG()) {
            this.ktB = advertAppInfo.dmr;
            this.ktx.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            a(adCard, c2);
            a(this.ktt, c2.getStatus(), str3);
            this.ktx.setData(c2);
            this.ktx.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    am.setViewTextColor(this.ktt, R.color.cp_link_tip_a, 1);
                    am.setBackgroundResource(this.ktt, R.drawable.ad_download_progress_button_bg);
                    this.ktt.setText(str3);
                    if (k.isEmpty(str)) {
                        this.ktt.setClickable(false);
                    } else {
                        this.ktt.setClickable(true);
                        this.ktt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.iKk != null && adCard.buttonClick != null && !t.KE(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.iKk.b(adCard.buttonClick.alJ, adCard.buttonClick.alK, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int b2 = r.b(AdCardBaseView.this.duG, str, (AdCardBaseView.this.ktC == null || AdCardBaseView.this.ktC.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.ktC.getAdvertAppInfo().dmo);
                                        if ((b2 == 1 || b2 == 2) && AdCardBaseView.this.iKk != null) {
                                            AdCardBaseView.this.iKk.d(b2, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.duG.getPageActivity());
                                    aVar.uf(adCard.popWindowText);
                                    aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int b3 = r.b(AdCardBaseView.this.duG, str, (AdCardBaseView.this.ktC == null || AdCardBaseView.this.ktC.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.ktC.getAdvertAppInfo().dmo);
                                            if ((b3 == 1 || b3 == 2) && AdCardBaseView.this.iKk != null) {
                                                AdCardBaseView.this.iKk.d(b3, null);
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
                                    aVar.b(AdCardBaseView.this.duG).aMU();
                                }
                            }
                        });
                    }
                } else {
                    this.ktt.setClickable(false);
                    this.ktt.setText(adCard.buttonTextDone);
                    am.setBackgroundResource(this.ktt, R.drawable.ad_download_progress_button_bg);
                    am.setViewTextColor(this.ktt, R.color.cp_btn_a, 1);
                }
            }
            this.ktx.setVisibility(8);
        }
        a(adCard);
        y(i.aIe().isShowImages(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            Jw(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.dmx != null && advertAppInfo.dmx.adCloseInfo != null && advertAppInfo.dmx.adCloseInfo.support_close.intValue() > 0) {
            this.ktv.setVisibility(0);
            this.ktv.setPage(getBusinessType());
            this.ktv.setData(advertAppInfo);
            l.addToParentArea(this.duG.getPageActivity(), this.ktw, 40, 40, 40, 120);
            this.ktw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.ktv.performClick();
                }
            });
        } else {
            this.ktv.setVisibility(8);
            this.ktu.setOnClickListener(null);
        }
        this.ktD.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.gpM.getLayoutParams();
        if (4 == getBusinessType()) {
            this.ktD.setVisibility(8);
            this.ktD.setBarNameClickEnabled(false);
            this.ktD.setShareVisible(false);
            this.ktD.setShowPraiseNum(false);
            this.ktD.setCommentNumEnable(false);
            this.ktD.setReplyTimeVisible(false);
            layoutParams2.height = this.ktr;
            this.ktF.setVisibility(0);
            this.ktG.setVisibility(8);
            this.gpM.setVisibility(8);
            cX(this.ktw);
        } else {
            b(adCard, bVar);
            this.gpM.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.ktx.getLayoutParams()).addRule(11, -1);
            ((RelativeLayout.LayoutParams) this.ktt.getLayoutParams()).addRule(11, -1);
            this.ktI.setVisibility(8);
            this.ktz.requestLayout();
        }
        a(adCard, this.gpp, getBusinessType());
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 instanceof AdvertAppInfo) {
            advertAppInfo2.tQ(aq.cj(adCard.time));
        }
        this.ktE.setData(advertAppInfo2);
        ((TextView) this.ktE.getUserName()).setText(adCard.userName);
        this.ktE.getUserName().setOnClickListener(bVar);
        this.ktE.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.ktE.getUserName()).setText(adCard.userName);
            }
        });
        if (4 == getBusinessType() && adCard.isPBBanner) {
            this.ktJ.setVisibility(0);
            this.ktJ.setBackgroundResource(R.color.cp_bg_line_b);
            this.ktE.setVisibility(8);
        } else {
            this.ktJ.setVisibility(8);
        }
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bND().bNE()) {
            this.ktd.setVisibility(0);
            am.setBackgroundColor(this.ktd, R.color.cp_bg_line_d);
        } else {
            this.ktd.setVisibility(8);
        }
        a(adCard, advertAppInfo);
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private void cX(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((FrameLayout) view.getParent()).removeView(view);
            }
            this.ktI.setVisibility(0);
            this.ktI.removeAllViews();
            view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.ktI.addView(view);
            int dimension = (int) getResources().getDimension(R.dimen.tbds26);
            int dimension2 = (int) getResources().getDimension(R.dimen.tbds33);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ktx.getLayoutParams();
            layoutParams.setMargins(0, dimension, dimension2, dimension);
            layoutParams.addRule(11, 0);
            layoutParams.addRule(0, this.ktI.getId());
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ktt.getLayoutParams();
            layoutParams2.addRule(11, 0);
            layoutParams2.setMargins(0, dimension, dimension2, dimension);
            layoutParams2.addRule(0, this.ktI.getId());
            this.ktz.requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bgo();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bgp();
    }

    private void a(AdCard adCard, DownloadData downloadData) {
        if (adCard.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.ktx.getDownloadStatus());
        }
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.directDownload) {
            this.ktx.setOnClickListener(bVar);
        } else {
            this.ktx.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public void bq(View view) {
                    AdCardBaseView.this.cNG();
                }
            });
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey yp;
        if (!adCard.directDownload && advertAppInfo != null && advertAppInfo.aIG()) {
            String scheme = adCard.getScheme();
            String str = advertAppInfo.dmo;
            if (!TextUtils.isEmpty(str)) {
                yp = com.baidu.tieba.ad.download.d.bgu().yo(str);
            } else {
                yp = com.baidu.tieba.ad.download.d.bgu().yp(scheme);
            }
            if (yp == null) {
                yp = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.dmr);
                com.baidu.tieba.ad.download.d.bgu().a(yp, null);
            }
            i(yp);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.ezz = downloadCacheKey;
            bgp();
            this.ezA = null;
            AdDownloadData d2 = com.baidu.tieba.ad.download.d.bgu().d(downloadCacheKey);
            if (d2 != null) {
                this.ktx.a(d2.getCurrentState());
            } else {
                this.ktx.a(DownloadStatus.STATUS_NONE);
            }
            String str = "";
            if (this.ktC != null && this.ktC.getAdvertAppInfo() != null) {
                str = this.ktC.getAdvertAppInfo().page;
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.ktx, d2, str);
            this.ezA = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d2.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d2);
            }
            bgo();
        }
    }

    private void bgo() {
        if (this.ezz != null && this.ezA != null) {
            com.baidu.tieba.ad.download.d.bgu().a(this.ezz, this.ezA);
        }
    }

    private void bgp() {
        if (this.ezz != null && this.ezA != null) {
            com.baidu.tieba.ad.download.d.bgu().b(this.ezz, this.ezA);
        }
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void b(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.ktG.setVisibility(0);
            this.ktD.setVisibility(8);
            return;
        }
        this.ktG.setVisibility(8);
        this.ktD.setVisibility(0);
        this.ktD.setBarNameClickEnabled(false);
        this.ktD.setReplyTimeVisible(false);
        this.ktD.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.ktD.setAgreeClickable(true);
            this.ktD.setPraiseContainerBgGray(false);
        } else {
            this.ktD.setAgreeClickable(false);
            this.ktD.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.ktD.setShareClickable(true);
            this.ktD.setShareContainerBgGray(false);
        } else {
            this.ktD.setShareClickable(false);
            this.ktD.setShareContainerBgGray(true);
        }
        if (this.ktD.getCommentContainer() != null) {
            this.ktD.getCommentContainer().setOnClickListener(bVar);
        }
        this.ktD.setNeedAddReplyIcon(true);
        this.ktD.setCommentNumEnable(false);
        this.ktD.setCommentClickable(true);
        this.ktD.setReplayContainerBgGray(true);
        this.ktD.setOnClickListener(bVar);
        this.ktD.setShareData(adCard);
        this.ktD.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        am.setBackgroundResource(this.gpM, R.color.cp_bg_line_b);
        this.ktv.onChangeSkinType();
        this.ktE.onChangeSkinType(this.duG, TbadkCoreApplication.getInst().getSkinType());
        this.ktD.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.gpp, R.color.cp_bg_line_e);
        } else {
            am.setBackgroundColor(this.gpp, R.color.transparent);
        }
        am.setViewTextColor(this.iCK, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.kty, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.ktu, R.color.cp_cont_d, 1);
        this.ktx.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String Jv(String str) {
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
            if (b(bVar) && !t.KE(bVar.scheme)) {
                if (this.iKk != null) {
                    this.iKk.b(bVar.alJ, bVar.alK, null);
                }
            } else if (this.ktC != null && this.ktC.getAdvertAppInfo() != null) {
                String Jx = Jx(bVar.scheme);
                String str = this.ktC.getAdvertAppInfo().dmo;
                if (!this.ktC.directDownload && this.ktC.getAdvertAppInfo().aIG()) {
                    b2 = r.c(this.duG, Jx, str);
                } else {
                    b2 = r.b(this.duG, Jx, str);
                }
                if (b2 == 1 || b2 == 2) {
                    if (this.iKk != null) {
                        this.iKk.d(b2, null);
                    }
                } else if (this.iKk != null) {
                    this.iKk.b(bVar.alJ, bVar.alK, null);
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
                        if (AdCardBaseView.this.ktC.hasAnimation()) {
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
        this.iIK = new a.C0584a();
        this.iIK.picUrl = tbImageView.getUrl();
        this.iIK.rect = rect;
    }

    private void Jw(String str) {
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
                    com.baidu.adp.lib.e.c.kV().a(jSONObject.optString("pic_url"), 17, null, this.iKr, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.iKr), this.duG.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.aIF() != 0) {
                l.showToast(this.duG.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.duG.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.duG.getPageActivity()) && this.iKl != null) {
                this.iKl.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.duG.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aIG()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.duG.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.duG.getPageActivity());
                aVar.uf(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.ktx);
                        if (AdCardBaseView.this.ktx != null) {
                            AdCardBaseView.this.ktx.q(AdCardBaseView.this.c(advertAppInfo, i));
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
                aVar.b(this.duG).aMU();
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
                    h.aY(this.duG.getPageActivity(), advertAppInfo.dmr);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, this.ktx);
                    apkDownloadView.s(c2);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.bgu().aH(this.duG.getPageActivity(), advertAppInfo.dmr);
                    return;
            }
        }
    }

    public a.C0584a getAnimationInfo() {
        return this.iIK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class b implements View.OnClickListener {
        private AdCard ktW;

        public b(AdCard adCard) {
            this.ktW = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdCardBaseView.this.duG.showToast(R.string.neterror);
            } else if (this.ktW != null) {
                AdvertAppInfo advertAppInfo = this.ktW.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.ktx;
                if (advertAppInfo != null && advertAppInfo.aIG()) {
                    a(advertAppInfo, z);
                } else {
                    i(advertAppInfo);
                }
            }
        }

        private void a(AdvertAppInfo advertAppInfo, boolean z) {
            if (this.ktW.directDownload || z) {
                b(advertAppInfo, z);
            } else {
                j(advertAppInfo);
            }
        }

        private void i(AdvertAppInfo advertAppInfo) {
            String scheme = this.ktW.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.dmq;
            }
            if (this.ktW.hasAnimation()) {
            }
            int f = r.f(AdCardBaseView.this.duG, AdCardBaseView.this.Jx(scheme));
            if (AdCardBaseView.this.iKk != null) {
                AdCardBaseView.this.iKk.d(f, null);
            }
        }

        private void b(AdvertAppInfo advertAppInfo, boolean z) {
            int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
            int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, i));
            if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                return;
            }
            AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.ktx, z);
            AdCardBaseView.this.cNG();
        }

        private void j(AdvertAppInfo advertAppInfo) {
            String scheme = this.ktW.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.dmq;
            }
            int c = r.c(AdCardBaseView.this.duG, scheme, advertAppInfo.dmo);
            if (AdCardBaseView.this.iKk != null) {
                AdCardBaseView.this.iKk.d(c, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cNG() {
        if (this.iKk != null) {
            this.iKk.d(3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Jx(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.iIK != null && this.iIK.isValid()) {
            String c0584a = this.iIK.toString();
            if (!TextUtils.isEmpty(c0584a)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(c0584a));
            }
        }
        if (!TextUtils.isEmpty(this.ktC.getPreLoadData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.ktC.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.ktC.getNextPageData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.ktC.getNextPageData()));
        }
        if (this.ktC.hasAnimation()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.ktC.isGoLandingPage()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.ktC.isImmersiveStyle()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes13.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> ktV;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.ktV = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.ktV.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.ktB) ? false : true)) && adCardBaseView.ktB.equals(downloadData.getId())) {
                    int status = e.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.ktt.setText(R.string.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.ktt.setText(R.string.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> ktV;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.ktV = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.ktV.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.ktB) && adCardBaseView.ktB.equals(downloadData.getId())) {
                adCardBaseView.ktx.t(downloadData);
            }
        }
    }

    /* loaded from: classes13.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> ktV;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.ktV = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.ktV.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                String str = null;
                if (adCardBaseView.ktC != null && adCardBaseView.ktC.getAdvertAppInfo() != null) {
                    str = adCardBaseView.ktC.getAdvertAppInfo().dmo;
                }
                r.b(adCardBaseView.duG, adCardBaseView.ktH.scheme, str);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void cng() {
        if (4 == getBusinessType()) {
            this.iCK.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.ksL != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.ktH = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.duG.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.duG, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        return true;
    }

    private void a(View view, TextView textView, ApkDownloadView apkDownloadView, AdCard adCard) {
        if (adCard == null) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        if (adCard.getAdvertAppInfo().aIG()) {
            textView.setVisibility(8);
            apkDownloadView.setVisibility(0);
        } else if (k.isEmpty(adCard.buttonText)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dmr);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dmp);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.dmo, 0));
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
