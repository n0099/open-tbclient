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
/* loaded from: classes20.dex */
public abstract class AdCardBaseView extends BaseLegoCardView<AdCard> implements com.baidu.tieba.lego.card.b.a {
    private com.baidu.tieba.ad.download.a.d foA;
    private DownloadCacheKey foz;
    protected View hjN;
    protected View hkk;
    private View iyN;
    private AdCard jHh;
    protected TextView jHl;
    protected TextView jHn;
    private a.C0731a jNQ;
    private final int jPx;
    protected TextView lEA;
    protected RelativeLayout lEB;
    protected View lEC;
    protected String lED;
    private AdThreadCommentAndPraiseInfoLayout lEE;
    protected AdThreadUserInfoLayout lEF;
    protected View lEG;
    protected View lEH;
    protected AdCard.b lEI;
    private FrameLayout lEJ;
    protected CustomMessageListener lEK;
    protected CustomMessageListener lEL;
    protected CustomMessageListener lEM;
    protected ViewStub lEe;
    protected View lEf;
    protected View lEg;
    protected final int lEh;
    protected final int lEi;
    protected final int lEj;
    protected final int lEk;
    protected final int lEl;
    protected final int lEm;
    protected final int lEn;
    protected final int lEo;
    private final int lEp;
    private final int lEq;
    private final int lEr;
    private final int lEs;
    private int lEt;
    private int lEu;
    private int lEv;
    protected TextView lEw;
    private AdCloseView lEx;
    private LinearLayout lEy;
    protected ApkDownloadView lEz;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void di(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.jPx = l.getEquipmentWidth(getContext());
        this.foA = null;
        this.lEK = new a(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG, this);
        this.lEL = new d(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG, this);
        this.lEM = new c(CmdConfigCustom.CMD_USER_INFO_CHANGED, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.ds640);
        this.mImageHeight = (int) resources.getDimension(R.dimen.ds278);
        this.lEh = (int) resources.getDimension(R.dimen.tbds92);
        this.lEi = (int) resources.getDimension(R.dimen.tbds92);
        this.lEj = (int) resources.getDimension(R.dimen.tbds20);
        this.lEm = (int) resources.getDimension(R.dimen.tbds90);
        this.lEn = (int) resources.getDimension(R.dimen.tbds90);
        this.lEo = (int) resources.getDimension(R.dimen.tbds22);
        this.lEk = (int) resources.getDimension(R.dimen.tbds44);
        this.lEl = (int) resources.getDimension(R.dimen.tbds44);
        this.lEt = (int) resources.getDimension(R.dimen.ds12);
        this.lEu = (int) resources.getDimension(R.dimen.ds1);
        this.lEv = (int) resources.getDimension(R.dimen.ds18);
        this.lEp = (int) resources.getDimension(R.dimen.tbds208);
        this.lEq = (int) resources.getDimension(R.dimen.tbds33);
        this.lEr = (int) resources.getDimension(R.dimen.tbds72);
        this.lEs = (int) resources.getDimension(R.dimen.tbds48);
    }

