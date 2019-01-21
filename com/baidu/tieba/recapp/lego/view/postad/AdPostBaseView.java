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
    private View cVT;
    protected View.OnClickListener cVV;
    protected View cYA;
    private ThreadUserInfoLayout cbx;
    private ViewStub gQV;
    private View gQW;
    protected View gQX;
    private AdCloseView gRm;
    private AdThreadCommentAndPraiseInfoLayout gRu;
    private TextView gST;
    private RelativeLayout gUr;
    private AdPost gUs;
    protected AdOperateBarHolder gUt;
    protected final AdOperateBarCreator gUu;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void bQ(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cVV = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.gUs != null) {
                    if ((AdPostBaseView.this.cbx.getUserName() == view || AdPostBaseView.this.cbx.getHeaderImg() == view) && AdPostBaseView.this.gUs.feedData.portraitClick != null) {
                        AdPostBaseView.this.l(3, AiAppUnitedSchemeUtilsDispatcher.PARAM_TOAST_ICON_KEY, AdPostBaseView.this.gUs.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.l(3, "hotarea", AdPostBaseView.this.gUs.feedData.scheme);
                }
            }
        };
        this.gUu = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        al.i(this.rootView, e.f.addresslist_item_bg);
        this.gRu.onChangeSkinType();
        this.cbx.onChangeSkinType();
        if (this.gRm != null) {
            this.gRm.onChangeSkinType();
        }
        if (this.gUt != null) {
            this.gUt.onChangeSkinType();
        }
        al.j(this.cVT, e.d.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View aZy() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.cVV);
        this.gQX = this.rootView.findViewById(e.g.thread_multi_del_ad_mask_view);
        this.gQX.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(e.g.card_home_page_normal_thread_title);
        this.cVT = this.rootView.findViewById(e.g.divider_line);
        this.cYA = this.rootView.findViewById(e.g.divider_line_above_praise);
        this.gRu = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.gRu.setStyle(2);
        this.cbx = (ThreadUserInfoLayout) this.rootView.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(e.h.ad_post_tag_close, (ViewGroup) null);
        this.gST = (TextView) inflate.findViewById(e.g.feed_tag);
        this.gRm = (AdCloseView) inflate.findViewById(e.g.ad_close_view);
        this.gRm.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.gRm != null && AdPostBaseView.this.gRm.getVisibility() == 0) {
                    AdPostBaseView.this.gRm.performClick();
                }
            }
        });
        this.cbx.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(e.C0210e.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.gRu.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gRu.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.gRu.setLayoutParams(layoutParams2);
        }
        this.gRu.setBarNameClickEnabled(false);
        this.gRu.setReplyTimeVisible(false);
        this.gRu.setShowPraiseNum(true);
        this.gRu.setNeedAddPraiseIcon(true);
        this.gRu.setNeedAddReplyIcon(true);
        this.gRu.setShareVisible(true);
        this.gUr = (RelativeLayout) this.rootView.findViewById(e.g.ad_operate_area);
        this.gUr.setOnClickListener(this.cVV);
        this.gQV = (ViewStub) this.rootView.findViewById(e.g.ad_custom_view_stub);
        this.gQV.setLayoutResource(getCustomLayout());
        this.gQW = this.gQV.inflate();
        bQ(this.gQW);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.gUs.preloadLegoCardStr)) {
            str2 = uX(str2);
        }
        a.WE().d(this.mContext.getPageActivity(), new String[]{str2});
        if (this.frw != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.frw.b(i, hashMap);
        }
    }

    private String uX(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + ETAG.EQUAL + URLEncoder.encode(this.gUs.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.gUs = adPost;
        this.cbx.setData(adPost.getAdvertAppInfo());
        this.gRu.setShareData(adPost);
        this.gRu.setCommentClickable(true);
        this.gRu.getCommentContainer().setOnClickListener(this.cVV);
        this.gRu.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.gST.setVisibility(8);
        } else {
            this.gST.setVisibility(0);
            this.gST.setText(adPost.feedData.tag_name);
            this.gST.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.gST.setTextSize(0, l.h(this.mContext.getPageActivity(), e.C0210e.fontsize24));
                al.c(this.gST, e.d.cp_cont_d, 1);
            } else {
                this.gST.setTextSize(0, l.h(this.mContext.getPageActivity(), e.C0210e.fontsize28));
                al.c(this.gST, e.d.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.aqe != null && advertAppInfo.aqe.adCloseInfo != null && advertAppInfo.aqe.adCloseInfo.support_close.intValue() > 0) {
            this.gRm.setVisibility(0);
            this.gRm.setData(advertAppInfo);
        } else {
            this.gRm.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.cbx.getHeaderImg() != null) {
            if (advertAppInfo2.zT() == null || advertAppInfo2.zT().getPendantData() == null || StringUtils.isNull(advertAppInfo2.zT().getPendantData().yF())) {
                this.cbx.getHeaderImg().setVisibility(0);
                this.cbx.getHeaderImg().setData(advertAppInfo2);
                this.cbx.getHeaderImg().setOnClickListener(this.cVV);
            } else {
                this.cbx.getHeaderImg().setVisibility(4);
            }
        }
        if (this.cbx.getUserName() != null) {
            this.cbx.getUserName().setOnClickListener(this.cVV);
        }
        o.a(this.mTitle, advertAppInfo2.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        o.b(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.cYA);
        al.j(this.cYA, e.d.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.aBg().aBh()) {
            this.gQX.setVisibility(0);
            al.j(this.gQX, e.d.cp_bg_line_d);
            return;
        }
        this.gQX.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.fqw == 1;
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
        if (this.gUt != null) {
            this.gUt.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.gUr.setVisibility(8);
            return;
        }
        this.gUt = this.gUu.obtainHolder(adPost, this.gUr, this.gUt, this.frx);
        if (this.gUt != null) {
            this.gUr.setVisibility(0);
            this.gUt.setVisibility(0);
            this.gUt.update(adPost);
            this.gUt.setAfterClickSchemeListener(this.frw);
            this.gUt.setPageContext(this.mContext);
            return;
        }
        this.gUr.setVisibility(8);
    }

    public int getLayout() {
        return e.h.post_ad_card_base;
    }
}
