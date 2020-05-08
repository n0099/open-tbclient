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
    private ThreadUserInfoLayout fsv;
    protected View.OnClickListener gpC;
    protected View gpv;
    private View gpy;
    private AdThreadCommentAndPraiseInfoLayout ktH;
    private ViewStub ktf;
    private View ktg;
    protected View kth;
    private AdCloseView ktz;
    private TextView kuV;
    private RelativeLayout kwk;
    private AdPost kwl;
    protected AdOperateBarHolder kwm;
    protected final AdOperateBarCreator kwn;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void cW(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gpC = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.kwl != null) {
                    if ((AdPostBaseView.this.fsv.getUserName() == view || AdPostBaseView.this.fsv.getHeaderImg() == view) && AdPostBaseView.this.kwl.feedData.portraitClick != null) {
                        AdPostBaseView.this.o(3, AlaStaticKeys.ALA_STATIC_VALUE_ICON, AdPostBaseView.this.kwl.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.o(3, "hotarea", AdPostBaseView.this.kwl.feedData.scheme);
                }
            }
        };
        this.kwn = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        am.setBackgroundResource(this.rootView, R.drawable.addresslist_item_bg);
        this.ktH.onChangeSkinType();
        this.fsv.onChangeSkinType();
        if (this.ktz != null) {
            this.ktz.onChangeSkinType();
        }
        if (this.kwm != null) {
            this.kwm.onChangeSkinType();
        }
        am.setBackgroundColor(this.gpy, R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View cmX() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.gpC);
        this.kth = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.kth.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.gpy = this.rootView.findViewById(R.id.divider_line);
        this.gpv = this.rootView.findViewById(R.id.divider_line_above_praise);
        this.ktH = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.ktH.setStyle(2);
        this.fsv = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.kuV = (TextView) inflate.findViewById(R.id.feed_tag);
        this.ktz = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.ktz.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.ktz != null && AdPostBaseView.this.ktz.getVisibility() == 0) {
                    AdPostBaseView.this.ktz.performClick();
                }
            }
        });
        this.fsv.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.duK.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.ktH.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ktH.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.ktH.setLayoutParams(layoutParams2);
        }
        this.ktH.setBarNameClickEnabled(false);
        this.ktH.setReplyTimeVisible(false);
        this.ktH.setShowPraiseNum(true);
        this.ktH.setNeedAddPraiseIcon(true);
        this.ktH.setNeedAddReplyIcon(true);
        this.ktH.setShareVisible(true);
        this.kwk = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.kwk.setOnClickListener(this.gpC);
        this.ktf = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.ktf.setLayoutResource(getCustomLayout());
        this.ktg = this.ktf.inflate();
        cW(this.ktg);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.kwl.preloadLegoCardStr)) {
            str2 = JA(str2);
        }
        a.bgh().c(this.duK.getPageActivity(), new String[]{str2});
        if (this.iKo != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.iKo.d(i, hashMap);
        }
    }

    private String JA(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + ETAG.EQUAL + URLEncoder.encode(this.kwl.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.kwl = adPost;
        this.fsv.setData(adPost.getAdvertAppInfo());
        this.ktH.setShareData(adPost);
        this.ktH.setCommentClickable(true);
        this.ktH.getCommentContainer().setOnClickListener(this.gpC);
        this.ktH.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.kuV.setVisibility(8);
        } else {
            this.kuV.setVisibility(0);
            this.kuV.setText(adPost.feedData.tag_name);
            this.kuV.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.kuV.setTextSize(0, l.getDimens(this.duK.getPageActivity(), R.dimen.fontsize24));
                am.setViewTextColor(this.kuV, R.color.cp_cont_d, 1);
            } else {
                this.kuV.setTextSize(0, l.getDimens(this.duK.getPageActivity(), R.dimen.fontsize28));
                am.setViewTextColor(this.kuV, R.color.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.dmB != null && advertAppInfo.dmB.adCloseInfo != null && advertAppInfo.dmB.adCloseInfo.support_close.intValue() > 0) {
            this.ktz.setVisibility(0);
            this.ktz.setData(advertAppInfo);
        } else {
            this.ktz.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.fsv.getHeaderImg() != null) {
            if (advertAppInfo2.aKC() == null || advertAppInfo2.aKC().getPendantData() == null || StringUtils.isNull(advertAppInfo2.aKC().getPendantData().aIU())) {
                this.fsv.getHeaderImg().setVisibility(0);
                this.fsv.getHeaderImg().setData(advertAppInfo2);
                this.fsv.getHeaderImg().setOnClickListener(this.gpC);
            } else {
                this.fsv.getHeaderImg().setVisibility(4);
            }
        }
        if (this.fsv.getUserName() != null) {
            this.fsv.getUserName().setOnClickListener(this.gpC);
        }
        com.baidu.tieba.card.l.a(this.mTitle, advertAppInfo2.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.l.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.gpv);
        am.setBackgroundColor(this.gpv, R.color.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bNB().bNC()) {
            this.kth.setVisibility(0);
            am.setBackgroundColor(this.kth, R.color.cp_bg_line_d);
            return;
        }
        this.kth.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.aIc().isShowImages() || adPost.feedData.cNC().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.kwm != null) {
            this.kwm.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.kwk.setVisibility(8);
            return;
        }
        this.kwm = this.kwn.obtainHolder(adPost, this.kwk, this.kwm, this.iKp);
        if (this.kwm != null) {
            this.kwk.setVisibility(0);
            this.kwm.setVisibility(0);
            this.kwm.update(adPost);
            this.kwm.setAfterClickSchemeListener(this.iKo);
            this.kwm.setPageContext(this.duK);
            return;
        }
        this.kwk.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
