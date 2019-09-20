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
    private ThreadUserInfoLayout dGs;
    protected View eEA;
    private View eED;
    protected View.OnClickListener eEH;
    private ViewStub iKN;
    private View iKO;
    protected View iKP;
    private AdCloseView iLd;
    private AdThreadCommentAndPraiseInfoLayout iLl;
    private TextView iMJ;
    private RelativeLayout iOh;
    private AdPost iOi;
    protected AdOperateBarHolder iOj;
    protected final AdOperateBarCreator iOk;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void cQ(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eEH = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.iOi != null) {
                    if ((AdPostBaseView.this.dGs.getUserName() == view || AdPostBaseView.this.dGs.getHeaderImg() == view) && AdPostBaseView.this.iOi.feedData.portraitClick != null) {
                        AdPostBaseView.this.o(3, "icon", AdPostBaseView.this.iOi.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.o(3, "hotarea", AdPostBaseView.this.iOi.feedData.scheme);
                }
            }
        };
        this.iOk = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        am.k(this.rootView, R.drawable.addresslist_item_bg);
        this.iLl.onChangeSkinType();
        this.dGs.onChangeSkinType();
        if (this.iLd != null) {
            this.iLd.onChangeSkinType();
        }
        if (this.iOj != null) {
            this.iOj.onChangeSkinType();
        }
        am.l(this.eED, R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View bLw() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.eEH);
        this.iKP = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.iKP.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.eED = this.rootView.findViewById(R.id.divider_line);
        this.eEA = this.rootView.findViewById(R.id.divider_line_above_praise);
        this.iLl = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.iLl.setStyle(2);
        this.dGs = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.iMJ = (TextView) inflate.findViewById(R.id.feed_tag);
        this.iLd = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.iLd.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.iLd != null && AdPostBaseView.this.iLd.getVisibility() == 0) {
                    AdPostBaseView.this.iLd.performClick();
                }
            }
        });
        this.dGs.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.iLl.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iLl.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.iLl.setLayoutParams(layoutParams2);
        }
        this.iLl.setBarNameClickEnabled(false);
        this.iLl.setReplyTimeVisible(false);
        this.iLl.setShowPraiseNum(true);
        this.iLl.setNeedAddPraiseIcon(true);
        this.iLl.setNeedAddReplyIcon(true);
        this.iLl.setShareVisible(true);
        this.iOh = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.iOh.setOnClickListener(this.eEH);
        this.iKN = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.iKN.setLayoutResource(getCustomLayout());
        this.iKO = this.iKN.inflate();
        cQ(this.iKO);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.iOi.preloadLegoCardStr)) {
            str2 = Em(str2);
        }
        a.aDp().c(this.mContext.getPageActivity(), new String[]{str2});
        if (this.hhI != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.hhI.b(i, hashMap);
        }
    }

    private String Em(String str) {
        return str + "&" + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.iOi.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.iOi = adPost;
        this.dGs.setData(adPost.getAdvertAppInfo());
        this.iLl.setShareData(adPost);
        this.iLl.setCommentClickable(true);
        this.iLl.getCommentContainer().setOnClickListener(this.eEH);
        this.iLl.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.iMJ.setVisibility(8);
        } else {
            this.iMJ.setVisibility(0);
            this.iMJ.setText(adPost.feedData.tag_name);
            this.iMJ.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.iMJ.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.fontsize24));
                am.f(this.iMJ, R.color.cp_cont_d, 1);
            } else {
                this.iMJ.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.fontsize28));
                am.f(this.iMJ, R.color.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.bFC != null && advertAppInfo.bFC.adCloseInfo != null && advertAppInfo.bFC.adCloseInfo.support_close.intValue() > 0) {
            this.iLd.setVisibility(0);
            this.iLd.setData(advertAppInfo);
        } else {
            this.iLd.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.dGs.getHeaderImg() != null) {
            if (advertAppInfo2.aeC() == null || advertAppInfo2.aeC().getPendantData() == null || StringUtils.isNull(advertAppInfo2.aeC().getPendantData().acZ())) {
                this.dGs.getHeaderImg().setVisibility(0);
                this.dGs.getHeaderImg().setData(advertAppInfo2);
                this.dGs.getHeaderImg().setOnClickListener(this.eEH);
            } else {
                this.dGs.getHeaderImg().setVisibility(4);
            }
        }
        if (this.dGs.getUserName() != null) {
            this.dGs.getUserName().setOnClickListener(this.eEH);
        }
        n.a(this.mTitle, advertAppInfo2.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        n.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.eEA);
        am.l(this.eEA, R.color.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.blQ().blR()) {
            this.iKP.setVisibility(0);
            am.l(this.iKP, R.color.cp_bg_line_d);
            return;
        }
        this.iKP.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.hgJ == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.ace().aci() || adPost.feedData.cjb().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.iOj != null) {
            this.iOj.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.iOh.setVisibility(8);
            return;
        }
        this.iOj = this.iOk.obtainHolder(adPost, this.iOh, this.iOj, this.hhJ);
        if (this.iOj != null) {
            this.iOh.setVisibility(0);
            this.iOj.setVisibility(0);
            this.iOj.update(adPost);
            this.iOj.setAfterClickSchemeListener(this.hhI);
            this.iOj.setPageContext(this.mContext);
            return;
        }
        this.iOh.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
