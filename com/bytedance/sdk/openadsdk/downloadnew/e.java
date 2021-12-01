package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.u;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class e extends a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Context f54787b;

    public e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54787b = context;
    }

    public static e a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (a == null) {
                synchronized (e.class) {
                    if (a == null) {
                        a = new e(context);
                    }
                }
            }
            return a;
        }
        return (e) invokeL.objValue;
    }

    private DownloadModel b(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, obj)) == null) {
            if (obj instanceof DownloadModel) {
                return (DownloadModel) obj;
            }
            return null;
        }
        return (DownloadModel) invokeL.objValue;
    }

    private DownloadEventConfig c(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, obj)) == null) {
            if (obj instanceof DownloadEventConfig) {
                return (DownloadEventConfig) obj;
            }
            return null;
        }
        return (DownloadEventConfig) invokeL.objValue;
    }

    private DownloadController d(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, obj)) == null) {
            if (obj instanceof DownloadController) {
                return (DownloadController) obj;
            }
            return null;
        }
        return (DownloadController) invokeL.objValue;
    }

    private ExitInstallListener e(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, obj)) == null) {
            if (obj instanceof ExitInstallListener) {
                return (ExitInstallListener) obj;
            }
            return null;
        }
        return (ExitInstallListener) invokeL.objValue;
    }

    private u f(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, obj)) == null) {
            if (obj instanceof u) {
                return (u) obj;
            }
            return null;
        }
        return (u) invokeL.objValue;
    }

    private IDownloadButtonClickListener g(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, obj)) == null) {
            if (obj instanceof IDownloadButtonClickListener) {
                return (IDownloadButtonClickListener) obj;
            }
            return null;
        }
        return (IDownloadButtonClickListener) invokeL.objValue;
    }

    private Activity getActivity(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, obj)) == null) {
            if (obj instanceof Activity) {
                return (Activity) obj;
            }
            return null;
        }
        return (Activity) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.a, com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T callMethod(Class<T> cls, int i2, Map<String, Object> map) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, cls, i2, map)) == null) {
            switch (i2) {
                case 0:
                    return (T) Boolean.valueOf(d.a(getActivity(map.get("activity")), e(map.get(TTDownloadField.TT_EXIT_INSTALL_LISTENER))));
                case 1:
                    return (T) d.a().f();
                case 2:
                    try {
                        return (T) Boolean.valueOf(d.a((String) map.get(TTDownloadField.TT_TAG_INTERCEPT), (String) map.get("label"), new JSONObject((String) map.get("meta")), new HashMap()));
                    } catch (JSONException unused) {
                        return (T) Boolean.FALSE;
                    }
                case 3:
                    d.a(((Integer) map.get(TTDownloadField.TT_HID)).intValue());
                    return null;
                case 4:
                    d.a().a((String) map.get(TTDownloadField.TT_DOWNLOAD_URL), ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue());
                    return null;
                case 5:
                    d.a().a(this.f54787b, ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue(), a(map.get(TTDownloadField.TT_DOWNLOAD_STATUSCHANGE_LISTENER)), b(map.get(TTDownloadField.TT_DOWNLOAD_MODEL)));
                    return null;
                case 6:
                    return (T) Boolean.valueOf(d.a(this.f54787b, (String) map.get(TTDownloadField.TT_DOWNLOAD_URL)));
                case 7:
                    d.b();
                    return null;
                case 8:
                    d.a().a((String) map.get(TTDownloadField.TT_DOWNLOAD_URL), ((Boolean) map.get(TTDownloadField.TT_FORCE)).booleanValue());
                    return null;
                case 9:
                    d.a(((Integer) map.get("id")).intValue(), (ITTDownloadAdapter.OnEventLogHandler) map.get(TTDownloadField.TT_ONEVENT_LOG_HANDLER));
                    return null;
                case 10:
                    d.a((String) map.get(TTDownloadField.TT_DOWNLOAD_PATH));
                    return null;
                case 11:
                default:
                    return (T) super.callMethod(cls, i2, map);
                case 12:
                    return (T) Boolean.valueOf(d.a(this.f54787b, (Uri) map.get("uri"), b(map.get(TTDownloadField.TT_DOWNLOAD_MODEL)), c(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG)), d(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER))));
                case 13:
                    int intValue = ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue();
                    d.a().e().a(this.f54787b, (String) map.get(TTDownloadField.TT_USERAGENT), ((Boolean) map.get(TTDownloadField.TT_IS_DISABLE_DIALOG)).booleanValue(), b(map.get(TTDownloadField.TT_DOWNLOAD_MODEL)), c(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG)), d(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER)), a(map.get(TTDownloadField.TT_DOWNLOAD_STATUSCHANGE_LISTENER)), intValue);
                    return null;
                case 14:
                    return (T) Boolean.valueOf(d.a().e().a(this.f54787b, ((Long) map.get("id")).longValue(), (String) map.get("logExtra"), (DownloadStatusChangeListener) null, ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue()));
                case 15:
                    return (T) Boolean.valueOf(d.a((Uri) map.get("uri")));
                case 16:
                    d.a().a((String) map.get(TTDownloadField.TT_DOWNLOAD_URL), ((Long) map.get("id")).longValue(), ((Integer) map.get(TTDownloadField.TT_ACTION_TYPE_BUTTON)).intValue(), c(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG)), d(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER)));
                    return null;
                case 17:
                    d.a().a((String) map.get(TTDownloadField.TT_DOWNLOAD_URL), ((Long) map.get("id")).longValue(), ((Integer) map.get(TTDownloadField.TT_ACTION_TYPE_BUTTON)).intValue(), c(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG)), d(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER)), f(map.get(TTDownloadField.TT_ITEM_CLICK_LISTENER)), g(map.get(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER)));
                    return null;
            }
        }
        return (T) invokeLIL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.a, com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T getObj(Class<T> cls, int i2, Map<String, Object> map) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, i2, map)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    return (T) super.getObj(cls);
                }
                return (T) Boolean.valueOf(d.f54776b);
            }
            return (T) d.a;
        }
        return (T) invokeLIL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.a, com.bytedance.sdk.openadsdk.TTAdBridge
    public void init(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.init(bundle);
            d.a(this.f54787b);
        }
    }

    private DownloadStatusChangeListener a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, obj)) == null) {
            if (obj instanceof DownloadStatusChangeListener) {
                return (DownloadStatusChangeListener) obj;
            }
            return null;
        }
        return (DownloadStatusChangeListener) invokeL.objValue;
    }
}
