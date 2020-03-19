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
    private ThreadUserInfoLayout eNW;
    protected View fKI;
    private View fKL;
    protected View.OnClickListener fKP;
    private AdCloseView jJJ;
    private AdThreadCommentAndPraiseInfoLayout jJR;
    private ViewStub jJp;
    private View jJq;
    protected View jJr;
    private TextView jLu;
    private RelativeLayout jMQ;
    private AdPost jMR;
    protected AdOperateBarHolder jMS;
    protected final AdOperateBarCreator jMT;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void cO(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fKP = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.jMR != null) {
                    if ((AdPostBaseView.this.eNW.getUserName() == view || AdPostBaseView.this.eNW.getHeaderImg() == view) && AdPostBaseView.this.jMR.feedData.portraitClick != null) {
                        AdPostBaseView.this.n(3, AlaStaticKeys.ALA_STATIC_VALUE_ICON, AdPostBaseView.this.jMR.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.n(3, "hotarea", AdPostBaseView.this.jMR.feedData.scheme);
                }
            }
        };
        this.jMT = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        am.setBackgroundResource(this.rootView, R.drawable.addresslist_item_bg);
        this.jJR.onChangeSkinType();
        this.eNW.onChangeSkinType();
        if (this.jJJ != null) {
            this.jJJ.onChangeSkinType();
        }
        if (this.jMS != null) {
            this.jMS.onChangeSkinType();
        }
        am.setBackgroundColor(this.fKL, R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View ccz() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.fKP);
        this.jJr = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.jJr.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.fKL = this.rootView.findViewById(R.id.divider_line);
        this.fKI = this.rootView.findViewById(R.id.divider_line_above_praise);
        this.jJR = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.jJR.setStyle(2);
        this.eNW = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.jLu = (TextView) inflate.findViewById(R.id.feed_tag);
        this.jJJ = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.jJJ.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.jJJ != null && AdPostBaseView.this.jJJ.getVisibility() == 0) {
                    AdPostBaseView.this.jJJ.performClick();
                }
            }
        });
        this.eNW.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.cVv.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.jJR.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jJR.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.jJR.setLayoutParams(layoutParams2);
        }
        this.jJR.setBarNameClickEnabled(false);
        this.jJR.setReplyTimeVisible(false);
        this.jJR.setShowPraiseNum(true);
        this.jJR.setNeedAddPraiseIcon(true);
        this.jJR.setNeedAddReplyIcon(true);
        this.jJR.setShareVisible(true);
        this.jMQ = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.jMQ.setOnClickListener(this.fKP);
        this.jJp = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.jJp.setLayoutResource(getCustomLayout());
        this.jJq = this.jJp.inflate();
        cO(this.jJq);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.jMR.preloadLegoCardStr)) {
            str2 = HT(str2);
        }
        a.aYe().c(this.cVv.getPageActivity(), new String[]{str2});
        if (this.iaq != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.iaq.b(i, hashMap);
        }
    }

    private String HT(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + ETAG.EQUAL + URLEncoder.encode(this.jMR.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.jMR = adPost;
        this.eNW.setData(adPost.getAdvertAppInfo());
        this.jJR.setShareData(adPost);
        this.jJR.setCommentClickable(true);
        this.jJR.getCommentContainer().setOnClickListener(this.fKP);
        this.jJR.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.jLu.setVisibility(8);
        } else {
            this.jLu.setVisibility(0);
            this.jLu.setText(adPost.feedData.tag_name);
            this.jLu.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.jLu.setTextSize(0, l.getDimens(this.cVv.getPageActivity(), R.dimen.fontsize24));
                am.setViewTextColor(this.jLu, R.color.cp_cont_d, 1);
            } else {
                this.jLu.setTextSize(0, l.getDimens(this.cVv.getPageActivity(), R.dimen.fontsize28));
                am.setViewTextColor(this.jLu, R.color.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.cNt != null && advertAppInfo.cNt.adCloseInfo != null && advertAppInfo.cNt.adCloseInfo.support_close.intValue() > 0) {
            this.jJJ.setVisibility(0);
            this.jJJ.setData(advertAppInfo);
        } else {
            this.jJJ.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.eNW.getHeaderImg() != null) {
            if (advertAppInfo2.aCr() == null || advertAppInfo2.aCr().getPendantData() == null || StringUtils.isNull(advertAppInfo2.aCr().getPendantData().aAJ())) {
                this.eNW.getHeaderImg().setVisibility(0);
                this.eNW.getHeaderImg().setData(advertAppInfo2);
                this.eNW.getHeaderImg().setOnClickListener(this.fKP);
            } else {
                this.eNW.getHeaderImg().setVisibility(4);
            }
        }
        if (this.eNW.getUserName() != null) {
            this.eNW.getUserName().setOnClickListener(this.fKP);
        }
        com.baidu.tieba.card.l.a(this.mTitle, advertAppInfo2.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.l.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.fKI);
        am.setBackgroundColor(this.fKI, R.color.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bDd().bDe()) {
            this.jJr.setVisibility(0);
            am.setBackgroundColor(this.jJr, R.color.cp_bg_line_d);
            return;
        }
        this.jJr.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.hZu == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.azR().isShowImages() || adPost.feedData.cDh().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.jMS != null) {
            this.jMS.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.jMQ.setVisibility(8);
            return;
        }
        this.jMS = this.jMT.obtainHolder(adPost, this.jMQ, this.jMS, this.iar);
        if (this.jMS != null) {
            this.jMQ.setVisibility(0);
            this.jMS.setVisibility(0);
            this.jMS.update(adPost);
            this.jMS.setAfterClickSchemeListener(this.iaq);
            this.jMS.setPageContext(this.cVv);
            return;
        }
        this.jMQ.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
