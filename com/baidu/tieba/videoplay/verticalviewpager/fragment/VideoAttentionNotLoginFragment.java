package com.baidu.tieba.videoplay.verticalviewpager.fragment;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.GestureDetectorCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.view.AttentionNotLoginLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b(\u0010)J\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u0010R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010&\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/baidu/tieba/videoplay/verticalviewpager/fragment/VideoAttentionNotLoginFragment;", "Lc/a/q0/y3/i/a/a;", "Lcom/baidu/tbadk/core/BaseFragment;", "Lcom/baidu/tieba/video/VideoItemModel;", "getCurrentData", "()Lcom/baidu/tieba/video/VideoItemModel;", "", "getFragmentIndex", "()I", "Landroid/os/Bundle;", "savedInstanceState", "", "onActivityCreated", "(Landroid/os/Bundle;)V", WriteMulitImageActivityConfig.SKIN_TYPE, "onChangeSkinType", "(I)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "index", "setFragmentIndex", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mBackHomeAnimListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mCurrentType", "I", "mFragmentIndex", "", "mFromPage", "Ljava/lang/String;", "Lcom/baidu/tieba/videoplay/view/AttentionNotLoginLayout;", "mNotLoginLayout", "Lcom/baidu/tieba/videoplay/view/AttentionNotLoginLayout;", "mVideoNoLoginData", "Lcom/baidu/tieba/video/VideoItemModel;", "<init>", "()V", "VideoPlay_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class VideoAttentionNotLoginFragment extends BaseFragment implements c.a.q0.y3.i.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public VideoItemModel f57884e;

    /* renamed from: f  reason: collision with root package name */
    public int f57885f;

    /* renamed from: g  reason: collision with root package name */
    public AttentionNotLoginLayout f57886g;

    /* renamed from: h  reason: collision with root package name */
    public int f57887h;

    /* renamed from: i  reason: collision with root package name */
    public final CustomMessageListener f57888i;

    /* loaded from: classes7.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoAttentionNotLoginFragment f57889a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoAttentionNotLoginFragment videoAttentionNotLoginFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAttentionNotLoginFragment, Integer.valueOf(i2)};
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
            this.f57889a = videoAttentionNotLoginFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2921612 && this.f57889a.isResumed() && this.f57889a.isVisible()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921611));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements AttentionNotLoginLayout.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoAttentionNotLoginFragment f57890a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b(VideoAttentionNotLoginFragment videoAttentionNotLoginFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoAttentionNotLoginFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57890a = videoAttentionNotLoginFragment;
        }

        @Override // com.baidu.tieba.videoplay.view.AttentionNotLoginLayout.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.f57890a.f57887h == 2 && !z) {
                TbSingleton tbSingleton = TbSingleton.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(tbSingleton, "TbSingleton.getInstance()");
                if (tbSingleton.isFromFeedVideoClick()) {
                    return;
                }
                TbPageContext<BaseFragmentActivity> pageContext = this.f57890a.getPageContext();
                Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
                pageContext.getPageActivity().finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GestureDetectorCompat f57891e;

        public c(GestureDetectorCompat gestureDetectorCompat) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gestureDetectorCompat};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57891e = gestureDetectorCompat;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? this.f57891e.onTouchEvent(motionEvent) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
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

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class e extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f57892e;

        public e(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57892e = view;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                if (motionEvent2.getX() - motionEvent.getX() > 50) {
                    TbSingleton tbSingleton = TbSingleton.getInstance();
                    Intrinsics.checkExpressionValueIsNotNull(tbSingleton, "TbSingleton.getInstance()");
                    if (tbSingleton.isFromFeedVideoClick()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921612));
                    }
                    this.f57892e.cancelLongPress();
                    return true;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    public VideoAttentionNotLoginFragment() {
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
        this.f57885f = -1;
        this.f57888i = new a(this, 2921612);
    }

    @Override // c.a.q0.y3.i.a.a
    public VideoItemModel getCurrentData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f57884e : (VideoItemModel) invokeV.objValue;
    }

    @Override // c.a.q0.y3.i.a.a
    public int getFragmentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57885f : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onActivityCreated(bundle);
            registerListener(this.f57888i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onChangeSkinType(i2);
            AttentionNotLoginLayout attentionNotLoginLayout = this.f57886g;
            if (attentionNotLoginLayout != null) {
                attentionNotLoginLayout.onChangeSkinType(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                Object obj = arguments.get("from");
                if (!(obj instanceof String)) {
                    obj = null;
                }
                String str = (String) obj;
                Object obj2 = arguments.get("video_data");
                this.f57884e = obj2 instanceof VideoItemModel ? obj2 : null;
                this.f57887h = arguments.getInt("current_type");
            }
            View inflate = layoutInflater.inflate(R.layout.video_attention_not_login_fragment, viewGroup, false);
            AttentionNotLoginLayout attentionNotLoginLayout = (AttentionNotLoginLayout) inflate.findViewById(R.id.not_login_layout);
            this.f57886g = attentionNotLoginLayout;
            if (attentionNotLoginLayout != null) {
                attentionNotLoginLayout.setOnAttentionLogin(new b(this));
            }
            inflate.setOnTouchListener(new c(new GestureDetectorCompat(getContext(), new e(inflate))));
            inflate.setOnLongClickListener(new d());
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // c.a.q0.y3.i.a.a
    public void setFragmentIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f57885f = i2;
        }
    }
}
