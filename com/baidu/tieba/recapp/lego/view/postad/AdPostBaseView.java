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
    private ThreadUserInfoLayout fGn;
    protected View gEk;
    private View gEn;
    protected View.OnClickListener gEr;
    private ViewStub kKZ;
    private AdThreadCommentAndPraiseInfoLayout kLA;
    private View kLa;
    protected View kLb;
    private AdCloseView kLs;
    private TextView kMO;
    private RelativeLayout kOd;
    private AdPost kOe;
    protected AdOperateBarHolder kOf;
    protected final AdOperateBarCreator kOg;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void cX(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gEr = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.kOe != null) {
                    if ((AdPostBaseView.this.fGn.getUserName() == view || AdPostBaseView.this.fGn.getHeaderImg() == view) && AdPostBaseView.this.kOe.feedData.portraitClick != null) {
                        AdPostBaseView.this.o(3, AlaStaticKeys.ALA_STATIC_VALUE_ICON, AdPostBaseView.this.kOe.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.o(3, "hotarea", AdPostBaseView.this.kOe.feedData.scheme);
                }
            }
        };
        this.kOg = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        am.setBackgroundResource(this.rootView, R.drawable.addresslist_item_bg);
        this.kLA.onChangeSkinType();
        this.fGn.onChangeSkinType();
        if (this.kLs != null) {
            this.kLs.onChangeSkinType();
        }
        if (this.kOf != null) {
            this.kOf.onChangeSkinType();
        }
        am.setBackgroundColor(this.gEn, R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View ctA() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.gEr);
        this.kLb = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.kLb.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.gEn = this.rootView.findViewById(R.id.divider_line);
        this.gEk = this.rootView.findViewById(R.id.divider_line_above_praise);
        this.kLA = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.kLA.setStyle(2);
        this.fGn = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.kMO = (TextView) inflate.findViewById(R.id.feed_tag);
        this.kLs = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.kLs.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.kLs != null && AdPostBaseView.this.kLs.getVisibility() == 0) {
                    AdPostBaseView.this.kLs.performClick();
                }
            }
        });
        this.fGn.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.dIF.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.kLA.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kLA.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.kLA.setLayoutParams(layoutParams2);
        }
        this.kLA.setBarNameClickEnabled(false);
        this.kLA.setReplyTimeVisible(false);
        this.kLA.setShowPraiseNum(true);
        this.kLA.setNeedAddPraiseIcon(true);
        this.kLA.setNeedAddReplyIcon(true);
        this.kLA.setShareVisible(true);
        this.kOd = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.kOd.setOnClickListener(this.gEr);
        this.kKZ = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.kKZ.setLayoutResource(getCustomLayout());
        this.kLa = this.kKZ.inflate();
        cX(this.kLa);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.kOe.preloadLegoCardStr)) {
            str2 = Lm(str2);
        }
        a.bms().c(this.dIF.getPageActivity(), new String[]{str2});
        if (this.iZo != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.iZo.d(i, hashMap);
        }
    }

    private String Lm(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + ETAG.EQUAL + URLEncoder.encode(this.kOe.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.kOe = adPost;
        this.fGn.setData(adPost.getAdvertAppInfo());
        this.kLA.setShareData(adPost);
        this.kLA.setCommentClickable(true);
        this.kLA.getCommentContainer().setOnClickListener(this.gEr);
        this.kLA.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.kMO.setVisibility(8);
        } else {
            this.kMO.setVisibility(0);
            this.kMO.setText(adPost.feedData.tag_name);
            this.kMO.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.kMO.setTextSize(0, l.getDimens(this.dIF.getPageActivity(), R.dimen.fontsize24));
                am.setViewTextColor(this.kMO, R.color.cp_cont_d, 1);
            } else {
                this.kMO.setTextSize(0, l.getDimens(this.dIF.getPageActivity(), R.dimen.fontsize28));
                am.setViewTextColor(this.kMO, R.color.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.dAD != null && advertAppInfo.dAD.adCloseInfo != null && advertAppInfo.dAD.adCloseInfo.support_close.intValue() > 0) {
            this.kLs.setVisibility(0);
            this.kLs.setData(advertAppInfo);
        } else {
            this.kLs.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.fGn.getHeaderImg() != null) {
            if (advertAppInfo2.aQx() == null || advertAppInfo2.aQx().getPendantData() == null || StringUtils.isNull(advertAppInfo2.aQx().getPendantData().aOP())) {
                this.fGn.getHeaderImg().setVisibility(0);
                this.fGn.getHeaderImg().setData(advertAppInfo2);
                this.fGn.getHeaderImg().setOnClickListener(this.gEr);
            } else {
                this.fGn.getHeaderImg().setVisibility(4);
            }
        }
        if (this.fGn.getUserName() != null) {
            this.fGn.getUserName().setOnClickListener(this.gEr);
        }
        m.a(this.mTitle, advertAppInfo2.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        m.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.gEk);
        am.setBackgroundColor(this.gEk, R.color.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bTX().bTY()) {
            this.kLb.setVisibility(0);
            am.setBackgroundColor(this.kLb, R.color.cp_bg_line_d);
            return;
        }
        this.kLb.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!k.aNQ().isShowImages() || adPost.feedData.cUD().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.kOf != null) {
            this.kOf.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.kOd.setVisibility(8);
            return;
        }
        this.kOf = this.kOg.obtainHolder(adPost, this.kOd, this.kOf, this.iZp);
        if (this.kOf != null) {
            this.kOd.setVisibility(0);
            this.kOf.setVisibility(0);
            this.kOf.update(adPost);
            this.kOf.setAfterClickSchemeListener(this.iZo);
            this.kOf.setPageContext(this.dIF);
            return;
        }
        this.kOd.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
