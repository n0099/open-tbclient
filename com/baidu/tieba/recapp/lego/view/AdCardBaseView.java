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
    protected View cAJ;
    protected View cOr;
    private a.C0252a ffn;
    private final int fgX;
    private AdCloseView gGA;
    private LinearLayout gGB;
    protected ApkDownloadView gGC;
    protected TextView gGD;
    protected RelativeLayout gGE;
    protected View gGF;
    protected String gGG;
    private AdCard gGH;
    private AdThreadCommentAndPraiseInfoLayout gGI;
    protected ThreadUserInfoLayout gGJ;
    protected View gGK;
    protected View gGL;
    protected AdCard.b gGM;
    protected CustomMessageListener gGN;
    protected CustomMessageListener gGO;
    protected CustomMessageListener gGP;
    protected ViewStub gGj;
    protected View gGk;
    protected View gGl;
    protected final int gGm;
    protected final int gGn;
    protected final int gGo;
    protected final int gGp;
    protected final int gGq;
    protected final int gGr;
    protected final int gGs;
    protected final int gGt;
    private int gGu;
    private int gGv;
    private int gGw;
    protected TextView gGx;
    protected TextView gGy;
    protected TextView gGz;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void bN(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fgX = l.aO(getContext());
        this.gGN = new a(2016484, this);
        this.gGO = new d(2016483, this);
        this.gGP = new c(2016494, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(e.C0200e.ds640);
        this.mImageHeight = (int) resources.getDimension(e.C0200e.ds278);
        this.gGm = (int) resources.getDimension(e.C0200e.tbds92);
        this.gGn = (int) resources.getDimension(e.C0200e.tbds92);
        this.gGo = (int) resources.getDimension(e.C0200e.tbds20);
        this.gGr = (int) resources.getDimension(e.C0200e.tbds90);
        this.gGs = (int) resources.getDimension(e.C0200e.tbds90);
        this.gGt = (int) resources.getDimension(e.C0200e.tbds22);
        this.gGp = (int) resources.getDimension(e.C0200e.tbds44);
        this.gGq = (int) resources.getDimension(e.C0200e.tbds44);
        this.gGu = (int) resources.getDimension(e.C0200e.ds12);
        this.gGv = (int) resources.getDimension(e.C0200e.ds1);
        this.gGw = (int) resources.getDimension(e.C0200e.ds18);
    }

    protected void j(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.gGI.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aWt() {
        MessageManager.getInstance().registerListener(this.gGN);
        MessageManager.getInstance().registerListener(this.gGO);
        MessageManager.getInstance().registerListener(this.gGP);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.cAJ = this.mRootView.findViewById(e.g.bottom_line);
        this.gGl = this.mRootView.findViewById(e.g.thread_multi_del_ad_mask_view);
        this.gGl.setClickable(true);
        this.gGx = (TextView) this.mRootView.findViewById(e.g.ad_title);
        this.gGy = (TextView) this.mRootView.findViewById(e.g.transform_btn);
        this.gGC = (ApkDownloadView) this.mRootView.findViewById(e.g.advert_app_download_view);
        this.gGD = (TextView) this.mRootView.findViewById(e.g.advert_app_name);
        this.gGE = (RelativeLayout) this.mRootView.findViewById(e.g.bottom_transformation_area);
        this.gGC.p(this.mContext.getUniqueId());
        this.gGN.setTag(this.mContext.getUniqueId());
        this.gGF = this.mRootView.findViewById(e.g.card_ad_middle_container);
        this.gGO.setTag(this.mContext.getUniqueId());
        this.gGP.setTag(this.mContext.getUniqueId());
        this.gGI = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.gGI.setStyle(1);
        this.gGJ = (ThreadUserInfoLayout) this.mRootView.findViewById(e.g.card_ad_user_info_layout);
        this.gGB = (LinearLayout) LayoutInflater.from(getContext()).inflate(e.h.ad_post_tag_close, (ViewGroup) null);
        this.gGA = (AdCloseView) this.gGB.findViewById(e.g.ad_close_view);
        this.gGz = (TextView) this.gGB.findViewById(e.g.feed_tag);
        this.gGJ.addView(this.gGB);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gGB.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(e.C0200e.ds8);
        this.gGB.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        this.gGB.setLayoutParams(layoutParams);
        this.gGJ.getHeaderImg().setDefaultErrorResource(e.f.icon_default_avatar100);
        this.gGJ.getHeaderImg().setDefaultResource(e.f.icon_default_avatar100);
        this.gGJ.getHeaderImg().setDefaultBgResource(e.d.cp_bg_line_e);
        this.cOr = this.mRootView.findViewById(e.g.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.aO(getContext()) - this.gGp) - this.gGq) - this.gGm) - this.gGo;
            this.gGI.setVisibility(8);
        } else {
            this.mMaxWidth = (l.aO(getContext()) - this.gGp) - this.gGq;
            this.gGI.setVisibility(0);
        }
        this.gGj = (ViewStub) this.mRootView.findViewById(e.g.ad_custom_view_stub);
        this.gGj.setLayoutResource(getCustomLayout());
        this.gGk = this.gGj.inflate();
        this.gGK = this.mRootView.findViewById(e.g.pb_bottom_view);
        this.gGL = this.mRootView.findViewById(e.g.frs_bottom_view);
        bN(this.gGk);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(final AdCard adCard) {
        final String str;
        this.gGH = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.gGJ.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.Ft() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.bg(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.gGC.setOnClickListener(bVar);
        this.gGy.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gGF.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.gGm + this.gGo;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.gGJ.getHeaderImg(), adCard.portraitClick, bVar);
        if (!TextUtils.isEmpty(adCard.tagName)) {
            this.gGz.setText(adCard.tagName);
        } else {
            this.gGz.setText("广告");
        }
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String ub = ub(ao.c(str2, 100, "..."));
            if (4 == getBusinessType()) {
                this.gGx.setTextSize(0, getContext().getResources().getDimension(e.C0200e.ds32));
            } else {
                this.gGx.setTextSize(0, getContext().getResources().getDimension(e.C0200e.tbfontsize48));
            }
            this.gGx.setText(ub);
            this.gGx.setVisibility(0);
        } else {
            this.gGx.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.xa()) && true == k.isEmpty(str3);
        a(this.gGE, this.gGy, this.gGC, adCard);
        if (!z && !TextUtils.isEmpty(adCard.userName)) {
            if (advertAppInfo != null && advertAppInfo.wZ()) {
                this.gGD.setText(adCard.userName.concat("App").toString());
            } else if (advertAppInfo != null && advertAppInfo.xa()) {
                this.gGD.setText(adCard.userName);
            }
        }
        if (advertAppInfo != null && advertAppInfo.wZ()) {
            this.gGG = advertAppInfo.alU;
            this.gGC.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, -1));
            c2.setStatus(ApkDownloadView.getStatus(c2));
            a(this.gGy, c2.getStatus(), str3);
            this.gGC.setData(c2);
            this.gGC.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    al.c(this.gGy, e.d.btn_forum_focus_color, 1);
                    this.gGy.setText(str3);
                    if (k.isEmpty(str)) {
                        this.gGy.setClickable(false);
                    } else {
                        this.gGy.setClickable(true);
                        this.gGy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.fgQ != null && adCard.buttonClick != null && !q.uW(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.fgQ.b(adCard.buttonClick.abf, adCard.buttonClick.abg, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int e = s.e(AdCardBaseView.this.mContext, str);
                                        if ((e == 1 || e == 2) && AdCardBaseView.this.fgQ != null) {
                                            AdCardBaseView.this.fgQ.b(e, null);
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
                                            if ((e2 == 1 || e2 == 2) && AdCardBaseView.this.fgQ != null) {
                                                AdCardBaseView.this.fgQ.b(e2, null);
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
                                    aVar.b(AdCardBaseView.this.mContext).AB();
                                }
                            }
                        });
                    }
                } else {
                    this.gGy.setClickable(false);
                    this.gGy.setText(adCard.buttonTextDone);
                    al.i(this.gGy, e.f.btn_rounded_corner_gray_frame);
                    al.c(this.gGy, e.d.cp_cont_d, 1);
                }
            }
            this.gGC.setVisibility(8);
        }
        a(adCard);
        j(i.wA().wE(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            uc(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.ama != null && advertAppInfo.ama.adCloseInfo != null && advertAppInfo.ama.adCloseInfo.support_close.intValue() > 0) {
            this.gGA.setVisibility(0);
            this.gGA.setPage(getBusinessType());
            this.gGA.setData(advertAppInfo);
            l.b(this.mContext.getPageActivity(), this.gGB, 40, 40, 40, 120);
            this.gGB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.gGA.performClick();
                }
            });
        } else {
            this.gGA.setVisibility(8);
            this.gGz.setOnClickListener(null);
        }
        this.gGI.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.cAJ.getLayoutParams();
        if (4 == getBusinessType()) {
            this.gGI.setVisibility(8);
            this.gGI.setBarNameClickEnabled(false);
            this.gGI.setShareVisible(false);
            this.gGI.setShowPraiseNum(false);
            this.gGI.setCommentNumEnable(false);
            this.gGI.setReplyTimeVisible(false);
            layoutParams2.height = this.gGv;
            this.gGK.setVisibility(0);
            this.gGL.setVisibility(8);
        } else {
            a(adCard, bVar);
        }
        a(adCard, this.cOr, getBusinessType());
        this.gGJ.setData(adCard.getAdvertAppInfo());
        this.gGJ.getHeaderImg().setVisibility(0);
        this.gGJ.getHeaderImg().startLoad(adCard.userPortrait, 10, false);
        this.gGJ.getUserName().setOnClickListener(bVar);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.ayk().ayl()) {
            this.gGl.setVisibility(0);
            al.j(this.gGl, e.d.cp_bg_line_d);
        } else {
            this.gGl.setVisibility(8);
        }
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean isInFrsAllThread() {
        return this.ffR == 1;
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.gGL.setVisibility(0);
            this.gGI.setVisibility(8);
            return;
        }
        this.gGL.setVisibility(8);
        this.gGI.setVisibility(0);
        this.gGI.setBarNameClickEnabled(false);
        this.gGI.setReplyTimeVisible(false);
        this.gGI.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.gGI.setAgreeClickable(true);
            this.gGI.setPraiseContainerBgGray(false);
        } else {
            this.gGI.setAgreeClickable(false);
            this.gGI.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.gGI.setShareClickable(true);
            this.gGI.setShareContainerBgGray(false);
        } else {
            this.gGI.setShareClickable(false);
            this.gGI.setShareContainerBgGray(true);
        }
        this.gGI.getCommentContainer().setOnClickListener(bVar);
        this.gGI.setNeedAddReplyIcon(true);
        this.gGI.setCommentNumEnable(true);
        this.gGI.setCommentClickable(true);
        this.gGI.setReplayContainerBgGray(true);
        this.gGI.setOnClickListener(bVar);
        this.gGI.setShareData(adCard);
        this.gGI.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        al.i(this.cAJ, e.d.cp_bg_line_c);
        this.gGA.onChangeSkinType();
        this.gGJ.onChangeSkinType();
        this.gGI.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            al.i(this.mRootView, e.f.addresslist_item_bg);
            al.j(this.cAJ, e.d.cp_bg_line_e);
            al.j(this.cOr, e.d.cp_bg_line_e);
        } else {
            al.j(this.cAJ, e.d.cp_bg_line_c);
            al.j(this.cOr, e.d.transparent);
        }
        al.c(this.gGx, e.d.cp_cont_b, 1);
        al.j(this.gGE, e.d.cp_bg_line_e);
        al.h(this.gGD, e.d.cp_cont_j);
        al.c(this.gGz, e.d.cp_cont_d, 1);
        this.gGC.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String ub(String str) {
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
            if (b(bVar) && !q.uW(bVar.scheme)) {
                if (this.fgQ != null) {
                    this.fgQ.b(bVar.abf, bVar.abg, null);
                    return;
                }
                return;
            }
            int e = s.e(this.mContext, ud(bVar.scheme));
            if (e == 1 || e == 2) {
                if (this.fgQ != null) {
                    this.fgQ.b(e, null);
                }
            } else if (this.fgQ != null) {
                this.fgQ.b(bVar.abf, bVar.abg, null);
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
                        if (AdCardBaseView.this.gGH.hasAnimation()) {
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
        this.ffn = new a.C0252a();
        this.ffn.picUrl = tbImageView.getUrl();
        this.ffn.rect = rect;
    }

    private void uc(String str) {
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
                    com.baidu.adp.lib.f.c.jA().a(jSONObject.optString("pic_url"), 17, null, this.fgX, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.fgX), this.mContext.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.wY() != 0) {
                l.showToast(this.mContext.getPageActivity(), e.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.Dp();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.A(this.mContext.getPageActivity()) && this.fgR != null) {
                this.fgR.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.p(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.kK()) {
                l.showToast(this.mContext.getPageActivity(), e.j.neterror);
            } else if (advertAppInfo.wZ()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(e.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.ej(str);
                aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.gGC);
                        if (AdCardBaseView.this.gGC != null) {
                            AdCardBaseView.this.gGC.p(AdCardBaseView.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).AB();
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
                    a(advertAppInfo, i, this.gGC);
                    apkDownloadView.r(c2);
                    return;
            }
            g.aD(this.mContext.getPageActivity(), advertAppInfo.alU);
        }
    }

    public a.C0252a getAnimationInfo() {
        return this.ffn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private AdCard gGY;

        public b(AdCard adCard) {
            this.gGY = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kK()) {
                AdCardBaseView.this.mContext.showToast(e.j.neterror);
            } else if (this.gGY != null) {
                AdvertAppInfo advertAppInfo = this.gGY.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.gGC;
                if (advertAppInfo != null && advertAppInfo.wZ()) {
                    int l = com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, l));
                    if ((6 == status || 7 == status) && j.kV() && !j.kW()) {
                        AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, l, true, this.gGY.popWindowText);
                        return;
                    }
                    AdCardBaseView.this.a(advertAppInfo, l, AdCardBaseView.this.gGC, z);
                    if (AdCardBaseView.this.fgQ != null) {
                        AdCardBaseView.this.fgQ.b(3, null);
                        return;
                    }
                    return;
                }
                String scheme = this.gGY.getScheme();
                if (k.isEmpty(scheme) && advertAppInfo != null) {
                    scheme = advertAppInfo.alS;
                }
                if (this.gGY.hasAnimation()) {
                }
                int e = s.e(AdCardBaseView.this.mContext, AdCardBaseView.this.ud(scheme));
                if (AdCardBaseView.this.fgQ != null) {
                    AdCardBaseView.this.fgQ.b(e, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ud(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.ffn != null && this.ffn.isValid()) {
            String c0252a = this.ffn.toString();
            if (!TextUtils.isEmpty(c0252a)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(c0252a));
            }
        }
        if (!TextUtils.isEmpty(this.gGH.getPreLoadData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.gGH.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.gGH.getNextPageData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.gGH.getNextPageData()));
        }
        if (this.gGH.hasAnimation()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.gGH.isGoLandingPage()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.gGH.isImmersiveStyle()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> gGX;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.gGX = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.gGX.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.gGG) ? false : true)) && adCardBaseView.gGG.equals(downloadData.getId())) {
                    int status = com.baidu.tieba.recapp.download.d.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.gGy.setText(e.j.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.gGy.setText(e.j.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> gGX;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.gGX = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.gGX.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.gGG) && adCardBaseView.gGG.equals(downloadData.getId())) {
                adCardBaseView.gGC.s(downloadData);
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> gGX;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.gGX = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.gGX.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                s.e(adCardBaseView.mContext, adCardBaseView.gGM.scheme);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aWB() {
        if (4 == getBusinessType()) {
            this.gGx.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.gFS != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.gGM = bVar;
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
        if (adCard.getAdvertAppInfo().wZ()) {
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
        DownloadData downloadData = new DownloadData(advertAppInfo.alU);
        downloadData.setUrl(advertAppInfo.alT);
        downloadData.setName(advertAppInfo.alQ);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.l(advertAppInfo.alP, 0));
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
