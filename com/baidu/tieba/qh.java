package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.BdStatisticsSwitchStatic;
import com.baidu.adp.lib.stats.upload.BdUploadingLogInfo;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class qh {
    public static /* synthetic */ Interceptable $ic;
    public static qh f;
    public transient /* synthetic */ FieldHolder $fh;
    public ah a;
    public String b;
    public String c;
    public b d;
    public CustomMessageListener e;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qh a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qh qhVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qhVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qhVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                this.a.f();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qh this$0;

        public b(qh qhVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qhVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = qhVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null) {
                return;
            }
            this.this$0.q(intent.getStringExtra("intent_data_userid"), intent.getStringExtra("intent_data_username"), intent.getStringExtra("intent_data_bduss"));
        }

        public /* synthetic */ b(qh qhVar, a aVar) {
            this(qhVar);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<Object, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public gh a;
        public final /* synthetic */ qh b;

        public c(@NonNull qh qhVar, gh ghVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qhVar, ghVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qhVar;
            this.a = null;
            this.a = ghVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                d(this.a);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r5) == null) {
                this.a.J(false);
            }
        }

        public final void d(gh ghVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ghVar) == null) {
                try {
                    BdUploadingLogInfo b = rh.b(ghVar);
                    int size = b.size();
                    if (b == null || size <= 0) {
                        return;
                    }
                    for (int i = size - 1; i >= 0; i--) {
                        ArrayList<String> trackLogStringByIndex = b.getTrackLogStringByIndex(i);
                        if (trackLogStringByIndex != null && trackLogStringByIndex.size() != 0) {
                            this.b.i(ghVar, trackLogStringByIndex, b.get(i));
                        }
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends BdAsyncTask<Object, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public gh a;
        public String b;
        public final /* synthetic */ qh c;

        public d(qh qhVar, gh ghVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qhVar, ghVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qhVar;
            this.a = ghVar;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                String e = sh.e(this.a, this.c.a);
                String str = this.b;
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                BdLog.i("commonHeader = " + e);
                BdLog.i("cache = " + str);
                this.a.d();
                this.c.h(this.a, e, arrayList, null, true);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e extends BdAsyncTask<Object, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public gh a;
        public String b;
        public final /* synthetic */ qh c;

        public e(qh qhVar, gh ghVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qhVar, ghVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qhVar;
            this.a = ghVar;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                String str = this.b;
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                this.a.f();
                this.c.i(this.a, arrayList, null);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f extends BdAsyncTask<Object, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public gh a;
        public ArrayList<String> b;
        public boolean c;
        public boolean d;
        public boolean e;
        public final /* synthetic */ qh f;

        public f(qh qhVar, gh ghVar, ArrayList<String> arrayList, boolean z, boolean z2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qhVar, ghVar, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = qhVar;
            this.a = null;
            this.b = null;
            this.c = false;
            this.d = false;
            this.e = false;
            this.a = ghVar;
            this.b = arrayList;
            this.c = z;
            this.d = z2;
            this.e = z3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                d(this.a, this.c, this.d, this.e);
                return null;
            }
            return (Void) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r5) == null) {
                this.a.K(false);
            }
        }

        public final void d(gh ghVar, boolean z, boolean z2, boolean z3) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{ghVar, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
                try {
                    String e = sh.e(ghVar, this.f.a);
                    BdUploadingLogInfo b = ph.b(ghVar, z2);
                    int size = b.size();
                    if (b == null || size <= 0) {
                        return;
                    }
                    if (!z) {
                        int i2 = 0;
                        while (i2 < size) {
                            ArrayList<String> logStringByIndex = b.getLogStringByIndex(i2, this.b);
                            if (logStringByIndex != null && logStringByIndex.size() != 0) {
                                if (!z2) {
                                    i = i2;
                                    this.f.h(ghVar, e, logStringByIndex, b.get(i), z3);
                                } else {
                                    ArrayList<jh> arrayList = b.get(i2);
                                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                        if (arrayList.get(i3).b.contains("notUpload/")) {
                                            arrayList.get(i3).b = arrayList.get(i3).b.replace("notUpload/", "");
                                        }
                                    }
                                    i = i2;
                                    this.f.h(ghVar, e, logStringByIndex, arrayList, z3);
                                }
                                i2 = i + 1;
                            }
                            i = i2;
                            i2 = i + 1;
                        }
                        return;
                    }
                    int i4 = 0;
                    for (int i5 = size - 1; i5 >= 0; i5--) {
                        ArrayList<String> logStringByIndex2 = b.getLogStringByIndex(i5, this.b);
                        if (logStringByIndex2 != null && logStringByIndex2.size() != 0) {
                            if (!pi.H() && (i4 = i4 + logStringByIndex2.toString().length()) > 102400) {
                                return;
                            }
                            int i6 = i4;
                            if (!z2) {
                                this.f.h(ghVar, e, logStringByIndex2, b.get(i5), z3);
                            } else {
                                ArrayList<jh> arrayList2 = b.get(i5);
                                for (int i7 = 0; i7 < arrayList2.size(); i7++) {
                                    if (arrayList2.get(i7).b.contains("notUpload/")) {
                                        arrayList2.get(i7).b = arrayList2.get(i7).b.replace("notUpload/", "");
                                    }
                                }
                                this.f.h(ghVar, e, logStringByIndex2, arrayList2, z3);
                            }
                            i4 = i6;
                        }
                    }
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448314998, "Lcom/baidu/tieba/qh;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448314998, "Lcom/baidu/tieba/qh;");
        }
    }

    public qh() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = new a(this, 2000994);
    }

    public static qh m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (f == null) {
                synchronized (qh.class) {
                    if (f == null) {
                        f = new qh();
                    }
                }
            }
            return f;
        }
        return (qh) invokeV.objValue;
    }

    public final void e(ArrayList<String> arrayList, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, arrayList, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        if (arrayList.contains(str)) {
            return;
        }
        arrayList.add(str);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.o = bh.a(BdBaseApplication.getInst());
            this.a.p = String.valueOf(pi.I());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String g(String str, gh ghVar, String str2, ArrayList<String> arrayList, ArrayList<jh> arrayList2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        byte[] l;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, ghVar, str2, arrayList, arrayList2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            String str3 = str;
            if (str3 != null && ghVar != null && (l = l(str2, arrayList)) != null && l.length > 0) {
                ByteArrayOutputStream byteArrayOutputStream2 = null;
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(l.length / 2);
                    try {
                        try {
                            mi.b(l, byteArrayOutputStream);
                            bArr = byteArrayOutputStream.toByteArray();
                            og.d(byteArrayOutputStream);
                        } catch (Exception e2) {
                            e = e2;
                            BdLog.e(e);
                            og.d(byteArrayOutputStream);
                            bArr = null;
                            if (bArr != null) {
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        og.d(byteArrayOutputStream2);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    byteArrayOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    og.d(byteArrayOutputStream2);
                    throw th;
                }
                if (bArr != null) {
                    return "";
                }
                HashMap hashMap = new HashMap();
                hashMap.put(ghVar.p(), bArr);
                ArrayList arrayList3 = new ArrayList(hashMap.entrySet());
                if (ghVar != null) {
                    try {
                        if (ghVar.o().equals("pfmonitor") && BdStatisticsSwitchStatic.isOn()) {
                            try {
                                tf tfVar = new tf();
                                String str4 = this.b;
                                if (z2 && str4.contains("tiebac.baidu.com")) {
                                    str4 = str4.replace("tiebac.baidu.com", "123.125.115.120");
                                    tfVar.b().a("Host", "tiebac.baidu.com");
                                }
                                tfVar.b().s(str4);
                                tfVar.b().q(HttpMessageTask.HTTP_METHOD.POST);
                                HashMap<String, Object> f2 = sh.f(str4, this.a, z);
                                if (f2 != null) {
                                    tfVar.b().r(new ArrayList(f2.entrySet()));
                                }
                                hashMap.clear();
                                hashMap.put("pf", bArr);
                                arrayList3.clear();
                                arrayList3.addAll(hashMap.entrySet());
                                tfVar.b().r(arrayList3);
                                try {
                                    new qf(tfVar).m(3, -1, -1);
                                } catch (Exception e4) {
                                    BdLog.detailException(e4);
                                }
                                j(arrayList2, ghVar.E());
                                return null;
                            } catch (Exception e5) {
                                BdLog.e(e5);
                                return e5.getMessage();
                            }
                        }
                    } catch (Exception e6) {
                        BdLog.e(e6);
                        return e6.getMessage();
                    }
                }
                tf tfVar2 = new tf();
                if (z2 && str3.contains("tiebac.baidu.com")) {
                    str3 = str3.replace("tiebac.baidu.com", "123.125.115.120");
                    tfVar2.b().a("Host", "tiebac.baidu.com");
                }
                tfVar2.b().s(str3);
                tfVar2.b().q(HttpMessageTask.HTTP_METHOD.POST);
                HashMap<String, Object> f3 = sh.f(str3, this.a, z);
                if (f3 != null) {
                    tfVar2.b().r(new ArrayList(f3.entrySet()));
                }
                tfVar2.b().r(arrayList3);
                try {
                    new qf(tfVar2).m(3, -1, -1);
                    int i = tfVar2.c().b;
                    byte[] bArr2 = tfVar2.c().i;
                    if (bArr2 != null && i == 200) {
                        try {
                            if (new JSONObject(new String(bArr2, IMAudioTransRequest.CHARSET)).optInt("error_code", -1) == 0) {
                                j(arrayList2, ghVar.E());
                                return null;
                            }
                        } catch (Exception e7) {
                            BdLog.e(e7);
                            return e7.getMessage();
                        }
                    }
                    List<sf> d2 = tfVar2.d();
                    if (d2 != null && d2.size() > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (int i2 = 0; i2 < d2.size(); i2++) {
                            sf sfVar = d2.get(i2);
                            if (sfVar != null && !TextUtils.isEmpty(sfVar.h)) {
                                if (sb.length() > 0) {
                                    sb.append(",");
                                }
                                sb.append(sfVar.h);
                            }
                        }
                        if (sb.length() > 0) {
                            return sb.toString();
                        }
                    }
                } catch (Exception e8) {
                    BdLog.detailException(e8);
                    return e8.getMessage();
                }
            }
            return "";
        }
        return (String) invokeCommon.objValue;
    }

    public final void h(gh ghVar, String str, ArrayList<String> arrayList, ArrayList<jh> arrayList2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{ghVar, str, arrayList, arrayList2, Boolean.valueOf(z)}) == null) && g(this.b, ghVar, str, arrayList, arrayList2, z, false) != null && pi.z()) {
            String g = g(this.b, ghVar, str, arrayList, arrayList2, z, true);
            if (g == null) {
                xg statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.b("issuc", "true");
                BdStatisticsManager.getInstance().debug("STAT_UPLOAD_USEIP", statsItem);
                return;
            }
            xg statsItem2 = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem2.b("issuc", "false");
            statsItem2.b("reason", g);
            BdStatisticsManager.getInstance().debug("STAT_UPLOAD_USEIP", statsItem2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x003c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean i(gh ghVar, ArrayList<String> arrayList, ArrayList<jh> arrayList2) {
        InterceptResult invokeLLL;
        byte[] k;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, ghVar, arrayList, arrayList2)) == null) {
            if (ghVar == null || arrayList == null || arrayList.isEmpty() || (k = k(arrayList)) == null || k.length == 0) {
                return false;
            }
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            byte[] bArr = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(k.length / 2);
                try {
                    try {
                        mi.b(k, byteArrayOutputStream);
                        bArr = byteArrayOutputStream.toByteArray();
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e);
                        og.d(byteArrayOutputStream);
                        if (bArr != null) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    og.d(byteArrayOutputStream2);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                og.d(byteArrayOutputStream2);
                throw th;
            }
            og.d(byteArrayOutputStream);
            if (bArr != null) {
                return false;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(ghVar.q(), bArr);
            ArrayList arrayList3 = new ArrayList(hashMap.entrySet());
            tf tfVar = new tf();
            tfVar.b().a("Host", "tiebac.baidu.com");
            tfVar.b().s(this.c);
            tfVar.b().q(HttpMessageTask.HTTP_METHOD.POST);
            HashMap<String, Object> f2 = sh.f(this.c, this.a, false);
            if (f2 != null) {
                tfVar.b().r(new ArrayList(f2.entrySet()));
            }
            tfVar.b().r(arrayList3);
            try {
                new qf(tfVar).m(3, -1, -1);
                if (tfVar.c().b == 200) {
                    try {
                        if (new JSONObject(new String(tfVar.c().i, IMAudioTransRequest.CHARSET)).optString("error_code").equals("0")) {
                            ArrayList arrayList4 = new ArrayList();
                            Iterator<jh> it = arrayList2.iterator();
                            while (it.hasNext()) {
                                arrayList4.add(it.next().b);
                            }
                            if (arrayList4.size() > 0) {
                                ih.a(arrayList4, ghVar.C());
                                return true;
                            }
                            return true;
                        }
                        return true;
                    } catch (Exception e4) {
                        BdLog.e(e4);
                        return false;
                    }
                }
                return true;
            } catch (Exception e5) {
                BdLog.detailException(e5);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final void j(ArrayList<jh> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, arrayList, z) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<jh> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().b);
        }
        if (arrayList2.size() > 0) {
            hh.a(arrayList2, z);
        }
    }

    public final byte[] k(ArrayList<String> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                try {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        if (i != 0) {
                            sb.append("&");
                        }
                        sb.append(URLEncoder.encode(arrayList.get(i), IMAudioTransRequest.CHARSET));
                    }
                    return sb.toString().getBytes();
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }

    public final byte[] l(String str, ArrayList<String> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        sb.append("&rec");
                        sb.append(i);
                        sb.append('=');
                        try {
                            sb.append(URLEncoder.encode(arrayList.get(i), IMAudioTransRequest.CHARSET));
                        } catch (UnsupportedEncodingException e2) {
                            BdLog.e(e2);
                        }
                    }
                    return sb.toString().getBytes();
                } catch (Exception e3) {
                    BdLog.e(e3);
                }
            }
            return null;
        }
        return (byte[]) invokeLL.objValue;
    }

    public void n(ah ahVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ahVar, str, str2) == null) {
            this.b = str;
            this.c = str2;
            this.a = ahVar;
            if (ahVar != null) {
                ahVar.k = Build.MODEL;
                ahVar.q = Build.VERSION.RELEASE;
                ahVar.o = bh.a(BdBaseApplication.getInst());
                this.a.p = String.valueOf(pi.I());
            }
            try {
                MessageManager.getInstance().registerListener(this.e);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.d == null) {
                this.d = new b(this, null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
                BdBaseApplication.getInst().registerReceiver(this.d, intentFilter);
            }
        }
    }

    public void o(String str) {
        ah ahVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || (ahVar = this.a) == null) {
            return;
        }
        ahVar.g = str;
    }

    public void p(String str) {
        ah ahVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || (ahVar = this.a) == null) {
            return;
        }
        ahVar.h = str;
    }

    public void q(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, str, str2, str3) == null) {
            if (this.a.l == null && str == null) {
                return;
            }
            String str4 = this.a.l;
            if (str4 == null || !str4.equals(str)) {
                ah ahVar = this.a;
                ahVar.l = str;
                ahVar.m = str2;
                ahVar.n = str3;
            }
        }
    }

    public void r(gh ghVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, ghVar, str) == null) {
            new d(this, ghVar, str).execute(new Object[0]);
        }
    }

    public void s(gh ghVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, ghVar, str) == null) {
            new e(this, ghVar, str).execute(new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t(gh ghVar, boolean z, boolean z2, boolean z3) {
        ArrayList<String> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048590, this, new Object[]{ghVar, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) != null) || !BdStatisticsManager.getInstance().isMainProcess() || ghVar == null) {
            return;
        }
        ArrayList<String> n = nh.o().n(ghVar.o());
        ArrayList arrayList2 = null;
        if (!z) {
            boolean x = nh.o().x(ghVar.o(), null);
            boolean H = pi.H();
            if (x && !H) {
                return;
            }
            if (n != null && n.size() > 0) {
                arrayList = new ArrayList<>();
                Iterator<String> it = n.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!nh.o().u(ghVar.o(), next)) {
                        e(arrayList, next);
                    } else if (!nh.o().B(ghVar.o(), next)) {
                        e(arrayList, next);
                    } else {
                        boolean x2 = nh.o().x(ghVar.o(), next);
                        boolean H2 = pi.H();
                        if (x2 && !H2) {
                            e(arrayList, next);
                        }
                    }
                }
                if (ghVar.D()) {
                    ghVar.K(true);
                    if (arrayList != null && arrayList.size() > 0) {
                        arrayList2 = new ArrayList();
                        Iterator<String> it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            String next2 = it2.next();
                            try {
                                arrayList2.add("st=" + URLEncoder.encode(xg.i(next2), IMAudioTransRequest.CHARSET) + "&");
                            } catch (UnsupportedEncodingException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    new f(this, ghVar, arrayList2, z, z2, z3).execute(new Object[0]);
                    return;
                }
                return;
            }
        }
        arrayList = null;
        if (ghVar.D()) {
        }
    }

    public void u(gh ghVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, ghVar) == null) || ghVar.B()) {
            return;
        }
        ghVar.J(true);
        new c(this, ghVar).execute(new Object[0]);
    }
}
