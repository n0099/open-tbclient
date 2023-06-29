package com.baidu.tieba.im.widget.chatVoiceView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.gc8;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.j98;
import com.baidu.tieba.jp5;
import com.baidu.tieba.k98;
import com.baidu.tieba.s75;
import com.baidu.tieba.sx5;
import com.baidu.tieba.v6a;
import com.baidu.tieba.ww5;
import com.baidu.tieba.wx5;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class ChatVoiceView extends LinearLayout implements VoiceManager.i, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TBLottieAnimationView a;
    public TextView b;
    public ImageView c;
    public ProgressBar d;
    public VoiceData.VoiceModel e;
    public ChatMessage f;
    public RelativeLayout g;
    public VoiceManager h;
    public int i;

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements LottieOnCompositionLoadedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatVoiceView a;

        /* renamed from: com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0342a implements SimpleLottieValueCallback<Integer> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0342a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.airbnb.lottie.value.SimpleLottieValueCallback
            /* renamed from: a */
            public Integer getValue(LottieFrameInfo<Integer> lottieFrameInfo) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lottieFrameInfo)) == null) {
                    return Integer.valueOf(this.a.a.i);
                }
                return (Integer) invokeL.objValue;
            }
        }

        public a(ChatVoiceView chatVoiceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatVoiceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatVoiceView;
        }

        @Override // com.airbnb.lottie.LottieOnCompositionLoadedListener
        @SuppressLint({"RestrictedApi"})
        public void onCompositionLoaded(LottieComposition lottieComposition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lottieComposition) == null) {
                for (KeyPath keyPath : this.a.a.resolveKeyPath(new KeyPath("**"))) {
                    if (keyPath.matches("填充 1", 2) || keyPath.matches("填充 1", 1)) {
                        this.a.a.addValueCallback(keyPath, (KeyPath) LottieProperty.COLOR, (SimpleLottieValueCallback<KeyPath>) new C0342a(this));
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends sx5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatMessage a;
        public final /* synthetic */ LinkedList b;
        public final /* synthetic */ ChatVoiceView c;

        public b(ChatVoiceView chatVoiceView, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatVoiceView, personalChatMessage, linkedList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = chatVoiceView;
            this.a = personalChatMessage;
            this.b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.sx5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return Boolean.valueOf(k98.w().n(gc8.q(this.a), this.b, false));
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ww5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatVoiceView a;

        public c(ChatVoiceView chatVoiceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatVoiceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatVoiceView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ww5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.a.c.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends sx5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialChatMessage a;
        public final /* synthetic */ LinkedList b;
        public final /* synthetic */ ChatVoiceView c;

        public d(ChatVoiceView chatVoiceView, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatVoiceView, officialChatMessage, linkedList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = chatVoiceView;
            this.a = officialChatMessage;
            this.b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.sx5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return Boolean.valueOf(j98.w().n(gc8.q(this.a), this.b, false));
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e implements ww5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatVoiceView a;

        public e(ChatVoiceView chatVoiceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatVoiceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatVoiceView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ww5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.a.c.setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatVoiceView(Context context) {
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
        this.b = null;
        this.c = null;
        this.d = null;
        this.i = 0;
        LayoutInflater.from(context).inflate(R.layout.widget_left_voice_view, (ViewGroup) this, true);
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
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
        this.b = null;
        this.c = null;
        this.d = null;
        this.i = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, v6a.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            LayoutInflater.from(context).inflate(R.layout.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(R.layout.widget_right_voice_view, (ViewGroup) this, true);
        }
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatVoiceView(Context context, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.d = null;
        this.i = 0;
        if (z) {
            LayoutInflater.from(context).inflate(R.layout.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(R.layout.widget_right_voice_view, (ViewGroup) this, true);
        }
        h();
    }

    public void j(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (this.i != 0) {
                this.a.clearAnimation();
                this.b.setTextColor(this.i);
            } else if (!z && z2) {
                s75.d(this.b).x(R.color.CAM_X0105);
            } else {
                s75.d(this.b).x(R.color.CAM_X0114);
            }
            this.a.setAnimation(R.raw.im_voice_buble_anim);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            k(i);
            VoiceData.VoiceModel voiceModel = this.e;
            if (voiceModel != null) {
                voiceModel.elapse = i;
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void b(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voiceModel) != null) || voiceModel == null) {
            return;
        }
        l(voiceModel.voice_status.intValue());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, view2) == null) && this.e != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.startPlay(this);
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, voiceManager) == null) {
            this.h = voiceManager;
        }
    }

    public void setVoicePureColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            if (i == 0) {
                this.i = SkinManager.getColor(R.color.CAM_X0114);
            } else {
                this.i = i;
            }
        }
    }

    private void setBubbleLength(int i) {
        float f;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, this, i) == null) {
            if (xi.i(getContext()) <= 2.0f) {
                f = xi.i(getContext()) / 2.0f;
            } else {
                f = 2.6f;
            }
            if (i <= 10) {
                i2 = ((i - 1) * 9) + 99;
            } else {
                i2 = ((i - 10) * 2) + 180;
            }
            int i3 = (int) ((f * i2) + 0.5f);
            try {
                if (this.g.getParent() != null && (this.g.getParent() instanceof RelativeLayout)) {
                    this.g.setLayoutParams(new RelativeLayout.LayoutParams(i3, -2));
                } else {
                    this.g.setLayoutParams(new LinearLayout.LayoutParams(i3, -2));
                }
            } catch (Exception unused) {
            }
        }
    }

    public void setData(@NonNull VoiceData.VoiceModel voiceModel) {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, voiceModel) == null) {
            this.e = voiceModel;
            this.b.setText(VoiceManager.formatVoiceTime01(voiceModel.getDuration()));
            this.b.setContentDescription(String.format(getContext().getString(R.string.editor_record_format), VoiceManager.formatVoiceTime01(voiceModel.getDuration())));
            setBubbleLength(voiceModel.getDuration());
            setTag(voiceModel);
            if (voiceModel.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            l(voiceModel.voice_status.intValue());
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.addLottieOnCompositionLoadedListener(new a(this));
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager.i getRealView() {
        InterceptResult invokeV;
        VoiceManager.i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Context context = getContext();
            if (context instanceof VoiceManager.j) {
                iVar = ((VoiceManager.j) context).f1(this.e);
            } else {
                iVar = this;
            }
            if (iVar == null) {
                return this;
            }
            return iVar;
        }
        return (VoiceManager.i) invokeV.objValue;
    }

    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Context context = getContext();
            VoiceManager voiceManager = this.h;
            if (voiceManager != null) {
                return voiceManager;
            }
            if (context instanceof VoiceManager.j) {
                return ((VoiceManager.j) context).y0();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceData.VoiceModel getVoiceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (VoiceData.VoiceModel) invokeV.objValue;
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            VoiceData.VoiceModel voiceModel = this.e;
            if (voiceModel == null || voiceModel.voice_status.intValue() != 3) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.e = null;
            l(1);
        }
    }

    public final void o() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (tBLottieAnimationView = this.a) != null) {
            tBLottieAnimationView.playAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDetachedFromWindow();
            try {
                p();
            } catch (Exception unused) {
            }
        }
    }

    public final void p() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (tBLottieAnimationView = this.a) != null) {
            tBLottieAnimationView.cancelAnimation();
            this.a.setFrame(0);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.g = (RelativeLayout) findViewById(R.id.lay_bubble);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) findViewById(R.id.img_voice_status);
            this.a = tBLottieAnimationView;
            tBLottieAnimationView.loop(true);
            this.b = (TextView) findViewById(R.id.tex_voice_duration);
            this.c = (ImageView) findViewById(R.id.img_voice_readed);
            this.d = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091d2e);
            i("");
        }
    }

    public void i(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (!StringUtils.isNull(str) && str.endsWith("MsgleftView")) {
                z = true;
                SkinManager.setBackgroundResource(this.g, R.drawable.selector_msg_text_bubble_other);
            } else {
                if (!StringUtils.isNull(str) && str.endsWith("MsgrightView")) {
                    SkinManager.setBackgroundResource(this.g, R.drawable.selector_msg_text_bubble_me);
                }
                z = false;
            }
            j(false, z);
        }
    }

    public final void n(ChatMessage chatMessage) {
        VoiceMsgData r;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, chatMessage) == null) {
            boolean z = true;
            if (gc8.y(chatMessage) || ((r = gc8.r(chatMessage)) != null && r.getHas_read() == 1)) {
                z = false;
            }
            if (z) {
                this.c.setVisibility(0);
            } else {
                this.c.setVisibility(8);
            }
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            if (i == 3) {
                TBLottieAnimationView tBLottieAnimationView = this.a;
                if (tBLottieAnimationView != null) {
                    tBLottieAnimationView.setVisibility(0);
                }
                this.d.setVisibility(4);
                o();
                VoiceMsgData r = gc8.r(this.f);
                if (r != null && r.getHas_read() != 1) {
                    r.setHas_read(1);
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(r);
                    this.f.setContent(PreferencesUtil.LEFT_MOUNT + jsonStrWithObject + PreferencesUtil.RIGHT_MOUNT);
                    ChatMessage chatMessage = this.f;
                    if (chatMessage instanceof PersonalChatMessage) {
                        PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(new CommonMsgPojo(personalChatMessage));
                        wx5.c(new b(this, personalChatMessage, linkedList), new c(this));
                        return;
                    } else if (chatMessage instanceof OfficialChatMessage) {
                        OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                        LinkedList linkedList2 = new LinkedList();
                        linkedList2.add(new CommonMsgPojo(officialChatMessage));
                        wx5.c(new d(this, officialChatMessage, linkedList2), new e(this));
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            p();
            if (jp5.b().d()) {
                jp5.b().n(false);
                jp5.b().l(false);
            }
            if (i == 1) {
                TBLottieAnimationView tBLottieAnimationView2 = this.a;
                if (tBLottieAnimationView2 != null) {
                    tBLottieAnimationView2.setVisibility(0);
                }
                this.d.setVisibility(4);
            } else if (i == 2) {
                TBLottieAnimationView tBLottieAnimationView3 = this.a;
                if (tBLottieAnimationView3 != null) {
                    tBLottieAnimationView3.setVisibility(4);
                }
                this.d.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void onShowErr(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i, str) == null) {
            xi.N(getContext(), str);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, chatMessage) == null) && chatMessage != null && chatMessage.getCacheData() != null) {
            VoiceData.VoiceModel voice_model = chatMessage.getCacheData().getVoice_model();
            this.e = voice_model;
            if (voice_model == null) {
                this.e = new VoiceData.VoiceModel();
            }
            this.f = chatMessage;
            this.b.setText(VoiceManager.formatVoiceTime01(this.e.getDuration()));
            this.b.setContentDescription(String.format(getContext().getString(R.string.editor_record_format), VoiceManager.formatVoiceTime01(this.e.getDuration())));
            setBubbleLength(this.e.getDuration());
            setTag(this.e);
            n(chatMessage);
            if (this.e.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            l(this.e.voice_status.intValue());
        }
    }
}
