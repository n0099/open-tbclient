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
import com.baidu.searchbox.ng.ai.apps.scheme.AiAppUnitedSchemeUtilsDispatcher;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.ad.a;
import com.baidu.tieba.card.o;
import com.baidu.tieba.e;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdOperateBarCreator;
import com.baidu.tieba.recapp.view.AdOperateBarHolder;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import com.baidu.webkit.internal.ETAG;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes3.dex */
public abstract class AdPostBaseView extends PostAdBaseView<AdPost> {
    private View cVS;
    protected View.OnClickListener cVU;
    protected View cYz;
    private ThreadUserInfoLayout cbw;
    private ViewStub gQU;
    private View gQV;
    protected View gQW;
    private AdCloseView gRl;
    private AdThreadCommentAndPraiseInfoLayout gRt;
    private TextView gSS;
    private RelativeLayout gUq;
    private AdPost gUr;
    protected AdOperateBarHolder gUs;
    protected final AdOperateBarCreator gUt;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void bQ(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cVU = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.gUr != null) {
                    if ((AdPostBaseView.this.cbw.getUserName() == view || AdPostBaseView.this.cbw.getHeaderImg() == view) && AdPostBaseView.this.gUr.feedData.portraitClick != null) {
                        AdPostBaseView.this.l(3, AiAppUnitedSchemeUtilsDispatcher.PARAM_TOAST_ICON_KEY, AdPostBaseView.this.gUr.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.l(3, "hotarea", AdPostBaseView.this.gUr.feedData.scheme);
                }
            }
        };
        this.gUt = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        al.i(this.rootView, e.f.addresslist_item_bg);
        this.gRt.onChangeSkinType();
        this.cbw.onChangeSkinType();
        if (this.gRl != null) {
            this.gRl.onChangeSkinType();
        }
        if (this.gUs != null) {
            this.gUs.onChangeSkinType();
        }
        al.j(this.cVS, e.d.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View aZy() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.cVU);
        this.gQW = this.rootView.findViewById(e.g.thread_multi_del_ad_mask_view);
        this.gQW.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(e.g.card_home_page_normal_thread_title);
        this.cVS = this.rootView.findViewById(e.g.divider_line);
        this.cYz = this.rootView.findViewById(e.g.divider_line_above_praise);
        this.gRt = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.gRt.setStyle(2);
        this.cbw = (ThreadUserInfoLayout) this.rootView.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(e.h.ad_post_tag_close, (ViewGroup) null);
        this.gSS = (TextView) inflate.findViewById(e.g.feed_tag);
        this.gRl = (AdCloseView) inflate.findViewById(e.g.ad_close_view);
        this.gRl.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.gRl != null && AdPostBaseView.this.gRl.getVisibility() == 0) {
                    AdPostBaseView.this.gRl.performClick();
                }
            }
        });
        this.cbw.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(e.C0210e.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.gRt.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gRt.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.gRt.setLayoutParams(layoutParams2);
        }
        this.gRt.setBarNameClickEnabled(false);
        this.gRt.setReplyTimeVisible(false);
        this.gRt.setShowPraiseNum(true);
        this.gRt.setNeedAddPraiseIcon(true);
        this.gRt.setNeedAddReplyIcon(true);
        this.gRt.setShareVisible(true);
        this.gUq = (RelativeLayout) this.rootView.findViewById(e.g.ad_operate_area);
        this.gUq.setOnClickListener(this.cVU);
        this.gQU = (ViewStub) this.rootView.findViewById(e.g.ad_custom_view_stub);
        this.gQU.setLayoutResource(getCustomLayout());
        this.gQV = this.gQU.inflate();
        bQ(this.gQV);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.gUr.preloadLegoCardStr)) {
            str2 = uX(str2);
        }
        a.WE().d(this.mContext.getPageActivity(), new String[]{str2});
        if (this.frv != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.frv.b(i, hashMap);
        }
    }

    private String uX(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + ETAG.EQUAL + URLEncoder.encode(this.gUr.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.gUr = adPost;
        this.cbw.setData(adPost.getAdvertAppInfo());
        this.gRt.setShareData(adPost);
        this.gRt.setCommentClickable(true);
        this.gRt.getCommentContainer().setOnClickListener(this.cVU);
        this.gRt.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.gSS.setVisibility(8);
        } else {
            this.gSS.setVisibility(0);
            this.gSS.setText(adPost.feedData.tag_name);
            this.gSS.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.gSS.setTextSize(0, l.h(this.mContext.getPageActivity(), e.C0210e.fontsize24));
                al.c(this.gSS, e.d.cp_cont_d, 1);
            } else {
                this.gSS.setTextSize(0, l.h(this.mContext.getPageActivity(), e.C0210e.fontsize28));
                al.c(this.gSS, e.d.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.aqd != null && advertAppInfo.aqd.adCloseInfo != null && advertAppInfo.aqd.adCloseInfo.support_close.intValue() > 0) {
            this.gRl.setVisibility(0);
            this.gRl.setData(advertAppInfo);
        } else {
            this.gRl.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.cbw.getHeaderImg() != null) {
            if (advertAppInfo2.zT() == null || advertAppInfo2.zT().getPendantData() == null || StringUtils.isNull(advertAppInfo2.zT().getPendantData().yF())) {
                this.cbw.getHeaderImg().setVisibility(0);
                this.cbw.getHeaderImg().setData(advertAppInfo2);
                this.cbw.getHeaderImg().setOnClickListener(this.cVU);
            } else {
                this.cbw.getHeaderImg().setVisibility(4);
            }
        }
        if (this.cbw.getUserName() != null) {
            this.cbw.getUserName().setOnClickListener(this.cVU);
        }
        o.a(this.mTitle, advertAppInfo2.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        o.b(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.cYz);
        al.j(this.cYz, e.d.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.aBg().aBh()) {
            this.gQW.setVisibility(0);
            al.j(this.gQW, e.d.cp_bg_line_d);
            return;
        }
        this.gQW.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.fqv == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.xR().xV() || adPost.feedData.bwl().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.gUs != null) {
            this.gUs.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.gUq.setVisibility(8);
            return;
        }
        this.gUs = this.gUt.obtainHolder(adPost, this.gUq, this.gUs, this.frw);
        if (this.gUs != null) {
            this.gUq.setVisibility(0);
            this.gUs.setVisibility(0);
            this.gUs.update(adPost);
            this.gUs.setAfterClickSchemeListener(this.frv);
            this.gUs.setPageContext(this.mContext);
            return;
        }
        this.gUq.setVisibility(8);
    }

    public int getLayout() {
        return e.h.post_ad_card_base;
    }
}
