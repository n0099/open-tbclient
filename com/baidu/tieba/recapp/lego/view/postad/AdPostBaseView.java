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
/* loaded from: classes8.dex */
public abstract class AdPostBaseView extends PostAdBaseView<AdPost> {
    private ThreadUserInfoLayout hny;
    private View iwb;
    protected View.OnClickListener iwf;
    private AdCloseView mOS;
    private ViewStub mOx;
    private View mOy;
    protected View mOz;
    private AdThreadCommentAndPraiseInfoLayout mPa;
    private TextView mQl;
    private RelativeLayout mRQ;
    private AdPost mRR;
    protected AdOperateBarHolder mRS;
    protected final AdOperateBarCreator mRT;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void ec(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.iwf = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.mRR != null) {
                    if ((AdPostBaseView.this.hny.getUserName() == view || AdPostBaseView.this.hny.getHeaderImg() == view) && AdPostBaseView.this.mRR.feedData.portraitClick != null) {
                        AdPostBaseView.this.p(3, AlaStaticKeys.ALA_STATIC_VALUE_ICON, AdPostBaseView.this.mRR.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.p(3, "hotarea", AdPostBaseView.this.mRR.feedData.scheme);
                }
            }
        };
        this.mRT = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        ao.setBackgroundResource(this.rootView, R.drawable.addresslist_item_bg);
        this.mPa.onChangeSkinType();
        this.hny.onChangeSkinType();
        if (this.mOS != null) {
            this.mOS.onChangeSkinType();
        }
        if (this.mRS != null) {
            this.mRS.onChangeSkinType();
        }
        ao.setBackgroundColor(this.iwb, R.color.CAM_X0205);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View ddH() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.iwf);
        this.mOz = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.mOz.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.iwb = this.rootView.findViewById(R.id.divider_line);
        this.mPa = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.mPa.setStyle(2);
        this.hny = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mQl = (TextView) inflate.findViewById(R.id.feed_tag);
        this.mOS = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.mOS.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.mOS != null && AdPostBaseView.this.mOS.getVisibility() == 0) {
                    AdPostBaseView.this.mOS.performClick();
                }
            }
        });
        this.hny.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.eXu.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.mPa.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mPa.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.mPa.setLayoutParams(layoutParams2);
        }
        this.mPa.setBarNameClickEnabled(false);
        this.mPa.setReplyTimeVisible(false);
        this.mPa.setShowPraiseNum(true);
        this.mPa.setNeedAddPraiseIcon(true);
        this.mPa.setNeedAddReplyIcon(true);
        this.mPa.setShareVisible(true);
        this.mRQ = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.mRQ.setOnClickListener(this.iwf);
        this.mOx = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.mOx.setLayoutResource(getCustomLayout());
        this.mOy = this.mOx.inflate();
        ec(this.mOy);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.mRR.preloadLegoCardStr)) {
            str2 = RP(str2);
        }
        a.bOF().a(this.eXu.getPageActivity(), new String[]{str2}, null);
        if (this.kYN != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.kYN.d(i, hashMap);
        }
    }

    private String RP(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.mRR.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.mRR = adPost;
        this.hny.setData(adPost.getAdvertAppInfo());
        this.mPa.setShareData(adPost);
        this.mPa.setCommentClickable(true);
        this.mPa.getCommentContainer().setOnClickListener(this.iwf);
        this.mPa.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.mQl.setVisibility(8);
        } else {
            this.mQl.setVisibility(0);
            this.mQl.setText(adPost.feedData.tag_name);
            this.mQl.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.mQl.setTextSize(0, l.getDimens(this.eXu.getPageActivity(), R.dimen.fontsize24));
                ao.setViewTextColor(this.mQl, R.color.CAM_X0109, 1);
            } else {
                this.mQl.setTextSize(0, l.getDimens(this.eXu.getPageActivity(), R.dimen.fontsize28));
                ao.setViewTextColor(this.mQl, R.color.CAM_X0106, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.eOc != null && advertAppInfo.eOc.adCloseInfo != null && advertAppInfo.eOc.adCloseInfo.support_close.intValue() > 0) {
            this.mOS.setVisibility(0);
            this.mOS.setData(advertAppInfo);
        } else {
            this.mOS.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.hny.getHeaderImg() != null) {
            if (advertAppInfo2.brq() == null || advertAppInfo2.brq().getPendantData() == null || StringUtils.isNull(advertAppInfo2.brq().getPendantData().getImgUrl())) {
                this.hny.getHeaderImg().setVisibility(0);
                this.hny.getHeaderImg().setData(advertAppInfo2);
                this.hny.getHeaderImg().setOnClickListener(this.iwf);
            } else {
                this.hny.getHeaderImg().setVisibility(4);
            }
        }
        if (this.hny.getUserName() != null) {
            this.hny.getUserName().setOnClickListener(this.iwf);
        }
        m.a(this.mTitle, advertAppInfo2.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        m.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        if ((b.cDX().cDR() || com.baidu.tieba.frs.a.cDQ().cDR()) && isInFrsAllThread()) {
            this.mOz.setVisibility(0);
            ao.setBackgroundColor(this.mOz, R.color.CAM_X0201);
            return;
        }
        this.mOz.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.mRS != null) {
            this.mRS.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.mRQ.setVisibility(8);
            return;
        }
        this.mRS = this.mRT.obtainHolder(adPost, this.mRQ, this.mRS, this.kYO);
        if (this.mRS != null) {
            this.mRQ.setVisibility(0);
            this.mRS.setVisibility(0);
            this.mRS.update(adPost);
            this.mRS.setAfterClickSchemeListener(this.kYN);
            this.mRS.setPageContext(this.eXu);
            return;
        }
        this.mRQ.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
