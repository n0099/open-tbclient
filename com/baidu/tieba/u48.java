package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class u48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v48 a;
    public TbPageContext b;
    public List<Cdo> c;
    public PersonMoreData d;

    public u48(TbPageContext tbPageContext, Bundle bundle, i26<u58> i26Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bundle, i26Var};
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
        v48 v48Var = new v48(tbPageContext);
        this.a = v48Var;
        v48Var.f(i26Var);
        if (bundle == null || !(OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            return;
        }
        this.d = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c = new ArrayList();
            PersonMoreData personMoreData = this.d;
            if (personMoreData == null || ListUtils.isEmpty(personMoreData.mUrlMaps)) {
                return;
            }
            for (PersonMoreItemData personMoreItemData : this.d.mUrlMaps) {
                if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                    u58 u58Var = new u58();
                    u58Var.e = personMoreItemData.mName;
                    u58Var.a = 36;
                    u58Var.g = personMoreItemData.mUrl;
                    u58Var.k = personMoreItemData.mId;
                    this.c.add(u58Var);
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.getPageActivity().setContentView(R.layout.obfuscated_res_0x7f0d06fb);
            this.a.c(this.b.getPageActivity().findViewById(R.id.obfuscated_res_0x7f09197d));
            a();
            this.a.e(this.c);
        }
    }

    public void c() {
        v48 v48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (v48Var = this.a) == null) {
            return;
        }
        v48Var.d();
    }
}
