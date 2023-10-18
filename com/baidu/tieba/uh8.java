package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.TbTextGenImageMsg;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.im.lib.socket.msg.data.BotsDTO;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class uh8 extends z98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean e;

    public uh8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = true;
    }

    @Override // com.baidu.tieba.w98
    public boolean a(int i, boolean z, Object obj) {
        InterceptResult invokeCommon;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), obj})) == null) {
            w98 w98Var = this.c;
            if (w98Var != null) {
                z2 = w98Var.a(i, z, obj);
            } else {
                z2 = true;
            }
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                v98 v98Var = this.a.get(i2);
                if (v98Var instanceof ki8) {
                    ki8 ki8Var = (ki8) v98Var;
                    if (ki8Var.d() && i != i2) {
                        ki8Var.e(false);
                        i(i2);
                    } else {
                        if (i == i2) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        ki8Var.e(z3);
                    }
                }
            }
            return z2;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.tieba.z98
    public List<v98> j(List list) {
        InterceptResult invokeL;
        List<BotsDTO.BotListDTO.SkillDTO> list2;
        aa8 aa8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                boolean z = true;
                if (i < list.size()) {
                    Object obj = list.get(i);
                    if (obj instanceof BotsDTO.BotListDTO.SkillDTO.ItemsDTO) {
                        BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO = (BotsDTO.BotListDTO.SkillDTO.ItemsDTO) obj;
                        if (itemsDTO.getItemType() == 1) {
                            aa8Var = new ba8(itemsDTO);
                        } else {
                            aa8 aa8Var2 = new aa8(itemsDTO);
                            int i2 = this.d;
                            if (i2 > -1) {
                                if (i != i2) {
                                    z = false;
                                }
                                aa8Var2.n(z);
                            }
                            aa8Var = aa8Var2;
                        }
                        arrayList.add(aa8Var);
                    } else if (obj instanceof BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO) {
                        ki8 ki8Var = new ki8((BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO) obj);
                        int i3 = this.d;
                        if (i3 > -1) {
                            if (i != i3) {
                                z = false;
                            }
                            ki8Var.e(z);
                        }
                        arrayList.add(ki8Var);
                    } else if (obj instanceof TbBaseMsg) {
                        TbTextGenImageMsg tbTextGenImageMsg = (TbTextGenImageMsg) obj;
                        if (tbTextGenImageMsg.getSubSkillConfig() != null && (list2 = tbTextGenImageMsg.getSubSkillConfig().a) != null && !list2.isEmpty()) {
                            if (this.e) {
                                arrayList.add(new ii8());
                                this.e = false;
                            }
                            for (BotsDTO.BotListDTO.SkillDTO skillDTO : list2) {
                                ji8 ji8Var = new ji8(skillDTO);
                                ji8Var.e(tbTextGenImageMsg);
                                arrayList.add(ji8Var);
                            }
                        }
                    } else if (obj instanceof AbilityItem) {
                        arrayList.add(new li8((AbilityItem) obj));
                    }
                    i++;
                } else {
                    this.e = true;
                    return arrayList;
                }
            }
        } else {
            return (List) invokeL.objValue;
        }
    }
}
