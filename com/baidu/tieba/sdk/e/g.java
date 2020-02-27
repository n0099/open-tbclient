package com.baidu.tieba.sdk.e;

import android.content.Context;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.scheme.ILiveScheme;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import java.util.Map;
/* loaded from: classes3.dex */
public class g implements ILiveScheme {
    @Override // com.baidu.live.tbadk.scheme.ILiveScheme
    public void excute(Context context, Map<String, String> map, SchemeCallback schemeCallback) {
        com.baidu.tieba.sdk.a.cEg().fq(TbadkCoreApplication.getInst());
    }
}
