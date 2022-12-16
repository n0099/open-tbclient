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
/* loaded from: classes5.dex */
public class j78 extends y28<k78, GodReplyMoreViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j78(PbFragment pbFragment, BdUniqueId bdUniqueId) {
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
                super((s78) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: u */
    public GodReplyMoreViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            return new GodReplyMoreViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d06ed, viewGroup, false));
        }
        return (GodReplyMoreViewHolder) invokeL.objValue;
    }

    public void w(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.g = onClickListener;
        }
    }

    @Override // com.baidu.tieba.y28, com.baidu.tieba.kn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        v(i, view2, viewGroup, (k78) obj, (GodReplyMoreViewHolder) viewHolder);
        return view2;
    }

    public View v(int i, View view2, ViewGroup viewGroup, k78 k78Var, GodReplyMoreViewHolder godReplyMoreViewHolder) {
        InterceptResult invokeCommon;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, k78Var, godReplyMoreViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) k78Var, (k78) godReplyMoreViewHolder);
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
