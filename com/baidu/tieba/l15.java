package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.liveremind.LiveRemindConfig;
import com.baidu.tbadk.data.LiveRemindRecommendData;
import com.baidu.tieba.s95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class l15 extends g15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public l15() {
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

    public static final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            YunDialogManager.unMarkShowingDialogName("homeLiveRemind");
        }
    }

    @Override // com.baidu.tieba.g15
    public void a(Context context, u05 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, data) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null && (currentActivity instanceof TbPageContextSupport)) {
                int i = 0;
                LiveRemindRecommendData c = g45.a().c(0);
                HashMap hashMap = new HashMap();
                if (c.getRemindType() == 1) {
                    i = 3;
                } else if (c.getRemindType() == 2) {
                    i = 4;
                } else if (c.getRemindType() == 3) {
                    i = 2;
                }
                hashMap.put("view_top_params_key_image_url", c.getLiveIconSrc());
                hashMap.put("view_top_params_key_schema", c.getLiveIconScheme());
                hashMap.put("view_top_params_user_name", c.getUserName());
                hashMap.put("view_top_params_key_desc", c.getDesc());
                hashMap.put("view_top_params_room_id", c.getRoomId());
                hashMap.put("view_top_params_btn_text", c.getBtnText());
                hashMap.put("view_top_params_key_title", c.getTitle());
                hashMap.put("view_top_params_key_nid", c.getFeedId());
                hashMap.put("view_top_params_key_yyext", c.getYyExtData());
                hashMap.put("view_top_params_key_type", Integer.valueOf(i));
                hashMap.put("view_top_params_is_breathe", Boolean.FALSE);
                t95.d(null, ((TbPageContextSupport) currentActivity).getPageContext(), hashMap, 0L, 4000L, new s95.h() { // from class: com.baidu.tieba.a15
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.s95.h
                    public final void dismiss() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            l15.b();
                        }
                    }
                });
                h45.b().f(LiveRemindConfig.Scene.LIVE_FLOAT);
                YunDialogManager.markShowingDialogName("homeLiveRemind");
                return;
            }
            YunDialogManager.unMarkShowingDialogName("homeLiveRemind");
        }
    }
}
