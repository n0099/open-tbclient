package com.baidu.tieba.runtime.task;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.ha7;
import com.baidu.tieba.hu4;
import com.baidu.tieba.ka7;
import com.baidu.tieba.nm5;
import com.baidu.tieba.ui;
import com.baidu.tieba.vl6;
import com.baidu.tieba.zv6;
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
import org.json.JSONObject;
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u0012\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/baidu/tieba/runtime/task/DownloadRuntime;", "", "()V", "mDownloadCallback", "Lcom/baidu/tieba/runtime/task/DownloadRuntime$DownloadStatusCallback;", "getMDownloadCallback", "()Lcom/baidu/tieba/runtime/task/DownloadRuntime$DownloadStatusCallback;", "mDownloadCallback$delegate", "Lkotlin/Lazy;", "mInstallListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mTbDownloadManager", "Lcom/baidu/tieba/filedownloader/TbDownloadManager;", "getMTbDownloadManager", "()Lcom/baidu/tieba/filedownloader/TbDownloadManager;", "mTbDownloadManager$delegate", "addDownloadCallBack", "", "downloadComplete", "data", "Lcom/baidu/tbadk/download/DownloadData;", "notifyFileDownloadStatus", "DownloadStatusCallback", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class DownloadRuntime {
    public static /* synthetic */ Interceptable $ic;
    public static final DownloadRuntime a;
    public static final Lazy b;
    public static final Lazy c;
    public static final CustomMessageListener d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a implements ka7 {
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

        @Override // com.baidu.tieba.ka7
        public void a(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                DownloadRuntime.a.g(data);
            }
        }

        @Override // com.baidu.tieba.ka7
        public void b(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                DownloadRuntime.a.g(data);
            }
        }

        @Override // com.baidu.tieba.ka7
        public void c(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                DownloadRuntime.a.g(data);
                DownloadRuntime.a.d(data);
            }
        }

        @Override // com.baidu.tieba.ka7
        public void d(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                DownloadRuntime.a.g(data);
            }
        }

        @Override // com.baidu.tieba.ka7
        public void e(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                DownloadRuntime.a.g(data);
            }
        }

        @Override // com.baidu.tieba.ka7
        public void f(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                DownloadRuntime.a.g(data);
            }
        }
    }

    /* loaded from: classes7.dex */
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
                String packageName = nm5.g((Intent) data);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("resultCode", 1);
                Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
                linkedHashMap.put("pkgName", packageName);
                vl6.a().b(CommonTbJsBridge.INSTALL_APK_RESULT, linkedHashMap);
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

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f().a(e());
        }
    }

    public final a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (a) c.getValue();
        }
        return (a) invokeV.objValue;
    }

    public final ha7 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return (ha7) b.getValue();
        }
        return (ha7) invokeV.objValue;
    }

    public final void d(@NonNull DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) && !ui.isEmpty(downloadData.getUniqueId()) && !ui.isEmpty(downloadData.getName())) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("item_name", downloadData.getName());
            jSONObject.put("item_id", downloadData.getUniqueId());
            hu4.d().c("download_game", jSONObject.toString());
        }
    }

    public final void g(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, downloadData) == null) && downloadData != null && zv6.e(downloadData.getSource())) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("status", Integer.valueOf(downloadData.getStatus()));
            linkedHashMap.put("source", Integer.valueOf(downloadData.getSource()));
            linkedHashMap.put(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_MSG, downloadData.getStatusMsg());
            linkedHashMap.put(CommonTbJsBridge.FILE_DOWNLOAD_CURRENT_SIZE, Long.valueOf(downloadData.getLength()));
            linkedHashMap.put(CommonTbJsBridge.FILE_DOWNLOAD_TOTAL_SIZE, Long.valueOf(downloadData.getSize()));
            linkedHashMap.put(CommonTbJsBridge.FILE_DOWNLOAD_URL, downloadData.getUrl());
            linkedHashMap.put("fileName", downloadData.getName());
            vl6.a().b(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT, linkedHashMap);
        }
    }
}
