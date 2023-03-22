package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextGenImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class uw7 extends ux7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean e;

    public uw7() {
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

    @Override // com.baidu.tieba.tx7
    public boolean a(int i, boolean z, Object obj) {
        InterceptResult invokeCommon;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), obj})) == null) {
            tx7 tx7Var = this.c;
            if (tx7Var != null) {
                z2 = tx7Var.a(i, z, obj);
            } else {
                z2 = true;
            }
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                sx7 sx7Var = this.a.get(i2);
                if (sx7Var instanceof dx7) {
                    dx7 dx7Var = (dx7) sx7Var;
                    if (dx7Var.d() && i != i2) {
                        dx7Var.e(false);
                        i(i2);
                    } else {
                        if (i == i2) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        dx7Var.e(z3);
                    }
                }
            }
            return z2;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.tieba.ux7
    public List<sx7> j(List list) {
        InterceptResult invokeL;
        List<BotsDTO.BotListDTO.SkillDTO> list2;
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
                        bx7 bx7Var = null;
                        if (itemsDTO.getItemType() == 0) {
                            bx7Var = new bx7(itemsDTO);
                            int i2 = this.d;
                            if (i2 > -1) {
                                if (i != i2) {
                                    z = false;
                                }
                                bx7Var.k(z);
                            }
                        } else {
                            itemsDTO.getItemType();
                        }
                        if (bx7Var != null) {
                            arrayList.add(bx7Var);
                        }
                    } else if (obj instanceof BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO) {
                        dx7 dx7Var = new dx7((BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO) obj);
                        int i3 = this.d;
                        if (i3 > -1) {
                            if (i != i3) {
                                z = false;
                            }
                            dx7Var.e(z);
                        }
                        arrayList.add(dx7Var);
                    } else if (obj instanceof BaseMsg) {
                        TextGenImageMsg textGenImageMsg = (TextGenImageMsg) obj;
                        if (textGenImageMsg.getSubSkillConfig() != null && (list2 = textGenImageMsg.getSubSkillConfig().a) != null && !list2.isEmpty()) {
                            if (this.e) {
                                arrayList.add(new zw7());
                                this.e = false;
                            }
                            for (BotsDTO.BotListDTO.SkillDTO skillDTO : list2) {
                                ax7 ax7Var = new ax7(skillDTO);
                                ax7Var.e(textGenImageMsg);
                                arrayList.add(ax7Var);
                            }
                        }
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
