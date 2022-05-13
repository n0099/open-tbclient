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
import com.repackage.gs4;
import com.repackage.gz7;
import com.repackage.mi;
import com.repackage.ns7;
import com.repackage.vu7;
/* loaded from: classes3.dex */
public class PbPrivateTitleAdapter extends vu7<ns7, PbPrivateTitleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class PbPrivateTitleViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public View b;
        public TextView c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PbPrivateTitleViewHolder(TbPageContext tbPageContext, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, view2};
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
            this.a = 3;
            if (view2 == null) {
                return;
            }
            this.b = view2.findViewById(R.id.obfuscated_res_0x7f0902f7);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092071);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(tbPageContext.getResources().getString(R.string.obfuscated_res_0x7f0f0dd5));
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.obfuscated_res_0x7f0808f9, R.color.CAM_X0109, EMRichTextAnyIconSpan.IconType.WEBP);
            eMRichTextAnyIconSpan.f(mi.f(tbPageContext.getContext(), R.dimen.tbds31));
            eMRichTextAnyIconSpan.d(mi.f(tbPageContext.getContext(), R.dimen.M_W_X002));
            eMRichTextAnyIconSpan.b(0);
            spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
            this.c.setText(spannableStringBuilder);
            c(TbadkCoreApplication.getInst().getSkinType());
        }

        public void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.a != i) {
                    gs4 d = gs4.d(this.c);
                    d.v(R.color.CAM_X0109);
                    d.A(R.string.F_X01);
                    gs4 d2 = gs4.d(this.b);
                    d2.n(R.string.J_X05);
                    d2.f(R.color.CAM_X0204);
                }
                this.a = i;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbPrivateTitleAdapter(gz7 gz7Var) {
        super(gz7Var, ns7.a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gz7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((gz7) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.vu7, com.repackage.eo
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        c0(i, view2, viewGroup, (ns7) obj, (PbPrivateTitleViewHolder) viewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: b0 */
    public PbPrivateTitleViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PbPrivateTitleViewHolder(this.i.getPageContext(), LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0689, viewGroup, false)) : (PbPrivateTitleViewHolder) invokeL.objValue;
    }

    public View c0(int i, View view2, ViewGroup viewGroup, ns7 ns7Var, PbPrivateTitleViewHolder pbPrivateTitleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ns7Var, pbPrivateTitleViewHolder})) == null) {
            super.S(i, view2, viewGroup, ns7Var, pbPrivateTitleViewHolder);
            pbPrivateTitleViewHolder.c(TbadkCoreApplication.getInst().getSkinType());
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
