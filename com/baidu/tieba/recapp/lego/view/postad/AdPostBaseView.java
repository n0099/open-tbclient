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
    private ThreadUserInfoLayout dqx;
    protected View ehX;
    private View eia;
    protected View.OnClickListener eie;
    private AdThreadCommentAndPraiseInfoLayout iiD;
    private ViewStub iif;
    private View iig;
    protected View iih;
    private AdCloseView iiv;
    private TextView ikb;
    private AdPost ilA;
    protected AdOperateBarHolder ilB;
    protected final AdOperateBarCreator ilC;
    private RelativeLayout ilz;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void cD(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eie = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.ilA != null) {
                    if ((AdPostBaseView.this.dqx.getUserName() == view || AdPostBaseView.this.dqx.getHeaderImg() == view) && AdPostBaseView.this.ilA.feedData.portraitClick != null) {
                        AdPostBaseView.this.l(3, "icon", AdPostBaseView.this.ilA.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.l(3, "hotarea", AdPostBaseView.this.ilA.feedData.scheme);
                }
            }
        };
        this.ilC = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        al.k(this.rootView, d.f.addresslist_item_bg);
        this.iiD.onChangeSkinType();
        this.dqx.onChangeSkinType();
        if (this.iiv != null) {
            this.iiv.onChangeSkinType();
        }
        if (this.ilB != null) {
            this.ilB.onChangeSkinType();
        }
        al.l(this.eia, d.C0277d.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View bAa() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.eie);
        this.iih = this.rootView.findViewById(d.g.thread_multi_del_ad_mask_view);
        this.iih.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(d.g.card_home_page_normal_thread_title);
        this.eia = this.rootView.findViewById(d.g.divider_line);
        this.ehX = this.rootView.findViewById(d.g.divider_line_above_praise);
        this.iiD = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.iiD.setStyle(2);
        this.dqx = (ThreadUserInfoLayout) this.rootView.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.ad_post_tag_close, (ViewGroup) null);
        this.ikb = (TextView) inflate.findViewById(d.g.feed_tag);
        this.iiv = (AdCloseView) inflate.findViewById(d.g.ad_close_view);
        this.iiv.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.iiv != null && AdPostBaseView.this.iiv.getVisibility() == 0) {
                    AdPostBaseView.this.iiv.performClick();
                }
            }
        });
        this.dqx.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(d.e.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.iiD.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iiD.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.iiD.setLayoutParams(layoutParams2);
        }
        this.iiD.setBarNameClickEnabled(false);
        this.iiD.setReplyTimeVisible(false);
        this.iiD.setShowPraiseNum(true);
        this.iiD.setNeedAddPraiseIcon(true);
        this.iiD.setNeedAddReplyIcon(true);
        this.iiD.setShareVisible(true);
        this.ilz = (RelativeLayout) this.rootView.findViewById(d.g.ad_operate_area);
        this.ilz.setOnClickListener(this.eie);
        this.iif = (ViewStub) this.rootView.findViewById(d.g.ad_custom_view_stub);
        this.iif.setLayoutResource(getCustomLayout());
        this.iig = this.iif.inflate();
        cD(this.iig);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.ilA.preloadLegoCardStr)) {
            str2 = BA(str2);
        }
        a.awB().d(this.mContext.getPageActivity(), new String[]{str2});
        if (this.gHl != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.gHl.b(i, hashMap);
        }
    }

    private String BA(String str) {
        return str + "&" + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.ilA.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.ilA = adPost;
        this.dqx.setData(adPost.getAdvertAppInfo());
        this.iiD.setShareData(adPost);
        this.iiD.setCommentClickable(true);
        this.iiD.getCommentContainer().setOnClickListener(this.eie);
        this.iiD.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.ikb.setVisibility(8);
        } else {
            this.ikb.setVisibility(0);
            this.ikb.setText(adPost.feedData.tag_name);
            this.ikb.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.ikb.setTextSize(0, l.h(this.mContext.getPageActivity(), d.e.fontsize24));
                al.d(this.ikb, d.C0277d.cp_cont_d, 1);
            } else {
                this.ikb.setTextSize(0, l.h(this.mContext.getPageActivity(), d.e.fontsize28));
                al.d(this.ikb, d.C0277d.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.bwQ != null && advertAppInfo.bwQ.adCloseInfo != null && advertAppInfo.bwQ.adCloseInfo.support_close.intValue() > 0) {
            this.iiv.setVisibility(0);
            this.iiv.setData(advertAppInfo);
        } else {
            this.iiv.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.dqx.getHeaderImg() != null) {
            if (advertAppInfo2.YO() == null || advertAppInfo2.YO().getPendantData() == null || StringUtils.isNull(advertAppInfo2.YO().getPendantData().Xk())) {
                this.dqx.getHeaderImg().setVisibility(0);
                this.dqx.getHeaderImg().setData(advertAppInfo2);
                this.dqx.getHeaderImg().setOnClickListener(this.eie);
            } else {
                this.dqx.getHeaderImg().setVisibility(4);
            }
        }
        if (this.dqx.getUserName() != null) {
            this.dqx.getUserName().setOnClickListener(this.eie);
        }
        n.a(this.mTitle, advertAppInfo2.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        n.b(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.ehX);
        al.l(this.ehX, d.C0277d.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bbD().bbE()) {
            this.iih.setVisibility(0);
            al.l(this.iih, d.C0277d.cp_bg_line_d);
            return;
        }
        this.iih.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.gGn == 1;
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
        if (this.ilB != null) {
            this.ilB.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.ilz.setVisibility(8);
            return;
        }
        this.ilB = this.ilC.obtainHolder(adPost, this.ilz, this.ilB, this.gHm);
        if (this.ilB != null) {
            this.ilz.setVisibility(0);
            this.ilB.setVisibility(0);
            this.ilB.update(adPost);
            this.ilB.setAfterClickSchemeListener(this.gHl);
            this.ilB.setPageContext(this.mContext);
            return;
        }
        this.ilz.setVisibility(8);
    }

    public int getLayout() {
        return d.h.post_ad_card_base;
    }
}
