package com.baidu.wallet.lightapp.business;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.analytics.Tracker;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.VerSig;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes13.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes13.dex */
    public interface a {
        void a(String[] strArr);
    }

    /* loaded from: classes13.dex */
    public static class b extends FilterInputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final HttpURLConnection a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(HttpURLConnection httpURLConnection) {
            super(c.b(httpURLConnection));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {httpURLConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((InputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.close();
                this.a.disconnect();
            }
        }
    }

    public static String[] c(String str, String[] strArr, Context context) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, str, strArr, context)) == null) {
            LogUtil.i(BeanConstants.WEB_VIEW_CACHE_TAG, "START: load cache");
            return a(str, strArr, context, true, false);
        }
        return (String[]) invokeLLL.objValue;
    }

    public static String[] d(String str, String[] strArr, Context context) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65552, null, str, strArr, context)) == null) {
            LogUtil.i(BeanConstants.WEB_VIEW_CACHE_TAG, "START: load network");
            return a(str, strArr, context, false, true);
        }
        return (String[]) invokeLLL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            String name = new File(URI.create(str).getPath()).getName();
            int lastIndexOf = name.lastIndexOf(46);
            return lastIndexOf > 0 ? name.substring(0, lastIndexOf) : name;
        }
        return (String) invokeL.objValue;
    }

    public static boolean b(CharSequence[] charSequenceArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, charSequenceArr)) == null) {
            if (charSequenceArr == null) {
                return true;
            }
            for (CharSequence charSequence : charSequenceArr) {
                if (!TextUtils.isEmpty(charSequence)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void a(String str, Context context, String[] strArr, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, str, context, strArr, aVar) == null) {
            new Thread(str, strArr, context, aVar) { // from class: com.baidu.wallet.lightapp.business.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String[] f53646b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Context f53647c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ a f53648d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str, strArr, context, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = str;
                    this.f53646b = strArr;
                    this.f53647c = context;
                    this.f53648d = aVar;
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.run();
                        LogUtil.i(BeanConstants.WEB_VIEW_CACHE_TAG, "ZipFileLoader load: " + this.a);
                        String[] strArr2 = new String[0];
                        long uptimeMillis = SystemClock.uptimeMillis();
                        try {
                            strArr2 = c.c(this.a, this.f53646b, this.f53647c);
                            LogUtil.i(BeanConstants.WEB_VIEW_CACHE_TAG, "END: cache duration: " + (SystemClock.uptimeMillis() - uptimeMillis));
                        } catch (IOException e2) {
                            LogUtil.e(BeanConstants.WEB_VIEW_CACHE_TAG, "EXCEPTION on load from cache", e2);
                            Tracker.send(LightAppStatEvent.OFFLINECACHE_DOWNLOAD_JSHOOK_FILE_FAILED, Arrays.asList(this.a, "EXCEPTION on load from cache", e2.toString()), this.f53647c);
                        }
                        if (c.b(strArr2)) {
                            long uptimeMillis2 = SystemClock.uptimeMillis();
                            try {
                                String str2 = this.a;
                                String[] strArr3 = this.f53646b;
                                Context context2 = this.f53647c;
                                strArr2 = c.b(str2, strArr3, context2, c.b(this.a) + File.separatorChar);
                                LogUtil.i(BeanConstants.WEB_VIEW_CACHE_TAG, "END: local duration: " + (SystemClock.uptimeMillis() - uptimeMillis2));
                            } catch (IOException e3) {
                                LogUtil.e(BeanConstants.WEB_VIEW_CACHE_TAG, "EXCEPTION on load from local", e3);
                                if (!(e3 instanceof FileNotFoundException)) {
                                    Tracker.send(LightAppStatEvent.OFFLINECACHE_DOWNLOAD_JSHOOK_FILE_FAILED, Arrays.asList(this.a, "EXCEPTION on load from local", e3.toString()), this.f53647c);
                                }
                            }
                            a aVar2 = this.f53648d;
                            if (aVar2 != null) {
                                aVar2.a(strArr2);
                                LogUtil.i(BeanConstants.WEB_VIEW_CACHE_TAG, "RESULT: load from local, is empty: " + c.b(strArr2));
                            }
                            try {
                                long uptimeMillis3 = SystemClock.uptimeMillis();
                                c.d(this.a, this.f53646b, this.f53647c);
                                LogUtil.i(BeanConstants.WEB_VIEW_CACHE_TAG, "END: network duration: " + (SystemClock.uptimeMillis() - uptimeMillis3));
                                return;
                            } catch (IOException e4) {
                                LogUtil.e(BeanConstants.WEB_VIEW_CACHE_TAG, "EXCEPTION on load from network", e4);
                                Tracker.send(LightAppStatEvent.OFFLINECACHE_DOWNLOAD_JSHOOK_FILE_FAILED, Arrays.asList(this.a, "EXCEPTION on load from network", e4.toString()), this.f53647c);
                                return;
                            }
                        }
                        a aVar3 = this.f53648d;
                        if (aVar3 != null) {
                            aVar3.a(strArr2);
                            LogUtil.i(BeanConstants.WEB_VIEW_CACHE_TAG, "RESULT: load from cache, is empty: " + c.b(strArr2));
                        }
                    }
                }
            }.start();
        }
    }

    public static String[] b(String str, String[] strArr, Context context, String str2) throws IOException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65550, null, str, strArr, context, str2)) == null) {
            if (strArr == null) {
                return new String[0];
            }
            String[] strArr2 = new String[strArr.length];
            LogUtil.i(BeanConstants.WEB_VIEW_CACHE_TAG, "START: load local");
            String str3 = null;
            boolean z = false;
            for (int i2 = 0; i2 < strArr.length; i2++) {
                byte[] a2 = a(DxmApplicationContextImpl.getApplicationContext(context).getAssets().open(str2 + strArr[i2] + ".sig"), true);
                byte[] a3 = a(DxmApplicationContextImpl.getApplicationContext(context).getAssets().open(str2 + strArr[i2]), true);
                if (VerSig.verify(a2, a3, "SHA-1")) {
                    strArr2[i2] = new String(a3);
                    LogUtil.i(BeanConstants.WEB_VIEW_CACHE_TAG, strArr[i2] + " verify passed");
                } else {
                    LogUtil.i(BeanConstants.WEB_VIEW_CACHE_TAG, strArr[i2] + " verify failed");
                    str3 = TextUtils.isEmpty(str3) ? strArr[i2] : str3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + strArr[i2];
                    z = true;
                }
            }
            if (z) {
                String[] strArr3 = new String[0];
                a(str3, str, context);
                return strArr3;
            }
            return strArr2;
        }
        return (String[]) invokeLLLL.objValue;
    }

    public static void a(String str, String str2, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, str, str2, context) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("url", str2);
        linkedHashMap.put(com.baidu.fsg.face.base.b.c.f34980g, str);
        Tracker.send(LightAppStatEvent.JS_FILE_VERIFY_FAILED, linkedHashMap, context);
    }

    public static byte[] a(InputStream inputStream, boolean z) throws IOException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65542, null, inputStream, z)) == null) {
            if (inputStream != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } finally {
                        if (z) {
                            inputStream.close();
                        }
                        byteArrayOutputStream.close();
                    }
                }
                return byteArrayOutputStream.toByteArray();
            }
            throw new IOException("The input stream is null!");
        }
        return (byte[]) invokeLZ.objValue;
    }

    public static String[] a(String str, String[] strArr, Context context, boolean z, boolean z2) throws IOException {
        InterceptResult invokeCommon;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{str, strArr, context, Boolean.valueOf(z), Boolean.valueOf(z2)})) != null) {
            return (String[]) invokeCommon.objValue;
        }
        if (strArr == null) {
            return new String[0];
        }
        int length = strArr.length;
        String[] strArr2 = new String[length];
        ZipInputStream zipInputStream = null;
        String str2 = null;
        r4 = null;
        ZipInputStream zipInputStream2 = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setUseCaches(true);
            a(z, z2, httpURLConnection);
            LogUtil.i(BeanConstants.WEB_VIEW_CACHE_TAG, "status code: " + httpURLConnection.getResponseCode() + ", msg: " + httpURLConnection.getResponseMessage());
            List asList = Arrays.asList(strArr);
            String[] strArr3 = new String[strArr.length];
            if (httpURLConnection.getResponseCode() == 200) {
                ZipInputStream zipInputStream3 = new ZipInputStream(new b(httpURLConnection));
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream3.getNextEntry();
                        if (nextEntry == null) {
                            break;
                        }
                        String name = nextEntry.getName();
                        int indexOf2 = asList.indexOf(name);
                        if (indexOf2 >= 0) {
                            strArr2[indexOf2] = new String(a(zipInputStream3, false));
                        }
                        if (name.endsWith(".sig") && (indexOf = asList.indexOf(name.substring(0, name.length() - 4))) >= 0) {
                            strArr3[indexOf] = new String(a(zipInputStream3, false));
                        }
                    } catch (Throwable th) {
                        th = th;
                        zipInputStream = zipInputStream3;
                        if (zipInputStream != null) {
                            zipInputStream.close();
                        }
                        throw th;
                    }
                }
                boolean z3 = false;
                for (int i2 = 0; i2 < length; i2++) {
                    if (VerSig.verify(strArr3[i2], strArr2[i2], "SHA-1")) {
                        LogUtil.i(BeanConstants.WEB_VIEW_CACHE_TAG, strArr[i2] + " verify passed");
                    } else {
                        LogUtil.i(BeanConstants.WEB_VIEW_CACHE_TAG, strArr[i2] + " verify failed");
                        str2 = TextUtils.isEmpty(str2) ? strArr[i2] : str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + strArr[i2];
                        z3 = true;
                    }
                }
                if (z3) {
                    String[] strArr4 = new String[0];
                    a(str2, str, context);
                    strArr2 = strArr4;
                }
                zipInputStream2 = zipInputStream3;
            } else if (!z) {
                Tracker.send(LightAppStatEvent.OFFLINECACHE_DOWNLOAD_JSHOOK_FILE_FAILED, Arrays.asList(str, httpURLConnection.getResponseMessage(), String.valueOf(httpURLConnection.getResponseCode())), context);
            }
            if (zipInputStream2 != null) {
                zipInputStream2.close();
            }
            return strArr2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static InputStream b(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, httpURLConnection)) == null) {
            try {
                return httpURLConnection.getInputStream();
            } catch (IOException unused) {
                return httpURLConnection.getErrorStream();
            }
        }
        return (InputStream) invokeL.objValue;
    }

    public static void a(boolean z, boolean z2, HttpURLConnection httpURLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), httpURLConnection}) == null) {
            if (z && z2) {
                return;
            }
            if (z) {
                httpURLConnection.addRequestProperty("Cache-Control", "only-if-cached");
                httpURLConnection.addRequestProperty("Cache-Control", "max-stale=31536000");
            }
            if (z2) {
                httpURLConnection.addRequestProperty("Cache-Control", "no-cache");
            }
        }
    }
}
