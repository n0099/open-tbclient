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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
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
import com.tencent.open.SocialConstants;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class AdCardBaseView extends BaseLegoCardView<AdCard> implements com.baidu.tieba.lego.card.b.a {
    protected View eEA;
    protected View ejX;
    protected TextView har;
    private a.C0365a hgf;
    private final int hhP;
    protected ViewStub iKN;
    protected View iKO;
    protected View iKP;
    protected final int iKQ;
    protected final int iKR;
    protected final int iKS;
    protected final int iKT;
    protected final int iKU;
    protected final int iKV;
    protected final int iKW;
    protected final int iKX;
    private int iKY;
    private int iKZ;
    private int iLa;
    protected TextView iLb;
    protected TextView iLc;
    private AdCloseView iLd;
    private LinearLayout iLe;
    protected ApkDownloadView iLf;
    protected TextView iLg;
    protected RelativeLayout iLh;
    protected View iLi;
    protected String iLj;
    private AdCard iLk;
    private AdThreadCommentAndPraiseInfoLayout iLl;
    protected AdThreadUserInfoLayout iLm;
    protected View iLn;
    protected View iLo;
    protected AdCard.b iLp;
    protected CustomMessageListener iLq;
    protected CustomMessageListener iLr;
    protected CustomMessageListener iLs;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgePolicy;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void cQ(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hhP = l.af(getContext());
        this.iLq = new a(2016484, this);
        this.iLr = new d(2016483, this);
        this.iLs = new c(2016494, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.ds640);
        this.mImageHeight = (int) resources.getDimension(R.dimen.ds278);
        this.iKQ = (int) resources.getDimension(R.dimen.tbds92);
        this.iKR = (int) resources.getDimension(R.dimen.tbds92);
        this.iKS = (int) resources.getDimension(R.dimen.tbds20);
        this.iKV = (int) resources.getDimension(R.dimen.tbds90);
        this.iKW = (int) resources.getDimension(R.dimen.tbds90);
        this.iKX = (int) resources.getDimension(R.dimen.tbds22);
        this.iKT = (int) resources.getDimension(R.dimen.tbds44);
        this.iKU = (int) resources.getDimension(R.dimen.tbds44);
        this.iKY = (int) resources.getDimension(R.dimen.ds12);
        this.iKZ = (int) resources.getDimension(R.dimen.ds1);
        this.iLa = (int) resources.getDimension(R.dimen.ds18);
    }

    protected void r(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.iLl.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bLw() {
        MessageManager.getInstance().registerListener(this.iLq);
        MessageManager.getInstance().registerListener(this.iLr);
        MessageManager.getInstance().registerListener(this.iLs);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.ejX = this.mRootView.findViewById(R.id.bottom_line);
        this.iKP = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.iKP.setClickable(true);
        this.har = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.iLb = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.iLf = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.iLg = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.iLh = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.iLf.s(this.mContext.getUniqueId());
        this.iLq.setTag(this.mContext.getUniqueId());
        this.iLi = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.iLr.setTag(this.mContext.getUniqueId());
        this.iLs.setTag(this.mContext.getUniqueId());
        this.iLl = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.iLl.setStyle(1);
        this.iLm = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        if (1 == getBusinessType()) {
            this.iLm.setShowFlag(1413);
        }
        this.iLe = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.iLd = (AdCloseView) this.iLe.findViewById(R.id.ad_close_view);
        this.iLc = (TextView) this.iLe.findViewById(R.id.feed_tag);
        this.iLc.setVisibility(8);
        this.iLm.addAdTagView(this.iLe);
        this.eEA = this.mRootView.findViewById(R.id.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.af(getContext()) - this.iKT) - this.iKU) - this.iKQ) - this.iKS;
            this.iLl.setVisibility(8);
        } else {
            this.mMaxWidth = (l.af(getContext()) - this.iKT) - this.iKU;
            this.iLl.setVisibility(0);
        }
        this.iKN = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.iKN.setLayoutResource(getCustomLayout());
        this.iKO = this.iKN.inflate();
        this.iLn = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.iLo = this.mRootView.findViewById(R.id.frs_bottom_view);
        cQ(this.iKO);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(final AdCard adCard) {
        final String str;
        this.iLk = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.iLm.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.amt() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.aS(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.iLf.setOnClickListener(bVar);
        this.iLb.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iLi.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.iKQ + this.iKS;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.iLm.getHeaderImg(), adCard.portraitClick, bVar);
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String Ek = Ek(aq.i(str2, 100, "..."));
            if (4 == getBusinessType()) {
                this.har.setTextSize(0, getContext().getResources().getDimension(R.dimen.ds32));
            } else {
                this.har.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize44));
            }
            this.har.setText(Ek);
            this.har.setVisibility(0);
        } else {
            this.har.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.acN()) && true == k.isEmpty(str3);
        a(this.iLh, this.iLb, this.iLf, adCard);
        if (advertAppInfo != null && advertAppInfo.acM()) {
            this.iLg.setText(adCard.userName.concat("APP").concat(" · 广告").toString());
        } else if (advertAppInfo != null && advertAppInfo.acN()) {
            String str4 = adCard.tagName;
            if (TextUtils.isEmpty(str4)) {
                str4 = "广告";
            }
            this.iLg.setText(str4);
        }
        if (advertAppInfo != null && advertAppInfo.acM()) {
            this.iLj = advertAppInfo.bFw;
            this.iLf.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.g.b.f(advertAppInfo.adPosition, -1));
            c2.setStatus(ApkDownloadView.getStatus(c2));
            a(this.iLb, c2.getStatus(), str3);
            this.iLf.setData(c2);
            this.iLf.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    am.f(this.iLb, R.color.btn_forum_focus_color, 1);
                    this.iLb.setText(str3);
                    if (k.isEmpty(str)) {
                        this.iLb.setClickable(false);
                    } else {
                        this.iLb.setClickable(true);
                        this.iLb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.hhI != null && adCard.buttonClick != null && !s.Fc(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.hhI.b(adCard.buttonClick.abI, adCard.buttonClick.abJ, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int a2 = com.baidu.tieba.recapp.s.a(AdCardBaseView.this.mContext, str, (AdCardBaseView.this.iLk == null || AdCardBaseView.this.iLk.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.iLk.getAdvertAppInfo().bFs);
                                        if ((a2 == 1 || a2 == 2) && AdCardBaseView.this.hhI != null) {
                                            AdCardBaseView.this.hhI.b(a2, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.mContext.getPageActivity());
                                    aVar.mQ(adCard.popWindowText);
                                    aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int a3 = com.baidu.tieba.recapp.s.a(AdCardBaseView.this.mContext, str, (AdCardBaseView.this.iLk == null || AdCardBaseView.this.iLk.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.iLk.getAdvertAppInfo().bFs);
                                            if ((a3 == 1 || a3 == 2) && AdCardBaseView.this.hhI != null) {
                                                AdCardBaseView.this.hhI.b(a3, null);
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
                                    aVar.b(AdCardBaseView.this.mContext).agO();
                                }
                            }
                        });
                    }
                } else {
                    this.iLb.setClickable(false);
                    this.iLb.setText(adCard.buttonTextDone);
                    am.k(this.iLb, R.drawable.btn_rounded_corner_gray_frame);
                    am.f(this.iLb, R.color.cp_cont_d, 1);
                }
            }
            this.iLf.setVisibility(8);
        }
        a(adCard);
        r(i.ace().aci(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            El(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.bFC != null && advertAppInfo.bFC.adCloseInfo != null && advertAppInfo.bFC.adCloseInfo.support_close.intValue() > 0) {
            this.iLd.setVisibility(0);
            this.iLd.setPage(getBusinessType());
            this.iLd.setData(advertAppInfo);
            l.b(this.mContext.getPageActivity(), this.iLe, 40, 40, 40, 120);
            this.iLe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.iLd.performClick();
                }
            });
        } else {
            this.iLd.setVisibility(8);
            this.iLc.setOnClickListener(null);
        }
        this.iLl.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.ejX.getLayoutParams();
        if (4 == getBusinessType()) {
            this.iLl.setVisibility(8);
            this.iLl.setBarNameClickEnabled(false);
            this.iLl.setShareVisible(false);
            this.iLl.setShowPraiseNum(false);
            this.iLl.setCommentNumEnable(false);
            this.iLl.setReplyTimeVisible(false);
            layoutParams2.height = this.iKZ;
            this.iLn.setVisibility(0);
            this.iLo.setVisibility(8);
        } else {
            a(adCard, bVar);
        }
        a(adCard, this.eEA, getBusinessType());
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 instanceof AdvertAppInfo) {
            advertAppInfo2.mz(aq.aE(adCard.time));
        }
        this.iLm.setData(advertAppInfo2);
        ((TextView) this.iLm.getUserName()).setText(adCard.userName);
        this.iLm.getUserName().setOnClickListener(bVar);
        this.iLm.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.iLm.getUserName()).setText(adCard.userName);
            }
        });
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.blQ().blR()) {
            this.iKP.setVisibility(0);
            am.l(this.iKP, R.color.cp_bg_line_d);
        } else {
            this.iKP.setVisibility(8);
        }
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean isInFrsAllThread() {
        return this.hgJ == 1;
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.iLo.setVisibility(0);
            this.iLl.setVisibility(8);
            return;
        }
        this.iLo.setVisibility(8);
        this.iLl.setVisibility(0);
        this.iLl.setBarNameClickEnabled(false);
        this.iLl.setReplyTimeVisible(false);
        this.iLl.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.iLl.setAgreeClickable(true);
            this.iLl.setPraiseContainerBgGray(false);
        } else {
            this.iLl.setAgreeClickable(false);
            this.iLl.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.iLl.setShareClickable(true);
            this.iLl.setShareContainerBgGray(false);
        } else {
            this.iLl.setShareClickable(false);
            this.iLl.setShareContainerBgGray(true);
        }
        if (this.iLl.getCommentContainer() != null) {
            this.iLl.getCommentContainer().setOnClickListener(bVar);
        }
        this.iLl.setNeedAddReplyIcon(true);
        this.iLl.setCommentNumEnable(false);
        this.iLl.setCommentClickable(true);
        this.iLl.setReplayContainerBgGray(true);
        this.iLl.setOnClickListener(bVar);
        this.iLl.setShareData(adCard);
        this.iLl.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        am.k(this.ejX, R.color.cp_bg_line_c);
        this.iLd.onChangeSkinType();
        this.iLm.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        this.iLl.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            am.k(this.mRootView, R.drawable.addresslist_item_bg);
            am.l(this.ejX, R.color.cp_bg_line_c);
            am.l(this.eEA, R.color.cp_bg_line_e);
        } else {
            am.l(this.ejX, R.color.cp_bg_line_c);
            am.l(this.eEA, R.color.transparent);
        }
        am.f(this.har, R.color.cp_cont_b, 1);
        am.j(this.iLg, R.color.cp_cont_d);
        am.f(this.iLc, R.color.cp_cont_d, 1);
        this.iLf.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String Ek(String str) {
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
            if (b(bVar) && !s.Fc(bVar.scheme)) {
                if (this.hhI != null) {
                    this.hhI.b(bVar.abI, bVar.abJ, null);
                    return;
                }
                return;
            }
            int a2 = com.baidu.tieba.recapp.s.a(this.mContext, Em(bVar.scheme), (this.iLk == null || this.iLk.getAdvertAppInfo() == null) ? null : this.iLk.getAdvertAppInfo().bFs);
            if (a2 == 1 || a2 == 2) {
                if (this.hhI != null) {
                    this.hhI.b(a2, null);
                }
            } else if (this.hhI != null) {
                this.hhI.b(bVar.abI, bVar.abJ, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final TbImageView tbImageView, final AdCard.b bVar) {
        if (tbImageView != null) {
            if (bVar != null && !k.isEmpty(bVar.scheme)) {
                tbImageView.setClickable(true);
                tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (AdCardBaseView.this.iLk.hasAnimation()) {
                            AdCardBaseView.this.e(tbImageView);
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
                view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.6
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
    public void e(TbImageView tbImageView) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        tbImageView.getLocationOnScreen(iArr);
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + tbImageView.getWidth();
        rect.bottom = rect.top + tbImageView.getHeight();
        this.hgf = new a.C0365a();
        this.hgf.picUrl = tbImageView.getUrl();
        this.hgf.cyf = rect;
    }

    private void El(String str) {
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
                    com.baidu.adp.lib.f.c.iE().a(jSONObject.optString("pic_url"), 17, null, this.hhP, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.hhP), this.mContext.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.acL() != 0) {
                l.showToast(this.mContext.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.c.a();
            }
            this.mPermissionJudgePolicy.ake();
            this.mPermissionJudgePolicy.e(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.ad(this.mContext.getPageActivity()) && this.hhJ != null) {
                this.hhJ.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.p(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.jQ()) {
                l.showToast(this.mContext.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.acM()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.mQ(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.iLf);
                        if (AdCardBaseView.this.iLf != null) {
                            AdCardBaseView.this.iLf.p(AdCardBaseView.this.c(advertAppInfo, i));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).agO();
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
                    a(advertAppInfo, i, this.iLf);
                    apkDownloadView.r(c2);
                    return;
            }
            h.aN(this.mContext.getPageActivity(), advertAppInfo.bFw);
        }
    }

    public a.C0365a getAnimationInfo() {
        return this.hgf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private AdCard iLC;

        public b(AdCard adCard) {
            this.iLC = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jQ()) {
                AdCardBaseView.this.mContext.showToast(R.string.neterror);
            } else if (this.iLC != null) {
                AdvertAppInfo advertAppInfo = this.iLC.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.iLf;
                if (advertAppInfo != null && advertAppInfo.acM()) {
                    int f = com.baidu.adp.lib.g.b.f(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, f));
                    if ((6 == status || 7 == status) && j.kc() && !j.kd()) {
                        AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, f, true, this.iLC.popWindowText);
                        return;
                    }
                    AdCardBaseView.this.a(advertAppInfo, f, AdCardBaseView.this.iLf, z);
                    if (AdCardBaseView.this.hhI != null) {
                        AdCardBaseView.this.hhI.b(3, null);
                        return;
                    }
                    return;
                }
                String scheme = this.iLC.getScheme();
                if (k.isEmpty(scheme) && advertAppInfo != null) {
                    scheme = advertAppInfo.bFu;
                }
                if (this.iLC.hasAnimation()) {
                }
                int a = com.baidu.tieba.recapp.s.a(AdCardBaseView.this.mContext, AdCardBaseView.this.Em(scheme), (AdCardBaseView.this.iLk == null || AdCardBaseView.this.iLk.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.iLk.getAdvertAppInfo().bFs);
                if (AdCardBaseView.this.hhI != null) {
                    AdCardBaseView.this.hhI.b(a, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Em(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.hgf != null && this.hgf.isValid()) {
            String c0365a = this.hgf.toString();
            if (!TextUtils.isEmpty(c0365a)) {
                sb.append("&");
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append("=");
                sb.append(URLEncoder.encode(c0365a));
            }
        }
        if (!TextUtils.isEmpty(this.iLk.getPreLoadData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append("=");
            sb.append(URLEncoder.encode(this.iLk.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.iLk.getNextPageData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append("=");
            sb.append(URLEncoder.encode(this.iLk.getNextPageData()));
        }
        if (this.iLk.hasAnimation()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append("=");
            sb.append("1");
        }
        if (this.iLk.isGoLandingPage()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append("=");
            sb.append("1");
        }
        if (this.iLk.isImmersiveStyle()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append("=");
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> iLB;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.iLB = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.iLB.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.iLj) ? false : true)) && adCardBaseView.iLj.equals(downloadData.getId())) {
                    int status = e.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.iLb.setText(R.string.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.iLb.setText(R.string.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> iLB;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.iLB = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.iLB.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.iLj) && adCardBaseView.iLj.equals(downloadData.getId())) {
                adCardBaseView.iLf.s(downloadData);
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> iLB;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.iLB = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.iLB.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                String str = null;
                if (adCardBaseView.iLk != null && adCardBaseView.iLk.getAdvertAppInfo() != null) {
                    str = adCardBaseView.iLk.getAdvertAppInfo().bFs;
                }
                com.baidu.tieba.recapp.s.a(adCardBaseView.mContext, adCardBaseView.iLp.scheme, str);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void bLD() {
        if (4 == getBusinessType()) {
            this.har.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.iKx != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.iLp = bVar;
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
        if (adCard.getAdvertAppInfo().acM()) {
            textView.setVisibility(8);
            apkDownloadView.setVisibility(0);
        } else if (true == k.isEmpty(adCard.buttonText) || "立即查看".equals(adCard.buttonText)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bFw);
        downloadData.setUrl(advertAppInfo.bFv);
        downloadData.setName(advertAppInfo.bFt);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.f(advertAppInfo.bFs, 0));
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
        }
    }
}
