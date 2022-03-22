package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.ViewGroup;
import c.a.d.f.k.b;
import c.a.d.f.p.n;
import c.a.p0.b3.e.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class PersonCommonForumCardView extends FlowLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f35516e;

    /* renamed from: f  reason: collision with root package name */
    public List<f> f35517f;

    /* renamed from: g  reason: collision with root package name */
    public List<PersonCommonForumItemView> f35518g;

    /* renamed from: h  reason: collision with root package name */
    public b<PersonCommonForumItemView> f35519h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonCommonForumCardView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35518g = new ArrayList();
        this.f35516e = context;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f35517f)) {
            return;
        }
        for (f fVar : this.f35517f) {
            if (fVar != null) {
                PersonCommonForumItemView b2 = this.f35519h.b();
                b2.setData(fVar);
                addView(b2, new ViewGroup.LayoutParams(((n.k(this.f35516e) - n.f(this.f35516e, R.dimen.tbds88)) - n.f(this.f35516e, R.dimen.tbds96)) / 2, -2));
                this.f35518g.add(b2);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (PersonCommonForumItemView personCommonForumItemView : this.f35518g) {
                if (personCommonForumItemView != null) {
                    personCommonForumItemView.e();
                }
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || ListUtils.isEmpty(this.f35518g)) {
            return;
        }
        for (PersonCommonForumItemView personCommonForumItemView : this.f35518g) {
            this.f35519h.e(personCommonForumItemView);
        }
        removeAllViews();
    }

    public void setData(List<f> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f35517f = list;
            i();
        }
    }

    public void setForumItemViewBdObjectPool(b<PersonCommonForumItemView> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f35519h = bVar;
        }
    }
}
