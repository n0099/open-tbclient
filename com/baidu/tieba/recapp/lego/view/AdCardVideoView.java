package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import c.a.r0.s.r.e;
import c.a.s0.j3.i0.b.f;
import c.a.s0.j3.n;
import c.a.s0.j3.r;
import c.a.s0.x1.o.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.DistributeVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class AdCardVideoView extends AdCardBaseView implements r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public DistributeVideoView mVideoView;
    public TbPageContext x;
    public int y;
    public int z;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdCardVideoView f49179e;

        public a(AdCardVideoView adCardVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adCardVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49179e = adCardVideoView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int jump2DownloadDetailPage = this.f49179e.mVideoView.jump2DownloadDetailPage();
                if (this.f49179e.afterClickSchemeListener != null) {
                    this.f49179e.afterClickSchemeListener.a(jump2DownloadDetailPage, null);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdCardVideoView(TbPageContext<?> tbPageContext) {
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
        this.x = tbPageContext;
    }

    private String getPageTypeByBusiness() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            int businessType = getBusinessType();
            return businessType != 1 ? (businessType == 2 || businessType == 3) ? "NEWINDEX" : businessType != 4 ? "unknown" : "PB_BANNER" : "FRS";
        }
        return (String) invokeV.objValue;
    }

    public final void T(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adCard) == null) {
            if (adCard.goodsStyle == 14) {
                int i2 = this.mMaxWidth / 2;
                this.y = i2;
                this.z = c.a.s0.j3.i0.c.a.b(i2);
            } else {
                int i3 = this.mMaxWidth;
                this.y = i3;
                this.z = c.a.s0.j3.i0.c.a.a(i3);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mVideoView.getLayoutParams();
            layoutParams.height = this.z;
            layoutParams.width = this.y;
            if (adCard.goodsStyle == 14 && !isVerticalTransform(adCard)) {
                int i4 = this.mMaxWidth / 2;
                this.A = i4;
                this.B = c.a.s0.j3.i0.c.a.b(i4);
            } else {
                int i5 = this.mMaxWidth;
                this.A = i5;
                this.B = c.a.s0.j3.i0.c.a.a(i5);
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mCustomRoot.getLayoutParams();
            layoutParams2.width = this.A;
            layoutParams2.height = this.B;
            this.mCustomRoot.requestLayout();
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void fillCustomView(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adCard) == null) || adCard == null || adCard.videoInfo == null) {
            return;
        }
        T(adCard);
        this.mVideoView.setPageContext(this.x);
        this.mVideoView.setVideoTailFrameData(adCard.tailFrame);
        this.mVideoView.setData(adCard.videoInfo, adCard.verticalVideoStyle, this.y, this.z, this.A, this.B);
        this.mVideoView.setScheme(adCard.getScheme());
        this.mVideoView.setAdInfo(adCard);
        this.mVideoView.setVideoScalingMode(0);
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        this.mVideoView.updateTailFrameView(advertAppInfo);
        if (advertAppInfo != null) {
            int i2 = -1;
            String pageTypeByBusiness = TextUtils.isEmpty(advertAppInfo.n4) ? getPageTypeByBusiness() : advertAppInfo.n4;
            e eVar = advertAppInfo.m4;
            if (eVar != null) {
                i2 = eVar.f13289b;
                pageTypeByBusiness = eVar.a;
            }
            this.mVideoView.setStatisticInfo(advertAppInfo, i2, pageTypeByBusiness);
        }
        this.mVideoView.setOnClickListener(new a(this));
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getCustomLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.ad_card_video_view : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.card_ad : invokeV.intValue;
    }

    @Override // c.a.s0.j3.r
    public n getVideoOrVrView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mVideoView : (n) invokeV.objValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void initCustomView(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || view == null) {
            return;
        }
        float ratioByResString = getRatioByResString(R.string.J_X05);
        XfremodeRoundLayout xfremodeRoundLayout = (XfremodeRoundLayout) view;
        xfremodeRoundLayout.setRoundLayoutRadius(new float[]{ratioByResString, ratioByResString, ratioByResString, ratioByResString, ratioByResString, ratioByResString, ratioByResString, ratioByResString});
        xfremodeRoundLayout.setLayerType(2, null);
        DistributeVideoView distributeVideoView = (DistributeVideoView) view.findViewById(R.id.advert_video);
        this.mVideoView = distributeVideoView;
        distributeVideoView.setHolderView(view);
    }

    public boolean isVerticalTransform(AdCard adCard) {
        InterceptResult invokeL;
        f fVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, adCard)) == null) ? adCard != null && adCard.goodsStyle == 14 && (fVar = adCard.verticalVideoStyle) != null && fVar.a() : invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView, c.a.s0.x1.o.l.e
    public void setDownloadAppCallback(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            super.setDownloadAppCallback(cVar);
            this.mVideoView.setDownloadCallback(cVar);
        }
    }
}
