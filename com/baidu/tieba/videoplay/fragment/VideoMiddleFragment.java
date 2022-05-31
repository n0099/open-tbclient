package com.baidu.tieba.videoplay.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.fluency.BdTracesManager;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tieba.videoplay.VideoPlayActivity;
import com.baidu.tieba.videoplay.view.VideoChannelHeaderLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class VideoMiddleFragment extends AbsVideoChannelFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener H;

    /* loaded from: classes4.dex */
    public class a implements BdSwipeRefreshLayout.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddleFragment a;

        public a(VideoMiddleFragment videoMiddleFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddleFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoMiddleFragment;
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.k
        public void a(int i, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                this.a.c.n(0, 0, false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements BdSwipeRefreshLayout.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddleFragment a;

        public b(VideoMiddleFragment videoMiddleFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddleFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoMiddleFragment;
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.k
        public void a(int i, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                this.a.c.n(0, 0, false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddleFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(VideoMiddleFragment videoMiddleFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddleFragment, Integer.valueOf(i)};
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
            this.a = videoMiddleFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (customResponsedMessage == null && customResponsedMessage.getData() == null) {
                    return;
                }
                boolean z = true;
                boolean booleanValue = customResponsedMessage.getData() instanceof Boolean ? ((Boolean) customResponsedMessage.getData()).booleanValue() : true;
                if ((this.a.getActivity() == null || !(this.a.getActivity() instanceof VideoPlayActivity)) ? false : false) {
                    if (booleanValue) {
                        this.a.c.setVisibility(0);
                        this.a.e.setVisibility(0);
                        this.a.d.setVisibility(0);
                        return;
                    }
                    this.a.c.setVisibility(8);
                    this.a.e.setVisibility(8);
                    this.a.d.setVisibility(8);
                }
            }
        }
    }

    public VideoMiddleFragment() {
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
        this.H = new c(this, 2921665);
    }

    @Override // com.baidu.tieba.videoplay.fragment.AbsVideoChannelFragment
    public int S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.videoplay.fragment.AbsVideoChannelFragment
    public Fragment U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new VideoAttentionPageFragment(this.a, new a(this), 0, 2) : (Fragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.videoplay.fragment.AbsVideoChannelFragment
    public Fragment V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new VideoVerticalPageFragment(this.a, new b(this), 1, 1) : (Fragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.videoplay.fragment.AbsVideoChannelFragment
    public void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.tieba.videoplay.fragment.AbsVideoChannelFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(VideoPlayActivityConfig.KEY_FPS_VIDEO_HOME_TAB);
            registerListener(this.H);
        }
    }

    @Override // com.baidu.tieba.videoplay.fragment.AbsVideoChannelFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            Y0(onCreateView);
            if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                VideoChannelHeaderLayout videoChannelHeaderLayout = this.c;
                if (videoChannelHeaderLayout != null) {
                    videoChannelHeaderLayout.setVisibility(8);
                }
                ImageView imageView = this.e;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                ImageView imageView2 = this.d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
            }
            return onCreateView;
        }
        return (View) invokeLLL.objValue;
    }
}
