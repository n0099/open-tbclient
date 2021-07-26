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
import d.a.d.e.p.l;
import d.a.d.k.e.n;
import d.a.q0.j2.d;
import d.a.q0.j2.h.e;
import d.a.q0.j2.h.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class PersonInfoUserPicsHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f20109a;

    /* renamed from: b  reason: collision with root package name */
    public View f20110b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f20111c;

    /* renamed from: d  reason: collision with root package name */
    public HTypeListView f20112d;

    /* renamed from: e  reason: collision with root package name */
    public e f20113e;

    /* renamed from: f  reason: collision with root package name */
    public int f20114f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f20115g;

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
        this.f20114f = 3;
        this.f20109a = view;
        this.f20115g = tbPageContext;
        this.f20110b = view.findViewById(R.id.divider_view_under_photo_album);
        this.f20111c = (TextView) view.findViewById(R.id.text_view_photo_album);
        HTypeListView hTypeListView = (HTypeListView) view.findViewById(R.id.listview_photo_album);
        this.f20112d = hTypeListView;
        this.f20113e = new e(this.f20115g, hTypeListView);
    }

    public void b(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f20113e.c(d(fVar.b()));
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f20114f == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        this.f20114f = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setBackgroundColor(this.f20109a, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f20110b, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f20111c, R.color.CAM_X0109, 1);
        this.f20113e.b();
    }

    public final List<n> d(List<n> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (ListUtils.getCount(list) <= 0) {
                return list;
            }
            ArrayList arrayList = new ArrayList(list);
            d dVar = new d(l.g(this.f20115g.getPageActivity(), R.dimen.ds32), l.g(this.f20115g.getPageActivity(), R.dimen.ds120));
            ListUtils.add(arrayList, 0, dVar);
            ListUtils.add(arrayList, dVar);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
