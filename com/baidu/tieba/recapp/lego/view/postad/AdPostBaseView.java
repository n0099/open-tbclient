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
import com.baidu.tbadk.core.util.ak;
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
    private ThreadUserInfoLayout bxa;
    private View cni;
    protected View.OnClickListener cnk;
    protected View cqc;
    private AdCloseView fZK;
    private AdThreadCommentAndPraiseInfoLayout fZS;
    private ViewStub fZu;
    private View fZv;
    private TextView gbp;
    private RelativeLayout gcK;
    private AdPost gcL;
    protected AdOperateBarHolder gcM;
    protected final AdOperateBarCreator gcN;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void br(View view2);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cnk = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (AdPostBaseView.this.gcL != null) {
                    if ((AdPostBaseView.this.bxa.getUserName() == view2 || AdPostBaseView.this.bxa.getHeaderImg() == view2) && AdPostBaseView.this.gcL.feedData.portraitClick != null) {
                        AdPostBaseView.this.i(3, "icon", AdPostBaseView.this.gcL.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.i(3, "hotarea", AdPostBaseView.this.gcL.feedData.scheme);
                }
            }
        };
        this.gcN = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        ak.i(this.rootView, d.f.addresslist_item_bg);
        this.fZS.onChangeSkinType();
        this.bxa.onChangeSkinType();
        if (this.fZK != null) {
            this.fZK.onChangeSkinType();
        }
        if (this.gcM != null) {
            this.gcM.onChangeSkinType();
        }
        ak.j(this.cni, d.C0126d.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View aKT() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.cnk);
        this.mTitle = (TextView) this.rootView.findViewById(d.g.card_home_page_normal_thread_title);
        this.cni = this.rootView.findViewById(d.g.divider_line);
        this.cqc = this.rootView.findViewById(d.g.divider_line_above_praise);
        this.fZS = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.fZS.setStyle(2);
        this.bxa = (ThreadUserInfoLayout) this.rootView.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(d.i.ad_post_tag_close, (ViewGroup) null);
        this.gbp = (TextView) inflate.findViewById(d.g.feed_tag);
        this.fZK = (AdCloseView) inflate.findViewById(d.g.ad_close_view);
        this.fZK.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (AdPostBaseView.this.fZK != null && AdPostBaseView.this.fZK.getVisibility() == 0) {
                    AdPostBaseView.this.fZK.performClick();
                }
            }
        });
        this.bxa.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(d.e.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.fZS.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fZS.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.fZS.setLayoutParams(layoutParams2);
        }
        this.fZS.setBarNameClickEnabled(false);
        this.fZS.setReplyTimeVisible(false);
        this.fZS.setShowPraiseNum(true);
        this.fZS.setNeedAddPraiseIcon(true);
        this.fZS.setNeedAddReplyIcon(true);
        this.fZS.setShareVisible(true);
        this.gcK = (RelativeLayout) this.rootView.findViewById(d.g.ad_operate_area);
        this.gcK.setOnClickListener(this.cnk);
        this.fZu = (ViewStub) this.rootView.findViewById(d.g.ad_custom_view_stub);
        this.fZu.setLayoutResource(getCustomLayout());
        this.fZv = this.fZu.inflate();
        br(this.fZv);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.gcL.preloadLegoCardStr)) {
            str2 = rZ(str2);
        }
        a.MZ().c(this.mContext.getPageActivity(), new String[]{str2});
        if (this.exr != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.exr.b(i, hashMap);
        }
    }

    private String rZ(String str) {
        return str + "&" + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.gcL.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.gcL = adPost;
        this.bxa.setData(adPost.getAdvertAppInfo());
        this.fZS.setShareData(adPost);
        this.fZS.setCommentClickable(true);
        this.fZS.getCommentContainer().setOnClickListener(this.cnk);
        this.fZS.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.gbp.setVisibility(8);
        } else {
            this.gbp.setVisibility(0);
            this.gbp.setText(adPost.feedData.tag_name);
            this.gbp.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.gbp.setTextSize(0, l.e(this.mContext.getPageActivity(), d.e.fontsize24));
                ak.c(this.gbp, d.C0126d.cp_cont_d, 1);
            } else {
                this.gbp.setTextSize(0, l.e(this.mContext.getPageActivity(), d.e.fontsize28));
                ak.c(this.gbp, d.C0126d.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.VX != null && advertAppInfo.VX.Ws != null && advertAppInfo.VX.Ws.support_close.intValue() > 0) {
            this.fZK.setVisibility(0);
            this.fZK.setData(advertAppInfo);
        } else {
            this.fZK.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.bxa.getHeaderImg() != null) {
            if (advertAppInfo2.rP() == null || advertAppInfo2.rP().getPendantData() == null || StringUtils.isNull(advertAppInfo2.rP().getPendantData().qF())) {
                this.bxa.getHeaderImg().setVisibility(0);
                this.bxa.getHeaderImg().setData(advertAppInfo2);
                this.bxa.getHeaderImg().setOnClickListener(this.cnk);
            } else {
                this.bxa.getHeaderImg().setVisibility(4);
            }
        }
        if (this.bxa.getUserName() != null) {
            this.bxa.getUserName().setOnClickListener(this.cnk);
        }
        o.a(this.mTitle, advertAppInfo2.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
        o.b(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.cqc);
        ak.j(this.cqc, d.C0126d.cp_bg_line_e);
    }

    private void a(AdPost adPost, View view2) {
        if (adPost != null) {
            if (!i.pX().qd() || adPost.feedData.bjB().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view2.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.gcM != null) {
            this.gcM.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.gcK.setVisibility(8);
            return;
        }
        this.gcM = this.gcN.obtainHolder(adPost, this.gcK, this.gcM, this.exs);
        if (this.gcM != null) {
            this.gcK.setVisibility(0);
            this.gcM.setVisibility(0);
            this.gcM.update(adPost);
            this.gcM.setAfterClickSchemeListener(this.exr);
            this.gcM.setPageContext(this.mContext);
            return;
        }
        this.gcK.setVisibility(8);
    }

    public int getLayout() {
        return d.i.post_ad_card_base;
    }
}
