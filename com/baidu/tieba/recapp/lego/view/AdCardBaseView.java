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
import com.tencent.open.SocialConstants;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class AdCardBaseView extends BaseLegoCardView<AdCard> implements com.baidu.tieba.lego.card.b.a {
    protected View cER;
    protected View cqY;
    private a.C0192a eWm;
    private final int eXW;
    protected ApkDownloadView gxA;
    protected TextView gxB;
    protected RelativeLayout gxC;
    protected View gxD;
    protected String gxE;
    private AdCard gxF;
    private AdThreadCommentAndPraiseInfoLayout gxG;
    protected ThreadUserInfoLayout gxH;
    protected View gxI;
    protected View gxJ;
    protected AdCard.b gxK;
    protected CustomMessageListener gxL;
    protected CustomMessageListener gxM;
    protected CustomMessageListener gxN;
    protected ViewStub gxh;
    protected View gxi;
    protected View gxj;
    protected final int gxk;
    protected final int gxl;
    protected final int gxm;
    protected final int gxn;
    protected final int gxo;
    protected final int gxp;
    protected final int gxq;
    protected final int gxr;
    private int gxs;
    private int gxt;
    private int gxu;
    protected TextView gxv;
    protected TextView gxw;
    protected TextView gxx;
    private AdCloseView gxy;
    private LinearLayout gxz;
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
        this.eXW = l.aO(getContext());
        this.gxL = new a(2016484, this);
        this.gxM = new d(2016483, this);
        this.gxN = new c(2016494, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(e.C0141e.ds640);
        this.mImageHeight = (int) resources.getDimension(e.C0141e.ds278);
        this.gxk = (int) resources.getDimension(e.C0141e.tbds92);
        this.gxl = (int) resources.getDimension(e.C0141e.tbds92);
        this.gxm = (int) resources.getDimension(e.C0141e.tbds20);
        this.gxp = (int) resources.getDimension(e.C0141e.tbds90);
        this.gxq = (int) resources.getDimension(e.C0141e.tbds90);
        this.gxr = (int) resources.getDimension(e.C0141e.tbds22);
        this.gxn = (int) resources.getDimension(e.C0141e.tbds44);
        this.gxo = (int) resources.getDimension(e.C0141e.tbds44);
        this.gxs = (int) resources.getDimension(e.C0141e.ds12);
        this.gxt = (int) resources.getDimension(e.C0141e.ds1);
        this.gxu = (int) resources.getDimension(e.C0141e.ds18);
    }

    protected void i(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.gxG.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aTI() {
        MessageManager.getInstance().registerListener(this.gxL);
        MessageManager.getInstance().registerListener(this.gxM);
        MessageManager.getInstance().registerListener(this.gxN);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.cqY = this.mRootView.findViewById(e.g.bottom_line);
        this.gxj = this.mRootView.findViewById(e.g.thread_multi_del_ad_mask_view);
        this.gxj.setClickable(true);
        this.gxv = (TextView) this.mRootView.findViewById(e.g.ad_title);
        this.gxw = (TextView) this.mRootView.findViewById(e.g.transform_btn);
        this.gxA = (ApkDownloadView) this.mRootView.findViewById(e.g.advert_app_download_view);
        this.gxB = (TextView) this.mRootView.findViewById(e.g.advert_app_name);
        this.gxC = (RelativeLayout) this.mRootView.findViewById(e.g.bottom_transformation_area);
        this.gxA.p(this.mContext.getUniqueId());
        this.gxL.setTag(this.mContext.getUniqueId());
        this.gxD = this.mRootView.findViewById(e.g.card_ad_middle_container);
        this.gxM.setTag(this.mContext.getUniqueId());
        this.gxN.setTag(this.mContext.getUniqueId());
        this.gxG = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.gxG.setStyle(1);
        this.gxH = (ThreadUserInfoLayout) this.mRootView.findViewById(e.g.card_ad_user_info_layout);
        this.gxz = (LinearLayout) LayoutInflater.from(getContext()).inflate(e.h.ad_post_tag_close, (ViewGroup) null);
        this.gxy = (AdCloseView) this.gxz.findViewById(e.g.ad_close_view);
        this.gxx = (TextView) this.gxz.findViewById(e.g.feed_tag);
        this.gxH.addView(this.gxz);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gxz.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(e.C0141e.ds8);
        this.gxz.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        this.gxz.setLayoutParams(layoutParams);
        this.gxH.getHeaderImg().setDefaultErrorResource(e.f.icon_default_avatar100);
        this.gxH.getHeaderImg().setDefaultResource(e.f.icon_default_avatar100);
        this.gxH.getHeaderImg().setDefaultBgResource(e.d.cp_bg_line_e);
        this.cER = this.mRootView.findViewById(e.g.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.aO(getContext()) - this.gxn) - this.gxo) - this.gxk) - this.gxm;
            this.gxG.setVisibility(8);
        } else {
            this.mMaxWidth = (l.aO(getContext()) - this.gxn) - this.gxo;
            this.gxG.setVisibility(0);
        }
        this.gxh = (ViewStub) this.mRootView.findViewById(e.g.ad_custom_view_stub);
        this.gxh.setLayoutResource(getCustomLayout());
        this.gxi = this.gxh.inflate();
        this.gxI = this.mRootView.findViewById(e.g.pb_bottom_view);
        this.gxJ = this.mRootView.findViewById(e.g.frs_bottom_view);
        bL(this.gxi);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(final AdCard adCard) {
        final String str;
        this.gxF = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.gxH.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.De() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.bh(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.gxA.setOnClickListener(bVar);
        this.gxw.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gxD.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.gxk + this.gxm;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.gxH.getHeaderImg(), adCard.portraitClick, bVar);
        if (!TextUtils.isEmpty(adCard.tagName)) {
            this.gxx.setText(adCard.tagName);
        } else {
            this.gxx.setText("广告");
        }
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String tv2 = tv(ao.c(str2, 100, "..."));
            if (4 == getBusinessType()) {
                this.gxv.setTextSize(0, getContext().getResources().getDimension(e.C0141e.ds32));
            } else {
                this.gxv.setTextSize(0, getContext().getResources().getDimension(e.C0141e.tbfontsize48));
            }
            this.gxv.setText(tv2);
            this.gxv.setVisibility(0);
        } else {
            this.gxv.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.uJ()) && true == k.isEmpty(str3);
        a(this.gxC, this.gxw, this.gxA, adCard);
        if (!z && !TextUtils.isEmpty(adCard.userName)) {
            if (advertAppInfo != null && advertAppInfo.uI()) {
                this.gxB.setText(adCard.userName.concat("App").toString());
            } else if (advertAppInfo != null && advertAppInfo.uJ()) {
                this.gxB.setText(adCard.userName);
            }
        }
        if (advertAppInfo != null && advertAppInfo.uI()) {
            this.gxE = advertAppInfo.agk;
            this.gxA.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, -1));
            c2.setStatus(ApkDownloadView.getStatus(c2));
            a(this.gxw, c2.getStatus(), str3);
            this.gxA.setData(c2);
            this.gxA.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    al.c(this.gxw, e.d.btn_forum_focus_color, 1);
                    this.gxw.setText(str3);
                    if (k.isEmpty(str)) {
                        this.gxw.setClickable(false);
                    } else {
                        this.gxw.setClickable(true);
                        this.gxw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.eXP != null && adCard.buttonClick != null && !q.up(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.eXP.b(adCard.buttonClick.WC, adCard.buttonClick.WD, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int e = s.e(AdCardBaseView.this.mContext, str);
                                        if ((e == 1 || e == 2) && AdCardBaseView.this.eXP != null) {
                                            AdCardBaseView.this.eXP.b(e, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.mContext.getPageActivity());
                                    aVar.dT(adCard.popWindowText);
                                    aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int e2 = s.e(AdCardBaseView.this.mContext, str);
                                            if ((e2 == 1 || e2 == 2) && AdCardBaseView.this.eXP != null) {
                                                AdCardBaseView.this.eXP.b(e2, null);
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
                                    aVar.b(AdCardBaseView.this.mContext).yl();
                                }
                            }
                        });
                    }
                } else {
                    this.gxw.setClickable(false);
                    this.gxw.setText(adCard.buttonTextDone);
                    al.i(this.gxw, e.f.btn_rounded_corner_gray_frame);
                    al.c(this.gxw, e.d.cp_cont_d, 1);
                }
            }
            this.gxA.setVisibility(8);
        }
        a(adCard);
        i(i.uj().un(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            tw(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.agr != null && advertAppInfo.agr.adCloseInfo != null && advertAppInfo.agr.adCloseInfo.support_close.intValue() > 0) {
            this.gxy.setVisibility(0);
            this.gxy.setPage(getBusinessType());
            this.gxy.setData(advertAppInfo);
            l.a(this.mContext.getPageActivity(), this.gxz, 40, 40, 40, 120);
            this.gxz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.gxy.performClick();
                }
            });
        } else {
            this.gxy.setVisibility(8);
            this.gxx.setOnClickListener(null);
        }
        this.gxG.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.cqY.getLayoutParams();
        if (4 == getBusinessType()) {
            this.gxG.setVisibility(8);
            this.gxG.setBarNameClickEnabled(false);
            this.gxG.setShareVisible(false);
            this.gxG.setShowPraiseNum(false);
            this.gxG.setCommentNumEnable(false);
            this.gxG.setReplyTimeVisible(false);
            layoutParams2.height = this.gxt;
            this.gxI.setVisibility(0);
            this.gxJ.setVisibility(8);
        } else {
            a(adCard, bVar);
        }
        a(adCard, this.cER, getBusinessType());
        this.gxH.setData(adCard.getAdvertAppInfo());
        this.gxH.getHeaderImg().setVisibility(0);
        this.gxH.getHeaderImg().startLoad(adCard.userPortrait, 10, false);
        this.gxH.getUserName().setOnClickListener(bVar);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.avq().avr()) {
            this.gxj.setVisibility(0);
            al.j(this.gxj, e.d.cp_bg_line_d);
        } else {
            this.gxj.setVisibility(8);
        }
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean isInFrsAllThread() {
        return this.eWQ == 1;
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.gxJ.setVisibility(0);
            this.gxG.setVisibility(8);
            return;
        }
        this.gxJ.setVisibility(8);
        this.gxG.setVisibility(0);
        this.gxG.setBarNameClickEnabled(false);
        this.gxG.setReplyTimeVisible(false);
        this.gxG.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.gxG.setAgreeClickable(true);
            this.gxG.setPraiseContainerBgGray(false);
        } else {
            this.gxG.setAgreeClickable(false);
            this.gxG.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.gxG.setShareClickable(true);
            this.gxG.setShareContainerBgGray(false);
        } else {
            this.gxG.setShareClickable(false);
            this.gxG.setShareContainerBgGray(true);
        }
        this.gxG.getCommentContainer().setOnClickListener(bVar);
        this.gxG.setNeedAddReplyIcon(true);
        this.gxG.setCommentNumEnable(true);
        this.gxG.setCommentClickable(true);
        this.gxG.setReplayContainerBgGray(true);
        this.gxG.setOnClickListener(bVar);
        this.gxG.setShareData(adCard);
        this.gxG.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        al.i(this.cqY, e.d.cp_bg_line_c);
        this.gxy.onChangeSkinType();
        this.gxH.onChangeSkinType();
        this.gxG.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            al.i(this.mRootView, e.f.addresslist_item_bg);
            al.j(this.cqY, e.d.cp_bg_line_e);
            al.j(this.cER, e.d.cp_bg_line_e);
        } else {
            al.j(this.cqY, e.d.cp_bg_line_c);
            al.j(this.cER, e.d.transparent);
        }
        al.c(this.gxv, e.d.cp_cont_b, 1);
        al.j(this.gxC, e.d.cp_bg_line_e);
        al.h(this.gxB, e.d.cp_cont_j);
        al.c(this.gxx, e.d.cp_cont_d, 1);
        this.gxA.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String tv(String str) {
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
            if (b(bVar) && !q.up(bVar.scheme)) {
                if (this.eXP != null) {
                    this.eXP.b(bVar.WC, bVar.WD, null);
                    return;
                }
                return;
            }
            int e = s.e(this.mContext, tx(bVar.scheme));
            if (e == 1 || e == 2) {
                if (this.eXP != null) {
                    this.eXP.b(e, null);
                }
            } else if (this.eXP != null) {
                this.eXP.b(bVar.WC, bVar.WD, null);
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
                        if (AdCardBaseView.this.gxF.hasAnimation()) {
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
        this.eWm = new a.C0192a();
        this.eWm.picUrl = tbImageView.getUrl();
        this.eWm.rect = rect;
    }

    private void tw(String str) {
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
                    com.baidu.adp.lib.f.c.jn().a(jSONObject.optString("pic_url"), 17, null, this.eXW, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.eXW), this.mContext.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.uH() != 0) {
                l.showToast(this.mContext.getPageActivity(), e.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.Bb();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.x(this.mContext.getPageActivity()) && this.eXQ != null) {
                this.eXQ.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.p(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.ky()) {
                l.showToast(this.mContext.getPageActivity(), e.j.neterror);
            } else if (advertAppInfo.uI()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(e.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.dT(str);
                aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.gxA);
                        if (AdCardBaseView.this.gxA != null) {
                            AdCardBaseView.this.gxA.p(AdCardBaseView.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).yl();
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
                    a(advertAppInfo, i, this.gxA);
                    apkDownloadView.r(c2);
                    return;
            }
            g.aD(this.mContext.getPageActivity(), advertAppInfo.agk);
        }
    }

    public a.C0192a getAnimationInfo() {
        return this.eWm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private AdCard gxW;

        public b(AdCard adCard) {
            this.gxW = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.ky()) {
                AdCardBaseView.this.mContext.showToast(e.j.neterror);
            } else if (this.gxW != null) {
                AdvertAppInfo advertAppInfo = this.gxW.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.gxA;
                if (advertAppInfo != null && advertAppInfo.uI()) {
                    int l = com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, l));
                    if ((6 == status || 7 == status) && j.kK() && !j.kL()) {
                        AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, l, true, this.gxW.popWindowText);
                        return;
                    }
                    AdCardBaseView.this.a(advertAppInfo, l, AdCardBaseView.this.gxA, z);
                    if (AdCardBaseView.this.eXP != null) {
                        AdCardBaseView.this.eXP.b(3, null);
                        return;
                    }
                    return;
                }
                String scheme = this.gxW.getScheme();
                if (k.isEmpty(scheme) && advertAppInfo != null) {
                    scheme = advertAppInfo.agi;
                }
                if (this.gxW.hasAnimation()) {
                }
                int e = s.e(AdCardBaseView.this.mContext, AdCardBaseView.this.tx(scheme));
                if (AdCardBaseView.this.eXP != null) {
                    AdCardBaseView.this.eXP.b(e, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String tx(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.eWm != null && this.eWm.isValid()) {
            String c0192a = this.eWm.toString();
            if (!TextUtils.isEmpty(c0192a)) {
                sb.append("&");
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append("=");
                sb.append(URLEncoder.encode(c0192a));
            }
        }
        if (!TextUtils.isEmpty(this.gxF.getPreLoadData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append("=");
            sb.append(URLEncoder.encode(this.gxF.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.gxF.getNextPageData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append("=");
            sb.append(URLEncoder.encode(this.gxF.getNextPageData()));
        }
        if (this.gxF.hasAnimation()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append("=");
            sb.append("1");
        }
        if (this.gxF.isGoLandingPage()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append("=");
            sb.append("1");
        }
        if (this.gxF.isImmersiveStyle()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append("=");
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> gxV;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.gxV = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.gxV.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.gxE) ? false : true)) && adCardBaseView.gxE.equals(downloadData.getId())) {
                    int status = com.baidu.tieba.recapp.download.d.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.gxw.setText(e.j.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.gxw.setText(e.j.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> gxV;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.gxV = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.gxV.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.gxE) && adCardBaseView.gxE.equals(downloadData.getId())) {
                adCardBaseView.gxA.s(downloadData);
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> gxV;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.gxV = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.gxV.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                s.e(adCardBaseView.mContext, adCardBaseView.gxK.scheme);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aTR() {
        if (4 == getBusinessType()) {
            this.gxv.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.gwQ != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.gxK = bVar;
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
        if (adCard.getAdvertAppInfo().uI()) {
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
        DownloadData downloadData = new DownloadData(advertAppInfo.agk);
        downloadData.setUrl(advertAppInfo.agj);
        downloadData.setName(advertAppInfo.agg);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.l(advertAppInfo.agf, 0));
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
