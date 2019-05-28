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
    private ViewStub iAU;
    private View iAV;
    protected View iAW;
    private AdCloseView iBk;
    private AdThreadCommentAndPraiseInfoLayout iBs;
    private TextView iCQ;
    private RelativeLayout iEo;
    private AdPost iEp;
    protected AdOperateBarHolder iEq;
    protected final AdOperateBarCreator iEr;
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
                if (AdPostBaseView.this.iEp != null) {
                    if ((AdPostBaseView.this.dBe.getUserName() == view || AdPostBaseView.this.dBe.getHeaderImg() == view) && AdPostBaseView.this.iEp.feedData.portraitClick != null) {
                        AdPostBaseView.this.n(3, "icon", AdPostBaseView.this.iEp.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.n(3, "hotarea", AdPostBaseView.this.iEp.feedData.scheme);
                }
            }
        };
        this.iEr = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        al.k(this.rootView, R.drawable.addresslist_item_bg);
        this.iBs.onChangeSkinType();
        this.dBe.onChangeSkinType();
        if (this.iBk != null) {
            this.iBk.onChangeSkinType();
        }
        if (this.iEq != null) {
            this.iEq.onChangeSkinType();
        }
        al.l(this.exP, R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View bHN() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.exT);
        this.iAW = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.iAW.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.exP = this.rootView.findViewById(R.id.divider_line);
        this.exM = this.rootView.findViewById(R.id.divider_line_above_praise);
        this.iBs = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.iBs.setStyle(2);
        this.dBe = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.iCQ = (TextView) inflate.findViewById(R.id.feed_tag);
        this.iBk = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.iBk.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.iBk != null && AdPostBaseView.this.iBk.getVisibility() == 0) {
                    AdPostBaseView.this.iBk.performClick();
                }
            }
        });
        this.dBe.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.iBs.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iBs.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.iBs.setLayoutParams(layoutParams2);
        }
        this.iBs.setBarNameClickEnabled(false);
        this.iBs.setReplyTimeVisible(false);
        this.iBs.setShowPraiseNum(true);
        this.iBs.setNeedAddPraiseIcon(true);
        this.iBs.setNeedAddReplyIcon(true);
        this.iBs.setShareVisible(true);
        this.iEo = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.iEo.setOnClickListener(this.exT);
        this.iAU = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.iAU.setLayoutResource(getCustomLayout());
        this.iAV = this.iAU.inflate();
        cL(this.iAV);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.iEp.preloadLegoCardStr)) {
            str2 = CW(str2);
        }
        a.aBK().c(this.mContext.getPageActivity(), new String[]{str2});
        if (this.gYJ != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.gYJ.b(i, hashMap);
        }
    }

    private String CW(String str) {
        return str + "&" + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.iEp.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.iEp = adPost;
        this.dBe.setData(adPost.getAdvertAppInfo());
        this.iBs.setShareData(adPost);
        this.iBs.setCommentClickable(true);
        this.iBs.getCommentContainer().setOnClickListener(this.exT);
        this.iBs.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.iCQ.setVisibility(8);
        } else {
            this.iCQ.setVisibility(0);
            this.iCQ.setText(adPost.feedData.tag_name);
            this.iCQ.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.iCQ.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.fontsize24));
                al.f(this.iCQ, R.color.cp_cont_d, 1);
            } else {
                this.iCQ.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.fontsize28));
                al.f(this.iCQ, R.color.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.bEc != null && advertAppInfo.bEc.adCloseInfo != null && advertAppInfo.bEc.adCloseInfo.support_close.intValue() > 0) {
            this.iBk.setVisibility(0);
            this.iBk.setData(advertAppInfo);
        } else {
            this.iBk.setVisibility(8);
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
            this.iAW.setVisibility(0);
            al.l(this.iAW, R.color.cp_bg_line_d);
            return;
        }
        this.iAW.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.gXL == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.abb().abf() || adPost.feedData.cfd().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.iEq != null) {
            this.iEq.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.iEo.setVisibility(8);
            return;
        }
        this.iEq = this.iEr.obtainHolder(adPost, this.iEo, this.iEq, this.gYK);
        if (this.iEq != null) {
            this.iEo.setVisibility(0);
            this.iEq.setVisibility(0);
            this.iEq.update(adPost);
            this.iEq.setAfterClickSchemeListener(this.gYJ);
            this.iEq.setPageContext(this.mContext);
            return;
        }
        this.iEo.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
