package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
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
import d.a.o0.r.q.e;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class AdCardSmallPicVideoView extends AdSimpleCardBaseView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView A;
    public TextView B;
    public DistributeVideoView C;
    public ImageView D;
    public XfremodeRoundLayout z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdCard f20528e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AdCardSmallPicVideoView f20529f;

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
            this.f20529f = adCardSmallPicVideoView;
            this.f20528e = adCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AdCardSmallPicVideoView adCardSmallPicVideoView = this.f20529f;
                if (adCardSmallPicVideoView.C == null) {
                    adCardSmallPicVideoView.W(this.f20528e);
                }
                DistributeVideoView distributeVideoView = this.f20529f.C;
                int jump2DownloadDetailPage = distributeVideoView != null ? distributeVideoView.jump2DownloadDetailPage() : 0;
                if (this.f20529f.o != null) {
                    this.f20529f.o.a(jump2DownloadDetailPage, null);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            int businessType = getBusinessType();
            return businessType != 1 ? (businessType == 2 || businessType == 3) ? "NEWINDEX" : businessType != 4 ? "unknown" : "PB_BANNER" : "FRS";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    public void N(AdCard adCard) {
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adCard) == null) {
            if (adCard != null && (videoInfo = adCard.videoInfo) != null) {
                String str = videoInfo.thumbnail_url;
                if (!TextUtils.isEmpty(str)) {
                    this.t.setVisibility(0);
                    this.A.M(str, 17, false);
                }
                AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
                if (advertAppInfo != null && advertAppInfo.t4()) {
                    this.r.setOnClickListener(new a(this, adCard));
                }
                this.D.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
                this.B.setText(StringUtils.translateSecondsToString(adCard.videoInfo.video_duration.intValue()));
                return;
            }
            this.t.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    public void P(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            float dimensionPixelSize = this.m.getResources().getDimensionPixelSize(R.dimen.tbds10);
            this.z = (XfremodeRoundLayout) view.findViewById(R.id.rl_ad_image);
            this.A = (TbImageView) view.findViewById(R.id.ad_img);
            this.B = (TextView) view.findViewById(R.id.ad_video_duration);
            this.D = (ImageView) view.findViewById(R.id.video_play_icon);
            this.A.setPlaceHolder(3);
            this.z.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        }
    }

    public final void W(AdCard adCard) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adCard) == null) && this.C == null) {
            DistributeVideoView distributeVideoView = new DistributeVideoView(getContext());
            this.C = distributeVideoView;
            distributeVideoView.setPageContext(this.m);
            this.C.setVideoTailFrameData(adCard.tailFrame);
            this.C.setData(adCard.videoInfo);
            this.C.setScheme(adCard.getScheme());
            this.C.setAdInfo(adCard);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            if (advertAppInfo != null) {
                int i2 = -1;
                String pageTypeByBusiness = getPageTypeByBusiness();
                e eVar = advertAppInfo.U3;
                if (eVar != null) {
                    i2 = eVar.f52633b;
                    pageTypeByBusiness = eVar.f52632a;
                }
                this.C.setStatisticInfo(advertAppInfo, i2, pageTypeByBusiness);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    public int getCustomLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.ad_card_small_pic_video_view : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    public int getLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.layout.card_small_pic_ad : invokeV.intValue;
    }
}
