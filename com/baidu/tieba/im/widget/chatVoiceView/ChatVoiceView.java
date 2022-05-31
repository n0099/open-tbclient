package com.baidu.tieba.im.widget.chatVoiceView;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.repackage.d47;
import com.repackage.e47;
import com.repackage.j57;
import com.repackage.li;
import com.repackage.mc5;
import com.repackage.pc5;
import com.repackage.s45;
import com.repackage.tb5;
import com.repackage.u37;
import com.repackage.wq4;
import com.repackage.y67;
import java.util.LinkedList;
/* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class a extends mc5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonGroupChatMessage a;
        public final /* synthetic */ LinkedList b;
        public final /* synthetic */ ChatVoiceView c;

        public a(ChatVoiceView chatVoiceView, CommonGroupChatMessage commonGroupChatMessage, LinkedList linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatVoiceView, commonGroupChatMessage, linkedList};
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
            this.a = commonGroupChatMessage;
            this.b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.repackage.mc5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(u37.h().l(this.a.getGroupId(), this.b, false)) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements tb5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatVoiceView a;

        public b(ChatVoiceView chatVoiceView) {
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
        @Override // com.repackage.tb5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.a.c.setVisibility(8);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends mc5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonGroupChatMessage a;
        public final /* synthetic */ LinkedList b;
        public final /* synthetic */ ChatVoiceView c;

        public c(ChatVoiceView chatVoiceView, CommonGroupChatMessage commonGroupChatMessage, LinkedList linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatVoiceView, commonGroupChatMessage, linkedList};
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
            this.a = commonGroupChatMessage;
            this.b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.repackage.mc5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(e47.v().n(y67.o(this.a), this.b, false)) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements tb5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatVoiceView a;

        public d(ChatVoiceView chatVoiceView) {
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
        @Override // com.repackage.tb5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.a.c.setVisibility(8);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends mc5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatMessage a;
        public final /* synthetic */ LinkedList b;
        public final /* synthetic */ ChatVoiceView c;

        public e(ChatVoiceView chatVoiceView, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
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
        @Override // com.repackage.mc5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(e47.v().n(y67.o(this.a), this.b, false)) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements tb5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatVoiceView a;

        public f(ChatVoiceView chatVoiceView) {
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
        @Override // com.repackage.tb5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.a.c.setVisibility(8);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends mc5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialChatMessage a;
        public final /* synthetic */ LinkedList b;
        public final /* synthetic */ ChatVoiceView c;

        public g(ChatVoiceView chatVoiceView, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
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
        @Override // com.repackage.mc5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(d47.v().n(y67.o(this.a), this.b, false)) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class h implements tb5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatVoiceView a;

        public h(ChatVoiceView chatVoiceView) {
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
        @Override // com.repackage.tb5
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
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d08a5, (ViewGroup) this, true);
        e();
    }

    private void setBubbleLength(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i) == null) {
            int i2 = (int) (((i <= 10 ? ((i - 1) * 9) + 74 : ((i - 10) * 2) + Cea708Decoder.COMMAND_SPL) * 2.6f) + 0.5f);
            try {
                if (this.g.getParent() != null && (this.g.getParent() instanceof RelativeLayout)) {
                    this.g.setLayoutParams(new RelativeLayout.LayoutParams(i2, -2));
                } else {
                    this.g.setLayoutParams(new LinearLayout.LayoutParams(i2, -2));
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            g(i);
            VoiceData.VoiceModel voiceModel = this.e;
            if (voiceModel != null) {
                voiceModel.elapse = i;
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void b(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voiceModel) == null) || voiceModel == null) {
            return;
        }
        h(voiceModel.voice_status.intValue());
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.g = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091177);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) findViewById(R.id.obfuscated_res_0x7f090eb2);
            this.a = tBLottieAnimationView;
            tBLottieAnimationView.loop(true);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f091f05);
            this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f090eb1);
            this.d = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091927);
            f("");
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (!StringUtils.isNull(str) && str.endsWith("MsgleftView")) {
                SkinManager.setBackgroundResource(this.g, R.drawable.selector_msg_text_bubble_other);
            } else if (!StringUtils.isNull(str) && str.endsWith("MsgrightView")) {
                SkinManager.setBackgroundResource(this.g, R.drawable.selector_msg_text_bubble_me);
            }
            this.a.setAnimation(R.raw.im_voice_buble_anim);
            wq4.d(this.b).v(R.color.CAM_X0105);
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager.i getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Context context = getContext();
            VoiceManager.i realView = context instanceof VoiceManager.j ? ((VoiceManager.j) context).getRealView(this.e) : this;
            return realView == null ? this : realView;
        }
        return (VoiceManager.i) invokeV.objValue;
    }

    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Context context = getContext();
            if (context instanceof VoiceManager.j) {
                return ((VoiceManager.j) context).getVoiceManager();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceData.VoiceModel getVoiceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.e : (VoiceData.VoiceModel) invokeV.objValue;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            if (i == 3) {
                TBLottieAnimationView tBLottieAnimationView = this.a;
                if (tBLottieAnimationView != null) {
                    tBLottieAnimationView.setVisibility(0);
                }
                this.d.setVisibility(4);
                k();
                VoiceMsgData p = y67.p(this.f);
                if (p == null || p.getHas_read() == 1) {
                    return;
                }
                p.setHas_read(1);
                String jsonStrWithObject = OrmObject.jsonStrWithObject(p);
                this.f.setContent(PreferencesUtil.LEFT_MOUNT + jsonStrWithObject + PreferencesUtil.RIGHT_MOUNT);
                ChatMessage chatMessage = this.f;
                if (chatMessage instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(j57.j))) {
                        pc5.c(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        pc5.c(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (chatMessage instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    pc5.c(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (chatMessage instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                    LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    pc5.c(new g(this, officialChatMessage, linkedList3), new h(this));
                    return;
                } else {
                    return;
                }
            }
            l();
            if (s45.b().d()) {
                s45.b().n(false);
                s45.b().l(false);
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

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.e = null;
            h(1);
        }
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            VoiceData.VoiceModel voiceModel = this.e;
            return voiceModel != null && voiceModel.voice_status.intValue() == 3;
        }
        return invokeV.booleanValue;
    }

    public final void j(ChatMessage chatMessage) {
        VoiceMsgData p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, chatMessage) == null) {
            boolean z = true;
            if (y67.t(chatMessage) || ((p = y67.p(chatMessage)) != null && p.getHas_read() == 1)) {
                z = false;
            }
            if (z) {
                this.c.setVisibility(0);
            } else {
                this.c.setVisibility(8);
            }
        }
    }

    public final void k() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (tBLottieAnimationView = this.a) == null) {
            return;
        }
        tBLottieAnimationView.playAnimation();
    }

    public final void l() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (tBLottieAnimationView = this.a) == null) {
            return;
        }
        tBLottieAnimationView.cancelAnimation();
        this.a.setFrame(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, view2) == null) || this.e == null || (voiceManager = getVoiceManager()) == null) {
            return;
        }
        voiceManager.startPlay(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDetachedFromWindow();
            try {
                l();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void onShowErr(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048593, this, i, str) == null) {
            li.L(getContext(), str);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, chatMessage) == null) || chatMessage == null || chatMessage.getCacheData() == null) {
            return;
        }
        VoiceData.VoiceModel voice_model = chatMessage.getCacheData().getVoice_model();
        this.e = voice_model;
        if (voice_model == null) {
            this.e = new VoiceData.VoiceModel();
        }
        this.f = chatMessage;
        this.b.setText(VoiceManager.formatVoiceTime01(this.e.duration));
        this.b.setContentDescription(String.format(getContext().getString(R.string.obfuscated_res_0x7f0f0536), VoiceManager.formatVoiceTime01(this.e.duration)));
        setBubbleLength(this.e.duration);
        setTag(this.e);
        j(chatMessage);
        if (this.e.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
            voiceManager.resetPlayView(this);
        }
        h(this.e.voice_status.intValue());
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040315}, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d08a5, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d08b4, (ViewGroup) this, true);
        }
        e();
    }
}
