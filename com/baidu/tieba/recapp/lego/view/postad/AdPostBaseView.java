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
import com.baidu.tieba.card.n;
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
/* loaded from: classes25.dex */
public abstract class AdPostBaseView extends PostAdBaseView<AdPost> {
    private ThreadUserInfoLayout gSx;
    private View hYH;
    protected View.OnClickListener hYL;
    private TextView mTitle;
    private AdThreadCommentAndPraiseInfoLayout mvF;
    private ViewStub mvc;
    private View mvd;
    protected View mve;
    private AdCloseView mvx;
    private TextView mwO;
    private RelativeLayout myt;
    private AdPost myu;
    protected AdOperateBarHolder myv;
    protected final AdOperateBarCreator myw;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void dH(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hYL = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.myu != null) {
                    if ((AdPostBaseView.this.gSx.getUserName() == view || AdPostBaseView.this.gSx.getHeaderImg() == view) && AdPostBaseView.this.myu.feedData.portraitClick != null) {
                        AdPostBaseView.this.p(3, AlaStaticKeys.ALA_STATIC_VALUE_ICON, AdPostBaseView.this.myu.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.p(3, "hotarea", AdPostBaseView.this.myu.feedData.scheme);
                }
            }
        };
        this.myw = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        ap.setBackgroundResource(this.rootView, R.drawable.addresslist_item_bg);
        this.mvF.onChangeSkinType();
        this.gSx.onChangeSkinType();
        if (this.mvx != null) {
            this.mvx.onChangeSkinType();
        }
        if (this.myv != null) {
            this.myv.onChangeSkinType();
        }
        ap.setBackgroundColor(this.hYH, R.color.CAM_X0205);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View cYK() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.hYL);
        this.mve = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.mve.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.hYH = this.rootView.findViewById(R.id.divider_line);
        this.mvF = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.mvF.setStyle(2);
        this.gSx = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mwO = (TextView) inflate.findViewById(R.id.feed_tag);
        this.mvx = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.mvx.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.mvx != null && AdPostBaseView.this.mvx.getVisibility() == 0) {
                    AdPostBaseView.this.mvx.performClick();
                }
            }
        });
        this.gSx.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.eGu.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.mvF.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mvF.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.mvF.setLayoutParams(layoutParams2);
        }
        this.mvF.setBarNameClickEnabled(false);
        this.mvF.setReplyTimeVisible(false);
        this.mvF.setShowPraiseNum(true);
        this.mvF.setNeedAddPraiseIcon(true);
        this.mvF.setNeedAddReplyIcon(true);
        this.mvF.setShareVisible(true);
        this.myt = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.myt.setOnClickListener(this.hYL);
        this.mvc = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.mvc.setLayoutResource(getCustomLayout());
        this.mvd = this.mvc.inflate();
        dH(this.mvd);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.myu.preloadLegoCardStr)) {
            str2 = QT(str2);
        }
        a.bIE().c(this.eGu.getPageActivity(), new String[]{str2});
        if (this.kFP != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.kFP.d(i, hashMap);
        }
    }

    private String QT(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + ETAG.EQUAL + URLEncoder.encode(this.myu.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.myu = adPost;
        this.gSx.setData(adPost.getAdvertAppInfo());
        this.mvF.setShareData(adPost);
        this.mvF.setCommentClickable(true);
        this.mvF.getCommentContainer().setOnClickListener(this.hYL);
        this.mvF.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.mwO.setVisibility(8);
        } else {
            this.mwO.setVisibility(0);
            this.mwO.setText(adPost.feedData.tag_name);
            this.mwO.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.mwO.setTextSize(0, l.getDimens(this.eGu.getPageActivity(), R.dimen.fontsize24));
                ap.setViewTextColor(this.mwO, R.color.CAM_X0109, 1);
            } else {
                this.mwO.setTextSize(0, l.getDimens(this.eGu.getPageActivity(), R.dimen.fontsize28));
                ap.setViewTextColor(this.mwO, R.color.CAM_X0106, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.exl != null && advertAppInfo.exl.adCloseInfo != null && advertAppInfo.exl.adCloseInfo.support_close.intValue() > 0) {
            this.mvx.setVisibility(0);
            this.mvx.setData(advertAppInfo);
        } else {
            this.mvx.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.gSx.getHeaderImg() != null) {
            if (advertAppInfo2.blC() == null || advertAppInfo2.blC().getPendantData() == null || StringUtils.isNull(advertAppInfo2.blC().getPendantData().bjy())) {
                this.gSx.getHeaderImg().setVisibility(0);
                this.gSx.getHeaderImg().setData(advertAppInfo2);
                this.gSx.getHeaderImg().setOnClickListener(this.hYL);
            } else {
                this.gSx.getHeaderImg().setVisibility(4);
            }
        }
        if (this.gSx.getUserName() != null) {
            this.gSx.getUserName().setOnClickListener(this.hYL);
        }
        n.a(this.mTitle, advertAppInfo2.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        n.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        if ((b.cwO().cwI() || com.baidu.tieba.frs.a.cwH().cwI()) && isInFrsAllThread()) {
            this.mve.setVisibility(0);
            ap.setBackgroundColor(this.mve, R.color.CAM_X0201);
            return;
        }
        this.mve.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.myv != null) {
            this.myv.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.myt.setVisibility(8);
            return;
        }
        this.myv = this.myw.obtainHolder(adPost, this.myt, this.myv, this.kFQ);
        if (this.myv != null) {
            this.myt.setVisibility(0);
            this.myv.setVisibility(0);
            this.myv.update(adPost);
            this.myv.setAfterClickSchemeListener(this.kFP);
            this.myv.setPageContext(this.eGu);
            return;
        }
        this.myt.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
