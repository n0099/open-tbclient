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
    private ThreadUserInfoLayout bwj;
    private View clY;
    protected View.OnClickListener cma;
    protected View coS;
    private AdCloseView fYE;
    private AdThreadCommentAndPraiseInfoLayout fYM;
    private ViewStub fYo;
    private View fYp;
    private TextView gaj;
    private RelativeLayout gbE;
    private AdPost gbF;
    protected AdOperateBarHolder gbG;
    protected final AdOperateBarCreator gbH;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void br(View view2);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cma = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (AdPostBaseView.this.gbF != null) {
                    if ((AdPostBaseView.this.bwj.getUserName() == view2 || AdPostBaseView.this.bwj.getHeaderImg() == view2) && AdPostBaseView.this.gbF.feedData.portraitClick != null) {
                        AdPostBaseView.this.i(3, "icon", AdPostBaseView.this.gbF.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.i(3, "hotarea", AdPostBaseView.this.gbF.feedData.scheme);
                }
            }
        };
        this.gbH = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        ak.i(this.rootView, d.f.addresslist_item_bg);
        this.fYM.onChangeSkinType();
        this.bwj.onChangeSkinType();
        if (this.fYE != null) {
            this.fYE.onChangeSkinType();
        }
        if (this.gbG != null) {
            this.gbG.onChangeSkinType();
        }
        ak.j(this.clY, d.C0126d.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View aKU() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.cma);
        this.mTitle = (TextView) this.rootView.findViewById(d.g.card_home_page_normal_thread_title);
        this.clY = this.rootView.findViewById(d.g.divider_line);
        this.coS = this.rootView.findViewById(d.g.divider_line_above_praise);
        this.fYM = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(d.g.card_home_page_normal_thread_info_layout);
        this.fYM.setStyle(2);
        this.bwj = (ThreadUserInfoLayout) this.rootView.findViewById(d.g.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(d.i.ad_post_tag_close, (ViewGroup) null);
        this.gaj = (TextView) inflate.findViewById(d.g.feed_tag);
        this.fYE = (AdCloseView) inflate.findViewById(d.g.ad_close_view);
        this.fYE.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (AdPostBaseView.this.fYE != null && AdPostBaseView.this.fYE.getVisibility() == 0) {
                    AdPostBaseView.this.fYE.performClick();
                }
            }
        });
        this.bwj.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.adf.getResources().getDimensionPixelOffset(d.e.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.fYM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fYM.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.fYM.setLayoutParams(layoutParams2);
        }
        this.fYM.setBarNameClickEnabled(false);
        this.fYM.setReplyTimeVisible(false);
        this.fYM.setShowPraiseNum(true);
        this.fYM.setNeedAddPraiseIcon(true);
        this.fYM.setNeedAddReplyIcon(true);
        this.fYM.setShareVisible(true);
        this.gbE = (RelativeLayout) this.rootView.findViewById(d.g.ad_operate_area);
        this.gbE.setOnClickListener(this.cma);
        this.fYo = (ViewStub) this.rootView.findViewById(d.g.ad_custom_view_stub);
        this.fYo.setLayoutResource(getCustomLayout());
        this.fYp = this.fYo.inflate();
        br(this.fYp);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.gbF.preloadLegoCardStr)) {
            str2 = rW(str2);
        }
        a.Nb().c(this.adf.getPageActivity(), new String[]{str2});
        if (this.ewj != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.ewj.b(i, hashMap);
        }
    }

    private String rW(String str) {
        return str + "&" + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.gbF.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.gbF = adPost;
        this.bwj.setData(adPost.getAdvertAppInfo());
        this.fYM.setShareData(adPost);
        this.fYM.setCommentClickable(true);
        this.fYM.getCommentContainer().setOnClickListener(this.cma);
        this.fYM.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.gaj.setVisibility(8);
        } else {
            this.gaj.setVisibility(0);
            this.gaj.setText(adPost.feedData.tag_name);
            this.gaj.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.gaj.setTextSize(0, l.e(this.adf.getPageActivity(), d.e.fontsize24));
                ak.c(this.gaj, d.C0126d.cp_cont_d, 1);
            } else {
                this.gaj.setTextSize(0, l.e(this.adf.getPageActivity(), d.e.fontsize28));
                ak.c(this.gaj, d.C0126d.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.Wb != null && advertAppInfo.Wb.Ww != null && advertAppInfo.Wb.Ww.support_close.intValue() > 0) {
            this.fYE.setVisibility(0);
            this.fYE.setData(advertAppInfo);
        } else {
            this.fYE.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.bwj.getHeaderImg() != null) {
            if (advertAppInfo2.rQ() == null || advertAppInfo2.rQ().getPendantData() == null || StringUtils.isNull(advertAppInfo2.rQ().getPendantData().qG())) {
                this.bwj.getHeaderImg().setVisibility(0);
                this.bwj.getHeaderImg().setData(advertAppInfo2);
                this.bwj.getHeaderImg().setOnClickListener(this.cma);
            } else {
                this.bwj.getHeaderImg().setVisibility(4);
            }
        }
        if (this.bwj.getUserName() != null) {
            this.bwj.getUserName().setOnClickListener(this.cma);
        }
        o.a(this.mTitle, advertAppInfo2.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
        o.b(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.coS);
        ak.j(this.coS, d.C0126d.cp_bg_line_e);
    }

    private void a(AdPost adPost, View view2) {
        if (adPost != null) {
            if (!i.pY().qe() || adPost.feedData.bjC().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view2.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.gbG != null) {
            this.gbG.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.gbE.setVisibility(8);
            return;
        }
        this.gbG = this.gbH.obtainHolder(adPost, this.gbE, this.gbG, this.ewk);
        if (this.gbG != null) {
            this.gbE.setVisibility(0);
            this.gbG.setVisibility(0);
            this.gbG.update(adPost);
            this.gbG.setAfterClickSchemeListener(this.ewj);
            this.gbG.setPageContext(this.adf);
            return;
        }
        this.gbE.setVisibility(8);
    }

    public int getLayout() {
        return d.i.post_ad_card_base;
    }
}
