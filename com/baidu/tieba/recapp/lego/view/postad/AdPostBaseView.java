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
    private ThreadUserInfoLayout hbK;
    private View ijE;
    protected View.OnClickListener ijI;
    private AdCloseView mJJ;
    private AdThreadCommentAndPraiseInfoLayout mJR;
    private ViewStub mJo;
    private View mJp;
    protected View mJq;
    private TextView mLa;
    private RelativeLayout mMF;
    private AdPost mMG;
    protected AdOperateBarHolder mMH;
    protected final AdOperateBarCreator mMI;
    private TextView mTitle;
    protected View rootView;

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected abstract void a2(AdPost adPost);

    protected abstract void dS(View view);

    protected abstract int getCustomLayout();

    public AdPostBaseView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.ijI = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.mMG != null) {
                    if ((AdPostBaseView.this.hbK.getUserName() == view || AdPostBaseView.this.hbK.getHeaderImg() == view) && AdPostBaseView.this.mMG.feedData.portraitClick != null) {
                        AdPostBaseView.this.r(3, AlaStaticKeys.ALA_STATIC_VALUE_ICON, AdPostBaseView.this.mMG.feedData.portraitClick.scheme);
                        return;
                    }
                    AdPostBaseView.this.r(3, "hotarea", AdPostBaseView.this.mMG.feedData.scheme);
                }
            }
        };
        this.mMI = new AdOperateBarCreator(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        ap.setBackgroundResource(this.rootView, R.drawable.addresslist_item_bg);
        this.mJR.onChangeSkinType();
        this.hbK.onChangeSkinType();
        if (this.mJJ != null) {
            this.mJJ.onChangeSkinType();
        }
        if (this.mMH != null) {
            this.mMH.onChangeSkinType();
        }
        ap.setBackgroundColor(this.ijE, R.color.CAM_X0205);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    protected View ddV() {
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null);
        this.rootView.setOnClickListener(this.ijI);
        this.mJq = this.rootView.findViewById(R.id.thread_multi_del_ad_mask_view);
        this.mJq.setClickable(true);
        this.mTitle = (TextView) this.rootView.findViewById(R.id.card_home_page_normal_thread_title);
        this.ijE = this.rootView.findViewById(R.id.divider_line);
        this.mJR = (AdThreadCommentAndPraiseInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_info_layout);
        this.mJR.setStyle(2);
        this.hbK = (ThreadUserInfoLayout) this.rootView.findViewById(R.id.card_home_page_normal_thread_user_info_layout);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ad_post_tag_close, (ViewGroup) null);
        this.mLa = (TextView) inflate.findViewById(R.id.feed_tag);
        this.mJJ = (AdCloseView) inflate.findViewById(R.id.ad_close_view);
        this.mJJ.setPage(getBusinessType());
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdPostBaseView.this.mJJ != null && AdPostBaseView.this.mJJ.getVisibility() == 0) {
                    AdPostBaseView.this.mJJ.performClick();
                }
            }
        });
        this.hbK.addView(inflate);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 53;
        int dimensionPixelOffset = this.eNx.getResources().getDimensionPixelOffset(R.dimen.ds8);
        inflate.setPadding(dimensionPixelOffset, 0, 0, dimensionPixelOffset);
        inflate.setLayoutParams(layoutParams);
        if (this.mJR.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mJR.getLayoutParams();
            layoutParams2.rightMargin = 0;
            this.mJR.setLayoutParams(layoutParams2);
        }
        this.mJR.setBarNameClickEnabled(false);
        this.mJR.setReplyTimeVisible(false);
        this.mJR.setShowPraiseNum(true);
        this.mJR.setNeedAddPraiseIcon(true);
        this.mJR.setNeedAddReplyIcon(true);
        this.mJR.setShareVisible(true);
        this.mMF = (RelativeLayout) this.rootView.findViewById(R.id.ad_operate_area);
        this.mMF.setOnClickListener(this.ijI);
        this.mJo = (ViewStub) this.rootView.findViewById(R.id.ad_custom_view_stub);
        this.mJo.setLayoutResource(getCustomLayout());
        this.mJp = this.mJo.inflate();
        dS(this.mJp);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i, String str, String str2) {
        if (!TextUtils.isEmpty(this.mMG.preloadLegoCardStr)) {
            str2 = Sc(str2);
        }
        a.bMm().c(this.eNx.getPageActivity(), new String[]{str2});
        if (this.kTh != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("da_area", str);
            this.kTh.d(i, hashMap);
        }
    }

    private String Sc(String str) {
        return str + ETAG.ITEM_SEPARATOR + LegoListActivityConfig.PRE_LOAD + "=" + URLEncoder.encode(this.mMG.preloadLegoCardStr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    /* renamed from: b */
    public void a(AdPost adPost) {
        super.a((AdPostBaseView) adPost);
        this.mMG = adPost;
        this.hbK.setData(adPost.getAdvertAppInfo());
        this.mJR.setShareData(adPost);
        this.mJR.setCommentClickable(true);
        this.mJR.getCommentContainer().setOnClickListener(this.ijI);
        this.mJR.setType(TbadkCoreApplication.getInst().getCardShowType());
        AdvertAppInfo advertAppInfo = adPost.getAdvertAppInfo();
        if (TextUtils.isEmpty(adPost.feedData.tag_name)) {
            this.mLa.setVisibility(8);
        } else {
            this.mLa.setVisibility(0);
            this.mLa.setText(adPost.feedData.tag_name);
            this.mLa.setPadding(0, 0, 0, 0);
            if ("广告".equals(adPost.feedData.tag_name)) {
                this.mLa.setTextSize(0, l.getDimens(this.eNx.getPageActivity(), R.dimen.fontsize24));
                ap.setViewTextColor(this.mLa, R.color.CAM_X0109, 1);
            } else {
                this.mLa.setTextSize(0, l.getDimens(this.eNx.getPageActivity(), R.dimen.fontsize28));
                ap.setViewTextColor(this.mLa, R.color.CAM_X0106, 1);
            }
        }
        if (advertAppInfo != null && advertAppInfo.eEm != null && advertAppInfo.eEm.adCloseInfo != null && advertAppInfo.eEm.adCloseInfo.support_close.intValue() > 0) {
            this.mJJ.setVisibility(0);
            this.mJJ.setData(advertAppInfo);
        } else {
            this.mJJ.setVisibility(8);
        }
        c(adPost);
        AdvertAppInfo advertAppInfo2 = adPost.getAdvertAppInfo();
        if (this.hbK.getHeaderImg() != null) {
            if (advertAppInfo2.boP() == null || advertAppInfo2.boP().getPendantData() == null || StringUtils.isNull(advertAppInfo2.boP().getPendantData().bmL())) {
                this.hbK.getHeaderImg().setVisibility(0);
                this.hbK.getHeaderImg().setData(advertAppInfo2);
                this.hbK.getHeaderImg().setOnClickListener(this.ijI);
            } else {
                this.hbK.getHeaderImg().setVisibility(4);
            }
        }
        if (this.hbK.getUserName() != null) {
            this.hbK.getUserName().setOnClickListener(this.ijI);
        }
        n.a(this.mTitle, advertAppInfo2.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        n.a(advertAppInfo2, this.mTitle);
        this.mTitle.setVisibility(0);
        a2(adPost);
        if ((b.cBd().cAX() || com.baidu.tieba.frs.a.cAW().cAX()) && isInFrsAllThread()) {
            this.mJq.setVisibility(0);
            ap.setBackgroundColor(this.mJq, R.color.CAM_X0201);
            return;
        }
        this.mJq.setVisibility(8);
    }

    private boolean isInFrsAllThread() {
        return this.mBusinessType == 1;
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView, com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        super.setDownloadAppCallback(cVar);
        if (this.mMH != null) {
            this.mMH.setDownloadAppCallback(cVar);
        }
    }

    protected final void c(AdPost adPost) {
        if (!AdOperateBarHolder.isOperateValid(adPost.adData)) {
            this.mMF.setVisibility(8);
            return;
        }
        this.mMH = this.mMI.obtainHolder(adPost, this.mMF, this.mMH, this.kTi);
        if (this.mMH != null) {
            this.mMF.setVisibility(0);
            this.mMH.setVisibility(0);
            this.mMH.update(adPost);
            this.mMH.setAfterClickSchemeListener(this.kTh);
            this.mMH.setPageContext(this.eNx);
            return;
        }
        this.mMF.setVisibility(8);
    }

    public int getLayout() {
        return R.layout.post_ad_card_base;
    }
}
