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
import com.baidu.tieba.tbadkCore.r;
import com.tencent.open.SocialConstants;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class a extends com.baidu.tieba.lego.card.e.b<AdCard> implements com.baidu.tieba.lego.card.b.a {
    protected View cIj;
    protected View cWU;
    private a.C0190a fag;
    private final int fbL;
    protected ViewStub gDE;
    protected View gDF;
    protected final int gDG;
    protected final int gDH;
    protected final int gDI;
    protected final int gDJ;
    protected final int gDK;
    protected final int gDL;
    protected final int gDM;
    protected final int gDN;
    private int gDO;
    private int gDP;
    private int gDQ;
    protected TextView gDR;
    protected TextView gDS;
    protected TextView gDT;
    private AdCloseView gDU;
    private LinearLayout gDV;
    protected ApkDownloadView gDW;
    protected TextView gDX;
    protected RelativeLayout gDY;
    protected View gDZ;
    protected String gEa;
    private AdCard gEb;
    private AdThreadCommentAndPraiseInfoLayout gEc;
    protected ThreadUserInfoLayout gEd;
    protected View gEe;
    protected View gEf;
    protected AdCard.b gEg;
    protected CustomMessageListener gEh;
    protected CustomMessageListener gEi;
    protected CustomMessageListener gEj;
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
        this.fbL = l.ao(getContext());
        this.gEh = new CustomMessageListener(2016484) { // from class: com.baidu.tieba.recapp.lego.view.a.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                    if (((downloadData != null) & (TextUtils.isEmpty(a.this.gEa) ? false : true)) && a.this.gEa.equals(downloadData.getId())) {
                        int status = com.baidu.tieba.recapp.download.d.getStatus(downloadData);
                        if (status == 7) {
                            a.this.gDS.setText(d.j.pause_load);
                        } else if (status == 1 || status == 2) {
                            a.this.gDS.setText(d.j.pb_download_pause);
                        }
                    }
                }
            }
        };
        this.gEi = new CustomMessageListener(2016483) { // from class: com.baidu.tieba.recapp.lego.view.a.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DownloadData downloadData;
                if (customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(a.this.gEa) && a.this.gEa.equals(downloadData.getId())) {
                    a.this.gDW.u(downloadData);
                }
            }
        };
        this.gEj = new b(2016494, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(d.e.ds640);
        this.mImageHeight = (int) resources.getDimension(d.e.ds278);
        this.gDG = (int) resources.getDimension(d.e.tbds92);
        this.gDH = (int) resources.getDimension(d.e.tbds92);
        this.gDI = (int) resources.getDimension(d.e.tbds20);
        this.gDL = (int) resources.getDimension(d.e.tbds90);
        this.gDM = (int) resources.getDimension(d.e.tbds90);
        this.gDN = (int) resources.getDimension(d.e.tbds22);
        this.gDJ = (int) resources.getDimension(d.e.tbds44);
        this.gDK = (int) resources.getDimension(d.e.tbds44);
        this.gDO = (int) resources.getDimension(d.e.ds12);
        this.gDP = (int) resources.getDimension(d.e.ds1);
        this.gDQ = (int) resources.getDimension(d.e.ds18);
    }

    protected void p(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.gEc.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.e.b
    protected View aPT() {
        MessageManager.getInstance().registerListener(this.gEh);
        MessageManager.getInstance().registerListener(this.gEi);
        MessageManager.getInstance().registerListener(this.gEj);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.cIj = this.mRootView.findViewById(d.g.bottom_line);
        this.gDR = (TextView) this.mRootView.findViewById(d.g.ad_title);
        this.gDS = (TextView) this.mRootView.findViewById(d.g.transform_btn);
        this.gDW = (ApkDownloadView) this.mRootView.findViewById(d.g.advert_app_download_view);
        this.gDX = (TextView) this.mRootView.findViewById(d.g.advert_app_name);
        this.gDY = (RelativeLayout) this.mRootView.findViewById(d.g.bottom_transformation_area);
        this.gDW.p(this.aRI.getUniqueId());
        this.gEh.setTag(this.aRI.getUniqueId());
        this.gDZ = this.mRootView.findViewById(d.g.card_ad_middle_container);
        this.gEi.setTag(this.aRI.getUniqueId());
        this.gEj.setTag(this.aRI.getUniqueId());
        this.gEc = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.gEc.setStyle(1);
        this.gEd = (ThreadUserInfoLayout) this.mRootView.findViewById(d.g.card_ad_user_info_layout);
        this.gDV = (LinearLayout) LayoutInflater.from(getContext()).inflate(d.h.ad_post_tag_close, (ViewGroup) null);
        this.gDU = (AdCloseView) this.gDV.findViewById(d.g.ad_close_view);
        this.gDT = (TextView) this.gDV.findViewById(d.g.feed_tag);
        this.gEd.addView(this.gDV);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gDV.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.aRI.getResources().getDimensionPixelOffset(d.e.ds8);
        this.gDV.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        this.gDV.setLayoutParams(layoutParams);
        this.gEd.getHeaderImg().setDefaultErrorResource(d.f.icon_default_avatar100);
        this.gEd.getHeaderImg().setDefaultResource(d.f.icon_default_avatar100);
        this.gEd.getHeaderImg().setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.cWU = this.mRootView.findViewById(d.g.divider_line_above_praise);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gEd.getHeaderImg().getLayoutParams();
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.ao(getContext()) - this.gDJ) - this.gDK) - this.gDG) - this.gDI;
            this.gEc.setVisibility(8);
        } else {
            this.mMaxWidth = (l.ao(getContext()) - this.gDJ) - this.gDK;
            this.gEc.setVisibility(0);
        }
        this.gDE = (ViewStub) this.mRootView.findViewById(d.g.ad_custom_view_stub);
        this.gDE.setLayoutResource(getCustomLayout());
        this.gDF = this.gDE.inflate();
        this.gEe = this.mRootView.findViewById(d.g.pb_bottom_view);
        this.gEf = this.mRootView.findViewById(d.g.frs_bottom_view);
        cL(this.gDF);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.e.b
    /* renamed from: b */
    public void e(final AdCard adCard) {
        final String str;
        this.gEb = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        View$OnClickListenerC0229a view$OnClickListenerC0229a = new View$OnClickListenerC0229a(adCard);
        this.mRootView.setOnClickListener(view$OnClickListenerC0229a);
        this.gEd.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.Fy() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.aE(advertAppInfo.xM());
                ((Vibrator) a.this.aRI.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.gDW.setOnClickListener(view$OnClickListenerC0229a);
        this.gDS.setOnClickListener(view$OnClickListenerC0229a);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gDZ.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.gDG + this.gDI;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.gEd.getHeaderImg(), adCard.portraitClick, view$OnClickListenerC0229a);
        if (!TextUtils.isEmpty(adCard.tagName)) {
            this.gDT.setText(adCard.tagName);
        } else {
            this.gDT.setText("广告");
        }
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String rO = rO(am.d(str2, 100, "..."));
            if (4 == getBusinessType()) {
                this.gDR.setTextSize(0, getContext().getResources().getDimension(d.e.ds32));
            } else {
                this.gDR.setTextSize(0, getContext().getResources().getDimension(d.e.tbfontsize48));
            }
            this.gDR.setText(rO);
            this.gDR.setVisibility(0);
        } else {
            this.gDR.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar = adCard.buttonClick;
        if (bVar == null) {
            str = "";
        } else {
            str = bVar.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.xL()) && true == com.baidu.adp.lib.util.k.isEmpty(str3);
        a(this.gDY, this.gDS, this.gDW, adCard);
        if (!z && !TextUtils.isEmpty(adCard.userName)) {
            if (advertAppInfo != null && advertAppInfo.xK()) {
                this.gDX.setText(adCard.userName.concat("App").toString());
            } else if (advertAppInfo != null && advertAppInfo.xL()) {
                this.gDX.setText(adCard.userName);
            }
        }
        if (advertAppInfo != null && advertAppInfo.xK()) {
            this.gEa = advertAppInfo.aKA;
            this.gDW.setClickable(true);
            DownloadData c = c(advertAppInfo, com.baidu.adp.lib.g.b.h(advertAppInfo.adPosition, -1));
            c.setStatus(ApkDownloadView.getStatus(c));
            a(this.gDS, c.getStatus(), str3);
            this.gDW.setData(c);
            this.gDW.setVisibility(0);
        } else {
            if (!z && !com.baidu.adp.lib.util.k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    aj.e(this.gDS, d.C0141d.btn_forum_focus_color, 1);
                    this.gDS.setText(str3);
                    if (com.baidu.adp.lib.util.k.isEmpty(str)) {
                        this.gDS.setClickable(false);
                    } else {
                        this.gDS.setClickable(true);
                        this.gDS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (a.this.fbE != null && adCard.buttonClick != null && !r.sG(adCard.buttonClick.scheme)) {
                                    a.this.fbE.b(adCard.buttonClick.azI, adCard.buttonClick.azJ, null);
                                }
                                if (!a.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int f = s.f(a.this.aRI, str);
                                        if ((f == 1 || f == 2) && a.this.fbE != null) {
                                            a.this.fbE.b(f, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.aRI.getPageActivity());
                                    aVar.dk(adCard.popWindowText);
                                    aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int f2 = s.f(a.this.aRI, str);
                                            if ((f2 == 1 || f2 == 2) && a.this.fbE != null) {
                                                a.this.fbE.b(f2, null);
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
                                    aVar.b(a.this.aRI).AV();
                                }
                            }
                        });
                    }
                } else {
                    this.gDS.setClickable(false);
                    this.gDS.setText(adCard.buttonTextDone);
                    aj.s(this.gDS, d.f.btn_rounded_corner_gray_frame);
                    aj.e(this.gDS, d.C0141d.cp_cont_d, 1);
                }
            }
            this.gDW.setVisibility(8);
        }
        a(adCard);
        p(com.baidu.tbadk.core.i.xo().xu(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            rP(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.aKH != null && advertAppInfo.aKH.aLc != null && advertAppInfo.aKH.aLc.support_close.intValue() > 0) {
            this.gDU.setVisibility(0);
            this.gDU.setPage(getBusinessType());
            this.gDU.setData(advertAppInfo);
            l.a(this.aRI.getPageActivity(), this.gDV, 40, 40, 40, 120);
            this.gDV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.gDU.performClick();
                }
            });
        } else {
            this.gDU.setVisibility(8);
            this.gDT.setOnClickListener(null);
        }
        this.gEc.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.cIj.getLayoutParams();
        if (4 == getBusinessType()) {
            this.gEc.setVisibility(8);
            this.gEc.setBarNameClickEnabled(false);
            this.gEc.setShareVisible(false);
            this.gEc.setShowPraiseNum(false);
            this.gEc.setCommentNumEnable(false);
            this.gEc.setReplyTimeVisible(false);
            layoutParams2.height = this.gDP;
            this.gEe.setVisibility(0);
            this.gEf.setVisibility(8);
        } else {
            a(adCard, view$OnClickListenerC0229a);
        }
        a(adCard, this.cWU, getBusinessType());
        this.gEd.setData(adCard.getAdvertAppInfo());
        this.gEd.getHeaderImg().setVisibility(0);
        this.gEd.getHeaderImg().startLoad(adCard.userPortrait, 10, false);
        this.gEd.getUserName().setOnClickListener(view$OnClickListenerC0229a);
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private void a(AdCard adCard, View$OnClickListenerC0229a view$OnClickListenerC0229a) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.gEf.setVisibility(0);
            this.gEc.setVisibility(8);
            return;
        }
        this.gEf.setVisibility(8);
        this.gEc.setVisibility(0);
        this.gEc.setBarNameClickEnabled(false);
        this.gEc.setReplyTimeVisible(false);
        this.gEc.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.gEc.setAgreeClickable(true);
            this.gEc.setPraiseContainerBgGray(false);
        } else {
            this.gEc.setAgreeClickable(false);
            this.gEc.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.gEc.setShareClickable(true);
            this.gEc.setShareContainerBgGray(false);
        } else {
            this.gEc.setShareClickable(false);
            this.gEc.setShareContainerBgGray(true);
        }
        this.gEc.getCommentContainer().setOnClickListener(view$OnClickListenerC0229a);
        this.gEc.setNeedAddReplyIcon(true);
        this.gEc.setCommentNumEnable(true);
        this.gEc.setCommentClickable(true);
        this.gEc.setReplayContainerBgGray(true);
        this.gEc.setOnClickListener(view$OnClickListenerC0229a);
        this.gEc.setShareData(adCard);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.e.b
    public void a(AdCard adCard, int i) {
        aj.s(this.cIj, d.C0141d.cp_bg_line_c);
        this.gDU.onChangeSkinType();
        this.gEd.onChangeSkinType();
        this.gEc.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            aj.s(this.mRootView, d.f.addresslist_item_bg);
            aj.t(this.cIj, d.C0141d.cp_bg_line_e);
            aj.t(this.cWU, d.C0141d.cp_bg_line_e);
        } else {
            aj.t(this.cIj, d.C0141d.cp_bg_line_c);
            aj.t(this.cWU, d.C0141d.transparent);
        }
        aj.e(this.gDR, d.C0141d.cp_cont_b, 1);
        aj.t(this.gDY, d.C0141d.cp_bg_line_e);
        aj.r(this.gDX, d.C0141d.cp_cont_j);
        aj.e(this.gDT, d.C0141d.cp_cont_d, 1);
        this.gDW.onChangeSkinType(i);
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
            if (b(bVar) && !r.sG(bVar.scheme)) {
                if (this.fbE != null) {
                    this.fbE.b(bVar.azI, bVar.azJ, null);
                    return;
                }
                return;
            }
            int f = s.f(this.aRI, rQ(bVar.scheme));
            if (f == 1 || f == 2) {
                if (this.fbE != null) {
                    this.fbE.b(f, null);
                }
            } else if (this.fbE != null) {
                this.fbE.b(bVar.azI, bVar.azJ, null);
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
                        if (a.this.gEb.hasAnimation()) {
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
        this.fag = new a.C0190a();
        this.fag.picUrl = tbImageView.getUrl();
        this.fag.rect = rect;
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
                    com.baidu.adp.lib.f.c.nm().a(jSONObject.optString("pic_url"), 17, null, this.fbL, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.fbL), this.aRI.getUniqueId(), new Object[0]);
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
                l.showToast(this.aRI.getPageActivity(), d.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.DI();
            this.mPermissionJudgePolicy.c(this.aRI.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.v(this.aRI.getPageActivity()) && this.fbF != null) {
                this.fbF.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.s(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!com.baidu.adp.lib.util.j.ox()) {
                l.showToast(this.aRI.getPageActivity(), d.j.neterror);
            } else if (advertAppInfo.xK()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.aRI.getString(d.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRI.getPageActivity());
                aVar.dk(str);
                aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.a.6
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        a.this.a(advertAppInfo, i, a.this.gDW);
                        if (a.this.gDW != null) {
                            a.this.gDW.s(a.this.c(advertAppInfo, i));
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
                aVar.b(this.aRI).AV();
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
                    a(advertAppInfo, i, this.gDW);
                    apkDownloadView.h(c);
                    return;
            }
            com.baidu.tieba.recapp.download.g.ao(this.aRI.getPageActivity(), advertAppInfo.aKA);
        }
    }

    public a.C0190a getAnimationInfo() {
        return this.fag;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.recapp.lego.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0229a implements View.OnClickListener {
        private AdCard gEr;

        public View$OnClickListenerC0229a(AdCard adCard) {
            this.gEr = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.adp.lib.util.j.ox()) {
                a.this.aRI.showToast(d.j.neterror);
            } else if (this.gEr != null) {
                AdvertAppInfo advertAppInfo = this.gEr.getAdvertAppInfo();
                boolean z = view == a.this.gDW;
                if (advertAppInfo != null && advertAppInfo.xK()) {
                    int h = com.baidu.adp.lib.g.b.h(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(a.this.c(advertAppInfo, h));
                    if ((6 == status || 7 == status) && com.baidu.adp.lib.util.j.oJ() && !com.baidu.adp.lib.util.j.oK()) {
                        a.this.showDownloadAppDialog(advertAppInfo, h, true, this.gEr.popWindowText);
                        return;
                    }
                    a.this.a(advertAppInfo, h, a.this.gDW, z);
                    if (a.this.fbE != null) {
                        a.this.fbE.b(3, null);
                        return;
                    }
                    return;
                }
                String scheme = this.gEr.getScheme();
                if (com.baidu.adp.lib.util.k.isEmpty(scheme) && advertAppInfo != null) {
                    scheme = advertAppInfo.aKy;
                }
                if (this.gEr.hasAnimation()) {
                }
                int f = s.f(a.this.aRI, a.this.rQ(scheme));
                if (a.this.fbE != null) {
                    a.this.fbE.b(f, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String rQ(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.fag != null && this.fag.isValid()) {
            String c0190a = this.fag.toString();
            if (!TextUtils.isEmpty(c0190a)) {
                sb.append("&");
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append("=");
                sb.append(URLEncoder.encode(c0190a));
            }
        }
        if (!TextUtils.isEmpty(this.gEb.getPreLoadData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append("=");
            sb.append(URLEncoder.encode(this.gEb.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.gEb.getNextPageData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append("=");
            sb.append(URLEncoder.encode(this.gEb.getNextPageData()));
        }
        if (this.gEb.hasAnimation()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append("=");
            sb.append("1");
        }
        if (this.gEb.isGoLandingPage()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append("=");
            sb.append("1");
        }
        if (this.gEb.isImmersiveStyle()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append("=");
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    private static class b extends CustomMessageListener {
        private final WeakReference<a> gEs;

        public b(int i, a aVar) {
            super(i);
            this.gEs = new WeakReference<>(aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a aVar = this.gEs.get();
            if (aVar != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                s.f(aVar.aRI, aVar.gEg.scheme);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.e.b, com.baidu.tieba.lego.card.e.k
    public void aQd() {
        if (4 == getBusinessType()) {
            this.gDR.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.gDm != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.gEg = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.aRI.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.aRI, new CustomMessage<>(2002001, loginActivityConfig));
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
        DownloadData downloadData = new DownloadData(advertAppInfo.aKA);
        downloadData.setUrl(advertAppInfo.aKz);
        downloadData.setName(advertAppInfo.aKw);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.h(advertAppInfo.aKv, 0));
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
