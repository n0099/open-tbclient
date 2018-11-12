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
    private ThreadUserInfoLayout bWQ;
    private View cLK;
    protected View.OnClickListener cLM;
    protected View cOr;
    private AdCloseView gGA;
    private AdThreadCommentAndPraiseInfoLayout gGI;
    private ViewStub gGj;
    private View gGk;
    protected View gGl;
    private TextView gIh;
    private RelativeLayout gJD;
    private AdPost gJE;
    protected AdOperateBarHolder gJF;
    protected final AdOperateBarCreator gJG;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void bN(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cLM = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.gJE != null) {
                    if ((AdPostBaseView.this.bWQ.getUserName() == view || AdPostBaseView.this.bWQ.getHeaderImg() == view) && AdPostBaseView.this.gJE.feedData.portraitClick != null) {
                        AdPostBaseView.this.k(3, AiAppUnitedSchemeUtilsDispatcher.PARAM_TOAST_ICON_KEY, AdPostBaseView.this.gJE.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.k(3, "hotarea", AdPostBaseView.this.gJE.feedData.scheme);
                }
            }
        };
        this.gJG = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        al.i(this.rootView, e.f.addresslist_item_bg);
        this.gGI.onChangeSkinType();
        this.bWQ.onChangeSkinType();
        if (this.gGA != null) {
            this.gGA.onChangeSkinType();
        }
        if (this.gJF != null) {
            this.gJF.onChangeSkinType();
        }
        al.j(this.cLK, e.d.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View aWt() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.cLM);
        this.gGl = this.rootView.findViewById(e.g.thread_multi_del_ad_mask_view);
        this.gGl.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(e.g.card_home_page_normal_thread_title);
        this.cLK = this.rootView.findViewById(e.g.divider_line);
        this.cOr = this.rootView.findViewById(e.g.divider_line_above_praise);
        this.gGI = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.gGI.setStyle(2);
        this.bWQ = (ThreadUserInfoLayout) this.rootView.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(e.h.ad_post_tag_close, (ViewGroup) null);
        this.gIh = (TextView) inflate.findViewById(e.g.feed_tag);
        this.gGA = (AdCloseView) inflate.findViewById(e.g.ad_close_view);
        this.gGA.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.gGA != null && AdPostBaseView.this.gGA.getVisibility() == 0) {
                    AdPostBaseView.this.gGA.performClick();
                }
            }
        });
        this.bWQ.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(e.C0200e.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.gGI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gGI.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.gGI.setLayoutParams(layoutParams2);
        }
        this.gGI.setBarNameClickEnabled(false);
        this.gGI.setReplyTimeVisible(false);
        this.gGI.setShowPraiseNum(true);
        this.gGI.setNeedAddPraiseIcon(true);
        this.gGI.setNeedAddReplyIcon(true);
        this.gGI.setShareVisible(true);
        this.gJD = (RelativeLayout) this.rootView.findViewById(e.g.ad_operate_area);
        this.gJD.setOnClickListener(this.cLM);
        this.gGj = (ViewStub) this.rootView.findViewById(e.g.ad_custom_view_stub);
        this.gGj.setLayoutResource(getCustomLayout());
        this.gGk = this.gGj.inflate();
        bN(this.gGk);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.gJE.preloadLegoCardStr)) {
            str2 = ud(str2);
        }
        a.Va().d(this.mContext.getPageActivity(), new String[]{str2});
        if (this.fgQ != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.fgQ.b(i, hashMap);
        }
    }

    private String ud(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + ETAG.EQUAL + URLEncoder.encode(this.gJE.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.gJE = adPost;
        this.bWQ.setData(adPost.getAdvertAppInfo());
        this.gGI.setShareData(adPost);
        this.gGI.setCommentClickable(true);
        this.gGI.getCommentContainer().setOnClickListener(this.cLM);
        this.gGI.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.gIh.setVisibility(8);
        } else {
            this.gIh.setVisibility(0);
            this.gIh.setText(adPost.feedData.tag_name);
            this.gIh.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.gIh.setTextSize(0, l.h(this.mContext.getPageActivity(), e.C0200e.fontsize24));
                al.c(this.gIh, e.d.cp_cont_d, 1);
            } else {
                this.gIh.setTextSize(0, l.h(this.mContext.getPageActivity(), e.C0200e.fontsize28));
                al.c(this.gIh, e.d.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.ama != null && advertAppInfo.ama.adCloseInfo != null && advertAppInfo.ama.adCloseInfo.support_close.intValue() > 0) {
            this.gGA.setVisibility(0);
            this.gGA.setData(advertAppInfo);
        } else {
            this.gGA.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.bWQ.getHeaderImg() != null) {
            if (advertAppInfo2.yC() == null || advertAppInfo2.yC().getPendantData() == null || StringUtils.isNull(advertAppInfo2.yC().getPendantData().xn())) {
                this.bWQ.getHeaderImg().setVisibility(0);
                this.bWQ.getHeaderImg().setData(advertAppInfo2);
                this.bWQ.getHeaderImg().setOnClickListener(this.cLM);
            } else {
                this.bWQ.getHeaderImg().setVisibility(4);
            }
        }
        if (this.bWQ.getUserName() != null) {
            this.bWQ.getUserName().setOnClickListener(this.cLM);
        }
        o.a(this.mTitle, advertAppInfo2.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        o.b(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.cOr);
        al.j(this.cOr, e.d.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.ayk().ayl()) {
            this.gGl.setVisibility(0);
            al.j(this.gGl, e.d.cp_bg_line_d);
            return;
        }
        this.gGl.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.ffR == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.wA().wE() || adPost.feedData.bsY().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.gJF != null) {
            this.gJF.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.gJD.setVisibility(8);
            return;
        }
        this.gJF = this.gJG.obtainHolder(adPost, this.gJD, this.gJF, this.fgR);
        if (this.gJF != null) {
            this.gJD.setVisibility(0);
            this.gJF.setVisibility(0);
            this.gJF.update(adPost);
            this.gJF.setAfterClickSchemeListener(this.fgQ);
            this.gJF.setPageContext(this.mContext);
            return;
        }
        this.gJD.setVisibility(8);
    }

    public int getLayout() {
        return e.h.post_ad_card_base;
    }
}
