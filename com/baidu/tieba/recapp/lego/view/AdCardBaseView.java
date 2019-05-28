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
    protected View edE;
    protected View exM;
    protected TextView gRt;
    private a.C0349a gXh;
    private final int gYQ;
    protected ViewStub iAU;
    protected View iAV;
    protected View iAW;
    protected final int iAX;
    protected final int iAY;
    protected final int iAZ;
    protected final int iBa;
    protected final int iBb;
    protected final int iBc;
    protected final int iBd;
    protected final int iBe;
    private int iBf;
    private int iBg;
    private int iBh;
    protected TextView iBi;
    protected TextView iBj;
    private AdCloseView iBk;
    private LinearLayout iBl;
    protected ApkDownloadView iBm;
    protected TextView iBn;
    protected RelativeLayout iBo;
    protected View iBp;
    protected String iBq;
    private AdCard iBr;
    private AdThreadCommentAndPraiseInfoLayout iBs;
    protected AdThreadUserInfoLayout iBt;
    protected View iBu;
    protected View iBv;
    protected AdCard.b iBw;
    protected CustomMessageListener iBx;
    protected CustomMessageListener iBy;
    protected CustomMessageListener iBz;
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
        this.gYQ = l.af(getContext());
        this.iBx = new a(2016484, this);
        this.iBy = new d(2016483, this);
        this.iBz = new c(2016494, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(R.dimen.ds640);
        this.mImageHeight = (int) resources.getDimension(R.dimen.ds278);
        this.iAX = (int) resources.getDimension(R.dimen.tbds92);
        this.iAY = (int) resources.getDimension(R.dimen.tbds92);
        this.iAZ = (int) resources.getDimension(R.dimen.tbds20);
        this.iBc = (int) resources.getDimension(R.dimen.tbds90);
        this.iBd = (int) resources.getDimension(R.dimen.tbds90);
        this.iBe = (int) resources.getDimension(R.dimen.tbds22);
        this.iBa = (int) resources.getDimension(R.dimen.tbds44);
        this.iBb = (int) resources.getDimension(R.dimen.tbds44);
        this.iBf = (int) resources.getDimension(R.dimen.ds12);
        this.iBg = (int) resources.getDimension(R.dimen.ds1);
        this.iBh = (int) resources.getDimension(R.dimen.ds18);
    }

    protected void r(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.iBs.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bHN() {
        MessageManager.getInstance().registerListener(this.iBx);
        MessageManager.getInstance().registerListener(this.iBy);
        MessageManager.getInstance().registerListener(this.iBz);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.edE = this.mRootView.findViewById(R.id.bottom_line);
        this.iAW = this.mRootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.iAW.setClickable(true);
        this.gRt = (TextView) this.mRootView.findViewById(R.id.ad_title);
        this.iBi = (TextView) this.mRootView.findViewById(R.id.transform_btn);
        this.iBm = (ApkDownloadView) this.mRootView.findViewById(R.id.advert_app_download_view);
        this.iBn = (TextView) this.mRootView.findViewById(R.id.advert_app_name);
        this.iBo = (RelativeLayout) this.mRootView.findViewById(R.id.bottom_transformation_area);
        this.iBm.s(this.mContext.getUniqueId());
        this.iBx.setTag(this.mContext.getUniqueId());
        this.iBp = this.mRootView.findViewById(R.id.card_ad_middle_container);
        this.iBy.setTag(this.mContext.getUniqueId());
        this.iBz.setTag(this.mContext.getUniqueId());
        this.iBs = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.iBs.setStyle(1);
        this.iBt = (AdThreadUserInfoLayout) this.mRootView.findViewById(R.id.card_ad_user_info_layout);
        if (1 == getBusinessType()) {
            this.iBt.setShowFlag(1413);
        }
        this.iBl = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.iBk = (AdCloseView) this.iBl.findViewById(R.id.ad_close_view);
        this.iBj = (TextView) this.iBl.findViewById(R.id.feed_tag);
        this.iBj.setVisibility(8);
        this.iBt.addAdTagView(this.iBl);
        this.exM = this.mRootView.findViewById(R.id.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.af(getContext()) - this.iBa) - this.iBb) - this.iAX) - this.iAZ;
            this.iBs.setVisibility(8);
        } else {
            this.mMaxWidth = (l.af(getContext()) - this.iBa) - this.iBb;
            this.iBs.setVisibility(0);
        }
        this.iAU = (ViewStub) this.mRootView.findViewById(R.id.ad_custom_view_stub);
        this.iAU.setLayoutResource(getCustomLayout());
        this.iAV = this.iAU.inflate();
        this.iBu = this.mRootView.findViewById(R.id.pb_bottom_view);
        this.iBv = this.mRootView.findViewById(R.id.frs_bottom_view);
        cL(this.iAV);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(final AdCard adCard) {
        final String str;
        this.iBr = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.iBt.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
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
        this.iBm.setOnClickListener(bVar);
        this.iBi.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iBp.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.iAX + this.iAZ;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.iBt.getHeaderImg(), adCard.portraitClick, bVar);
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String CU = CU(ap.i(str2, 100, "..."));
            if (4 == getBusinessType()) {
                this.gRt.setTextSize(0, getContext().getResources().getDimension(R.dimen.ds32));
            } else {
                this.gRt.setTextSize(0, getContext().getResources().getDimension(R.dimen.tbfontsize44));
            }
            this.gRt.setText(CU);
            this.gRt.setVisibility(0);
        } else {
            this.gRt.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.abG()) && true == k.isEmpty(str3);
        a(this.iBo, this.iBi, this.iBm, adCard);
        if (advertAppInfo != null && advertAppInfo.abF()) {
            this.iBn.setText(adCard.userName.concat("APP").concat(" · 广告").toString());
        } else if (advertAppInfo != null && advertAppInfo.abG()) {
            String str4 = adCard.tagName;
            if (TextUtils.isEmpty(str4)) {
                str4 = "广告";
            }
            this.iBn.setText(str4);
        }
        if (advertAppInfo != null && advertAppInfo.abF()) {
            this.iBq = advertAppInfo.bDW;
            this.iBm.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.g.b.f(advertAppInfo.adPosition, -1));
            c2.setStatus(ApkDownloadView.getStatus(c2));
            a(this.iBi, c2.getStatus(), str3);
            this.iBm.setData(c2);
            this.iBm.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    al.f(this.iBi, R.color.btn_forum_focus_color, 1);
                    this.iBi.setText(str3);
                    if (k.isEmpty(str)) {
                        this.iBi.setClickable(false);
                    } else {
                        this.iBi.setClickable(true);
                        this.iBi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.gYJ != null && adCard.buttonClick != null && !q.DM(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.gYJ.b(adCard.buttonClick.abk, adCard.buttonClick.abl, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int e = s.e(AdCardBaseView.this.mContext, str);
                                        if ((e == 1 || e == 2) && AdCardBaseView.this.gYJ != null) {
                                            AdCardBaseView.this.gYJ.b(e, null);
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
                                            if ((e2 == 1 || e2 == 2) && AdCardBaseView.this.gYJ != null) {
                                                AdCardBaseView.this.gYJ.b(e2, null);
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
                    this.iBi.setClickable(false);
                    this.iBi.setText(adCard.buttonTextDone);
                    al.k(this.iBi, R.drawable.btn_rounded_corner_gray_frame);
                    al.f(this.iBi, R.color.cp_cont_d, 1);
                }
            }
            this.iBm.setVisibility(8);
        }
        a(adCard);
        r(i.abb().abf(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            CV(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.bEc != null && advertAppInfo.bEc.adCloseInfo != null && advertAppInfo.bEc.adCloseInfo.support_close.intValue() > 0) {
            this.iBk.setVisibility(0);
            this.iBk.setPage(getBusinessType());
            this.iBk.setData(advertAppInfo);
            l.b(this.mContext.getPageActivity(), this.iBl, 40, 40, 40, 120);
            this.iBl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.iBk.performClick();
                }
            });
        } else {
            this.iBk.setVisibility(8);
            this.iBj.setOnClickListener(null);
        }
        this.iBs.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.edE.getLayoutParams();
        if (4 == getBusinessType()) {
            this.iBs.setVisibility(8);
            this.iBs.setBarNameClickEnabled(false);
            this.iBs.setShareVisible(false);
            this.iBs.setShowPraiseNum(false);
            this.iBs.setCommentNumEnable(false);
            this.iBs.setReplyTimeVisible(false);
            layoutParams2.height = this.iBg;
            this.iBu.setVisibility(0);
            this.iBv.setVisibility(8);
        } else {
            a(adCard, bVar);
        }
        a(adCard, this.exM, getBusinessType());
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 instanceof AdvertAppInfo) {
            advertAppInfo2.mn(ap.aD(adCard.time));
        }
        this.iBt.setData(advertAppInfo2);
        ((TextView) this.iBt.getUserName()).setText(adCard.userName);
        this.iBt.getUserName().setOnClickListener(bVar);
        this.iBt.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.iBt.getUserName()).setText(adCard.userName);
            }
        });
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.biW().biX()) {
            this.iAW.setVisibility(0);
            al.l(this.iAW, R.color.cp_bg_line_d);
        } else {
            this.iAW.setVisibility(8);
        }
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean isInFrsAllThread() {
        return this.gXL == 1;
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.iBv.setVisibility(0);
            this.iBs.setVisibility(8);
            return;
        }
        this.iBv.setVisibility(8);
        this.iBs.setVisibility(0);
        this.iBs.setBarNameClickEnabled(false);
        this.iBs.setReplyTimeVisible(false);
        this.iBs.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.iBs.setAgreeClickable(true);
            this.iBs.setPraiseContainerBgGray(false);
        } else {
            this.iBs.setAgreeClickable(false);
            this.iBs.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.iBs.setShareClickable(true);
            this.iBs.setShareContainerBgGray(false);
        } else {
            this.iBs.setShareClickable(false);
            this.iBs.setShareContainerBgGray(true);
        }
        if (this.iBs.getCommentContainer() != null) {
            this.iBs.getCommentContainer().setOnClickListener(bVar);
        }
        this.iBs.setNeedAddReplyIcon(true);
        this.iBs.setCommentNumEnable(false);
        this.iBs.setCommentClickable(true);
        this.iBs.setReplayContainerBgGray(true);
        this.iBs.setOnClickListener(bVar);
        this.iBs.setShareData(adCard);
        this.iBs.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        al.k(this.edE, R.color.cp_bg_line_c);
        this.iBk.onChangeSkinType();
        this.iBt.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        this.iBs.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            al.k(this.mRootView, R.drawable.addresslist_item_bg);
            al.l(this.edE, R.color.cp_bg_line_e);
            al.l(this.exM, R.color.cp_bg_line_e);
        } else {
            al.l(this.edE, R.color.cp_bg_line_c);
            al.l(this.exM, R.color.transparent);
        }
        al.f(this.gRt, R.color.cp_cont_b, 1);
        al.j(this.iBn, R.color.cp_cont_d);
        al.f(this.iBj, R.color.cp_cont_d, 1);
        this.iBm.onChangeSkinType(i);
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
                if (this.gYJ != null) {
                    this.gYJ.b(bVar.abk, bVar.abl, null);
                    return;
                }
                return;
            }
            int e = s.e(this.mContext, CW(bVar.scheme));
            if (e == 1 || e == 2) {
                if (this.gYJ != null) {
                    this.gYJ.b(e, null);
                }
            } else if (this.gYJ != null) {
                this.gYJ.b(bVar.abk, bVar.abl, null);
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
                        if (AdCardBaseView.this.iBr.hasAnimation()) {
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
        this.gXh = new a.C0349a();
        this.gXh.picUrl = tbImageView.getUrl();
        this.gXh.rect = rect;
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
                    com.baidu.adp.lib.f.c.iv().a(jSONObject.optString("pic_url"), 17, null, this.gYQ, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.gYQ), this.mContext.getUniqueId(), new Object[0]);
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
            if (!this.mPermissionJudgePolicy.aa(this.mContext.getPageActivity()) && this.gYK != null) {
                this.gYK.b(advertAppInfo, i);
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
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.iBm);
                        if (AdCardBaseView.this.iBm != null) {
                            AdCardBaseView.this.iBm.p(AdCardBaseView.this.c(advertAppInfo, i));
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
                    a(advertAppInfo, i, this.iBm);
                    apkDownloadView.r(c2);
                    return;
            }
            g.aF(this.mContext.getPageActivity(), advertAppInfo.bDW);
        }
    }

    public a.C0349a getAnimationInfo() {
        return this.gXh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private AdCard iBJ;

        public b(AdCard adCard) {
            this.iBJ = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.jG()) {
                AdCardBaseView.this.mContext.showToast(R.string.neterror);
            } else if (this.iBJ != null) {
                AdvertAppInfo advertAppInfo = this.iBJ.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.iBm;
                if (advertAppInfo != null && advertAppInfo.abF()) {
                    int f = com.baidu.adp.lib.g.b.f(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, f));
                    if ((6 == status || 7 == status) && j.jS() && !j.jT()) {
                        AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, f, true, this.iBJ.popWindowText);
                        return;
                    }
                    AdCardBaseView.this.a(advertAppInfo, f, AdCardBaseView.this.iBm, z);
                    if (AdCardBaseView.this.gYJ != null) {
                        AdCardBaseView.this.gYJ.b(3, null);
                        return;
                    }
                    return;
                }
                String scheme = this.iBJ.getScheme();
                if (k.isEmpty(scheme) && advertAppInfo != null) {
                    scheme = advertAppInfo.bDU;
                }
                if (this.iBJ.hasAnimation()) {
                }
                int e = s.e(AdCardBaseView.this.mContext, AdCardBaseView.this.CW(scheme));
                if (AdCardBaseView.this.gYJ != null) {
                    AdCardBaseView.this.gYJ.b(e, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String CW(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.gXh != null && this.gXh.isValid()) {
            String c0349a = this.gXh.toString();
            if (!TextUtils.isEmpty(c0349a)) {
                sb.append("&");
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append("=");
                sb.append(URLEncoder.encode(c0349a));
            }
        }
        if (!TextUtils.isEmpty(this.iBr.getPreLoadData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append("=");
            sb.append(URLEncoder.encode(this.iBr.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.iBr.getNextPageData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append("=");
            sb.append(URLEncoder.encode(this.iBr.getNextPageData()));
        }
        if (this.iBr.hasAnimation()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append("=");
            sb.append("1");
        }
        if (this.iBr.isGoLandingPage()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append("=");
            sb.append("1");
        }
        if (this.iBr.isImmersiveStyle()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append("=");
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> iBI;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.iBI = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.iBI.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.iBq) ? false : true)) && adCardBaseView.iBq.equals(downloadData.getId())) {
                    int status = com.baidu.tieba.recapp.download.d.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.iBi.setText(R.string.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.iBi.setText(R.string.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> iBI;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.iBI = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.iBI.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.iBq) && adCardBaseView.iBq.equals(downloadData.getId())) {
                adCardBaseView.iBm.s(downloadData);
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> iBI;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.iBI = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.iBI.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                s.e(adCardBaseView.mContext, adCardBaseView.iBw.scheme);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void bHU() {
        if (4 == getBusinessType()) {
            this.gRt.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.iAE != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.iBw = bVar;
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
