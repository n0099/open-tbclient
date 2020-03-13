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
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.a;
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
    private ThreadUserInfoLayout eNy;
    protected View fKa;
    private View fKd;
    protected View.OnClickListener fKh;
    private ViewStub jHQ;
    private View jHR;
    protected View jHS;
    private AdCloseView jIk;
    private AdThreadCommentAndPraiseInfoLayout jIs;
    private TextView jJS;
    private RelativeLayout jLo;
    private AdPost jLp;
    protected AdOperateBarHolder jLq;
    protected final AdOperateBarCreator jLr;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void cO(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fKh = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.jLp != null) {
                    if ((AdPostBaseView.this.eNy.getUserName() == view || AdPostBaseView.this.eNy.getHeaderImg() == view) && AdPostBaseView.this.jLp.feedData.portraitClick != null) {
                        AdPostBaseView.this.n(3, AlaStaticKeys.ALA_STATIC_VALUE_ICON, AdPostBaseView.this.jLp.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.n(3, "hotarea", AdPostBaseView.this.jLp.feedData.scheme);
                }
            }
        };
        this.jLr = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        am.setBackgroundResource(this.rootView, R.drawable.addresslist_item_bg);
        this.jIs.onChangeSkinType();
        this.eNy.onChangeSkinType();
        if (this.jIk != null) {
            this.jIk.onChangeSkinType();
        }
        if (this.jLq != null) {
            this.jLq.onChangeSkinType();
        }
        am.setBackgroundColor(this.fKd, R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View ccg() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.fKh);
        this.jHS = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.jHS.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.fKd = this.rootView.findViewById(R.id.divider_line);
        this.fKa = this.rootView.findViewById(R.id.divider_line_above_praise);
        this.jIs = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.jIs.setStyle(2);
        this.eNy = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.jJS = (TextView) inflate.findViewById(R.id.feed_tag);
        this.jIk = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.jIk.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.jIk != null && AdPostBaseView.this.jIk.getVisibility() == 0) {
                    AdPostBaseView.this.jIk.performClick();
                }
            }
        });
        this.eNy.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.cVi.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.jIs.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jIs.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.jIs.setLayoutParams(layoutParams2);
        }
        this.jIs.setBarNameClickEnabled(false);
        this.jIs.setReplyTimeVisible(false);
        this.jIs.setShowPraiseNum(true);
        this.jIs.setNeedAddPraiseIcon(true);
        this.jIs.setNeedAddReplyIcon(true);
        this.jIs.setShareVisible(true);
        this.jLo = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.jLo.setOnClickListener(this.fKh);
        this.jHQ = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.jHQ.setLayoutResource(getCustomLayout());
        this.jHR = this.jHQ.inflate();
        cO(this.jHR);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.jLp.preloadLegoCardStr)) {
            str2 = HT(str2);
        }
        a.aYa().c(this.cVi.getPageActivity(), new String[]{str2});
        if (this.hYQ != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.hYQ.b(i, hashMap);
        }
    }

    private String HT(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + ETAG.EQUAL + URLEncoder.encode(this.jLp.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.jLp = adPost;
        this.eNy.setData(adPost.getAdvertAppInfo());
        this.jIs.setShareData(adPost);
        this.jIs.setCommentClickable(true);
        this.jIs.getCommentContainer().setOnClickListener(this.fKh);
        this.jIs.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.jJS.setVisibility(8);
        } else {
            this.jJS.setVisibility(0);
            this.jJS.setText(adPost.feedData.tag_name);
            this.jJS.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.jJS.setTextSize(0, l.getDimens(this.cVi.getPageActivity(), R.dimen.fontsize24));
                am.setViewTextColor(this.jJS, R.color.cp_cont_d, 1);
            } else {
                this.jJS.setTextSize(0, l.getDimens(this.cVi.getPageActivity(), R.dimen.fontsize28));
                am.setViewTextColor(this.jJS, R.color.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.cNg != null && advertAppInfo.cNg.adCloseInfo != null && advertAppInfo.cNg.adCloseInfo.support_close.intValue() > 0) {
            this.jIk.setVisibility(0);
            this.jIk.setData(advertAppInfo);
        } else {
            this.jIk.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.eNy.getHeaderImg() != null) {
            if (advertAppInfo2.aCo() == null || advertAppInfo2.aCo().getPendantData() == null || StringUtils.isNull(advertAppInfo2.aCo().getPendantData().aAG())) {
                this.eNy.getHeaderImg().setVisibility(0);
                this.eNy.getHeaderImg().setData(advertAppInfo2);
                this.eNy.getHeaderImg().setOnClickListener(this.fKh);
            } else {
                this.eNy.getHeaderImg().setVisibility(4);
            }
        }
        if (this.eNy.getUserName() != null) {
            this.eNy.getUserName().setOnClickListener(this.fKh);
        }
        com.baidu.tieba.card.l.a(this.mTitle, advertAppInfo2.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.l.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.fKa);
        am.setBackgroundColor(this.fKa, R.color.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bCW().bCX()) {
            this.jHS.setVisibility(0);
            am.setBackgroundColor(this.jHS, R.color.cp_bg_line_d);
            return;
        }
        this.jHS.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.hXU == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.azO().isShowImages() || adPost.feedData.cCN().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.jLq != null) {
            this.jLq.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.jLo.setVisibility(8);
            return;
        }
        this.jLq = this.jLr.obtainHolder(adPost, this.jLo, this.jLq, this.hYR);
        if (this.jLq != null) {
            this.jLo.setVisibility(0);
            this.jLq.setVisibility(0);
            this.jLq.update(adPost);
            this.jLq.setAfterClickSchemeListener(this.hYQ);
            this.jLq.setPageContext(this.cVi);
            return;
        }
        this.jLo.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
