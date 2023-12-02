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
public class w7a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public x7a a;
    public TbPageContext b;
    public List<pi> c;
    public PersonMoreData d;

    public w7a(TbPageContext tbPageContext, Bundle bundle, mm6<x8a> mm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bundle, mm6Var};
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
        x7a x7aVar = new x7a(tbPageContext);
        this.a = x7aVar;
        x7aVar.f(mm6Var);
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
                        x8a x8aVar = new x8a();
                        x8aVar.e = personMoreItemData.mName;
                        x8aVar.a = 36;
                        x8aVar.f = personMoreItemData.mUrl;
                        x8aVar.j = personMoreItemData.mId;
                        this.c.add(x8aVar);
                    }
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.getPageActivity().setContentView(R.layout.obfuscated_res_0x7f0d07ff);
            this.a.c(this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f091d0f));
            b();
            this.a.e(this.c);
        }
    }

    public void d() {
        x7a x7aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (x7aVar = this.a) != null) {
            x7aVar.d();
        }
    }
}
