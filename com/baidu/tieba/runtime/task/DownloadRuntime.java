package com.baidu.tieba.runtime.task;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.filedownloader.TbDownloadManager;
import com.baidu.tieba.ke7;
import com.baidu.tieba.ksa;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.lz0;
import com.baidu.tieba.msa;
import com.baidu.tieba.nj6;
import com.baidu.tieba.po4;
import com.baidu.tieba.rd;
import com.baidu.tieba.ru6;
import com.baidu.tieba.uj5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u0012\u0010\u0014\u001a\u00020\u00132\b\b\u0001\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0018\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/baidu/tieba/runtime/task/DownloadRuntime;", "", "()V", "TAG", "", "mDownloadCallback", "Lcom/baidu/tieba/runtime/task/DownloadRuntime$DownloadStatusCallback;", "getMDownloadCallback", "()Lcom/baidu/tieba/runtime/task/DownloadRuntime$DownloadStatusCallback;", "mDownloadCallback$delegate", "Lkotlin/Lazy;", "mInstallListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mTbDownloadManager", "Lcom/baidu/tieba/filedownloader/TbDownloadManager;", "getMTbDownloadManager", "()Lcom/baidu/tieba/filedownloader/TbDownloadManager;", "mTbDownloadManager$delegate", "addDownloadCallBack", "", "downloadComplete", "data", "Lcom/baidu/tbadk/download/DownloadData;", "downloadCompleteStatistic", "notifyFileDownloadStatus", "DownloadStatusCallback", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class DownloadRuntime {
    public static /* synthetic */ Interceptable $ic;
    public static final DownloadRuntime a;
    public static final Lazy b;
    public static final Lazy c;
    public static final CustomMessageListener d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static final class a implements ke7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.ke7
        public void a(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                DownloadRuntime.a.i(data);
            }
        }

        @Override // com.baidu.tieba.ke7
        public void b(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                DownloadRuntime.a.i(data);
                DownloadRuntime.a.e(data);
                DownloadRuntime.a.f(data);
            }
        }

        @Override // com.baidu.tieba.ke7
        public void c(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                DownloadRuntime.a.i(data);
            }
        }

        @Override // com.baidu.tieba.ke7
        public void d(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                DownloadRuntime.a.i(data);
            }
        }

        @Override // com.baidu.tieba.ke7
        public void e(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                DownloadRuntime.a.i(data);
            }
        }

        @Override // com.baidu.tieba.ke7
        public void f(DownloadData data, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048581, this, data, i) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                DownloadRuntime.a.i(data);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b() {
            super(2002504);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Intent) {
                String packageName = uj5.g((Intent) data);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("resultCode", 1);
                Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
                linkedHashMap.put("pkgName", packageName);
                nj6.a().b(CommonTbJsBridge.INSTALL_APK_RESULT, linkedHashMap);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class c extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadData a;

        public c(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = downloadData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... params) {
            InterceptResult invokeL;
            String str;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, params)) == null) {
                Intrinsics.checkNotNullParameter(params, "params");
                ItemData itemData = this.a.getItemData();
                String str2 = null;
                if (itemData == null || (str = itemData.pkgName) == null) {
                    ItemData itemData2 = this.a.getItemData();
                    if (itemData2 != null) {
                        str = itemData2.packageName;
                    } else {
                        str = null;
                    }
                }
                boolean z2 = false;
                if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    String id = this.a.getId();
                    if (!((id == null || StringsKt__StringsJVMKt.isBlank(id)) ? true : true)) {
                        ru6 m = DownloadRuntime.a.h().m();
                        lz0 title = msa.q;
                        Intrinsics.checkNotNullExpressionValue(title, "title");
                        String id2 = this.a.getId();
                        Intrinsics.checkNotNullExpressionValue(id2, "data.id");
                        ksa h = m.h(title, id2);
                        if (h != null) {
                            str2 = h.h();
                        }
                        return str2;
                    }
                    return str;
                }
                return str;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                super.onPostExecute((c) str);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("status", Integer.valueOf(this.a.getStatus()));
                linkedHashMap.put("source", Integer.valueOf(this.a.getSource()));
                linkedHashMap.put(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_MSG, this.a.getStatusMsg());
                linkedHashMap.put(CommonTbJsBridge.FILE_DOWNLOAD_CURRENT_SIZE, Long.valueOf(this.a.getLength()));
                linkedHashMap.put(CommonTbJsBridge.FILE_DOWNLOAD_TOTAL_SIZE, Long.valueOf(this.a.getSize()));
                linkedHashMap.put(CommonTbJsBridge.FILE_DOWNLOAD_URL, this.a.getUrl());
                linkedHashMap.put("fileName", this.a.getName());
                linkedHashMap.put("pkgName", str);
                nj6.a().b(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT, linkedHashMap);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1847204496, "Lcom/baidu/tieba/runtime/task/DownloadRuntime;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1847204496, "Lcom/baidu/tieba/runtime/task/DownloadRuntime;");
                return;
            }
        }
        a = new DownloadRuntime();
        b = LazyKt__LazyJVMKt.lazy(DownloadRuntime$mTbDownloadManager$2.INSTANCE);
        c = LazyKt__LazyJVMKt.lazy(DownloadRuntime$mDownloadCallback$2.INSTANCE);
        d = new b();
        MessageManager.getInstance().registerListener(d);
    }

    public DownloadRuntime() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return (a) c.getValue();
        }
        return (a) invokeV.objValue;
    }

    public final TbDownloadManager h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return (TbDownloadManager) b.getValue();
        }
        return (TbDownloadManager) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            h().w(2);
            h().g(g());
            h().w(1);
            h().g(g());
        }
    }

    public final void e(@NonNull DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) && !rd.isEmpty(downloadData.getUniqueId()) && !rd.isEmpty(downloadData.getName())) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("item_name", downloadData.getName());
            jSONObject.put("item_id", downloadData.getUniqueId());
            po4.d().c("download_game", jSONObject.toString());
        }
    }

    public final void f(DownloadData downloadData) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData) == null) {
            String id = downloadData.getId();
            boolean z3 = false;
            if (id != null && !StringsKt__StringsJVMKt.isBlank(id)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return;
            }
            ru6 m = h().m();
            lz0 title = msa.q;
            Intrinsics.checkNotNullExpressionValue(title, "title");
            String id2 = downloadData.getId();
            Intrinsics.checkNotNullExpressionValue(id2, "data.id");
            ksa h = m.h(title, id2);
            if (h != null) {
                String e = h.e();
                if (e != null && !StringsKt__StringsJVMKt.isBlank(e)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    try {
                        JSONObject jSONObject = new JSONObject(h.e());
                        String optString = jSONObject.optString("order_id");
                        if (!((optString == null || StringsKt__StringsJVMKt.isBlank(optString)) ? true : true)) {
                            String optString2 = jSONObject.optString("tid");
                            String optString3 = jSONObject.optString(TiePlusStat.RichTextType.STAT_KEY);
                            String optString4 = jSONObject.optString("obj_name");
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_TIE_PLUS_DOWNLOAD_FINISHED).addParam("tid", optString2).addParam("order_id", optString).addParam(TiePlusStat.RichTextType.STAT_KEY, optString3).addParam("obj_name", optString4).addParam("obj_locate", jSONObject.optString("obj_locate")).addParam("obj_type", jSONObject.optString("obj_type")));
                        }
                    } catch (JSONException unused) {
                        TbLog defaultLog = DefaultLog.getInstance();
                        defaultLog.i(com.baidu.searchbox.download.ioc.DownloadRuntime.TAG, "method downloadCompleteStatistic, json解析异常，数据：" + h.e());
                    }
                }
            }
        }
    }

    public final void i(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, downloadData) == null) && downloadData != null) {
            c cVar = new c(downloadData);
            cVar.setPriority(3);
            cVar.execute(new String[0]);
        }
    }
}
