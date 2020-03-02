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
    private ThreadUserInfoLayout eNl;
    protected View fJN;
    private View fJQ;
    protected View.OnClickListener fJU;
    private ViewStub jHE;
    private View jHF;
    protected View jHG;
    private AdCloseView jHY;
    private AdThreadCommentAndPraiseInfoLayout jIg;
    private TextView jJG;
    private RelativeLayout jLc;
    private AdPost jLd;
    protected AdOperateBarHolder jLe;
    protected final AdOperateBarCreator jLf;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void cO(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fJU = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.jLd != null) {
                    if ((AdPostBaseView.this.eNl.getUserName() == view || AdPostBaseView.this.eNl.getHeaderImg() == view) && AdPostBaseView.this.jLd.feedData.portraitClick != null) {
                        AdPostBaseView.this.n(3, AlaStaticKeys.ALA_STATIC_VALUE_ICON, AdPostBaseView.this.jLd.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.n(3, "hotarea", AdPostBaseView.this.jLd.feedData.scheme);
                }
            }
        };
        this.jLf = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        am.setBackgroundResource(this.rootView, R.drawable.addresslist_item_bg);
        this.jIg.onChangeSkinType();
        this.eNl.onChangeSkinType();
        if (this.jHY != null) {
            this.jHY.onChangeSkinType();
        }
        if (this.jLe != null) {
            this.jLe.onChangeSkinType();
        }
        am.setBackgroundColor(this.fJQ, R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View ccf() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.fJU);
        this.jHG = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.jHG.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.fJQ = this.rootView.findViewById(R.id.divider_line);
        this.fJN = this.rootView.findViewById(R.id.divider_line_above_praise);
        this.jIg = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.jIg.setStyle(2);
        this.eNl = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.jJG = (TextView) inflate.findViewById(R.id.feed_tag);
        this.jHY = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.jHY.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.jHY != null && AdPostBaseView.this.jHY.getVisibility() == 0) {
                    AdPostBaseView.this.jHY.performClick();
                }
            }
        });
        this.eNl.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.cVh.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.jIg.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jIg.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.jIg.setLayoutParams(layoutParams2);
        }
        this.jIg.setBarNameClickEnabled(false);
        this.jIg.setReplyTimeVisible(false);
        this.jIg.setShowPraiseNum(true);
        this.jIg.setNeedAddPraiseIcon(true);
        this.jIg.setNeedAddReplyIcon(true);
        this.jIg.setShareVisible(true);
        this.jLc = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.jLc.setOnClickListener(this.fJU);
        this.jHE = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.jHE.setLayoutResource(getCustomLayout());
        this.jHF = this.jHE.inflate();
        cO(this.jHF);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.jLd.preloadLegoCardStr)) {
            str2 = HS(str2);
        }
        a.aXZ().c(this.cVh.getPageActivity(), new String[]{str2});
        if (this.hYE != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.hYE.b(i, hashMap);
        }
    }

    private String HS(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + ETAG.EQUAL + URLEncoder.encode(this.jLd.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.jLd = adPost;
        this.eNl.setData(adPost.getAdvertAppInfo());
        this.jIg.setShareData(adPost);
        this.jIg.setCommentClickable(true);
        this.jIg.getCommentContainer().setOnClickListener(this.fJU);
        this.jIg.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.jJG.setVisibility(8);
        } else {
            this.jJG.setVisibility(0);
            this.jJG.setText(adPost.feedData.tag_name);
            this.jJG.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.jJG.setTextSize(0, l.getDimens(this.cVh.getPageActivity(), R.dimen.fontsize24));
                am.setViewTextColor(this.jJG, R.color.cp_cont_d, 1);
            } else {
                this.jJG.setTextSize(0, l.getDimens(this.cVh.getPageActivity(), R.dimen.fontsize28));
                am.setViewTextColor(this.jJG, R.color.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.cNf != null && advertAppInfo.cNf.adCloseInfo != null && advertAppInfo.cNf.adCloseInfo.support_close.intValue() > 0) {
            this.jHY.setVisibility(0);
            this.jHY.setData(advertAppInfo);
        } else {
            this.jHY.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.eNl.getHeaderImg() != null) {
            if (advertAppInfo2.aCo() == null || advertAppInfo2.aCo().getPendantData() == null || StringUtils.isNull(advertAppInfo2.aCo().getPendantData().aAG())) {
                this.eNl.getHeaderImg().setVisibility(0);
                this.eNl.getHeaderImg().setData(advertAppInfo2);
                this.eNl.getHeaderImg().setOnClickListener(this.fJU);
            } else {
                this.eNl.getHeaderImg().setVisibility(4);
            }
        }
        if (this.eNl.getUserName() != null) {
            this.eNl.getUserName().setOnClickListener(this.fJU);
        }
        com.baidu.tieba.card.l.a(this.mTitle, advertAppInfo2.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.l.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.fJN);
        am.setBackgroundColor(this.fJN, R.color.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bCV().bCW()) {
            this.jHG.setVisibility(0);
            am.setBackgroundColor(this.jHG, R.color.cp_bg_line_d);
            return;
        }
        this.jHG.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.hXI == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.azO().isShowImages() || adPost.feedData.cCM().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.jLe != null) {
            this.jLe.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.jLc.setVisibility(8);
            return;
        }
        this.jLe = this.jLf.obtainHolder(adPost, this.jLc, this.jLe, this.hYF);
        if (this.jLe != null) {
            this.jLc.setVisibility(0);
            this.jLe.setVisibility(0);
            this.jLe.update(adPost);
            this.jLe.setAfterClickSchemeListener(this.hYE);
            this.jLe.setPageContext(this.cVh);
            return;
        }
        this.jLc.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
