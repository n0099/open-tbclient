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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.ad.a;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdOperateBarCreator;
import com.baidu.tieba.recapp.view.AdOperateBarHolder;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes3.dex */
public abstract class AdPostBaseView extends PostAdBaseView<AdPost> {
    private ThreadUserInfoLayout bFd;
    private View cvN;
    protected View.OnClickListener cvP;
    protected View cyF;
    private ViewStub gkM;
    private View gkN;
    private AdCloseView glc;
    private AdThreadCommentAndPraiseInfoLayout glk;
    private TextView gmH;
    private RelativeLayout goc;
    private AdPost god;
    protected AdOperateBarHolder goe;
    protected final AdOperateBarCreator gof;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void bu(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cvP = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.god != null) {
                    if ((AdPostBaseView.this.bFd.getUserName() == view || AdPostBaseView.this.bFd.getHeaderImg() == view) && AdPostBaseView.this.god.feedData.portraitClick != null) {
                        AdPostBaseView.this.i(3, "icon", AdPostBaseView.this.god.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.i(3, "hotarea", AdPostBaseView.this.god.feedData.scheme);
                }
            }
        };
        this.gof = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        al.i(this.rootView, d.f.addresslist_item_bg);
        this.glk.onChangeSkinType();
        this.bFd.onChangeSkinType();
        if (this.glc != null) {
            this.glc.onChangeSkinType();
        }
        if (this.goe != null) {
            this.goe.onChangeSkinType();
        }
        al.j(this.cvN, d.C0141d.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View aPQ() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.cvP);
        this.mTitle = (TextView) this.rootView.findViewById(d.g.card_home_page_normal_thread_title);
        this.cvN = this.rootView.findViewById(d.g.divider_line);
        this.cyF = this.rootView.findViewById(d.g.divider_line_above_praise);
        this.glk = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.glk.setStyle(2);
        this.bFd = (ThreadUserInfoLayout) this.rootView.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(d.i.ad_post_tag_close, (ViewGroup) null);
        this.gmH = (TextView) inflate.findViewById(d.g.feed_tag);
        this.glc = (AdCloseView) inflate.findViewById(d.g.ad_close_view);
        this.glc.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.glc != null && AdPostBaseView.this.glc.getVisibility() == 0) {
                    AdPostBaseView.this.glc.performClick();
                }
            }
        });
        this.bFd.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(d.e.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.glk.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.glk.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.glk.setLayoutParams(layoutParams2);
        }
        this.glk.setBarNameClickEnabled(false);
        this.glk.setReplyTimeVisible(false);
        this.glk.setShowPraiseNum(true);
        this.glk.setNeedAddPraiseIcon(true);
        this.glk.setNeedAddReplyIcon(true);
        this.glk.setShareVisible(true);
        this.goc = (RelativeLayout) this.rootView.findViewById(d.g.ad_operate_area);
        this.goc.setOnClickListener(this.cvP);
        this.gkM = (ViewStub) this.rootView.findViewById(d.g.ad_custom_view_stub);
        this.gkM.setLayoutResource(getCustomLayout());
        this.gkN = this.gkM.inflate();
        bu(this.gkN);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.god.preloadLegoCardStr)) {
            str2 = sR(str2);
        }
        a.Qy().c(this.mContext.getPageActivity(), new String[]{str2});
        if (this.eIN != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.eIN.b(i, hashMap);
        }
    }

    private String sR(String str) {
        return str + "&" + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.god.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.god = adPost;
        this.bFd.setData(adPost.getAdvertAppInfo());
        this.glk.setShareData(adPost);
        this.glk.setCommentClickable(true);
        this.glk.getCommentContainer().setOnClickListener(this.cvP);
        this.glk.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.gmH.setVisibility(8);
        } else {
            this.gmH.setVisibility(0);
            this.gmH.setText(adPost.feedData.tag_name);
            this.gmH.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.gmH.setTextSize(0, l.e(this.mContext.getPageActivity(), d.e.fontsize24));
                al.c(this.gmH, d.C0141d.cp_cont_d, 1);
            } else {
                this.gmH.setTextSize(0, l.e(this.mContext.getPageActivity(), d.e.fontsize28));
                al.c(this.gmH, d.C0141d.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.adX != null && advertAppInfo.adX.aet != null && advertAppInfo.adX.aet.support_close.intValue() > 0) {
            this.glc.setVisibility(0);
            this.glc.setData(advertAppInfo);
        } else {
            this.glc.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.bFd.getHeaderImg() != null) {
            if (advertAppInfo2.vm() == null || advertAppInfo2.vm().getPendantData() == null || StringUtils.isNull(advertAppInfo2.vm().getPendantData().ub())) {
                this.bFd.getHeaderImg().setVisibility(0);
                this.bFd.getHeaderImg().setData(advertAppInfo2);
                this.bFd.getHeaderImg().setOnClickListener(this.cvP);
            } else {
                this.bFd.getHeaderImg().setVisibility(4);
            }
        }
        if (this.bFd.getUserName() != null) {
            this.bFd.getUserName().setOnClickListener(this.cvP);
        }
        o.a(this.mTitle, advertAppInfo2.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
        o.b(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.cyF);
        al.j(this.cyF, d.C0141d.cp_bg_line_e);
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.tt().tz() || adPost.feedData.boA().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.goe != null) {
            this.goe.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.goc.setVisibility(8);
            return;
        }
        this.goe = this.gof.obtainHolder(adPost, this.goc, this.goe, this.eIO);
        if (this.goe != null) {
            this.goc.setVisibility(0);
            this.goe.setVisibility(0);
            this.goe.update(adPost);
            this.goe.setAfterClickSchemeListener(this.eIN);
            this.goe.setPageContext(this.mContext);
            return;
        }
        this.goc.setVisibility(8);
    }

    public int getLayout() {
        return d.i.post_ad_card_base;
    }
}
