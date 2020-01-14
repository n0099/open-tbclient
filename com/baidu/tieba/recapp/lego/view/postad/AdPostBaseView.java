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
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.a;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdOperateBarCreator;
import com.baidu.tieba.recapp.view.AdOperateBarHolder;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import com.baidu.webkit.internal.ETAG;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes11.dex */
public abstract class AdPostBaseView extends PostAdBaseView<AdPost> {
    private ThreadUserInfoLayout eJq;
    protected View fHo;
    private View fHr;
    protected View.OnClickListener fHv;
    private ViewStub jGL;
    private View jGM;
    protected View jGN;
    private AdCloseView jHb;
    private AdThreadCommentAndPraiseInfoLayout jHj;
    private TextView jII;
    private RelativeLayout jKe;
    private AdPost jKf;
    protected AdOperateBarHolder jKg;
    protected final AdOperateBarCreator jKh;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void cN(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fHv = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.jKf != null) {
                    if ((AdPostBaseView.this.eJq.getUserName() == view || AdPostBaseView.this.eJq.getHeaderImg() == view) && AdPostBaseView.this.jKf.feedData.portraitClick != null) {
                        AdPostBaseView.this.n(3, AlaStaticKeys.ALA_STATIC_VALUE_ICON, AdPostBaseView.this.jKf.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.n(3, "hotarea", AdPostBaseView.this.jKf.feedData.scheme);
                }
            }
        };
        this.jKh = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        am.setBackgroundResource(this.rootView, R.drawable.addresslist_item_bg);
        this.jHj.onChangeSkinType();
        this.eJq.onChangeSkinType();
        if (this.jHb != null) {
            this.jHb.onChangeSkinType();
        }
        if (this.jKg != null) {
            this.jKg.onChangeSkinType();
        }
        am.setBackgroundColor(this.fHr, R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View caC() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.fHv);
        this.jGN = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.jGN.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.fHr = this.rootView.findViewById(R.id.divider_line);
        this.fHo = this.rootView.findViewById(R.id.divider_line_above_praise);
        this.jHj = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.jHj.setStyle(2);
        this.eJq = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.jII = (TextView) inflate.findViewById(R.id.feed_tag);
        this.jHb = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.jHb.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.jHb != null && AdPostBaseView.this.jHb.getVisibility() == 0) {
                    AdPostBaseView.this.jHb.performClick();
                }
            }
        });
        this.eJq.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.cRe.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.jHj.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jHj.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.jHj.setLayoutParams(layoutParams2);
        }
        this.jHj.setBarNameClickEnabled(false);
        this.jHj.setReplyTimeVisible(false);
        this.jHj.setShowPraiseNum(true);
        this.jHj.setNeedAddPraiseIcon(true);
        this.jHj.setNeedAddReplyIcon(true);
        this.jHj.setShareVisible(true);
        this.jKe = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.jKe.setOnClickListener(this.fHv);
        this.jGL = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.jGL.setLayoutResource(getCustomLayout());
        this.jGM = this.jGL.inflate();
        cN(this.jGM);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.jKf.preloadLegoCardStr)) {
            str2 = HE(str2);
        }
        a.aVI().c(this.cRe.getPageActivity(), new String[]{str2});
        if (this.hWE != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.hWE.b(i, hashMap);
        }
    }

    private String HE(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + ETAG.EQUAL + URLEncoder.encode(this.jKf.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.jKf = adPost;
        this.eJq.setData(adPost.getAdvertAppInfo());
        this.jHj.setShareData(adPost);
        this.jHj.setCommentClickable(true);
        this.jHj.getCommentContainer().setOnClickListener(this.fHv);
        this.jHj.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.jII.setVisibility(8);
        } else {
            this.jII.setVisibility(0);
            this.jII.setText(adPost.feedData.tag_name);
            this.jII.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.jII.setTextSize(0, l.getDimens(this.cRe.getPageActivity(), R.dimen.fontsize24));
                am.setViewTextColor(this.jII, R.color.cp_cont_d, 1);
            } else {
                this.jII.setTextSize(0, l.getDimens(this.cRe.getPageActivity(), R.dimen.fontsize28));
                am.setViewTextColor(this.jII, R.color.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.cJb != null && advertAppInfo.cJb.adCloseInfo != null && advertAppInfo.cJb.adCloseInfo.support_close.intValue() > 0) {
            this.jHb.setVisibility(0);
            this.jHb.setData(advertAppInfo);
        } else {
            this.jHb.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.eJq.getHeaderImg() != null) {
            if (advertAppInfo2.azX() == null || advertAppInfo2.azX().getPendantData() == null || StringUtils.isNull(advertAppInfo2.azX().getPendantData().ayq())) {
                this.eJq.getHeaderImg().setVisibility(0);
                this.eJq.getHeaderImg().setData(advertAppInfo2);
                this.eJq.getHeaderImg().setOnClickListener(this.fHv);
            } else {
                this.eJq.getHeaderImg().setVisibility(4);
            }
        }
        if (this.eJq.getUserName() != null) {
            this.eJq.getUserName().setOnClickListener(this.fHv);
        }
        com.baidu.tieba.card.l.a(this.mTitle, advertAppInfo2.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.l.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.fHo);
        am.setBackgroundColor(this.fHo, R.color.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bBr().bBs()) {
            this.jGN.setVisibility(0);
            am.setBackgroundColor(this.jGN, R.color.cp_bg_line_d);
            return;
        }
        this.jGN.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.hVI == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.axy().isShowImages() || adPost.feedData.cBo().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.jKg != null) {
            this.jKg.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.jKe.setVisibility(8);
            return;
        }
        this.jKg = this.jKh.obtainHolder(adPost, this.jKe, this.jKg, this.hWF);
        if (this.jKg != null) {
            this.jKe.setVisibility(0);
            this.jKg.setVisibility(0);
            this.jKg.update(adPost);
            this.jKg.setAfterClickSchemeListener(this.hWE);
            this.jKg.setPageContext(this.cRe);
            return;
        }
        this.jKe.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
