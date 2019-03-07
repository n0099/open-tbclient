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
    protected TextView gAq;
    private a.C0268a gFW;
    private final int gHF;
    protected View iiA;
    protected View iiB;
    protected final int iiC;
    protected final int iiD;
    protected final int iiE;
    protected final int iiF;
    protected final int iiG;
    protected final int iiH;
    protected final int iiI;
    protected final int iiJ;
    private int iiK;
    private int iiL;
    private int iiM;
    protected TextView iiN;
    protected TextView iiO;
    private AdCloseView iiP;
    private LinearLayout iiQ;
    protected ApkDownloadView iiR;
    protected TextView iiS;
    protected RelativeLayout iiT;
    protected View iiU;
    protected String iiV;
    private AdCard iiW;
    private AdThreadCommentAndPraiseInfoLayout iiX;
    protected AdThreadUserInfoLayout iiY;
    protected View iiZ;
    protected ViewStub iiz;
    protected View ija;
    protected AdCard.b ijb;
    protected CustomMessageListener ijc;
    protected CustomMessageListener ijd;
    protected CustomMessageListener ije;
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
        this.gHF = l.aO(getContext());
        this.ijc = new a(2016484, this);
        this.ijd = new d(2016483, this);
        this.ije = new c(2016494, this);
        Resources resources = tbPageContext.getResources();
        this.mImageWidth = (int) resources.getDimension(d.e.ds640);
        this.mImageHeight = (int) resources.getDimension(d.e.ds278);
        this.iiC = (int) resources.getDimension(d.e.tbds92);
        this.iiD = (int) resources.getDimension(d.e.tbds92);
        this.iiE = (int) resources.getDimension(d.e.tbds20);
        this.iiH = (int) resources.getDimension(d.e.tbds90);
        this.iiI = (int) resources.getDimension(d.e.tbds90);
        this.iiJ = (int) resources.getDimension(d.e.tbds22);
        this.iiF = (int) resources.getDimension(d.e.tbds44);
        this.iiG = (int) resources.getDimension(d.e.tbds44);
        this.iiK = (int) resources.getDimension(d.e.ds12);
        this.iiL = (int) resources.getDimension(d.e.ds1);
        this.iiM = (int) resources.getDimension(d.e.ds18);
    }

    protected void r(boolean z, int i) {
    }

    private void a(AdCard adCard, View view, int i) {
        if (adCard != null) {
            if (4 == i) {
                view.setVisibility(8);
            } else if (adCard.isNoPicAd() && this.iiX.getVisibility() == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAd() {
        MessageManager.getInstance().registerListener(this.ijc);
        MessageManager.getInstance().registerListener(this.ijd);
        MessageManager.getInstance().registerListener(this.ije);
        this.mRootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.dTP = this.mRootView.findViewById(d.g.bottom_line);
        this.iiB = this.mRootView.findViewById(d.g.thread_multi_del_ad_mask_view);
        this.iiB.setClickable(true);
        this.gAq = (TextView) this.mRootView.findViewById(d.g.ad_title);
        this.iiN = (TextView) this.mRootView.findViewById(d.g.transform_btn);
        this.iiR = (ApkDownloadView) this.mRootView.findViewById(d.g.advert_app_download_view);
        this.iiS = (TextView) this.mRootView.findViewById(d.g.advert_app_name);
        this.iiT = (RelativeLayout) this.mRootView.findViewById(d.g.bottom_transformation_area);
        this.iiR.q(this.mContext.getUniqueId());
        this.ijc.setTag(this.mContext.getUniqueId());
        this.iiU = this.mRootView.findViewById(d.g.card_ad_middle_container);
        this.ijd.setTag(this.mContext.getUniqueId());
        this.ije.setTag(this.mContext.getUniqueId());
        this.iiX = (AdThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.iiX.setStyle(1);
        this.iiY = (AdThreadUserInfoLayout) this.mRootView.findViewById(d.g.card_ad_user_info_layout);
        if (1 == getBusinessType()) {
            this.iiY.setShowFlag(1413);
        }
        this.iiQ = (LinearLayout) LayoutInflater.from(getContext()).inflate(d.h.ad_post_tag_close, (ViewGroup) null);
        this.iiP = (AdCloseView) this.iiQ.findViewById(d.g.ad_close_view);
        this.iiO = (TextView) this.iiQ.findViewById(d.g.feed_tag);
        this.iiO.setVisibility(8);
        this.iiY.addAdTagView(this.iiQ);
        this.eip = this.mRootView.findViewById(d.g.divider_line_above_praise);
        if (4 == getBusinessType()) {
            this.mMaxWidth = (((l.aO(getContext()) - this.iiF) - this.iiG) - this.iiC) - this.iiE;
            this.iiX.setVisibility(8);
        } else {
            this.mMaxWidth = (l.aO(getContext()) - this.iiF) - this.iiG;
            this.iiX.setVisibility(0);
        }
        this.iiz = (ViewStub) this.mRootView.findViewById(d.g.ad_custom_view_stub);
        this.iiz.setLayoutResource(getCustomLayout());
        this.iiA = this.iiz.inflate();
        this.iiZ = this.mRootView.findViewById(d.g.pb_bottom_view);
        this.ija = this.mRootView.findViewById(d.g.frs_bottom_view);
        cD(this.iiA);
        return this.mRootView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(final AdCard adCard) {
        final String str;
        this.iiW = adCard;
        final AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        b bVar = new b(adCard);
        this.mRootView.setOnClickListener(bVar);
        this.iiY.getHeaderImg().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.1
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
        this.iiR.setOnClickListener(bVar);
        this.iiN.setOnClickListener(bVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iiU.getLayoutParams();
        if (4 == getBusinessType()) {
            layoutParams.leftMargin = this.iiC + this.iiE;
        } else {
            layoutParams.leftMargin = 0;
        }
        a(this.iiY.getHeaderImg(), adCard.portraitClick, bVar);
        String str2 = adCard.threadTitle;
        if (!TextUtils.isEmpty(str2)) {
            String BA = BA(ap.f(str2, 100, "..."));
            if (4 == getBusinessType()) {
                this.gAq.setTextSize(0, getContext().getResources().getDimension(d.e.ds32));
            } else {
                this.gAq.setTextSize(0, getContext().getResources().getDimension(d.e.tbfontsize44));
            }
            this.gAq.setText(BA);
            this.gAq.setVisibility(0);
        } else {
            this.gAq.setVisibility(8);
        }
        String str3 = adCard.buttonText;
        AdCard.b bVar2 = adCard.buttonClick;
        if (bVar2 == null) {
            str = "";
        } else {
            str = bVar2.scheme;
        }
        boolean z = (advertAppInfo == null || advertAppInfo.Xc()) && true == k.isEmpty(str3);
        a(this.iiT, this.iiN, this.iiR, adCard);
        if (advertAppInfo != null && advertAppInfo.Xb()) {
            this.iiS.setText(adCard.userName.concat("APP").concat(" · 广告").toString());
        } else if (advertAppInfo != null && advertAppInfo.Xc()) {
            String str4 = adCard.tagName;
            if (TextUtils.isEmpty(str4)) {
                str4 = "广告";
            }
            this.iiS.setText(str4);
        }
        if (advertAppInfo != null && advertAppInfo.Xb()) {
            this.iiV = advertAppInfo.bwF;
            this.iiR.setClickable(true);
            DownloadData c2 = c(advertAppInfo, com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, -1));
            c2.setStatus(ApkDownloadView.getStatus(c2));
            a(this.iiN, c2.getStatus(), str3);
            this.iiR.setData(c2);
            this.iiR.setVisibility(0);
        } else {
            if (!z && !k.isEmpty(str3)) {
                if (TextUtils.isEmpty(adCard.buttonTextDone) || 1 == adCard.buttonStatus) {
                    al.d(this.iiN, d.C0236d.btn_forum_focus_color, 1);
                    this.iiN.setText(str3);
                    if (k.isEmpty(str)) {
                        this.iiN.setClickable(false);
                    } else {
                        this.iiN.setClickable(true);
                        this.iiN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (AdCardBaseView.this.gHy != null && adCard.buttonClick != null && !q.Cs(adCard.buttonClick.scheme)) {
                                    AdCardBaseView.this.gHy.b(adCard.buttonClick.adq, adCard.buttonClick.adr, null);
                                }
                                if (!AdCardBaseView.this.b(adCard.buttonClick)) {
                                    if (TextUtils.isEmpty(adCard.popWindowText)) {
                                        int f = s.f(AdCardBaseView.this.mContext, str);
                                        if ((f == 1 || f == 2) && AdCardBaseView.this.gHy != null) {
                                            AdCardBaseView.this.gHy.b(f, null);
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
                                            if ((f2 == 1 || f2 == 2) && AdCardBaseView.this.gHy != null) {
                                                AdCardBaseView.this.gHy.b(f2, null);
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
                    this.iiN.setClickable(false);
                    this.iiN.setText(adCard.buttonTextDone);
                    al.k(this.iiN, d.f.btn_rounded_corner_gray_frame);
                    al.d(this.iiN, d.C0236d.cp_cont_d, 1);
                }
            }
            this.iiR.setVisibility(8);
        }
        a(adCard);
        r(i.Wy().WC(), getBusinessType());
        if (!TextUtils.isEmpty(adCard.getPreLoadData())) {
            BB(adCard.getPreLoadData());
        }
        if (advertAppInfo != null && advertAppInfo.bwL != null && advertAppInfo.bwL.adCloseInfo != null && advertAppInfo.bwL.adCloseInfo.support_close.intValue() > 0) {
            this.iiP.setVisibility(0);
            this.iiP.setPage(getBusinessType());
            this.iiP.setData(advertAppInfo);
            l.b(this.mContext.getPageActivity(), this.iiQ, 40, 40, 40, 120);
            this.iiQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdCardBaseView.this.iiP.performClick();
                }
            });
        } else {
            this.iiP.setVisibility(8);
            this.iiO.setOnClickListener(null);
        }
        this.iiX.setType(TbadkCoreApplication.getInst().getCardShowType());
        ViewGroup.LayoutParams layoutParams2 = this.dTP.getLayoutParams();
        if (4 == getBusinessType()) {
            this.iiX.setVisibility(8);
            this.iiX.setBarNameClickEnabled(false);
            this.iiX.setShareVisible(false);
            this.iiX.setShowPraiseNum(false);
            this.iiX.setCommentNumEnable(false);
            this.iiX.setReplyTimeVisible(false);
            layoutParams2.height = this.iiL;
            this.iiZ.setVisibility(0);
            this.ija.setVisibility(8);
        } else {
            a(adCard, bVar);
        }
        a(adCard, this.eip, getBusinessType());
        AdvertAppInfo advertAppInfo2 = adCard.getAdvertAppInfo();
        if (advertAppInfo2 instanceof AdvertAppInfo) {
            advertAppInfo2.lh(ap.ap(adCard.time));
        }
        this.iiY.setData(advertAppInfo2);
        ((TextView) this.iiY.getUserName()).setText(adCard.userName);
        this.iiY.getUserName().setOnClickListener(bVar);
        this.iiY.setAfterAdjustChildWidthListener(new AdThreadUserInfoLayout.AfterAdjustChildWidthListener() { // from class: com.baidu.tieba.recapp.lego.view.AdCardBaseView.4
            @Override // com.baidu.tieba.recapp.view.AdThreadUserInfoLayout.AfterAdjustChildWidthListener
            public void afterChildWidth() {
                ((TextView) AdCardBaseView.this.iiY.getUserName()).setText(adCard.userName);
            }
        });
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bbF().bbG()) {
            this.iiB.setVisibility(0);
            al.l(this.iiB, d.C0236d.cp_bg_line_d);
        } else {
            this.iiB.setVisibility(8);
        }
        a(adCard, TbadkCoreApplication.getInst().getSkinType());
    }

    private boolean isInFrsAllThread() {
        return this.gGA == 1;
    }

    private void a(AdCard adCard, b bVar) {
        if (adCard.agree_num == -999 && adCard.share_num == -999 && adCard.reply_num == -999) {
            this.ija.setVisibility(0);
            this.iiX.setVisibility(8);
            return;
        }
        this.ija.setVisibility(8);
        this.iiX.setVisibility(0);
        this.iiX.setBarNameClickEnabled(false);
        this.iiX.setReplyTimeVisible(false);
        this.iiX.setData(adCard.getThreadData());
        if (adCard.agree_num != -999) {
            this.iiX.setAgreeClickable(true);
            this.iiX.setPraiseContainerBgGray(false);
        } else {
            this.iiX.setAgreeClickable(false);
            this.iiX.setPraiseContainerBgGray(true);
        }
        if (adCard.share_num != -999) {
            this.iiX.setShareClickable(true);
            this.iiX.setShareContainerBgGray(false);
        } else {
            this.iiX.setShareClickable(false);
            this.iiX.setShareContainerBgGray(true);
        }
        if (this.iiX.getCommentContainer() != null) {
            this.iiX.getCommentContainer().setOnClickListener(bVar);
        }
        this.iiX.setNeedAddReplyIcon(true);
        this.iiX.setCommentNumEnable(false);
        this.iiX.setCommentClickable(true);
        this.iiX.setReplayContainerBgGray(true);
        this.iiX.setOnClickListener(bVar);
        this.iiX.setShareData(adCard);
        this.iiX.setDisPraiseViewVisibility(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        al.k(this.dTP, d.C0236d.cp_bg_line_c);
        this.iiP.onChangeSkinType();
        this.iiY.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
        this.iiX.onChangeSkinType();
        if (getBusinessType() == 1 || getBusinessType() == 2) {
            al.k(this.mRootView, d.f.addresslist_item_bg);
            al.l(this.dTP, d.C0236d.cp_bg_line_e);
            al.l(this.eip, d.C0236d.cp_bg_line_e);
        } else {
            al.l(this.dTP, d.C0236d.cp_bg_line_c);
            al.l(this.eip, d.C0236d.transparent);
        }
        al.d(this.gAq, d.C0236d.cp_cont_b, 1);
        al.j(this.iiS, d.C0236d.cp_cont_d);
        al.d(this.iiO, d.C0236d.cp_cont_d, 1);
        this.iiR.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String BA(String str) {
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
            if (b(bVar) && !q.Cs(bVar.scheme)) {
                if (this.gHy != null) {
                    this.gHy.b(bVar.adq, bVar.adr, null);
                    return;
                }
                return;
            }
            int f = s.f(this.mContext, BC(bVar.scheme));
            if (f == 1 || f == 2) {
                if (this.gHy != null) {
                    this.gHy.b(f, null);
                }
            } else if (this.gHy != null) {
                this.gHy.b(bVar.adq, bVar.adr, null);
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
                        if (AdCardBaseView.this.iiW.hasAnimation()) {
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
        this.gFW = new a.C0268a();
        this.gFW.picUrl = tbImageView.getUrl();
        this.gFW.rect = rect;
    }

    private void BB(String str) {
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
                    com.baidu.adp.lib.f.c.jB().a(jSONObject.optString("pic_url"), 17, null, this.gHF, (int) ((jSONObject.optInt(VrPlayerActivityConfig.PIC_HEIGHT) / jSONObject.optInt(VrPlayerActivityConfig.PIC_WIDTH)) * this.gHF), this.mContext.getUniqueId(), new Object[0]);
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
            if (!this.mPermissionJudgePolicy.Y(this.mContext.getPageActivity()) && this.gHz != null) {
                this.gHz.b(advertAppInfo, i);
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
                        AdCardBaseView.this.a(advertAppInfo, i, AdCardBaseView.this.iiR);
                        if (AdCardBaseView.this.iiR != null) {
                            AdCardBaseView.this.iiR.p(AdCardBaseView.this.c(advertAppInfo, i));
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
                    a(advertAppInfo, i, this.iiR);
                    apkDownloadView.r(c2);
                    return;
            }
            g.aS(this.mContext.getPageActivity(), advertAppInfo.bwF);
        }
    }

    public a.C0268a getAnimationInfo() {
        return this.gFW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private AdCard ijo;

        public b(AdCard adCard) {
            this.ijo = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j.kM()) {
                AdCardBaseView.this.mContext.showToast(d.j.neterror);
            } else if (this.ijo != null) {
                AdvertAppInfo advertAppInfo = this.ijo.getAdvertAppInfo();
                boolean z = view == AdCardBaseView.this.iiR;
                if (advertAppInfo != null && advertAppInfo.Xb()) {
                    int l = com.baidu.adp.lib.g.b.l(advertAppInfo.adPosition, -1);
                    int status = ApkDownloadView.getStatus(AdCardBaseView.this.c(advertAppInfo, l));
                    if ((6 == status || 7 == status) && j.kY() && !j.kZ()) {
                        AdCardBaseView.this.showDownloadAppDialog(advertAppInfo, l, true, this.ijo.popWindowText);
                        return;
                    }
                    AdCardBaseView.this.a(advertAppInfo, l, AdCardBaseView.this.iiR, z);
                    if (AdCardBaseView.this.gHy != null) {
                        AdCardBaseView.this.gHy.b(3, null);
                        return;
                    }
                    return;
                }
                String scheme = this.ijo.getScheme();
                if (k.isEmpty(scheme) && advertAppInfo != null) {
                    scheme = advertAppInfo.bwD;
                }
                if (this.ijo.hasAnimation()) {
                }
                int f = s.f(AdCardBaseView.this.mContext, AdCardBaseView.this.BC(scheme));
                if (AdCardBaseView.this.gHy != null) {
                    AdCardBaseView.this.gHy.b(f, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String BC(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (this.gFW != null && this.gFW.isValid()) {
            String c0268a = this.gFW.toString();
            if (!TextUtils.isEmpty(c0268a)) {
                sb.append("&");
                sb.append(LegoListActivityConfig.ANIMATION_INFO);
                sb.append("=");
                sb.append(URLEncoder.encode(c0268a));
            }
        }
        if (!TextUtils.isEmpty(this.iiW.getPreLoadData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.PRE_LOAD);
            sb.append("=");
            sb.append(URLEncoder.encode(this.iiW.getPreLoadData()));
        }
        if (!TextUtils.isEmpty(this.iiW.getNextPageData())) {
            sb.append("&");
            sb.append(LegoListActivityConfig.NEXT_PAGE);
            sb.append("=");
            sb.append(URLEncoder.encode(this.iiW.getNextPageData()));
        }
        if (this.iiW.hasAnimation()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.HAS_ANIMATION);
            sb.append("=");
            sb.append("1");
        }
        if (this.iiW.isGoLandingPage()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_LANDINGPAGE);
            sb.append("=");
            sb.append("1");
        }
        if (this.iiW.isImmersiveStyle()) {
            sb.append("&");
            sb.append(LegoListActivityConfig.IS_IMMERSIVE);
            sb.append("=");
            sb.append("1");
        }
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    private static class a extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> ijn;

        public a(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.ijn = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.ijn.get();
            if (adCardBaseView != null && customResponsedMessage != null) {
                DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                if (((downloadData != null) & (TextUtils.isEmpty(adCardBaseView.iiV) ? false : true)) && adCardBaseView.iiV.equals(downloadData.getId())) {
                    int status = com.baidu.tieba.recapp.download.d.getStatus(downloadData);
                    if (status == 7) {
                        adCardBaseView.iiN.setText(d.j.pause_load);
                    } else if (status == 1 || status == 2) {
                        adCardBaseView.iiN.setText(d.j.pb_download_pause);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class d extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> ijn;

        public d(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.ijn = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            AdCardBaseView adCardBaseView = this.ijn.get();
            if (adCardBaseView != null && customResponsedMessage != null && (downloadData = (DownloadData) customResponsedMessage.getData()) != null && !TextUtils.isEmpty(adCardBaseView.iiV) && adCardBaseView.iiV.equals(downloadData.getId())) {
                adCardBaseView.iiR.s(downloadData);
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class c extends CustomMessageListener {
        private final WeakReference<AdCardBaseView> ijn;

        public c(int i, AdCardBaseView adCardBaseView) {
            super(i);
            this.ijn = new WeakReference<>(adCardBaseView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AdCardBaseView adCardBaseView = this.ijn.get();
            if (adCardBaseView != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && AdCard.DEAL_URL_AFTER_LOGIN.equals((String) customResponsedMessage.getData())) {
                s.f(adCardBaseView.mContext, adCardBaseView.ijb.scheme);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, com.baidu.tieba.lego.card.view.e
    public void bAk() {
        if (4 == getBusinessType()) {
            this.gAq.setTextSize(0, TbConfig.getContentSize());
        }
    }

    protected boolean b(AdCard.b bVar) {
        if (bVar == null || bVar.iii != 1) {
            return false;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            return false;
        }
        this.ijb = bVar;
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
