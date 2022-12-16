package com.baidu.tieba.imMessageCenter.chatgroup.grouppage.inputTool;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.c75;
import com.baidu.tieba.h85;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.j75;
import com.baidu.tieba.m65;
import com.baidu.tieba.mj;
import com.baidu.tieba.oj;
import com.baidu.tieba.rw4;
import com.baidu.tieba.uk5;
import com.baidu.tieba.v85;
import com.baidu.tieba.x65;
import com.baidu.tieba.y65;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class GroupInputTool implements LifecycleObserver, oj {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GroupChatFragment a;
    public f b;
    public g c;
    public ViewTreeObserver.OnGlobalLayoutListener d;
    public boolean e;
    public boolean f;
    public final CustomMessageListener g;
    public final Handler h;

    /* loaded from: classes4.dex */
    public interface g {
        void a();

        void b(VoiceData.VoiceModel voiceModel);
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputTool a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GroupInputTool groupInputTool, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputTool, Integer.valueOf(i)};
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
            this.a = groupInputTool;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                this.a.f = ((Boolean) customResponsedMessage.getData()).booleanValue();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputTool a;

        public b(GroupInputTool groupInputTool) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputTool};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputTool;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what == 1) {
                    this.a.h.removeMessages(1);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements h85.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputTool a;

        public c(GroupInputTool groupInputTool) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputTool};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputTool;
        }

        @Override // com.baidu.tieba.h85.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.e = z;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements uk5.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputTool a;

        public d(GroupInputTool groupInputTool) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputTool};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputTool;
        }

        @Override // com.baidu.tieba.uk5.c
        public void a(@NonNull MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) && this.a.b != null && this.a.b.i() != null) {
                this.a.b.i().q();
                this.a.b.i().r();
                this.a.b.i().B(new m65(5, -1, null));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements uk5.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupInputTool a;

        public e(GroupInputTool groupInputTool) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupInputTool};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupInputTool;
        }

        @Override // com.baidu.tieba.uk5.d
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!this.a.e && !this.a.f) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public j75 a;
        public EditorTools b;
        public RelativeLayout c;
        public x65 d;
        public ISendVoiceView e;
        public GroupInputViewController f;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.b = null;
            this.d = null;
            this.e = null;
        }

        public ISendVoiceView h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.e;
            }
            return (ISendVoiceView) invokeV.objValue;
        }

        public EditorTools i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b;
            }
            return (EditorTools) invokeV.objValue;
        }

        public static f g(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, view2)) == null) {
                f fVar = new f();
                fVar.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090d57);
                return fVar;
            }
            return (f) invokeL.objValue;
        }

        public final void j(GroupChatFragment groupChatFragment, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, groupChatFragment, context) == null) {
                j75 j75Var = new j75(context, true, false);
                this.a = j75Var;
                j75Var.h(true);
                EditorTools editorTools = new EditorTools(context);
                this.b = editorTools;
                editorTools.setId(R.id.group_chat_input_tool_view);
                this.b.setMoreButtonAtEnd(true);
                this.b.setBarLauncherType(9);
                this.b.setBarMaxLauCount(1);
                this.b.setBackgroundColorId(R.color.CAM_X0204);
                this.b.setBarBackgroundColorId(R.color.CAM_X0207);
                this.b.setDeskBackgroundColorId(R.color.CAM_X0206);
                this.b.setMoreDeskBgColorId(R.color.CAM_X0206);
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001301, x65.class, context);
                if (runTask != null && runTask.getData() != null) {
                    x65 x65Var = (x65) runTask.getData();
                    this.d = x65Var;
                    y65 y65Var = x65Var.m;
                    if (y65Var != null && (y65Var instanceof ISendVoiceView)) {
                        this.e = (ISendVoiceView) y65Var;
                    }
                    x65 x65Var2 = this.d;
                    x65Var2.l = 1;
                    this.b.d(x65Var2);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(5);
                this.b.h(arrayList);
                x65 o = this.b.o(5);
                if (o != null) {
                    o.f(true);
                    o.e(true);
                    o.d = 0;
                }
                this.b.d(this.a);
                this.b.d(new c75(context));
                this.b.d(new v85(context, true));
                this.b.f();
                this.c.addView(this.b, new ViewGroup.LayoutParams(-1, -2));
                y65 y65Var2 = this.a.m;
                if (y65Var2 instanceof EditText) {
                    rw4 d = rw4.d((EditText) y65Var2);
                    d.z(R.dimen.T_X06);
                    d.n(R.string.J_X07);
                    d.l(R.dimen.L_X01);
                    d.k(R.color.CAM_X0209);
                    d.f(R.color.CAM_X0212);
                }
                this.b.x(TbadkCoreApplication.getInst().getSkinType());
            }
        }

        public final void k(int i) {
            y65 y65Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                this.b.x(i);
                j75 j75Var = this.a;
                if (j75Var != null && (y65Var = j75Var.m) != null && (y65Var instanceof EditText)) {
                    rw4 d = rw4.d((EditText) y65Var);
                    d.z(R.dimen.T_X06);
                    d.n(R.string.J_X07);
                    d.l(R.dimen.L_X01);
                    d.k(R.color.CAM_X0209);
                    d.f(R.color.CAM_X0212);
                }
            }
        }
    }

    public GroupInputTool(GroupChatFragment groupChatFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {groupChatFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new a(this, 2921774);
        this.h = new b(this);
        this.a = groupChatFragment;
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048580, this, i) != null) {
            return;
        }
        this.b.k(i);
    }

    public void m(@NonNull Bundle bundle) {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) && (fVar = this.b) != null && fVar.f != null) {
            this.b.f.H(bundle);
        }
    }

    public void n(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, gVar) == null) {
            this.c = gVar;
        }
    }

    @Override // com.baidu.tieba.oj
    public void onDeletedVoice(String str) {
        g gVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && (gVar = this.c) != null) {
            gVar.a();
        }
    }

    @Override // com.baidu.tieba.oj
    public void onShowRecordTime(int i) {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && (fVar = this.b) != null && fVar.e != null) {
            this.b.e.onShowRecordTime(i);
        }
    }

    @Override // com.baidu.tieba.oj
    public void onShowRecording(int i) {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (fVar = this.b) != null && fVar.e != null) {
            this.b.e.onShowRecording(i);
        }
    }

    @Override // com.baidu.tieba.oj
    public void onSendVoice(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i) == null) {
            VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
            voiceModel.setDuration(i);
            voiceModel.setVoiceId(str);
            voiceModel.voice_status = 1;
            g gVar = this.c;
            if (gVar != null) {
                gVar.b(voiceModel);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            f g2 = f.g(this.a.requireView());
            this.b = g2;
            GroupChatFragment groupChatFragment = this.a;
            g2.j(groupChatFragment, groupChatFragment.getContext());
            FragmentActivity requireActivity = this.a.requireActivity();
            this.a.registerListener(this.g);
            if (this.b.i() != null && this.b.i().b != null) {
                this.d = h85.b(requireActivity, this.b.i().b, new c(this));
            }
            uk5 g3 = uk5.g(requireActivity);
            g3.k(R.id.obfuscated_res_0x7f090d57);
            g3.j(new e(this));
            g3.i(new d(this));
            g3.f();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            Handler handler = this.h;
            if (handler != null) {
                handler.removeMessages(1);
            }
            GroupChatFragment groupChatFragment = this.a;
            if (groupChatFragment != null && this.d != null) {
                h85.c(groupChatFragment.requireActivity(), this.d);
            }
        }
    }

    @Nullable
    public RelativeLayout h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            f fVar = this.b;
            if (fVar != null) {
                return fVar.c;
            }
            return null;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Nullable
    public ISendVoiceView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            f fVar = this.b;
            if (fVar != null) {
                return fVar.h();
            }
            return null;
        }
        return (ISendVoiceView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oj
    public boolean isOnCancle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            f fVar = this.b;
            if (fVar != null && fVar.e != null) {
                return this.b.e.isOnCancle();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public EditorTools k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            f fVar = this.b;
            if (fVar != null) {
                return fVar.b;
            }
            return null;
        }
        return (EditorTools) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oj
    public void onStopingRecorder() {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (fVar = this.b) != null && fVar.e != null) {
            this.b.e.onStopingRecorder();
        }
    }

    @Override // com.baidu.tieba.oj
    public void onShowErr(int i, String str) {
        f fVar;
        GroupChatFragment groupChatFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048585, this, i, str) == null) && (fVar = this.b) != null && fVar.e != null) {
            this.b.e.onShowErr(i, str);
            if (!StringUtils.isNull(str) && (groupChatFragment = this.a) != null) {
                if (i == 3) {
                    groupChatFragment.showToast(str);
                    this.b.e.setRecoding(false);
                } else if (i == 2) {
                    Handler handler = this.h;
                    handler.sendMessageDelayed(handler.obtainMessage(1), 500L);
                } else {
                    groupChatFragment.showToast(str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.oj
    public void onStartedRecorder(boolean z, int i) {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && (fVar = this.b) != null && fVar.e != null) {
            this.b.e.onStartedRecorder(z, mj.c);
        }
    }
}
