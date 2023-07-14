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
import com.baidu.tieba.ho9;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.io9;
import com.baidu.tieba.yi;
import com.baidu.tieba.yn;
import com.baidu.tieba.zn9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class PersonInfoUserPicsHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public View b;
    public TextView c;
    public HTypeListView d;
    public ho9 e;
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
        this.b = view2.findViewById(R.id.obfuscated_res_0x7f09090f);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092483);
        HTypeListView hTypeListView = (HTypeListView) view2.findViewById(R.id.obfuscated_res_0x7f09153c);
        this.d = hTypeListView;
        this.e = new ho9(this.g, hTypeListView);
    }

    public void b(io9 io9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, io9Var) != null) || io9Var == null) {
            return;
        }
        this.e.c(d(io9Var.a()));
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f != TbadkCoreApplication.getInst().getSkinType()) {
            this.f = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.c, R.color.CAM_X0109, 1);
            this.e.b();
        }
    }

    public final List<yn> d(List<yn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (ListUtils.getCount(list) <= 0) {
                return list;
            }
            ArrayList arrayList = new ArrayList(list);
            zn9 zn9Var = new zn9(yi.g(this.g.getPageActivity(), R.dimen.obfuscated_res_0x7f070207), yi.g(this.g.getPageActivity(), R.dimen.obfuscated_res_0x7f070364));
            ListUtils.add(arrayList, 0, zn9Var);
            ListUtils.add(arrayList, zn9Var);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
