package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e extends a {
    public static volatile e a;
    public final Context b;

    public static boolean a(IDownloadButtonClickListener iDownloadButtonClickListener) {
        return iDownloadButtonClickListener != null;
    }

    public e(Context context) {
        this.b = context;
    }

    public static e a(Context context) {
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new e(context);
                }
            }
        }
        return a;
    }

    private DownloadModel b(Object obj) {
        if (obj instanceof DownloadModel) {
            return (DownloadModel) obj;
        }
        return null;
    }

    private DownloadEventConfig c(Object obj) {
        if (obj instanceof DownloadEventConfig) {
            return (DownloadEventConfig) obj;
        }
        return null;
    }

    private DownloadController d(Object obj) {
        if (obj instanceof DownloadController) {
            return (DownloadController) obj;
        }
        return null;
    }

    private ExitInstallListener e(Object obj) {
        if (obj instanceof ExitInstallListener) {
            return (ExitInstallListener) obj;
        }
        return null;
    }

    private OnItemClickListener f(Object obj) {
        if (obj instanceof OnItemClickListener) {
            return (OnItemClickListener) obj;
        }
        return null;
    }

    private IDownloadButtonClickListener g(Object obj) {
        if (obj instanceof IDownloadButtonClickListener) {
            return (IDownloadButtonClickListener) obj;
        }
        return null;
    }

    private Activity getActivity(Object obj) {
        if (obj instanceof Activity) {
            return (Activity) obj;
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.a, com.bytedance.sdk.openadsdk.TTAdBridge
    public void init(Bundle bundle) {
        super.init(bundle);
        d.a(this.b);
    }

    private DownloadStatusChangeListener a(Object obj) {
        if (obj instanceof DownloadStatusChangeListener) {
            return (DownloadStatusChangeListener) obj;
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.a, com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T callMethod(Class<T> cls, int i, Map<String, Object> map) {
        switch (i) {
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
                d.a(((Integer) map.get("hid")).intValue());
                return null;
            case 4:
                int intValue = ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue();
                d.a().a((String) map.get(TTDownloadField.TT_DOWNLOAD_URL), intValue);
                return null;
            case 5:
                int intValue2 = ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue();
                DownloadModel b = b(map.get(TTDownloadField.TT_DOWNLOAD_MODEL));
                d.a().a(this.b, intValue2, a(map.get(TTDownloadField.TT_DOWNLOAD_STATUSCHANGE_LISTENER)), b);
                return null;
            case 6:
                return (T) Boolean.valueOf(d.a(this.b, (String) map.get(TTDownloadField.TT_DOWNLOAD_URL)));
            case 7:
                d.b();
                return null;
            case 8:
                boolean booleanValue = ((Boolean) map.get(TTDownloadField.TT_FORCE)).booleanValue();
                d.a().a((String) map.get(TTDownloadField.TT_DOWNLOAD_URL), booleanValue);
                return null;
            case 9:
                d.a(((Integer) map.get("id")).intValue(), (ITTDownloadAdapter.OnEventLogHandler) map.get(TTDownloadField.TT_ONEVENT_LOG_HANDLER));
                return null;
            case 10:
                d.a((String) map.get(TTDownloadField.TT_DOWNLOAD_PATH));
                return null;
            case 11:
            default:
                return (T) super.callMethod(cls, i, map);
            case 12:
                Uri uri = (Uri) map.get("uri");
                DownloadModel b2 = b(map.get(TTDownloadField.TT_DOWNLOAD_MODEL));
                DownloadEventConfig c = c(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                DownloadController d = d(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER));
                IDownloadButtonClickListener g = g(map.get(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER));
                if (a(g)) {
                    return (T) Boolean.valueOf(d.a(this.b, uri, b2, c, d, g));
                }
                return (T) Boolean.valueOf(d.a(this.b, uri, b2, c, d));
            case 13:
                int intValue3 = ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue();
                boolean booleanValue2 = ((Boolean) map.get(TTDownloadField.TT_IS_DISABLE_DIALOG)).booleanValue();
                String str = (String) map.get(TTDownloadField.TT_USERAGENT);
                DownloadModel b3 = b(map.get(TTDownloadField.TT_DOWNLOAD_MODEL));
                DownloadEventConfig c2 = c(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                DownloadController d2 = d(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER));
                DownloadStatusChangeListener a2 = a(map.get(TTDownloadField.TT_DOWNLOAD_STATUSCHANGE_LISTENER));
                IDownloadButtonClickListener g2 = g(map.get(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER));
                if (a(g2)) {
                    d.a().e().a(this.b, str, booleanValue2, b3, c2, d2, a2, intValue3, g2);
                    return null;
                }
                d.a().e().a(this.b, str, booleanValue2, b3, c2, d2, a2, intValue3);
                return null;
            case 14:
                int intValue4 = ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue();
                return (T) Boolean.valueOf(d.a().e().a(this.b, ((Long) map.get("id")).longValue(), (String) map.get("logExtra"), (DownloadStatusChangeListener) null, intValue4));
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

    @Override // com.bytedance.sdk.openadsdk.downloadnew.a, com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T getObj(Class<T> cls, int i, Map<String, Object> map) {
        if (i != 0) {
            if (i != 1) {
                return (T) super.getObj(cls);
            }
            return (T) Boolean.valueOf(d.b);
        }
        return (T) d.a;
    }
}
