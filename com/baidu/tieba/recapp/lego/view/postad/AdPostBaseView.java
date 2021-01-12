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
import com.baidu.tbadk.core.util.ao;
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
    private ThreadUserInfoLayout hiS;
    private View iru;
    protected View.OnClickListener iry;
    private ViewStub mJS;
    private View mJT;
    protected View mJU;
    private AdCloseView mKn;
    private AdThreadCommentAndPraiseInfoLayout mKv;
    private TextView mLE;
    private RelativeLayout mNj;
    private AdPost mNk;
    protected AdOperateBarHolder mNl;
    protected final AdOperateBarCreator mNm;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void ec(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iry = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.mNk != null) {
                    if ((AdPostBaseView.this.hiS.getUserName() == view || AdPostBaseView.this.hiS.getHeaderImg() == view) && AdPostBaseView.this.mNk.feedData.portraitClick != null) {
                        AdPostBaseView.this.p(3, AlaStaticKeys.ALA_STATIC_VALUE_ICON, AdPostBaseView.this.mNk.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.p(3, "hotarea", AdPostBaseView.this.mNk.feedData.scheme);
                }
            }
        };
        this.mNm = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        ao.setBackgroundResource(this.rootView, R.drawable.addresslist_item_bg);
        this.mKv.onChangeSkinType();
        this.hiS.onChangeSkinType();
        if (this.mKn != null) {
            this.mKn.onChangeSkinType();
        }
        if (this.mNl != null) {
            this.mNl.onChangeSkinType();
        }
        ao.setBackgroundColor(this.iru, R.color.CAM_X0205);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View cZQ() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.iry);
        this.mJU = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.mJU.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.iru = this.rootView.findViewById(R.id.divider_line);
        this.mKv = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.mKv.setStyle(2);
        this.hiS = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mLE = (TextView) inflate.findViewById(R.id.feed_tag);
        this.mKn = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.mKn.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.mKn != null && AdPostBaseView.this.mKn.getVisibility() == 0) {
                    AdPostBaseView.this.mKn.performClick();
                }
            }
        });
        this.hiS.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.eSJ.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.mKv.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mKv.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.mKv.setLayoutParams(layoutParams2);
        }
        this.mKv.setBarNameClickEnabled(false);
        this.mKv.setReplyTimeVisible(false);
        this.mKv.setShowPraiseNum(true);
        this.mKv.setNeedAddPraiseIcon(true);
        this.mKv.setNeedAddReplyIcon(true);
        this.mKv.setShareVisible(true);
        this.mNj = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.mNj.setOnClickListener(this.iry);
        this.mJS = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.mJS.setLayoutResource(getCustomLayout());
        this.mJT = this.mJS.inflate();
        ec(this.mJT);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.mNk.preloadLegoCardStr)) {
            str2 = QG(str2);
        }
        a.bKO().a(this.eSJ.getPageActivity(), new String[]{str2}, null);
        if (this.kUi != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.kUi.d(i, hashMap);
        }
    }

    private String QG(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.mNk.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.mNk = adPost;
        this.hiS.setData(adPost.getAdvertAppInfo());
        this.mKv.setShareData(adPost);
        this.mKv.setCommentClickable(true);
        this.mKv.getCommentContainer().setOnClickListener(this.iry);
        this.mKv.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.mLE.setVisibility(8);
        } else {
            this.mLE.setVisibility(0);
            this.mLE.setText(adPost.feedData.tag_name);
            this.mLE.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.mLE.setTextSize(0, l.getDimens(this.eSJ.getPageActivity(), R.dimen.fontsize24));
                ao.setViewTextColor(this.mLE, R.color.CAM_X0109, 1);
            } else {
                this.mLE.setTextSize(0, l.getDimens(this.eSJ.getPageActivity(), R.dimen.fontsize28));
                ao.setViewTextColor(this.mLE, R.color.CAM_X0106, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.eJr != null && advertAppInfo.eJr.adCloseInfo != null && advertAppInfo.eJr.adCloseInfo.support_close.intValue() > 0) {
            this.mKn.setVisibility(0);
            this.mKn.setData(advertAppInfo);
        } else {
            this.mKn.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.hiS.getHeaderImg() != null) {
            if (advertAppInfo2.bnx() == null || advertAppInfo2.bnx().getPendantData() == null || StringUtils.isNull(advertAppInfo2.bnx().getPendantData().getImgUrl())) {
                this.hiS.getHeaderImg().setVisibility(0);
                this.hiS.getHeaderImg().setData(advertAppInfo2);
                this.hiS.getHeaderImg().setOnClickListener(this.iry);
            } else {
                this.hiS.getHeaderImg().setVisibility(4);
            }
        }
        if (this.hiS.getUserName() != null) {
            this.hiS.getUserName().setOnClickListener(this.iry);
        }
        m.a(this.mTitle, advertAppInfo2.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        m.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        if ((b.cAg().cAa() || com.baidu.tieba.frs.a.czZ().cAa()) && isInFrsAllThread()) {
            this.mJU.setVisibility(0);
            ao.setBackgroundColor(this.mJU, R.color.CAM_X0201);
            return;
        }
        this.mJU.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.mNl != null) {
            this.mNl.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.mNj.setVisibility(8);
            return;
        }
        this.mNl = this.mNm.obtainHolder(adPost, this.mNj, this.mNl, this.kUj);
        if (this.mNl != null) {
            this.mNj.setVisibility(0);
            this.mNl.setVisibility(0);
            this.mNl.update(adPost);
            this.mNl.setAfterClickSchemeListener(this.kUi);
            this.mNl.setPageContext(this.eSJ);
            return;
        }
        this.mNj.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
