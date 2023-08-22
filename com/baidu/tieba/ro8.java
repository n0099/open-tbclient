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
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.GroupInputTool;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes7.dex */
public class ro8 implements VoiceManager.i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VoiceManager a;
    public GroupInputTool b;
    public Context c;
    public TbPageContext d;
    public boolean e;
    public GroupChatFragment f;
    public ISendVoiceView g;
    public PermissionJudgePolicy h;
    public ai5 i;
    public EditorTools j;
    public wi8 k;

    public void k(int i, int i2, @Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, intent) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager.IPlayView q1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements wi8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ro8 a;

        @Override // com.baidu.tieba.wi8
        public void setRecoding(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            }
        }

        public a(ro8 ro8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ro8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ro8Var;
        }

        @Override // com.baidu.tieba.wi8
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

        @Override // com.baidu.tieba.wi8
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.h() != null) {
                this.a.h().cancelRecord();
            }
        }

        @Override // com.baidu.tieba.wi8
        public boolean isForeground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.a.e;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.wi8
        public void stopRecord() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.a.h() != null) {
                this.a.h().stopRecord();
            }
        }

        @Override // com.baidu.tieba.wi8
        public void startRecord() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.a.h() != null) {
                this.a.h().c(this.a.b, -1);
                this.a.h().d(qi.c);
            }
        }
    }

    public ro8(GroupChatFragment groupChatFragment) {
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
        this.g = null;
        this.j = null;
        this.k = new a(this);
        this.c = groupChatFragment.getContext();
        this.d = groupChatFragment.getPageContext();
        this.f = groupChatFragment;
        j();
    }

    public void o(ai5 ai5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, ai5Var) == null) {
            this.i = ai5Var;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.e = z;
        }
    }

    public void r(PermissionJudgePolicy permissionJudgePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, permissionJudgePolicy) == null) {
            this.h = permissionJudgePolicy;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    @NonNull
    public VoiceManager G0() {
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

    public tha h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            VoiceManager voiceManager = this.a;
            if (voiceManager != null && voiceManager.getRecorderManager() != null) {
                return this.a.getRecorderManager();
            }
            return null;
        }
        return (tha) invokeV.objValue;
    }

    public void i() {
        ISendVoiceView iSendVoiceView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (iSendVoiceView = this.g) != null) {
            iSendVoiceView.setTouchCallBack(this.k);
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
                G0().setIsUseMediaPlayer(true);
                this.a.onCreate(this.d);
            }
            this.a.setSpeakerphoneOn(!TbadkCoreApplication.getInst().isHeadsetModeOn());
            VoiceManager.setIsNeedBlackScreen(false);
        }
    }

    public void q(GroupInputTool groupInputTool) {
        ai5 ai5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, groupInputTool) == null) {
            this.b = groupInputTool;
            EditorTools S = groupInputTool.S();
            this.j = S;
            if (S != null && this.b != null && (ai5Var = this.i) != null) {
                S.setActionListener(24, ai5Var);
                this.j.setActionListener(8, this.i);
                this.j.setActionListener(4, this.i);
                this.j.setActionListener(14, this.i);
                this.j.setActionListener(5, this.i);
                this.j.setActionListener(17, this.i);
                this.j.setActionListener(16, this.i);
                this.j.setActionListener(62, this.i);
                this.j.setActionListener(64, this.i);
                this.j.setActionListener(63, this.i);
                this.g = this.b.Q();
                t(SharedPrefHelper.getInstance().getBoolean("key_group_chat_chatroom_audio_switch", true));
                s(SharedPrefHelper.getInstance().getBoolean("key_group_chat_chatroom_picture_switch", true), this.c.getString(R.string.function_can_not_use));
                this.j.D(new zh5(73, 3, 200));
            }
        }
    }

    public void s(boolean z, String str) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048590, this, z, str) == null) && (editorTools = this.j) != null && editorTools.p(38) != null && (this.j.p(38).m instanceof SendNoLaunchView)) {
            ((SendNoLaunchView) this.j.p(38).m).setPicIconEnable(z);
            ((SendNoLaunchView) this.j.p(38).m).setSendInterceptToastText(str, z);
        }
    }

    public void t(boolean z) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048591, this, z) == null) && (editorTools = this.j) != null) {
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
