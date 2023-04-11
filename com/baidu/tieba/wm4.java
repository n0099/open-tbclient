package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.launched.LaunchedTaskSpeedStats;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.ubc.FlowInfoHelper;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.Closeable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SyntheticAccessor"})
/* loaded from: classes6.dex */
public class wm4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public final kn4 b;

    /* loaded from: classes6.dex */
    public class a extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long c;
        public final /* synthetic */ SparseIntArray d;
        public final /* synthetic */ String e;
        public final /* synthetic */ ArrayList f;
        public final /* synthetic */ boolean g;
        public final /* synthetic */ wm4 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(wm4 wm4Var, SparseIntArray sparseIntArray, String str, ArrayList arrayList, boolean z) {
            super(wm4Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wm4Var, sparseIntArray, str, arrayList, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((wm4) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = wm4Var;
            this.d = sparseIntArray;
            this.e = str;
            this.f = arrayList;
            this.g = z;
            this.c = System.currentTimeMillis();
        }

        @Override // com.baidu.tieba.wm4.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            ArrayList arrayList;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                SparseIntArray sparseIntArray = this.d;
                if (sparseIntArray != null && sparseIntArray.size() > 0) {
                    int size = this.d.size();
                    ArrayList arrayList2 = new ArrayList(size);
                    for (int i = 0; i < size; i++) {
                        arrayList2.add(Integer.valueOf(this.d.keyAt(i)));
                    }
                    String str = "flowhandle in (" + this.h.t(arrayList2) + SmallTailInfo.EMOTION_SUFFIX;
                    on4.a("delete flow table flow count:" + sQLiteDatabase.delete("flow", str, null));
                    on4.a("delete flow table event count:" + sQLiteDatabase.delete("event", str, null));
                }
                ArrayList arrayList3 = this.f;
                if (arrayList3 != null && arrayList3.size() > 0) {
                    int delete = sQLiteDatabase.delete("event", "eventid in (" + this.h.t(this.f) + ") AND flowhandle = -1", null);
                    StringBuilder sb = new StringBuilder();
                    sb.append("delete event table event count:");
                    sb.append(delete);
                    on4.a(sb.toString());
                }
                SparseIntArray sparseIntArray2 = this.d;
                if ((sparseIntArray2 != null && sparseIntArray2.size() > 0) || ((arrayList = this.f) != null && arrayList.size() > 0)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(BreakpointSQLiteKey.FILENAME, this.e);
                    String str2 = "0";
                    contentValues.put("state", "0");
                    if (this.g) {
                        str2 = "1";
                    }
                    contentValues.put("reserve1", str2);
                    sQLiteDatabase.replace("file", null, contentValues);
                }
                on4.a("delete total time:" + (System.currentTimeMillis() - this.c));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(wm4 wm4Var, String str, boolean z) {
            super(wm4Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wm4Var, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((wm4) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = str;
            this.d = z;
        }

        @Override // com.baidu.tieba.wm4.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                ContentValues contentValues = new ContentValues();
                String str = "1";
                contentValues.put("state", "1");
                contentValues.put(BreakpointSQLiteKey.FILENAME, this.c);
                if (!this.d) {
                    str = "0";
                }
                contentValues.put("reserve1", str);
                sQLiteDatabase.replace("file", null, contentValues);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(wm4 wm4Var, String str) {
            super(wm4Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wm4Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((wm4) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = str;
        }

        @Override // com.baidu.tieba.wm4.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                sQLiteDatabase.delete("file", "filename=\"" + this.c + "\"", null);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(wm4 wm4Var) {
            super(wm4Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wm4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((wm4) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.wm4.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                sQLiteDatabase.delete("file", null, null);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(wm4 wm4Var, String str) {
            super(wm4Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wm4Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((wm4) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = str;
        }

        @Override // com.baidu.tieba.wm4.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("state", "1");
                sQLiteDatabase.update("file", contentValues, "filename=\"" + this.c + "\"", null);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(wm4 wm4Var, String str, String str2) {
            super(wm4Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wm4Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((wm4) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = str;
            this.d = str2;
        }

        @Override // com.baidu.tieba.wm4.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("state", this.d);
                sQLiteDatabase.update("file", contentValues, "filename=\"" + this.c + "\"", null);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(wm4 wm4Var) {
            super(wm4Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wm4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((wm4) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.wm4.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("state", "1");
                sQLiteDatabase.update("file", contentValues, null, null);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class h extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ ContentValues f;
        public final /* synthetic */ wm4 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(wm4 wm4Var, String str, String str2, int i, ContentValues contentValues) {
            super(wm4Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wm4Var, str, str2, Integer.valueOf(i), contentValues};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((wm4) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = wm4Var;
            this.c = str;
            this.d = str2;
            this.e = i;
            this.f = contentValues;
        }

        @Override // com.baidu.tieba.wm4.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                if (!this.g.e(this.c, this.d, this.e, sQLiteDatabase) || sQLiteDatabase.insert("event", null, this.f) == -1) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class i extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List c;
        public final /* synthetic */ wm4 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(wm4 wm4Var, List list) {
            super(wm4Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wm4Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((wm4) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = wm4Var;
            this.c = list;
        }

        @Override // com.baidu.tieba.wm4.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                boolean z = true;
                for (en4 en4Var : this.c) {
                    if (!TextUtils.isEmpty(en4Var.a) && this.d.e(en4Var.b, en4Var.a, en4Var.c, sQLiteDatabase)) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("flowhandle", Integer.valueOf(en4Var.c));
                        contentValues.put("eventid", en4Var.a);
                        contentValues.put("begintime", Long.valueOf(en4Var.f));
                        if (!TextUtils.isEmpty(en4Var.d)) {
                            contentValues.put("content", en4Var.d);
                        } else {
                            JSONObject jSONObject = en4Var.e;
                            if (jSONObject != null && !TextUtils.isEmpty(jSONObject.toString())) {
                                contentValues.put("content", en4Var.e.toString());
                            }
                        }
                        contentValues.put("reserve1", en4Var.h);
                        if (!TextUtils.isEmpty(en4Var.i)) {
                            contentValues.put("reserve2", en4Var.i);
                        }
                        if (en4Var.j) {
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("ctr", "1");
                                contentValues.put("extend", jSONObject2.toString());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        if (sQLiteDatabase.insert("event", null, contentValues) < 0) {
                            z = false;
                        }
                    }
                }
                return z;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class j extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ContentValues c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(wm4 wm4Var, ContentValues contentValues) {
            super(wm4Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wm4Var, contentValues};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((wm4) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = contentValues;
        }

        @Override // com.baidu.tieba.wm4.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                if (sQLiteDatabase.insert("flow", null, this.c) != -1) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class k extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ContentValues c;
        public final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(wm4 wm4Var, ContentValues contentValues, String str) {
            super(wm4Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wm4Var, contentValues, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((wm4) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = contentValues;
            this.d = str;
        }

        @Override // com.baidu.tieba.wm4.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                if (sQLiteDatabase.update("flow", this.c, this.d, null) == 1) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class l extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ContentValues c;
        public final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(wm4 wm4Var, ContentValues contentValues, String str) {
            super(wm4Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wm4Var, contentValues, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((wm4) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = contentValues;
            this.d = str;
        }

        @Override // com.baidu.tieba.wm4.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                if (sQLiteDatabase.update("flow", this.c, this.d, null) == 1) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class m extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(wm4 wm4Var, String str, int i) {
            super(wm4Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wm4Var, str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((wm4) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = str;
            this.d = i;
        }

        @Override // com.baidu.tieba.wm4.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                sQLiteDatabase.delete("flow", this.c, null);
                sQLiteDatabase.delete("event", "flowhandle = " + this.d, null);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class n extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wm4 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(wm4 wm4Var) {
            super(wm4Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wm4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((wm4) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = wm4Var;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:13:0x00a5 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x00b6 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x007e */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00c0 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00c1  */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v15 */
        /* JADX WARN: Type inference failed for: r0v16 */
        /* JADX WARN: Type inference failed for: r0v17, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r0v21, types: [android.database.Cursor] */
        /* JADX WARN: Type inference failed for: r0v22 */
        /* JADX WARN: Type inference failed for: r0v23 */
        /* JADX WARN: Type inference failed for: r0v24 */
        /* JADX WARN: Type inference failed for: r9v0, types: [android.database.sqlite.SQLiteDatabase, java.lang.Object] */
        @Override // com.baidu.tieba.wm4.q
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            boolean moveToNext;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                long currentTimeMillis = System.currentTimeMillis() - zm4.g().e();
                Closeable closeable = null;
                wm4.x(currentTimeMillis, sQLiteDatabase.delete("flow", "endtime < " + currentTimeMillis, null), "flow");
                wm4.x(currentTimeMillis, sQLiteDatabase.delete("event", "begintime < " + currentTimeMillis, null), "event");
                String str = "SELECT flowhandle FROM flow WHERE begintime < " + (System.currentTimeMillis() - 86400000) + " AND endtime is NULL  AND " + SpeedStatsUtils.UBC_KEY_OPTION + " = 0";
                ArrayList arrayList = new ArrayList();
                try {
                    try {
                        str = sQLiteDatabase.rawQuery(str, null);
                    } catch (Throwable th) {
                        th = th;
                        closeable = str;
                        yn4.d(closeable);
                        throw th;
                    }
                } catch (SQLiteFullException unused) {
                    str = 0;
                } catch (RuntimeException e) {
                    e = e;
                    str = 0;
                } catch (Throwable th2) {
                    th = th2;
                    yn4.d(closeable);
                    throw th;
                }
                if (str != 0) {
                    try {
                        int count = str.getCount();
                        str = str;
                        if (count > 0) {
                            str.moveToFirst();
                            do {
                                arrayList.add(Integer.valueOf(str.getInt(str.getColumnIndex("flowhandle"))));
                                moveToNext = str.moveToNext();
                                str = str;
                            } while (moveToNext);
                        }
                    } catch (SQLiteFullException unused2) {
                    } catch (RuntimeException e2) {
                        e = e2;
                        e.printStackTrace();
                        str = str;
                        yn4.d(str);
                        if (arrayList.size() != 0) {
                        }
                    }
                }
                yn4.d(str);
                if (arrayList.size() != 0) {
                    return true;
                }
                String str2 = "flowhandle in (" + this.c.t(arrayList) + SmallTailInfo.EMOTION_SUFFIX;
                sQLiteDatabase.delete("flow", str2, null);
                sQLiteDatabase.delete("event", str2, null);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class o extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(wm4 wm4Var, String str, int i) {
            super(wm4Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wm4Var, str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((wm4) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = str;
            this.d = i;
        }

        @Override // com.baidu.tieba.wm4.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                String str = this.c;
                int delete = sQLiteDatabase.delete(str, "_id < " + this.d, null);
                an4.h("23", "delLimit");
                if (delete > 0) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class p extends q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(wm4 wm4Var, List list) {
            super(wm4Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wm4Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((wm4) objArr2[0], (h) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = list;
        }

        @Override // com.baidu.tieba.wm4.q
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sQLiteDatabase)) == null) {
                for (cn4 cn4Var : this.c) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("eventid", cn4Var.a);
                    contentValues.put("type", cn4Var.e);
                    if ("1".equals(cn4Var.c)) {
                        i = 0;
                    } else {
                        i = cn4Var.d;
                    }
                    contentValues.put("cycle", Integer.valueOf(i));
                    contentValues.put(SetImageWatermarkTypeReqMsg.SWITCH, cn4Var.b);
                    contentValues.put("reserve1", cn4Var.f);
                    if (!TextUtils.isEmpty(cn4Var.h)) {
                        contentValues.put("reserve2", cn4Var.h);
                    }
                    contentValues.put("sample", Integer.valueOf(cn4Var.g));
                    int i2 = cn4Var.i;
                    if (i2 != 0 && cn4Var.j != 0) {
                        contentValues.put("recordrule", Integer.valueOf(i2));
                        contentValues.put("uploadrule", Integer.valueOf(cn4Var.j));
                    }
                    if (TextUtils.equals(cn4Var.k, "1")) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(Constant.ID_TYPE, "1");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        contentValues.put("extend", jSONObject.toString());
                    }
                    sQLiteDatabase.replace("config", null, contentValues);
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public abstract class q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ wm4 b;

        public abstract boolean b(SQLiteDatabase sQLiteDatabase);

        public q(wm4 wm4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wm4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wm4Var;
            this.a = false;
        }

        public /* synthetic */ q(wm4 wm4Var, h hVar) {
            this(wm4Var);
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.booleanValue;
        }

        public void c(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase) != null) || sQLiteDatabase == null) {
                return;
            }
            this.a = false;
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    if (b(sQLiteDatabase)) {
                        sQLiteDatabase.setTransactionSuccessful();
                        this.a = true;
                    }
                } catch (RuntimeException e) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "DBError");
                        jSONObject.put("db_size", this.b.o());
                        jSONObject.put("db_log_size", this.b.n());
                        jSONObject.put("exception", Log.getStackTraceString(e));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    an4.h("23", jSONObject.toString());
                }
                try {
                    sQLiteDatabase.endTransaction();
                } catch (RuntimeException unused) {
                }
            } catch (Throwable th) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (RuntimeException unused2) {
                }
                throw th;
            }
        }
    }

    public wm4(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new kn4(context);
    }

    public final String t(ArrayList arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, arrayList)) == null) {
            StringBuilder sb = new StringBuilder();
            Iterator it = arrayList.iterator();
            String str = "";
            while (it.hasNext()) {
                Object next = it.next();
                sb.append(str);
                sb.append(next);
                str = ",";
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void A(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            new b(this, str, z).c(this.b.getWritableDatabase());
        }
    }

    public void G(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            new f(this, str, str2).c(this.b.getWritableDatabase());
        }
    }

    public static void x(long j2, int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), str}) == null) && i2 > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "expire");
                jSONObject.put("ubc_type", str);
                jSONObject.put(PushConstants.REGISTER_STATUS_EXPIRE_TIME, j2);
                jSONObject.put("count", i2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            an4.h("23", jSONObject.toString());
        }
    }

    public void E(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048580, this, str, i2, str2) == null) && i2 >= 0 && !TextUtils.isEmpty(str)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("content", str2);
            new k(this, contentValues, "flowid=\"" + str + "\" AND flowhandle = " + i2).c(this.b.getWritableDatabase());
        }
    }

    public void B(gn4 gn4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gn4Var) == null) && gn4Var != null && !TextUtils.isEmpty(gn4Var.a)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("flowid", gn4Var.a);
            contentValues.put("flowhandle", Integer.valueOf(gn4Var.b));
            contentValues.put("state", gn4Var.h);
            contentValues.put("begintime", Long.valueOf(gn4Var.e));
            JSONObject jSONObject = gn4Var.d;
            if (jSONObject != null) {
                contentValues.put("content", jSONObject.toString());
            } else {
                contentValues.put("content", gn4Var.c);
            }
            contentValues.put(SpeedStatsUtils.UBC_KEY_OPTION, Integer.valueOf(gn4Var.g));
            contentValues.put("reserve1", gn4Var.i);
            if (!TextUtils.isEmpty(gn4Var.j)) {
                contentValues.put("reserve2", gn4Var.j);
            }
            if (gn4Var.l) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("ctr", "1");
                    contentValues.put("extend", jSONObject2.toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            new j(this, contentValues).c(this.b.getWritableDatabase());
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x0058 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x0023 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8, types: [android.database.Cursor] */
    public fn4 u(String str) {
        InterceptResult invokeL;
        Closeable closeable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            String str2 = "SELECT state , reserve1 FROM file WHERE filename=\"" + str + "\"";
            Closeable closeable2 = null;
            r3 = null;
            r3 = null;
            fn4 fn4Var = null;
            try {
                try {
                    str2 = this.b.getReadableDatabase().rawQuery(str2, null);
                    closeable = str2;
                    if (str2 != 0) {
                        try {
                            int count = str2.getCount();
                            closeable = str2;
                            if (count > 0) {
                                str2.moveToFirst();
                                String string = str2.getString(str2.getColumnIndex("state"));
                                String str3 = "";
                                if (!str2.isNull(str2.getColumnIndex("reserve1"))) {
                                    str3 = str2.getString(str2.getColumnIndex("reserve1"));
                                }
                                fn4Var = new fn4(str, string, str3);
                                closeable = str2;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("type", "DBError");
                                jSONObject.put("exception", Log.getStackTraceString(e));
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                            an4.h("23", jSONObject.toString());
                            closeable = str2;
                            yn4.d(closeable);
                            return fn4Var;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    closeable2 = str2;
                    yn4.d(closeable2);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                str2 = 0;
            } catch (Throwable th2) {
                th = th2;
                yn4.d(closeable2);
                throw th;
            }
            yn4.d(closeable);
            return fn4Var;
        }
        return (fn4) invokeL.objValue;
    }

    public void y(en4 en4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, en4Var) == null) && en4Var != null && !TextUtils.isEmpty(en4Var.a)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("flowhandle", Integer.valueOf(en4Var.c));
            contentValues.put("eventid", en4Var.a);
            contentValues.put("begintime", Long.valueOf(en4Var.f));
            JSONObject jSONObject = en4Var.e;
            if (jSONObject != null) {
                contentValues.put("content", jSONObject.toString());
            } else {
                contentValues.put("content", en4Var.d);
            }
            contentValues.put("reserve1", en4Var.h);
            if (!TextUtils.isEmpty(en4Var.i)) {
                contentValues.put("reserve2", en4Var.i);
            }
            if (en4Var.j) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("ctr", "1");
                    contentValues.put("extend", jSONObject2.toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            new h(this, en4Var.b, en4Var.a, en4Var.c, contentValues).c(this.b.getWritableDatabase());
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            new g(this).c(this.b.getWritableDatabase());
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            new n(this).c(this.b.getWritableDatabase());
            k("flow");
            k("event");
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            new d(this).c(this.b.getWritableDatabase());
        }
    }

    public final long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.b.e();
        }
        return invokeV.longValue;
    }

    public final long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.b.f();
        }
        return invokeV.longValue;
    }

    public void D(List<cn4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, list) == null) && list != null && list.size() != 0) {
            new p(this, list).c(this.b.getWritableDatabase());
        }
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            new e(this, str).c(this.b.getWritableDatabase());
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            new c(this, str).c(this.b.getWritableDatabase());
        }
    }

    public int l(qn4 qn4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, qn4Var)) == null) {
            this.a = 0L;
            int q2 = q(" SELECT * FROM flow", qn4Var);
            if (this.a >= 2097152) {
                return 1;
            }
            return p("SELECT * FROM event WHERE flowhandle = -1", qn4Var) | q2;
        }
        return invokeL.intValue;
    }

    public void z(List<en4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, list) == null) && list != null && list.size() != 0) {
            new i(this, list).c(this.b.getWritableDatabase());
        }
    }

    public void d(String str, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048583, this, str, i2) == null) && i2 >= 0 && !TextUtils.isEmpty(str)) {
            new m(this, "flowid=\"" + str + "\" AND flowhandle = " + i2, i2).c(this.b.getWritableDatabase());
        }
    }

    public final String s(ArrayList<bn4> arrayList, boolean z) {
        InterceptResult invokeLZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048598, this, arrayList, z)) == null) {
            StringBuilder sb = new StringBuilder();
            Iterator<bn4> it = arrayList.iterator();
            String str = "";
            while (it.hasNext()) {
                bn4 next = it.next();
                if ((z && !"0".equals(next.b)) || (!z && "0".equals(next.b))) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    sb.append(str);
                    sb.append(next.a);
                    str = ",";
                }
            }
            return sb.toString();
        }
        return (String) invokeLZ.objValue;
    }

    public final boolean e(String str, String str2, int i2, SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, i2, sQLiteDatabase)) == null) {
            boolean equals = str.equals(str2);
            boolean z = false;
            if (!equals) {
                Cursor cursor = null;
                try {
                    try {
                        cursor = sQLiteDatabase.rawQuery("SELECT state FROM flow WHERE flowhandle = " + i2, null);
                        if (cursor != null && cursor.getCount() > 0) {
                            cursor.moveToFirst();
                            String string = cursor.getString(0);
                            if (!TextUtils.isEmpty(string)) {
                                if ("1".equals(string)) {
                                    z = true;
                                }
                            }
                        }
                    } catch (SQLiteFullException unused) {
                    } catch (RuntimeException e2) {
                        e2.printStackTrace();
                    }
                    return z;
                } finally {
                    yn4.d(cursor);
                }
            }
            return true;
        }
        return invokeLLIL.booleanValue;
    }

    public boolean g(SparseIntArray sparseIntArray, ArrayList<String> arrayList, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{sparseIntArray, arrayList, Boolean.valueOf(z), str})) == null) {
            a aVar = new a(this, sparseIntArray, str, arrayList, z);
            aVar.c(this.b.getWritableDatabase());
            return aVar.a();
        }
        return invokeCommon.booleanValue;
    }

    public void j(String str, int i2, long j2, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, Integer.valueOf(i2), Long.valueOf(j2), jSONArray}) == null) && i2 >= 0 && !TextUtils.isEmpty(str)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", "2");
            contentValues.put("endtime", Long.valueOf(j2));
            if (jSONArray != null && jSONArray.length() > 0) {
                contentValues.put("slot", jSONArray.toString());
            }
            new l(this, contentValues, "flowid=\"" + str + "\" AND flowhandle = " + i2).c(this.b.getWritableDatabase());
        }
    }

    public final void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
            int i2 = 0;
            Cursor cursor = null;
            try {
                try {
                    cursor = writableDatabase.rawQuery("SELECT COUNT(*), MIN(_id), MAX(_id)  FROM " + str, null);
                    if (cursor != null && cursor.getCount() > 0) {
                        cursor.moveToFirst();
                        if (cursor.getInt(0) > zm4.g().f()) {
                            i2 = (cursor.getInt(1) + cursor.getInt(2)) / 2;
                        }
                    }
                } catch (SQLiteFullException unused) {
                } catch (RuntimeException e2) {
                    e2.printStackTrace();
                }
                if (i2 > 0) {
                    new o(this, str, i2).c(writableDatabase);
                }
            } finally {
                yn4.d(cursor);
            }
        }
    }

    public void v(SparseArray<ArrayList> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, sparseArray) == null) {
            Cursor cursor = null;
            try {
                try {
                    cursor = this.b.getReadableDatabase().rawQuery("SELECT eventid , type , cycle FROM config WHERE switch=\"1\"", null);
                    if (cursor != null && cursor.getCount() > 0) {
                        cursor.moveToFirst();
                        int columnIndex = cursor.getColumnIndex("eventid");
                        int columnIndex2 = cursor.getColumnIndex("type");
                        int columnIndex3 = cursor.getColumnIndex("cycle");
                        do {
                            String string = cursor.getString(columnIndex);
                            String string2 = cursor.getString(columnIndex2);
                            int i2 = cursor.getInt(columnIndex3);
                            if (i2 != 0) {
                                if (i2 < 6) {
                                    i2 = 6;
                                } else if (i2 > 720) {
                                    i2 = 720;
                                }
                            }
                            if (string != null) {
                                ArrayList arrayList = sparseArray.get(i2);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    sparseArray.put(i2, arrayList);
                                }
                                arrayList.add(new bn4(string, string2));
                            }
                        } while (cursor.moveToNext());
                    }
                } catch (RuntimeException e2) {
                    e2.printStackTrace();
                }
            } finally {
                yn4.d(cursor);
            }
        }
    }

    public int m(ArrayList<bn4> arrayList, qn4 qn4Var) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, arrayList, qn4Var)) == null) {
            this.a = 0L;
            String s = s(arrayList, true);
            if (!TextUtils.isEmpty(s)) {
                i2 = q("SELECT *  FROM flow WHERE flowid in (" + s + SmallTailInfo.EMOTION_SUFFIX, qn4Var);
            } else {
                i2 = 0;
            }
            String s2 = s(arrayList, false);
            if (!TextUtils.isEmpty(s2)) {
                return i2 | p("SELECT *  FROM event WHERE eventid in (" + s2 + ") AND flowhandle = -1", qn4Var);
            }
            return i2;
        }
        return invokeLL.intValue;
    }

    public final int p(String str, qn4 qn4Var) {
        InterceptResult invokeLL;
        qn4 qn4Var2;
        long j2;
        long j3;
        int i2;
        int i3;
        String str2;
        long j4;
        int i4;
        String string;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, str, qn4Var)) == null) {
            qn4 qn4Var3 = qn4Var;
            String str3 = "content";
            Cursor cursor = null;
            long j5 = Long.MAX_VALUE;
            try {
                try {
                    cursor = this.b.getReadableDatabase().rawQuery(str, null);
                    if (cursor != null && cursor.getCount() > 0) {
                        cursor.moveToFirst();
                        int columnIndex = cursor.getColumnIndex("eventid");
                        int columnIndex2 = cursor.getColumnIndex("begintime");
                        int columnIndex3 = cursor.getColumnIndex("content");
                        int columnIndex4 = cursor.getColumnIndex("reserve1");
                        int columnIndex5 = cursor.getColumnIndex("reserve2");
                        int columnIndex6 = cursor.getColumnIndex("extend");
                        j2 = 0;
                        while (true) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                String string2 = cursor.getString(columnIndex3);
                                int i6 = columnIndex3;
                                int i7 = columnIndex6;
                                if (!TextUtils.isEmpty(string2)) {
                                    try {
                                        JSONObject jSONObject2 = new JSONObject(string2);
                                        if (jSONObject2.has("bizId")) {
                                            JSONObject jSONObject3 = jSONObject2.getJSONObject(str3);
                                            i3 = columnIndex5;
                                            JSONObject jSONObject4 = jSONObject2.getJSONObject(DI.APP_INFO_NAME);
                                            if (jSONObject3 != null && jSONObject4 != null) {
                                                jSONObject3.put(DI.APP_INFO_NAME, jSONObject4);
                                                jSONObject2.remove(DI.APP_INFO_NAME);
                                            }
                                            jSONObject = jSONObject2;
                                        } else {
                                            i3 = columnIndex5;
                                            jSONObject.put(str3, jSONObject2);
                                        }
                                        str2 = str3;
                                        this.a += string2.getBytes("UTF-8").length;
                                    } catch (SQLiteFullException | UnsupportedEncodingException | JSONException unused) {
                                        qn4Var2 = qn4Var;
                                        yn4.d(cursor);
                                        j3 = j2;
                                        i2 = 0;
                                        qn4Var2.g(j5, j3);
                                        return i2;
                                    } catch (RuntimeException e2) {
                                        e = e2;
                                        qn4Var2 = qn4Var;
                                        e.printStackTrace();
                                        yn4.d(cursor);
                                        j3 = j2;
                                        i2 = 0;
                                        qn4Var2.g(j5, j3);
                                        return i2;
                                    }
                                } else {
                                    i3 = columnIndex5;
                                    str2 = str3;
                                }
                                String string3 = cursor.getString(columnIndex);
                                jSONObject.put("bizId", string3);
                                long j6 = cursor.getLong(columnIndex2);
                                jSONObject.put("timestamp", Long.toString(j6));
                                if (j6 > 0) {
                                    if (j6 < j5) {
                                        j5 = j6;
                                    }
                                    if (j6 > j2) {
                                        j2 = j6;
                                    }
                                }
                                try {
                                    try {
                                        jSONObject.put("eventType", "0");
                                        String string4 = cursor.getString(columnIndex4);
                                        if (!TextUtils.isEmpty(string4)) {
                                            jSONObject.put("abtest", string4);
                                            qn4Var2 = qn4Var;
                                            try {
                                                qn4Var2.f = "1";
                                                j4 = j5;
                                                try {
                                                    i4 = columnIndex2;
                                                    this.a += string4.getBytes("UTF-8").length;
                                                } catch (SQLiteFullException | UnsupportedEncodingException | JSONException unused2) {
                                                    j5 = j4;
                                                    yn4.d(cursor);
                                                    j3 = j2;
                                                    i2 = 0;
                                                    qn4Var2.g(j5, j3);
                                                    return i2;
                                                } catch (RuntimeException e3) {
                                                    e = e3;
                                                    j5 = j4;
                                                    e.printStackTrace();
                                                    yn4.d(cursor);
                                                    j3 = j2;
                                                    i2 = 0;
                                                    qn4Var2.g(j5, j3);
                                                    return i2;
                                                }
                                            } catch (SQLiteFullException | UnsupportedEncodingException | JSONException unused3) {
                                                yn4.d(cursor);
                                                j3 = j2;
                                                i2 = 0;
                                                qn4Var2.g(j5, j3);
                                                return i2;
                                            } catch (RuntimeException e4) {
                                                e = e4;
                                                e.printStackTrace();
                                                yn4.d(cursor);
                                                j3 = j2;
                                                i2 = 0;
                                                qn4Var2.g(j5, j3);
                                                return i2;
                                            }
                                        } else {
                                            qn4Var2 = qn4Var;
                                            j4 = j5;
                                            i4 = columnIndex2;
                                        }
                                        int i8 = i3;
                                        if (!TextUtils.isEmpty(cursor.getString(i8))) {
                                            jSONObject.put("c", cursor.getString(i8));
                                        }
                                        if (!TextUtils.isEmpty(cursor.getString(i7))) {
                                            if (new JSONObject(cursor.getString(i7)).has("ctr")) {
                                                jSONObject.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
                                            }
                                            i5 = i7;
                                            this.a += string.getBytes("UTF-8").length;
                                        } else {
                                            i5 = i7;
                                        }
                                        jSONObject.put(Constant.ID_TYPE, zm4.g().j(string3));
                                        nn4.a(jSONObject);
                                        qn4Var2.a(jSONObject);
                                        qn4Var2.e(cursor.getString(columnIndex));
                                        if (this.a >= 2097152 || !cursor.moveToNext()) {
                                            break;
                                        }
                                        columnIndex3 = i6;
                                        qn4Var3 = qn4Var2;
                                        columnIndex6 = i5;
                                        j5 = j4;
                                        columnIndex2 = i4;
                                        String str4 = str2;
                                        columnIndex5 = i8;
                                        str3 = str4;
                                    } catch (SQLiteFullException | UnsupportedEncodingException unused4) {
                                        qn4Var2 = qn4Var;
                                    }
                                } catch (RuntimeException e5) {
                                    e = e5;
                                    qn4Var2 = qn4Var;
                                } catch (JSONException unused5) {
                                    qn4Var2 = qn4Var;
                                }
                            } catch (SQLiteFullException | UnsupportedEncodingException | JSONException unused6) {
                                qn4Var2 = qn4Var3;
                            } catch (RuntimeException e6) {
                                e = e6;
                                qn4Var2 = qn4Var3;
                            }
                        }
                        i2 = 1;
                        j5 = j4;
                    } else {
                        qn4Var2 = qn4Var3;
                        j2 = 0;
                        i2 = 0;
                    }
                    yn4.d(cursor);
                    j3 = j2;
                } catch (Throwable th) {
                    yn4.d(null);
                    throw th;
                }
            } catch (SQLiteFullException | UnsupportedEncodingException | JSONException unused7) {
                qn4Var2 = qn4Var3;
                j2 = 0;
            } catch (RuntimeException e7) {
                e = e7;
                qn4Var2 = qn4Var3;
                j2 = 0;
            }
            qn4Var2.g(j5, j3);
            return i2;
        }
        return invokeLL.intValue;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:75:0x01bf
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public final int q(java.lang.String r30, com.baidu.tieba.qn4 r31) {
        /*
            r29 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.wm4.$ic
            if (r0 != 0) goto L20b
        L4:
            r1 = r29
            r2 = r31
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            com.baidu.tieba.kn4 r0 = r1.b
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()
            r4 = 0
            r10 = r30
            android.database.Cursor r4 = r0.rawQuery(r10, r4)     // Catch: java.lang.Throwable -> L1d9 java.lang.RuntimeException -> L1db java.lang.Throwable -> L1ee
            if (r4 == 0) goto L1c8
            int r0 = r4.getCount()     // Catch: java.lang.Throwable -> L1d9 java.lang.RuntimeException -> L1db java.lang.Throwable -> L1ee
            if (r0 <= 0) goto L1c8
            r4.moveToFirst()     // Catch: java.lang.Throwable -> L1d9 java.lang.RuntimeException -> L1db java.lang.Throwable -> L1ee
            java.lang.String r0 = "flowid"
            int r11 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d9 java.lang.RuntimeException -> L1db java.lang.Throwable -> L1ee
            java.lang.String r0 = "flowhandle"
            int r12 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d9 java.lang.RuntimeException -> L1db java.lang.Throwable -> L1ee
            java.lang.String r0 = "state"
            int r13 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d9 java.lang.RuntimeException -> L1db java.lang.Throwable -> L1ee
            java.lang.String r0 = "begintime"
            int r14 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d9 java.lang.RuntimeException -> L1db java.lang.Throwable -> L1ee
            java.lang.String r0 = "endtime"
            int r15 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d9 java.lang.RuntimeException -> L1db java.lang.Throwable -> L1ee
            java.lang.String r0 = "content"
            int r7 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d9 java.lang.RuntimeException -> L1db java.lang.Throwable -> L1ee
            java.lang.String r0 = "option"
            int r8 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d9 java.lang.RuntimeException -> L1db java.lang.Throwable -> L1ee
            java.lang.String r0 = "reserve1"
            int r9 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d9 java.lang.RuntimeException -> L1db java.lang.Throwable -> L1ee
            java.lang.String r0 = "reserve2"
            int r10 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d9 java.lang.RuntimeException -> L1db java.lang.Throwable -> L1ee
            java.lang.String r0 = "slot"
            int r5 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d9 java.lang.RuntimeException -> L1db java.lang.Throwable -> L1ee
            java.lang.String r0 = "extend"
            int r6 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L1d9 java.lang.RuntimeException -> L1db java.lang.Throwable -> L1ee
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r20 = 0
        L70:
            java.lang.String r0 = "2"
            java.lang.String r2 = r4.getString(r13)     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            boolean r0 = r0.equals(r2)     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            if (r0 != 0) goto Lac
            long r22 = r4.getLong(r14)     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            long r24 = java.lang.System.currentTimeMillis()     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            long r22 = r22 - r24
            long r22 = java.lang.Math.abs(r22)     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            r24 = 86400000(0x5265c00, double:4.2687272E-316)
            int r0 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1))
            if (r0 <= 0) goto L9a
            int r0 = r4.getInt(r8)     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            r0 = r0 & 4
            if (r0 == 0) goto L9a
            goto Lac
        L9a:
            r24 = r8
            r22 = r11
            r23 = r12
            r25 = r13
            r26 = r14
            r18 = 0
            r8 = r31
            r11 = r7
            r7 = 1
            goto L19f
        Lac:
            com.baidu.tieba.gn4 r2 = new com.baidu.tieba.gn4     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            r2.<init>()     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            java.lang.String r0 = r4.getString(r11)     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            r2.a = r0     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            int r0 = r4.getInt(r12)     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            r2.b = r0     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            r22 = r11
            r23 = r12
            long r11 = r4.getLong(r14)     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            r2.e = r11     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            long r11 = r4.getLong(r15)     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            r2.f = r11     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            r18 = 0
            int r0 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r0 <= 0) goto Ld9
            int r0 = (r11 > r20 ? 1 : (r11 == r20 ? 0 : -1))
            if (r0 <= 0) goto Ld9
            r20 = r11
        Ld9:
            long r11 = r2.e     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            r18 = 0
            int r0 = (r11 > r18 ? 1 : (r11 == r18 ? 0 : -1))
            if (r0 <= 0) goto Leb
            long r11 = r2.e     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            int r0 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r0 >= 0) goto Leb
            long r11 = r2.e     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            r16 = r11
        Leb:
            java.lang.String r0 = r4.getString(r7)     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            boolean r11 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            java.lang.String r12 = "UTF-8"
            if (r11 != 0) goto L105
            r2.c = r0     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            byte[] r0 = r0.getBytes(r12)     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            int r0 = r0.length     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            r11 = r7
            r24 = r8
            long r7 = (long) r0     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            r1.a = r7     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            goto L108
        L105:
            r11 = r7
            r24 = r8
        L108:
            java.lang.String r0 = r4.getString(r9)     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            if (r7 != 0) goto L124
            r2.i = r0     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            long r7 = r1.a     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            byte[] r0 = r0.getBytes(r12)     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            int r0 = r0.length     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            r25 = r13
            r26 = r14
            long r13 = (long) r0     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            long r7 = r7 + r13
            r1.a = r7     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            goto L128
        L124:
            r25 = r13
            r26 = r14
        L128:
            java.lang.String r0 = r4.getString(r10)     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            if (r0 != 0) goto L138
            java.lang.String r0 = r4.getString(r10)     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            r2.j = r0     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
        L138:
            java.lang.String r0 = r4.getString(r5)     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            if (r5 < 0) goto L152
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            if (r7 != 0) goto L152
            r2.b(r0)     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            long r7 = r1.a     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            byte[] r0 = r0.getBytes(r12)     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            int r0 = r0.length     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            long r13 = (long) r0     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            long r7 = r7 + r13
            r1.a = r7     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
        L152:
            java.lang.String r0 = r4.getString(r6)     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            if (r7 != 0) goto L184
            long r7 = r1.a     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            byte[] r0 = r0.getBytes(r12)     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            int r0 = r0.length     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            long r12 = (long) r0     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            long r7 = r7 + r12
            r1.a = r7     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L17e java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            java.lang.String r7 = r4.getString(r6)     // Catch: org.json.JSONException -> L17e java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            r0.<init>(r7)     // Catch: org.json.JSONException -> L17e java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            java.lang.String r7 = "ctr"
            boolean r0 = r0.has(r7)     // Catch: org.json.JSONException -> L17e java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            if (r0 == 0) goto L184
            r7 = 1
            r2.l = r7     // Catch: org.json.JSONException -> L17c java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            goto L185
        L17c:
            r0 = move-exception
            goto L180
        L17e:
            r0 = move-exception
            r7 = 1
        L180:
            r0.printStackTrace()     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            goto L185
        L184:
            r7 = 1
        L185:
            r3.add(r2)     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            int r0 = r2.b     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            java.lang.String r2 = r2.a     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.RuntimeException -> L1b8 java.lang.Throwable -> L1bc java.lang.Throwable -> L1d9
            r8 = r31
            r8.f(r0, r2)     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1c5 java.lang.Throwable -> L1d9
            long r12 = r1.a     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1c5 java.lang.Throwable -> L1d9
            r27 = 2097152(0x200000, double:1.036131E-317)
            int r0 = (r12 > r27 ? 1 : (r12 == r27 ? 0 : -1))
            if (r0 < 0) goto L19f
            goto L1a5
        L19f:
            boolean r0 = r4.moveToNext()     // Catch: java.lang.RuntimeException -> L1b6 java.lang.Throwable -> L1c5 java.lang.Throwable -> L1d9
            if (r0 != 0) goto L1a8
        L1a5:
            r5 = r20
            goto L1d3
        L1a8:
            r2 = r8
            r7 = r11
            r11 = r22
            r12 = r23
            r8 = r24
            r13 = r25
            r14 = r26
            goto L70
        L1b6:
            r0 = move-exception
            goto L1c1
        L1b8:
            r0 = move-exception
            r8 = r31
            goto L1c1
        L1bc:
            r8 = r31
            goto L1c5
        L1bf:
            r0 = move-exception
            r8 = r2
        L1c1:
            r5 = r20
            goto L1e6
        L1c4:
            r8 = r2
        L1c5:
            r5 = r20
            goto L1f8
        L1c8:
            r8 = r2
            r18 = 0
            r5 = r18
            r7 = 0
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L1d3:
            com.baidu.tieba.yn4.d(r4)
            r9 = r16
            goto L1fe
        L1d9:
            r0 = move-exception
            goto L1ea
        L1db:
            r0 = move-exception
            r8 = r2
            r18 = 0
            r5 = r18
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L1e6:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L1d9
            goto L1f8
        L1ea:
            com.baidu.tieba.yn4.d(r4)
            throw r0
        L1ee:
            r8 = r2
            r18 = 0
            r5 = r18
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L1f8:
            com.baidu.tieba.yn4.d(r4)
            r9 = r16
            r7 = 0
        L1fe:
            int r0 = r3.size()
            if (r0 <= 0) goto L207
            r1.r(r3, r8)
        L207:
            r8.g(r9, r5)
            return r7
        L20b:
            r27 = r0
            r28 = 1048596(0x100014, float:1.469396E-39)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r27.invokeLL(r28, r29, r30, r31)
            if (r0 == 0) goto L4
            int r1 = r0.intValue
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.wm4.q(java.lang.String, com.baidu.tieba.qn4):int");
    }

    public final void r(ArrayList<gn4> arrayList, qn4 qn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, arrayList, qn4Var) == null) {
            JSONObject jSONObject = new JSONObject();
            SQLiteDatabase readableDatabase = this.b.getReadableDatabase();
            try {
                Iterator<gn4> it = arrayList.iterator();
                String[] strArr = null;
                Cursor cursor = null;
                while (it.hasNext()) {
                    gn4 next = it.next();
                    if (next.b >= 0) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("bizId", next.a);
                        jSONObject2.put(LaunchedTaskSpeedStats.KEY_START_TIME, Long.toString(next.e));
                        jSONObject2.put("endtime", Long.toString(next.f));
                        jSONObject2.put("eventType", "1");
                        if (!TextUtils.isEmpty(next.c)) {
                            jSONObject = new JSONObject(next.c);
                        }
                        if (!TextUtils.isEmpty(next.i)) {
                            jSONObject2.put("abtest", next.i);
                            qn4Var.f = "1";
                        }
                        if (!TextUtils.isEmpty(next.j)) {
                            jSONObject2.put("c", next.j);
                        }
                        if (next.k != null) {
                            jSONObject2.put("part", next.k);
                        }
                        if (next.l) {
                            jSONObject2.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
                        }
                        jSONObject2.put(Constant.ID_TYPE, zm4.g().j(next.a));
                        JSONArray jSONArray = new JSONArray();
                        try {
                            cursor = readableDatabase.rawQuery("SELECT eventid , begintime , content FROM event WHERE flowhandle = " + next.b, strArr);
                            if (cursor != null && cursor.getCount() > 0) {
                                cursor.moveToFirst();
                                int columnIndex = cursor.getColumnIndex("eventid");
                                int columnIndex2 = cursor.getColumnIndex("begintime");
                                int columnIndex3 = cursor.getColumnIndex("content");
                                while (true) {
                                    JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.put("id", cursor.getString(columnIndex));
                                    jSONObject3.put("timestamp", Long.toString(cursor.getLong(columnIndex2)));
                                    jSONObject3.put("content", cursor.getString(columnIndex3));
                                    jSONArray.put(jSONObject3);
                                    if (!cursor.moveToNext()) {
                                        break;
                                    }
                                }
                                jSONObject.put(FlowInfoHelper.KEY_EVENTLIST, jSONArray);
                            }
                        } catch (SQLiteFullException unused) {
                        } catch (Throwable th) {
                            yn4.d(cursor);
                            throw th;
                        }
                        yn4.d(cursor);
                        jSONObject2.put("content", jSONObject);
                        nn4.a(jSONObject2);
                        qn4Var.a(jSONObject2);
                    }
                    strArr = null;
                }
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            } catch (JSONException unused2) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x009a A[Catch: all -> 0x0108, RuntimeException -> 0x010a, SQLiteFullException -> 0x0113, TryCatch #5 {SQLiteFullException -> 0x0113, RuntimeException -> 0x010a, blocks: (B:8:0x0011, B:10:0x0017, B:12:0x001d, B:13:0x0020, B:17:0x0088, B:23:0x009a, B:25:0x00a2, B:27:0x00a8, B:30:0x00b2, B:32:0x00be, B:34:0x00c4, B:38:0x00d0, B:40:0x00dd, B:42:0x00e3, B:45:0x00f2, B:53:0x0101, B:51:0x00fb, B:19:0x008d, B:21:0x0094), top: B:73:0x0011, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a8 A[Catch: all -> 0x0108, RuntimeException -> 0x010a, SQLiteFullException -> 0x0113, TryCatch #5 {SQLiteFullException -> 0x0113, RuntimeException -> 0x010a, blocks: (B:8:0x0011, B:10:0x0017, B:12:0x001d, B:13:0x0020, B:17:0x0088, B:23:0x009a, B:25:0x00a2, B:27:0x00a8, B:30:0x00b2, B:32:0x00be, B:34:0x00c4, B:38:0x00d0, B:40:0x00dd, B:42:0x00e3, B:45:0x00f2, B:53:0x0101, B:51:0x00fb, B:19:0x008d, B:21:0x0094), top: B:73:0x0011, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b2 A[Catch: all -> 0x0108, RuntimeException -> 0x010a, SQLiteFullException -> 0x0113, TryCatch #5 {SQLiteFullException -> 0x0113, RuntimeException -> 0x010a, blocks: (B:8:0x0011, B:10:0x0017, B:12:0x001d, B:13:0x0020, B:17:0x0088, B:23:0x009a, B:25:0x00a2, B:27:0x00a8, B:30:0x00b2, B:32:0x00be, B:34:0x00c4, B:38:0x00d0, B:40:0x00dd, B:42:0x00e3, B:45:0x00f2, B:53:0x0101, B:51:0x00fb, B:19:0x008d, B:21:0x0094), top: B:73:0x0011, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c4 A[Catch: all -> 0x0108, RuntimeException -> 0x010a, SQLiteFullException -> 0x0113, TryCatch #5 {SQLiteFullException -> 0x0113, RuntimeException -> 0x010a, blocks: (B:8:0x0011, B:10:0x0017, B:12:0x001d, B:13:0x0020, B:17:0x0088, B:23:0x009a, B:25:0x00a2, B:27:0x00a8, B:30:0x00b2, B:32:0x00be, B:34:0x00c4, B:38:0x00d0, B:40:0x00dd, B:42:0x00e3, B:45:0x00f2, B:53:0x0101, B:51:0x00fb, B:19:0x008d, B:21:0x0094), top: B:73:0x0011, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void w(HashSet<String> hashSet, HashSet<String> hashSet2, HashSet<String> hashSet3, HashSet<String> hashSet4, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, HashMap<String, dn4> hashMap3, HashSet<String> hashSet5) {
        SQLiteDatabase readableDatabase;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048602, this, new Object[]{hashSet, hashSet2, hashSet3, hashSet4, hashMap, hashMap2, hashMap3, hashSet5}) != null) || (readableDatabase = this.b.getReadableDatabase()) == null) {
            return;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = readableDatabase.rawQuery("SELECT * FROM config", null);
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    do {
                        String string = cursor.getString(cursor.getColumnIndex("eventid"));
                        String string2 = cursor.getString(cursor.getColumnIndex(SetImageWatermarkTypeReqMsg.SWITCH));
                        int i2 = cursor.getInt(cursor.getColumnIndex("sample"));
                        String string3 = cursor.getString(cursor.getColumnIndex("reserve1"));
                        String string4 = cursor.getString(cursor.getColumnIndex("reserve2"));
                        int i3 = cursor.getInt(cursor.getColumnIndex("cycle"));
                        int i4 = cursor.getInt(cursor.getColumnIndex("uploadrule"));
                        int i5 = cursor.getInt(cursor.getColumnIndex("recordrule"));
                        String string5 = cursor.getString(cursor.getColumnIndex("extend"));
                        if (TextUtils.equals(string2, "0")) {
                            hashSet.add(string);
                        } else if (TextUtils.equals(string2, "1")) {
                            hashSet2.add(string);
                            if (i3 != 0) {
                                hashSet3.add(string);
                            }
                            if (!TextUtils.equals(string3, "1")) {
                                hashSet4.add(string);
                            }
                            if (i2 <= 0) {
                                hashMap.put(string, String.valueOf(i2));
                            }
                            if (TextUtils.isEmpty(string4)) {
                                hashMap2.put(string, string4);
                            }
                            if (i4 == 0 && i5 != 0) {
                                hashMap3.put(string, new dn4(string, i5, i4));
                            }
                            if (!TextUtils.isEmpty(string5)) {
                                try {
                                } catch (JSONException e2) {
                                    e = e2;
                                }
                                if (new JSONObject(string5).has(Constant.ID_TYPE)) {
                                    try {
                                        hashSet5.add(string);
                                    } catch (JSONException e3) {
                                        e = e3;
                                        e.printStackTrace();
                                        if (!cursor.moveToNext()) {
                                        }
                                    }
                                }
                            }
                        }
                        if (i3 != 0) {
                        }
                        if (!TextUtils.equals(string3, "1")) {
                        }
                        if (i2 <= 0) {
                        }
                        if (TextUtils.isEmpty(string4)) {
                        }
                        if (i4 == 0) {
                        }
                        if (!TextUtils.isEmpty(string5)) {
                        }
                    } while (!cursor.moveToNext());
                }
            } catch (SQLiteFullException unused) {
            } catch (RuntimeException e4) {
                e4.printStackTrace();
            }
        } finally {
            yn4.d(cursor);
        }
    }
}
