package com.bun.miitmdid.supplier.h.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
/* loaded from: classes6.dex */
public class a {
    private Context a;

    public a(Context context) {
        this.a = context;
    }

    public String a(int i, String str) {
        Uri parse;
        switch (i) {
            case 0:
                parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
                break;
            case 1:
                parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str);
                break;
            case 2:
                parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str);
                break;
            default:
                parse = null;
                break;
        }
        Cursor query = this.a.getContentResolver().query(parse, null, null, null, null);
        if (query != null) {
            r2 = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
            query.close();
        } else {
            com.bun.miitmdid.utils.a.b("VMS_IDLG_SDK_DB", "return cursor is null,return");
        }
        return r2;
    }
}
