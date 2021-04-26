package com.baidu.wallet.personal.storage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.common.security.MD5Util;
import com.baidu.apollon.statistics.sqlite.MyDb;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.paysdk.datamodel.CardListResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class CardListCache extends MyDb {

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f27078f = {"user_id TEXT not null", "card_list TEXT NOT null default ''", "primary key (user_id)"};

    /* renamed from: a  reason: collision with root package name */
    public CardListResponse f27079a;

    /* renamed from: b  reason: collision with root package name */
    public CardListResponse f27080b;

    /* renamed from: c  reason: collision with root package name */
    public b<CardListResponse> f27081c;

    /* renamed from: d  reason: collision with root package name */
    public a<CardListResponse> f27082d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f27083e;

    /* loaded from: classes5.dex */
    public interface a<Value extends Serializable> {
        void a(Value value);
    }

    /* loaded from: classes5.dex */
    public interface b<Value extends Serializable> {
        void a(Value value);
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static int f27085a = 2;

        /* renamed from: b  reason: collision with root package name */
        public static final CardListCache f27086b = new CardListCache(BaiduWalletDelegate.getInstance().getAppContext(), "wallet_sdk.db", f27085a);
    }

    public static CardListCache getInstance() {
        return c.f27086b;
    }

    public void getCardList(b<CardListResponse> bVar) {
        this.f27081c = bVar;
        if (bVar == null) {
            return;
        }
        this.f27083e.obtainMessage(10001).sendToTarget();
    }

    public void getEemCardList(a<CardListResponse> aVar) {
        this.f27082d = aVar;
        if (aVar == null) {
            return;
        }
        this.f27083e.obtainMessage(10002).sendToTarget();
    }

    public String getUserId() {
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

    public String getUserIdV2() {
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

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.mDb = sQLiteDatabase;
        MyDb.createTable(sQLiteDatabase, "tb_card_list", f27078f);
        MyDb.createTable(sQLiteDatabase, "tb_eem_card_list", f27078f);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        this.mDb = sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        this.mDb = sQLiteDatabase;
        if (i3 > i2) {
            MyDb.createTable(sQLiteDatabase, "tb_eem_card_list", f27078f);
        }
    }

    public void updateCardList(int i2, CardListResponse cardListResponse) {
        if (cardListResponse == null) {
            return;
        }
        String a2 = a(cardListResponse);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        if (i2 == 599) {
            this.f27083e.obtainMessage(10000, a2).sendToTarget();
        } else if (i2 == 607) {
            this.f27083e.obtainMessage(10003, a2).sendToTarget();
        }
    }

    public CardListCache(Context context, String str, int i2) {
        super(context, str, i2);
        HandlerThread handlerThread = new HandlerThread("sdk_db_thread");
        handlerThread.start();
        this.f27083e = new Handler(handlerThread.getLooper()) { // from class: com.baidu.wallet.personal.storage.CardListCache.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (BaiduWalletDelegate.getInstance().getAppContext() == null) {
                    return;
                }
                int i3 = message.what;
                if (10000 == i3) {
                    CardListCache.this.a((String) message.obj, "tb_card_list");
                } else if (10001 == i3) {
                    CardListCache cardListCache = CardListCache.this;
                    cardListCache.f27079a = cardListCache.a("tb_card_list");
                    if (CardListCache.this.f27081c != null) {
                        CardListCache.this.f27081c.a(CardListCache.this.f27079a);
                    }
                } else if (10003 == i3) {
                    CardListCache.this.a((String) message.obj, "tb_eem_card_list");
                } else if (10002 == i3) {
                    CardListCache cardListCache2 = CardListCache.this;
                    cardListCache2.f27080b = cardListCache2.a("tb_eem_card_list");
                    if (CardListCache.this.f27082d != null) {
                        CardListCache.this.f27082d.a(CardListCache.this.f27080b);
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        SQLiteDatabase sQLiteDatabase;
        if (TextUtils.isEmpty(str)) {
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x002a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x002c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x002e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> T a(String str, Class<T> cls) {
        ObjectInputStream objectInputStream;
        Object obj;
        ?? r1 = 0;
        r1 = 0;
        if (TextUtils.isEmpty(str) || cls == null) {
            return null;
        }
        ?? r3 = 2;
        try {
            try {
                r3 = new ByteArrayInputStream(Base64.decode(str, 2));
            } catch (Throwable th) {
                th = th;
                r1 = str;
            }
        } catch (IOException e2) {
            e = e2;
            objectInputStream = null;
            r3 = 0;
        } catch (ClassNotFoundException e3) {
            e = e3;
            objectInputStream = null;
            r3 = 0;
        } catch (Throwable th2) {
            th = th2;
            r3 = 0;
        }
        try {
            objectInputStream = new ObjectInputStream(r3);
            try {
                obj = objectInputStream.readObject();
                try {
                    objectInputStream.close();
                    r3.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            } catch (IOException e5) {
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
                if (r3 != 0) {
                    r3.close();
                }
                obj = null;
                if (obj == null) {
                }
            } catch (ClassNotFoundException e7) {
                e = e7;
                e.printStackTrace();
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e8) {
                        e = e8;
                        e.printStackTrace();
                        obj = null;
                        if (obj == null) {
                        }
                    }
                }
                if (r3 != 0) {
                    r3.close();
                }
                obj = null;
                if (obj == null) {
                }
            }
        } catch (IOException e9) {
            e = e9;
            objectInputStream = null;
        } catch (ClassNotFoundException e10) {
            e = e10;
            objectInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            if (r1 != 0) {
                try {
                    r1.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                    throw th;
                }
            }
            if (r3 != 0) {
                r3.close();
            }
            throw th;
        }
        if (obj == null) {
            return null;
        }
        return (T) obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x004e A[Catch: IOException -> 0x004a, TRY_LEAVE, TryCatch #0 {IOException -> 0x004a, blocks: (B:31:0x0046, B:35:0x004e), top: B:39:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Serializable serializable) {
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        String str = null;
        str = null;
        str = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        if (serializable == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeObject(serializable);
                    str = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                    byteArrayOutputStream.close();
                    objectOutputStream.close();
                } catch (IOException e3) {
                    e = e3;
                    e.printStackTrace();
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    return str;
                }
            } catch (IOException e4) {
                e = e4;
                objectOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream = null;
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
            byteArrayOutputStream = null;
            objectOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            objectOutputStream = null;
            if (byteArrayOutputStream2 != null) {
            }
            if (objectOutputStream != null) {
            }
            throw th;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CardListResponse a(String str) {
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
}
