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
    private ViewStub iiA;
    private View iiB;
    protected View iiC;
    private AdCloseView iiQ;
    private AdThreadCommentAndPraiseInfoLayout iiY;
    private TextView ikw;
    private RelativeLayout ilU;
    private AdPost ilV;
    protected AdOperateBarHolder ilW;
    protected final AdOperateBarCreator ilX;
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
                if (AdPostBaseView.this.ilV != null) {
                    if ((AdPostBaseView.this.dqy.getUserName() == view || AdPostBaseView.this.dqy.getHeaderImg() == view) && AdPostBaseView.this.ilV.feedData.portraitClick != null) {
                        AdPostBaseView.this.l(3, "icon", AdPostBaseView.this.ilV.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.l(3, "hotarea", AdPostBaseView.this.ilV.feedData.scheme);
                }
            }
        };
        this.ilX = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        al.k(this.rootView, d.f.addresslist_item_bg);
        this.iiY.onChangeSkinType();
        this.dqy.onChangeSkinType();
        if (this.iiQ != null) {
            this.iiQ.onChangeSkinType();
        }
        if (this.ilW != null) {
            this.ilW.onChangeSkinType();
        }
        al.l(this.eis, d.C0236d.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View bAe() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.eiw);
        this.iiC = this.rootView.findViewById(d.g.thread_multi_del_ad_mask_view);
        this.iiC.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(d.g.card_home_page_normal_thread_title);
        this.eis = this.rootView.findViewById(d.g.divider_line);
        this.eip = this.rootView.findViewById(d.g.divider_line_above_praise);
        this.iiY = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.iiY.setStyle(2);
        this.dqy = (ThreadUserInfoLayout) this.rootView.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.ad_post_tag_close, (ViewGroup) null);
        this.ikw = (TextView) inflate.findViewById(d.g.feed_tag);
        this.iiQ = (AdCloseView) inflate.findViewById(d.g.ad_close_view);
        this.iiQ.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.iiQ != null && AdPostBaseView.this.iiQ.getVisibility() == 0) {
                    AdPostBaseView.this.iiQ.performClick();
                }
            }
        });
        this.dqy.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(d.e.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.iiY.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iiY.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.iiY.setLayoutParams(layoutParams2);
        }
        this.iiY.setBarNameClickEnabled(false);
        this.iiY.setReplyTimeVisible(false);
        this.iiY.setShowPraiseNum(true);
        this.iiY.setNeedAddPraiseIcon(true);
        this.iiY.setNeedAddReplyIcon(true);
        this.iiY.setShareVisible(true);
        this.ilU = (RelativeLayout) this.rootView.findViewById(d.g.ad_operate_area);
        this.ilU.setOnClickListener(this.eiw);
        this.iiA = (ViewStub) this.rootView.findViewById(d.g.ad_custom_view_stub);
        this.iiA.setLayoutResource(getCustomLayout());
        this.iiB = this.iiA.inflate();
        cD(this.iiB);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.ilV.preloadLegoCardStr)) {
            str2 = BD(str2);
        }
        a.awF().d(this.mContext.getPageActivity(), new String[]{str2});
        if (this.gHz != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.gHz.b(i, hashMap);
        }
    }

    private String BD(String str) {
        return str + "&" + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.ilV.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.ilV = adPost;
        this.dqy.setData(adPost.getAdvertAppInfo());
        this.iiY.setShareData(adPost);
        this.iiY.setCommentClickable(true);
        this.iiY.getCommentContainer().setOnClickListener(this.eiw);
        this.iiY.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.ikw.setVisibility(8);
        } else {
            this.ikw.setVisibility(0);
            this.ikw.setText(adPost.feedData.tag_name);
            this.ikw.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.ikw.setTextSize(0, l.h(this.mContext.getPageActivity(), d.e.fontsize24));
                al.d(this.ikw, d.C0236d.cp_cont_d, 1);
            } else {
                this.ikw.setTextSize(0, l.h(this.mContext.getPageActivity(), d.e.fontsize28));
                al.d(this.ikw, d.C0236d.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.bwL != null && advertAppInfo.bwL.adCloseInfo != null && advertAppInfo.bwL.adCloseInfo.support_close.intValue() > 0) {
            this.iiQ.setVisibility(0);
            this.iiQ.setData(advertAppInfo);
        } else {
            this.iiQ.setVisibility(8);
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
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bbG().bbH()) {
            this.iiC.setVisibility(0);
            al.l(this.iiC, d.C0236d.cp_bg_line_d);
            return;
        }
        this.iiC.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.gGB == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.Wy().WC() || adPost.feedData.bWZ().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.ilW != null) {
            this.ilW.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.ilU.setVisibility(8);
            return;
        }
        this.ilW = this.ilX.obtainHolder(adPost, this.ilU, this.ilW, this.gHA);
        if (this.ilW != null) {
            this.ilU.setVisibility(0);
            this.ilW.setVisibility(0);
            this.ilW.update(adPost);
            this.ilW.setAfterClickSchemeListener(this.gHz);
            this.ilW.setPageContext(this.mContext);
            return;
        }
        this.ilU.setVisibility(8);
    }

    public int getLayout() {
        return d.h.post_ad_card_base;
    }
}
