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
/* loaded from: classes20.dex */
public abstract class AdPostBaseView extends PostAdBaseView<AdPost> {
    private ThreadUserInfoLayout gjd;
    protected View hjN;
    private View hjQ;
    protected View.OnClickListener hjU;
    private AdThreadCommentAndPraiseInfoLayout lEE;
    private ViewStub lEe;
    private View lEf;
    protected View lEg;
    private AdCloseView lEx;
    private TextView lFT;
    private RelativeLayout lHi;
    private AdPost lHj;
    protected AdOperateBarHolder lHk;
    protected final AdOperateBarCreator lHl;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void di(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hjU = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.lHj != null) {
                    if ((AdPostBaseView.this.gjd.getUserName() == view || AdPostBaseView.this.gjd.getHeaderImg() == view) && AdPostBaseView.this.lHj.feedData.portraitClick != null) {
                        AdPostBaseView.this.p(3, AlaStaticKeys.ALA_STATIC_VALUE_ICON, AdPostBaseView.this.lHj.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.p(3, "hotarea", AdPostBaseView.this.lHj.feedData.scheme);
                }
            }
        };
        this.lHl = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        ap.setBackgroundResource(this.rootView, R.drawable.addresslist_item_bg);
        this.lEE.onChangeSkinType();
        this.gjd.onChangeSkinType();
        if (this.lEx != null) {
            this.lEx.onChangeSkinType();
        }
        if (this.lHk != null) {
            this.lHk.onChangeSkinType();
        }
        ap.setBackgroundColor(this.hjQ, R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View cMq() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.hjU);
        this.lEg = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.lEg.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.hjQ = this.rootView.findViewById(R.id.divider_line);
        this.hjN = this.rootView.findViewById(R.id.divider_line_above_praise);
        this.lEE = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.lEE.setStyle(2);
        this.gjd = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.lFT = (TextView) inflate.findViewById(R.id.feed_tag);
        this.lEx = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.lEx.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.lEx != null && AdPostBaseView.this.lEx.getVisibility() == 0) {
                    AdPostBaseView.this.lEx.performClick();
                }
            }
        });
        this.gjd.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.efr.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.lEE.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lEE.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.lEE.setLayoutParams(layoutParams2);
        }
        this.lEE.setBarNameClickEnabled(false);
        this.lEE.setReplyTimeVisible(false);
        this.lEE.setShowPraiseNum(true);
        this.lEE.setNeedAddPraiseIcon(true);
        this.lEE.setNeedAddReplyIcon(true);
        this.lEE.setShareVisible(true);
        this.lHi = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.lHi.setOnClickListener(this.hjU);
        this.lEe = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.lEe.setLayoutResource(getCustomLayout());
        this.lEf = this.lEe.inflate();
        di(this.lEf);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.lHj.preloadLegoCardStr)) {
            str2 = Pv(str2);
        }
        a.bAU().c(this.efr.getPageActivity(), new String[]{str2});
        if (this.jPq != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.jPq.d(i, hashMap);
        }
    }

    private String Pv(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + ETAG.EQUAL + URLEncoder.encode(this.lHj.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.lHj = adPost;
        this.gjd.setData(adPost.getAdvertAppInfo());
        this.lEE.setShareData(adPost);
        this.lEE.setCommentClickable(true);
        this.lEE.getCommentContainer().setOnClickListener(this.hjU);
        this.lEE.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.lFT.setVisibility(8);
        } else {
            this.lFT.setVisibility(0);
            this.lFT.setText(adPost.feedData.tag_name);
            this.lFT.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.lFT.setTextSize(0, l.getDimens(this.efr.getPageActivity(), R.dimen.fontsize24));
                ap.setViewTextColor(this.lFT, R.color.cp_cont_d, 1);
            } else {
                this.lFT.setTextSize(0, l.getDimens(this.efr.getPageActivity(), R.dimen.fontsize28));
                ap.setViewTextColor(this.lFT, R.color.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.dWs != null && advertAppInfo.dWs.adCloseInfo != null && advertAppInfo.dWs.adCloseInfo.support_close.intValue() > 0) {
            this.lEx.setVisibility(0);
            this.lEx.setData(advertAppInfo);
        } else {
            this.lEx.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.gjd.getHeaderImg() != null) {
            if (advertAppInfo2.beE() == null || advertAppInfo2.beE().getPendantData() == null || StringUtils.isNull(advertAppInfo2.beE().getPendantData().bcA())) {
                this.gjd.getHeaderImg().setVisibility(0);
                this.gjd.getHeaderImg().setData(advertAppInfo2);
                this.gjd.getHeaderImg().setOnClickListener(this.hjU);
            } else {
                this.gjd.getHeaderImg().setVisibility(4);
            }
        }
        if (this.gjd.getUserName() != null) {
            this.gjd.getUserName().setOnClickListener(this.hjU);
        }
        m.a(this.mTitle, advertAppInfo2.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
        m.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.hjN);
        ap.setBackgroundColor(this.hjN, R.color.cp_bg_line_e);
        if ((b.ckT().ckN() || com.baidu.tieba.frs.a.ckM().ckN()) && isInFrsAllThread()) {
            this.lEg.setVisibility(0);
            ap.setBackgroundColor(this.lEg, R.color.cp_bg_line_d);
            return;
        }
        this.lEg.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!k.bbM().isShowImages() || adPost.feedData.dnC().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.lHk != null) {
            this.lHk.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.lHi.setVisibility(8);
            return;
        }
        this.lHk = this.lHl.obtainHolder(adPost, this.lHi, this.lHk, this.jPr);
        if (this.lHk != null) {
            this.lHi.setVisibility(0);
            this.lHk.setVisibility(0);
            this.lHk.update(adPost);
            this.lHk.setAfterClickSchemeListener(this.jPq);
            this.lHk.setPageContext(this.efr);
            return;
        }
        this.lHi.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
