package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f67756a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f67757b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f67758c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f67759d;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ a[] f67760f;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f67761e;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2095758227, "Lcom/bytedance/sdk/openadsdk/core/widget/webview/a/e$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2095758227, "Lcom/bytedance/sdk/openadsdk/core/widget/webview/a/e$a;");
                    return;
                }
            }
            f67756a = new a("HTML", 0, SapiWebView.DATA_MIME_TYPE);
            f67757b = new a("CSS", 1, "text/css");
            f67758c = new a("JS", 2, "application/x-javascript");
            a aVar = new a("IMAGE", 3, BdUploadHandler.IMAGE_MIME_TYPE);
            f67759d = aVar;
            f67760f = new a[]{f67756a, f67757b, f67758c, aVar};
        }

        public a(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f67761e = str2;
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (a) Enum.valueOf(a.class, str) : (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (a[]) f67760f.clone() : (a[]) invokeV.objValue;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67761e : (String) invokeV.objValue;
        }
    }

    public static a a(String str) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            a aVar2 = a.f67759d;
            if (TextUtils.isEmpty(str)) {
                return aVar2;
            }
            try {
                String path = Uri.parse(str).getPath();
                if (path != null) {
                    if (path.endsWith(FileHelper.FILE_CACHE_CSS)) {
                        aVar = a.f67757b;
                    } else if (path.endsWith(".js")) {
                        aVar = a.f67758c;
                    } else {
                        if (!path.endsWith(ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX) && !path.endsWith(".gif") && !path.endsWith(EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX) && !path.endsWith(".jpeg") && !path.endsWith(".webp") && !path.endsWith(".bmp") && !path.endsWith(".ico")) {
                            if (!path.endsWith(DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION)) {
                                return aVar2;
                            }
                            aVar = a.f67756a;
                        }
                        aVar = a.f67759d;
                    }
                    return aVar;
                }
                return aVar2;
            } catch (Throwable unused) {
                return aVar2;
            }
        }
        return (a) invokeL.objValue;
    }
}
