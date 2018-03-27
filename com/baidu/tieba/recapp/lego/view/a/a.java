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
    protected View.OnClickListener cVA;
    private View cVy;
    protected View cWU;
    private ThreadUserInfoLayout clZ;
    private ViewStub gDE;
    private View gDF;
    private AdCloseView gDU;
    private AdThreadCommentAndPraiseInfoLayout gEc;
    private TextView gGJ;
    private RelativeLayout gGK;
    private AdPost gGL;
    protected AdOperateBarHolder gGM;
    protected final AdOperateBarCreator gGN;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void cL(View view);

    protected abstract int getCustomLayout();

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cVA = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gGL != null) {
                    if ((a.this.clZ.getUserName() == view || a.this.clZ.getHeaderImg() == view) && a.this.gGL.feedData.portraitClick != null) {
                        a.this.j(3, "icon", a.this.gGL.feedData.portraitClick.scheme);
                        return;
                    }
                    a.this.j(3, "hotarea", a.this.gGL.feedData.scheme);
                }
            }
        };
        this.gGN = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.a.d
    public void a(AdPost adPost, int i) {
        aj.s(this.rootView, d.f.addresslist_item_bg);
        this.gEc.onChangeSkinType();
        this.clZ.onChangeSkinType();
        if (this.gDU != null) {
            this.gDU.onChangeSkinType();
        }
        if (this.gGM != null) {
            this.gGM.onChangeSkinType();
        }
        aj.t(this.cVy, d.C0141d.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.a.d
    protected View aPT() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.cVA);
        this.mTitle = (TextView) this.rootView.findViewById(d.g.card_home_page_normal_thread_title);
        this.cVy = this.rootView.findViewById(d.g.divider_line);
        this.cWU = this.rootView.findViewById(d.g.divider_line_above_praise);
        this.gEc = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.gEc.setStyle(2);
        this.clZ = (ThreadUserInfoLayout) this.rootView.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.ad_post_tag_close, (ViewGroup) null);
        this.gGJ = (TextView) inflate.findViewById(d.g.feed_tag);
        this.gDU = (AdCloseView) inflate.findViewById(d.g.ad_close_view);
        this.gDU.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gDU != null && a.this.gDU.getVisibility() == 0) {
                    a.this.gDU.performClick();
                }
            }
        });
        this.clZ.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.aRI.getResources().getDimensionPixelOffset(d.e.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.gEc.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gEc.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.gEc.setLayoutParams(layoutParams2);
        }
        this.gEc.setBarNameClickEnabled(false);
        this.gEc.setReplyTimeVisible(false);
        this.gEc.setShowPraiseNum(true);
        this.gEc.setNeedAddPraiseIcon(true);
        this.gEc.setNeedAddReplyIcon(true);
        this.gEc.setShareVisible(true);
        this.gGK = (RelativeLayout) this.rootView.findViewById(d.g.ad_operate_area);
        this.gGK.setOnClickListener(this.cVA);
        this.gDE = (ViewStub) this.rootView.findViewById(d.g.ad_custom_view_stub);
        this.gDE.setLayoutResource(getCustomLayout());
        this.gDF = this.gDE.inflate();
        cL(this.gDF);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.gGL.preloadLegoCardStr)) {
            str2 = rQ(str2);
        }
        com.baidu.tieba.ad.a.UA().c(this.aRI.getPageActivity(), new String[]{str2});
        if (this.fbE != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.fbE.b(i, hashMap);
        }
    }

    private String rQ(String str) {
        return str + "&" + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.gGL.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.a.d
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((a) adPost);
        this.gGL = adPost;
        this.clZ.setData(adPost.getAdvertAppInfo());
        this.gEc.setShareData(adPost);
        this.gEc.setCommentClickable(true);
        this.gEc.getCommentContainer().setOnClickListener(this.cVA);
        this.gEc.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.gGJ.setVisibility(8);
        } else {
            this.gGJ.setVisibility(0);
            this.gGJ.setText(adPost.feedData.tag_name);
            this.gGJ.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.gGJ.setTextSize(0, l.t(this.aRI.getPageActivity(), d.e.fontsize24));
                aj.e(this.gGJ, d.C0141d.cp_cont_d, 1);
            } else {
                this.gGJ.setTextSize(0, l.t(this.aRI.getPageActivity(), d.e.fontsize28));
                aj.e(this.gGJ, d.C0141d.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.aKH != null && advertAppInfo.aKH.aLc != null && advertAppInfo.aKH.aLc.support_close.intValue() > 0) {
            this.gDU.setVisibility(0);
            this.gDU.setData(advertAppInfo);
        } else {
            this.gDU.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.clZ.getHeaderImg() != null) {
            if (advertAppInfo2.zn() == null || advertAppInfo2.zn().getPendantData() == null || StringUtils.isNull(advertAppInfo2.zn().getPendantData().ya())) {
                this.clZ.getHeaderImg().setVisibility(0);
                this.clZ.getHeaderImg().setData(advertAppInfo2);
                this.clZ.getHeaderImg().setOnClickListener(this.cVA);
            } else {
                this.clZ.getHeaderImg().setVisibility(4);
            }
        }
        if (this.clZ.getUserName() != null) {
            this.clZ.getUserName().setOnClickListener(this.cVA);
        }
        j.a(this.mTitle, advertAppInfo2.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        j.b(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.cWU);
        aj.t(this.cWU, d.C0141d.cp_bg_line_e);
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
        if (this.gGM != null) {
            this.gGM.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.gGK.setVisibility(8);
            return;
        }
        this.gGM = this.gGN.obtainHolder(adPost, this.gGK, this.gGM, this.fbF);
        if (this.gGM != null) {
            this.gGK.setVisibility(0);
            this.gGM.setVisibility(0);
            this.gGM.update(adPost);
            this.gGM.setAfterClickSchemeListener(this.fbE);
            this.gGM.setPageContext(this.aRI);
            return;
        }
        this.gGK.setVisibility(8);
    }

    public int getLayout() {
        return d.h.post_ad_card_base;
    }
}
