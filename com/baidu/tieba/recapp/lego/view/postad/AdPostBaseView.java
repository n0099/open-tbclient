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
import com.baidu.searchbox.ng.ai.apps.scheme.AiAppUnitedSchemeUtilsDispatcher;
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
import com.baidu.webkit.internal.ETAG;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes3.dex */
public abstract class AdPostBaseView extends PostAdBaseView<AdPost> {
    private ThreadUserInfoLayout bWe;
    private View cKE;
    protected View.OnClickListener cKG;
    protected View cNl;
    private ViewStub gEH;
    private View gEI;
    protected View gEJ;
    private AdCloseView gEY;
    private AdThreadCommentAndPraiseInfoLayout gFg;
    private TextView gGF;
    private RelativeLayout gIb;
    private AdPost gIc;
    protected AdOperateBarHolder gId;
    protected final AdOperateBarCreator gIe;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void bL(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cKG = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.gIc != null) {
                    if ((AdPostBaseView.this.bWe.getUserName() == view || AdPostBaseView.this.bWe.getHeaderImg() == view) && AdPostBaseView.this.gIc.feedData.portraitClick != null) {
                        AdPostBaseView.this.k(3, AiAppUnitedSchemeUtilsDispatcher.PARAM_TOAST_ICON_KEY, AdPostBaseView.this.gIc.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.k(3, "hotarea", AdPostBaseView.this.gIc.feedData.scheme);
                }
            }
        };
        this.gIe = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        al.i(this.rootView, e.f.addresslist_item_bg);
        this.gFg.onChangeSkinType();
        this.bWe.onChangeSkinType();
        if (this.gEY != null) {
            this.gEY.onChangeSkinType();
        }
        if (this.gId != null) {
            this.gId.onChangeSkinType();
        }
        al.j(this.cKE, e.d.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View aWW() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.cKG);
        this.gEJ = this.rootView.findViewById(e.g.thread_multi_del_ad_mask_view);
        this.gEJ.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(e.g.card_home_page_normal_thread_title);
        this.cKE = this.rootView.findViewById(e.g.divider_line);
        this.cNl = this.rootView.findViewById(e.g.divider_line_above_praise);
        this.gFg = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.gFg.setStyle(2);
        this.bWe = (ThreadUserInfoLayout) this.rootView.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(e.h.ad_post_tag_close, (ViewGroup) null);
        this.gGF = (TextView) inflate.findViewById(e.g.feed_tag);
        this.gEY = (AdCloseView) inflate.findViewById(e.g.ad_close_view);
        this.gEY.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.gEY != null && AdPostBaseView.this.gEY.getVisibility() == 0) {
                    AdPostBaseView.this.gEY.performClick();
                }
            }
        });
        this.bWe.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(e.C0175e.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.gFg.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gFg.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.gFg.setLayoutParams(layoutParams2);
        }
        this.gFg.setBarNameClickEnabled(false);
        this.gFg.setReplyTimeVisible(false);
        this.gFg.setShowPraiseNum(true);
        this.gFg.setNeedAddPraiseIcon(true);
        this.gFg.setNeedAddReplyIcon(true);
        this.gFg.setShareVisible(true);
        this.gIb = (RelativeLayout) this.rootView.findViewById(e.g.ad_operate_area);
        this.gIb.setOnClickListener(this.cKG);
        this.gEH = (ViewStub) this.rootView.findViewById(e.g.ad_custom_view_stub);
        this.gEH.setLayoutResource(getCustomLayout());
        this.gEI = this.gEH.inflate();
        bL(this.gEI);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.gIc.preloadLegoCardStr)) {
            str2 = tZ(str2);
        }
        a.UR().d(this.mContext.getPageActivity(), new String[]{str2});
        if (this.ffw != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.ffw.b(i, hashMap);
        }
    }

    private String tZ(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + ETAG.EQUAL + URLEncoder.encode(this.gIc.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.gIc = adPost;
        this.bWe.setData(adPost.getAdvertAppInfo());
        this.gFg.setShareData(adPost);
        this.gFg.setCommentClickable(true);
        this.gFg.getCommentContainer().setOnClickListener(this.cKG);
        this.gFg.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.gGF.setVisibility(8);
        } else {
            this.gGF.setVisibility(0);
            this.gGF.setText(adPost.feedData.tag_name);
            this.gGF.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.gGF.setTextSize(0, l.h(this.mContext.getPageActivity(), e.C0175e.fontsize24));
                al.c(this.gGF, e.d.cp_cont_d, 1);
            } else {
                this.gGF.setTextSize(0, l.h(this.mContext.getPageActivity(), e.C0175e.fontsize28));
                al.c(this.gGF, e.d.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.aln != null && advertAppInfo.aln.adCloseInfo != null && advertAppInfo.aln.adCloseInfo.support_close.intValue() > 0) {
            this.gEY.setVisibility(0);
            this.gEY.setData(advertAppInfo);
        } else {
            this.gEY.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.bWe.getHeaderImg() != null) {
            if (advertAppInfo2.yv() == null || advertAppInfo2.yv().getPendantData() == null || StringUtils.isNull(advertAppInfo2.yv().getPendantData().xf())) {
                this.bWe.getHeaderImg().setVisibility(0);
                this.bWe.getHeaderImg().setData(advertAppInfo2);
                this.bWe.getHeaderImg().setOnClickListener(this.cKG);
            } else {
                this.bWe.getHeaderImg().setVisibility(4);
            }
        }
        if (this.bWe.getUserName() != null) {
            this.bWe.getUserName().setOnClickListener(this.cKG);
        }
        o.a(this.mTitle, advertAppInfo2.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        o.b(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.cNl);
        al.j(this.cNl, e.d.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.ayM().ayN()) {
            this.gEJ.setVisibility(0);
            al.j(this.gEJ, e.d.cp_bg_line_d);
            return;
        }
        this.gEJ.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.fex == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.ws().ww() || adPost.feedData.btC().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.gId != null) {
            this.gId.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.gIb.setVisibility(8);
            return;
        }
        this.gId = this.gIe.obtainHolder(adPost, this.gIb, this.gId, this.ffx);
        if (this.gId != null) {
            this.gIb.setVisibility(0);
            this.gId.setVisibility(0);
            this.gId.update(adPost);
            this.gId.setAfterClickSchemeListener(this.ffw);
            this.gId.setPageContext(this.mContext);
            return;
        }
        this.gIb.setVisibility(8);
    }

    public int getLayout() {
        return e.h.post_ad_card_base;
    }
}
