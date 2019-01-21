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
    protected View cGn;
    protected View cYA;
    private a.C0263a fpS;
    private final int frD;
    protected ViewStub gQV;
    protected View gQW;
    protected View gQX;
    protected final int gQY;
    protected final int gQZ;
    protected CustomMessageListener gRA;
    protected CustomMessageListener gRB;
    protected final int gRa;
    protected final int gRb;
    protected final int gRc;
    protected final int gRd;
    protected final int gRe;
    protected final int gRf;
    private int gRg;
    private int gRh;
    private int gRi;
    protected TextView gRj;
    protected TextView gRk;
    protected TextView gRl;
    private AdCloseView gRm;
    private LinearLayout gRn;
    protected ApkDownloadView gRo;
    protected TextView gRp;
    protected RelativeLayout gRq;
    protected View gRr;
    protected String gRs;
    private AdCard gRt;
    private AdThreadCommentAndPraiseInfoLayout gRu;
    protected ThreadUserInfoLayout gRv;
    protected View gRw;
    protected View gRx;
    protected AdCard.b gRy;
    protected CustomMessageListener gRz;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void bQ(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.frD = l.aO(getContext());
        this.gRz = new a(2016484, this);
        this.gRA = new d(2016483, this);
        this.gRB = new c(2016494, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(e.C0210e.ds640);
        this.mImageHeight = (int) resources.getDimension(e.C0210e.ds278);
        this.gQY = (int) resources.getDimension(e.C0210e.tbds92);
        this.gQZ = (int) resources.getDimension(e.C0210e.tbds92);
        this.gRa = (int) resources.getDimension(e.C0210e.tbds20);
        this.gRd = (int) resources.getDimension(e.C0210e.tbds90);
        this.gRe = (int) resources.getDimension(e.C0210e.tbds90);
        this.gRf = (int) resources.getDimension(e.C0210e.tbds22);
        this.gRb = (int) resources.getDimension(e.C0210e.tbds44);
        this.gRc = (int) resources.getDimension(e.C0210e.tbds44);
        this.gRg = (int) resources.getDimension(e.C0210e.ds12);
        this.gRh = (int) resources.getDimension(e.C0210e.ds1);
        this.gRi = (int) resources.getDimension(e.C0210e.ds18);
    }

    protected void k(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.gRu.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aZy() {
        MessageManager.getInstance().registerListener(this.gRz);
        MessageManager.getInstance().registerListener(this.gRA);
        MessageManager.getInstance().registerListener(this.gRB);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.cGn = this.mRootView.findViewById(e.g.bottom_line);
        this.gQX = this.mRootView.findViewById(e.g.thread_multi_del_ad_mask_view);
        this.gQX.setClickable(true);
        this.gRj = (TextView) this.mRootView.findViewById(e.g.ad_title);
        this.gRk = (TextView) this.mRootView.findViewById(e.g.transform_btn);
        this.gRo = (ApkDownloadView) this.mRootView.findViewById(e.g.advert_app_download_view);
        this.gRp = (TextView) this.mRootView.findViewById(e.g.advert_app_name);
        this.gRq = (RelativeLayout) this.mRootView.findViewById(e.g.bottom_transformation_area);
        this.gRo.p(this.mContext.getUniqueId());
        this.gRz.setTag(this.mContext.getUniqueId());
        this.gRr = this.mRootView.findViewById(e.g.card_ad_middle_container);
        this.gRA.setTag(this.mContext.getUniqueId());
        this.gRB.setTag(this.mContext.getUniqueId());
        this.gRu = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.gRu.setStyle(1);
        this.gRv = (ThreadUserInfoLayout) this.mRootView.findViewById(e.g.card_ad_user_info_layout);
        this.gRn = (LinearLayout) LayoutInflater.from(getContext()).inflate(e.h.ad_post_tag_close, (ViewGroup) null);
        this.gRm = (AdCloseView) this.gRn.findViewById(e.g.ad_close_view);
        this.gRl = (TextView) this.gRn.findViewById(e.g.feed_tag);
        this.gRv.addView(this.gRn);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gRn.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(e.C0210e.ds8);
        this.gRn.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        this.gRn.setLayoutParams(layoutParams);
        this.gRv.getHeaderImg().setDefaultErrorResource(e.f.icon_default_avatar100);
        this.gRv.getHeaderImg().setDefaultResource(e.f.icon_default_avatar100);
        this.gRv.getHeaderImg().setDefaultBgResource(e.d.cp_bg_line_e);
        this.cYA = this.mRootView.findViewById(e.g.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.aO(getContext()) - this.gRb) - this.gRc) - this.gQY) - this.gRa;
            this.gRu.setVisibility(8);
        } else {
            this.mMaxWidth = (l.aO(getContext()) - this.gRb) - this.gRc;
            this.gRu.setVisibility(0);
        }
        this.gQV = (ViewStub) this.mRootView.findViewById(e.g.ad_custom_view_stub);
        this.gQV.setLayoutResource(getCustomLayout());
        this.gQW = this.gQV.inflate();
        this.gRw = this.mRootView.findViewById(e.g.pb_bottom_view);
        this.gRx = this.mRootView.findViewById(e.g.frs_bottom_view);
        bQ(this.gQW);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(final AdCard adCard) {
        final String str;
        this.gRt = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.gRv.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.GL() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.bg(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.gRo.setOnClickListener(bVar);
        this.gRk.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gRr.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.gQY + this.gRa;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.gRv.getHeaderImg(), adCard.portraitClick, bVar);
        if (!TextUtils.isEmpty(adCard.tagName)) {
            this.gRl.setText(adCard.tagName);
        } else {
            this.gRl.setText("广告");
        }
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String uV = uV(ao.c(str2, 100, "..."));
            if (4 == getBusinessType()) {
                this.gRj.setTextSize(0, getContext().getResources().getDimension(e.C0210e.ds32));
            } else {
                this.gRj.setTextSize(0, getContext().getResources().getDimension(e.C0210e.tbfontsize48));
            }
            this.gRj.setText(uV);
            this.gRj.setVisibility(0);
        } else {
            this.gRj.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.yr()) && true == k.isEmpty(str3);
        a(this.gRq, this.gRk, this.gRo, adCard);
        if (!z && !TextUtils.isEmpty(adCard.userName)) {
            if (advertAppInfo != null && advertAppInfo.yq()) {
                this.gRp.setText(adCard.userName.concat("App").toString());
            } else if (advertAppInfo != null && advertAppInfo.yr()) {
                this.gRp.setText(adCard.userName);
            }
        }
        if (advertAppInfo != null && advertAppInfo.yq()) {
            this.gRs = advertAppInfo.apY;
            this.gRo.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, -1));
            c2.setStatus(ApkDownloadView.getStatus(c2));
            a(this.gRk, c2.getStatus(), str3);
            this.gRo.setData(c2);
            this.gRo.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    al.c(this.gRk, e.d.btn_forum_focus_color, 1);
                    this.gRk.setText(str3);
                    if (k.isEmpty(str)) {
                        this.gRk.setClickable(false);
                    } else {
                        this.gRk.setClickable(true);
                        this.gRk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.frw != null && adCard.buttonClick != null && !q.vQ(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.frw.b(adCard.buttonClick.abo, adCard.buttonClick.abp, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int e = s.e(AdCardBaseView.this.mContext, str);
                                        if ((e == 1 || e == 2) && AdCardBaseView.this.frw != null) {
                                            AdCardBaseView.this.frw.b(e, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.mContext.getPageActivity());
                                    aVar.eK(adCard.popWindowText);
                                    aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int e2 = s.e(AdCardBaseView.this.mContext, str);
                                            if ((e2 == 1 || e2 == 2) && AdCardBaseView.this.frw != null) {
                                                AdCardBaseView.this.frw.b(e2, null);
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
                                    aVar.b(AdCardBaseView.this.mContext).BS();
                                }
                            }
                        });
                    }
                } else {
                    this.gRk.setClickable(false);
                    this.gRk.setText(adCard.buttonTextDone);
                    al.i(this.gRk, e.f.btn_rounded_corner_gray_frame);
                    al.c(this.gRk, e.d.cp_cont_d, 1);
                }
            }
            this.gRo.setVisibility(8);
        }
        a(adCard);
        k(i.xR().xV(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            uW(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.aqe != null && advertAppInfo.aqe.adCloseInfo != null && advertAppInfo.aqe.adCloseInfo.support_close.intValue() > 0) {
            this.gRm.setVisibility(0);
            this.gRm.setPage(getBusinessType());
            this.gRm.setData(advertAppInfo);
            l.b(this.mContext.getPageActivity(), this.gRn, 40, 40, 40, 120);
            this.gRn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.gRm.performClick();
                }
            });
        } else {
            this.gRm.setVisibility(8);
            this.gRl.setOnClickListener(null);
        }
        this.gRu.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.cGn.getLayoutParams();
        if (4 == getBusinessType()) {
            this.gRu.setVisibility(8);
            this.gRu.setBarNameClickEnabled(false);
            this.gRu.setShareVisible(false);
            this.gRu.setShowPraiseNum(false);
            this.gRu.setCommentNumEnable(false);
            this.gRu.setReplyTimeVisible(false);
            layoutParams2.height = this.gRh;
            this.gRw.setVisibility(0);
            this.gRx.setVisibility(8);
        } else {
            a(adCard, bVar);
        }
        a(adCard, this.cYA, getBusinessType());
        this.gRv.setData(adCard.getAdvertAppInfo());
        this.gRv.getHeaderImg().setVisibility(0);
        this.gRv.getHeaderImg().startLoad(adCard.userPortrait, 10, false);
        this.gRv.getUserName().setOnClickListener(bVar);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.aBg().aBh()) {
            this.gQX.setVisibility(0);
            al.j(this.gQX, e.d.cp_bg_line_d);
        } else {
            this.gQX.setVisibility(8);
        }
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean isInFrsAllThread() {
        return this.fqw == 1;
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.gRx.setVisibility(0);
            this.gRu.setVisibility(8);
            return;
        }
        this.gRx.setVisibility(8);
        this.gRu.setVisibility(0);
        this.gRu.setBarNameClickEnabled(false);
        this.gRu.setReplyTimeVisible(false);
        this.gRu.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.gRu.setAgreeClickable(true);
            this.gRu.setPraiseContainerBgGray(false);
        } else {
            this.gRu.setAgreeClickable(false);
            this.gRu.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.gRu.setShareClickable(true);
            this.gRu.setShareContainerBgGray(false);
        } else {
            this.gRu.setShareClickable(false);
            this.gRu.setShareContainerBgGray(true);
        }
        this.gRu.getCommentContainer().setOnClickListener(bVar);
        this.gRu.setNeedAddReplyIcon(true);
        this.gRu.setCommentNumEnable(true);
        this.gRu.setCommentClickable(true);
        this.gRu.setReplayContainerBgGray(true);
        this.gRu.setOnClickListener(bVar);
        this.gRu.setShareData(adCard);
        this.gRu.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        al.i(this.cGn, e.d.cp_bg_line_c);
        this.gRm.onChangeSkinType();
        this.gRv.onChangeSkinType();
        this.gRu.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            al.i(this.mRootView, e.f.addresslist_item_bg);
            al.j(this.cGn, e.d.cp_bg_line_e);
            al.j(this.cYA, e.d.cp_bg_line_e);
        } else {
            al.j(this.cGn, e.d.cp_bg_line_c);
            al.j(this.cYA, e.d.transparent);
        }
        al.c(this.gRj, e.d.cp_cont_b, 1);
        al.j(this.gRq, e.d.cp_bg_line_e);
        al.h(this.gRp, e.d.cp_cont_j);
        al.c(this.gRl, e.d.cp_cont_d, 1);
        this.gRo.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String uV(String str) {
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
            if (b(bVar) && !q.vQ(bVar.scheme)) {
                if (this.frw != null) {
                    this.frw.b(bVar.abo, bVar.abp, null);
                    return;
                }
                return;
            }
            int e = s.e(this.mContext, uX(bVar.scheme));
            if (e == 1 || e == 2) {
                if (this.frw != null) {
                    this.frw.b(e, null);
                }
            } else if (this.frw != null) {
                this.frw.b(bVar.abo, bVar.abp, null);
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
                        if (AdCardBaseView.this.gRt.hasAnimation()) {
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
        this.fpS = new a.C0263a();
        this.fpS.picUrl = tbImageView.getUrl();
        this.fpS.rect = rect;
    }

    private void uW(String str) {
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
                    com.baidu.adp.lib.f.c.jA().a(jSONObject.optString("pic_url"), 17, null, this.frD, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.frD), this.mContext.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.yp() != 0) {
                l.showToast(this.mContext.getPageActivity(), e.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.EG();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.B(this.mContext.getPageActivity()) && this.frx != null) {
                this.frx.b(advertAppInfo, i);
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
            } else if (advertAppInfo.yq()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(e.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.eK(str);
                aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.gRo);
                        if (AdCardBaseView.this.gRo != null) {
                            AdCardBaseView.this.gRo.p(AdCardBaseView.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).BS();
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
                    a(advertAppInfo, i, this.gRo);
                    apkDownloadView.r(c2);
                    return;
            }
            g.aE(this.mContext.getPageActivity(), advertAppInfo.apY);
        }
    }

    public a.C0263a getAnimationInfo() {
        return this.fpS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private AdCard gRK;

        public b(AdCard adCard) {
            this.gRK = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kK()) {
                AdCardBaseView.this.mContext.showToast(e.j.neterror);
            } else if (this.gRK != null) {
                AdvertAppInfo advertAppInfo = this.gRK.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.gRo;
                if (advertAppInfo != null && advertAppInfo.yq()) {
                    int l = com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, l));
                    if ((6 == status || 7 == status) && j.kV() && !j.kW()) {
                        AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, l, true, this.gRK.popWindowText);
                        return;
                    }
                    AdCardBaseView.this.a(advertAppInfo, l, AdCardBaseView.this.gRo, z);
                    if (AdCardBaseView.this.frw != null) {
                        AdCardBaseView.this.frw.b(3, null);
                        return;
                    }
                    return;
                }
                String scheme = this.gRK.getScheme();
                if (k.isEmpty(scheme) && advertAppInfo != null) {
                    scheme = advertAppInfo.apW;
                }
                if (this.gRK.hasAnimation()) {
                }
                int e = s.e(AdCardBaseView.this.mContext, AdCardBaseView.this.uX(scheme));
                if (AdCardBaseView.this.frw != null) {
                    AdCardBaseView.this.frw.b(e, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String uX(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.fpS != null && this.fpS.isValid()) {
            String c0263a = this.fpS.toString();
            if (!TextUtils.isEmpty(c0263a)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(c0263a));
            }
        }
        if (!TextUtils.isEmpty(this.gRt.getPreLoadData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.gRt.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.gRt.getNextPageData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.gRt.getNextPageData()));
        }
        if (this.gRt.hasAnimation()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.gRt.isGoLandingPage()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.gRt.isImmersiveStyle()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> gRJ;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.gRJ = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.gRJ.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.gRs) ? false : true)) && adCardBaseView.gRs.equals(downloadData.getId())) {
                    int status = com.baidu.tieba.recapp.download.d.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.gRk.setText(e.j.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.gRk.setText(e.j.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> gRJ;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.gRJ = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.gRJ.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.gRs) && adCardBaseView.gRs.equals(downloadData.getId())) {
                adCardBaseView.gRo.s(downloadData);
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> gRJ;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.gRJ = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.gRJ.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                s.e(adCardBaseView.mContext, adCardBaseView.gRy.scheme);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aZG() {
        if (4 == getBusinessType()) {
            this.gRj.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.gQE != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.gRy = bVar;
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
        if (adCard.getAdvertAppInfo().yq()) {
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
        DownloadData downloadData = new DownloadData(advertAppInfo.apY);
        downloadData.setUrl(advertAppInfo.apX);
        downloadData.setName(advertAppInfo.apU);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.l(advertAppInfo.apT, 0));
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
