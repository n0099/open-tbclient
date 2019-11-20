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
import com.baidu.tieba.card.n;
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
    private ThreadUserInfoLayout dSz;
    protected View eMp;
    private View eMs;
    protected View.OnClickListener eMw;
    private ViewStub iIN;
    private View iIO;
    protected View iIP;
    private AdCloseView iJd;
    private AdThreadCommentAndPraiseInfoLayout iJl;
    private TextView iKL;
    private RelativeLayout iMi;
    private AdPost iMj;
    protected AdOperateBarHolder iMk;
    protected final AdOperateBarCreator iMl;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void cM(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eMw = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.iMj != null) {
                    if ((AdPostBaseView.this.dSz.getUserName() == view || AdPostBaseView.this.dSz.getHeaderImg() == view) && AdPostBaseView.this.iMj.feedData.portraitClick != null) {
                        AdPostBaseView.this.p(3, AlaStaticKeys.ALA_STATIC_VALUE_ICON, AdPostBaseView.this.iMj.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.p(3, "hotarea", AdPostBaseView.this.iMj.feedData.scheme);
                }
            }
        };
        this.iMl = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        am.setBackgroundResource(this.rootView, R.drawable.addresslist_item_bg);
        this.iJl.onChangeSkinType();
        this.dSz.onChangeSkinType();
        if (this.iJd != null) {
            this.iJd.onChangeSkinType();
        }
        if (this.iMk != null) {
            this.iMk.onChangeSkinType();
        }
        am.setBackgroundColor(this.eMs, R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View bIe() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.eMw);
        this.iIP = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.iIP.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.eMs = this.rootView.findViewById(R.id.divider_line);
        this.eMp = this.rootView.findViewById(R.id.divider_line_above_praise);
        this.iJl = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.iJl.setStyle(2);
        this.dSz = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.iKL = (TextView) inflate.findViewById(R.id.feed_tag);
        this.iJd = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.iJd.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.iJd != null && AdPostBaseView.this.iJd.getVisibility() == 0) {
                    AdPostBaseView.this.iJd.performClick();
                }
            }
        });
        this.dSz.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.ceu.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.iJl.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iJl.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.iJl.setLayoutParams(layoutParams2);
        }
        this.iJl.setBarNameClickEnabled(false);
        this.iJl.setReplyTimeVisible(false);
        this.iJl.setShowPraiseNum(true);
        this.iJl.setNeedAddPraiseIcon(true);
        this.iJl.setNeedAddReplyIcon(true);
        this.iJl.setShareVisible(true);
        this.iMi = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.iMi.setOnClickListener(this.eMw);
        this.iIN = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.iIN.setLayoutResource(getCustomLayout());
        this.iIO = this.iIN.inflate();
        cM(this.iIO);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.iMj.preloadLegoCardStr)) {
            str2 = CH(str2);
        }
        a.aDw().c(this.ceu.getPageActivity(), new String[]{str2});
        if (this.heW != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.heW.b(i, hashMap);
        }
    }

    private String CH(String str) {
        return str + "&" + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.iMj.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.iMj = adPost;
        this.dSz.setData(adPost.getAdvertAppInfo());
        this.iJl.setShareData(adPost);
        this.iJl.setCommentClickable(true);
        this.iJl.getCommentContainer().setOnClickListener(this.eMw);
        this.iJl.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.iKL.setVisibility(8);
        } else {
            this.iKL.setVisibility(0);
            this.iKL.setText(adPost.feedData.tag_name);
            this.iKL.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.iKL.setTextSize(0, l.getDimens(this.ceu.getPageActivity(), R.dimen.fontsize24));
                am.setViewTextColor(this.iKL, R.color.cp_cont_d, 1);
            } else {
                this.iKL.setTextSize(0, l.getDimens(this.ceu.getPageActivity(), R.dimen.fontsize28));
                am.setViewTextColor(this.iKL, R.color.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.bWD != null && advertAppInfo.bWD.adCloseInfo != null && advertAppInfo.bWD.adCloseInfo.support_close.intValue() > 0) {
            this.iJd.setVisibility(0);
            this.iJd.setData(advertAppInfo);
        } else {
            this.iJd.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.dSz.getHeaderImg() != null) {
            if (advertAppInfo2.aiE() == null || advertAppInfo2.aiE().getPendantData() == null || StringUtils.isNull(advertAppInfo2.aiE().getPendantData().ahd())) {
                this.dSz.getHeaderImg().setVisibility(0);
                this.dSz.getHeaderImg().setData(advertAppInfo2);
                this.dSz.getHeaderImg().setOnClickListener(this.eMw);
            } else {
                this.dSz.getHeaderImg().setVisibility(4);
            }
        }
        if (this.dSz.getUserName() != null) {
            this.dSz.getUserName().setOnClickListener(this.eMw);
        }
        n.a(this.mTitle, advertAppInfo2.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        n.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.eMp);
        am.setBackgroundColor(this.eMp, R.color.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.biU().biV()) {
            this.iIP.setVisibility(0);
            am.setBackgroundColor(this.iIP, R.color.cp_bg_line_d);
            return;
        }
        this.iIP.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.hdX == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.ago().isShowImages() || adPost.feedData.cgb().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.iMk != null) {
            this.iMk.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.iMi.setVisibility(8);
            return;
        }
        this.iMk = this.iMl.obtainHolder(adPost, this.iMi, this.iMk, this.heX);
        if (this.iMk != null) {
            this.iMi.setVisibility(0);
            this.iMk.setVisibility(0);
            this.iMk.update(adPost);
            this.iMk.setAfterClickSchemeListener(this.heW);
            this.iMk.setPageContext(this.ceu);
            return;
        }
        this.iMi.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
