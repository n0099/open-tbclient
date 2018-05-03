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
    protected View bYn;
    protected View coS;
    private a.C0173a euL;
    private final int ewq;
    private int fYA;
    protected TextView fYB;
    protected TextView fYC;
    protected TextView fYD;
    private AdCloseView fYE;
    private LinearLayout fYF;
    protected ApkDownloadView fYG;
    protected TextView fYH;
    protected RelativeLayout fYI;
    protected View fYJ;
    protected String fYK;
    private AdCard fYL;
    private AdThreadCommentAndPraiseInfoLayout fYM;
    protected ThreadUserInfoLayout fYN;
    protected View fYO;
    protected View fYP;
    protected AdCard.b fYQ;
    protected CustomMessageListener fYR;
    protected CustomMessageListener fYS;
    protected CustomMessageListener fYT;
    protected ViewStub fYo;
    protected View fYp;
    protected final int fYq;
    protected final int fYr;
    protected final int fYs;
    protected final int fYt;
    protected final int fYu;
    protected final int fYv;
    protected final int fYw;
    protected final int fYx;
    private int fYy;
    private int fYz;
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
        this.ewq = l.af(getContext());
        this.fYR = new CustomMessageListener(2016484) { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                    if (((downloadData != null) & (TextUtils.isEmpty(AdCardBaseView.this.fYK) ? false : true)) && AdCardBaseView.this.fYK.equals(downloadData.getId())) {
                        int status = d.getStatus(downloadData);
                        if (status == 7) {
                            AdCardBaseView.this.fYC.setText(d.k.pause_load);
                        } else if (status == 1 || status == 2) {
                            AdCardBaseView.this.fYC.setText(d.k.pb_download_pause);
                        }
                    }
                }
            }
        };
        this.fYS = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(AdCardBaseView.this.fYK) && AdCardBaseView.this.fYK.equals(downloadData.getId())) {
                    AdCardBaseView.this.fYG.u(downloadData);
                }
            }
        };
        this.fYT = new b(2016494, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(d.e.ds640);
        this.mImageHeight = (int) resources.getDimension(d.e.ds278);
        this.fYq = (int) resources.getDimension(d.e.tbds92);
        this.fYr = (int) resources.getDimension(d.e.tbds92);
        this.fYs = (int) resources.getDimension(d.e.tbds20);
        this.fYv = (int) resources.getDimension(d.e.tbds90);
        this.fYw = (int) resources.getDimension(d.e.tbds90);
        this.fYx = (int) resources.getDimension(d.e.tbds22);
        this.fYt = (int) resources.getDimension(d.e.tbds44);
        this.fYu = (int) resources.getDimension(d.e.tbds44);
        this.fYy = (int) resources.getDimension(d.e.ds12);
        this.fYz = (int) resources.getDimension(d.e.ds1);
        this.fYA = (int) resources.getDimension(d.e.ds18);
    }

    protected void l(boolean z, int i) {
    }

    private void a(AdCard adCard, View view2, int i) {
        if (adCard != null) {
            if (4 == i) {
                view2.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.fYM.getVisibility() == 0) {
                view2.setVisibility(8);
            } else {
                view2.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View aKU() {
        MessageManager.getInstance().registerListener(this.fYR);
        MessageManager.getInstance().registerListener(this.fYS);
        MessageManager.getInstance().registerListener(this.fYT);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.bYn = this.mRootView.findViewById(d.g.bottom_line);
        this.fYB = (TextView) this.mRootView.findViewById(d.g.ad_title);
        this.fYC = (TextView) this.mRootView.findViewById(d.g.transform_btn);
        this.fYG = (ApkDownloadView) this.mRootView.findViewById(d.g.advert_app_download_view);
        this.fYH = (TextView) this.mRootView.findViewById(d.g.advert_app_name);
        this.fYI = (RelativeLayout) this.mRootView.findViewById(d.g.bottom_transformation_area);
        this.fYG.p(this.adf.getUniqueId());
        this.fYR.setTag(this.adf.getUniqueId());
        this.fYJ = this.mRootView.findViewById(d.g.card_ad_middle_container);
        this.fYS.setTag(this.adf.getUniqueId());
        this.fYT.setTag(this.adf.getUniqueId());
        this.fYM = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.fYM.setStyle(1);
        this.fYN = (ThreadUserInfoLayout) this.mRootView.findViewById(d.g.card_ad_user_info_layout);
        this.fYF = (LinearLayout) LayoutInflater.from(getContext()).inflate(d.i.ad_post_tag_close, (ViewGroup) null);
        this.fYE = (AdCloseView) this.fYF.findViewById(d.g.ad_close_view);
        this.fYD = (TextView) this.fYF.findViewById(d.g.feed_tag);
        this.fYN.addView(this.fYF);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fYF.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.adf.getResources().getDimensionPixelOffset(d.e.ds8);
        this.fYF.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        this.fYF.setLayoutParams(layoutParams);
        this.fYN.getHeaderImg().setDefaultErrorResource(d.f.icon_default_avatar100);
        this.fYN.getHeaderImg().setDefaultResource(d.f.icon_default_avatar100);
        this.fYN.getHeaderImg().setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.coS = this.mRootView.findViewById(d.g.divider_line_above_praise);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fYN.getHeaderImg().getLayoutParams();
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.af(getContext()) - this.fYt) - this.fYu) - this.fYq) - this.fYs;
            this.fYM.setVisibility(8);
        } else {
            this.mMaxWidth = (l.af(getContext()) - this.fYt) - this.fYu;
            this.fYM.setVisibility(0);
        }
        this.fYo = (ViewStub) this.mRootView.findViewById(d.g.ad_custom_view_stub);
        this.fYo.setLayoutResource(getCustomLayout());
        this.fYp = this.fYo.inflate();
        this.fYO = this.mRootView.findViewById(d.g.pb_bottom_view);
        this.fYP = this.mRootView.findViewById(d.g.frs_bottom_view);
        br(this.fYp);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(final AdCard adCard) {
        final String str;
        this.fYL = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        a aVar = new a(adCard);
        this.mRootView.setOnClickListener(aVar);
        this.fYN.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
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
        this.fYG.setOnClickListener(aVar);
        this.fYC.setOnClickListener(aVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fYJ.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.fYq + this.fYs;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.fYN.getHeaderImg(), adCard.portraitClick, aVar);
        if (!TextUtils.isEmpty(adCard.tagName)) {
            this.fYD.setText(adCard.tagName);
        } else {
            this.fYD.setText("广告");
        }
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String rU = rU(an.d(str2, 100, "..."));
            if (4 == getBusinessType()) {
                this.fYB.setTextSize(0, getContext().getResources().getDimension(d.e.ds32));
            } else {
                this.fYB.setTextSize(0, getContext().getResources().getDimension(d.e.tbfontsize48));
            }
            this.fYB.setText(rU);
            this.fYB.setVisibility(0);
        } else {
            this.fYB.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar = adCard.buttonClick;
        if (bVar == null) {
            str = "";
        } else {
            str = bVar.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.qu()) && true == k.isEmpty(str3);
        a(this.fYI, this.fYC, this.fYG, adCard);
        if (!z && !TextUtils.isEmpty(adCard.userName)) {
            if (advertAppInfo != null && advertAppInfo.qt()) {
                this.fYH.setText(adCard.userName.concat("App").toString());
            } else if (advertAppInfo != null && advertAppInfo.qu()) {
                this.fYH.setText(adCard.userName);
            }
        }
        if (advertAppInfo != null && advertAppInfo.qt()) {
            this.fYK = advertAppInfo.VU;
            this.fYG.setClickable(true);
            DownloadData c = c(advertAppInfo, com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            a(this.fYC, c.getStatus(), str3);
            this.fYG.setData(c);
            this.fYG.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    ak.c(this.fYC, d.C0126d.btn_forum_focus_color, 1);
                    this.fYC.setText(str3);
                    if (k.isEmpty(str)) {
                        this.fYC.setClickable(false);
                    } else {
                        this.fYC.setClickable(true);
                        this.fYC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (AdCardBaseView.this.ewj != null && adCard.buttonClick != null && !q.sN(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.ewj.b(adCard.buttonClick.LW, adCard.buttonClick.LX, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int e = s.e(AdCardBaseView.this.adf, str);
                                        if ((e == 1 || e == 2) && AdCardBaseView.this.ewj != null) {
                                            AdCardBaseView.this.ewj.b(e, null);
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
                                            if ((e2 == 1 || e2 == 2) && AdCardBaseView.this.ewj != null) {
                                                AdCardBaseView.this.ewj.b(e2, null);
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
                    this.fYC.setClickable(false);
                    this.fYC.setText(adCard.buttonTextDone);
                    ak.i(this.fYC, d.f.btn_rounded_corner_gray_frame);
                    ak.c(this.fYC, d.C0126d.cp_cont_d, 1);
                }
            }
            this.fYG.setVisibility(8);
        }
        a(adCard);
        l(i.pY().qe(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            rV(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.Wb != null && advertAppInfo.Wb.Ww != null && advertAppInfo.Wb.Ww.support_close.intValue() > 0) {
            this.fYE.setVisibility(0);
            this.fYE.setPage(getBusinessType());
            this.fYE.setData(advertAppInfo);
            l.a(this.adf.getPageActivity(), this.fYF, 40, 40, 40, 120);
            this.fYF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AdCardBaseView.this.fYE.performClick();
                }
            });
        } else {
            this.fYE.setVisibility(8);
            this.fYD.setOnClickListener(null);
        }
        this.fYM.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.bYn.getLayoutParams();
        if (4 == getBusinessType()) {
            this.fYM.setVisibility(8);
            this.fYM.setBarNameClickEnabled(false);
            this.fYM.setShareVisible(false);
            this.fYM.setShowPraiseNum(false);
            this.fYM.setCommentNumEnable(false);
            this.fYM.setReplyTimeVisible(false);
            layoutParams2.height = this.fYz;
            this.fYO.setVisibility(0);
            this.fYP.setVisibility(8);
        } else {
            a(adCard, aVar);
        }
        a(adCard, this.coS, getBusinessType());
        this.fYN.setData(adCard.getAdvertAppInfo());
        this.fYN.getHeaderImg().setVisibility(0);
        this.fYN.getHeaderImg().startLoad(adCard.userPortrait, 10, false);
        this.fYN.getUserName().setOnClickListener(aVar);
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private void a(AdCard adCard, a aVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.fYP.setVisibility(0);
            this.fYM.setVisibility(8);
            return;
        }
        this.fYP.setVisibility(8);
        this.fYM.setVisibility(0);
        this.fYM.setBarNameClickEnabled(false);
        this.fYM.setReplyTimeVisible(false);
        this.fYM.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.fYM.setAgreeClickable(true);
            this.fYM.setPraiseContainerBgGray(false);
        } else {
            this.fYM.setAgreeClickable(false);
            this.fYM.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.fYM.setShareClickable(true);
            this.fYM.setShareContainerBgGray(false);
        } else {
            this.fYM.setShareClickable(false);
            this.fYM.setShareContainerBgGray(true);
        }
        this.fYM.getCommentContainer().setOnClickListener(aVar);
        this.fYM.setNeedAddReplyIcon(true);
        this.fYM.setCommentNumEnable(true);
        this.fYM.setCommentClickable(true);
        this.fYM.setReplayContainerBgGray(true);
        this.fYM.setOnClickListener(aVar);
        this.fYM.setShareData(adCard);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        ak.i(this.bYn, d.C0126d.cp_bg_line_c);
        this.fYE.onChangeSkinType();
        this.fYN.onChangeSkinType();
        this.fYM.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            ak.i(this.mRootView, d.f.addresslist_item_bg);
            ak.j(this.bYn, d.C0126d.cp_bg_line_e);
            ak.j(this.coS, d.C0126d.cp_bg_line_e);
        } else {
            ak.j(this.bYn, d.C0126d.cp_bg_line_c);
            ak.j(this.coS, d.C0126d.transparent);
        }
        ak.c(this.fYB, d.C0126d.cp_cont_b, 1);
        ak.j(this.fYI, d.C0126d.cp_bg_line_e);
        ak.h(this.fYH, d.C0126d.cp_cont_j);
        ak.c(this.fYD, d.C0126d.cp_cont_d, 1);
        this.fYG.onChangeSkinType(i);
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
                if (this.ewj != null) {
                    this.ewj.b(bVar.LW, bVar.LX, null);
                    return;
                }
                return;
            }
            int e = s.e(this.adf, rW(bVar.scheme));
            if (e == 1 || e == 2) {
                if (this.ewj != null) {
                    this.ewj.b(e, null);
                }
            } else if (this.ewj != null) {
                this.ewj.b(bVar.LW, bVar.LX, null);
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
                        if (AdCardBaseView.this.fYL.hasAnimation()) {
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
        this.euL = new a.C0173a();
        this.euL.picUrl = tbImageView.getUrl();
        this.euL.rect = rect;
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
                    com.baidu.adp.lib.f.c.fp().a(jSONObject.optString("pic_url"), 17, null, this.ewq, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.ewq), this.adf.getUniqueId(), new Object[0]);
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
            if (!this.mPermissionJudgePolicy.v(this.adf.getPageActivity()) && this.ewk != null) {
                this.ewk.b(advertAppInfo, i);
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
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.fYG);
                        if (AdCardBaseView.this.fYG != null) {
                            AdCardBaseView.this.fYG.s(AdCardBaseView.this.c(advertAppInfo, i));
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
                    a(advertAppInfo, i, this.fYG);
                    apkDownloadView.h(c);
                    return;
            }
            g.aj(this.adf.getPageActivity(), advertAppInfo.VU);
        }
    }

    public a.C0173a getAnimationInfo() {
        return this.euL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private AdCard fZb;

        public a(AdCard adCard) {
            this.fZb = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (!j.gD()) {
                AdCardBaseView.this.adf.showToast(d.k.neterror);
            } else if (this.fZb != null) {
                AdvertAppInfo advertAppInfo = this.fZb.getAdvertAppInfo();
                boolean z = view2 == AdCardBaseView.this.fYG;
                if (advertAppInfo != null && advertAppInfo.qt()) {
                    int g = com.baidu.adp.lib.g.b.g(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, g));
                    if ((6 == status || 7 == status) && j.gP() && !j.gQ()) {
                        AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, g, true, this.fZb.popWindowText);
                        return;
                    }
                    AdCardBaseView.this.a(advertAppInfo, g, AdCardBaseView.this.fYG, z);
                    if (AdCardBaseView.this.ewj != null) {
                        AdCardBaseView.this.ewj.b(3, null);
                        return;
                    }
                    return;
                }
                String scheme = this.fZb.getScheme();
                if (k.isEmpty(scheme) && advertAppInfo != null) {
                    scheme = advertAppInfo.VS;
                }
                if (this.fZb.hasAnimation()) {
                }
                int e = s.e(AdCardBaseView.this.adf, AdCardBaseView.this.rW(scheme));
                if (AdCardBaseView.this.ewj != null) {
                    AdCardBaseView.this.ewj.b(e, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String rW(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.euL != null && this.euL.isValid()) {
            String c0173a = this.euL.toString();
            if (!TextUtils.isEmpty(c0173a)) {
                sb.append("&");
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append("=");
                sb.append(URLEncoder.encode(c0173a));
            }
        }
        if (!TextUtils.isEmpty(this.fYL.getPreLoadData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append("=");
            sb.append(URLEncoder.encode(this.fYL.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.fYL.getNextPageData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append("=");
            sb.append(URLEncoder.encode(this.fYL.getNextPageData()));
        }
        if (this.fYL.hasAnimation()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append("=");
            sb.append("1");
        }
        if (this.fYL.isGoLandingPage()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append("=");
            sb.append("1");
        }
        if (this.fYL.isImmersiveStyle()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append("=");
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    private static class b extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> fZc;

        public b(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.fZc = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.fZc.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                s.e(adCardBaseView.adf, adCardBaseView.fYQ.scheme);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void aLd() {
        if (4 == getBusinessType()) {
            this.fYB.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.fXW != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.fYQ = bVar;
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
