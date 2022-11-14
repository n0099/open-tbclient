package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.og;
import com.baidu.tieba.wa8;
import com.baidu.tieba.yi;
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
    public Context e;
    public List<wa8> f;
    public List<PersonCommonForumItemView> g;
    public og<PersonCommonForumItemView> h;

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
        this.g = new ArrayList();
        this.e = context;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || ListUtils.isEmpty(this.f)) {
            return;
        }
        for (wa8 wa8Var : this.f) {
            if (wa8Var != null) {
                PersonCommonForumItemView b = this.h.b();
                b.setData(wa8Var);
                addView(b, new ViewGroup.LayoutParams(((yi.l(this.e) - yi.g(this.e, R.dimen.tbds88)) - yi.g(this.e, R.dimen.tbds96)) / 2, -2));
                this.g.add(b);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (PersonCommonForumItemView personCommonForumItemView : this.g) {
                if (personCommonForumItemView != null) {
                    personCommonForumItemView.e();
                }
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !ListUtils.isEmpty(this.g)) {
            for (PersonCommonForumItemView personCommonForumItemView : this.g) {
                this.h.e(personCommonForumItemView);
            }
            removeAllViews();
        }
    }

    public void setData(List<wa8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f = list;
            i();
        }
    }

    public void setForumItemViewBdObjectPool(og<PersonCommonForumItemView> ogVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ogVar) == null) {
            this.h = ogVar;
        }
    }
}
