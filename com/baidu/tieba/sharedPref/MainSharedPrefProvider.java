package com.baidu.tieba.sharedPref;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class MainSharedPrefProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        SharedPreferences a;
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null || lastPathSegment.length() <= 0 || (a = a()) == null) {
            return null;
        }
        return a.getString(lastPathSegment, null);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        if (contentValues != null && contentValues.size() > 0) {
            String lastPathSegment = uri.getLastPathSegment();
            String asString = contentValues.getAsString(lastPathSegment);
            SharedPreferences a = a();
            if (a != null) {
                SharedPreferences.Editor edit = a.edit();
                edit.putString(lastPathSegment, asString);
                edit.commit();
                if (a(lastPathSegment)) {
                    a(lastPathSegment, asString);
                    return null;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        SharedPreferences a;
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment != null && lastPathSegment.length() > 0 && (a = a()) != null) {
            SharedPreferences.Editor edit = a.edit();
            edit.remove(lastPathSegment);
            edit.commit();
            if (a(lastPathSegment)) {
                a(lastPathSegment, null);
                return 0;
            }
            return 0;
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private void a(String str, String str2) {
        Intent intent = new Intent();
        intent.setAction("com.baidu.tieba.broadcast.changeSharedPref");
        intent.putExtra("intent_key", str);
        intent.putExtra("intent_value", str2);
        TiebaApplication.h().sendBroadcast(intent);
    }

    private boolean a(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = a.e.length;
        for (int i = 0; i < length; i++) {
            if (a.e[i].equals(str)) {
                return true;
            }
        }
        return false;
    }

    private SharedPreferences a() {
        try {
            if (TiebaApplication.h() != null) {
                return TiebaApplication.h().getSharedPreferences("common_settings", 0);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
