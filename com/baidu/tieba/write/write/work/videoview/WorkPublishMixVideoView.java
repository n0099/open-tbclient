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
import c.a.s0.n4.d;
import c.a.s0.n4.e0.p.x.b;
import c.a.s0.n4.g;
import c.a.s0.n4.h;
import c.a.s0.n4.j;
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
import com.baidu.tieba.video.EditVideoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u000202J\b\u00106\u001a\u000202H\u0016J\u0006\u00107\u001a\u000202J\b\u00108\u001a\u000202H\u0016J\b\u00109\u001a\u000202H\u0016J\u0006\u0010:\u001a\u000202J\u0006\u0010;\u001a\u000202J\u0012\u0010<\u001a\u0002022\n\u0010=\u001a\u0006\u0012\u0002\b\u00030 J\u0016\u0010>\u001a\u0002022\u0006\u0010/\u001a\u0002002\u0006\u0010?\u001a\u000204J\u0018\u0010@\u001a\u0002022\u0006\u0010A\u001a\u00020\n2\u0006\u0010B\u001a\u00020\nH\u0002R\u0014\u0010\f\u001a\u00020\nX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\nX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\nX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\nX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0012\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/baidu/tieba/write/write/work/videoview/WorkPublishMixVideoView;", "Landroid/widget/LinearLayout;", "Lcom/baidu/tieba/write/write/work/interf/IWriteVideoPreviewListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "STATE_FAILED", "getSTATE_FAILED", "()I", "STATE_MIXING", "getSTATE_MIXING", "STATE_NONE", "getSTATE_NONE", "STATE_SUCCESS", "getSTATE_SUCCESS", "callback", "Lcom/baidu/tieba/video/EditVideoTaskDataAndCallback;", "editData", "Lcom/baidu/tieba/video/EditVideoData;", "iWorkVideoMixListener", "Lcom/baidu/tieba/write/write/work/interf/IWorkVideoMixListener;", "getIWorkVideoMixListener", "()Lcom/baidu/tieba/write/write/work/interf/IWorkVideoMixListener;", "setIWorkVideoMixListener", "(Lcom/baidu/tieba/write/write/work/interf/IWorkVideoMixListener;)V", "mContext", "Lcom/baidu/tbadk/TbPageContext;", "mRootView", "Landroid/view/View;", "mixPercentText", "Landroid/widget/TextView;", "mixRetryText", "mixState", "mixStateLayout", "mixStateText", "muxerProgressUpdateListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "publishVideoView", "Lcom/baidu/tieba/write/write/work/videoview/WorkPublishVideoView;", "saveEditVideoController", "Lcom/baidu/tieba/controller/ISaveEditVideoController;", TbPreviewVideoActivityConfig.KEY_VIDEO_INFO, "Lcom/baidu/tbadk/coreExtra/data/VideoInfo;", "initView", "", "isVisible", "", "onChangeSkin", "onCoverEditClick", MissionEvent.MESSAGE_DESTROY, "onEditClick", "onPlayClick", "onStart", MissionEvent.MESSAGE_STOP, "setPageContext", "tbPageContext", "setVideoInfo", "isDraft", "updateStateTexts", "state", SapiOptions.KEY_CACHE_PERCENT, "write_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class WorkPublishMixVideoView extends LinearLayout implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f51798e;

    /* renamed from: f  reason: collision with root package name */
    public final int f51799f;

    /* renamed from: g  reason: collision with root package name */
    public final int f51800g;

    /* renamed from: h  reason: collision with root package name */
    public final int f51801h;

    /* renamed from: i  reason: collision with root package name */
    public int f51802i;

    /* renamed from: j  reason: collision with root package name */
    public View f51803j;

    /* renamed from: k  reason: collision with root package name */
    public TbPageContext<?> f51804k;
    public WorkPublishVideoView l;
    public LinearLayout m;
    public TextView n;
    public TextView o;
    public TextView p;
    public c.a.s0.j4.b q;
    public c.a.s0.k0.b r;
    public VideoInfo s;
    public EditVideoData t;
    public c.a.s0.n4.e0.p.x.a u;
    public final CustomMessageListener v;

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                    if (data == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    int intValue = ((Integer) data).intValue();
                    if (intValue >= 0 && intValue < 100) {
                        WorkPublishMixVideoView workPublishMixVideoView = this.a;
                        workPublishMixVideoView.a(workPublishMixVideoView.getSTATE_MIXING(), intValue);
                    } else if (intValue == 100) {
                        WorkPublishMixVideoView workPublishMixVideoView2 = this.a;
                        workPublishMixVideoView2.a(workPublishMixVideoView2.getSTATE_SUCCESS(), intValue);
                    }
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
        this.f51799f = 1;
        this.f51800g = 2;
        this.f51801h = 3;
        this.f51802i = this.f51798e;
        this.v = new a(this);
        initView();
    }

    public final void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            TextView textView = this.o;
            WorkPublishVideoView workPublishVideoView = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mixPercentText");
                textView = null;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            TbPageContext<?> tbPageContext = this.f51804k;
            if (tbPageContext == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                tbPageContext = null;
            }
            String string = tbPageContext.getString(j.video_mix_percent);
            Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(R.string.video_mix_percent)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            textView.setText(format);
            if (i2 != this.f51802i) {
                this.f51802i = i2;
                TextView textView2 = this.n;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mixStateText");
                    textView2 = null;
                }
                SkinManager.setViewTextColor(textView2, this.f51802i == this.f51801h ? d.CAM_X0301 : d.CAM_X0107);
                if (i2 == this.f51799f) {
                    TextView textView3 = this.n;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixStateText");
                        textView3 = null;
                    }
                    TbPageContext<?> tbPageContext2 = this.f51804k;
                    if (tbPageContext2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                        tbPageContext2 = null;
                    }
                    textView3.setText(tbPageContext2.getString(j.video_mixing));
                    TextView textView4 = this.o;
                    if (textView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixPercentText");
                        textView4 = null;
                    }
                    textView4.setVisibility(0);
                    TextView textView5 = this.p;
                    if (textView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixRetryText");
                        textView5 = null;
                    }
                    textView5.setVisibility(8);
                } else if (i2 == this.f51801h) {
                    TextView textView6 = this.n;
                    if (textView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixStateText");
                        textView6 = null;
                    }
                    TbPageContext<?> tbPageContext3 = this.f51804k;
                    if (tbPageContext3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                        tbPageContext3 = null;
                    }
                    textView6.setText(tbPageContext3.getString(j.video_mix_failed));
                    TextView textView7 = this.o;
                    if (textView7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixPercentText");
                        textView7 = null;
                    }
                    textView7.setVisibility(8);
                    TextView textView8 = this.p;
                    if (textView8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixRetryText");
                        textView8 = null;
                    }
                    textView8.setVisibility(0);
                } else {
                    TextView textView9 = this.n;
                    if (textView9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixStateText");
                        textView9 = null;
                    }
                    TbPageContext<?> tbPageContext4 = this.f51804k;
                    if (tbPageContext4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContext");
                        tbPageContext4 = null;
                    }
                    textView9.setText(tbPageContext4.getString(j.video_mix_success));
                    TextView textView10 = this.o;
                    if (textView10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixPercentText");
                        textView10 = null;
                    }
                    textView10.setVisibility(8);
                    TextView textView11 = this.p;
                    if (textView11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixRetryText");
                        textView11 = null;
                    }
                    textView11.setVisibility(8);
                }
                c.a.s0.n4.e0.p.x.a aVar = this.u;
                if (aVar != null) {
                    aVar.onMixStateChanged(this.f51802i);
                }
            }
            WorkPublishVideoView workPublishVideoView2 = this.l;
            if (workPublishVideoView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
            } else {
                workPublishVideoView = workPublishVideoView2;
            }
            workPublishVideoView.updatePercent(i3 / 100.0f);
        }
    }

    public final c.a.s0.n4.e0.p.x.a getIWorkVideoMixListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.u : (c.a.s0.n4.e0.p.x.a) invokeV.objValue;
    }

    public final int getSTATE_FAILED() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f51801h : invokeV.intValue;
    }

    public final int getSTATE_MIXING() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f51799f : invokeV.intValue;
    }

    public final int getSTATE_NONE() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f51798e : invokeV.intValue;
    }

    public final int getSTATE_SUCCESS() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f51800g : invokeV.intValue;
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(h.work_publish_mix_video_view, (ViewGroup) this, true);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…x_video_view, this, true)");
            this.f51803j = inflate;
            View view = null;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                inflate = null;
            }
            View findViewById = inflate.findViewById(g.write_video_preview);
            Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.write_video_preview)");
            WorkPublishVideoView workPublishVideoView = (WorkPublishVideoView) findViewById;
            this.l = workPublishVideoView;
            if (workPublishVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
                workPublishVideoView = null;
            }
            workPublishVideoView.setIWriteVideoPreviewListener(this);
            View view2 = this.f51803j;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view2 = null;
            }
            View findViewById2 = view2.findViewById(g.write_video_mix_state_layout);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R…e_video_mix_state_layout)");
            this.m = (LinearLayout) findViewById2;
            View view3 = this.f51803j;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view3 = null;
            }
            View findViewById3 = view3.findViewById(g.write_video_state_text);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R…d.write_video_state_text)");
            this.n = (TextView) findViewById3;
            View view4 = this.f51803j;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view4 = null;
            }
            View findViewById4 = view4.findViewById(g.write_video_percent);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.write_video_percent)");
            this.o = (TextView) findViewById4;
            View view5 = this.f51803j;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            } else {
                view = view5;
            }
            View findViewById5 = view.findViewById(g.write_video_retry);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R.id.write_video_retry)");
            this.p = (TextView) findViewById5;
            onChangeSkin();
        }
    }

    public final boolean isVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.l == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
            }
            WorkPublishVideoView workPublishVideoView = this.l;
            if (workPublishVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
                workPublishVideoView = null;
            }
            return workPublishVideoView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public final void onChangeSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            WorkPublishVideoView workPublishVideoView = this.l;
            TextView textView = null;
            if (workPublishVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
                workPublishVideoView = null;
            }
            workPublishVideoView.onChangeSkin();
            TextView textView2 = this.n;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mixStateText");
                textView2 = null;
            }
            SkinManager.setViewTextColor(textView2, this.f51802i == this.f51801h ? d.CAM_X0301 : d.CAM_X0107);
            TextView textView3 = this.o;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mixPercentText");
                textView3 = null;
            }
            SkinManager.setViewTextColor(textView3, d.CAM_X0109);
            TextView textView4 = this.p;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mixRetryText");
            } else {
                textView = textView4;
            }
            SkinManager.setViewTextColor(textView, d.CAM_X0302);
        }
    }

    @Override // c.a.s0.n4.e0.p.x.b
    public void onCoverEditClick() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f51802i == this.f51799f) {
            return;
        }
        onDestroy();
        VideoInfo videoInfo = this.s;
        TbPageContext<?> tbPageContext = null;
        if ((videoInfo == null ? null : videoInfo.getMultiMediaData()) != null) {
            TiebaStatic.log("c14259");
            TbPageContext<?> tbPageContext2 = this.f51804k;
            if (tbPageContext2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                tbPageContext2 = null;
            }
            TbEditVideoActivityConfig tbEditVideoActivityConfig = new TbEditVideoActivityConfig(tbPageContext2.getPageActivity());
            Intent intent = tbEditVideoActivityConfig.getIntent();
            TbPageContext<?> tbPageContext3 = this.f51804k;
            if (tbPageContext3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                tbPageContext = tbPageContext3;
            }
            intent.putExtras(tbPageContext.getPageActivity().getIntent());
            tbEditVideoActivityConfig.setMultiMediaData(TbEditVideoActivityConfig.convert2MultiMedia(this.s));
            tbEditVideoActivityConfig.setVideoFrom(4);
            VideoInfo videoInfo2 = this.s;
            Intrinsics.checkNotNull(videoInfo2);
            tbEditVideoActivityConfig.setVideoRatio(videoInfo2.getMultiMediaData().videoRatio);
            tbEditVideoActivityConfig.setPageModeType(3);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbEditVideoActivityConfig));
        }
    }

    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.a.s0.j4.b bVar = this.q;
            if (bVar != null) {
                Intrinsics.checkNotNull(bVar);
                bVar.i(true);
            }
            c.a.s0.k0.b bVar2 = this.r;
            if (bVar2 != null) {
                Intrinsics.checkNotNull(bVar2);
                bVar2.cancel();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921585));
        }
    }

    @Override // c.a.s0.n4.e0.p.x.b
    public void onEditClick() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f51802i == this.f51799f) {
            return;
        }
        onDestroy();
        VideoInfo videoInfo = this.s;
        TbPageContext<?> tbPageContext = null;
        if ((videoInfo == null ? null : videoInfo.getMultiMediaData()) != null) {
            TiebaStatic.log("c14258");
            TbPageContext<?> tbPageContext2 = this.f51804k;
            if (tbPageContext2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                tbPageContext2 = null;
            }
            TbEditVideoActivityConfig tbEditVideoActivityConfig = new TbEditVideoActivityConfig(tbPageContext2.getPageActivity());
            Intent intent = tbEditVideoActivityConfig.getIntent();
            TbPageContext<?> tbPageContext3 = this.f51804k;
            if (tbPageContext3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                tbPageContext = tbPageContext3;
            }
            intent.putExtras(tbPageContext.getPageActivity().getIntent());
            tbEditVideoActivityConfig.setMultiMediaData(TbEditVideoActivityConfig.convert2MultiMedia(this.s));
            tbEditVideoActivityConfig.setVideoFrom(4);
            VideoInfo videoInfo2 = this.s;
            Intrinsics.checkNotNull(videoInfo2);
            tbEditVideoActivityConfig.setVideoRatio(videoInfo2.getMultiMediaData().videoRatio);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbEditVideoActivityConfig));
        }
    }

    @Override // c.a.s0.n4.e0.p.x.b
    public void onPlayClick() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f51802i == this.f51799f || this.s == null) {
            return;
        }
        TbPageContext<?> tbPageContext = this.f51804k;
        if (tbPageContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            tbPageContext = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbPreviewVideoActivityConfig(tbPageContext.getPageActivity(), this.s)));
    }

    public final void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            WorkPublishVideoView workPublishVideoView = this.l;
            if (workPublishVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
                workPublishVideoView = null;
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
                workPublishVideoView = null;
            }
            workPublishVideoView.deleteCoverCache();
        }
    }

    public final void setIWorkVideoMixListener(c.a.s0.n4.e0.p.x.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) {
            this.u = aVar;
        }
    }

    public final void setPageContext(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, tbPageContext) == null) {
            Intrinsics.checkNotNullParameter(tbPageContext, "tbPageContext");
            this.f51804k = tbPageContext;
            CustomMessageListener customMessageListener = this.v;
            if (tbPageContext == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                tbPageContext = null;
            }
            customMessageListener.setTag(tbPageContext.getUniqueId());
            MessageManager.getInstance().registerListener(this.v);
        }
    }

    public final void setVideoInfo(VideoInfo videoInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048593, this, videoInfo, z) == null) {
            Intrinsics.checkNotNullParameter(videoInfo, "videoInfo");
            EditVideoData editVideoData = videoInfo.getEditVideoData();
            this.t = editVideoData;
            this.s = videoInfo;
            WorkPublishVideoView workPublishVideoView = null;
            if (editVideoData != null) {
                Intrinsics.checkNotNull(editVideoData);
                if (editVideoData.isLegal()) {
                    LinearLayout linearLayout = this.m;
                    if (linearLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mixStateLayout");
                        linearLayout = null;
                    }
                    linearLayout.setVisibility(0);
                    WorkPublishVideoView workPublishVideoView2 = this.l;
                    if (workPublishVideoView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
                        workPublishVideoView2 = null;
                    }
                    workPublishVideoView2.setVisibility(0);
                    WorkPublishVideoView workPublishVideoView3 = this.l;
                    if (workPublishVideoView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
                        workPublishVideoView3 = null;
                    }
                    workPublishVideoView3.setVideoInfo(this.t);
                    if (z) {
                        WorkPublishVideoView workPublishVideoView4 = this.l;
                        if (workPublishVideoView4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
                        } else {
                            workPublishVideoView = workPublishVideoView4;
                        }
                        workPublishVideoView.updatePercent(1.0f);
                        return;
                    }
                    return;
                }
            }
            LinearLayout linearLayout2 = this.m;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mixStateLayout");
                linearLayout2 = null;
            }
            linearLayout2.setVisibility(8);
            WorkPublishVideoView workPublishVideoView5 = this.l;
            if (workPublishVideoView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
                workPublishVideoView5 = null;
            }
            workPublishVideoView5.setVisibility(8);
            WorkPublishVideoView workPublishVideoView6 = this.l;
            if (workPublishVideoView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishVideoView");
            } else {
                workPublishVideoView = workPublishVideoView6;
            }
            workPublishVideoView.reset();
            c.a.s0.j4.b bVar = this.q;
            if (bVar != null) {
                bVar.i(true);
            }
            c.a.s0.k0.b bVar2 = this.r;
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
        this.f51799f = 1;
        this.f51800g = 2;
        this.f51801h = 3;
        this.f51802i = this.f51798e;
        this.v = new a(this);
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
        this.f51799f = 1;
        this.f51800g = 2;
        this.f51801h = 3;
        this.f51802i = this.f51798e;
        this.v = new a(this);
        initView();
    }
}
