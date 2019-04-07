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
    protected View dTd;
    protected View ehX;
    protected TextView gAd;
    private a.C0331a gFJ;
    private final int gHs;
    protected View iiA;
    protected String iiB;
    private AdCard iiC;
    private AdThreadCommentAndPraiseInfoLayout iiD;
    protected AdThreadUserInfoLayout iiE;
    protected View iiF;
    protected View iiG;
    protected AdCard.b iiH;
    protected CustomMessageListener iiI;
    protected CustomMessageListener iiJ;
    protected CustomMessageListener iiK;
    protected ViewStub iif;
    protected View iig;
    protected View iih;
    protected final int iii;
    protected final int iij;
    protected final int iik;
    protected final int iil;
    protected final int iim;
    protected final int iin;
    protected final int iio;
    protected final int iip;
    private int iiq;
    private int iir;
    private int iis;
    protected TextView iit;
    protected TextView iiu;
    private AdCloseView iiv;
    private LinearLayout iiw;
    protected ApkDownloadView iix;
    protected TextView iiy;
    protected RelativeLayout iiz;
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
        this.gHs = l.aO(getContext());
        this.iiI = new a(2016484, this);
        this.iiJ = new d(2016483, this);
        this.iiK = new c(2016494, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(d.e.ds640);
        this.mImageHeight = (int) resources.getDimension(d.e.ds278);
        this.iii = (int) resources.getDimension(d.e.tbds92);
        this.iij = (int) resources.getDimension(d.e.tbds92);
        this.iik = (int) resources.getDimension(d.e.tbds20);
        this.iin = (int) resources.getDimension(d.e.tbds90);
        this.iio = (int) resources.getDimension(d.e.tbds90);
        this.iip = (int) resources.getDimension(d.e.tbds22);
        this.iil = (int) resources.getDimension(d.e.tbds44);
        this.iim = (int) resources.getDimension(d.e.tbds44);
        this.iiq = (int) resources.getDimension(d.e.ds12);
        this.iir = (int) resources.getDimension(d.e.ds1);
        this.iis = (int) resources.getDimension(d.e.ds18);
    }

    protected void r(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.iiD.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAa() {
        MessageManager.getInstance().registerListener(this.iiI);
        MessageManager.getInstance().registerListener(this.iiJ);
        MessageManager.getInstance().registerListener(this.iiK);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.dTd = this.mRootView.findViewById(d.g.bottom_line);
        this.iih = this.mRootView.findViewById(d.g.thread_multi_del_ad_mask_view);
        this.iih.setClickable(true);
        this.gAd = (TextView) this.mRootView.findViewById(d.g.ad_title);
        this.iit = (TextView) this.mRootView.findViewById(d.g.transform_btn);
        this.iix = (ApkDownloadView) this.mRootView.findViewById(d.g.advert_app_download_view);
        this.iiy = (TextView) this.mRootView.findViewById(d.g.advert_app_name);
        this.iiz = (RelativeLayout) this.mRootView.findViewById(d.g.bottom_transformation_area);
        this.iix.q(this.mContext.getUniqueId());
        this.iiI.setTag(this.mContext.getUniqueId());
        this.iiA = this.mRootView.findViewById(d.g.card_ad_middle_container);
        this.iiJ.setTag(this.mContext.getUniqueId());
        this.iiK.setTag(this.mContext.getUniqueId());
        this.iiD = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.iiD.setStyle(1);
        this.iiE = (AdThreadUserInfoLayout) this.mRootView.findViewById(d.g.card_ad_user_info_layout);
        if (1 == getBusinessType()) {
            this.iiE.setShowFlag(1413);
        }
        this.iiw = (LinearLayout) LayoutInflater.from(getContext()).inflate(d.h.ad_post_tag_close, (ViewGroup) null);
        this.iiv = (AdCloseView) this.iiw.findViewById(d.g.ad_close_view);
        this.iiu = (TextView) this.iiw.findViewById(d.g.feed_tag);
        this.iiu.setVisibility(8);
        this.iiE.addAdTagView(this.iiw);
        this.ehX = this.mRootView.findViewById(d.g.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.aO(getContext()) - this.iil) - this.iim) - this.iii) - this.iik;
            this.iiD.setVisibility(8);
        } else {
            this.mMaxWidth = (l.aO(getContext()) - this.iil) - this.iim;
            this.iiD.setVisibility(0);
        }
        this.iif = (ViewStub) this.mRootView.findViewById(d.g.ad_custom_view_stub);
        this.iif.setLayoutResource(getCustomLayout());
        this.iig = this.iif.inflate();
        this.iiF = this.mRootView.findViewById(d.g.pb_bottom_view);
        this.iiG = this.mRootView.findViewById(d.g.frs_bottom_view);
        cD(this.iig);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(final AdCard adCard) {
        final String str;
        this.iiC = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.iiE.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
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
        this.iix.setOnClickListener(bVar);
        this.iit.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iiA.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.iii + this.iik;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.iiE.getHeaderImg(), adCard.portraitClick, bVar);
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String By = By(ap.f(str2, 100, "..."));
            if (4 == getBusinessType()) {
                this.gAd.setTextSize(0, getContext().getResources().getDimension(d.e.ds32));
            } else {
                this.gAd.setTextSize(0, getContext().getResources().getDimension(d.e.tbfontsize44));
            }
            this.gAd.setText(By);
            this.gAd.setVisibility(0);
        } else {
            this.gAd.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.WZ()) && true == k.isEmpty(str3);
        a(this.iiz, this.iit, this.iix, adCard);
        if (advertAppInfo != null && advertAppInfo.WY()) {
            this.iiy.setText(adCard.userName.concat("APP").concat(" · 广告").toString());
        } else if (advertAppInfo != null && advertAppInfo.WZ()) {
            String str4 = adCard.tagName;
            if (TextUtils.isEmpty(str4)) {
                str4 = "广告";
            }
            this.iiy.setText(str4);
        }
        if (advertAppInfo != null && advertAppInfo.WY()) {
            this.iiB = advertAppInfo.bwK;
            this.iix.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, -1));
            c2.setStatus(ApkDownloadView.getStatus(c2));
            a(this.iit, c2.getStatus(), str3);
            this.iix.setData(c2);
            this.iix.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    al.d(this.iit, d.C0277d.btn_forum_focus_color, 1);
                    this.iit.setText(str3);
                    if (k.isEmpty(str)) {
                        this.iit.setClickable(false);
                    } else {
                        this.iit.setClickable(true);
                        this.iit.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.gHl != null && adCard.buttonClick != null && !q.Cq(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.gHl.b(adCard.buttonClick.adw, adCard.buttonClick.adx, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int e = s.e(AdCardBaseView.this.mContext, str);
                                        if ((e == 1 || e == 2) && AdCardBaseView.this.gHl != null) {
                                            AdCardBaseView.this.gHl.b(e, null);
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
                                            if ((e2 == 1 || e2 == 2) && AdCardBaseView.this.gHl != null) {
                                                AdCardBaseView.this.gHl.b(e2, null);
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
                    this.iit.setClickable(false);
                    this.iit.setText(adCard.buttonTextDone);
                    al.k(this.iit, d.f.btn_rounded_corner_gray_frame);
                    al.d(this.iit, d.C0277d.cp_cont_d, 1);
                }
            }
            this.iix.setVisibility(8);
        }
        a(adCard);
        r(i.Wv().Wz(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            Bz(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.bwQ != null && advertAppInfo.bwQ.adCloseInfo != null && advertAppInfo.bwQ.adCloseInfo.support_close.intValue() > 0) {
            this.iiv.setVisibility(0);
            this.iiv.setPage(getBusinessType());
            this.iiv.setData(advertAppInfo);
            l.b(this.mContext.getPageActivity(), this.iiw, 40, 40, 40, 120);
            this.iiw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.iiv.performClick();
                }
            });
        } else {
            this.iiv.setVisibility(8);
            this.iiu.setOnClickListener(null);
        }
        this.iiD.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.dTd.getLayoutParams();
        if (4 == getBusinessType()) {
            this.iiD.setVisibility(8);
            this.iiD.setBarNameClickEnabled(false);
            this.iiD.setShareVisible(false);
            this.iiD.setShowPraiseNum(false);
            this.iiD.setCommentNumEnable(false);
            this.iiD.setReplyTimeVisible(false);
            layoutParams2.height = this.iir;
            this.iiF.setVisibility(0);
            this.iiG.setVisibility(8);
        } else {
            a(adCard, bVar);
        }
        a(adCard, this.ehX, getBusinessType());
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 instanceof AdvertAppInfo) {
            advertAppInfo2.li(ap.ap(adCard.time));
        }
        this.iiE.setData(advertAppInfo2);
        ((TextView) this.iiE.getUserName()).setText(adCard.userName);
        this.iiE.getUserName().setOnClickListener(bVar);
        this.iiE.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.iiE.getUserName()).setText(adCard.userName);
            }
        });
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bbD().bbE()) {
            this.iih.setVisibility(0);
            al.l(this.iih, d.C0277d.cp_bg_line_d);
        } else {
            this.iih.setVisibility(8);
        }
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean isInFrsAllThread() {
        return this.gGn == 1;
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.iiG.setVisibility(0);
            this.iiD.setVisibility(8);
            return;
        }
        this.iiG.setVisibility(8);
        this.iiD.setVisibility(0);
        this.iiD.setBarNameClickEnabled(false);
        this.iiD.setReplyTimeVisible(false);
        this.iiD.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.iiD.setAgreeClickable(true);
            this.iiD.setPraiseContainerBgGray(false);
        } else {
            this.iiD.setAgreeClickable(false);
            this.iiD.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.iiD.setShareClickable(true);
            this.iiD.setShareContainerBgGray(false);
        } else {
            this.iiD.setShareClickable(false);
            this.iiD.setShareContainerBgGray(true);
        }
        if (this.iiD.getCommentContainer() != null) {
            this.iiD.getCommentContainer().setOnClickListener(bVar);
        }
        this.iiD.setNeedAddReplyIcon(true);
        this.iiD.setCommentNumEnable(false);
        this.iiD.setCommentClickable(true);
        this.iiD.setReplayContainerBgGray(true);
        this.iiD.setOnClickListener(bVar);
        this.iiD.setShareData(adCard);
        this.iiD.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        al.k(this.dTd, d.C0277d.cp_bg_line_c);
        this.iiv.onChangeSkinType();
        this.iiE.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        this.iiD.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            al.k(this.mRootView, d.f.addresslist_item_bg);
            al.l(this.dTd, d.C0277d.cp_bg_line_e);
            al.l(this.ehX, d.C0277d.cp_bg_line_e);
        } else {
            al.l(this.dTd, d.C0277d.cp_bg_line_c);
            al.l(this.ehX, d.C0277d.transparent);
        }
        al.d(this.gAd, d.C0277d.cp_cont_b, 1);
        al.j(this.iiy, d.C0277d.cp_cont_d);
        al.d(this.iiu, d.C0277d.cp_cont_d, 1);
        this.iix.onChangeSkinType(i);
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
                if (this.gHl != null) {
                    this.gHl.b(bVar.adw, bVar.adx, null);
                    return;
                }
                return;
            }
            int e = s.e(this.mContext, BA(bVar.scheme));
            if (e == 1 || e == 2) {
                if (this.gHl != null) {
                    this.gHl.b(e, null);
                }
            } else if (this.gHl != null) {
                this.gHl.b(bVar.adw, bVar.adx, null);
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
                        if (AdCardBaseView.this.iiC.hasAnimation()) {
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
        this.gFJ = new a.C0331a();
        this.gFJ.picUrl = tbImageView.getUrl();
        this.gFJ.rect = rect;
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
                    com.baidu.adp.lib.f.c.jB().a(jSONObject.optString("pic_url"), 17, null, this.gHs, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.gHs), this.mContext.getUniqueId(), new Object[0]);
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
            if (!this.mPermissionJudgePolicy.Y(this.mContext.getPageActivity()) && this.gHm != null) {
                this.gHm.b(advertAppInfo, i);
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
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.iix);
                        if (AdCardBaseView.this.iix != null) {
                            AdCardBaseView.this.iix.p(AdCardBaseView.this.c(advertAppInfo, i));
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
                    a(advertAppInfo, i, this.iix);
                    apkDownloadView.r(c2);
                    return;
            }
            g.aR(this.mContext.getPageActivity(), advertAppInfo.bwK);
        }
    }

    public a.C0331a getAnimationInfo() {
        return this.gFJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private AdCard iiU;

        public b(AdCard adCard) {
            this.iiU = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kM()) {
                AdCardBaseView.this.mContext.showToast(d.j.neterror);
            } else if (this.iiU != null) {
                AdvertAppInfo advertAppInfo = this.iiU.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.iix;
                if (advertAppInfo != null && advertAppInfo.WY()) {
                    int l = com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, l));
                    if ((6 == status || 7 == status) && j.kY() && !j.kZ()) {
                        AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, l, true, this.iiU.popWindowText);
                        return;
                    }
                    AdCardBaseView.this.a(advertAppInfo, l, AdCardBaseView.this.iix, z);
                    if (AdCardBaseView.this.gHl != null) {
                        AdCardBaseView.this.gHl.b(3, null);
                        return;
                    }
                    return;
                }
                String scheme = this.iiU.getScheme();
                if (k.isEmpty(scheme) && advertAppInfo != null) {
                    scheme = advertAppInfo.bwI;
                }
                if (this.iiU.hasAnimation()) {
                }
                int e = s.e(AdCardBaseView.this.mContext, AdCardBaseView.this.BA(scheme));
                if (AdCardBaseView.this.gHl != null) {
                    AdCardBaseView.this.gHl.b(e, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String BA(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.gFJ != null && this.gFJ.isValid()) {
            String c0331a = this.gFJ.toString();
            if (!TextUtils.isEmpty(c0331a)) {
                sb.append("&");
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append("=");
                sb.append(URLEncoder.encode(c0331a));
            }
        }
        if (!TextUtils.isEmpty(this.iiC.getPreLoadData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append("=");
            sb.append(URLEncoder.encode(this.iiC.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.iiC.getNextPageData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append("=");
            sb.append(URLEncoder.encode(this.iiC.getNextPageData()));
        }
        if (this.iiC.hasAnimation()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append("=");
            sb.append("1");
        }
        if (this.iiC.isGoLandingPage()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append("=");
            sb.append("1");
        }
        if (this.iiC.isImmersiveStyle()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append("=");
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> iiT;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.iiT = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.iiT.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.iiB) ? false : true)) && adCardBaseView.iiB.equals(downloadData.getId())) {
                    int status = com.baidu.tieba.recapp.download.d.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.iit.setText(d.j.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.iit.setText(d.j.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> iiT;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.iiT = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.iiT.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.iiB) && adCardBaseView.iiB.equals(downloadData.getId())) {
                adCardBaseView.iix.s(downloadData);
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> iiT;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.iiT = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.iiT.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                s.e(adCardBaseView.mContext, adCardBaseView.iiH.scheme);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void bAh() {
        if (4 == getBusinessType()) {
            this.gAd.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.ihP != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.iiH = bVar;
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
        DownloadData downloadData = new DownloadData(advertAppInfo.bwK);
        downloadData.setUrl(advertAppInfo.bwJ);
        downloadData.setName(advertAppInfo.bwH);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.l(advertAppInfo.bwG, 0));
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
