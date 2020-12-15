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
    private ThreadUserInfoLayout hbM;
    private View ijG;
    protected View.OnClickListener ijK;
    private AdCloseView mJL;
    private AdThreadCommentAndPraiseInfoLayout mJT;
    private ViewStub mJq;
    private View mJr;
    protected View mJs;
    private TextView mLc;
    private RelativeLayout mMH;
    private AdPost mMI;
    protected AdOperateBarHolder mMJ;
    protected final AdOperateBarCreator mMK;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void dS(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ijK = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.mMI != null) {
                    if ((AdPostBaseView.this.hbM.getUserName() == view || AdPostBaseView.this.hbM.getHeaderImg() == view) && AdPostBaseView.this.mMI.feedData.portraitClick != null) {
                        AdPostBaseView.this.r(3, AlaStaticKeys.ALA_STATIC_VALUE_ICON, AdPostBaseView.this.mMI.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.r(3, "hotarea", AdPostBaseView.this.mMI.feedData.scheme);
                }
            }
        };
        this.mMK = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        ap.setBackgroundResource(this.rootView, R.drawable.addresslist_item_bg);
        this.mJT.onChangeSkinType();
        this.hbM.onChangeSkinType();
        if (this.mJL != null) {
            this.mJL.onChangeSkinType();
        }
        if (this.mMJ != null) {
            this.mMJ.onChangeSkinType();
        }
        ap.setBackgroundColor(this.ijG, R.color.CAM_X0205);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View ddW() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.ijK);
        this.mJs = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.mJs.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.ijG = this.rootView.findViewById(R.id.divider_line);
        this.mJT = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.mJT.setStyle(2);
        this.hbM = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mLc = (TextView) inflate.findViewById(R.id.feed_tag);
        this.mJL = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.mJL.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.mJL != null && AdPostBaseView.this.mJL.getVisibility() == 0) {
                    AdPostBaseView.this.mJL.performClick();
                }
            }
        });
        this.hbM.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.eNx.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.mJT.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mJT.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.mJT.setLayoutParams(layoutParams2);
        }
        this.mJT.setBarNameClickEnabled(false);
        this.mJT.setReplyTimeVisible(false);
        this.mJT.setShowPraiseNum(true);
        this.mJT.setNeedAddPraiseIcon(true);
        this.mJT.setNeedAddReplyIcon(true);
        this.mJT.setShareVisible(true);
        this.mMH = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.mMH.setOnClickListener(this.ijK);
        this.mJq = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.mJq.setLayoutResource(getCustomLayout());
        this.mJr = this.mJq.inflate();
        dS(this.mJr);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.mMI.preloadLegoCardStr)) {
            str2 = Sc(str2);
        }
        a.bMn().c(this.eNx.getPageActivity(), new String[]{str2});
        if (this.kTj != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.kTj.d(i, hashMap);
        }
    }

    private String Sc(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.mMI.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.mMI = adPost;
        this.hbM.setData(adPost.getAdvertAppInfo());
        this.mJT.setShareData(adPost);
        this.mJT.setCommentClickable(true);
        this.mJT.getCommentContainer().setOnClickListener(this.ijK);
        this.mJT.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.mLc.setVisibility(8);
        } else {
            this.mLc.setVisibility(0);
            this.mLc.setText(adPost.feedData.tag_name);
            this.mLc.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.mLc.setTextSize(0, l.getDimens(this.eNx.getPageActivity(), R.dimen.fontsize24));
                ap.setViewTextColor(this.mLc, R.color.CAM_X0109, 1);
            } else {
                this.mLc.setTextSize(0, l.getDimens(this.eNx.getPageActivity(), R.dimen.fontsize28));
                ap.setViewTextColor(this.mLc, R.color.CAM_X0106, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.eEm != null && advertAppInfo.eEm.adCloseInfo != null && advertAppInfo.eEm.adCloseInfo.support_close.intValue() > 0) {
            this.mJL.setVisibility(0);
            this.mJL.setData(advertAppInfo);
        } else {
            this.mJL.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.hbM.getHeaderImg() != null) {
            if (advertAppInfo2.boP() == null || advertAppInfo2.boP().getPendantData() == null || StringUtils.isNull(advertAppInfo2.boP().getPendantData().bmL())) {
                this.hbM.getHeaderImg().setVisibility(0);
                this.hbM.getHeaderImg().setData(advertAppInfo2);
                this.hbM.getHeaderImg().setOnClickListener(this.ijK);
            } else {
                this.hbM.getHeaderImg().setVisibility(4);
            }
        }
        if (this.hbM.getUserName() != null) {
            this.hbM.getUserName().setOnClickListener(this.ijK);
        }
        n.a(this.mTitle, advertAppInfo2.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        n.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        if ((b.cBe().cAY() || com.baidu.tieba.frs.a.cAX().cAY()) && isInFrsAllThread()) {
            this.mJs.setVisibility(0);
            ap.setBackgroundColor(this.mJs, R.color.CAM_X0201);
            return;
        }
        this.mJs.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.mMJ != null) {
            this.mMJ.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.mMH.setVisibility(8);
            return;
        }
        this.mMJ = this.mMK.obtainHolder(adPost, this.mMH, this.mMJ, this.kTk);
        if (this.mMJ != null) {
            this.mMH.setVisibility(0);
            this.mMJ.setVisibility(0);
            this.mMJ.update(adPost);
            this.mMJ.setAfterClickSchemeListener(this.kTj);
            this.mMJ.setPageContext(this.eNx);
            return;
        }
        this.mMH.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
