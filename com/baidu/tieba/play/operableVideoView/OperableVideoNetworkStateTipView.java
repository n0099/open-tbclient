package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.j;
import d.a.d.e.p.l;
import d.a.p0.s.f0.n.a;
import d.a.p0.s.f0.n.c;
import d.a.q0.v3.h;
/* loaded from: classes4.dex */
public class OperableVideoNetworkStateTipView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TBSpecificationBtn f20435e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f20436f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f20437g;

    /* renamed from: h  reason: collision with root package name */
    public String f20438h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperableVideoNetworkStateTipView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c();
    }

    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f20436f.getLayoutParams();
            if (z && !z2) {
                setOrientation(1);
                layoutParams.leftMargin = 0;
                layoutParams.topMargin = (int) getResources().getDimension(R.dimen.tbds62);
            } else {
                setOrientation(0);
                layoutParams.leftMargin = (int) getResources().getDimension(R.dimen.tbds52);
                layoutParams.topMargin = 0;
            }
            this.f20436f.setLayoutParams(layoutParams);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TbSingleton.getInstance().hasAgreeToPlay() : invokeV.booleanValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LinearLayout.inflate(getContext(), getLayoutR(), this);
            this.f20435e = (TBSpecificationBtn) findViewById(R.id.play);
            this.f20436f = (TBSpecificationBtn) findViewById(R.id.free_flow);
            c cVar = new c();
            cVar.r();
            cVar.i(R.drawable.ic_icon_pure_video_play12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
            cVar.g(l.g(getContext(), R.dimen.tbds32));
            this.f20435e.setText(getResources().getString(R.string.video_flow_play));
            this.f20435e.setTextSize(R.dimen.tbds36);
            this.f20435e.setConfig(cVar);
            a aVar = new a();
            this.f20436f.setText(getResources().getString(R.string.video_open_free_data));
            this.f20436f.setTextSize(R.dimen.tbds36);
            this.f20436f.setConfig(aVar);
            this.f20435e.setOnClickListener(this);
            this.f20436f.setOnClickListener(this);
            setOnClickListener(this);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (b() || h.d().e() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !j.x()) ? false : true : invokeV.booleanValue;
    }

    public int getLayoutR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.layout.operable_video_network_state_tip : invokeV.intValue;
    }

    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || view == null) {
            return;
        }
        if (view.getId() == R.id.free_flow) {
            d.a.p0.m.a.u(true, getContext(), getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
        } else if (view.getId() == R.id.play) {
            setHasAgreeToPlay(true);
            View.OnClickListener onClickListener = this.f20437g;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_FLOW_PLAY_CLICK).param("obj_locate", 2).param("tid", this.f20438h));
        }
    }

    public void setHasAgreeToPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            TbSingleton.getInstance().setHasAgreeToPlay(z);
        }
    }

    public void setPlayViewOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.f20437g = onClickListener;
        }
    }

    public void setTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f20438h = str;
        }
    }

    public void setVideoDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
        }
    }

    public void setVideoLength(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048586, this, j) == null) || j <= 0) {
            return;
        }
        this.f20435e.setText(String.format(getResources().getString(R.string.video_data), StringHelper.getFormatSize(j)));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperableVideoNetworkStateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperableVideoNetworkStateTipView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        c();
    }
}
