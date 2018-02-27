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
    protected View cIg;
    protected View cWR;
    private a.C0190a eZS;
    private final int fbx;
    private int gDA;
    protected TextView gDB;
    protected TextView gDC;
    protected TextView gDD;
    private AdCloseView gDE;
    private LinearLayout gDF;
    protected ApkDownloadView gDG;
    protected TextView gDH;
    protected RelativeLayout gDI;
    protected View gDJ;
    protected String gDK;
    private AdCard gDL;
    private AdThreadCommentAndPraiseInfoLayout gDM;
    protected ThreadUserInfoLayout gDN;
    protected View gDO;
    protected View gDP;
    protected AdCard.b gDQ;
    protected CustomMessageListener gDR;
    protected CustomMessageListener gDS;
    protected CustomMessageListener gDT;
    protected ViewStub gDo;
    protected View gDp;
    protected final int gDq;
    protected final int gDr;
    protected final int gDs;
    protected final int gDt;
    protected final int gDu;
    protected final int gDv;
    protected final int gDw;
    protected final int gDx;
    private int gDy;
    private int gDz;
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
        this.fbx = l.ao(getContext());
        this.gDR = new CustomMessageListener(2016484) { // from class: com.baidu.tieba.recapp.lego.view.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                    if (((downloadData != null) & (TextUtils.isEmpty(a.this.gDK) ? false : true)) && a.this.gDK.equals(downloadData.getId())) {
                        int status = com.baidu.tieba.recapp.download.d.getStatus(downloadData);
                        if (status == 7) {
                            a.this.gDC.setText(d.j.pause_load);
                        } else if (status == 1 || status == 2) {
                            a.this.gDC.setText(d.j.pb_download_pause);
                        }
                    }
                }
            }
        };
        this.gDS = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.gDK) && a.this.gDK.equals(downloadData.getId())) {
                    a.this.gDG.u(downloadData);
                }
            }
        };
        this.gDT = new b(2016494, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(d.e.ds640);
        this.mImageHeight = (int) resources.getDimension(d.e.ds278);
        this.gDq = (int) resources.getDimension(d.e.tbds92);
        this.gDr = (int) resources.getDimension(d.e.tbds92);
        this.gDs = (int) resources.getDimension(d.e.tbds20);
        this.gDv = (int) resources.getDimension(d.e.tbds90);
        this.gDw = (int) resources.getDimension(d.e.tbds90);
        this.gDx = (int) resources.getDimension(d.e.tbds22);
        this.gDt = (int) resources.getDimension(d.e.tbds44);
        this.gDu = (int) resources.getDimension(d.e.tbds44);
        this.gDy = (int) resources.getDimension(d.e.ds12);
        this.gDz = (int) resources.getDimension(d.e.ds1);
        this.gDA = (int) resources.getDimension(d.e.ds18);
    }

    protected void p(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.gDM.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.e.b
    protected View aPS() {
        MessageManager.getInstance().registerListener(this.gDR);
        MessageManager.getInstance().registerListener(this.gDS);
        MessageManager.getInstance().registerListener(this.gDT);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.cIg = this.mRootView.findViewById(d.g.bottom_line);
        this.gDB = (TextView) this.mRootView.findViewById(d.g.ad_title);
        this.gDC = (TextView) this.mRootView.findViewById(d.g.transform_btn);
        this.gDG = (ApkDownloadView) this.mRootView.findViewById(d.g.advert_app_download_view);
        this.gDH = (TextView) this.mRootView.findViewById(d.g.advert_app_name);
        this.gDI = (RelativeLayout) this.mRootView.findViewById(d.g.bottom_transformation_area);
        this.gDG.p(this.aRG.getUniqueId());
        this.gDR.setTag(this.aRG.getUniqueId());
        this.gDJ = this.mRootView.findViewById(d.g.card_ad_middle_container);
        this.gDS.setTag(this.aRG.getUniqueId());
        this.gDT.setTag(this.aRG.getUniqueId());
        this.gDM = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.gDM.setStyle(1);
        this.gDN = (ThreadUserInfoLayout) this.mRootView.findViewById(d.g.card_ad_user_info_layout);
        this.gDF = (LinearLayout) LayoutInflater.from(getContext()).inflate(d.h.ad_post_tag_close, (ViewGroup) null);
        this.gDE = (AdCloseView) this.gDF.findViewById(d.g.ad_close_view);
        this.gDD = (TextView) this.gDF.findViewById(d.g.feed_tag);
        this.gDN.addView(this.gDF);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gDF.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.aRG.getResources().getDimensionPixelOffset(d.e.ds8);
        this.gDF.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        this.gDF.setLayoutParams(layoutParams);
        this.gDN.getHeaderImg().setDefaultErrorResource(d.f.icon_default_avatar100);
        this.gDN.getHeaderImg().setDefaultResource(d.f.icon_default_avatar100);
        this.gDN.getHeaderImg().setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.cWR = this.mRootView.findViewById(d.g.divider_line_above_praise);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gDN.getHeaderImg().getLayoutParams();
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.ao(getContext()) - this.gDt) - this.gDu) - this.gDq) - this.gDs;
            this.gDM.setVisibility(8);
        } else {
            this.mMaxWidth = (l.ao(getContext()) - this.gDt) - this.gDu;
            this.gDM.setVisibility(0);
        }
        this.gDo = (ViewStub) this.mRootView.findViewById(d.g.ad_custom_view_stub);
        this.gDo.setLayoutResource(getCustomLayout());
        this.gDp = this.gDo.inflate();
        this.gDO = this.mRootView.findViewById(d.g.pb_bottom_view);
        this.gDP = this.mRootView.findViewById(d.g.frs_bottom_view);
        cL(this.gDp);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.e.b
    /* renamed from: b */
    public void e(final AdCard adCard) {
        final String str;
        this.gDL = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        View$OnClickListenerC0229a view$OnClickListenerC0229a = new View$OnClickListenerC0229a(adCard);
        this.mRootView.setOnClickListener(view$OnClickListenerC0229a);
        this.gDN.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.Fx() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.aE(advertAppInfo.xM());
                ((Vibrator) a.this.aRG.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.gDG.setOnClickListener(view$OnClickListenerC0229a);
        this.gDC.setOnClickListener(view$OnClickListenerC0229a);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gDJ.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.gDq + this.gDs;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.gDN.getHeaderImg(), adCard.portraitClick, view$OnClickListenerC0229a);
        if (!TextUtils.isEmpty(adCard.tagName)) {
            this.gDD.setText(adCard.tagName);
        } else {
            this.gDD.setText("广告");
        }
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String rO = rO(am.d(str2, 100, "..."));
            if (4 == getBusinessType()) {
                this.gDB.setTextSize(0, getContext().getResources().getDimension(d.e.ds32));
            } else {
                this.gDB.setTextSize(0, getContext().getResources().getDimension(d.e.tbfontsize48));
            }
            this.gDB.setText(rO);
            this.gDB.setVisibility(0);
        } else {
            this.gDB.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar = adCard.buttonClick;
        if (bVar == null) {
            str = "";
        } else {
            str = bVar.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.xL()) && true == com.baidu.adp.lib.util.k.isEmpty(str3);
        a(this.gDI, this.gDC, this.gDG, adCard);
        if (!z && !TextUtils.isEmpty(adCard.userName)) {
            if (advertAppInfo != null && advertAppInfo.xK()) {
                this.gDH.setText(adCard.userName.concat("App").toString());
            } else if (advertAppInfo != null && advertAppInfo.xL()) {
                this.gDH.setText(adCard.userName);
            }
        }
        if (advertAppInfo != null && advertAppInfo.xK()) {
            this.gDK = advertAppInfo.aKz;
            this.gDG.setClickable(true);
            DownloadData c = c(advertAppInfo, com.baidu.adp.lib.g.b.h(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            a(this.gDC, c.getStatus(), str3);
            this.gDG.setData(c);
            this.gDG.setVisibility(0);
        } else {
            if (!z && !com.baidu.adp.lib.util.k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    aj.e(this.gDC, d.C0141d.btn_forum_focus_color, 1);
                    this.gDC.setText(str3);
                    if (com.baidu.adp.lib.util.k.isEmpty(str)) {
                        this.gDC.setClickable(false);
                    } else {
                        this.gDC.setClickable(true);
                        this.gDC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (a.this.fbq != null && adCard.buttonClick != null && !q.sG(adCard.buttonClick.scheme)) {
                                    a.this.fbq.b(adCard.buttonClick.azH, adCard.buttonClick.azI, null);
                                }
                                if (!a.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int f = s.f(a.this.aRG, str);
                                        if ((f == 1 || f == 2) && a.this.fbq != null) {
                                            a.this.fbq.b(f, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.aRG.getPageActivity());
                                    aVar.dk(adCard.popWindowText);
                                    aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int f2 = s.f(a.this.aRG, str);
                                            if ((f2 == 1 || f2 == 2) && a.this.fbq != null) {
                                                a.this.fbq.b(f2, null);
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
                                    aVar.b(a.this.aRG).AU();
                                }
                            }
                        });
                    }
                } else {
                    this.gDC.setClickable(false);
                    this.gDC.setText(adCard.buttonTextDone);
                    aj.s(this.gDC, d.f.btn_rounded_corner_gray_frame);
                    aj.e(this.gDC, d.C0141d.cp_cont_d, 1);
                }
            }
            this.gDG.setVisibility(8);
        }
        a(adCard);
        p(com.baidu.tbadk.core.i.xo().xu(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            rP(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.aKG != null && advertAppInfo.aKG.aLb != null && advertAppInfo.aKG.aLb.support_close.intValue() > 0) {
            this.gDE.setVisibility(0);
            this.gDE.setPage(getBusinessType());
            this.gDE.setData(advertAppInfo);
            l.a(this.aRG.getPageActivity(), this.gDF, 40, 40, 40, 120);
            this.gDF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.gDE.performClick();
                }
            });
        } else {
            this.gDE.setVisibility(8);
            this.gDD.setOnClickListener(null);
        }
        this.gDM.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.cIg.getLayoutParams();
        if (4 == getBusinessType()) {
            this.gDM.setVisibility(8);
            this.gDM.setBarNameClickEnabled(false);
            this.gDM.setShareVisible(false);
            this.gDM.setShowPraiseNum(false);
            this.gDM.setCommentNumEnable(false);
            this.gDM.setReplyTimeVisible(false);
            layoutParams2.height = this.gDz;
            this.gDO.setVisibility(0);
            this.gDP.setVisibility(8);
        } else {
            a(adCard, view$OnClickListenerC0229a);
        }
        a(adCard, this.cWR, getBusinessType());
        this.gDN.setData(adCard.getAdvertAppInfo());
        this.gDN.getHeaderImg().setVisibility(0);
        this.gDN.getHeaderImg().startLoad(adCard.userPortrait, 10, false);
        this.gDN.getUserName().setOnClickListener(view$OnClickListenerC0229a);
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private void a(AdCard adCard, View$OnClickListenerC0229a view$OnClickListenerC0229a) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.gDP.setVisibility(0);
            this.gDM.setVisibility(8);
            return;
        }
        this.gDP.setVisibility(8);
        this.gDM.setVisibility(0);
        this.gDM.setBarNameClickEnabled(false);
        this.gDM.setReplyTimeVisible(false);
        this.gDM.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.gDM.setAgreeClickable(true);
            this.gDM.setPraiseContainerBgGray(false);
        } else {
            this.gDM.setAgreeClickable(false);
            this.gDM.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.gDM.setShareClickable(true);
            this.gDM.setShareContainerBgGray(false);
        } else {
            this.gDM.setShareClickable(false);
            this.gDM.setShareContainerBgGray(true);
        }
        this.gDM.getCommentContainer().setOnClickListener(view$OnClickListenerC0229a);
        this.gDM.setNeedAddReplyIcon(true);
        this.gDM.setCommentNumEnable(true);
        this.gDM.setCommentClickable(true);
        this.gDM.setReplayContainerBgGray(true);
        this.gDM.setOnClickListener(view$OnClickListenerC0229a);
        this.gDM.setShareData(adCard);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.e.b
    public void a(AdCard adCard, int i) {
        aj.s(this.cIg, d.C0141d.cp_bg_line_c);
        this.gDE.onChangeSkinType();
        this.gDN.onChangeSkinType();
        this.gDM.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            aj.s(this.mRootView, d.f.addresslist_item_bg);
            aj.t(this.cIg, d.C0141d.cp_bg_line_e);
            aj.t(this.cWR, d.C0141d.cp_bg_line_e);
        } else {
            aj.t(this.cIg, d.C0141d.cp_bg_line_c);
            aj.t(this.cWR, d.C0141d.transparent);
        }
        aj.e(this.gDB, d.C0141d.cp_cont_b, 1);
        aj.t(this.gDI, d.C0141d.cp_bg_line_e);
        aj.r(this.gDH, d.C0141d.cp_cont_j);
        aj.e(this.gDD, d.C0141d.cp_cont_d, 1);
        this.gDG.onChangeSkinType(i);
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
                if (this.fbq != null) {
                    this.fbq.b(bVar.azH, bVar.azI, null);
                    return;
                }
                return;
            }
            int f = s.f(this.aRG, rQ(bVar.scheme));
            if (f == 1 || f == 2) {
                if (this.fbq != null) {
                    this.fbq.b(f, null);
                }
            } else if (this.fbq != null) {
                this.fbq.b(bVar.azH, bVar.azI, null);
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
                        if (a.this.gDL.hasAnimation()) {
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
    public void a(TbImageView tbImageView, final AdCard.b bVar, View$OnClickListenerC0229a view$OnClickListenerC0229a) {
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
            tbImageView.setOnClickListener(view$OnClickListenerC0229a);
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
        this.eZS = new a.C0190a();
        this.eZS.picUrl = tbImageView.getUrl();
        this.eZS.rect = rect;
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
                    com.baidu.adp.lib.f.c.nm().a(jSONObject.optString("pic_url"), 17, null, this.fbx, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.fbx), this.aRG.getUniqueId(), new Object[0]);
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
                l.showToast(this.aRG.getPageActivity(), d.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.DH();
            this.mPermissionJudgePolicy.c(this.aRG.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.v(this.aRG.getPageActivity()) && this.fbr != null) {
                this.fbr.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.s(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!com.baidu.adp.lib.util.j.ox()) {
                l.showToast(this.aRG.getPageActivity(), d.j.neterror);
            } else if (advertAppInfo.xK()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.aRG.getString(d.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRG.getPageActivity());
                aVar.dk(str);
                aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.a(advertAppInfo, i, a.this.gDG);
                        if (a.this.gDG != null) {
                            a.this.gDG.s(a.this.c(advertAppInfo, i));
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
                aVar.b(this.aRG).AU();
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
                    a(advertAppInfo, i, this.gDG);
                    apkDownloadView.h(c);
                    return;
            }
            com.baidu.tieba.recapp.download.g.ao(this.aRG.getPageActivity(), advertAppInfo.aKz);
        }
    }

    public a.C0190a getAnimationInfo() {
        return this.eZS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.recapp.lego.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0229a implements View.OnClickListener {
        private AdCard gEb;

        public View$OnClickListenerC0229a(AdCard adCard) {
            this.gEb = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.adp.lib.util.j.ox()) {
                a.this.aRG.showToast(d.j.neterror);
            } else if (this.gEb != null) {
                AdvertAppInfo advertAppInfo = this.gEb.getAdvertAppInfo();
                boolean z = view == a.this.gDG;
                if (advertAppInfo != null && advertAppInfo.xK()) {
                    int h = com.baidu.adp.lib.g.b.h(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(a.this.c(advertAppInfo, h));
                    if ((6 == status || 7 == status) && com.baidu.adp.lib.util.j.oJ() && !com.baidu.adp.lib.util.j.oK()) {
                        a.this.showDownloadAppDialog(advertAppInfo, h, true, this.gEb.popWindowText);
                        return;
                    }
                    a.this.a(advertAppInfo, h, a.this.gDG, z);
                    if (a.this.fbq != null) {
                        a.this.fbq.b(3, null);
                        return;
                    }
                    return;
                }
                String scheme = this.gEb.getScheme();
                if (com.baidu.adp.lib.util.k.isEmpty(scheme) && advertAppInfo != null) {
                    scheme = advertAppInfo.aKx;
                }
                if (this.gEb.hasAnimation()) {
                }
                int f = s.f(a.this.aRG, a.this.rQ(scheme));
                if (a.this.fbq != null) {
                    a.this.fbq.b(f, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String rQ(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.eZS != null && this.eZS.isValid()) {
            String c0190a = this.eZS.toString();
            if (!TextUtils.isEmpty(c0190a)) {
                sb.append("&");
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append("=");
                sb.append(URLEncoder.encode(c0190a));
            }
        }
        if (!TextUtils.isEmpty(this.gDL.getPreLoadData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append("=");
            sb.append(URLEncoder.encode(this.gDL.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.gDL.getNextPageData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append("=");
            sb.append(URLEncoder.encode(this.gDL.getNextPageData()));
        }
        if (this.gDL.hasAnimation()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append("=");
            sb.append("1");
        }
        if (this.gDL.isGoLandingPage()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append("=");
            sb.append("1");
        }
        if (this.gDL.isImmersiveStyle()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append("=");
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    private static class b extends CustomMessageListener {
        private final WeakReference<a> gEc;

        public b(int i, a aVar) {
            super(i);
            this.gEc = new WeakReference<>(aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a aVar = this.gEc.get();
            if (aVar != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                s.f(aVar.aRG, aVar.gDQ.scheme);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.e.b, com.baidu.tieba.lego.card.e.k
    public void aQc() {
        if (4 == getBusinessType()) {
            this.gDB.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.gCW != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.gDQ = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.aRG.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.aRG, new CustomMessage<>(2002001, loginActivityConfig));
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
        DownloadData downloadData = new DownloadData(advertAppInfo.aKz);
        downloadData.setUrl(advertAppInfo.aKy);
        downloadData.setName(advertAppInfo.aKv);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.h(advertAppInfo.aKu, 0));
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
