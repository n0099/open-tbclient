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
    private DownloadCacheKey fMm;
    private com.baidu.tieba.ad.download.a.d fMn;
    protected View hSE;
    protected View hSh;
    private View jhv;
    private AdCard krg;
    protected TextView krk;
    protected TextView krm;
    private a.C0762a kyg;
    private final int kzN;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    protected View mRootView;
    protected ViewStub moO;
    protected View moP;
    protected View moQ;
    protected final int moR;
    protected final int moS;
    protected final int moT;
    protected final int moU;
    protected final int moV;
    protected final int moW;
    protected final int moX;
    protected final int moY;
    private final int moZ;
    private final int mpa;
    private final int mpb;
    private final int mpc;
    private int mpd;
    private int mpe;
    private int mpf;
    protected TextView mpg;
    private AdCloseView mph;
    private LinearLayout mpi;
    protected ApkDownloadView mpj;
    protected TextView mpk;
    protected RelativeLayout mpl;
    protected View mpm;
    protected String mpn;
    private AdThreadCommentAndPraiseInfoLayout mpo;
    protected AdThreadUserInfoLayout mpp;
    protected View mpq;
    protected View mpr;
    protected AdCard.b mps;
    private FrameLayout mpt;
    protected CustomMessageListener mpu;
    protected CustomMessageListener mpv;
    protected CustomMessageListener mpw;

    protected abstract void a(AdCard adCard);

    protected abstract void dy(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kzN = l.getEquipmentWidth(getContext());
        this.fMn = null;
        this.mpu = new a(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG, this);
        this.mpv = new d(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG, this);
        this.mpw = new c(CmdConfigCustom.CMD_USER_INFO_CHANGED, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.ds640);
        this.mImageHeight = (int) resources.getDimension(R.dimen.ds278);
        this.moR = (int) resources.getDimension(R.dimen.tbds92);
        this.moS = (int) resources.getDimension(R.dimen.tbds92);
        this.moT = (int) resources.getDimension(R.dimen.tbds20);
        this.moW = (int) resources.getDimension(R.dimen.tbds90);
        this.moX = (int) resources.getDimension(R.dimen.tbds90);
        this.moY = (int) resources.getDimension(R.dimen.tbds22);
        this.moU = (int) resources.getDimension(R.dimen.tbds44);
        this.moV = (int) resources.getDimension(R.dimen.tbds44);
        this.mpd = (int) resources.getDimension(R.dimen.ds12);
        this.mpe = (int) resources.getDimension(R.dimen.ds1);
        this.mpf = (int) resources.getDimension(R.dimen.ds18);
        this.moZ = (int) resources.getDimension(R.dimen.tbds208);
        this.mpa = (int) resources.getDimension(R.dimen.tbds33);
        this.mpb = (int) resources.getDimension(R.dimen.tbds72);
        this.mpc = (int) resources.getDimension(R.dimen.tbds48);
    }

    protected void H(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.mpo.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cWN() {
        MessageManager.getInstance().registerListener(this.mpu);
        MessageManager.getInstance().registerListener(this.mpv);
        MessageManager.getInstance().registerListener(this.mpw);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.hSE = this.mRootView.findViewById(R.id.bottom_line);
        this.jhv = this.mRootView.findViewById(R.id.top_line);
        this.moQ = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.moQ.setClickable(true);
        this.krk = (TextView) this.mRootView.findViewById(R.id.ad_title);
        com.baidu.tbadk.a.b.a.d(this.krk, R.dimen.tbds32, R.dimen.tbds20);
        this.mpg = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.mpj = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.mpk = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.mpl = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.mpj.x(this.eCn.getUniqueId());
        this.mpu.setTag(this.eCn.getUniqueId());
        this.mpm = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.mpv.setTag(this.eCn.getUniqueId());
        this.mpw.setTag(this.eCn.getUniqueId());
        this.mpo = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.mpo.setStyle(1);
        this.mpp = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        this.mpt = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        if (1 == getBusinessType()) {
            this.mpp.setShowFlag(1413);
        }
        this.mpi = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mph = (AdCloseView) this.mpi.findViewById(R.id.ad_close_view);
        ViewGroup.LayoutParams layoutParams = this.mph.mtm.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.mph.mtm.getLayoutParams();
        int dimens = l.getDimens(getContext(), R.dimen.tbds62);
        layoutParams2.width = dimens;
        layoutParams.height = dimens;
        this.krm = (TextView) this.mpi.findViewById(R.id.feed_tag);
        this.krm.setVisibility(8);
        this.mpp.addAdTagView(this.mpi);
        this.hSh = this.mRootView.findViewById(R.id.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.moU) - this.moV) - this.moR) - this.moT;
            this.mpo.setVisibility(8);
        } else {
            this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.moU) - this.moV;
            this.mpo.setVisibility(0);
        }
        this.moO = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.moO.setLayoutResource(getCustomLayout());
        this.moP = this.moO.inflate();
        com.baidu.tbadk.a.b.a.d(this.moP, R.dimen.tbds32, R.dimen.tbds14);
        this.mpq = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.mpr = this.mRootView.findViewById(R.id.frs_bottom_view);
        dy(this.moP);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(final AdCard adCard) {
        final String str;
        int i;
        this.krg = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.mpp.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.brT() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.eCn.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        a(adCard, bVar);
        this.mpg.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mpm.getLayoutParams();
        if (4 == getBusinessType()) {
            if (adCard.isPBBanner) {
                layoutParams.leftMargin = 0;
                this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.moU) - this.moV;
            } else {
                layoutParams.leftMargin = this.moR + this.moT;
                this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.moU) - this.moV) - this.moR) - this.moT;
            }
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.mpp.getHeaderImg(), adCard.portraitClick, bVar);
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            this.krk.setMaxLines(adCard.titleLines <= 0 ? 4 : adCard.titleLines);
            if (4 == getBusinessType()) {
                this.krk.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize42));
            } else {
                this.krk.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize44));
            }
            this.krk.setText(str2);
            this.krk.setVisibility(0);
        } else {
            this.krk.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.bhT()) && k.isEmpty(str3);
        a(this.mpl, this.mpg, this.mpj, adCard);
        int i2 = (this.mMaxWidth - this.moZ) - this.mpc;
        if (4 == getBusinessType()) {
            this.mpk.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize30));
            i = i2 - (this.mpa + this.mpb);
        } else {
            i = i2;
        }
        String str4 = null;
        if (advertAppInfo != null && advertAppInfo.bhS()) {
            str4 = adCard.userName.concat("APP");
        } else if (advertAppInfo != null && advertAppInfo.bhT()) {
            str4 = TextUtils.isEmpty(adCard.userName) ? "广告" : adCard.userName;
        }
        this.mpk.setText(com.baidu.g.a.e.a.a(str4, "广告", i, this.mpk.getPaint()));
        if (advertAppInfo != null && advertAppInfo.bhS()) {
            this.mpn = advertAppInfo.esX;
            this.mpj.setClickable(true);
            DownloadData b2 = b(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            a(adCard, b2);
            a(this.mpg, b2.getStatus(), str3);
            this.mpj.setData(b2);
            this.mpj.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    ap.setViewTextColor(this.mpg, R.color.cp_link_tip_a, 1);
                    ap.setBackgroundResource(this.mpg, R.drawable.ad_download_progress_button_bg);
                    this.mpg.setText(str3);
                    if (k.isEmpty(str)) {
                        this.mpg.setClickable(false);
                    } else {
                        this.mpg.setClickable(true);
                        this.mpg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.kzG != null && adCard.buttonClick != null && !u.QY(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.kzG.a(adCard.buttonClick.auR, adCard.buttonClick.auS, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int c2 = s.c(AdCardBaseView.this.eCn, str, (AdCardBaseView.this.krg == null || AdCardBaseView.this.krg.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.krg.getAdvertAppInfo().esU);
                                        if ((c2 == 1 || c2 == 2) && AdCardBaseView.this.kzG != null) {
                                            AdCardBaseView.this.kzG.d(c2, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.eCn.getPageActivity());
                                    aVar.Ba(adCard.popWindowText);
                                    aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int c3 = s.c(AdCardBaseView.this.eCn, str, (AdCardBaseView.this.krg == null || AdCardBaseView.this.krg.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.krg.getAdvertAppInfo().esU);
                                            if ((c3 == 1 || c3 == 2) && AdCardBaseView.this.kzG != null) {
                                                AdCardBaseView.this.kzG.d(c3, null);
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
                                    aVar.b(AdCardBaseView.this.eCn).bmC();
                                }
                            }
                        });
                    }
                } else {
                    this.mpg.setClickable(false);
                    this.mpg.setText(adCard.buttonTextDone);
                    ap.setBackgroundResource(this.mpg, R.drawable.ad_download_progress_button_bg);
                    ap.setViewTextColor(this.mpg, R.color.cp_btn_a, 1);
                }
            }
            this.mpj.setVisibility(8);
        }
        a(adCard);
        H(com.baidu.tbadk.core.k.bhh().isShowImages(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            Rg(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.ete != null && advertAppInfo.ete.adCloseInfo != null && advertAppInfo.ete.adCloseInfo.support_close.intValue() > 0) {
            this.mph.setVisibility(0);
            this.mph.mtn = R.drawable.icon_home_delete_n;
            this.mph.setPage(getBusinessType());
            this.mph.setData(advertAppInfo);
            l.addToParentArea(this.eCn.getPageActivity(), this.mpi, 40, 40, 40, 120);
            this.mpi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.mph.performClick();
                }
            });
        } else {
            this.mph.setVisibility(8);
            this.krm.setOnClickListener(null);
        }
        this.mpo.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.hSE.getLayoutParams();
        if (4 == getBusinessType()) {
            this.mpo.setVisibility(8);
            this.mpo.setBarNameClickEnabled(false);
            this.mpo.setShareVisible(false);
            this.mpo.setShowPraiseNum(false);
            this.mpo.setCommentNumEnable(false);
            this.mpo.setReplyTimeVisible(false);
            layoutParams2.height = this.mpe;
            this.mpq.setVisibility(0);
            this.mpr.setVisibility(8);
            this.hSE.setVisibility(8);
            dz(this.mpi);
        } else {
            b(adCard, bVar);
            this.hSE.setVisibility(0);
            com.baidu.tbadk.a.b.a.a(this.hSE, (AbsThreadDataSupport) null);
            ((RelativeLayout.LayoutParams) this.mpj.getLayoutParams()).addRule(11, -1);
            ((RelativeLayout.LayoutParams) this.mpg.getLayoutParams()).addRule(11, -1);
            this.mpt.setVisibility(8);
            this.mpl.requestLayout();
        }
        a(adCard, this.hSh, getBusinessType());
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 instanceof AdvertAppInfo) {
            advertAppInfo2.AL(at.cX(adCard.time));
        }
        this.mpp.setData(advertAppInfo2);
        ((TextView) this.mpp.getUserName()).setText(adCard.userName);
        com.baidu.tbadk.a.b.a.a((TextView) this.mpp.getUserName());
        this.mpp.getUserName().setOnClickListener(bVar);
        this.mpp.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.mpp.getUserName()).setText(adCard.userName);
            }
        });
        if (4 == getBusinessType() && adCard.isPBBanner) {
            this.jhv.setVisibility(0);
            this.jhv.setBackgroundResource(R.color.cp_bg_line_b);
            this.mpp.setVisibility(8);
        } else {
            this.jhv.setVisibility(8);
        }
        if ((com.baidu.tieba.frs.b.cuL().cuF() || com.baidu.tieba.frs.a.cuE().cuF()) && isInFrsAllThread()) {
            this.moQ.setVisibility(0);
            ap.setBackgroundColor(this.moQ, R.color.cp_bg_line_d);
        } else {
            this.moQ.setVisibility(8);
        }
        a(adCard, advertAppInfo);
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private void dz(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.mpt.setVisibility(0);
            this.mpt.removeAllViews();
            view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.mpt.addView(view);
            int dimension = (int) getResources().getDimension(R.dimen.tbds26);
            int dimension2 = (int) getResources().getDimension(R.dimen.tbds33);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mpj.getLayoutParams();
            layoutParams.setMargins(0, dimension, dimension2, dimension);
            layoutParams.addRule(11, 0);
            layoutParams.addRule(0, this.mpt.getId());
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mpg.getLayoutParams();
            layoutParams2.addRule(11, 0);
            layoutParams2.setMargins(0, dimension, dimension2, dimension);
            layoutParams2.addRule(0, this.mpt.getId());
            this.mpl.requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bGQ();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bGR();
    }

    private void a(AdCard adCard, DownloadData downloadData) {
        if (adCard.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.mpj.getDownloadStatus());
        }
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.directDownload) {
            this.mpj.setOnClickListener(bVar);
        } else {
            this.mpj.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public boolean bL(View view) {
                    AdCardBaseView.this.dye();
                    return false;
                }
            });
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey EY;
        if (!adCard.directDownload && advertAppInfo != null && advertAppInfo.bhS()) {
            String scheme = adCard.getScheme();
            String str = advertAppInfo.esU;
            if (!TextUtils.isEmpty(str)) {
                EY = com.baidu.tieba.ad.download.d.bGX().EX(str);
            } else {
                EY = com.baidu.tieba.ad.download.d.bGX().EY(scheme);
            }
            if (EY == null) {
                EY = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.esX);
                com.baidu.tieba.ad.download.d.bGX().a(EY, null);
            }
            i(EY);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.fMm = downloadCacheKey;
            bGR();
            this.fMn = null;
            AdDownloadData d2 = com.baidu.tieba.ad.download.d.bGX().d(downloadCacheKey);
            if (d2 != null) {
                this.mpj.a(d2.getCurrentState());
            } else {
                this.mpj.a(DownloadStatus.STATUS_NONE);
            }
            String str = "";
            if (this.krg != null && this.krg.getAdvertAppInfo() != null) {
                str = this.krg.getAdvertAppInfo().page;
                d2.setExtInfo(this.krg.getAdvertAppInfo().extensionInfo);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.mpj, d2, str);
            this.fMn = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d2.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d2);
            }
            bGQ();
        }
    }

    private void bGQ() {
        if (this.fMm != null && this.fMn != null) {
            com.baidu.tieba.ad.download.d.bGX().a(this.fMm, this.fMn);
        }
    }

    private void bGR() {
        if (this.fMm != null && this.fMn != null) {
            com.baidu.tieba.ad.download.d.bGX().b(this.fMm, this.fMn);
        }
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void b(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.mpr.setVisibility(0);
            this.mpo.setVisibility(8);
            return;
        }
        this.mpr.setVisibility(8);
        this.mpo.setVisibility(0);
        this.mpo.setBarNameClickEnabled(false);
        this.mpo.setReplyTimeVisible(false);
        this.mpo.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.mpo.setAgreeClickable(true);
            this.mpo.setPraiseContainerBgGray(false);
        } else {
            this.mpo.setAgreeClickable(false);
            this.mpo.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.mpo.setShareClickable(true);
            this.mpo.setShareContainerBgGray(false);
        } else {
            this.mpo.setShareClickable(false);
            this.mpo.setShareContainerBgGray(true);
        }
        if (this.mpo.getCommentContainer() != null) {
            this.mpo.getCommentContainer().setOnClickListener(bVar);
        }
        this.mpo.setNeedAddReplyIcon(true);
        this.mpo.setCommentNumEnable(false);
        this.mpo.setCommentClickable(true);
        this.mpo.setReplayContainerBgGray(true);
        this.mpo.setOnClickListener(bVar);
        this.mpo.setShareData(adCard);
        this.mpo.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        ap.setBackgroundResource(this.hSE, R.color.cp_bg_line_b);
        com.baidu.tbadk.a.b.a.ba(this.hSE);
        this.mph.onChangeSkinType();
        this.mpp.onChangeSkinType(this.eCn, TbadkCoreApplication.getInst().getSkinType());
        this.mpo.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            ap.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.hSh, R.color.cp_bg_line_e);
        } else {
            ap.setBackgroundColor(this.hSh, R.color.transparent);
        }
        com.baidu.tbadk.a.b.a.b((TextView) this.mpp.getUserName());
        ap.setViewTextColor(this.krk, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.mpk, R.color.cp_cont_d);
        ap.setViewTextColor(this.krm, R.color.cp_cont_d, 1);
        this.mpj.onChangeSkinType(i);
    }

    protected void a(AdCard.b bVar) {
        int c2;
        if (bVar != null) {
            if (b(bVar) && !u.QY(bVar.scheme)) {
                if (this.kzG != null) {
                    this.kzG.a(bVar.auR, bVar.auS, null);
                }
            } else if (this.krg != null && this.krg.getAdvertAppInfo() != null) {
                String Rh = Rh(bVar.scheme);
                String str = this.krg.getAdvertAppInfo().esU;
                if (!this.krg.directDownload && this.krg.getAdvertAppInfo().bhS()) {
                    c2 = s.d(this.eCn, Rh, str);
                } else {
                    c2 = s.c(this.eCn, Rh, str);
                }
                if (c2 == 1 || c2 == 2) {
                    if (this.kzG != null) {
                        this.kzG.d(c2, null);
                    }
                } else if (this.kzG != null) {
                    this.kzG.a(bVar.auR, bVar.auS, null);
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
                        if (AdCardBaseView.this.krg.hasAnimation()) {
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
        this.kyg = new a.C0762a();
        this.kyg.picUrl = tbImageView.getUrl();
        this.kyg.bxA = rect;
    }

    private void Rg(String str) {
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
                    com.baidu.adp.lib.e.c.mS().a(jSONObject.optString("pic_url"), 17, null, this.kzN, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.kzN), this.eCn.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.bhR() != 0) {
                l.showToast(this.eCn.getPageActivity(), R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.eCn.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.eCn.getPageActivity()) && this.kzH != null) {
                this.kzH.c(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(b(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.eCn.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bhS()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.eCn.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eCn.getPageActivity());
                aVar.Ba(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.mpj);
                        if (AdCardBaseView.this.mpj != null) {
                            AdCardBaseView.this.mpj.q(AdCardBaseView.this.b(advertAppInfo, i));
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
                aVar.b(this.eCn).bmC();
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
                    h.aX(this.eCn.getPageActivity(), advertAppInfo.esX);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, this.mpj);
                    apkDownloadView.s(b2);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.bGX().aG(this.eCn.getPageActivity(), advertAppInfo.esX);
                    return;
            }
        }
    }

    public a.C0762a getAnimationInfo() {
        return this.kyg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes26.dex */
    public class b implements View.OnClickListener {
        private AdCard mpG;

        public b(AdCard adCard) {
            this.mpG = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdCardBaseView.this.eCn.showToast(R.string.neterror);
            } else if (this.mpG != null && view != null && view.getId() != R.id.thread_info_commont_container) {
                AdvertAppInfo advertAppInfo = this.mpG.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.mpj;
                if (advertAppInfo != null && advertAppInfo.bhS()) {
                    a(advertAppInfo, z);
                } else {
                    h(advertAppInfo);
                }
            }
        }

        private void a(AdvertAppInfo advertAppInfo, boolean z) {
            if (this.mpG.directDownload || z) {
                b(advertAppInfo, z);
            } else {
                i(advertAppInfo);
            }
        }

        private void h(AdvertAppInfo advertAppInfo) {
            String scheme = this.mpG.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.esW;
            }
            if (this.mpG.hasAnimation()) {
            }
            int h = s.h(AdCardBaseView.this.eCn, AdCardBaseView.this.Rh(scheme));
            if (AdCardBaseView.this.kzG != null) {
                AdCardBaseView.this.kzG.d(h, null);
            }
        }

        private void b(AdvertAppInfo advertAppInfo, boolean z) {
            int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
            int status = ApkDownloadView.getStatus(AdCardBaseView.this.b(advertAppInfo, i));
            if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                return;
            }
            AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.mpj, z);
            AdCardBaseView.this.dye();
        }

        private void i(AdvertAppInfo advertAppInfo) {
            String scheme = this.mpG.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.esW;
            }
            int d = s.d(AdCardBaseView.this.eCn, scheme, advertAppInfo.esU);
            if (AdCardBaseView.this.kzG != null) {
                AdCardBaseView.this.kzG.d(d, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dye() {
        if (this.kzG != null) {
            this.kzG.d(3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Rh(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.kyg != null && this.kyg.isValid()) {
            String c0762a = this.kyg.toString();
            if (!TextUtils.isEmpty(c0762a)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(c0762a));
            }
        }
        if (!TextUtils.isEmpty(this.krg.getPreLoadData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.krg.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.krg.getNextPageData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.krg.getNextPageData()));
        }
        if (this.krg.hasAnimation()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.krg.isGoLandingPage()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.krg.isImmersiveStyle()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes26.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mpF;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mpF = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.mpF.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.mpn) ? false : true)) && adCardBaseView.mpn.equals(downloadData.getId())) {
                    int status = e.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.mpg.setText(R.string.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.mpg.setText(R.string.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes26.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mpF;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mpF = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.mpF.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.mpn) && adCardBaseView.mpn.equals(downloadData.getId())) {
                adCardBaseView.mpj.t(downloadData);
            }
        }
    }

    /* loaded from: classes26.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> mpF;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.mpF = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.mpF.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                String str = null;
                if (adCardBaseView.krg != null && adCardBaseView.krg.getAdvertAppInfo() != null) {
                    str = adCardBaseView.krg.getAdvertAppInfo().esU;
                }
                s.c(adCardBaseView.eCn, adCardBaseView.mps.scheme, str);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void cWT() {
        if (4 == getBusinessType()) {
            this.krk.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.moy != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.mps = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.eCn.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.eCn, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        return true;
    }

    private void a(View view, TextView textView, ApkDownloadView apkDownloadView, AdCard adCard) {
        if (adCard == null) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        if (adCard.getAdvertAppInfo().bhS()) {
            textView.setVisibility(8);
            apkDownloadView.setVisibility(0);
        } else if (k.isEmpty(adCard.buttonText)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.esX);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.esV);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.esU, 0));
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
