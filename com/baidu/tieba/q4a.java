package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.BdExpandListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.themeCenter.SkinProgressView;
import com.baidu.tieba.themeCenter.background.BackgroundPreviewActivity;
import com.baidu.tieba.themeCenter.background.BackgroundSetHttpResponseMessage;
import com.baidu.tieba.themeCenter.background.BackgroundSetRequestMessage;
import com.baidu.tieba.themeCenter.background.BackgroundSetSocketResponseMessage;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class q4a {
    public static /* synthetic */ Interceptable $ic;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;
    public BackgroundPreviewActivity a;
    public View b;
    public View c;
    public NavigationBar d;
    public p4a e;
    public BdExpandListView f;
    public n4a g;
    public SkinProgressView h;
    public DressItemData i;
    public k4a j;
    public View.OnClickListener k;
    public jb l;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q4a a;

        public a(q4a q4aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q4aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q4aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.a.i != null && this.a.j != null) {
                TiebaStatic.log(new StatisticItem("c10284"));
                if (this.a.i.getInUse()) {
                    i95.e(this.a.a.getPageContext().getPageActivity(), 8);
                } else {
                    this.a.j.e(this.a.i, true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends jb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q4a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(q4a q4aVar, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q4aVar, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q4aVar;
        }

        @Override // com.baidu.tieba.jb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            if (!(responsedMessage instanceof BackgroundSetHttpResponseMessage) && !(responsedMessage instanceof BackgroundSetSocketResponseMessage)) {
                return;
            }
            if (responsedMessage.getError() != 0) {
                int i = c4a.b;
                if (responsedMessage.getError() == c4a.c) {
                    i = c4a.a;
                }
                this.a.j.d(i, responsedMessage.getErrorString(), this.a.i, ((BackgroundSetRequestMessage) responsedMessage.getOrginalMessage().getExtra()).getFromDetail());
                return;
            }
            TiebaStatic.log(new StatisticItem("c10286").param("obj_id", this.a.i.getPropsId()).param("obj_type", this.a.i.getFreeUserLevel()));
            this.a.i.setInUse(true);
            this.a.m();
            n95 m = n95.m();
            m.z("current_used_personal_background_" + TbadkCoreApplication.getCurrentAccount(), this.a.i.getPropsId());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948043243, "Lcom/baidu/tieba/q4a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948043243, "Lcom/baidu/tieba/q4a;");
                return;
            }
        }
        m = vi.g(TbadkApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0703b6);
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0204);
            this.a.hideNetRefreshView(this.b);
            this.c.setVisibility(0);
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            rx9.h(309022, BackgroundSetSocketResponseMessage.class, false, false);
            rx9.c(309022, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, TbConfig.PERSONAL_BACKGROUND_SET, BackgroundSetHttpResponseMessage.class, false, false, false, false);
        }
    }

    public q4a(BackgroundPreviewActivity backgroundPreviewActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {backgroundPreviewActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = new a(this);
        this.l = new b(this, CmdConfigHttp.CMD_PERSONAL_BACKGROUND_SET, 309022);
        this.a = backgroundPreviewActivity;
        View inflate = LayoutInflater.from(backgroundPreviewActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0139, (ViewGroup) null);
        this.b = inflate;
        this.a.setContentView(inflate);
        this.c = this.b.findViewById(R.id.obfuscated_res_0x7f090414);
        NavigationBar navigationBar = (NavigationBar) this.b.findViewById(R.id.view_navigation_bar);
        this.d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.showBottomLine(false);
        this.f = (BdExpandListView) this.a.findViewById(R.id.obfuscated_res_0x7f091bc8);
        this.h = (SkinProgressView) this.b.findViewById(R.id.obfuscated_res_0x7f09286c);
        k4a k4aVar = new k4a(backgroundPreviewActivity.getPageContext(), this.a.getUniqueId());
        this.j = k4aVar;
        k4aVar.c(this.a.y1());
    }

    public void j(BdExpandListView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f.setExpandListRefreshListener(bVar);
        }
    }

    public void g() {
        n4a n4aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            gt5.a(this.a.getPageContext(), this.b);
            NavigationBar navigationBar = this.d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
                SkinManager.setBackgroundResource(this.d, R.color.common_color_10262);
            }
            BdExpandListView bdExpandListView = this.f;
            if (bdExpandListView != null && bdExpandListView.getVisibility() == 0 && (n4aVar = this.g) != null) {
                n4aVar.notifyDataSetChanged();
            }
        }
    }

    public final void m() {
        DressItemData dressItemData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || (dressItemData = this.i) == null) {
            return;
        }
        boolean inUse = dressItemData.getInUse();
        int activityFinish = this.i.getActivityFinish();
        this.h.setFontSize(vi.g(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0702b7));
        if (inUse) {
            this.h.b(0, 0.0f, this.i.getFreeUserLevel(), activityFinish, 2);
        } else {
            this.h.b(9, 0.0f, this.i.getFreeUserLevel(), activityFinish, 2);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c.setVisibility(8);
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0201);
            String string = this.a.getPageContext().getResources().getString(R.string.no_data_text);
            this.a.setNetRefreshViewTopMargin(m);
            this.a.showNetRefreshView(this.b, string, false);
        }
    }

    public void l(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dressItemData) == null) {
            this.i = dressItemData;
            if (dressItemData == null) {
                k();
                return;
            }
            e();
            if (this.e == null) {
                p4a p4aVar = new p4a(this.a);
                this.e = p4aVar;
                p4aVar.e(dressItemData);
                this.f.addHeaderView(this.e.b());
                this.e.d();
                this.f.setExpandView(this.e.b(), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703cf));
                n4a n4aVar = new n4a(this.a.getPageContext(), dressItemData);
                this.g = n4aVar;
                this.f.setAdapter((ListAdapter) n4aVar);
                i();
                this.a.registerListener(this.l);
            }
            this.h.setDressData(this.i);
            this.h.setOnClickListener(this.k);
            m();
        }
    }
}
