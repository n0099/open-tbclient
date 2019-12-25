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
/* loaded from: classes10.dex */
public abstract class AdPostBaseView extends PostAdBaseView<AdPost> {
    private ThreadUserInfoLayout eIg;
    protected View fEe;
    private View fEh;
    protected View.OnClickListener fEl;
    private AdThreadCommentAndPraiseInfoLayout jDC;
    private ViewStub jDe;
    private View jDf;
    protected View jDg;
    private AdCloseView jDu;
    private TextView jFb;
    protected final AdOperateBarCreator jGA;
    private RelativeLayout jGx;
    private AdPost jGy;
    protected AdOperateBarHolder jGz;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void cH(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fEl = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.jGy != null) {
                    if ((AdPostBaseView.this.eIg.getUserName() == view || AdPostBaseView.this.eIg.getHeaderImg() == view) && AdPostBaseView.this.jGy.feedData.portraitClick != null) {
                        AdPostBaseView.this.n(3, AlaStaticKeys.ALA_STATIC_VALUE_ICON, AdPostBaseView.this.jGy.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.n(3, "hotarea", AdPostBaseView.this.jGy.feedData.scheme);
                }
            }
        };
        this.jGA = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        am.setBackgroundResource(this.rootView, R.drawable.addresslist_item_bg);
        this.jDC.onChangeSkinType();
        this.eIg.onChangeSkinType();
        if (this.jDu != null) {
            this.jDu.onChangeSkinType();
        }
        if (this.jGz != null) {
            this.jGz.onChangeSkinType();
        }
        am.setBackgroundColor(this.fEh, R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View bZt() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.fEl);
        this.jDg = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.jDg.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.fEh = this.rootView.findViewById(R.id.divider_line);
        this.fEe = this.rootView.findViewById(R.id.divider_line_above_praise);
        this.jDC = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.jDC.setStyle(2);
        this.eIg = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.jFb = (TextView) inflate.findViewById(R.id.feed_tag);
        this.jDu = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.jDu.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.jDu != null && AdPostBaseView.this.jDu.getVisibility() == 0) {
                    AdPostBaseView.this.jDu.performClick();
                }
            }
        });
        this.eIg.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.cQU.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.jDC.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jDC.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.jDC.setLayoutParams(layoutParams2);
        }
        this.jDC.setBarNameClickEnabled(false);
        this.jDC.setReplyTimeVisible(false);
        this.jDC.setShowPraiseNum(true);
        this.jDC.setNeedAddPraiseIcon(true);
        this.jDC.setNeedAddReplyIcon(true);
        this.jDC.setShareVisible(true);
        this.jGx = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.jGx.setOnClickListener(this.fEl);
        this.jDe = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.jDe.setLayoutResource(getCustomLayout());
        this.jDf = this.jDe.inflate();
        cH(this.jDf);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.jGy.preloadLegoCardStr)) {
            str2 = Hu(str2);
        }
        a.aVp().c(this.cQU.getPageActivity(), new String[]{str2});
        if (this.hTa != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.hTa.b(i, hashMap);
        }
    }

    private String Hu(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + ETAG.EQUAL + URLEncoder.encode(this.jGy.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.jGy = adPost;
        this.eIg.setData(adPost.getAdvertAppInfo());
        this.jDC.setShareData(adPost);
        this.jDC.setCommentClickable(true);
        this.jDC.getCommentContainer().setOnClickListener(this.fEl);
        this.jDC.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.jFb.setVisibility(8);
        } else {
            this.jFb.setVisibility(0);
            this.jFb.setText(adPost.feedData.tag_name);
            this.jFb.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.jFb.setTextSize(0, l.getDimens(this.cQU.getPageActivity(), R.dimen.fontsize24));
                am.setViewTextColor(this.jFb, R.color.cp_cont_d, 1);
            } else {
                this.jFb.setTextSize(0, l.getDimens(this.cQU.getPageActivity(), R.dimen.fontsize28));
                am.setViewTextColor(this.jFb, R.color.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.cIQ != null && advertAppInfo.cIQ.adCloseInfo != null && advertAppInfo.cIQ.adCloseInfo.support_close.intValue() > 0) {
            this.jDu.setVisibility(0);
            this.jDu.setData(advertAppInfo);
        } else {
            this.jDu.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.eIg.getHeaderImg() != null) {
            if (advertAppInfo2.azE() == null || advertAppInfo2.azE().getPendantData() == null || StringUtils.isNull(advertAppInfo2.azE().getPendantData().axX())) {
                this.eIg.getHeaderImg().setVisibility(0);
                this.eIg.getHeaderImg().setData(advertAppInfo2);
                this.eIg.getHeaderImg().setOnClickListener(this.fEl);
            } else {
                this.eIg.getHeaderImg().setVisibility(4);
            }
        }
        if (this.eIg.getUserName() != null) {
            this.eIg.getUserName().setOnClickListener(this.fEl);
        }
        com.baidu.tieba.card.l.a(this.mTitle, advertAppInfo2.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.l.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.fEe);
        am.setBackgroundColor(this.fEe, R.color.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bAp().bAq()) {
            this.jDg.setVisibility(0);
            am.setBackgroundColor(this.jDg, R.color.cp_bg_line_d);
            return;
        }
        this.jDg.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.hSe == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.axf().isShowImages() || adPost.feedData.cAf().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.jGz != null) {
            this.jGz.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.jGx.setVisibility(8);
            return;
        }
        this.jGz = this.jGA.obtainHolder(adPost, this.jGx, this.jGz, this.hTb);
        if (this.jGz != null) {
            this.jGx.setVisibility(0);
            this.jGz.setVisibility(0);
            this.jGz.update(adPost);
            this.jGz.setAfterClickSchemeListener(this.hTa);
            this.jGz.setPageContext(this.cQU);
            return;
        }
        this.jGx.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
