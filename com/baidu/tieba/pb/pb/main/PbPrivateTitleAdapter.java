package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b.a.q0.s.u.c;
import b.a.r0.k2.f;
import b.a.r0.k2.g;
import b.a.r0.k2.h;
import b.a.r0.k2.i;
import b.a.r0.k2.j;
import b.a.r0.k2.l;
import b.a.r0.k2.r.p;
import b.a.r0.k2.u.f.n;
import b.a.r0.k2.y.b;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class PbPrivateTitleAdapter extends n<p, PbPrivateTitleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class PbPrivateTitleViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f53353a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f53354b;
        public int mSkinType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PbPrivateTitleViewHolder(TbPageContext tbPageContext, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, view};
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
            this.mSkinType = 3;
            if (view == null) {
                return;
            }
            this.f53353a = view.findViewById(i.background);
            this.f53354b = (TextView) view.findViewById(i.title);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(tbPageContext.getResources().getString(l.pb_private_block_title));
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(h.icon_pure_barrules_careful12, f.CAM_X0109, EMRichTextAnyIconSpan.IconType.WEBP);
            eMRichTextAnyIconSpan.f(b.a.e.f.p.l.g(tbPageContext.getContext(), g.tbds31));
            eMRichTextAnyIconSpan.d(b.a.e.f.p.l.g(tbPageContext.getContext(), g.M_W_X002));
            eMRichTextAnyIconSpan.b(0);
            spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
            this.f53354b.setText(spannableStringBuilder);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.mSkinType != i2) {
                    c d2 = c.d(this.f53354b);
                    d2.v(f.CAM_X0109);
                    d2.A(l.F_X01);
                    c d3 = c.d(this.f53353a);
                    d3.n(l.J_X05);
                    d3.f(f.CAM_X0204);
                }
                this.mSkinType = i2;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbPrivateTitleAdapter(b bVar) {
        super(bVar, p.f20330e);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
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

    @Override // b.a.r0.k2.u.f.n, b.a.e.m.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        j0(i2, view, viewGroup, (p) obj, (PbPrivateTitleViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: i0 */
    public PbPrivateTitleViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PbPrivateTitleViewHolder(this.m.getPageContext(), LayoutInflater.from(this.f2421e).inflate(j.pb_private_title_layout, viewGroup, false)) : (PbPrivateTitleViewHolder) invokeL.objValue;
    }

    public View j0(int i2, View view, ViewGroup viewGroup, p pVar, PbPrivateTitleViewHolder pbPrivateTitleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, pVar, pbPrivateTitleViewHolder})) == null) {
            super.Z(i2, view, viewGroup, pVar, pbPrivateTitleViewHolder);
            pbPrivateTitleViewHolder.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
