package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.TextView;
import c.a.d.o.e.n;
import c.a.p0.y2.d;
import c.a.p0.y2.h.e;
import c.a.p0.y2.h.f;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
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

    /* renamed from: b  reason: collision with root package name */
    public View f35358b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35359c;

    /* renamed from: d  reason: collision with root package name */
    public HTypeListView f35360d;

    /* renamed from: e  reason: collision with root package name */
    public e f35361e;

    /* renamed from: f  reason: collision with root package name */
    public int f35362f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f35363g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonInfoUserPicsHolder(View view, TbPageContext tbPageContext) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, tbPageContext};
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
        this.f35362f = 3;
        this.a = view;
        this.f35363g = tbPageContext;
        this.f35358b = view.findViewById(R.id.obfuscated_res_0x7f09080a);
        this.f35359c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091f5d);
        HTypeListView hTypeListView = (HTypeListView) view.findViewById(R.id.obfuscated_res_0x7f09128c);
        this.f35360d = hTypeListView;
        this.f35361e = new e(this.f35363g, hTypeListView);
    }

    public void c(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f35361e.c(e(fVar.a()));
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f35362f == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        this.f35362f = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f35358b, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f35359c, R.color.CAM_X0109, 1);
        this.f35361e.b();
    }

    public final List<n> e(List<n> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (ListUtils.getCount(list) <= 0) {
                return list;
            }
            ArrayList arrayList = new ArrayList(list);
            d dVar = new d(c.a.d.f.p.n.f(this.f35363g.getPageActivity(), R.dimen.obfuscated_res_0x7f070207), c.a.d.f.p.n.f(this.f35363g.getPageActivity(), R.dimen.obfuscated_res_0x7f070235));
            ListUtils.add(arrayList, 0, dVar);
            ListUtils.add(arrayList, dVar);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
