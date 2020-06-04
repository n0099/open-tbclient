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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.a;
import com.baidu.tieba.card.m;
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
    private ThreadUserInfoLayout fGy;
    protected View.OnClickListener gEC;
    protected View gEv;
    private View gEy;
    private AdCloseView kMB;
    private AdThreadCommentAndPraiseInfoLayout kMJ;
    private ViewStub kMi;
    private View kMj;
    protected View kMk;
    private TextView kNX;
    private RelativeLayout kPm;
    private AdPost kPn;
    protected AdOperateBarHolder kPo;
    protected final AdOperateBarCreator kPp;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void cX(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gEC = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.kPn != null) {
                    if ((AdPostBaseView.this.fGy.getUserName() == view || AdPostBaseView.this.fGy.getHeaderImg() == view) && AdPostBaseView.this.kPn.feedData.portraitClick != null) {
                        AdPostBaseView.this.o(3, AlaStaticKeys.ALA_STATIC_VALUE_ICON, AdPostBaseView.this.kPn.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.o(3, "hotarea", AdPostBaseView.this.kPn.feedData.scheme);
                }
            }
        };
        this.kPp = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        am.setBackgroundResource(this.rootView, R.drawable.addresslist_item_bg);
        this.kMJ.onChangeSkinType();
        this.fGy.onChangeSkinType();
        if (this.kMB != null) {
            this.kMB.onChangeSkinType();
        }
        if (this.kPo != null) {
            this.kPo.onChangeSkinType();
        }
        am.setBackgroundColor(this.gEy, R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View ctJ() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.gEC);
        this.kMk = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.kMk.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.gEy = this.rootView.findViewById(R.id.divider_line);
        this.gEv = this.rootView.findViewById(R.id.divider_line_above_praise);
        this.kMJ = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.kMJ.setStyle(2);
        this.fGy = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.kNX = (TextView) inflate.findViewById(R.id.feed_tag);
        this.kMB = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.kMB.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.kMB != null && AdPostBaseView.this.kMB.getVisibility() == 0) {
                    AdPostBaseView.this.kMB.performClick();
                }
            }
        });
        this.fGy.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.dIF.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.kMJ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kMJ.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.kMJ.setLayoutParams(layoutParams2);
        }
        this.kMJ.setBarNameClickEnabled(false);
        this.kMJ.setReplyTimeVisible(false);
        this.kMJ.setShowPraiseNum(true);
        this.kMJ.setNeedAddPraiseIcon(true);
        this.kMJ.setNeedAddReplyIcon(true);
        this.kMJ.setShareVisible(true);
        this.kPm = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.kPm.setOnClickListener(this.gEC);
        this.kMi = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.kMi.setLayoutResource(getCustomLayout());
        this.kMj = this.kMi.inflate();
        cX(this.kMj);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.kPn.preloadLegoCardStr)) {
            str2 = Ln(str2);
        }
        a.bmu().c(this.dIF.getPageActivity(), new String[]{str2});
        if (this.jab != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.jab.d(i, hashMap);
        }
    }

    private String Ln(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + ETAG.EQUAL + URLEncoder.encode(this.kPn.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.kPn = adPost;
        this.fGy.setData(adPost.getAdvertAppInfo());
        this.kMJ.setShareData(adPost);
        this.kMJ.setCommentClickable(true);
        this.kMJ.getCommentContainer().setOnClickListener(this.gEC);
        this.kMJ.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.kNX.setVisibility(8);
        } else {
            this.kNX.setVisibility(0);
            this.kNX.setText(adPost.feedData.tag_name);
            this.kNX.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.kNX.setTextSize(0, l.getDimens(this.dIF.getPageActivity(), R.dimen.fontsize24));
                am.setViewTextColor(this.kNX, R.color.cp_cont_d, 1);
            } else {
                this.kNX.setTextSize(0, l.getDimens(this.dIF.getPageActivity(), R.dimen.fontsize28));
                am.setViewTextColor(this.kNX, R.color.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.dAD != null && advertAppInfo.dAD.adCloseInfo != null && advertAppInfo.dAD.adCloseInfo.support_close.intValue() > 0) {
            this.kMB.setVisibility(0);
            this.kMB.setData(advertAppInfo);
        } else {
            this.kMB.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.fGy.getHeaderImg() != null) {
            if (advertAppInfo2.aQx() == null || advertAppInfo2.aQx().getPendantData() == null || StringUtils.isNull(advertAppInfo2.aQx().getPendantData().aOP())) {
                this.fGy.getHeaderImg().setVisibility(0);
                this.fGy.getHeaderImg().setData(advertAppInfo2);
                this.fGy.getHeaderImg().setOnClickListener(this.gEC);
            } else {
                this.fGy.getHeaderImg().setVisibility(4);
            }
        }
        if (this.fGy.getUserName() != null) {
            this.fGy.getUserName().setOnClickListener(this.gEC);
        }
        m.a(this.mTitle, advertAppInfo2.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        m.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.gEv);
        am.setBackgroundColor(this.gEv, R.color.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bTZ().bUa()) {
            this.kMk.setVisibility(0);
            am.setBackgroundColor(this.kMk, R.color.cp_bg_line_d);
            return;
        }
        this.kMk.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!k.aNQ().isShowImages() || adPost.feedData.cUT().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.kPo != null) {
            this.kPo.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.kPm.setVisibility(8);
            return;
        }
        this.kPo = this.kPp.obtainHolder(adPost, this.kPm, this.kPo, this.jac);
        if (this.kPo != null) {
            this.kPm.setVisibility(0);
            this.kPo.setVisibility(0);
            this.kPo.update(adPost);
            this.kPo.setAfterClickSchemeListener(this.jab);
            this.kPo.setPageContext(this.dIF);
            return;
        }
        this.kPm.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
