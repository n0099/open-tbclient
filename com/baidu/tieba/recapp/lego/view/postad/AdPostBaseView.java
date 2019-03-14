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
import com.baidu.tieba.card.n;
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
    private ThreadUserInfoLayout dqu;
    protected View eil;
    private View eio;
    protected View.OnClickListener eis;
    private AdCloseView iiJ;
    private AdThreadCommentAndPraiseInfoLayout iiR;
    private ViewStub iit;
    private View iiu;
    protected View iiv;
    private TextView ikp;
    private RelativeLayout ilN;
    private AdPost ilO;
    protected AdOperateBarHolder ilP;
    protected final AdOperateBarCreator ilQ;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void cD(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eis = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.ilO != null) {
                    if ((AdPostBaseView.this.dqu.getUserName() == view || AdPostBaseView.this.dqu.getHeaderImg() == view) && AdPostBaseView.this.ilO.feedData.portraitClick != null) {
                        AdPostBaseView.this.l(3, "icon", AdPostBaseView.this.ilO.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.l(3, "hotarea", AdPostBaseView.this.ilO.feedData.scheme);
                }
            }
        };
        this.ilQ = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        al.k(this.rootView, d.f.addresslist_item_bg);
        this.iiR.onChangeSkinType();
        this.dqu.onChangeSkinType();
        if (this.iiJ != null) {
            this.iiJ.onChangeSkinType();
        }
        if (this.ilP != null) {
            this.ilP.onChangeSkinType();
        }
        al.l(this.eio, d.C0277d.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View bAd() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.eis);
        this.iiv = this.rootView.findViewById(d.g.thread_multi_del_ad_mask_view);
        this.iiv.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(d.g.card_home_page_normal_thread_title);
        this.eio = this.rootView.findViewById(d.g.divider_line);
        this.eil = this.rootView.findViewById(d.g.divider_line_above_praise);
        this.iiR = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.iiR.setStyle(2);
        this.dqu = (ThreadUserInfoLayout) this.rootView.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.ad_post_tag_close, (ViewGroup) null);
        this.ikp = (TextView) inflate.findViewById(d.g.feed_tag);
        this.iiJ = (AdCloseView) inflate.findViewById(d.g.ad_close_view);
        this.iiJ.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.iiJ != null && AdPostBaseView.this.iiJ.getVisibility() == 0) {
                    AdPostBaseView.this.iiJ.performClick();
                }
            }
        });
        this.dqu.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(d.e.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.iiR.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iiR.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.iiR.setLayoutParams(layoutParams2);
        }
        this.iiR.setBarNameClickEnabled(false);
        this.iiR.setReplyTimeVisible(false);
        this.iiR.setShowPraiseNum(true);
        this.iiR.setNeedAddPraiseIcon(true);
        this.iiR.setNeedAddReplyIcon(true);
        this.iiR.setShareVisible(true);
        this.ilN = (RelativeLayout) this.rootView.findViewById(d.g.ad_operate_area);
        this.ilN.setOnClickListener(this.eis);
        this.iit = (ViewStub) this.rootView.findViewById(d.g.ad_custom_view_stub);
        this.iit.setLayoutResource(getCustomLayout());
        this.iiu = this.iit.inflate();
        cD(this.iiu);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.ilO.preloadLegoCardStr)) {
            str2 = BB(str2);
        }
        a.awE().d(this.mContext.getPageActivity(), new String[]{str2});
        if (this.gHy != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.gHy.b(i, hashMap);
        }
    }

    private String BB(String str) {
        return str + "&" + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.ilO.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.ilO = adPost;
        this.dqu.setData(adPost.getAdvertAppInfo());
        this.iiR.setShareData(adPost);
        this.iiR.setCommentClickable(true);
        this.iiR.getCommentContainer().setOnClickListener(this.eis);
        this.iiR.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.ikp.setVisibility(8);
        } else {
            this.ikp.setVisibility(0);
            this.ikp.setText(adPost.feedData.tag_name);
            this.ikp.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.ikp.setTextSize(0, l.h(this.mContext.getPageActivity(), d.e.fontsize24));
                al.d(this.ikp, d.C0277d.cp_cont_d, 1);
            } else {
                this.ikp.setTextSize(0, l.h(this.mContext.getPageActivity(), d.e.fontsize28));
                al.d(this.ikp, d.C0277d.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.bwN != null && advertAppInfo.bwN.adCloseInfo != null && advertAppInfo.bwN.adCloseInfo.support_close.intValue() > 0) {
            this.iiJ.setVisibility(0);
            this.iiJ.setData(advertAppInfo);
        } else {
            this.iiJ.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.dqu.getHeaderImg() != null) {
            if (advertAppInfo2.YR() == null || advertAppInfo2.YR().getPendantData() == null || StringUtils.isNull(advertAppInfo2.YR().getPendantData().Xn())) {
                this.dqu.getHeaderImg().setVisibility(0);
                this.dqu.getHeaderImg().setData(advertAppInfo2);
                this.dqu.getHeaderImg().setOnClickListener(this.eis);
            } else {
                this.dqu.getHeaderImg().setVisibility(4);
            }
        }
        if (this.dqu.getUserName() != null) {
            this.dqu.getUserName().setOnClickListener(this.eis);
        }
        n.a(this.mTitle, advertAppInfo2.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        n.b(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.eil);
        al.l(this.eil, d.C0277d.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bbF().bbG()) {
            this.iiv.setVisibility(0);
            al.l(this.iiv, d.C0277d.cp_bg_line_d);
            return;
        }
        this.iiv.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.gGA == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.Wy().WC() || adPost.feedData.bXb().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.ilP != null) {
            this.ilP.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.ilN.setVisibility(8);
            return;
        }
        this.ilP = this.ilQ.obtainHolder(adPost, this.ilN, this.ilP, this.gHz);
        if (this.ilP != null) {
            this.ilN.setVisibility(0);
            this.ilP.setVisibility(0);
            this.ilP.update(adPost);
            this.ilP.setAfterClickSchemeListener(this.gHy);
            this.ilP.setPageContext(this.mContext);
            return;
        }
        this.ilN.setVisibility(8);
    }

    public int getLayout() {
        return d.h.post_ad_card_base;
    }
}
