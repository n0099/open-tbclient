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
/* loaded from: classes20.dex */
public abstract class AdPostBaseView extends PostAdBaseView<AdPost> {
    private ThreadUserInfoLayout giZ;
    protected View hjJ;
    private View hjM;
    protected View.OnClickListener hjQ;
    private ViewStub lDT;
    private View lDU;
    protected View lDV;
    private AdCloseView lEm;
    private AdThreadCommentAndPraiseInfoLayout lEt;
    private TextView lFG;
    private RelativeLayout lGV;
    private AdPost lGW;
    protected AdOperateBarHolder lGX;
    protected final AdOperateBarCreator lGY;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void di(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hjQ = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.lGW != null) {
                    if ((AdPostBaseView.this.giZ.getUserName() == view || AdPostBaseView.this.giZ.getHeaderImg() == view) && AdPostBaseView.this.lGW.feedData.portraitClick != null) {
                        AdPostBaseView.this.o(3, AlaStaticKeys.ALA_STATIC_VALUE_ICON, AdPostBaseView.this.lGW.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.o(3, "hotarea", AdPostBaseView.this.lGW.feedData.scheme);
                }
            }
        };
        this.lGY = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        ap.setBackgroundResource(this.rootView, R.drawable.addresslist_item_bg);
        this.lEt.onChangeSkinType();
        this.giZ.onChangeSkinType();
        if (this.lEm != null) {
            this.lEm.onChangeSkinType();
        }
        if (this.lGX != null) {
            this.lGX.onChangeSkinType();
        }
        ap.setBackgroundColor(this.hjM, R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View cMp() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.hjQ);
        this.lDV = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.lDV.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.hjM = this.rootView.findViewById(R.id.divider_line);
        this.hjJ = this.rootView.findViewById(R.id.divider_line_above_praise);
        this.lEt = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.lEt.setStyle(2);
        this.giZ = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.lFG = (TextView) inflate.findViewById(R.id.feed_tag);
        this.lEm = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.lEm.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.lEm != null && AdPostBaseView.this.lEm.getVisibility() == 0) {
                    AdPostBaseView.this.lEm.performClick();
                }
            }
        });
        this.giZ.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.efn.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.lEt.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lEt.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.lEt.setLayoutParams(layoutParams2);
        }
        this.lEt.setBarNameClickEnabled(false);
        this.lEt.setReplyTimeVisible(false);
        this.lEt.setShowPraiseNum(true);
        this.lEt.setNeedAddPraiseIcon(true);
        this.lEt.setNeedAddReplyIcon(true);
        this.lEt.setShareVisible(true);
        this.lGV = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.lGV.setOnClickListener(this.hjQ);
        this.lDT = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.lDT.setLayoutResource(getCustomLayout());
        this.lDU = this.lDT.inflate();
        di(this.lDU);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.lGW.preloadLegoCardStr)) {
            str2 = Pu(str2);
        }
        a.bAT().c(this.efn.getPageActivity(), new String[]{str2});
        if (this.jPk != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.jPk.d(i, hashMap);
        }
    }

    private String Pu(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + ETAG.EQUAL + URLEncoder.encode(this.lGW.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.lGW = adPost;
        this.giZ.setData(adPost.getAdvertAppInfo());
        this.lEt.setShareData(adPost);
        this.lEt.setCommentClickable(true);
        this.lEt.getCommentContainer().setOnClickListener(this.hjQ);
        this.lEt.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.lFG.setVisibility(8);
        } else {
            this.lFG.setVisibility(0);
            this.lFG.setText(adPost.feedData.tag_name);
            this.lFG.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.lFG.setTextSize(0, l.getDimens(this.efn.getPageActivity(), R.dimen.fontsize24));
                ap.setViewTextColor(this.lFG, R.color.cp_cont_d, 1);
            } else {
                this.lFG.setTextSize(0, l.getDimens(this.efn.getPageActivity(), R.dimen.fontsize28));
                ap.setViewTextColor(this.lFG, R.color.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.dWo != null && advertAppInfo.dWo.adCloseInfo != null && advertAppInfo.dWo.adCloseInfo.support_close.intValue() > 0) {
            this.lEm.setVisibility(0);
            this.lEm.setData(advertAppInfo);
        } else {
            this.lEm.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.giZ.getHeaderImg() != null) {
            if (advertAppInfo2.beE() == null || advertAppInfo2.beE().getPendantData() == null || StringUtils.isNull(advertAppInfo2.beE().getPendantData().bcA())) {
                this.giZ.getHeaderImg().setVisibility(0);
                this.giZ.getHeaderImg().setData(advertAppInfo2);
                this.giZ.getHeaderImg().setOnClickListener(this.hjQ);
            } else {
                this.giZ.getHeaderImg().setVisibility(4);
            }
        }
        if (this.giZ.getUserName() != null) {
            this.giZ.getUserName().setOnClickListener(this.hjQ);
        }
        m.a(this.mTitle, advertAppInfo2.getId(), R.color.cp_cont_b, R.color.cp_cont_d);
        m.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.hjJ);
        ap.setBackgroundColor(this.hjJ, R.color.cp_bg_line_e);
        if ((b.ckS().ckM() || com.baidu.tieba.frs.a.ckL().ckM()) && isInFrsAllThread()) {
            this.lDV.setVisibility(0);
            ap.setBackgroundColor(this.lDV, R.color.cp_bg_line_d);
            return;
        }
        this.lDV.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!k.bbM().isShowImages() || adPost.feedData.dnz().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.lGX != null) {
            this.lGX.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.lGV.setVisibility(8);
            return;
        }
        this.lGX = this.lGY.obtainHolder(adPost, this.lGV, this.lGX, this.jPl);
        if (this.lGX != null) {
            this.lGV.setVisibility(0);
            this.lGX.setVisibility(0);
            this.lGX.update(adPost);
            this.lGX.setAfterClickSchemeListener(this.jPk);
            this.lGX.setPageContext(this.efn);
            return;
        }
        this.lGV.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
