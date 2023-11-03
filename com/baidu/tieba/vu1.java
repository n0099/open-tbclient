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
/* loaded from: classes8.dex */
public class vu1 extends ku1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ku1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "File" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ku1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "FileApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements ActivityResultConsumer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ vu1 b;

        public a(vu1 vu1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vu1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vu1Var;
            this.a = str;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
        public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, activityResultDispatcher, i, intent)) == null) {
                this.b.d(this.a, new hy1(0));
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vu1(@NonNull iu1 iu1Var) {
        super(iu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iu1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((iu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final String y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf > 0) {
                String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str.substring(lastIndexOf + 1));
                if (!TextUtils.isEmpty(contentTypeFor)) {
                    return contentTypeFor;
                }
                return "*/*";
            }
            return "*/*";
        }
        return (String) invokeL.objValue;
    }

    public hy1 z(String str) {
        InterceptResult invokeL;
        Uri fromFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            r("#shareFile", false);
            if (o()) {
                g32.c("FileApi", "FileApi does not supported when app is invisible.");
                return new hy1(1001, "FileApi does not supported when app is invisible.");
            }
            Pair<hy1, JSONObject> t = t(str);
            hy1 hy1Var = (hy1) t.first;
            if (!hy1Var.isSuccess()) {
                return hy1Var;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            String optString = jSONObject.optString("filePath");
            String M = od3.M(optString, g63.h0());
            if (!TextUtils.isEmpty(optString) && od3.s(optString) == PathType.BD_FILE && !TextUtils.isEmpty(M)) {
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    g32.c("FileApi", "cb is required");
                    return new hy1(202, "cb is required");
                }
                File file = new File(M);
                if (file.exists() && !file.isDirectory()) {
                    SwanAppActivity activity = tr2.V().getActivity();
                    if (activity == null) {
                        g32.c("FileApi", "activity null");
                        return new hy1(1001, "activity null");
                    }
                    ActivityResultDispatcher resultDispatcher = activity.getResultDispatcher();
                    Intent intent = new Intent();
                    if (ni3.i()) {
                        fromFile = dk3.a(activity, file);
                        intent.setFlags(3);
                    } else {
                        fromFile = Uri.fromFile(file);
                    }
                    intent.setAction("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.STREAM", fromFile);
                    intent.setType(y(M));
                    resultDispatcher.addConsumer(new a(this, optString2));
                    resultDispatcher.startActivityForResult(Intent.createChooser(intent, "分享到..."));
                    return hy1.f();
                }
                g32.c("FileApi", "file not exists");
                return new hy1(1001, "file not exists");
            }
            g32.c("FileApi", "a valid filePath is required");
            return new hy1(202, "a valid filePath is required");
        }
        return (hy1) invokeL.objValue;
    }
}
