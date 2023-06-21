package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class xd9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yd9 a;
    public TbPageContext b;
    public List<wn> c;
    public PersonMoreData d;

    public xd9(TbPageContext tbPageContext, Bundle bundle, lo6<ye9> lo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bundle, lo6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = tbPageContext;
        yd9 yd9Var = new yd9(tbPageContext);
        this.a = yd9Var;
        yd9Var.f(lo6Var);
        a(bundle);
    }

    public final void a(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) && bundle != null && (bundle.get(PersonMoreData.URL_MAPS) instanceof ArrayList)) {
            this.d = new PersonMoreData();
            this.d.mUrlMaps.addAll(DataExt.toEntityList(bundle.getStringArrayList(PersonMoreData.URL_MAPS).toString(), PersonMoreItemData.class));
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c = new ArrayList();
            PersonMoreData personMoreData = this.d;
            if (personMoreData != null && !ListUtils.isEmpty(personMoreData.mUrlMaps)) {
                for (PersonMoreItemData personMoreItemData : this.d.mUrlMaps) {
                    if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                        ye9 ye9Var = new ye9();
                        ye9Var.e = personMoreItemData.mName;
                        ye9Var.a = 36;
                        ye9Var.f = personMoreItemData.mUrl;
                        ye9Var.j = personMoreItemData.mId;
                        this.c.add(ye9Var);
                    }
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.getPageActivity().setContentView(R.layout.obfuscated_res_0x7f0d0791);
            this.a.c(this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091b94));
            b();
            this.a.e(this.c);
        }
    }

    public void d() {
        yd9 yd9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (yd9Var = this.a) != null) {
            yd9Var.d();
        }
    }
}
