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
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.a;
import com.baidu.tieba.card.m;
import com.baidu.tieba.frs.b;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdOperateBarCreator;
import com.baidu.tieba.recapp.view.AdOperateBarHolder;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import com.baidu.webkit.internal.ETAG;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes20.dex */
public abstract class AdPostBaseView extends PostAdBaseView<AdPost> {
    private ThreadUserInfoLayout fXa;
    protected View gWQ;
    private View gWT;
    protected View.OnClickListener gWX;
    private AdCloseView lnM;
    private AdThreadCommentAndPraiseInfoLayout lnU;
    private ViewStub lnt;
    private View lnu;
    protected View lnv;
    private TextView lpl;
    private RelativeLayout lqA;
    private AdPost lqB;
    protected AdOperateBarHolder lqC;
    protected final AdOperateBarCreator lqD;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void de(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gWX = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.lqB != null) {
                    if ((AdPostBaseView.this.fXa.getUserName() == view || AdPostBaseView.this.fXa.getHeaderImg() == view) && AdPostBaseView.this.lqB.feedData.portraitClick != null) {
                        AdPostBaseView.this.o(3, AlaStaticKeys.ALA_STATIC_VALUE_ICON, AdPostBaseView.this.lqB.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.o(3, "hotarea", AdPostBaseView.this.lqB.feedData.scheme);
                }
            }
        };
        this.lqD = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        ao.setBackgroundResource(this.rootView, R.drawable.addresslist_item_bg);
        this.lnU.onChangeSkinType();
        this.fXa.onChangeSkinType();
        if (this.lnM != null) {
            this.lnM.onChangeSkinType();
        }
        if (this.lqC != null) {
            this.lqC.onChangeSkinType();
        }
        ao.setBackgroundColor(this.gWT, R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View cBx() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.gWX);
        this.lnv = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.lnv.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.gWT = this.rootView.findViewById(R.id.divider_line);
        this.gWQ = this.rootView.findViewById(R.id.divider_line_above_praise);
        this.lnU = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.lnU.setStyle(2);
        this.fXa = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.lpl = (TextView) inflate.findViewById(R.id.feed_tag);
        this.lnM = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.lnM.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.lnM != null && AdPostBaseView.this.lnM.getVisibility() == 0) {
                    AdPostBaseView.this.lnM.performClick();
                }
            }
        });
        this.fXa.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.dVN.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.lnU.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lnU.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.lnU.setLayoutParams(layoutParams2);
        }
        this.lnU.setBarNameClickEnabled(false);
        this.lnU.setReplyTimeVisible(false);
        this.lnU.setShowPraiseNum(true);
        this.lnU.setNeedAddPraiseIcon(true);
        this.lnU.setNeedAddReplyIcon(true);
        this.lnU.setShareVisible(true);
        this.lqA = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.lqA.setOnClickListener(this.gWX);
        this.lnt = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.lnt.setLayoutResource(getCustomLayout());
        this.lnu = this.lnt.inflate();
        de(this.lnu);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.lqB.preloadLegoCardStr)) {
            str2 = Mw(str2);
        }
        a.brW().c(this.dVN.getPageActivity(), new String[]{str2});
        if (this.jzQ != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.jzQ.d(i, hashMap);
        }
    }

    private String Mw(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + ETAG.EQUAL + URLEncoder.encode(this.lqB.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.lqB = adPost;
        this.fXa.setData(adPost.getAdvertAppInfo());
        this.lnU.setShareData(adPost);
        this.lnU.setCommentClickable(true);
        this.lnU.getCommentContainer().setOnClickListener(this.gWX);
        this.lnU.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.lpl.setVisibility(8);
        } else {
            this.lpl.setVisibility(0);
            this.lpl.setText(adPost.feedData.tag_name);
            this.lpl.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.lpl.setTextSize(0, l.getDimens(this.dVN.getPageActivity(), R.dimen.fontsize24));
                ao.setViewTextColor(this.lpl, R.color.cp_cont_d, 1);
            } else {
                this.lpl.setTextSize(0, l.getDimens(this.dVN.getPageActivity(), R.dimen.fontsize28));
                ao.setViewTextColor(this.lpl, R.color.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.dNf != null && advertAppInfo.dNf.adCloseInfo != null && advertAppInfo.dNf.adCloseInfo.support_close.intValue() > 0) {
            this.lnM.setVisibility(0);
            this.lnM.setData(advertAppInfo);
        } else {
            this.lnM.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.fXa.getHeaderImg() != null) {
            if (advertAppInfo2.aWl() == null || advertAppInfo2.aWl().getPendantData() == null || StringUtils.isNull(advertAppInfo2.aWl().getPendantData().aUh())) {
                this.fXa.getHeaderImg().setVisibility(0);
                this.fXa.getHeaderImg().setData(advertAppInfo2);
                this.fXa.getHeaderImg().setOnClickListener(this.gWX);
            } else {
                this.fXa.getHeaderImg().setVisibility(4);
            }
        }
        if (this.fXa.getUserName() != null) {
            this.fXa.getUserName().setOnClickListener(this.gWX);
        }
        m.a(this.mTitle, advertAppInfo2.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
        m.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.gWQ);
        ao.setBackgroundColor(this.gWQ, R.color.cp_bg_line_e);
        if ((b.caw().caq() || com.baidu.tieba.frs.a.cap().caq()) && isInFrsAllThread()) {
            this.lnv.setVisibility(0);
            ao.setBackgroundColor(this.lnv, R.color.cp_bg_line_d);
            return;
        }
        this.lnv.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!k.aTv().isShowImages() || adPost.feedData.dcr().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.lqC != null) {
            this.lqC.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.lqA.setVisibility(8);
            return;
        }
        this.lqC = this.lqD.obtainHolder(adPost, this.lqA, this.lqC, this.jzR);
        if (this.lqC != null) {
            this.lqA.setVisibility(0);
            this.lqC.setVisibility(0);
            this.lqC.update(adPost);
            this.lqC.setAfterClickSchemeListener(this.jzQ);
            this.lqC.setPageContext(this.dVN);
            return;
        }
        this.lqA.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
