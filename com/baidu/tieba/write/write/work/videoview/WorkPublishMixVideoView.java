package com.baidu.tieba.write.write.work.videoview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.d4.u.p.c.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiOptions;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.TbEditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.TbPreviewVideoActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.video.EditVideoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\b\u0016\u0012\b\u0010M\u001a\u0004\u0018\u00010L¢\u0006\u0004\bN\u0010OB\u001d\b\u0016\u0012\b\u0010M\u001a\u0004\u0018\u00010L\u0012\b\u0010Q\u001a\u0004\u0018\u00010P¢\u0006\u0004\bN\u0010RB%\b\u0016\u0012\b\u0010M\u001a\u0004\u0018\u00010L\u0012\b\u0010Q\u001a\u0004\u0018\u00010P\u0012\u0006\u0010S\u001a\u00020\u0019¢\u0006\u0004\bN\u0010TJ\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0005J\r\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0005J\r\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u0005J\r\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0005J\u0019\u0010\u0012\u001a\u00020\u00032\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u00020\u00198\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\"\u001a\u00020\u00198\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010!R\u001c\u0010$\u001a\u00020\u00198\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!R\u001c\u0010&\u001a\u00020\u00198\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b&\u0010\u001f\u001a\u0004\b'\u0010!R\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R$\u0010/\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u0006\u0012\u0002\b\u00030\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b=\u0010<R\u0016\u0010>\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010\u001fR\u0016\u0010?\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020:8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bA\u0010<R\u0016\u0010C\u001a\u00020B8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010F\u001a\u00020E8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010I\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010K¨\u0006U"}, d2 = {"Lcom/baidu/tieba/write/write/work/videoview/WorkPublishMixVideoView;", "Lb/a/r0/d4/u/p/c/b;", "Landroid/widget/LinearLayout;", "", "initView", "()V", "", "isVisible", "()Z", "onChangeSkin", "onCoverEditClick", MissionEvent.MESSAGE_DESTROY, "onEditClick", "onPlayClick", "onStart", MissionEvent.MESSAGE_STOP, "Lcom/baidu/tbadk/TbPageContext;", "tbPageContext", "setPageContext", "(Lcom/baidu/tbadk/TbPageContext;)V", "Lcom/baidu/tbadk/coreExtra/data/VideoInfo;", TbPreviewVideoActivityConfig.KEY_VIDEO_INFO, "isDraft", "setVideoInfo", "(Lcom/baidu/tbadk/coreExtra/data/VideoInfo;Z)V", "", "state", SapiOptions.KEY_CACHE_PERCENT, "updateStateTexts", "(II)V", "STATE_FAILED", "I", "getSTATE_FAILED", "()I", "STATE_MIXING", "getSTATE_MIXING", "STATE_NONE", "getSTATE_NONE", "STATE_SUCCESS", "getSTATE_SUCCESS", "Lcom/baidu/tieba/video/EditVideoTaskDataAndCallback;", "callback", "Lcom/baidu/tieba/video/EditVideoTaskDataAndCallback;", "Lcom/baidu/tieba/video/EditVideoData;", "editData", "Lcom/baidu/tieba/video/EditVideoData;", "Lcom/baidu/tieba/write/write/work/interf/IWorkVideoMixListener;", "iWorkVideoMixListener", "Lcom/baidu/tieba/write/write/work/interf/IWorkVideoMixListener;", "getIWorkVideoMixListener", "()Lcom/baidu/tieba/write/write/work/interf/IWorkVideoMixListener;", "setIWorkVideoMixListener", "(Lcom/baidu/tieba/write/write/work/interf/IWorkVideoMixListener;)V", "mContext", "Lcom/baidu/tbadk/TbPageContext;", "Landroid/view/View;", "mRootView", "Landroid/view/View;", "Landroid/widget/TextView;", "mixPercentText", "Landroid/widget/TextView;", "mixRetryText", "mixState", "mixStateLayout", "Landroid/widget/LinearLayout;", "mixStateText", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "muxerProgressUpdateListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "Lcom/baidu/tieba/write/write/work/videoview/WorkPublishVideoView;", "publishVideoView", "Lcom/baidu/tieba/write/write/work/videoview/WorkPublishVideoView;", "Lcom/baidu/tieba/controller/ISaveEditVideoController;", "saveEditVideoController", "Lcom/baidu/tieba/controller/ISaveEditVideoController;", "Lcom/baidu/tbadk/coreExtra/data/VideoInfo;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "write_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class WorkPublishMixVideoView extends LinearLayout implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f56338e;

    /* renamed from: f  reason: collision with root package name */
    public final int f56339f;

    /* renamed from: g  reason: collision with root package name */
    public final int f56340g;

    /* renamed from: h  reason: collision with root package name */
    public final int f56341h;

    /* renamed from: i  reason: collision with root package name */
    public int f56342i;
    public View j;
    public TbPageContext<?> k;
    public WorkPublishVideoView l;
    public LinearLayout m;
    public TextView n;
    public TextView o;
    public TextView p;
    public b.a.r0.z3.b q;
    public b.a.r0.f0.b r;
    public VideoInfo s;
    public EditVideoData t;
    public b.a.r0.d4.u.p.c.a u;
    public final CustomMessageListener v;

    /* loaded from: classes10.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishMixVideoView f56343a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(WorkPublishMixVideoView workPublishMixVideoView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishMixVideoView, Integer.valueOf(i2)};
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
            this.f56343a = workPublishMixVideoView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof Integer)) {
                Object data = customResponsedMessage.getData();
                if (data == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                }
                int intValue = ((Integer) data).intValue();
                if (intValue >= 0 && intValue < 100) {
                    WorkPublishMixVideoView workPublishMixVideoView = this.f56343a;
                    workPublishMixVideoView.a(workPublishMixVideoView.getSTATE_MIXING(), intValue);
                } else if (intValue == 100) {
                    WorkPublishMixVideoView workPublishMixVideoView2 = this.f56343a;
                    workPublishMixVideoView2.a(workPublishMixVideoView2.getSTATE_SUCCESS(), intValue);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56339f = 1;
        this.f56340g = 2;
        this.f56341h = 3;
        this.f56342i = this.f56338e;
        this.v = new a(this, 2921584);
        initView();
    }

    public final void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            TextView textView = this.o;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mixPercentText");
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            TbPageContext<?> tbPageContext = this.k;
            if (tbPageContext == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            }
            String string = tbPageContext.getString(R.string.video_mix_percent);
            Intrinsics.checkExpressionValueIsNotNull(string, "mContext.getString(R.string.video_mix_percent)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            textView.setText(format);
            if (i2 != this.f56342i) {
                this.f56342i = i2;
                TextView textView2 = this.n;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mixStateText");
                }
                SkinManager.setViewTextColor(textView2, this.f56342i == this.f56341h ? R.color.CAM_X0301 : R.color.CAM_X0107);
                if (i2 == this.f56339f) {
                    TextView textView3 = this.n;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixStateText");
                    }
                    TbPageContext<?> tbPageContext2 = this.k;
                    if (tbPageContext2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    }
                    textView3.setText(tbPageContext2.getString(R.string.video_mixing));
                    TextView textView4 = this.o;
                    if (textView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixPercentText");
                    }
                    textView4.setVisibility(0);
                    TextView textView5 = this.p;
                    if (textView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixRetryText");
                    }
                    textView5.setVisibility(8);
                } else if (i2 == this.f56341h) {
                    TextView textView6 = this.n;
                    if (textView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixStateText");
                    }
                    TbPageContext<?> tbPageContext3 = this.k;
                    if (tbPageContext3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    }
                    textView6.setText(tbPageContext3.getString(R.string.video_mix_failed));
                    TextView textView7 = this.o;
                    if (textView7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixPercentText");
                    }
                    textView7.setVisibility(8);
                    TextView textView8 = this.p;
                    if (textView8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixRetryText");
                    }
                    textView8.setVisibility(0);
                } else {
                    TextView textView9 = this.n;
                    if (textView9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixStateText");
                    }
                    TbPageContext<?> tbPageContext4 = this.k;
                    if (tbPageContext4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    }
                    textView9.setText(tbPageContext4.getString(R.string.video_mix_success));
                    TextView textView10 = this.o;
                    if (textView10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixPercentText");
                    }
                    textView10.setVisibility(8);
                    TextView textView11 = this.p;
                    if (textView11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixRetryText");
                    }
                    textView11.setVisibility(8);
                }
                b.a.r0.d4.u.p.c.a aVar = this.u;
                if (aVar != null) {
                    aVar.onMixStateChanged(this.f56342i);
                }
            }
            WorkPublishVideoView workPublishVideoView = this.l;
            if (workPublishVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
            }
            workPublishVideoView.updatePercent(i3 / 100.0f);
        }
    }

    public final b.a.r0.d4.u.p.c.a getIWorkVideoMixListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.u : (b.a.r0.d4.u.p.c.a) invokeV.objValue;
    }

    public final int getSTATE_FAILED() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f56341h : invokeV.intValue;
    }

    public final int getSTATE_MIXING() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f56339f : invokeV.intValue;
    }

    public final int getSTATE_NONE() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f56338e : invokeV.intValue;
    }

    public final int getSTATE_SUCCESS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f56340g : invokeV.intValue;
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.work_publish_mix_video_view, (ViewGroup) this, true);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(cont…x_video_view, this, true)");
            this.j = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            View findViewById = inflate.findViewById(R.id.write_video_preview);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "mRootView.findViewById(R.id.write_video_preview)");
            WorkPublishVideoView workPublishVideoView = (WorkPublishVideoView) findViewById;
            this.l = workPublishVideoView;
            if (workPublishVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
            }
            workPublishVideoView.setIWriteVideoPreviewListener(this);
            View view = this.j;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            View findViewById2 = view.findViewById(R.id.write_video_mix_state_layout);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "mRootView.findViewById(R…e_video_mix_state_layout)");
            this.m = (LinearLayout) findViewById2;
            View view2 = this.j;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            View findViewById3 = view2.findViewById(R.id.write_video_state_text);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "mRootView.findViewById(R…d.write_video_state_text)");
            this.n = (TextView) findViewById3;
            View view3 = this.j;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            View findViewById4 = view3.findViewById(R.id.write_video_percent);
            Intrinsics.checkExpressionValueIsNotNull(findViewById4, "mRootView.findViewById(R.id.write_video_percent)");
            this.o = (TextView) findViewById4;
            View view4 = this.j;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            }
            View findViewById5 = view4.findViewById(R.id.write_video_retry);
            Intrinsics.checkExpressionValueIsNotNull(findViewById5, "mRootView.findViewById(R.id.write_video_retry)");
            this.p = (TextView) findViewById5;
            onChangeSkin();
        }
    }

    public final boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            WorkPublishVideoView workPublishVideoView = this.l;
            if (workPublishVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
            }
            if (workPublishVideoView != null) {
                WorkPublishVideoView workPublishVideoView2 = this.l;
                if (workPublishVideoView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
                }
                if (workPublishVideoView2 == null) {
                    Intrinsics.throwNpe();
                }
                if (workPublishVideoView2.getVisibility() == 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void onChangeSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            WorkPublishVideoView workPublishVideoView = this.l;
            if (workPublishVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
            }
            workPublishVideoView.onChangeSkin();
            TextView textView = this.n;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mixStateText");
            }
            SkinManager.setViewTextColor(textView, this.f56342i == this.f56341h ? R.color.CAM_X0301 : R.color.CAM_X0107);
            TextView textView2 = this.o;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mixPercentText");
            }
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0109);
            TextView textView3 = this.p;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mixRetryText");
            }
            SkinManager.setViewTextColor(textView3, R.color.CAM_X0302);
        }
    }

    @Override // b.a.r0.d4.u.p.c.b
    public void onCoverEditClick() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f56342i == this.f56339f) {
            return;
        }
        onDestroy();
        VideoInfo videoInfo = this.s;
        if ((videoInfo != null ? videoInfo.getMultiMediaData() : null) != null) {
            TiebaStatic.log("c14259");
            TbPageContext<?> tbPageContext = this.k;
            if (tbPageContext == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            }
            TbEditVideoActivityConfig tbEditVideoActivityConfig = new TbEditVideoActivityConfig(tbPageContext.getPageActivity());
            Intent intent = tbEditVideoActivityConfig.getIntent();
            TbPageContext<?> tbPageContext2 = this.k;
            if (tbPageContext2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            }
            Activity pageActivity = tbPageContext2.getPageActivity();
            Intrinsics.checkExpressionValueIsNotNull(pageActivity, "mContext.pageActivity");
            intent.putExtras(pageActivity.getIntent());
            tbEditVideoActivityConfig.setMultiMediaData(TbEditVideoActivityConfig.convert2MultiMedia(this.s));
            tbEditVideoActivityConfig.setVideoFrom(4);
            VideoInfo videoInfo2 = this.s;
            if (videoInfo2 == null) {
                Intrinsics.throwNpe();
            }
            tbEditVideoActivityConfig.setVideoRatio(videoInfo2.getMultiMediaData().videoRatio);
            tbEditVideoActivityConfig.setPageModeType(3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbEditVideoActivityConfig));
        }
    }

    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            b.a.r0.z3.b bVar = this.q;
            if (bVar != null) {
                if (bVar == null) {
                    Intrinsics.throwNpe();
                }
                bVar.i(true);
            }
            b.a.r0.f0.b bVar2 = this.r;
            if (bVar2 != null) {
                if (bVar2 == null) {
                    Intrinsics.throwNpe();
                }
                bVar2.cancel();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921585));
        }
    }

    @Override // b.a.r0.d4.u.p.c.b
    public void onEditClick() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f56342i == this.f56339f) {
            return;
        }
        onDestroy();
        VideoInfo videoInfo = this.s;
        if ((videoInfo != null ? videoInfo.getMultiMediaData() : null) != null) {
            TiebaStatic.log("c14258");
            TbPageContext<?> tbPageContext = this.k;
            if (tbPageContext == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            }
            TbEditVideoActivityConfig tbEditVideoActivityConfig = new TbEditVideoActivityConfig(tbPageContext.getPageActivity());
            Intent intent = tbEditVideoActivityConfig.getIntent();
            TbPageContext<?> tbPageContext2 = this.k;
            if (tbPageContext2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            }
            Activity pageActivity = tbPageContext2.getPageActivity();
            Intrinsics.checkExpressionValueIsNotNull(pageActivity, "mContext.pageActivity");
            intent.putExtras(pageActivity.getIntent());
            tbEditVideoActivityConfig.setMultiMediaData(TbEditVideoActivityConfig.convert2MultiMedia(this.s));
            tbEditVideoActivityConfig.setVideoFrom(4);
            VideoInfo videoInfo2 = this.s;
            if (videoInfo2 == null) {
                Intrinsics.throwNpe();
            }
            tbEditVideoActivityConfig.setVideoRatio(videoInfo2.getMultiMediaData().videoRatio);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbEditVideoActivityConfig));
        }
    }

    @Override // b.a.r0.d4.u.p.c.b
    public void onPlayClick() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f56342i == this.f56339f || this.s == null) {
            return;
        }
        TbPageContext<?> tbPageContext = this.k;
        if (tbPageContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbPreviewVideoActivityConfig(tbPageContext.getPageActivity(), this.s)));
    }

    public final void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            WorkPublishVideoView workPublishVideoView = this.l;
            if (workPublishVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
            }
            workPublishVideoView.loadCover();
        }
    }

    public final void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            WorkPublishVideoView workPublishVideoView = this.l;
            if (workPublishVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
            }
            workPublishVideoView.deleteCoverCache();
        }
    }

    public final void setIWorkVideoMixListener(b.a.r0.d4.u.p.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
            this.u = aVar;
        }
    }

    public final void setPageContext(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, tbPageContext) == null) {
            this.k = tbPageContext;
            CustomMessageListener customMessageListener = this.v;
            if (tbPageContext == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            }
            customMessageListener.setTag(tbPageContext.getUniqueId());
            MessageManager.getInstance().registerListener(this.v);
        }
    }

    public final void setVideoInfo(VideoInfo videoInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048593, this, videoInfo, z) == null) {
            EditVideoData editVideoData = videoInfo.getEditVideoData();
            this.t = editVideoData;
            this.s = videoInfo;
            if (editVideoData != null) {
                if (editVideoData == null) {
                    Intrinsics.throwNpe();
                }
                if (editVideoData.isLegal()) {
                    LinearLayout linearLayout = this.m;
                    if (linearLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixStateLayout");
                    }
                    linearLayout.setVisibility(0);
                    WorkPublishVideoView workPublishVideoView = this.l;
                    if (workPublishVideoView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
                    }
                    workPublishVideoView.setVisibility(0);
                    WorkPublishVideoView workPublishVideoView2 = this.l;
                    if (workPublishVideoView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
                    }
                    workPublishVideoView2.setVideoInfo(this.t);
                    if (z) {
                        WorkPublishVideoView workPublishVideoView3 = this.l;
                        if (workPublishVideoView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
                        }
                        workPublishVideoView3.updatePercent(1.0f);
                        return;
                    }
                    return;
                }
            }
            LinearLayout linearLayout2 = this.m;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mixStateLayout");
            }
            linearLayout2.setVisibility(8);
            WorkPublishVideoView workPublishVideoView4 = this.l;
            if (workPublishVideoView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
            }
            workPublishVideoView4.setVisibility(8);
            WorkPublishVideoView workPublishVideoView5 = this.l;
            if (workPublishVideoView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
            }
            workPublishVideoView5.reset();
            b.a.r0.z3.b bVar = this.q;
            if (bVar != null) {
                bVar.i(true);
            }
            b.a.r0.f0.b bVar2 = this.r;
            if (bVar2 != null) {
                bVar2.cancel();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921585));
        }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f56339f = 1;
        this.f56340g = 2;
        this.f56341h = 3;
        this.f56342i = this.f56338e;
        this.v = new a(this, 2921584);
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkPublishMixVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f56339f = 1;
        this.f56340g = 2;
        this.f56341h = 3;
        this.f56342i = this.f56338e;
        this.v = new a(this, 2921584);
        initView();
    }
}
