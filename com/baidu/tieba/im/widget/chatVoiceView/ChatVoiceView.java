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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.ju8;
import com.baidu.tieba.ku8;
import com.baidu.tieba.nu5;
import com.baidu.tieba.ru5;
import com.baidu.tieba.st5;
import com.baidu.tieba.vya;
import com.baidu.tieba.vz8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class ChatVoiceView extends LinearLayout implements VoiceManager.IPlayView, View.OnClickListener {
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
    public int j;

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
    public void onPlayPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
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
    public class b extends nu5<Boolean> {
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
        @Override // com.baidu.tieba.nu5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return Boolean.valueOf(ku8.w().n(vz8.r(this.a), this.b, false));
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements st5<Boolean> {
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
        @Override // com.baidu.tieba.st5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.a.c.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends nu5<Boolean> {
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
        @Override // com.baidu.tieba.nu5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return Boolean.valueOf(ju8.w().n(vz8.r(this.a), this.b, false));
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e implements st5<Boolean> {
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
        @Override // com.baidu.tieba.st5
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
        this.j = 0;
        LayoutInflater.from(context).inflate(R.layout.widget_left_voice_view, (ViewGroup) this, true);
        e();
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
        this.j = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vya.ChatVoiceView, 0, 0);
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
        e();
    }

    public void g(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            int i = this.i;
            if (i != 0) {
                if (i != this.j) {
                    this.j = i;
                    this.a.clearAnimation();
                    this.b.setTextColor(this.i);
                    this.a.setAnimation(R.raw.im_voice_buble_anim);
                    return;
                }
                return;
            }
            if (!z && z2) {
                EMManager.from(this.b).setTextColor(R.color.CAM_X0105);
            } else {
                EMManager.from(this.b).setTextColor(R.color.CAM_X0114);
            }
            this.a.setAnimation(R.raw.im_voice_buble_anim);
        }
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
        this.j = 0;
        if (z) {
            LayoutInflater.from(context).inflate(R.layout.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(R.layout.widget_right_voice_view, (ViewGroup) this, true);
        }
        e();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, view2) == null) && this.e != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.startPlay(this);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
    public void onPlayElapse(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            h(i);
            VoiceData.VoiceModel voiceModel = this.e;
            if (voiceModel != null) {
                voiceModel.elapse = i;
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
    public void onRefreshByPlayStatus(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, voiceModel) != null) || voiceModel == null) {
            return;
        }
        i(voiceModel.voice_status.intValue());
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
            if (BdUtilHelper.getEquipmentDensity(getContext()) <= 2.0f) {
                f = BdUtilHelper.getEquipmentDensity(getContext()) / 1.6f;
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
            i(voiceModel.voice_status.intValue());
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.addLottieOnCompositionLoadedListener(new a(this));
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
    public VoiceManager.IPlayView getRealView() {
        InterceptResult invokeV;
        VoiceManager.IPlayView iPlayView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Context context = getContext();
            if (context instanceof VoiceManager.j) {
                iPlayView = ((VoiceManager.j) context).V1(this.e);
            } else {
                iPlayView = this;
            }
            if (iPlayView == null) {
                return this;
            }
            return iPlayView;
        }
        return (VoiceManager.IPlayView) invokeV.objValue;
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
                return ((VoiceManager.j) context).d1();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
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

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.e = null;
            i(1);
        }
    }

    public final void l() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (tBLottieAnimationView = this.a) != null) {
            tBLottieAnimationView.playAnimation();
        }
    }

    public final void n() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (tBLottieAnimationView = this.a) != null) {
            tBLottieAnimationView.cancelAnimation();
            this.a.setFrame(0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDetachedFromWindow();
            try {
                n();
            } catch (Exception unused) {
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.g = (RelativeLayout) findViewById(R.id.lay_bubble);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) findViewById(R.id.img_voice_status);
            this.a = tBLottieAnimationView;
            tBLottieAnimationView.loop(true);
            this.b = (TextView) findViewById(R.id.tex_voice_duration);
            this.c = (ImageView) findViewById(R.id.img_voice_readed);
            this.d = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091e5c);
            f("");
        }
    }

    public void f(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (!StringUtils.isNull(str) && str.endsWith("MsgleftView")) {
                z = true;
                SkinManager.setBackgroundResource(this.g, R.drawable.selector_msg_text_bubble_other);
            } else {
                if (!StringUtils.isNull(str) && str.endsWith("MsgrightView")) {
                    SkinManager.setBackgroundResource(this.g, R.drawable.selector_msg_text_bubble_me);
                }
                z = false;
            }
            g(false, z);
        }
    }

    public final void k(ChatMessage chatMessage) {
        VoiceMsgData s;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, chatMessage) == null) {
            boolean z = true;
            if (vz8.A(chatMessage) || ((s = vz8.s(chatMessage)) != null && s.getHas_read() == 1)) {
                z = false;
            }
            if (z) {
                this.c.setVisibility(0);
            } else {
                this.c.setVisibility(8);
            }
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            if (i == 3) {
                TBLottieAnimationView tBLottieAnimationView = this.a;
                if (tBLottieAnimationView != null) {
                    tBLottieAnimationView.setVisibility(0);
                }
                this.d.setVisibility(4);
                l();
                VoiceMsgData s = vz8.s(this.f);
                if (s != null && s.getHas_read() != 1) {
                    s.setHas_read(1);
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(s);
                    this.f.setContent(PreferencesUtil.LEFT_MOUNT + jsonStrWithObject + PreferencesUtil.RIGHT_MOUNT);
                    ChatMessage chatMessage = this.f;
                    if (chatMessage instanceof PersonalChatMessage) {
                        PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(new CommonMsgPojo(personalChatMessage));
                        ru5.c(new b(this, personalChatMessage, linkedList), new c(this));
                        return;
                    } else if (chatMessage instanceof OfficialChatMessage) {
                        OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                        LinkedList linkedList2 = new LinkedList();
                        linkedList2.add(new CommonMsgPojo(officialChatMessage));
                        ru5.c(new d(this, officialChatMessage, linkedList2), new e(this));
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            n();
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

    @Override // com.baidu.tbadk.core.voice.VoiceManager.IPlayView
    public void onShowErr(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048595, this, i, str) == null) {
            BdUtilHelper.showLongToast(getContext(), str);
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
            k(chatMessage);
            if (this.e.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
                voiceManager.resetPlayView(this);
            }
            i(this.e.voice_status.intValue());
        }
    }
}
