package com.baidu.wallet.impl;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.utils.StringUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.internal.IContacts;
import com.baidu.wallet.core.utils.contacts.ContractInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public class ContactsImpl implements IContacts {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ContactsImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002d, code lost:
        if (r0 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002f, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
        if (r0 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003e, code lost:
        return r1;
     */
    @Override // com.baidu.wallet.api.internal.IContacts
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int countOfContacts(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, context)) != null) {
            return invokeL.intValue;
        }
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
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0061, code lost:
        if (r6 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006c, code lost:
        if (r6 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006e, code lost:
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0071, code lost:
        return r8;
     */
    @Override // com.baidu.wallet.api.internal.IContacts
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<ContractInfo> loadAllPhone(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) != null) {
            return (List) invokeL.objValue;
        }
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
        InterceptResult invokeLL;
        Cursor cursor;
        Cursor cursor2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, uri, context)) != null) {
            return (List) invokeLL.objValue;
        }
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
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006f, code lost:
        if (r7 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007a, code lost:
        if (r7 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007c, code lost:
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007f, code lost:
        return r9;
     */
    @Override // com.baidu.wallet.api.internal.IContacts
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ConcurrentHashMap<String, ContractInfo> loadPhoneContracts(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048579, this, context)) != null) {
            return (ConcurrentHashMap) invokeL.objValue;
        }
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

    /* JADX WARN: Removed duplicated region for block: B:30:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.wallet.api.internal.IContacts
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<String> loadRawPhone(@NonNull Uri uri, @NonNull Context context) {
        InterceptResult invokeLL;
        Cursor cursor;
        Cursor cursor2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048580, this, uri, context)) != null) {
            return (List) invokeLL.objValue;
        }
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
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006d, code lost:
        if (r8 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0078, code lost:
        if (r8 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007a, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007d, code lost:
        return r0;
     */
    @Override // com.baidu.wallet.api.internal.IContacts
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ConcurrentHashMap<String, ContractInfo> loadSimContracts(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048581, this, context)) != null) {
            return (ConcurrentHashMap) invokeL.objValue;
        }
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
                    String string2 = cursor.getString(cursor.getColumnIndex("number"));
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
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, activity, i2)) == null) {
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setData(ContactsContract.Contacts.CONTENT_URI);
            if (activity != null) {
                try {
                    activity.startActivityForResult(intent, i2);
                    return true;
                } catch (ActivityNotFoundException e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    @Override // com.baidu.wallet.api.internal.IContacts
    public boolean pickContactsByPhoneContentType(@NonNull Activity activity, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, activity, i2)) == null) {
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("vnd.android.cursor.dir/phone_v2");
            if (activity != null) {
                try {
                    activity.startActivityForResult(intent, i2);
                    return true;
                } catch (ActivityNotFoundException e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }
}
