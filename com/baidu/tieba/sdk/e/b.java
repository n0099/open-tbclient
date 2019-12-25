package com.baidu.tieba.sdk.e;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.scheme.ILiveScheme;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import java.util.Map;
/* loaded from: classes2.dex */
public class b implements ILiveScheme {
    @Override // com.baidu.live.tbadk.scheme.ILiveScheme
    public void excute(Map<String, String> map, SchemeCallback schemeCallback) {
        com.baidu.tieba.sdk.a.cBx().bf(TbadkCoreApplication.getInst(), "");
    }
}
