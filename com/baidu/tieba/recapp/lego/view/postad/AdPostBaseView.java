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
    private ThreadUserInfoLayout eNk;
    protected View fJL;
    private View fJO;
    protected View.OnClickListener fJS;
    private ViewStub jHC;
    private View jHD;
    protected View jHE;
    private AdCloseView jHW;
    private AdThreadCommentAndPraiseInfoLayout jIe;
    private TextView jJE;
    private RelativeLayout jLa;
    private AdPost jLb;
    protected AdOperateBarHolder jLc;
    protected final AdOperateBarCreator jLd;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void cO(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fJS = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.jLb != null) {
                    if ((AdPostBaseView.this.eNk.getUserName() == view || AdPostBaseView.this.eNk.getHeaderImg() == view) && AdPostBaseView.this.jLb.feedData.portraitClick != null) {
                        AdPostBaseView.this.n(3, AlaStaticKeys.ALA_STATIC_VALUE_ICON, AdPostBaseView.this.jLb.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.n(3, "hotarea", AdPostBaseView.this.jLb.feedData.scheme);
                }
            }
        };
        this.jLd = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        am.setBackgroundResource(this.rootView, R.drawable.addresslist_item_bg);
        this.jIe.onChangeSkinType();
        this.eNk.onChangeSkinType();
        if (this.jHW != null) {
            this.jHW.onChangeSkinType();
        }
        if (this.jLc != null) {
            this.jLc.onChangeSkinType();
        }
        am.setBackgroundColor(this.fJO, R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View ccd() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.fJS);
        this.jHE = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.jHE.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.fJO = this.rootView.findViewById(R.id.divider_line);
        this.fJL = this.rootView.findViewById(R.id.divider_line_above_praise);
        this.jIe = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.jIe.setStyle(2);
        this.eNk = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.jJE = (TextView) inflate.findViewById(R.id.feed_tag);
        this.jHW = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.jHW.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.jHW != null && AdPostBaseView.this.jHW.getVisibility() == 0) {
                    AdPostBaseView.this.jHW.performClick();
                }
            }
        });
        this.eNk.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.cVg.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.jIe.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jIe.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.jIe.setLayoutParams(layoutParams2);
        }
        this.jIe.setBarNameClickEnabled(false);
        this.jIe.setReplyTimeVisible(false);
        this.jIe.setShowPraiseNum(true);
        this.jIe.setNeedAddPraiseIcon(true);
        this.jIe.setNeedAddReplyIcon(true);
        this.jIe.setShareVisible(true);
        this.jLa = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.jLa.setOnClickListener(this.fJS);
        this.jHC = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.jHC.setLayoutResource(getCustomLayout());
        this.jHD = this.jHC.inflate();
        cO(this.jHD);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.jLb.preloadLegoCardStr)) {
            str2 = HS(str2);
        }
        a.aXX().c(this.cVg.getPageActivity(), new String[]{str2});
        if (this.hYC != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.hYC.b(i, hashMap);
        }
    }

    private String HS(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + ETAG.EQUAL + URLEncoder.encode(this.jLb.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.jLb = adPost;
        this.eNk.setData(adPost.getAdvertAppInfo());
        this.jIe.setShareData(adPost);
        this.jIe.setCommentClickable(true);
        this.jIe.getCommentContainer().setOnClickListener(this.fJS);
        this.jIe.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.jJE.setVisibility(8);
        } else {
            this.jJE.setVisibility(0);
            this.jJE.setText(adPost.feedData.tag_name);
            this.jJE.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.jJE.setTextSize(0, l.getDimens(this.cVg.getPageActivity(), R.dimen.fontsize24));
                am.setViewTextColor(this.jJE, R.color.cp_cont_d, 1);
            } else {
                this.jJE.setTextSize(0, l.getDimens(this.cVg.getPageActivity(), R.dimen.fontsize28));
                am.setViewTextColor(this.jJE, R.color.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.cNe != null && advertAppInfo.cNe.adCloseInfo != null && advertAppInfo.cNe.adCloseInfo.support_close.intValue() > 0) {
            this.jHW.setVisibility(0);
            this.jHW.setData(advertAppInfo);
        } else {
            this.jHW.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.eNk.getHeaderImg() != null) {
            if (advertAppInfo2.aCm() == null || advertAppInfo2.aCm().getPendantData() == null || StringUtils.isNull(advertAppInfo2.aCm().getPendantData().aAE())) {
                this.eNk.getHeaderImg().setVisibility(0);
                this.eNk.getHeaderImg().setData(advertAppInfo2);
                this.eNk.getHeaderImg().setOnClickListener(this.fJS);
            } else {
                this.eNk.getHeaderImg().setVisibility(4);
            }
        }
        if (this.eNk.getUserName() != null) {
            this.eNk.getUserName().setOnClickListener(this.fJS);
        }
        com.baidu.tieba.card.l.a(this.mTitle, advertAppInfo2.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.l.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.fJL);
        am.setBackgroundColor(this.fJL, R.color.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bCT().bCU()) {
            this.jHE.setVisibility(0);
            am.setBackgroundColor(this.jHE, R.color.cp_bg_line_d);
            return;
        }
        this.jHE.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.hXG == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.azM().isShowImages() || adPost.feedData.cCK().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.jLc != null) {
            this.jLc.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.jLa.setVisibility(8);
            return;
        }
        this.jLc = this.jLd.obtainHolder(adPost, this.jLa, this.jLc, this.hYD);
        if (this.jLc != null) {
            this.jLa.setVisibility(0);
            this.jLc.setVisibility(0);
            this.jLc.update(adPost);
            this.jLc.setAfterClickSchemeListener(this.hYC);
            this.jLc.setPageContext(this.cVg);
            return;
        }
        this.jLa.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
