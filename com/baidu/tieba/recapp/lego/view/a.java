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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.b.a;
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
public abstract class a extends com.baidu.tieba.lego.card.e.b<AdCard> implements com.baidu.tieba.lego.card.b.a {
    protected View cIs;
    protected View cXd;
    private a.C0189a fae;
    private final int fbJ;
    protected ViewStub gDD;
    protected View gDE;
    protected final int gDF;
    protected final int gDG;
    protected final int gDH;
    protected final int gDI;
    protected final int gDJ;
    protected final int gDK;
    protected final int gDL;
    protected final int gDM;
    private int gDN;
    private int gDO;
    private int gDP;
    protected TextView gDQ;
    protected TextView gDR;
    protected TextView gDS;
    private AdCloseView gDT;
    private LinearLayout gDU;
    protected ApkDownloadView gDV;
    protected TextView gDW;
    protected RelativeLayout gDX;
    protected View gDY;
    protected String gDZ;
    private AdCard gEa;
    private AdThreadCommentAndPraiseInfoLayout gEb;
    protected ThreadUserInfoLayout gEc;
    protected View gEd;
    protected View gEe;
    protected AdCard.b gEf;
    protected CustomMessageListener gEg;
    protected CustomMessageListener gEh;
    protected CustomMessageListener gEi;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void cL(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fbJ = l.ao(getContext());
        this.gEg = new CustomMessageListener(2016484) { // from class: com.baidu.tieba.recapp.lego.view.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                    if (((downloadData != null) & (TextUtils.isEmpty(a.this.gDZ) ? false : true)) && a.this.gDZ.equals(downloadData.getId())) {
                        int status = com.baidu.tieba.recapp.download.d.getStatus(downloadData);
                        if (status == 7) {
                            a.this.gDR.setText(d.j.pause_load);
                        } else if (status == 1 || status == 2) {
                            a.this.gDR.setText(d.j.pb_download_pause);
                        }
                    }
                }
            }
        };
        this.gEh = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.gDZ) && a.this.gDZ.equals(downloadData.getId())) {
                    a.this.gDV.u(downloadData);
                }
            }
        };
        this.gEi = new b(2016494, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(d.e.ds640);
        this.mImageHeight = (int) resources.getDimension(d.e.ds278);
        this.gDF = (int) resources.getDimension(d.e.tbds92);
        this.gDG = (int) resources.getDimension(d.e.tbds92);
        this.gDH = (int) resources.getDimension(d.e.tbds20);
        this.gDK = (int) resources.getDimension(d.e.tbds90);
        this.gDL = (int) resources.getDimension(d.e.tbds90);
        this.gDM = (int) resources.getDimension(d.e.tbds22);
        this.gDI = (int) resources.getDimension(d.e.tbds44);
        this.gDJ = (int) resources.getDimension(d.e.tbds44);
        this.gDN = (int) resources.getDimension(d.e.ds12);
        this.gDO = (int) resources.getDimension(d.e.ds1);
        this.gDP = (int) resources.getDimension(d.e.ds18);
    }

    protected void p(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.gEb.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.e.b
    protected View aPT() {
        MessageManager.getInstance().registerListener(this.gEg);
        MessageManager.getInstance().registerListener(this.gEh);
        MessageManager.getInstance().registerListener(this.gEi);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.cIs = this.mRootView.findViewById(d.g.bottom_line);
        this.gDQ = (TextView) this.mRootView.findViewById(d.g.ad_title);
        this.gDR = (TextView) this.mRootView.findViewById(d.g.transform_btn);
        this.gDV = (ApkDownloadView) this.mRootView.findViewById(d.g.advert_app_download_view);
        this.gDW = (TextView) this.mRootView.findViewById(d.g.advert_app_name);
        this.gDX = (RelativeLayout) this.mRootView.findViewById(d.g.bottom_transformation_area);
        this.gDV.p(this.aRR.getUniqueId());
        this.gEg.setTag(this.aRR.getUniqueId());
        this.gDY = this.mRootView.findViewById(d.g.card_ad_middle_container);
        this.gEh.setTag(this.aRR.getUniqueId());
        this.gEi.setTag(this.aRR.getUniqueId());
        this.gEb = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.gEb.setStyle(1);
        this.gEc = (ThreadUserInfoLayout) this.mRootView.findViewById(d.g.card_ad_user_info_layout);
        this.gDU = (LinearLayout) LayoutInflater.from(getContext()).inflate(d.h.ad_post_tag_close, (ViewGroup) null);
        this.gDT = (AdCloseView) this.gDU.findViewById(d.g.ad_close_view);
        this.gDS = (TextView) this.gDU.findViewById(d.g.feed_tag);
        this.gEc.addView(this.gDU);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gDU.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.aRR.getResources().getDimensionPixelOffset(d.e.ds8);
        this.gDU.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        this.gDU.setLayoutParams(layoutParams);
        this.gEc.getHeaderImg().setDefaultErrorResource(d.f.icon_default_avatar100);
        this.gEc.getHeaderImg().setDefaultResource(d.f.icon_default_avatar100);
        this.gEc.getHeaderImg().setDefaultBgResource(d.C0140d.cp_bg_line_e);
        this.cXd = this.mRootView.findViewById(d.g.divider_line_above_praise);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gEc.getHeaderImg().getLayoutParams();
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.ao(getContext()) - this.gDI) - this.gDJ) - this.gDF) - this.gDH;
            this.gEb.setVisibility(8);
        } else {
            this.mMaxWidth = (l.ao(getContext()) - this.gDI) - this.gDJ;
            this.gEb.setVisibility(0);
        }
        this.gDD = (ViewStub) this.mRootView.findViewById(d.g.ad_custom_view_stub);
        this.gDD.setLayoutResource(getCustomLayout());
        this.gDE = this.gDD.inflate();
        this.gEd = this.mRootView.findViewById(d.g.pb_bottom_view);
        this.gEe = this.mRootView.findViewById(d.g.frs_bottom_view);
        cL(this.gDE);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.e.b
    /* renamed from: b */
    public void e(final AdCard adCard) {
        final String str;
        this.gEa = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        View$OnClickListenerC0228a view$OnClickListenerC0228a = new View$OnClickListenerC0228a(adCard);
        this.mRootView.setOnClickListener(view$OnClickListenerC0228a);
        this.gEc.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.Fy() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.aE(advertAppInfo.xM());
                ((Vibrator) a.this.aRR.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.gDV.setOnClickListener(view$OnClickListenerC0228a);
        this.gDR.setOnClickListener(view$OnClickListenerC0228a);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gDY.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.gDF + this.gDH;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.gEc.getHeaderImg(), adCard.portraitClick, view$OnClickListenerC0228a);
        if (!TextUtils.isEmpty(adCard.tagName)) {
            this.gDS.setText(adCard.tagName);
        } else {
            this.gDS.setText("广告");
        }
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String rO = rO(am.d(str2, 100, "..."));
            if (4 == getBusinessType()) {
                this.gDQ.setTextSize(0, getContext().getResources().getDimension(d.e.ds32));
            } else {
                this.gDQ.setTextSize(0, getContext().getResources().getDimension(d.e.tbfontsize48));
            }
            this.gDQ.setText(rO);
            this.gDQ.setVisibility(0);
        } else {
            this.gDQ.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar = adCard.buttonClick;
        if (bVar == null) {
            str = "";
        } else {
            str = bVar.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.xL()) && true == com.baidu.adp.lib.util.k.isEmpty(str3);
        a(this.gDX, this.gDR, this.gDV, adCard);
        if (!z && !TextUtils.isEmpty(adCard.userName)) {
            if (advertAppInfo != null && advertAppInfo.xK()) {
                this.gDW.setText(adCard.userName.concat("App").toString());
            } else if (advertAppInfo != null && advertAppInfo.xL()) {
                this.gDW.setText(adCard.userName);
            }
        }
        if (advertAppInfo != null && advertAppInfo.xK()) {
            this.gDZ = advertAppInfo.aKK;
            this.gDV.setClickable(true);
            DownloadData c = c(advertAppInfo, com.baidu.adp.lib.g.b.h(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            a(this.gDR, c.getStatus(), str3);
            this.gDV.setData(c);
            this.gDV.setVisibility(0);
        } else {
            if (!z && !com.baidu.adp.lib.util.k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    aj.e(this.gDR, d.C0140d.btn_forum_focus_color, 1);
                    this.gDR.setText(str3);
                    if (com.baidu.adp.lib.util.k.isEmpty(str)) {
                        this.gDR.setClickable(false);
                    } else {
                        this.gDR.setClickable(true);
                        this.gDR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (a.this.fbC != null && adCard.buttonClick != null && !q.sG(adCard.buttonClick.scheme)) {
                                    a.this.fbC.b(adCard.buttonClick.azQ, adCard.buttonClick.azR, null);
                                }
                                if (!a.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int f = s.f(a.this.aRR, str);
                                        if ((f == 1 || f == 2) && a.this.fbC != null) {
                                            a.this.fbC.b(f, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.aRR.getPageActivity());
                                    aVar.dk(adCard.popWindowText);
                                    aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int f2 = s.f(a.this.aRR, str);
                                            if ((f2 == 1 || f2 == 2) && a.this.fbC != null) {
                                                a.this.fbC.b(f2, null);
                                            }
                                            aVar2.dismiss();
                                        }
                                    });
                                    aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.2.2
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            aVar2.dismiss();
                                        }
                                    });
                                    aVar.b(a.this.aRR).AU();
                                }
                            }
                        });
                    }
                } else {
                    this.gDR.setClickable(false);
                    this.gDR.setText(adCard.buttonTextDone);
                    aj.s(this.gDR, d.f.btn_rounded_corner_gray_frame);
                    aj.e(this.gDR, d.C0140d.cp_cont_d, 1);
                }
            }
            this.gDV.setVisibility(8);
        }
        a(adCard);
        p(com.baidu.tbadk.core.i.xo().xu(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            rP(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.aKR != null && advertAppInfo.aKR.aLm != null && advertAppInfo.aKR.aLm.support_close.intValue() > 0) {
            this.gDT.setVisibility(0);
            this.gDT.setPage(getBusinessType());
            this.gDT.setData(advertAppInfo);
            l.a(this.aRR.getPageActivity(), this.gDU, 40, 40, 40, 120);
            this.gDU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.gDT.performClick();
                }
            });
        } else {
            this.gDT.setVisibility(8);
            this.gDS.setOnClickListener(null);
        }
        this.gEb.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.cIs.getLayoutParams();
        if (4 == getBusinessType()) {
            this.gEb.setVisibility(8);
            this.gEb.setBarNameClickEnabled(false);
            this.gEb.setShareVisible(false);
            this.gEb.setShowPraiseNum(false);
            this.gEb.setCommentNumEnable(false);
            this.gEb.setReplyTimeVisible(false);
            layoutParams2.height = this.gDO;
            this.gEd.setVisibility(0);
            this.gEe.setVisibility(8);
        } else {
            a(adCard, view$OnClickListenerC0228a);
        }
        a(adCard, this.cXd, getBusinessType());
        this.gEc.setData(adCard.getAdvertAppInfo());
        this.gEc.getHeaderImg().setVisibility(0);
        this.gEc.getHeaderImg().startLoad(adCard.userPortrait, 10, false);
        this.gEc.getUserName().setOnClickListener(view$OnClickListenerC0228a);
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private void a(AdCard adCard, View$OnClickListenerC0228a view$OnClickListenerC0228a) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.gEe.setVisibility(0);
            this.gEb.setVisibility(8);
            return;
        }
        this.gEe.setVisibility(8);
        this.gEb.setVisibility(0);
        this.gEb.setBarNameClickEnabled(false);
        this.gEb.setReplyTimeVisible(false);
        this.gEb.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.gEb.setAgreeClickable(true);
            this.gEb.setPraiseContainerBgGray(false);
        } else {
            this.gEb.setAgreeClickable(false);
            this.gEb.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.gEb.setShareClickable(true);
            this.gEb.setShareContainerBgGray(false);
        } else {
            this.gEb.setShareClickable(false);
            this.gEb.setShareContainerBgGray(true);
        }
        this.gEb.getCommentContainer().setOnClickListener(view$OnClickListenerC0228a);
        this.gEb.setNeedAddReplyIcon(true);
        this.gEb.setCommentNumEnable(true);
        this.gEb.setCommentClickable(true);
        this.gEb.setReplayContainerBgGray(true);
        this.gEb.setOnClickListener(view$OnClickListenerC0228a);
        this.gEb.setShareData(adCard);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.e.b
    public void a(AdCard adCard, int i) {
        aj.s(this.cIs, d.C0140d.cp_bg_line_c);
        this.gDT.onChangeSkinType();
        this.gEc.onChangeSkinType();
        this.gEb.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            aj.s(this.mRootView, d.f.addresslist_item_bg);
            aj.t(this.cIs, d.C0140d.cp_bg_line_e);
            aj.t(this.cXd, d.C0140d.cp_bg_line_e);
        } else {
            aj.t(this.cIs, d.C0140d.cp_bg_line_c);
            aj.t(this.cXd, d.C0140d.transparent);
        }
        aj.e(this.gDQ, d.C0140d.cp_cont_b, 1);
        aj.t(this.gDX, d.C0140d.cp_bg_line_e);
        aj.r(this.gDW, d.C0140d.cp_cont_j);
        aj.e(this.gDS, d.C0140d.cp_cont_d, 1);
        this.gDV.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String rO(String str) {
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
            if (b(bVar) && !q.sG(bVar.scheme)) {
                if (this.fbC != null) {
                    this.fbC.b(bVar.azQ, bVar.azR, null);
                    return;
                }
                return;
            }
            int f = s.f(this.aRR, rQ(bVar.scheme));
            if (f == 1 || f == 2) {
                if (this.fbC != null) {
                    this.fbC.b(f, null);
                }
            } else if (this.fbC != null) {
                this.fbC.b(bVar.azQ, bVar.azR, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final TbImageView tbImageView, final AdCard.b bVar) {
        if (tbImageView != null) {
            if (bVar != null && !com.baidu.adp.lib.util.k.isEmpty(bVar.scheme)) {
                tbImageView.setClickable(true);
                tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (a.this.gEa.hasAnimation()) {
                            a.this.d(tbImageView);
                        }
                        a.this.a(bVar);
                    }
                });
                return;
            }
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TbImageView tbImageView, final AdCard.b bVar, View$OnClickListenerC0228a view$OnClickListenerC0228a) {
        if (tbImageView != null) {
            if (bVar != null && !com.baidu.adp.lib.util.k.isEmpty(bVar.scheme)) {
                tbImageView.setClickable(true);
                tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        a.this.a(bVar);
                    }
                });
                return;
            }
            tbImageView.setClickable(true);
            tbImageView.setOnClickListener(view$OnClickListenerC0228a);
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
        this.fae = new a.C0189a();
        this.fae.picUrl = tbImageView.getUrl();
        this.fae.rect = rect;
    }

    private void rP(String str) {
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
                    com.baidu.adp.lib.f.c.nm().a(jSONObject.optString("pic_url"), 17, null, this.fbJ, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.fbJ), this.aRR.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.xJ() != 0) {
                l.showToast(this.aRR.getPageActivity(), d.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.DI();
            this.mPermissionJudgePolicy.c(this.aRR.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.v(this.aRR.getPageActivity()) && this.fbD != null) {
                this.fbD.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.s(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!com.baidu.adp.lib.util.j.ox()) {
                l.showToast(this.aRR.getPageActivity(), d.j.neterror);
            } else if (advertAppInfo.xK()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.aRR.getString(d.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRR.getPageActivity());
                aVar.dk(str);
                aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.a(advertAppInfo, i, a.this.gDV);
                        if (a.this.gDV != null) {
                            a.this.gDV.s(a.this.c(advertAppInfo, i));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.aRR).AU();
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
                        com.baidu.tieba.recapp.download.g.e(advertAppInfo);
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
                    a(advertAppInfo, i, this.gDV);
                    apkDownloadView.h(c);
                    return;
            }
            com.baidu.tieba.recapp.download.g.ao(this.aRR.getPageActivity(), advertAppInfo.aKK);
        }
    }

    public a.C0189a getAnimationInfo() {
        return this.fae;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.recapp.lego.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0228a implements View.OnClickListener {
        private AdCard gEq;

        public View$OnClickListenerC0228a(AdCard adCard) {
            this.gEq = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.adp.lib.util.j.ox()) {
                a.this.aRR.showToast(d.j.neterror);
            } else if (this.gEq != null) {
                AdvertAppInfo advertAppInfo = this.gEq.getAdvertAppInfo();
                boolean z = view == a.this.gDV;
                if (advertAppInfo != null && advertAppInfo.xK()) {
                    int h = com.baidu.adp.lib.g.b.h(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(a.this.c(advertAppInfo, h));
                    if ((6 == status || 7 == status) && com.baidu.adp.lib.util.j.oJ() && !com.baidu.adp.lib.util.j.oK()) {
                        a.this.showDownloadAppDialog(advertAppInfo, h, true, this.gEq.popWindowText);
                        return;
                    }
                    a.this.a(advertAppInfo, h, a.this.gDV, z);
                    if (a.this.fbC != null) {
                        a.this.fbC.b(3, null);
                        return;
                    }
                    return;
                }
                String scheme = this.gEq.getScheme();
                if (com.baidu.adp.lib.util.k.isEmpty(scheme) && advertAppInfo != null) {
                    scheme = advertAppInfo.aKI;
                }
                if (this.gEq.hasAnimation()) {
                }
                int f = s.f(a.this.aRR, a.this.rQ(scheme));
                if (a.this.fbC != null) {
                    a.this.fbC.b(f, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String rQ(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.fae != null && this.fae.isValid()) {
            String c0189a = this.fae.toString();
            if (!TextUtils.isEmpty(c0189a)) {
                sb.append("&");
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append("=");
                sb.append(URLEncoder.encode(c0189a));
            }
        }
        if (!TextUtils.isEmpty(this.gEa.getPreLoadData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append("=");
            sb.append(URLEncoder.encode(this.gEa.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.gEa.getNextPageData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append("=");
            sb.append(URLEncoder.encode(this.gEa.getNextPageData()));
        }
        if (this.gEa.hasAnimation()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append("=");
            sb.append("1");
        }
        if (this.gEa.isGoLandingPage()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append("=");
            sb.append("1");
        }
        if (this.gEa.isImmersiveStyle()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append("=");
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    private static class b extends CustomMessageListener {
        private final WeakReference<a> gEr;

        public b(int i, a aVar) {
            super(i);
            this.gEr = new WeakReference<>(aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a aVar = this.gEr.get();
            if (aVar != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                s.f(aVar.aRR, aVar.gEf.scheme);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.e.b, com.baidu.tieba.lego.card.e.k
    public void aQd() {
        if (4 == getBusinessType()) {
            this.gDQ.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.gDl != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.gEf = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.aRR.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.aRR, new CustomMessage<>(2002001, loginActivityConfig));
        return true;
    }

    private void a(View view, TextView textView, ApkDownloadView apkDownloadView, AdCard adCard) {
        if (adCard == null) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        if (adCard.getAdvertAppInfo().xK()) {
            textView.setVisibility(8);
            apkDownloadView.setVisibility(0);
            return;
        }
        if (true == com.baidu.adp.lib.util.k.isEmpty(adCard.buttonText) || "立即查看".equals(adCard.buttonText)) {
            textView.setVisibility(8);
            view.setVisibility(8);
        } else {
            textView.setVisibility(0);
            aj.s(textView, d.f.btn_focus_border_bg);
        }
        apkDownloadView.setVisibility(8);
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.aKK);
        downloadData.setUrl(advertAppInfo.aKJ);
        downloadData.setName(advertAppInfo.aKG);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.h(advertAppInfo.aKF, 0));
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
