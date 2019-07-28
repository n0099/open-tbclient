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
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.recapp.view.AdThreadUserInfoLayout;
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
    protected View eCK;
    protected View eig;
    protected TextView gXF;
    private a.C0354a hdt;
    private final int hfd;
    private int iHA;
    protected TextView iHB;
    protected TextView iHC;
    private AdCloseView iHD;
    private LinearLayout iHE;
    protected ApkDownloadView iHF;
    protected TextView iHG;
    protected RelativeLayout iHH;
    protected View iHI;
    protected String iHJ;
    private AdCard iHK;
    private AdThreadCommentAndPraiseInfoLayout iHL;
    protected AdThreadUserInfoLayout iHM;
    protected View iHN;
    protected View iHO;
    protected AdCard.b iHP;
    protected CustomMessageListener iHQ;
    protected CustomMessageListener iHR;
    protected CustomMessageListener iHS;
    protected ViewStub iHn;
    protected View iHo;
    protected View iHp;
    protected final int iHq;
    protected final int iHr;
    protected final int iHs;
    protected final int iHt;
    protected final int iHu;
    protected final int iHv;
    protected final int iHw;
    protected final int iHx;
    private int iHy;
    private int iHz;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void cO(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hfd = l.af(getContext());
        this.iHQ = new a(2016484, this);
        this.iHR = new d(2016483, this);
        this.iHS = new c(2016494, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.ds640);
        this.mImageHeight = (int) resources.getDimension(R.dimen.ds278);
        this.iHq = (int) resources.getDimension(R.dimen.tbds92);
        this.iHr = (int) resources.getDimension(R.dimen.tbds92);
        this.iHs = (int) resources.getDimension(R.dimen.tbds20);
        this.iHv = (int) resources.getDimension(R.dimen.tbds90);
        this.iHw = (int) resources.getDimension(R.dimen.tbds90);
        this.iHx = (int) resources.getDimension(R.dimen.tbds22);
        this.iHt = (int) resources.getDimension(R.dimen.tbds44);
        this.iHu = (int) resources.getDimension(R.dimen.tbds44);
        this.iHy = (int) resources.getDimension(R.dimen.ds12);
        this.iHz = (int) resources.getDimension(R.dimen.ds1);
        this.iHA = (int) resources.getDimension(R.dimen.ds18);
    }

    protected void r(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.iHL.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bKv() {
        MessageManager.getInstance().registerListener(this.iHQ);
        MessageManager.getInstance().registerListener(this.iHR);
        MessageManager.getInstance().registerListener(this.iHS);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.eig = this.mRootView.findViewById(R.id.bottom_line);
        this.iHp = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.iHp.setClickable(true);
        this.gXF = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.iHB = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.iHF = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.iHG = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.iHH = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.iHF.s(this.mContext.getUniqueId());
        this.iHQ.setTag(this.mContext.getUniqueId());
        this.iHI = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.iHR.setTag(this.mContext.getUniqueId());
        this.iHS.setTag(this.mContext.getUniqueId());
        this.iHL = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.iHL.setStyle(1);
        this.iHM = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        if (1 == getBusinessType()) {
            this.iHM.setShowFlag(1413);
        }
        this.iHE = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.iHD = (AdCloseView) this.iHE.findViewById(R.id.ad_close_view);
        this.iHC = (TextView) this.iHE.findViewById(R.id.feed_tag);
        this.iHC.setVisibility(8);
        this.iHM.addAdTagView(this.iHE);
        this.eCK = this.mRootView.findViewById(R.id.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.af(getContext()) - this.iHt) - this.iHu) - this.iHq) - this.iHs;
            this.iHL.setVisibility(8);
        } else {
            this.mMaxWidth = (l.af(getContext()) - this.iHt) - this.iHu;
            this.iHL.setVisibility(0);
        }
        this.iHn = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.iHn.setLayoutResource(getCustomLayout());
        this.iHo = this.iHn.inflate();
        this.iHN = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.iHO = this.mRootView.findViewById(R.id.frs_bottom_view);
        cO(this.iHo);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(final AdCard adCard) {
        final String str;
        this.iHK = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.iHM.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.amf() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.aS(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.iHF.setOnClickListener(bVar);
        this.iHB.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iHI.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.iHq + this.iHs;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.iHM.getHeaderImg(), adCard.portraitClick, bVar);
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String DJ = DJ(aq.i(str2, 100, "..."));
            if (4 == getBusinessType()) {
                this.gXF.setTextSize(0, getContext().getResources().getDimension(R.dimen.ds32));
            } else {
                this.gXF.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize44));
            }
            this.gXF.setText(DJ);
            this.gXF.setVisibility(0);
        } else {
            this.gXF.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.acI()) && true == k.isEmpty(str3);
        a(this.iHH, this.iHB, this.iHF, adCard);
        if (advertAppInfo != null && advertAppInfo.acH()) {
            this.iHG.setText(adCard.userName.concat("APP").concat(" · 广告").toString());
        } else if (advertAppInfo != null && advertAppInfo.acI()) {
            String str4 = adCard.tagName;
            if (TextUtils.isEmpty(str4)) {
                str4 = "广告";
            }
            this.iHG.setText(str4);
        }
        if (advertAppInfo != null && advertAppInfo.acH()) {
            this.iHJ = advertAppInfo.bEX;
            this.iHF.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.g.b.f(advertAppInfo.adPosition, -1));
            c2.setStatus(ApkDownloadView.getStatus(c2));
            a(this.iHB, c2.getStatus(), str3);
            this.iHF.setData(c2);
            this.iHF.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    am.f(this.iHB, R.color.btn_forum_focus_color, 1);
                    this.iHB.setText(str3);
                    if (k.isEmpty(str)) {
                        this.iHB.setClickable(false);
                    } else {
                        this.iHB.setClickable(true);
                        this.iHB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.heW != null && adCard.buttonClick != null && !q.EB(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.heW.b(adCard.buttonClick.abI, adCard.buttonClick.abJ, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int e = s.e(AdCardBaseView.this.mContext, str);
                                        if ((e == 1 || e == 2) && AdCardBaseView.this.heW != null) {
                                            AdCardBaseView.this.heW.b(e, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.mContext.getPageActivity());
                                    aVar.mO(adCard.popWindowText);
                                    aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int e2 = s.e(AdCardBaseView.this.mContext, str);
                                            if ((e2 == 1 || e2 == 2) && AdCardBaseView.this.heW != null) {
                                                AdCardBaseView.this.heW.b(e2, null);
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
                                    aVar.b(AdCardBaseView.this.mContext).agI();
                                }
                            }
                        });
                    }
                } else {
                    this.iHB.setClickable(false);
                    this.iHB.setText(adCard.buttonTextDone);
                    am.k(this.iHB, R.drawable.btn_rounded_corner_gray_frame);
                    am.f(this.iHB, R.color.cp_cont_d, 1);
                }
            }
            this.iHF.setVisibility(8);
        }
        a(adCard);
        r(i.aca().ace(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            DK(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.bFd != null && advertAppInfo.bFd.adCloseInfo != null && advertAppInfo.bFd.adCloseInfo.support_close.intValue() > 0) {
            this.iHD.setVisibility(0);
            this.iHD.setPage(getBusinessType());
            this.iHD.setData(advertAppInfo);
            l.b(this.mContext.getPageActivity(), this.iHE, 40, 40, 40, 120);
            this.iHE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.iHD.performClick();
                }
            });
        } else {
            this.iHD.setVisibility(8);
            this.iHC.setOnClickListener(null);
        }
        this.iHL.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.eig.getLayoutParams();
        if (4 == getBusinessType()) {
            this.iHL.setVisibility(8);
            this.iHL.setBarNameClickEnabled(false);
            this.iHL.setShareVisible(false);
            this.iHL.setShowPraiseNum(false);
            this.iHL.setCommentNumEnable(false);
            this.iHL.setReplyTimeVisible(false);
            layoutParams2.height = this.iHz;
            this.iHN.setVisibility(0);
            this.iHO.setVisibility(8);
        } else {
            a(adCard, bVar);
        }
        a(adCard, this.eCK, getBusinessType());
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 instanceof AdvertAppInfo) {
            advertAppInfo2.mx(aq.aE(adCard.time));
        }
        this.iHM.setData(advertAppInfo2);
        ((TextView) this.iHM.getUserName()).setText(adCard.userName);
        this.iHM.getUserName().setOnClickListener(bVar);
        this.iHM.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.iHM.getUserName()).setText(adCard.userName);
            }
        });
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bkY().bkZ()) {
            this.iHp.setVisibility(0);
            am.l(this.iHp, R.color.cp_bg_line_d);
        } else {
            this.iHp.setVisibility(8);
        }
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean isInFrsAllThread() {
        return this.hdX == 1;
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.iHO.setVisibility(0);
            this.iHL.setVisibility(8);
            return;
        }
        this.iHO.setVisibility(8);
        this.iHL.setVisibility(0);
        this.iHL.setBarNameClickEnabled(false);
        this.iHL.setReplyTimeVisible(false);
        this.iHL.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.iHL.setAgreeClickable(true);
            this.iHL.setPraiseContainerBgGray(false);
        } else {
            this.iHL.setAgreeClickable(false);
            this.iHL.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.iHL.setShareClickable(true);
            this.iHL.setShareContainerBgGray(false);
        } else {
            this.iHL.setShareClickable(false);
            this.iHL.setShareContainerBgGray(true);
        }
        if (this.iHL.getCommentContainer() != null) {
            this.iHL.getCommentContainer().setOnClickListener(bVar);
        }
        this.iHL.setNeedAddReplyIcon(true);
        this.iHL.setCommentNumEnable(false);
        this.iHL.setCommentClickable(true);
        this.iHL.setReplayContainerBgGray(true);
        this.iHL.setOnClickListener(bVar);
        this.iHL.setShareData(adCard);
        this.iHL.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        am.k(this.eig, R.color.cp_bg_line_c);
        this.iHD.onChangeSkinType();
        this.iHM.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        this.iHL.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            am.k(this.mRootView, R.drawable.addresslist_item_bg);
            am.l(this.eig, R.color.cp_bg_line_e);
            am.l(this.eCK, R.color.cp_bg_line_e);
        } else {
            am.l(this.eig, R.color.cp_bg_line_c);
            am.l(this.eCK, R.color.transparent);
        }
        am.f(this.gXF, R.color.cp_cont_b, 1);
        am.j(this.iHG, R.color.cp_cont_d);
        am.f(this.iHC, R.color.cp_cont_d, 1);
        this.iHF.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String DJ(String str) {
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
            if (b(bVar) && !q.EB(bVar.scheme)) {
                if (this.heW != null) {
                    this.heW.b(bVar.abI, bVar.abJ, null);
                    return;
                }
                return;
            }
            int e = s.e(this.mContext, DL(bVar.scheme));
            if (e == 1 || e == 2) {
                if (this.heW != null) {
                    this.heW.b(e, null);
                }
            } else if (this.heW != null) {
                this.heW.b(bVar.abI, bVar.abJ, null);
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
                        if (AdCardBaseView.this.iHK.hasAnimation()) {
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
        this.hdt = new a.C0354a();
        this.hdt.picUrl = tbImageView.getUrl();
        this.hdt.cxc = rect;
    }

    private void DK(String str) {
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
                    com.baidu.adp.lib.f.c.iE().a(jSONObject.optString("pic_url"), 17, null, this.hfd, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.hfd), this.mContext.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.acG() != 0) {
                l.showToast(this.mContext.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.ajQ();
            this.mPermissionJudgePolicy.e(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.ad(this.mContext.getPageActivity()) && this.heX != null) {
                this.heX.b(advertAppInfo, i);
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
            } else if (advertAppInfo.acH()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.mO(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.iHF);
                        if (AdCardBaseView.this.iHF != null) {
                            AdCardBaseView.this.iHF.p(AdCardBaseView.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).agI();
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
                    a(advertAppInfo, i, this.iHF);
                    apkDownloadView.r(c2);
                    return;
            }
            g.aG(this.mContext.getPageActivity(), advertAppInfo.bEX);
        }
    }

    public a.C0354a getAnimationInfo() {
        return this.hdt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private AdCard iIc;

        public b(AdCard adCard) {
            this.iIc = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jQ()) {
                AdCardBaseView.this.mContext.showToast(R.string.neterror);
            } else if (this.iIc != null) {
                AdvertAppInfo advertAppInfo = this.iIc.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.iHF;
                if (advertAppInfo != null && advertAppInfo.acH()) {
                    int f = com.baidu.adp.lib.g.b.f(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, f));
                    if ((6 == status || 7 == status) && j.kc() && !j.kd()) {
                        AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, f, true, this.iIc.popWindowText);
                        return;
                    }
                    AdCardBaseView.this.a(advertAppInfo, f, AdCardBaseView.this.iHF, z);
                    if (AdCardBaseView.this.heW != null) {
                        AdCardBaseView.this.heW.b(3, null);
                        return;
                    }
                    return;
                }
                String scheme = this.iIc.getScheme();
                if (k.isEmpty(scheme) && advertAppInfo != null) {
                    scheme = advertAppInfo.bEV;
                }
                if (this.iIc.hasAnimation()) {
                }
                int e = s.e(AdCardBaseView.this.mContext, AdCardBaseView.this.DL(scheme));
                if (AdCardBaseView.this.heW != null) {
                    AdCardBaseView.this.heW.b(e, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String DL(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.hdt != null && this.hdt.isValid()) {
            String c0354a = this.hdt.toString();
            if (!TextUtils.isEmpty(c0354a)) {
                sb.append("&");
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append("=");
                sb.append(URLEncoder.encode(c0354a));
            }
        }
        if (!TextUtils.isEmpty(this.iHK.getPreLoadData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append("=");
            sb.append(URLEncoder.encode(this.iHK.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.iHK.getNextPageData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append("=");
            sb.append(URLEncoder.encode(this.iHK.getNextPageData()));
        }
        if (this.iHK.hasAnimation()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append("=");
            sb.append("1");
        }
        if (this.iHK.isGoLandingPage()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append("=");
            sb.append("1");
        }
        if (this.iHK.isImmersiveStyle()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append("=");
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> iIb;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.iIb = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.iIb.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.iHJ) ? false : true)) && adCardBaseView.iHJ.equals(downloadData.getId())) {
                    int status = com.baidu.tieba.recapp.download.d.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.iHB.setText(R.string.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.iHB.setText(R.string.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> iIb;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.iIb = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.iIb.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.iHJ) && adCardBaseView.iHJ.equals(downloadData.getId())) {
                adCardBaseView.iHF.s(downloadData);
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> iIb;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.iIb = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.iIb.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                s.e(adCardBaseView.mContext, adCardBaseView.iHP.scheme);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void bKC() {
        if (4 == getBusinessType()) {
            this.gXF.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.iGX != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.iHP = bVar;
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
        if (adCard.getAdvertAppInfo().acH()) {
            textView.setVisibility(8);
            apkDownloadView.setVisibility(0);
        } else if (true == k.isEmpty(adCard.buttonText) || "立即查看".equals(adCard.buttonText)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bEX);
        downloadData.setUrl(advertAppInfo.bEW);
        downloadData.setName(advertAppInfo.bEU);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.f(advertAppInfo.bET, 0));
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
