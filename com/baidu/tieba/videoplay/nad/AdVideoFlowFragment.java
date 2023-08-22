package com.baidu.tieba.videoplay.nad;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.f1a;
import com.baidu.tieba.hta;
import com.baidu.tieba.n26;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.view.GestureInterceptTouchFrameLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class AdVideoFlowFragment extends BaseFragment implements n26.b, hta {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GestureInterceptTouchFrameLayout a;
    public FrameLayout b;
    public f1a c;
    public VideoItemModel d;
    public int e;
    public int f;
    public CustomMessageListener g;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdVideoFlowFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AdVideoFlowFragment adVideoFlowFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adVideoFlowFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                if (this.a.getActivity() != null) {
                    this.a.getActivity().finish();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdVideoFlowFragment a;

        public b(AdVideoFlowFragment adVideoFlowFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adVideoFlowFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adVideoFlowFragment;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                if (motionEvent2.getX() - motionEvent.getX() > 50.0f) {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = -1;
        this.g = new a(this, 2921612);
    }

    @Override // com.baidu.tieba.hta
    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.hta
    public VideoItemModel X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (VideoItemModel) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            f1a f1aVar = this.c;
            if (f1aVar == null) {
                return;
            }
            f1aVar.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            FrameLayout frameLayout = this.b;
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            }
            super.onDestroyView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPause();
            f1a f1aVar = this.c;
            if (f1aVar == null) {
                return;
            }
            f1aVar.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPrimary();
            f1a f1aVar = this.c;
            if (f1aVar == null) {
                return;
            }
            f1aVar.onPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tieba.n26.b
    public void onViewClick() {
        f1a f1aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || (f1aVar = this.c) == null) {
            return;
        }
        f1aVar.onViewClick();
    }

    @Override // com.baidu.tieba.n26.b
    public void onViewDragToRight() {
        f1a f1aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || (f1aVar = this.c) == null) {
            return;
        }
        f1aVar.onViewDragToRight();
    }

    @Override // com.baidu.tieba.n26.b
    public void C0(float f, float f2) {
        f1a f1aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) != null) || (f1aVar = this.c) == null) {
            return;
        }
        f1aVar.onViewDoubleClick();
    }

    @Override // com.baidu.tieba.hta
    public void E0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.e = i;
        }
    }

    public void U1(f1a f1aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, f1aVar) == null) {
            this.c = f1aVar;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            super.setUserVisibleHint(z);
            f1a f1aVar = this.c;
            if (f1aVar == null) {
                return;
            }
            f1aVar.onUserVisibleHint(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.c == null) {
                return null;
            }
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.d = (VideoItemModel) arguments.get("video_data");
                this.f = arguments.getInt(VideoPlayActivityConfig.CURRENT_TYPE);
            }
            this.c.setDrawables(WebPManager.getMaskDrawable((int) R.drawable.icon_pure_video_play208, WebPManager.ResourceStateType.NORMAL), WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_return40, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL_PRESS), WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080a26, WebPManager.ResourceStateType.NORMAL_PRESS), WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a24, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL_PRESS), WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a2b, SkinManager.getColor(R.color.CAM_X0104), WebPManager.ResourceStateType.NORMAL_DISABLE), WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a2c, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.c.updateTiebaData(this.f, this.d);
            GestureInterceptTouchFrameLayout gestureInterceptTouchFrameLayout = (GestureInterceptTouchFrameLayout) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d007a, (ViewGroup) null);
            this.a = gestureInterceptTouchFrameLayout;
            FrameLayout frameLayout = (FrameLayout) gestureInterceptTouchFrameLayout.findViewById(R.id.obfuscated_res_0x7f0900aa);
            this.b = frameLayout;
            frameLayout.removeAllViews();
            this.b.addView((View) this.c);
            this.a.setSimpleOnGestureListener(new b(this));
            registerListener(this.g);
            return this.a;
        }
        return (View) invokeLLL.objValue;
    }
}
