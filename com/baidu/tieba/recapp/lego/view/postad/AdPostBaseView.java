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
import com.baidu.tieba.f;
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
    private ThreadUserInfoLayout bHN;
    private View cwt;
    protected View.OnClickListener cwv;
    protected View cyZ;
    private ViewStub gpP;
    private View gpQ;
    protected View gpR;
    private AdCloseView gqg;
    private AdThreadCommentAndPraiseInfoLayout gqo;
    private TextView grL;
    private RelativeLayout gti;
    private AdPost gtj;
    protected AdOperateBarHolder gtk;
    protected final AdOperateBarCreator gtl;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void by(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cwv = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.gtj != null) {
                    if ((AdPostBaseView.this.bHN.getUserName() == view || AdPostBaseView.this.bHN.getHeaderImg() == view) && AdPostBaseView.this.gtj.feedData.portraitClick != null) {
                        AdPostBaseView.this.i(3, "icon", AdPostBaseView.this.gtj.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.i(3, "hotarea", AdPostBaseView.this.gtj.feedData.scheme);
                }
            }
        };
        this.gtl = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        am.i(this.rootView, f.C0146f.addresslist_item_bg);
        this.gqo.onChangeSkinType();
        this.bHN.onChangeSkinType();
        if (this.gqg != null) {
            this.gqg.onChangeSkinType();
        }
        if (this.gtk != null) {
            this.gtk.onChangeSkinType();
        }
        am.j(this.cwt, f.d.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View aRu() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.cwv);
        this.gpR = this.rootView.findViewById(f.g.thread_multi_del_ad_mask_view);
        this.gpR.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(f.g.card_home_page_normal_thread_title);
        this.cwt = this.rootView.findViewById(f.g.divider_line);
        this.cyZ = this.rootView.findViewById(f.g.divider_line_above_praise);
        this.gqo = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(f.g.card_home_page_normal_thread_info_layout);
        this.gqo.setStyle(2);
        this.bHN = (ThreadUserInfoLayout) this.rootView.findViewById(f.g.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(f.h.ad_post_tag_close, (ViewGroup) null);
        this.grL = (TextView) inflate.findViewById(f.g.feed_tag);
        this.gqg = (AdCloseView) inflate.findViewById(f.g.ad_close_view);
        this.gqg.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.gqg != null && AdPostBaseView.this.gqg.getVisibility() == 0) {
                    AdPostBaseView.this.gqg.performClick();
                }
            }
        });
        this.bHN.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(f.e.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.gqo.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gqo.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.gqo.setLayoutParams(layoutParams2);
        }
        this.gqo.setBarNameClickEnabled(false);
        this.gqo.setReplyTimeVisible(false);
        this.gqo.setShowPraiseNum(true);
        this.gqo.setNeedAddPraiseIcon(true);
        this.gqo.setNeedAddReplyIcon(true);
        this.gqo.setShareVisible(true);
        this.gti = (RelativeLayout) this.rootView.findViewById(f.g.ad_operate_area);
        this.gti.setOnClickListener(this.cwv);
        this.gpP = (ViewStub) this.rootView.findViewById(f.g.ad_custom_view_stub);
        this.gpP.setLayoutResource(getCustomLayout());
        this.gpQ = this.gpP.inflate();
        by(this.gpQ);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.gtj.preloadLegoCardStr)) {
            str2 = sQ(str2);
        }
        a.Rh().c(this.mContext.getPageActivity(), new String[]{str2});
        if (this.eQu != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.eQu.b(i, hashMap);
        }
    }

    private String sQ(String str) {
        return str + "&" + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.gtj.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.gtj = adPost;
        this.bHN.setData(adPost.getAdvertAppInfo());
        this.gqo.setShareData(adPost);
        this.gqo.setCommentClickable(true);
        this.gqo.getCommentContainer().setOnClickListener(this.cwv);
        this.gqo.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.grL.setVisibility(8);
        } else {
            this.grL.setVisibility(0);
            this.grL.setText(adPost.feedData.tag_name);
            this.grL.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.grL.setTextSize(0, l.f(this.mContext.getPageActivity(), f.e.fontsize24));
                am.c(this.grL, f.d.cp_cont_d, 1);
            } else {
                this.grL.setTextSize(0, l.f(this.mContext.getPageActivity(), f.e.fontsize28));
                am.c(this.grL, f.d.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.adQ != null && advertAppInfo.adQ.adCloseInfo != null && advertAppInfo.adQ.adCloseInfo.support_close.intValue() > 0) {
            this.gqg.setVisibility(0);
            this.gqg.setData(advertAppInfo);
        } else {
            this.gqg.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.bHN.getHeaderImg() != null) {
            if (advertAppInfo2.vj() == null || advertAppInfo2.vj().getPendantData() == null || StringUtils.isNull(advertAppInfo2.vj().getPendantData().tT())) {
                this.bHN.getHeaderImg().setVisibility(0);
                this.bHN.getHeaderImg().setData(advertAppInfo2);
                this.bHN.getHeaderImg().setOnClickListener(this.cwv);
            } else {
                this.bHN.getHeaderImg().setVisibility(4);
            }
        }
        if (this.bHN.getUserName() != null) {
            this.bHN.getUserName().setOnClickListener(this.cwv);
        }
        o.a(this.mTitle, advertAppInfo2.getId(), f.d.cp_cont_b, f.d.cp_cont_d);
        o.b(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.cyZ);
        am.j(this.cyZ, f.d.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.atC().atD()) {
            this.gpR.setVisibility(0);
            am.j(this.gpR, f.d.cp_bg_line_d);
            return;
        }
        this.gpR.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.ePv == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.td().tj() || adPost.feedData.bnG().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.gtk != null) {
            this.gtk.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.gti.setVisibility(8);
            return;
        }
        this.gtk = this.gtl.obtainHolder(adPost, this.gti, this.gtk, this.eQv);
        if (this.gtk != null) {
            this.gti.setVisibility(0);
            this.gtk.setVisibility(0);
            this.gtk.update(adPost);
            this.gtk.setAfterClickSchemeListener(this.eQu);
            this.gtk.setPageContext(this.mContext);
            return;
        }
        this.gti.setVisibility(8);
    }

    public int getLayout() {
        return f.h.post_ad_card_base;
    }
}
