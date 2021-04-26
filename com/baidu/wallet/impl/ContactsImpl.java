package com.baidu.wallet.impl;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.utils.StringUtils;
import com.baidu.wallet.api.internal.IContacts;
import com.baidu.wallet.base.iddetect.IdCardActivity;
import com.baidu.wallet.core.utils.contacts.ContractInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class ContactsImpl implements IContacts {
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0029, code lost:
        if (r0 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002b, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
        if (r0 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
        return r1;
     */
    @Override // com.baidu.wallet.api.internal.IContacts
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int countOfContacts(@NonNull Context context) {
        if (!PermissionManager.checkCallingPermission(context, "android.permission.READ_CONTACTS")) {
            return 0;
        }
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://com.android.contacts/contacts"), new String[]{"_id"}, null, null, null);
            r1 = cursor != null ? cursor.getCount() : 0;
        } catch (Exception unused) {
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005d, code lost:
        if (r6 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0068, code lost:
        if (r6 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006a, code lost:
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006d, code lost:
        return r8;
     */
    @Override // com.baidu.wallet.api.internal.IContacts
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<ContractInfo> loadAllPhone(@NonNull Context context) {
        if (!PermissionManager.checkCallingPermission(context, "android.permission.READ_CONTACTS")) {
            return Collections.emptyList();
        }
        ContentResolver contentResolver = context.getContentResolver();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"display_name", "data1"}, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    if (!TextUtils.isEmpty(string2)) {
                        String replaceAll = string2.replaceAll("[ |-]+", "");
                        if (!TextUtils.isEmpty(replaceAll)) {
                            ContractInfo contractInfo = new ContractInfo();
                            contractInfo.setName(string);
                            contractInfo.setMobile(replaceAll);
                            arrayList.add(contractInfo);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // com.baidu.wallet.api.internal.IContacts
    public List<String> loadPhoneContactsForChargeFragment(@NonNull Uri uri, @NonNull Context context) {
        Cursor cursor;
        Cursor cursor2;
        if (!PermissionManager.checkCallingPermission(context, "android.permission.READ_CONTACTS")) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor3 = null;
        try {
            cursor2 = contentResolver.query(uri, null, null, null, null);
            if (cursor2 == null) {
                if (cursor2 != null) {
                    cursor2.close();
                }
                return null;
            }
            try {
                cursor2.moveToFirst();
                arrayList.add(cursor2.getString(cursor2.getColumnIndex("display_name")));
                String string = cursor2.getString(cursor2.getColumnIndex("_id"));
                cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id=" + string, null, null);
                if (cursor == null) {
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                try {
                    if (cursor.getCount() <= 0) {
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    }
                    cursor.moveToFirst();
                    do {
                        String formatPhoneNumber = StringUtils.formatPhoneNumber(cursor.getString(cursor.getColumnIndex("data1")));
                        if (!TextUtils.isEmpty(formatPhoneNumber)) {
                            arrayList.add(formatPhoneNumber);
                        }
                    } while (cursor.moveToNext());
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                } catch (Exception unused) {
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursor3 = cursor2;
                    if (cursor3 != null) {
                        cursor3.close();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
        } catch (Exception unused3) {
            cursor2 = null;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006b, code lost:
        if (r7 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0076, code lost:
        if (r7 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0078, code lost:
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007b, code lost:
        return r9;
     */
    @Override // com.baidu.wallet.api.internal.IContacts
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ConcurrentHashMap<String, ContractInfo> loadPhoneContracts(@NonNull Context context) {
        if (!PermissionManager.checkCallingPermission(context, "android.permission.READ_CONTACTS")) {
            return new ConcurrentHashMap<>();
        }
        ContentResolver contentResolver = context.getContentResolver();
        ConcurrentHashMap<String, ContractInfo> concurrentHashMap = new ConcurrentHashMap<>();
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    String string = cursor.getString(cursor.getColumnIndex("display_name"));
                    String string2 = cursor.getString(cursor.getColumnIndex("data1"));
                    if (!TextUtils.isEmpty(string2)) {
                        String formatPhoneNumber = StringUtils.formatPhoneNumber(string2.replaceAll(" ", "").replaceAll("-", ""));
                        if (!TextUtils.isEmpty(formatPhoneNumber)) {
                            ContractInfo contractInfo = new ContractInfo();
                            contractInfo.setName(string);
                            contractInfo.setMobile(formatPhoneNumber);
                            concurrentHashMap.put(formatPhoneNumber, contractInfo);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.wallet.api.internal.IContacts
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<String> loadRawPhone(@NonNull Uri uri, @NonNull Context context) {
        Cursor cursor;
        Cursor cursor2;
        if (!PermissionManager.checkCallingPermission(context, "android.permission.READ_CONTACTS")) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        ContentResolver contentResolver = context.getContentResolver();
        try {
            cursor = contentResolver.query(uri, new String[]{"lookup"}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToNext()) {
                        cursor2 = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"display_name", "data1"}, "lookup=?", new String[]{cursor.getString(0)}, null);
                        boolean z = true;
                        while (cursor2 != null) {
                            try {
                                if (!cursor2.moveToNext()) {
                                    break;
                                }
                                if (z) {
                                    arrayList.add(cursor2.getString(0));
                                    z = false;
                                }
                                String string = cursor2.getString(1);
                                if (!TextUtils.isEmpty(string)) {
                                    String replaceAll = string.replaceAll("[ |-]+", "");
                                    if (!TextUtils.isEmpty(replaceAll)) {
                                        arrayList.add(replaceAll);
                                    }
                                }
                            } catch (Throwable unused) {
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                if (cursor == null) {
                                    cursor.close();
                                    return null;
                                }
                                return null;
                            }
                        }
                        if (arrayList.size() < 2) {
                            arrayList = null;
                        }
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        return arrayList;
                    }
                } catch (Throwable unused2) {
                    cursor2 = null;
                    if (cursor2 != null) {
                    }
                    if (cursor == null) {
                    }
                }
            }
            cursor2 = null;
            if (arrayList.size() < 2) {
            }
            if (cursor2 != null) {
            }
            if (cursor != null) {
            }
            return arrayList;
        } catch (Throwable unused3) {
            cursor = null;
            cursor2 = null;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0069, code lost:
        if (r8 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0074, code lost:
        if (r8 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0076, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0079, code lost:
        return r0;
     */
    @Override // com.baidu.wallet.api.internal.IContacts
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ConcurrentHashMap<String, ContractInfo> loadSimContracts(@NonNull Context context) {
        if (!PermissionManager.checkCallingPermission(context, "android.permission.READ_CONTACTS")) {
            return new ConcurrentHashMap<>();
        }
        ConcurrentHashMap<String, ContractInfo> concurrentHashMap = new ConcurrentHashMap<>();
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(Uri.parse("content://icc/adn"), null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    String string = cursor.getString(cursor.getColumnIndex("name"));
                    String string2 = cursor.getString(cursor.getColumnIndex(IdCardActivity.KEY_NUMBER));
                    if (!TextUtils.isEmpty(string2)) {
                        String formatPhoneNumber = StringUtils.formatPhoneNumber(string2.replaceAll(" ", ""));
                        if (!TextUtils.isEmpty(formatPhoneNumber)) {
                            ContractInfo contractInfo = new ContractInfo();
                            contractInfo.setName(string);
                            contractInfo.setMobile(formatPhoneNumber);
                            concurrentHashMap.put(formatPhoneNumber, contractInfo);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // com.baidu.wallet.api.internal.IContacts
    public boolean pickContactsByContactsContentUri(@NonNull Activity activity, int i2) {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setData(ContactsContract.Contacts.CONTENT_URI);
        if (activity == null || intent.resolveActivity(activity.getPackageManager()) == null) {
            return false;
        }
        activity.startActivityForResult(intent, i2);
        return true;
    }

    @Override // com.baidu.wallet.api.internal.IContacts
    public boolean pickContactsByPhoneContentType(@NonNull Activity activity, int i2) {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("vnd.android.cursor.dir/phone_v2");
        if (activity == null || intent.resolveActivity(activity.getPackageManager()) == null) {
            return false;
        }
        activity.startActivityForResult(intent, i2);
        return true;
    }
}
