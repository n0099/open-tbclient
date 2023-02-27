package com.baidu.tieba;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Parcel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.k60;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.openid.IOpenID;
import java.security.MessageDigest;
/* loaded from: classes5.dex */
public class l60 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ k60.a b;

        public a(Context context, k60.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = aVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Signature[] signatureArr;
            String str;
            Parcel obtain;
            Parcel obtain2;
            MessageDigest messageDigest;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(1048576, this, componentName, iBinder) != null) {
                return;
            }
            iBinder.queryLocalInterface(IOpenID.Stub.DESCRIPTOR);
            String packageName = this.a.getPackageName();
            try {
                signatureArr = this.a.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Exception e) {
                this.b.a(false, null);
                e.printStackTrace();
                signatureArr = null;
            }
            try {
                try {
                    if (signatureArr != null && signatureArr.length > 0) {
                        byte[] byteArray = signatureArr[0].toByteArray();
                        try {
                            messageDigest = MessageDigest.getInstance("SHA1");
                        } catch (Exception e2) {
                            this.b.a(false, null);
                            e2.printStackTrace();
                        }
                        if (messageDigest != null) {
                            byte[] digest = messageDigest.digest(byteArray);
                            StringBuilder sb = new StringBuilder();
                            for (byte b : digest) {
                                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                            }
                            str = sb.toString();
                            obtain = Parcel.obtain();
                            obtain2 = Parcel.obtain();
                            obtain.writeInterfaceToken(IOpenID.Stub.DESCRIPTOR);
                            obtain.writeString(packageName);
                            obtain.writeString(str);
                            obtain.writeString("OUID");
                            iBinder.transact(1, obtain, obtain2, 0);
                            obtain2.readException();
                            String readString = obtain2.readString();
                            obtain.recycle();
                            obtain2.recycle();
                            this.b.a(true, readString);
                            return;
                        }
                    }
                    obtain.writeInterfaceToken(IOpenID.Stub.DESCRIPTOR);
                    obtain.writeString(packageName);
                    obtain.writeString(str);
                    obtain.writeString("OUID");
                    iBinder.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString2 = obtain2.readString();
                    obtain.recycle();
                    obtain2.recycle();
                    this.b.a(true, readString2);
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    this.b.a(false, null);
                    obtain.recycle();
                    obtain2.recycle();
                    return;
                }
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                throw th;
            }
            str = null;
            obtain = Parcel.obtain();
            obtain2 = Parcel.obtain();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
            }
        }
    }

    public static void a(Context context, k60.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, context, aVar) == null) {
            if (context == null) {
                aVar.a(false, null);
                return;
            }
            try {
                a aVar2 = new a(context, aVar);
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                context.bindService(intent, aVar2, 1);
            } catch (Throwable unused) {
                aVar.a(false, null);
            }
        }
    }
}
