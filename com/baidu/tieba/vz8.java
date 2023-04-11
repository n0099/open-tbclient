package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.video.GodReplyMoreViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class vz8 extends pv8<wz8, GodReplyMoreViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vz8(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((yz8) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.um
    /* renamed from: u */
    public GodReplyMoreViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            return new GodReplyMoreViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d071b, viewGroup, false));
        }
        return (GodReplyMoreViewHolder) invokeL.objValue;
    }

    public void y(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.g = onClickListener;
        }
    }

    @Override // com.baidu.tieba.pv8, com.baidu.tieba.um
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        x(i, view2, viewGroup, (wz8) obj, (GodReplyMoreViewHolder) viewHolder);
        return view2;
    }

    public View x(int i, View view2, ViewGroup viewGroup, wz8 wz8Var, GodReplyMoreViewHolder godReplyMoreViewHolder) {
        InterceptResult invokeCommon;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, wz8Var, godReplyMoreViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) wz8Var, (wz8) godReplyMoreViewHolder);
            if (godReplyMoreViewHolder != null && (textView = godReplyMoreViewHolder.a) != null) {
                View.OnClickListener onClickListener = this.g;
                if (onClickListener != null) {
                    textView.setOnClickListener(onClickListener);
                }
                if (godReplyMoreViewHolder.c != TbadkCoreApplication.getInst().getSkinType()) {
                    godReplyMoreViewHolder.c = TbadkCoreApplication.getInst().getSkinType();
                    SkinManager.setViewTextColor(godReplyMoreViewHolder.a, (int) R.color.CAM_X0106);
                    SkinManager.setBackgroundResource(godReplyMoreViewHolder.a, R.drawable.more_all);
                    SkinManager.setBackgroundResource(godReplyMoreViewHolder.b, R.color.CAM_X0204);
                }
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
