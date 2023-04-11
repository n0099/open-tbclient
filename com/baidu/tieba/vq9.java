package com.baidu.tieba;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.liveremind.LiveRemindConfig;
import com.baidu.tbadk.data.LiveRemindRecommendData;
import com.baidu.tieba.j95;
import com.baidu.tieba.s05;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class vq9 extends s05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity c;
    public LiveRemindRecommendData d;
    public Map<String, Object> e;
    public j95 f;

    /* loaded from: classes6.dex */
    public class a implements j95.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vq9 a;

        public a(vq9 vq9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vq9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vq9Var;
        }

        @Override // com.baidu.tieba.j95.h
        public void dismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vq9(MainTabActivity mainTabActivity, jo9 jo9Var) {
        super(mainTabActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, jo9Var};
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

    @Override // com.baidu.tieba.s05
    public void b() {
        j95 j95Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (j95Var = this.f) != null) {
            j95Var.t();
        }
    }

    @Override // com.baidu.tieba.s05
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f = k95.d(null, this.c.getPageContext(), this.e, 0L, 4000L, new a(this));
            d45.b().f(LiveRemindConfig.Scene.LIVE_FLOAT);
        }
    }

    @Override // com.baidu.tieba.s05
    public void d(s05.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (z05.i()) {
                aVar.a(false);
                return;
            }
            LiveRemindRecommendData c = c45.a().c(0);
            this.d = c;
            if (c != null && d45.b().j(LiveRemindConfig.Scene.LIVE_FLOAT)) {
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
                if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && !la5.e()) {
                    if (!MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && !la5.e()) {
                        aVar.a(true);
                        return;
                    } else {
                        aVar.a(false);
                        return;
                    }
                }
                aVar.a(false);
                return;
            }
            aVar.a(false);
        }
    }
}
