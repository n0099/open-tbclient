package com.baidu.tieba;

import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.coreExtra.util.PushOpenUtil;
import com.baidu.tieba.dga;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.push.PushGuideManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
/* loaded from: classes8.dex */
public class r28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vb5 a;
    public FrsActivity b;
    public Map<String, Date> c;
    public boolean d;

    /* loaded from: classes8.dex */
    public class a implements Function0<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dga a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Date c;
        public final /* synthetic */ r28 d;

        /* renamed from: com.baidu.tieba.r28$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class View$OnClickListenerC0456a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnClickListenerC0456a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    new dga.b(this.a.d.b.getPageContext(), this.a.a).a();
                    this.a.d.a();
                }
            }
        }

        public a(r28 r28Var, dga dgaVar, String str, Date date) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r28Var, dgaVar, str, date};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = r28Var;
            this.a = dgaVar;
            this.b = str;
            this.c = date;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Unit invoke() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                FrsActivity frsActivity = this.d.b;
                if (frsActivity != null && frsActivity.q1() != null) {
                    z = this.d.b.q1().B;
                } else {
                    z = false;
                }
                HashMap hashMap = new HashMap();
                if (z) {
                    hashMap.put(PushOpenUtil.VIEW_PARAMS_KEY_STYLE, "short");
                }
                vb5 vb5Var = this.d.a;
                if (vb5Var != null) {
                    vb5Var.o();
                }
                r28 r28Var = this.d;
                r28Var.a = PushOpenUtil.showPushOpenView(r28Var.b.getPageContext(), this.a.h(), 2000L, hashMap);
                vb5 vb5Var2 = this.d.a;
                if (vb5Var2 != null) {
                    vb5Var2.v(new View$OnClickListenerC0456a(this));
                    this.a.g();
                }
                this.d.c.put(this.b, this.c);
                TbSingleton.getInstance().setHasShowTip(this.d.c);
                return null;
            }
            return (Unit) invokeV.objValue;
        }
    }

    public r28(FrsActivity frsActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new HashMap();
        this.d = false;
        this.b = frsActivity;
    }

    public void a() {
        vb5 vb5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (vb5Var = this.a) != null) {
            vb5Var.o();
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            vb5 vb5Var = this.a;
            if (vb5Var != null && vb5Var.r()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public Date c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (this.c == null) {
                this.c = new HashMap();
            } else {
                this.c = TbSingleton.getInstance().getHasShowTip();
            }
            Date date = new Date(System.currentTimeMillis());
            Map<String, Date> map = this.c;
            if (map != null && map.containsKey(str)) {
                if (TimeHelper.getDayDifference(this.c.get(str), date) >= 1) {
                    this.d = true;
                }
            } else {
                this.d = true;
            }
            return date;
        }
        return (Date) invokeL.objValue;
    }

    public void d(@Nullable ForumData forumData) {
        FrsActivity frsActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, forumData) == null) && (frsActivity = this.b) != null && frsActivity.getPageContext() != null && forumData != null) {
            String id = forumData.getId();
            Date c = c(id);
            dga j = PushGuideManager.j("forum_follow");
            if (j != null && this.d) {
                j.e(forumData);
                j.k(this.b.getPageContext(), new a(this, j, id, c));
                return;
            }
            BdUtilHelper.showToastByTextCenter(TbadkCoreApplication.getInst(), R.string.push_like_tip_msg);
        }
    }
}
