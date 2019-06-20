package com.baidu.tieba.recapp.lego.view.postad;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.a;
import com.baidu.tieba.card.n;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdOperateBarCreator;
import com.baidu.tieba.recapp.view.AdOperateBarHolder;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes3.dex */
public abstract class AdPostBaseView extends PostAdBaseView<AdPost> {
    private ThreadUserInfoLayout dBe;
    protected View exM;
    private View exP;
    protected View.OnClickListener exT;
    private ViewStub iAV;
    private View iAW;
    protected View iAX;
    private AdCloseView iBl;
    private AdThreadCommentAndPraiseInfoLayout iBt;
    private TextView iCR;
    private RelativeLayout iEp;
    private AdPost iEq;
    protected AdOperateBarHolder iEr;
    protected final AdOperateBarCreator iEs;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void cL(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.exT = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.iEq != null) {
                    if ((AdPostBaseView.this.dBe.getUserName() == view || AdPostBaseView.this.dBe.getHeaderImg() == view) && AdPostBaseView.this.iEq.feedData.portraitClick != null) {
                        AdPostBaseView.this.n(3, "icon", AdPostBaseView.this.iEq.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.n(3, "hotarea", AdPostBaseView.this.iEq.feedData.scheme);
                }
            }
        };
        this.iEs = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        al.k(this.rootView, R.drawable.addresslist_item_bg);
        this.iBt.onChangeSkinType();
        this.dBe.onChangeSkinType();
        if (this.iBl != null) {
            this.iBl.onChangeSkinType();
        }
        if (this.iEr != null) {
            this.iEr.onChangeSkinType();
        }
        al.l(this.exP, R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View bHO() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.exT);
        this.iAX = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.iAX.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.exP = this.rootView.findViewById(R.id.divider_line);
        this.exM = this.rootView.findViewById(R.id.divider_line_above_praise);
        this.iBt = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.iBt.setStyle(2);
        this.dBe = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.iCR = (TextView) inflate.findViewById(R.id.feed_tag);
        this.iBl = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.iBl.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.iBl != null && AdPostBaseView.this.iBl.getVisibility() == 0) {
                    AdPostBaseView.this.iBl.performClick();
                }
            }
        });
        this.dBe.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.iBt.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iBt.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.iBt.setLayoutParams(layoutParams2);
        }
        this.iBt.setBarNameClickEnabled(false);
        this.iBt.setReplyTimeVisible(false);
        this.iBt.setShowPraiseNum(true);
        this.iBt.setNeedAddPraiseIcon(true);
        this.iBt.setNeedAddReplyIcon(true);
        this.iBt.setShareVisible(true);
        this.iEp = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.iEp.setOnClickListener(this.exT);
        this.iAV = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.iAV.setLayoutResource(getCustomLayout());
        this.iAW = this.iAV.inflate();
        cL(this.iAW);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.iEq.preloadLegoCardStr)) {
            str2 = CY(str2);
        }
        a.aBK().c(this.mContext.getPageActivity(), new String[]{str2});
        if (this.gYK != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.gYK.b(i, hashMap);
        }
    }

    private String CY(String str) {
        return str + "&" + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.iEq.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.iEq = adPost;
        this.dBe.setData(adPost.getAdvertAppInfo());
        this.iBt.setShareData(adPost);
        this.iBt.setCommentClickable(true);
        this.iBt.getCommentContainer().setOnClickListener(this.exT);
        this.iBt.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.iCR.setVisibility(8);
        } else {
            this.iCR.setVisibility(0);
            this.iCR.setText(adPost.feedData.tag_name);
            this.iCR.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.iCR.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.fontsize24));
                al.f(this.iCR, R.color.cp_cont_d, 1);
            } else {
                this.iCR.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.fontsize28));
                al.f(this.iCR, R.color.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.bEd != null && advertAppInfo.bEd.adCloseInfo != null && advertAppInfo.bEd.adCloseInfo.support_close.intValue() > 0) {
            this.iBl.setVisibility(0);
            this.iBl.setData(advertAppInfo);
        } else {
            this.iBl.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.dBe.getHeaderImg() != null) {
            if (advertAppInfo2.adv() == null || advertAppInfo2.adv().getPendantData() == null || StringUtils.isNull(advertAppInfo2.adv().getPendantData().abS())) {
                this.dBe.getHeaderImg().setVisibility(0);
                this.dBe.getHeaderImg().setData(advertAppInfo2);
                this.dBe.getHeaderImg().setOnClickListener(this.exT);
            } else {
                this.dBe.getHeaderImg().setVisibility(4);
            }
        }
        if (this.dBe.getUserName() != null) {
            this.dBe.getUserName().setOnClickListener(this.exT);
        }
        n.a(this.mTitle, advertAppInfo2.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        n.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.exM);
        al.l(this.exM, R.color.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.biW().biX()) {
            this.iAX.setVisibility(0);
            al.l(this.iAX, R.color.cp_bg_line_d);
            return;
        }
        this.iAX.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.gXM == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.abb().abf() || adPost.feedData.cfe().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.iEr != null) {
            this.iEr.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.iEp.setVisibility(8);
            return;
        }
        this.iEr = this.iEs.obtainHolder(adPost, this.iEp, this.iEr, this.gYL);
        if (this.iEr != null) {
            this.iEp.setVisibility(0);
            this.iEr.setVisibility(0);
            this.iEr.update(adPost);
            this.iEr.setAfterClickSchemeListener(this.gYK);
            this.iEr.setPageContext(this.mContext);
            return;
        }
        this.iEp.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
