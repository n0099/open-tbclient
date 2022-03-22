package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.r.e;
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
/* loaded from: classes5.dex */
public class AdCardSmallPicVideoView extends AdSimpleCardBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public XfremodeRoundLayout u;
    public TbImageView v;
    public TextView w;
    public DistributeVideoView x;
    public ImageView y;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdCard a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdCardSmallPicVideoView f35719b;

        public a(AdCardSmallPicVideoView adCardSmallPicVideoView, AdCard adCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardSmallPicVideoView, adCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35719b = adCardSmallPicVideoView;
            this.a = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AdCardSmallPicVideoView adCardSmallPicVideoView = this.f35719b;
                if (adCardSmallPicVideoView.x == null) {
                    adCardSmallPicVideoView.Q(this.a);
                }
                DistributeVideoView distributeVideoView = this.f35719b.x;
                int jump2DownloadDetailPage = distributeVideoView != null ? distributeVideoView.jump2DownloadDetailPage() : 0;
                if (this.f35719b.k != null) {
                    this.f35719b.k.a(jump2DownloadDetailPage, null);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            int businessType = getBusinessType();
            return businessType != 1 ? (businessType == 2 || businessType == 3) ? "HOME" : businessType != 4 ? "unknown" : "PB_BANNER" : "FRS";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    public void I(AdCard adCard) {
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adCard) == null) {
            if (adCard != null && (videoInfo = adCard.videoInfo) != null) {
                String str = videoInfo.thumbnail_url;
                if (!TextUtils.isEmpty(str)) {
                    this.o.setVisibility(0);
                    this.v.J(str, 17, false);
                }
                AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
                if (advertAppInfo != null && advertAppInfo.i()) {
                    this.m.setOnClickListener(new a(this, adCard));
                }
                this.y.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
                this.w.setText(StringUtils.translateSecondsToString(adCard.videoInfo.video_duration.intValue()));
                return;
            }
            this.o.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    public void K(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            float dimensionPixelSize = this.i.getResources().getDimensionPixelSize(R.dimen.tbds10);
            this.u = (XfremodeRoundLayout) view.findViewById(R.id.obfuscated_res_0x7f091ac5);
            this.v = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f0900a9);
            this.w = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0900fa);
            this.y = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f092366);
            this.v.setPlaceHolder(3);
            this.u.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        }
    }

    public final void Q(AdCard adCard) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adCard) == null) && this.x == null) {
            DistributeVideoView distributeVideoView = new DistributeVideoView(getContext());
            this.x = distributeVideoView;
            distributeVideoView.setPageContext(this.i);
            this.x.setVideoTailFrameData(adCard.tailFrame);
            this.x.setData(adCard.videoInfo);
            this.x.setScheme(adCard.getScheme());
            this.x.setAdInfo(adCard);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            if (advertAppInfo != null) {
                int i = -1;
                String pageTypeByBusiness = getPageTypeByBusiness();
                e eVar = advertAppInfo.j;
                if (eVar != null) {
                    i = eVar.f10837b;
                    pageTypeByBusiness = eVar.a;
                }
                this.x.setStatisticInfo(advertAppInfo, i, pageTypeByBusiness);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    public int getCustomLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d0067 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    public int getLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.layout.obfuscated_res_0x7f0d01be : invokeV.intValue;
    }
}
