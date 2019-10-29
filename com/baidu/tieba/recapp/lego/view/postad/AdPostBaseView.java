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
    private ThreadUserInfoLayout dTq;
    protected View eNg;
    private View eNj;
    protected View.OnClickListener eNn;
    private ViewStub iJE;
    private View iJF;
    protected View iJG;
    private AdCloseView iJU;
    private AdThreadCommentAndPraiseInfoLayout iKc;
    private TextView iLC;
    private RelativeLayout iMZ;
    private AdPost iNa;
    protected AdOperateBarHolder iNb;
    protected final AdOperateBarCreator iNc;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void cM(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eNn = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.iNa != null) {
                    if ((AdPostBaseView.this.dTq.getUserName() == view || AdPostBaseView.this.dTq.getHeaderImg() == view) && AdPostBaseView.this.iNa.feedData.portraitClick != null) {
                        AdPostBaseView.this.p(3, AlaStaticKeys.ALA_STATIC_VALUE_ICON, AdPostBaseView.this.iNa.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.p(3, "hotarea", AdPostBaseView.this.iNa.feedData.scheme);
                }
            }
        };
        this.iNc = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        am.setBackgroundResource(this.rootView, R.drawable.addresslist_item_bg);
        this.iKc.onChangeSkinType();
        this.dTq.onChangeSkinType();
        if (this.iJU != null) {
            this.iJU.onChangeSkinType();
        }
        if (this.iNb != null) {
            this.iNb.onChangeSkinType();
        }
        am.setBackgroundColor(this.eNj, R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View bIg() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.eNn);
        this.iJG = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.iJG.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.eNj = this.rootView.findViewById(R.id.divider_line);
        this.eNg = this.rootView.findViewById(R.id.divider_line_above_praise);
        this.iKc = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.iKc.setStyle(2);
        this.dTq = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.iLC = (TextView) inflate.findViewById(R.id.feed_tag);
        this.iJU = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.iJU.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.iJU != null && AdPostBaseView.this.iJU.getVisibility() == 0) {
                    AdPostBaseView.this.iJU.performClick();
                }
            }
        });
        this.dTq.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.cfl.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.iKc.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iKc.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.iKc.setLayoutParams(layoutParams2);
        }
        this.iKc.setBarNameClickEnabled(false);
        this.iKc.setReplyTimeVisible(false);
        this.iKc.setShowPraiseNum(true);
        this.iKc.setNeedAddPraiseIcon(true);
        this.iKc.setNeedAddReplyIcon(true);
        this.iKc.setShareVisible(true);
        this.iMZ = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.iMZ.setOnClickListener(this.eNn);
        this.iJE = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.iJE.setLayoutResource(getCustomLayout());
        this.iJF = this.iJE.inflate();
        cM(this.iJF);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.iNa.preloadLegoCardStr)) {
            str2 = CH(str2);
        }
        a.aDy().c(this.cfl.getPageActivity(), new String[]{str2});
        if (this.hfN != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.hfN.b(i, hashMap);
        }
    }

    private String CH(String str) {
        return str + "&" + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.iNa.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.iNa = adPost;
        this.dTq.setData(adPost.getAdvertAppInfo());
        this.iKc.setShareData(adPost);
        this.iKc.setCommentClickable(true);
        this.iKc.getCommentContainer().setOnClickListener(this.eNn);
        this.iKc.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.iLC.setVisibility(8);
        } else {
            this.iLC.setVisibility(0);
            this.iLC.setText(adPost.feedData.tag_name);
            this.iLC.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.iLC.setTextSize(0, l.getDimens(this.cfl.getPageActivity(), R.dimen.fontsize24));
                am.setViewTextColor(this.iLC, R.color.cp_cont_d, 1);
            } else {
                this.iLC.setTextSize(0, l.getDimens(this.cfl.getPageActivity(), R.dimen.fontsize28));
                am.setViewTextColor(this.iLC, R.color.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.bXu != null && advertAppInfo.bXu.adCloseInfo != null && advertAppInfo.bXu.adCloseInfo.support_close.intValue() > 0) {
            this.iJU.setVisibility(0);
            this.iJU.setData(advertAppInfo);
        } else {
            this.iJU.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.dTq.getHeaderImg() != null) {
            if (advertAppInfo2.aiG() == null || advertAppInfo2.aiG().getPendantData() == null || StringUtils.isNull(advertAppInfo2.aiG().getPendantData().ahf())) {
                this.dTq.getHeaderImg().setVisibility(0);
                this.dTq.getHeaderImg().setData(advertAppInfo2);
                this.dTq.getHeaderImg().setOnClickListener(this.eNn);
            } else {
                this.dTq.getHeaderImg().setVisibility(4);
            }
        }
        if (this.dTq.getUserName() != null) {
            this.dTq.getUserName().setOnClickListener(this.eNn);
        }
        n.a(this.mTitle, advertAppInfo2.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        n.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.eNg);
        am.setBackgroundColor(this.eNg, R.color.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.biW().biX()) {
            this.iJG.setVisibility(0);
            am.setBackgroundColor(this.iJG, R.color.cp_bg_line_d);
            return;
        }
        this.iJG.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.heO == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.agq().isShowImages() || adPost.feedData.cgd().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.iNb != null) {
            this.iNb.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.iMZ.setVisibility(8);
            return;
        }
        this.iNb = this.iNc.obtainHolder(adPost, this.iMZ, this.iNb, this.hfO);
        if (this.iNb != null) {
            this.iMZ.setVisibility(0);
            this.iNb.setVisibility(0);
            this.iNb.update(adPost);
            this.iNb.setAfterClickSchemeListener(this.hfN);
            this.iNb.setPageContext(this.cfl);
            return;
        }
        this.iMZ.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
