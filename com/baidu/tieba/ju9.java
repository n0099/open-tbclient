package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.dv9;
import com.baidu.tieba.pb.bot.menu.BotSkillMenuAdapter;
import com.baidu.tieba.pb.bot.menu.BotSkillMenuView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tbclient.CallRobotEntrance;
/* loaded from: classes6.dex */
public final class ju9 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface b {
        void a(CallRobotEntrance callRobotEntrance);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947895931, "Lcom/baidu/tieba/ju9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947895931, "Lcom/baidu/tieba/ju9;");
                return;
            }
        }
        a = new a(null);
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: com.baidu.tieba.ju9$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0370a implements BotSkillMenuAdapter.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;
            public final /* synthetic */ dv9 b;

            public C0370a(b bVar, dv9 dv9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, dv9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
                this.b = dv9Var;
            }

            @Override // com.baidu.tieba.pb.bot.menu.BotSkillMenuAdapter.a
            public void a(View view2, CallRobotEntrance data) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, view2, data) == null) {
                    Intrinsics.checkNotNullParameter(view2, "view");
                    Intrinsics.checkNotNullParameter(data, "data");
                    if (data.ability_conf != null) {
                        b bVar = this.a;
                        dv9 dv9Var = this.b;
                        bVar.a(data);
                        dv9Var.a();
                    }
                }
            }
        }

        public a() {
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

        public final void a(View view2, dv9.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, aVar) == null) {
                Context context = view2.getContext();
                int equipmentWidth = BdUtilHelper.getEquipmentWidth(context);
                int screenHeight = UtilHelper.getScreenHeight(TbadkApplication.getInst());
                int dimens = BdUtilHelper.getDimens(context, R.dimen.tbds62);
                int dimens2 = BdUtilHelper.getDimens(context, R.dimen.M_H_X001);
                int dimens3 = BdUtilHelper.getDimens(context, R.dimen.tbds19);
                Rect rect = new Rect();
                view2.getGlobalVisibleRect(rect);
                aVar.i((equipmentWidth - rect.centerX()) - dimens);
                aVar.j(((screenHeight - rect.top) + dimens2) - dimens3);
            }
        }

        @JvmStatic
        public final void b(View view2, List<CallRobotEntrance> dataList, b listener, ev9 ev9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, dataList, listener, ev9Var) == null) {
                Intrinsics.checkNotNullParameter(dataList, "dataList");
                Intrinsics.checkNotNullParameter(listener, "listener");
                if (view2 != null && !ListUtils.isEmpty(dataList)) {
                    Context context = view2.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    BotSkillMenuView botSkillMenuView = new BotSkillMenuView(context);
                    dv9.a aVar = new dv9.a(botSkillMenuView);
                    aVar.g(85);
                    aVar.h(ev9Var);
                    a(view2, aVar);
                    dv9 a = aVar.a();
                    botSkillMenuView.setOnItemClickListener(new C0370a(listener, a));
                    a.b();
                    botSkillMenuView.setData(dataList);
                }
            }
        }
    }
}
