package com.baidu.tieba.sdk.e;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.scheme.ILiveScheme;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import java.util.Map;
/* loaded from: classes6.dex */
public class g implements ILiveScheme {
    @Override // com.baidu.live.tbadk.scheme.ILiveScheme
    public void excute(Map<String, String> map, SchemeCallback schemeCallback) {
        com.baidu.tieba.sdk.a.chv().dX(TbadkCoreApplication.getInst());
    }
}
