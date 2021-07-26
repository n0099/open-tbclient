package com.baidu.tieba.pb.videopb;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.PbCommentFloatActivityConfig;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.i0.b;
/* loaded from: classes4.dex */
public class VideoPbCommentFloatFragment extends AbsVideoPbFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public VideoPbCommentFloatFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.pb.videopb.AbsVideoPbFragment
    public void L3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.L3();
            b bVar = this.R0;
            if (bVar != null) {
                bVar.i(null);
            }
        }
    }

    @Override // com.baidu.tieba.pb.videopb.AbsVideoPbFragment
    public boolean N3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.pb.videopb.AbsVideoPbFragment
    public int d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (getActivity() == null || getActivity().getIntent() == null) {
                return 0;
            }
            return getActivity().getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE, 0);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.pb.videopb.AbsVideoPbFragment
    public int f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.video_pb_fragment : invokeV.intValue;
    }

    @Override // com.baidu.tieba.pb.videopb.AbsVideoPbFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            this.q.setVisibility(8);
            this.m.setVisibility(8);
            this.r.setVisibility(8);
            this.s.setVisibility(8);
            this.o = null;
            return onCreateView;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.pb.videopb.AbsVideoPbFragment
    public void z4(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.q.setVisibility(8);
        }
    }
}
