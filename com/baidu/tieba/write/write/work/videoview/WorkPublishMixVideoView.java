package com.baidu.tieba.write.write.work.videoview;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.TbEditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.TbPreviewVideoActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.j56;
import com.baidu.tieba.s99;
import com.baidu.tieba.t99;
import com.baidu.tieba.uw8;
import com.baidu.tieba.video.EditVideoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u000202J\b\u00106\u001a\u000202H\u0016J\u0006\u00107\u001a\u000202J\b\u00108\u001a\u000202H\u0016J\b\u00109\u001a\u000202H\u0016J\u0006\u0010:\u001a\u000202J\u0006\u0010;\u001a\u000202J\u0012\u0010<\u001a\u0002022\n\u0010=\u001a\u0006\u0012\u0002\b\u00030 J\u0016\u0010>\u001a\u0002022\u0006\u0010/\u001a\u0002002\u0006\u0010?\u001a\u000204J\u0018\u0010@\u001a\u0002022\u0006\u0010A\u001a\u00020\n2\u0006\u0010B\u001a\u00020\nH\u0002R\u0014\u0010\f\u001a\u00020\nX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\nX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\nX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\nX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0012\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/baidu/tieba/write/write/work/videoview/WorkPublishMixVideoView;", "Landroid/widget/LinearLayout;", "Lcom/baidu/tieba/write/write/work/interf/IWriteVideoPreviewListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "STATE_FAILED", "getSTATE_FAILED", "()I", "STATE_MIXING", "getSTATE_MIXING", "STATE_NONE", "getSTATE_NONE", "STATE_SUCCESS", "getSTATE_SUCCESS", WebChromeClient.KEY_ARG_CALLBACK, "Lcom/baidu/tieba/video/EditVideoTaskDataAndCallback;", "editData", "Lcom/baidu/tieba/video/EditVideoData;", "iWorkVideoMixListener", "Lcom/baidu/tieba/write/write/work/interf/IWorkVideoMixListener;", "getIWorkVideoMixListener", "()Lcom/baidu/tieba/write/write/work/interf/IWorkVideoMixListener;", "setIWorkVideoMixListener", "(Lcom/baidu/tieba/write/write/work/interf/IWorkVideoMixListener;)V", "mContext", "Lcom/baidu/tbadk/TbPageContext;", "mRootView", "Landroid/view/View;", "mixPercentText", "Landroid/widget/TextView;", "mixRetryText", "mixState", "mixStateLayout", "mixStateText", "muxerProgressUpdateListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "publishVideoView", "Lcom/baidu/tieba/write/write/work/videoview/WorkPublishVideoView;", "saveEditVideoController", "Lcom/baidu/tieba/controller/ISaveEditVideoController;", "videoInfo", "Lcom/baidu/tbadk/coreExtra/data/VideoInfo;", "initView", "", "isVisible", "", "onChangeSkin", "onCoverEditClick", MissionEvent.MESSAGE_DESTROY, "onEditClick", "onPlayClick", "onStart", MissionEvent.MESSAGE_STOP, "setPageContext", "tbPageContext", "setVideoInfo", "isDraft", "updateStateTexts", "state", "percent", "write_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class WorkPublishMixVideoView extends LinearLayout implements t99 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public int e;
    public View f;
    public TbPageContext<?> g;
    public WorkPublishVideoView h;
    public LinearLayout i;
    public TextView j;
    public TextView k;
    public TextView l;
    public uw8 m;
    public j56 n;
    public VideoInfo o;
    public EditVideoData p;
    public s99 q;
    public final CustomMessageListener r;

    /* loaded from: classes6.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishMixVideoView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(WorkPublishMixVideoView workPublishMixVideoView) {
            super(2921584);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishMixVideoView};
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
            this.a = workPublishMixVideoView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (responsedMessage.getData() instanceof Integer) {
                    Object data = responsedMessage.getData();
                    if (data != null) {
                        int intValue = ((Integer) data).intValue();
                        if (intValue >= 0 && intValue < 100) {
                            WorkPublishMixVideoView workPublishMixVideoView = this.a;
                            workPublishMixVideoView.h(workPublishMixVideoView.getSTATE_MIXING(), intValue);
                            return;
                        } else if (intValue == 100) {
                            WorkPublishMixVideoView workPublishMixVideoView2 = this.a;
                            workPublishMixVideoView2.h(workPublishMixVideoView2.getSTATE_SUCCESS(), intValue);
                            return;
                        } else {
                            return;
                        }
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkPublishMixVideoView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 1;
        this.c = 2;
        this.d = 3;
        this.e = this.a;
        this.r = new a(this);
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkPublishMixVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = 1;
        this.c = 2;
        this.d = 3;
        this.e = this.a;
        this.r = new a(this);
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkPublishMixVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.b = 1;
        this.c = 2;
        this.d = 3;
        this.e = this.a;
        this.r = new a(this);
        e();
    }

    @Override // com.baidu.tieba.t99
    public void a() {
        TbMultiMediaData multiMediaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.e == this.b) {
            return;
        }
        g();
        VideoInfo videoInfo = this.o;
        TbPageContext<?> tbPageContext = null;
        if (videoInfo == null) {
            multiMediaData = null;
        } else {
            multiMediaData = videoInfo.getMultiMediaData();
        }
        if (multiMediaData != null) {
            TiebaStatic.log("c14259");
            TbPageContext<?> tbPageContext2 = this.g;
            if (tbPageContext2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                tbPageContext2 = null;
            }
            TbEditVideoActivityConfig tbEditVideoActivityConfig = new TbEditVideoActivityConfig(tbPageContext2.getPageActivity());
            Intent intent = tbEditVideoActivityConfig.getIntent();
            TbPageContext<?> tbPageContext3 = this.g;
            if (tbPageContext3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                tbPageContext = tbPageContext3;
            }
            intent.putExtras(tbPageContext.getPageActivity().getIntent());
            tbEditVideoActivityConfig.setMultiMediaData(TbEditVideoActivityConfig.convert2MultiMedia(this.o));
            tbEditVideoActivityConfig.setVideoFrom(4);
            VideoInfo videoInfo2 = this.o;
            Intrinsics.checkNotNull(videoInfo2);
            tbEditVideoActivityConfig.setVideoRatio(videoInfo2.getMultiMediaData().videoRatio);
            tbEditVideoActivityConfig.setPageModeType(3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbEditVideoActivityConfig));
        }
    }

    @Override // com.baidu.tieba.t99
    public void c() {
        TbMultiMediaData multiMediaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.e == this.b) {
            return;
        }
        g();
        VideoInfo videoInfo = this.o;
        TbPageContext<?> tbPageContext = null;
        if (videoInfo == null) {
            multiMediaData = null;
        } else {
            multiMediaData = videoInfo.getMultiMediaData();
        }
        if (multiMediaData != null) {
            TiebaStatic.log("c14258");
            TbPageContext<?> tbPageContext2 = this.g;
            if (tbPageContext2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                tbPageContext2 = null;
            }
            TbEditVideoActivityConfig tbEditVideoActivityConfig = new TbEditVideoActivityConfig(tbPageContext2.getPageActivity());
            Intent intent = tbEditVideoActivityConfig.getIntent();
            TbPageContext<?> tbPageContext3 = this.g;
            if (tbPageContext3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                tbPageContext = tbPageContext3;
            }
            intent.putExtras(tbPageContext.getPageActivity().getIntent());
            tbEditVideoActivityConfig.setMultiMediaData(TbEditVideoActivityConfig.convert2MultiMedia(this.o));
            tbEditVideoActivityConfig.setVideoFrom(4);
            VideoInfo videoInfo2 = this.o;
            Intrinsics.checkNotNull(videoInfo2);
            tbEditVideoActivityConfig.setVideoRatio(videoInfo2.getMultiMediaData().videoRatio);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbEditVideoActivityConfig));
        }
    }

    @Override // com.baidu.tieba.t99
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.e != this.b && this.o != null) {
            TbPageContext<?> tbPageContext = this.g;
            if (tbPageContext == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                tbPageContext = null;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbPreviewVideoActivityConfig(tbPageContext.getPageActivity(), this.o)));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            uw8 uw8Var = this.m;
            if (uw8Var != null) {
                Intrinsics.checkNotNull(uw8Var);
                uw8Var.i(true);
            }
            j56 j56Var = this.n;
            if (j56Var != null) {
                Intrinsics.checkNotNull(j56Var);
                j56Var.cancel();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921585));
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0946, (ViewGroup) this, true);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…x_video_view, this, true)");
            this.f = inflate;
            View view2 = null;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                inflate = null;
            }
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f09270c);
            Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.write_video_preview)");
            WorkPublishVideoView workPublishVideoView = (WorkPublishVideoView) findViewById;
            this.h = workPublishVideoView;
            if (workPublishVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
                workPublishVideoView = null;
            }
            workPublishVideoView.setIWriteVideoPreviewListener(this);
            View view3 = this.f;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view3 = null;
            }
            View findViewById2 = view3.findViewById(R.id.obfuscated_res_0x7f09270a);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R…e_video_mix_state_layout)");
            this.i = (LinearLayout) findViewById2;
            View view4 = this.f;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view4 = null;
            }
            View findViewById3 = view4.findViewById(R.id.obfuscated_res_0x7f09270e);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R…d.write_video_state_text)");
            this.j = (TextView) findViewById3;
            View view5 = this.f;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view5 = null;
            }
            View findViewById4 = view5.findViewById(R.id.obfuscated_res_0x7f09270b);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.write_video_percent)");
            this.k = (TextView) findViewById4;
            View view6 = this.f;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            } else {
                view2 = view6;
            }
            View findViewById5 = view2.findViewById(R.id.obfuscated_res_0x7f09270d);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R.id.write_video_retry)");
            this.l = (TextView) findViewById5;
            f();
        }
    }

    public final void f() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            WorkPublishVideoView workPublishVideoView = this.h;
            TextView textView = null;
            if (workPublishVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
                workPublishVideoView = null;
            }
            workPublishVideoView.h();
            TextView textView2 = this.j;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mixStateText");
                textView2 = null;
            }
            if (this.e == this.d) {
                i = R.color.CAM_X0301;
            } else {
                i = R.color.CAM_X0107;
            }
            SkinManager.setViewTextColor(textView2, i);
            TextView textView3 = this.k;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mixPercentText");
                textView3 = null;
            }
            SkinManager.setViewTextColor(textView3, (int) R.color.CAM_X0109);
            TextView textView4 = this.l;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mixRetryText");
            } else {
                textView = textView4;
            }
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0302);
        }
    }

    public final s99 getIWorkVideoMixListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.q;
        }
        return (s99) invokeV.objValue;
    }

    public final int getSTATE_FAILED() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public final int getSTATE_MIXING() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public final int getSTATE_NONE() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public final int getSTATE_SUCCESS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public final void h(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            TextView textView = this.k;
            WorkPublishVideoView workPublishVideoView = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mixPercentText");
                textView = null;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            TbPageContext<?> tbPageContext = this.g;
            if (tbPageContext == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                tbPageContext = null;
            }
            String string = tbPageContext.getString(R.string.obfuscated_res_0x7f0f1575);
            Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(R.string.video_mix_percent)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            textView.setText(format);
            if (i != this.e) {
                this.e = i;
                TextView textView2 = this.j;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mixStateText");
                    textView2 = null;
                }
                if (this.e == this.d) {
                    i3 = R.color.CAM_X0301;
                } else {
                    i3 = R.color.CAM_X0107;
                }
                SkinManager.setViewTextColor(textView2, i3);
                if (i == this.b) {
                    TextView textView3 = this.j;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixStateText");
                        textView3 = null;
                    }
                    TbPageContext<?> tbPageContext2 = this.g;
                    if (tbPageContext2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                        tbPageContext2 = null;
                    }
                    textView3.setText(tbPageContext2.getString(R.string.obfuscated_res_0x7f0f1578));
                    TextView textView4 = this.k;
                    if (textView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixPercentText");
                        textView4 = null;
                    }
                    textView4.setVisibility(0);
                    TextView textView5 = this.l;
                    if (textView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixRetryText");
                        textView5 = null;
                    }
                    textView5.setVisibility(8);
                } else if (i == this.d) {
                    TextView textView6 = this.j;
                    if (textView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixStateText");
                        textView6 = null;
                    }
                    TbPageContext<?> tbPageContext3 = this.g;
                    if (tbPageContext3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                        tbPageContext3 = null;
                    }
                    textView6.setText(tbPageContext3.getString(R.string.obfuscated_res_0x7f0f1574));
                    TextView textView7 = this.k;
                    if (textView7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixPercentText");
                        textView7 = null;
                    }
                    textView7.setVisibility(8);
                    TextView textView8 = this.l;
                    if (textView8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixRetryText");
                        textView8 = null;
                    }
                    textView8.setVisibility(0);
                } else {
                    TextView textView9 = this.j;
                    if (textView9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixStateText");
                        textView9 = null;
                    }
                    TbPageContext<?> tbPageContext4 = this.g;
                    if (tbPageContext4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                        tbPageContext4 = null;
                    }
                    textView9.setText(tbPageContext4.getString(R.string.obfuscated_res_0x7f0f1577));
                    TextView textView10 = this.k;
                    if (textView10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixPercentText");
                        textView10 = null;
                    }
                    textView10.setVisibility(8);
                    TextView textView11 = this.l;
                    if (textView11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixRetryText");
                        textView11 = null;
                    }
                    textView11.setVisibility(8);
                }
                s99 s99Var = this.q;
                if (s99Var != null) {
                    s99Var.f(this.e);
                }
            }
            WorkPublishVideoView workPublishVideoView2 = this.h;
            if (workPublishVideoView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
            } else {
                workPublishVideoView = workPublishVideoView2;
            }
            workPublishVideoView.j(i2 / 100.0f);
        }
    }

    public final void setIWorkVideoMixListener(s99 s99Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, s99Var) == null) {
            this.q = s99Var;
        }
    }

    public final void setPageContext(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, tbPageContext) == null) {
            Intrinsics.checkNotNullParameter(tbPageContext, "tbPageContext");
            this.g = tbPageContext;
            CustomMessageListener customMessageListener = this.r;
            if (tbPageContext == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                tbPageContext = null;
            }
            customMessageListener.setTag(tbPageContext.getUniqueId());
            MessageManager.getInstance().registerListener(this.r);
        }
    }

    public final void setVideoInfo(VideoInfo videoInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, videoInfo, z) == null) {
            Intrinsics.checkNotNullParameter(videoInfo, "videoInfo");
            EditVideoData editVideoData = videoInfo.getEditVideoData();
            this.p = editVideoData;
            this.o = videoInfo;
            WorkPublishVideoView workPublishVideoView = null;
            if (editVideoData != null) {
                Intrinsics.checkNotNull(editVideoData);
                if (editVideoData.isLegal()) {
                    LinearLayout linearLayout = this.i;
                    if (linearLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixStateLayout");
                        linearLayout = null;
                    }
                    linearLayout.setVisibility(0);
                    WorkPublishVideoView workPublishVideoView2 = this.h;
                    if (workPublishVideoView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
                        workPublishVideoView2 = null;
                    }
                    workPublishVideoView2.setVisibility(0);
                    try {
                        WorkPublishVideoView workPublishVideoView3 = this.h;
                        if (workPublishVideoView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
                            workPublishVideoView3 = null;
                        }
                        workPublishVideoView3.setVideoInfo(this.p);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (z) {
                        WorkPublishVideoView workPublishVideoView4 = this.h;
                        if (workPublishVideoView4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
                        } else {
                            workPublishVideoView = workPublishVideoView4;
                        }
                        workPublishVideoView.j(1.0f);
                        return;
                    }
                    return;
                }
            }
            LinearLayout linearLayout2 = this.i;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mixStateLayout");
                linearLayout2 = null;
            }
            linearLayout2.setVisibility(8);
            WorkPublishVideoView workPublishVideoView5 = this.h;
            if (workPublishVideoView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
                workPublishVideoView5 = null;
            }
            workPublishVideoView5.setVisibility(8);
            WorkPublishVideoView workPublishVideoView6 = this.h;
            if (workPublishVideoView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
            } else {
                workPublishVideoView = workPublishVideoView6;
            }
            workPublishVideoView.i();
            uw8 uw8Var = this.m;
            if (uw8Var != null) {
                uw8Var.i(true);
            }
            j56 j56Var = this.n;
            if (j56Var != null) {
                j56Var.cancel();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921585));
        }
    }
}
