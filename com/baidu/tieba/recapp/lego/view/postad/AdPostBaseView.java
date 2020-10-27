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
import com.baidu.tieba.card.n;
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
    private ThreadUserInfoLayout gMr;
    protected View hSh;
    private View hSk;
    protected View.OnClickListener hSo;
    private TextView mTitle;
    private ViewStub moO;
    private View moP;
    protected View moQ;
    private AdCloseView mph;
    private AdThreadCommentAndPraiseInfoLayout mpo;
    private TextView mqD;
    private RelativeLayout mrS;
    private AdPost mrT;
    protected AdOperateBarHolder mrU;
    protected final AdOperateBarCreator mrV;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void dy(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hSo = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.mrT != null) {
                    if ((AdPostBaseView.this.gMr.getUserName() == view || AdPostBaseView.this.gMr.getHeaderImg() == view) && AdPostBaseView.this.mrT.feedData.portraitClick != null) {
                        AdPostBaseView.this.p(3, AlaStaticKeys.ALA_STATIC_VALUE_ICON, AdPostBaseView.this.mrT.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.p(3, "hotarea", AdPostBaseView.this.mrT.feedData.scheme);
                }
            }
        };
        this.mrV = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        ap.setBackgroundResource(this.rootView, R.drawable.addresslist_item_bg);
        this.mpo.onChangeSkinType();
        this.gMr.onChangeSkinType();
        if (this.mph != null) {
            this.mph.onChangeSkinType();
        }
        if (this.mrU != null) {
            this.mrU.onChangeSkinType();
        }
        ap.setBackgroundColor(this.hSk, R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View cWN() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.hSo);
        this.moQ = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.moQ.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.hSk = this.rootView.findViewById(R.id.divider_line);
        this.hSh = this.rootView.findViewById(R.id.divider_line_above_praise);
        this.mpo = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.mpo.setStyle(2);
        this.gMr = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mqD = (TextView) inflate.findViewById(R.id.feed_tag);
        this.mph = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.mph.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.mph != null && AdPostBaseView.this.mph.getVisibility() == 0) {
                    AdPostBaseView.this.mph.performClick();
                }
            }
        });
        this.gMr.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.eCn.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.mpo.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mpo.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.mpo.setLayoutParams(layoutParams2);
        }
        this.mpo.setBarNameClickEnabled(false);
        this.mpo.setReplyTimeVisible(false);
        this.mpo.setShowPraiseNum(true);
        this.mpo.setNeedAddPraiseIcon(true);
        this.mpo.setNeedAddReplyIcon(true);
        this.mpo.setShareVisible(true);
        this.mrS = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.mrS.setOnClickListener(this.hSo);
        this.moO = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.moO.setLayoutResource(getCustomLayout());
        this.moP = this.moO.inflate();
        dy(this.moP);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.mrT.preloadLegoCardStr)) {
            str2 = Rh(str2);
        }
        a.bGL().c(this.eCn.getPageActivity(), new String[]{str2});
        if (this.kzG != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.kzG.d(i, hashMap);
        }
    }

    private String Rh(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + ETAG.EQUAL + URLEncoder.encode(this.mrT.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.mrT = adPost;
        this.gMr.setData(adPost.getAdvertAppInfo());
        this.mpo.setShareData(adPost);
        this.mpo.setCommentClickable(true);
        this.mpo.getCommentContainer().setOnClickListener(this.hSo);
        this.mpo.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.mqD.setVisibility(8);
        } else {
            this.mqD.setVisibility(0);
            this.mqD.setText(adPost.feedData.tag_name);
            this.mqD.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.mqD.setTextSize(0, l.getDimens(this.eCn.getPageActivity(), R.dimen.fontsize24));
                ap.setViewTextColor(this.mqD, R.color.cp_cont_d, 1);
            } else {
                this.mqD.setTextSize(0, l.getDimens(this.eCn.getPageActivity(), R.dimen.fontsize28));
                ap.setViewTextColor(this.mqD, R.color.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.ete != null && advertAppInfo.ete.adCloseInfo != null && advertAppInfo.ete.adCloseInfo.support_close.intValue() > 0) {
            this.mph.setVisibility(0);
            this.mph.setData(advertAppInfo);
        } else {
            this.mph.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.gMr.getHeaderImg() != null) {
            if (advertAppInfo2.bka() == null || advertAppInfo2.bka().getPendantData() == null || StringUtils.isNull(advertAppInfo2.bka().getPendantData().bhW())) {
                this.gMr.getHeaderImg().setVisibility(0);
                this.gMr.getHeaderImg().setData(advertAppInfo2);
                this.gMr.getHeaderImg().setOnClickListener(this.hSo);
            } else {
                this.gMr.getHeaderImg().setVisibility(4);
            }
        }
        if (this.gMr.getUserName() != null) {
            this.gMr.getUserName().setOnClickListener(this.hSo);
        }
        n.a(this.mTitle, advertAppInfo2.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
        n.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.hSh);
        ap.setBackgroundColor(this.hSh, R.color.cp_bg_line_e);
        if ((b.cuL().cuF() || com.baidu.tieba.frs.a.cuE().cuF()) && isInFrsAllThread()) {
            this.moQ.setVisibility(0);
            ap.setBackgroundColor(this.moQ, R.color.cp_bg_line_d);
            return;
        }
        this.moQ.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!k.bhh().isShowImages() || adPost.feedData.dyd().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.mrU != null) {
            this.mrU.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.mrS.setVisibility(8);
            return;
        }
        this.mrU = this.mrV.obtainHolder(adPost, this.mrS, this.mrU, this.kzH);
        if (this.mrU != null) {
            this.mrS.setVisibility(0);
            this.mrU.setVisibility(0);
            this.mrU.update(adPost);
            this.mrU.setAfterClickSchemeListener(this.kzG);
            this.mrU.setPageContext(this.eCn);
            return;
        }
        this.mrS.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
