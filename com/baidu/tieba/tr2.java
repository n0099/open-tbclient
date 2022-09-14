package com.baidu.tieba;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.d83;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.File;
import java.net.URI;
import org.json.JSONObject;
import rx.schedulers.Schedulers;
/* loaded from: classes6.dex */
public class tr2 extends v43 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements rh3<b83<d83.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ File d;
        public final /* synthetic */ UnitedSchemeEntity e;
        public final /* synthetic */ tr2 f;

        public a(tr2 tr2Var, CallbackHandler callbackHandler, String str, Context context, File file, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tr2Var, callbackHandler, str, context, file, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = tr2Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = context;
            this.d = file;
            this.e = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rh3
        /* renamed from: b */
        public void a(b83<d83.e> b83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b83Var) == null) {
                if (w73.h(b83Var)) {
                    this.f.u(this.c, this.d, this.e, this.a, this.b);
                } else {
                    w73.q(b83Var, this.a, this.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements by2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ File b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ UnitedSchemeEntity e;
        public final /* synthetic */ tr2 f;

        public b(tr2 tr2Var, Context context, File file, CallbackHandler callbackHandler, String str, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tr2Var, context, file, callbackHandler, str, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = tr2Var;
            this.a = context;
            this.b = file;
            this.c = callbackHandler;
            this.d = str;
            this.e = unitedSchemeEntity;
        }

        @Override // com.baidu.tieba.by2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (v43.b) {
                    Log.d("SwanAppAction", str + "");
                }
                this.f.x(this.a, this.b, this.c, this.d);
            }
        }

        @Override // com.baidu.tieba.by2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.safeCallback(this.c, this.e, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ex9<File> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ tr2 d;

        public c(tr2 tr2Var, CallbackHandler callbackHandler, String str, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tr2Var, callbackHandler, str, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = tr2Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ex9
        public void call(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                if (file == null) {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001, "output file create fail").toString());
                    return;
                }
                Uri fromFile = Uri.fromFile(file);
                this.d.w(this.c, file.getPath(), -1L);
                this.c.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", fromFile));
                if (v43.b) {
                    Log.i("SaveVideoAction", "saveToAlbum : file = " + file);
                }
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ix9<File, File> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ tr2 b;

        public d(tr2 tr2Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tr2Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tr2Var;
            this.a = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ix9
        public File call(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) {
                String x = ga3.x(y23.g0());
                if (TextUtils.isEmpty(x) || !file.getPath().startsWith(x)) {
                    return null;
                }
                return this.b.q(this.a, file);
            }
            return (File) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tr2(v33 v33Var) {
        super(v33Var, "/swanAPI/saveVideoToPhotosAlbum");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v33Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static File t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath());
            if (file.exists()) {
                String str = "video";
                File file2 = new File(file, (new File(file, "Video").exists() || !new File(file, "video").exists()) ? "Video" : "Video");
                if ((file2.exists() || file2.mkdirs()) && file2.canWrite()) {
                    return file2;
                }
            }
            File file3 = new File(Environment.getExternalStorageDirectory().getPath() + File.separator + "baidu" + File.separator + FileUtils.SEARCHBOX_FOLDER + File.separator + "Video");
            if (file3.exists() || file3.mkdirs()) {
                return file3;
            }
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                File file4 = new File(externalFilesDir.getPath() + File.separator + "Video");
                if (file4.exists() || file4.mkdirs()) {
                    return file4;
                }
            }
            File file5 = new File(context.getFilesDir().getPath() + File.separator + "Video");
            if (file5.exists() || file5.mkdirs()) {
                return file5;
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    @Override // com.baidu.tieba.v43
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, y23 y23Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, y23Var)) == null) {
            if (y23Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
                return false;
            } else if (y23Var.n0()) {
                if (v43.b) {
                    Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            } else {
                JSONObject a2 = v43.a(unitedSchemeEntity, "params");
                if (a2 == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal params");
                    return false;
                }
                String optString = a2.optString("filePath");
                try {
                    File file = null;
                    if ("bdfile".equalsIgnoreCase(URI.create(optString).getScheme())) {
                        String M = ga3.M(optString, y23Var.b);
                        if (!TextUtils.isEmpty(M)) {
                            file = new File(M);
                        }
                    } else {
                        String L = ga3.L(optString, y23Var, y23Var.k0());
                        if (!TextUtils.isEmpty(L)) {
                            file = new File(L);
                        }
                    }
                    if (file != null && file.exists() && file.isFile()) {
                        String optString2 = a2.optString("cb");
                        if (TextUtils.isEmpty(optString2)) {
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                            return false;
                        }
                        y23Var.e0().g(context, "mapp_images", new a(this, callbackHandler, optString2, context, file, unitedSchemeEntity));
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                        return true;
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "can not find such file : " + file);
                    return false;
                } catch (Exception e) {
                    if (v43.b) {
                        e.printStackTrace();
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "Illegal file_path : " + optString);
                    return false;
                }
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return new File(str).exists();
        }
        return invokeL.booleanValue;
    }

    public final File q(Context context, @NonNull File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, file)) == null) {
            File t = t(context);
            if (t == null) {
                return null;
            }
            File file2 = new File(t, file.getName());
            if (cj4.f(file, file2) > 0) {
                return file2;
            }
            return null;
        }
        return (File) invokeLL.objValue;
    }

    public final long r(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) ? j <= 0 ? System.currentTimeMillis() : j : invokeJ.longValue;
    }

    public final String s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            String lowerCase = str.toLowerCase();
            return (lowerCase.endsWith("mp4") || lowerCase.endsWith("mpeg4") || !lowerCase.endsWith("3gp")) ? MimeTypes.VIDEO_MP4 : "video/3gp";
        }
        return (String) invokeL.objValue;
    }

    public final void u(@NonNull Context context, @NonNull File file, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048581, this, context, file, unitedSchemeEntity, callbackHandler, str) == null) {
            ay2.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new b(this, context, file, callbackHandler, str, unitedSchemeEntity));
        }
    }

    public final ContentValues v(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048582, this, str, j)) == null) {
            ContentValues contentValues = new ContentValues();
            File file = new File(str);
            long r = r(j);
            contentValues.put("title", file.getName());
            contentValues.put("_display_name", file.getName());
            contentValues.put("date_modified", Long.valueOf(r));
            contentValues.put("date_added", Long.valueOf(r));
            contentValues.put("_data", file.getAbsolutePath());
            contentValues.put("_size", Long.valueOf(file.length()));
            return contentValues;
        }
        return (ContentValues) invokeLJ.objValue;
    }

    public final void w(Context context, String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, str, Long.valueOf(j)}) == null) && p(str)) {
            long r = r(j);
            ContentValues v = v(str, r);
            v.put("datetaken", Long.valueOf(r));
            v.put("mime_type", s(str));
            context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, v);
        }
    }

    public final void x(@NonNull Context context, @NonNull File file, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, file, callbackHandler, str) == null) {
            if (file == null) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "can not save to album : " + file).toString());
                return;
            }
            qw9.f(file).h(new d(this, context)).y(Schedulers.io()).k(ax9.b()).w(new c(this, callbackHandler, str, context));
        }
    }
}
