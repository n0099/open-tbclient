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
import com.baidu.tieba.ad.a;
import com.baidu.tieba.card.n;
import com.baidu.tieba.d;
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
    private ThreadUserInfoLayout dqy;
    protected View eip;
    private View eis;
    protected View.OnClickListener eiw;
    private View iiA;
    protected View iiB;
    private AdCloseView iiP;
    private AdThreadCommentAndPraiseInfoLayout iiX;
    private ViewStub iiz;
    private TextView ikv;
    private RelativeLayout ilT;
    private AdPost ilU;
    protected AdOperateBarHolder ilV;
    protected final AdOperateBarCreator ilW;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void cD(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eiw = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.ilU != null) {
                    if ((AdPostBaseView.this.dqy.getUserName() == view || AdPostBaseView.this.dqy.getHeaderImg() == view) && AdPostBaseView.this.ilU.feedData.portraitClick != null) {
                        AdPostBaseView.this.l(3, "icon", AdPostBaseView.this.ilU.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.l(3, "hotarea", AdPostBaseView.this.ilU.feedData.scheme);
                }
            }
        };
        this.ilW = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        al.k(this.rootView, d.f.addresslist_item_bg);
        this.iiX.onChangeSkinType();
        this.dqy.onChangeSkinType();
        if (this.iiP != null) {
            this.iiP.onChangeSkinType();
        }
        if (this.ilV != null) {
            this.ilV.onChangeSkinType();
        }
        al.l(this.eis, d.C0236d.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View bAd() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.eiw);
        this.iiB = this.rootView.findViewById(d.g.thread_multi_del_ad_mask_view);
        this.iiB.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(d.g.card_home_page_normal_thread_title);
        this.eis = this.rootView.findViewById(d.g.divider_line);
        this.eip = this.rootView.findViewById(d.g.divider_line_above_praise);
        this.iiX = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.iiX.setStyle(2);
        this.dqy = (ThreadUserInfoLayout) this.rootView.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.ad_post_tag_close, (ViewGroup) null);
        this.ikv = (TextView) inflate.findViewById(d.g.feed_tag);
        this.iiP = (AdCloseView) inflate.findViewById(d.g.ad_close_view);
        this.iiP.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.iiP != null && AdPostBaseView.this.iiP.getVisibility() == 0) {
                    AdPostBaseView.this.iiP.performClick();
                }
            }
        });
        this.dqy.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(d.e.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.iiX.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iiX.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.iiX.setLayoutParams(layoutParams2);
        }
        this.iiX.setBarNameClickEnabled(false);
        this.iiX.setReplyTimeVisible(false);
        this.iiX.setShowPraiseNum(true);
        this.iiX.setNeedAddPraiseIcon(true);
        this.iiX.setNeedAddReplyIcon(true);
        this.iiX.setShareVisible(true);
        this.ilT = (RelativeLayout) this.rootView.findViewById(d.g.ad_operate_area);
        this.ilT.setOnClickListener(this.eiw);
        this.iiz = (ViewStub) this.rootView.findViewById(d.g.ad_custom_view_stub);
        this.iiz.setLayoutResource(getCustomLayout());
        this.iiA = this.iiz.inflate();
        cD(this.iiA);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.ilU.preloadLegoCardStr)) {
            str2 = BC(str2);
        }
        a.awE().d(this.mContext.getPageActivity(), new String[]{str2});
        if (this.gHy != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.gHy.b(i, hashMap);
        }
    }

    private String BC(String str) {
        return str + "&" + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.ilU.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.ilU = adPost;
        this.dqy.setData(adPost.getAdvertAppInfo());
        this.iiX.setShareData(adPost);
        this.iiX.setCommentClickable(true);
        this.iiX.getCommentContainer().setOnClickListener(this.eiw);
        this.iiX.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.ikv.setVisibility(8);
        } else {
            this.ikv.setVisibility(0);
            this.ikv.setText(adPost.feedData.tag_name);
            this.ikv.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.ikv.setTextSize(0, l.h(this.mContext.getPageActivity(), d.e.fontsize24));
                al.d(this.ikv, d.C0236d.cp_cont_d, 1);
            } else {
                this.ikv.setTextSize(0, l.h(this.mContext.getPageActivity(), d.e.fontsize28));
                al.d(this.ikv, d.C0236d.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.bwL != null && advertAppInfo.bwL.adCloseInfo != null && advertAppInfo.bwL.adCloseInfo.support_close.intValue() > 0) {
            this.iiP.setVisibility(0);
            this.iiP.setData(advertAppInfo);
        } else {
            this.iiP.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.dqy.getHeaderImg() != null) {
            if (advertAppInfo2.YR() == null || advertAppInfo2.YR().getPendantData() == null || StringUtils.isNull(advertAppInfo2.YR().getPendantData().Xn())) {
                this.dqy.getHeaderImg().setVisibility(0);
                this.dqy.getHeaderImg().setData(advertAppInfo2);
                this.dqy.getHeaderImg().setOnClickListener(this.eiw);
            } else {
                this.dqy.getHeaderImg().setVisibility(4);
            }
        }
        if (this.dqy.getUserName() != null) {
            this.dqy.getUserName().setOnClickListener(this.eiw);
        }
        n.a(this.mTitle, advertAppInfo2.getId(), d.C0236d.cp_cont_b, d.C0236d.cp_cont_d);
        n.b(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.eip);
        al.l(this.eip, d.C0236d.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bbF().bbG()) {
            this.iiB.setVisibility(0);
            al.l(this.iiB, d.C0236d.cp_bg_line_d);
            return;
        }
        this.iiB.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.gGA == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.Wy().WC() || adPost.feedData.bWY().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.ilV != null) {
            this.ilV.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.ilT.setVisibility(8);
            return;
        }
        this.ilV = this.ilW.obtainHolder(adPost, this.ilT, this.ilV, this.gHz);
        if (this.ilV != null) {
            this.ilT.setVisibility(0);
            this.ilV.setVisibility(0);
            this.ilV.update(adPost);
            this.ilV.setAfterClickSchemeListener(this.gHy);
            this.ilV.setPageContext(this.mContext);
            return;
        }
        this.ilT.setVisibility(8);
    }

    public int getLayout() {
        return d.h.post_ad_card_base;
    }
}
