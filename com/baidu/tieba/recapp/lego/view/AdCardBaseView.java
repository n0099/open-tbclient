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
    protected View bYq;
    protected View coV;
    private a.C0173a euO;
    private final int ewt;
    protected final int fYA;
    private int fYB;
    private int fYC;
    private int fYD;
    protected TextView fYE;
    protected TextView fYF;
    protected TextView fYG;
    private AdCloseView fYH;
    private LinearLayout fYI;
    protected ApkDownloadView fYJ;
    protected TextView fYK;
    protected RelativeLayout fYL;
    protected View fYM;
    protected String fYN;
    private AdCard fYO;
    private AdThreadCommentAndPraiseInfoLayout fYP;
    protected ThreadUserInfoLayout fYQ;
    protected View fYR;
    protected View fYS;
    protected AdCard.b fYT;
    protected CustomMessageListener fYU;
    protected CustomMessageListener fYV;
    protected CustomMessageListener fYW;
    protected ViewStub fYr;
    protected View fYs;
    protected final int fYt;
    protected final int fYu;
    protected final int fYv;
    protected final int fYw;
    protected final int fYx;
    protected final int fYy;
    protected final int fYz;
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
        this.ewt = l.af(getContext());
        this.fYU = new CustomMessageListener(2016484) { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                    if (((downloadData != null) & (TextUtils.isEmpty(AdCardBaseView.this.fYN) ? false : true)) && AdCardBaseView.this.fYN.equals(downloadData.getId())) {
                        int status = d.getStatus(downloadData);
                        if (status == 7) {
                            AdCardBaseView.this.fYF.setText(d.k.pause_load);
                        } else if (status == 1 || status == 2) {
                            AdCardBaseView.this.fYF.setText(d.k.pb_download_pause);
                        }
                    }
                }
            }
        };
        this.fYV = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdCardBaseView.this.fYN) && AdCardBaseView.this.fYN.equals(downloadData.getId())) {
                    AdCardBaseView.this.fYJ.u(downloadData);
                }
            }
        };
        this.fYW = new b(2016494, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(d.e.ds640);
        this.mImageHeight = (int) resources.getDimension(d.e.ds278);
        this.fYt = (int) resources.getDimension(d.e.tbds92);
        this.fYu = (int) resources.getDimension(d.e.tbds92);
        this.fYv = (int) resources.getDimension(d.e.tbds20);
        this.fYy = (int) resources.getDimension(d.e.tbds90);
        this.fYz = (int) resources.getDimension(d.e.tbds90);
        this.fYA = (int) resources.getDimension(d.e.tbds22);
        this.fYw = (int) resources.getDimension(d.e.tbds44);
        this.fYx = (int) resources.getDimension(d.e.tbds44);
        this.fYB = (int) resources.getDimension(d.e.ds12);
        this.fYC = (int) resources.getDimension(d.e.ds1);
        this.fYD = (int) resources.getDimension(d.e.ds18);
    }

    protected void l(boolean z, int i) {
    }

    private void a(AdCard adCard, View view2, int i) {
        if (adCard != null) {
            if (4 == i) {
                view2.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.fYP.getVisibility() == 0) {
                view2.setVisibility(8);
            } else {
                view2.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aKU() {
        MessageManager.getInstance().registerListener(this.fYU);
        MessageManager.getInstance().registerListener(this.fYV);
        MessageManager.getInstance().registerListener(this.fYW);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.bYq = this.mRootView.findViewById(d.g.bottom_line);
        this.fYE = (TextView) this.mRootView.findViewById(d.g.ad_title);
        this.fYF = (TextView) this.mRootView.findViewById(d.g.transform_btn);
        this.fYJ = (ApkDownloadView) this.mRootView.findViewById(d.g.advert_app_download_view);
        this.fYK = (TextView) this.mRootView.findViewById(d.g.advert_app_name);
        this.fYL = (RelativeLayout) this.mRootView.findViewById(d.g.bottom_transformation_area);
        this.fYJ.p(this.adf.getUniqueId());
        this.fYU.setTag(this.adf.getUniqueId());
        this.fYM = this.mRootView.findViewById(d.g.card_ad_middle_container);
        this.fYV.setTag(this.adf.getUniqueId());
        this.fYW.setTag(this.adf.getUniqueId());
        this.fYP = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.fYP.setStyle(1);
        this.fYQ = (ThreadUserInfoLayout) this.mRootView.findViewById(d.g.card_ad_user_info_layout);
        this.fYI = (LinearLayout) LayoutInflater.from(getContext()).inflate(d.i.ad_post_tag_close, (ViewGroup) null);
        this.fYH = (AdCloseView) this.fYI.findViewById(d.g.ad_close_view);
        this.fYG = (TextView) this.fYI.findViewById(d.g.feed_tag);
        this.fYQ.addView(this.fYI);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fYI.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.adf.getResources().getDimensionPixelOffset(d.e.ds8);
        this.fYI.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        this.fYI.setLayoutParams(layoutParams);
        this.fYQ.getHeaderImg().setDefaultErrorResource(d.f.icon_default_avatar100);
        this.fYQ.getHeaderImg().setDefaultResource(d.f.icon_default_avatar100);
        this.fYQ.getHeaderImg().setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.coV = this.mRootView.findViewById(d.g.divider_line_above_praise);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fYQ.getHeaderImg().getLayoutParams();
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.af(getContext()) - this.fYw) - this.fYx) - this.fYt) - this.fYv;
            this.fYP.setVisibility(8);
        } else {
            this.mMaxWidth = (l.af(getContext()) - this.fYw) - this.fYx;
            this.fYP.setVisibility(0);
        }
        this.fYr = (ViewStub) this.mRootView.findViewById(d.g.ad_custom_view_stub);
        this.fYr.setLayoutResource(getCustomLayout());
        this.fYs = this.fYr.inflate();
        this.fYR = this.mRootView.findViewById(d.g.pb_bottom_view);
        this.fYS = this.mRootView.findViewById(d.g.frs_bottom_view);
        br(this.fYs);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(final AdCard adCard) {
        final String str;
        this.fYO = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        a aVar = new a(adCard);
        this.mRootView.setOnClickListener(aVar);
        this.fYQ.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.yl() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.aB(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.adf.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.fYJ.setOnClickListener(aVar);
        this.fYF.setOnClickListener(aVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fYM.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.fYt + this.fYv;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.fYQ.getHeaderImg(), adCard.portraitClick, aVar);
        if (!TextUtils.isEmpty(adCard.tagName)) {
            this.fYG.setText(adCard.tagName);
        } else {
            this.fYG.setText("广告");
        }
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String rU = rU(an.d(str2, 100, "..."));
            if (4 == getBusinessType()) {
                this.fYE.setTextSize(0, getContext().getResources().getDimension(d.e.ds32));
            } else {
                this.fYE.setTextSize(0, getContext().getResources().getDimension(d.e.tbfontsize48));
            }
            this.fYE.setText(rU);
            this.fYE.setVisibility(0);
        } else {
            this.fYE.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar = adCard.buttonClick;
        if (bVar == null) {
            str = "";
        } else {
            str = bVar.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.qu()) && true == k.isEmpty(str3);
        a(this.fYL, this.fYF, this.fYJ, adCard);
        if (!z && !TextUtils.isEmpty(adCard.userName)) {
            if (advertAppInfo != null && advertAppInfo.qt()) {
                this.fYK.setText(adCard.userName.concat("App").toString());
            } else if (advertAppInfo != null && advertAppInfo.qu()) {
                this.fYK.setText(adCard.userName);
            }
        }
        if (advertAppInfo != null && advertAppInfo.qt()) {
            this.fYN = advertAppInfo.VU;
            this.fYJ.setClickable(true);
            DownloadData c = c(advertAppInfo, com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            a(this.fYF, c.getStatus(), str3);
            this.fYJ.setData(c);
            this.fYJ.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    ak.c(this.fYF, d.C0126d.btn_forum_focus_color, 1);
                    this.fYF.setText(str3);
                    if (k.isEmpty(str)) {
                        this.fYF.setClickable(false);
                    } else {
                        this.fYF.setClickable(true);
                        this.fYF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (AdCardBaseView.this.ewm != null && adCard.buttonClick != null && !q.sN(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.ewm.b(adCard.buttonClick.LW, adCard.buttonClick.LX, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int e = s.e(AdCardBaseView.this.adf, str);
                                        if ((e == 1 || e == 2) && AdCardBaseView.this.ewm != null) {
                                            AdCardBaseView.this.ewm.b(e, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.adf.getPageActivity());
                                    aVar2.dc(adCard.popWindowText);
                                    aVar2.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                                            int e2 = s.e(AdCardBaseView.this.adf, str);
                                            if ((e2 == 1 || e2 == 2) && AdCardBaseView.this.ewm != null) {
                                                AdCardBaseView.this.ewm.b(e2, null);
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
                                    aVar2.b(AdCardBaseView.this.adf).tD();
                                }
                            }
                        });
                    }
                } else {
                    this.fYF.setClickable(false);
                    this.fYF.setText(adCard.buttonTextDone);
                    ak.i(this.fYF, d.f.btn_rounded_corner_gray_frame);
                    ak.c(this.fYF, d.C0126d.cp_cont_d, 1);
                }
            }
            this.fYJ.setVisibility(8);
        }
        a(adCard);
        l(i.pY().qe(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            rV(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.Wb != null && advertAppInfo.Wb.Ww != null && advertAppInfo.Wb.Ww.support_close.intValue() > 0) {
            this.fYH.setVisibility(0);
            this.fYH.setPage(getBusinessType());
            this.fYH.setData(advertAppInfo);
            l.a(this.adf.getPageActivity(), this.fYI, 40, 40, 40, 120);
            this.fYI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AdCardBaseView.this.fYH.performClick();
                }
            });
        } else {
            this.fYH.setVisibility(8);
            this.fYG.setOnClickListener(null);
        }
        this.fYP.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.bYq.getLayoutParams();
        if (4 == getBusinessType()) {
            this.fYP.setVisibility(8);
            this.fYP.setBarNameClickEnabled(false);
            this.fYP.setShareVisible(false);
            this.fYP.setShowPraiseNum(false);
            this.fYP.setCommentNumEnable(false);
            this.fYP.setReplyTimeVisible(false);
            layoutParams2.height = this.fYC;
            this.fYR.setVisibility(0);
            this.fYS.setVisibility(8);
        } else {
            a(adCard, aVar);
        }
        a(adCard, this.coV, getBusinessType());
        this.fYQ.setData(adCard.getAdvertAppInfo());
        this.fYQ.getHeaderImg().setVisibility(0);
        this.fYQ.getHeaderImg().startLoad(adCard.userPortrait, 10, false);
        this.fYQ.getUserName().setOnClickListener(aVar);
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private void a(AdCard adCard, a aVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.fYS.setVisibility(0);
            this.fYP.setVisibility(8);
            return;
        }
        this.fYS.setVisibility(8);
        this.fYP.setVisibility(0);
        this.fYP.setBarNameClickEnabled(false);
        this.fYP.setReplyTimeVisible(false);
        this.fYP.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.fYP.setAgreeClickable(true);
            this.fYP.setPraiseContainerBgGray(false);
        } else {
            this.fYP.setAgreeClickable(false);
            this.fYP.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.fYP.setShareClickable(true);
            this.fYP.setShareContainerBgGray(false);
        } else {
            this.fYP.setShareClickable(false);
            this.fYP.setShareContainerBgGray(true);
        }
        this.fYP.getCommentContainer().setOnClickListener(aVar);
        this.fYP.setNeedAddReplyIcon(true);
        this.fYP.setCommentNumEnable(true);
        this.fYP.setCommentClickable(true);
        this.fYP.setReplayContainerBgGray(true);
        this.fYP.setOnClickListener(aVar);
        this.fYP.setShareData(adCard);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        ak.i(this.bYq, d.C0126d.cp_bg_line_c);
        this.fYH.onChangeSkinType();
        this.fYQ.onChangeSkinType();
        this.fYP.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            ak.i(this.mRootView, d.f.addresslist_item_bg);
            ak.j(this.bYq, d.C0126d.cp_bg_line_e);
            ak.j(this.coV, d.C0126d.cp_bg_line_e);
        } else {
            ak.j(this.bYq, d.C0126d.cp_bg_line_c);
            ak.j(this.coV, d.C0126d.transparent);
        }
        ak.c(this.fYE, d.C0126d.cp_cont_b, 1);
        ak.j(this.fYL, d.C0126d.cp_bg_line_e);
        ak.h(this.fYK, d.C0126d.cp_cont_j);
        ak.c(this.fYG, d.C0126d.cp_cont_d, 1);
        this.fYJ.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String rU(String str) {
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
            if (b(bVar) && !q.sN(bVar.scheme)) {
                if (this.ewm != null) {
                    this.ewm.b(bVar.LW, bVar.LX, null);
                    return;
                }
                return;
            }
            int e = s.e(this.adf, rW(bVar.scheme));
            if (e == 1 || e == 2) {
                if (this.ewm != null) {
                    this.ewm.b(e, null);
                }
            } else if (this.ewm != null) {
                this.ewm.b(bVar.LW, bVar.LX, null);
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
                        if (AdCardBaseView.this.fYO.hasAnimation()) {
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
        this.euO = new a.C0173a();
        this.euO.picUrl = tbImageView.getUrl();
        this.euO.rect = rect;
    }

    private void rV(String str) {
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
                    com.baidu.adp.lib.f.c.fp().a(jSONObject.optString("pic_url"), 17, null, this.ewt, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.ewt), this.adf.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.qs() != 0) {
                l.showToast(this.adf.getPageActivity(), d.k.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.wu();
            this.mPermissionJudgePolicy.c(this.adf.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.v(this.adf.getPageActivity()) && this.ewn != null) {
                this.ewn.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.s(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.gD()) {
                l.showToast(this.adf.getPageActivity(), d.k.neterror);
            } else if (advertAppInfo.qt()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.adf.getString(d.k.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.adf.getPageActivity());
                aVar.dc(str);
                aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.fYJ);
                        if (AdCardBaseView.this.fYJ != null) {
                            AdCardBaseView.this.fYJ.s(AdCardBaseView.this.c(advertAppInfo, i));
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
                aVar.b(this.adf).tD();
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
                    a(advertAppInfo, i, this.fYJ);
                    apkDownloadView.h(c);
                    return;
            }
            g.aj(this.adf.getPageActivity(), advertAppInfo.VU);
        }
    }

    public a.C0173a getAnimationInfo() {
        return this.euO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private AdCard fZe;

        public a(AdCard adCard) {
            this.fZe = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (!j.gD()) {
                AdCardBaseView.this.adf.showToast(d.k.neterror);
            } else if (this.fZe != null) {
                AdvertAppInfo advertAppInfo = this.fZe.getAdvertAppInfo();
                boolean z = view2 == AdCardBaseView.this.fYJ;
                if (advertAppInfo != null && advertAppInfo.qt()) {
                    int g = com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, g));
                    if ((6 == status || 7 == status) && j.gP() && !j.gQ()) {
                        AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, g, true, this.fZe.popWindowText);
                        return;
                    }
                    AdCardBaseView.this.a(advertAppInfo, g, AdCardBaseView.this.fYJ, z);
                    if (AdCardBaseView.this.ewm != null) {
                        AdCardBaseView.this.ewm.b(3, null);
                        return;
                    }
                    return;
                }
                String scheme = this.fZe.getScheme();
                if (k.isEmpty(scheme) && advertAppInfo != null) {
                    scheme = advertAppInfo.VS;
                }
                if (this.fZe.hasAnimation()) {
                }
                int e = s.e(AdCardBaseView.this.adf, AdCardBaseView.this.rW(scheme));
                if (AdCardBaseView.this.ewm != null) {
                    AdCardBaseView.this.ewm.b(e, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String rW(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.euO != null && this.euO.isValid()) {
            String c0173a = this.euO.toString();
            if (!TextUtils.isEmpty(c0173a)) {
                sb.append("&");
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append("=");
                sb.append(URLEncoder.encode(c0173a));
            }
        }
        if (!TextUtils.isEmpty(this.fYO.getPreLoadData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append("=");
            sb.append(URLEncoder.encode(this.fYO.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.fYO.getNextPageData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append("=");
            sb.append(URLEncoder.encode(this.fYO.getNextPageData()));
        }
        if (this.fYO.hasAnimation()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append("=");
            sb.append("1");
        }
        if (this.fYO.isGoLandingPage()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append("=");
            sb.append("1");
        }
        if (this.fYO.isImmersiveStyle()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append("=");
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    private static class b extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> fZf;

        public b(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.fZf = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.fZf.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                s.e(adCardBaseView.adf, adCardBaseView.fYT.scheme);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aLd() {
        if (4 == getBusinessType()) {
            this.fYE.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.fXZ != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.fYT = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.adf.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.adf, new CustomMessage<>(2002001, loginActivityConfig));
        return true;
    }

    private void a(View view2, TextView textView, ApkDownloadView apkDownloadView, AdCard adCard) {
        if (adCard == null) {
            view2.setVisibility(8);
            return;
        }
        view2.setVisibility(0);
        if (adCard.getAdvertAppInfo().qt()) {
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
        DownloadData downloadData = new DownloadData(advertAppInfo.VU);
        downloadData.setUrl(advertAppInfo.VT);
        downloadData.setName(advertAppInfo.VQ);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.g(advertAppInfo.VP, 0));
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
