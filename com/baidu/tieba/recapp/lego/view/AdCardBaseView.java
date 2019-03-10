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
    protected View dTP;
    protected View eip;
    protected TextView gAr;
    private a.C0268a gFX;
    private final int gHG;
    protected ViewStub iiA;
    protected View iiB;
    protected View iiC;
    protected final int iiD;
    protected final int iiE;
    protected final int iiF;
    protected final int iiG;
    protected final int iiH;
    protected final int iiI;
    protected final int iiJ;
    protected final int iiK;
    private int iiL;
    private int iiM;
    private int iiN;
    protected TextView iiO;
    protected TextView iiP;
    private AdCloseView iiQ;
    private LinearLayout iiR;
    protected ApkDownloadView iiS;
    protected TextView iiT;
    protected RelativeLayout iiU;
    protected View iiV;
    protected String iiW;
    private AdCard iiX;
    private AdThreadCommentAndPraiseInfoLayout iiY;
    protected AdThreadUserInfoLayout iiZ;
    protected View ija;
    protected View ijb;
    protected AdCard.b ijc;
    protected CustomMessageListener ijd;
    protected CustomMessageListener ije;
    protected CustomMessageListener ijf;
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
        this.gHG = l.aO(getContext());
        this.ijd = new a(2016484, this);
        this.ije = new d(2016483, this);
        this.ijf = new c(2016494, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(d.e.ds640);
        this.mImageHeight = (int) resources.getDimension(d.e.ds278);
        this.iiD = (int) resources.getDimension(d.e.tbds92);
        this.iiE = (int) resources.getDimension(d.e.tbds92);
        this.iiF = (int) resources.getDimension(d.e.tbds20);
        this.iiI = (int) resources.getDimension(d.e.tbds90);
        this.iiJ = (int) resources.getDimension(d.e.tbds90);
        this.iiK = (int) resources.getDimension(d.e.tbds22);
        this.iiG = (int) resources.getDimension(d.e.tbds44);
        this.iiH = (int) resources.getDimension(d.e.tbds44);
        this.iiL = (int) resources.getDimension(d.e.ds12);
        this.iiM = (int) resources.getDimension(d.e.ds1);
        this.iiN = (int) resources.getDimension(d.e.ds18);
    }

    protected void r(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.iiY.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAe() {
        MessageManager.getInstance().registerListener(this.ijd);
        MessageManager.getInstance().registerListener(this.ije);
        MessageManager.getInstance().registerListener(this.ijf);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.dTP = this.mRootView.findViewById(d.g.bottom_line);
        this.iiC = this.mRootView.findViewById(d.g.thread_multi_del_ad_mask_view);
        this.iiC.setClickable(true);
        this.gAr = (TextView) this.mRootView.findViewById(d.g.ad_title);
        this.iiO = (TextView) this.mRootView.findViewById(d.g.transform_btn);
        this.iiS = (ApkDownloadView) this.mRootView.findViewById(d.g.advert_app_download_view);
        this.iiT = (TextView) this.mRootView.findViewById(d.g.advert_app_name);
        this.iiU = (RelativeLayout) this.mRootView.findViewById(d.g.bottom_transformation_area);
        this.iiS.q(this.mContext.getUniqueId());
        this.ijd.setTag(this.mContext.getUniqueId());
        this.iiV = this.mRootView.findViewById(d.g.card_ad_middle_container);
        this.ije.setTag(this.mContext.getUniqueId());
        this.ijf.setTag(this.mContext.getUniqueId());
        this.iiY = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.iiY.setStyle(1);
        this.iiZ = (AdThreadUserInfoLayout) this.mRootView.findViewById(d.g.card_ad_user_info_layout);
        if (1 == getBusinessType()) {
            this.iiZ.setShowFlag(1413);
        }
        this.iiR = (LinearLayout) LayoutInflater.from(getContext()).inflate(d.h.ad_post_tag_close, (ViewGroup) null);
        this.iiQ = (AdCloseView) this.iiR.findViewById(d.g.ad_close_view);
        this.iiP = (TextView) this.iiR.findViewById(d.g.feed_tag);
        this.iiP.setVisibility(8);
        this.iiZ.addAdTagView(this.iiR);
        this.eip = this.mRootView.findViewById(d.g.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.aO(getContext()) - this.iiG) - this.iiH) - this.iiD) - this.iiF;
            this.iiY.setVisibility(8);
        } else {
            this.mMaxWidth = (l.aO(getContext()) - this.iiG) - this.iiH;
            this.iiY.setVisibility(0);
        }
        this.iiA = (ViewStub) this.mRootView.findViewById(d.g.ad_custom_view_stub);
        this.iiA.setLayoutResource(getCustomLayout());
        this.iiB = this.iiA.inflate();
        this.ija = this.mRootView.findViewById(d.g.pb_bottom_view);
        this.ijb = this.mRootView.findViewById(d.g.frs_bottom_view);
        cD(this.iiB);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(final AdCard adCard) {
        final String str;
        this.iiX = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.iiZ.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.baidu.tbadk.coreExtra.data.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.age() || advertAppInfo == null) {
                    return false;
                }
                com.baidu.adp.lib.util.a.bh(advertAppInfo.adCollect());
                ((Vibrator) AdCardBaseView.this.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
        });
        this.iiS.setOnClickListener(bVar);
        this.iiO.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iiV.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.iiD + this.iiF;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.iiZ.getHeaderImg(), adCard.portraitClick, bVar);
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String BB = BB(ap.f(str2, 100, "..."));
            if (4 == getBusinessType()) {
                this.gAr.setTextSize(0, getContext().getResources().getDimension(d.e.ds32));
            } else {
                this.gAr.setTextSize(0, getContext().getResources().getDimension(d.e.tbfontsize44));
            }
            this.gAr.setText(BB);
            this.gAr.setVisibility(0);
        } else {
            this.gAr.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.Xc()) && true == k.isEmpty(str3);
        a(this.iiU, this.iiO, this.iiS, adCard);
        if (advertAppInfo != null && advertAppInfo.Xb()) {
            this.iiT.setText(adCard.userName.concat("APP").concat(" · 广告").toString());
        } else if (advertAppInfo != null && advertAppInfo.Xc()) {
            String str4 = adCard.tagName;
            if (TextUtils.isEmpty(str4)) {
                str4 = "广告";
            }
            this.iiT.setText(str4);
        }
        if (advertAppInfo != null && advertAppInfo.Xb()) {
            this.iiW = advertAppInfo.bwF;
            this.iiS.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, -1));
            c2.setStatus(ApkDownloadView.getStatus(c2));
            a(this.iiO, c2.getStatus(), str3);
            this.iiS.setData(c2);
            this.iiS.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    al.d(this.iiO, d.C0236d.btn_forum_focus_color, 1);
                    this.iiO.setText(str3);
                    if (k.isEmpty(str)) {
                        this.iiO.setClickable(false);
                    } else {
                        this.iiO.setClickable(true);
                        this.iiO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.gHz != null && adCard.buttonClick != null && !q.Ct(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.gHz.b(adCard.buttonClick.adq, adCard.buttonClick.adr, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int f = s.f(AdCardBaseView.this.mContext, str);
                                        if ((f == 1 || f == 2) && AdCardBaseView.this.gHz != null) {
                                            AdCardBaseView.this.gHz.b(f, null);
                                            return;
                                        }
                                        return;
                                    }
                                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(AdCardBaseView.this.mContext.getPageActivity());
                                    aVar.ly(adCard.popWindowText);
                                    aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2.1
                                        @Override // com.baidu.tbadk.core.dialog.a.b
                                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                            int f2 = s.f(AdCardBaseView.this.mContext, str);
                                            if ((f2 == 1 || f2 == 2) && AdCardBaseView.this.gHz != null) {
                                                AdCardBaseView.this.gHz.b(f2, null);
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
                                    aVar.b(AdCardBaseView.this.mContext).aaZ();
                                }
                            }
                        });
                    }
                } else {
                    this.iiO.setClickable(false);
                    this.iiO.setText(adCard.buttonTextDone);
                    al.k(this.iiO, d.f.btn_rounded_corner_gray_frame);
                    al.d(this.iiO, d.C0236d.cp_cont_d, 1);
                }
            }
            this.iiS.setVisibility(8);
        }
        a(adCard);
        r(i.Wy().WC(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            BC(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.bwL != null && advertAppInfo.bwL.adCloseInfo != null && advertAppInfo.bwL.adCloseInfo.support_close.intValue() > 0) {
            this.iiQ.setVisibility(0);
            this.iiQ.setPage(getBusinessType());
            this.iiQ.setData(advertAppInfo);
            l.b(this.mContext.getPageActivity(), this.iiR, 40, 40, 40, 120);
            this.iiR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.iiQ.performClick();
                }
            });
        } else {
            this.iiQ.setVisibility(8);
            this.iiP.setOnClickListener(null);
        }
        this.iiY.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.dTP.getLayoutParams();
        if (4 == getBusinessType()) {
            this.iiY.setVisibility(8);
            this.iiY.setBarNameClickEnabled(false);
            this.iiY.setShareVisible(false);
            this.iiY.setShowPraiseNum(false);
            this.iiY.setCommentNumEnable(false);
            this.iiY.setReplyTimeVisible(false);
            layoutParams2.height = this.iiM;
            this.ija.setVisibility(0);
            this.ijb.setVisibility(8);
        } else {
            a(adCard, bVar);
        }
        a(adCard, this.eip, getBusinessType());
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 instanceof AdvertAppInfo) {
            advertAppInfo2.lh(ap.ap(adCard.time));
        }
        this.iiZ.setData(advertAppInfo2);
        ((TextView) this.iiZ.getUserName()).setText(adCard.userName);
        this.iiZ.getUserName().setOnClickListener(bVar);
        this.iiZ.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.iiZ.getUserName()).setText(adCard.userName);
            }
        });
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bbG().bbH()) {
            this.iiC.setVisibility(0);
            al.l(this.iiC, d.C0236d.cp_bg_line_d);
        } else {
            this.iiC.setVisibility(8);
        }
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean isInFrsAllThread() {
        return this.gGB == 1;
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.ijb.setVisibility(0);
            this.iiY.setVisibility(8);
            return;
        }
        this.ijb.setVisibility(8);
        this.iiY.setVisibility(0);
        this.iiY.setBarNameClickEnabled(false);
        this.iiY.setReplyTimeVisible(false);
        this.iiY.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.iiY.setAgreeClickable(true);
            this.iiY.setPraiseContainerBgGray(false);
        } else {
            this.iiY.setAgreeClickable(false);
            this.iiY.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.iiY.setShareClickable(true);
            this.iiY.setShareContainerBgGray(false);
        } else {
            this.iiY.setShareClickable(false);
            this.iiY.setShareContainerBgGray(true);
        }
        if (this.iiY.getCommentContainer() != null) {
            this.iiY.getCommentContainer().setOnClickListener(bVar);
        }
        this.iiY.setNeedAddReplyIcon(true);
        this.iiY.setCommentNumEnable(false);
        this.iiY.setCommentClickable(true);
        this.iiY.setReplayContainerBgGray(true);
        this.iiY.setOnClickListener(bVar);
        this.iiY.setShareData(adCard);
        this.iiY.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        al.k(this.dTP, d.C0236d.cp_bg_line_c);
        this.iiQ.onChangeSkinType();
        this.iiZ.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        this.iiY.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            al.k(this.mRootView, d.f.addresslist_item_bg);
            al.l(this.dTP, d.C0236d.cp_bg_line_e);
            al.l(this.eip, d.C0236d.cp_bg_line_e);
        } else {
            al.l(this.dTP, d.C0236d.cp_bg_line_c);
            al.l(this.eip, d.C0236d.transparent);
        }
        al.d(this.gAr, d.C0236d.cp_cont_b, 1);
        al.j(this.iiT, d.C0236d.cp_cont_d);
        al.d(this.iiP, d.C0236d.cp_cont_d, 1);
        this.iiS.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String BB(String str) {
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
            if (b(bVar) && !q.Ct(bVar.scheme)) {
                if (this.gHz != null) {
                    this.gHz.b(bVar.adq, bVar.adr, null);
                    return;
                }
                return;
            }
            int f = s.f(this.mContext, BD(bVar.scheme));
            if (f == 1 || f == 2) {
                if (this.gHz != null) {
                    this.gHz.b(f, null);
                }
            } else if (this.gHz != null) {
                this.gHz.b(bVar.adq, bVar.adr, null);
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
                        if (AdCardBaseView.this.iiX.hasAnimation()) {
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
        this.gFX = new a.C0268a();
        this.gFX.picUrl = tbImageView.getUrl();
        this.gFX.rect = rect;
    }

    private void BC(String str) {
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
                    com.baidu.adp.lib.f.c.jB().a(jSONObject.optString("pic_url"), 17, null, this.gHG, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.gHG), this.mContext.getUniqueId(), new Object[0]);
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
            if (advertAppInfo.Xa() != 0) {
                l.showToast(this.mContext.getPageActivity(), d.j.download_error);
                return;
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgePolicy.adQ();
            this.mPermissionJudgePolicy.e(this.mContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgePolicy.Y(this.mContext.getPageActivity()) && this.gHA != null) {
                this.gHA.b(advertAppInfo, i);
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
            } else if (advertAppInfo.Xb()) {
                if (TextUtils.isEmpty(str)) {
                    str = this.mContext.getString(d.j.frs_network_tips);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
                aVar.ly(str);
                aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.iiS);
                        if (AdCardBaseView.this.iiS != null) {
                            AdCardBaseView.this.iiS.p(AdCardBaseView.this.c(advertAppInfo, i));
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
                aVar.b(this.mContext).aaZ();
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
                    a(advertAppInfo, i, this.iiS);
                    apkDownloadView.r(c2);
                    return;
            }
            g.aS(this.mContext.getPageActivity(), advertAppInfo.bwF);
        }
    }

    public a.C0268a getAnimationInfo() {
        return this.gFX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private AdCard ijp;

        public b(AdCard adCard) {
            this.ijp = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kM()) {
                AdCardBaseView.this.mContext.showToast(d.j.neterror);
            } else if (this.ijp != null) {
                AdvertAppInfo advertAppInfo = this.ijp.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.iiS;
                if (advertAppInfo != null && advertAppInfo.Xb()) {
                    int l = com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, l));
                    if ((6 == status || 7 == status) && j.kY() && !j.kZ()) {
                        AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, l, true, this.ijp.popWindowText);
                        return;
                    }
                    AdCardBaseView.this.a(advertAppInfo, l, AdCardBaseView.this.iiS, z);
                    if (AdCardBaseView.this.gHz != null) {
                        AdCardBaseView.this.gHz.b(3, null);
                        return;
                    }
                    return;
                }
                String scheme = this.ijp.getScheme();
                if (k.isEmpty(scheme) && advertAppInfo != null) {
                    scheme = advertAppInfo.bwD;
                }
                if (this.ijp.hasAnimation()) {
                }
                int f = s.f(AdCardBaseView.this.mContext, AdCardBaseView.this.BD(scheme));
                if (AdCardBaseView.this.gHz != null) {
                    AdCardBaseView.this.gHz.b(f, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String BD(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.gFX != null && this.gFX.isValid()) {
            String c0268a = this.gFX.toString();
            if (!TextUtils.isEmpty(c0268a)) {
                sb.append("&");
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append("=");
                sb.append(URLEncoder.encode(c0268a));
            }
        }
        if (!TextUtils.isEmpty(this.iiX.getPreLoadData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append("=");
            sb.append(URLEncoder.encode(this.iiX.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.iiX.getNextPageData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append("=");
            sb.append(URLEncoder.encode(this.iiX.getNextPageData()));
        }
        if (this.iiX.hasAnimation()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append("=");
            sb.append("1");
        }
        if (this.iiX.isGoLandingPage()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append("=");
            sb.append("1");
        }
        if (this.iiX.isImmersiveStyle()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append("=");
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> ijo;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.ijo = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.ijo.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.iiW) ? false : true)) && adCardBaseView.iiW.equals(downloadData.getId())) {
                    int status = com.baidu.tieba.recapp.download.d.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.iiO.setText(d.j.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.iiO.setText(d.j.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> ijo;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.ijo = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.ijo.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.iiW) && adCardBaseView.iiW.equals(downloadData.getId())) {
                adCardBaseView.iiS.s(downloadData);
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> ijo;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.ijo = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.ijo.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                s.f(adCardBaseView.mContext, adCardBaseView.ijc.scheme);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void bAl() {
        if (4 == getBusinessType()) {
            this.gAr.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.iij != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.ijc = bVar;
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
        if (adCard.getAdvertAppInfo().Xb()) {
            textView.setVisibility(8);
            apkDownloadView.setVisibility(0);
        } else if (true == k.isEmpty(adCard.buttonText) || "立即查看".equals(adCard.buttonText)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    DownloadData c(AdvertAppInfo advertAppInfo, int i) {
        DownloadData downloadData = new DownloadData(advertAppInfo.bwF);
        downloadData.setUrl(advertAppInfo.bwE);
        downloadData.setName(advertAppInfo.bwC);
        downloadData.setPosition(i);
        downloadData.setNotifyId(com.baidu.adp.lib.g.b.l(advertAppInfo.bwB, 0));
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
