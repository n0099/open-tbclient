package com.baidu.tieba.videoplay.nad;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.f1.r.b;
import c.a.s0.j3.m;
import c.a.s0.l4.c;
import c.a.s0.l4.e;
import c.a.s0.l4.f;
import c.a.s0.l4.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.view.GestureInterceptTouchFrameLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class AdVideoFlowFragment extends BaseFragment implements b.InterfaceC0814b, c.a.s0.l4.s.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public GestureInterceptTouchFrameLayout f50639e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f50640f;

    /* renamed from: g  reason: collision with root package name */
    public m f50641g;

    /* renamed from: h  reason: collision with root package name */
    public VideoItemModel f50642h;

    /* renamed from: i  reason: collision with root package name */
    public int f50643i;

    /* renamed from: j  reason: collision with root package name */
    public int f50644j;

    /* renamed from: k  reason: collision with root package name */
    public CustomMessageListener f50645k;

    /* loaded from: classes12.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdVideoFlowFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AdVideoFlowFragment adVideoFlowFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adVideoFlowFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adVideoFlowFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921612 && this.a.isResumed() && this.a.isVisible()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921611));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdVideoFlowFragment f50646e;

        public b(AdVideoFlowFragment adVideoFlowFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adVideoFlowFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50646e = adVideoFlowFragment;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                if (motionEvent2.getX() - motionEvent.getX() > 50.0f) {
                    this.f50646e.i();
                    return true;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

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
        this.f50643i = -1;
        this.f50645k = new a(this, 2921612);
    }

    @Override // c.a.s0.l4.s.b.a
    public VideoItemModel getCurrentData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f50642h : (VideoItemModel) invokeV.objValue;
    }

    @Override // c.a.s0.l4.s.b.a
    public int getFragmentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f50643i : invokeV.intValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && TbSingleton.getInstance().isFromFeedVideoClick()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921612));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.f50641g == null) {
                return null;
            }
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f50642h = (VideoItemModel) arguments.get("video_data");
                this.f50644j = arguments.getInt("current_type");
            }
            this.f50641g.setDrawables(WebPManager.getMaskDrawable(e.icon_pure_video_play208, WebPManager.ResourceStateType.NORMAL), WebPManager.getPureDrawable(e.icon_pure_topbar_return40, SkinManager.getColor(c.CAM_X0101), WebPManager.ResourceStateType.NORMAL_PRESS), WebPManager.getMaskDrawable(e.icon_mask_video_gooded36, WebPManager.ResourceStateType.NORMAL_PRESS), WebPManager.getPureDrawable(e.icon_mask_video_good36, SkinManager.getColor(c.CAM_X0101), WebPManager.ResourceStateType.NORMAL_PRESS), WebPManager.getPureDrawable(e.icon_mask_video_reply36, SkinManager.getColor(c.CAM_X0104), WebPManager.ResourceStateType.NORMAL_DISABLE), WebPManager.getPureDrawable(e.icon_mask_video_share36, SkinManager.getColor(c.CAM_X0101), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.f50641g.updateTiebaData(this.f50644j, this.f50642h);
            GestureInterceptTouchFrameLayout gestureInterceptTouchFrameLayout = (GestureInterceptTouchFrameLayout) layoutInflater.inflate(g.ad_video_middle_page, (ViewGroup) null);
            this.f50639e = gestureInterceptTouchFrameLayout;
            FrameLayout frameLayout = (FrameLayout) gestureInterceptTouchFrameLayout.findViewById(f.ad_container);
            this.f50640f = frameLayout;
            frameLayout.removeAllViews();
            this.f50640f.addView((View) this.f50641g);
            this.f50639e.setSimpleOnGestureListener(new b(this));
            registerListener(this.f50645k);
            return this.f50639e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            m mVar = this.f50641g;
            if (mVar == null) {
                return;
            }
            mVar.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            FrameLayout frameLayout = this.f50640f;
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            }
            super.onDestroyView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onPause();
            m mVar = this.f50641g;
            if (mVar == null) {
                return;
            }
            mVar.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPrimary();
            m mVar = this.f50641g;
            if (mVar == null) {
                return;
            }
            mVar.onPrimary(isPrimary());
        }
    }

    @Override // c.a.r0.f1.r.b.InterfaceC0814b
    public void onViewClick() {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (mVar = this.f50641g) == null) {
            return;
        }
        mVar.onViewClick();
    }

    @Override // c.a.r0.f1.r.b.InterfaceC0814b
    public void onViewDoubleClick(float f2, float f3) {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (mVar = this.f50641g) == null) {
            return;
        }
        mVar.onViewDoubleClick();
    }

    @Override // c.a.r0.f1.r.b.InterfaceC0814b
    public void onViewDragToRight() {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (mVar = this.f50641g) == null) {
            return;
        }
        mVar.onViewDragToRight();
    }

    public void setAdView(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, mVar) == null) {
            this.f50641g = mVar;
        }
    }

    @Override // c.a.s0.l4.s.b.a
    public void setFragmentIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f50643i = i2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            super.setUserVisibleHint(z);
            m mVar = this.f50641g;
            if (mVar == null) {
                return;
            }
            mVar.onUserVisibleHint(z);
        }
    }
}
