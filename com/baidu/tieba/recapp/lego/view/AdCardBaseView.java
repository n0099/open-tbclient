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
    private DownloadCacheKey dhN;
    private com.baidu.tieba.ad.download.a.d dhO;
    protected View eNE;
    protected View eNg;
    protected TextView gYu;
    private a.C0454a hek;
    private final int hfU;
    protected ViewStub iJE;
    protected View iJF;
    protected View iJG;
    protected final int iJH;
    protected final int iJI;
    protected final int iJJ;
    protected final int iJK;
    protected final int iJL;
    protected final int iJM;
    protected final int iJN;
    protected final int iJO;
    private int iJP;
    private int iJQ;
    private int iJR;
    protected TextView iJS;
    protected TextView iJT;
    private AdCloseView iJU;
    private LinearLayout iJV;
    protected ApkDownloadView iJW;
    protected TextView iJX;
    protected RelativeLayout iJY;
    protected View iJZ;
    protected String iKa;
    private AdCard iKb;
    private AdThreadCommentAndPraiseInfoLayout iKc;
    protected AdThreadUserInfoLayout iKd;
    protected View iKe;
    protected View iKf;
    protected AdCard.b iKg;
    protected CustomMessageListener iKh;
    protected CustomMessageListener iKi;
    protected CustomMessageListener iKj;
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
        this.hfU = l.getEquipmentWidth(getContext());
        this.dhO = null;
        this.iKh = new a(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG, this);
        this.iKi = new d(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG, this);
        this.iKj = new c(CmdConfigCustom.CMD_USER_INFO_CHANGED, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.ds640);
        this.mImageHeight = (int) resources.getDimension(R.dimen.ds278);
        this.iJH = (int) resources.getDimension(R.dimen.tbds92);
        this.iJI = (int) resources.getDimension(R.dimen.tbds92);
        this.iJJ = (int) resources.getDimension(R.dimen.tbds20);
        this.iJM = (int) resources.getDimension(R.dimen.tbds90);
        this.iJN = (int) resources.getDimension(R.dimen.tbds90);
        this.iJO = (int) resources.getDimension(R.dimen.tbds22);
        this.iJK = (int) resources.getDimension(R.dimen.tbds44);
        this.iJL = (int) resources.getDimension(R.dimen.tbds44);
        this.iJP = (int) resources.getDimension(R.dimen.ds12);
        this.iJQ = (int) resources.getDimension(R.dimen.ds1);
        this.iJR = (int) resources.getDimension(R.dimen.ds18);
    }

    protected void s(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.iKc.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bIg() {
        MessageManager.getInstance().registerListener(this.iKh);
        MessageManager.getInstance().registerListener(this.iKi);
        MessageManager.getInstance().registerListener(this.iKj);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.eNE = this.mRootView.findViewById(R.id.bottom_line);
        this.iJG = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.iJG.setClickable(true);
        this.gYu = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.iJS = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.iJW = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.iJX = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.iJY = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.iJW.t(this.cfl.getUniqueId());
        this.iKh.setTag(this.cfl.getUniqueId());
        this.iJZ = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.iKi.setTag(this.cfl.getUniqueId());
        this.iKj.setTag(this.cfl.getUniqueId());
        this.iKc = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.iKc.setStyle(1);
        this.iKd = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        if (1 == getBusinessType()) {
            this.iKd.setShowFlag(1413);
        }
        this.iJV = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.iJU = (AdCloseView) this.iJV.findViewById(R.id.ad_close_view);
        this.iJT = (TextView) this.iJV.findViewById(R.id.feed_tag);
        this.iJT.setVisibility(8);
        this.iKd.addAdTagView(this.iJV);
        this.eNg = this.mRootView.findViewById(R.id.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.iJK) - this.iJL) - this.iJH) - this.iJJ;
            this.iKc.setVisibility(8);
        } else {
            this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.iJK) - this.iJL;
            this.iKc.setVisibility(0);
        }
        this.iJE = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.iJE.setLayoutResource(getCustomLayout());
        this.iJF = this.iJE.inflate();
        this.iKe = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.iKf = this.mRootView.findViewById(R.id.frs_bottom_view);
        cM(this.iJF);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(final AdCard adCard) {
        final String str;
        this.iKb = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.iKd.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.aoY() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.cfl.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        a(adCard, bVar);
        this.iJS.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iJZ.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.iJH + this.iJJ;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.iKd.getHeaderImg(), adCard.portraitClick, bVar);
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String CF = CF(aq.cutStringWithSuffix(str2, 100, StringHelper.STRING_MORE));
            if (4 == getBusinessType()) {
                this.gYu.setTextSize(0, getContext().getResources().getDimension(R.dimen.ds32));
            } else {
                this.gYu.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize44));
            }
            this.gYu.setText(CF);
            this.gYu.setVisibility(0);
        } else {
            this.gYu.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.agT()) && true == k.isEmpty(str3);
        a(this.iJY, this.iJS, this.iJW, adCard);
        if (advertAppInfo != null && advertAppInfo.agS()) {
            this.iJX.setText(adCard.userName.concat("APP").concat(" · 广告").toString());
        } else if (advertAppInfo != null && advertAppInfo.agT()) {
            String str4 = adCard.tagName;
            if (TextUtils.isEmpty(str4)) {
                str4 = "广告";
            }
            this.iJX.setText(str4);
        }
        if (advertAppInfo != null && advertAppInfo.agS()) {
            this.iKa = advertAppInfo.bXo;
            this.iJW.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.g.b.toInt(advertAppInfo.adPosition, -1));
            a(adCard, c2);
            a(this.iJS, c2.getStatus(), str3);
            this.iJW.setData(c2);
            this.iJW.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    am.setViewTextColor(this.iJS, R.color.btn_forum_focus_color, 1);
                    this.iJS.setText(str3);
                    if (k.isEmpty(str)) {
                        this.iJS.setClickable(false);
                    } else {
                        this.iJS.setClickable(true);
                        this.iJS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.hfN != null && adCard.buttonClick != null && !s.DH(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.hfN.b(adCard.buttonClick.LE, adCard.buttonClick.LG, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int a2 = com.baidu.tieba.recapp.s.a(AdCardBaseView.this.cfl, str, (AdCardBaseView.this.iKb == null || AdCardBaseView.this.iKb.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.iKb.getAdvertAppInfo().bXk);
                                        if ((a2 == 1 || a2 == 2) && AdCardBaseView.this.hfN != null) {
                                            AdCardBaseView.this.hfN.b(a2, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.cfl.getPageActivity());
                                    aVar.nn(adCard.popWindowText);
                                    aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int a3 = com.baidu.tieba.recapp.s.a(AdCardBaseView.this.cfl, str, (AdCardBaseView.this.iKb == null || AdCardBaseView.this.iKb.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.iKb.getAdvertAppInfo().bXk);
                                            if ((a3 == 1 || a3 == 2) && AdCardBaseView.this.hfN != null) {
                                                AdCardBaseView.this.hfN.b(a3, null);
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
                                    aVar.b(AdCardBaseView.this.cfl).akO();
                                }
                            }
                        });
                    }
                } else {
                    this.iJS.setClickable(false);
                    this.iJS.setText(adCard.buttonTextDone);
                    am.setBackgroundResource(this.iJS, R.drawable.btn_rounded_corner_gray_frame);
                    am.setViewTextColor(this.iJS, R.color.cp_cont_d, 1);
                }
            }
            this.iJW.setVisibility(8);
        }
        a(adCard);
        s(i.agq().isShowImages(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            CG(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.bXu != null && advertAppInfo.bXu.adCloseInfo != null && advertAppInfo.bXu.adCloseInfo.support_close.intValue() > 0) {
            this.iJU.setVisibility(0);
            this.iJU.setPage(getBusinessType());
            this.iJU.setData(advertAppInfo);
            l.addToParentArea(this.cfl.getPageActivity(), this.iJV, 40, 40, 40, 120);
            this.iJV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.iJU.performClick();
                }
            });
        } else {
            this.iJU.setVisibility(8);
            this.iJT.setOnClickListener(null);
        }
        this.iKc.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.eNE.getLayoutParams();
        if (4 == getBusinessType()) {
            this.iKc.setVisibility(8);
            this.iKc.setBarNameClickEnabled(false);
            this.iKc.setShareVisible(false);
            this.iKc.setShowPraiseNum(false);
            this.iKc.setCommentNumEnable(false);
            this.iKc.setReplyTimeVisible(false);
            layoutParams2.height = this.iJQ;
            this.iKe.setVisibility(0);
            this.iKf.setVisibility(8);
        } else {
            b(adCard, bVar);
        }
        a(adCard, this.eNg, getBusinessType());
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 instanceof AdvertAppInfo) {
            advertAppInfo2.mW(aq.aS(adCard.time));
        }
        this.iKd.setData(advertAppInfo2);
        ((TextView) this.iKd.getUserName()).setText(adCard.userName);
        this.iKd.getUserName().setOnClickListener(bVar);
        this.iKd.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.iKd.getUserName()).setText(adCard.userName);
            }
        });
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.biW().biX()) {
            this.iJG.setVisibility(0);
            am.setBackgroundColor(this.iJG, R.color.cp_bg_line_d);
        } else {
            this.iJG.setVisibility(8);
        }
        a(adCard, advertAppInfo);
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aDC();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aDD();
    }

    private void a(AdCard adCard, DownloadData downloadData) {
        if (adCard.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.iJW.getDownloadStatus());
        }
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.directDownload) {
            this.iJW.setOnClickListener(bVar);
        } else {
            this.iJW.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public void bo(View view) {
                    AdCardBaseView.this.cge();
                }
            });
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey ru;
        if (!adCard.directDownload && advertAppInfo != null && advertAppInfo.agS()) {
            String scheme = adCard.getScheme();
            String str = advertAppInfo.bXk;
            if (!TextUtils.isEmpty(str)) {
                ru = com.baidu.tieba.ad.download.d.aDI().rt(str);
            } else {
                ru = com.baidu.tieba.ad.download.d.aDI().ru(scheme);
            }
            if (ru == null) {
                ru = DownloadCacheKey.create(str, advertAppInfo.bXn, advertAppInfo.bXo);
                com.baidu.tieba.ad.download.d.aDI().a(ru, null);
            }
            i(ru);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.dhN = downloadCacheKey;
            aDD();
            this.dhO = null;
            AdDownloadData d2 = com.baidu.tieba.ad.download.d.aDI().d(downloadCacheKey);
            if (d2 != null) {
                this.iJW.a(d2.getCurrentState());
            } else {
                this.iJW.a(DownloadStatus.STATUS_NONE);
            }
            String str = "";
            if (this.iKb != null && this.iKb.getAdvertAppInfo() != null) {
                str = this.iKb.getAdvertAppInfo().page;
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.iJW, d2, str);
            this.dhO = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d2.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d2);
            }
            aDC();
        }
    }

    private void aDC() {
        if (this.dhN != null && this.dhO != null) {
            com.baidu.tieba.ad.download.d.aDI().a(this.dhN, this.dhO);
        }
    }

    private void aDD() {
        if (this.dhN != null && this.dhO != null) {
            com.baidu.tieba.ad.download.d.aDI().b(this.dhN, this.dhO);
        }
    }

    private boolean isInFrsAllThread() {
        return this.heO == 1;
    }

    private void b(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.iKf.setVisibility(0);
            this.iKc.setVisibility(8);
            return;
        }
        this.iKf.setVisibility(8);
        this.iKc.setVisibility(0);
        this.iKc.setBarNameClickEnabled(false);
        this.iKc.setReplyTimeVisible(false);
        this.iKc.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.iKc.setAgreeClickable(true);
            this.iKc.setPraiseContainerBgGray(false);
        } else {
            this.iKc.setAgreeClickable(false);
            this.iKc.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.iKc.setShareClickable(true);
            this.iKc.setShareContainerBgGray(false);
        } else {
            this.iKc.setShareClickable(false);
            this.iKc.setShareContainerBgGray(true);
        }
        if (this.iKc.getCommentContainer() != null) {
            this.iKc.getCommentContainer().setOnClickListener(bVar);
        }
        this.iKc.setNeedAddReplyIcon(true);
        this.iKc.setCommentNumEnable(false);
        this.iKc.setCommentClickable(true);
        this.iKc.setReplayContainerBgGray(true);
        this.iKc.setOnClickListener(bVar);
        this.iKc.setShareData(adCard);
        this.iKc.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        am.setBackgroundResource(this.eNE, R.color.cp_bg_line_c);
        this.iJU.onChangeSkinType();
        this.iKd.onChangeSkinType(this.cfl, TbadkCoreApplication.getInst().getSkinType());
        this.iKc.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.eNE, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.eNg, R.color.cp_bg_line_e);
        } else {
            am.setBackgroundColor(this.eNE, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.eNg, R.color.transparent);
        }
        am.setViewTextColor(this.gYu, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.iJX, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.iJT, R.color.cp_cont_d, 1);
        this.iJW.onChangeSkinType(i);
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
                if (this.hfN != null) {
                    this.hfN.b(bVar.LE, bVar.LG, null);
                }
            } else if (this.iKb != null && this.iKb.getAdvertAppInfo() != null) {
                String CH = CH(bVar.scheme);
                String str = this.iKb.getAdvertAppInfo().bXk;
                if (!this.iKb.directDownload && this.iKb.getAdvertAppInfo().agS()) {
                    a2 = com.baidu.tieba.recapp.s.b(this.cfl, CH, str);
                } else {
                    a2 = com.baidu.tieba.recapp.s.a(this.cfl, CH, str);
                }
                if (a2 == 1 || a2 == 2) {
                    if (this.hfN != null) {
                        this.hfN.b(a2, null);
                    }
                } else if (this.hfN != null) {
                    this.hfN.b(bVar.LE, bVar.LG, null);
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
                        if (AdCardBaseView.this.iKb.hasAnimation()) {
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
        this.hek = new a.C0454a();
        this.hek.picUrl = tbImageView.getUrl();
        this.hek.apc = rect;
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
                    com.baidu.adp.lib.f.c.fT().a(jSONObject.optString("pic_url"), 17, null, this.hfU, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.hfU), this.cfl.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.agR() != 0) {
                l.showToast(this.cfl.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.c.a();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.cfl.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.cfl.getPageActivity()) && this.hfO != null) {
                this.hfO.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.cfl.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.agS()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.cfl.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cfl.getPageActivity());
                aVar.nn(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.iJW);
                        if (AdCardBaseView.this.iJW != null) {
                            AdCardBaseView.this.iJW.q(AdCardBaseView.this.c(advertAppInfo, i));
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
                aVar.b(this.cfl).akO();
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
                    a(advertAppInfo, i, this.iJW);
                    apkDownloadView.s(c2);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.aDI().au(this.cfl.getPageActivity(), advertAppInfo.bXo);
                    return;
            }
            h.aK(this.cfl.getPageActivity(), advertAppInfo.bXo);
        }
    }

    public a.C0454a getAnimationInfo() {
        return this.hek;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private AdCard iKt;

        public b(AdCard adCard) {
            this.iKt = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdCardBaseView.this.cfl.showToast(R.string.neterror);
            } else if (this.iKt != null) {
                AdvertAppInfo advertAppInfo = this.iKt.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.iJW;
                if (advertAppInfo != null && advertAppInfo.agS()) {
                    a(advertAppInfo, z);
                } else {
                    j(advertAppInfo);
                }
            }
        }

        private void a(AdvertAppInfo advertAppInfo, boolean z) {
            if (this.iKt.directDownload || z) {
                b(advertAppInfo, z);
            } else {
                k(advertAppInfo);
            }
        }

        private void j(AdvertAppInfo advertAppInfo) {
            String scheme = this.iKt.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.bXm;
            }
            if (this.iKt.hasAnimation()) {
            }
            int e = com.baidu.tieba.recapp.s.e(AdCardBaseView.this.cfl, AdCardBaseView.this.CH(scheme));
            if (AdCardBaseView.this.hfN != null) {
                AdCardBaseView.this.hfN.b(e, null);
            }
        }

        private void b(AdvertAppInfo advertAppInfo, boolean z) {
            int i = com.baidu.adp.lib.g.b.toInt(advertAppInfo.adPosition, -1);
            int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, i));
            if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                return;
            }
            AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.iJW, z);
            AdCardBaseView.this.cge();
        }

        private void k(AdvertAppInfo advertAppInfo) {
            String scheme = this.iKt.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.bXm;
            }
            int b = com.baidu.tieba.recapp.s.b(AdCardBaseView.this.cfl, scheme, advertAppInfo.bXk);
            if (AdCardBaseView.this.hfN != null) {
                AdCardBaseView.this.hfN.b(b, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cge() {
        if (this.hfN != null) {
            this.hfN.b(3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String CH(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.hek != null && this.hek.isValid()) {
            String c0454a = this.hek.toString();
            if (!TextUtils.isEmpty(c0454a)) {
                sb.append("&");
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append("=");
                sb.append(URLEncoder.encode(c0454a));
            }
        }
        if (!TextUtils.isEmpty(this.iKb.getPreLoadData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append("=");
            sb.append(URLEncoder.encode(this.iKb.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.iKb.getNextPageData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append("=");
            sb.append(URLEncoder.encode(this.iKb.getNextPageData()));
        }
        if (this.iKb.hasAnimation()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append("=");
            sb.append("1");
        }
        if (this.iKb.isGoLandingPage()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append("=");
            sb.append("1");
        }
        if (this.iKb.isImmersiveStyle()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append("=");
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> iKs;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.iKs = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.iKs.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.iKa) ? false : true)) && adCardBaseView.iKa.equals(downloadData.getId())) {
                    int status = e.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.iJS.setText(R.string.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.iJS.setText(R.string.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> iKs;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.iKs = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.iKs.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.iKa) && adCardBaseView.iKa.equals(downloadData.getId())) {
                adCardBaseView.iJW.t(downloadData);
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> iKs;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.iKs = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.iKs.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                String str = null;
                if (adCardBaseView.iKb != null && adCardBaseView.iKb.getAdvertAppInfo() != null) {
                    str = adCardBaseView.iKb.getAdvertAppInfo().bXk;
                }
                com.baidu.tieba.recapp.s.a(adCardBaseView.cfl, adCardBaseView.iKg.scheme, str);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void bIn() {
        if (4 == getBusinessType()) {
            this.gYu.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.iJo != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.iKg = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.cfl.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.cfl, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        return true;
    }

    private void a(View view, TextView textView, ApkDownloadView apkDownloadView, AdCard adCard) {
        if (adCard == null) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        if (adCard.getAdvertAppInfo().agS()) {
            textView.setVisibility(8);
            apkDownloadView.setVisibility(0);
        } else if (true == k.isEmpty(adCard.buttonText) || "立即查看".equals(adCard.buttonText)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bXo);
        downloadData.setUrl(advertAppInfo.bXn);
        downloadData.setName(advertAppInfo.bXl);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.toInt(advertAppInfo.bXk, 0));
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
