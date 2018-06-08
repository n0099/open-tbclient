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
    protected View chp;
    protected View cyF;
    private a.C0189a eHk;
    private final int eIU;
    protected ViewStub gkM;
    protected View gkN;
    protected final int gkO;
    protected final int gkP;
    protected final int gkQ;
    protected final int gkR;
    protected final int gkS;
    protected final int gkT;
    protected final int gkU;
    protected final int gkV;
    private int gkW;
    private int gkX;
    private int gkY;
    protected TextView gkZ;
    protected TextView gla;
    protected TextView glb;
    private AdCloseView glc;
    private LinearLayout gld;
    protected ApkDownloadView gle;
    protected TextView glf;
    protected RelativeLayout glg;
    protected View glh;
    protected String gli;
    private AdCard glj;
    private AdThreadCommentAndPraiseInfoLayout glk;
    protected ThreadUserInfoLayout gll;
    protected View glm;
    protected View gln;
    protected AdCard.b glo;
    protected CustomMessageListener glp;
    protected CustomMessageListener glq;
    protected CustomMessageListener glr;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void bu(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eIU = l.ah(getContext());
        this.glp = new a(2016484, this);
        this.glq = new d(2016483, this);
        this.glr = new c(2016494, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(d.e.ds640);
        this.mImageHeight = (int) resources.getDimension(d.e.ds278);
        this.gkO = (int) resources.getDimension(d.e.tbds92);
        this.gkP = (int) resources.getDimension(d.e.tbds92);
        this.gkQ = (int) resources.getDimension(d.e.tbds20);
        this.gkT = (int) resources.getDimension(d.e.tbds90);
        this.gkU = (int) resources.getDimension(d.e.tbds90);
        this.gkV = (int) resources.getDimension(d.e.tbds22);
        this.gkR = (int) resources.getDimension(d.e.tbds44);
        this.gkS = (int) resources.getDimension(d.e.tbds44);
        this.gkW = (int) resources.getDimension(d.e.ds12);
        this.gkX = (int) resources.getDimension(d.e.ds1);
        this.gkY = (int) resources.getDimension(d.e.ds18);
    }

    protected void l(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.glk.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aPQ() {
        MessageManager.getInstance().registerListener(this.glp);
        MessageManager.getInstance().registerListener(this.glq);
        MessageManager.getInstance().registerListener(this.glr);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.chp = this.mRootView.findViewById(d.g.bottom_line);
        this.gkZ = (TextView) this.mRootView.findViewById(d.g.ad_title);
        this.gla = (TextView) this.mRootView.findViewById(d.g.transform_btn);
        this.gle = (ApkDownloadView) this.mRootView.findViewById(d.g.advert_app_download_view);
        this.glf = (TextView) this.mRootView.findViewById(d.g.advert_app_name);
        this.glg = (RelativeLayout) this.mRootView.findViewById(d.g.bottom_transformation_area);
        this.gle.q(this.mContext.getUniqueId());
        this.glp.setTag(this.mContext.getUniqueId());
        this.glh = this.mRootView.findViewById(d.g.card_ad_middle_container);
        this.glq.setTag(this.mContext.getUniqueId());
        this.glr.setTag(this.mContext.getUniqueId());
        this.glk = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.glk.setStyle(1);
        this.gll = (ThreadUserInfoLayout) this.mRootView.findViewById(d.g.card_ad_user_info_layout);
        this.gld = (LinearLayout) LayoutInflater.from(getContext()).inflate(d.i.ad_post_tag_close, (ViewGroup) null);
        this.glc = (AdCloseView) this.gld.findViewById(d.g.ad_close_view);
        this.glb = (TextView) this.gld.findViewById(d.g.feed_tag);
        this.gll.addView(this.gld);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gld.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(d.e.ds8);
        this.gld.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        this.gld.setLayoutParams(layoutParams);
        this.gll.getHeaderImg().setDefaultErrorResource(d.f.icon_default_avatar100);
        this.gll.getHeaderImg().setDefaultResource(d.f.icon_default_avatar100);
        this.gll.getHeaderImg().setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.cyF = this.mRootView.findViewById(d.g.divider_line_above_praise);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gll.getHeaderImg().getLayoutParams();
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.ah(getContext()) - this.gkR) - this.gkS) - this.gkO) - this.gkQ;
            this.glk.setVisibility(8);
        } else {
            this.mMaxWidth = (l.ah(getContext()) - this.gkR) - this.gkS;
            this.glk.setVisibility(0);
        }
        this.gkM = (ViewStub) this.mRootView.findViewById(d.g.ad_custom_view_stub);
        this.gkM.setLayoutResource(getCustomLayout());
        this.gkN = this.gkM.inflate();
        this.glm = this.mRootView.findViewById(d.g.pb_bottom_view);
        this.gln = this.mRootView.findViewById(d.g.frs_bottom_view);
        bu(this.gkN);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(final AdCard adCard) {
        final String str;
        this.glj = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.gll.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.BK() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.aN(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.gle.setOnClickListener(bVar);
        this.gla.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.glh.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.gkO + this.gkQ;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.gll.getHeaderImg(), adCard.portraitClick, bVar);
        if (!TextUtils.isEmpty(adCard.tagName)) {
            this.glb.setText(adCard.tagName);
        } else {
            this.glb.setText("广告");
        }
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String sP = sP(ao.d(str2, 100, "..."));
            if (4 == getBusinessType()) {
                this.gkZ.setTextSize(0, getContext().getResources().getDimension(d.e.ds32));
            } else {
                this.gkZ.setTextSize(0, getContext().getResources().getDimension(d.e.tbfontsize48));
            }
            this.gkZ.setText(sP);
            this.gkZ.setVisibility(0);
        } else {
            this.gkZ.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.tP()) && true == k.isEmpty(str3);
        a(this.glg, this.gla, this.gle, adCard);
        if (!z && !TextUtils.isEmpty(adCard.userName)) {
            if (advertAppInfo != null && advertAppInfo.tO()) {
                this.glf.setText(adCard.userName.concat("App").toString());
            } else if (advertAppInfo != null && advertAppInfo.tP()) {
                this.glf.setText(adCard.userName);
            }
        }
        if (advertAppInfo != null && advertAppInfo.tO()) {
            this.gli = advertAppInfo.adQ;
            this.gle.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, -1));
            c2.setStatus(ApkDownloadView.getStatus(c2));
            a(this.gla, c2.getStatus(), str3);
            this.gle.setData(c2);
            this.gle.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    al.c(this.gla, d.C0141d.btn_forum_focus_color, 1);
                    this.gla.setText(str3);
                    if (k.isEmpty(str)) {
                        this.gla.setClickable(false);
                    } else {
                        this.gla.setClickable(true);
                        this.gla.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.eIN != null && adCard.buttonClick != null && !q.tH(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.eIN.b(adCard.buttonClick.Uc, adCard.buttonClick.Ud, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int e = s.e(AdCardBaseView.this.mContext, str);
                                        if ((e == 1 || e == 2) && AdCardBaseView.this.eIN != null) {
                                            AdCardBaseView.this.eIN.b(e, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.mContext.getPageActivity());
                                    aVar.dB(adCard.popWindowText);
                                    aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int e2 = s.e(AdCardBaseView.this.mContext, str);
                                            if ((e2 == 1 || e2 == 2) && AdCardBaseView.this.eIN != null) {
                                                AdCardBaseView.this.eIN.b(e2, null);
                                            }
                                            aVar2.dismiss();
                                        }
                                    });
                                    aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.2
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            aVar2.dismiss();
                                        }
                                    });
                                    aVar.b(AdCardBaseView.this.mContext).xa();
                                }
                            }
                        });
                    }
                } else {
                    this.gla.setClickable(false);
                    this.gla.setText(adCard.buttonTextDone);
                    al.i(this.gla, d.f.btn_rounded_corner_gray_frame);
                    al.c(this.gla, d.C0141d.cp_cont_d, 1);
                }
            }
            this.gle.setVisibility(8);
        }
        a(adCard);
        l(i.tt().tz(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            sQ(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.adX != null && advertAppInfo.adX.aet != null && advertAppInfo.adX.aet.support_close.intValue() > 0) {
            this.glc.setVisibility(0);
            this.glc.setPage(getBusinessType());
            this.glc.setData(advertAppInfo);
            l.a(this.mContext.getPageActivity(), this.gld, 40, 40, 40, 120);
            this.gld.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.glc.performClick();
                }
            });
        } else {
            this.glc.setVisibility(8);
            this.glb.setOnClickListener(null);
        }
        this.glk.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.chp.getLayoutParams();
        if (4 == getBusinessType()) {
            this.glk.setVisibility(8);
            this.glk.setBarNameClickEnabled(false);
            this.glk.setShareVisible(false);
            this.glk.setShowPraiseNum(false);
            this.glk.setCommentNumEnable(false);
            this.glk.setReplyTimeVisible(false);
            layoutParams2.height = this.gkX;
            this.glm.setVisibility(0);
            this.gln.setVisibility(8);
        } else {
            a(adCard, bVar);
        }
        a(adCard, this.cyF, getBusinessType());
        this.gll.setData(adCard.getAdvertAppInfo());
        this.gll.getHeaderImg().setVisibility(0);
        this.gll.getHeaderImg().startLoad(adCard.userPortrait, 10, false);
        this.gll.getUserName().setOnClickListener(bVar);
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.gln.setVisibility(0);
            this.glk.setVisibility(8);
            return;
        }
        this.gln.setVisibility(8);
        this.glk.setVisibility(0);
        this.glk.setBarNameClickEnabled(false);
        this.glk.setReplyTimeVisible(false);
        this.glk.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.glk.setAgreeClickable(true);
            this.glk.setPraiseContainerBgGray(false);
        } else {
            this.glk.setAgreeClickable(false);
            this.glk.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.glk.setShareClickable(true);
            this.glk.setShareContainerBgGray(false);
        } else {
            this.glk.setShareClickable(false);
            this.glk.setShareContainerBgGray(true);
        }
        this.glk.getCommentContainer().setOnClickListener(bVar);
        this.glk.setNeedAddReplyIcon(true);
        this.glk.setCommentNumEnable(true);
        this.glk.setCommentClickable(true);
        this.glk.setReplayContainerBgGray(true);
        this.glk.setOnClickListener(bVar);
        this.glk.setShareData(adCard);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        al.i(this.chp, d.C0141d.cp_bg_line_c);
        this.glc.onChangeSkinType();
        this.gll.onChangeSkinType();
        this.glk.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            al.i(this.mRootView, d.f.addresslist_item_bg);
            al.j(this.chp, d.C0141d.cp_bg_line_e);
            al.j(this.cyF, d.C0141d.cp_bg_line_e);
        } else {
            al.j(this.chp, d.C0141d.cp_bg_line_c);
            al.j(this.cyF, d.C0141d.transparent);
        }
        al.c(this.gkZ, d.C0141d.cp_cont_b, 1);
        al.j(this.glg, d.C0141d.cp_bg_line_e);
        al.h(this.glf, d.C0141d.cp_cont_j);
        al.c(this.glb, d.C0141d.cp_cont_d, 1);
        this.gle.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String sP(String str) {
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
            if (b(bVar) && !q.tH(bVar.scheme)) {
                if (this.eIN != null) {
                    this.eIN.b(bVar.Uc, bVar.Ud, null);
                    return;
                }
                return;
            }
            int e = s.e(this.mContext, sR(bVar.scheme));
            if (e == 1 || e == 2) {
                if (this.eIN != null) {
                    this.eIN.b(e, null);
                }
            } else if (this.eIN != null) {
                this.eIN.b(bVar.Uc, bVar.Ud, null);
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
                        if (AdCardBaseView.this.glj.hasAnimation()) {
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
        this.eHk = new a.C0189a();
        this.eHk.picUrl = tbImageView.getUrl();
        this.eHk.rect = rect;
    }

    private void sQ(String str) {
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
                    com.baidu.adp.lib.f.c.ig().a(jSONObject.optString("pic_url"), 17, null, this.eIU, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.eIU), this.mContext.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.tN() != 0) {
                l.showToast(this.mContext.getPageActivity(), d.k.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.zU();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.u(this.mContext.getPageActivity()) && this.eIO != null) {
                this.eIO.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.s(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.jr()) {
                l.showToast(this.mContext.getPageActivity(), d.k.neterror);
            } else if (advertAppInfo.tO()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(d.k.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.dB(str);
                aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.gle);
                        if (AdCardBaseView.this.gle != null) {
                            AdCardBaseView.this.gle.s(AdCardBaseView.this.c(advertAppInfo, i));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).xa();
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
                        apkDownloadView.t(c2);
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
                    a(advertAppInfo, i, this.gle);
                    apkDownloadView.h(c2);
                    return;
            }
            g.al(this.mContext.getPageActivity(), advertAppInfo.adQ);
        }
    }

    public a.C0189a getAnimationInfo() {
        return this.eHk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private AdCard glA;

        public b(AdCard adCard) {
            this.glA = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jr()) {
                AdCardBaseView.this.mContext.showToast(d.k.neterror);
            } else if (this.glA != null) {
                AdvertAppInfo advertAppInfo = this.glA.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.gle;
                if (advertAppInfo != null && advertAppInfo.tO()) {
                    int g = com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, g));
                    if ((6 == status || 7 == status) && j.jD() && !j.jE()) {
                        AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, g, true, this.glA.popWindowText);
                        return;
                    }
                    AdCardBaseView.this.a(advertAppInfo, g, AdCardBaseView.this.gle, z);
                    if (AdCardBaseView.this.eIN != null) {
                        AdCardBaseView.this.eIN.b(3, null);
                        return;
                    }
                    return;
                }
                String scheme = this.glA.getScheme();
                if (k.isEmpty(scheme) && advertAppInfo != null) {
                    scheme = advertAppInfo.adO;
                }
                if (this.glA.hasAnimation()) {
                }
                int e = s.e(AdCardBaseView.this.mContext, AdCardBaseView.this.sR(scheme));
                if (AdCardBaseView.this.eIN != null) {
                    AdCardBaseView.this.eIN.b(e, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String sR(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.eHk != null && this.eHk.isValid()) {
            String c0189a = this.eHk.toString();
            if (!TextUtils.isEmpty(c0189a)) {
                sb.append("&");
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append("=");
                sb.append(URLEncoder.encode(c0189a));
            }
        }
        if (!TextUtils.isEmpty(this.glj.getPreLoadData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append("=");
            sb.append(URLEncoder.encode(this.glj.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.glj.getNextPageData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append("=");
            sb.append(URLEncoder.encode(this.glj.getNextPageData()));
        }
        if (this.glj.hasAnimation()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append("=");
            sb.append("1");
        }
        if (this.glj.isGoLandingPage()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append("=");
            sb.append("1");
        }
        if (this.glj.isImmersiveStyle()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append("=");
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> glz;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.glz = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.glz.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.gli) ? false : true)) && adCardBaseView.gli.equals(downloadData.getId())) {
                    int status = com.baidu.tieba.recapp.download.d.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.gla.setText(d.k.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.gla.setText(d.k.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> glz;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.glz = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.glz.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.gli) && adCardBaseView.gli.equals(downloadData.getId())) {
                adCardBaseView.gle.u(downloadData);
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> glz;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.glz = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.glz.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                s.e(adCardBaseView.mContext, adCardBaseView.glo.scheme);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aPZ() {
        if (4 == getBusinessType()) {
            this.gkZ.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.gku != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.glo = bVar;
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
        if (adCard.getAdvertAppInfo().tO()) {
            textView.setVisibility(8);
            apkDownloadView.setVisibility(0);
            return;
        }
        if (true == k.isEmpty(adCard.buttonText) || "立即查看".equals(adCard.buttonText)) {
            textView.setVisibility(8);
            view.setVisibility(8);
        } else {
            textView.setVisibility(0);
            al.i(textView, d.f.btn_focus_border_bg);
        }
        apkDownloadView.setVisibility(8);
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.adQ);
        downloadData.setUrl(advertAppInfo.adP);
        downloadData.setName(advertAppInfo.adM);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.g(advertAppInfo.adL, 0));
        return downloadData;
    }

    protected void a(TextView textView, int i, String str) {
        switch (i) {
            case 1:
            case 5:
                textView.setText(d.k.pause_load);
                return;
            case 2:
            case 4:
            default:
                return;
            case 3:
                textView.setText(d.k.downloaded_install);
                return;
            case 6:
                textView.setText(d.k.install_app);
                return;
            case 7:
                textView.setText(d.k.pb_download_pause);
                return;
        }
    }
}
