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
    private ViewStub gEI;
    private View gEJ;
    protected View gEK;
    private AdCloseView gEZ;
    private AdThreadCommentAndPraiseInfoLayout gFh;
    private TextView gGG;
    private RelativeLayout gIc;
    private AdPost gId;
    protected AdOperateBarHolder gIe;
    protected final AdOperateBarCreator gIf;
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
                if (AdPostBaseView.this.gId != null) {
                    if ((AdPostBaseView.this.bWe.getUserName() == view || AdPostBaseView.this.bWe.getHeaderImg() == view) && AdPostBaseView.this.gId.feedData.portraitClick != null) {
                        AdPostBaseView.this.k(3, AiAppUnitedSchemeUtilsDispatcher.PARAM_TOAST_ICON_KEY, AdPostBaseView.this.gId.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.k(3, "hotarea", AdPostBaseView.this.gId.feedData.scheme);
                }
            }
        };
        this.gIf = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        al.i(this.rootView, e.f.addresslist_item_bg);
        this.gFh.onChangeSkinType();
        this.bWe.onChangeSkinType();
        if (this.gEZ != null) {
            this.gEZ.onChangeSkinType();
        }
        if (this.gIe != null) {
            this.gIe.onChangeSkinType();
        }
        al.j(this.cKE, e.d.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View aWW() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.cKG);
        this.gEK = this.rootView.findViewById(e.g.thread_multi_del_ad_mask_view);
        this.gEK.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(e.g.card_home_page_normal_thread_title);
        this.cKE = this.rootView.findViewById(e.g.divider_line);
        this.cNl = this.rootView.findViewById(e.g.divider_line_above_praise);
        this.gFh = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.gFh.setStyle(2);
        this.bWe = (ThreadUserInfoLayout) this.rootView.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(e.h.ad_post_tag_close, (ViewGroup) null);
        this.gGG = (TextView) inflate.findViewById(e.g.feed_tag);
        this.gEZ = (AdCloseView) inflate.findViewById(e.g.ad_close_view);
        this.gEZ.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.gEZ != null && AdPostBaseView.this.gEZ.getVisibility() == 0) {
                    AdPostBaseView.this.gEZ.performClick();
                }
            }
        });
        this.bWe.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(e.C0175e.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.gFh.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gFh.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.gFh.setLayoutParams(layoutParams2);
        }
        this.gFh.setBarNameClickEnabled(false);
        this.gFh.setReplyTimeVisible(false);
        this.gFh.setShowPraiseNum(true);
        this.gFh.setNeedAddPraiseIcon(true);
        this.gFh.setNeedAddReplyIcon(true);
        this.gFh.setShareVisible(true);
        this.gIc = (RelativeLayout) this.rootView.findViewById(e.g.ad_operate_area);
        this.gIc.setOnClickListener(this.cKG);
        this.gEI = (ViewStub) this.rootView.findViewById(e.g.ad_custom_view_stub);
        this.gEI.setLayoutResource(getCustomLayout());
        this.gEJ = this.gEI.inflate();
        bL(this.gEJ);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.gId.preloadLegoCardStr)) {
            str2 = tZ(str2);
        }
        a.UR().d(this.mContext.getPageActivity(), new String[]{str2});
        if (this.ffx != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.ffx.b(i, hashMap);
        }
    }

    private String tZ(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + ETAG.EQUAL + URLEncoder.encode(this.gId.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.gId = adPost;
        this.bWe.setData(adPost.getAdvertAppInfo());
        this.gFh.setShareData(adPost);
        this.gFh.setCommentClickable(true);
        this.gFh.getCommentContainer().setOnClickListener(this.cKG);
        this.gFh.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.gGG.setVisibility(8);
        } else {
            this.gGG.setVisibility(0);
            this.gGG.setText(adPost.feedData.tag_name);
            this.gGG.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.gGG.setTextSize(0, l.h(this.mContext.getPageActivity(), e.C0175e.fontsize24));
                al.c(this.gGG, e.d.cp_cont_d, 1);
            } else {
                this.gGG.setTextSize(0, l.h(this.mContext.getPageActivity(), e.C0175e.fontsize28));
                al.c(this.gGG, e.d.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.aln != null && advertAppInfo.aln.adCloseInfo != null && advertAppInfo.aln.adCloseInfo.support_close.intValue() > 0) {
            this.gEZ.setVisibility(0);
            this.gEZ.setData(advertAppInfo);
        } else {
            this.gEZ.setVisibility(8);
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
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.ayN().ayO()) {
            this.gEK.setVisibility(0);
            al.j(this.gEK, e.d.cp_bg_line_d);
            return;
        }
        this.gEK.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.fey == 1;
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
        if (this.gIe != null) {
            this.gIe.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.gIc.setVisibility(8);
            return;
        }
        this.gIe = this.gIf.obtainHolder(adPost, this.gIc, this.gIe, this.ffy);
        if (this.gIe != null) {
            this.gIc.setVisibility(0);
            this.gIe.setVisibility(0);
            this.gIe.update(adPost);
            this.gIe.setAfterClickSchemeListener(this.ffx);
            this.gIe.setPageContext(this.mContext);
            return;
        }
        this.gIc.setVisibility(8);
    }

    public int getLayout() {
        return e.h.post_ad_card_base;
    }
}
