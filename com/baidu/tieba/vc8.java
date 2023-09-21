package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.sendtool.SendNoLaunchView;
import com.baidu.tieba.im.base.core.inputtool.GroupInputTool;
import com.baidu.tieba.im.base.core.inputtool.InputToolFragment;
import com.baidu.tieba.im.base.core.inputtool.keyboardtool.PanelType;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes8.dex */
public class vc8 implements VoiceManager.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VoiceManager a;
    public GroupInputTool b;
    public Context c;
    public TbPageContext d;
    public boolean e;
    public final InputToolFragment f;
    public ISendVoiceView g;
    public PermissionJudgePolicy h;
    public xi5 i;
    public EditorTools j;
    public PanelType k;
    public PanelType l;
    public adc<PanelType, PanelType, Float, Float> m;
    public dp8 n;

    public void k(int i, int i2, @Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, intent) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView w1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements dp8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vc8 a;

        @Override // com.baidu.tieba.dp8
        public void setRecoding(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            }
        }

        public a(vc8 vc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vc8Var;
        }

        @Override // com.baidu.tieba.dp8
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.a != null && this.a.h().f()) {
                    if (this.a.f == null) {
                        return true;
                    }
                    FragmentActivity fragmentActivity = this.a.f.getFragmentActivity();
                    if (this.a.h == null) {
                        this.a.h = new PermissionJudgePolicy();
                    }
                    this.a.h.clearRequestPermissionList();
                    this.a.h.appendRequestPermission(fragmentActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    this.a.h.appendRequestPermission(fragmentActivity, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
                    return !this.a.h.startRequestPermission(fragmentActivity);
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.dp8
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.h() != null) {
                this.a.h().cancelRecord();
            }
        }

        @Override // com.baidu.tieba.dp8
        public boolean isForeground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.a.e;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.dp8
        public void stopRecord() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.a.h() != null) {
                this.a.h().stopRecord();
            }
        }

        @Override // com.baidu.tieba.dp8
        public void startRecord() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a.h() != null) {
                this.a.h().c(this.a.b, -1);
                this.a.h().d(qi.c);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-350873728, "Lcom/baidu/tieba/vc8$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-350873728, "Lcom/baidu/tieba/vc8$b;");
                    return;
                }
            }
            int[] iArr = new int[PanelType.values().length];
            a = iArr;
            try {
                iArr[PanelType.INPUT_KEYBOARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PanelType.VOICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[PanelType.EXPRESSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[PanelType.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public vc8(@NonNull InputToolFragment inputToolFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputToolFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = null;
        this.j = null;
        PanelType panelType = PanelType.NONE;
        this.k = panelType;
        this.l = panelType;
        this.n = new a(this);
        this.c = inputToolFragment.getContext();
        this.d = inputToolFragment.getPageContext();
        this.f = inputToolFragment;
        j();
    }

    public void o(xi5 xi5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, xi5Var) == null) {
            this.i = xi5Var;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.e = z;
        }
    }

    public void r(adc<PanelType, PanelType, Float, Float> adcVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, adcVar) == null) {
            this.m = adcVar;
        }
    }

    public void s(PermissionJudgePolicy permissionJudgePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, permissionJudgePolicy) == null) {
            this.h = permissionJudgePolicy;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    @NonNull
    public VoiceManager P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Nullable
    public PermissionJudgePolicy g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (PermissionJudgePolicy) invokeV.objValue;
    }

    public tla h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            VoiceManager voiceManager = this.a;
            if (voiceManager != null && voiceManager.getRecorderManager() != null) {
                return this.a.getRecorderManager();
            }
            return null;
        }
        return (tla) invokeV.objValue;
    }

    public void i() {
        ISendVoiceView iSendVoiceView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (iSendVoiceView = this.g) != null) {
            iSendVoiceView.setTouchCallBack(this.n);
        }
    }

    public void l() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (voiceManager = this.a) != null) {
            voiceManager.onDestory(this.d);
        }
    }

    public void m() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (voiceManager = this.a) != null) {
            voiceManager.onPause();
        }
    }

    public void n() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (voiceManager = this.a) != null) {
            voiceManager.onResume(this.d);
            this.a.setSpeakerphoneOn(!TbadkCoreApplication.getInst().isHeadsetModeOn());
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.a == null) {
                this.a = new VoiceManager();
                P0().setIsUseMediaPlayer(true);
                this.a.onCreate(this.d);
            }
            this.a.setSpeakerphoneOn(!TbadkCoreApplication.getInst().isHeadsetModeOn());
            VoiceManager.setIsNeedBlackScreen(false);
        }
    }

    public void q(GroupInputTool groupInputTool) {
        xi5 xi5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, groupInputTool) == null) {
            this.b = groupInputTool;
            EditorTools T2 = groupInputTool.T();
            this.j = T2;
            if (T2 != null && this.b != null && (xi5Var = this.i) != null) {
                T2.setActionListener(24, xi5Var);
                this.j.setActionListener(8, this.i);
                this.j.setActionListener(4, this.i);
                this.j.setActionListener(14, this.i);
                this.j.setActionListener(5, this.i);
                this.j.setActionListener(17, this.i);
                this.j.setActionListener(16, this.i);
                this.j.setActionListener(62, this.i);
                this.j.setActionListener(64, this.i);
                this.j.setActionListener(63, this.i);
                this.j.setActionListener(80, this.i);
                this.g = this.b.R();
                v(SharedPrefHelper.getInstance().getBoolean("key_group_chat_chatroom_audio_switch", true));
                t(SharedPrefHelper.getInstance().getBoolean("key_group_chat_chatroom_picture_switch", true), this.c.getString(R.string.function_can_not_use));
                this.j.D(new wi5(73, 3, 200));
                this.j.D(new wi5(79, 3, Boolean.TRUE));
            }
        }
    }

    public void t(boolean z, String str) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048590, this, z, str) == null) && (editorTools = this.j) != null && editorTools.p(38) != null && (this.j.p(38).m instanceof SendNoLaunchView)) {
            ((SendNoLaunchView) this.j.p(38).m).setPicIconEnable(z);
            ((SendNoLaunchView) this.j.p(38).m).setSendInterceptToastText(str, z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(PanelType panelType) {
        int i;
        float f;
        adc<PanelType, PanelType, Float, Float> adcVar;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, panelType) == null) && vd8.k != 0 && this.k != panelType) {
            this.l = panelType;
            int i3 = b.a[panelType.ordinal()];
            float f2 = 0.0f;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            i = vd8.k;
                        } else {
                            PanelType panelType2 = this.k;
                            if (panelType2 == PanelType.INPUT_KEYBOARD || panelType2 == PanelType.EXPRESSION) {
                                i2 = vd8.k;
                                f2 = -i2;
                            }
                            f = 0.0f;
                        }
                    } else {
                        i = vd8.k;
                    }
                } else {
                    PanelType panelType3 = this.k;
                    if (panelType3 != PanelType.NONE && panelType3 == PanelType.INPUT_KEYBOARD) {
                        i2 = vd8.k;
                        f2 = -i2;
                    }
                    f = 0.0f;
                }
                adcVar = this.m;
                if (adcVar != null) {
                    adcVar.call(this.l, this.k, Float.valueOf(f2), Float.valueOf(f));
                }
                this.k = panelType;
            }
            i = vd8.k;
            f = -i;
            adcVar = this.m;
            if (adcVar != null) {
            }
            this.k = panelType;
        }
    }

    public void v(boolean z) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && (editorTools = this.j) != null) {
            if (editorTools.p(6) != null && !z) {
                this.j.p(6).f = R.color.CAM_X0109;
                this.j.p(6).k = false;
                return;
            }
            this.j.p(6).f = R.color.CAM_X0105;
            this.j.p(6).k = true;
        }
    }
}
