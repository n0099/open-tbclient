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
    private View cVh;
    protected View.OnClickListener cVj;
    protected View cXO;
    private ThreadUserInfoLayout caL;
    private ViewStub gPR;
    private View gPS;
    protected View gPT;
    private AdCloseView gQi;
    private AdThreadCommentAndPraiseInfoLayout gQq;
    private TextView gRP;
    private RelativeLayout gTl;
    private AdPost gTm;
    protected AdOperateBarHolder gTn;
    protected final AdOperateBarCreator gTo;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void bQ(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cVj = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.gTm != null) {
                    if ((AdPostBaseView.this.caL.getUserName() == view || AdPostBaseView.this.caL.getHeaderImg() == view) && AdPostBaseView.this.gTm.feedData.portraitClick != null) {
                        AdPostBaseView.this.l(3, AiAppUnitedSchemeUtilsDispatcher.PARAM_TOAST_ICON_KEY, AdPostBaseView.this.gTm.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.l(3, "hotarea", AdPostBaseView.this.gTm.feedData.scheme);
                }
            }
        };
        this.gTo = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        al.i(this.rootView, e.f.addresslist_item_bg);
        this.gQq.onChangeSkinType();
        this.caL.onChangeSkinType();
        if (this.gQi != null) {
            this.gQi.onChangeSkinType();
        }
        if (this.gTn != null) {
            this.gTn.onChangeSkinType();
        }
        al.j(this.cVh, e.d.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View aYY() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.cVj);
        this.gPT = this.rootView.findViewById(e.g.thread_multi_del_ad_mask_view);
        this.gPT.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(e.g.card_home_page_normal_thread_title);
        this.cVh = this.rootView.findViewById(e.g.divider_line);
        this.cXO = this.rootView.findViewById(e.g.divider_line_above_praise);
        this.gQq = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.gQq.setStyle(2);
        this.caL = (ThreadUserInfoLayout) this.rootView.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(e.h.ad_post_tag_close, (ViewGroup) null);
        this.gRP = (TextView) inflate.findViewById(e.g.feed_tag);
        this.gQi = (AdCloseView) inflate.findViewById(e.g.ad_close_view);
        this.gQi.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.gQi != null && AdPostBaseView.this.gQi.getVisibility() == 0) {
                    AdPostBaseView.this.gQi.performClick();
                }
            }
        });
        this.caL.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(e.C0210e.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.gQq.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gQq.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.gQq.setLayoutParams(layoutParams2);
        }
        this.gQq.setBarNameClickEnabled(false);
        this.gQq.setReplyTimeVisible(false);
        this.gQq.setShowPraiseNum(true);
        this.gQq.setNeedAddPraiseIcon(true);
        this.gQq.setNeedAddReplyIcon(true);
        this.gQq.setShareVisible(true);
        this.gTl = (RelativeLayout) this.rootView.findViewById(e.g.ad_operate_area);
        this.gTl.setOnClickListener(this.cVj);
        this.gPR = (ViewStub) this.rootView.findViewById(e.g.ad_custom_view_stub);
        this.gPR.setLayoutResource(getCustomLayout());
        this.gPS = this.gPR.inflate();
        bQ(this.gPS);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.gTm.preloadLegoCardStr)) {
            str2 = uH(str2);
        }
        a.Wi().d(this.mContext.getPageActivity(), new String[]{str2});
        if (this.fqA != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.fqA.b(i, hashMap);
        }
    }

    private String uH(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + ETAG.EQUAL + URLEncoder.encode(this.gTm.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.gTm = adPost;
        this.caL.setData(adPost.getAdvertAppInfo());
        this.gQq.setShareData(adPost);
        this.gQq.setCommentClickable(true);
        this.gQq.getCommentContainer().setOnClickListener(this.cVj);
        this.gQq.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.gRP.setVisibility(8);
        } else {
            this.gRP.setVisibility(0);
            this.gRP.setText(adPost.feedData.tag_name);
            this.gRP.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.gRP.setTextSize(0, l.h(this.mContext.getPageActivity(), e.C0210e.fontsize24));
                al.c(this.gRP, e.d.cp_cont_d, 1);
            } else {
                this.gRP.setTextSize(0, l.h(this.mContext.getPageActivity(), e.C0210e.fontsize28));
                al.c(this.gRP, e.d.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.apB != null && advertAppInfo.apB.adCloseInfo != null && advertAppInfo.apB.adCloseInfo.support_close.intValue() > 0) {
            this.gQi.setVisibility(0);
            this.gQi.setData(advertAppInfo);
        } else {
            this.gQi.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.caL.getHeaderImg() != null) {
            if (advertAppInfo2.zG() == null || advertAppInfo2.zG().getPendantData() == null || StringUtils.isNull(advertAppInfo2.zG().getPendantData().ys())) {
                this.caL.getHeaderImg().setVisibility(0);
                this.caL.getHeaderImg().setData(advertAppInfo2);
                this.caL.getHeaderImg().setOnClickListener(this.cVj);
            } else {
                this.caL.getHeaderImg().setVisibility(4);
            }
        }
        if (this.caL.getUserName() != null) {
            this.caL.getUserName().setOnClickListener(this.cVj);
        }
        o.a(this.mTitle, advertAppInfo2.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        o.b(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.cXO);
        al.j(this.cXO, e.d.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.aAJ().aAK()) {
            this.gPT.setVisibility(0);
            al.j(this.gPT, e.d.cp_bg_line_d);
            return;
        }
        this.gPT.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.fpB == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.xE().xI() || adPost.feedData.bvC().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.gTn != null) {
            this.gTn.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.gTl.setVisibility(8);
            return;
        }
        this.gTn = this.gTo.obtainHolder(adPost, this.gTl, this.gTn, this.fqB);
        if (this.gTn != null) {
            this.gTl.setVisibility(0);
            this.gTn.setVisibility(0);
            this.gTn.update(adPost);
            this.gTn.setAfterClickSchemeListener(this.fqA);
            this.gTn.setPageContext(this.mContext);
            return;
        }
        this.gTl.setVisibility(8);
    }

    public int getLayout() {
        return e.h.post_ad_card_base;
    }
}
