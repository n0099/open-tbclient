package com.baidu.tieba.videoplay.fragment;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ja5;
import com.baidu.tieba.jm4;
import com.baidu.tieba.km4;
import com.baidu.tieba.videoplay.view.VideoChannelHeaderLayout;
import com.baidu.tieba.videoplay.view.VideoChannelViewPager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class VideoChannelFragment extends AbsVideoChannelFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CustomMessageListener F;

    @Override // com.baidu.tieba.videoplay.fragment.AbsVideoChannelFragment
    public int J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "715" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoChannelFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoChannelFragment videoChannelFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoChannelFragment, Integer.valueOf(i)};
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
            this.a = videoChannelFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.isResumed()) {
                this.a.startBrowseTimeMission();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements BdSwipeRefreshLayout.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoChannelFragment a;

        public b(VideoChannelFragment videoChannelFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoChannelFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoChannelFragment;
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.k
        public void a(int i, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                this.a.i.n(i, i2, z);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements BdSwipeRefreshLayout.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoChannelFragment a;

        public c(VideoChannelFragment videoChannelFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoChannelFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoChannelFragment;
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.k
        public void a(int i, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                this.a.i.n(i, i2, z);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements VideoChannelHeaderLayout.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoChannelFragment a;

        public d(VideoChannelFragment videoChannelFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoChannelFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoChannelFragment;
        }

        @Override // com.baidu.tieba.videoplay.view.VideoChannelHeaderLayout.d
        public void a() {
            VideoChannelViewPager videoChannelViewPager;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                VideoChannelFragment videoChannelFragment = this.a;
                if (videoChannelFragment.i != null && (videoChannelViewPager = videoChannelFragment.h) != null && ListUtils.getItem(videoChannelFragment.n, videoChannelViewPager.getCurrentItem()) != null) {
                    VideoChannelFragment videoChannelFragment2 = this.a;
                    if (((ja5) ListUtils.getItem(videoChannelFragment2.n, videoChannelFragment2.h.getCurrentItem())).a instanceof BaseFragment) {
                        VideoChannelFragment videoChannelFragment3 = this.a;
                        videoChannelFragment3.i.f(((BaseFragment) ((ja5) ListUtils.getItem(videoChannelFragment3.n, videoChannelFragment3.h.getCurrentItem())).a).getUniqueId());
                    }
                }
            }
        }
    }

    public VideoChannelFragment() {
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
        this.F = new a(this, 2921391);
    }

    @Override // com.baidu.tieba.videoplay.fragment.AbsVideoChannelFragment
    public Fragment L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new VideoAttentionPageFragment(this.g, new b(this), 0, 4);
        }
        return (Fragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.videoplay.fragment.AbsVideoChannelFragment
    public Fragment M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new VideoVerticalPageFragment(this.g, new c(this), 1, 3);
        }
        return (Fragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.videoplay.fragment.AbsVideoChannelFragment
    public void T1() {
        VideoChannelHeaderLayout videoChannelHeaderLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (videoChannelHeaderLayout = this.i) != null) {
            videoChannelHeaderLayout.setOnAchieveRefresh(new d(this));
        }
    }

    @Override // com.baidu.tieba.videoplay.fragment.AbsVideoChannelFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.F);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onPause();
            if (km4.w().y(jm4.e0)) {
                km4.w().E();
            }
        }
    }

    @Override // com.baidu.tieba.videoplay.fragment.AbsVideoChannelFragment, com.baidu.tbadk.core.LazyBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                startBrowseTimeMission();
            } else if (km4.w().y(jm4.e0)) {
                km4.w().E();
            }
        }
    }

    @Override // com.baidu.tieba.videoplay.fragment.AbsVideoChannelFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            startBrowseTimeMission();
        }
    }

    public final void startBrowseTimeMission() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            km4.w().N(jm4.e0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public ViewGroup taskAttachParentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.l;
        }
        return (ViewGroup) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onActivityCreated(bundle);
            registerListener(this.F);
        }
    }
}
