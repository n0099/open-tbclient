package com.baidu.tieba.videoplay.verticalviewpager.fragment;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.verticalviewpager.fragment.VideoLoadingFragment;
import com.baidu.tieba.wm5;
import com.baidu.tieba.zaa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/baidu/tieba/videoplay/verticalviewpager/fragment/VideoLoadingFragment;", "Lcom/baidu/tbadk/core/BaseFragment;", "Lcom/baidu/tieba/videoplay/verticalviewpager/transforms/IVideoFragment;", "()V", "mBackHomeAnimListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mCurrentType", "", "mFragmentIndex", "mFromPage", "", "mNetworkChangedMessageListener", "mRootView", "Landroid/view/View;", "mVideoLoadingData", "Lcom/baidu/tieba/video/VideoItemModel;", "getCurrentData", "getFragmentIndex", "hideErrorView", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onPrimary", "setFragmentIndex", "index", "showErrorView", "VideoPlay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class VideoLoadingFragment extends BaseFragment implements zaa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoItemModel a;
    public int b;
    public View c;
    public int d;
    public final CustomMessageListener e;
    public final CustomMessageListener f;

    public static final boolean M1(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, view2)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes8.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoLoadingFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoLoadingFragment videoLoadingFragment) {
            super(2921612);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoLoadingFragment};
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
            this.a = videoLoadingFragment;
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
    public static final class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoLoadingFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(VideoLoadingFragment videoLoadingFragment) {
            super(2000994);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoLoadingFragment};
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
            this.a = videoLoadingFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> resMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, resMsg) == null) {
                Intrinsics.checkNotNullParameter(resMsg, "resMsg");
                if (!(resMsg instanceof NetWorkChangedMessage) || resMsg.getCmd() != 2000994 || resMsg.hasError()) {
                    return;
                }
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921574));
                    return;
                }
                VideoLoadingFragment videoLoadingFragment = this.a;
                videoLoadingFragment.hideLoadingView(videoLoadingFragment.c);
                this.a.N1();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class c extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoLoadingFragment a;

        public c(VideoLoadingFragment videoLoadingFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoLoadingFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoLoadingFragment;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent e1, MotionEvent e2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{e1, e2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                Intrinsics.checkNotNullParameter(e1, "e1");
                Intrinsics.checkNotNullParameter(e2, "e2");
                if (e2.getX() - e1.getX() > 50.0f) {
                    View view2 = this.a.c;
                    if (view2 != null) {
                        view2.cancelLongPress();
                        return true;
                    }
                    return true;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    public VideoLoadingFragment() {
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
        this.e = new b(this);
        this.f = new a(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onActivityCreated(bundle);
            registerListener(this.f);
        }
    }

    @Override // com.baidu.tieba.zaa
    public void w0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.b = i;
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

    public static final void O1(VideoLoadingFragment this$0, View view2) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.d == 5) {
                i = 0;
            } else {
                i = -1;
            }
            int i2 = this$0.d;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921574, Integer.valueOf((i2 == 3 || i2 == 4) ? 1 : 1)));
        }
    }

    public final void K1() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View view3 = this.c;
            if (view3 != null) {
                FrameLayout frameLayout = (FrameLayout) view3;
                wm5 wm5Var = this.mRefreshView;
                if (wm5Var != null) {
                    view2 = wm5Var.b();
                } else {
                    view2 = null;
                }
                frameLayout.removeView(view2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
        }
    }

    @Override // com.baidu.tieba.zaa
    public VideoItemModel O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (VideoItemModel) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroyView();
            this.c = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    K1();
                    showLoadingView(this.c, true);
                    return;
                }
                hideLoadingView(this.c);
                N1();
            }
        }
    }

    @Override // com.baidu.tieba.zaa
    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public final void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            wm5 wm5Var = new wm5(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.yaa
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        VideoLoadingFragment.O1(VideoLoadingFragment.this, view2);
                    }
                }
            });
            this.mRefreshView = wm5Var;
            wm5Var.p();
            this.mRefreshView.m(null);
            String string = getResources().getString(R.string.refresh_view_title_text);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st….refresh_view_title_text)");
            this.mRefreshView.n(string);
            this.mRefreshView.i(R.drawable.new_pic_emotion_08);
            this.mRefreshView.l(0);
            this.mRefreshView.attachView(this.c, true);
        }
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
                this.d = arguments.getInt(VideoPlayActivityConfig.CURRENT_TYPE);
            }
            this.c = inflater.inflate(R.layout.obfuscated_res_0x7f0d09a3, viewGroup, false);
            registerListener(this.e);
            final GestureDetectorCompat gestureDetectorCompat = new GestureDetectorCompat(getContext(), new c(this));
            View view2 = this.c;
            if (view2 != null) {
                view2.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.xaa
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view3, MotionEvent motionEvent) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view3, motionEvent)) == null) ? VideoLoadingFragment.L1(GestureDetectorCompat.this, view3, motionEvent) : invokeLL.booleanValue;
                    }
                });
            }
            View view3 = this.c;
            if (view3 != null) {
                view3.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.waa
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view4) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, view4)) == null) ? VideoLoadingFragment.M1(view4) : invokeL.booleanValue;
                    }
                });
            }
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }
}
