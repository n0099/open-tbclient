package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.nadcore.webarch.permission.NadPermissionActivity;
import com.baidu.tieba.r71;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class v81 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ValueCallback<Uri> a;
    public String b;
    public ValueCallback<Uri[]> c;
    public u81 d;
    public boolean e;
    public boolean f;
    public Activity g;
    public boolean h;

    /* loaded from: classes8.dex */
    public class a implements r71.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ v81 b;

        public a(v81 v81Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v81Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v81Var;
            this.a = i;
        }

        @Override // com.baidu.tieba.r71.b
        @RequiresApi(api = 21)
        public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, strArr, iArr) == null) && i == this.a) {
                if (iArr.length == 0) {
                    z = false;
                } else {
                    z = true;
                }
                for (int i2 : iArr) {
                    if (i2 == -1) {
                        z = false;
                    }
                }
                if (z) {
                    this.b.h = false;
                    v81 v81Var = this.b;
                    v81Var.startActivityForResult(v81Var.k(), 11);
                } else if (this.b.c != null) {
                    this.b.c.onReceiveValue(null);
                }
                u71.b().d(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements r71.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v81 a;

        public b(v81 v81Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v81Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v81Var;
        }

        @Override // com.baidu.tieba.r71.b
        public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, strArr, iArr) == null) && i == 4099) {
                if (iArr.length == 0) {
                    z = false;
                } else {
                    z = true;
                }
                for (int i2 : iArr) {
                    if (i2 == -1) {
                        z = false;
                    }
                }
                if (z) {
                    this.a.h = true;
                    v81 v81Var = this.a;
                    v81Var.startActivityForResult(v81Var.j(), 11);
                }
                u71.b().d(4099);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements r71.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v81 a;

        public c(v81 v81Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v81Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v81Var;
        }

        @Override // com.baidu.tieba.r71.b
        public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(1048576, this, i, strArr, iArr) == null) && i == 4099) {
                if (iArr.length == 0) {
                    z = false;
                } else {
                    z = true;
                }
                for (int i2 : iArr) {
                    if (i2 == -1) {
                        z = false;
                    }
                }
                if (z) {
                    this.a.h = true;
                    this.a.g.startActivityForResult(this.a.h(), 11);
                }
                u71.b().d(4099);
            }
        }
    }

    public v81(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = false;
        this.g = activity;
    }

    public boolean startActivityForResult(Intent intent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, intent, i)) == null) {
            try {
                try {
                    this.g.startActivityForResult(intent, i);
                    return true;
                } catch (ActivityNotFoundException unused) {
                    g();
                    return false;
                }
            } catch (ActivityNotFoundException unused2) {
                this.f = true;
                this.g.startActivityForResult(m(), i);
                return true;
            }
        }
        return invokeLI.booleanValue;
    }

    private void requestPermissions(int i, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65543, this, i, strArr) == null) {
            Intent intent = new Intent(this.g.getApplicationContext(), NadPermissionActivity.class);
            intent.putExtra("request_code", i);
            intent.putExtra("permissions", strArr);
            u71.b().a(i, new a(this, i));
            try {
                i61.c(this.g, intent);
            } catch (Exception unused) {
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ValueCallback<Uri> valueCallback = this.a;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
            ValueCallback<Uri[]> valueCallback2 = this.c;
            if (valueCallback2 != null) {
                valueCallback2.onReceiveValue(null);
            }
        }
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return (Activity) invokeV.objValue;
    }

    public final Intent n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return new Intent("android.provider.MediaStore.RECORD_SOUND");
        }
        return (Intent) invokeV.objValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public final Intent h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (y81.a(this.g)) {
                return new Intent("android.media.action.VIDEO_CAPTURE");
            }
            Intent intent = new Intent(this.g.getApplicationContext(), NadPermissionActivity.class);
            intent.putExtra("request_code", 4099);
            intent.putExtra("permissions", new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE});
            u71.b().a(4099, new c(this));
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    public final Intent m() {
        InterceptResult invokeV;
        u81 u81Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("*/*");
            Intent l = l(i(), h(), n());
            l.putExtra("android.intent.extra.INTENT", intent);
            if (Build.VERSION.SDK_INT >= 21 && (u81Var = this.d) != null) {
                l.putExtra("android.intent.extra.INTENT", u81Var.a());
            }
            return l;
        }
        return (Intent) invokeV.objValue;
    }

    public Intent i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (y81.a(this.g) && y81.b(this.g)) {
                return j();
            }
            Intent intent = new Intent(this.g.getApplicationContext(), NadPermissionActivity.class);
            intent.putExtra("request_code", 4099);
            String[] strArr = {PermissionRequest.RESOURCE_VIDEO_CAPTURE, "android.permission.WRITE_EXTERNAL_STORAGE"};
            if (Build.VERSION.SDK_INT >= 29 && !Environment.isExternalStorageLegacy()) {
                strArr = new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE};
            }
            intent.putExtra("permissions", strArr);
            u71.b().a(4099, new b(this));
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    @SuppressLint({"NewApi", "ObsoleteSdkInt"})
    public final Intent j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            File externalFilesDir = tj0.b().getExternalFilesDir(Environment.DIRECTORY_DCIM);
            File file = new File(externalFilesDir.getAbsolutePath() + File.separator + "nad-browser-photos");
            file.mkdirs();
            this.b = file.getAbsolutePath() + File.separator + System.currentTimeMillis() + ".jpg";
            if (Build.VERSION.SDK_INT >= 24) {
                intent.putExtra("output", FileProvider.getUriForFile(tj0.b(), tj0.c().a().v(), new File(this.b)));
            } else {
                intent.putExtra("output", Uri.fromFile(new File(this.b)));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                intent.setFlags(3);
            }
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    @RequiresApi(api = 21)
    @SuppressLint({"ObsoleteSdkInt"})
    public final Intent k() {
        InterceptResult invokeV;
        String[] strArr;
        String str;
        boolean z;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            u81 u81Var = this.d;
            if (u81Var != null) {
                strArr = u81Var.b();
            } else {
                strArr = null;
            }
            String str2 = "*/*";
            if (strArr == null || strArr.length <= 0) {
                str = "*/*";
            } else {
                str = strArr[0];
            }
            if (str != null && !str.trim().isEmpty()) {
                str2 = str;
            }
            ArrayList arrayList = new ArrayList();
            u81 u81Var2 = this.d;
            if (u81Var2 != null && u81Var2.getMode() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (str2.equals(BdUploadHandler.IMAGE_MIME_TYPE)) {
                arrayList.add(j());
            } else if (str2.equals(BdUploadHandler.VIDEO_MIME_TYPE)) {
                arrayList.add(new Intent("android.media.action.VIDEO_CAPTURE"));
            } else if (str2.equals(BdUploadHandler.AUDIO_MIME_TYPE)) {
                arrayList.add(n());
            }
            if (arrayList.isEmpty()) {
                arrayList.add(j());
                arrayList.add(h());
                arrayList.add(n());
            }
            if (str2.equals(BdUploadHandler.IMAGE_MIME_TYPE)) {
                intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, BdUploadHandler.IMAGE_MIME_TYPE);
                if (Build.VERSION.SDK_INT >= 18 && z) {
                    intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                }
            } else {
                Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
                if (Build.VERSION.SDK_INT >= 18 && z) {
                    intent2.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                }
                intent2.setType(str2);
                intent = intent2;
            }
            Intent intent3 = new Intent("android.intent.action.CHOOSER");
            if (!arrayList.isEmpty()) {
                intent3.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Intent[0]));
            }
            intent3.putExtra("android.intent.extra.INTENT", intent);
            return intent3;
        }
        return (Intent) invokeV.objValue;
    }

    public final Intent l(Intent... intentArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, intentArr)) == null) {
            Intent intent = new Intent("android.intent.action.CHOOSER");
            intent.putExtra("android.intent.extra.INITIAL_INTENTS", intentArr);
            intent.putExtra("android.intent.extra.TITLE", tj0.b().getResources().getString(R.string.nad_choose_upload));
            return intent;
        }
        return (Intent) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v2, resolved type: android.webkit.ValueCallback<android.net.Uri[]> */
    /* JADX WARN: Multi-variable type inference failed */
    public void p(int i, Intent intent) {
        Uri uri;
        Uri fromFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i, intent) == null) {
            if (this.h) {
                this.h = false;
                return;
            }
            if (i == -1 && intent == null && this.b == null) {
                i = 0;
            }
            if (i == 0 && this.f) {
                this.f = false;
                return;
            }
            if (intent != null && i == -1) {
                try {
                    uri = intent.getData();
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            } else {
                uri = null;
            }
            if (uri == null && intent == null && i == -1) {
                File file = new File(this.b);
                if (file.exists()) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        fromFile = FileProvider.getUriForFile(tj0.b(), tj0.c().a().v(), file);
                    } else {
                        fromFile = Uri.fromFile(file);
                    }
                    uri = fromFile;
                    tj0.b().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", uri));
                }
            }
            if (this.c != null) {
                ArrayList arrayList = new ArrayList();
                if (uri != null) {
                    arrayList.add(uri);
                } else if (intent != null && intent.getClipData() != null) {
                    ClipData clipData = intent.getClipData();
                    for (int i2 = 0; i2 < clipData.getItemCount(); i2++) {
                        arrayList.add(clipData.getItemAt(i2).getUri());
                    }
                }
                this.c.onReceiveValue(arrayList.toArray(new Uri[0]));
            }
            if (this.a != null) {
                this.a.onReceiveValue(uri);
            }
            this.e = true;
            this.f = false;
        }
    }

    @RequiresApi(api = 21)
    public boolean q(@NonNull ValueCallback<Uri[]> valueCallback, @NonNull u81 u81Var) {
        InterceptResult invokeLL;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, valueCallback, u81Var)) == null) {
            this.c = valueCallback;
            this.d = u81Var;
            String[] b2 = u81Var.b();
            if (b2 != null && b2.length > 0) {
                str = b2[0];
            } else {
                str = "*/*";
            }
            ArrayList arrayList = new ArrayList();
            if (str.equals(BdUploadHandler.IMAGE_MIME_TYPE)) {
                if (!y81.a(this.g)) {
                    arrayList.add(PermissionRequest.RESOURCE_VIDEO_CAPTURE);
                }
                if (Build.VERSION.SDK_INT >= 29 && !Environment.isExternalStorageLegacy()) {
                    z = false;
                } else {
                    z = true;
                }
                if (!y81.b(this.g) && z) {
                    arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                }
            } else if (str.equals(BdUploadHandler.VIDEO_MIME_TYPE) && !y81.a(this.g)) {
                arrayList.add(PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            }
            if (arrayList.isEmpty()) {
                if (!y81.a(this.g)) {
                    arrayList.add(PermissionRequest.RESOURCE_VIDEO_CAPTURE);
                }
                if (!y81.b(this.g)) {
                    arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                }
            }
            if (arrayList.size() > 0) {
                requestPermissions(4099, (String[]) arrayList.toArray(new String[0]));
                return true;
            }
            try {
                return startActivityForResult(k(), 11);
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
