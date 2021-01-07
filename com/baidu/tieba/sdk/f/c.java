package com.baidu.tieba.sdk.f;

import android.content.Context;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.scheme.ILiveScheme;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.Map;
/* loaded from: classes11.dex */
public class c implements ILiveScheme {
    @Override // com.baidu.live.tbadk.scheme.ILiveScheme
    public void excute(Context context, Map<String, String> map, SchemeCallback schemeCallback) {
        try {
            com.baidu.tieba.sdk.a.dGY().b(TbadkCoreApplication.getInst(), map.get("exp") == null ? -1L : Long.parseLong(map.get("exp")), map.get(MapBundleKey.MapObjKey.OBJ_LEVEL) == null ? -1 : Integer.parseInt(map.get(MapBundleKey.MapObjKey.OBJ_LEVEL)));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
