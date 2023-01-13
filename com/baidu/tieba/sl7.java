package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tieba.imMessageCenter.chatgroup.chatbox.adapter.BaseItemViewHolder;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.inputTool.robotfloor.adapter.RobotItemViewHolder;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.inputTool.robotfloor.adapter.RobotSkillItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class sl7 implements nk7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ql7 a;

    public sl7(ql7 ql7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ql7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ql7Var;
    }

    @Override // com.baidu.tieba.nk7
    @Nullable
    public BaseItemViewHolder a(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i)) == null) {
            if (i == 5) {
                return new RobotSkillItemViewHolder(LayoutInflater.from(SelectorHelper.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0391, viewGroup, false), this.a);
            }
            if (i == 4) {
                return new RobotItemViewHolder(LayoutInflater.from(SelectorHelper.getContext()).inflate(R.layout.obfuscated_res_0x7f0d038f, viewGroup, false));
            }
            return null;
        }
        return (BaseItemViewHolder) invokeLI.objValue;
    }
}
