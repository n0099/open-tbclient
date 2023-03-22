package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.pb.pb.adapter.PbNoDataItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class zl8 extends bl8<ui8, PbNoDataItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zl8(wp8 wp8Var, BdUniqueId bdUniqueId) {
        super(wp8Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wp8Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((wp8) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: u */
    public PbNoDataItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            return new PbNoDataItemViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0734, viewGroup, false), this.mContext);
        }
        return (PbNoDataItemViewHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.bl8, com.baidu.tieba.tm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        x(i, view2, viewGroup, (ui8) obj, (PbNoDataItemViewHolder) viewHolder);
        return view2;
    }

    public View x(int i, View view2, ViewGroup viewGroup, ui8 ui8Var, PbNoDataItemViewHolder pbNoDataItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ui8Var, pbNoDataItemViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) ui8Var, (ui8) pbNoDataItemViewHolder);
            this.d = TbadkCoreApplication.getInst().getSkinType();
            pbNoDataItemViewHolder.a.setText(ui8Var.a1);
            int i2 = ui8Var.Z0;
            if (i2 != 0) {
                SkinManager.setImageResource(pbNoDataItemViewHolder.b, i2);
            } else {
                SkinManager.setImageResource(pbNoDataItemViewHolder.b, R.drawable.new_pic_emotion_06);
            }
            SkinManager.setViewTextColor(pbNoDataItemViewHolder.a, (int) R.color.CAM_X0109);
            if (ui8Var.b1 != 0 && view2.getLayoutParams() != null) {
                view2.getLayoutParams().height = ui8Var.b1;
            }
            if (ui8Var.c1 != 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbNoDataItemViewHolder.b.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, ui8Var.c1, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            if (ui8Var.d1 != 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbNoDataItemViewHolder.a.getLayoutParams();
                int i3 = marginLayoutParams2.leftMargin;
                marginLayoutParams2.setMargins(i3, i3, marginLayoutParams2.rightMargin, ui8Var.d1);
            }
            pbNoDataItemViewHolder.b.setVisibility(ui8Var.e1);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
