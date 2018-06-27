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
    protected View cjz;
    protected View cwz;
    private a.C0191a eLb;
    private final int eML;
    protected ViewStub goC;
    protected View goD;
    protected View goE;
    protected final int goF;
    protected final int goG;
    protected final int goH;
    protected final int goI;
    protected final int goJ;
    protected final int goK;
    protected final int goL;
    protected final int goM;
    private int goN;
    private int goO;
    private int goP;
    protected TextView goQ;
    protected TextView goR;
    protected TextView goS;
    private AdCloseView goT;
    private LinearLayout goU;
    protected ApkDownloadView goV;
    protected TextView goW;
    protected RelativeLayout goX;
    protected View goY;
    protected String goZ;
    private AdCard gpa;
    private AdThreadCommentAndPraiseInfoLayout gpb;
    protected ThreadUserInfoLayout gpc;
    protected View gpd;
    protected View gpe;
    protected AdCard.b gpf;
    protected CustomMessageListener gpg;
    protected CustomMessageListener gph;
    protected CustomMessageListener gpi;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void bv(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eML = l.ah(getContext());
        this.gpg = new a(2016484, this);
        this.gph = new d(2016483, this);
        this.gpi = new c(2016494, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(d.e.ds640);
        this.mImageHeight = (int) resources.getDimension(d.e.ds278);
        this.goF = (int) resources.getDimension(d.e.tbds92);
        this.goG = (int) resources.getDimension(d.e.tbds92);
        this.goH = (int) resources.getDimension(d.e.tbds20);
        this.goK = (int) resources.getDimension(d.e.tbds90);
        this.goL = (int) resources.getDimension(d.e.tbds90);
        this.goM = (int) resources.getDimension(d.e.tbds22);
        this.goI = (int) resources.getDimension(d.e.tbds44);
        this.goJ = (int) resources.getDimension(d.e.tbds44);
        this.goN = (int) resources.getDimension(d.e.ds12);
        this.goO = (int) resources.getDimension(d.e.ds1);
        this.goP = (int) resources.getDimension(d.e.ds18);
    }

    protected void l(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.gpb.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aQw() {
        MessageManager.getInstance().registerListener(this.gpg);
        MessageManager.getInstance().registerListener(this.gph);
        MessageManager.getInstance().registerListener(this.gpi);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.cjz = this.mRootView.findViewById(d.g.bottom_line);
        this.goE = this.mRootView.findViewById(d.g.thread_multi_del_ad_mask_view);
        this.goE.setClickable(true);
        this.goQ = (TextView) this.mRootView.findViewById(d.g.ad_title);
        this.goR = (TextView) this.mRootView.findViewById(d.g.transform_btn);
        this.goV = (ApkDownloadView) this.mRootView.findViewById(d.g.advert_app_download_view);
        this.goW = (TextView) this.mRootView.findViewById(d.g.advert_app_name);
        this.goX = (RelativeLayout) this.mRootView.findViewById(d.g.bottom_transformation_area);
        this.goV.q(this.mContext.getUniqueId());
        this.gpg.setTag(this.mContext.getUniqueId());
        this.goY = this.mRootView.findViewById(d.g.card_ad_middle_container);
        this.gph.setTag(this.mContext.getUniqueId());
        this.gpi.setTag(this.mContext.getUniqueId());
        this.gpb = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.gpb.setStyle(1);
        this.gpc = (ThreadUserInfoLayout) this.mRootView.findViewById(d.g.card_ad_user_info_layout);
        this.goU = (LinearLayout) LayoutInflater.from(getContext()).inflate(d.i.ad_post_tag_close, (ViewGroup) null);
        this.goT = (AdCloseView) this.goU.findViewById(d.g.ad_close_view);
        this.goS = (TextView) this.goU.findViewById(d.g.feed_tag);
        this.gpc.addView(this.goU);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.goU.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(d.e.ds8);
        this.goU.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        this.goU.setLayoutParams(layoutParams);
        this.gpc.getHeaderImg().setDefaultErrorResource(d.f.icon_default_avatar100);
        this.gpc.getHeaderImg().setDefaultResource(d.f.icon_default_avatar100);
        this.gpc.getHeaderImg().setDefaultBgResource(d.C0142d.cp_bg_line_e);
        this.cwz = this.mRootView.findViewById(d.g.divider_line_above_praise);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gpc.getHeaderImg().getLayoutParams();
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.ah(getContext()) - this.goI) - this.goJ) - this.goF) - this.goH;
            this.gpb.setVisibility(8);
        } else {
            this.mMaxWidth = (l.ah(getContext()) - this.goI) - this.goJ;
            this.gpb.setVisibility(0);
        }
        this.goC = (ViewStub) this.mRootView.findViewById(d.g.ad_custom_view_stub);
        this.goC.setLayoutResource(getCustomLayout());
        this.goD = this.goC.inflate();
        this.gpd = this.mRootView.findViewById(d.g.pb_bottom_view);
        this.gpe = this.mRootView.findViewById(d.g.frs_bottom_view);
        bv(this.goD);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(final AdCard adCard) {
        final String str;
        this.gpa = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.gpc.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.Cb() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.aP(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.goV.setOnClickListener(bVar);
        this.goR.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.goY.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.goF + this.goH;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.gpc.getHeaderImg(), adCard.portraitClick, bVar);
        if (!TextUtils.isEmpty(adCard.tagName)) {
            this.goS.setText(adCard.tagName);
        } else {
            this.goS.setText("广告");
        }
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String sO = sO(ap.d(str2, 100, "..."));
            if (4 == getBusinessType()) {
                this.goQ.setTextSize(0, getContext().getResources().getDimension(d.e.ds32));
            } else {
                this.goQ.setTextSize(0, getContext().getResources().getDimension(d.e.tbfontsize48));
            }
            this.goQ.setText(sO);
            this.goQ.setVisibility(0);
        } else {
            this.goQ.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.tV()) && true == k.isEmpty(str3);
        a(this.goX, this.goR, this.goV, adCard);
        if (!z && !TextUtils.isEmpty(adCard.userName)) {
            if (advertAppInfo != null && advertAppInfo.tU()) {
                this.goW.setText(adCard.userName.concat("App").toString());
            } else if (advertAppInfo != null && advertAppInfo.tV()) {
                this.goW.setText(adCard.userName);
            }
        }
        if (advertAppInfo != null && advertAppInfo.tU()) {
            this.goZ = advertAppInfo.aef;
            this.goV.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, -1));
            c2.setStatus(ApkDownloadView.getStatus(c2));
            a(this.goR, c2.getStatus(), str3);
            this.goV.setData(c2);
            this.goV.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    am.c(this.goR, d.C0142d.btn_forum_focus_color, 1);
                    this.goR.setText(str3);
                    if (k.isEmpty(str)) {
                        this.goR.setClickable(false);
                    } else {
                        this.goR.setClickable(true);
                        this.goR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.eME != null && adCard.buttonClick != null && !q.tG(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.eME.b(adCard.buttonClick.Ue, adCard.buttonClick.Uf, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int e = s.e(AdCardBaseView.this.mContext, str);
                                        if ((e == 1 || e == 2) && AdCardBaseView.this.eME != null) {
                                            AdCardBaseView.this.eME.b(e, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.mContext.getPageActivity());
                                    aVar.dE(adCard.popWindowText);
                                    aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int e2 = s.e(AdCardBaseView.this.mContext, str);
                                            if ((e2 == 1 || e2 == 2) && AdCardBaseView.this.eME != null) {
                                                AdCardBaseView.this.eME.b(e2, null);
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
                                    aVar.b(AdCardBaseView.this.mContext).xn();
                                }
                            }
                        });
                    }
                } else {
                    this.goR.setClickable(false);
                    this.goR.setText(adCard.buttonTextDone);
                    am.i(this.goR, d.f.btn_rounded_corner_gray_frame);
                    am.c(this.goR, d.C0142d.cp_cont_d, 1);
                }
            }
            this.goV.setVisibility(8);
        }
        a(adCard);
        l(i.tt().tz(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            sP(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.aem != null && advertAppInfo.aem.aeI != null && advertAppInfo.aem.aeI.support_close.intValue() > 0) {
            this.goT.setVisibility(0);
            this.goT.setPage(getBusinessType());
            this.goT.setData(advertAppInfo);
            l.a(this.mContext.getPageActivity(), this.goU, 40, 40, 40, 120);
            this.goU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.goT.performClick();
                }
            });
        } else {
            this.goT.setVisibility(8);
            this.goS.setOnClickListener(null);
        }
        this.gpb.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.cjz.getLayoutParams();
        if (4 == getBusinessType()) {
            this.gpb.setVisibility(8);
            this.gpb.setBarNameClickEnabled(false);
            this.gpb.setShareVisible(false);
            this.gpb.setShowPraiseNum(false);
            this.gpb.setCommentNumEnable(false);
            this.gpb.setReplyTimeVisible(false);
            layoutParams2.height = this.goO;
            this.gpd.setVisibility(0);
            this.gpe.setVisibility(8);
        } else {
            a(adCard, bVar);
        }
        a(adCard, this.cwz, getBusinessType());
        this.gpc.setData(adCard.getAdvertAppInfo());
        this.gpc.getHeaderImg().setVisibility(0);
        this.gpc.getHeaderImg().startLoad(adCard.userPortrait, 10, false);
        this.gpc.getUserName().setOnClickListener(bVar);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.asZ().ata()) {
            this.goE.setVisibility(0);
            am.j(this.goE, d.C0142d.cp_bg_line_d);
        } else {
            this.goE.setVisibility(8);
        }
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean isInFrsAllThread() {
        return this.eLF == 1;
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.gpe.setVisibility(0);
            this.gpb.setVisibility(8);
            return;
        }
        this.gpe.setVisibility(8);
        this.gpb.setVisibility(0);
        this.gpb.setBarNameClickEnabled(false);
        this.gpb.setReplyTimeVisible(false);
        this.gpb.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.gpb.setAgreeClickable(true);
            this.gpb.setPraiseContainerBgGray(false);
        } else {
            this.gpb.setAgreeClickable(false);
            this.gpb.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.gpb.setShareClickable(true);
            this.gpb.setShareContainerBgGray(false);
        } else {
            this.gpb.setShareClickable(false);
            this.gpb.setShareContainerBgGray(true);
        }
        this.gpb.getCommentContainer().setOnClickListener(bVar);
        this.gpb.setNeedAddReplyIcon(true);
        this.gpb.setCommentNumEnable(true);
        this.gpb.setCommentClickable(true);
        this.gpb.setReplayContainerBgGray(true);
        this.gpb.setOnClickListener(bVar);
        this.gpb.setShareData(adCard);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        am.i(this.cjz, d.C0142d.cp_bg_line_c);
        this.goT.onChangeSkinType();
        this.gpc.onChangeSkinType();
        this.gpb.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            am.i(this.mRootView, d.f.addresslist_item_bg);
            am.j(this.cjz, d.C0142d.cp_bg_line_e);
            am.j(this.cwz, d.C0142d.cp_bg_line_e);
        } else {
            am.j(this.cjz, d.C0142d.cp_bg_line_c);
            am.j(this.cwz, d.C0142d.transparent);
        }
        am.c(this.goQ, d.C0142d.cp_cont_b, 1);
        am.j(this.goX, d.C0142d.cp_bg_line_e);
        am.h(this.goW, d.C0142d.cp_cont_j);
        am.c(this.goS, d.C0142d.cp_cont_d, 1);
        this.goV.onChangeSkinType(i);
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
            if (b(bVar) && !q.tG(bVar.scheme)) {
                if (this.eME != null) {
                    this.eME.b(bVar.Ue, bVar.Uf, null);
                    return;
                }
                return;
            }
            int e = s.e(this.mContext, sQ(bVar.scheme));
            if (e == 1 || e == 2) {
                if (this.eME != null) {
                    this.eME.b(e, null);
                }
            } else if (this.eME != null) {
                this.eME.b(bVar.Ue, bVar.Uf, null);
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
                        if (AdCardBaseView.this.gpa.hasAnimation()) {
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
        this.eLb = new a.C0191a();
        this.eLb.picUrl = tbImageView.getUrl();
        this.eLb.rect = rect;
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
                    com.baidu.adp.lib.f.c.ig().a(jSONObject.optString("pic_url"), 17, null, this.eML, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.eML), this.mContext.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.tT() != 0) {
                l.showToast(this.mContext.getPageActivity(), d.k.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.Aj();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.u(this.mContext.getPageActivity()) && this.eMF != null) {
                this.eMF.b(advertAppInfo, i);
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
            } else if (advertAppInfo.tU()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(d.k.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.dE(str);
                aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.goV);
                        if (AdCardBaseView.this.goV != null) {
                            AdCardBaseView.this.goV.s(AdCardBaseView.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).xn();
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
                    a(advertAppInfo, i, this.goV);
                    apkDownloadView.h(c2);
                    return;
            }
            g.al(this.mContext.getPageActivity(), advertAppInfo.aef);
        }
    }

    public a.C0191a getAnimationInfo() {
        return this.eLb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private AdCard gpr;

        public b(AdCard adCard) {
            this.gpr = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jr()) {
                AdCardBaseView.this.mContext.showToast(d.k.neterror);
            } else if (this.gpr != null) {
                AdvertAppInfo advertAppInfo = this.gpr.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.goV;
                if (advertAppInfo != null && advertAppInfo.tU()) {
                    int g = com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, g));
                    if ((6 == status || 7 == status) && j.jD() && !j.jE()) {
                        AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, g, true, this.gpr.popWindowText);
                        return;
                    }
                    AdCardBaseView.this.a(advertAppInfo, g, AdCardBaseView.this.goV, z);
                    if (AdCardBaseView.this.eME != null) {
                        AdCardBaseView.this.eME.b(3, null);
                        return;
                    }
                    return;
                }
                String scheme = this.gpr.getScheme();
                if (k.isEmpty(scheme) && advertAppInfo != null) {
                    scheme = advertAppInfo.aed;
                }
                if (this.gpr.hasAnimation()) {
                }
                int e = s.e(AdCardBaseView.this.mContext, AdCardBaseView.this.sQ(scheme));
                if (AdCardBaseView.this.eME != null) {
                    AdCardBaseView.this.eME.b(e, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String sQ(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.eLb != null && this.eLb.isValid()) {
            String c0191a = this.eLb.toString();
            if (!TextUtils.isEmpty(c0191a)) {
                sb.append("&");
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append("=");
                sb.append(URLEncoder.encode(c0191a));
            }
        }
        if (!TextUtils.isEmpty(this.gpa.getPreLoadData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append("=");
            sb.append(URLEncoder.encode(this.gpa.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.gpa.getNextPageData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append("=");
            sb.append(URLEncoder.encode(this.gpa.getNextPageData()));
        }
        if (this.gpa.hasAnimation()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append("=");
            sb.append("1");
        }
        if (this.gpa.isGoLandingPage()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append("=");
            sb.append("1");
        }
        if (this.gpa.isImmersiveStyle()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append("=");
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> gpq;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.gpq = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.gpq.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.goZ) ? false : true)) && adCardBaseView.goZ.equals(downloadData.getId())) {
                    int status = com.baidu.tieba.recapp.download.d.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.goR.setText(d.k.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.goR.setText(d.k.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> gpq;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.gpq = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.gpq.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.goZ) && adCardBaseView.goZ.equals(downloadData.getId())) {
                adCardBaseView.goV.u(downloadData);
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> gpq;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.gpq = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.gpq.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                s.e(adCardBaseView.mContext, adCardBaseView.gpf.scheme);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aQF() {
        if (4 == getBusinessType()) {
            this.goQ.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.gol != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.gpf = bVar;
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
        if (adCard.getAdvertAppInfo().tU()) {
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
        DownloadData downloadData = new DownloadData(advertAppInfo.aef);
        downloadData.setUrl(advertAppInfo.aee);
        downloadData.setName(advertAppInfo.aeb);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.g(advertAppInfo.aea, 0));
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
