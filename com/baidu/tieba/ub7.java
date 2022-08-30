package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.UserData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ub7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(UserData userData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, userData)) == null) {
            if (userData == null) {
                return "";
            }
            if (UtilHelper.isFllowByPriorty(userData)) {
                if (userData.getAuthType() == 1) {
                    if (userData.isOfficial()) {
                        return "";
                    }
                } else if (userData.getAuthType() == 2) {
                    if (userData.isOriginal()) {
                        return userData.getCreatorInfo().authDesc;
                    }
                } else if (userData.getAuthType() == 3) {
                    if (userData.isNewGod()) {
                        return userData.getNewGodData().getFieldName() + uf5.c(userData.isVideoGod());
                    }
                } else if (userData.getAuthType() == 4 && userData.showBazhuGrade()) {
                    return StringHelper.cutChineseAndEnglishWithSuffix(userData.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE);
                }
            }
            if (TextUtils.isEmpty("") && userData.isOfficial()) {
                return "";
            }
            if (TextUtils.isEmpty("") && userData.isOriginal()) {
                return userData.getCreatorInfo().authDesc;
            }
            if (!TextUtils.isEmpty("") || !userData.isNewGod()) {
                return (TextUtils.isEmpty("") && userData.showBazhuGrade()) ? StringHelper.cutChineseAndEnglishWithSuffix(userData.getBazhuGradeData().getDesc(), 16, StringHelper.STRING_MORE) : "";
            }
            return userData.getNewGodData().getFieldName() + uf5.c(userData.isVideoGod());
        }
        return (String) invokeL.objValue;
    }
}
