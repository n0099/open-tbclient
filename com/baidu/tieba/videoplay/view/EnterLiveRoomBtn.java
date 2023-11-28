package com.baidu.tieba.videoplay.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.ai5;
import com.baidu.tieba.f9b;
import com.baidu.tieba.nw6;
import com.baidu.tieba.video.LiveConfig;
import com.baidu.tieba.videoplay.view.EnterLiveRoomBtn;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 <2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003<=>B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010-\u001a\u00020.2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010/\u001a\u00020.J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u001aH\u0002J\u0010\u00103\u001a\u00020.2\u0006\u00104\u001a\u00020(H\u0016J\u0012\u00105\u001a\u00020.2\b\u00106\u001a\u0004\u0018\u00010&H\u0016J\u0006\u00107\u001a\u00020.J\u0010\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020(H\u0002J\b\u0010:\u001a\u00020.H\u0002J\u0006\u0010;\u001a\u00020.R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/baidu/tieba/videoplay/view/EnterLiveRoomBtn;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "Lcom/baidu/tieba/edgefloat/IChangeSkinType;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cancelSpan", "Landroid/text/style/ClickableSpan;", "config", "Lcom/baidu/tieba/video/LiveConfig;", "getConfig", "()Lcom/baidu/tieba/video/LiveConfig;", "setConfig", "(Lcom/baidu/tieba/video/LiveConfig;)V", "countDownCallback", "Lcom/baidu/tieba/videoplay/view/EnterLiveRoomBtn$CountDownTimer$CountDownCallback;", "countDownTimerTask", "Lcom/baidu/tieba/videoplay/view/EnterLiveRoomBtn$CountDownTimer;", "getCountDownTimerTask", "()Lcom/baidu/tieba/videoplay/view/EnterLiveRoomBtn$CountDownTimer;", "setCountDownTimerTask", "(Lcom/baidu/tieba/videoplay/view/EnterLiveRoomBtn$CountDownTimer;)V", "descriptionAutoEnter", "", "descriptionClickEnter", "enterLiveRoomCallback", "Lcom/baidu/tieba/videoplay/view/EnterLiveRoomBtn$EnterLiveRoomCallback;", "getEnterLiveRoomCallback", "()Lcom/baidu/tieba/videoplay/view/EnterLiveRoomBtn$EnterLiveRoomCallback;", "setEnterLiveRoomCallback", "(Lcom/baidu/tieba/videoplay/view/EnterLiveRoomBtn$EnterLiveRoomCallback;)V", "enterSpan", "imgIcon", "Landroid/widget/ImageView;", "root", "Landroid/view/View;", WriteMulitImageActivityConfig.SKIN_TYPE, "", "timer", "Ljava/util/Timer;", "tvDescription", "Landroid/widget/TextView;", "bindViewData", "", "cancel", "getSpanText", "Landroid/text/SpannableString;", "text", "onChangeSkinType", "type", "onClick", "v", MissionEvent.MESSAGE_DESTROY, "setCountDownStyle", "currentTime", "setSingleClickStyle", "start", "Companion", "CountDownTimer", "EnterLiveRoomCallback", "VideoPlay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class EnterLiveRoomBtn extends LinearLayout implements View.OnClickListener, nw6 {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final View c;
    public TextView d;
    public ImageView e;
    public int f;
    public Timer g;
    public b h;
    public LiveConfig i;
    public a j;
    public final ClickableSpan k;
    public final ClickableSpan l;
    public final a.InterfaceC0507a m;

    /* loaded from: classes8.dex */
    public interface b {
        void a(int i);

        void onCancel();
    }

    /* loaded from: classes8.dex */
    public static final class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public boolean b;
        public InterfaceC0507a c;

        /* renamed from: com.baidu.tieba.videoplay.view.EnterLiveRoomBtn$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public interface InterfaceC0507a {
            void a(int i);

            void onFinish();
        }

        public a(LiveConfig config) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {config};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(config, "config");
            this.a = config.getWaitSecond();
        }

        public static final void a(a this$0) {
            InterfaceC0507a interfaceC0507a;
            InterfaceC0507a interfaceC0507a2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                int i = this$0.a - 1;
                this$0.a = i;
                if (i < 0) {
                    if (!this$0.b && (interfaceC0507a2 = this$0.c) != null) {
                        interfaceC0507a2.onFinish();
                    }
                    this$0.cancel();
                } else if (!this$0.b && (interfaceC0507a = this$0.c) != null) {
                    interfaceC0507a.a(i);
                }
            }
        }

        public final void b(InterfaceC0507a interfaceC0507a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC0507a) == null) {
                this.c = interfaceC0507a;
            }
        }

        @Override // java.util.TimerTask
        public boolean cancel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                this.b = true;
                this.c = null;
                return super.cancel();
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.q9b
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            EnterLiveRoomBtn.a.a(EnterLiveRoomBtn.a.this);
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class c extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterLiveRoomBtn a;

        public c(EnterLiveRoomBtn enterLiveRoomBtn) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterLiveRoomBtn};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = enterLiveRoomBtn;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ds) == null) {
                Intrinsics.checkNotNullParameter(ds, "ds");
                super.updateDrawState(ds);
                ds.setColor(SkinManager.getColor(R.color.CAM_X0619));
                ds.setUnderlineText(false);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, widget) == null) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                b enterLiveRoomCallback = this.a.getEnterLiveRoomCallback();
                if (enterLiveRoomCallback != null) {
                    enterLiveRoomCallback.onCancel();
                }
                LiveConfig config = this.a.getConfig();
                if (config != null) {
                    str = config.getCurrentId();
                } else {
                    str = null;
                }
                f9b.g("sp_live_cancel_id_", str);
                f9b.f("sp_live_click_cancel_key");
                this.a.d();
                this.a.g();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class d implements a.InterfaceC0507a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterLiveRoomBtn a;

        public d(EnterLiveRoomBtn enterLiveRoomBtn) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterLiveRoomBtn};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = enterLiveRoomBtn;
        }

        @Override // com.baidu.tieba.videoplay.view.EnterLiveRoomBtn.a.InterfaceC0507a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                return;
            }
            this.a.setCountDownStyle(i);
        }

        @Override // com.baidu.tieba.videoplay.view.EnterLiveRoomBtn.a.InterfaceC0507a
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                b enterLiveRoomCallback = this.a.getEnterLiveRoomCallback();
                if (enterLiveRoomCallback != null) {
                    enterLiveRoomCallback.a(2);
                }
                this.a.g();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class e extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterLiveRoomBtn a;

        public e(EnterLiveRoomBtn enterLiveRoomBtn) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enterLiveRoomBtn};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = enterLiveRoomBtn;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, widget) == null) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                b enterLiveRoomCallback = this.a.getEnterLiveRoomCallback();
                if (enterLiveRoomCallback != null) {
                    enterLiveRoomCallback.a(1);
                }
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ds) == null) {
                Intrinsics.checkNotNullParameter(ds, "ds");
                super.updateDrawState(ds);
                ds.setColor(SkinManager.getColor(R.color.CAM_X0101));
                ds.setUnderlineText(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1189557886, "Lcom/baidu/tieba/videoplay/view/EnterLiveRoomBtn;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1189557886, "Lcom/baidu/tieba/videoplay/view/EnterLiveRoomBtn;");
                return;
            }
        }
        n = UtilHelper.getDimenPixelSize(R.dimen.tbds28);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d();
            this.j = null;
            this.g = null;
        }
    }

    public final LiveConfig getConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.i;
        }
        return (LiveConfig) invokeV.objValue;
    }

    public final a getCountDownTimerTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.j;
        }
        return (a) invokeV.objValue;
    }

    public final b getEnterLiveRoomCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.h;
        }
        return (b) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterLiveRoomBtn(Context context, AttributeSet attributeSet) {
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
        Intrinsics.checkNotNullParameter(context, "context");
        String string = TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f068a);
        Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(R.st…ter_live_room_count_down)");
        this.a = string;
        String string2 = TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f046e);
        Intrinsics.checkNotNullExpressionValue(string2, "getInst().getString(R.st…ng.click_enter_live_room)");
        this.b = string2;
        this.f = -1;
        this.k = new c(this);
        this.l = new e(this);
        this.m = new d(this);
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02d4, (ViewGroup) this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…_room_layout, this, true)");
        this.c = inflate;
        setOrientation(0);
        setGravity(17);
        int i3 = n;
        setPadding(0, i3, 0, i3);
        TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0904fb);
        this.d = textView;
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f090504);
            this.e = imageView;
            if (imageView != null) {
                imageView.setOnClickListener(this);
            }
            this.c.setOnClickListener(this);
            onChangeSkinType(TbadkApplication.getInst().getSkinType());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, view2) == null) && (bVar = this.h) != null) {
            bVar.a(1);
        }
    }

    public final void setConfig(LiveConfig liveConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, liveConfig) == null) {
            this.i = liveConfig;
        }
    }

    public final void setCountDownTimerTask(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.j = aVar;
        }
    }

    public final void setEnterLiveRoomCallback(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.h = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCountDownStyle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i) == null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(this.a, Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            TextView textView = this.d;
            if (textView != null) {
                textView.setText(e(format));
            }
        }
    }

    public final void c(LiveConfig config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, config) == null) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.i = config;
            if (config.getType() == 1) {
                config.setCurrentRealHitStrategy(1);
                g();
            } else if (config.getType() == 2) {
                if (f9b.d(config)) {
                    setCountDownStyle(config.getWaitSecond());
                    config.setCurrentRealHitStrategy(2);
                    return;
                }
                config.setCurrentRealHitStrategy(1);
                g();
            }
        }
    }

    public final SpannableString e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0101)), 0, 9, 33);
            spannableString.setSpan(this.l, 0, 9, 33);
            spannableString.setSpan(this.k, 9, str.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a aVar = this.j;
            if (aVar != null) {
                aVar.cancel();
            }
            Timer timer = this.g;
            if (timer != null) {
                timer.cancel();
            }
            LiveConfig liveConfig = this.i;
            boolean z = false;
            if (liveConfig != null && liveConfig.getType() == 2) {
                z = true;
            }
            if (z) {
                LiveConfig liveConfig2 = this.i;
                Intrinsics.checkNotNull(liveConfig2);
                if (f9b.d(liveConfig2)) {
                    LiveConfig liveConfig3 = this.i;
                    Intrinsics.checkNotNull(liveConfig3);
                    setCountDownStyle(liveConfig3.getWaitSecond());
                    return;
                }
            }
            g();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SpannableString spannableString = new SpannableString(this.b);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0101)), 0, this.b.length(), 33);
            spannableString.setSpan(this.l, 0, this.b.length(), 33);
            TextView textView = this.d;
            if (textView != null) {
                textView.setText(spannableString);
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            LiveConfig liveConfig = this.i;
            boolean z = false;
            if (liveConfig != null && liveConfig.getType() == 2) {
                z = true;
            }
            if (z) {
                LiveConfig liveConfig2 = this.i;
                Intrinsics.checkNotNull(liveConfig2);
                if (f9b.d(liveConfig2)) {
                    this.g = new Timer();
                    LiveConfig liveConfig3 = this.i;
                    Intrinsics.checkNotNull(liveConfig3);
                    a aVar = new a(liveConfig3);
                    this.j = aVar;
                    if (aVar != null) {
                        aVar.b(this.m);
                    }
                    LiveConfig liveConfig4 = this.i;
                    Intrinsics.checkNotNull(liveConfig4);
                    setCountDownStyle(liveConfig4.getWaitSecond());
                    Timer timer = this.g;
                    if (timer != null) {
                        timer.schedule(this.j, 1000L, 1000L);
                    }
                    TbSingleton.getInstance().autoInLiveRoomTimes++;
                    f9b.f("sp_live_day_show_auto_in_key");
                    return;
                }
            }
            g();
        }
    }

    @Override // com.baidu.tieba.nw6
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i) == null) && this.f != i) {
            this.f = i;
            ImageView imageView = this.e;
            if (imageView != null) {
                ai5.a(imageView, "enter_live_room_animation.png");
            }
            EMManager.from(this.c).setCorner(R.string.J_X01).setBorderWidth(R.dimen.L_X01).setBorderColor(R.color.CAM_X0619).setBackGroundColor(R.color.CAM_X0604);
            EMManager.from(this.d).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0101);
        }
    }
}
