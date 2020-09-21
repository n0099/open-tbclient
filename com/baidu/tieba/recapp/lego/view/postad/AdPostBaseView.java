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
import com.baidu.tbadk.core.util.ap;
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
/* loaded from: classes25.dex */
public abstract class AdPostBaseView extends PostAdBaseView<AdPost> {
    private ThreadUserInfoLayout gmk;
    protected View hqQ;
    private View hqT;
    protected View.OnClickListener hqX;
    private ViewStub lMY;
    private View lMZ;
    protected View lNa;
    private AdCloseView lNr;
    private AdThreadCommentAndPraiseInfoLayout lNy;
    private TextView lON;
    private RelativeLayout lQc;
    private AdPost lQd;
    protected AdOperateBarHolder lQe;
    protected final AdOperateBarCreator lQf;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void dq(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hqX = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.lQd != null) {
                    if ((AdPostBaseView.this.gmk.getUserName() == view || AdPostBaseView.this.gmk.getHeaderImg() == view) && AdPostBaseView.this.lQd.feedData.portraitClick != null) {
                        AdPostBaseView.this.p(3, AlaStaticKeys.ALA_STATIC_VALUE_ICON, AdPostBaseView.this.lQd.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.p(3, "hotarea", AdPostBaseView.this.lQd.feedData.scheme);
                }
            }
        };
        this.lQf = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        ap.setBackgroundResource(this.rootView, R.drawable.addresslist_item_bg);
        this.lNy.onChangeSkinType();
        this.gmk.onChangeSkinType();
        if (this.lNr != null) {
            this.lNr.onChangeSkinType();
        }
        if (this.lQe != null) {
            this.lQe.onChangeSkinType();
        }
        ap.setBackgroundColor(this.hqT, R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View cPW() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.hqX);
        this.lNa = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.lNa.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.hqT = this.rootView.findViewById(R.id.divider_line);
        this.hqQ = this.rootView.findViewById(R.id.divider_line_above_praise);
        this.lNy = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.lNy.setStyle(2);
        this.gmk = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.lON = (TextView) inflate.findViewById(R.id.feed_tag);
        this.lNr = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.lNr.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.lNr != null && AdPostBaseView.this.lNr.getVisibility() == 0) {
                    AdPostBaseView.this.lNr.performClick();
                }
            }
        });
        this.gmk.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.ehG.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.lNy.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lNy.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.lNy.setLayoutParams(layoutParams2);
        }
        this.lNy.setBarNameClickEnabled(false);
        this.lNy.setReplyTimeVisible(false);
        this.lNy.setShowPraiseNum(true);
        this.lNy.setNeedAddPraiseIcon(true);
        this.lNy.setNeedAddReplyIcon(true);
        this.lNy.setShareVisible(true);
        this.lQc = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.lQc.setOnClickListener(this.hqX);
        this.lMY = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.lMY.setLayoutResource(getCustomLayout());
        this.lMZ = this.lMY.inflate();
        dq(this.lMZ);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.lQd.preloadLegoCardStr)) {
            str2 = PV(str2);
        }
        a.bCg().c(this.ehG.getPageActivity(), new String[]{str2});
        if (this.jXT != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.jXT.d(i, hashMap);
        }
    }

    private String PV(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + ETAG.EQUAL + URLEncoder.encode(this.lQd.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.lQd = adPost;
        this.gmk.setData(adPost.getAdvertAppInfo());
        this.lNy.setShareData(adPost);
        this.lNy.setCommentClickable(true);
        this.lNy.getCommentContainer().setOnClickListener(this.hqX);
        this.lNy.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.lON.setVisibility(8);
        } else {
            this.lON.setVisibility(0);
            this.lON.setText(adPost.feedData.tag_name);
            this.lON.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.lON.setTextSize(0, l.getDimens(this.ehG.getPageActivity(), R.dimen.fontsize24));
                ap.setViewTextColor(this.lON, R.color.cp_cont_d, 1);
            } else {
                this.lON.setTextSize(0, l.getDimens(this.ehG.getPageActivity(), R.dimen.fontsize28));
                ap.setViewTextColor(this.lON, R.color.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.dYC != null && advertAppInfo.dYC.adCloseInfo != null && advertAppInfo.dYC.adCloseInfo.support_close.intValue() > 0) {
            this.lNr.setVisibility(0);
            this.lNr.setData(advertAppInfo);
        } else {
            this.lNr.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.gmk.getHeaderImg() != null) {
            if (advertAppInfo2.bfy() == null || advertAppInfo2.bfy().getPendantData() == null || StringUtils.isNull(advertAppInfo2.bfy().getPendantData().bdu())) {
                this.gmk.getHeaderImg().setVisibility(0);
                this.gmk.getHeaderImg().setData(advertAppInfo2);
                this.gmk.getHeaderImg().setOnClickListener(this.hqX);
            } else {
                this.gmk.getHeaderImg().setVisibility(4);
            }
        }
        if (this.gmk.getUserName() != null) {
            this.gmk.getUserName().setOnClickListener(this.hqX);
        }
        m.a(this.mTitle, advertAppInfo2.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
        m.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.hqQ);
        ap.setBackgroundColor(this.hqQ, R.color.cp_bg_line_e);
        if ((b.cog().coa() || com.baidu.tieba.frs.a.cnZ().coa()) && isInFrsAllThread()) {
            this.lNa.setVisibility(0);
            ap.setBackgroundColor(this.lNa, R.color.cp_bg_line_d);
            return;
        }
        this.lNa.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!k.bcG().isShowImages() || adPost.feedData.drl().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.lQe != null) {
            this.lQe.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.lQc.setVisibility(8);
            return;
        }
        this.lQe = this.lQf.obtainHolder(adPost, this.lQc, this.lQe, this.jXU);
        if (this.lQe != null) {
            this.lQc.setVisibility(0);
            this.lQe.setVisibility(0);
            this.lQe.update(adPost);
            this.lQe.setAfterClickSchemeListener(this.jXT);
            this.lQe.setPageContext(this.ehG);
            return;
        }
        this.lQc.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
