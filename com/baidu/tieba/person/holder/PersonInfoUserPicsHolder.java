package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.bn;
import com.baidu.tieba.gr9;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.hr9;
import com.baidu.tieba.yq9;
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
    public gr9 e;
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
        this.b = view2.findViewById(R.id.obfuscated_res_0x7f090924);
        this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924cf);
        HTypeListView hTypeListView = (HTypeListView) view2.findViewById(R.id.obfuscated_res_0x7f091566);
        this.d = hTypeListView;
        this.e = new gr9(this.g, hTypeListView);
    }

    public void b(hr9 hr9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, hr9Var) != null) || hr9Var == null) {
            return;
        }
        this.e.c(d(hr9Var.a()));
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

    public final List<bn> d(List<bn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (ListUtils.getCount(list) <= 0) {
                return list;
            }
            ArrayList arrayList = new ArrayList(list);
            yq9 yq9Var = new yq9(BdUtilHelper.getDimens(this.g.getPageActivity(), R.dimen.obfuscated_res_0x7f070207), BdUtilHelper.getDimens(this.g.getPageActivity(), R.dimen.obfuscated_res_0x7f070364));
            ListUtils.add(arrayList, 0, yq9Var);
            ListUtils.add(arrayList, yq9Var);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
