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
/* loaded from: classes7.dex */
public class qp9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rp9 a;
    public TbPageContext b;
    public List<yh> c;
    public PersonMoreData d;

    public qp9(TbPageContext tbPageContext, Bundle bundle, bk6<rq9> bk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bundle, bk6Var};
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
        rp9 rp9Var = new rp9(tbPageContext);
        this.a = rp9Var;
        rp9Var.f(bk6Var);
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
                        rq9 rq9Var = new rq9();
                        rq9Var.e = personMoreItemData.mName;
                        rq9Var.a = 36;
                        rq9Var.f = personMoreItemData.mUrl;
                        rq9Var.j = personMoreItemData.mId;
                        this.c.add(rq9Var);
                    }
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.getPageActivity().setContentView(R.layout.obfuscated_res_0x7f0d07cf);
            this.a.c(this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091c51));
            b();
            this.a.e(this.c);
        }
    }

    public void d() {
        rp9 rp9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (rp9Var = this.a) != null) {
            rp9Var.d();
        }
    }
}
