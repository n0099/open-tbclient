package com.baidu.wallet.utils;

import android.app.DownloadManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class Downloader {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: f  reason: collision with root package name */
    public static final int f63536f = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public DownloadManager f63537a;

    /* renamed from: b  reason: collision with root package name */
    public final Pattern f63538b;

    /* renamed from: c  reason: collision with root package name */
    public final Pattern f63539c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f63540d;

    /* renamed from: e  reason: collision with root package name */
    public ContentResolver f63541e;

    /* renamed from: g  reason: collision with root package name */
    public final String f63542g;

    /* loaded from: classes8.dex */
    public interface DownloaderListener {
        void onProgress(String str, int i2, long j2, long j3);
    }

    /* loaded from: classes8.dex */
    public final class a extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Downloader f63544a;

        /* renamed from: b  reason: collision with root package name */
        public long f63545b;

        /* renamed from: c  reason: collision with root package name */
        public DownloaderListener f63546c;

        /* renamed from: d  reason: collision with root package name */
        public String f63547d;

        /* renamed from: e  reason: collision with root package name */
        public final int f63548e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Downloader downloader, Handler handler, String str, long j2, DownloaderListener downloaderListener) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloader, handler, str, Long.valueOf(j2), downloaderListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Handler) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63544a = downloader;
            this.f63548e = 24;
            this.f63547d = str;
            this.f63545b = j2;
            this.f63546c = downloaderListener;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x006b, code lost:
            r11.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x006e, code lost:
            return;
         */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0087  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void a(long j2) {
            Cursor cursor;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(65537, this, j2) == null) {
                Cursor cursor2 = null;
                try {
                    try {
                        cursor = this.f63544a.f63537a.query(new DownloadManager.Query().setFilterById(j2));
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = j2;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Exception unused) {
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
                if (cursor != null) {
                    try {
                    } catch (Exception unused2) {
                        this.f63546c = null;
                        this.f63544a.f63541e.unregisterContentObserver(this);
                        if (cursor == null) {
                            return;
                        }
                        cursor.close();
                    }
                    if (cursor.getCount() != 0 && cursor.moveToFirst()) {
                        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(PackageTable.TOTAL_SIZE);
                        int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("bytes_so_far");
                        int columnIndex = cursor.getColumnIndex("status");
                        long j3 = cursor.getLong(columnIndexOrThrow);
                        long j4 = cursor.getLong(columnIndexOrThrow2);
                        int i2 = cursor.getInt(columnIndex);
                        if (this.f63546c != null) {
                            this.f63546c.onProgress(this.f63547d, i2, j3, j4);
                        }
                        if ((i2 & 24) != 0) {
                            this.f63546c = null;
                            this.f63544a.f63541e.unregisterContentObserver(this);
                        }
                        if (cursor == null) {
                            return;
                        }
                        cursor.close();
                    }
                }
            }
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.onChange(z);
                a(this.f63545b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f63549a;

        /* renamed from: b  reason: collision with root package name */
        public DownloaderListener f63550b;

        /* renamed from: c  reason: collision with root package name */
        public String f63551c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Downloader f63552d;

        public b(Downloader downloader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63552d = downloader;
        }
    }

    /* loaded from: classes8.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Downloader f63553a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-947857023, "Lcom/baidu/wallet/utils/Downloader$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-947857023, "Lcom/baidu/wallet/utils/Downloader$c;");
                    return;
                }
            }
            f63553a = new Downloader();
        }

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public static Downloader getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? c.f63553a : (Downloader) invokeV.objValue;
    }

    public void download(String str, String str2, DownloaderListener downloaderListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, downloaderListener) == null) {
            if (str != null ? this.f63539c.matcher(str).matches() : false) {
                b bVar = new b();
                bVar.f63549a = str;
                bVar.f63550b = downloaderListener;
                bVar.f63551c = str2;
                this.f63540d.obtainMessage(1, bVar).sendToTarget();
                return;
            }
            a(downloaderListener, str);
        }
    }

    public void init(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) && this.f63537a == null && context != null) {
            this.f63537a = (DownloadManager) context.getSystemService("download");
            this.f63541e = context.getContentResolver();
            HandlerThread handlerThread = new HandlerThread("downloader");
            handlerThread.start();
            this.f63540d = new Handler(this, handlerThread.getLooper()) { // from class: com.baidu.wallet.utils.Downloader.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Downloader f63543a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((Looper) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f63543a = this;
                }

                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) && 1 == message.what) {
                        b bVar = (b) message.obj;
                        if (this.f63543a.f63537a == null) {
                            this.f63543a.a(bVar.f63550b, bVar.f63549a);
                        } else {
                            this.f63543a.a(bVar.f63549a, bVar.f63550b, bVar.f63551c);
                        }
                    }
                }
            };
        }
    }

    public Downloader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63538b = Pattern.compile(".*\\/(.*)");
        this.f63539c = Pattern.compile("^(https?)://.*");
        this.f63542g = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DOWNLOADS + File.separator;
    }

    private String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, str)) == null) {
            String str2 = str.startsWith(this.f63542g) ? null : this.f63542g;
            File parentFile = new File(str2, str).getParentFile();
            parentFile.mkdirs();
            if (parentFile.isDirectory()) {
                return str2 == null ? str.substring(this.f63542g.length()) : str;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, DownloaderListener downloaderListener, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, this, str, downloaderListener, str2) == null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = a(str);
            }
            if (str2 == null) {
                a(downloaderListener, str);
                return;
            }
            String b2 = b(str2);
            if (b2 == null) {
                a(downloaderListener, str);
                return;
            }
            try {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
                request.setNotificationVisibility(2);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, b2);
                request.setAllowedNetworkTypes(2);
                long enqueue = this.f63537a.enqueue(request);
                a aVar = new a(this, this.f63540d, str, enqueue, downloaderListener);
                this.f63541e.registerContentObserver(Uri.parse("content://downloads/my_downloads/" + enqueue), true, aVar);
            } catch (Exception e2) {
                a(downloaderListener, str);
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DownloaderListener downloaderListener, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, downloaderListener, str) == null) || downloaderListener == null) {
            return;
        }
        downloaderListener.onProgress(str, 16, 0L, 0L);
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            Matcher matcher = this.f63538b.matcher(str);
            if (matcher.matches()) {
                return matcher.group(1);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
