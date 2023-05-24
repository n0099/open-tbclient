package com.baidu.tieba;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class sb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            for (BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO : list) {
                if (itemsDTO != null && !ListUtils.isEmpty(itemsDTO.getOpts()) && ListUtils.getCount(itemsDTO.getOpts()) > 0 && ListUtils.getItem(itemsDTO.getOpts(), 0) != null) {
                    BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO.Ext ext = ((BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO) ListUtils.getItem(itemsDTO.getOpts(), 0)).getExt();
                    if (itemsDTO.getItemType() == 0) {
                        continue;
                    } else if (itemsDTO.getItemType() == 1 && (ext == null || StringUtils.isNull(ext.getPicPath()) || StringUtils.isNull(ext.getPicSize()))) {
                        c(itemsDTO.getItemType());
                        return false;
                    } else if (!itemsDTO.isOptional() && itemsDTO.getItemType() == 2 && (ext == null || ListUtils.isEmpty(ext.getAtUserInfos()))) {
                        c(itemsDTO.getItemType());
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public static List<String> b(@Nullable List<AtSelectData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            if (list != null && !ListUtils.isEmpty(list) && ListUtils.getCount(list) > 0) {
                ArrayList arrayList = new ArrayList();
                for (AtSelectData atSelectData : list) {
                    if (atSelectData != null) {
                        arrayList.add(atSelectData.getUid());
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static void c(int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            if (i == 1) {
                str = TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0928);
            } else if (i == 2) {
                str = TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0927);
            } else {
                str = "";
            }
            Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
            if (currentActivity != null) {
                BdTopToast bdTopToast = new BdTopToast(currentActivity, 2000);
                bdTopToast.h(false);
                bdTopToast.g(str);
                bdTopToast.i((ViewGroup) currentActivity.findViewById(16908290));
            }
        }
    }
}
