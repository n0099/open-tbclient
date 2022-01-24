package com.baidu.tieba.pb.pb.sub.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.t0.t2.f;
import c.a.t0.t2.i;
import c.a.t0.t2.j;
import c.a.t0.t2.l;
import c.a.t0.t2.u.h.f.a;
import c.a.t0.t2.u.h.g.b;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class SubPbReplyAdapter extends a<b, SubPbReplyViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean o;

    /* loaded from: classes12.dex */
    public static class SubPbReplyViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public View f46821b;

        /* renamed from: c  reason: collision with root package name */
        public int f46822c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SubPbReplyViewHolder(View view) {
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
            this.f46822c = 3;
            this.a = (TextView) view.findViewById(i.floor_reply_text);
            this.f46821b = view.findViewById(i.floor_reply_top_line);
        }

        public void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f46822c != TbadkApplication.getInst().getSkinType()) {
                    SkinManager.setViewTextColor(this.a, f.CAM_X0105);
                    SkinManager.setBackgroundColor(this.f46821b, f.CAM_X0204);
                    SkinManager.setBackgroundColor(this.a, f.CAM_X0201);
                }
                this.f46822c = TbadkApplication.getInst().getSkinType();
            }
        }

        public void showTopLine(boolean z) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (view = this.f46821b) == null) {
                return;
            }
            view.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubPbReplyAdapter(c.a.t0.t2.u.a aVar, BdUniqueId bdUniqueId) {
        super(aVar, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.t0.t2.u.a) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: Z */
    public SubPbReplyViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new SubPbReplyViewHolder(LayoutInflater.from(this.f3360e).inflate(j.sub_pb_reply_num_layout, viewGroup, false)) : (SubPbReplyViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.t2.u.h.f.a, c.a.d.n.e.a
    /* renamed from: a0 */
    public View S(int i2, View view, ViewGroup viewGroup, b bVar, SubPbReplyViewHolder subPbReplyViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, subPbReplyViewHolder})) == null) {
            String format = String.format(TbadkApplication.getInst().getString(l.subpb_floor_reply_count), String.valueOf(bVar == null ? 0 : bVar.a()));
            subPbReplyViewHolder.showTopLine(this.o);
            ((SubPbReplyViewHolder) this.k).a.setText(format);
            ((SubPbReplyViewHolder) this.k).onChangeSkinType();
            return subPbReplyViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.o = z;
        }
    }
}
