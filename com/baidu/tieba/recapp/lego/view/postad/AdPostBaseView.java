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
import com.baidu.tbadk.core.util.an;
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
/* loaded from: classes13.dex */
public abstract class AdPostBaseView extends PostAdBaseView<AdPost> {
    private ThreadUserInfoLayout fRH;
    protected View gRl;
    private View gRo;
    protected View.OnClickListener gRs;
    private AdThreadCommentAndPraiseInfoLayout lgD;
    private ViewStub lgc;
    private View lgd;
    protected View lge;
    private AdCloseView lgv;
    private TextView lhQ;
    private RelativeLayout ljf;
    private AdPost ljg;
    protected AdOperateBarHolder ljh;
    protected final AdOperateBarCreator lji;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void cY(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gRs = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.ljg != null) {
                    if ((AdPostBaseView.this.fRH.getUserName() == view || AdPostBaseView.this.fRH.getHeaderImg() == view) && AdPostBaseView.this.ljg.feedData.portraitClick != null) {
                        AdPostBaseView.this.o(3, AlaStaticKeys.ALA_STATIC_VALUE_ICON, AdPostBaseView.this.ljg.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.o(3, "hotarea", AdPostBaseView.this.ljg.feedData.scheme);
                }
            }
        };
        this.lji = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        an.setBackgroundResource(this.rootView, R.drawable.addresslist_item_bg);
        this.lgD.onChangeSkinType();
        this.fRH.onChangeSkinType();
        if (this.lgv != null) {
            this.lgv.onChangeSkinType();
        }
        if (this.ljh != null) {
            this.ljh.onChangeSkinType();
        }
        an.setBackgroundColor(this.gRo, R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View cxz() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.gRs);
        this.lge = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.lge.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.gRo = this.rootView.findViewById(R.id.divider_line);
        this.gRl = this.rootView.findViewById(R.id.divider_line_above_praise);
        this.lgD = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.lgD.setStyle(2);
        this.fRH = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.lhQ = (TextView) inflate.findViewById(R.id.feed_tag);
        this.lgv = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.lgv.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.lgv != null && AdPostBaseView.this.lgv.getVisibility() == 0) {
                    AdPostBaseView.this.lgv.performClick();
                }
            }
        });
        this.fRH.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.dPv.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.lgD.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lgD.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.lgD.setLayoutParams(layoutParams2);
        }
        this.lgD.setBarNameClickEnabled(false);
        this.lgD.setReplyTimeVisible(false);
        this.lgD.setShowPraiseNum(true);
        this.lgD.setNeedAddPraiseIcon(true);
        this.lgD.setNeedAddReplyIcon(true);
        this.lgD.setShareVisible(true);
        this.ljf = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.ljf.setOnClickListener(this.gRs);
        this.lgc = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.lgc.setLayoutResource(getCustomLayout());
        this.lgd = this.lgc.inflate();
        cY(this.lgd);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.ljg.preloadLegoCardStr)) {
            str2 = LO(str2);
        }
        a.boU().c(this.dPv.getPageActivity(), new String[]{str2});
        if (this.jrl != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.jrl.d(i, hashMap);
        }
    }

    private String LO(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + ETAG.EQUAL + URLEncoder.encode(this.ljg.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.ljg = adPost;
        this.fRH.setData(adPost.getAdvertAppInfo());
        this.lgD.setShareData(adPost);
        this.lgD.setCommentClickable(true);
        this.lgD.getCommentContainer().setOnClickListener(this.gRs);
        this.lgD.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.lhQ.setVisibility(8);
        } else {
            this.lhQ.setVisibility(0);
            this.lhQ.setText(adPost.feedData.tag_name);
            this.lhQ.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.lhQ.setTextSize(0, l.getDimens(this.dPv.getPageActivity(), R.dimen.fontsize24));
                an.setViewTextColor(this.lhQ, R.color.cp_cont_d, 1);
            } else {
                this.lhQ.setTextSize(0, l.getDimens(this.dPv.getPageActivity(), R.dimen.fontsize28));
                an.setViewTextColor(this.lhQ, R.color.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.dGU != null && advertAppInfo.dGU.adCloseInfo != null && advertAppInfo.dGU.adCloseInfo.support_close.intValue() > 0) {
            this.lgv.setVisibility(0);
            this.lgv.setData(advertAppInfo);
        } else {
            this.lgv.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.fRH.getHeaderImg() != null) {
            if (advertAppInfo2.aSp() == null || advertAppInfo2.aSp().getPendantData() == null || StringUtils.isNull(advertAppInfo2.aSp().getPendantData().aQl())) {
                this.fRH.getHeaderImg().setVisibility(0);
                this.fRH.getHeaderImg().setData(advertAppInfo2);
                this.fRH.getHeaderImg().setOnClickListener(this.gRs);
            } else {
                this.fRH.getHeaderImg().setVisibility(4);
            }
        }
        if (this.fRH.getUserName() != null) {
            this.fRH.getUserName().setOnClickListener(this.gRs);
        }
        m.a(this.mTitle, advertAppInfo2.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        m.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.gRl);
        an.setBackgroundColor(this.gRl, R.color.cp_bg_line_e);
        if ((b.bXd().bWX() || com.baidu.tieba.frs.a.bWW().bWX()) && isInFrsAllThread()) {
            this.lge.setVisibility(0);
            an.setBackgroundColor(this.lge, R.color.cp_bg_line_d);
            return;
        }
        this.lge.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!k.aPA().isShowImages() || adPost.feedData.cZk().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.ljh != null) {
            this.ljh.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.ljf.setVisibility(8);
            return;
        }
        this.ljh = this.lji.obtainHolder(adPost, this.ljf, this.ljh, this.jrm);
        if (this.ljh != null) {
            this.ljf.setVisibility(0);
            this.ljh.setVisibility(0);
            this.ljh.update(adPost);
            this.ljh.setAfterClickSchemeListener(this.jrl);
            this.ljh.setPageContext(this.dPv);
            return;
        }
        this.ljf.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
