package com.bytedance.pangle;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.receiver.PluginBroadcastReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes7.dex */
public final class LocalBroadcastManager {
    public static /* synthetic */ Interceptable $ic;
    public static final Object f;
    public static LocalBroadcastManager g;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final HashMap b;
    public final HashMap c;
    public final ArrayList d;
    public final Handler e;

    /* loaded from: classes7.dex */
    public final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Intent a;
        public final ArrayList b;

        public a(Intent intent, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {intent, arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = intent;
            this.b = arrayList;
        }
    }

    /* loaded from: classes7.dex */
    public final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final IntentFilter a;
        public final PluginBroadcastReceiver b;
        public boolean c;
        public boolean d;

        public b(IntentFilter intentFilter, PluginBroadcastReceiver pluginBroadcastReceiver) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {intentFilter, pluginBroadcastReceiver};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = intentFilter;
            this.b = pluginBroadcastReceiver;
        }

        public final String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                StringBuilder sb = new StringBuilder(128);
                sb.append("Receiver{");
                sb.append(this.b);
                sb.append(" filter=");
                sb.append(this.a);
                if (this.d) {
                    sb.append(" DEAD");
                }
                sb.append("}");
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1794661746, "Lcom/bytedance/pangle/LocalBroadcastManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1794661746, "Lcom/bytedance/pangle/LocalBroadcastManager;");
                return;
            }
        }
        f = new Object();
    }

    public LocalBroadcastManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new ArrayList();
        this.a = context;
        this.e = new Handler(this, context.getMainLooper()) { // from class: com.bytedance.pangle.LocalBroadcastManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LocalBroadcastManager a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    if (message.what != 1) {
                        super.handleMessage(message);
                    } else {
                        this.a.a();
                    }
                }
            }
        };
    }

    public static LocalBroadcastManager getInstance(Context context) {
        InterceptResult invokeL;
        LocalBroadcastManager localBroadcastManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (f) {
                if (g == null) {
                    g = new LocalBroadcastManager(context.getApplicationContext());
                }
                localBroadcastManager = g;
            }
            return localBroadcastManager;
        }
        return (LocalBroadcastManager) invokeL.objValue;
    }

    public final void sendBroadcastSync(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, intent) == null) && sendBroadcast(intent)) {
            a();
        }
    }

    public final void a() {
        int size;
        a[] aVarArr;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
            return;
        }
        while (true) {
            synchronized (this.b) {
                size = this.d.size();
                if (size <= 0) {
                    return;
                }
                aVarArr = new a[size];
                this.d.toArray(aVarArr);
                this.d.clear();
            }
            for (int i = 0; i < size; i++) {
                a aVar = aVarArr[i];
                int size2 = aVar.b.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    b bVar = (b) aVar.b.get(i2);
                    if (!bVar.d) {
                        bVar.b.onReceive(this.a, aVar.a);
                    }
                }
            }
        }
    }

    public final void registerReceiver(PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pluginBroadcastReceiver, intentFilter) == null) {
            synchronized (this.b) {
                b bVar = new b(intentFilter, pluginBroadcastReceiver);
                ArrayList arrayList = (ArrayList) this.b.get(pluginBroadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    this.b.put(pluginBroadcastReceiver, arrayList);
                }
                arrayList.add(bVar);
                for (int i = 0; i < intentFilter.countActions(); i++) {
                    String action = intentFilter.getAction(i);
                    ArrayList arrayList2 = (ArrayList) this.c.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                        this.c.put(action, arrayList2);
                    }
                    arrayList2.add(bVar);
                }
            }
        }
    }

    public final boolean sendBroadcast(Intent intent) {
        InterceptResult invokeL;
        boolean z;
        int i;
        String str;
        ArrayList arrayList;
        ArrayList arrayList2;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent)) == null) {
            synchronized (this.b) {
                String action = intent.getAction();
                String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.a.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                if ((intent.getFlags() & 8) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    Log.v(androidx.localbroadcastmanager.content.LocalBroadcastManager.TAG, "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                }
                ArrayList arrayList3 = (ArrayList) this.c.get(intent.getAction());
                if (arrayList3 != null) {
                    if (z) {
                        Log.v(androidx.localbroadcastmanager.content.LocalBroadcastManager.TAG, "Action list: ".concat(String.valueOf(arrayList3)));
                    }
                    ArrayList arrayList4 = null;
                    int i2 = 0;
                    while (i2 < arrayList3.size()) {
                        b bVar = (b) arrayList3.get(i2);
                        if (z) {
                            Log.v(androidx.localbroadcastmanager.content.LocalBroadcastManager.TAG, "Matching against filter " + bVar.a);
                        }
                        if (bVar.c) {
                            if (z) {
                                Log.v(androidx.localbroadcastmanager.content.LocalBroadcastManager.TAG, "  Filter's target already added");
                            }
                            i = i2;
                            arrayList2 = arrayList3;
                            str = action;
                            str2 = resolveTypeIfNeeded;
                            arrayList = arrayList4;
                        } else {
                            i = i2;
                            str = action;
                            arrayList = arrayList4;
                            arrayList2 = arrayList3;
                            str2 = resolveTypeIfNeeded;
                            int match = bVar.a.match(action, resolveTypeIfNeeded, scheme, data, categories, androidx.localbroadcastmanager.content.LocalBroadcastManager.TAG);
                            if (match >= 0) {
                                if (z) {
                                    Log.v(androidx.localbroadcastmanager.content.LocalBroadcastManager.TAG, "  Filter matched!  match=0x" + Integer.toHexString(match));
                                }
                                if (arrayList == null) {
                                    arrayList4 = new ArrayList();
                                } else {
                                    arrayList4 = arrayList;
                                }
                                arrayList4.add(bVar);
                                bVar.c = true;
                                i2 = i + 1;
                                action = str;
                                arrayList3 = arrayList2;
                                resolveTypeIfNeeded = str2;
                            } else if (z) {
                                if (match != -4) {
                                    if (match != -3) {
                                        if (match != -2) {
                                            if (match != -1) {
                                                str3 = "unknown reason";
                                            } else {
                                                str3 = "type";
                                            }
                                        } else {
                                            str3 = "data";
                                        }
                                    } else {
                                        str3 = "action";
                                    }
                                } else {
                                    str3 = "category";
                                }
                                Log.v(androidx.localbroadcastmanager.content.LocalBroadcastManager.TAG, "  Filter did not match: ".concat(str3));
                            }
                        }
                        arrayList4 = arrayList;
                        i2 = i + 1;
                        action = str;
                        arrayList3 = arrayList2;
                        resolveTypeIfNeeded = str2;
                    }
                    ArrayList arrayList5 = arrayList4;
                    if (arrayList5 != null) {
                        for (int i3 = 0; i3 < arrayList5.size(); i3++) {
                            ((b) arrayList5.get(i3)).c = false;
                        }
                        this.d.add(new a(intent, arrayList5));
                        if (!this.e.hasMessages(1)) {
                            this.e.sendEmptyMessage(1);
                        }
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final void unregisterReceiver(PluginBroadcastReceiver pluginBroadcastReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pluginBroadcastReceiver) == null) {
            synchronized (this.b) {
                ArrayList arrayList = (ArrayList) this.b.remove(pluginBroadcastReceiver);
                if (arrayList == null) {
                    return;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    b bVar = (b) arrayList.get(size);
                    bVar.d = true;
                    for (int i = 0; i < bVar.a.countActions(); i++) {
                        String action = bVar.a.getAction(i);
                        ArrayList arrayList2 = (ArrayList) this.c.get(action);
                        if (arrayList2 != null) {
                            for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                                b bVar2 = (b) arrayList2.get(size2);
                                if (bVar2.b == pluginBroadcastReceiver) {
                                    bVar2.d = true;
                                    arrayList2.remove(size2);
                                }
                            }
                            if (arrayList2.size() <= 0) {
                                this.c.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }
}
