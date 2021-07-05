package com.baidu.wallet.personal.storage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.common.security.MD5Util;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.statistics.sqlite.MyDb;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.paysdk.datamodel.CardListResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class CardListCache extends MyDb {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f26980f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public CardListResponse f26981a;

    /* renamed from: b  reason: collision with root package name */
    public CardListResponse f26982b;

    /* renamed from: c  reason: collision with root package name */
    public b<CardListResponse> f26983c;

    /* renamed from: d  reason: collision with root package name */
    public a<CardListResponse> f26984d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f26985e;

    /* loaded from: classes6.dex */
    public interface a<Value extends Serializable> {
        void a(Value value);
    }

    /* loaded from: classes6.dex */
    public interface b<Value extends Serializable> {
        void a(Value value);
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static int f26987a = 2;

        /* renamed from: b  reason: collision with root package name */
        public static final CardListCache f26988b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1356624605, "Lcom/baidu/wallet/personal/storage/CardListCache$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1356624605, "Lcom/baidu/wallet/personal/storage/CardListCache$c;");
                    return;
                }
            }
            f26988b = new CardListCache(BaiduWalletDelegate.getInstance().getAppContext(), "wallet_sdk.db", f26987a);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1319845950, "Lcom/baidu/wallet/personal/storage/CardListCache;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1319845950, "Lcom/baidu/wallet/personal/storage/CardListCache;");
                return;
            }
        }
        f26980f = new String[]{"user_id TEXT not null", "card_list TEXT NOT null default ''", "primary key (user_id)"};
    }

    public static CardListCache getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? c.f26988b : (CardListCache) invokeV.objValue;
    }

    public void getCardList(b<CardListResponse> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f26983c = bVar;
            if (bVar == null) {
                return;
            }
            this.f26985e.obtainMessage(10001).sendToTarget();
        }
    }

    public void getEemCardList(a<CardListResponse> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f26984d = aVar;
            if (aVar == null) {
                return;
            }
            this.f26985e.obtainMessage(10002).sendToTarget();
        }
    }

    public String getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (BaiduWalletDelegate.getInstance().getAppContext() == null) {
                return null;
            }
            String passUid = WalletLoginHelper.getInstance().getPassUid();
            if (TextUtils.isEmpty(passUid)) {
                return null;
            }
            try {
                return MD5Util.toMd5(passUid.getBytes(), false);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public String getUserIdV2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (BaiduWalletDelegate.getInstance().getAppContext() == null) {
                return null;
            }
            String unionId = WalletLoginHelper.getInstance().getUnionId();
            if (TextUtils.isEmpty(unionId)) {
                return null;
            }
            try {
                return MD5Util.toMd5(unionId.getBytes(), false);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sQLiteDatabase) == null) {
            this.mDb = sQLiteDatabase;
            MyDb.createTable(sQLiteDatabase, "tb_card_list", f26980f);
            MyDb.createTable(sQLiteDatabase, "tb_eem_card_list", f26980f);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sQLiteDatabase) == null) {
            this.mDb = sQLiteDatabase;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, sQLiteDatabase, i2, i3) == null) {
            this.mDb = sQLiteDatabase;
            if (i3 > i2) {
                MyDb.createTable(sQLiteDatabase, "tb_eem_card_list", f26980f);
            }
        }
    }

    public void updateCardList(int i2, CardListResponse cardListResponse) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048583, this, i2, cardListResponse) == null) || cardListResponse == null) {
            return;
        }
        String a2 = a(cardListResponse);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        if (i2 == 599) {
            this.f26985e.obtainMessage(10000, a2).sendToTarget();
        } else if (i2 == 607) {
            this.f26985e.obtainMessage(10003, a2).sendToTarget();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardListCache(Context context, String str, int i2) {
        super(context, str, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        HandlerThread handlerThread = new HandlerThread("sdk_db_thread");
        handlerThread.start();
        this.f26985e = new Handler(this, handlerThread.getLooper()) { // from class: com.baidu.wallet.personal.storage.CardListCache.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CardListCache f26986a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f26986a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) || BaiduWalletDelegate.getInstance().getAppContext() == null) {
                    return;
                }
                int i5 = message.what;
                if (10000 == i5) {
                    this.f26986a.a((String) message.obj, "tb_card_list");
                } else if (10001 == i5) {
                    CardListCache cardListCache = this.f26986a;
                    cardListCache.f26981a = cardListCache.a("tb_card_list");
                    if (this.f26986a.f26983c != null) {
                        this.f26986a.f26983c.a(this.f26986a.f26981a);
                    }
                } else if (10003 == i5) {
                    this.f26986a.a((String) message.obj, "tb_eem_card_list");
                } else if (10002 == i5) {
                    CardListCache cardListCache2 = this.f26986a;
                    cardListCache2.f26982b = cardListCache2.a("tb_eem_card_list");
                    if (this.f26986a.f26984d != null) {
                        this.f26986a.f26984d.a(this.f26986a.f26982b);
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        SQLiteDatabase sQLiteDatabase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, this, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        String userIdV2 = getUserIdV2();
        if (TextUtils.isEmpty(userIdV2) || (sQLiteDatabase = this.mDb) == null) {
            return;
        }
        sQLiteDatabase.beginTransaction();
        this.mDb.execSQL("insert or replace into " + str2 + "(user_id,card_list) values('" + userIdV2 + "','" + str + "')");
        this.mDb.setTransactionSuccessful();
        this.mDb.endTransaction();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x002e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0030 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0032 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> T a(String str, Class<T> cls) {
        InterceptResult invokeLL;
        ObjectInputStream objectInputStream;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, cls)) == null) {
            ?? r1 = 0;
            r1 = 0;
            if (TextUtils.isEmpty(str) || cls == null) {
                return null;
            }
            ?? r5 = 2;
            try {
                try {
                    r5 = new ByteArrayInputStream(Base64.decode(str, 2));
                } catch (Throwable th) {
                    th = th;
                    r1 = str;
                }
                try {
                    objectInputStream = new ObjectInputStream(r5);
                    try {
                        obj = objectInputStream.readObject();
                        try {
                            objectInputStream.close();
                            r5.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    } catch (IOException e3) {
                        e = e3;
                        e.printStackTrace();
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e4) {
                                e = e4;
                                e.printStackTrace();
                                obj = null;
                                if (obj == null) {
                                }
                            }
                        }
                        if (r5 != 0) {
                            r5.close();
                        }
                        obj = null;
                        if (obj == null) {
                        }
                    } catch (ClassNotFoundException e5) {
                        e = e5;
                        e.printStackTrace();
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e6) {
                                e = e6;
                                e.printStackTrace();
                                obj = null;
                                if (obj == null) {
                                }
                            }
                        }
                        if (r5 != 0) {
                            r5.close();
                        }
                        obj = null;
                        if (obj == null) {
                        }
                    }
                } catch (IOException e7) {
                    e = e7;
                    objectInputStream = null;
                } catch (ClassNotFoundException e8) {
                    e = e8;
                    objectInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (r1 != 0) {
                        try {
                            r1.close();
                        } catch (IOException e9) {
                            e9.printStackTrace();
                            throw th;
                        }
                    }
                    if (r5 != 0) {
                        r5.close();
                    }
                    throw th;
                }
            } catch (IOException e10) {
                e = e10;
                objectInputStream = null;
                r5 = 0;
            } catch (ClassNotFoundException e11) {
                e = e11;
                objectInputStream = null;
                r5 = 0;
            } catch (Throwable th3) {
                th = th3;
                r5 = 0;
            }
            if (obj == null) {
                return null;
            }
            return (T) obj;
        }
        return (T) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0052 A[Catch: IOException -> 0x004e, TRY_LEAVE, TryCatch #7 {IOException -> 0x004e, blocks: (B:33:0x004a, B:37:0x0052), top: B:49:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Serializable serializable) {
        InterceptResult invokeL;
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, serializable)) == null) {
            String str = null;
            str = null;
            str = null;
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            try {
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            if (serializable == null) {
                return null;
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (IOException e3) {
                e = e3;
                byteArrayOutputStream = null;
                objectOutputStream = null;
            } catch (Throwable th) {
                th = th;
                objectOutputStream = null;
                if (byteArrayOutputStream2 != null) {
                }
                if (objectOutputStream != null) {
                }
                throw th;
            }
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    try {
                        objectOutputStream.writeObject(serializable);
                        str = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                        byteArrayOutputStream.close();
                        objectOutputStream.close();
                    } catch (IOException e4) {
                        e = e4;
                        e.printStackTrace();
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                        return str;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                            throw th;
                        }
                    }
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
                objectOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                objectOutputStream = null;
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                }
                if (objectOutputStream != null) {
                }
                throw th;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CardListResponse a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str)) == null) {
            String userIdV2 = getUserIdV2();
            if (TextUtils.isEmpty(userIdV2) || this.mDb == null) {
                return null;
            }
            this.mDb.beginTransaction();
            Cursor rawQuery = this.mDb.rawQuery("select card_list from " + str + " where user_id='" + userIdV2 + "'", null);
            String str2 = null;
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    try {
                        str2 = rawQuery.getString(0);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                rawQuery.close();
            }
            this.mDb.setTransactionSuccessful();
            this.mDb.endTransaction();
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            return (CardListResponse) a(str2, CardListResponse.class);
        }
        return (CardListResponse) invokeL.objValue;
    }
}
