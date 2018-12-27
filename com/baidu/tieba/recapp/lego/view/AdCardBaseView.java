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
    protected View cFB;
    protected View cXO;
    private a.C0263a foW;
    private final int fqH;
    protected ViewStub gPR;
    protected View gPS;
    protected View gPT;
    protected final int gPU;
    protected final int gPV;
    protected final int gPW;
    protected final int gPX;
    protected final int gPY;
    protected final int gPZ;
    protected final int gQa;
    protected final int gQb;
    private int gQc;
    private int gQd;
    private int gQe;
    protected TextView gQf;
    protected TextView gQg;
    protected TextView gQh;
    private AdCloseView gQi;
    private LinearLayout gQj;
    protected ApkDownloadView gQk;
    protected TextView gQl;
    protected RelativeLayout gQm;
    protected View gQn;
    protected String gQo;
    private AdCard gQp;
    private AdThreadCommentAndPraiseInfoLayout gQq;
    protected ThreadUserInfoLayout gQr;
    protected View gQs;
    protected View gQt;
    protected AdCard.b gQu;
    protected CustomMessageListener gQv;
    protected CustomMessageListener gQw;
    protected CustomMessageListener gQx;
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
        this.fqH = l.aO(getContext());
        this.gQv = new a(2016484, this);
        this.gQw = new d(2016483, this);
        this.gQx = new c(2016494, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(e.C0210e.ds640);
        this.mImageHeight = (int) resources.getDimension(e.C0210e.ds278);
        this.gPU = (int) resources.getDimension(e.C0210e.tbds92);
        this.gPV = (int) resources.getDimension(e.C0210e.tbds92);
        this.gPW = (int) resources.getDimension(e.C0210e.tbds20);
        this.gPZ = (int) resources.getDimension(e.C0210e.tbds90);
        this.gQa = (int) resources.getDimension(e.C0210e.tbds90);
        this.gQb = (int) resources.getDimension(e.C0210e.tbds22);
        this.gPX = (int) resources.getDimension(e.C0210e.tbds44);
        this.gPY = (int) resources.getDimension(e.C0210e.tbds44);
        this.gQc = (int) resources.getDimension(e.C0210e.ds12);
        this.gQd = (int) resources.getDimension(e.C0210e.ds1);
        this.gQe = (int) resources.getDimension(e.C0210e.ds18);
    }

    protected void k(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.gQq.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aYY() {
        MessageManager.getInstance().registerListener(this.gQv);
        MessageManager.getInstance().registerListener(this.gQw);
        MessageManager.getInstance().registerListener(this.gQx);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.cFB = this.mRootView.findViewById(e.g.bottom_line);
        this.gPT = this.mRootView.findViewById(e.g.thread_multi_del_ad_mask_view);
        this.gPT.setClickable(true);
        this.gQf = (TextView) this.mRootView.findViewById(e.g.ad_title);
        this.gQg = (TextView) this.mRootView.findViewById(e.g.transform_btn);
        this.gQk = (ApkDownloadView) this.mRootView.findViewById(e.g.advert_app_download_view);
        this.gQl = (TextView) this.mRootView.findViewById(e.g.advert_app_name);
        this.gQm = (RelativeLayout) this.mRootView.findViewById(e.g.bottom_transformation_area);
        this.gQk.p(this.mContext.getUniqueId());
        this.gQv.setTag(this.mContext.getUniqueId());
        this.gQn = this.mRootView.findViewById(e.g.card_ad_middle_container);
        this.gQw.setTag(this.mContext.getUniqueId());
        this.gQx.setTag(this.mContext.getUniqueId());
        this.gQq = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.gQq.setStyle(1);
        this.gQr = (ThreadUserInfoLayout) this.mRootView.findViewById(e.g.card_ad_user_info_layout);
        this.gQj = (LinearLayout) LayoutInflater.from(getContext()).inflate(e.h.ad_post_tag_close, (ViewGroup) null);
        this.gQi = (AdCloseView) this.gQj.findViewById(e.g.ad_close_view);
        this.gQh = (TextView) this.gQj.findViewById(e.g.feed_tag);
        this.gQr.addView(this.gQj);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gQj.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(e.C0210e.ds8);
        this.gQj.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        this.gQj.setLayoutParams(layoutParams);
        this.gQr.getHeaderImg().setDefaultErrorResource(e.f.icon_default_avatar100);
        this.gQr.getHeaderImg().setDefaultResource(e.f.icon_default_avatar100);
        this.gQr.getHeaderImg().setDefaultBgResource(e.d.cp_bg_line_e);
        this.cXO = this.mRootView.findViewById(e.g.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.aO(getContext()) - this.gPX) - this.gPY) - this.gPU) - this.gPW;
            this.gQq.setVisibility(8);
        } else {
            this.mMaxWidth = (l.aO(getContext()) - this.gPX) - this.gPY;
            this.gQq.setVisibility(0);
        }
        this.gPR = (ViewStub) this.mRootView.findViewById(e.g.ad_custom_view_stub);
        this.gPR.setLayoutResource(getCustomLayout());
        this.gPS = this.gPR.inflate();
        this.gQs = this.mRootView.findViewById(e.g.pb_bottom_view);
        this.gQt = this.mRootView.findViewById(e.g.frs_bottom_view);
        bQ(this.gPS);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(final AdCard adCard) {
        final String str;
        this.gQp = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.gQr.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.Gy() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.bg(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.gQk.setOnClickListener(bVar);
        this.gQg.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gQn.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.gPU + this.gPW;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.gQr.getHeaderImg(), adCard.portraitClick, bVar);
        if (!TextUtils.isEmpty(adCard.tagName)) {
            this.gQh.setText(adCard.tagName);
        } else {
            this.gQh.setText("广告");
        }
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String uF = uF(ao.c(str2, 100, "..."));
            if (4 == getBusinessType()) {
                this.gQf.setTextSize(0, getContext().getResources().getDimension(e.C0210e.ds32));
            } else {
                this.gQf.setTextSize(0, getContext().getResources().getDimension(e.C0210e.tbfontsize48));
            }
            this.gQf.setText(uF);
            this.gQf.setVisibility(0);
        } else {
            this.gQf.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.ye()) && true == k.isEmpty(str3);
        a(this.gQm, this.gQg, this.gQk, adCard);
        if (!z && !TextUtils.isEmpty(adCard.userName)) {
            if (advertAppInfo != null && advertAppInfo.yd()) {
                this.gQl.setText(adCard.userName.concat("App").toString());
            } else if (advertAppInfo != null && advertAppInfo.ye()) {
                this.gQl.setText(adCard.userName);
            }
        }
        if (advertAppInfo != null && advertAppInfo.yd()) {
            this.gQo = advertAppInfo.apv;
            this.gQk.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, -1));
            c2.setStatus(ApkDownloadView.getStatus(c2));
            a(this.gQg, c2.getStatus(), str3);
            this.gQk.setData(c2);
            this.gQk.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    al.c(this.gQg, e.d.btn_forum_focus_color, 1);
                    this.gQg.setText(str3);
                    if (k.isEmpty(str)) {
                        this.gQg.setClickable(false);
                    } else {
                        this.gQg.setClickable(true);
                        this.gQg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.fqA != null && adCard.buttonClick != null && !q.vA(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.fqA.b(adCard.buttonClick.abf, adCard.buttonClick.abg, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int e = s.e(AdCardBaseView.this.mContext, str);
                                        if ((e == 1 || e == 2) && AdCardBaseView.this.fqA != null) {
                                            AdCardBaseView.this.fqA.b(e, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.mContext.getPageActivity());
                                    aVar.eB(adCard.popWindowText);
                                    aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int e2 = s.e(AdCardBaseView.this.mContext, str);
                                            if ((e2 == 1 || e2 == 2) && AdCardBaseView.this.fqA != null) {
                                                AdCardBaseView.this.fqA.b(e2, null);
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
                                    aVar.b(AdCardBaseView.this.mContext).BF();
                                }
                            }
                        });
                    }
                } else {
                    this.gQg.setClickable(false);
                    this.gQg.setText(adCard.buttonTextDone);
                    al.i(this.gQg, e.f.btn_rounded_corner_gray_frame);
                    al.c(this.gQg, e.d.cp_cont_d, 1);
                }
            }
            this.gQk.setVisibility(8);
        }
        a(adCard);
        k(i.xE().xI(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            uG(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.apB != null && advertAppInfo.apB.adCloseInfo != null && advertAppInfo.apB.adCloseInfo.support_close.intValue() > 0) {
            this.gQi.setVisibility(0);
            this.gQi.setPage(getBusinessType());
            this.gQi.setData(advertAppInfo);
            l.b(this.mContext.getPageActivity(), this.gQj, 40, 40, 40, 120);
            this.gQj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.gQi.performClick();
                }
            });
        } else {
            this.gQi.setVisibility(8);
            this.gQh.setOnClickListener(null);
        }
        this.gQq.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.cFB.getLayoutParams();
        if (4 == getBusinessType()) {
            this.gQq.setVisibility(8);
            this.gQq.setBarNameClickEnabled(false);
            this.gQq.setShareVisible(false);
            this.gQq.setShowPraiseNum(false);
            this.gQq.setCommentNumEnable(false);
            this.gQq.setReplyTimeVisible(false);
            layoutParams2.height = this.gQd;
            this.gQs.setVisibility(0);
            this.gQt.setVisibility(8);
        } else {
            a(adCard, bVar);
        }
        a(adCard, this.cXO, getBusinessType());
        this.gQr.setData(adCard.getAdvertAppInfo());
        this.gQr.getHeaderImg().setVisibility(0);
        this.gQr.getHeaderImg().startLoad(adCard.userPortrait, 10, false);
        this.gQr.getUserName().setOnClickListener(bVar);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.aAJ().aAK()) {
            this.gPT.setVisibility(0);
            al.j(this.gPT, e.d.cp_bg_line_d);
        } else {
            this.gPT.setVisibility(8);
        }
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean isInFrsAllThread() {
        return this.fpB == 1;
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.gQt.setVisibility(0);
            this.gQq.setVisibility(8);
            return;
        }
        this.gQt.setVisibility(8);
        this.gQq.setVisibility(0);
        this.gQq.setBarNameClickEnabled(false);
        this.gQq.setReplyTimeVisible(false);
        this.gQq.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.gQq.setAgreeClickable(true);
            this.gQq.setPraiseContainerBgGray(false);
        } else {
            this.gQq.setAgreeClickable(false);
            this.gQq.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.gQq.setShareClickable(true);
            this.gQq.setShareContainerBgGray(false);
        } else {
            this.gQq.setShareClickable(false);
            this.gQq.setShareContainerBgGray(true);
        }
        this.gQq.getCommentContainer().setOnClickListener(bVar);
        this.gQq.setNeedAddReplyIcon(true);
        this.gQq.setCommentNumEnable(true);
        this.gQq.setCommentClickable(true);
        this.gQq.setReplayContainerBgGray(true);
        this.gQq.setOnClickListener(bVar);
        this.gQq.setShareData(adCard);
        this.gQq.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        al.i(this.cFB, e.d.cp_bg_line_c);
        this.gQi.onChangeSkinType();
        this.gQr.onChangeSkinType();
        this.gQq.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            al.i(this.mRootView, e.f.addresslist_item_bg);
            al.j(this.cFB, e.d.cp_bg_line_e);
            al.j(this.cXO, e.d.cp_bg_line_e);
        } else {
            al.j(this.cFB, e.d.cp_bg_line_c);
            al.j(this.cXO, e.d.transparent);
        }
        al.c(this.gQf, e.d.cp_cont_b, 1);
        al.j(this.gQm, e.d.cp_bg_line_e);
        al.h(this.gQl, e.d.cp_cont_j);
        al.c(this.gQh, e.d.cp_cont_d, 1);
        this.gQk.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String uF(String str) {
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
            if (b(bVar) && !q.vA(bVar.scheme)) {
                if (this.fqA != null) {
                    this.fqA.b(bVar.abf, bVar.abg, null);
                    return;
                }
                return;
            }
            int e = s.e(this.mContext, uH(bVar.scheme));
            if (e == 1 || e == 2) {
                if (this.fqA != null) {
                    this.fqA.b(e, null);
                }
            } else if (this.fqA != null) {
                this.fqA.b(bVar.abf, bVar.abg, null);
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
                        if (AdCardBaseView.this.gQp.hasAnimation()) {
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
        this.foW = new a.C0263a();
        this.foW.picUrl = tbImageView.getUrl();
        this.foW.rect = rect;
    }

    private void uG(String str) {
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
                    com.baidu.adp.lib.f.c.jA().a(jSONObject.optString("pic_url"), 17, null, this.fqH, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.fqH), this.mContext.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.yc() != 0) {
                l.showToast(this.mContext.getPageActivity(), e.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.Et();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.A(this.mContext.getPageActivity()) && this.fqB != null) {
                this.fqB.b(advertAppInfo, i);
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
            } else if (advertAppInfo.yd()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(e.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.eB(str);
                aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.gQk);
                        if (AdCardBaseView.this.gQk != null) {
                            AdCardBaseView.this.gQk.p(AdCardBaseView.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).BF();
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
                    a(advertAppInfo, i, this.gQk);
                    apkDownloadView.r(c2);
                    return;
            }
            g.aG(this.mContext.getPageActivity(), advertAppInfo.apv);
        }
    }

    public a.C0263a getAnimationInfo() {
        return this.foW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private AdCard gQG;

        public b(AdCard adCard) {
            this.gQG = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kK()) {
                AdCardBaseView.this.mContext.showToast(e.j.neterror);
            } else if (this.gQG != null) {
                AdvertAppInfo advertAppInfo = this.gQG.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.gQk;
                if (advertAppInfo != null && advertAppInfo.yd()) {
                    int l = com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, l));
                    if ((6 == status || 7 == status) && j.kV() && !j.kW()) {
                        AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, l, true, this.gQG.popWindowText);
                        return;
                    }
                    AdCardBaseView.this.a(advertAppInfo, l, AdCardBaseView.this.gQk, z);
                    if (AdCardBaseView.this.fqA != null) {
                        AdCardBaseView.this.fqA.b(3, null);
                        return;
                    }
                    return;
                }
                String scheme = this.gQG.getScheme();
                if (k.isEmpty(scheme) && advertAppInfo != null) {
                    scheme = advertAppInfo.apt;
                }
                if (this.gQG.hasAnimation()) {
                }
                int e = s.e(AdCardBaseView.this.mContext, AdCardBaseView.this.uH(scheme));
                if (AdCardBaseView.this.fqA != null) {
                    AdCardBaseView.this.fqA.b(e, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String uH(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.foW != null && this.foW.isValid()) {
            String c0263a = this.foW.toString();
            if (!TextUtils.isEmpty(c0263a)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(c0263a));
            }
        }
        if (!TextUtils.isEmpty(this.gQp.getPreLoadData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.gQp.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.gQp.getNextPageData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.gQp.getNextPageData()));
        }
        if (this.gQp.hasAnimation()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.gQp.isGoLandingPage()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.gQp.isImmersiveStyle()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> gQF;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.gQF = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.gQF.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.gQo) ? false : true)) && adCardBaseView.gQo.equals(downloadData.getId())) {
                    int status = com.baidu.tieba.recapp.download.d.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.gQg.setText(e.j.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.gQg.setText(e.j.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> gQF;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.gQF = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.gQF.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.gQo) && adCardBaseView.gQo.equals(downloadData.getId())) {
                adCardBaseView.gQk.s(downloadData);
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> gQF;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.gQF = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.gQF.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                s.e(adCardBaseView.mContext, adCardBaseView.gQu.scheme);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aZg() {
        if (4 == getBusinessType()) {
            this.gQf.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.gPA != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.gQu = bVar;
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
        if (adCard.getAdvertAppInfo().yd()) {
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
        DownloadData downloadData = new DownloadData(advertAppInfo.apv);
        downloadData.setUrl(advertAppInfo.apu);
        downloadData.setName(advertAppInfo.apr);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.l(advertAppInfo.apq, 0));
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
