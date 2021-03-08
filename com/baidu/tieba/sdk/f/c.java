package com.baidu.tieba.sdk.f;

import android.content.Context;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.scheme.ILiveScheme;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import java.util.Map;
/* loaded from: classes10.dex */
public class c implements ILiveScheme {
    @Override // com.baidu.live.tbadk.scheme.ILiveScheme
    public void excute(Context context, Map<String, String> map, SchemeCallback schemeCallback) {
        try {
            com.baidu.tieba.sdk.a.dFF().a(TbadkCoreApplication.getInst(), map.get("exp") == null ? -1L : Long.parseLong(map.get("exp")), map.get("level") == null ? -1 : Integer.parseInt(map.get("level")));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
