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
import com.baidu.webkit.internal.ETAG;
import com.tencent.open.SocialConstants;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class AdCardBaseView extends BaseLegoCardView<AdCard> implements com.baidu.tieba.lego.card.b.a {
    private DownloadCacheKey dUL;
    private com.baidu.tieba.ad.download.a.d dUM;
    protected View fEB;
    protected View fEe;
    protected TextView hLE;
    private a.C0535a hRB;
    private final int hTh;
    protected String jDA;
    private AdCard jDB;
    private AdThreadCommentAndPraiseInfoLayout jDC;
    protected AdThreadUserInfoLayout jDD;
    protected View jDE;
    protected View jDF;
    protected AdCard.b jDG;
    protected CustomMessageListener jDH;
    protected CustomMessageListener jDI;
    protected CustomMessageListener jDJ;
    protected ViewStub jDe;
    protected View jDf;
    protected View jDg;
    protected final int jDh;
    protected final int jDi;
    protected final int jDj;
    protected final int jDk;
    protected final int jDl;
    protected final int jDm;
    protected final int jDn;
    protected final int jDo;
    private int jDp;
    private int jDq;
    private int jDr;
    protected TextView jDs;
    protected TextView jDt;
    private AdCloseView jDu;
    private LinearLayout jDv;
    protected ApkDownloadView jDw;
    protected TextView jDx;
    protected RelativeLayout jDy;
    protected View jDz;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void cH(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hTh = l.getEquipmentWidth(getContext());
        this.dUM = null;
        this.jDH = new a(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG, this);
        this.jDI = new d(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG, this);
        this.jDJ = new c(CmdConfigCustom.CMD_USER_INFO_CHANGED, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.ds640);
        this.mImageHeight = (int) resources.getDimension(R.dimen.ds278);
        this.jDh = (int) resources.getDimension(R.dimen.tbds92);
        this.jDi = (int) resources.getDimension(R.dimen.tbds92);
        this.jDj = (int) resources.getDimension(R.dimen.tbds20);
        this.jDm = (int) resources.getDimension(R.dimen.tbds90);
        this.jDn = (int) resources.getDimension(R.dimen.tbds90);
        this.jDo = (int) resources.getDimension(R.dimen.tbds22);
        this.jDk = (int) resources.getDimension(R.dimen.tbds44);
        this.jDl = (int) resources.getDimension(R.dimen.tbds44);
        this.jDp = (int) resources.getDimension(R.dimen.ds12);
        this.jDq = (int) resources.getDimension(R.dimen.ds1);
        this.jDr = (int) resources.getDimension(R.dimen.ds18);
    }

    protected void v(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.jDC.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bZt() {
        MessageManager.getInstance().registerListener(this.jDH);
        MessageManager.getInstance().registerListener(this.jDI);
        MessageManager.getInstance().registerListener(this.jDJ);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.fEB = this.mRootView.findViewById(R.id.bottom_line);
        this.jDg = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.jDg.setClickable(true);
        this.hLE = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.jDs = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.jDw = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.jDx = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.jDy = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.jDw.u(this.cQU.getUniqueId());
        this.jDH.setTag(this.cQU.getUniqueId());
        this.jDz = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.jDI.setTag(this.cQU.getUniqueId());
        this.jDJ.setTag(this.cQU.getUniqueId());
        this.jDC = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.jDC.setStyle(1);
        this.jDD = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        if (1 == getBusinessType()) {
            this.jDD.setShowFlag(1413);
        }
        this.jDv = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.jDu = (AdCloseView) this.jDv.findViewById(R.id.ad_close_view);
        this.jDt = (TextView) this.jDv.findViewById(R.id.feed_tag);
        this.jDt.setVisibility(8);
        this.jDC.addAdMoreView(this.jDv);
        this.fEe = this.mRootView.findViewById(R.id.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.jDk) - this.jDl) - this.jDh) - this.jDj;
            this.jDC.setVisibility(8);
        } else {
            this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.jDk) - this.jDl;
            this.jDC.setVisibility(0);
        }
        this.jDe = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.jDe.setLayoutResource(getCustomLayout());
        this.jDf = this.jDe.inflate();
        this.jDE = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.jDF = this.mRootView.findViewById(R.id.frs_bottom_view);
        cH(this.jDf);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(final AdCard adCard) {
        final String str;
        this.jDB = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.jDD.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.aGy() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.cQU.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        a(adCard, bVar);
        this.jDs.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jDz.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.jDh + this.jDj;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.jDD.getHeaderImg(), adCard.portraitClick, bVar);
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String Hs = Hs(str2);
            this.hLE.setMaxLines(adCard.titleLines <= 0 ? 4 : adCard.titleLines);
            if (4 == getBusinessType()) {
                this.hLE.setTextSize(0, getContext().getResources().getDimension(R.dimen.ds32));
            } else {
                this.hLE.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize44));
            }
            this.hLE.setText(Hs);
            this.hLE.setVisibility(0);
        } else {
            this.hLE.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.axI()) && k.isEmpty(str3);
        a(this.jDy, this.jDs, this.jDw, adCard);
        if (advertAppInfo != null && advertAppInfo.axH()) {
            this.jDx.setText(adCard.userName.concat("APP").concat("   广告").toString());
        } else if (advertAppInfo != null && advertAppInfo.axI()) {
            String str4 = adCard.tagName;
            if (TextUtils.isEmpty(str4)) {
                str4 = "广告";
            }
            this.jDx.setText(str4);
        }
        if (advertAppInfo != null && advertAppInfo.axH()) {
            this.jDA = advertAppInfo.cIK;
            this.jDw.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            a(adCard, c2);
            a(this.jDs, c2.getStatus(), str3);
            this.jDw.setData(c2);
            this.jDw.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    am.setViewTextColor(this.jDs, R.color.cp_btn_a, 1);
                    this.jDs.setText(str3);
                    if (k.isEmpty(str)) {
                        this.jDs.setClickable(false);
                    } else {
                        this.jDs.setClickable(true);
                        this.jDs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.hTa != null && adCard.buttonClick != null && !s.Iw(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.hTa.b(adCard.buttonClick.RA, adCard.buttonClick.RB, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int a2 = com.baidu.tieba.recapp.s.a(AdCardBaseView.this.cQU, str, (AdCardBaseView.this.jDB == null || AdCardBaseView.this.jDB.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.jDB.getAdvertAppInfo().cIG);
                                        if ((a2 == 1 || a2 == 2) && AdCardBaseView.this.hTa != null) {
                                            AdCardBaseView.this.hTa.b(a2, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.cQU.getPageActivity());
                                    aVar.sz(adCard.popWindowText);
                                    aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int a3 = com.baidu.tieba.recapp.s.a(AdCardBaseView.this.cQU, str, (AdCardBaseView.this.jDB == null || AdCardBaseView.this.jDB.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.jDB.getAdvertAppInfo().cIG);
                                            if ((a3 == 1 || a3 == 2) && AdCardBaseView.this.hTa != null) {
                                                AdCardBaseView.this.hTa.b(a3, null);
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
                                    aVar.b(AdCardBaseView.this.cQU).aBW();
                                }
                            }
                        });
                    }
                } else {
                    this.jDs.setClickable(false);
                    this.jDs.setText(adCard.buttonTextDone);
                    am.setBackgroundResource(this.jDs, R.drawable.ad_download_progress_button_bg);
                    am.setViewTextColor(this.jDs, R.color.cp_btn_a, 1);
                }
            }
            this.jDw.setVisibility(8);
        }
        a(adCard);
        v(i.axf().isShowImages(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            Ht(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.cIQ != null && advertAppInfo.cIQ.adCloseInfo != null && advertAppInfo.cIQ.adCloseInfo.support_close.intValue() > 0) {
            this.jDu.setVisibility(0);
            this.jDu.setPage(getBusinessType());
            this.jDu.setData(advertAppInfo);
            l.addToParentArea(this.cQU.getPageActivity(), this.jDv, 40, 40, 40, 120);
            this.jDv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.jDu.performClick();
                }
            });
        } else {
            this.jDu.setVisibility(8);
            this.jDt.setOnClickListener(null);
        }
        this.jDC.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.fEB.getLayoutParams();
        if (4 == getBusinessType()) {
            this.jDC.setVisibility(8);
            this.jDC.setBarNameClickEnabled(false);
            this.jDC.setShareVisible(false);
            this.jDC.setShowPraiseNum(false);
            this.jDC.setCommentNumEnable(false);
            this.jDC.setReplyTimeVisible(false);
            layoutParams2.height = this.jDq;
            this.jDE.setVisibility(0);
            this.jDF.setVisibility(8);
        } else {
            b(adCard, bVar);
        }
        a(adCard, this.fEe, getBusinessType());
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 instanceof AdvertAppInfo) {
            advertAppInfo2.sj(aq.bw(adCard.time));
        }
        this.jDD.setData(advertAppInfo2);
        ((TextView) this.jDD.getUserName()).setText(adCard.userName);
        this.jDD.getUserName().setOnClickListener(bVar);
        this.jDD.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.jDD.getUserName()).setText(adCard.userName);
            }
        });
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bAp().bAq()) {
            this.jDg.setVisibility(0);
            am.setBackgroundColor(this.jDg, R.color.cp_bg_line_d);
        } else {
            this.jDg.setVisibility(8);
        }
        a(adCard, advertAppInfo);
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aVu();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aVv();
    }

    private void a(AdCard adCard, DownloadData downloadData) {
        if (adCard.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.jDw.getDownloadStatus());
        }
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.directDownload) {
            this.jDw.setOnClickListener(bVar);
        } else {
            this.jDw.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public void bl(View view) {
                    AdCardBaseView.this.cAg();
                }
            });
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey wD;
        if (!adCard.directDownload && advertAppInfo != null && advertAppInfo.axH()) {
            String scheme = adCard.getScheme();
            String str = advertAppInfo.cIG;
            if (!TextUtils.isEmpty(str)) {
                wD = com.baidu.tieba.ad.download.d.aVA().wC(str);
            } else {
                wD = com.baidu.tieba.ad.download.d.aVA().wD(scheme);
            }
            if (wD == null) {
                wD = DownloadCacheKey.create(str, advertAppInfo.cIJ, advertAppInfo.cIK);
                com.baidu.tieba.ad.download.d.aVA().a(wD, null);
            }
            i(wD);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.dUL = downloadCacheKey;
            aVv();
            this.dUM = null;
            AdDownloadData d2 = com.baidu.tieba.ad.download.d.aVA().d(downloadCacheKey);
            if (d2 != null) {
                this.jDw.a(d2.getCurrentState());
            } else {
                this.jDw.a(DownloadStatus.STATUS_NONE);
            }
            String str = "";
            if (this.jDB != null && this.jDB.getAdvertAppInfo() != null) {
                str = this.jDB.getAdvertAppInfo().page;
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.jDw, d2, str);
            this.dUM = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d2.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d2);
            }
            aVu();
        }
    }

    private void aVu() {
        if (this.dUL != null && this.dUM != null) {
            com.baidu.tieba.ad.download.d.aVA().a(this.dUL, this.dUM);
        }
    }

    private void aVv() {
        if (this.dUL != null && this.dUM != null) {
            com.baidu.tieba.ad.download.d.aVA().b(this.dUL, this.dUM);
        }
    }

    private boolean isInFrsAllThread() {
        return this.hSe == 1;
    }

    private void b(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.jDF.setVisibility(0);
            this.jDC.setVisibility(8);
            return;
        }
        this.jDF.setVisibility(8);
        this.jDC.setVisibility(0);
        this.jDC.setBarNameClickEnabled(false);
        this.jDC.setReplyTimeVisible(false);
        this.jDC.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.jDC.setAgreeClickable(true);
            this.jDC.setPraiseContainerBgGray(false);
        } else {
            this.jDC.setAgreeClickable(false);
            this.jDC.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.jDC.setShareClickable(true);
            this.jDC.setShareContainerBgGray(false);
        } else {
            this.jDC.setShareClickable(false);
            this.jDC.setShareContainerBgGray(true);
        }
        if (this.jDC.getCommentContainer() != null) {
            this.jDC.getCommentContainer().setOnClickListener(bVar);
        }
        this.jDC.setNeedAddReplyIcon(true);
        this.jDC.setCommentNumEnable(false);
        this.jDC.setCommentClickable(true);
        this.jDC.setReplayContainerBgGray(true);
        this.jDC.setOnClickListener(bVar);
        this.jDC.setShareData(adCard);
        this.jDC.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        am.setBackgroundResource(this.fEB, R.color.cp_bg_line_b);
        this.jDu.onChangeSkinType();
        this.jDD.onChangeSkinType(this.cQU, TbadkCoreApplication.getInst().getSkinType());
        this.jDC.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.fEe, R.color.cp_bg_line_e);
        } else {
            am.setBackgroundColor(this.fEe, R.color.transparent);
        }
        am.setViewTextColor(this.hLE, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.jDx, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.jDt, R.color.cp_cont_d, 1);
        this.jDw.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String Hs(String str) {
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
            if (b(bVar) && !s.Iw(bVar.scheme)) {
                if (this.hTa != null) {
                    this.hTa.b(bVar.RA, bVar.RB, null);
                }
            } else if (this.jDB != null && this.jDB.getAdvertAppInfo() != null) {
                String Hu = Hu(bVar.scheme);
                String str = this.jDB.getAdvertAppInfo().cIG;
                if (!this.jDB.directDownload && this.jDB.getAdvertAppInfo().axH()) {
                    a2 = com.baidu.tieba.recapp.s.b(this.cQU, Hu, str);
                } else {
                    a2 = com.baidu.tieba.recapp.s.a(this.cQU, Hu, str);
                }
                if (a2 == 1 || a2 == 2) {
                    if (this.hTa != null) {
                        this.hTa.b(a2, null);
                    }
                } else if (this.hTa != null) {
                    this.hTa.b(bVar.RA, bVar.RB, null);
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
                        if (AdCardBaseView.this.jDB.hasAnimation()) {
                            AdCardBaseView.this.k(tbImageView);
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
    public void k(TbImageView tbImageView) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        tbImageView.getLocationOnScreen(iArr);
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + tbImageView.getWidth();
        rect.bottom = rect.top + tbImageView.getHeight();
        this.hRB = new a.C0535a();
        this.hRB.picUrl = tbImageView.getUrl();
        this.hRB.rect = rect;
    }

    private void Ht(String str) {
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
                    com.baidu.adp.lib.e.c.gs().a(jSONObject.optString("pic_url"), 17, null, this.hTh, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.hTh), this.cQU.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.axG() != 0) {
                l.showToast(this.cQU.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.cQU.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.cQU.getPageActivity()) && this.hTb != null) {
                this.hTb.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.cQU.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.axH()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.cQU.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cQU.getPageActivity());
                aVar.sz(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.jDw);
                        if (AdCardBaseView.this.jDw != null) {
                            AdCardBaseView.this.jDw.q(AdCardBaseView.this.c(advertAppInfo, i));
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
                aVar.b(this.cQU).aBW();
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
                    a(advertAppInfo, i, this.jDw);
                    apkDownloadView.s(c2);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.aVA().aM(this.cQU.getPageActivity(), advertAppInfo.cIK);
                    return;
            }
            h.bc(this.cQU.getPageActivity(), advertAppInfo.cIK);
        }
    }

    public a.C0535a getAnimationInfo() {
        return this.hRB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        private AdCard jDT;

        public b(AdCard adCard) {
            this.jDT = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdCardBaseView.this.cQU.showToast(R.string.neterror);
            } else if (this.jDT != null) {
                AdvertAppInfo advertAppInfo = this.jDT.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.jDw;
                if (advertAppInfo != null && advertAppInfo.axH()) {
                    a(advertAppInfo, z);
                } else {
                    i(advertAppInfo);
                }
            }
        }

        private void a(AdvertAppInfo advertAppInfo, boolean z) {
            if (this.jDT.directDownload || z) {
                b(advertAppInfo, z);
            } else {
                j(advertAppInfo);
            }
        }

        private void i(AdvertAppInfo advertAppInfo) {
            String scheme = this.jDT.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.cII;
            }
            if (this.jDT.hasAnimation()) {
            }
            int e = com.baidu.tieba.recapp.s.e(AdCardBaseView.this.cQU, AdCardBaseView.this.Hu(scheme));
            if (AdCardBaseView.this.hTa != null) {
                AdCardBaseView.this.hTa.b(e, null);
            }
        }

        private void b(AdvertAppInfo advertAppInfo, boolean z) {
            int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
            int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, i));
            if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                return;
            }
            AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.jDw, z);
            AdCardBaseView.this.cAg();
        }

        private void j(AdvertAppInfo advertAppInfo) {
            String scheme = this.jDT.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.cII;
            }
            int b = com.baidu.tieba.recapp.s.b(AdCardBaseView.this.cQU, scheme, advertAppInfo.cIG);
            if (AdCardBaseView.this.hTa != null) {
                AdCardBaseView.this.hTa.b(b, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cAg() {
        if (this.hTa != null) {
            this.hTa.b(3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Hu(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.hRB != null && this.hRB.isValid()) {
            String c0535a = this.hRB.toString();
            if (!TextUtils.isEmpty(c0535a)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(c0535a));
            }
        }
        if (!TextUtils.isEmpty(this.jDB.getPreLoadData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.jDB.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.jDB.getNextPageData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.jDB.getNextPageData()));
        }
        if (this.jDB.hasAnimation()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.jDB.isGoLandingPage()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.jDB.isImmersiveStyle()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes10.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> jDS;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.jDS = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.jDS.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.jDA) ? false : true)) && adCardBaseView.jDA.equals(downloadData.getId())) {
                    int status = e.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.jDs.setText(R.string.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.jDs.setText(R.string.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> jDS;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.jDS = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.jDS.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.jDA) && adCardBaseView.jDA.equals(downloadData.getId())) {
                adCardBaseView.jDw.t(downloadData);
            }
        }
    }

    /* loaded from: classes10.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> jDS;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.jDS = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.jDS.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                String str = null;
                if (adCardBaseView.jDB != null && adCardBaseView.jDB.getAdvertAppInfo() != null) {
                    str = adCardBaseView.jDB.getAdvertAppInfo().cIG;
                }
                com.baidu.tieba.recapp.s.a(adCardBaseView.cQU, adCardBaseView.jDG.scheme, str);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void bZz() {
        if (4 == getBusinessType()) {
            this.hLE.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.jCO != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.jDG = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.cQU.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.cQU, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        return true;
    }

    private void a(View view, TextView textView, ApkDownloadView apkDownloadView, AdCard adCard) {
        if (adCard == null) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        if (adCard.getAdvertAppInfo().axH()) {
            textView.setVisibility(8);
            apkDownloadView.setVisibility(0);
        } else if (true == k.isEmpty(adCard.buttonText) || "立即查看".equals(adCard.buttonText)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.cIK);
        downloadData.setUrl(advertAppInfo.cIJ);
        downloadData.setName(advertAppInfo.cIH);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.cIG, 0));
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
