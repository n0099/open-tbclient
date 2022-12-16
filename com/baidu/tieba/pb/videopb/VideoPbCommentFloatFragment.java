package com.baidu.tieba.pb.videopb;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.PbCommentFloatActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.wa6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class VideoPbCommentFloatFragment extends AbsVideoPbFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.pb.videopb.AbsVideoPbFragment
    public boolean A4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.pb.videopb.AbsVideoPbFragment
    public boolean C4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.pb.videopb.AbsVideoPbFragment
    public int S3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.obfuscated_res_0x7f0d090c : invokeV.intValue;
    }

    public VideoPbCommentFloatFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.pb.videopb.AbsVideoPbFragment
    public int Q3() {
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
    public void y4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.y4();
            wa6 wa6Var = this.K0;
            if (wa6Var != null) {
                wa6Var.i(null);
            }
        }
    }

    @Override // com.baidu.tieba.pb.videopb.AbsVideoPbFragment
    public void o5(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.m.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.AbsVideoPbFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            this.m.setVisibility(8);
            this.i.setVisibility(8);
            this.n.setVisibility(8);
            this.o.setVisibility(8);
            this.k = null;
            return onCreateView;
        }
        return (View) invokeLLL.objValue;
    }
}
