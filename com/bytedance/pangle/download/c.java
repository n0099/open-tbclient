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
/* loaded from: classes12.dex */
public final class c implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public final h f54526b;

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
        this.a = false;
        this.f54526b = hVar;
    }

    @Override // java.lang.Runnable
    public final synchronized void run() {
        List<PluginDownloadBean> providePluginConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.a && h.a().f54549d) {
                    return;
                }
                if (System.currentTimeMillis() - this.f54526b.a < 300000) {
                    return;
                }
                if (d.a(Zeus.getAppApplication())) {
                    for (int i2 = 0; i2 < 2; i2++) {
                        try {
                        } catch (Exception e2) {
                            ZeusLogger.e(ZeusLogger.TAG_DOWNLOAD, "Request plugin config failed!!!", e2);
                        }
                        if (!com.bytedance.pangle.a.a.booleanValue()) {
                            ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, "Skip! useInternalNetworkImpl = false!");
                            PluginProvider pluginProvider = com.bytedance.pangle.i.a().f54604b.getPluginProvider();
                            if (pluginProvider != null && (providePluginConfig = pluginProvider.providePluginConfig()) != null) {
                                this.f54526b.a = System.currentTimeMillis();
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
                        d a = d.a();
                        String a2 = e.a();
                        JSONObject jSONObject = new JSONObject();
                        JSONArray b2 = e.b();
                        if (b2 == null) {
                            b2 = new JSONArray();
                        }
                        jSONObject.put("plugin", b2);
                        jSONObject.put("auto_request", true);
                        String a3 = a.a(a2, jSONObject.toString(), AbstractBceClient.DEFAULT_CONTENT_TYPE);
                        if (TextUtils.isEmpty(a3)) {
                            ZeusLogger.e(ZeusLogger.TAG_DOWNLOAD, "Request plugin failed! response is empty!");
                        } else {
                            ZeusLogger.i(ZeusLogger.TAG_DOWNLOAD, "response：".concat(String.valueOf(a3)));
                            JSONObject jSONObject2 = new JSONObject(a3);
                            JSONObject optJSONObject = jSONObject2.getJSONObject("data").optJSONObject(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
                            if (optJSONObject != null) {
                                this.f54526b.a(optJSONObject.optLong("auto_request_interval", 1800L));
                            }
                            JSONArray optJSONArray = jSONObject2.getJSONObject("data").optJSONArray("plugin");
                            if (optJSONArray != null) {
                                this.f54526b.a = System.currentTimeMillis();
                                h hVar = this.f54526b;
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
