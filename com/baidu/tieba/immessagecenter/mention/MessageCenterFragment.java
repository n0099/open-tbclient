package com.baidu.tieba.immessagecenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.LazyBaseFragment;
import com.baidu.tbadk.core.atomData.ShareFriendActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.nf8;
import com.baidu.tieba.nt8;
import com.baidu.tieba.t55;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class MessageCenterFragment extends LazyBaseFragment implements VoiceManager.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nt8 g;
    public VoiceManager h;
    public CustomMessageListener i;

    @Override // com.baidu.tbadk.core.LazyBaseFragment
    public int X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.obfuscated_res_0x7f0d0630 : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "a079" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.IPlayView r1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.IPlayView) invokeL.objValue;
    }

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MessageCenterFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MessageCenterFragment messageCenterFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {messageCenterFragment, Integer.valueOf(i)};
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
            this.a = messageCenterFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 3 && this.a.isPrimary() && this.a.g != null) {
                this.a.g.H();
            }
        }
    }

    public MessageCenterFragment() {
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
        this.i = new a(this, 2001384);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.h == null) {
                this.h = VoiceManager.instance();
            }
            return this.h;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            getActivity().finish();
        }
    }

    public void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ShareFriendActivityConfig shareFriendActivityConfig = new ShareFriendActivityConfig(getContext());
            shareFriendActivityConfig.setIsForChat(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, shareFriendActivityConfig));
            TiebaStatic.log("c12929");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            nf8.l().c();
            nt8 nt8Var = this.g;
            if (nt8Var != null) {
                nt8Var.G();
            }
            VoiceManager voiceManager = this.h;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPause();
            VoiceManager voiceManager = this.h;
            if (voiceManager != null) {
                voiceManager.onPause();
            }
            YunDialogManager.onHidden(t55.l);
        }
    }

    @Override // com.baidu.tbadk.core.LazyBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                if (getContext() != null) {
                    YunDialogManager.onShow(getContext(), t55.l);
                    return;
                }
                return;
            }
            YunDialogManager.onHidden(t55.l);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
            VoiceManager voiceManager = this.h;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.h;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onStop();
            VoiceManager voiceManager = this.h;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && this.g != null) {
            super.changeSkinType(i);
        }
    }

    public void d2(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, intent) == null) {
            nf8.l().c();
            if (this.h == null) {
                VoiceManager H0 = H0();
                this.h = H0;
                H0.onCreate(getPageContext());
            }
            if (intent != null) {
                e2(intent);
            }
        }
    }

    public final void e2(Intent intent) {
        nt8 nt8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, intent) == null) && (nt8Var = this.g) != null) {
            nt8Var.I(-1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            super.onChangeSkinType(i);
            nt8 nt8Var = this.g;
            if (nt8Var != null) {
                nt8Var.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.LazyBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.i);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        nt8 nt8Var;
        TbTabLayout.f u;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) && (nt8Var = this.g) != null && (u = nt8Var.u()) != null) {
            bundle.putInt("Selected_Tab", u.d());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            super.setPrimary(z);
            nt8 nt8Var = this.g;
            if (nt8Var != null) {
                nt8Var.J(z);
            }
        }
    }

    @Override // com.baidu.tbadk.core.LazyBaseFragment
    public void Z1(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, bundle) == null) {
            nt8 nt8Var = new nt8(this);
            this.g = nt8Var;
            nt8Var.C(view2);
            this.g.I(-2);
            e2(getActivity().getIntent());
            VoiceManager H0 = H0();
            this.h = H0;
            H0.onCreate(getPageContext());
            TiebaStatic.log(new StatisticItem("c11941"));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048585, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            nt8 nt8Var = this.g;
            if (nt8Var != null) {
                nt8Var.F(i, i2, intent);
            }
        }
    }
}
