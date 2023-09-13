package com.baidu.tieba.write.webwrite.data;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.hz4;
import com.baidu.tieba.p1b;
import com.baidu.tieba.q1b;
import com.baidu.tieba.s1b;
import com.baidu.tieba.si5;
import com.baidu.tieba.t1b;
import com.baidu.tieba.u1b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\rH\u0002J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\rH\u0002J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\rH\u0002J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\rH\u0002J\u001a\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\bJ\u0018\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\bJ\u000e\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0012J\u0006\u0010&\u001a\u00020\tJ\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020\t2\u0006\u0010 \u001a\u00020\bJ\u000e\u0010,\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010-\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\rR\u009b\u0001\u0010\u0003\u001a\u008e\u0001\u0012\u0004\u0012\u00020\u0005\u0012<\u0012:\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u00070\u0006j\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0007`\n0\u0004jF\u0012\u0004\u0012\u00020\u0005\u0012<\u0012:\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u00070\u0006j\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0007`\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0006j\b\u0012\u0004\u0012\u00020\r`\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR6\u0010\u0010\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u00110\u0006j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u0011`\nX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00140\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0014`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/baidu/tieba/write/webwrite/data/BizBus;", "", "()V", "activityRequestHandlers", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lkotlin/Function2;", "Landroid/content/Intent;", "", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "allBiz", "Lcom/baidu/tieba/write/webwrite/data/Biz;", "getAllBiz", "()Ljava/util/ArrayList;", "draftDataHandlers", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "editorActionHandlers", "Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "hybridListeners", "", "Lcom/baidu/tbadk/browser/utils/HybridNotifyManager$HybridNotifyListener;", "addActionHandlers", "biz", "addActivityResultHandler", "addDraftDataListener", "addHybridKeyListener", "initFromIntent", "savedInstanceState", "Landroid/os/Bundle;", "intent", "onActivityResultOK", "requestCode", "data", "onAddDraftData", "json", MissionEvent.MESSAGE_DESTROY, "onEditorAction", "", "action", "Lcom/baidu/tbadk/editortools/Action;", "onNewIntent", "onSaveInstanceState", "register", "write_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class BizBus {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<hz4.d> a;
    public final ArrayList<s1b> b;
    public final HashMap<Integer, ArrayList<Function2<Integer, Intent, Unit>>> c;
    public final HashMap<Integer, p1b> d;
    public final ArrayList<Function1<JSONObject, Unit>> e;

    public BizBus() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.b = new ArrayList<>();
        this.c = new HashMap<>();
        this.d = new HashMap<>();
        this.e = new ArrayList<>();
    }

    public final void a(s1b s1bVar) {
        p1b[] d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, s1bVar) == null) && (d = s1bVar.d()) != null) {
            for (p1b p1bVar : d) {
                for (Integer num : p1bVar.a()) {
                    this.d.put(Integer.valueOf(num.intValue()), p1bVar);
                }
            }
        }
    }

    public final void j(Intent intent) {
        u1b u1bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Iterator<s1b> it = this.b.iterator();
            while (it.hasNext()) {
                s1b next = it.next();
                if (next instanceof u1b) {
                    u1bVar = (u1b) next;
                } else {
                    u1bVar = null;
                }
                if (u1bVar != null) {
                    u1bVar.onNewIntent(intent);
                }
            }
        }
    }

    public final void k(Bundle savedInstanceState) {
        u1b u1bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, savedInstanceState) == null) {
            Intrinsics.checkNotNullParameter(savedInstanceState, "savedInstanceState");
            Iterator<s1b> it = this.b.iterator();
            while (it.hasNext()) {
                s1b next = it.next();
                if (next instanceof u1b) {
                    u1bVar = (u1b) next;
                } else {
                    u1bVar = null;
                }
                if (u1bVar != null) {
                    u1bVar.onSaveInstanceState(savedInstanceState);
                }
            }
        }
    }

    public final void b(s1b s1bVar) {
        q1b[] f;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s1bVar) == null) && (f = s1bVar.f()) != null) {
            for (q1b q1bVar : f) {
                for (Integer num : q1bVar.b()) {
                    int intValue = num.intValue();
                    ArrayList<Function2<Integer, Intent, Unit>> arrayList = this.c.get(Integer.valueOf(intValue));
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    } else {
                        Intrinsics.checkNotNullExpressionValue(arrayList, "activityRequestHandlers[code] ?: ArrayList()");
                    }
                    arrayList.add(new BizBus$addActivityResultHandler$1$1(q1bVar));
                    this.c.put(Integer.valueOf(intValue), arrayList);
                }
            }
        }
    }

    public final void c(s1b s1bVar) {
        Function1<JSONObject, Unit> b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, s1bVar) == null) && (b = s1bVar.b()) != null) {
            this.e.add(b);
        }
    }

    public final void d(s1b s1bVar) {
        WrapListener[] e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, s1bVar) == null) && (e = s1bVar.e()) != null) {
            for (WrapListener wrapListener : e) {
                this.a.add(wrapListener);
                hz4.b.a().c(wrapListener);
            }
        }
    }

    public final void g(JSONObject json) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, json) == null) {
            Intrinsics.checkNotNullParameter(json, "json");
            Iterator<T> it = this.e.iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(json);
            }
        }
    }

    public final boolean i(si5 action) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, action)) == null) {
            Intrinsics.checkNotNullParameter(action, "action");
            p1b p1bVar = this.d.get(Integer.valueOf(action.a));
            if (p1bVar != null) {
                p1bVar.b(action);
            }
            if (p1bVar != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void l(s1b biz) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, biz) == null) {
            Intrinsics.checkNotNullParameter(biz, "biz");
            this.b.add(biz);
            a(biz);
            b(biz);
            d(biz);
            c(biz);
        }
    }

    public final void e(Bundle bundle, Intent intent) {
        u1b u1bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bundle, intent) == null) {
            Iterator<s1b> it = this.b.iterator();
            while (it.hasNext()) {
                s1b next = it.next();
                if (next instanceof u1b) {
                    u1bVar = (u1b) next;
                } else {
                    u1bVar = null;
                }
                if (u1bVar != null) {
                    u1bVar.a(bundle, intent);
                }
            }
        }
    }

    public final void f(int i, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, intent) == null) {
            ArrayList<Function2<Integer, Intent, Unit>> arrayList = this.c.get(Integer.valueOf(i));
            if (arrayList != null) {
                Iterator<T> it = arrayList.iterator();
                while (it.hasNext()) {
                    ((Function2) it.next()).invoke(Integer.valueOf(i), intent);
                }
                return;
            }
            throw new IllegalStateException(i + " activityResultHandler not found!");
        }
    }

    public final void h() {
        t1b t1bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Iterator<hz4.d> it = this.a.iterator();
            while (true) {
                t1b t1bVar2 = null;
                if (!it.hasNext()) {
                    break;
                }
                hz4.d next = it.next();
                hz4.b.a().e(next);
                if (next instanceof t1b) {
                    t1bVar2 = (t1b) next;
                }
                if (t1bVar2 != null) {
                    t1bVar2.onDestroy();
                }
            }
            this.a.clear();
            this.c.clear();
            this.d.clear();
            Iterator<s1b> it2 = this.b.iterator();
            while (it2.hasNext()) {
                s1b next2 = it2.next();
                if (next2 instanceof t1b) {
                    t1bVar = (t1b) next2;
                } else {
                    t1bVar = null;
                }
                if (t1bVar != null) {
                    t1bVar.onDestroy();
                }
            }
            this.b.clear();
        }
    }
}
