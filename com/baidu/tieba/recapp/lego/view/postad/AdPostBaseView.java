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
    private View cSr;
    protected View.OnClickListener cSt;
    protected View cUY;
    private ThreadUserInfoLayout caI;
    private ViewStub gMZ;
    private View gNa;
    protected View gNb;
    private AdCloseView gNq;
    private AdThreadCommentAndPraiseInfoLayout gNy;
    private TextView gOX;
    private RelativeLayout gQt;
    private AdPost gQu;
    protected AdOperateBarHolder gQv;
    protected final AdOperateBarCreator gQw;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void bN(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.cSt = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.gQu != null) {
                    if ((AdPostBaseView.this.caI.getUserName() == view || AdPostBaseView.this.caI.getHeaderImg() == view) && AdPostBaseView.this.gQu.feedData.portraitClick != null) {
                        AdPostBaseView.this.l(3, AiAppUnitedSchemeUtilsDispatcher.PARAM_TOAST_ICON_KEY, AdPostBaseView.this.gQu.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.l(3, "hotarea", AdPostBaseView.this.gQu.feedData.scheme);
                }
            }
        };
        this.gQw = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        al.i(this.rootView, e.f.addresslist_item_bg);
        this.gNy.onChangeSkinType();
        this.caI.onChangeSkinType();
        if (this.gNq != null) {
            this.gNq.onChangeSkinType();
        }
        if (this.gQv != null) {
            this.gQv.onChangeSkinType();
        }
        al.j(this.cSr, e.d.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View aYk() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.cSt);
        this.gNb = this.rootView.findViewById(e.g.thread_multi_del_ad_mask_view);
        this.gNb.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(e.g.card_home_page_normal_thread_title);
        this.cSr = this.rootView.findViewById(e.g.divider_line);
        this.cUY = this.rootView.findViewById(e.g.divider_line_above_praise);
        this.gNy = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(e.g.card_home_page_normal_thread_info_layout);
        this.gNy.setStyle(2);
        this.caI = (ThreadUserInfoLayout) this.rootView.findViewById(e.g.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(e.h.ad_post_tag_close, (ViewGroup) null);
        this.gOX = (TextView) inflate.findViewById(e.g.feed_tag);
        this.gNq = (AdCloseView) inflate.findViewById(e.g.ad_close_view);
        this.gNq.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.gNq != null && AdPostBaseView.this.gNq.getVisibility() == 0) {
                    AdPostBaseView.this.gNq.performClick();
                }
            }
        });
        this.caI.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(e.C0210e.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.gNy.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gNy.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.gNy.setLayoutParams(layoutParams2);
        }
        this.gNy.setBarNameClickEnabled(false);
        this.gNy.setReplyTimeVisible(false);
        this.gNy.setShowPraiseNum(true);
        this.gNy.setNeedAddPraiseIcon(true);
        this.gNy.setNeedAddReplyIcon(true);
        this.gNy.setShareVisible(true);
        this.gQt = (RelativeLayout) this.rootView.findViewById(e.g.ad_operate_area);
        this.gQt.setOnClickListener(this.cSt);
        this.gMZ = (ViewStub) this.rootView.findViewById(e.g.ad_custom_view_stub);
        this.gMZ.setLayoutResource(getCustomLayout());
        this.gNa = this.gMZ.inflate();
        bN(this.gNa);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.gQu.preloadLegoCardStr)) {
            str2 = uE(str2);
        }
        a.Wg().d(this.mContext.getPageActivity(), new String[]{str2});
        if (this.fnI != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.fnI.b(i, hashMap);
        }
    }

    private String uE(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + ETAG.EQUAL + URLEncoder.encode(this.gQu.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.gQu = adPost;
        this.caI.setData(adPost.getAdvertAppInfo());
        this.gNy.setShareData(adPost);
        this.gNy.setCommentClickable(true);
        this.gNy.getCommentContainer().setOnClickListener(this.cSt);
        this.gNy.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.gOX.setVisibility(8);
        } else {
            this.gOX.setVisibility(0);
            this.gOX.setText(adPost.feedData.tag_name);
            this.gOX.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.gOX.setTextSize(0, l.h(this.mContext.getPageActivity(), e.C0210e.fontsize24));
                al.c(this.gOX, e.d.cp_cont_d, 1);
            } else {
                this.gOX.setTextSize(0, l.h(this.mContext.getPageActivity(), e.C0210e.fontsize28));
                al.c(this.gOX, e.d.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.apB != null && advertAppInfo.apB.adCloseInfo != null && advertAppInfo.apB.adCloseInfo.support_close.intValue() > 0) {
            this.gNq.setVisibility(0);
            this.gNq.setData(advertAppInfo);
        } else {
            this.gNq.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.caI.getHeaderImg() != null) {
            if (advertAppInfo2.zG() == null || advertAppInfo2.zG().getPendantData() == null || StringUtils.isNull(advertAppInfo2.zG().getPendantData().ys())) {
                this.caI.getHeaderImg().setVisibility(0);
                this.caI.getHeaderImg().setData(advertAppInfo2);
                this.caI.getHeaderImg().setOnClickListener(this.cSt);
            } else {
                this.caI.getHeaderImg().setVisibility(4);
            }
        }
        if (this.caI.getUserName() != null) {
            this.caI.getUserName().setOnClickListener(this.cSt);
        }
        o.a(this.mTitle, advertAppInfo2.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
        o.b(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.cUY);
        al.j(this.cUY, e.d.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.azU().azV()) {
            this.gNb.setVisibility(0);
            al.j(this.gNb, e.d.cp_bg_line_d);
            return;
        }
        this.gNb.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.fmJ == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.xE().xI() || adPost.feedData.buQ().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.gQv != null) {
            this.gQv.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.gQt.setVisibility(8);
            return;
        }
        this.gQv = this.gQw.obtainHolder(adPost, this.gQt, this.gQv, this.fnJ);
        if (this.gQv != null) {
            this.gQt.setVisibility(0);
            this.gQv.setVisibility(0);
            this.gQv.update(adPost);
            this.gQv.setAfterClickSchemeListener(this.fnI);
            this.gQv.setPageContext(this.mContext);
            return;
        }
        this.gQt.setVisibility(8);
    }

    public int getLayout() {
        return e.h.post_ad_card_base;
    }
}
