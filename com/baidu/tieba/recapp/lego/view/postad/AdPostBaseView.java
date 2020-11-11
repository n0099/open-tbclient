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
/* loaded from: classes26.dex */
public abstract class AdPostBaseView extends PostAdBaseView<AdPost> {
    private ThreadUserInfoLayout gSQ;
    protected View hYe;
    private View hYh;
    protected View.OnClickListener hYl;
    private TextView mTitle;
    private ViewStub muL;
    private View muM;
    protected View muN;
    private AdCloseView mve;
    private AdThreadCommentAndPraiseInfoLayout mvl;
    private TextView mwA;
    private RelativeLayout mxP;
    private AdPost mxQ;
    protected AdOperateBarHolder mxR;
    protected final AdOperateBarCreator mxS;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void dD(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hYl = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.mxQ != null) {
                    if ((AdPostBaseView.this.gSQ.getUserName() == view || AdPostBaseView.this.gSQ.getHeaderImg() == view) && AdPostBaseView.this.mxQ.feedData.portraitClick != null) {
                        AdPostBaseView.this.p(3, AlaStaticKeys.ALA_STATIC_VALUE_ICON, AdPostBaseView.this.mxQ.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.p(3, "hotarea", AdPostBaseView.this.mxQ.feedData.scheme);
                }
            }
        };
        this.mxS = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        ap.setBackgroundResource(this.rootView, R.drawable.addresslist_item_bg);
        this.mvl.onChangeSkinType();
        this.gSQ.onChangeSkinType();
        if (this.mve != null) {
            this.mve.onChangeSkinType();
        }
        if (this.mxR != null) {
            this.mxR.onChangeSkinType();
        }
        ap.setBackgroundColor(this.hYh, R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View cZo() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.hYl);
        this.muN = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.muN.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.hYh = this.rootView.findViewById(R.id.divider_line);
        this.hYe = this.rootView.findViewById(R.id.divider_line_above_praise);
        this.mvl = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.mvl.setStyle(2);
        this.gSQ = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mwA = (TextView) inflate.findViewById(R.id.feed_tag);
        this.mve = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.mve.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.mve != null && AdPostBaseView.this.mve.getVisibility() == 0) {
                    AdPostBaseView.this.mve.performClick();
                }
            }
        });
        this.gSQ.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.eIc.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.mvl.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mvl.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.mvl.setLayoutParams(layoutParams2);
        }
        this.mvl.setBarNameClickEnabled(false);
        this.mvl.setReplyTimeVisible(false);
        this.mvl.setShowPraiseNum(true);
        this.mvl.setNeedAddPraiseIcon(true);
        this.mvl.setNeedAddReplyIcon(true);
        this.mvl.setShareVisible(true);
        this.mxP = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.mxP.setOnClickListener(this.hYl);
        this.muL = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.muL.setLayoutResource(getCustomLayout());
        this.muM = this.muL.inflate();
        dD(this.muM);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.mxQ.preloadLegoCardStr)) {
            str2 = Ry(str2);
        }
        a.bJk().c(this.eIc.getPageActivity(), new String[]{str2});
        if (this.kFA != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.kFA.d(i, hashMap);
        }
    }

    private String Ry(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + ETAG.EQUAL + URLEncoder.encode(this.mxQ.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.mxQ = adPost;
        this.gSQ.setData(adPost.getAdvertAppInfo());
        this.mvl.setShareData(adPost);
        this.mvl.setCommentClickable(true);
        this.mvl.getCommentContainer().setOnClickListener(this.hYl);
        this.mvl.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.mwA.setVisibility(8);
        } else {
            this.mwA.setVisibility(0);
            this.mwA.setText(adPost.feedData.tag_name);
            this.mwA.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.mwA.setTextSize(0, l.getDimens(this.eIc.getPageActivity(), R.dimen.fontsize24));
                ap.setViewTextColor(this.mwA, R.color.cp_cont_d, 1);
            } else {
                this.mwA.setTextSize(0, l.getDimens(this.eIc.getPageActivity(), R.dimen.fontsize28));
                ap.setViewTextColor(this.mwA, R.color.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.eyX != null && advertAppInfo.eyX.adCloseInfo != null && advertAppInfo.eyX.adCloseInfo.support_close.intValue() > 0) {
            this.mve.setVisibility(0);
            this.mve.setData(advertAppInfo);
        } else {
            this.mve.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.gSQ.getHeaderImg() != null) {
            if (advertAppInfo2.bmA() == null || advertAppInfo2.bmA().getPendantData() == null || StringUtils.isNull(advertAppInfo2.bmA().getPendantData().bkw())) {
                this.gSQ.getHeaderImg().setVisibility(0);
                this.gSQ.getHeaderImg().setData(advertAppInfo2);
                this.gSQ.getHeaderImg().setOnClickListener(this.hYl);
            } else {
                this.gSQ.getHeaderImg().setVisibility(4);
            }
        }
        if (this.gSQ.getUserName() != null) {
            this.gSQ.getUserName().setOnClickListener(this.hYl);
        }
        n.a(this.mTitle, advertAppInfo2.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
        n.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.hYe);
        ap.setBackgroundColor(this.hYe, R.color.cp_bg_line_e);
        if ((b.cxm().cxg() || com.baidu.tieba.frs.a.cxf().cxg()) && isInFrsAllThread()) {
            this.muN.setVisibility(0);
            ap.setBackgroundColor(this.muN, R.color.cp_bg_line_d);
            return;
        }
        this.muN.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!k.bjH().isShowImages() || adPost.feedData.dAF().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.mxR != null) {
            this.mxR.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.mxP.setVisibility(8);
            return;
        }
        this.mxR = this.mxS.obtainHolder(adPost, this.mxP, this.mxR, this.kFB);
        if (this.mxR != null) {
            this.mxP.setVisibility(0);
            this.mxR.setVisibility(0);
            this.mxR.update(adPost);
            this.mxR.setAfterClickSchemeListener(this.kFA);
            this.mxR.setPageContext(this.eIc);
            return;
        }
        this.mxP.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
