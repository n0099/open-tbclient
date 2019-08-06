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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.b.a;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.download.g;
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
    protected View eCR;
    protected View ein;
    protected TextView gYx;
    private a.C0354a hel;
    private final int hfV;
    protected final int iIA;
    protected final int iIB;
    private int iIC;
    private int iID;
    private int iIE;
    protected TextView iIF;
    protected TextView iIG;
    private AdCloseView iIH;
    private LinearLayout iII;
    protected ApkDownloadView iIJ;
    protected TextView iIK;
    protected RelativeLayout iIL;
    protected View iIM;
    protected String iIN;
    private AdCard iIO;
    private AdThreadCommentAndPraiseInfoLayout iIP;
    protected AdThreadUserInfoLayout iIQ;
    protected View iIR;
    protected View iIS;
    protected AdCard.b iIT;
    protected CustomMessageListener iIU;
    protected CustomMessageListener iIV;
    protected CustomMessageListener iIW;
    protected ViewStub iIr;
    protected View iIs;
    protected View iIt;
    protected final int iIu;
    protected final int iIv;
    protected final int iIw;
    protected final int iIx;
    protected final int iIy;
    protected final int iIz;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void cQ(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hfV = l.af(getContext());
        this.iIU = new a(2016484, this);
        this.iIV = new d(2016483, this);
        this.iIW = new c(2016494, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.ds640);
        this.mImageHeight = (int) resources.getDimension(R.dimen.ds278);
        this.iIu = (int) resources.getDimension(R.dimen.tbds92);
        this.iIv = (int) resources.getDimension(R.dimen.tbds92);
        this.iIw = (int) resources.getDimension(R.dimen.tbds20);
        this.iIz = (int) resources.getDimension(R.dimen.tbds90);
        this.iIA = (int) resources.getDimension(R.dimen.tbds90);
        this.iIB = (int) resources.getDimension(R.dimen.tbds22);
        this.iIx = (int) resources.getDimension(R.dimen.tbds44);
        this.iIy = (int) resources.getDimension(R.dimen.tbds44);
        this.iIC = (int) resources.getDimension(R.dimen.ds12);
        this.iID = (int) resources.getDimension(R.dimen.ds1);
        this.iIE = (int) resources.getDimension(R.dimen.ds18);
    }

    protected void r(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.iIP.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bKJ() {
        MessageManager.getInstance().registerListener(this.iIU);
        MessageManager.getInstance().registerListener(this.iIV);
        MessageManager.getInstance().registerListener(this.iIW);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.ein = this.mRootView.findViewById(R.id.bottom_line);
        this.iIt = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.iIt.setClickable(true);
        this.gYx = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.iIF = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.iIJ = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.iIK = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.iIL = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.iIJ.s(this.mContext.getUniqueId());
        this.iIU.setTag(this.mContext.getUniqueId());
        this.iIM = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.iIV.setTag(this.mContext.getUniqueId());
        this.iIW.setTag(this.mContext.getUniqueId());
        this.iIP = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.iIP.setStyle(1);
        this.iIQ = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        if (1 == getBusinessType()) {
            this.iIQ.setShowFlag(1413);
        }
        this.iII = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.iIH = (AdCloseView) this.iII.findViewById(R.id.ad_close_view);
        this.iIG = (TextView) this.iII.findViewById(R.id.feed_tag);
        this.iIG.setVisibility(8);
        this.iIQ.addAdTagView(this.iII);
        this.eCR = this.mRootView.findViewById(R.id.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.af(getContext()) - this.iIx) - this.iIy) - this.iIu) - this.iIw;
            this.iIP.setVisibility(8);
        } else {
            this.mMaxWidth = (l.af(getContext()) - this.iIx) - this.iIy;
            this.iIP.setVisibility(0);
        }
        this.iIr = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.iIr.setLayoutResource(getCustomLayout());
        this.iIs = this.iIr.inflate();
        this.iIR = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.iIS = this.mRootView.findViewById(R.id.frs_bottom_view);
        cQ(this.iIs);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(final AdCard adCard) {
        final String str;
        this.iIO = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.iIQ.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.amh() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.aS(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.iIJ.setOnClickListener(bVar);
        this.iIF.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iIM.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.iIu + this.iIw;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.iIQ.getHeaderImg(), adCard.portraitClick, bVar);
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String DK = DK(aq.i(str2, 100, "..."));
            if (4 == getBusinessType()) {
                this.gYx.setTextSize(0, getContext().getResources().getDimension(R.dimen.ds32));
            } else {
                this.gYx.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize44));
            }
            this.gYx.setText(DK);
            this.gYx.setVisibility(0);
        } else {
            this.gYx.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.acJ()) && true == k.isEmpty(str3);
        a(this.iIL, this.iIF, this.iIJ, adCard);
        if (advertAppInfo != null && advertAppInfo.acI()) {
            this.iIK.setText(adCard.userName.concat("APP").concat(" · 广告").toString());
        } else if (advertAppInfo != null && advertAppInfo.acJ()) {
            String str4 = adCard.tagName;
            if (TextUtils.isEmpty(str4)) {
                str4 = "广告";
            }
            this.iIK.setText(str4);
        }
        if (advertAppInfo != null && advertAppInfo.acI()) {
            this.iIN = advertAppInfo.bEY;
            this.iIJ.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.g.b.f(advertAppInfo.adPosition, -1));
            c2.setStatus(ApkDownloadView.getStatus(c2));
            a(this.iIF, c2.getStatus(), str3);
            this.iIJ.setData(c2);
            this.iIJ.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    am.f(this.iIF, R.color.btn_forum_focus_color, 1);
                    this.iIF.setText(str3);
                    if (k.isEmpty(str)) {
                        this.iIF.setClickable(false);
                    } else {
                        this.iIF.setClickable(true);
                        this.iIF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.hfO != null && adCard.buttonClick != null && !s.EC(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.hfO.b(adCard.buttonClick.abI, adCard.buttonClick.abJ, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int e = com.baidu.tieba.recapp.s.e(AdCardBaseView.this.mContext, str);
                                        if ((e == 1 || e == 2) && AdCardBaseView.this.hfO != null) {
                                            AdCardBaseView.this.hfO.b(e, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.mContext.getPageActivity());
                                    aVar.mO(adCard.popWindowText);
                                    aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int e2 = com.baidu.tieba.recapp.s.e(AdCardBaseView.this.mContext, str);
                                            if ((e2 == 1 || e2 == 2) && AdCardBaseView.this.hfO != null) {
                                                AdCardBaseView.this.hfO.b(e2, null);
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
                                    aVar.b(AdCardBaseView.this.mContext).agK();
                                }
                            }
                        });
                    }
                } else {
                    this.iIF.setClickable(false);
                    this.iIF.setText(adCard.buttonTextDone);
                    am.k(this.iIF, R.drawable.btn_rounded_corner_gray_frame);
                    am.f(this.iIF, R.color.cp_cont_d, 1);
                }
            }
            this.iIJ.setVisibility(8);
        }
        a(adCard);
        r(i.aca().ace(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            DL(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.bFe != null && advertAppInfo.bFe.adCloseInfo != null && advertAppInfo.bFe.adCloseInfo.support_close.intValue() > 0) {
            this.iIH.setVisibility(0);
            this.iIH.setPage(getBusinessType());
            this.iIH.setData(advertAppInfo);
            l.b(this.mContext.getPageActivity(), this.iII, 40, 40, 40, 120);
            this.iII.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.iIH.performClick();
                }
            });
        } else {
            this.iIH.setVisibility(8);
            this.iIG.setOnClickListener(null);
        }
        this.iIP.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.ein.getLayoutParams();
        if (4 == getBusinessType()) {
            this.iIP.setVisibility(8);
            this.iIP.setBarNameClickEnabled(false);
            this.iIP.setShareVisible(false);
            this.iIP.setShowPraiseNum(false);
            this.iIP.setCommentNumEnable(false);
            this.iIP.setReplyTimeVisible(false);
            layoutParams2.height = this.iID;
            this.iIR.setVisibility(0);
            this.iIS.setVisibility(8);
        } else {
            a(adCard, bVar);
        }
        a(adCard, this.eCR, getBusinessType());
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 instanceof AdvertAppInfo) {
            advertAppInfo2.mx(aq.aE(adCard.time));
        }
        this.iIQ.setData(advertAppInfo2);
        ((TextView) this.iIQ.getUserName()).setText(adCard.userName);
        this.iIQ.getUserName().setOnClickListener(bVar);
        this.iIQ.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.iIQ.getUserName()).setText(adCard.userName);
            }
        });
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.blf().blg()) {
            this.iIt.setVisibility(0);
            am.l(this.iIt, R.color.cp_bg_line_d);
        } else {
            this.iIt.setVisibility(8);
        }
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean isInFrsAllThread() {
        return this.heP == 1;
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.iIS.setVisibility(0);
            this.iIP.setVisibility(8);
            return;
        }
        this.iIS.setVisibility(8);
        this.iIP.setVisibility(0);
        this.iIP.setBarNameClickEnabled(false);
        this.iIP.setReplyTimeVisible(false);
        this.iIP.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.iIP.setAgreeClickable(true);
            this.iIP.setPraiseContainerBgGray(false);
        } else {
            this.iIP.setAgreeClickable(false);
            this.iIP.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.iIP.setShareClickable(true);
            this.iIP.setShareContainerBgGray(false);
        } else {
            this.iIP.setShareClickable(false);
            this.iIP.setShareContainerBgGray(true);
        }
        if (this.iIP.getCommentContainer() != null) {
            this.iIP.getCommentContainer().setOnClickListener(bVar);
        }
        this.iIP.setNeedAddReplyIcon(true);
        this.iIP.setCommentNumEnable(false);
        this.iIP.setCommentClickable(true);
        this.iIP.setReplayContainerBgGray(true);
        this.iIP.setOnClickListener(bVar);
        this.iIP.setShareData(adCard);
        this.iIP.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        am.k(this.ein, R.color.cp_bg_line_c);
        this.iIH.onChangeSkinType();
        this.iIQ.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        this.iIP.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            am.k(this.mRootView, R.drawable.addresslist_item_bg);
            am.l(this.ein, R.color.cp_bg_line_e);
            am.l(this.eCR, R.color.cp_bg_line_e);
        } else {
            am.l(this.ein, R.color.cp_bg_line_c);
            am.l(this.eCR, R.color.transparent);
        }
        am.f(this.gYx, R.color.cp_cont_b, 1);
        am.j(this.iIK, R.color.cp_cont_d);
        am.f(this.iIG, R.color.cp_cont_d, 1);
        this.iIJ.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String DK(String str) {
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
            if (b(bVar) && !s.EC(bVar.scheme)) {
                if (this.hfO != null) {
                    this.hfO.b(bVar.abI, bVar.abJ, null);
                    return;
                }
                return;
            }
            int e = com.baidu.tieba.recapp.s.e(this.mContext, DM(bVar.scheme));
            if (e == 1 || e == 2) {
                if (this.hfO != null) {
                    this.hfO.b(e, null);
                }
            } else if (this.hfO != null) {
                this.hfO.b(bVar.abI, bVar.abJ, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final TbImageView tbImageView, final AdCard.b bVar) {
        if (tbImageView != null) {
            if (bVar != null && !k.isEmpty(bVar.scheme)) {
                tbImageView.setClickable(true);
                tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (AdCardBaseView.this.iIO.hasAnimation()) {
                            AdCardBaseView.this.e(tbImageView);
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
                view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.6
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
    public void e(TbImageView tbImageView) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        tbImageView.getLocationOnScreen(iArr);
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + tbImageView.getWidth();
        rect.bottom = rect.top + tbImageView.getHeight();
        this.hel = new a.C0354a();
        this.hel.picUrl = tbImageView.getUrl();
        this.hel.cxj = rect;
    }

    private void DL(String str) {
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
                    com.baidu.adp.lib.f.c.iE().a(jSONObject.optString("pic_url"), 17, null, this.hfV, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.hfV), this.mContext.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.acH() != 0) {
                l.showToast(this.mContext.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.ajS();
            this.mPermissionJudgePolicy.e(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.ad(this.mContext.getPageActivity()) && this.hfP != null) {
                this.hfP.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.p(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.jQ()) {
                l.showToast(this.mContext.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.acI()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.mO(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.iIJ);
                        if (AdCardBaseView.this.iIJ != null) {
                            AdCardBaseView.this.iIJ.p(AdCardBaseView.this.c(advertAppInfo, i));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).agK();
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
                        g.f(advertAppInfo);
                        apkDownloadView.q(c2);
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
                    a(advertAppInfo, i, this.iIJ);
                    apkDownloadView.r(c2);
                    return;
            }
            g.aG(this.mContext.getPageActivity(), advertAppInfo.bEY);
        }
    }

    public a.C0354a getAnimationInfo() {
        return this.hel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private AdCard iJg;

        public b(AdCard adCard) {
            this.iJg = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jQ()) {
                AdCardBaseView.this.mContext.showToast(R.string.neterror);
            } else if (this.iJg != null) {
                AdvertAppInfo advertAppInfo = this.iJg.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.iIJ;
                if (advertAppInfo != null && advertAppInfo.acI()) {
                    int f = com.baidu.adp.lib.g.b.f(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, f));
                    if ((6 == status || 7 == status) && j.kc() && !j.kd()) {
                        AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, f, true, this.iJg.popWindowText);
                        return;
                    }
                    AdCardBaseView.this.a(advertAppInfo, f, AdCardBaseView.this.iIJ, z);
                    if (AdCardBaseView.this.hfO != null) {
                        AdCardBaseView.this.hfO.b(3, null);
                        return;
                    }
                    return;
                }
                String scheme = this.iJg.getScheme();
                if (k.isEmpty(scheme) && advertAppInfo != null) {
                    scheme = advertAppInfo.bEW;
                }
                if (this.iJg.hasAnimation()) {
                }
                int e = com.baidu.tieba.recapp.s.e(AdCardBaseView.this.mContext, AdCardBaseView.this.DM(scheme));
                if (AdCardBaseView.this.hfO != null) {
                    AdCardBaseView.this.hfO.b(e, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String DM(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.hel != null && this.hel.isValid()) {
            String c0354a = this.hel.toString();
            if (!TextUtils.isEmpty(c0354a)) {
                sb.append("&");
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append("=");
                sb.append(URLEncoder.encode(c0354a));
            }
        }
        if (!TextUtils.isEmpty(this.iIO.getPreLoadData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append("=");
            sb.append(URLEncoder.encode(this.iIO.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.iIO.getNextPageData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append("=");
            sb.append(URLEncoder.encode(this.iIO.getNextPageData()));
        }
        if (this.iIO.hasAnimation()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append("=");
            sb.append("1");
        }
        if (this.iIO.isGoLandingPage()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append("=");
            sb.append("1");
        }
        if (this.iIO.isImmersiveStyle()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append("=");
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> iJf;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.iJf = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.iJf.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.iIN) ? false : true)) && adCardBaseView.iIN.equals(downloadData.getId())) {
                    int status = com.baidu.tieba.recapp.download.d.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.iIF.setText(R.string.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.iIF.setText(R.string.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> iJf;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.iJf = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.iJf.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.iIN) && adCardBaseView.iIN.equals(downloadData.getId())) {
                adCardBaseView.iIJ.s(downloadData);
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> iJf;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.iJf = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.iJf.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                com.baidu.tieba.recapp.s.e(adCardBaseView.mContext, adCardBaseView.iIT.scheme);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void bKQ() {
        if (4 == getBusinessType()) {
            this.gYx.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.iIb != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.iIT = bVar;
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.mContext.getPageActivity(), true);
        loginActivityConfig.getIntent().putExtra(LoginActivityConfig.USER_INFO_CHANGED, AdCard.DEAL_URL_AFTER_LOGIN);
        TbadkCoreApplication.getInst().login(this.mContext, new CustomMessage<>(2002001, loginActivityConfig));
        return true;
    }

    private void a(View view, TextView textView, ApkDownloadView apkDownloadView, AdCard adCard) {
        if (adCard == null) {
            view.setVisibility(8);
            return;
        }
        view.setVisibility(0);
        if (adCard.getAdvertAppInfo().acI()) {
            textView.setVisibility(8);
            apkDownloadView.setVisibility(0);
        } else if (true == k.isEmpty(adCard.buttonText) || "立即查看".equals(adCard.buttonText)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bEY);
        downloadData.setUrl(advertAppInfo.bEX);
        downloadData.setName(advertAppInfo.bEV);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.f(advertAppInfo.bEU, 0));
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
        }
    }
}
