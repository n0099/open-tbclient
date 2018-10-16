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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.lego.card.b.a;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.download.g;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.tieba.tbadkCore.q;
import com.baidu.webkit.internal.ETAG;
import com.tencent.open.SocialConstants;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class AdCardBaseView extends BaseLegoCardView<AdCard> implements com.baidu.tieba.lego.card.b.a {
    protected View cNl;
    protected View czB;
    private a.C0226a fdT;
    private final int ffD;
    protected ViewStub gEH;
    protected View gEI;
    protected View gEJ;
    protected final int gEK;
    protected final int gEL;
    protected final int gEM;
    protected final int gEN;
    protected final int gEO;
    protected final int gEP;
    protected final int gEQ;
    protected final int gER;
    private int gES;
    private int gET;
    private int gEU;
    protected TextView gEV;
    protected TextView gEW;
    protected TextView gEX;
    private AdCloseView gEY;
    private LinearLayout gEZ;
    protected ApkDownloadView gFa;
    protected TextView gFb;
    protected RelativeLayout gFc;
    protected View gFd;
    protected String gFe;
    private AdCard gFf;
    private AdThreadCommentAndPraiseInfoLayout gFg;
    protected ThreadUserInfoLayout gFh;
    protected View gFi;
    protected View gFj;
    protected AdCard.b gFk;
    protected CustomMessageListener gFl;
    protected CustomMessageListener gFm;
    protected CustomMessageListener gFn;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void bL(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ffD = l.aO(getContext());
        this.gFl = new a(2016484, this);
        this.gFm = new d(2016483, this);
        this.gFn = new c(2016494, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(e.C0175e.ds640);
        this.mImageHeight = (int) resources.getDimension(e.C0175e.ds278);
        this.gEK = (int) resources.getDimension(e.C0175e.tbds92);
        this.gEL = (int) resources.getDimension(e.C0175e.tbds92);
        this.gEM = (int) resources.getDimension(e.C0175e.tbds20);
        this.gEP = (int) resources.getDimension(e.C0175e.tbds90);
        this.gEQ = (int) resources.getDimension(e.C0175e.tbds90);
        this.gER = (int) resources.getDimension(e.C0175e.tbds22);
        this.gEN = (int) resources.getDimension(e.C0175e.tbds44);
        this.gEO = (int) resources.getDimension(e.C0175e.tbds44);
        this.gES = (int) resources.getDimension(e.C0175e.ds12);
        this.gET = (int) resources.getDimension(e.C0175e.ds1);
        this.gEU = (int) resources.getDimension(e.C0175e.ds18);
    }

    protected void j(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.gFg.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aWW() {
        MessageManager.getInstance().registerListener(this.gFl);
        MessageManager.getInstance().registerListener(this.gFm);
        MessageManager.getInstance().registerListener(this.gFn);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.czB = this.mRootView.findViewById(e.g.bottom_line);
        this.gEJ = this.mRootView.findViewById(e.g.thread_multi_del_ad_mask_view);
        this.gEJ.setClickable(true);
        this.gEV = (TextView) this.mRootView.findViewById(e.g.ad_title);
        this.gEW = (TextView) this.mRootView.findViewById(e.g.transform_btn);
        this.gFa = (ApkDownloadView) this.mRootView.findViewById(e.g.advert_app_download_view);
        this.gFb = (TextView) this.mRootView.findViewById(e.g.advert_app_name);
        this.gFc = (RelativeLayout) this.mRootView.findViewById(e.g.bottom_transformation_area);
        this.gFa.p(this.mContext.getUniqueId());
        this.gFl.setTag(this.mContext.getUniqueId());
        this.gFd = this.mRootView.findViewById(e.g.card_ad_middle_container);
        this.gFm.setTag(this.mContext.getUniqueId());
        this.gFn.setTag(this.mContext.getUniqueId());
        this.gFg = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.gFg.setStyle(1);
        this.gFh = (ThreadUserInfoLayout) this.mRootView.findViewById(e.g.card_ad_user_info_layout);
        this.gEZ = (LinearLayout) LayoutInflater.from(getContext()).inflate(e.h.ad_post_tag_close, (ViewGroup) null);
        this.gEY = (AdCloseView) this.gEZ.findViewById(e.g.ad_close_view);
        this.gEX = (TextView) this.gEZ.findViewById(e.g.feed_tag);
        this.gFh.addView(this.gEZ);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gEZ.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(e.C0175e.ds8);
        this.gEZ.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        this.gEZ.setLayoutParams(layoutParams);
        this.gFh.getHeaderImg().setDefaultErrorResource(e.f.icon_default_avatar100);
        this.gFh.getHeaderImg().setDefaultResource(e.f.icon_default_avatar100);
        this.gFh.getHeaderImg().setDefaultBgResource(e.d.cp_bg_line_e);
        this.cNl = this.mRootView.findViewById(e.g.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.aO(getContext()) - this.gEN) - this.gEO) - this.gEK) - this.gEM;
            this.gFg.setVisibility(8);
        } else {
            this.mMaxWidth = (l.aO(getContext()) - this.gEN) - this.gEO;
            this.gFg.setVisibility(0);
        }
        this.gEH = (ViewStub) this.mRootView.findViewById(e.g.ad_custom_view_stub);
        this.gEH.setLayoutResource(getCustomLayout());
        this.gEI = this.gEH.inflate();
        this.gFi = this.mRootView.findViewById(e.g.pb_bottom_view);
        this.gFj = this.mRootView.findViewById(e.g.frs_bottom_view);
        bL(this.gEI);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(final AdCard adCard) {
        final String str;
        this.gFf = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.gFh.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.Fi() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.bg(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.gFa.setOnClickListener(bVar);
        this.gEW.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gFd.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.gEK + this.gEM;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.gFh.getHeaderImg(), adCard.portraitClick, bVar);
        if (!TextUtils.isEmpty(adCard.tagName)) {
            this.gEX.setText(adCard.tagName);
        } else {
            this.gEX.setText("广告");
        }
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String tX = tX(ao.c(str2, 100, "..."));
            if (4 == getBusinessType()) {
                this.gEV.setTextSize(0, getContext().getResources().getDimension(e.C0175e.ds32));
            } else {
                this.gEV.setTextSize(0, getContext().getResources().getDimension(e.C0175e.tbfontsize48));
            }
            this.gEV.setText(tX);
            this.gEV.setVisibility(0);
        } else {
            this.gEV.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.wS()) && true == k.isEmpty(str3);
        a(this.gFc, this.gEW, this.gFa, adCard);
        if (!z && !TextUtils.isEmpty(adCard.userName)) {
            if (advertAppInfo != null && advertAppInfo.wR()) {
                this.gFb.setText(adCard.userName.concat("App").toString());
            } else if (advertAppInfo != null && advertAppInfo.wS()) {
                this.gFb.setText(adCard.userName);
            }
        }
        if (advertAppInfo != null && advertAppInfo.wR()) {
            this.gFe = advertAppInfo.alg;
            this.gFa.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, -1));
            c2.setStatus(ApkDownloadView.getStatus(c2));
            a(this.gEW, c2.getStatus(), str3);
            this.gFa.setData(c2);
            this.gFa.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    al.c(this.gEW, e.d.btn_forum_focus_color, 1);
                    this.gEW.setText(str3);
                    if (k.isEmpty(str)) {
                        this.gEW.setClickable(false);
                    } else {
                        this.gEW.setClickable(true);
                        this.gEW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.ffw != null && adCard.buttonClick != null && !q.uR(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.ffw.b(adCard.buttonClick.abh, adCard.buttonClick.abi, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int e = s.e(AdCardBaseView.this.mContext, str);
                                        if ((e == 1 || e == 2) && AdCardBaseView.this.ffw != null) {
                                            AdCardBaseView.this.ffw.b(e, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.mContext.getPageActivity());
                                    aVar.ej(adCard.popWindowText);
                                    aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int e2 = s.e(AdCardBaseView.this.mContext, str);
                                            if ((e2 == 1 || e2 == 2) && AdCardBaseView.this.ffw != null) {
                                                AdCardBaseView.this.ffw.b(e2, null);
                                            }
                                            aVar2.dismiss();
                                        }
                                    });
                                    aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.2
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            aVar2.dismiss();
                                        }
                                    });
                                    aVar.b(AdCardBaseView.this.mContext).Au();
                                }
                            }
                        });
                    }
                } else {
                    this.gEW.setClickable(false);
                    this.gEW.setText(adCard.buttonTextDone);
                    al.i(this.gEW, e.f.btn_rounded_corner_gray_frame);
                    al.c(this.gEW, e.d.cp_cont_d, 1);
                }
            }
            this.gFa.setVisibility(8);
        }
        a(adCard);
        j(i.ws().ww(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            tY(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.aln != null && advertAppInfo.aln.adCloseInfo != null && advertAppInfo.aln.adCloseInfo.support_close.intValue() > 0) {
            this.gEY.setVisibility(0);
            this.gEY.setPage(getBusinessType());
            this.gEY.setData(advertAppInfo);
            l.a(this.mContext.getPageActivity(), this.gEZ, 40, 40, 40, 120);
            this.gEZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.gEY.performClick();
                }
            });
        } else {
            this.gEY.setVisibility(8);
            this.gEX.setOnClickListener(null);
        }
        this.gFg.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.czB.getLayoutParams();
        if (4 == getBusinessType()) {
            this.gFg.setVisibility(8);
            this.gFg.setBarNameClickEnabled(false);
            this.gFg.setShareVisible(false);
            this.gFg.setShowPraiseNum(false);
            this.gFg.setCommentNumEnable(false);
            this.gFg.setReplyTimeVisible(false);
            layoutParams2.height = this.gET;
            this.gFi.setVisibility(0);
            this.gFj.setVisibility(8);
        } else {
            a(adCard, bVar);
        }
        a(adCard, this.cNl, getBusinessType());
        this.gFh.setData(adCard.getAdvertAppInfo());
        this.gFh.getHeaderImg().setVisibility(0);
        this.gFh.getHeaderImg().startLoad(adCard.userPortrait, 10, false);
        this.gFh.getUserName().setOnClickListener(bVar);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.ayM().ayN()) {
            this.gEJ.setVisibility(0);
            al.j(this.gEJ, e.d.cp_bg_line_d);
        } else {
            this.gEJ.setVisibility(8);
        }
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean isInFrsAllThread() {
        return this.fex == 1;
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.gFj.setVisibility(0);
            this.gFg.setVisibility(8);
            return;
        }
        this.gFj.setVisibility(8);
        this.gFg.setVisibility(0);
        this.gFg.setBarNameClickEnabled(false);
        this.gFg.setReplyTimeVisible(false);
        this.gFg.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.gFg.setAgreeClickable(true);
            this.gFg.setPraiseContainerBgGray(false);
        } else {
            this.gFg.setAgreeClickable(false);
            this.gFg.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.gFg.setShareClickable(true);
            this.gFg.setShareContainerBgGray(false);
        } else {
            this.gFg.setShareClickable(false);
            this.gFg.setShareContainerBgGray(true);
        }
        this.gFg.getCommentContainer().setOnClickListener(bVar);
        this.gFg.setNeedAddReplyIcon(true);
        this.gFg.setCommentNumEnable(true);
        this.gFg.setCommentClickable(true);
        this.gFg.setReplayContainerBgGray(true);
        this.gFg.setOnClickListener(bVar);
        this.gFg.setShareData(adCard);
        this.gFg.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        al.i(this.czB, e.d.cp_bg_line_c);
        this.gEY.onChangeSkinType();
        this.gFh.onChangeSkinType();
        this.gFg.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            al.i(this.mRootView, e.f.addresslist_item_bg);
            al.j(this.czB, e.d.cp_bg_line_e);
            al.j(this.cNl, e.d.cp_bg_line_e);
        } else {
            al.j(this.czB, e.d.cp_bg_line_c);
            al.j(this.cNl, e.d.transparent);
        }
        al.c(this.gEV, e.d.cp_cont_b, 1);
        al.j(this.gFc, e.d.cp_bg_line_e);
        al.h(this.gFb, e.d.cp_cont_j);
        al.c(this.gEX, e.d.cp_cont_d, 1);
        this.gFa.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String tX(String str) {
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
        if (bVar != null) {
            if (b(bVar) && !q.uR(bVar.scheme)) {
                if (this.ffw != null) {
                    this.ffw.b(bVar.abh, bVar.abi, null);
                    return;
                }
                return;
            }
            int e = s.e(this.mContext, tZ(bVar.scheme));
            if (e == 1 || e == 2) {
                if (this.ffw != null) {
                    this.ffw.b(e, null);
                }
            } else if (this.ffw != null) {
                this.ffw.b(bVar.abh, bVar.abi, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final TbImageView tbImageView, final AdCard.b bVar) {
        if (tbImageView != null) {
            if (bVar != null && !k.isEmpty(bVar.scheme)) {
                tbImageView.setClickable(true);
                tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (AdCardBaseView.this.gFf.hasAnimation()) {
                            AdCardBaseView.this.d(tbImageView);
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
    public void a(TbImageView tbImageView, final AdCard.b bVar, b bVar2) {
        if (tbImageView != null) {
            if (bVar != null && !k.isEmpty(bVar.scheme)) {
                tbImageView.setClickable(true);
                tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AdCardBaseView.this.a(bVar);
                    }
                });
                return;
            }
            tbImageView.setClickable(true);
            tbImageView.setOnClickListener(bVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(TbImageView tbImageView) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        tbImageView.getLocationOnScreen(iArr);
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + tbImageView.getWidth();
        rect.bottom = rect.top + tbImageView.getHeight();
        this.fdT = new a.C0226a();
        this.fdT.picUrl = tbImageView.getUrl();
        this.fdT.rect = rect;
    }

    private void tY(String str) {
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
                    com.baidu.adp.lib.f.c.jC().a(jSONObject.optString("pic_url"), 17, null, this.ffD, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.ffD), this.mContext.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.wQ() != 0) {
                l.showToast(this.mContext.getPageActivity(), e.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.Di();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.z(this.mContext.getPageActivity()) && this.ffx != null) {
                this.ffx.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.p(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.kM()) {
                l.showToast(this.mContext.getPageActivity(), e.j.neterror);
            } else if (advertAppInfo.wR()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(e.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.ej(str);
                aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.gFa);
                        if (AdCardBaseView.this.gFa != null) {
                            AdCardBaseView.this.gFa.p(AdCardBaseView.this.c(advertAppInfo, i));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).Au();
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
                        g.f(advertAppInfo);
                        apkDownloadView.q(c2);
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
                    a(advertAppInfo, i, this.gFa);
                    apkDownloadView.r(c2);
                    return;
            }
            g.aF(this.mContext.getPageActivity(), advertAppInfo.alg);
        }
    }

    public a.C0226a getAnimationInfo() {
        return this.fdT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private AdCard gFw;

        public b(AdCard adCard) {
            this.gFw = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kM()) {
                AdCardBaseView.this.mContext.showToast(e.j.neterror);
            } else if (this.gFw != null) {
                AdvertAppInfo advertAppInfo = this.gFw.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.gFa;
                if (advertAppInfo != null && advertAppInfo.wR()) {
                    int l = com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, l));
                    if ((6 == status || 7 == status) && j.kX() && !j.kY()) {
                        AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, l, true, this.gFw.popWindowText);
                        return;
                    }
                    AdCardBaseView.this.a(advertAppInfo, l, AdCardBaseView.this.gFa, z);
                    if (AdCardBaseView.this.ffw != null) {
                        AdCardBaseView.this.ffw.b(3, null);
                        return;
                    }
                    return;
                }
                String scheme = this.gFw.getScheme();
                if (k.isEmpty(scheme) && advertAppInfo != null) {
                    scheme = advertAppInfo.ale;
                }
                if (this.gFw.hasAnimation()) {
                }
                int e = s.e(AdCardBaseView.this.mContext, AdCardBaseView.this.tZ(scheme));
                if (AdCardBaseView.this.ffw != null) {
                    AdCardBaseView.this.ffw.b(e, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String tZ(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.fdT != null && this.fdT.isValid()) {
            String c0226a = this.fdT.toString();
            if (!TextUtils.isEmpty(c0226a)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(c0226a));
            }
        }
        if (!TextUtils.isEmpty(this.gFf.getPreLoadData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.gFf.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.gFf.getNextPageData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.gFf.getNextPageData()));
        }
        if (this.gFf.hasAnimation()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.gFf.isGoLandingPage()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.gFf.isImmersiveStyle()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> gFv;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.gFv = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.gFv.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.gFe) ? false : true)) && adCardBaseView.gFe.equals(downloadData.getId())) {
                    int status = com.baidu.tieba.recapp.download.d.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.gEW.setText(e.j.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.gEW.setText(e.j.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> gFv;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.gFv = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.gFv.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.gFe) && adCardBaseView.gFe.equals(downloadData.getId())) {
                adCardBaseView.gFa.s(downloadData);
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> gFv;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.gFv = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.gFv.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                s.e(adCardBaseView.mContext, adCardBaseView.gFk.scheme);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aXe() {
        if (4 == getBusinessType()) {
            this.gEV.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.gEq != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.gFk = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.mContext.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.mContext, new CustomMessage<>(2002001, loginActivityConfig));
        return true;
    }

    private void a(View view, TextView textView, ApkDownloadView apkDownloadView, AdCard adCard) {
        if (adCard == null) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        if (adCard.getAdvertAppInfo().wR()) {
            textView.setVisibility(8);
            apkDownloadView.setVisibility(0);
            return;
        }
        if (true == k.isEmpty(adCard.buttonText) || "立即查看".equals(adCard.buttonText)) {
            textView.setVisibility(8);
            view.setVisibility(8);
        } else {
            textView.setVisibility(0);
            al.i(textView, e.f.btn_focus_border_bg);
        }
        apkDownloadView.setVisibility(8);
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.alg);
        downloadData.setUrl(advertAppInfo.alf);
        downloadData.setName(advertAppInfo.alc);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.l(advertAppInfo.alb, 0));
        return downloadData;
    }

    protected void a(TextView textView, int i, String str) {
        switch (i) {
            case 1:
            case 5:
                textView.setText(e.j.pause_load);
                return;
            case 2:
            case 4:
            default:
                return;
            case 3:
                textView.setText(e.j.downloaded_install);
                return;
            case 6:
                textView.setText(e.j.install_app);
                return;
            case 7:
                textView.setText(e.j.pb_download_pause);
                return;
        }
    }
}
