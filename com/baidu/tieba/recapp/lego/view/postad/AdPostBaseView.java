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
    private ThreadUserInfoLayout hnt;
    private View ixm;
    protected View.OnClickListener ixq;
    private ViewStub mTD;
    private View mTE;
    protected View mTF;
    private AdCloseView mTY;
    private TextView mTitle;
    private AdThreadCommentAndPraiseInfoLayout mUh;
    private TextView mVt;
    private RelativeLayout mWY;
    private AdPost mWZ;
    protected AdOperateBarHolder mXa;
    protected final AdOperateBarCreator mXb;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void ea(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ixq = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.mWZ != null) {
                    if ((AdPostBaseView.this.hnt.getUserName() == view || AdPostBaseView.this.hnt.getHeaderImg() == view) && AdPostBaseView.this.mWZ.feedData.portraitClick != null) {
                        AdPostBaseView.this.p(1, AlaStaticKeys.ALA_STATIC_VALUE_ICON, AdPostBaseView.this.mWZ.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.p(1, "hotarea", AdPostBaseView.this.mWZ.feedData.scheme);
                }
            }
        };
        this.mXb = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        ap.setBackgroundResource(this.rootView, R.drawable.addresslist_item_bg);
        this.mUh.onChangeSkinType();
        this.hnt.onChangeSkinType();
        if (this.mTY != null) {
            this.mTY.onChangeSkinType();
        }
        if (this.mXa != null) {
            this.mXa.onChangeSkinType();
        }
        ap.setBackgroundColor(this.ixm, R.color.CAM_X0205);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View dbV() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.ixq);
        this.mTF = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.mTF.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.ixm = this.rootView.findViewById(R.id.divider_line);
        this.mUh = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.mUh.setStyle(2);
        this.hnt = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mVt = (TextView) inflate.findViewById(R.id.feed_tag);
        this.mTY = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.mTY.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.mTY != null && AdPostBaseView.this.mTY.getVisibility() == 0) {
                    AdPostBaseView.this.mTY.performClick();
                }
            }
        });
        this.hnt.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.eUY.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.mUh.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mUh.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.mUh.setLayoutParams(layoutParams2);
        }
        this.mUh.setBarNameClickEnabled(false);
        this.mUh.setReplyTimeVisible(false);
        this.mUh.setShowPraiseNum(true);
        this.mUh.setNeedAddPraiseIcon(true);
        this.mUh.setNeedAddReplyIcon(true);
        this.mUh.setShareVisible(true);
        this.mWY = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.mWY.setOnClickListener(this.ixq);
        this.mTD = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.mTD.setLayoutResource(getCustomLayout());
        this.mTE = this.mTD.inflate();
        ea(this.mTE);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.mWZ.preloadLegoCardStr)) {
            str2 = RM(str2);
        }
        a.bLn().a(this.eUY.getPageActivity(), new String[]{str2}, null);
        if (this.lcA != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.lcA.d(i, hashMap);
        }
    }

    private String RM(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.mWZ.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.mWZ = adPost;
        this.hnt.setData(adPost.getAdvertAppInfo());
        this.mUh.setShareData(adPost);
        this.mUh.setCommentClickable(true);
        this.mUh.getCommentContainer().setOnClickListener(this.ixq);
        this.mUh.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.mVt.setVisibility(8);
        } else {
            this.mVt.setVisibility(0);
            this.mVt.setText(adPost.feedData.tag_name);
            this.mVt.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.mVt.setTextSize(0, l.getDimens(this.eUY.getPageActivity(), R.dimen.fontsize24));
                ap.setViewTextColor(this.mVt, R.color.CAM_X0109, 1);
            } else {
                this.mVt.setTextSize(0, l.getDimens(this.eUY.getPageActivity(), R.dimen.fontsize28));
                ap.setViewTextColor(this.mVt, R.color.CAM_X0106, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.eLC != null && advertAppInfo.eLC.adCloseInfo != null && advertAppInfo.eLC.adCloseInfo.support_close.intValue() > 0) {
            this.mTY.setVisibility(0);
            this.mTY.setData(advertAppInfo);
        } else {
            this.mTY.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.hnt.getHeaderImg() != null) {
            if (advertAppInfo2.bnQ() == null || advertAppInfo2.bnQ().getPendantData() == null || StringUtils.isNull(advertAppInfo2.bnQ().getPendantData().getImgUrl())) {
                this.hnt.getHeaderImg().setVisibility(0);
                this.hnt.getHeaderImg().setData(advertAppInfo2);
                this.hnt.getHeaderImg().setOnClickListener(this.ixq);
            } else {
                this.hnt.getHeaderImg().setVisibility(4);
            }
        }
        if (this.hnt.getUserName() != null) {
            this.hnt.getUserName().setOnClickListener(this.ixq);
        }
        m.a(this.mTitle, advertAppInfo2.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        m.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        if ((b.cBy().cBs() || com.baidu.tieba.frs.a.cBr().cBs()) && isInFrsAllThread()) {
            this.mTF.setVisibility(0);
            ap.setBackgroundColor(this.mTF, R.color.CAM_X0201);
            return;
        }
        this.mTF.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.mXa != null) {
            this.mXa.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.mWY.setVisibility(8);
            return;
        }
        this.mXa = this.mXb.obtainHolder(adPost, this.mWY, this.mXa, this.lcB);
        if (this.mXa != null) {
            this.mWY.setVisibility(0);
            this.mXa.setVisibility(0);
            this.mXa.update(adPost);
            this.mXa.setAfterClickSchemeListener(this.lcA);
            this.mXa.setPageContext(this.eUY);
            return;
        }
        this.mWY.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
