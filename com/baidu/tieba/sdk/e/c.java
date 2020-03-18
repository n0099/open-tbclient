package com.baidu.tieba.sdk.e;

import android.content.Context;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.scheme.ILiveScheme;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import java.util.Map;
/* loaded from: classes3.dex */
public class c implements ILiveScheme {
    @Override // com.baidu.live.tbadk.scheme.ILiveScheme
    public void excute(Context context, Map<String, String> map, SchemeCallback schemeCallback) {
        try {
            com.baidu.tieba.sdk.a.cED().a(TbadkCoreApplication.getInst(), map.get("exp") == null ? -1L : Long.parseLong(map.get("exp")), map.get(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL) == null ? -1 : Integer.parseInt(map.get(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL)));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
