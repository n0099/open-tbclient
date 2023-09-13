package com.baidu.tieba.pb.videopb;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.PbCommentFloatActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.gz6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class VideoPbCommentFloatFragment extends AbsVideoPbFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.pb.videopb.AbsVideoPbFragment
    public int I3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.obfuscated_res_0x7f0d09fc : invokeV.intValue;
    }

    @Override // com.baidu.tieba.pb.videopb.AbsVideoPbFragment
    public boolean j4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
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
    public int G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (getActivity() == null || getActivity().getIntent() == null) {
                return 0;
            }
            return getActivity().getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE, 0);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.pb.videopb.AbsVideoPbFragment
    public void h4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.h4();
            gz6 gz6Var = this.b0;
            if (gz6Var != null) {
                gz6Var.i(null);
            }
        }
    }
}
