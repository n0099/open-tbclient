package com.baidu.tieba;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.net.URLConnection;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class zr1 extends or1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements ActivityResultConsumer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ zr1 b;

        public a(zr1 zr1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zr1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zr1Var;
            this.a = str;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
        public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, activityResultDispatcher, i, intent)) == null) {
                this.b.d(this.a, new lv1(0));
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zr1(@NonNull mr1 mr1Var) {
        super(mr1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mr1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mr1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.or1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "File" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.or1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "FileApi" : (String) invokeV.objValue;
    }

    public final String x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf > 0) {
                String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str.substring(lastIndexOf + 1));
                return !TextUtils.isEmpty(contentTypeFor) ? contentTypeFor : "*/*";
            }
            return "*/*";
        }
        return (String) invokeL.objValue;
    }

    public lv1 y(String str) {
        InterceptResult invokeL;
        Uri fromFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#shareFile", false);
            if (n()) {
                l02.c("FileApi", "FileApi does not supported when app is invisible.");
                return new lv1(1001, "FileApi does not supported when app is invisible.");
            }
            Pair<lv1, JSONObject> s = s(str);
            lv1 lv1Var = (lv1) s.first;
            if (lv1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("filePath");
                String M = ta3.M(optString, l33.g0());
                if (!TextUtils.isEmpty(optString) && ta3.s(optString) == PathType.BD_FILE && !TextUtils.isEmpty(M)) {
                    String optString2 = jSONObject.optString("cb");
                    if (TextUtils.isEmpty(optString2)) {
                        l02.c("FileApi", "cb is required");
                        return new lv1(202, "cb is required");
                    }
                    File file = new File(M);
                    if (file.exists() && !file.isDirectory()) {
                        SwanAppActivity activity = yo2.U().getActivity();
                        if (activity == null) {
                            l02.c("FileApi", "activity null");
                            return new lv1(1001, "activity null");
                        }
                        ActivityResultDispatcher resultDispatcher = activity.getResultDispatcher();
                        Intent intent = new Intent();
                        if (sf3.i()) {
                            fromFile = ih3.a(activity, file);
                            intent.setFlags(3);
                        } else {
                            fromFile = Uri.fromFile(file);
                        }
                        intent.setAction("android.intent.action.SEND");
                        intent.putExtra("android.intent.extra.STREAM", fromFile);
                        intent.setType(x(M));
                        resultDispatcher.addConsumer(new a(this, optString2));
                        resultDispatcher.startActivityForResult(Intent.createChooser(intent, "分享到..."));
                        return lv1.f();
                    }
                    l02.c("FileApi", "file not exists");
                    return new lv1(1001, "file not exists");
                }
                l02.c("FileApi", "a valid filePath is required");
                return new lv1(202, "a valid filePath is required");
            }
            return lv1Var;
        }
        return (lv1) invokeL.objValue;
    }
}
