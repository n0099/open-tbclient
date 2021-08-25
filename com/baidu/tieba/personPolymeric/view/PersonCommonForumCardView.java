package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.ViewGroup;
import c.a.e.e.k.b;
import c.a.e.e.p.l;
import c.a.q0.n2.e.f;
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
/* loaded from: classes7.dex */
public class PersonCommonForumCardView extends FlowLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public Context f55905i;

    /* renamed from: j  reason: collision with root package name */
    public List<f> f55906j;
    public List<PersonCommonForumItemView> k;
    public b<PersonCommonForumItemView> l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonCommonForumCardView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new ArrayList();
        this.f55905i = context;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f55906j)) {
            return;
        }
        for (f fVar : this.f55906j) {
            if (fVar != null) {
                PersonCommonForumItemView b2 = this.l.b();
                b2.setData(fVar);
                addView(b2, new ViewGroup.LayoutParams(((l.k(this.f55905i) - l.g(this.f55905i, R.dimen.tbds88)) - l.g(this.f55905i, R.dimen.tbds96)) / 2, -2));
                this.k.add(b2);
            }
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (PersonCommonForumItemView personCommonForumItemView : this.k) {
                if (personCommonForumItemView != null) {
                    personCommonForumItemView.onChangeSkinType();
                }
            }
        }
    }

    public void recycle() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || ListUtils.isEmpty(this.k)) {
            return;
        }
        for (PersonCommonForumItemView personCommonForumItemView : this.k) {
            this.l.e(personCommonForumItemView);
        }
        removeAllViews();
    }

    public void setData(List<f> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f55906j = list;
            f();
        }
    }

    public void setForumItemViewBdObjectPool(b<PersonCommonForumItemView> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.l = bVar;
        }
    }
}
