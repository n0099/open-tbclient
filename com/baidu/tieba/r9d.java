package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ThemeBubble;
/* loaded from: classes8.dex */
public class r9d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ThemeBubble themeBubble) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, themeBubble)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "props_id", themeBubble.props_id);
            ltc.a(jSONObject, TableDefine.EmojiColumns.COLUMN_PACKAGE_ID, themeBubble.package_id);
            ltc.a(jSONObject, BigdayActivityConfig.JUMP_URL, themeBubble.jump_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
