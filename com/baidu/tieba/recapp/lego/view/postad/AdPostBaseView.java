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
    protected View ehY;
    private View eib;
    protected View.OnClickListener eif;
    private AdThreadCommentAndPraiseInfoLayout iiE;
    private ViewStub iig;
    private View iih;
    protected View iii;
    private AdCloseView iiw;
    private TextView ikc;
    private RelativeLayout ilA;
    private AdPost ilB;
    protected AdOperateBarHolder ilC;
    protected final AdOperateBarCreator ilD;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void cD(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eif = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.ilB != null) {
                    if ((AdPostBaseView.this.dqy.getUserName() == view || AdPostBaseView.this.dqy.getHeaderImg() == view) && AdPostBaseView.this.ilB.feedData.portraitClick != null) {
                        AdPostBaseView.this.l(3, "icon", AdPostBaseView.this.ilB.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.l(3, "hotarea", AdPostBaseView.this.ilB.feedData.scheme);
                }
            }
        };
        this.ilD = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        al.k(this.rootView, d.f.addresslist_item_bg);
        this.iiE.onChangeSkinType();
        this.dqy.onChangeSkinType();
        if (this.iiw != null) {
            this.iiw.onChangeSkinType();
        }
        if (this.ilC != null) {
            this.ilC.onChangeSkinType();
        }
        al.l(this.eib, d.C0277d.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View bAa() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.eif);
        this.iii = this.rootView.findViewById(d.g.thread_multi_del_ad_mask_view);
        this.iii.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(d.g.card_home_page_normal_thread_title);
        this.eib = this.rootView.findViewById(d.g.divider_line);
        this.ehY = this.rootView.findViewById(d.g.divider_line_above_praise);
        this.iiE = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.iiE.setStyle(2);
        this.dqy = (ThreadUserInfoLayout) this.rootView.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.ad_post_tag_close, (ViewGroup) null);
        this.ikc = (TextView) inflate.findViewById(d.g.feed_tag);
        this.iiw = (AdCloseView) inflate.findViewById(d.g.ad_close_view);
        this.iiw.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.iiw != null && AdPostBaseView.this.iiw.getVisibility() == 0) {
                    AdPostBaseView.this.iiw.performClick();
                }
            }
        });
        this.dqy.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(d.e.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.iiE.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iiE.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.iiE.setLayoutParams(layoutParams2);
        }
        this.iiE.setBarNameClickEnabled(false);
        this.iiE.setReplyTimeVisible(false);
        this.iiE.setShowPraiseNum(true);
        this.iiE.setNeedAddPraiseIcon(true);
        this.iiE.setNeedAddReplyIcon(true);
        this.iiE.setShareVisible(true);
        this.ilA = (RelativeLayout) this.rootView.findViewById(d.g.ad_operate_area);
        this.ilA.setOnClickListener(this.eif);
        this.iig = (ViewStub) this.rootView.findViewById(d.g.ad_custom_view_stub);
        this.iig.setLayoutResource(getCustomLayout());
        this.iih = this.iig.inflate();
        cD(this.iih);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.ilB.preloadLegoCardStr)) {
            str2 = BA(str2);
        }
        a.awB().d(this.mContext.getPageActivity(), new String[]{str2});
        if (this.gHm != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.gHm.b(i, hashMap);
        }
    }

    private String BA(String str) {
        return str + "&" + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.ilB.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.ilB = adPost;
        this.dqy.setData(adPost.getAdvertAppInfo());
        this.iiE.setShareData(adPost);
        this.iiE.setCommentClickable(true);
        this.iiE.getCommentContainer().setOnClickListener(this.eif);
        this.iiE.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.ikc.setVisibility(8);
        } else {
            this.ikc.setVisibility(0);
            this.ikc.setText(adPost.feedData.tag_name);
            this.ikc.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.ikc.setTextSize(0, l.h(this.mContext.getPageActivity(), d.e.fontsize24));
                al.d(this.ikc, d.C0277d.cp_cont_d, 1);
            } else {
                this.ikc.setTextSize(0, l.h(this.mContext.getPageActivity(), d.e.fontsize28));
                al.d(this.ikc, d.C0277d.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.bwR != null && advertAppInfo.bwR.adCloseInfo != null && advertAppInfo.bwR.adCloseInfo.support_close.intValue() > 0) {
            this.iiw.setVisibility(0);
            this.iiw.setData(advertAppInfo);
        } else {
            this.iiw.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.dqy.getHeaderImg() != null) {
            if (advertAppInfo2.YO() == null || advertAppInfo2.YO().getPendantData() == null || StringUtils.isNull(advertAppInfo2.YO().getPendantData().Xk())) {
                this.dqy.getHeaderImg().setVisibility(0);
                this.dqy.getHeaderImg().setData(advertAppInfo2);
                this.dqy.getHeaderImg().setOnClickListener(this.eif);
            } else {
                this.dqy.getHeaderImg().setVisibility(4);
            }
        }
        if (this.dqy.getUserName() != null) {
            this.dqy.getUserName().setOnClickListener(this.eif);
        }
        n.a(this.mTitle, advertAppInfo2.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        n.b(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.ehY);
        al.l(this.ehY, d.C0277d.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bbD().bbE()) {
            this.iii.setVisibility(0);
            al.l(this.iii, d.C0277d.cp_bg_line_d);
            return;
        }
        this.iii.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.gGo == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.Wv().Wz() || adPost.feedData.bWX().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.ilC != null) {
            this.ilC.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.ilA.setVisibility(8);
            return;
        }
        this.ilC = this.ilD.obtainHolder(adPost, this.ilA, this.ilC, this.gHn);
        if (this.ilC != null) {
            this.ilA.setVisibility(0);
            this.ilC.setVisibility(0);
            this.ilC.update(adPost);
            this.ilC.setAfterClickSchemeListener(this.gHm);
            this.ilC.setPageContext(this.mContext);
            return;
        }
        this.ilA.setVisibility(8);
    }

    public int getLayout() {
        return d.h.post_ad_card_base;
    }
}
