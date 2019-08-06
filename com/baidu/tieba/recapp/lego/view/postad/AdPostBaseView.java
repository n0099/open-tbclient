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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.a;
import com.baidu.tieba.card.n;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.recapp.lego.model.AdPost;
import com.baidu.tieba.recapp.view.AdCloseView;
import com.baidu.tieba.recapp.view.AdOperateBarCreator;
import com.baidu.tieba.recapp.view.AdOperateBarHolder;
import com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes3.dex */
public abstract class AdPostBaseView extends PostAdBaseView<AdPost> {
    private ThreadUserInfoLayout dEH;
    protected View eCR;
    private View eCU;
    protected View.OnClickListener eCY;
    private AdCloseView iIH;
    private AdThreadCommentAndPraiseInfoLayout iIP;
    private ViewStub iIr;
    private View iIs;
    protected View iIt;
    private TextView iKn;
    private RelativeLayout iLL;
    private AdPost iLM;
    protected AdOperateBarHolder iLN;
    protected final AdOperateBarCreator iLO;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void cQ(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eCY = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.iLM != null) {
                    if ((AdPostBaseView.this.dEH.getUserName() == view || AdPostBaseView.this.dEH.getHeaderImg() == view) && AdPostBaseView.this.iLM.feedData.portraitClick != null) {
                        AdPostBaseView.this.n(3, "icon", AdPostBaseView.this.iLM.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.n(3, "hotarea", AdPostBaseView.this.iLM.feedData.scheme);
                }
            }
        };
        this.iLO = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        am.k(this.rootView, R.drawable.addresslist_item_bg);
        this.iIP.onChangeSkinType();
        this.dEH.onChangeSkinType();
        if (this.iIH != null) {
            this.iIH.onChangeSkinType();
        }
        if (this.iLN != null) {
            this.iLN.onChangeSkinType();
        }
        am.l(this.eCU, R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View bKJ() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.eCY);
        this.iIt = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.iIt.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.eCU = this.rootView.findViewById(R.id.divider_line);
        this.eCR = this.rootView.findViewById(R.id.divider_line_above_praise);
        this.iIP = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.iIP.setStyle(2);
        this.dEH = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.iKn = (TextView) inflate.findViewById(R.id.feed_tag);
        this.iIH = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.iIH.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.iIH != null && AdPostBaseView.this.iIH.getVisibility() == 0) {
                    AdPostBaseView.this.iIH.performClick();
                }
            }
        });
        this.dEH.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.iIP.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iIP.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.iIP.setLayoutParams(layoutParams2);
        }
        this.iIP.setBarNameClickEnabled(false);
        this.iIP.setReplyTimeVisible(false);
        this.iIP.setShowPraiseNum(true);
        this.iIP.setNeedAddPraiseIcon(true);
        this.iIP.setNeedAddReplyIcon(true);
        this.iIP.setShareVisible(true);
        this.iLL = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.iLL.setOnClickListener(this.eCY);
        this.iIr = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.iIr.setLayoutResource(getCustomLayout());
        this.iIs = this.iIr.inflate();
        cQ(this.iIs);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.iLM.preloadLegoCardStr)) {
            str2 = DM(str2);
        }
        a.aDb().c(this.mContext.getPageActivity(), new String[]{str2});
        if (this.hfO != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.hfO.b(i, hashMap);
        }
    }

    private String DM(String str) {
        return str + "&" + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.iLM.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.iLM = adPost;
        this.dEH.setData(adPost.getAdvertAppInfo());
        this.iIP.setShareData(adPost);
        this.iIP.setCommentClickable(true);
        this.iIP.getCommentContainer().setOnClickListener(this.eCY);
        this.iIP.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.iKn.setVisibility(8);
        } else {
            this.iKn.setVisibility(0);
            this.iKn.setText(adPost.feedData.tag_name);
            this.iKn.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.iKn.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.fontsize24));
                am.f(this.iKn, R.color.cp_cont_d, 1);
            } else {
                this.iKn.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.fontsize28));
                am.f(this.iKn, R.color.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.bFe != null && advertAppInfo.bFe.adCloseInfo != null && advertAppInfo.bFe.adCloseInfo.support_close.intValue() > 0) {
            this.iIH.setVisibility(0);
            this.iIH.setData(advertAppInfo);
        } else {
            this.iIH.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.dEH.getHeaderImg() != null) {
            if (advertAppInfo2.aey() == null || advertAppInfo2.aey().getPendantData() == null || StringUtils.isNull(advertAppInfo2.aey().getPendantData().acV())) {
                this.dEH.getHeaderImg().setVisibility(0);
                this.dEH.getHeaderImg().setData(advertAppInfo2);
                this.dEH.getHeaderImg().setOnClickListener(this.eCY);
            } else {
                this.dEH.getHeaderImg().setVisibility(4);
            }
        }
        if (this.dEH.getUserName() != null) {
            this.dEH.getUserName().setOnClickListener(this.eCY);
        }
        n.a(this.mTitle, advertAppInfo2.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        n.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.eCR);
        am.l(this.eCR, R.color.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.blf().blg()) {
            this.iIt.setVisibility(0);
            am.l(this.iIt, R.color.cp_bg_line_d);
            return;
        }
        this.iIt.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.heP == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.aca().ace() || adPost.feedData.cin().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.iLN != null) {
            this.iLN.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.iLL.setVisibility(8);
            return;
        }
        this.iLN = this.iLO.obtainHolder(adPost, this.iLL, this.iLN, this.hfP);
        if (this.iLN != null) {
            this.iLL.setVisibility(0);
            this.iLN.setVisibility(0);
            this.iLN.update(adPost);
            this.iLN.setAfterClickSchemeListener(this.hfO);
            this.iLN.setPageContext(this.mContext);
            return;
        }
        this.iLL.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
