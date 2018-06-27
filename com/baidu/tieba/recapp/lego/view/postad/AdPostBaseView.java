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
import com.baidu.tbadk.core.util.am;
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
    private ThreadUserInfoLayout bGY;
    private View ctT;
    protected View.OnClickListener ctV;
    protected View cwz;
    private ViewStub goC;
    private View goD;
    protected View goE;
    private AdCloseView goT;
    private AdThreadCommentAndPraiseInfoLayout gpb;
    private TextView gqy;
    private RelativeLayout grT;
    private AdPost grU;
    protected AdOperateBarHolder grV;
    protected final AdOperateBarCreator grW;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void bv(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ctV = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.grU != null) {
                    if ((AdPostBaseView.this.bGY.getUserName() == view || AdPostBaseView.this.bGY.getHeaderImg() == view) && AdPostBaseView.this.grU.feedData.portraitClick != null) {
                        AdPostBaseView.this.i(3, "icon", AdPostBaseView.this.grU.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.i(3, "hotarea", AdPostBaseView.this.grU.feedData.scheme);
                }
            }
        };
        this.grW = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        am.i(this.rootView, d.f.addresslist_item_bg);
        this.gpb.onChangeSkinType();
        this.bGY.onChangeSkinType();
        if (this.goT != null) {
            this.goT.onChangeSkinType();
        }
        if (this.grV != null) {
            this.grV.onChangeSkinType();
        }
        am.j(this.ctT, d.C0142d.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View aQw() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.ctV);
        this.goE = this.rootView.findViewById(d.g.thread_multi_del_ad_mask_view);
        this.goE.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(d.g.card_home_page_normal_thread_title);
        this.ctT = this.rootView.findViewById(d.g.divider_line);
        this.cwz = this.rootView.findViewById(d.g.divider_line_above_praise);
        this.gpb = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.gpb.setStyle(2);
        this.bGY = (ThreadUserInfoLayout) this.rootView.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(d.i.ad_post_tag_close, (ViewGroup) null);
        this.gqy = (TextView) inflate.findViewById(d.g.feed_tag);
        this.goT = (AdCloseView) inflate.findViewById(d.g.ad_close_view);
        this.goT.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.goT != null && AdPostBaseView.this.goT.getVisibility() == 0) {
                    AdPostBaseView.this.goT.performClick();
                }
            }
        });
        this.bGY.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(d.e.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.gpb.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gpb.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.gpb.setLayoutParams(layoutParams2);
        }
        this.gpb.setBarNameClickEnabled(false);
        this.gpb.setReplyTimeVisible(false);
        this.gpb.setShowPraiseNum(true);
        this.gpb.setNeedAddPraiseIcon(true);
        this.gpb.setNeedAddReplyIcon(true);
        this.gpb.setShareVisible(true);
        this.grT = (RelativeLayout) this.rootView.findViewById(d.g.ad_operate_area);
        this.grT.setOnClickListener(this.ctV);
        this.goC = (ViewStub) this.rootView.findViewById(d.g.ad_custom_view_stub);
        this.goC.setLayoutResource(getCustomLayout());
        this.goD = this.goC.inflate();
        bv(this.goD);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.grU.preloadLegoCardStr)) {
            str2 = sQ(str2);
        }
        a.QV().c(this.mContext.getPageActivity(), new String[]{str2});
        if (this.eME != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.eME.b(i, hashMap);
        }
    }

    private String sQ(String str) {
        return str + "&" + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.grU.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.grU = adPost;
        this.bGY.setData(adPost.getAdvertAppInfo());
        this.gpb.setShareData(adPost);
        this.gpb.setCommentClickable(true);
        this.gpb.getCommentContainer().setOnClickListener(this.ctV);
        this.gpb.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.gqy.setVisibility(8);
        } else {
            this.gqy.setVisibility(0);
            this.gqy.setText(adPost.feedData.tag_name);
            this.gqy.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.gqy.setTextSize(0, l.e(this.mContext.getPageActivity(), d.e.fontsize24));
                am.c(this.gqy, d.C0142d.cp_cont_d, 1);
            } else {
                this.gqy.setTextSize(0, l.e(this.mContext.getPageActivity(), d.e.fontsize28));
                am.c(this.gqy, d.C0142d.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.aem != null && advertAppInfo.aem.aeI != null && advertAppInfo.aem.aeI.support_close.intValue() > 0) {
            this.goT.setVisibility(0);
            this.goT.setData(advertAppInfo);
        } else {
            this.goT.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.bGY.getHeaderImg() != null) {
            if (advertAppInfo2.vw() == null || advertAppInfo2.vw().getPendantData() == null || StringUtils.isNull(advertAppInfo2.vw().getPendantData().uh())) {
                this.bGY.getHeaderImg().setVisibility(0);
                this.bGY.getHeaderImg().setData(advertAppInfo2);
                this.bGY.getHeaderImg().setOnClickListener(this.ctV);
            } else {
                this.bGY.getHeaderImg().setVisibility(4);
            }
        }
        if (this.bGY.getUserName() != null) {
            this.bGY.getUserName().setOnClickListener(this.ctV);
        }
        o.a(this.mTitle, advertAppInfo2.getId(), d.C0142d.cp_cont_b, d.C0142d.cp_cont_d);
        o.b(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.cwz);
        am.j(this.cwz, d.C0142d.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.asZ().ata()) {
            this.goE.setVisibility(0);
            am.j(this.goE, d.C0142d.cp_bg_line_d);
            return;
        }
        this.goE.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.eLF == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.tt().tz() || adPost.feedData.bpb().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.grV != null) {
            this.grV.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.grT.setVisibility(8);
            return;
        }
        this.grV = this.grW.obtainHolder(adPost, this.grT, this.grV, this.eMF);
        if (this.grV != null) {
            this.grT.setVisibility(0);
            this.grV.setVisibility(0);
            this.grV.update(adPost);
            this.grV.setAfterClickSchemeListener(this.eME);
            this.grV.setPageContext(this.mContext);
            return;
        }
        this.grT.setVisibility(8);
    }

    public int getLayout() {
        return d.i.post_ad_card_base;
    }
}
