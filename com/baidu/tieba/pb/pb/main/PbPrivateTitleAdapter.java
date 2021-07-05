package com.baidu.tieba.pb.pb.main;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.r.u.c;
import d.a.s0.h2.h.n;
import d.a.s0.h2.k.e.o;
import d.a.s0.h2.o.b;
/* loaded from: classes5.dex */
public class PbPrivateTitleAdapter extends o<n, PbPrivateTitleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class PbPrivateTitleViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f19403a;

        /* renamed from: b  reason: collision with root package name */
        public View f19404b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f19405c;

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
            this.f19403a = 3;
            if (view == null) {
                return;
            }
            this.f19404b = view.findViewById(R.id.background);
            this.f19405c = (TextView) view.findViewById(R.id.title);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(tbPageContext.getResources().getString(R.string.pb_private_block_title));
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_barrules_careful12, R.color.CAM_X0109, EMRichTextAnyIconSpan.IconType.WEBP);
            eMRichTextAnyIconSpan.d(l.g(tbPageContext.getContext(), R.dimen.tbds31));
            eMRichTextAnyIconSpan.c(l.g(tbPageContext.getContext(), R.dimen.M_W_X002));
            eMRichTextAnyIconSpan.a(0);
            spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
            this.f19405c.setText(spannableStringBuilder);
            b(TbadkCoreApplication.getInst().getSkinType());
        }

        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (this.f19403a != i2) {
                    c d2 = c.d(this.f19405c);
                    d2.t(R.color.CAM_X0109);
                    d2.y(R.string.F_X01);
                    c d3 = c.d(this.f19404b);
                    d3.n(R.string.J_X05);
                    d3.f(R.color.CAM_X0204);
                }
                this.f19403a = i2;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbPrivateTitleAdapter(b bVar) {
        super(bVar, n.f60173e);
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

    @Override // d.a.s0.h2.k.e.o, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        i0(i2, view, viewGroup, (n) obj, (PbPrivateTitleViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public PbPrivateTitleViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PbPrivateTitleViewHolder(this.m.getPageContext(), LayoutInflater.from(this.f44821e).inflate(R.layout.pb_private_title_layout, viewGroup, false)) : (PbPrivateTitleViewHolder) invokeL.objValue;
    }

    public View i0(int i2, View view, ViewGroup viewGroup, n nVar, PbPrivateTitleViewHolder pbPrivateTitleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, nVar, pbPrivateTitleViewHolder})) == null) {
            super.X(i2, view, viewGroup, nVar, pbPrivateTitleViewHolder);
            pbPrivateTitleViewHolder.b(TbadkCoreApplication.getInst().getSkinType());
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
