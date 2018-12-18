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
    protected View cEB;
    protected View cUY;
    private a.C0263a fmf;
    private final int fnP;
    protected ViewStub gMZ;
    protected View gNA;
    protected View gNB;
    protected AdCard.b gNC;
    protected CustomMessageListener gND;
    protected CustomMessageListener gNE;
    protected CustomMessageListener gNF;
    protected View gNa;
    protected View gNb;
    protected final int gNc;
    protected final int gNd;
    protected final int gNe;
    protected final int gNf;
    protected final int gNg;
    protected final int gNh;
    protected final int gNi;
    protected final int gNj;
    private int gNk;
    private int gNl;
    private int gNm;
    protected TextView gNn;
    protected TextView gNo;
    protected TextView gNp;
    private AdCloseView gNq;
    private LinearLayout gNr;
    protected ApkDownloadView gNs;
    protected TextView gNt;
    protected RelativeLayout gNu;
    protected View gNv;
    protected String gNw;
    private AdCard gNx;
    private AdThreadCommentAndPraiseInfoLayout gNy;
    protected ThreadUserInfoLayout gNz;
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
        this.fnP = l.aO(getContext());
        this.gND = new a(2016484, this);
        this.gNE = new d(2016483, this);
        this.gNF = new c(2016494, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(e.C0210e.ds640);
        this.mImageHeight = (int) resources.getDimension(e.C0210e.ds278);
        this.gNc = (int) resources.getDimension(e.C0210e.tbds92);
        this.gNd = (int) resources.getDimension(e.C0210e.tbds92);
        this.gNe = (int) resources.getDimension(e.C0210e.tbds20);
        this.gNh = (int) resources.getDimension(e.C0210e.tbds90);
        this.gNi = (int) resources.getDimension(e.C0210e.tbds90);
        this.gNj = (int) resources.getDimension(e.C0210e.tbds22);
        this.gNf = (int) resources.getDimension(e.C0210e.tbds44);
        this.gNg = (int) resources.getDimension(e.C0210e.tbds44);
        this.gNk = (int) resources.getDimension(e.C0210e.ds12);
        this.gNl = (int) resources.getDimension(e.C0210e.ds1);
        this.gNm = (int) resources.getDimension(e.C0210e.ds18);
    }

    protected void k(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.gNy.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aYk() {
        MessageManager.getInstance().registerListener(this.gND);
        MessageManager.getInstance().registerListener(this.gNE);
        MessageManager.getInstance().registerListener(this.gNF);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.cEB = this.mRootView.findViewById(e.g.bottom_line);
        this.gNb = this.mRootView.findViewById(e.g.thread_multi_del_ad_mask_view);
        this.gNb.setClickable(true);
        this.gNn = (TextView) this.mRootView.findViewById(e.g.ad_title);
        this.gNo = (TextView) this.mRootView.findViewById(e.g.transform_btn);
        this.gNs = (ApkDownloadView) this.mRootView.findViewById(e.g.advert_app_download_view);
        this.gNt = (TextView) this.mRootView.findViewById(e.g.advert_app_name);
        this.gNu = (RelativeLayout) this.mRootView.findViewById(e.g.bottom_transformation_area);
        this.gNs.p(this.mContext.getUniqueId());
        this.gND.setTag(this.mContext.getUniqueId());
        this.gNv = this.mRootView.findViewById(e.g.card_ad_middle_container);
        this.gNE.setTag(this.mContext.getUniqueId());
        this.gNF.setTag(this.mContext.getUniqueId());
        this.gNy = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.gNy.setStyle(1);
        this.gNz = (ThreadUserInfoLayout) this.mRootView.findViewById(e.g.card_ad_user_info_layout);
        this.gNr = (LinearLayout) LayoutInflater.from(getContext()).inflate(e.h.ad_post_tag_close, (ViewGroup) null);
        this.gNq = (AdCloseView) this.gNr.findViewById(e.g.ad_close_view);
        this.gNp = (TextView) this.gNr.findViewById(e.g.feed_tag);
        this.gNz.addView(this.gNr);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gNr.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(e.C0210e.ds8);
        this.gNr.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        this.gNr.setLayoutParams(layoutParams);
        this.gNz.getHeaderImg().setDefaultErrorResource(e.f.icon_default_avatar100);
        this.gNz.getHeaderImg().setDefaultResource(e.f.icon_default_avatar100);
        this.gNz.getHeaderImg().setDefaultBgResource(e.d.cp_bg_line_e);
        this.cUY = this.mRootView.findViewById(e.g.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.aO(getContext()) - this.gNf) - this.gNg) - this.gNc) - this.gNe;
            this.gNy.setVisibility(8);
        } else {
            this.mMaxWidth = (l.aO(getContext()) - this.gNf) - this.gNg;
            this.gNy.setVisibility(0);
        }
        this.gMZ = (ViewStub) this.mRootView.findViewById(e.g.ad_custom_view_stub);
        this.gMZ.setLayoutResource(getCustomLayout());
        this.gNa = this.gMZ.inflate();
        this.gNA = this.mRootView.findViewById(e.g.pb_bottom_view);
        this.gNB = this.mRootView.findViewById(e.g.frs_bottom_view);
        bN(this.gNa);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(final AdCard adCard) {
        final String str;
        this.gNx = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.gNz.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.Gx() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.bg(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.gNs.setOnClickListener(bVar);
        this.gNo.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gNv.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.gNc + this.gNe;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.gNz.getHeaderImg(), adCard.portraitClick, bVar);
        if (!TextUtils.isEmpty(adCard.tagName)) {
            this.gNp.setText(adCard.tagName);
        } else {
            this.gNp.setText("广告");
        }
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String uC = uC(ao.c(str2, 100, "..."));
            if (4 == getBusinessType()) {
                this.gNn.setTextSize(0, getContext().getResources().getDimension(e.C0210e.ds32));
            } else {
                this.gNn.setTextSize(0, getContext().getResources().getDimension(e.C0210e.tbfontsize48));
            }
            this.gNn.setText(uC);
            this.gNn.setVisibility(0);
        } else {
            this.gNn.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.ye()) && true == k.isEmpty(str3);
        a(this.gNu, this.gNo, this.gNs, adCard);
        if (!z && !TextUtils.isEmpty(adCard.userName)) {
            if (advertAppInfo != null && advertAppInfo.yd()) {
                this.gNt.setText(adCard.userName.concat("App").toString());
            } else if (advertAppInfo != null && advertAppInfo.ye()) {
                this.gNt.setText(adCard.userName);
            }
        }
        if (advertAppInfo != null && advertAppInfo.yd()) {
            this.gNw = advertAppInfo.apv;
            this.gNs.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, -1));
            c2.setStatus(ApkDownloadView.getStatus(c2));
            a(this.gNo, c2.getStatus(), str3);
            this.gNs.setData(c2);
            this.gNs.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    al.c(this.gNo, e.d.btn_forum_focus_color, 1);
                    this.gNo.setText(str3);
                    if (k.isEmpty(str)) {
                        this.gNo.setClickable(false);
                    } else {
                        this.gNo.setClickable(true);
                        this.gNo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.fnI != null && adCard.buttonClick != null && !q.vx(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.fnI.b(adCard.buttonClick.abf, adCard.buttonClick.abg, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int e = s.e(AdCardBaseView.this.mContext, str);
                                        if ((e == 1 || e == 2) && AdCardBaseView.this.fnI != null) {
                                            AdCardBaseView.this.fnI.b(e, null);
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
                                            if ((e2 == 1 || e2 == 2) && AdCardBaseView.this.fnI != null) {
                                                AdCardBaseView.this.fnI.b(e2, null);
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
                    this.gNo.setClickable(false);
                    this.gNo.setText(adCard.buttonTextDone);
                    al.i(this.gNo, e.f.btn_rounded_corner_gray_frame);
                    al.c(this.gNo, e.d.cp_cont_d, 1);
                }
            }
            this.gNs.setVisibility(8);
        }
        a(adCard);
        k(i.xE().xI(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            uD(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.apB != null && advertAppInfo.apB.adCloseInfo != null && advertAppInfo.apB.adCloseInfo.support_close.intValue() > 0) {
            this.gNq.setVisibility(0);
            this.gNq.setPage(getBusinessType());
            this.gNq.setData(advertAppInfo);
            l.b(this.mContext.getPageActivity(), this.gNr, 40, 40, 40, 120);
            this.gNr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.gNq.performClick();
                }
            });
        } else {
            this.gNq.setVisibility(8);
            this.gNp.setOnClickListener(null);
        }
        this.gNy.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.cEB.getLayoutParams();
        if (4 == getBusinessType()) {
            this.gNy.setVisibility(8);
            this.gNy.setBarNameClickEnabled(false);
            this.gNy.setShareVisible(false);
            this.gNy.setShowPraiseNum(false);
            this.gNy.setCommentNumEnable(false);
            this.gNy.setReplyTimeVisible(false);
            layoutParams2.height = this.gNl;
            this.gNA.setVisibility(0);
            this.gNB.setVisibility(8);
        } else {
            a(adCard, bVar);
        }
        a(adCard, this.cUY, getBusinessType());
        this.gNz.setData(adCard.getAdvertAppInfo());
        this.gNz.getHeaderImg().setVisibility(0);
        this.gNz.getHeaderImg().startLoad(adCard.userPortrait, 10, false);
        this.gNz.getUserName().setOnClickListener(bVar);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.azU().azV()) {
            this.gNb.setVisibility(0);
            al.j(this.gNb, e.d.cp_bg_line_d);
        } else {
            this.gNb.setVisibility(8);
        }
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean isInFrsAllThread() {
        return this.fmJ == 1;
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.gNB.setVisibility(0);
            this.gNy.setVisibility(8);
            return;
        }
        this.gNB.setVisibility(8);
        this.gNy.setVisibility(0);
        this.gNy.setBarNameClickEnabled(false);
        this.gNy.setReplyTimeVisible(false);
        this.gNy.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.gNy.setAgreeClickable(true);
            this.gNy.setPraiseContainerBgGray(false);
        } else {
            this.gNy.setAgreeClickable(false);
            this.gNy.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.gNy.setShareClickable(true);
            this.gNy.setShareContainerBgGray(false);
        } else {
            this.gNy.setShareClickable(false);
            this.gNy.setShareContainerBgGray(true);
        }
        this.gNy.getCommentContainer().setOnClickListener(bVar);
        this.gNy.setNeedAddReplyIcon(true);
        this.gNy.setCommentNumEnable(true);
        this.gNy.setCommentClickable(true);
        this.gNy.setReplayContainerBgGray(true);
        this.gNy.setOnClickListener(bVar);
        this.gNy.setShareData(adCard);
        this.gNy.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        al.i(this.cEB, e.d.cp_bg_line_c);
        this.gNq.onChangeSkinType();
        this.gNz.onChangeSkinType();
        this.gNy.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            al.i(this.mRootView, e.f.addresslist_item_bg);
            al.j(this.cEB, e.d.cp_bg_line_e);
            al.j(this.cUY, e.d.cp_bg_line_e);
        } else {
            al.j(this.cEB, e.d.cp_bg_line_c);
            al.j(this.cUY, e.d.transparent);
        }
        al.c(this.gNn, e.d.cp_cont_b, 1);
        al.j(this.gNu, e.d.cp_bg_line_e);
        al.h(this.gNt, e.d.cp_cont_j);
        al.c(this.gNp, e.d.cp_cont_d, 1);
        this.gNs.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String uC(String str) {
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
            if (b(bVar) && !q.vx(bVar.scheme)) {
                if (this.fnI != null) {
                    this.fnI.b(bVar.abf, bVar.abg, null);
                    return;
                }
                return;
            }
            int e = s.e(this.mContext, uE(bVar.scheme));
            if (e == 1 || e == 2) {
                if (this.fnI != null) {
                    this.fnI.b(e, null);
                }
            } else if (this.fnI != null) {
                this.fnI.b(bVar.abf, bVar.abg, null);
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
                        if (AdCardBaseView.this.gNx.hasAnimation()) {
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
        this.fmf = new a.C0263a();
        this.fmf.picUrl = tbImageView.getUrl();
        this.fmf.rect = rect;
    }

    private void uD(String str) {
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
                    com.baidu.adp.lib.f.c.jA().a(jSONObject.optString("pic_url"), 17, null, this.fnP, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.fnP), this.mContext.getUniqueId(), new Object[0]);
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
            if (!this.mPermissionJudgePolicy.A(this.mContext.getPageActivity()) && this.fnJ != null) {
                this.fnJ.b(advertAppInfo, i);
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
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.gNs);
                        if (AdCardBaseView.this.gNs != null) {
                            AdCardBaseView.this.gNs.p(AdCardBaseView.this.c(advertAppInfo, i));
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
                    a(advertAppInfo, i, this.gNs);
                    apkDownloadView.r(c2);
                    return;
            }
            g.aG(this.mContext.getPageActivity(), advertAppInfo.apv);
        }
    }

    public a.C0263a getAnimationInfo() {
        return this.fmf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private AdCard gNO;

        public b(AdCard adCard) {
            this.gNO = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kK()) {
                AdCardBaseView.this.mContext.showToast(e.j.neterror);
            } else if (this.gNO != null) {
                AdvertAppInfo advertAppInfo = this.gNO.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.gNs;
                if (advertAppInfo != null && advertAppInfo.yd()) {
                    int l = com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, l));
                    if ((6 == status || 7 == status) && j.kV() && !j.kW()) {
                        AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, l, true, this.gNO.popWindowText);
                        return;
                    }
                    AdCardBaseView.this.a(advertAppInfo, l, AdCardBaseView.this.gNs, z);
                    if (AdCardBaseView.this.fnI != null) {
                        AdCardBaseView.this.fnI.b(3, null);
                        return;
                    }
                    return;
                }
                String scheme = this.gNO.getScheme();
                if (k.isEmpty(scheme) && advertAppInfo != null) {
                    scheme = advertAppInfo.apt;
                }
                if (this.gNO.hasAnimation()) {
                }
                int e = s.e(AdCardBaseView.this.mContext, AdCardBaseView.this.uE(scheme));
                if (AdCardBaseView.this.fnI != null) {
                    AdCardBaseView.this.fnI.b(e, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String uE(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.fmf != null && this.fmf.isValid()) {
            String c0263a = this.fmf.toString();
            if (!TextUtils.isEmpty(c0263a)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(c0263a));
            }
        }
        if (!TextUtils.isEmpty(this.gNx.getPreLoadData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.gNx.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.gNx.getNextPageData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.gNx.getNextPageData()));
        }
        if (this.gNx.hasAnimation()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.gNx.isGoLandingPage()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.gNx.isImmersiveStyle()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> gNN;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.gNN = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.gNN.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.gNw) ? false : true)) && adCardBaseView.gNw.equals(downloadData.getId())) {
                    int status = com.baidu.tieba.recapp.download.d.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.gNo.setText(e.j.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.gNo.setText(e.j.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> gNN;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.gNN = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.gNN.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.gNw) && adCardBaseView.gNw.equals(downloadData.getId())) {
                adCardBaseView.gNs.s(downloadData);
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> gNN;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.gNN = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.gNN.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                s.e(adCardBaseView.mContext, adCardBaseView.gNC.scheme);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aYs() {
        if (4 == getBusinessType()) {
            this.gNn.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.gMI != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.gNC = bVar;
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
