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
/* loaded from: classes13.dex */
public abstract class AdPostBaseView extends PostAdBaseView<AdPost> {
    private ThreadUserInfoLayout fsq;
    protected View gpp;
    private View gps;
    protected View.OnClickListener gpw;
    private AdThreadCommentAndPraiseInfoLayout ktD;
    private ViewStub ktb;
    private View ktc;
    protected View ktd;
    private AdCloseView ktv;
    private TextView kuR;
    private RelativeLayout kwg;
    private AdPost kwh;
    protected AdOperateBarHolder kwi;
    protected final AdOperateBarCreator kwj;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void cW(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gpw = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.kwh != null) {
                    if ((AdPostBaseView.this.fsq.getUserName() == view || AdPostBaseView.this.fsq.getHeaderImg() == view) && AdPostBaseView.this.kwh.feedData.portraitClick != null) {
                        AdPostBaseView.this.o(3, AlaStaticKeys.ALA_STATIC_VALUE_ICON, AdPostBaseView.this.kwh.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.o(3, "hotarea", AdPostBaseView.this.kwh.feedData.scheme);
                }
            }
        };
        this.kwj = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        am.setBackgroundResource(this.rootView, R.drawable.addresslist_item_bg);
        this.ktD.onChangeSkinType();
        this.fsq.onChangeSkinType();
        if (this.ktv != null) {
            this.ktv.onChangeSkinType();
        }
        if (this.kwi != null) {
            this.kwi.onChangeSkinType();
        }
        am.setBackgroundColor(this.gps, R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View cna() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.gpw);
        this.ktd = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.ktd.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.gps = this.rootView.findViewById(R.id.divider_line);
        this.gpp = this.rootView.findViewById(R.id.divider_line_above_praise);
        this.ktD = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.ktD.setStyle(2);
        this.fsq = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.kuR = (TextView) inflate.findViewById(R.id.feed_tag);
        this.ktv = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.ktv.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.ktv != null && AdPostBaseView.this.ktv.getVisibility() == 0) {
                    AdPostBaseView.this.ktv.performClick();
                }
            }
        });
        this.fsq.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.duG.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.ktD.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ktD.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.ktD.setLayoutParams(layoutParams2);
        }
        this.ktD.setBarNameClickEnabled(false);
        this.ktD.setReplyTimeVisible(false);
        this.ktD.setShowPraiseNum(true);
        this.ktD.setNeedAddPraiseIcon(true);
        this.ktD.setNeedAddReplyIcon(true);
        this.ktD.setShareVisible(true);
        this.kwg = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.kwg.setOnClickListener(this.gpw);
        this.ktb = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.ktb.setLayoutResource(getCustomLayout());
        this.ktc = this.ktb.inflate();
        cW(this.ktc);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.kwh.preloadLegoCardStr)) {
            str2 = Jx(str2);
        }
        a.bgj().c(this.duG.getPageActivity(), new String[]{str2});
        if (this.iKk != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.iKk.d(i, hashMap);
        }
    }

    private String Jx(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + ETAG.EQUAL + URLEncoder.encode(this.kwh.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.kwh = adPost;
        this.fsq.setData(adPost.getAdvertAppInfo());
        this.ktD.setShareData(adPost);
        this.ktD.setCommentClickable(true);
        this.ktD.getCommentContainer().setOnClickListener(this.gpw);
        this.ktD.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.kuR.setVisibility(8);
        } else {
            this.kuR.setVisibility(0);
            this.kuR.setText(adPost.feedData.tag_name);
            this.kuR.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.kuR.setTextSize(0, l.getDimens(this.duG.getPageActivity(), R.dimen.fontsize24));
                am.setViewTextColor(this.kuR, R.color.cp_cont_d, 1);
            } else {
                this.kuR.setTextSize(0, l.getDimens(this.duG.getPageActivity(), R.dimen.fontsize28));
                am.setViewTextColor(this.kuR, R.color.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.dmx != null && advertAppInfo.dmx.adCloseInfo != null && advertAppInfo.dmx.adCloseInfo.support_close.intValue() > 0) {
            this.ktv.setVisibility(0);
            this.ktv.setData(advertAppInfo);
        } else {
            this.ktv.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.fsq.getHeaderImg() != null) {
            if (advertAppInfo2.aKE() == null || advertAppInfo2.aKE().getPendantData() == null || StringUtils.isNull(advertAppInfo2.aKE().getPendantData().aIW())) {
                this.fsq.getHeaderImg().setVisibility(0);
                this.fsq.getHeaderImg().setData(advertAppInfo2);
                this.fsq.getHeaderImg().setOnClickListener(this.gpw);
            } else {
                this.fsq.getHeaderImg().setVisibility(4);
            }
        }
        if (this.fsq.getUserName() != null) {
            this.fsq.getUserName().setOnClickListener(this.gpw);
        }
        com.baidu.tieba.card.l.a(this.mTitle, advertAppInfo2.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.l.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.gpp);
        am.setBackgroundColor(this.gpp, R.color.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bND().bNE()) {
            this.ktd.setVisibility(0);
            am.setBackgroundColor(this.ktd, R.color.cp_bg_line_d);
            return;
        }
        this.ktd.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.aIe().isShowImages() || adPost.feedData.cNF().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.kwi != null) {
            this.kwi.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.kwg.setVisibility(8);
            return;
        }
        this.kwi = this.kwj.obtainHolder(adPost, this.kwg, this.kwi, this.iKl);
        if (this.kwi != null) {
            this.kwg.setVisibility(0);
            this.kwi.setVisibility(0);
            this.kwi.update(adPost);
            this.kwi.setAfterClickSchemeListener(this.iKk);
            this.kwi.setPageContext(this.duG);
            return;
        }
        this.kwg.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
