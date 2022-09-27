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
/* loaded from: classes6.dex */
public class u98 extends i16<s88> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public View j;
    public View k;
    public TextView l;
    public HTypeListView m;
    public q78 n;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s88 a;
        public final /* synthetic */ u98 b;

        public a(u98 u98Var, s88 s88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u98Var, s88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u98Var;
            this.a = s88Var;
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
    public u98(TbPageContext tbPageContext) {
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
        this.k = h.findViewById(R.id.obfuscated_res_0x7f090821);
        this.l = (TextView) this.j.findViewById(R.id.obfuscated_res_0x7f090cc4);
        HTypeListView hTypeListView = (HTypeListView) this.j.findViewById(R.id.obfuscated_res_0x7f090cb1);
        this.m = hTypeListView;
        this.n = new q78(this.i, hTypeListView);
    }

    @Override // com.baidu.tieba.i16
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0192 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.i16
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    public final void s(s88 s88Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, s88Var) == null) {
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
                this.i.showToast(R.string.obfuscated_res_0x7f0f07d6);
            } else if (ViewHelper.checkUpIsLogin(this.i.getPageActivity())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.i.getPageActivity(), s88Var.c, s88Var.d, s88Var.e, s88Var.f)));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i16
    /* renamed from: t */
    public void i(s88 s88Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, s88Var) == null) {
            if (s88Var != null && s88Var.isValid()) {
                a aVar = new a(this, s88Var);
                this.n.a(aVar);
                this.j.setOnClickListener(aVar);
                this.n.b(aVar);
                this.m.setData(u(s88Var.g));
                if (s88Var.a) {
                    this.l.setText(R.string.obfuscated_res_0x7f0f07da);
                } else if (s88Var.b) {
                    this.l.setText(R.string.obfuscated_res_0x7f0f07d9);
                } else {
                    this.l.setText(R.string.obfuscated_res_0x7f0f07d8);
                }
                j(this.i, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.j.setVisibility(8);
        }
    }

    public final List<Cdo> u(List<Cdo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            int count = ListUtils.getCount(list);
            if (count <= 0) {
                return list;
            }
            List<Cdo> arrayList = new ArrayList<>(list);
            int f = ej.f(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f07019a);
            int f2 = ej.f(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f070207);
            if (count > 7) {
                arrayList = arrayList.subList(0, 7);
                t88 t88Var = new t88();
                t88Var.b = f;
                t88Var.a = f;
                ListUtils.add(arrayList, t88Var);
            }
            d48 d48Var = new d48(f2, f);
            ListUtils.add(arrayList, 0, d48Var);
            ListUtils.add(arrayList, d48Var);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
