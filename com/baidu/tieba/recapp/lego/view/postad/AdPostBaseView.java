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
    private ThreadUserInfoLayout dEA;
    protected View eCK;
    private View eCN;
    protected View.OnClickListener eCR;
    private AdCloseView iHD;
    private AdThreadCommentAndPraiseInfoLayout iHL;
    private ViewStub iHn;
    private View iHo;
    protected View iHp;
    private TextView iJj;
    private RelativeLayout iKH;
    private AdPost iKI;
    protected AdOperateBarHolder iKJ;
    protected final AdOperateBarCreator iKK;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void cO(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eCR = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.iKI != null) {
                    if ((AdPostBaseView.this.dEA.getUserName() == view || AdPostBaseView.this.dEA.getHeaderImg() == view) && AdPostBaseView.this.iKI.feedData.portraitClick != null) {
                        AdPostBaseView.this.n(3, "icon", AdPostBaseView.this.iKI.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.n(3, "hotarea", AdPostBaseView.this.iKI.feedData.scheme);
                }
            }
        };
        this.iKK = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        am.k(this.rootView, R.drawable.addresslist_item_bg);
        this.iHL.onChangeSkinType();
        this.dEA.onChangeSkinType();
        if (this.iHD != null) {
            this.iHD.onChangeSkinType();
        }
        if (this.iKJ != null) {
            this.iKJ.onChangeSkinType();
        }
        am.l(this.eCN, R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View bKv() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.eCR);
        this.iHp = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.iHp.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.eCN = this.rootView.findViewById(R.id.divider_line);
        this.eCK = this.rootView.findViewById(R.id.divider_line_above_praise);
        this.iHL = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.iHL.setStyle(2);
        this.dEA = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.iJj = (TextView) inflate.findViewById(R.id.feed_tag);
        this.iHD = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.iHD.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.iHD != null && AdPostBaseView.this.iHD.getVisibility() == 0) {
                    AdPostBaseView.this.iHD.performClick();
                }
            }
        });
        this.dEA.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.iHL.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iHL.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.iHL.setLayoutParams(layoutParams2);
        }
        this.iHL.setBarNameClickEnabled(false);
        this.iHL.setReplyTimeVisible(false);
        this.iHL.setShowPraiseNum(true);
        this.iHL.setNeedAddPraiseIcon(true);
        this.iHL.setNeedAddReplyIcon(true);
        this.iHL.setShareVisible(true);
        this.iKH = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.iKH.setOnClickListener(this.eCR);
        this.iHn = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.iHn.setLayoutResource(getCustomLayout());
        this.iHo = this.iHn.inflate();
        cO(this.iHo);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.iKI.preloadLegoCardStr)) {
            str2 = DL(str2);
        }
        a.aCZ().c(this.mContext.getPageActivity(), new String[]{str2});
        if (this.heW != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.heW.b(i, hashMap);
        }
    }

    private String DL(String str) {
        return str + "&" + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.iKI.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.iKI = adPost;
        this.dEA.setData(adPost.getAdvertAppInfo());
        this.iHL.setShareData(adPost);
        this.iHL.setCommentClickable(true);
        this.iHL.getCommentContainer().setOnClickListener(this.eCR);
        this.iHL.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.iJj.setVisibility(8);
        } else {
            this.iJj.setVisibility(0);
            this.iJj.setText(adPost.feedData.tag_name);
            this.iJj.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.iJj.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.fontsize24));
                am.f(this.iJj, R.color.cp_cont_d, 1);
            } else {
                this.iJj.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.fontsize28));
                am.f(this.iJj, R.color.cp_cont_f, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.bFd != null && advertAppInfo.bFd.adCloseInfo != null && advertAppInfo.bFd.adCloseInfo.support_close.intValue() > 0) {
            this.iHD.setVisibility(0);
            this.iHD.setData(advertAppInfo);
        } else {
            this.iHD.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.dEA.getHeaderImg() != null) {
            if (advertAppInfo2.aex() == null || advertAppInfo2.aex().getPendantData() == null || StringUtils.isNull(advertAppInfo2.aex().getPendantData().acU())) {
                this.dEA.getHeaderImg().setVisibility(0);
                this.dEA.getHeaderImg().setData(advertAppInfo2);
                this.dEA.getHeaderImg().setOnClickListener(this.eCR);
            } else {
                this.dEA.getHeaderImg().setVisibility(4);
            }
        }
        if (this.dEA.getUserName() != null) {
            this.dEA.getUserName().setOnClickListener(this.eCR);
        }
        n.a(this.mTitle, advertAppInfo2.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        n.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        a(adPost, this.eCK);
        am.l(this.eCK, R.color.cp_bg_line_e);
        if (isInFrsAllThread() && com.baidu.tieba.frs.a.bkY().bkZ()) {
            this.iHp.setVisibility(0);
            am.l(this.iHp, R.color.cp_bg_line_d);
            return;
        }
        this.iHp.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.hdX == 1;
    }

    private void a(AdPost adPost, View view) {
        if (adPost != null) {
            if (!i.aca().ace() || adPost.feedData.chV().size() == 0) {
            }
            if (adPost.adData.type == 1) {
            }
            view.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.iKJ != null) {
            this.iKJ.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.iKH.setVisibility(8);
            return;
        }
        this.iKJ = this.iKK.obtainHolder(adPost, this.iKH, this.iKJ, this.heX);
        if (this.iKJ != null) {
            this.iKH.setVisibility(0);
            this.iKJ.setVisibility(0);
            this.iKJ.update(adPost);
            this.iKJ.setAfterClickSchemeListener(this.heW);
            this.iKJ.setPageContext(this.mContext);
            return;
        }
        this.iKH.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
