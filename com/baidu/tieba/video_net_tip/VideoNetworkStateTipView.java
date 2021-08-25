package com.baidu.tieba.video_net_tip;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.m.e;
import c.a.e.e.p.j;
import c.a.q0.w3.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class VideoNetworkStateTipView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f57621e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f57622f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f57623g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f57624h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f57625i;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoNetworkStateTipView f57626e;

        public a(VideoNetworkStateTipView videoNetworkStateTipView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoNetworkStateTipView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57626e = videoNetworkStateTipView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f57626e.hide();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoNetworkStateTipView f57627e;

        public b(VideoNetworkStateTipView videoNetworkStateTipView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoNetworkStateTipView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57627e = videoNetworkStateTipView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.p0.m.a.v(true, this.f57627e.getContext(), this.f57627e.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoNetworkStateTipView(Context context) {
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
        this.f57621e = 3;
        this.f57625i = new a(this);
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            RelativeLayout.inflate(getContext(), R.layout.video_network_state_tip, this);
            this.f57622f = (TextView) findViewById(R.id.play);
            TextView textView = (TextView) findViewById(R.id.free_flow);
            this.f57623g = textView;
            textView.setOnClickListener(new b(this));
            this.f57624h = (TextView) findViewById(R.id.play_tips);
            onChangeSkinType(TbadkApplication.getInst().getSkinType());
        }
    }

    public boolean hasAgreeToPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TbSingleton.getInstance().hasAgreeToPlay() : invokeV.booleanValue;
    }

    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setVisibility(8);
        }
    }

    public boolean isShowNetworkTips() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (hasAgreeToPlay() || h.d().e() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2 || !j.x()) ? false : true : invokeV.booleanValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || this.f57621e == i2) {
            return;
        }
        this.f57621e = i2;
        SkinManager.setViewTextColor(this.f57622f, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(this.f57622f, R.drawable.rectangle_background_alpha80);
        SkinManager.setViewTextColor(this.f57623g, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(this.f57623g, R.drawable.blue_rectangle_background);
        SkinManager.setViewTextColor(this.f57624h, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(this.f57624h, R.drawable.rectangle_background_alpha80);
    }

    public void setHasAgreeToPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            TbSingleton.getInstance().setHasAgreeToPlay(z);
        }
    }

    public void setPlayViewOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.f57622f.setOnClickListener(onClickListener);
        }
    }

    public void showNetWorkTips() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            setVisibility(0);
            this.f57622f.setVisibility(0);
            this.f57623g.setVisibility(0);
            this.f57624h.setVisibility(8);
        }
    }

    public void showPlayTips() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            setVisibility(0);
            this.f57622f.setVisibility(8);
            this.f57623g.setVisibility(8);
            this.f57624h.setVisibility(0);
            e.a().removeCallbacks(this.f57625i);
            e.a().postDelayed(this.f57625i, 3000L);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoNetworkStateTipView(Context context, AttributeSet attributeSet) {
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
        this.f57621e = 3;
        this.f57625i = new a(this);
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoNetworkStateTipView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f57621e = 3;
        this.f57625i = new a(this);
        a();
    }
}
