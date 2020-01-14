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
/* loaded from: classes11.dex */
public abstract class AdCardBaseView extends BaseLegoCardView<AdCard> implements com.baidu.tieba.lego.card.b.a {
    private DownloadCacheKey dUU;
    private com.baidu.tieba.ad.download.a.d dUV;
    protected View fHL;
    protected View fHo;
    protected TextView hPh;
    private a.C0540a hVf;
    private final int hWL;
    protected ViewStub jGL;
    protected View jGM;
    protected View jGN;
    protected final int jGO;
    protected final int jGP;
    protected final int jGQ;
    protected final int jGR;
    protected final int jGS;
    protected final int jGT;
    protected final int jGU;
    protected final int jGV;
    private int jGW;
    private int jGX;
    private int jGY;
    protected TextView jGZ;
    protected TextView jHa;
    private AdCloseView jHb;
    private LinearLayout jHc;
    protected ApkDownloadView jHd;
    protected TextView jHe;
    protected RelativeLayout jHf;
    protected View jHg;
    protected String jHh;
    private AdCard jHi;
    private AdThreadCommentAndPraiseInfoLayout jHj;
    protected AdThreadUserInfoLayout jHk;
    protected View jHl;
    protected View jHm;
    protected AdCard.b jHn;
    protected CustomMessageListener jHo;
    protected CustomMessageListener jHp;
    protected CustomMessageListener jHq;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void cN(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hWL = l.getEquipmentWidth(getContext());
        this.dUV = null;
        this.jHo = new a(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG, this);
        this.jHp = new d(CmdConfigCustom.CMD_DELETE_DOWNLOAD_MSG, this);
        this.jHq = new c(CmdConfigCustom.CMD_USER_INFO_CHANGED, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.ds640);
        this.mImageHeight = (int) resources.getDimension(R.dimen.ds278);
        this.jGO = (int) resources.getDimension(R.dimen.tbds92);
        this.jGP = (int) resources.getDimension(R.dimen.tbds92);
        this.jGQ = (int) resources.getDimension(R.dimen.tbds20);
        this.jGT = (int) resources.getDimension(R.dimen.tbds90);
        this.jGU = (int) resources.getDimension(R.dimen.tbds90);
        this.jGV = (int) resources.getDimension(R.dimen.tbds22);
        this.jGR = (int) resources.getDimension(R.dimen.tbds44);
        this.jGS = (int) resources.getDimension(R.dimen.tbds44);
        this.jGW = (int) resources.getDimension(R.dimen.ds12);
        this.jGX = (int) resources.getDimension(R.dimen.ds1);
        this.jGY = (int) resources.getDimension(R.dimen.ds18);
    }

