package com.baidu.tieba.im.widget.chatVoiceView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
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
import d.a.r0.z0.f0;
import d.a.r0.z0.i0;
import d.a.r0.z0.n;
import d.a.s0.i1.h.l;
import d.a.s0.i1.h.m;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class ChatVoiceView extends LinearLayout implements VoiceManager.i, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f17666e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f17667f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17668g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f17669h;

    /* renamed from: i  reason: collision with root package name */
    public ProgressBar f17670i;
    public VoiceData$VoiceModel j;
    public ChatMessage k;
    public RelativeLayout l;

    /* loaded from: classes5.dex */
    public class a extends f0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonGroupChatMessage f17671a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f17672b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ChatVoiceView f17673c;

        public a(ChatVoiceView chatVoiceView, CommonGroupChatMessage commonGroupChatMessage, LinkedList linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatVoiceView, commonGroupChatMessage, linkedList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17673c = chatVoiceView;
            this.f17671a = commonGroupChatMessage;
            this.f17672b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.r0.z0.f0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(d.a.s0.i1.h.c.h().l(this.f17671a.getGroupId(), this.f17672b, false)) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements n<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ChatVoiceView f17674a;

        public b(ChatVoiceView chatVoiceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatVoiceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17674a = chatVoiceView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f17674a.f17669h.setVisibility(8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends f0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonGroupChatMessage f17675a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f17676b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ChatVoiceView f17677c;

        public c(ChatVoiceView chatVoiceView, CommonGroupChatMessage commonGroupChatMessage, LinkedList linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatVoiceView, commonGroupChatMessage, linkedList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17677c = chatVoiceView;
            this.f17675a = commonGroupChatMessage;
            this.f17676b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.r0.z0.f0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(m.t().m(d.a.s0.i1.w.c.m(this.f17675a), this.f17676b, false)) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements n<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ChatVoiceView f17678a;

        public d(ChatVoiceView chatVoiceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatVoiceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17678a = chatVoiceView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f17678a.f17669h.setVisibility(8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends f0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalChatMessage f17679a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f17680b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ChatVoiceView f17681c;

        public e(ChatVoiceView chatVoiceView, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatVoiceView, personalChatMessage, linkedList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17681c = chatVoiceView;
            this.f17679a = personalChatMessage;
            this.f17680b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.r0.z0.f0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(m.t().m(d.a.s0.i1.w.c.m(this.f17679a), this.f17680b, false)) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements n<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ChatVoiceView f17682a;

        public f(ChatVoiceView chatVoiceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatVoiceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17682a = chatVoiceView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f17682a.f17669h.setVisibility(8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends f0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialChatMessage f17683a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedList f17684b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ChatVoiceView f17685c;

        public g(ChatVoiceView chatVoiceView, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatVoiceView, officialChatMessage, linkedList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17685c = chatVoiceView;
            this.f17683a = officialChatMessage;
            this.f17684b = linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.r0.z0.f0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(l.t().m(d.a.s0.i1.w.c.m(this.f17683a), this.f17684b, false)) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class h implements n<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ChatVoiceView f17686a;

        public h(ChatVoiceView chatVoiceView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatVoiceView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17686a = chatVoiceView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.f17686a.f17669h.setVisibility(8);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17666e = null;
        this.f17668g = null;
        this.f17669h = null;
        this.f17670i = null;
        LayoutInflater.from(context).inflate(R.layout.widget_left_voice_view, (ViewGroup) this, true);
        b();
    }

    private void setBubbleLength(int i2) {
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(65539, this, i2) != null) {
            return;
        }
        int k = d.a.c.e.p.l.k(getContext());
        try {
            if (i2 <= 10) {
                double d2 = k;
                i4 = (int) (0.1875d * d2);
                i5 = ((i2 - 1) * (((int) (d2 * 0.4125d)) - i4)) / 10;
            } else if (i2 <= 30) {
                double d3 = k;
                i4 = (int) (0.4125d * d3);
                i5 = ((i2 - 10) * (((int) (d3 * 0.5375d)) - i4)) / 20;
            } else {
                i3 = (int) (k * 0.5375d);
                if (this.l.getParent() == null && (this.l.getParent() instanceof RelativeLayout)) {
                    this.l.setLayoutParams(new RelativeLayout.LayoutParams(i3, -2));
                    return;
                }
                this.l.setLayoutParams(new LinearLayout.LayoutParams(i3, -2));
                return;
            }
            if (this.l.getParent() == null) {
            }
            this.l.setLayoutParams(new LinearLayout.LayoutParams(i3, -2));
            return;
        } catch (Exception unused) {
            return;
        }
        i3 = i4 + i5;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.l = (RelativeLayout) findViewById(R.id.lay_bubble);
            this.f17666e = (ImageView) findViewById(R.id.img_voice_status);
            this.f17667f = (ImageView) findViewById(R.id.img_voice_status_anim);
            this.f17668g = (TextView) findViewById(R.id.tex_voice_duration);
            this.f17669h = (ImageView) findViewById(R.id.img_voice_readed);
            this.f17670i = (ProgressBar) findViewById(R.id.progress);
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (i2 == 3) {
                ImageView imageView = this.f17666e;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                this.f17670i.setVisibility(4);
                h();
                VoiceMsgData n = d.a.s0.i1.w.c.n(this.k);
                if (n == null || n.getHas_read() == 1) {
                    return;
                }
                n.setHas_read(1);
                String jsonStrWithObject = OrmObject.jsonStrWithObject(n);
                this.k.setContent(PreferencesUtil.LEFT_MOUNT + jsonStrWithObject + PreferencesUtil.RIGHT_MOUNT);
                ChatMessage chatMessage = this.k;
                if (chatMessage instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(new CommonMsgPojo(commonGroupChatMessage));
                    if (!commonGroupChatMessage.getGroupId().equals(String.valueOf(d.a.s0.i1.s.a.f61853i))) {
                        i0.c(new a(this, commonGroupChatMessage, linkedList), new b(this));
                        return;
                    } else {
                        i0.c(new c(this, commonGroupChatMessage, linkedList), new d(this));
                        return;
                    }
                } else if (chatMessage instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new CommonMsgPojo(personalChatMessage));
                    i0.c(new e(this, personalChatMessage, linkedList2), new f(this));
                    return;
                } else if (chatMessage instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                    LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(new CommonMsgPojo(officialChatMessage));
                    i0.c(new g(this, officialChatMessage, linkedList3), new h(this));
                    return;
                } else {
                    return;
                }
            }
            i();
            if (i2 == 1) {
                ImageView imageView2 = this.f17666e;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
                this.f17670i.setVisibility(4);
            } else if (i2 == 2) {
                ImageView imageView3 = this.f17666e;
                if (imageView3 != null) {
                    imageView3.setVisibility(4);
                }
                this.f17670i.setVisibility(0);
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.j = null;
            d(1);
        }
    }

    public final void f(ChatMessage chatMessage) {
        VoiceMsgData n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, chatMessage) == null) {
            boolean z = true;
            if (d.a.s0.i1.w.c.p(chatMessage) || ((n = d.a.s0.i1.w.c.n(chatMessage)) != null && n.getHas_read() == 1)) {
                z = false;
            }
            if (z) {
                this.f17669h.setVisibility(0);
            } else {
                this.f17669h.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager.i getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Context context = getContext();
            VoiceManager.i realView = context instanceof VoiceManager.j ? ((VoiceManager.j) context).getRealView(this.j) : this;
            return realView == null ? this : realView;
        }
        return (VoiceManager.i) invokeV.objValue;
    }

    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Context context = getContext();
            if (context instanceof VoiceManager.j) {
                return ((VoiceManager.j) context).getVoiceManager();
            }
            return null;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceData$VoiceModel getVoiceModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.j : (VoiceData$VoiceModel) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f17666e.setVisibility(8);
            this.f17667f.setVisibility(0);
            ((AnimationDrawable) this.f17667f.getBackground()).start();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ((AnimationDrawable) this.f17667f.getBackground()).stop();
            this.f17667f.clearAnimation();
            this.f17666e.setVisibility(0);
            this.f17667f.setVisibility(8);
        }
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            VoiceData$VoiceModel voiceData$VoiceModel = this.j;
            return voiceData$VoiceModel != null && voiceData$VoiceModel.voice_status.intValue() == 3;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, view) == null) || this.j == null || (voiceManager = getVoiceManager()) == null) {
            return;
        }
        voiceManager.startPlay(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDetachedFromWindow();
            try {
                i();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void onPlayElapse(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            c(i2);
            VoiceData$VoiceModel voiceData$VoiceModel = this.j;
            if (voiceData$VoiceModel != null) {
                voiceData$VoiceModel.elapse = i2;
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void onPlayPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void onRefreshByPlayStatus(VoiceData$VoiceModel voiceData$VoiceModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, voiceData$VoiceModel) == null) || voiceData$VoiceModel == null) {
            return;
        }
        d(voiceData$VoiceModel.voice_status.intValue());
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void onShowErr(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048592, this, i2, str) == null) {
            d.a.c.e.p.l.J(getContext(), str);
        }
    }

    public void setData(ChatMessage chatMessage) {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, chatMessage) == null) || chatMessage == null || chatMessage.getCacheData() == null) {
            return;
        }
        VoiceData$VoiceModel voice_model = chatMessage.getCacheData().getVoice_model();
        this.j = voice_model;
        if (voice_model == null) {
            this.j = new VoiceData$VoiceModel();
        }
        this.k = chatMessage;
        this.f17668g.setText(VoiceManager.formatVoiceTime(this.j.duration));
        this.f17668g.setContentDescription(String.format(getContext().getString(R.string.editor_record_format), VoiceManager.formatVoiceTime(this.j.duration)));
        setBubbleLength(this.j.duration);
        setTag(this.j);
        f(chatMessage);
        if (this.j.voice_status.intValue() != 1 && (voiceManager = getVoiceManager()) != null) {
            voiceManager.resetPlayView(this);
        }
        d(this.j.voice_status.intValue());
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
        this.f17666e = null;
        this.f17668g = null;
        this.f17669h = null;
        this.f17670i = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ChatVoiceView, 0, 0);
        if (obtainStyledAttributes != null) {
            z = obtainStyledAttributes.getBoolean(R$styleable.ChatVoiceView_is_left, true);
            obtainStyledAttributes.recycle();
        } else {
            z = true;
        }
        if (z) {
            LayoutInflater.from(context).inflate(R.layout.widget_left_voice_view, (ViewGroup) this, true);
        } else {
            LayoutInflater.from(context).inflate(R.layout.widget_right_voice_view, (ViewGroup) this, true);
        }
        b();
    }
}
