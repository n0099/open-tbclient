package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class ac implements Cloneable {
    private static final SimpleDateFormat pmZ = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    /* renamed from: a  reason: collision with root package name */
    public long f5776a = System.currentTimeMillis();

    /* renamed from: b  reason: collision with root package name */
    public long f5777b;
    public String c;
    public String d;
    public String e;
    public String f;
    String g;

    @NonNull
    public abstract ac C(@NonNull Cursor cursor);

    protected abstract void a(@NonNull JSONObject jSONObject);

    protected abstract String[] a();

    protected abstract JSONObject b();

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public abstract String d();

    protected abstract void d(@NonNull ContentValues contentValues);

    protected abstract ac eR(@NonNull JSONObject jSONObject);

    public static String a(long j) {
        return pmZ.format(new Date(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ContentValues e(@Nullable ContentValues contentValues) {
        if (contentValues == null) {
            contentValues = new ContentValues();
        } else {
            contentValues.clear();
        }
        d(contentValues);
        return contentValues;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String c() {
        String[] a2 = a();
        if (a2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("create table if not exists ").append(d()).append("(");
        for (int i = 0; i < a2.length; i += 2) {
            sb.append(a2[i]).append(" ").append(a2[i + 1]).append(",");
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append(")");
        return sb.toString();
    }

    @NonNull
    public final JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("k_cls", d());
            a(jSONObject);
        } catch (JSONException e) {
            au.a(e);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public final JSONObject f() {
        try {
            this.g = a(this.f5776a);
            return b();
        } catch (JSONException e) {
            au.a(e);
            return null;
        }
    }

    public static ac YI(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return ad.f5778a.get(jSONObject.optString("k_cls", "")).clone().eR(jSONObject);
        } catch (Throwable th) {
            au.a(th);
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: enZ */
    public ac clone() {
        try {
            return (ac) super.clone();
        } catch (CloneNotSupportedException e) {
            au.a(e);
            return null;
        }
    }

    @NonNull
    public String toString() {
        if (au.f5788b) {
            String d = d();
            if (!getClass().getSimpleName().equalsIgnoreCase(d)) {
                d = d + ", " + getClass().getSimpleName();
            }
            String str = this.c;
            if (str != null) {
                int indexOf = str.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (indexOf >= 0) {
                    str = str.substring(0, indexOf);
                }
            } else {
                str = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            }
            return "{" + d + ", " + h() + ", " + str + ", " + this.f5776a + "}";
        }
        return super.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String h() {
        return "sid:" + this.c;
    }
}
