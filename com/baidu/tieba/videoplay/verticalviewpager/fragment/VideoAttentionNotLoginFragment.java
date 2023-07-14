package com.baidu.tieba.videoplay.verticalviewpager.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.tpa;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.verticalviewpager.fragment.VideoAttentionNotLoginFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\n\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\u0012\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\"\u001a\u00020\u0013H\u0016J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006%"}, d2 = {"Lcom/baidu/tieba/videoplay/verticalviewpager/fragment/VideoAttentionNotLoginFragment;", "Lcom/baidu/tbadk/core/BaseFragment;", "Lcom/baidu/tieba/videoplay/verticalviewpager/transforms/IVideoFragment;", "()V", "mBackHomeAnimListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mCurrentType", "", "mFragmentIndex", "mFromPage", "", "mNotLoginView", "Lcom/baidu/tbadk/core/view/NoDataView;", "mVideoNoLoginData", "Lcom/baidu/tieba/video/VideoItemModel;", "userChangeListener", "com/baidu/tieba/videoplay/verticalviewpager/fragment/VideoAttentionNotLoginFragment$userChangeListener$1", "Lcom/baidu/tieba/videoplay/verticalviewpager/fragment/VideoAttentionNotLoginFragment$userChangeListener$1;", "createNotLoginView", "", "rooView", "Landroid/view/View;", "getCurrentData", "getFragmentIndex", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "setFragmentIndex", "index", "VideoPlay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class VideoAttentionNotLoginFragment extends BaseFragment implements tpa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoItemModel a;
    public int b;
    public NoDataView c;
    public final CustomMessageListener d;
    public final d e;

    /* loaded from: classes8.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAttentionNotLoginFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoAttentionNotLoginFragment videoAttentionNotLoginFragment) {
            super(2921612);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAttentionNotLoginFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoAttentionNotLoginFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (responsedMessage.getCmd() == 2921612 && this.a.isResumed() && this.a.isVisible()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921611));
                    FragmentActivity activity = this.a.getActivity();
                    if (activity != null) {
                        activity.finish();
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, v)) == null) {
                Intrinsics.checkNotNullParameter(v, "v");
                return true;
            }
            return invokeL.booleanValue;
        }

        public b() {
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
    }

    /* loaded from: classes8.dex */
    public static final class c extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public c(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent e1, MotionEvent e2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{e1, e2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                Intrinsics.checkNotNullParameter(e1, "e1");
                Intrinsics.checkNotNullParameter(e2, "e2");
                if (e2.getX() - e1.getX() > 50.0f) {
                    this.a.cancelLongPress();
                    return true;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoAttentionNotLoginFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(VideoAttentionNotLoginFragment videoAttentionNotLoginFragment) {
            super(2921410);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAttentionNotLoginFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoAttentionNotLoginFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && TbadkCoreApplication.isLogin()) {
                NoDataView noDataView = this.a.c;
                if (noDataView != null) {
                    noDataView.setVisibility(8);
                }
                VideoAttentionNotLoginFragment videoAttentionNotLoginFragment = this.a;
                videoAttentionNotLoginFragment.showLoadingView(videoAttentionNotLoginFragment.getView());
            }
        }
    }

    public VideoAttentionNotLoginFragment() {
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
        this.b = -1;
        this.d = new a(this);
        this.e = new d(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onActivityCreated(bundle);
            registerListener(this.d);
            registerListener(this.e);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            NoDataView noDataView = this.c;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i);
            }
            NoDataView noDataView2 = this.c;
            if (noDataView2 != null) {
                noDataView2.setTitleTextColor(R.color.CAM_X0107, 4);
            }
        }
    }

    @Override // com.baidu.tieba.tpa
    public void w0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.b = i;
        }
    }

    public static final void K1(VideoAttentionNotLoginFragment this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!ViewHelper.checkUpIsLogin(this$0.getContext())) {
                TbSingleton.loginFrom = 1;
            }
        }
    }

    public static final boolean L1(GestureDetectorCompat detectorCompat, View view2, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, detectorCompat, view2, motionEvent)) == null) {
            Intrinsics.checkNotNullParameter(detectorCompat, "$detectorCompat");
            return detectorCompat.onTouchEvent(motionEvent);
        }
        return invokeLLL.booleanValue;
    }

    public final void J1(View view2) {
        String str;
        Resources resources;
        Resources resources2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ppa
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                        VideoAttentionNotLoginFragment.K1(VideoAttentionNotLoginFragment.this, view3);
                    }
                }
            };
            NoDataViewFactory.d a2 = NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NOTLOGIN);
            Context context = getContext();
            String str2 = null;
            if (context != null && (resources2 = context.getResources()) != null) {
                str = resources2.getString(R.string.obfuscated_res_0x7f0f17d4);
            } else {
                str = null;
            }
            NoDataViewFactory.e d2 = NoDataViewFactory.e.d(null, str);
            Context context2 = getContext();
            if (context2 != null && (resources = context2.getResources()) != null) {
                str2 = resources.getString(R.string.obfuscated_res_0x7f0f0462);
            }
            NoDataView a3 = NoDataViewFactory.a(getContext(), view2, a2, d2, NoDataViewFactory.c.a(new NoDataViewFactory.b(str2, onClickListener)));
            this.c = a3;
            if (a3 != null) {
                a3.setTitleTextColor(R.color.CAM_X0107, 4);
            }
            NoDataView noDataView = this.c;
            if (noDataView != null) {
                noDataView.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.tpa
    public VideoItemModel O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (VideoItemModel) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroyView();
        }
    }

    @Override // com.baidu.tieba.tpa
    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        VideoItemModel videoItemModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Bundle arguments = getArguments();
            if (arguments != null) {
                Object obj = arguments.get("from");
                if (obj instanceof String) {
                    String str = (String) obj;
                }
                Object obj2 = arguments.get("video_data");
                if (obj2 instanceof VideoItemModel) {
                    videoItemModel = (VideoItemModel) obj2;
                } else {
                    videoItemModel = null;
                }
                this.a = videoItemModel;
                arguments.getInt(VideoPlayActivityConfig.CURRENT_TYPE);
            }
            View rooView = inflater.inflate(R.layout.obfuscated_res_0x7f0d09c4, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(rooView, "rooView");
            J1(rooView);
            final GestureDetectorCompat gestureDetectorCompat = new GestureDetectorCompat(getContext(), new c(rooView));
            rooView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.opa
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) ? VideoAttentionNotLoginFragment.L1(GestureDetectorCompat.this, view2, motionEvent) : invokeLL.booleanValue;
                }
            });
            rooView.setOnLongClickListener(new b());
            return rooView;
        }
        return (View) invokeLLL.objValue;
    }
}
