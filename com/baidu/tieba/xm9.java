package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.person.holder.PersonCenterIntervalHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class xm9 extends lm<tm9, PersonCenterIntervalHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xm9(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm
    /* renamed from: s */
    public PersonCenterIntervalHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            return new PersonCenterIntervalHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d046c, viewGroup, false));
        }
        return (PersonCenterIntervalHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.lm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, tm9 tm9Var, PersonCenterIntervalHolder personCenterIntervalHolder) {
        t(i, view2, viewGroup, tm9Var, personCenterIntervalHolder);
        return view2;
    }

    public View t(int i, View view2, ViewGroup viewGroup, tm9 tm9Var, PersonCenterIntervalHolder personCenterIntervalHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, tm9Var, personCenterIntervalHolder})) == null) {
            if (tm9Var != null && personCenterIntervalHolder != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (personCenterIntervalHolder.a != skinType) {
                    personCenterIntervalHolder.a = skinType;
                    SkinManager.setBackgroundResource(personCenterIntervalHolder.b, tm9Var.c);
                }
                ViewGroup.LayoutParams layoutParams = personCenterIntervalHolder.b.getLayoutParams();
                int i2 = tm9Var.a;
                if (i2 > 0) {
                    layoutParams.height = i2;
                }
                int i3 = tm9Var.b;
                if (i3 > 0) {
                    layoutParams.width = i3;
                }
                personCenterIntervalHolder.b.setLayoutParams(layoutParams);
                personCenterIntervalHolder.b.setOnClickListener(null);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
