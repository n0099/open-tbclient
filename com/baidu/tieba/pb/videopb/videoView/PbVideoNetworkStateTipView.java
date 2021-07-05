package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.r0.l.a;
import d.a.s0.v3.f;
/* loaded from: classes5.dex */
public class PbVideoNetworkStateTipView extends OperableVideoNetworkStateTipView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public TextView f19813i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbVideoNetworkStateTipView(Context context) {
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

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f19813i = (TextView) findViewById(R.id.video_net_tip_duration);
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView
    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (b() || f.d().e() || TbadkCoreApplication.getInst().getVideoAutoPlayReal() == 2 || !j.x()) ? false : true : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView
    public int getLayoutR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.pb_video_network_state_tip : invokeV.intValue;
    }

    @Override // com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || view == null) {
            return;
        }
        if (view.getId() == R.id.free_flow) {
            a.u(true, getContext(), getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
        } else if (view.getId() == R.id.play) {
            View.OnClickListener onClickListener = this.f20273g;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            TiebaStatic.log("c12618");
        }
    }

    @Override // com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView
    public void setVideoDuration(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.f19813i.setText(String.format(getResources().getString(R.string.pb_video_duration), StringHelper.stringForVideoTime(i2 * 1000)));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbVideoNetworkStateTipView(Context context, AttributeSet attributeSet) {
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
    public PbVideoNetworkStateTipView(Context context, AttributeSet attributeSet, int i2) {
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
