package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.j1.b.e;
/* loaded from: classes5.dex */
public class ChatAggregationFragment extends BaseFragment implements d.a.r0.g0.c.a, NoNetworkView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public e f17842e;

    /* renamed from: f  reason: collision with root package name */
    public ViewEventCenter f17843f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f17844g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f17845h;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ChatAggregationFragment f17846a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ChatAggregationFragment chatAggregationFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatAggregationFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17846a = chatAggregationFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                if (this.f17846a.f17842e != null) {
                    this.f17846a.f17842e.m0(true);
                }
                MentionActivityConfig.newJumpIn = true;
                if (this.f17846a.f17842e != null) {
                    this.f17846a.f17842e.L();
                    this.f17846a.f17842e.w0(TbadkCoreApplication.isLogin(), true ^ TbadkCoreApplication.isLogin());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ChatAggregationFragment f17847a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ChatAggregationFragment chatAggregationFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatAggregationFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17847a = chatAggregationFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (this.f17847a.f17842e != null) {
                    this.f17847a.f17842e.S(intent);
                }
            }
        }
    }

    public ChatAggregationFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17844g = new a(this, 2005016);
        this.f17845h = new b(this, 2016321);
    }

    public ViewEventCenter H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f17843f == null) {
                this.f17843f = new ViewEventCenter();
            }
            return this.f17843f;
        }
        return (ViewEventCenter) invokeV.objValue;
    }

    public final boolean I0(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent)) == null) ? (intent == null || intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1) == -1) ? false : true : invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void b(boolean z) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (eVar = this.f17842e) == null) {
            return;
        }
        eVar.R(z);
    }

    @Override // d.a.r0.g0.c.a
    public boolean isEventMustSelf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048580, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 12011) {
                Bundle extras = intent.getExtras();
                String string = extras.getString("user_id");
                String string2 = extras.getString("user_name");
                String string3 = extras.getString("name_show");
                String string4 = extras.getString("portrait");
                if (string2 == null || string == null) {
                    return;
                }
                try {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getActivity(), Long.parseLong(string), string2, string3, string4, 0)));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (eVar = this.f17842e) == null) {
            return;
        }
        eVar.N(getPageContext(), i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, layoutInflater, viewGroup, bundle)) == null) {
            e eVar = new e(this);
            this.f17842e = eVar;
            if (bundle != null) {
                eVar.J(bundle);
            } else {
                eVar.J(null);
            }
            View P = this.f17842e.P();
            this.f17842e.N(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            H0().addEventDelegate(this);
            registerListener(this.f17844g);
            registerListener(this.f17845h);
            return P;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.f17844g);
            MessageManager.getInstance().unRegisterListener(this.f17845h);
            e eVar = this.f17842e;
            if (eVar != null) {
                eVar.K();
            }
        }
    }

    @Override // d.a.r0.g0.c.a
    public boolean onEventDispatch(d.a.r0.g0.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar)) == null) ? bVar == null : invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPrimary();
            e eVar = this.f17842e;
            if (eVar != null) {
                eVar.A();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            super.onUserChanged(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, view, bundle) == null) {
            if (getActivity() != null && I0(getActivity().getIntent())) {
                this.f17842e.S(getActivity().getIntent());
            } else {
                this.f17842e.L();
            }
            super.onViewCreated(view, bundle);
        }
    }

    public void p() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (eVar = this.f17842e) == null) {
            return;
        }
        eVar.j0();
    }
}
