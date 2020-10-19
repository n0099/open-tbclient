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
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.a;
import com.baidu.tieba.card.m;
import com.baidu.tieba.frs.b;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdOperateBarCreator;
import com.baidu.tieba.recapp.view.AdOperateBarHolder;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import com.baidu.webkit.internal.ETAG;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes26.dex */
public abstract class AdPostBaseView extends PostAdBaseView<AdPost> {
    private ThreadUserInfoLayout gAD;
    protected View hFK;
    private View hFN;
    protected View.OnClickListener hFR;
    private TextView mTitle;
    private AdCloseView mcI;
    private AdThreadCommentAndPraiseInfoLayout mcP;
    private ViewStub mcp;
    private View mcq;
    protected View mcr;
    private TextView mee;
    private RelativeLayout mfu;
    private AdPost mfv;
    protected AdOperateBarHolder mfw;
    protected final AdOperateBarCreator mfx;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void du(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hFR = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.mfv != null) {
                    if ((AdPostBaseView.this.gAD.getUserName() == view || AdPostBaseView.this.gAD.getHeaderImg() == view) && AdPostBaseView.this.mfv.feedData.portraitClick != null) {
                        AdPostBaseView.this.p(3, AlaStaticKeys.ALA_STATIC_VALUE_ICON, AdPostBaseView.this.mfv.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.p(3, "hotarea", AdPostBaseView.this.mfv.feedData.scheme);
                }
            }
        };
        this.mfx = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        ap.setBackgroundResource(this.rootView, R.drawable.addresslist_item_bg);
        this.mcP.onChangeSkinType();
        this.gAD.onChangeSkinType();
        if (this.mcI != null) {
            this.mcI.onChangeSkinType();
        }
        if (this.mfw != null) {
            this.mfw.onChangeSkinType();
        }
        ap.setBackgroundColor(this.hFN, R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View cTG() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.hFR);
        this.mcr = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.mcr.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.hFN = this.rootView.findViewById(R.id.divider_line);
        this.hFK = this.rootView.findViewById(R.id.divider_line_above_praise);
        this.mcP = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.mcP.setStyle(2);
        this.gAD = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mee = (TextView) inflate.findViewById(R.id.feed_tag);
        this.mcI = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.mcI.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.mcI != null && AdPostBaseView.this.mcI.getVisibility() == 0) {
                    AdPostBaseView.this.mcI.performClick();
                }
            }
        });
        this.gAD.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.etO.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.mcP.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mcP.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.mcP.setLayoutParams(layoutParams2);
        }
        this.mcP.setBarNameClickEnabled(false);
        this.mcP.setReplyTimeVisible(false);
        this.mcP.setShowPraiseNum(true);
        this.mcP.setNeedAddPraiseIcon(true);
        this.mcP.setNeedAddReplyIcon(true);
        this.mcP.setShareVisible(true);
        this.mfu = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.mfu.setOnClickListener(this.hFR);
        this.mcp = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.mcp.setLayoutResource(getCustomLayout());
        this.mcq = this.mcp.inflate();
        du(this.mcq);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.mfv.preloadLegoCardStr)) {
            str2 = QJ(str2);
        }
        a.bES().c(this.etO.getPageActivity(), new String[]{str2});
        if (this.knj != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.knj.d(i, hashMap);
        }
    }

    private String QJ(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + ETAG.EQUAL + URLEncoder.encode(this.mfv.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.mfv = adPost;
        this.gAD.setData(adPost.getAdvertAppInfo());
        this.mcP.setShareData(adPost);
        this.mcP.setCommentClickable(true);
        this.mcP.getCommentContainer().setOnClickListener(this.hFR);
        this.mcP.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.mee.setVisibility(8);
        } else {
            this.mee.setVisibility(0);
            this.mee.setText(adPost.feedData.tag_name);
            this.mee.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.mee.setTextSize(0, l.getDimens(this.etO.getPageActivity(), R.dimen.fontsize24));
                ap.setViewTextColor(this.mee, R.color.cp_cont_d, 1);
            } else {
                this.mee.setTextSize(0, l.getDimens(this.etO.getPageActivity(), R.dimen.fontsize28));
                ap.setViewTextColor(this.mee, R.color.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.ekE != null && advertAppInfo.ekE.adCloseInfo != null && advertAppInfo.ekE.adCloseInfo.support_close.intValue() > 0) {
            this.mcI.setVisibility(0);
            this.mcI.setData(advertAppInfo);
        } else {
            this.mcI.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.gAD.getHeaderImg() != null) {
            if (advertAppInfo2.bih() == null || advertAppInfo2.bih().getPendantData() == null || StringUtils.isNull(advertAppInfo2.bih().getPendantData().bgd())) {
                this.gAD.getHeaderImg().setVisibility(0);
                this.gAD.getHeaderImg().setData(advertAppInfo2);
                this.gAD.getHeaderImg().setOnClickListener(this.hFR);
            } else {
                this.gAD.getHeaderImg().setVisibility(4);
            }
        }
        if (this.gAD.getUserName() != null) {
            this.gAD.getUserName().setOnClickListener(this.hFR);
        }
        m.a(this.mTitle, advertAppInfo2.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
        m.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.hFK);
        ap.setBackgroundColor(this.hFK, R.color.cp_bg_line_e);
        if ((b.crE().cry() || com.baidu.tieba.frs.a.crx().cry()) && isInFrsAllThread()) {
            this.mcr.setVisibility(0);
            ap.setBackgroundColor(this.mcr, R.color.cp_bg_line_d);
            return;
        }
        this.mcr.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!k.bfo().isShowImages() || adPost.feedData.duW().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.mfw != null) {
            this.mfw.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.mfu.setVisibility(8);
            return;
        }
        this.mfw = this.mfx.obtainHolder(adPost, this.mfu, this.mfw, this.knk);
        if (this.mfw != null) {
            this.mfu.setVisibility(0);
            this.mfw.setVisibility(0);
            this.mfw.update(adPost);
            this.mfw.setAfterClickSchemeListener(this.knj);
            this.mfw.setPageContext(this.etO);
            return;
        }
        this.mfu.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