    protected void w(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.jHj.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View caC() {
        MessageManager.getInstance().registerListener(this.jHo);
        MessageManager.getInstance().registerListener(this.jHp);
        MessageManager.getInstance().registerListener(this.jHq);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.fHL = this.mRootView.findViewById(R.id.bottom_line);
        this.jGN = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.jGN.setClickable(true);
        this.hPh = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.jGZ = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.jHd = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.jHe = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.jHf = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.jHd.u(this.cRe.getUniqueId());
        this.jHo.setTag(this.cRe.getUniqueId());
        this.jHg = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.jHp.setTag(this.cRe.getUniqueId());
        this.jHq.setTag(this.cRe.getUniqueId());
        this.jHj = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.jHj.setStyle(1);
        this.jHk = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        if (1 == getBusinessType()) {
            this.jHk.setShowFlag(1413);
        }
        this.jHc = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.jHb = (AdCloseView) this.jHc.findViewById(R.id.ad_close_view);
        this.jHa = (TextView) this.jHc.findViewById(R.id.feed_tag);
        this.jHa.setVisibility(8);
        this.jHj.addAdMoreView(this.jHc);
        this.fHo = this.mRootView.findViewById(R.id.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.getEquipmentWidth(getContext()) - this.jGR) - this.jGS) - this.jGO) - this.jGQ;
            this.jHj.setVisibility(8);
        } else {
            this.mMaxWidth = (l.getEquipmentWidth(getContext()) - this.jGR) - this.jGS;
            this.jHj.setVisibility(0);
        }
        this.jGL = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.jGL.setLayoutResource(getCustomLayout());
        this.jGM = this.jGL.inflate();
        this.jHl = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.jHm = this.mRootView.findViewById(R.id.frs_bottom_view);
        cN(this.jGM);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(final AdCard adCard) {
        final String str;
        this.jHi = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.jHk.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.aGR() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.copyToClipboard(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.cRe.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        a(adCard, bVar);
        this.jGZ.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jHg.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.jGO + this.jGQ;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.jHk.getHeaderImg(), adCard.portraitClick, bVar);
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String HC = HC(str2);
            this.hPh.setMaxLines(adCard.titleLines <= 0 ? 4 : adCard.titleLines);
            if (4 == getBusinessType()) {
                this.hPh.setTextSize(0, getContext().getResources().getDimension(R.dimen.ds32));
            } else {
                this.hPh.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize44));
            }
            this.hPh.setText(HC);
            this.hPh.setVisibility(0);
        } else {
            this.hPh.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.ayb()) && k.isEmpty(str3);
        a(this.jHf, this.jGZ, this.jHd, adCard);
        if (advertAppInfo != null && advertAppInfo.aya()) {
            this.jHe.setText(adCard.userName.concat("APP").concat("   广告").toString());
        } else if (advertAppInfo != null && advertAppInfo.ayb()) {
            String str4 = adCard.tagName;
            if (TextUtils.isEmpty(str4)) {
                str4 = "广告";
            }
            this.jHe.setText(str4);
        }
        if (advertAppInfo != null && advertAppInfo.aya()) {
            this.jHh = advertAppInfo.cIV;
            this.jHd.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1));
            a(adCard, c2);
            a(this.jGZ, c2.getStatus(), str3);
            this.jHd.setData(c2);
            this.jHd.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    am.setViewTextColor(this.jGZ, R.color.cp_btn_a, 1);
                    this.jGZ.setText(str3);
                    if (k.isEmpty(str)) {
                        this.jGZ.setClickable(false);
                    } else {
                        this.jGZ.setClickable(true);
                        this.jGZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.hWE != null && adCard.buttonClick != null && !s.IG(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.hWE.b(adCard.buttonClick.RD, adCard.buttonClick.RE, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int b2 = com.baidu.tieba.recapp.s.b(AdCardBaseView.this.cRe, str, (AdCardBaseView.this.jHi == null || AdCardBaseView.this.jHi.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.jHi.getAdvertAppInfo().cIS);
                                        if ((b2 == 1 || b2 == 2) && AdCardBaseView.this.hWE != null) {
                                            AdCardBaseView.this.hWE.b(b2, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.cRe.getPageActivity());
                                    aVar.sC(adCard.popWindowText);
                                    aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int b3 = com.baidu.tieba.recapp.s.b(AdCardBaseView.this.cRe, str, (AdCardBaseView.this.jHi == null || AdCardBaseView.this.jHi.getAdvertAppInfo() == null) ? null : AdCardBaseView.this.jHi.getAdvertAppInfo().cIS);
                                            if ((b3 == 1 || b3 == 2) && AdCardBaseView.this.hWE != null) {
                                                AdCardBaseView.this.hWE.b(b3, null);
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
                                    aVar.b(AdCardBaseView.this.cRe).aCp();
                                }
                            }
                        });
                    }
                } else {
                    this.jGZ.setClickable(false);
                    this.jGZ.setText(adCard.buttonTextDone);
                    am.setBackgroundResource(this.jGZ, R.drawable.ad_download_progress_button_bg);
                    am.setViewTextColor(this.jGZ, R.color.cp_btn_a, 1);
                }
            }
            this.jHd.setVisibility(8);
        }
        a(adCard);
        w(i.axy().isShowImages(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            HD(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.cJb != null && advertAppInfo.cJb.adCloseInfo != null && advertAppInfo.cJb.adCloseInfo.support_close.intValue() > 0) {
            this.jHb.setVisibility(0);
            this.jHb.setPage(getBusinessType());
            this.jHb.setData(advertAppInfo);
            l.addToParentArea(this.cRe.getPageActivity(), this.jHc, 40, 40, 40, 120);
            this.jHc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.jHb.performClick();
                }
            });
        } else {
            this.jHb.setVisibility(8);
            this.jHa.setOnClickListener(null);
        }
        this.jHj.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.fHL.getLayoutParams();
        if (4 == getBusinessType()) {
            this.jHj.setVisibility(8);
            this.jHj.setBarNameClickEnabled(false);
            this.jHj.setShareVisible(false);
            this.jHj.setShowPraiseNum(false);
            this.jHj.setCommentNumEnable(false);
            this.jHj.setReplyTimeVisible(false);
            layoutParams2.height = this.jGX;
            this.jHl.setVisibility(0);
            this.jHm.setVisibility(8);
        } else {
            b(adCard, bVar);
        }
        a(adCard, this.fHo, getBusinessType());
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 instanceof AdvertAppInfo) {
            advertAppInfo2.sm(aq.bz(adCard.time));
        }
        this.jHk.setData(advertAppInfo2);
        ((TextView) this.jHk.getUserName()).setText(adCard.userName);
        this.jHk.getUserName().setOnClickListener(bVar);
        this.jHk.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.jHk.getUserName()).setText(adCard.userName);
            }
        });
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bBr().bBs()) {
            this.jGN.setVisibility(0);
            am.setBackgroundColor(this.jGN, R.color.cp_bg_line_d);
        } else {
            this.jGN.setVisibility(8);
        }
        a(adCard, advertAppInfo);
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aVN();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aVO();
    }

    private void a(AdCard adCard, DownloadData downloadData) {
        if (adCard.directDownload) {
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        } else {
            downloadData.setStatus(this.jHd.getDownloadStatus());
        }
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.directDownload) {
            this.jHd.setOnClickListener(bVar);
        } else {
            this.jHd.setOnClickInterceptListener(new b.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                @Override // com.baidu.tieba.ad.download.mvp.b.a
                public void bp(View view) {
                    AdCardBaseView.this.cBp();
                }
            });
        }
    }

    private void a(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey wH;
        if (!adCard.directDownload && advertAppInfo != null && advertAppInfo.aya()) {
            String scheme = adCard.getScheme();
            String str = advertAppInfo.cIS;
            if (!TextUtils.isEmpty(str)) {
                wH = com.baidu.tieba.ad.download.d.aVT().wG(str);
            } else {
                wH = com.baidu.tieba.ad.download.d.aVT().wH(scheme);
            }
            if (wH == null) {
                wH = DownloadCacheKey.create(str, advertAppInfo.apkUrl, advertAppInfo.cIV);
                com.baidu.tieba.ad.download.d.aVT().a(wH, null);
            }
            i(wH);
        }
    }

    public void i(DownloadCacheKey downloadCacheKey) {
        if (downloadCacheKey != null) {
            this.dUU = downloadCacheKey;
            aVO();
            this.dUV = null;
            AdDownloadData d2 = com.baidu.tieba.ad.download.d.aVT().d(downloadCacheKey);
            if (d2 != null) {
                this.jHd.a(d2.getCurrentState());
            } else {
                this.jHd.a(DownloadStatus.STATUS_NONE);
            }
            String str = "";
            if (this.jHi != null && this.jHi.getAdvertAppInfo() != null) {
                str = this.jHi.getAdvertAppInfo().page;
            }
            com.baidu.tieba.ad.browser.newstyle.view.a aVar = new com.baidu.tieba.ad.browser.newstyle.view.a(this.jHd, d2, str);
            this.dUV = new com.baidu.tieba.ad.download.a.b(aVar);
            if (d2.extra().getPercent() > 0) {
                aVar.b((com.baidu.tieba.ad.browser.newstyle.view.a) d2);
            }
            aVN();
        }
    }

    private void aVN() {
        if (this.dUU != null && this.dUV != null) {
            com.baidu.tieba.ad.download.d.aVT().a(this.dUU, this.dUV);
        }
    }

    private void aVO() {
        if (this.dUU != null && this.dUV != null) {
            com.baidu.tieba.ad.download.d.aVT().b(this.dUU, this.dUV);
        }
    }

    private boolean isInFrsAllThread() {
        return this.hVI == 1;
    }

    private void b(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.jHm.setVisibility(0);
            this.jHj.setVisibility(8);
            return;
        }
        this.jHm.setVisibility(8);
        this.jHj.setVisibility(0);
        this.jHj.setBarNameClickEnabled(false);
        this.jHj.setReplyTimeVisible(false);
        this.jHj.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.jHj.setAgreeClickable(true);
            this.jHj.setPraiseContainerBgGray(false);
        } else {
            this.jHj.setAgreeClickable(false);
            this.jHj.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.jHj.setShareClickable(true);
            this.jHj.setShareContainerBgGray(false);
        } else {
            this.jHj.setShareClickable(false);
            this.jHj.setShareContainerBgGray(true);
        }
        if (this.jHj.getCommentContainer() != null) {
            this.jHj.getCommentContainer().setOnClickListener(bVar);
        }
        this.jHj.setNeedAddReplyIcon(true);
        this.jHj.setCommentNumEnable(false);
        this.jHj.setCommentClickable(true);
        this.jHj.setReplayContainerBgGray(true);
        this.jHj.setOnClickListener(bVar);
        this.jHj.setShareData(adCard);
        this.jHj.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        am.setBackgroundResource(this.fHL, R.color.cp_bg_line_b);
        this.jHb.onChangeSkinType();
        this.jHk.onChangeSkinType(this.cRe, TbadkCoreApplication.getInst().getSkinType());
        this.jHj.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            am.setBackgroundColor(this.fHo, R.color.cp_bg_line_e);
        } else {
            am.setBackgroundColor(this.fHo, R.color.transparent);
        }
        am.setViewTextColor(this.hPh, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.jHe, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.jHa, R.color.cp_cont_d, 1);
        this.jHd.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String HC(String str) {
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
        int b2;
        if (bVar != null) {
            if (b(bVar) && !s.IG(bVar.scheme)) {
                if (this.hWE != null) {
                    this.hWE.b(bVar.RD, bVar.RE, null);
                }
            } else if (this.jHi != null && this.jHi.getAdvertAppInfo() != null) {
                String HE = HE(bVar.scheme);
                String str = this.jHi.getAdvertAppInfo().cIS;
                if (!this.jHi.directDownload && this.jHi.getAdvertAppInfo().aya()) {
                    b2 = com.baidu.tieba.recapp.s.c(this.cRe, HE, str);
                } else {
                    b2 = com.baidu.tieba.recapp.s.b(this.cRe, HE, str);
                }
                if (b2 == 1 || b2 == 2) {
                    if (this.hWE != null) {
                        this.hWE.b(b2, null);
                    }
                } else if (this.hWE != null) {
                    this.hWE.b(bVar.RD, bVar.RE, null);
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
                        if (AdCardBaseView.this.jHi.hasAnimation()) {
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
        this.hVf = new a.C0540a();
        this.hVf.picUrl = tbImageView.getUrl();
        this.hVf.rect = rect;
    }

    private void HD(String str) {
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
                    com.baidu.adp.lib.e.c.gr().a(jSONObject.optString("pic_url"), 17, null, this.hWL, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.hWL), this.cRe.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.axZ() != 0) {
                l.showToast(this.cRe.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this.cRe.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.startRequestPermission(this.cRe.getPageActivity()) && this.hWF != null) {
                this.hWF.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.q(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.isNetworkAvailableForImmediately()) {
                l.showToast(this.cRe.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.aya()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.cRe.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cRe.getPageActivity());
                aVar.sC(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.jHd);
                        if (AdCardBaseView.this.jHd != null) {
                            AdCardBaseView.this.jHd.q(AdCardBaseView.this.c(advertAppInfo, i));
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
                aVar.b(this.cRe).aCp();
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
                    a(advertAppInfo, i, this.jHd);
                    apkDownloadView.s(c2);
                    return;
                case 8:
                    com.baidu.tieba.ad.download.d.aVT().aN(this.cRe.getPageActivity(), advertAppInfo.cIV);
                    return;
            }
            h.bd(this.cRe.getPageActivity(), advertAppInfo.cIV);
        }
    }

    public a.C0540a getAnimationInfo() {
        return this.hVf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        private AdCard jHA;

        public b(AdCard adCard) {
            this.jHA = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.isNetworkAvailableForImmediately()) {
                AdCardBaseView.this.cRe.showToast(R.string.neterror);
            } else if (this.jHA != null) {
                AdvertAppInfo advertAppInfo = this.jHA.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.jHd;
                if (advertAppInfo != null && advertAppInfo.aya()) {
                    a(advertAppInfo, z);
                } else {
                    i(advertAppInfo);
                }
            }
        }

        private void a(AdvertAppInfo advertAppInfo, boolean z) {
            if (this.jHA.directDownload || z) {
                b(advertAppInfo, z);
            } else {
                j(advertAppInfo);
            }
        }

        private void i(AdvertAppInfo advertAppInfo) {
            String scheme = this.jHA.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.cIU;
            }
            if (this.jHA.hasAnimation()) {
            }
            int e = com.baidu.tieba.recapp.s.e(AdCardBaseView.this.cRe, AdCardBaseView.this.HE(scheme));
            if (AdCardBaseView.this.hWE != null) {
                AdCardBaseView.this.hWE.b(e, null);
            }
        }

        private void b(AdvertAppInfo advertAppInfo, boolean z) {
            int i = com.baidu.adp.lib.f.b.toInt(advertAppInfo.adPosition, -1);
            int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, i));
            if ((6 == status || 7 == status) && j.isNetWorkAvailable() && !j.isWifiNet()) {
                AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, i, true, "");
                return;
            }
            AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.jHd, z);
            AdCardBaseView.this.cBp();
        }

        private void j(AdvertAppInfo advertAppInfo) {
            String scheme = this.jHA.getScheme();
            if (k.isEmpty(scheme) && advertAppInfo != null) {
                scheme = advertAppInfo.cIU;
            }
            int c = com.baidu.tieba.recapp.s.c(AdCardBaseView.this.cRe, scheme, advertAppInfo.cIS);
            if (AdCardBaseView.this.hWE != null) {
                AdCardBaseView.this.hWE.b(c, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cBp() {
        if (this.hWE != null) {
            this.hWE.b(3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String HE(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.hVf != null && this.hVf.isValid()) {
            String c0540a = this.hVf.toString();
            if (!TextUtils.isEmpty(c0540a)) {
                sb.append(ETAG.ITEM_SEPARATOR);
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(c0540a));
            }
        }
        if (!TextUtils.isEmpty(this.jHi.getPreLoadData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.jHi.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.jHi.getNextPageData())) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append(ETAG.EQUAL);
            sb.append(URLEncoder.encode(this.jHi.getNextPageData()));
        }
        if (this.jHi.hasAnimation()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.jHi.isGoLandingPage()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        if (this.jHi.isImmersiveStyle()) {
            sb.append(ETAG.ITEM_SEPARATOR);
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append(ETAG.EQUAL);
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes11.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> jHz;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.jHz = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.jHz.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.jHh) ? false : true)) && adCardBaseView.jHh.equals(downloadData.getId())) {
                    int status = e.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.jGZ.setText(R.string.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.jGZ.setText(R.string.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> jHz;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.jHz = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.jHz.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.jHh) && adCardBaseView.jHh.equals(downloadData.getId())) {
                adCardBaseView.jHd.t(downloadData);
            }
        }
    }

    /* loaded from: classes11.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> jHz;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.jHz = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.jHz.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                String str = null;
                if (adCardBaseView.jHi != null && adCardBaseView.jHi.getAdvertAppInfo() != null) {
                    str = adCardBaseView.jHi.getAdvertAppInfo().cIS;
                }
                com.baidu.tieba.recapp.s.b(adCardBaseView.cRe, adCardBaseView.jHn.scheme, str);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void caI() {
        if (4 == getBusinessType()) {
            this.hPh.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.jGv != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.jHn = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.cRe.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.cRe, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        return true;
    }

    private void a(View view, TextView textView, ApkDownloadView apkDownloadView, AdCard adCard) {
        if (adCard == null) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        if (adCard.getAdvertAppInfo().aya()) {
            textView.setVisibility(8);
            apkDownloadView.setVisibility(0);
        } else if (true == k.isEmpty(adCard.buttonText) || "立即查看".equals(adCard.buttonText)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.cIV);
        downloadData.setUrl(advertAppInfo.apkUrl);
        downloadData.setName(advertAppInfo.cIT);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.f.b.toInt(advertAppInfo.cIS, 0));
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
