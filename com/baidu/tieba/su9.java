package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
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
/* loaded from: classes8.dex */
public class su9 extends cj6<qt9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public View j;
    public View k;
    public TextView l;
    public HTypeListView m;
    public os9 n;

    @Override // com.baidu.tieba.cj6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01be : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qt9 a;
        public final /* synthetic */ su9 b;

        public a(su9 su9Var, qt9 qt9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {su9Var, qt9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = su9Var;
            this.a = qt9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.t(this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public su9(TbPageContext tbPageContext) {
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
        View i3 = i();
        this.j = i3;
        this.k = i3.findViewById(R.id.obfuscated_res_0x7f09092e);
        this.l = (TextView) this.j.findViewById(R.id.obfuscated_res_0x7f090e65);
        HTypeListView hTypeListView = (HTypeListView) this.j.findViewById(R.id.obfuscated_res_0x7f090e52);
        this.m = hTypeListView;
        this.n = new os9(this.i, hTypeListView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cj6
    /* renamed from: u */
    public void j(qt9 qt9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, qt9Var) == null) {
            if (qt9Var != null && qt9Var.isValid()) {
                a aVar = new a(this, qt9Var);
                this.n.a(aVar);
                this.j.setOnClickListener(aVar);
                this.n.b(aVar);
                this.m.setData(x(qt9Var.g));
                if (qt9Var.a) {
                    this.l.setText(R.string.obfuscated_res_0x7f0f08ff);
                } else if (qt9Var.b) {
                    this.l.setText(R.string.obfuscated_res_0x7f0f08fe);
                } else {
                    this.l.setText(R.string.obfuscated_res_0x7f0f08fd);
                }
                k(this.i, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.j.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.cj6
    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
        }
    }

    public final void t(qt9 qt9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, qt9Var) == null) {
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
                this.i.showToast(R.string.obfuscated_res_0x7f0f08fb);
            } else if (!ViewHelper.checkUpIsLogin(this.i.getPageActivity())) {
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.i.getPageActivity(), qt9Var.c, qt9Var.d, qt9Var.e, qt9Var.f)));
            }
        }
    }

    public final List<yh> x(List<yh> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            int count = ListUtils.getCount(list);
            if (count <= 0) {
                return list;
            }
            List<yh> arrayList = new ArrayList<>(list);
            int dimens = BdUtilHelper.getDimens(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f07019a);
            int dimens2 = BdUtilHelper.getDimens(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f070207);
            if (count > 7) {
                arrayList = arrayList.subList(0, 7);
                rt9 rt9Var = new rt9();
                rt9Var.b = dimens;
                rt9Var.a = dimens;
                ListUtils.add(arrayList, rt9Var);
            }
            zo9 zo9Var = new zo9(dimens2, dimens);
            ListUtils.add(arrayList, 0, zo9Var);
            ListUtils.add(arrayList, zo9Var);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
