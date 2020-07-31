package com.baidu.tieba.write.b.a;

import android.content.Context;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class o extends UnitedSchemeBaseDispatcher {
    private static final String TAG = o.class.getSimpleName();
    private static final boolean DEBUG = AppConfig.isDebug();
    public static HashMap<String, CallbackHandler> mxi = new HashMap<>();

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        return "ugc";
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return false;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        return null;
    }
}
