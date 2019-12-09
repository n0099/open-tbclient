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
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.mvp.b;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.lego.card.b.a;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.download.e;
import com.baidu.tieba.recapp.download.h;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.recapp.view.AdThreadUserInfoLayout;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.tieba.tbadkCore.s;
import com.tencent.open.SocialConstants;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class AdCardBaseView extends BaseLegoCardView<AdCard> implements com.baidu.tieba.lego.card.b.a {
    private DownloadCacheKey dgW;
    private com.baidu.tieba.ad.download.a.d dgX;
    protected View eMN;
    protected View eMp;
    protected TextView gXD;
    private a.C0449a hdt;
    private final int hfd;
    protected ViewStub iIN;
    protected View iIO;
    protected View iIP;
    protected final int iIQ;
    protected final int iIR;
    protected final int iIS;
    protected final int iIT;
    protected final int iIU;
    protected final int iIV;
    protected final int iIW;
    protected final int iIX;
    private int iIY;
    private int iIZ;
    private int iJa;
    protected TextView iJb;
    protected TextView iJc;
    private AdCloseView iJd;
    private LinearLayout iJe;
    protected ApkDownloadView iJf;
    protected TextView iJg;
    protected RelativeLayout iJh;
    protected View iJi;
    protected String iJj;
    private AdCard iJk;
    private AdThreadCommentAndPraiseInfoLayout iJl;
    protected AdThreadUserInfoLayout iJm;
    protected View iJn;
    protected View iJo;
    protected AdCard.b iJp;
    protected CustomMessageListener iJq;
    protected CustomMessageListener iJr;
    protected CustomMessageListener iJs;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgePolicy;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void cM(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hfd = l.getEquipmentWidth(getContext());
        this.dgX = null;
        this.iJq = new a(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG, this);
        this.iJr = new d(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG, this);
        this.iJs = new c(CmdConfigCustom.CMD_USER_INFO_CHANGED, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.ds640);
        this.mImageHeight = (int) resources.getDimension(R.dimen.ds278);
        this.iIQ = (int) resources.getDimension(R.dimen.tbds92);
        this.iIR = (int) resources.getDimension(R.dimen.tbds92);
        this.iIS = (int) resources.getDimension(R.dimen.tbds20);
        this.iIV = (int) resources.getDimension(R.dimen.tbds90);
        this.iIW = (int) resources.getDimension(R.dimen.tbds90);
        this.iIX = (int) resources.getDimension(R.dimen.tbds22);
        this.iIT = (int) resources.getDimension(R.dimen.tbds44);
        this.iIU = (int) resources.getDimension(R.dimen.tbds44);
        this.iIY = (int) resources.getDimension(R.dimen.ds12);
        this.iIZ = (int) resources.getDimension(R.dimen.ds1);
        this.iJa = (int) resources.getDimension(R.dimen.ds18);
    }

    protected void s(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.iJl.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bIe() {
        MessageManager.getInstance().registerListener(this.iJq);
        MessageManager.getInstance().registerListener(this.iJr);
        MessageManager.getInstance().registerListener(this.iJs);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.eMN = this.mRootView.findViewById(R.id.bottom_line);
        this.iIP = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.iIP.setClickable(true);
        this.gXD = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.iJb = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.iJf = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.iJg = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.iJh = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.iJf.t(this.ceu.getUniqueId());
        this.iJq.setTag(this.ceu.getUniqueId());
        this.iJi = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.iJr.setTag(this.ceu.getUniqueId());
        this.iJs.setTag(this.ceu.getUniqueId());
        this.iJl = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.iJl.setStyle(1);
        this.iJm = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        if (1 == getBusinessType()) {
            this.iJm.setShowFlag(1413);
        }
        this.iJe = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.iJd = (AdCloseView) this.iJe.findViewById(R.id.ad_close_view);
        this.iJc = (TextView) this.iJe.findViewById(R.id.feed_tag);
        this.iJc.setVisibility(8);
        this.iJm.addAdTagView(this.iJe);
        this.eMp = this.mRootView.findViewById(R.id.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.iIT) - this.iIU) - this.iIQ) - this.iIS;
            this.iJl.setVisibility(8);
        } else {
            this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.iIT) - this.iIU;
            this.iJl.setVisibility(0);
        }
        this.iIN = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.iIN.setLayoutResource(getCustomLayout());
        this.iIO = this.iIN.inflate();
        this.iJn = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.iJo = this.mRootView.findViewById(R.id.frs_bottom_view);
        cM(this.iIO);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(final AdCard adCard) {
        final String str;
        this.iJk = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.iJm.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.aoW() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.ceu.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        a(adCard, bVar);
        this.iJb.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iJi.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.iIQ + this.iIS;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.iJm.getHeaderImg(), adCard.portraitClick, bVar);
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String CF = CF(aq.cutStringWithSuffix(str2, 100, StringHelper.STRING_MORE));
            if (4 == getBusinessType()) {
                this.gXD.setTextSize(0, getContext().getResources().getDimension(R.dimen.ds32));
            } else {
                this.gXD.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize44));
            }
            this.gXD.setText(CF);
            this.gXD.setVisibility(0);
        } else {
            this.gXD.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.agR()) && true == k.isEmpty(str3);
        a(this.iJh, this.iJb, this.iJf, adCard);
        if (advertAppInfo != null && advertAppInfo.agQ()) {
            this.iJg.setText(adCard.userName.concat("APP").concat(" · 广告").toString());
        } else if (advertAppInfo != null && advertAppInfo.agR()) {
            String str4 = adCard.tagName;
            if (TextUtils.isEmpty(str4)) {
                str4 = "广告";
            }
            this.iJg.setText(str4);
        }
        if (advertAppInfo != null && advertAppInfo.agQ()) {
            this.iJj = advertAppInfo.bWx;
            this.iJf.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.g.b.toInt(advertAppInfo.adPosition, -1));
            a(adCard, c2);
            a(this.iJb, c2.getStatus(), str3);
            this.iJf.setData(c2);
            this.iJf.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    am.setViewTextColor(this.iJb, R.color.btn_forum_focus_color, 1);
                    this.iJb.setText(str3);
                    if (k.isEmpty(str)) {
                        this.iJb.setClickable(false);
                    } else {
                        this.iJb.setClickable(true);
                        this.iJb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.heW != null && adCard.buttonClick != null && !s.DH(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.heW.b(adCard.buttonClick.Le, adCard.buttonClick.Lf, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int a2 = com.baidu.tieba.recapp.s.a(AdCardBaseView.this.ceu, str, (AdCardBaseView.this.iJk == null || AdCardBaseView.this.iJk.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.iJk.getAdvertAppInfo().bWt);
                                        if ((a2 == 1 || a2 == 2) && AdCardBaseView.this.heW != null) {
                                            AdCardBaseView.this.heW.b(a2, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.ceu.getPageActivity());
                                    aVar.nn(adCard.popWindowText);
                                    aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int a3 = com.baidu.tieba.recapp.s.a(AdCardBaseView.this.ceu, str, (AdCardBaseView.this.iJk == null || AdCardBaseView.this.iJk.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.iJk.getAdvertAppInfo().bWt);
                                            if ((a3 == 1 || a3 == 2) && AdCardBaseView.this.heW != null) {
                                                AdCardBaseView.this.heW.b(a3, null);
                                            }
                                            aVar2.dismiss();
                                        }
                                    });
                                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.2
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            aVar2.dismiss();
                                        }
                                    });
                                    aVar.b(AdCardBaseView.this.ceu).akM();
                                }
                            }
                        });
                    }
                } else {
                    this.iJb.setClickable(false);
                    this.iJb.setText(adCard.buttonTextDone);
                    am.setBackgroundResource(this.iJb, R.drawable.btn_rounded_corner_gray_frame);
                    am.setViewTextColor(this.iJb, R.color.cp_cont_d, 1);
                }
            }
            this.iJf.setVisibility(8);
        }
        a(adCard);
        s(i.ago().isShowImages(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            CG(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.bWD != null && advertAppInfo.bWD.adCloseInfo != null && advertAppInfo.bWD.adCloseInfo.support_close.intValue() > 0) {
            this.iJd.setVisibility(0);
            this.iJd.setPage(getBusinessType());
            this.iJd.setData(advertAppInfo);
            l.addToParentArea(this.ceu.getPageActivity(), this.iJe, 40, 40, 40, 120);
            this.iJe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.iJd.performClick();
                }
            });
        } else {
            this.iJd.setVisibility(8);
            this.iJc.setOnClickListener(null);
        }
        this.iJl.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.eMN.getLayoutParams();
        if (4 == getBusinessType()) {
            this.iJl.setVisibility(8);
            this.iJl.setBarNameClickEnabled(false);
            this.iJl.setShareVisible(false);
            this.iJl.setShowPraiseNum(false);
            this.iJl.setCommentNumEnable(false);
            this.iJl.setReplyTimeVisible(false);
            layoutParams2.height = this.iIZ;
            this.iJn.setVisibility(0);
            this.iJo.setVisibility(8);
        } else {
            b(adCard, bVar);
        }
        a(adCard, this.eMp, getBusinessType());
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 instanceof AdvertAppInfo) {
            advertAppInfo2.mW(aq.aR(adCard.time));
        }
        this.iJm.setData(advertAppInfo2);
        ((TextView) this.iJm.getUserName()).setText(adCard.userName);
        this.iJm.getUserName().setOnClickListener(bVar);
        this.iJm.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.iJm.getUserName()).setText(adCard.userName);
            }
        });
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.biU().biV()) {
            this.iIP.setVisibility(0);
            am.setBackgroundColor(this.iIP, R.color.cp_bg_line_d);
        } else {
            this.iIP.setVisibility(8);
        }
        a(adCard, advertAppInfo);
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aDA();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aDB();
    }

    private void a(AdCard adCard, DownloadData downloadData) {
        if (adCard.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.iJf.getDownloadStatus());
        }
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.directDownload) {
            this.iJf.setOnClickListener(bVar);
        } else {
            this.iJf.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public void bo(View view) {
                    AdCardBaseView.this.cgc();
                }
            });
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey ru;
        if (!adCard.directDownload && advertAppInfo != null && advertAppInfo.agQ()) {
            String scheme = adCard.getScheme();
            String str = advertAppInfo.bWt;
            if (!TextUtils.isEmpty(str)) {
                ru = com.baidu.tieba.ad.download.d.aDG().rt(str);
            } else {
                ru = com.baidu.tieba.ad.download.d.aDG().ru(scheme);
            }
            if (ru == null) {
                ru = DownloadCacheKey.create(str, advertAppInfo.bWw, advertAppInfo.bWx);
                com.baidu.tieba.ad.download.d.aDG().a(ru, null);
            }
            i(ru);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.dgW = downloadCacheKey;
            aDB();
            this.dgX = null;
            AdDownloadData d2 = com.baidu.tieba.ad.download.d.aDG().d(downloadCacheKey);
            if (d2 != null) {
                this.iJf.a(d2.getCurrentState());
            } else {
                this.iJf.a(DownloadStatus.STATUS_NONE);
            }
            String str = "";
            if (this.iJk != null && this.iJk.getAdvertAppInfo() != null) {
                str = this.iJk.getAdvertAppInfo().page;
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.iJf, d2, str);
            this.dgX = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d2.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d2);
            }
            aDA();
        }
    }

    private void aDA() {
        if (this.dgW != null && this.dgX != null) {
            com.baidu.tieba.ad.download.d.aDG().a(this.dgW, this.dgX);
        }
    }

    private void aDB() {
        if (this.dgW != null && this.dgX != null) {
            com.baidu.tieba.ad.download.d.aDG().b(this.dgW, this.dgX);
        }
    }

    private boolean isInFrsAllThread() {
        return this.hdX == 1;
    }

    private void b(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.iJo.setVisibility(0);
            this.iJl.setVisibility(8);
            return;
        }
        this.iJo.setVisibility(8);
        this.iJl.setVisibility(0);
        this.iJl.setBarNameClickEnabled(false);
        this.iJl.setReplyTimeVisible(false);
        this.iJl.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.iJl.setAgreeClickable(true);
            this.iJl.setPraiseContainerBgGray(false);
        } else {
            this.iJl.setAgreeClickable(false);
            this.iJl.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.iJl.setShareClickable(true);
            this.iJl.setShareContainerBgGray(false);
        } else {
            this.iJl.setShareClickable(false);
            this.iJl.setShareContainerBgGray(true);
        }
        if (this.iJl.getCommentContainer() != null) {
            this.iJl.getCommentContainer().setOnClickListener(bVar);
        }
        this.iJl.setNeedAddReplyIcon(true);
        this.iJl.setCommentNumEnable(false);
        this.iJl.setCommentClickable(true);
        this.iJl.setReplayContainerBgGray(true);
        this.iJl.setOnClickListener(bVar);
        this.iJl.setShareData(adCard);
        this.iJl.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        am.setBackgroundResource(this.eMN, R.color.cp_bg_line_c);
        this.iJd.onChangeSkinType();
        this.iJm.onChangeSkinType(this.ceu, TbadkCoreApplication.getInst().getSkinType());
        this.iJl.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.eMN, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.eMp, R.color.cp_bg_line_e);
        } else {
            am.setBackgroundColor(this.eMN, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.eMp, R.color.transparent);
        }
        am.setViewTextColor(this.gXD, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.iJg, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.iJc, R.color.cp_cont_d, 1);
        this.iJf.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String CF(String str) {
        if (!StringUtils.isNull(str)) {
            String replaceAll = str.replaceAll("，", "， ").replaceAll("。", "。 ").replaceAll("？", "？ ").replaceAll("！", "！ ").replaceAll("、", "、 ").replaceAll("‘", "’ ").replaceAll("“", "” ").replaceAll("【", "【 ").replaceAll("】", "】 ").replaceAll("；", "； ").replaceAll("：", "： ").replaceAll("（", "（ ").replaceAll("）", "） ").replaceAll("·", "· ").replaceAll(HanziToPinyin.Token.SEPARATOR, "  ");
            if (replaceAll.charAt(replaceAll.length() - 1) == ' ') {
                replaceAll = replaceAll.substring(0, replaceAll.length() - 1);
            }
            return replaceAll;
        }
        return str;
    }

    protected void a(AdCard.b bVar) {
        int a2;
        if (bVar != null) {
            if (b(bVar) && !s.DH(bVar.scheme)) {
                if (this.heW != null) {
                    this.heW.b(bVar.Le, bVar.Lf, null);
                }
            } else if (this.iJk != null && this.iJk.getAdvertAppInfo() != null) {
                String CH = CH(bVar.scheme);
                String str = this.iJk.getAdvertAppInfo().bWt;
                if (!this.iJk.directDownload && this.iJk.getAdvertAppInfo().agQ()) {
                    a2 = com.baidu.tieba.recapp.s.b(this.ceu, CH, str);
                } else {
                    a2 = com.baidu.tieba.recapp.s.a(this.ceu, CH, str);
                }
                if (a2 == 1 || a2 == 2) {
                    if (this.heW != null) {
                        this.heW.b(a2, null);
                    }
                } else if (this.heW != null) {
                    this.heW.b(bVar.Le, bVar.Lf, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final TbImageView tbImageView, final AdCard.b bVar) {
        if (tbImageView != null) {
            if (bVar != null && !k.isEmpty(bVar.scheme)) {
                tbImageView.setClickable(true);
                tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (AdCardBaseView.this.iJk.hasAnimation()) {
                            AdCardBaseView.this.i(tbImageView);
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
    public void a(View view, final AdCard.b bVar, b bVar2) {
        if (view != null) {
            if (bVar != null && !k.isEmpty(bVar.scheme)) {
                view.setClickable(true);
                view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        AdCardBaseView.this.a(bVar);
                    }
                });
                return;
            }
            view.setClickable(true);
            view.setOnClickListener(bVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(TbImageView tbImageView) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        tbImageView.getLocationOnScreen(iArr);
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + tbImageView.getWidth();
        rect.bottom = rect.top + tbImageView.getHeight();
        this.hdt = new a.C0449a();
        this.hdt.picUrl = tbImageView.getUrl();
        this.hdt.aoK = rect;
    }

    private void CG(String str) {
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
                    com.baidu.adp.lib.f.c.fT().a(jSONObject.optString("pic_url"), 17, null, this.hfd, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.hfd), this.ceu.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.agP() != 0) {
                l.showToast(this.ceu.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.c.a();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.ceu.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.ceu.getPageActivity()) && this.heX != null) {
                this.heX.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.ceu.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.agQ()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.ceu.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ceu.getPageActivity());
                aVar.nn(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.iJf);
                        if (AdCardBaseView.this.iJf != null) {
                            AdCardBaseView.this.iJf.q(AdCardBaseView.this.c(advertAppInfo, i));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.9
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.ceu).akM();
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
                        h.f(advertAppInfo);
                        apkDownloadView.r(c2);
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
                    a(advertAppInfo, i, this.iJf);
                    apkDownloadView.s(c2);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.aDG().au(this.ceu.getPageActivity(), advertAppInfo.bWx);
                    return;
            }
            h.aK(this.ceu.getPageActivity(), advertAppInfo.bWx);
        }
    }

    public a.C0449a getAnimationInfo() {
        return this.hdt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private AdCard iJC;

        public b(AdCard adCard) {
            this.iJC = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdCardBaseView.this.ceu.showToast(R.string.neterror);
            } else if (this.iJC != null) {
                AdvertAppInfo advertAppInfo = this.iJC.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.iJf;
                if (advertAppInfo != null && advertAppInfo.agQ()) {
                    a(advertAppInfo, z);
                } else {
                    j(advertAppInfo);
                }
            }
        }

        private void a(AdvertAppInfo advertAppInfo, boolean z) {
            if (this.iJC.directDownload || z) {
                b(advertAppInfo, z);
            } else {
                k(advertAppInfo);
            }
        }

        private void j(AdvertAppInfo advertAppInfo) {
            String scheme = this.iJC.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.bWv;
            }
            if (this.iJC.hasAnimation()) {
            }
            int e = com.baidu.tieba.recapp.s.e(AdCardBaseView.this.ceu, AdCardBaseView.this.CH(scheme));
            if (AdCardBaseView.this.heW != null) {
                AdCardBaseView.this.heW.b(e, null);
            }
        }

        private void b(AdvertAppInfo advertAppInfo, boolean z) {
            int i = com.baidu.adp.lib.g.b.toInt(advertAppInfo.adPosition, -1);
            int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, i));
            if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                return;
            }
            AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.iJf, z);
            AdCardBaseView.this.cgc();
        }

        private void k(AdvertAppInfo advertAppInfo) {
            String scheme = this.iJC.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.bWv;
            }
            int b = com.baidu.tieba.recapp.s.b(AdCardBaseView.this.ceu, scheme, advertAppInfo.bWt);
            if (AdCardBaseView.this.heW != null) {
                AdCardBaseView.this.heW.b(b, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cgc() {
        if (this.heW != null) {
            this.heW.b(3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String CH(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.hdt != null && this.hdt.isValid()) {
            String c0449a = this.hdt.toString();
            if (!TextUtils.isEmpty(c0449a)) {
                sb.append("&");
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append("=");
                sb.append(URLEncoder.encode(c0449a));
            }
        }
        if (!TextUtils.isEmpty(this.iJk.getPreLoadData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append("=");
            sb.append(URLEncoder.encode(this.iJk.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.iJk.getNextPageData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append("=");
            sb.append(URLEncoder.encode(this.iJk.getNextPageData()));
        }
        if (this.iJk.hasAnimation()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append("=");
            sb.append("1");
        }
        if (this.iJk.isGoLandingPage()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append("=");
            sb.append("1");
        }
        if (this.iJk.isImmersiveStyle()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append("=");
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> iJB;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.iJB = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.iJB.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.iJj) ? false : true)) && adCardBaseView.iJj.equals(downloadData.getId())) {
                    int status = e.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.iJb.setText(R.string.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.iJb.setText(R.string.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> iJB;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.iJB = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.iJB.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.iJj) && adCardBaseView.iJj.equals(downloadData.getId())) {
                adCardBaseView.iJf.t(downloadData);
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> iJB;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.iJB = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.iJB.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                String str = null;
                if (adCardBaseView.iJk != null && adCardBaseView.iJk.getAdvertAppInfo() != null) {
                    str = adCardBaseView.iJk.getAdvertAppInfo().bWt;
                }
                com.baidu.tieba.recapp.s.a(adCardBaseView.ceu, adCardBaseView.iJp.scheme, str);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void bIl() {
        if (4 == getBusinessType()) {
            this.gXD.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.iIx != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.iJp = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.ceu.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.ceu, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        return true;
    }

    private void a(View view, TextView textView, ApkDownloadView apkDownloadView, AdCard adCard) {
        if (adCard == null) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        if (adCard.getAdvertAppInfo().agQ()) {
            textView.setVisibility(8);
            apkDownloadView.setVisibility(0);
        } else if (true == k.isEmpty(adCard.buttonText) || "立即查看".equals(adCard.buttonText)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bWx);
        downloadData.setUrl(advertAppInfo.bWw);
        downloadData.setName(advertAppInfo.bWu);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.toInt(advertAppInfo.bWt, 0));
        return downloadData;
    }

    protected void a(TextView textView, int i, String str) {
        switch (i) {
            case 1:
            case 5:
                textView.setText(R.string.pause_load);
                return;
            case 2:
            case 4:
            default:
                return;
            case 3:
                textView.setText(R.string.downloaded_install);
                return;
            case 6:
                textView.setText(R.string.install_app);
                return;
            case 7:
                textView.setText(R.string.pb_download_pause);
                return;
            case 8:
                textView.setText(R.string.immediately_open);
                return;
        }
    }
}
