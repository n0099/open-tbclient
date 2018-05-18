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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.coreExtra.data.c;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.b.a;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.download.d;
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
    protected View bZm;
    protected View cqc;
    private a.C0173a evT;
    private final int exz;
    protected final int fZA;
    protected final int fZB;
    protected final int fZC;
    protected final int fZD;
    private int fZE;
    private int fZF;
    private int fZG;
    protected TextView fZH;
    protected TextView fZI;
    protected TextView fZJ;
    private AdCloseView fZK;
    private LinearLayout fZL;
    protected ApkDownloadView fZM;
    protected TextView fZN;
    protected RelativeLayout fZO;
    protected View fZP;
    protected String fZQ;
    private AdCard fZR;
    private AdThreadCommentAndPraiseInfoLayout fZS;
    protected ThreadUserInfoLayout fZT;
    protected View fZU;
    protected View fZV;
    protected AdCard.b fZW;
    protected CustomMessageListener fZX;
    protected CustomMessageListener fZY;
    protected CustomMessageListener fZZ;
    protected ViewStub fZu;
    protected View fZv;
    protected final int fZw;
    protected final int fZx;
    protected final int fZy;
    protected final int fZz;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void br(View view2);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.exz = l.af(getContext());
        this.fZX = new CustomMessageListener(2016484) { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                    if (((downloadData != null) & (TextUtils.isEmpty(AdCardBaseView.this.fZQ) ? false : true)) && AdCardBaseView.this.fZQ.equals(downloadData.getId())) {
                        int status = d.getStatus(downloadData);
                        if (status == 7) {
                            AdCardBaseView.this.fZI.setText(d.k.pause_load);
                        } else if (status == 1 || status == 2) {
                            AdCardBaseView.this.fZI.setText(d.k.pb_download_pause);
                        }
                    }
                }
            }
        };
        this.fZY = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdCardBaseView.this.fZQ) && AdCardBaseView.this.fZQ.equals(downloadData.getId())) {
                    AdCardBaseView.this.fZM.u(downloadData);
                }
            }
        };
        this.fZZ = new b(2016494, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(d.e.ds640);
        this.mImageHeight = (int) resources.getDimension(d.e.ds278);
        this.fZw = (int) resources.getDimension(d.e.tbds92);
        this.fZx = (int) resources.getDimension(d.e.tbds92);
        this.fZy = (int) resources.getDimension(d.e.tbds20);
        this.fZB = (int) resources.getDimension(d.e.tbds90);
        this.fZC = (int) resources.getDimension(d.e.tbds90);
        this.fZD = (int) resources.getDimension(d.e.tbds22);
        this.fZz = (int) resources.getDimension(d.e.tbds44);
        this.fZA = (int) resources.getDimension(d.e.tbds44);
        this.fZE = (int) resources.getDimension(d.e.ds12);
        this.fZF = (int) resources.getDimension(d.e.ds1);
        this.fZG = (int) resources.getDimension(d.e.ds18);
    }

    protected void l(boolean z, int i) {
    }

    private void a(AdCard adCard, View view2, int i) {
        if (adCard != null) {
            if (4 == i) {
                view2.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.fZS.getVisibility() == 0) {
                view2.setVisibility(8);
            } else {
                view2.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aKT() {
        MessageManager.getInstance().registerListener(this.fZX);
        MessageManager.getInstance().registerListener(this.fZY);
        MessageManager.getInstance().registerListener(this.fZZ);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.bZm = this.mRootView.findViewById(d.g.bottom_line);
        this.fZH = (TextView) this.mRootView.findViewById(d.g.ad_title);
        this.fZI = (TextView) this.mRootView.findViewById(d.g.transform_btn);
        this.fZM = (ApkDownloadView) this.mRootView.findViewById(d.g.advert_app_download_view);
        this.fZN = (TextView) this.mRootView.findViewById(d.g.advert_app_name);
        this.fZO = (RelativeLayout) this.mRootView.findViewById(d.g.bottom_transformation_area);
        this.fZM.p(this.mContext.getUniqueId());
        this.fZX.setTag(this.mContext.getUniqueId());
        this.fZP = this.mRootView.findViewById(d.g.card_ad_middle_container);
        this.fZY.setTag(this.mContext.getUniqueId());
        this.fZZ.setTag(this.mContext.getUniqueId());
        this.fZS = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.fZS.setStyle(1);
        this.fZT = (ThreadUserInfoLayout) this.mRootView.findViewById(d.g.card_ad_user_info_layout);
        this.fZL = (LinearLayout) LayoutInflater.from(getContext()).inflate(d.i.ad_post_tag_close, (ViewGroup) null);
        this.fZK = (AdCloseView) this.fZL.findViewById(d.g.ad_close_view);
        this.fZJ = (TextView) this.fZL.findViewById(d.g.feed_tag);
        this.fZT.addView(this.fZL);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fZL.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(d.e.ds8);
        this.fZL.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        this.fZL.setLayoutParams(layoutParams);
        this.fZT.getHeaderImg().setDefaultErrorResource(d.f.icon_default_avatar100);
        this.fZT.getHeaderImg().setDefaultResource(d.f.icon_default_avatar100);
        this.fZT.getHeaderImg().setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.cqc = this.mRootView.findViewById(d.g.divider_line_above_praise);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fZT.getHeaderImg().getLayoutParams();
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.af(getContext()) - this.fZz) - this.fZA) - this.fZw) - this.fZy;
            this.fZS.setVisibility(8);
        } else {
            this.mMaxWidth = (l.af(getContext()) - this.fZz) - this.fZA;
            this.fZS.setVisibility(0);
        }
        this.fZu = (ViewStub) this.mRootView.findViewById(d.g.ad_custom_view_stub);
        this.fZu.setLayoutResource(getCustomLayout());
        this.fZv = this.fZu.inflate();
        this.fZU = this.mRootView.findViewById(d.g.pb_bottom_view);
        this.fZV = this.mRootView.findViewById(d.g.frs_bottom_view);
        br(this.fZv);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(final AdCard adCard) {
        final String str;
        this.fZR = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        a aVar = new a(adCard);
        this.mRootView.setOnClickListener(aVar);
        this.fZT.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.yk() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.aB(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.fZM.setOnClickListener(aVar);
        this.fZI.setOnClickListener(aVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fZP.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.fZw + this.fZy;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.fZT.getHeaderImg(), adCard.portraitClick, aVar);
        if (!TextUtils.isEmpty(adCard.tagName)) {
            this.fZJ.setText(adCard.tagName);
        } else {
            this.fZJ.setText("广告");
        }
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String rX = rX(an.d(str2, 100, "..."));
            if (4 == getBusinessType()) {
                this.fZH.setTextSize(0, getContext().getResources().getDimension(d.e.ds32));
            } else {
                this.fZH.setTextSize(0, getContext().getResources().getDimension(d.e.tbfontsize48));
            }
            this.fZH.setText(rX);
            this.fZH.setVisibility(0);
        } else {
            this.fZH.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar = adCard.buttonClick;
        if (bVar == null) {
            str = "";
        } else {
            str = bVar.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.qt()) && true == k.isEmpty(str3);
        a(this.fZO, this.fZI, this.fZM, adCard);
        if (!z && !TextUtils.isEmpty(adCard.userName)) {
            if (advertAppInfo != null && advertAppInfo.qs()) {
                this.fZN.setText(adCard.userName.concat("App").toString());
            } else if (advertAppInfo != null && advertAppInfo.qt()) {
                this.fZN.setText(adCard.userName);
            }
        }
        if (advertAppInfo != null && advertAppInfo.qs()) {
            this.fZQ = advertAppInfo.VQ;
            this.fZM.setClickable(true);
            DownloadData c = c(advertAppInfo, com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            a(this.fZI, c.getStatus(), str3);
            this.fZM.setData(c);
            this.fZM.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    ak.c(this.fZI, d.C0126d.btn_forum_focus_color, 1);
                    this.fZI.setText(str3);
                    if (k.isEmpty(str)) {
                        this.fZI.setClickable(false);
                    } else {
                        this.fZI.setClickable(true);
                        this.fZI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (AdCardBaseView.this.exr != null && adCard.buttonClick != null && !q.sQ(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.exr.b(adCard.buttonClick.LS, adCard.buttonClick.LT, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int e = s.e(AdCardBaseView.this.mContext, str);
                                        if ((e == 1 || e == 2) && AdCardBaseView.this.exr != null) {
                                            AdCardBaseView.this.exr.b(e, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.mContext.getPageActivity());
                                    aVar2.dc(adCard.popWindowText);
                                    aVar2.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                                            int e2 = s.e(AdCardBaseView.this.mContext, str);
                                            if ((e2 == 1 || e2 == 2) && AdCardBaseView.this.exr != null) {
                                                AdCardBaseView.this.exr.b(e2, null);
                                            }
                                            aVar3.dismiss();
                                        }
                                    });
                                    aVar2.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.2
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                                            aVar3.dismiss();
                                        }
                                    });
                                    aVar2.b(AdCardBaseView.this.mContext).tC();
                                }
                            }
                        });
                    }
                } else {
                    this.fZI.setClickable(false);
                    this.fZI.setText(adCard.buttonTextDone);
                    ak.i(this.fZI, d.f.btn_rounded_corner_gray_frame);
                    ak.c(this.fZI, d.C0126d.cp_cont_d, 1);
                }
            }
            this.fZM.setVisibility(8);
        }
        a(adCard);
        l(i.pX().qd(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            rY(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.VX != null && advertAppInfo.VX.Ws != null && advertAppInfo.VX.Ws.support_close.intValue() > 0) {
            this.fZK.setVisibility(0);
            this.fZK.setPage(getBusinessType());
            this.fZK.setData(advertAppInfo);
            l.a(this.mContext.getPageActivity(), this.fZL, 40, 40, 40, 120);
            this.fZL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AdCardBaseView.this.fZK.performClick();
                }
            });
        } else {
            this.fZK.setVisibility(8);
            this.fZJ.setOnClickListener(null);
        }
        this.fZS.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.bZm.getLayoutParams();
        if (4 == getBusinessType()) {
            this.fZS.setVisibility(8);
            this.fZS.setBarNameClickEnabled(false);
            this.fZS.setShareVisible(false);
            this.fZS.setShowPraiseNum(false);
            this.fZS.setCommentNumEnable(false);
            this.fZS.setReplyTimeVisible(false);
            layoutParams2.height = this.fZF;
            this.fZU.setVisibility(0);
            this.fZV.setVisibility(8);
        } else {
            a(adCard, aVar);
        }
        a(adCard, this.cqc, getBusinessType());
        this.fZT.setData(adCard.getAdvertAppInfo());
        this.fZT.getHeaderImg().setVisibility(0);
        this.fZT.getHeaderImg().startLoad(adCard.userPortrait, 10, false);
        this.fZT.getUserName().setOnClickListener(aVar);
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private void a(AdCard adCard, a aVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.fZV.setVisibility(0);
            this.fZS.setVisibility(8);
            return;
        }
        this.fZV.setVisibility(8);
        this.fZS.setVisibility(0);
        this.fZS.setBarNameClickEnabled(false);
        this.fZS.setReplyTimeVisible(false);
        this.fZS.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.fZS.setAgreeClickable(true);
            this.fZS.setPraiseContainerBgGray(false);
        } else {
            this.fZS.setAgreeClickable(false);
            this.fZS.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.fZS.setShareClickable(true);
            this.fZS.setShareContainerBgGray(false);
        } else {
            this.fZS.setShareClickable(false);
            this.fZS.setShareContainerBgGray(true);
        }
        this.fZS.getCommentContainer().setOnClickListener(aVar);
        this.fZS.setNeedAddReplyIcon(true);
        this.fZS.setCommentNumEnable(true);
        this.fZS.setCommentClickable(true);
        this.fZS.setReplayContainerBgGray(true);
        this.fZS.setOnClickListener(aVar);
        this.fZS.setShareData(adCard);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        ak.i(this.bZm, d.C0126d.cp_bg_line_c);
        this.fZK.onChangeSkinType();
        this.fZT.onChangeSkinType();
        this.fZS.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            ak.i(this.mRootView, d.f.addresslist_item_bg);
            ak.j(this.bZm, d.C0126d.cp_bg_line_e);
            ak.j(this.cqc, d.C0126d.cp_bg_line_e);
        } else {
            ak.j(this.bZm, d.C0126d.cp_bg_line_c);
            ak.j(this.cqc, d.C0126d.transparent);
        }
        ak.c(this.fZH, d.C0126d.cp_cont_b, 1);
        ak.j(this.fZO, d.C0126d.cp_bg_line_e);
        ak.h(this.fZN, d.C0126d.cp_cont_j);
        ak.c(this.fZJ, d.C0126d.cp_cont_d, 1);
        this.fZM.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String rX(String str) {
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
            if (b(bVar) && !q.sQ(bVar.scheme)) {
                if (this.exr != null) {
                    this.exr.b(bVar.LS, bVar.LT, null);
                    return;
                }
                return;
            }
            int e = s.e(this.mContext, rZ(bVar.scheme));
            if (e == 1 || e == 2) {
                if (this.exr != null) {
                    this.exr.b(e, null);
                }
            } else if (this.exr != null) {
                this.exr.b(bVar.LS, bVar.LT, null);
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
                    public void onClick(View view2) {
                        if (AdCardBaseView.this.fZR.hasAnimation()) {
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
    public void a(TbImageView tbImageView, final AdCard.b bVar, a aVar) {
        if (tbImageView != null) {
            if (bVar != null && !k.isEmpty(bVar.scheme)) {
                tbImageView.setClickable(true);
                tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        AdCardBaseView.this.a(bVar);
                    }
                });
                return;
            }
            tbImageView.setClickable(true);
            tbImageView.setOnClickListener(aVar);
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
        this.evT = new a.C0173a();
        this.evT.picUrl = tbImageView.getUrl();
        this.evT.rect = rect;
    }

    private void rY(String str) {
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
                    com.baidu.adp.lib.f.c.fp().a(jSONObject.optString("pic_url"), 17, null, this.exz, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.exz), this.mContext.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.qr() != 0) {
                l.showToast(this.mContext.getPageActivity(), d.k.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.wt();
            this.mPermissionJudgePolicy.c(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.v(this.mContext.getPageActivity()) && this.exs != null) {
                this.exs.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.s(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.gD()) {
                l.showToast(this.mContext.getPageActivity(), d.k.neterror);
            } else if (advertAppInfo.qs()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(d.k.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.dc(str);
                aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.fZM);
                        if (AdCardBaseView.this.fZM != null) {
                            AdCardBaseView.this.fZM.s(AdCardBaseView.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).tC();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void a(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView, boolean z) {
        if (advertAppInfo != null) {
            DownloadData c = c(advertAppInfo, i);
            switch (ApkDownloadView.getStatus(c)) {
                case 1:
                case 5:
                    if (z) {
                        g.e(advertAppInfo);
                        apkDownloadView.t(c);
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
                    a(advertAppInfo, i, this.fZM);
                    apkDownloadView.h(c);
                    return;
            }
            g.aj(this.mContext.getPageActivity(), advertAppInfo.VQ);
        }
    }

    public a.C0173a getAnimationInfo() {
        return this.evT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private AdCard gah;

        public a(AdCard adCard) {
            this.gah = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (!j.gD()) {
                AdCardBaseView.this.mContext.showToast(d.k.neterror);
            } else if (this.gah != null) {
                AdvertAppInfo advertAppInfo = this.gah.getAdvertAppInfo();
                boolean z = view2 == AdCardBaseView.this.fZM;
                if (advertAppInfo != null && advertAppInfo.qs()) {
                    int g = com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, g));
                    if ((6 == status || 7 == status) && j.gP() && !j.gQ()) {
                        AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, g, true, this.gah.popWindowText);
                        return;
                    }
                    AdCardBaseView.this.a(advertAppInfo, g, AdCardBaseView.this.fZM, z);
                    if (AdCardBaseView.this.exr != null) {
                        AdCardBaseView.this.exr.b(3, null);
                        return;
                    }
                    return;
                }
                String scheme = this.gah.getScheme();
                if (k.isEmpty(scheme) && advertAppInfo != null) {
                    scheme = advertAppInfo.VO;
                }
                if (this.gah.hasAnimation()) {
                }
                int e = s.e(AdCardBaseView.this.mContext, AdCardBaseView.this.rZ(scheme));
                if (AdCardBaseView.this.exr != null) {
                    AdCardBaseView.this.exr.b(e, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String rZ(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.evT != null && this.evT.isValid()) {
            String c0173a = this.evT.toString();
            if (!TextUtils.isEmpty(c0173a)) {
                sb.append("&");
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append("=");
                sb.append(URLEncoder.encode(c0173a));
            }
        }
        if (!TextUtils.isEmpty(this.fZR.getPreLoadData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append("=");
            sb.append(URLEncoder.encode(this.fZR.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.fZR.getNextPageData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append("=");
            sb.append(URLEncoder.encode(this.fZR.getNextPageData()));
        }
        if (this.fZR.hasAnimation()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append("=");
            sb.append("1");
        }
        if (this.fZR.isGoLandingPage()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append("=");
            sb.append("1");
        }
        if (this.fZR.isImmersiveStyle()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append("=");
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    private static class b extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> gai;

        public b(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.gai = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.gai.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                s.e(adCardBaseView.mContext, adCardBaseView.fZW.scheme);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aLc() {
        if (4 == getBusinessType()) {
            this.fZH.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.fZc != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.fZW = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.mContext.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.mContext, new CustomMessage<>(2002001, loginActivityConfig));
        return true;
    }

    private void a(View view2, TextView textView, ApkDownloadView apkDownloadView, AdCard adCard) {
        if (adCard == null) {
            view2.setVisibility(8);
            return;
        }
        view2.setVisibility(0);
        if (adCard.getAdvertAppInfo().qs()) {
            textView.setVisibility(8);
            apkDownloadView.setVisibility(0);
            return;
        }
        if (true == k.isEmpty(adCard.buttonText) || "立即查看".equals(adCard.buttonText)) {
            textView.setVisibility(8);
            view2.setVisibility(8);
        } else {
            textView.setVisibility(0);
            ak.i(textView, d.f.btn_focus_border_bg);
        }
        apkDownloadView.setVisibility(8);
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.VQ);
        downloadData.setUrl(advertAppInfo.VP);
        downloadData.setName(advertAppInfo.VM);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.g(advertAppInfo.VL, 0));
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
