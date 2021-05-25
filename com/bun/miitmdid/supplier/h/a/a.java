package com.bun.miitmdid.supplier.h.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f26805a;

    public a(Context context) {
        this.f26805a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(int i2, String str) {
        String str2;
        Uri parse;
        Cursor query;
        StringBuilder sb;
        String str3;
        if (i2 != 0) {
            if (i2 == 1) {
                sb = new StringBuilder();
                str3 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_";
            } else if (i2 != 2) {
                parse = null;
                query = this.f26805a.getContentResolver().query(parse, null, null, null, null);
                if (query == null) {
                    r0 = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
                    query.close();
                } else {
                    com.bun.miitmdid.utils.a.b("VMS_IDLG_SDK_DB", "return cursor is null,return");
                }
                return r0;
            } else {
                sb = new StringBuilder();
                str3 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_";
            }
            sb.append(str3);
            sb.append(str);
            str2 = sb.toString();
        } else {
            str2 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID";
        }
        parse = Uri.parse(str2);
        query = this.f26805a.getContentResolver().query(parse, null, null, null, null);
        if (query == null) {
        }
        return r0;
    }
}
