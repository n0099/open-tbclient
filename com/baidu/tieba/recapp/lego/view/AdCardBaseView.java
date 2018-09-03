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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
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
    protected View clf;
    protected View cyZ;
    private a.C0190a eOR;
    private final int eQB;
    protected ViewStub gpP;
    protected View gpQ;
    protected View gpR;
    protected final int gpS;
    protected final int gpT;
    protected final int gpU;
    protected final int gpV;
    protected final int gpW;
    protected final int gpX;
    protected final int gpY;
    protected final int gpZ;
    private int gqa;
    private int gqb;
    private int gqc;
    protected TextView gqd;
    protected TextView gqe;
    protected TextView gqf;
    private AdCloseView gqg;
    private LinearLayout gqh;
    protected ApkDownloadView gqi;
    protected TextView gqj;
    protected RelativeLayout gqk;
    protected View gql;
    protected String gqm;
    private AdCard gqn;
    private AdThreadCommentAndPraiseInfoLayout gqo;
    protected ThreadUserInfoLayout gqp;
    protected View gqq;
    protected View gqr;
    protected AdCard.b gqs;
    protected CustomMessageListener gqt;
    protected CustomMessageListener gqu;
    protected CustomMessageListener gqv;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void by(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eQB = l.ah(getContext());
        this.gqt = new a(2016484, this);
        this.gqu = new d(2016483, this);
        this.gqv = new c(2016494, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(f.e.ds640);
        this.mImageHeight = (int) resources.getDimension(f.e.ds278);
        this.gpS = (int) resources.getDimension(f.e.tbds92);
        this.gpT = (int) resources.getDimension(f.e.tbds92);
        this.gpU = (int) resources.getDimension(f.e.tbds20);
        this.gpX = (int) resources.getDimension(f.e.tbds90);
        this.gpY = (int) resources.getDimension(f.e.tbds90);
        this.gpZ = (int) resources.getDimension(f.e.tbds22);
        this.gpV = (int) resources.getDimension(f.e.tbds44);
        this.gpW = (int) resources.getDimension(f.e.tbds44);
        this.gqa = (int) resources.getDimension(f.e.ds12);
        this.gqb = (int) resources.getDimension(f.e.ds1);
        this.gqc = (int) resources.getDimension(f.e.ds18);
    }

    protected void k(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.gqo.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aRu() {
        MessageManager.getInstance().registerListener(this.gqt);
        MessageManager.getInstance().registerListener(this.gqu);
        MessageManager.getInstance().registerListener(this.gqv);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.clf = this.mRootView.findViewById(f.g.bottom_line);
        this.gpR = this.mRootView.findViewById(f.g.thread_multi_del_ad_mask_view);
        this.gpR.setClickable(true);
        this.gqd = (TextView) this.mRootView.findViewById(f.g.ad_title);
        this.gqe = (TextView) this.mRootView.findViewById(f.g.transform_btn);
        this.gqi = (ApkDownloadView) this.mRootView.findViewById(f.g.advert_app_download_view);
        this.gqj = (TextView) this.mRootView.findViewById(f.g.advert_app_name);
        this.gqk = (RelativeLayout) this.mRootView.findViewById(f.g.bottom_transformation_area);
        this.gqi.q(this.mContext.getUniqueId());
        this.gqt.setTag(this.mContext.getUniqueId());
        this.gql = this.mRootView.findViewById(f.g.card_ad_middle_container);
        this.gqu.setTag(this.mContext.getUniqueId());
        this.gqv.setTag(this.mContext.getUniqueId());
        this.gqo = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(f.g.card_home_page_normal_thread_info_layout);
        this.gqo.setStyle(1);
        this.gqp = (ThreadUserInfoLayout) this.mRootView.findViewById(f.g.card_ad_user_info_layout);
        this.gqh = (LinearLayout) LayoutInflater.from(getContext()).inflate(f.h.ad_post_tag_close, (ViewGroup) null);
        this.gqg = (AdCloseView) this.gqh.findViewById(f.g.ad_close_view);
        this.gqf = (TextView) this.gqh.findViewById(f.g.feed_tag);
        this.gqp.addView(this.gqh);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gqh.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(f.e.ds8);
        this.gqh.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        this.gqh.setLayoutParams(layoutParams);
        this.gqp.getHeaderImg().setDefaultErrorResource(f.C0146f.icon_default_avatar100);
        this.gqp.getHeaderImg().setDefaultResource(f.C0146f.icon_default_avatar100);
        this.gqp.getHeaderImg().setDefaultBgResource(f.d.cp_bg_line_e);
        this.cyZ = this.mRootView.findViewById(f.g.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.ah(getContext()) - this.gpV) - this.gpW) - this.gpS) - this.gpU;
            this.gqo.setVisibility(8);
        } else {
            this.mMaxWidth = (l.ah(getContext()) - this.gpV) - this.gpW;
            this.gqo.setVisibility(0);
        }
        this.gpP = (ViewStub) this.mRootView.findViewById(f.g.ad_custom_view_stub);
        this.gpP.setLayoutResource(getCustomLayout());
        this.gpQ = this.gpP.inflate();
        this.gqq = this.mRootView.findViewById(f.g.pb_bottom_view);
        this.gqr = this.mRootView.findViewById(f.g.frs_bottom_view);
        by(this.gpQ);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(final AdCard adCard) {
        final String str;
        this.gqn = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.gqp.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.BQ() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.aQ(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.gqi.setOnClickListener(bVar);
        this.gqe.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gql.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.gpS + this.gpU;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.gqp.getHeaderImg(), adCard.portraitClick, bVar);
        if (!TextUtils.isEmpty(adCard.tagName)) {
            this.gqf.setText(adCard.tagName);
        } else {
            this.gqf.setText("广告");
        }
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String sO = sO(ap.c(str2, 100, "..."));
            if (4 == getBusinessType()) {
                this.gqd.setTextSize(0, getContext().getResources().getDimension(f.e.ds32));
            } else {
                this.gqd.setTextSize(0, getContext().getResources().getDimension(f.e.tbfontsize48));
            }
            this.gqd.setText(sO);
            this.gqd.setVisibility(0);
        } else {
            this.gqd.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.tG()) && true == k.isEmpty(str3);
        a(this.gqk, this.gqe, this.gqi, adCard);
        if (!z && !TextUtils.isEmpty(adCard.userName)) {
            if (advertAppInfo != null && advertAppInfo.tF()) {
                this.gqj.setText(adCard.userName.concat("App").toString());
            } else if (advertAppInfo != null && advertAppInfo.tG()) {
                this.gqj.setText(adCard.userName);
            }
        }
        if (advertAppInfo != null && advertAppInfo.tF()) {
            this.gqm = advertAppInfo.adJ;
            this.gqi.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, -1));
            c2.setStatus(ApkDownloadView.getStatus(c2));
            a(this.gqe, c2.getStatus(), str3);
            this.gqi.setData(c2);
            this.gqi.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    am.c(this.gqe, f.d.btn_forum_focus_color, 1);
                    this.gqe.setText(str3);
                    if (k.isEmpty(str)) {
                        this.gqe.setClickable(false);
                    } else {
                        this.gqe.setClickable(true);
                        this.gqe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.eQu != null && adCard.buttonClick != null && !q.tI(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.eQu.b(adCard.buttonClick.Ua, adCard.buttonClick.Ub, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int e = s.e(AdCardBaseView.this.mContext, str);
                                        if ((e == 1 || e == 2) && AdCardBaseView.this.eQu != null) {
                                            AdCardBaseView.this.eQu.b(e, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.mContext.getPageActivity());
                                    aVar.dB(adCard.popWindowText);
                                    aVar.a(f.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int e2 = s.e(AdCardBaseView.this.mContext, str);
                                            if ((e2 == 1 || e2 == 2) && AdCardBaseView.this.eQu != null) {
                                                AdCardBaseView.this.eQu.b(e2, null);
                                            }
                                            aVar2.dismiss();
                                        }
                                    });
                                    aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.2
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            aVar2.dismiss();
                                        }
                                    });
                                    aVar.b(AdCardBaseView.this.mContext).xe();
                                }
                            }
                        });
                    }
                } else {
                    this.gqe.setClickable(false);
                    this.gqe.setText(adCard.buttonTextDone);
                    am.i(this.gqe, f.C0146f.btn_rounded_corner_gray_frame);
                    am.c(this.gqe, f.d.cp_cont_d, 1);
                }
            }
            this.gqi.setVisibility(8);
        }
        a(adCard);
        k(i.td().tj(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            sP(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.adQ != null && advertAppInfo.adQ.adCloseInfo != null && advertAppInfo.adQ.adCloseInfo.support_close.intValue() > 0) {
            this.gqg.setVisibility(0);
            this.gqg.setPage(getBusinessType());
            this.gqg.setData(advertAppInfo);
            l.a(this.mContext.getPageActivity(), this.gqh, 40, 40, 40, 120);
            this.gqh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.gqg.performClick();
                }
            });
        } else {
            this.gqg.setVisibility(8);
            this.gqf.setOnClickListener(null);
        }
        this.gqo.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.clf.getLayoutParams();
        if (4 == getBusinessType()) {
            this.gqo.setVisibility(8);
            this.gqo.setBarNameClickEnabled(false);
            this.gqo.setShareVisible(false);
            this.gqo.setShowPraiseNum(false);
            this.gqo.setCommentNumEnable(false);
            this.gqo.setReplyTimeVisible(false);
            layoutParams2.height = this.gqb;
            this.gqq.setVisibility(0);
            this.gqr.setVisibility(8);
        } else {
            a(adCard, bVar);
        }
        a(adCard, this.cyZ, getBusinessType());
        this.gqp.setData(adCard.getAdvertAppInfo());
        this.gqp.getHeaderImg().setVisibility(0);
        this.gqp.getHeaderImg().startLoad(adCard.userPortrait, 10, false);
        this.gqp.getUserName().setOnClickListener(bVar);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.atC().atD()) {
            this.gpR.setVisibility(0);
            am.j(this.gpR, f.d.cp_bg_line_d);
        } else {
            this.gpR.setVisibility(8);
        }
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean isInFrsAllThread() {
        return this.ePv == 1;
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.gqr.setVisibility(0);
            this.gqo.setVisibility(8);
            return;
        }
        this.gqr.setVisibility(8);
        this.gqo.setVisibility(0);
        this.gqo.setBarNameClickEnabled(false);
        this.gqo.setReplyTimeVisible(false);
        this.gqo.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.gqo.setAgreeClickable(true);
            this.gqo.setPraiseContainerBgGray(false);
        } else {
            this.gqo.setAgreeClickable(false);
            this.gqo.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.gqo.setShareClickable(true);
            this.gqo.setShareContainerBgGray(false);
        } else {
            this.gqo.setShareClickable(false);
            this.gqo.setShareContainerBgGray(true);
        }
        this.gqo.getCommentContainer().setOnClickListener(bVar);
        this.gqo.setNeedAddReplyIcon(true);
        this.gqo.setCommentNumEnable(true);
        this.gqo.setCommentClickable(true);
        this.gqo.setReplayContainerBgGray(true);
        this.gqo.setOnClickListener(bVar);
        this.gqo.setShareData(adCard);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        am.i(this.clf, f.d.cp_bg_line_c);
        this.gqg.onChangeSkinType();
        this.gqp.onChangeSkinType();
        this.gqo.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            am.i(this.mRootView, f.C0146f.addresslist_item_bg);
            am.j(this.clf, f.d.cp_bg_line_e);
            am.j(this.cyZ, f.d.cp_bg_line_e);
        } else {
            am.j(this.clf, f.d.cp_bg_line_c);
            am.j(this.cyZ, f.d.transparent);
        }
        am.c(this.gqd, f.d.cp_cont_b, 1);
        am.j(this.gqk, f.d.cp_bg_line_e);
        am.h(this.gqj, f.d.cp_cont_j);
        am.c(this.gqf, f.d.cp_cont_d, 1);
        this.gqi.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String sO(String str) {
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
            if (b(bVar) && !q.tI(bVar.scheme)) {
                if (this.eQu != null) {
                    this.eQu.b(bVar.Ua, bVar.Ub, null);
                    return;
                }
                return;
            }
            int e = s.e(this.mContext, sQ(bVar.scheme));
            if (e == 1 || e == 2) {
                if (this.eQu != null) {
                    this.eQu.b(e, null);
                }
            } else if (this.eQu != null) {
                this.eQu.b(bVar.Ua, bVar.Ub, null);
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
                        if (AdCardBaseView.this.gqn.hasAnimation()) {
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
        this.eOR = new a.C0190a();
        this.eOR.picUrl = tbImageView.getUrl();
        this.eOR.rect = rect;
    }

    private void sP(String str) {
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
                    com.baidu.adp.lib.f.c.ih().a(jSONObject.optString("pic_url"), 17, null, this.eQB, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.eQB), this.mContext.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.tE() != 0) {
                l.showToast(this.mContext.getPageActivity(), f.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.zW();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.u(this.mContext.getPageActivity()) && this.eQv != null) {
                this.eQv.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.p(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.js()) {
                l.showToast(this.mContext.getPageActivity(), f.j.neterror);
            } else if (advertAppInfo.tF()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(f.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.dB(str);
                aVar.a(f.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.gqi);
                        if (AdCardBaseView.this.gqi != null) {
                            AdCardBaseView.this.gqi.p(AdCardBaseView.this.c(advertAppInfo, i));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).xe();
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
                    a(advertAppInfo, i, this.gqi);
                    apkDownloadView.r(c2);
                    return;
            }
            g.an(this.mContext.getPageActivity(), advertAppInfo.adJ);
        }
    }

    public a.C0190a getAnimationInfo() {
        return this.eOR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private AdCard gqE;

        public b(AdCard adCard) {
            this.gqE = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.js()) {
                AdCardBaseView.this.mContext.showToast(f.j.neterror);
            } else if (this.gqE != null) {
                AdvertAppInfo advertAppInfo = this.gqE.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.gqi;
                if (advertAppInfo != null && advertAppInfo.tF()) {
                    int g = com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, g));
                    if ((6 == status || 7 == status) && j.jE() && !j.jF()) {
                        AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, g, true, this.gqE.popWindowText);
                        return;
                    }
                    AdCardBaseView.this.a(advertAppInfo, g, AdCardBaseView.this.gqi, z);
                    if (AdCardBaseView.this.eQu != null) {
                        AdCardBaseView.this.eQu.b(3, null);
                        return;
                    }
                    return;
                }
                String scheme = this.gqE.getScheme();
                if (k.isEmpty(scheme) && advertAppInfo != null) {
                    scheme = advertAppInfo.adH;
                }
                if (this.gqE.hasAnimation()) {
                }
                int e = s.e(AdCardBaseView.this.mContext, AdCardBaseView.this.sQ(scheme));
                if (AdCardBaseView.this.eQu != null) {
                    AdCardBaseView.this.eQu.b(e, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String sQ(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.eOR != null && this.eOR.isValid()) {
            String c0190a = this.eOR.toString();
            if (!TextUtils.isEmpty(c0190a)) {
                sb.append("&");
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append("=");
                sb.append(URLEncoder.encode(c0190a));
            }
        }
        if (!TextUtils.isEmpty(this.gqn.getPreLoadData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append("=");
            sb.append(URLEncoder.encode(this.gqn.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.gqn.getNextPageData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append("=");
            sb.append(URLEncoder.encode(this.gqn.getNextPageData()));
        }
        if (this.gqn.hasAnimation()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append("=");
            sb.append("1");
        }
        if (this.gqn.isGoLandingPage()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append("=");
            sb.append("1");
        }
        if (this.gqn.isImmersiveStyle()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append("=");
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> gqD;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.gqD = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.gqD.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.gqm) ? false : true)) && adCardBaseView.gqm.equals(downloadData.getId())) {
                    int status = com.baidu.tieba.recapp.download.d.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.gqe.setText(f.j.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.gqe.setText(f.j.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> gqD;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.gqD = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.gqD.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.gqm) && adCardBaseView.gqm.equals(downloadData.getId())) {
                adCardBaseView.gqi.s(downloadData);
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> gqD;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.gqD = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.gqD.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                s.e(adCardBaseView.mContext, adCardBaseView.gqs.scheme);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aRD() {
        if (4 == getBusinessType()) {
            this.gqd.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.gpy != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.gqs = bVar;
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
        if (adCard.getAdvertAppInfo().tF()) {
            textView.setVisibility(8);
            apkDownloadView.setVisibility(0);
            return;
        }
        if (true == k.isEmpty(adCard.buttonText) || "立即查看".equals(adCard.buttonText)) {
            textView.setVisibility(8);
            view.setVisibility(8);
        } else {
            textView.setVisibility(0);
            am.i(textView, f.C0146f.btn_focus_border_bg);
        }
        apkDownloadView.setVisibility(8);
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.adJ);
        downloadData.setUrl(advertAppInfo.adI);
        downloadData.setName(advertAppInfo.adF);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.g(advertAppInfo.adE, 0));
        return downloadData;
    }

    protected void a(TextView textView, int i, String str) {
        switch (i) {
            case 1:
            case 5:
                textView.setText(f.j.pause_load);
                return;
            case 2:
            case 4:
            default:
                return;
            case 3:
                textView.setText(f.j.downloaded_install);
                return;
            case 6:
                textView.setText(f.j.install_app);
                return;
            case 7:
                textView.setText(f.j.pb_download_pause);
                return;
        }
    }
}
