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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
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
    protected View edD;
    protected View exL;
    protected TextView gRq;
    private a.C0349a gXe;
    private final int gYN;
    protected ViewStub iAS;
    protected View iAT;
    protected View iAU;
    protected final int iAV;
    protected final int iAW;
    protected final int iAX;
    protected final int iAY;
    protected final int iAZ;
    protected final int iBa;
    protected final int iBb;
    protected final int iBc;
    private int iBd;
    private int iBe;
    private int iBf;
    protected TextView iBg;
    protected TextView iBh;
    private AdCloseView iBi;
    private LinearLayout iBj;
    protected ApkDownloadView iBk;
    protected TextView iBl;
    protected RelativeLayout iBm;
    protected View iBn;
    protected String iBo;
    private AdCard iBp;
    private AdThreadCommentAndPraiseInfoLayout iBq;
    protected AdThreadUserInfoLayout iBr;
    protected View iBs;
    protected View iBt;
    protected AdCard.b iBu;
    protected CustomMessageListener iBv;
    protected CustomMessageListener iBw;
    protected CustomMessageListener iBx;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void cL(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gYN = l.af(getContext());
        this.iBv = new a(2016484, this);
        this.iBw = new d(2016483, this);
        this.iBx = new c(2016494, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.ds640);
        this.mImageHeight = (int) resources.getDimension(R.dimen.ds278);
        this.iAV = (int) resources.getDimension(R.dimen.tbds92);
        this.iAW = (int) resources.getDimension(R.dimen.tbds92);
        this.iAX = (int) resources.getDimension(R.dimen.tbds20);
        this.iBa = (int) resources.getDimension(R.dimen.tbds90);
        this.iBb = (int) resources.getDimension(R.dimen.tbds90);
        this.iBc = (int) resources.getDimension(R.dimen.tbds22);
        this.iAY = (int) resources.getDimension(R.dimen.tbds44);
        this.iAZ = (int) resources.getDimension(R.dimen.tbds44);
        this.iBd = (int) resources.getDimension(R.dimen.ds12);
        this.iBe = (int) resources.getDimension(R.dimen.ds1);
        this.iBf = (int) resources.getDimension(R.dimen.ds18);
    }

    protected void r(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.iBq.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bHK() {
        MessageManager.getInstance().registerListener(this.iBv);
        MessageManager.getInstance().registerListener(this.iBw);
        MessageManager.getInstance().registerListener(this.iBx);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.edD = this.mRootView.findViewById(R.id.bottom_line);
        this.iAU = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.iAU.setClickable(true);
        this.gRq = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.iBg = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.iBk = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.iBl = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.iBm = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.iBk.s(this.mContext.getUniqueId());
        this.iBv.setTag(this.mContext.getUniqueId());
        this.iBn = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.iBw.setTag(this.mContext.getUniqueId());
        this.iBx.setTag(this.mContext.getUniqueId());
        this.iBq = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.iBq.setStyle(1);
        this.iBr = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        if (1 == getBusinessType()) {
            this.iBr.setShowFlag(1413);
        }
        this.iBj = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.iBi = (AdCloseView) this.iBj.findViewById(R.id.ad_close_view);
        this.iBh = (TextView) this.iBj.findViewById(R.id.feed_tag);
        this.iBh.setVisibility(8);
        this.iBr.addAdTagView(this.iBj);
        this.exL = this.mRootView.findViewById(R.id.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.af(getContext()) - this.iAY) - this.iAZ) - this.iAV) - this.iAX;
            this.iBq.setVisibility(8);
        } else {
            this.mMaxWidth = (l.af(getContext()) - this.iAY) - this.iAZ;
            this.iBq.setVisibility(0);
        }
        this.iAS = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.iAS.setLayoutResource(getCustomLayout());
        this.iAT = this.iAS.inflate();
        this.iBs = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.iBt = this.mRootView.findViewById(R.id.frs_bottom_view);
        cL(this.iAT);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(final AdCard adCard) {
        final String str;
        this.iBp = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.iBr.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.ala() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.aR(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.iBk.setOnClickListener(bVar);
        this.iBg.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iBn.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.iAV + this.iAX;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.iBr.getHeaderImg(), adCard.portraitClick, bVar);
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String CU = CU(ap.i(str2, 100, "..."));
            if (4 == getBusinessType()) {
                this.gRq.setTextSize(0, getContext().getResources().getDimension(R.dimen.ds32));
            } else {
                this.gRq.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize44));
            }
            this.gRq.setText(CU);
            this.gRq.setVisibility(0);
        } else {
            this.gRq.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.abG()) && true == k.isEmpty(str3);
        a(this.iBm, this.iBg, this.iBk, adCard);
        if (advertAppInfo != null && advertAppInfo.abF()) {
            this.iBl.setText(adCard.userName.concat("APP").concat(" · 广告").toString());
        } else if (advertAppInfo != null && advertAppInfo.abG()) {
            String str4 = adCard.tagName;
            if (TextUtils.isEmpty(str4)) {
                str4 = "广告";
            }
            this.iBl.setText(str4);
        }
        if (advertAppInfo != null && advertAppInfo.abF()) {
            this.iBo = advertAppInfo.bDW;
            this.iBk.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.g.b.f(advertAppInfo.adPosition, -1));
            c2.setStatus(ApkDownloadView.getStatus(c2));
            a(this.iBg, c2.getStatus(), str3);
            this.iBk.setData(c2);
            this.iBk.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    al.f(this.iBg, R.color.btn_forum_focus_color, 1);
                    this.iBg.setText(str3);
                    if (k.isEmpty(str)) {
                        this.iBg.setClickable(false);
                    } else {
                        this.iBg.setClickable(true);
                        this.iBg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.gYG != null && adCard.buttonClick != null && !q.DM(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.gYG.b(adCard.buttonClick.abk, adCard.buttonClick.abl, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int e = s.e(AdCardBaseView.this.mContext, str);
                                        if ((e == 1 || e == 2) && AdCardBaseView.this.gYG != null) {
                                            AdCardBaseView.this.gYG.b(e, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.mContext.getPageActivity());
                                    aVar.mE(adCard.popWindowText);
                                    aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int e2 = s.e(AdCardBaseView.this.mContext, str);
                                            if ((e2 == 1 || e2 == 2) && AdCardBaseView.this.gYG != null) {
                                                AdCardBaseView.this.gYG.b(e2, null);
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
                                    aVar.b(AdCardBaseView.this.mContext).afG();
                                }
                            }
                        });
                    }
                } else {
                    this.iBg.setClickable(false);
                    this.iBg.setText(adCard.buttonTextDone);
                    al.k(this.iBg, R.drawable.btn_rounded_corner_gray_frame);
                    al.f(this.iBg, R.color.cp_cont_d, 1);
                }
            }
            this.iBk.setVisibility(8);
        }
        a(adCard);
        r(i.abb().abf(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            CV(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.bEc != null && advertAppInfo.bEc.adCloseInfo != null && advertAppInfo.bEc.adCloseInfo.support_close.intValue() > 0) {
            this.iBi.setVisibility(0);
            this.iBi.setPage(getBusinessType());
            this.iBi.setData(advertAppInfo);
            l.b(this.mContext.getPageActivity(), this.iBj, 40, 40, 40, 120);
            this.iBj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.iBi.performClick();
                }
            });
        } else {
            this.iBi.setVisibility(8);
            this.iBh.setOnClickListener(null);
        }
        this.iBq.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.edD.getLayoutParams();
        if (4 == getBusinessType()) {
            this.iBq.setVisibility(8);
            this.iBq.setBarNameClickEnabled(false);
            this.iBq.setShareVisible(false);
            this.iBq.setShowPraiseNum(false);
            this.iBq.setCommentNumEnable(false);
            this.iBq.setReplyTimeVisible(false);
            layoutParams2.height = this.iBe;
            this.iBs.setVisibility(0);
            this.iBt.setVisibility(8);
        } else {
            a(adCard, bVar);
        }
        a(adCard, this.exL, getBusinessType());
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 instanceof AdvertAppInfo) {
            advertAppInfo2.mn(ap.aD(adCard.time));
        }
        this.iBr.setData(advertAppInfo2);
        ((TextView) this.iBr.getUserName()).setText(adCard.userName);
        this.iBr.getUserName().setOnClickListener(bVar);
        this.iBr.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.iBr.getUserName()).setText(adCard.userName);
            }
        });
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.biT().biU()) {
            this.iAU.setVisibility(0);
            al.l(this.iAU, R.color.cp_bg_line_d);
        } else {
            this.iAU.setVisibility(8);
        }
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean isInFrsAllThread() {
        return this.gXI == 1;
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.iBt.setVisibility(0);
            this.iBq.setVisibility(8);
            return;
        }
        this.iBt.setVisibility(8);
        this.iBq.setVisibility(0);
        this.iBq.setBarNameClickEnabled(false);
        this.iBq.setReplyTimeVisible(false);
        this.iBq.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.iBq.setAgreeClickable(true);
            this.iBq.setPraiseContainerBgGray(false);
        } else {
            this.iBq.setAgreeClickable(false);
            this.iBq.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.iBq.setShareClickable(true);
            this.iBq.setShareContainerBgGray(false);
        } else {
            this.iBq.setShareClickable(false);
            this.iBq.setShareContainerBgGray(true);
        }
        if (this.iBq.getCommentContainer() != null) {
            this.iBq.getCommentContainer().setOnClickListener(bVar);
        }
        this.iBq.setNeedAddReplyIcon(true);
        this.iBq.setCommentNumEnable(false);
        this.iBq.setCommentClickable(true);
        this.iBq.setReplayContainerBgGray(true);
        this.iBq.setOnClickListener(bVar);
        this.iBq.setShareData(adCard);
        this.iBq.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        al.k(this.edD, R.color.cp_bg_line_c);
        this.iBi.onChangeSkinType();
        this.iBr.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        this.iBq.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            al.k(this.mRootView, R.drawable.addresslist_item_bg);
            al.l(this.edD, R.color.cp_bg_line_e);
            al.l(this.exL, R.color.cp_bg_line_e);
        } else {
            al.l(this.edD, R.color.cp_bg_line_c);
            al.l(this.exL, R.color.transparent);
        }
        al.f(this.gRq, R.color.cp_cont_b, 1);
        al.j(this.iBl, R.color.cp_cont_d);
        al.f(this.iBh, R.color.cp_cont_d, 1);
        this.iBk.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String CU(String str) {
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
            if (b(bVar) && !q.DM(bVar.scheme)) {
                if (this.gYG != null) {
                    this.gYG.b(bVar.abk, bVar.abl, null);
                    return;
                }
                return;
            }
            int e = s.e(this.mContext, CW(bVar.scheme));
            if (e == 1 || e == 2) {
                if (this.gYG != null) {
                    this.gYG.b(e, null);
                }
            } else if (this.gYG != null) {
                this.gYG.b(bVar.abk, bVar.abl, null);
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
                        if (AdCardBaseView.this.iBp.hasAnimation()) {
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
        this.gXe = new a.C0349a();
        this.gXe.picUrl = tbImageView.getUrl();
        this.gXe.rect = rect;
    }

    private void CV(String str) {
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
                    com.baidu.adp.lib.f.c.iv().a(jSONObject.optString("pic_url"), 17, null, this.gYN, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.gYN), this.mContext.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.abE() != 0) {
                l.showToast(this.mContext.getPageActivity(), (int) R.string.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.aiM();
            this.mPermissionJudgePolicy.e(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.aa(this.mContext.getPageActivity()) && this.gYH != null) {
                this.gYH.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.p(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.jG()) {
                l.showToast(this.mContext.getPageActivity(), (int) R.string.neterror);
            } else if (advertAppInfo.abF()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(R.string.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.mE(str);
                aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.iBk);
                        if (AdCardBaseView.this.iBk != null) {
                            AdCardBaseView.this.iBk.p(AdCardBaseView.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).afG();
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
                    a(advertAppInfo, i, this.iBk);
                    apkDownloadView.r(c2);
                    return;
            }
            g.aF(this.mContext.getPageActivity(), advertAppInfo.bDW);
        }
    }

    public a.C0349a getAnimationInfo() {
        return this.gXe;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private AdCard iBH;

        public b(AdCard adCard) {
            this.iBH = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jG()) {
                AdCardBaseView.this.mContext.showToast(R.string.neterror);
            } else if (this.iBH != null) {
                AdvertAppInfo advertAppInfo = this.iBH.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.iBk;
                if (advertAppInfo != null && advertAppInfo.abF()) {
                    int f = com.baidu.adp.lib.g.b.f(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, f));
                    if ((6 == status || 7 == status) && j.jS() && !j.jT()) {
                        AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, f, true, this.iBH.popWindowText);
                        return;
                    }
                    AdCardBaseView.this.a(advertAppInfo, f, AdCardBaseView.this.iBk, z);
                    if (AdCardBaseView.this.gYG != null) {
                        AdCardBaseView.this.gYG.b(3, null);
                        return;
                    }
                    return;
                }
                String scheme = this.iBH.getScheme();
                if (k.isEmpty(scheme) && advertAppInfo != null) {
                    scheme = advertAppInfo.bDU;
                }
                if (this.iBH.hasAnimation()) {
                }
                int e = s.e(AdCardBaseView.this.mContext, AdCardBaseView.this.CW(scheme));
                if (AdCardBaseView.this.gYG != null) {
                    AdCardBaseView.this.gYG.b(e, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String CW(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.gXe != null && this.gXe.isValid()) {
            String c0349a = this.gXe.toString();
            if (!TextUtils.isEmpty(c0349a)) {
                sb.append("&");
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append("=");
                sb.append(URLEncoder.encode(c0349a));
            }
        }
        if (!TextUtils.isEmpty(this.iBp.getPreLoadData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append("=");
            sb.append(URLEncoder.encode(this.iBp.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.iBp.getNextPageData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append("=");
            sb.append(URLEncoder.encode(this.iBp.getNextPageData()));
        }
        if (this.iBp.hasAnimation()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append("=");
            sb.append("1");
        }
        if (this.iBp.isGoLandingPage()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append("=");
            sb.append("1");
        }
        if (this.iBp.isImmersiveStyle()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append("=");
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> iBG;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.iBG = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.iBG.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.iBo) ? false : true)) && adCardBaseView.iBo.equals(downloadData.getId())) {
                    int status = com.baidu.tieba.recapp.download.d.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.iBg.setText(R.string.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.iBg.setText(R.string.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> iBG;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.iBG = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.iBG.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.iBo) && adCardBaseView.iBo.equals(downloadData.getId())) {
                adCardBaseView.iBk.s(downloadData);
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> iBG;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.iBG = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.iBG.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                s.e(adCardBaseView.mContext, adCardBaseView.iBu.scheme);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void bHR() {
        if (4 == getBusinessType()) {
            this.gRq.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.iAC != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.iBu = bVar;
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
        if (adCard.getAdvertAppInfo().abF()) {
            textView.setVisibility(8);
            apkDownloadView.setVisibility(0);
        } else if (true == k.isEmpty(adCard.buttonText) || "立即查看".equals(adCard.buttonText)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bDW);
        downloadData.setUrl(advertAppInfo.bDV);
        downloadData.setName(advertAppInfo.bDT);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.f(advertAppInfo.bDS, 0));
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
