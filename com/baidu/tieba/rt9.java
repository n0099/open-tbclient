package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class rt9 extends wo6<ps9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public View j;
    public View k;
    public TextView l;
    public HTypeListView m;
    public nr9 n;

    @Override // com.baidu.tieba.wo6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01b4 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ps9 a;
        public final /* synthetic */ rt9 b;

        public a(rt9 rt9Var, ps9 ps9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rt9Var, ps9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rt9Var;
            this.a = ps9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.s(this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rt9(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = tbPageContext;
        View h = h();
        this.j = h;
        this.k = h.findViewById(R.id.obfuscated_res_0x7f09090e);
        this.l = (TextView) this.j.findViewById(R.id.obfuscated_res_0x7f090e34);
        HTypeListView hTypeListView = (HTypeListView) this.j.findViewById(R.id.obfuscated_res_0x7f090e21);
        this.m = hTypeListView;
        this.n = new nr9(this.i, hTypeListView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.wo6
    /* renamed from: t */
    public void i(ps9 ps9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ps9Var) == null) {
            if (ps9Var != null && ps9Var.isValid()) {
                a aVar = new a(this, ps9Var);
                this.n.a(aVar);
                this.j.setOnClickListener(aVar);
                this.n.b(aVar);
                this.m.setData(u(ps9Var.g));
                if (ps9Var.a) {
                    this.l.setText(R.string.obfuscated_res_0x7f0f08ea);
                } else if (ps9Var.b) {
                    this.l.setText(R.string.obfuscated_res_0x7f0f08e9);
                } else {
                    this.l.setText(R.string.obfuscated_res_0x7f0f08e8);
                }
                j(this.i, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.j.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.wo6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
        }
    }

    public final void s(ps9 ps9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ps9Var) == null) {
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
                this.i.showToast(R.string.obfuscated_res_0x7f0f08e6);
            } else if (!ViewHelper.checkUpIsLogin(this.i.getPageActivity())) {
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.i.getPageActivity(), ps9Var.c, ps9Var.d, ps9Var.e, ps9Var.f)));
            }
        }
    }

    public final List<yn> u(List<yn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            int count = ListUtils.getCount(list);
            if (count <= 0) {
                return list;
            }
            List<yn> arrayList = new ArrayList<>(list);
            int g = yi.g(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f07019a);
            int g2 = yi.g(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f070207);
            if (count > 7) {
                arrayList = arrayList.subList(0, 7);
                qs9 qs9Var = new qs9();
                qs9Var.b = g;
                qs9Var.a = g;
                ListUtils.add(arrayList, qs9Var);
            }
            zn9 zn9Var = new zn9(g2, g);
            ListUtils.add(arrayList, 0, zn9Var);
            ListUtils.add(arrayList, zn9Var);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
