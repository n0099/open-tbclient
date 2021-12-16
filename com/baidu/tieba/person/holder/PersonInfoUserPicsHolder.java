package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.d.m.e.n;
import c.a.s0.u2.g.e;
import c.a.s0.u2.g.f;
import c.a.s0.y2.a;
import c.a.s0.y2.b;
import c.a.s0.y2.d;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class PersonInfoUserPicsHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e adapterManager;
    public HTypeListView albumListView;
    public View dividerView;
    public TbPageContext mPageContext;
    public View rootView;
    public int skinType;
    public TextView titleView;

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
        this.skinType = 3;
        this.rootView = view;
        this.mPageContext = tbPageContext;
        this.dividerView = view.findViewById(d.divider_view_under_photo_album);
        this.titleView = (TextView) view.findViewById(d.text_view_photo_album);
        HTypeListView hTypeListView = (HTypeListView) view.findViewById(d.listview_photo_album);
        this.albumListView = hTypeListView;
        this.adapterManager = new e(this.mPageContext, hTypeListView);
    }

    public final List<n> a(List<n> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (ListUtils.getCount(list) <= 0) {
                return list;
            }
            ArrayList arrayList = new ArrayList(list);
            c.a.s0.u2.d dVar = new c.a.s0.u2.d(m.f(this.mPageContext.getPageActivity(), b.ds32), m.f(this.mPageContext.getPageActivity(), b.ds120));
            ListUtils.add(arrayList, 0, dVar);
            ListUtils.add(arrayList, dVar);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void fillView(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) || fVar == null) {
            return;
        }
        this.adapterManager.c(a(fVar.a()));
    }

    public void fillViewResource() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.skinType == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        this.skinType = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setBackgroundColor(this.rootView, a.CAM_X0201);
        SkinManager.setBackgroundColor(this.dividerView, a.CAM_X0204);
        SkinManager.setViewTextColor(this.titleView, a.CAM_X0109, 1);
        this.adapterManager.b();
    }
}
