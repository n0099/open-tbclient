package com.baidu.tieba.pb.pb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b.a.q0.s.u.c;
import b.a.r0.b0.f0.e;
import b.a.r0.k2.f;
import b.a.r0.k2.i;
import b.a.r0.k2.j;
import b.a.r0.k2.l;
import b.a.r0.k2.u.f.n;
import b.a.r0.k2.y.b;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class PbRecomChildTitleAdapter extends n<e, ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewHolder s;

    /* loaded from: classes9.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f52129a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f52130b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
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
            this.f52129a = 3;
            initView(view);
        }

        public void bindDataToView(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                this.f52130b.setText(eVar.f14788e);
            }
        }

        public final void initView(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                TextView textView = (TextView) view.findViewById(i.tv_title);
                this.f52130b = textView;
                c.d(textView).A(l.F_X02);
            }
        }

        public void onChangeSkin() {
            int skinType;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f52129a == (skinType = TbadkCoreApplication.getInst().getSkinType())) {
                return;
            }
            SkinManager.setBackgroundColor(getView(), f.CAM_X0202);
            SkinManager.setViewTextColor(this.f52130b, f.CAM_X0105);
            this.f52129a = skinType;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbRecomChildTitleAdapter(b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((b) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.r0.k2.u.f.n, b.a.e.l.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        k0(i2, view, viewGroup, (e) obj, (ViewHolder) viewHolder);
        return view;
    }

    public ViewHolder i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.s : (ViewHolder) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: j0 */
    public ViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(this.f2419e).inflate(j.pb_reclist_title, viewGroup, false));
            this.s = viewHolder;
            return viewHolder;
        }
        return (ViewHolder) invokeL.objValue;
    }

    public View k0(int i2, View view, ViewGroup viewGroup, e eVar, ViewHolder viewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, eVar, viewHolder})) == null) {
            super.Z(i2, view, viewGroup, eVar, viewHolder);
            viewHolder.bindDataToView(eVar);
            viewHolder.onChangeSkin();
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
