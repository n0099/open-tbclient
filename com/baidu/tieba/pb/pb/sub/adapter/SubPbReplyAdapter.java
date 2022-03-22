package com.baidu.tieba.pb.pb.sub.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.p0.w2.m.h.f.a;
import c.a.p0.w2.m.h.g.b;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class SubPbReplyAdapter extends a<b, SubPbReplyViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean k;

    /* loaded from: classes5.dex */
    public static class SubPbReplyViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public View f35134b;

        /* renamed from: c  reason: collision with root package name */
        public int f35135c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SubPbReplyViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
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
            this.f35135c = 3;
            this.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0909e1);
            this.f35134b = view.findViewById(R.id.obfuscated_res_0x7f0909e2);
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f35135c != TbadkApplication.getInst().getSkinType()) {
                    SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0105);
                    SkinManager.setBackgroundColor(this.f35134b, R.color.CAM_X0204);
                    SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
                }
                this.f35135c = TbadkApplication.getInst().getSkinType();
            }
        }

        public void e(boolean z) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (view = this.f35134b) == null) {
                return;
            }
            view.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubPbReplyAdapter(c.a.p0.w2.m.a aVar, BdUniqueId bdUniqueId) {
        super(aVar, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.p0.w2.m.a) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: Z */
    public SubPbReplyViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new SubPbReplyViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d07b7, viewGroup, false)) : (SubPbReplyViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.w2.m.h.f.a, c.a.d.o.e.a
    /* renamed from: a0 */
    public View S(int i, View view, ViewGroup viewGroup, b bVar, SubPbReplyViewHolder subPbReplyViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view, viewGroup, bVar, subPbReplyViewHolder})) == null) {
            String format = String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f11ec), String.valueOf(bVar == null ? 0 : bVar.a()));
            subPbReplyViewHolder.e(this.k);
            ((SubPbReplyViewHolder) this.f2573g).a.setText(format);
            ((SubPbReplyViewHolder) this.f2573g).d();
            return subPbReplyViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.k = z;
        }
    }
}
