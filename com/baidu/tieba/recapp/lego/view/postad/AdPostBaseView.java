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
/* loaded from: classes7.dex */
public abstract class AdPostBaseView extends PostAdBaseView<AdPost> {
    private ThreadUserInfoLayout hpd;
    private View iyV;
    protected View.OnClickListener iyZ;
    private TextView mTitle;
    private ViewStub mVO;
    private View mVP;
    protected View mVQ;
    private AdCloseView mWj;
    private AdThreadCommentAndPraiseInfoLayout mWr;
    private TextView mXE;
    private RelativeLayout mZi;
    private AdPost mZj;
    protected AdOperateBarHolder mZk;
    protected final AdOperateBarCreator mZl;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void ea(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iyZ = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.mZj != null) {
                    if ((AdPostBaseView.this.hpd.getUserName() == view || AdPostBaseView.this.hpd.getHeaderImg() == view) && AdPostBaseView.this.mZj.feedData.portraitClick != null) {
                        AdPostBaseView.this.p(1, AlaStaticKeys.ALA_STATIC_VALUE_ICON, AdPostBaseView.this.mZj.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.p(1, "hotarea", AdPostBaseView.this.mZj.feedData.scheme);
                }
            }
        };
        this.mZl = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        ap.setBackgroundResource(this.rootView, R.drawable.addresslist_item_bg);
        this.mWr.onChangeSkinType();
        this.hpd.onChangeSkinType();
        if (this.mWj != null) {
            this.mWj.onChangeSkinType();
        }
        if (this.mZk != null) {
            this.mZk.onChangeSkinType();
        }
        ap.setBackgroundColor(this.iyV, R.color.CAM_X0205);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View dce() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.iyZ);
        this.mVQ = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.mVQ.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.iyV = this.rootView.findViewById(R.id.divider_line);
        this.mWr = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.mWr.setStyle(2);
        this.hpd = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mXE = (TextView) inflate.findViewById(R.id.feed_tag);
        this.mWj = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.mWj.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.mWj != null && AdPostBaseView.this.mWj.getVisibility() == 0) {
                    AdPostBaseView.this.mWj.performClick();
                }
            }
        });
        this.hpd.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.eWx.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.mWr.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mWr.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.mWr.setLayoutParams(layoutParams2);
        }
        this.mWr.setBarNameClickEnabled(false);
        this.mWr.setReplyTimeVisible(false);
        this.mWr.setShowPraiseNum(true);
        this.mWr.setNeedAddPraiseIcon(true);
        this.mWr.setNeedAddReplyIcon(true);
        this.mWr.setShareVisible(true);
        this.mZi = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.mZi.setOnClickListener(this.iyZ);
        this.mVO = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.mVO.setLayoutResource(getCustomLayout());
        this.mVP = this.mVO.inflate();
        ea(this.mVP);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.mZj.preloadLegoCardStr)) {
            str2 = RS(str2);
        }
        a.bLr().a(this.eWx.getPageActivity(), new String[]{str2}, null);
        if (this.leD != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.leD.d(i, hashMap);
        }
    }

    private String RS(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.mZj.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.mZj = adPost;
        this.hpd.setData(adPost.getAdvertAppInfo());
        this.mWr.setShareData(adPost);
        this.mWr.setCommentClickable(true);
        this.mWr.getCommentContainer().setOnClickListener(this.iyZ);
        this.mWr.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.mXE.setVisibility(8);
        } else {
            this.mXE.setVisibility(0);
            this.mXE.setText(adPost.feedData.tag_name);
            this.mXE.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.mXE.setTextSize(0, l.getDimens(this.eWx.getPageActivity(), R.dimen.fontsize24));
                ap.setViewTextColor(this.mXE, R.color.CAM_X0109, 1);
            } else {
                this.mXE.setTextSize(0, l.getDimens(this.eWx.getPageActivity(), R.dimen.fontsize28));
                ap.setViewTextColor(this.mXE, R.color.CAM_X0106, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.eNd != null && advertAppInfo.eNd.adCloseInfo != null && advertAppInfo.eNd.adCloseInfo.support_close.intValue() > 0) {
            this.mWj.setVisibility(0);
            this.mWj.setData(advertAppInfo);
        } else {
            this.mWj.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.hpd.getHeaderImg() != null) {
            if (advertAppInfo2.bnS() == null || advertAppInfo2.bnS().getPendantData() == null || StringUtils.isNull(advertAppInfo2.bnS().getPendantData().getImgUrl())) {
                this.hpd.getHeaderImg().setVisibility(0);
                this.hpd.getHeaderImg().setData(advertAppInfo2);
                this.hpd.getHeaderImg().setOnClickListener(this.iyZ);
            } else {
                this.hpd.getHeaderImg().setVisibility(4);
            }
        }
        if (this.hpd.getUserName() != null) {
            this.hpd.getUserName().setOnClickListener(this.iyZ);
        }
        m.a(this.mTitle, advertAppInfo2.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        m.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        if ((b.cBE().cBy() || com.baidu.tieba.frs.a.cBx().cBy()) && isInFrsAllThread()) {
            this.mVQ.setVisibility(0);
            ap.setBackgroundColor(this.mVQ, R.color.CAM_X0201);
            return;
        }
        this.mVQ.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.mZk != null) {
            this.mZk.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.mZi.setVisibility(8);
            return;
        }
        this.mZk = this.mZl.obtainHolder(adPost, this.mZi, this.mZk, this.leE);
        if (this.mZk != null) {
            this.mZi.setVisibility(0);
            this.mZk.setVisibility(0);
            this.mZk.update(adPost);
            this.mZk.setAfterClickSchemeListener(this.leD);
            this.mZk.setPageContext(this.eWx);
            return;
        }
        this.mZi.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
