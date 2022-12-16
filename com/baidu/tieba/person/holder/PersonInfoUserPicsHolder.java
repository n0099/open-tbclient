package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.c98;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.k98;
import com.baidu.tieba.l98;
import com.baidu.tieba.xn;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class PersonInfoUserPicsHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public View b;
    public TextView c;
    public HTypeListView d;
    public k98 e;
    public int f;
    public TbPageContext g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonInfoUserPicsHolder(View view2, TbPageContext tbPageContext) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = 3;
        this.a = view2;
        this.g = tbPageContext;
        this.b = view2.findViewById(R.id.obfuscated_res_0x7f090856);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092211);
        HTypeListView hTypeListView = (HTypeListView) view2.findViewById(R.id.obfuscated_res_0x7f0913d2);
        this.d = hTypeListView;
        this.e = new k98(this.g, hTypeListView);
    }

    public void a(l98 l98Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, l98Var) != null) || l98Var == null) {
            return;
        }
        this.e.c(c(l98Var.a()));
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f != TbadkCoreApplication.getInst().getSkinType()) {
            this.f = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.c, R.color.CAM_X0109, 1);
            this.e.b();
        }
    }

    public final List<xn> c(List<xn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (ListUtils.getCount(list) <= 0) {
                return list;
            }
            ArrayList arrayList = new ArrayList(list);
            c98 c98Var = new c98(yi.g(this.g.getPageActivity(), R.dimen.obfuscated_res_0x7f070207), yi.g(this.g.getPageActivity(), R.dimen.obfuscated_res_0x7f07023c));
            ListUtils.add(arrayList, 0, c98Var);
            ListUtils.add(arrayList, c98Var);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
