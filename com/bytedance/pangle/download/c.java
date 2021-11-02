package com.bytedance.pangle.download;

import android.text.TextUtils;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.AbstractBceClient;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.PluginProvider;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class c implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f61320a;

    /* renamed from: b  reason: collision with root package name */
    public final h f61321b;

    public c(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61320a = false;
        this.f61321b = hVar;
    }

    @Override // java.lang.Runnable
    public final synchronized void run() {
        List<PluginDownloadBean> providePluginConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.f61320a && h.a().f61351d) {
                    return;
                }
                if (System.currentTimeMillis() - this.f61321b.f61348a < 300000) {
                    return;
                }
                if (d.a(Zeus.getAppApplication())) {
                    for (int i2 = 0; i2 < 2; i2++) {
                        try {
                        } catch (Exception e2) {
                            ZeusLogger.e(ZeusLogger.TAG_DOWNLOAD, "Request plugin config failed!!!", e2);
                        }
                        if (!com.bytedance.pangle.a.f61231a.booleanValue()) {
                            ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, "Skip! useInternalNetworkImpl = false!");
                            PluginProvider pluginProvider = com.bytedance.pangle.i.a().f61439b.getPluginProvider();
                            if (pluginProvider != null && (providePluginConfig = pluginProvider.providePluginConfig()) != null) {
                                this.f61321b.f61348a = System.currentTimeMillis();
                                ZeusLogger.i(ZeusLogger.TAG_DOWNLOAD, "handlePlugins, pluginSize = " + providePluginConfig.size());
                                for (int i3 = 0; i3 < providePluginConfig.size(); i3++) {
                                    PluginDownloadBean pluginDownloadBean = providePluginConfig.get(i3);
                                    if (!h.a(pluginDownloadBean)) {
                                        providePluginConfig.remove(pluginDownloadBean);
                                    }
                                }
                                h.a(providePluginConfig);
                            }
                            return;
                        }
                        d a2 = d.a();
                        String a3 = e.a();
                        JSONObject jSONObject = new JSONObject();
                        JSONArray b2 = e.b();
                        if (b2 == null) {
                            b2 = new JSONArray();
                        }
                        jSONObject.put("plugin", b2);
                        jSONObject.put("auto_request", true);
                        String a4 = a2.a(a3, jSONObject.toString(), AbstractBceClient.DEFAULT_CONTENT_TYPE);
                        if (TextUtils.isEmpty(a4)) {
                            ZeusLogger.e(ZeusLogger.TAG_DOWNLOAD, "Request plugin failed! response is empty!");
                        } else {
                            ZeusLogger.i(ZeusLogger.TAG_DOWNLOAD, "response：".concat(String.valueOf(a4)));
                            JSONObject jSONObject2 = new JSONObject(a4);
                            JSONObject optJSONObject = jSONObject2.getJSONObject("data").optJSONObject(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
                            if (optJSONObject != null) {
                                this.f61321b.a(optJSONObject.optLong("auto_request_interval", 1800L));
                            }
                            JSONArray optJSONArray = jSONObject2.getJSONObject("data").optJSONArray("plugin");
                            if (optJSONArray != null) {
                                this.f61321b.f61348a = System.currentTimeMillis();
                                h hVar = this.f61321b;
                                ZeusLogger.i(ZeusLogger.TAG_DOWNLOAD, "handlePlugins, pluginSize = " + optJSONArray.length());
                                if (optJSONArray.length() >= 0) {
                                    h.a(hVar.a(optJSONArray));
                                }
                            }
                            return;
                        }
                    }
                }
            }
        }
    }
}
