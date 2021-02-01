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
/* loaded from: classes8.dex */
public abstract class AdPostBaseView extends PostAdBaseView<AdPost> {
    private ThreadUserInfoLayout hnf;
    private View iwY;
    protected View.OnClickListener ixc;
    private AdThreadCommentAndPraiseInfoLayout mTG;
    private ViewStub mTb;
    private View mTc;
    protected View mTd;
    private TextView mTitle;
    private AdCloseView mTy;
    private TextView mUT;
    protected final AdOperateBarCreator mWA;
    private RelativeLayout mWx;
    private AdPost mWy;
    protected AdOperateBarHolder mWz;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void ea(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ixc = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.mWy != null) {
                    if ((AdPostBaseView.this.hnf.getUserName() == view || AdPostBaseView.this.hnf.getHeaderImg() == view) && AdPostBaseView.this.mWy.feedData.portraitClick != null) {
                        AdPostBaseView.this.p(1, AlaStaticKeys.ALA_STATIC_VALUE_ICON, AdPostBaseView.this.mWy.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.p(1, "hotarea", AdPostBaseView.this.mWy.feedData.scheme);
                }
            }
        };
        this.mWA = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        ap.setBackgroundResource(this.rootView, R.drawable.addresslist_item_bg);
        this.mTG.onChangeSkinType();
        this.hnf.onChangeSkinType();
        if (this.mTy != null) {
            this.mTy.onChangeSkinType();
        }
        if (this.mWz != null) {
            this.mWz.onChangeSkinType();
        }
        ap.setBackgroundColor(this.iwY, R.color.CAM_X0205);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View dbO() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.ixc);
        this.mTd = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.mTd.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.iwY = this.rootView.findViewById(R.id.divider_line);
        this.mTG = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.mTG.setStyle(2);
        this.hnf = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mUT = (TextView) inflate.findViewById(R.id.feed_tag);
        this.mTy = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.mTy.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.mTy != null && AdPostBaseView.this.mTy.getVisibility() == 0) {
                    AdPostBaseView.this.mTy.performClick();
                }
            }
        });
        this.hnf.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.eUY.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.mTG.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mTG.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.mTG.setLayoutParams(layoutParams2);
        }
        this.mTG.setBarNameClickEnabled(false);
        this.mTG.setReplyTimeVisible(false);
        this.mTG.setShowPraiseNum(true);
        this.mTG.setNeedAddPraiseIcon(true);
        this.mTG.setNeedAddReplyIcon(true);
        this.mTG.setShareVisible(true);
        this.mWx = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.mWx.setOnClickListener(this.ixc);
        this.mTb = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.mTb.setLayoutResource(getCustomLayout());
        this.mTc = this.mTb.inflate();
        ea(this.mTc);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.mWy.preloadLegoCardStr)) {
            str2 = RA(str2);
        }
        a.bLi().a(this.eUY.getPageActivity(), new String[]{str2}, null);
        if (this.lcl != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.lcl.d(i, hashMap);
        }
    }

    private String RA(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.mWy.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.mWy = adPost;
        this.hnf.setData(adPost.getAdvertAppInfo());
        this.mTG.setShareData(adPost);
        this.mTG.setCommentClickable(true);
        this.mTG.getCommentContainer().setOnClickListener(this.ixc);
        this.mTG.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.mUT.setVisibility(8);
        } else {
            this.mUT.setVisibility(0);
            this.mUT.setText(adPost.feedData.tag_name);
            this.mUT.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.mUT.setTextSize(0, l.getDimens(this.eUY.getPageActivity(), R.dimen.fontsize24));
                ap.setViewTextColor(this.mUT, R.color.CAM_X0109, 1);
            } else {
                this.mUT.setTextSize(0, l.getDimens(this.eUY.getPageActivity(), R.dimen.fontsize28));
                ap.setViewTextColor(this.mUT, R.color.CAM_X0106, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.eLD != null && advertAppInfo.eLD.adCloseInfo != null && advertAppInfo.eLD.adCloseInfo.support_close.intValue() > 0) {
            this.mTy.setVisibility(0);
            this.mTy.setData(advertAppInfo);
        } else {
            this.mTy.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.hnf.getHeaderImg() != null) {
            if (advertAppInfo2.bnQ() == null || advertAppInfo2.bnQ().getPendantData() == null || StringUtils.isNull(advertAppInfo2.bnQ().getPendantData().getImgUrl())) {
                this.hnf.getHeaderImg().setVisibility(0);
                this.hnf.getHeaderImg().setData(advertAppInfo2);
                this.hnf.getHeaderImg().setOnClickListener(this.ixc);
            } else {
                this.hnf.getHeaderImg().setVisibility(4);
            }
        }
        if (this.hnf.getUserName() != null) {
            this.hnf.getUserName().setOnClickListener(this.ixc);
        }
        m.a(this.mTitle, advertAppInfo2.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        m.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        if ((b.cBr().cBl() || com.baidu.tieba.frs.a.cBk().cBl()) && isInFrsAllThread()) {
            this.mTd.setVisibility(0);
            ap.setBackgroundColor(this.mTd, R.color.CAM_X0201);
            return;
        }
        this.mTd.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.mWz != null) {
            this.mWz.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.mWx.setVisibility(8);
            return;
        }
        this.mWz = this.mWA.obtainHolder(adPost, this.mWx, this.mWz, this.lcm);
        if (this.mWz != null) {
            this.mWx.setVisibility(0);
            this.mWz.setVisibility(0);
            this.mWz.update(adPost);
            this.mWz.setAfterClickSchemeListener(this.lcl);
            this.mWz.setPageContext(this.eUY);
            return;
        }
        this.mWx.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
