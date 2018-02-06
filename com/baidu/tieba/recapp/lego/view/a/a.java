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
    private View cVH;
    protected View.OnClickListener cVJ;
    protected View cXd;
    private ThreadUserInfoLayout cmj;
    private ViewStub gDD;
    private View gDE;
    private AdCloseView gDT;
    private AdThreadCommentAndPraiseInfoLayout gEb;
    private TextView gGI;
    private RelativeLayout gGJ;
    private AdPost gGK;
    protected AdOperateBarHolder gGL;
    protected final AdOperateBarCreator gGM;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void cL(View view);

    protected abstract int getCustomLayout();

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cVJ = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gGK != null) {
                    if ((a.this.cmj.getUserName() == view || a.this.cmj.getHeaderImg() == view) && a.this.gGK.feedData.portraitClick != null) {
                        a.this.j(3, "icon", a.this.gGK.feedData.portraitClick.scheme);
                        return;
                    }
                    a.this.j(3, "hotarea", a.this.gGK.feedData.scheme);
                }
            }
        };
        this.gGM = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.a.d
    public void a(AdPost adPost, int i) {
        aj.s(this.rootView, d.f.addresslist_item_bg);
        this.gEb.onChangeSkinType();
        this.cmj.onChangeSkinType();
        if (this.gDT != null) {
            this.gDT.onChangeSkinType();
        }
        if (this.gGL != null) {
            this.gGL.onChangeSkinType();
        }
        aj.t(this.cVH, d.C0140d.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.a.d
    protected View aPT() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.cVJ);
        this.mTitle = (TextView) this.rootView.findViewById(d.g.card_home_page_normal_thread_title);
        this.cVH = this.rootView.findViewById(d.g.divider_line);
        this.cXd = this.rootView.findViewById(d.g.divider_line_above_praise);
        this.gEb = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.gEb.setStyle(2);
        this.cmj = (ThreadUserInfoLayout) this.rootView.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.ad_post_tag_close, (ViewGroup) null);
        this.gGI = (TextView) inflate.findViewById(d.g.feed_tag);
        this.gDT = (AdCloseView) inflate.findViewById(d.g.ad_close_view);
        this.gDT.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gDT != null && a.this.gDT.getVisibility() == 0) {
                    a.this.gDT.performClick();
                }
            }
        });
        this.cmj.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.aRR.getResources().getDimensionPixelOffset(d.e.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.gEb.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gEb.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.gEb.setLayoutParams(layoutParams2);
        }
        this.gEb.setBarNameClickEnabled(false);
        this.gEb.setReplyTimeVisible(false);
        this.gEb.setShowPraiseNum(true);
        this.gEb.setNeedAddPraiseIcon(true);
        this.gEb.setNeedAddReplyIcon(true);
        this.gEb.setShareVisible(true);
        this.gGJ = (RelativeLayout) this.rootView.findViewById(d.g.ad_operate_area);
        this.gGJ.setOnClickListener(this.cVJ);
        this.gDD = (ViewStub) this.rootView.findViewById(d.g.ad_custom_view_stub);
        this.gDD.setLayoutResource(getCustomLayout());
        this.gDE = this.gDD.inflate();
        cL(this.gDE);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.gGK.preloadLegoCardStr)) {
            str2 = rQ(str2);
        }
        com.baidu.tieba.ad.a.UA().c(this.aRR.getPageActivity(), new String[]{str2});
        if (this.fbC != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.fbC.b(i, hashMap);
        }
    }

    private String rQ(String str) {
        return str + "&" + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.gGK.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.a.d
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((a) adPost);
        this.gGK = adPost;
        this.cmj.setData(adPost.getAdvertAppInfo());
        this.gEb.setShareData(adPost);
        this.gEb.setCommentClickable(true);
        this.gEb.getCommentContainer().setOnClickListener(this.cVJ);
        this.gEb.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.gGI.setVisibility(8);
        } else {
            this.gGI.setVisibility(0);
            this.gGI.setText(adPost.feedData.tag_name);
            this.gGI.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.gGI.setTextSize(0, l.t(this.aRR.getPageActivity(), d.e.fontsize24));
                aj.e(this.gGI, d.C0140d.cp_cont_d, 1);
            } else {
                this.gGI.setTextSize(0, l.t(this.aRR.getPageActivity(), d.e.fontsize28));
                aj.e(this.gGI, d.C0140d.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.aKR != null && advertAppInfo.aKR.aLm != null && advertAppInfo.aKR.aLm.support_close.intValue() > 0) {
            this.gDT.setVisibility(0);
            this.gDT.setData(advertAppInfo);
        } else {
            this.gDT.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.cmj.getHeaderImg() != null) {
            if (advertAppInfo2.zn() == null || advertAppInfo2.zn().getPendantData() == null || StringUtils.isNull(advertAppInfo2.zn().getPendantData().ya())) {
                this.cmj.getHeaderImg().setVisibility(0);
                this.cmj.getHeaderImg().setData(advertAppInfo2);
                this.cmj.getHeaderImg().setOnClickListener(this.cVJ);
            } else {
                this.cmj.getHeaderImg().setVisibility(4);
            }
        }
        if (this.cmj.getUserName() != null) {
            this.cmj.getUserName().setOnClickListener(this.cVJ);
        }
        j.a(this.mTitle, advertAppInfo2.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
        j.b(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.cXd);
        aj.t(this.cXd, d.C0140d.cp_bg_line_e);
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.xo().xu() || adPost.feedData.bow().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.a.d, com.baidu.tieba.lego.card.e.k
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.gGL != null) {
            this.gGL.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.gGJ.setVisibility(8);
            return;
        }
        this.gGL = this.gGM.obtainHolder(adPost, this.gGJ, this.gGL, this.fbD);
        if (this.gGL != null) {
            this.gGJ.setVisibility(0);
            this.gGL.setVisibility(0);
            this.gGL.update(adPost);
            this.gGL.setAfterClickSchemeListener(this.fbC);
            this.gGL.setPageContext(this.aRR);
            return;
        }
        this.gGJ.setVisibility(8);
    }

    public int getLayout() {
        return d.h.post_ad_card_base;
    }
}
