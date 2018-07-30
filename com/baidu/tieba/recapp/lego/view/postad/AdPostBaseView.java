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
    private ThreadUserInfoLayout bHN;
    private View cww;
    protected View.OnClickListener cwy;
    protected View czc;
    private ViewStub gpM;
    private View gpN;
    protected View gpO;
    private AdCloseView gqd;
    private AdThreadCommentAndPraiseInfoLayout gql;
    private TextView grI;
    private RelativeLayout gtf;
    private AdPost gtg;
    protected AdOperateBarHolder gth;
    protected final AdOperateBarCreator gti;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void by(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cwy = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.gtg != null) {
                    if ((AdPostBaseView.this.bHN.getUserName() == view || AdPostBaseView.this.bHN.getHeaderImg() == view) && AdPostBaseView.this.gtg.feedData.portraitClick != null) {
                        AdPostBaseView.this.i(3, "icon", AdPostBaseView.this.gtg.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.i(3, "hotarea", AdPostBaseView.this.gtg.feedData.scheme);
                }
            }
        };
        this.gti = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        am.i(this.rootView, d.f.addresslist_item_bg);
        this.gql.onChangeSkinType();
        this.bHN.onChangeSkinType();
        if (this.gqd != null) {
            this.gqd.onChangeSkinType();
        }
        if (this.gth != null) {
            this.gth.onChangeSkinType();
        }
        am.j(this.cww, d.C0140d.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View aRx() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.cwy);
        this.gpO = this.rootView.findViewById(d.g.thread_multi_del_ad_mask_view);
        this.gpO.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(d.g.card_home_page_normal_thread_title);
        this.cww = this.rootView.findViewById(d.g.divider_line);
        this.czc = this.rootView.findViewById(d.g.divider_line_above_praise);
        this.gql = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.gql.setStyle(2);
        this.bHN = (ThreadUserInfoLayout) this.rootView.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.ad_post_tag_close, (ViewGroup) null);
        this.grI = (TextView) inflate.findViewById(d.g.feed_tag);
        this.gqd = (AdCloseView) inflate.findViewById(d.g.ad_close_view);
        this.gqd.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.gqd != null && AdPostBaseView.this.gqd.getVisibility() == 0) {
                    AdPostBaseView.this.gqd.performClick();
                }
            }
        });
        this.bHN.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(d.e.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.gql.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gql.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.gql.setLayoutParams(layoutParams2);
        }
        this.gql.setBarNameClickEnabled(false);
        this.gql.setReplyTimeVisible(false);
        this.gql.setShowPraiseNum(true);
        this.gql.setNeedAddPraiseIcon(true);
        this.gql.setNeedAddReplyIcon(true);
        this.gql.setShareVisible(true);
        this.gtf = (RelativeLayout) this.rootView.findViewById(d.g.ad_operate_area);
        this.gtf.setOnClickListener(this.cwy);
        this.gpM = (ViewStub) this.rootView.findViewById(d.g.ad_custom_view_stub);
        this.gpM.setLayoutResource(getCustomLayout());
        this.gpN = this.gpM.inflate();
        by(this.gpN);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.gtg.preloadLegoCardStr)) {
            str2 = sM(str2);
        }
        a.Rc().c(this.mContext.getPageActivity(), new String[]{str2});
        if (this.eQz != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.eQz.b(i, hashMap);
        }
    }

    private String sM(String str) {
        return str + "&" + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.gtg.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.gtg = adPost;
        this.bHN.setData(adPost.getAdvertAppInfo());
        this.gql.setShareData(adPost);
        this.gql.setCommentClickable(true);
        this.gql.getCommentContainer().setOnClickListener(this.cwy);
        this.gql.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.grI.setVisibility(8);
        } else {
            this.grI.setVisibility(0);
            this.grI.setText(adPost.feedData.tag_name);
            this.grI.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.grI.setTextSize(0, l.f(this.mContext.getPageActivity(), d.e.fontsize24));
                am.c(this.grI, d.C0140d.cp_cont_d, 1);
            } else {
                this.grI.setTextSize(0, l.f(this.mContext.getPageActivity(), d.e.fontsize28));
                am.c(this.grI, d.C0140d.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.adQ != null && advertAppInfo.adQ.adCloseInfo != null && advertAppInfo.adQ.adCloseInfo.support_close.intValue() > 0) {
            this.gqd.setVisibility(0);
            this.gqd.setData(advertAppInfo);
        } else {
            this.gqd.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.bHN.getHeaderImg() != null) {
            if (advertAppInfo2.vk() == null || advertAppInfo2.vk().getPendantData() == null || StringUtils.isNull(advertAppInfo2.vk().getPendantData().tU())) {
                this.bHN.getHeaderImg().setVisibility(0);
                this.bHN.getHeaderImg().setData(advertAppInfo2);
                this.bHN.getHeaderImg().setOnClickListener(this.cwy);
            } else {
                this.bHN.getHeaderImg().setVisibility(4);
            }
        }
        if (this.bHN.getUserName() != null) {
            this.bHN.getUserName().setOnClickListener(this.cwy);
        }
        o.a(this.mTitle, advertAppInfo2.getId(), d.C0140d.cp_cont_b, d.C0140d.cp_cont_d);
        o.b(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.czc);
        am.j(this.czc, d.C0140d.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.atD().atE()) {
            this.gpO.setVisibility(0);
            am.j(this.gpO, d.C0140d.cp_bg_line_d);
            return;
        }
        this.gpO.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.ePA == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.te().tk() || adPost.feedData.bnF().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.gth != null) {
            this.gth.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.gtf.setVisibility(8);
            return;
        }
        this.gth = this.gti.obtainHolder(adPost, this.gtf, this.gth, this.eQA);
        if (this.gth != null) {
            this.gtf.setVisibility(0);
            this.gth.setVisibility(0);
            this.gth.update(adPost);
            this.gth.setAfterClickSchemeListener(this.eQz);
            this.gth.setPageContext(this.mContext);
            return;
        }
        this.gtf.setVisibility(8);
    }

    public int getLayout() {
        return d.h.post_ad_card_base;
    }
}
