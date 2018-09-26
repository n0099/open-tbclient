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
import com.baidu.tieba.e;
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
    private ThreadUserInfoLayout bNC;
    private View cCj;
    protected View.OnClickListener cCl;
    protected View cER;
    private RelativeLayout gAC;
    private AdPost gAD;
    protected AdOperateBarHolder gAE;
    protected final AdOperateBarCreator gAF;
    private AdThreadCommentAndPraiseInfoLayout gxG;
    private ViewStub gxh;
    private View gxi;
    protected View gxj;
    private AdCloseView gxy;
    private TextView gzf;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void bL(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cCl = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.gAD != null) {
                    if ((AdPostBaseView.this.bNC.getUserName() == view || AdPostBaseView.this.bNC.getHeaderImg() == view) && AdPostBaseView.this.gAD.feedData.portraitClick != null) {
                        AdPostBaseView.this.i(3, "icon", AdPostBaseView.this.gAD.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.i(3, "hotarea", AdPostBaseView.this.gAD.feedData.scheme);
                }
            }
        };
        this.gAF = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        al.i(this.rootView, e.f.addresslist_item_bg);
        this.gxG.onChangeSkinType();
        this.bNC.onChangeSkinType();
        if (this.gxy != null) {
            this.gxy.onChangeSkinType();
        }
        if (this.gAE != null) {
            this.gAE.onChangeSkinType();
        }
        al.j(this.cCj, e.d.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View aTI() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.cCl);
        this.gxj = this.rootView.findViewById(e.g.thread_multi_del_ad_mask_view);
        this.gxj.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(e.g.card_home_page_normal_thread_title);
        this.cCj = this.rootView.findViewById(e.g.divider_line);
        this.cER = this.rootView.findViewById(e.g.divider_line_above_praise);
        this.gxG = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.gxG.setStyle(2);
        this.bNC = (ThreadUserInfoLayout) this.rootView.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(e.h.ad_post_tag_close, (ViewGroup) null);
        this.gzf = (TextView) inflate.findViewById(e.g.feed_tag);
        this.gxy = (AdCloseView) inflate.findViewById(e.g.ad_close_view);
        this.gxy.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.gxy != null && AdPostBaseView.this.gxy.getVisibility() == 0) {
                    AdPostBaseView.this.gxy.performClick();
                }
            }
        });
        this.bNC.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(e.C0141e.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.gxG.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gxG.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.gxG.setLayoutParams(layoutParams2);
        }
        this.gxG.setBarNameClickEnabled(false);
        this.gxG.setReplyTimeVisible(false);
        this.gxG.setShowPraiseNum(true);
        this.gxG.setNeedAddPraiseIcon(true);
        this.gxG.setNeedAddReplyIcon(true);
        this.gxG.setShareVisible(true);
        this.gAC = (RelativeLayout) this.rootView.findViewById(e.g.ad_operate_area);
        this.gAC.setOnClickListener(this.cCl);
        this.gxh = (ViewStub) this.rootView.findViewById(e.g.ad_custom_view_stub);
        this.gxh.setLayoutResource(getCustomLayout());
        this.gxi = this.gxh.inflate();
        bL(this.gxi);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.gAD.preloadLegoCardStr)) {
            str2 = tx(str2);
        }
        a.SV().d(this.mContext.getPageActivity(), new String[]{str2});
        if (this.eXP != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.eXP.b(i, hashMap);
        }
    }

    private String tx(String str) {
        return str + "&" + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.gAD.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.gAD = adPost;
        this.bNC.setData(adPost.getAdvertAppInfo());
        this.gxG.setShareData(adPost);
        this.gxG.setCommentClickable(true);
        this.gxG.getCommentContainer().setOnClickListener(this.cCl);
        this.gxG.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.gzf.setVisibility(8);
        } else {
            this.gzf.setVisibility(0);
            this.gzf.setText(adPost.feedData.tag_name);
            this.gzf.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.gzf.setTextSize(0, l.h(this.mContext.getPageActivity(), e.C0141e.fontsize24));
                al.c(this.gzf, e.d.cp_cont_d, 1);
            } else {
                this.gzf.setTextSize(0, l.h(this.mContext.getPageActivity(), e.C0141e.fontsize28));
                al.c(this.gzf, e.d.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.agr != null && advertAppInfo.agr.adCloseInfo != null && advertAppInfo.agr.adCloseInfo.support_close.intValue() > 0) {
            this.gxy.setVisibility(0);
            this.gxy.setData(advertAppInfo);
        } else {
            this.gxy.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.bNC.getHeaderImg() != null) {
            if (advertAppInfo2.wm() == null || advertAppInfo2.wm().getPendantData() == null || StringUtils.isNull(advertAppInfo2.wm().getPendantData().uW())) {
                this.bNC.getHeaderImg().setVisibility(0);
                this.bNC.getHeaderImg().setData(advertAppInfo2);
                this.bNC.getHeaderImg().setOnClickListener(this.cCl);
            } else {
                this.bNC.getHeaderImg().setVisibility(4);
            }
        }
        if (this.bNC.getUserName() != null) {
            this.bNC.getUserName().setOnClickListener(this.cCl);
        }
        o.a(this.mTitle, advertAppInfo2.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        o.b(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.cER);
        al.j(this.cER, e.d.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.avq().avr()) {
            this.gxj.setVisibility(0);
            al.j(this.gxj, e.d.cp_bg_line_d);
            return;
        }
        this.gxj.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.eWQ == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.uj().un() || adPost.feedData.bqn().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.gAE != null) {
            this.gAE.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.gAC.setVisibility(8);
            return;
        }
        this.gAE = this.gAF.obtainHolder(adPost, this.gAC, this.gAE, this.eXQ);
        if (this.gAE != null) {
            this.gAC.setVisibility(0);
            this.gAE.setVisibility(0);
            this.gAE.update(adPost);
            this.gAE.setAfterClickSchemeListener(this.eXP);
            this.gAE.setPageContext(this.mContext);
            return;
        }
        this.gAC.setVisibility(8);
    }

    public int getLayout() {
        return e.h.post_ad_card_base;
    }
}
