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
    private DownloadCacheKey fov;
    private com.baidu.tieba.ad.download.a.d fow;
    protected View hjJ;
    protected View hkg;
    private View iyH;
    private AdCard jHb;
    protected TextView jHf;
    protected TextView jHh;
    private a.C0731a jNK;
    private final int jPr;
    protected ViewStub lDT;
    protected View lDU;
    protected View lDV;
    protected final int lDW;
    protected final int lDX;
    protected final int lDY;
    protected final int lDZ;
    protected CustomMessageListener lEA;
    protected CustomMessageListener lEB;
    protected final int lEa;
    protected final int lEb;
    protected final int lEc;
    protected final int lEd;
    private final int lEe;
    private final int lEf;
    private final int lEg;
    private final int lEh;
    private int lEi;
    private int lEj;
    private int lEk;
    protected TextView lEl;
    private AdCloseView lEm;
    private LinearLayout lEn;
    protected ApkDownloadView lEo;
    protected TextView lEp;
    protected RelativeLayout lEq;
    protected View lEr;
    protected String lEs;
    private AdThreadCommentAndPraiseInfoLayout lEt;
    protected AdThreadUserInfoLayout lEu;
    protected View lEv;
    protected View lEw;
    protected AdCard.b lEx;
    private FrameLayout lEy;
    protected CustomMessageListener lEz;
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
        this.jPr = l.getEquipmentWidth(getContext());
        this.fow = null;
        this.lEz = new a(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG, this);
        this.lEA = new d(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG, this);
        this.lEB = new c(CmdConfigCustom.CMD_USER_INFO_CHANGED, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.ds640);
        this.mImageHeight = (int) resources.getDimension(R.dimen.ds278);
        this.lDW = (int) resources.getDimension(R.dimen.tbds92);
        this.lDX = (int) resources.getDimension(R.dimen.tbds92);
        this.lDY = (int) resources.getDimension(R.dimen.tbds20);
        this.lEb = (int) resources.getDimension(R.dimen.tbds90);
        this.lEc = (int) resources.getDimension(R.dimen.tbds90);
        this.lEd = (int) resources.getDimension(R.dimen.tbds22);
        this.lDZ = (int) resources.getDimension(R.dimen.tbds44);
        this.lEa = (int) resources.getDimension(R.dimen.tbds44);
        this.lEi = (int) resources.getDimension(R.dimen.ds12);
        this.lEj = (int) resources.getDimension(R.dimen.ds1);
        this.lEk = (int) resources.getDimension(R.dimen.ds18);
        this.lEe = (int) resources.getDimension(R.dimen.tbds208);
        this.lEf = (int) resources.getDimension(R.dimen.tbds33);
        this.lEg = (int) resources.getDimension(R.dimen.tbds72);
        this.lEh = (int) resources.getDimension(R.dimen.tbds48);
    }

    protected void E(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.lEt.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cMp() {
        MessageManager.getInstance().registerListener(this.lEz);
        MessageManager.getInstance().registerListener(this.lEA);
        MessageManager.getInstance().registerListener(this.lEB);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.hkg = this.mRootView.findViewById(R.id.bottom_line);
        this.iyH = this.mRootView.findViewById(R.id.top_line);
        this.lDV = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.lDV.setClickable(true);
        this.jHf = (TextView) this.mRootView.findViewById(R.id.ad_title);
        com.baidu.tbadk.a.b.a.d(this.jHf, R.dimen.tbds32, R.dimen.tbds20);
        this.lEl = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.lEo = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.lEp = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.lEq = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.lEo.y(this.efn.getUniqueId());
        this.lEz.setTag(this.efn.getUniqueId());
        this.lEr = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.lEA.setTag(this.efn.getUniqueId());
        this.lEB.setTag(this.efn.getUniqueId());
        this.lEt = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.lEt.setStyle(1);
        this.lEu = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        this.lEy = (FrameLayout) this.mRootView.findViewById(R.id.btn_pb_card_bottom_op_more_container);
        if (1 == getBusinessType()) {
            this.lEu.setShowFlag(1413);
        }
        this.lEn = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.lEm = (AdCloseView) this.lEn.findViewById(R.id.ad_close_view);
        ViewGroup.LayoutParams layoutParams = this.lEm.lIo.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.lEm.lIo.getLayoutParams();
        int dimens = l.getDimens(getContext(), R.dimen.tbds62);
        layoutParams2.width = dimens;
        layoutParams.height = dimens;
        this.jHh = (TextView) this.lEn.findViewById(R.id.feed_tag);
        this.jHh.setVisibility(8);
        this.lEu.addAdTagView(this.lEn);
        this.hjJ = this.mRootView.findViewById(R.id.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.lDZ) - this.lEa) - this.lDW) - this.lDY;
            this.lEt.setVisibility(8);
        } else {
            this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.lDZ) - this.lEa;
            this.lEt.setVisibility(0);
        }
        this.lDT = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.lDT.setLayoutResource(getCustomLayout());
        this.lDU = this.lDT.inflate();
        com.baidu.tbadk.a.b.a.d(this.lDU, R.dimen.tbds32, R.dimen.tbds14);
        this.lEv = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.lEw = this.mRootView.findViewById(R.id.frs_bottom_view);
        di(this.lDU);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(final AdCard adCard) {
        final String str;
        int i;
        this.jHb = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.lEu.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.bmw() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.efn.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        a(adCard, bVar);
        this.lEl.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lEr.getLayoutParams();
        if (4 == getBusinessType()) {
            if (adCard.isPBBanner) {
                layoutParams.leftMargin = 0;
                this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.lDZ) - this.lEa;
            } else {
                layoutParams.leftMargin = this.lDW + this.lDY;
                this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.lDZ) - this.lEa) - this.lDW) - this.lDY;
            }
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.lEu.getHeaderImg(), adCard.portraitClick, bVar);
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String Ps = Ps(str2);
            this.jHf.setMaxLines(adCard.titleLines <= 0 ? 4 : adCard.titleLines);
            if (4 == getBusinessType()) {
                this.jHf.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize42));
            } else {
                this.jHf.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize44));
            }
            this.jHf.setText(Ps);
            this.jHf.setVisibility(0);
        } else {
            this.jHf.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.bcx()) && k.isEmpty(str3);
        a(this.lEq, this.lEl, this.lEo, adCard);
        int i2 = (this.mMaxWidth - this.lEe) - this.lEh;
        if (4 == getBusinessType()) {
            this.lEp.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize30));
            i = i2 - (this.lEf + this.lEg);
        } else {
            i = i2;
        }
        String str4 = null;
        if (advertAppInfo != null && advertAppInfo.bcw()) {
            str4 = adCard.userName.concat("APP");
        } else if (advertAppInfo != null && advertAppInfo.bcx()) {
            str4 = TextUtils.isEmpty(adCard.userName) ? "广告" : adCard.userName;
        }
        this.lEp.setText(com.baidu.g.a.e.a.a(str4, "广告", i, this.lEp.getPaint()));
        if (advertAppInfo != null && advertAppInfo.bcw()) {
            this.lEs = advertAppInfo.dWi;
            this.lEo.setClickable(true);
            DownloadData b2 = b(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            a(adCard, b2);
            a(this.lEl, b2.getStatus(), str3);
            this.lEo.setData(b2);
            this.lEo.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    ap.setViewTextColor(this.lEl, R.color.cp_link_tip_a, 1);
                    ap.setBackgroundResource(this.lEl, R.drawable.ad_download_progress_button_bg);
                    this.lEl.setText(str3);
                    if (k.isEmpty(str)) {
                        this.lEl.setClickable(false);
                    } else {
                        this.lEl.setClickable(true);
                        this.lEl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.jPk != null && adCard.buttonClick != null && !u.Pk(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.jPk.a(adCard.buttonClick.atD, adCard.buttonClick.atE, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int c2 = s.c(AdCardBaseView.this.efn, str, (AdCardBaseView.this.jHb == null || AdCardBaseView.this.jHb.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.jHb.getAdvertAppInfo().dWf);
                                        if ((c2 == 1 || c2 == 2) && AdCardBaseView.this.jPk != null) {
                                            AdCardBaseView.this.jPk.d(c2, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.efn.getPageActivity());
                                    aVar.zz(adCard.popWindowText);
                                    aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int c3 = s.c(AdCardBaseView.this.efn, str, (AdCardBaseView.this.jHb == null || AdCardBaseView.this.jHb.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.jHb.getAdvertAppInfo().dWf);
                                            if ((c3 == 1 || c3 == 2) && AdCardBaseView.this.jPk != null) {
                                                AdCardBaseView.this.jPk.d(c3, null);
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
                                    aVar.b(AdCardBaseView.this.efn).bhg();
                                }
                            }
                        });
                    }
                } else {
                    this.lEl.setClickable(false);
                    this.lEl.setText(adCard.buttonTextDone);
                    ap.setBackgroundResource(this.lEl, R.drawable.ad_download_progress_button_bg);
                    ap.setViewTextColor(this.lEl, R.color.cp_btn_a, 1);
                }
            }
            this.lEo.setVisibility(8);
        }
        a(adCard);
        E(com.baidu.tbadk.core.k.bbM().isShowImages(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            Pt(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.dWo != null && advertAppInfo.dWo.adCloseInfo != null && advertAppInfo.dWo.adCloseInfo.support_close.intValue() > 0) {
            this.lEm.setVisibility(0);
            this.lEm.lIp = R.drawable.icon_home_delete_n;
            this.lEm.setPage(getBusinessType());
            this.lEm.setData(advertAppInfo);
            l.addToParentArea(this.efn.getPageActivity(), this.lEn, 40, 40, 40, 120);
            this.lEn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.lEm.performClick();
                }
            });
        } else {
            this.lEm.setVisibility(8);
            this.jHh.setOnClickListener(null);
        }
        this.lEt.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.hkg.getLayoutParams();
        if (4 == getBusinessType()) {
            this.lEt.setVisibility(8);
            this.lEt.setBarNameClickEnabled(false);
            this.lEt.setShareVisible(false);
            this.lEt.setShowPraiseNum(false);
            this.lEt.setCommentNumEnable(false);
            this.lEt.setReplyTimeVisible(false);
            layoutParams2.height = this.lEj;
            this.lEv.setVisibility(0);
            this.lEw.setVisibility(8);
            this.hkg.setVisibility(8);
            dj(this.lEn);
        } else {
            b(adCard, bVar);
            this.hkg.setVisibility(0);
            com.baidu.tbadk.a.b.a.a(this.hkg, (AbsThreadDataSupport) null);
            ((RelativeLayout.LayoutParams) this.lEo.getLayoutParams()).addRule(11, -1);
            ((RelativeLayout.LayoutParams) this.lEl.getLayoutParams()).addRule(11, -1);
            this.lEy.setVisibility(8);
            this.lEq.requestLayout();
        }
        a(adCard, this.hjJ, getBusinessType());
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 instanceof AdvertAppInfo) {
            advertAppInfo2.zk(at.cM(adCard.time));
        }
        this.lEu.setData(advertAppInfo2);
        ((TextView) this.lEu.getUserName()).setText(adCard.userName);
        com.baidu.tbadk.a.b.a.a((TextView) this.lEu.getUserName());
        this.lEu.getUserName().setOnClickListener(bVar);
        this.lEu.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.lEu.getUserName()).setText(adCard.userName);
            }
        });
        if (4 == getBusinessType() && adCard.isPBBanner) {
            this.iyH.setVisibility(0);
            this.iyH.setBackgroundResource(R.color.cp_bg_line_b);
            this.lEu.setVisibility(8);
        } else {
            this.iyH.setVisibility(8);
        }
        if ((com.baidu.tieba.frs.b.ckS().ckM() || com.baidu.tieba.frs.a.ckL().ckM()) && isInFrsAllThread()) {
            this.lDV.setVisibility(0);
            ap.setBackgroundColor(this.lDV, R.color.cp_bg_line_d);
        } else {
            this.lDV.setVisibility(8);
        }
        a(adCard, advertAppInfo);
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private void dj(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.lEy.setVisibility(0);
            this.lEy.removeAllViews();
            view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.lEy.addView(view);
            int dimension = (int) getResources().getDimension(R.dimen.tbds26);
            int dimension2 = (int) getResources().getDimension(R.dimen.tbds33);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lEo.getLayoutParams();
            layoutParams.setMargins(0, dimension, dimension2, dimension);
            layoutParams.addRule(11, 0);
            layoutParams.addRule(0, this.lEy.getId());
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lEl.getLayoutParams();
            layoutParams2.addRule(11, 0);
            layoutParams2.setMargins(0, dimension, dimension2, dimension);
            layoutParams2.addRule(0, this.lEy.getId());
            this.lEq.requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bAY();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bAZ();
    }

    private void a(AdCard adCard, DownloadData downloadData) {
        if (adCard.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.lEo.getDownloadStatus());
        }
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.directDownload) {
            this.lEo.setOnClickListener(bVar);
        } else {
            this.lEo.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public boolean bC(View view) {
                    AdCardBaseView.this.dnA();
                    return false;
                }
            });
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey Dw;
        if (!adCard.directDownload && advertAppInfo != null && advertAppInfo.bcw()) {
            String scheme = adCard.getScheme();
            String str = advertAppInfo.dWf;
            if (!TextUtils.isEmpty(str)) {
                Dw = com.baidu.tieba.ad.download.d.bBf().Dv(str);
            } else {
                Dw = com.baidu.tieba.ad.download.d.bBf().Dw(scheme);
            }
            if (Dw == null) {
                Dw = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.dWi);
                com.baidu.tieba.ad.download.d.bBf().a(Dw, null);
            }
            i(Dw);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.fov = downloadCacheKey;
            bAZ();
            this.fow = null;
            AdDownloadData d2 = com.baidu.tieba.ad.download.d.bBf().d(downloadCacheKey);
            if (d2 != null) {
                this.lEo.a(d2.getCurrentState());
            } else {
                this.lEo.a(DownloadStatus.STATUS_NONE);
            }
            String str = "";
            if (this.jHb != null && this.jHb.getAdvertAppInfo() != null) {
                str = this.jHb.getAdvertAppInfo().page;
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.lEo, d2, str);
            this.fow = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d2.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d2);
            }
            bAY();
        }
    }

    private void bAY() {
        if (this.fov != null && this.fow != null) {
            com.baidu.tieba.ad.download.d.bBf().a(this.fov, this.fow);
        }
    }

    private void bAZ() {
        if (this.fov != null && this.fow != null) {
            com.baidu.tieba.ad.download.d.bBf().b(this.fov, this.fow);
        }
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void b(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.lEw.setVisibility(0);
            this.lEt.setVisibility(8);
            return;
        }
        this.lEw.setVisibility(8);
        this.lEt.setVisibility(0);
        this.lEt.setBarNameClickEnabled(false);
        this.lEt.setReplyTimeVisible(false);
        this.lEt.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.lEt.setAgreeClickable(true);
            this.lEt.setPraiseContainerBgGray(false);
        } else {
            this.lEt.setAgreeClickable(false);
            this.lEt.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.lEt.setShareClickable(true);
            this.lEt.setShareContainerBgGray(false);
        } else {
            this.lEt.setShareClickable(false);
            this.lEt.setShareContainerBgGray(true);
        }
        if (this.lEt.getCommentContainer() != null) {
            this.lEt.getCommentContainer().setOnClickListener(bVar);
        }
        this.lEt.setNeedAddReplyIcon(true);
        this.lEt.setCommentNumEnable(false);
        this.lEt.setCommentClickable(true);
        this.lEt.setReplayContainerBgGray(true);
        this.lEt.setOnClickListener(bVar);
        this.lEt.setShareData(adCard);
        this.lEt.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        ap.setBackgroundResource(this.hkg, R.color.cp_bg_line_b);
        com.baidu.tbadk.a.b.a.aW(this.hkg);
        this.lEm.onChangeSkinType();
        this.lEu.onChangeSkinType(this.efn, TbadkCoreApplication.getInst().getSkinType());
        this.lEt.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            ap.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(this.hjJ, R.color.cp_bg_line_e);
        } else {
            ap.setBackgroundColor(this.hjJ, R.color.transparent);
        }
        com.baidu.tbadk.a.b.a.b((TextView) this.lEu.getUserName());
        ap.setViewTextColor(this.jHf, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.lEp, R.color.cp_cont_d);
        ap.setViewTextColor(this.jHh, R.color.cp_cont_d, 1);
        this.lEo.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String Ps(String str) {
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
            if (b(bVar) && !u.Pk(bVar.scheme)) {
                if (this.jPk != null) {
                    this.jPk.a(bVar.atD, bVar.atE, null);
                }
            } else if (this.jHb != null && this.jHb.getAdvertAppInfo() != null) {
                String Pu = Pu(bVar.scheme);
                String str = this.jHb.getAdvertAppInfo().dWf;
                if (!this.jHb.directDownload && this.jHb.getAdvertAppInfo().bcw()) {
                    c2 = s.d(this.efn, Pu, str);
                } else {
                    c2 = s.c(this.efn, Pu, str);
                }
                if (c2 == 1 || c2 == 2) {
                    if (this.jPk != null) {
                        this.jPk.d(c2, null);
                    }
                } else if (this.jPk != null) {
                    this.jPk.a(bVar.atD, bVar.atE, null);
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
                        if (AdCardBaseView.this.jHb.hasAnimation()) {
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
        this.jNK = new a.C0731a();
        this.jNK.picUrl = tbImageView.getUrl();
        this.jNK.rect = rect;
    }

    private void Pt(String str) {
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
                    com.baidu.adp.lib.e.c.mM().a(jSONObject.optString("pic_url"), 17, null, this.jPr, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.jPr), this.efn.getUniqueId(), new Object[0]);
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
                l.showToast(this.efn.getPageActivity(), R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.efn.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.efn.getPageActivity()) && this.jPl != null) {
                this.jPl.c(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(b(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.efn.getPageActivity(), R.string.neterror);
            } else if (advertAppInfo.bcw()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.efn.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.efn.getPageActivity());
                aVar.zz(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.lEo);
                        if (AdCardBaseView.this.lEo != null) {
                            AdCardBaseView.this.lEo.q(AdCardBaseView.this.b(advertAppInfo, i));
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
                aVar.b(this.efn).bhg();
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
                    h.aQ(this.efn.getPageActivity(), advertAppInfo.dWi);
                    return;
                case 6:
                case 7:
                    a(advertAppInfo, i, this.lEo);
                    apkDownloadView.s(b2);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.bBf().az(this.efn.getPageActivity(), advertAppInfo.dWi);
                    return;
            }
        }
    }

    public a.C0731a getAnimationInfo() {
        return this.jNK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class b implements View.OnClickListener {
        private AdCard lEL;

        public b(AdCard adCard) {
            this.lEL = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdCardBaseView.this.efn.showToast(R.string.neterror);
            } else if (this.lEL != null && view != null && view.getId() != R.id.thread_info_commont_container) {
                AdvertAppInfo advertAppInfo = this.lEL.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.lEo;
                if (advertAppInfo != null && advertAppInfo.bcw()) {
                    a(advertAppInfo, z);
                } else {
                    h(advertAppInfo);
                }
            }
        }

        private void a(AdvertAppInfo advertAppInfo, boolean z) {
            if (this.lEL.directDownload || z) {
                b(advertAppInfo, z);
            } else {
                i(advertAppInfo);
            }
        }

        private void h(AdvertAppInfo advertAppInfo) {
            String scheme = this.lEL.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.dWh;
            }
            if (this.lEL.hasAnimation()) {
            }
            int h = s.h(AdCardBaseView.this.efn, AdCardBaseView.this.Pu(scheme));
            if (AdCardBaseView.this.jPk != null) {
                AdCardBaseView.this.jPk.d(h, null);
            }
        }

        private void b(AdvertAppInfo advertAppInfo, boolean z) {
            int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
            int status = ApkDownloadView.getStatus(AdCardBaseView.this.b(advertAppInfo, i));
            if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                return;
            }
            AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.lEo, z);
            AdCardBaseView.this.dnA();
        }

        private void i(AdvertAppInfo advertAppInfo) {
            String scheme = this.lEL.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.dWh;
            }
            int d = s.d(AdCardBaseView.this.efn, scheme, advertAppInfo.dWf);
            if (AdCardBaseView.this.jPk != null) {
                AdCardBaseView.this.jPk.d(d, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dnA() {
        if (this.jPk != null) {
            this.jPk.d(3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Pu(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.jNK != null && this.jNK.isValid()) {
            String c0731a = this.jNK.toString();
            if (!TextUtils.isEmpty(c0731a)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(c0731a));
            }
        }
        if (!TextUtils.isEmpty(this.jHb.getPreLoadData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.jHb.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.jHb.getNextPageData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.jHb.getNextPageData()));
        }
        if (this.jHb.hasAnimation()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.jHb.isGoLandingPage()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.jHb.isImmersiveStyle()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes20.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> lEK;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.lEK = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.lEK.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.lEs) ? false : true)) && adCardBaseView.lEs.equals(downloadData.getId())) {
                    int status = e.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.lEl.setText(R.string.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.lEl.setText(R.string.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes20.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> lEK;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.lEK = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.lEK.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.lEs) && adCardBaseView.lEs.equals(downloadData.getId())) {
                adCardBaseView.lEo.t(downloadData);
            }
        }
    }

    /* loaded from: classes20.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> lEK;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.lEK = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.lEK.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                String str = null;
                if (adCardBaseView.jHb != null && adCardBaseView.jHb.getAdvertAppInfo() != null) {
                    str = adCardBaseView.jHb.getAdvertAppInfo().dWf;
                }
                s.c(adCardBaseView.efn, adCardBaseView.lEx.scheme, str);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void cMv() {
        if (4 == getBusinessType()) {
            this.jHf.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.lDD != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.lEx = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.efn.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.efn, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
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
        DownloadData downloadData = new DownloadData(advertAppInfo.dWi);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.dWg);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.dWf, 0));
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
