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
/* loaded from: classes9.dex */
public class zca extends nl6<xba> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public View j;
    public View k;
    public TextView l;
    public HTypeListView m;
    public vaa n;

    @Override // com.baidu.tieba.nl6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01c7 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xba a;
        public final /* synthetic */ zca b;

        public a(zca zcaVar, xba xbaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zcaVar, xbaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zcaVar;
            this.a = xbaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.r(this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zca(TbPageContext tbPageContext) {
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
        this.k = i3.findViewById(R.id.obfuscated_res_0x7f09096e);
        this.l = (TextView) this.j.findViewById(R.id.obfuscated_res_0x7f090ebd);
        HTypeListView hTypeListView = (HTypeListView) this.j.findViewById(R.id.obfuscated_res_0x7f090eaa);
        this.m = hTypeListView;
        this.n = new vaa(this.i, hTypeListView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nl6
    /* renamed from: s */
    public void j(xba xbaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, xbaVar) == null) {
            if (xbaVar != null && xbaVar.isValid()) {
                a aVar = new a(this, xbaVar);
                this.n.a(aVar);
                this.j.setOnClickListener(aVar);
                this.n.b(aVar);
                this.m.setData(y(xbaVar.g));
                if (xbaVar.a) {
                    this.l.setText(R.string.obfuscated_res_0x7f0f0916);
                } else if (xbaVar.b) {
                    this.l.setText(R.string.obfuscated_res_0x7f0f0915);
                } else {
                    this.l.setText(R.string.obfuscated_res_0x7f0f0914);
                }
                k(this.i, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.j.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.nl6
    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
        }
    }

    public final void r(xba xbaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, xbaVar) == null) {
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
                this.i.showToast(R.string.obfuscated_res_0x7f0f0912);
            } else if (!ViewHelper.checkUpIsLogin(this.i.getPageActivity())) {
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.i.getPageActivity(), xbaVar.c, xbaVar.d, xbaVar.e, xbaVar.f)));
            }
        }
    }

    public final List<pi> y(List<pi> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            int count = ListUtils.getCount(list);
            if (count <= 0) {
                return list;
            }
            List<pi> arrayList = new ArrayList<>(list);
            int dimens = BdUtilHelper.getDimens(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f07019a);
            int dimens2 = BdUtilHelper.getDimens(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f070207);
            if (count > 7) {
                arrayList = arrayList.subList(0, 7);
                yba ybaVar = new yba();
                ybaVar.b = dimens;
                ybaVar.a = dimens;
                ListUtils.add(arrayList, ybaVar);
            }
            g7a g7aVar = new g7a(dimens2, dimens);
            ListUtils.add(arrayList, 0, g7aVar);
            ListUtils.add(arrayList, g7aVar);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
