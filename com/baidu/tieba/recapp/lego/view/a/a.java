package com.baidu.tieba.recapp.lego.view.a;

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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.card.j;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdOperateBarCreator;
import com.baidu.tieba.recapp.view.AdOperateBarHolder;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes3.dex */
public abstract class a extends d<AdPost> {
    private View cVv;
    protected View.OnClickListener cVx;
    protected View cWR;
    private ThreadUserInfoLayout clW;
    private AdCloseView gDE;
    private AdThreadCommentAndPraiseInfoLayout gDM;
    private ViewStub gDo;
    private View gDp;
    private TextView gGt;
    private RelativeLayout gGu;
    private AdPost gGv;
    protected AdOperateBarHolder gGw;
    protected final AdOperateBarCreator gGx;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void cL(View view);

    protected abstract int getCustomLayout();

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cVx = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gGv != null) {
                    if ((a.this.clW.getUserName() == view || a.this.clW.getHeaderImg() == view) && a.this.gGv.feedData.portraitClick != null) {
                        a.this.j(3, "icon", a.this.gGv.feedData.portraitClick.scheme);
                        return;
                    }
                    a.this.j(3, "hotarea", a.this.gGv.feedData.scheme);
                }
            }
        };
        this.gGx = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.a.d
    public void a(AdPost adPost, int i) {
        aj.s(this.rootView, d.f.addresslist_item_bg);
        this.gDM.onChangeSkinType();
        this.clW.onChangeSkinType();
        if (this.gDE != null) {
            this.gDE.onChangeSkinType();
        }
        if (this.gGw != null) {
            this.gGw.onChangeSkinType();
        }
        aj.t(this.cVv, d.C0141d.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.a.d
    protected View aPS() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.cVx);
        this.mTitle = (TextView) this.rootView.findViewById(d.g.card_home_page_normal_thread_title);
        this.cVv = this.rootView.findViewById(d.g.divider_line);
        this.cWR = this.rootView.findViewById(d.g.divider_line_above_praise);
        this.gDM = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.gDM.setStyle(2);
        this.clW = (ThreadUserInfoLayout) this.rootView.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.ad_post_tag_close, (ViewGroup) null);
        this.gGt = (TextView) inflate.findViewById(d.g.feed_tag);
        this.gDE = (AdCloseView) inflate.findViewById(d.g.ad_close_view);
        this.gDE.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gDE != null && a.this.gDE.getVisibility() == 0) {
                    a.this.gDE.performClick();
                }
            }
        });
        this.clW.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.aRG.getResources().getDimensionPixelOffset(d.e.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.gDM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gDM.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.gDM.setLayoutParams(layoutParams2);
        }
        this.gDM.setBarNameClickEnabled(false);
        this.gDM.setReplyTimeVisible(false);
        this.gDM.setShowPraiseNum(true);
        this.gDM.setNeedAddPraiseIcon(true);
        this.gDM.setNeedAddReplyIcon(true);
        this.gDM.setShareVisible(true);
        this.gGu = (RelativeLayout) this.rootView.findViewById(d.g.ad_operate_area);
        this.gGu.setOnClickListener(this.cVx);
        this.gDo = (ViewStub) this.rootView.findViewById(d.g.ad_custom_view_stub);
        this.gDo.setLayoutResource(getCustomLayout());
        this.gDp = this.gDo.inflate();
        cL(this.gDp);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.gGv.preloadLegoCardStr)) {
            str2 = rQ(str2);
        }
        com.baidu.tieba.ad.a.Uz().c(this.aRG.getPageActivity(), new String[]{str2});
        if (this.fbq != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.fbq.b(i, hashMap);
        }
    }

    private String rQ(String str) {
        return str + "&" + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.gGv.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.a.d
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((a) adPost);
        this.gGv = adPost;
        this.clW.setData(adPost.getAdvertAppInfo());
        this.gDM.setShareData(adPost);
        this.gDM.setCommentClickable(true);
        this.gDM.getCommentContainer().setOnClickListener(this.cVx);
        this.gDM.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.gGt.setVisibility(8);
        } else {
            this.gGt.setVisibility(0);
            this.gGt.setText(adPost.feedData.tag_name);
            this.gGt.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.gGt.setTextSize(0, l.t(this.aRG.getPageActivity(), d.e.fontsize24));
                aj.e(this.gGt, d.C0141d.cp_cont_d, 1);
            } else {
                this.gGt.setTextSize(0, l.t(this.aRG.getPageActivity(), d.e.fontsize28));
                aj.e(this.gGt, d.C0141d.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.aKG != null && advertAppInfo.aKG.aLb != null && advertAppInfo.aKG.aLb.support_close.intValue() > 0) {
            this.gDE.setVisibility(0);
            this.gDE.setData(advertAppInfo);
        } else {
            this.gDE.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.clW.getHeaderImg() != null) {
            if (advertAppInfo2.zn() == null || advertAppInfo2.zn().getPendantData() == null || StringUtils.isNull(advertAppInfo2.zn().getPendantData().ya())) {
                this.clW.getHeaderImg().setVisibility(0);
                this.clW.getHeaderImg().setData(advertAppInfo2);
                this.clW.getHeaderImg().setOnClickListener(this.cVx);
            } else {
                this.clW.getHeaderImg().setVisibility(4);
            }
        }
        if (this.clW.getUserName() != null) {
            this.clW.getUserName().setOnClickListener(this.cVx);
        }
        j.a(this.mTitle, advertAppInfo2.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        j.b(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.cWR);
        aj.t(this.cWR, d.C0141d.cp_bg_line_e);
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.xo().xu() || adPost.feedData.bov().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.a.d, com.baidu.tieba.lego.card.e.k
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.gGw != null) {
            this.gGw.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.gGu.setVisibility(8);
            return;
        }
        this.gGw = this.gGx.obtainHolder(adPost, this.gGu, this.gGw, this.fbr);
        if (this.gGw != null) {
            this.gGu.setVisibility(0);
            this.gGw.setVisibility(0);
            this.gGw.update(adPost);
            this.gGw.setAfterClickSchemeListener(this.fbq);
            this.gGw.setPageContext(this.aRG);
            return;
        }
        this.gGu.setVisibility(8);
    }

    public int getLayout() {
        return d.h.post_ad_card_base;
    }
}
