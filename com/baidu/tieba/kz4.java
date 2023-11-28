package com.baidu.tieba;

import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tbclient.PbContent;
import tbclient.TiebaPlusInfo;
/* loaded from: classes7.dex */
public final class kz4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(ThreadData threadData) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        TiebaPlusInfo tiebaPlusInfo;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, threadData)) == null) {
            Intrinsics.checkNotNullParameter(threadData, "<this>");
            String convertBtnType = threadData.getConvertBtnType();
            if (convertBtnType != null && convertBtnType.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                List<PbContent> richAbstractList = threadData.getRichAbstractList();
                if (richAbstractList != null && !richAbstractList.isEmpty()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    for (PbContent pbContent : threadData.getRichAbstractList()) {
                        if (pbContent != null && (tiebaPlusInfo = pbContent.tiebaplus_info) != null) {
                            Integer num = pbContent.type;
                            if (num != null && num.intValue() == 35) {
                                String str = tiebaPlusInfo.desc;
                                if (str != null && str.length() != 0) {
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                                if (!z3) {
                                    String str2 = tiebaPlusInfo.button_desc;
                                    if (str2 != null && str2.length() != 0) {
                                        z4 = false;
                                    } else {
                                        z4 = true;
                                    }
                                    if (!z4) {
                                        String str3 = tiebaPlusInfo.jump_url;
                                        if (str3 != null && str3.length() != 0) {
                                            z5 = false;
                                        } else {
                                            z5 = true;
                                        }
                                        if (!z5) {
                                            String str4 = tiebaPlusInfo.download_url;
                                            if (str4 != null && str4.length() != 0) {
                                                z6 = false;
                                            } else {
                                                z6 = true;
                                            }
                                            if (!z6) {
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
