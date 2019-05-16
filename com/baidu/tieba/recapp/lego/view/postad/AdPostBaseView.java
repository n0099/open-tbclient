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
import com.baidu.tbadk.core.util.al;
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
    private ThreadUserInfoLayout dBd;
    protected View exL;
    private View exO;
    protected View.OnClickListener exS;
    private ViewStub iAS;
    private View iAT;
    protected View iAU;
    private AdCloseView iBi;
    private AdThreadCommentAndPraiseInfoLayout iBq;
    private TextView iCO;
    private RelativeLayout iEm;
    private AdPost iEn;
    protected AdOperateBarHolder iEo;
    protected final AdOperateBarCreator iEp;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void cL(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.exS = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.iEn != null) {
                    if ((AdPostBaseView.this.dBd.getUserName() == view || AdPostBaseView.this.dBd.getHeaderImg() == view) && AdPostBaseView.this.iEn.feedData.portraitClick != null) {
                        AdPostBaseView.this.n(3, "icon", AdPostBaseView.this.iEn.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.n(3, "hotarea", AdPostBaseView.this.iEn.feedData.scheme);
                }
            }
        };
        this.iEp = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        al.k(this.rootView, R.drawable.addresslist_item_bg);
        this.iBq.onChangeSkinType();
        this.dBd.onChangeSkinType();
        if (this.iBi != null) {
            this.iBi.onChangeSkinType();
        }
        if (this.iEo != null) {
            this.iEo.onChangeSkinType();
        }
        al.l(this.exO, R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View bHK() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.exS);
        this.iAU = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.iAU.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.exO = this.rootView.findViewById(R.id.divider_line);
        this.exL = this.rootView.findViewById(R.id.divider_line_above_praise);
        this.iBq = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.iBq.setStyle(2);
        this.dBd = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.iCO = (TextView) inflate.findViewById(R.id.feed_tag);
        this.iBi = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.iBi.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.iBi != null && AdPostBaseView.this.iBi.getVisibility() == 0) {
                    AdPostBaseView.this.iBi.performClick();
                }
            }
        });
        this.dBd.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.iBq.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iBq.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.iBq.setLayoutParams(layoutParams2);
        }
        this.iBq.setBarNameClickEnabled(false);
        this.iBq.setReplyTimeVisible(false);
        this.iBq.setShowPraiseNum(true);
        this.iBq.setNeedAddPraiseIcon(true);
        this.iBq.setNeedAddReplyIcon(true);
        this.iBq.setShareVisible(true);
        this.iEm = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.iEm.setOnClickListener(this.exS);
        this.iAS = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.iAS.setLayoutResource(getCustomLayout());
        this.iAT = this.iAS.inflate();
        cL(this.iAT);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.iEn.preloadLegoCardStr)) {
            str2 = CW(str2);
        }
        a.aBH().c(this.mContext.getPageActivity(), new String[]{str2});
        if (this.gYG != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.gYG.b(i, hashMap);
        }
    }

    private String CW(String str) {
        return str + "&" + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.iEn.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.iEn = adPost;
        this.dBd.setData(adPost.getAdvertAppInfo());
        this.iBq.setShareData(adPost);
        this.iBq.setCommentClickable(true);
        this.iBq.getCommentContainer().setOnClickListener(this.exS);
        this.iBq.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.iCO.setVisibility(8);
        } else {
            this.iCO.setVisibility(0);
            this.iCO.setText(adPost.feedData.tag_name);
            this.iCO.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.iCO.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.fontsize24));
                al.f(this.iCO, R.color.cp_cont_d, 1);
            } else {
                this.iCO.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.fontsize28));
                al.f(this.iCO, R.color.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.bEc != null && advertAppInfo.bEc.adCloseInfo != null && advertAppInfo.bEc.adCloseInfo.support_close.intValue() > 0) {
            this.iBi.setVisibility(0);
            this.iBi.setData(advertAppInfo);
        } else {
            this.iBi.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.dBd.getHeaderImg() != null) {
            if (advertAppInfo2.adv() == null || advertAppInfo2.adv().getPendantData() == null || StringUtils.isNull(advertAppInfo2.adv().getPendantData().abS())) {
                this.dBd.getHeaderImg().setVisibility(0);
                this.dBd.getHeaderImg().setData(advertAppInfo2);
                this.dBd.getHeaderImg().setOnClickListener(this.exS);
            } else {
                this.dBd.getHeaderImg().setVisibility(4);
            }
        }
        if (this.dBd.getUserName() != null) {
            this.dBd.getUserName().setOnClickListener(this.exS);
        }
        n.a(this.mTitle, advertAppInfo2.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        n.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.exL);
        al.l(this.exL, R.color.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.biT().biU()) {
            this.iAU.setVisibility(0);
            al.l(this.iAU, R.color.cp_bg_line_d);
            return;
        }
        this.iAU.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.gXI == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.abb().abf() || adPost.feedData.cfb().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.iEo != null) {
            this.iEo.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.iEm.setVisibility(8);
            return;
        }
        this.iEo = this.iEp.obtainHolder(adPost, this.iEm, this.iEo, this.gYH);
        if (this.iEo != null) {
            this.iEm.setVisibility(0);
            this.iEo.setVisibility(0);
            this.iEo.update(adPost);
            this.iEo.setAfterClickSchemeListener(this.gYG);
            this.iEo.setPageContext(this.mContext);
            return;
        }
        this.iEm.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
