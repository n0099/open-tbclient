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
/* loaded from: classes5.dex */
public class o68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public p68 a;
    public TbPageContext b;
    public List<wn> c;
    public PersonMoreData d;

    public o68(TbPageContext tbPageContext, Bundle bundle, z36<o78> z36Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bundle, z36Var};
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
        p68 p68Var = new p68(tbPageContext);
        this.a = p68Var;
        p68Var.f(z36Var);
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
                        o78 o78Var = new o78();
                        o78Var.e = personMoreItemData.mName;
                        o78Var.a = 36;
                        o78Var.g = personMoreItemData.mUrl;
                        o78Var.k = personMoreItemData.mId;
                        this.c.add(o78Var);
                    }
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.getPageActivity().setContentView(R.layout.obfuscated_res_0x7f0d0710);
            this.a.c(this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0919b8));
            b();
            this.a.e(this.c);
        }
    }

    public void d() {
        p68 p68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (p68Var = this.a) != null) {
            p68Var.d();
        }
    }
}
