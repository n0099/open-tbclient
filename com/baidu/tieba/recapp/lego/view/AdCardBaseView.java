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
import com.baidu.tieba.d;
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
    protected View cli;
    protected View czc;
    private a.C0190a eOW;
    private final int eQG;
    protected ViewStub gpM;
    protected View gpN;
    protected View gpO;
    protected final int gpP;
    protected final int gpQ;
    protected final int gpR;
    protected final int gpS;
    protected final int gpT;
    protected final int gpU;
    protected final int gpV;
    protected final int gpW;
    private int gpX;
    private int gpY;
    private int gpZ;
    protected TextView gqa;
    protected TextView gqb;
    protected TextView gqc;
    private AdCloseView gqd;
    private LinearLayout gqe;
    protected ApkDownloadView gqf;
    protected TextView gqg;
    protected RelativeLayout gqh;
    protected View gqi;
    protected String gqj;
    private AdCard gqk;
    private AdThreadCommentAndPraiseInfoLayout gql;
    protected ThreadUserInfoLayout gqm;
    protected View gqn;
    protected View gqo;
    protected AdCard.b gqp;
    protected CustomMessageListener gqq;
    protected CustomMessageListener gqr;
    protected CustomMessageListener gqs;
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
        this.eQG = l.ah(getContext());
        this.gqq = new a(2016484, this);
        this.gqr = new d(2016483, this);
        this.gqs = new c(2016494, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(d.e.ds640);
        this.mImageHeight = (int) resources.getDimension(d.e.ds278);
        this.gpP = (int) resources.getDimension(d.e.tbds92);
        this.gpQ = (int) resources.getDimension(d.e.tbds92);
        this.gpR = (int) resources.getDimension(d.e.tbds20);
        this.gpU = (int) resources.getDimension(d.e.tbds90);
        this.gpV = (int) resources.getDimension(d.e.tbds90);
        this.gpW = (int) resources.getDimension(d.e.tbds22);
        this.gpS = (int) resources.getDimension(d.e.tbds44);
        this.gpT = (int) resources.getDimension(d.e.tbds44);
        this.gpX = (int) resources.getDimension(d.e.ds12);
        this.gpY = (int) resources.getDimension(d.e.ds1);
        this.gpZ = (int) resources.getDimension(d.e.ds18);
    }

    protected void k(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.gql.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aRx() {
        MessageManager.getInstance().registerListener(this.gqq);
        MessageManager.getInstance().registerListener(this.gqr);
        MessageManager.getInstance().registerListener(this.gqs);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.cli = this.mRootView.findViewById(d.g.bottom_line);
        this.gpO = this.mRootView.findViewById(d.g.thread_multi_del_ad_mask_view);
        this.gpO.setClickable(true);
        this.gqa = (TextView) this.mRootView.findViewById(d.g.ad_title);
        this.gqb = (TextView) this.mRootView.findViewById(d.g.transform_btn);
        this.gqf = (ApkDownloadView) this.mRootView.findViewById(d.g.advert_app_download_view);
        this.gqg = (TextView) this.mRootView.findViewById(d.g.advert_app_name);
        this.gqh = (RelativeLayout) this.mRootView.findViewById(d.g.bottom_transformation_area);
        this.gqf.q(this.mContext.getUniqueId());
        this.gqq.setTag(this.mContext.getUniqueId());
        this.gqi = this.mRootView.findViewById(d.g.card_ad_middle_container);
        this.gqr.setTag(this.mContext.getUniqueId());
        this.gqs.setTag(this.mContext.getUniqueId());
        this.gql = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.gql.setStyle(1);
        this.gqm = (ThreadUserInfoLayout) this.mRootView.findViewById(d.g.card_ad_user_info_layout);
        this.gqe = (LinearLayout) LayoutInflater.from(getContext()).inflate(d.h.ad_post_tag_close, (ViewGroup) null);
        this.gqd = (AdCloseView) this.gqe.findViewById(d.g.ad_close_view);
        this.gqc = (TextView) this.gqe.findViewById(d.g.feed_tag);
        this.gqm.addView(this.gqe);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gqe.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(d.e.ds8);
        this.gqe.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        this.gqe.setLayoutParams(layoutParams);
        this.gqm.getHeaderImg().setDefaultErrorResource(d.f.icon_default_avatar100);
        this.gqm.getHeaderImg().setDefaultResource(d.f.icon_default_avatar100);
        this.gqm.getHeaderImg().setDefaultBgResource(d.C0140d.cp_bg_line_e);
        this.czc = this.mRootView.findViewById(d.g.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.ah(getContext()) - this.gpS) - this.gpT) - this.gpP) - this.gpR;
            this.gql.setVisibility(8);
        } else {
            this.mMaxWidth = (l.ah(getContext()) - this.gpS) - this.gpT;
            this.gql.setVisibility(0);
        }
        this.gpM = (ViewStub) this.mRootView.findViewById(d.g.ad_custom_view_stub);
        this.gpM.setLayoutResource(getCustomLayout());
        this.gpN = this.gpM.inflate();
        this.gqn = this.mRootView.findViewById(d.g.pb_bottom_view);
        this.gqo = this.mRootView.findViewById(d.g.frs_bottom_view);
        by(this.gpN);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(final AdCard adCard) {
        final String str;
        this.gqk = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.gqm.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.BT() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.aQ(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.gqf.setOnClickListener(bVar);
        this.gqb.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gqi.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.gpP + this.gpR;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.gqm.getHeaderImg(), adCard.portraitClick, bVar);
        if (!TextUtils.isEmpty(adCard.tagName)) {
            this.gqc.setText(adCard.tagName);
        } else {
            this.gqc.setText("广告");
        }
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String sK = sK(ap.d(str2, 100, "..."));
            if (4 == getBusinessType()) {
                this.gqa.setTextSize(0, getContext().getResources().getDimension(d.e.ds32));
            } else {
                this.gqa.setTextSize(0, getContext().getResources().getDimension(d.e.tbfontsize48));
            }
            this.gqa.setText(sK);
            this.gqa.setVisibility(0);
        } else {
            this.gqa.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.tH()) && true == k.isEmpty(str3);
        a(this.gqh, this.gqb, this.gqf, adCard);
        if (!z && !TextUtils.isEmpty(adCard.userName)) {
            if (advertAppInfo != null && advertAppInfo.tG()) {
                this.gqg.setText(adCard.userName.concat("App").toString());
            } else if (advertAppInfo != null && advertAppInfo.tH()) {
                this.gqg.setText(adCard.userName);
            }
        }
        if (advertAppInfo != null && advertAppInfo.tG()) {
            this.gqj = advertAppInfo.adJ;
            this.gqf.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, -1));
            c2.setStatus(ApkDownloadView.getStatus(c2));
            a(this.gqb, c2.getStatus(), str3);
            this.gqf.setData(c2);
            this.gqf.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    am.c(this.gqb, d.C0140d.btn_forum_focus_color, 1);
                    this.gqb.setText(str3);
                    if (k.isEmpty(str)) {
                        this.gqb.setClickable(false);
                    } else {
                        this.gqb.setClickable(true);
                        this.gqb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.eQz != null && adCard.buttonClick != null && !q.tE(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.eQz.b(adCard.buttonClick.Ua, adCard.buttonClick.Ub, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int e = s.e(AdCardBaseView.this.mContext, str);
                                        if ((e == 1 || e == 2) && AdCardBaseView.this.eQz != null) {
                                            AdCardBaseView.this.eQz.b(e, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.mContext.getPageActivity());
                                    aVar.dB(adCard.popWindowText);
                                    aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int e2 = s.e(AdCardBaseView.this.mContext, str);
                                            if ((e2 == 1 || e2 == 2) && AdCardBaseView.this.eQz != null) {
                                                AdCardBaseView.this.eQz.b(e2, null);
                                            }
                                            aVar2.dismiss();
                                        }
                                    });
                                    aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.2
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            aVar2.dismiss();
                                        }
                                    });
                                    aVar.b(AdCardBaseView.this.mContext).xf();
                                }
                            }
                        });
                    }
                } else {
                    this.gqb.setClickable(false);
                    this.gqb.setText(adCard.buttonTextDone);
                    am.i(this.gqb, d.f.btn_rounded_corner_gray_frame);
                    am.c(this.gqb, d.C0140d.cp_cont_d, 1);
                }
            }
            this.gqf.setVisibility(8);
        }
        a(adCard);
        k(i.te().tk(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            sL(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.adQ != null && advertAppInfo.adQ.adCloseInfo != null && advertAppInfo.adQ.adCloseInfo.support_close.intValue() > 0) {
            this.gqd.setVisibility(0);
            this.gqd.setPage(getBusinessType());
            this.gqd.setData(advertAppInfo);
            l.a(this.mContext.getPageActivity(), this.gqe, 40, 40, 40, 120);
            this.gqe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.gqd.performClick();
                }
            });
        } else {
            this.gqd.setVisibility(8);
            this.gqc.setOnClickListener(null);
        }
        this.gql.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.cli.getLayoutParams();
        if (4 == getBusinessType()) {
            this.gql.setVisibility(8);
            this.gql.setBarNameClickEnabled(false);
            this.gql.setShareVisible(false);
            this.gql.setShowPraiseNum(false);
            this.gql.setCommentNumEnable(false);
            this.gql.setReplyTimeVisible(false);
            layoutParams2.height = this.gpY;
            this.gqn.setVisibility(0);
            this.gqo.setVisibility(8);
        } else {
            a(adCard, bVar);
        }
        a(adCard, this.czc, getBusinessType());
        this.gqm.setData(adCard.getAdvertAppInfo());
        this.gqm.getHeaderImg().setVisibility(0);
        this.gqm.getHeaderImg().startLoad(adCard.userPortrait, 10, false);
        this.gqm.getUserName().setOnClickListener(bVar);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.atD().atE()) {
            this.gpO.setVisibility(0);
            am.j(this.gpO, d.C0140d.cp_bg_line_d);
        } else {
            this.gpO.setVisibility(8);
        }
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean isInFrsAllThread() {
        return this.ePA == 1;
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.gqo.setVisibility(0);
            this.gql.setVisibility(8);
            return;
        }
        this.gqo.setVisibility(8);
        this.gql.setVisibility(0);
        this.gql.setBarNameClickEnabled(false);
        this.gql.setReplyTimeVisible(false);
        this.gql.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.gql.setAgreeClickable(true);
            this.gql.setPraiseContainerBgGray(false);
        } else {
            this.gql.setAgreeClickable(false);
            this.gql.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.gql.setShareClickable(true);
            this.gql.setShareContainerBgGray(false);
        } else {
            this.gql.setShareClickable(false);
            this.gql.setShareContainerBgGray(true);
        }
        this.gql.getCommentContainer().setOnClickListener(bVar);
        this.gql.setNeedAddReplyIcon(true);
        this.gql.setCommentNumEnable(true);
        this.gql.setCommentClickable(true);
        this.gql.setReplayContainerBgGray(true);
        this.gql.setOnClickListener(bVar);
        this.gql.setShareData(adCard);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        am.i(this.cli, d.C0140d.cp_bg_line_c);
        this.gqd.onChangeSkinType();
        this.gqm.onChangeSkinType();
        this.gql.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            am.i(this.mRootView, d.f.addresslist_item_bg);
            am.j(this.cli, d.C0140d.cp_bg_line_e);
            am.j(this.czc, d.C0140d.cp_bg_line_e);
        } else {
            am.j(this.cli, d.C0140d.cp_bg_line_c);
            am.j(this.czc, d.C0140d.transparent);
        }
        am.c(this.gqa, d.C0140d.cp_cont_b, 1);
        am.j(this.gqh, d.C0140d.cp_bg_line_e);
        am.h(this.gqg, d.C0140d.cp_cont_j);
        am.c(this.gqc, d.C0140d.cp_cont_d, 1);
        this.gqf.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String sK(String str) {
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
            if (b(bVar) && !q.tE(bVar.scheme)) {
                if (this.eQz != null) {
                    this.eQz.b(bVar.Ua, bVar.Ub, null);
                    return;
                }
                return;
            }
            int e = s.e(this.mContext, sM(bVar.scheme));
            if (e == 1 || e == 2) {
                if (this.eQz != null) {
                    this.eQz.b(e, null);
                }
            } else if (this.eQz != null) {
                this.eQz.b(bVar.Ua, bVar.Ub, null);
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
                        if (AdCardBaseView.this.gqk.hasAnimation()) {
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
        this.eOW = new a.C0190a();
        this.eOW.picUrl = tbImageView.getUrl();
        this.eOW.rect = rect;
    }

    private void sL(String str) {
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
                    com.baidu.adp.lib.f.c.ih().a(jSONObject.optString("pic_url"), 17, null, this.eQG, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.eQG), this.mContext.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.tF() != 0) {
                l.showToast(this.mContext.getPageActivity(), d.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.zY();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.u(this.mContext.getPageActivity()) && this.eQA != null) {
                this.eQA.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.p(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.js()) {
                l.showToast(this.mContext.getPageActivity(), d.j.neterror);
            } else if (advertAppInfo.tG()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(d.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.dB(str);
                aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.gqf);
                        if (AdCardBaseView.this.gqf != null) {
                            AdCardBaseView.this.gqf.p(AdCardBaseView.this.c(advertAppInfo, i));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).xf();
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
                    a(advertAppInfo, i, this.gqf);
                    apkDownloadView.r(c2);
                    return;
            }
            g.an(this.mContext.getPageActivity(), advertAppInfo.adJ);
        }
    }

    public a.C0190a getAnimationInfo() {
        return this.eOW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private AdCard gqB;

        public b(AdCard adCard) {
            this.gqB = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.js()) {
                AdCardBaseView.this.mContext.showToast(d.j.neterror);
            } else if (this.gqB != null) {
                AdvertAppInfo advertAppInfo = this.gqB.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.gqf;
                if (advertAppInfo != null && advertAppInfo.tG()) {
                    int g = com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, g));
                    if ((6 == status || 7 == status) && j.jE() && !j.jF()) {
                        AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, g, true, this.gqB.popWindowText);
                        return;
                    }
                    AdCardBaseView.this.a(advertAppInfo, g, AdCardBaseView.this.gqf, z);
                    if (AdCardBaseView.this.eQz != null) {
                        AdCardBaseView.this.eQz.b(3, null);
                        return;
                    }
                    return;
                }
                String scheme = this.gqB.getScheme();
                if (k.isEmpty(scheme) && advertAppInfo != null) {
                    scheme = advertAppInfo.adH;
                }
                if (this.gqB.hasAnimation()) {
                }
                int e = s.e(AdCardBaseView.this.mContext, AdCardBaseView.this.sM(scheme));
                if (AdCardBaseView.this.eQz != null) {
                    AdCardBaseView.this.eQz.b(e, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String sM(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.eOW != null && this.eOW.isValid()) {
            String c0190a = this.eOW.toString();
            if (!TextUtils.isEmpty(c0190a)) {
                sb.append("&");
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append("=");
                sb.append(URLEncoder.encode(c0190a));
            }
        }
        if (!TextUtils.isEmpty(this.gqk.getPreLoadData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append("=");
            sb.append(URLEncoder.encode(this.gqk.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.gqk.getNextPageData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append("=");
            sb.append(URLEncoder.encode(this.gqk.getNextPageData()));
        }
        if (this.gqk.hasAnimation()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append("=");
            sb.append("1");
        }
        if (this.gqk.isGoLandingPage()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append("=");
            sb.append("1");
        }
        if (this.gqk.isImmersiveStyle()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append("=");
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> gqA;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.gqA = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.gqA.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.gqj) ? false : true)) && adCardBaseView.gqj.equals(downloadData.getId())) {
                    int status = com.baidu.tieba.recapp.download.d.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.gqb.setText(d.j.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.gqb.setText(d.j.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> gqA;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.gqA = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.gqA.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.gqj) && adCardBaseView.gqj.equals(downloadData.getId())) {
                adCardBaseView.gqf.s(downloadData);
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> gqA;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.gqA = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.gqA.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                s.e(adCardBaseView.mContext, adCardBaseView.gqp.scheme);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aRG() {
        if (4 == getBusinessType()) {
            this.gqa.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.gpv != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.gqp = bVar;
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
        if (adCard.getAdvertAppInfo().tG()) {
            textView.setVisibility(8);
            apkDownloadView.setVisibility(0);
            return;
        }
        if (true == k.isEmpty(adCard.buttonText) || "立即查看".equals(adCard.buttonText)) {
            textView.setVisibility(8);
            view.setVisibility(8);
        } else {
            textView.setVisibility(0);
            am.i(textView, d.f.btn_focus_border_bg);
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
                textView.setText(d.j.pause_load);
                return;
            case 2:
            case 4:
            default:
                return;
            case 3:
                textView.setText(d.j.downloaded_install);
                return;
            case 6:
                textView.setText(d.j.install_app);
                return;
            case 7:
                textView.setText(d.j.pb_download_pause);
                return;
        }
    }
}
