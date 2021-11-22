package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.q0.s.q.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.VideoInfo;
/* loaded from: classes9.dex */
public class AdCardSmallPicVideoView extends AdSimpleCardBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public XfremodeRoundLayout f54449i;
    public TbImageView j;
    public TextView mVideoDuration;
    public ImageView mVideoPlayIcon;
    public DistributeVideoView mVideoView;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdCard f54450e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdCardSmallPicVideoView f54451f;

        public a(AdCardSmallPicVideoView adCardSmallPicVideoView, AdCard adCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardSmallPicVideoView, adCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54451f = adCardSmallPicVideoView;
            this.f54450e = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AdCardSmallPicVideoView adCardSmallPicVideoView = this.f54451f;
                if (adCardSmallPicVideoView.mVideoView == null) {
                    adCardSmallPicVideoView.m(this.f54450e);
                }
                DistributeVideoView distributeVideoView = this.f54451f.mVideoView;
                int jump2DownloadDetailPage = distributeVideoView != null ? distributeVideoView.jump2DownloadDetailPage() : 0;
                if (this.f54451f.afterClickSchemeListener != null) {
                    this.f54451f.afterClickSchemeListener.a(jump2DownloadDetailPage, null);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdCardSmallPicVideoView(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private String getPageTypeByBusiness() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            int businessType = getBusinessType();
            return businessType != 1 ? (businessType == 2 || businessType == 3) ? "NEWINDEX" : businessType != 4 ? "unknown" : "PB_BANNER" : "FRS";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    public void fillCustomView(AdCard adCard) {
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adCard) == null) {
            if (adCard != null && (videoInfo = adCard.videoInfo) != null) {
                String str = videoInfo.thumbnail_url;
                if (!TextUtils.isEmpty(str)) {
                    this.mCustomRoot.setVisibility(0);
                    this.j.startLoad(str, 17, false);
                }
                AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
                if (advertAppInfo != null && advertAppInfo.T4()) {
                    this.mRootView.setOnClickListener(new a(this, adCard));
                }
                this.mVideoPlayIcon.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
                this.mVideoDuration.setText(StringUtils.translateSecondsToString(adCard.videoInfo.video_duration.intValue()));
                return;
            }
            this.mCustomRoot.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    public int getCustomLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.ad_card_small_pic_video_view : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    public int getLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.card_small_pic_ad : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    public void initCustomView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            float dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10);
            this.f54449i = (XfremodeRoundLayout) view.findViewById(R.id.rl_ad_image);
            this.j = (TbImageView) view.findViewById(R.id.ad_img);
            this.mVideoDuration = (TextView) view.findViewById(R.id.ad_video_duration);
            this.mVideoPlayIcon = (ImageView) view.findViewById(R.id.video_play_icon);
            this.j.setPlaceHolder(3);
            this.f54449i.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        }
    }

    public final void m(AdCard adCard) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, adCard) == null) && this.mVideoView == null) {
            DistributeVideoView distributeVideoView = new DistributeVideoView(getContext());
            this.mVideoView = distributeVideoView;
            distributeVideoView.setPageContext(this.mContext);
            this.mVideoView.setVideoTailFrameData(adCard.tailFrame);
            this.mVideoView.setData(adCard.videoInfo);
            this.mVideoView.setScheme(adCard.getScheme());
            this.mVideoView.setAdInfo(adCard);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            if (advertAppInfo != null) {
                int i2 = -1;
                String pageTypeByBusiness = getPageTypeByBusiness();
                e eVar = advertAppInfo.h4;
                if (eVar != null) {
                    i2 = eVar.f14057b;
                    pageTypeByBusiness = eVar.f14056a;
                }
                this.mVideoView.setStatisticInfo(advertAppInfo, i2, pageTypeByBusiness);
            }
        }
    }
}
