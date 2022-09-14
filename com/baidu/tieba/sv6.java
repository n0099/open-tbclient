package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateBarActivityConfig;
import com.baidu.tbadk.core.atomData.CreateForumActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.home.CreateBarGuideActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.UserBfbInfo;
/* loaded from: classes5.dex */
public class sv6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CreateBarGuideActivity a;
    public View b;
    public View c;
    public NoNetworkView d;
    public NoDataView e;
    public NavigationBar f;
    public TextView g;
    public TextView h;
    public TextView i;
    public LinearLayout j;
    public TbImageView k;
    public UserBfbInfo l;
    public String m;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sv6 a;

        public a(sv6 sv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sv6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.l != null) {
                    if (this.a.l.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(this.a.a.getActivity(), this.a.m, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(this.a.a.getActivity(), this.a.m, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(this.a.a.getActivity(), this.a.m, true)));
                }
                TiebaStatic.log("c11223");
                this.a.a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sv6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(sv6 sv6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sv6Var, Integer.valueOf(i)};
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
            this.a = sv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.l == null) {
                return;
            }
            if (this.a.l.res_no.intValue() == 9528) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(this.a.a.getActivity(), this.a.m, true)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(this.a.a.getActivity(), this.a.m, true)));
            }
        }
    }

    public sv6(CreateBarGuideActivity createBarGuideActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {createBarGuideActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = createBarGuideActivity;
        View inflate = LayoutInflater.from(createBarGuideActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0201, (ViewGroup) null);
        this.b = inflate;
        this.a.setContentView(inflate);
        this.c = this.b.findViewById(R.id.obfuscated_res_0x7f0903b7);
        NavigationBar navigationBar = (NavigationBar) this.b.findViewById(R.id.obfuscated_res_0x7f0925c2);
        this.f = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f.setTitleText(R.string.obfuscated_res_0x7f0f046e);
        this.d = (NoNetworkView) this.b.findViewById(R.id.obfuscated_res_0x7f0925c4);
        this.h = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09211a);
        this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092119);
        this.k = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091f85);
        this.g.setOnClickListener(new a(this));
        this.i = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092114);
        this.j = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091671);
        MessageManager.getInstance().registerListener(new b(this, 2016458));
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c.setVisibility(8);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            td5.a(this.a.getPageContext(), this.b);
            NavigationBar navigationBar = this.f;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            NoNetworkView noNetworkView = this.d;
            if (noNetworkView != null) {
                noNetworkView.d(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            NoDataView noDataView = this.e;
            if (noDataView != null) {
                noDataView.f(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c.setVisibility(0);
        }
    }

    public void h(String str, UserBfbInfo userBfbInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, userBfbInfo) == null) {
            this.m = str;
            this.l = userBfbInfo;
            if (this.e == null) {
                int f = ej.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07019a);
                NoDataView a2 = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0908ae), NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, f), null, null);
                this.e = a2;
                a2.setVisibility(0);
                f();
            }
            TextView textView = this.h;
            textView.setText(this.m + "吧");
            UserBfbInfo userBfbInfo2 = this.l;
            if (userBfbInfo2 != null && userBfbInfo2.res_no.intValue() == 9528) {
                if (this.l.activity_status.intValue() == 0) {
                    this.k.setImageResource(R.drawable.icon_create_attention_n);
                } else {
                    this.k.setImageResource(R.drawable.icon_create_complete_n);
                }
            } else {
                this.i.setVisibility(4);
                this.j.setVisibility(4);
            }
            this.i.setVisibility(8);
            this.j.setVisibility(8);
        }
    }
}
