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
import com.baidu.tieba.d;
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
    protected View dTe;
    protected View ehY;
    protected TextView gAe;
    private a.C0331a gFK;
    private final int gHt;
    protected RelativeLayout iiA;
    protected View iiB;
    protected String iiC;
    private AdCard iiD;
    private AdThreadCommentAndPraiseInfoLayout iiE;
    protected AdThreadUserInfoLayout iiF;
    protected View iiG;
    protected View iiH;
    protected AdCard.b iiI;
    protected CustomMessageListener iiJ;
    protected CustomMessageListener iiK;
    protected CustomMessageListener iiL;
    protected ViewStub iig;
    protected View iih;
    protected View iii;
    protected final int iij;
    protected final int iik;
    protected final int iil;
    protected final int iim;
    protected final int iin;
    protected final int iio;
    protected final int iip;
    protected final int iiq;
    private int iir;
    private int iis;
    private int iit;
    protected TextView iiu;
    protected TextView iiv;
    private AdCloseView iiw;
    private LinearLayout iix;
    protected ApkDownloadView iiy;
    protected TextView iiz;
    protected final int mImageHeight;
    protected final int mImageWidth;
    protected int mMaxWidth;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgePolicy;
    protected View mRootView;

    protected abstract void a(AdCard adCard);

    protected abstract void cD(View view);

    protected abstract int getCustomLayout();

    protected abstract int getLayout();

    public AdCardBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gHt = l.aO(getContext());
        this.iiJ = new a(2016484, this);
        this.iiK = new d(2016483, this);
        this.iiL = new c(2016494, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(d.e.ds640);
        this.mImageHeight = (int) resources.getDimension(d.e.ds278);
        this.iij = (int) resources.getDimension(d.e.tbds92);
        this.iik = (int) resources.getDimension(d.e.tbds92);
        this.iil = (int) resources.getDimension(d.e.tbds20);
        this.iio = (int) resources.getDimension(d.e.tbds90);
        this.iip = (int) resources.getDimension(d.e.tbds90);
        this.iiq = (int) resources.getDimension(d.e.tbds22);
        this.iim = (int) resources.getDimension(d.e.tbds44);
        this.iin = (int) resources.getDimension(d.e.tbds44);
        this.iir = (int) resources.getDimension(d.e.ds12);
        this.iis = (int) resources.getDimension(d.e.ds1);
        this.iit = (int) resources.getDimension(d.e.ds18);
    }

    protected void r(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.iiE.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAa() {
        MessageManager.getInstance().registerListener(this.iiJ);
        MessageManager.getInstance().registerListener(this.iiK);
        MessageManager.getInstance().registerListener(this.iiL);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.dTe = this.mRootView.findViewById(d.g.bottom_line);
        this.iii = this.mRootView.findViewById(d.g.thread_multi_del_ad_mask_view);
        this.iii.setClickable(true);
        this.gAe = (TextView) this.mRootView.findViewById(d.g.ad_title);
        this.iiu = (TextView) this.mRootView.findViewById(d.g.transform_btn);
        this.iiy = (ApkDownloadView) this.mRootView.findViewById(d.g.advert_app_download_view);
        this.iiz = (TextView) this.mRootView.findViewById(d.g.advert_app_name);
        this.iiA = (RelativeLayout) this.mRootView.findViewById(d.g.bottom_transformation_area);
        this.iiy.q(this.mContext.getUniqueId());
        this.iiJ.setTag(this.mContext.getUniqueId());
        this.iiB = this.mRootView.findViewById(d.g.card_ad_middle_container);
        this.iiK.setTag(this.mContext.getUniqueId());
        this.iiL.setTag(this.mContext.getUniqueId());
        this.iiE = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.iiE.setStyle(1);
        this.iiF = (AdThreadUserInfoLayout) this.mRootView.findViewById(d.g.card_ad_user_info_layout);
        if (1 == getBusinessType()) {
            this.iiF.setShowFlag(1413);
        }
        this.iix = (LinearLayout) LayoutInflater.from(getContext()).inflate(d.h.ad_post_tag_close, (ViewGroup) null);
        this.iiw = (AdCloseView) this.iix.findViewById(d.g.ad_close_view);
        this.iiv = (TextView) this.iix.findViewById(d.g.feed_tag);
        this.iiv.setVisibility(8);
        this.iiF.addAdTagView(this.iix);
        this.ehY = this.mRootView.findViewById(d.g.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.aO(getContext()) - this.iim) - this.iin) - this.iij) - this.iil;
            this.iiE.setVisibility(8);
        } else {
            this.mMaxWidth = (l.aO(getContext()) - this.iim) - this.iin;
            this.iiE.setVisibility(0);
        }
        this.iig = (ViewStub) this.mRootView.findViewById(d.g.ad_custom_view_stub);
        this.iig.setLayoutResource(getCustomLayout());
        this.iih = this.iig.inflate();
        this.iiG = this.mRootView.findViewById(d.g.pb_bottom_view);
        this.iiH = this.mRootView.findViewById(d.g.frs_bottom_view);
        cD(this.iih);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(final AdCard adCard) {
        final String str;
        this.iiD = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.iiF.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.agb() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.bh(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.iiy.setOnClickListener(bVar);
        this.iiu.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iiB.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.iij + this.iil;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.iiF.getHeaderImg(), adCard.portraitClick, bVar);
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String By = By(ap.f(str2, 100, "..."));
            if (4 == getBusinessType()) {
                this.gAe.setTextSize(0, getContext().getResources().getDimension(d.e.ds32));
            } else {
                this.gAe.setTextSize(0, getContext().getResources().getDimension(d.e.tbfontsize44));
            }
            this.gAe.setText(By);
            this.gAe.setVisibility(0);
        } else {
            this.gAe.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.WZ()) && true == k.isEmpty(str3);
        a(this.iiA, this.iiu, this.iiy, adCard);
        if (advertAppInfo != null && advertAppInfo.WY()) {
            this.iiz.setText(adCard.userName.concat("APP").concat(" · 广告").toString());
        } else if (advertAppInfo != null && advertAppInfo.WZ()) {
            String str4 = adCard.tagName;
            if (TextUtils.isEmpty(str4)) {
                str4 = "广告";
            }
            this.iiz.setText(str4);
        }
        if (advertAppInfo != null && advertAppInfo.WY()) {
            this.iiC = advertAppInfo.bwL;
            this.iiy.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, -1));
            c2.setStatus(ApkDownloadView.getStatus(c2));
            a(this.iiu, c2.getStatus(), str3);
            this.iiy.setData(c2);
            this.iiy.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    al.d(this.iiu, d.C0277d.btn_forum_focus_color, 1);
                    this.iiu.setText(str3);
                    if (k.isEmpty(str)) {
                        this.iiu.setClickable(false);
                    } else {
                        this.iiu.setClickable(true);
                        this.iiu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.gHm != null && adCard.buttonClick != null && !q.Cq(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.gHm.b(adCard.buttonClick.adx, adCard.buttonClick.ady, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int e = s.e(AdCardBaseView.this.mContext, str);
                                        if ((e == 1 || e == 2) && AdCardBaseView.this.gHm != null) {
                                            AdCardBaseView.this.gHm.b(e, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.mContext.getPageActivity());
                                    aVar.lz(adCard.popWindowText);
                                    aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int e2 = s.e(AdCardBaseView.this.mContext, str);
                                            if ((e2 == 1 || e2 == 2) && AdCardBaseView.this.gHm != null) {
                                                AdCardBaseView.this.gHm.b(e2, null);
                                            }
                                            aVar2.dismiss();
                                        }
                                    });
                                    aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.2
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            aVar2.dismiss();
                                        }
                                    });
                                    aVar.b(AdCardBaseView.this.mContext).aaW();
                                }
                            }
                        });
                    }
                } else {
                    this.iiu.setClickable(false);
                    this.iiu.setText(adCard.buttonTextDone);
                    al.k(this.iiu, d.f.btn_rounded_corner_gray_frame);
                    al.d(this.iiu, d.C0277d.cp_cont_d, 1);
                }
            }
            this.iiy.setVisibility(8);
        }
        a(adCard);
        r(i.Wv().Wz(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            Bz(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.bwR != null && advertAppInfo.bwR.adCloseInfo != null && advertAppInfo.bwR.adCloseInfo.support_close.intValue() > 0) {
            this.iiw.setVisibility(0);
            this.iiw.setPage(getBusinessType());
            this.iiw.setData(advertAppInfo);
            l.b(this.mContext.getPageActivity(), this.iix, 40, 40, 40, 120);
            this.iix.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.iiw.performClick();
                }
            });
        } else {
            this.iiw.setVisibility(8);
            this.iiv.setOnClickListener(null);
        }
        this.iiE.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.dTe.getLayoutParams();
        if (4 == getBusinessType()) {
            this.iiE.setVisibility(8);
            this.iiE.setBarNameClickEnabled(false);
            this.iiE.setShareVisible(false);
            this.iiE.setShowPraiseNum(false);
            this.iiE.setCommentNumEnable(false);
            this.iiE.setReplyTimeVisible(false);
            layoutParams2.height = this.iis;
            this.iiG.setVisibility(0);
            this.iiH.setVisibility(8);
        } else {
            a(adCard, bVar);
        }
        a(adCard, this.ehY, getBusinessType());
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 instanceof AdvertAppInfo) {
            advertAppInfo2.li(ap.ap(adCard.time));
        }
        this.iiF.setData(advertAppInfo2);
        ((TextView) this.iiF.getUserName()).setText(adCard.userName);
        this.iiF.getUserName().setOnClickListener(bVar);
        this.iiF.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.iiF.getUserName()).setText(adCard.userName);
            }
        });
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bbD().bbE()) {
            this.iii.setVisibility(0);
            al.l(this.iii, d.C0277d.cp_bg_line_d);
        } else {
            this.iii.setVisibility(8);
        }
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean isInFrsAllThread() {
        return this.gGo == 1;
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.iiH.setVisibility(0);
            this.iiE.setVisibility(8);
            return;
        }
        this.iiH.setVisibility(8);
        this.iiE.setVisibility(0);
        this.iiE.setBarNameClickEnabled(false);
        this.iiE.setReplyTimeVisible(false);
        this.iiE.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.iiE.setAgreeClickable(true);
            this.iiE.setPraiseContainerBgGray(false);
        } else {
            this.iiE.setAgreeClickable(false);
            this.iiE.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.iiE.setShareClickable(true);
            this.iiE.setShareContainerBgGray(false);
        } else {
            this.iiE.setShareClickable(false);
            this.iiE.setShareContainerBgGray(true);
        }
        if (this.iiE.getCommentContainer() != null) {
            this.iiE.getCommentContainer().setOnClickListener(bVar);
        }
        this.iiE.setNeedAddReplyIcon(true);
        this.iiE.setCommentNumEnable(false);
        this.iiE.setCommentClickable(true);
        this.iiE.setReplayContainerBgGray(true);
        this.iiE.setOnClickListener(bVar);
        this.iiE.setShareData(adCard);
        this.iiE.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        al.k(this.dTe, d.C0277d.cp_bg_line_c);
        this.iiw.onChangeSkinType();
        this.iiF.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        this.iiE.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            al.k(this.mRootView, d.f.addresslist_item_bg);
            al.l(this.dTe, d.C0277d.cp_bg_line_e);
            al.l(this.ehY, d.C0277d.cp_bg_line_e);
        } else {
            al.l(this.dTe, d.C0277d.cp_bg_line_c);
            al.l(this.ehY, d.C0277d.transparent);
        }
        al.d(this.gAe, d.C0277d.cp_cont_b, 1);
        al.j(this.iiz, d.C0277d.cp_cont_d);
        al.d(this.iiv, d.C0277d.cp_cont_d, 1);
        this.iiy.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String By(String str) {
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
            if (b(bVar) && !q.Cq(bVar.scheme)) {
                if (this.gHm != null) {
                    this.gHm.b(bVar.adx, bVar.ady, null);
                    return;
                }
                return;
            }
            int e = s.e(this.mContext, BA(bVar.scheme));
            if (e == 1 || e == 2) {
                if (this.gHm != null) {
                    this.gHm.b(e, null);
                }
            } else if (this.gHm != null) {
                this.gHm.b(bVar.adx, bVar.ady, null);
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
                        if (AdCardBaseView.this.iiD.hasAnimation()) {
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
        this.gFK = new a.C0331a();
        this.gFK.picUrl = tbImageView.getUrl();
        this.gFK.rect = rect;
    }

    private void Bz(String str) {
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
                    com.baidu.adp.lib.f.c.jB().a(jSONObject.optString("pic_url"), 17, null, this.gHt, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.gHt), this.mContext.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.WX() != 0) {
                l.showToast(this.mContext.getPageActivity(), d.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.adN();
            this.mPermissionJudgePolicy.e(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.Y(this.mContext.getPageActivity()) && this.gHn != null) {
                this.gHn.b(advertAppInfo, i);
                if (apkDownloadView != null) {
                    apkDownloadView.p(c(advertAppInfo, i));
                }
            }
        }
    }

    public void showDownloadAppDialog(final AdvertAppInfo advertAppInfo, final int i, boolean z, String str) {
        if (advertAppInfo != null) {
            if (!j.kM()) {
                l.showToast(this.mContext.getPageActivity(), d.j.neterror);
            } else if (advertAppInfo.WY()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(d.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.lz(str);
                aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.iiy);
                        if (AdCardBaseView.this.iiy != null) {
                            AdCardBaseView.this.iiy.p(AdCardBaseView.this.c(advertAppInfo, i));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(this.mContext).aaW();
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
                    a(advertAppInfo, i, this.iiy);
                    apkDownloadView.r(c2);
                    return;
            }
            g.aR(this.mContext.getPageActivity(), advertAppInfo.bwL);
        }
    }

    public a.C0331a getAnimationInfo() {
        return this.gFK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private AdCard iiV;

        public b(AdCard adCard) {
            this.iiV = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kM()) {
                AdCardBaseView.this.mContext.showToast(d.j.neterror);
            } else if (this.iiV != null) {
                AdvertAppInfo advertAppInfo = this.iiV.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.iiy;
                if (advertAppInfo != null && advertAppInfo.WY()) {
                    int l = com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, l));
                    if ((6 == status || 7 == status) && j.kY() && !j.kZ()) {
                        AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, l, true, this.iiV.popWindowText);
                        return;
                    }
                    AdCardBaseView.this.a(advertAppInfo, l, AdCardBaseView.this.iiy, z);
                    if (AdCardBaseView.this.gHm != null) {
                        AdCardBaseView.this.gHm.b(3, null);
                        return;
                    }
                    return;
                }
                String scheme = this.iiV.getScheme();
                if (k.isEmpty(scheme) && advertAppInfo != null) {
                    scheme = advertAppInfo.bwJ;
                }
                if (this.iiV.hasAnimation()) {
                }
                int e = s.e(AdCardBaseView.this.mContext, AdCardBaseView.this.BA(scheme));
                if (AdCardBaseView.this.gHm != null) {
                    AdCardBaseView.this.gHm.b(e, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String BA(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.gFK != null && this.gFK.isValid()) {
            String c0331a = this.gFK.toString();
            if (!TextUtils.isEmpty(c0331a)) {
                sb.append("&");
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append("=");
                sb.append(URLEncoder.encode(c0331a));
            }
        }
        if (!TextUtils.isEmpty(this.iiD.getPreLoadData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append("=");
            sb.append(URLEncoder.encode(this.iiD.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.iiD.getNextPageData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append("=");
            sb.append(URLEncoder.encode(this.iiD.getNextPageData()));
        }
        if (this.iiD.hasAnimation()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append("=");
            sb.append("1");
        }
        if (this.iiD.isGoLandingPage()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append("=");
            sb.append("1");
        }
        if (this.iiD.isImmersiveStyle()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append("=");
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> iiU;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.iiU = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.iiU.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.iiC) ? false : true)) && adCardBaseView.iiC.equals(downloadData.getId())) {
                    int status = com.baidu.tieba.recapp.download.d.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.iiu.setText(d.j.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.iiu.setText(d.j.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> iiU;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.iiU = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.iiU.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.iiC) && adCardBaseView.iiC.equals(downloadData.getId())) {
                adCardBaseView.iiy.s(downloadData);
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> iiU;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.iiU = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.iiU.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                s.e(adCardBaseView.mContext, adCardBaseView.iiI.scheme);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void bAh() {
        if (4 == getBusinessType()) {
            this.gAe.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.ihQ != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.iiI = bVar;
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
        if (adCard.getAdvertAppInfo().WY()) {
            textView.setVisibility(8);
            apkDownloadView.setVisibility(0);
        } else if (true == k.isEmpty(adCard.buttonText) || "立即查看".equals(adCard.buttonText)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bwL);
        downloadData.setUrl(advertAppInfo.bwK);
        downloadData.setName(advertAppInfo.bwI);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.l(advertAppInfo.bwH, 0));
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
