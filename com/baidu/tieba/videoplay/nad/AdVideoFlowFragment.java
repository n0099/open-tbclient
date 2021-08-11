package com.baidu.tieba.videoplay.nad;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.d1.q.a;
import c.a.p0.x2.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class AdVideoFlowFragment extends BaseFragment implements a.b, c.a.p0.y3.i.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f57692e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f57693f;

    /* renamed from: g  reason: collision with root package name */
    public m f57694g;

    /* renamed from: h  reason: collision with root package name */
    public VideoItemModel f57695h;

    /* renamed from: i  reason: collision with root package name */
    public int f57696i;

    /* renamed from: j  reason: collision with root package name */
    public int f57697j;

    public AdVideoFlowFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57696i = -1;
    }

    @Override // c.a.p0.y3.i.a.a
    public VideoItemModel getCurrentData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f57695h : (VideoItemModel) invokeV.objValue;
    }

    @Override // c.a.p0.y3.i.a.a
    public int getFragmentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57696i : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.f57694g == null) {
                return null;
            }
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f57695h = (VideoItemModel) arguments.get("video_data");
                this.f57697j = arguments.getInt("current_type");
            }
            this.f57694g.setDrawables(WebPManager.getMaskDrawable(R.drawable.icon_pure_video_play208, WebPManager.ResourceStateType.NORMAL), WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_return40, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL_PRESS), WebPManager.getMaskDrawable(R.drawable.icon_mask_video_gooded36, WebPManager.ResourceStateType.NORMAL_PRESS), WebPManager.getPureDrawable(R.drawable.icon_mask_video_good36, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL_PRESS), WebPManager.getPureDrawable(R.drawable.icon_mask_video_reply36, SkinManager.getColor(R.color.CAM_X0104), WebPManager.ResourceStateType.NORMAL_DISABLE), WebPManager.getPureDrawable(R.drawable.icon_mask_video_share36, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.f57694g.updateTiebaData(this.f57697j, this.f57695h);
            View inflate = layoutInflater.inflate(R.layout.ad_video_middle_page, (ViewGroup) null);
            this.f57692e = inflate;
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.ad_container);
            this.f57693f = frameLayout;
            frameLayout.removeAllViews();
            this.f57693f.addView((View) this.f57694g);
            return this.f57692e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            m mVar = this.f57694g;
            if (mVar == null) {
                return;
            }
            mVar.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onPause();
            m mVar = this.f57694g;
            if (mVar == null) {
                return;
            }
            mVar.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPrimary();
            m mVar = this.f57694g;
            if (mVar == null) {
                return;
            }
            mVar.onPrimary(isPrimary());
        }
    }

    @Override // c.a.o0.d1.q.a.b
    public void onViewClick() {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (mVar = this.f57694g) == null) {
            return;
        }
        mVar.onViewClick();
    }

    @Override // c.a.o0.d1.q.a.b
    public void onViewDoubleClick(float f2, float f3) {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (mVar = this.f57694g) == null) {
            return;
        }
        mVar.onViewDoubleClick();
    }

    @Override // c.a.o0.d1.q.a.b
    public void onViewDragToRight() {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (mVar = this.f57694g) == null) {
            return;
        }
        mVar.onViewDragToRight();
    }

    public void setAdView(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, mVar) == null) {
            this.f57694g = mVar;
        }
    }

    @Override // c.a.p0.y3.i.a.a
    public void setFragmentIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f57696i = i2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            super.setUserVisibleHint(z);
            m mVar = this.f57694g;
            if (mVar == null) {
                return;
            }
            mVar.onUserVisibleHint(z);
        }
    }
}
