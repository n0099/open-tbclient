package com.baidu.tieba;

import android.content.Context;
import android.os.AsyncTask;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class qf0 extends tf0 {
    public static /* synthetic */ Interceptable $ic;
    public static JSONObject h;
    public transient /* synthetic */ FieldHolder $fh;
    public sf0 c;
    public WeakReference d;
    public String e;
    public File f;
    public boolean g;

    /* loaded from: classes5.dex */
    public class a extends AsyncTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qf0 a;

        public a(qf0 qf0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qf0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qf0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                super.onPostExecute(bool);
                qf0 qf0Var = this.a;
                if (bool.booleanValue()) {
                    i = 2;
                } else {
                    i = 3;
                }
                qf0Var.d(i);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                if (qf0.h == null) {
                    qf0.h = new JSONObject();
                }
                if (this.a.f == null) {
                    try {
                        qf0.h.put("sdcardPath", StringUtil.NULL_STRING);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return Boolean.FALSE;
                } else if (!this.a.g && this.a.m()) {
                    try {
                        qf0.h.put("exist", true);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    return Boolean.TRUE;
                } else {
                    if (!this.a.f.isDirectory()) {
                        try {
                            qf0.h.put("file-del", true);
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                        this.a.f.delete();
                    }
                    File file = new File(this.a.f.getAbsoluteFile() + ".loading");
                    boolean a = this.a.c.a(this.a.e, file);
                    if (a) {
                        try {
                            qf0.h.put("assetsToSD", true);
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                        a = file.renameTo(this.a.f);
                    }
                    if (!a) {
                        try {
                            qf0.h.put("renameTo-del", true);
                        } catch (JSONException e5) {
                            e5.printStackTrace();
                        }
                        uf0.b(file);
                        if (this.a.f.exists()) {
                            uf0.b(this.a.f);
                        }
                    }
                    try {
                        qf0.h.put(TiebaStatic.LogFields.RESULT, a);
                    } catch (JSONException e6) {
                        e6.printStackTrace();
                    }
                    if (this.a.l()) {
                        yf0.a("ARSourceCopyManager", "sdk exist + " + qf0.h.toString());
                    }
                    return Boolean.valueOf(a);
                }
            }
            return (Boolean) invokeL.objValue;
        }
    }

    public qf0() {
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

    private Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            WeakReference weakReference = this.d;
            if (weakReference != null) {
                return (Context) weakReference.get();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c = new sf0(getContext());
            new a(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
        }
    }

    public final boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ve0.m();
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            File file = this.f;
            if (file != null && file.isDirectory() && this.f.exists()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tf0
    public void b() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean m = m();
            JSONObject jSONObject = new JSONObject();
            h = jSONObject;
            if (m) {
                try {
                    if (we0.a) {
                        str = "assets";
                    } else {
                        str = "soloader";
                    }
                    jSONObject.put("type", str);
                    h.put("exist", m);
                    h.put("path", this.f);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (l()) {
                    yf0.a("ARSourceCopyManager", "sdk exist + " + h.toString());
                }
                d(2);
            } else if (getContext() != null) {
                try {
                    if (l()) {
                        yf0.a("ARSourceCopyManager", "sdk loading .. to " + this.f.getAbsoluteFile());
                    }
                    k();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
