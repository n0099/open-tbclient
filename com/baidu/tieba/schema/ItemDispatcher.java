package com.baidu.tieba.schema;

import android.content.Context;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tieba.xc9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/baidu/tieba/schema/ItemDispatcher;", "Lcom/baidu/tieba/schema/SchemaDispatcher;", "()V", StatConstants.VALUE_TYPE_DISPATCH, "", "params", "Lorg/json/JSONObject;", "context", "Landroid/content/Context;", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ItemDispatcher implements xc9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ItemDispatcher() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.xc9
    public void dispatch(JSONObject jSONObject, Context context) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, jSONObject, context) != null) || jSONObject == null) {
            return;
        }
        String forumName = jSONObject.optString("forum_name");
        String itemId = jSONObject.optString("item_id");
        int i2 = 2;
        boolean z = false;
        if (Intrinsics.areEqual(jSONObject.optString("page_from"), ImageViewerConfig.FROM_CONCERN)) {
            i = 2;
        } else {
            i = 0;
            i2 = 0;
        }
        if ((forumName == null || forumName.length() == 0) ? true : true) {
            Intrinsics.checkNotNullExpressionValue(itemId, "itemId");
            ItemClickJumpUtil.jumpToItemDetailPage(itemId, i);
            return;
        }
        Intrinsics.checkNotNullExpressionValue(forumName, "forumName");
        ItemClickJumpUtil.jumpToFrs(forumName, Integer.valueOf(i2));
    }
}
