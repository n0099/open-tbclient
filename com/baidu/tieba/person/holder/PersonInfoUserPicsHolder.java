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
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.s0.j2.d;
import d.a.s0.j2.h.e;
import d.a.s0.j2.h.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class PersonInfoUserPicsHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f19951a;

    /* renamed from: b  reason: collision with root package name */
    public View f19952b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19953c;

    /* renamed from: d  reason: collision with root package name */
    public HTypeListView f19954d;

    /* renamed from: e  reason: collision with root package name */
    public e f19955e;

    /* renamed from: f  reason: collision with root package name */
    public int f19956f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f19957g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonInfoUserPicsHolder(View view, TbPageContext tbPageContext) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19956f = 3;
        this.f19951a = view;
        this.f19957g = tbPageContext;
        this.f19952b = view.findViewById(R.id.divider_view_under_photo_album);
        this.f19953c = (TextView) view.findViewById(R.id.text_view_photo_album);
        HTypeListView hTypeListView = (HTypeListView) view.findViewById(R.id.listview_photo_album);
        this.f19954d = hTypeListView;
        this.f19955e = new e(this.f19957g, hTypeListView);
    }

    public void b(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f19955e.c(d(fVar.b()));
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f19956f == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        this.f19956f = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setBackgroundColor(this.f19951a, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f19952b, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f19953c, R.color.CAM_X0109, 1);
        this.f19955e.b();
    }

    public final List<n> d(List<n> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (ListUtils.getCount(list) <= 0) {
                return list;
            }
            ArrayList arrayList = new ArrayList(list);
            d dVar = new d(l.g(this.f19957g.getPageActivity(), R.dimen.ds32), l.g(this.f19957g.getPageActivity(), R.dimen.ds120));
            ListUtils.add(arrayList, 0, dVar);
            ListUtils.add(arrayList, dVar);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
