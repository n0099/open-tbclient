package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mc8;
import com.repackage.nc8;
import com.repackage.ni;
import com.repackage.xc7;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class DistributeVideoWrapper extends RelativeLayout implements IHomeAdVideoView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public Context b;
    public VideoInfo c;
    public mc8 d;
    public int e;
    public int f;
    public int g;
    public int h;
    public nc8 i;
    public AdvertAppInfo j;
    public AdvertAppInfo k;
    public int l;
    public String m;
    public TBLottieAnimationView n;
    public ForeDrawableImageView o;
    public TextView p;
    public AdCard q;
    public String r;
    public xc7 s;
    public int t;
    public DistributeVideoView u;
    public View.OnClickListener v;
    public boolean w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DistributeVideoWrapper(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = 1;
        this.w = false;
        b(context);
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.repackage.aa8
    public void autoPlay(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            c();
            DistributeVideoView distributeVideoView = this.u;
            if (distributeVideoView != null) {
                distributeVideoView.autoPlay(i);
            }
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) || context == null) {
            return;
        }
        this.b = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d08d7, (ViewGroup) this, true);
        if (inflate != null) {
            this.o = (ForeDrawableImageView) inflate.findViewById(R.id.obfuscated_res_0x7f092478);
            this.n = (TBLottieAnimationView) inflate.findViewById(R.id.obfuscated_res_0x7f092479);
            this.p = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092477);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.w) {
            return;
        }
        removeAllViews();
        DistributeVideoView distributeVideoView = new DistributeVideoView(this.b);
        this.u = distributeVideoView;
        addView(distributeVideoView, getLayoutParams());
        this.u.setPageContext(this.a);
        this.u.setVideoTailFrameData(this.i);
        this.u.setData(this.c, this.d, this.e, this.f, this.g, this.h);
        this.u.setScheme(this.r);
        this.u.setAdInfo(this.q);
        this.u.setVideoScalingMode(this.t);
        this.u.updateTailFrameView(this.j);
        AdvertAppInfo advertAppInfo = this.k;
        if (advertAppInfo != null) {
            this.u.setStatisticInfo(advertAppInfo, this.l, this.m);
        }
        this.u.setOnClickListener(this.v);
        this.u.setDownloadCallback(this.s);
        this.w = true;
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.repackage.aa8
    public boolean canPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.w) {
                DistributeVideoView distributeVideoView = this.u;
                if (distributeVideoView != null) {
                    return distributeVideoView.canPlay();
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.repackage.aa8
    public long getCurrentPosition() {
        InterceptResult invokeV;
        DistributeVideoView distributeVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!this.w || (distributeVideoView = this.u) == null) {
                return 0L;
            }
            return distributeVideoView.getCurrentPosition();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.repackage.aa8
    public int getPlayStatus() {
        InterceptResult invokeV;
        DistributeVideoView distributeVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!this.w || (distributeVideoView = this.u) == null) {
                return -1;
            }
            return distributeVideoView.getPlayStatus();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.repackage.aa8
    public String getPlayUrl() {
        InterceptResult invokeV;
        DistributeVideoView distributeVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.w && (distributeVideoView = this.u) != null) {
                return distributeVideoView.getPlayUrl();
            }
            VideoInfo videoInfo = this.c;
            return videoInfo != null ? videoInfo.video_url : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.repackage.aa8
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.repackage.aa8
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        DistributeVideoView distributeVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!this.w || (distributeVideoView = this.u) == null) {
                return false;
            }
            return distributeVideoView.isPlayStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.repackage.aa8
    public boolean isPlaying() {
        InterceptResult invokeV;
        DistributeVideoView distributeVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!this.w || (distributeVideoView = this.u) == null) {
                return false;
            }
            return distributeVideoView.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView
    public int jump2DownloadDetailPage() {
        InterceptResult invokeV;
        DistributeVideoView distributeVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (!this.w || (distributeVideoView = this.u) == null) {
                return 0;
            }
            return distributeVideoView.jump2DownloadDetailPage();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.repackage.aa8
    public void release() {
        DistributeVideoView distributeVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.w && (distributeVideoView = this.u) != null) {
            distributeVideoView.release();
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView
    public void setAdInfo(AdCard adCard) {
        DistributeVideoView distributeVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, adCard) == null) {
            this.q = adCard;
            if (!this.w || (distributeVideoView = this.u) == null) {
                return;
            }
            distributeVideoView.setAdInfo(adCard);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView
    public void setData(VideoInfo videoInfo, mc8 mc8Var, int i, int i2, int i3, int i4) {
        DistributeVideoView distributeVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{videoInfo, mc8Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (videoInfo == null) {
                setVisibility(8);
            } else if (this.w && (distributeVideoView = this.u) != null) {
                distributeVideoView.setData(videoInfo, mc8Var, i, i2, i3, i4);
            } else {
                this.c = videoInfo;
                this.d = mc8Var;
                this.e = i;
                this.f = i2;
                this.g = i3;
                this.h = i4;
                ForeDrawableImageView foreDrawableImageView = this.o;
                if (foreDrawableImageView != null) {
                    foreDrawableImageView.setDefaultResource(0);
                    this.o.setDefaultBgResource(R.drawable.pic_use_header_40_n);
                    if (!ni.isEmpty(videoInfo.thumbnail_url)) {
                        this.o.K(videoInfo.thumbnail_url, 10, false);
                    }
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = i;
                        layoutParams.height = i2;
                    }
                }
                TBLottieAnimationView tBLottieAnimationView = this.n;
                if (tBLottieAnimationView != null) {
                    tBLottieAnimationView.setAnimation(R.raw.obfuscated_res_0x7f110018);
                    this.n.setMinFrame(0);
                    this.n.setFrame(0);
                }
                TextView textView = this.p;
                if (textView != null) {
                    SkinManager.setViewTextColor(textView, (int) R.color.cp_cont_m);
                    this.p.setText(StringUtils.translateSecondsToString(this.c.video_duration.intValue()));
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView
    public void setDownloadCallback(xc7 xc7Var) {
        DistributeVideoView distributeVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, xc7Var) == null) {
            this.s = xc7Var;
            if (!this.w || (distributeVideoView = this.u) == null) {
                return;
            }
            distributeVideoView.setDownloadCallback(xc7Var);
        }
    }

    @Override // android.view.View, com.baidu.tieba.recapp.view.IHomeAdVideoView
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        DistributeVideoView distributeVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) {
            this.v = onClickListener;
            if (!this.w) {
                super.setOnClickListener(new View.OnClickListener(this, onClickListener) { // from class: com.baidu.tieba.recapp.view.DistributeVideoWrapper.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ View.OnClickListener a;
                    public final /* synthetic */ DistributeVideoWrapper b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, onClickListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = this;
                        this.a = onClickListener;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            this.b.c();
                            View.OnClickListener onClickListener2 = this.a;
                            if (onClickListener2 != null) {
                                onClickListener2.onClick(view2);
                            }
                        }
                    }
                });
            }
            if (!this.w || (distributeVideoView = this.u) == null) {
                return;
            }
            distributeVideoView.setOnClickListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView
    public void setPageContext(TbPageContext<?> tbPageContext) {
        DistributeVideoView distributeVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, tbPageContext) == null) {
            this.a = tbPageContext;
            if (!this.w || (distributeVideoView = this.u) == null) {
                return;
            }
            distributeVideoView.setPageContext(tbPageContext);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView
    public void setScheme(String str) {
        DistributeVideoView distributeVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.r = str;
            if (!this.w || (distributeVideoView = this.u) == null) {
                return;
            }
            distributeVideoView.setScheme(str);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView
    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        DistributeVideoView distributeVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048594, this, advertAppInfo, i, str) == null) {
            this.k = advertAppInfo;
            this.l = i;
            this.m = str;
            if (!this.w || (distributeVideoView = this.u) == null) {
                return;
            }
            distributeVideoView.setStatisticInfo(advertAppInfo, i, str);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView
    public void setVideoScalingMode(int i) {
        DistributeVideoView distributeVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.t = i;
            if (!this.w || (distributeVideoView = this.u) == null) {
                return;
            }
            distributeVideoView.setVideoScalingMode(i);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView
    public void setVideoTailFrameData(nc8 nc8Var) {
        DistributeVideoView distributeVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, nc8Var) == null) {
            this.i = nc8Var;
            if (!this.w || (distributeVideoView = this.u) == null) {
                return;
            }
            distributeVideoView.setVideoTailFrameData(nc8Var);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.repackage.aa8
    public void startPlay() {
        DistributeVideoView distributeVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            c();
            if (!this.w || (distributeVideoView = this.u) == null) {
                return;
            }
            distributeVideoView.startPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.repackage.aa8
    public void stopPlay() {
        DistributeVideoView distributeVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && this.w && (distributeVideoView = this.u) != null) {
            distributeVideoView.stopPlay();
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView
    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        DistributeVideoView distributeVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, advertAppInfo) == null) {
            this.j = advertAppInfo;
            if (!this.w || (distributeVideoView = this.u) == null) {
                return;
            }
            distributeVideoView.updateTailFrameView(advertAppInfo);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DistributeVideoWrapper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.t = 1;
        this.w = false;
        b(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DistributeVideoWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.t = 1;
        this.w = false;
        b(context);
    }
}
