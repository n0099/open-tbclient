package com.baidu.tieba.pb.fragment;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.fragment.VideoFragmentController;
import com.baidu.tieba.qx9;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.zv9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 .2\u00020\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010!\u001a\u00020\u001a2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\"\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u000e\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020\u001aJ\u0012\u0010*\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u000e\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020-R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006/"}, d2 = {"Lcom/baidu/tieba/pb/fragment/VideoFragmentController;", "", "()V", "bdUniqueId", "Lcom/baidu/adp/BdUniqueId;", "getBdUniqueId", "()Lcom/baidu/adp/BdUniqueId;", "setBdUniqueId", "(Lcom/baidu/adp/BdUniqueId;)V", "component", "Lcom/baidu/tieba/pb/fragment/VideoFragmentComponent;", "getComponent", "()Lcom/baidu/tieba/pb/fragment/VideoFragmentComponent;", "component$delegate", "Lkotlin/Lazy;", "mBackImage", "Landroid/widget/ImageView;", "getMBackImage", "()Landroid/widget/ImageView;", "setMBackImage", "(Landroid/widget/ImageView;)V", "mSuspendedViewAnimationListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "getMSuspendedViewAnimationListener", "()Lcom/baidu/adp/framework/listener/CustomMessageListener;", "addVideoBackButton", "", "activity", "Landroid/app/Activity;", "getVideoFragmentArguments", "Landroid/os/Bundle;", "pbData", "Lcom/baidu/tieba/pb/data/PbData;", "initUniqueId", "makeVideoScene", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "postOnResumeDelay", "setVideoBackground", "setVideoFragmentUserVisibleHint", "isVisibleToUser", "", "Companion", "pb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class VideoFragmentController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;
    public ImageView b;
    public BdUniqueId c;
    public final CustomMessageListener d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(436407332, "Lcom/baidu/tieba/pb/fragment/VideoFragmentController;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(436407332, "Lcom/baidu/tieba/pb/fragment/VideoFragmentController;");
        }
    }

    /* loaded from: classes7.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoFragmentController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoFragmentController videoFragmentController) {
            super(2921594);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoFragmentController};
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
            this.a = videoFragmentController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            BdUniqueId tag;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (customResponsedMessage != null) {
                    message = customResponsedMessage.getOrginalMessage();
                } else {
                    message = null;
                }
                if (message == null || (tag = customResponsedMessage.getOrginalMessage().getTag()) == null) {
                    return;
                }
                BdUniqueId c = this.a.c();
                boolean z = false;
                if (c != null && c.getId() == tag.getId()) {
                    z = true;
                }
                if (!z || !(customResponsedMessage.getData() instanceof Float)) {
                    return;
                }
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    float floatValue = ((Float) data).floatValue();
                    if (floatValue >= 0.0f && floatValue <= 1.0f) {
                        ImageView e = this.a.e();
                        Intrinsics.checkNotNull(e);
                        e.setAlpha(floatValue);
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
        }
    }

    public VideoFragmentController() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = LazyKt__LazyJVMKt.lazy(VideoFragmentController$component$2.INSTANCE);
        this.d = new a(this);
    }

    public final BdUniqueId c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final qx9 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (qx9) this.a.getValue();
        }
        return (qx9) invokeV.objValue;
    }

    public final ImageView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (ImageView) invokeV.objValue;
    }

    public final CustomMessageListener f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (CustomMessageListener) invokeV.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ox9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        VideoFragmentController.m(VideoFragmentController.this);
                    }
                }
            }, 500L);
        }
    }

    public static final void b(Activity this_run, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this_run, view2) == null) {
            Intrinsics.checkNotNullParameter(this_run, "$this_run");
            this_run.finish();
        }
    }

    public static final void m(VideoFragmentController this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            BaseFragment b = this$0.d().b();
            if (b != null) {
                b.onResume();
            }
            this$0.o(true);
        }
    }

    public final void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.c = bdUniqueId;
            d().h(bdUniqueId);
        }
    }

    public final void i(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, activity) == null) {
            n(activity);
            a(activity);
        }
    }

    public final void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            WebPManager.setPureDrawable(this.b, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public final void k(Configuration newConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, newConfig) == null) {
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            if (newConfig.orientation == 2) {
                ImageView imageView = this.b;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    return;
                }
                return;
            }
            ImageView imageView2 = this.b;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
        }
    }

    public final void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            d().g(z);
            d().i(z);
        }
    }

    public final void a(final Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && activity != null) {
            ImageView imageView = new ImageView(activity);
            this.b = imageView;
            WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            ImageView imageView2 = this.b;
            Intrinsics.checkNotNull(imageView2);
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.px9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        VideoFragmentController.b(activity, view2);
                    }
                }
            });
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds104), UtilHelper.getDimenPixelSize(R.dimen.tbds104));
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
            layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
            activity.addContentView(this.b, layoutParams);
        }
    }

    public final Bundle g(zv9 zv9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, zv9Var)) == null) {
            if (zv9Var == null) {
                return null;
            }
            ThreadData R = zv9Var.R();
            Intrinsics.checkNotNullExpressionValue(R, "pbData.thread");
            VideoItemData videoItemData = new VideoItemData();
            videoItemData.buildWithThreadData(R);
            ArrayList arrayList = new ArrayList();
            arrayList.add(videoItemData);
            Bundle bundle = new Bundle();
            bundle.putSerializable("video_list", arrayList);
            bundle.putString("from", VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public final void n(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, activity) == null) && activity != null) {
            View findViewById = activity.findViewById(R.id.obfuscated_res_0x7f0907f7);
            if (findViewById != null) {
                findViewById.setBackgroundResource(R.color.CAM_X0611);
            }
            View findViewById2 = activity.findViewById(R.id.obfuscated_res_0x7f090808);
            if (findViewById2 != null) {
                findViewById2.setBackgroundResource(R.color.CAM_X0611);
            }
            activity.getWindow().setBackgroundDrawable(new ColorDrawable(activity.getResources().getColor(R.color.CAM_X0611)));
        }
    }
}