    protected void E(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.lEE.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cMq() {
        MessageManager.getInstance().registerListener(this.lEK);
        MessageManager.getInstance().registerListener(this.lEL);
        MessageManager.getInstance().registerListener(this.lEM);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.hkk = this.mRootView.findViewById(R.id.bottom_line);
        this.iyN = this.mRootView.findViewById(R.id.top_line);
        this.lEg = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.lEg.setClickable(true);
        this.jHl = (TextView) this.mRootView.findViewById(R.id.ad_title);
        com.baidu.tbadk.a.b.a.d(this.jHl, R.dimen.tbds32, R.dimen.tbds20);
        this.lEw = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.lEz = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.lEA = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.lEB = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.lEz.y(this.efr.getUniqueId());
        this.lEK.setTag(this.efr.getUniqueId());
        this.lEC = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.lEL.setTag(this.efr.getUniqueId());
        this.lEM.setTag(this.efr.getUniqueId());
        this.lEE = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.lEE.setStyle(1);
        this.lEF = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        this.lEJ = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        if (1 == getBusinessType()) {
            this.lEF.setShowFlag(1413);
        }
        this.lEy = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.lEx = (AdCloseView) this.lEy.findViewById(R.id.ad_close_view);
        ViewGroup.LayoutParams layoutParams = this.lEx.lIB.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.lEx.lIB.getLayoutParams();
        int dimens = l.getDimens(getContext(), R.dimen.tbds62);
        layoutParams2.width = dimens;
        layoutParams.height = dimens;
        this.jHn = (TextView) this.lEy.findViewById(R.id.feed_tag);
        this.jHn.setVisibility(8);
        this.lEF.addAdTagView(this.lEy);
        this.hjN = this.mRootView.findViewById(R.id.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.lEk) - this.lEl) - this.lEh) - this.lEj;
            this.lEE.setVisibility(8);
        } else {
            this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.lEk) - this.lEl;
            this.lEE.setVisibility(0);
        }
        this.lEe = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.lEe.setLayoutResource(getCustomLayout());
        this.lEf = this.lEe.inflate();
        com.baidu.tbadk.a.b.a.d(this.lEf, R.dimen.tbds32, R.dimen.tbds14);
        this.lEG = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.lEH = this.mRootView.findViewById(R.id.frs_bottom_view);
        di(this.lEf);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(final AdCard adCard) {
        final String str;
        int i;
        this.jHh = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.lEF.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.bmw() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.efr.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        a(adCard, bVar);
        this.lEw.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lEC.getLayoutParams();
        if (4 == getBusinessType()) {
            if (adCard.isPBBanner) {
                layoutParams.leftMargin = 0;
                this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.lEk) - this.lEl;
            } else {
                layoutParams.leftMargin = this.lEh + this.lEj;
                this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.lEk) - this.lEl) - this.lEh) - this.lEj;
            }
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.lEF.getHeaderImg(), adCard.portraitClick, bVar);
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String Pt = Pt(str2);
            this.jHl.setMaxLines(adCard.titleLines <= 0 ? 4 : adCard.titleLines);
            if (4 == getBusinessType()) {
                this.jHl.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize42));
            } else {
                this.jHl.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize44));
            }
            this.jHl.setText(Pt);
            this.jHl.setVisibility(0);
        } else {
            this.jHl.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.bcx()) && k.isEmpty(str3);
        a(this.lEB, this.lEw, this.lEz, adCard);
        int i2 = (this.mMaxWidth - this.lEp) - this.lEs;
        if (4 == getBusinessType()) {
            this.lEA.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize30));
            i = i2 - (this.lEq + this.lEr);
        } else {
            i = i2;
        }
        String str4 = null;
        if (advertAppInfo != null && advertAppInfo.bcw()) {
            str4 = adCard.userName.concat("APP");
        } else if (advertAppInfo != null && advertAppInfo.bcx()) {
            str4 = TextUtils.isEmpty(adCard.userName) ? "广告" : adCard.userName;
        }
        this.lEA.setText(com.baidu.g.a.e.a.a(str4, "广告", i, this.lEA.getPaint()));
        if (advertAppInfo != null && advertAppInfo.bcw()) {
            this.lED = advertAppInfo.dWm;
            this.lEz.setClickable(true);
            DownloadData b2 = b(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            a(adCard, b2);
            a(this.lEw, b2.getStatus(), str3);
            this.lEz.setData(b2);
            this.lEz.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    ap.setViewTextColor(this.lEw, R.color.cp_link_tip_a, 1);
                    ap.setBackgroundResource(this.lEw, R.drawable.ad_download_progress_button_bg);
                    this.lEw.setText(str3);
                    if (k.isEmpty(str)) {
                        this.lEw.setClickable(false);
                    } else {
                        this.lEw.setClickable(true);
                        this.lEw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.jPq != null && adCard.buttonClick != null && !u.Pl(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.jPq.a(adCard.buttonClick.atF, adCard.buttonClick.atG, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int c2 = s.c(AdCardBaseView.this.efr, str, (AdCardBaseView.this.jHh == null || AdCardBaseView.this.jHh.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.jHh.getAdvertAppInfo().dWj);
                                        if ((c2 == 1 || c2 == 2) && AdCardBaseView.this.jPq != null) {
                                            AdCardBaseView.this.jPq.d(c2, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.efr.getPageActivity());
                                    aVar.zA(adCard.popWindowText);
                                    aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int c3 = s.c(AdCardBaseView.this.efr, str, (AdCardBaseView.this.jHh == null || AdCardBaseView.this.jHh.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.jHh.getAdvertAppInfo().dWj);
                                            if ((c3 == 1 || c3 == 2) && AdCardBaseView.this.jPq != null) {
                                                AdCardBaseView.this.jPq.d(c3, null);
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
                                    aVar.b(AdCardBaseView.this.efr).bhg();
                                }
                            }
                        });
                    }
                } else {
                    this.lEw.setClickable(false);
                    this.lEw.setText(adCard.buttonTextDone);
                    ap.setBackgroundResource(this.lEw, R.drawable.ad_download_progress_button_bg);
                    ap.setViewTextColor(this.lEw, R.color.cp_btn_a, 1);
                }
            }
            this.lEz.setVisibility(8);
        }
        a(adCard);
        E(com.baidu.tbadk.core.k.bbM().isShowImages(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            Pu(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.dWs != null && advertAppInfo.dWs.adCloseInfo != null && advertAppInfo.dWs.adCloseInfo.support_close.intValue() > 0) {
            this.lEx.setVisibility(0);
            this.lEx.lIC = R.drawable.icon_home_delete_n;
            this.lEx.setPage(getBusinessType());
            this.lEx.setData(advertAppInfo);
            l.addToParentArea(this.efr.getPageActivity(), this.lEy, 40, 40, 40, 120);
            this.lEy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.lEx.performClick();
                }
            });
        } else {
            this.lEx.setVisibility(8);
            this.jHn.setOnClickListener(null);
        }
        this.lEE.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.hkk.getLayoutParams();
        if (4 == getBusinessType()) {
            this.lEE.setVisibility(8);
            this.lEE.setBarNameClickEnabled(false);
            this.lEE.setShareVisible(false);
            this.lEE.setShowPraiseNum(false);
            this.lEE.setCommentNumEnable(false);
            this.lEE.setReplyTimeVisible(false);
            layoutParams2.height = this.lEu;
            this.lEG.setVisibility(0);
            this.lEH.setVisibility(8);
            this.hkk.setVisibility(8);
            dj(this.lEy);
        } else {
            b(adCard, bVar);
            this.hkk.setVisibility(0);
            com.baidu.tbadk.a.b.a.a(this.hkk, (AbsThreadDataSupport) null);
            ((RelativeLayout.LayoutParams) this.lEz.getLayoutParams()).addRule(11, -1);
            ((RelativeLayout.LayoutParams) this.lEw.getLayoutParams()).addRule(11, -1);
            this.lEJ.setVisibility(8);
            this.lEB.requestLayout();
        }
        a(adCard, this.hjN, getBusinessType());
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 instanceof AdvertAppInfo) {
            advertAppInfo2.zl(at.cM(adCard.time));
        }
        this.lEF.setData(advertAppInfo2);
        ((TextView) this.lEF.getUserName()).setText(adCard.userName);
        com.baidu.tbadk.a.b.a.a((TextView) this.lEF.getUserName());
        this.lEF.getUserName().setOnClickListener(bVar);
        this.lEF.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.lEF.getUserName()).setText(adCard.userName);
            }
        });
        if (4 == getBusinessType() && adCard.isPBBanner) {
            this.iyN.setVisibility(0);
            this.iyN.setBackgroundResource(R.color.cp_bg_line_b);
            this.lEF.setVisibility(8);
        } else {
            this.iyN.setVisibility(8);
        }
        if ((com.baidu.tieba.frs.b.ckT().ckN() || com.baidu.tieba.frs.a.ckM().ckN()) && isInFrsAllThread()) {
            this.lEg.setVisibility(0);
            ap.setBackgroundColor(this.lEg, R.color.cp_bg_line_d);
        } else {
            this.lEg.setVisibility(8);
        }
        a(adCard, advertAppInfo);
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private void dj(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.lEJ.setVisibility(0);
            this.lEJ.removeAllViews();
            view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.lEJ.addView(view);
            int dimension = (int) getResources().getDimension(R.dimen.tbds26);
            int dimension2 = (int) getResources().getDimension(R.dimen.tbds33);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lEz.getLayoutParams();
            layoutParams.setMargins(0, dimension, dimension2, dimension);
            layoutParams.addRule(11, 0);
            layoutParams.addRule(0, this.lEJ.getId());
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lEw.getLayoutParams();
            layoutParams2.addRule(11, 0);
            layoutParams2.setMargins(0, dimension, dimension2, dimension);
            layoutParams2.addRule(0, this.lEJ.getId());
            this.lEB.requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bAZ();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bBa();
    }

    private void a(AdCard adCard, DownloadData downloadData) {
        if (adCard.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.lEz.getDownloadStatus());
        }
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.directDownload) {
            this.lEz.setOnClickListener(bVar);
        } else {
            this.lEz.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public boolean bC(View view) {
                    AdCardBaseView.this.dnD();
                    return false;
                }
            });
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey Dx;
        if (!adCard.directDownload && advertAppInfo != null && advertAppInfo.bcw()) {
            String scheme = adCard.getScheme();
            String str = advertAppInfo.dWj;
            if (!TextUtils.isEmpty(str)) {
                Dx = com.baidu.tieba.ad.download.d.bBg().Dw(str);
            } else {
                Dx = com.baidu.tieba.ad.download.d.bBg().Dx(scheme);
            }
            if (Dx == null) {
                Dx = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.dWm);
                com.baidu.tieba.ad.download.d.bBg().a(Dx, null);
            }
            i(Dx);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.foz = downloadCacheKey;
            bBa();
            this.foA = null;
            AdDownloadData d2 = com.baidu.tieba.ad.download.d.bBg().d(downloadCacheKey);
            if (d2 != null) {
                this.lEz.a(d2.getCurrentState());
            } else {
                this.lEz.a(DownloadStatus.STATUS_NONE);
            }
            String str = "";
            if (this.jHh != null && this.jHh.getAdvertAppInfo() != null) {
                str = this.jHh.getAdvertAppInfo().page;
                d2.setExtInfo(this.jHh.getAdvertAppInfo().extensionInfo);
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.lEz, d2, str);
            this.foA = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d2.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d2);
            }
            bAZ();
        }
    }

    private void bAZ() {
        if (this.foz != null && this.foA != null) {
            com.baidu.tieba.ad.download.d.bBg().a(this.foz, this.foA);
        }
    }

    private void bBa() {
        if (this.foz != null && this.foA != null) {
            com.baidu.tieba.ad.download.d.bBg().b(this.foz, this.foA);
        }
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void b(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.lEH.setVisibility(0);
            this.lEE.setVisibility(8);
            return;
        }
        this.lEH.setVisibility(8);
        this.lEE.setVisibility(0);
        this.lEE.setBarNameClickEnabled(false);
        this.lEE.setReplyTimeVisible(false);
        this.lEE.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.lEE.setAgreeClickable(true);
            this.lEE.setPraiseContainerBgGray(false);
        } else {
            this.lEE.setAgreeClickable(false);
            this.lEE.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.lEE.setShareClickable(true);
            this.lEE.setShareContainerBgGray(false);
        } else {
            this.lEE.setShareClickable(false);
            this.lEE.setShareContainerBgGray(true);
        }
        if (this.lEE.getCommentContainer() != null) {
            this.lEE.getCommentContainer().setOnClickListener(bVar);
        }
        this.lEE.setNeedAddReplyIcon(true);
        this.lEE.setCommentNumEnable(false);
        this.lEE.setCommentClickable(true);
        this.lEE.setReplayContainerBgGray(true);
        this.lEE.setOnClickListener(bVar);
        this.lEE.setShareData(adCard);
        this.lEE.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        ap.setBackgroundResource(this.hkk, R.color.cp_bg_line_b);
        com.baidu.tbadk.a.b.a.aW(this.hkk);
        this.lEx.onChangeSkinType();
        this.lEF.onChangeSkinType(this.efr, TbadkCoreApplication.getInst().getSkinType());
        this.lEE.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            ap.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.hjN, R.color.cp_bg_line_e);
        } else {
            ap.setBackgroundColor(this.hjN, R.color.transparent);
        }
        com.baidu.tbadk.a.b.a.b((TextView) this.lEF.getUserName());
        ap.setViewTextColor(this.jHl, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.lEA, R.color.cp_cont_d);
        ap.setViewTextColor(this.jHn, R.color.cp_cont_d, 1);
        this.lEz.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String Pt(String str) {
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
            if (b(bVar) && !u.Pl(bVar.scheme)) {
                if (this.jPq != null) {
                    this.jPq.a(bVar.atF, bVar.atG, null);
                }
            } else if (this.jHh != null && this.jHh.getAdvertAppInfo() != null) {
                String Pv = Pv(bVar.scheme);
                String str = this.jHh.getAdvertAppInfo().dWj;
                if (!this.jHh.directDownload && this.jHh.getAdvertAppInfo().bcw()) {
                    c2 = s.d(this.efr, Pv, str);
                } else {
                    c2 = s.c(this.efr, Pv, str);
                }
                if (c2 == 1 || c2 == 2) {
                    if (this.jPq != null) {
                        this.jPq.d(c2, null);
                    }
                } else if (this.jPq != null) {
                    this.jPq.a(bVar.atF, bVar.atG, null);
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
                        if (AdCardBaseView.this.jHh.hasAnimation()) {
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
        this.jNQ = new a.C0731a();
        this.jNQ.picUrl = tbImageView.getUrl();
        this.jNQ.rect = rect;
    }

    private void Pu(String str) {
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
                    com.baidu.adp.lib.e.c.mM().a(jSONObject.optString("pic_url"), 17, null, this.jPx, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.jPx), this.efr.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.bcv() != 0) {
                l.showToast(this.efr.getPageActivity(), R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.efr.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.efr.getPageActivity()) && this.jPr != null) {
                this.jPr.c(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(b(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.efr.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bcw()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.efr.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.efr.getPageActivity());
                aVar.zA(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.lEz);
                        if (AdCardBaseView.this.lEz != null) {
                            AdCardBaseView.this.lEz.q(AdCardBaseView.this.b(advertAppInfo, i));
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
                aVar.b(this.efr).bhg();
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
                    h.aQ(this.efr.getPageActivity(), advertAppInfo.dWm);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, this.lEz);
                    apkDownloadView.s(b2);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.bBg().az(this.efr.getPageActivity(), advertAppInfo.dWm);
                    return;
            }
        }
    }

    public a.C0731a getAnimationInfo() {
        return this.jNQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class b implements View.OnClickListener {
        private AdCard lEW;

        public b(AdCard adCard) {
            this.lEW = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdCardBaseView.this.efr.showToast(R.string.neterror);
            } else if (this.lEW != null && view != null && view.getId() != R.id.thread_info_commont_container) {
                AdvertAppInfo advertAppInfo = this.lEW.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.lEz;
                if (advertAppInfo != null && advertAppInfo.bcw()) {
                    a(advertAppInfo, z);
                } else {
                    h(advertAppInfo);
                }
            }
        }

        private void a(AdvertAppInfo advertAppInfo, boolean z) {
            if (this.lEW.directDownload || z) {
                b(advertAppInfo, z);
            } else {
                i(advertAppInfo);
            }
        }

        private void h(AdvertAppInfo advertAppInfo) {
            String scheme = this.lEW.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.dWl;
            }
            if (this.lEW.hasAnimation()) {
            }
            int h = s.h(AdCardBaseView.this.efr, AdCardBaseView.this.Pv(scheme));
            if (AdCardBaseView.this.jPq != null) {
                AdCardBaseView.this.jPq.d(h, null);
            }
        }

        private void b(AdvertAppInfo advertAppInfo, boolean z) {
            int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
            int status = ApkDownloadView.getStatus(AdCardBaseView.this.b(advertAppInfo, i));
            if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                return;
            }
            AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.lEz, z);
            AdCardBaseView.this.dnD();
        }

        private void i(AdvertAppInfo advertAppInfo) {
            String scheme = this.lEW.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.dWl;
            }
            int d = s.d(AdCardBaseView.this.efr, scheme, advertAppInfo.dWj);
            if (AdCardBaseView.this.jPq != null) {
                AdCardBaseView.this.jPq.d(d, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dnD() {
        if (this.jPq != null) {
            this.jPq.d(3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Pv(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.jNQ != null && this.jNQ.isValid()) {
            String c0731a = this.jNQ.toString();
            if (!TextUtils.isEmpty(c0731a)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(c0731a));
            }
        }
        if (!TextUtils.isEmpty(this.jHh.getPreLoadData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.jHh.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.jHh.getNextPageData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.jHh.getNextPageData()));
        }
        if (this.jHh.hasAnimation()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.jHh.isGoLandingPage()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.jHh.isImmersiveStyle()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes20.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> lEV;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.lEV = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.lEV.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.lED) ? false : true)) && adCardBaseView.lED.equals(downloadData.getId())) {
                    int status = e.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.lEw.setText(R.string.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.lEw.setText(R.string.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes20.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> lEV;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.lEV = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.lEV.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.lED) && adCardBaseView.lED.equals(downloadData.getId())) {
                adCardBaseView.lEz.t(downloadData);
            }
        }
    }

    /* loaded from: classes20.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> lEV;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.lEV = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.lEV.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                String str = null;
                if (adCardBaseView.jHh != null && adCardBaseView.jHh.getAdvertAppInfo() != null) {
                    str = adCardBaseView.jHh.getAdvertAppInfo().dWj;
                }
                s.c(adCardBaseView.efr, adCardBaseView.lEI.scheme, str);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void cMw() {
        if (4 == getBusinessType()) {
            this.jHl.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.lDO != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.lEI = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.efr.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.efr, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        return true;
    }

    private void a(View view, TextView textView, ApkDownloadView apkDownloadView, AdCard adCard) {
        if (adCard == null) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        if (adCard.getAdvertAppInfo().bcw()) {
            textView.setVisibility(8);
            apkDownloadView.setVisibility(0);
        } else if (k.isEmpty(adCard.buttonText)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    DownloadData b(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.dWm);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dWk);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.dWj, 0));
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
