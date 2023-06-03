package com.baidu.tieba;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.liveremind.LiveRemindConfig;
import com.baidu.tbadk.data.LiveRemindRecommendData;
import com.baidu.tieba.ge5;
import com.baidu.tieba.q55;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class m3a extends q55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity c;
    public LiveRemindRecommendData d;
    public Map<String, Object> e;
    public ge5 f;

    /* loaded from: classes6.dex */
    public class a implements ge5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m3a a;

        public a(m3a m3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m3aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m3aVar;
        }

        @Override // com.baidu.tieba.ge5.h
        public void dismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m3a(MainTabActivity mainTabActivity, v0a v0aVar) {
        super(mainTabActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, v0aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = mainTabActivity;
    }

    @Override // com.baidu.tieba.q55
    public void b() {
        ge5 ge5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (ge5Var = this.f) != null) {
            ge5Var.t();
        }
    }

    @Override // com.baidu.tieba.q55
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f = he5.d(null, this.c.getPageContext(), this.e, 0L, 4000L, new a(this));
            z85.b().f(LiveRemindConfig.Scene.LIVE_FLOAT);
        }
    }

    @Override // com.baidu.tieba.q55
    public void d(q55.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (x55.j()) {
                aVar.callback(false);
                return;
            }
            LiveRemindRecommendData c = y85.a().c(0);
            this.d = c;
            if (c != null && z85.b().j(LiveRemindConfig.Scene.LIVE_FLOAT)) {
                this.e = new HashMap();
                int i = 3;
                if (this.d.getRemindType() != 1) {
                    if (this.d.getRemindType() == 2) {
                        i = 4;
                    } else if (this.d.getRemindType() == 3) {
                        i = 2;
                    } else {
                        i = 0;
                    }
                }
                this.e.put("view_top_params_key_image_url", this.d.getLiveIconSrc());
                this.e.put("view_top_params_key_schema", this.d.getLiveIconScheme());
                this.e.put("view_top_params_user_name", this.d.getUserName());
                this.e.put("view_top_params_key_desc", this.d.getDesc());
                this.e.put("view_top_params_room_id", this.d.getRoomId());
                this.e.put("view_top_params_btn_text", this.d.getBtnText());
                this.e.put("view_top_params_key_title", this.d.getTitle());
                this.e.put("view_top_params_key_nid", this.d.getFeedId());
                this.e.put("view_top_params_key_yyext", this.d.getYyExtData());
                this.e.put("view_top_params_key_type", Integer.valueOf(i));
                this.e.put("view_top_params_is_breathe", Boolean.FALSE);
                if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && !of5.j()) {
                    if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && !of5.j()) {
                        aVar.callback(true);
                        return;
                    } else {
                        aVar.callback(false);
                        return;
                    }
                }
                aVar.callback(false);
                return;
            }
            aVar.callback(false);
        }
    }
}
