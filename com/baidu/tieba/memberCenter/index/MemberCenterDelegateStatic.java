package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.g0.c;
import d.a.p0.g0.d;
/* loaded from: classes4.dex */
public class MemberCenterDelegateStatic extends d.a.p0.g0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f18645a;

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f18646b;

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c fragmentTabStructure;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2007002 || customResponsedMessage.getData() == null) {
                return;
            }
            MemberCenterDelegateStatic memberCenterDelegateStatic = new MemberCenterDelegateStatic();
            ((d) customResponsedMessage.getData()).a(memberCenterDelegateStatic);
            if (((d) customResponsedMessage.getData()).b() == null || (fragmentTabStructure = memberCenterDelegateStatic.getFragmentTabStructure()) == null) {
                return;
            }
            fragmentTabStructure.f52618a.setArguments(new Bundle());
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MemberCenterDelegateStatic f18647a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MemberCenterDelegateStatic memberCenterDelegateStatic, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {memberCenterDelegateStatic, Integer.valueOf(i2)};
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
            this.f18647a = memberCenterDelegateStatic;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    this.f18647a.f18645a.setVisibility(8);
                } else if (!TbadkCoreApplication.isLogin()) {
                    this.f18647a.f18645a.setVisibility(8);
                } else {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    d.a.p0.s.d0.b j = d.a.p0.s.d0.b.j();
                    if (TbadkCoreApplication.getInst().getLastUpdateMemberCenterTime() > j.l("maintab_member_center_red_tip_" + currentAccount, 0L)) {
                        this.f18647a.f18645a.setVisibility(0);
                    } else {
                        this.f18647a.f18645a.setVisibility(8);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1909480022, "Lcom/baidu/tieba/memberCenter/index/MemberCenterDelegateStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1909480022, "Lcom/baidu/tieba/memberCenter/index/MemberCenterDelegateStatic;");
                return;
            }
        }
        new a(2007002);
    }

    public MemberCenterDelegateStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // d.a.p0.g0.b
    public c createFragmentTabStructure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c cVar = new c();
            cVar.f52618a = new MemberCenterFragment();
            cVar.f52622e = 14;
            cVar.f52619b = R.string.member;
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    @Override // d.a.p0.g0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            this.mIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
            this.f18645a = new ImageView(context);
            TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
            aVar.f13169f = this.mIndicator;
            aVar.f13166c = l.e(context, 3.0f);
            ImageView imageView = this.f18645a;
            aVar.f13164a = imageView;
            aVar.f13167d = R.drawable.icon_news_down_bar_one;
            imageView.setVisibility(8);
            this.mIndicator.a("member_center_red_tip", aVar);
            return this.mIndicator;
        }
        return (TbFragmentTabIndicator) invokeL.objValue;
    }

    @Override // d.a.p0.g0.b
    public boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? MainTabActivityConfig.MEMBER_CENTER_TAB_AVAILABLE : invokeV.booleanValue;
    }

    @Override // d.a.p0.g0.b
    public void onAdd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onAdd();
            this.f18646b = new b(this, 2016459);
        }
    }

    @Override // d.a.p0.g0.b
    public void onRemove() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onRemove();
            this.f18645a = null;
            MessageManager.getInstance().unRegisterListener(this.f18646b);
        }
    }
}
