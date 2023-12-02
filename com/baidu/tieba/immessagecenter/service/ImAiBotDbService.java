package com.baidu.tieba.immessagecenter.service;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fu8;
import com.baidu.tieba.immessagecenter.arch.utils.IMLog;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.sd;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\u001e\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\t\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007J&\u0010\u000b\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007¨\u0006\u000f"}, d2 = {"Lcom/baidu/tieba/immessagecenter/service/ImAiBotDbService;", "", "()V", "getAiBotInfoByPaid", "", "", "paid", "getAiBotInfoByUid", "uid", "isAiBot", "", "updateAiBotInfo", "", "uk", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ImAiBotDbService {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public static final Lazy<ImAiBotDbService> b;
    public transient /* synthetic */ FieldHolder $fh;

    public /* synthetic */ ImAiBotDbService(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
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

        public final ImAiBotDbService a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b();
            }
            return (ImAiBotDbService) invokeV.objValue;
        }

        public final synchronized ImAiBotDbService b() {
            InterceptResult invokeV;
            ImAiBotDbService imAiBotDbService;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                synchronized (this) {
                    imAiBotDbService = (ImAiBotDbService) ImAiBotDbService.b.getValue();
                }
                return imAiBotDbService;
            }
            return (ImAiBotDbService) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-902603520, "Lcom/baidu/tieba/immessagecenter/service/ImAiBotDbService;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-902603520, "Lcom/baidu/tieba/immessagecenter/service/ImAiBotDbService;");
                return;
            }
        }
        a = new a(null);
        b = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) ImAiBotDbService$Companion$instance$2.INSTANCE);
    }

    public ImAiBotDbService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @WorkerThread
    public final Map<String, String> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            HashMap hashMap = new HashMap();
            Cursor cursor = null;
            try {
                try {
                    cursor = fu8.e().g("select * from tb_ai_bot WHERE paid=?", new String[]{str});
                    if (cursor != null && cursor.moveToNext()) {
                        String string = cursor.getString(cursor.getColumnIndex("paid"));
                        Intrinsics.checkNotNullExpressionValue(string, "cursor.getString(cursor.…elper.INDEX_AI_BOT_PAID))");
                        hashMap.put("paid", string);
                        String string2 = cursor.getString(cursor.getColumnIndex("uid"));
                        Intrinsics.checkNotNullExpressionValue(string2, "cursor.getString(cursor.…Helper.INDEX_AI_BOT_UID))");
                        hashMap.put("uid", string2);
                        String string3 = cursor.getString(cursor.getColumnIndex("uk"));
                        Intrinsics.checkNotNullExpressionValue(string3, "cursor.getString(cursor.…eHelper.INDEX_AI_BOT_UK))");
                        hashMap.put("uk", string3);
                        String string4 = cursor.getString(cursor.getColumnIndex("topicText"));
                        Intrinsics.checkNotNullExpressionValue(string4, "cursor.getString(cursor.…INDEX_AI_BOT_TOPIC_TEXT))");
                        hashMap.put("topicText", string4);
                        String string5 = cursor.getString(cursor.getColumnIndex("sugText"));
                        Intrinsics.checkNotNullExpressionValue(string5, "cursor.getString(cursor.…r.INDEX_AI_BOT_SUG_TEXT))");
                        hashMap.put("sugText", string5);
                        String string6 = cursor.getString(cursor.getColumnIndex("backgroundUrl"));
                        Intrinsics.checkNotNullExpressionValue(string6, "cursor.getString(cursor.…X_AI_BOT_BACKGROUND_URL))");
                        hashMap.put("backgroundUrl", string6);
                    }
                } catch (Exception e) {
                    TbLog iMLog = IMLog.getInstance();
                    iMLog.i("ImAiBotDbService", "ImAiBotDao.getAiBotInfo " + e);
                }
                return hashMap;
            } finally {
                sd.a(cursor);
            }
        }
        return (Map) invokeL.objValue;
    }

    @WorkerThread
    public final Map<String, String> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            HashMap hashMap = new HashMap();
            Cursor cursor = null;
            try {
                try {
                    cursor = fu8.e().g("select * from tb_ai_bot WHERE uid=?", new String[]{str});
                    if (cursor != null && cursor.moveToNext()) {
                        String string = cursor.getString(cursor.getColumnIndex("paid"));
                        Intrinsics.checkNotNullExpressionValue(string, "cursor.getString(cursor.…elper.INDEX_AI_BOT_PAID))");
                        hashMap.put("paid", string);
                        String string2 = cursor.getString(cursor.getColumnIndex("uid"));
                        Intrinsics.checkNotNullExpressionValue(string2, "cursor.getString(cursor.…Helper.INDEX_AI_BOT_UID))");
                        hashMap.put("uid", string2);
                        String string3 = cursor.getString(cursor.getColumnIndex("uk"));
                        Intrinsics.checkNotNullExpressionValue(string3, "cursor.getString(cursor.…eHelper.INDEX_AI_BOT_UK))");
                        hashMap.put("uk", string3);
                        String string4 = cursor.getString(cursor.getColumnIndex("topicText"));
                        Intrinsics.checkNotNullExpressionValue(string4, "cursor.getString(cursor.…INDEX_AI_BOT_TOPIC_TEXT))");
                        hashMap.put("topicText", string4);
                        String string5 = cursor.getString(cursor.getColumnIndex("sugText"));
                        Intrinsics.checkNotNullExpressionValue(string5, "cursor.getString(cursor.…r.INDEX_AI_BOT_SUG_TEXT))");
                        hashMap.put("sugText", string5);
                        String string6 = cursor.getString(cursor.getColumnIndex("backgroundUrl"));
                        Intrinsics.checkNotNullExpressionValue(string6, "cursor.getString(cursor.…X_AI_BOT_BACKGROUND_URL))");
                        hashMap.put("backgroundUrl", string6);
                    }
                } catch (Exception e) {
                    TbLog iMLog = IMLog.getInstance();
                    iMLog.i("ImAiBotDbService", "ImAiBotDao.getAiBotInfo " + e);
                }
                return hashMap;
            } finally {
                sd.a(cursor);
            }
        }
        return (Map) invokeL.objValue;
    }

    @WorkerThread
    public final boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            Map<String, String> c = c(str);
            if (c.get("uk") != null && c.get("paid") != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @WorkerThread
    public final void e(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                TbLog iMLog = IMLog.getInstance();
                iMLog.i("ImAiBotDbService", "updateAiBotInfo paid:" + str + " uid:" + str2 + " uk:" + str3);
                ContentValues contentValues = new ContentValues();
                if (!TextUtils.isEmpty(str)) {
                    contentValues.put("paid", str);
                }
                if (!TextUtils.isEmpty(str3)) {
                    contentValues.put("uk", str3);
                }
                if (fu8.e().i("tb_ai_bot", contentValues, "uid=?", new String[]{str2}) == 0) {
                    contentValues.put("uid", str2);
                    fu8.e().f("tb_ai_bot", null, contentValues);
                }
            } catch (Exception e) {
                TbLog iMLog2 = IMLog.getInstance();
                iMLog2.i("ImAiBotDbService", "ImAiBotDao.insertOrUpdateAiBot" + e);
            }
        }
    }
}
