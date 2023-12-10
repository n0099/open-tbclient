package com.baidu.tieba.write;

import android.content.Context;
import android.content.MutableContextWrapper;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.rj6;
import com.baidu.tieba.tbadkCore.writeModel.WriteMsgHolder;
import com.baidu.tieba.write.WriteWebViewCacheManager$skinChangeListener$2;
import com.baidu.tieba.xdb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u0006\u0010\u0017\u001a\u00020\u0011J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0005R-\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/baidu/tieba/write/WriteWebViewCacheManager;", "", "()V", "cache", "Ljava/util/HashMap;", "", "Lcom/baidu/tieba/browser/TbWebView;", "Lkotlin/collections/HashMap;", "getCache", "()Ljava/util/HashMap;", "skinChangeListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "getSkinChangeListener", "()Lcom/baidu/adp/framework/listener/CustomMessageListener;", "skinChangeListener$delegate", "Lkotlin/Lazy;", DownloadStatisticConstants.UBC_VALUE_CLEAR, "", CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "url", "context", "Landroid/content/Context;", "initWebView", "preInitWebView", "tryInitLastWebView", "lastTab", "Companion", "Holder", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class WriteWebViewCacheManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a c;
    public static final String d = "https://tieba.baidu.com/mo/q/hybrid-main-post/app-post?user_skin_overlay=0";
    public static final String e = "https://tieba.baidu.com/mo/q/hybrid-main-post/app-post-article?user_skin_overlay=0";
    public static final String f = "https://tieba.baidu.com/mo/q/hybrid-main-post/app-post-resort?user_skin_overlay=0";
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, TbWebView> a;
    public final Lazy b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1246450904, "Lcom/baidu/tieba/write/WriteWebViewCacheManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1246450904, "Lcom/baidu/tieba/write/WriteWebViewCacheManager;");
                return;
            }
        }
        c = new a(null);
    }

    public /* synthetic */ WriteWebViewCacheManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final WriteWebViewCacheManager g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? c.b() : (WriteWebViewCacheManager) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

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

        public final String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return (String) invokeV.objValue;
            }
            return WriteWebViewCacheManager.e;
        }

        @JvmStatic
        public final WriteWebViewCacheManager b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return b.a.a();
            }
            return (WriteWebViewCacheManager) invokeV.objValue;
        }

        public final String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) != null) {
                return (String) invokeV.objValue;
            }
            return WriteWebViewCacheManager.d;
        }

        public final String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048579, this)) != null) {
                return (String) invokeV.objValue;
            }
            return WriteWebViewCacheManager.f;
        }
    }

    /* loaded from: classes8.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public static final WriteWebViewCacheManager b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-456575846, "Lcom/baidu/tieba/write/WriteWebViewCacheManager$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-456575846, "Lcom/baidu/tieba/write/WriteWebViewCacheManager$b;");
                    return;
                }
            }
            a = new b();
            b = new WriteWebViewCacheManager(null);
        }

        public b() {
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

        public final WriteWebViewCacheManager a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b;
            }
            return (WriteWebViewCacheManager) invokeV.objValue;
        }
    }

    public WriteWebViewCacheManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<WriteWebViewCacheManager$skinChangeListener$2.a>(this) { // from class: com.baidu.tieba.write.WriteWebViewCacheManager$skinChangeListener$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WriteWebViewCacheManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* loaded from: classes8.dex */
            public static final class a extends CustomMessageListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WriteWebViewCacheManager a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(WriteWebViewCacheManager writeWebViewCacheManager) {
                    super(2001304);
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {writeWebViewCacheManager};
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
                    this.a = writeWebViewCacheManager;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                        for (Map.Entry<String, TbWebView> entry : this.a.f().entrySet()) {
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            String currentSkinTypeString = SkinManager.getCurrentSkinTypeString();
                            Intrinsics.checkNotNullExpressionValue(currentSkinTypeString, "getCurrentSkinTypeString()");
                            linkedHashMap.put("skin", currentSkinTypeString);
                            rj6.a().d(entry.getValue(), CommonTbJsBridge.CHANGE_SKIN_TYPE, linkedHashMap);
                        }
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new a(this.this$0);
                }
                return (a) invokeV.objValue;
            }
        });
        MessageManager.getInstance().registerListener(h());
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (Map.Entry<String, TbWebView> entry : this.a.entrySet()) {
                entry.getValue().onDestroy();
            }
            this.a.clear();
        }
    }

    public final HashMap<String, TbWebView> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (HashMap) invokeV.objValue;
    }

    public final CustomMessageListener h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return (CustomMessageListener) this.b.getValue();
        }
        return (CustomMessageListener) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && UbsABTestHelper.isNewWrite()) {
            String lastTab = SharedPrefHelper.getInstance().getString(SharedPrefHelper.getSharedPrefKeyWithAccount("key_last_select_write_tab"), "");
            Intrinsics.checkNotNullExpressionValue(lastTab, "lastTab");
            k(lastTab);
        }
    }

    public final TbWebView e(String url, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, url, context)) == null) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(context, "context");
            TbWebView tbWebView = this.a.get(url);
            if (tbWebView == null) {
                return null;
            }
            this.a.remove(url);
            Context context2 = tbWebView.getContext();
            if (context2 instanceof MutableContextWrapper) {
                ((MutableContextWrapper) context2).setBaseContext(xdb.a.b(context));
            }
            return tbWebView;
        }
        return (TbWebView) invokeLL.objValue;
    }

    public final void i(String str) {
        MutableContextWrapper mutableContextWrapper;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, str) != null) || this.a.containsKey(str)) {
            return;
        }
        if (TbadkCoreApplication.getInst().getMainActivity() != null) {
            mutableContextWrapper = new MutableContextWrapper(TbadkCoreApplication.getInst().getMainActivity());
        } else {
            mutableContextWrapper = new MutableContextWrapper(TbadkCoreApplication.getInst());
        }
        TbWebView a2 = xdb.a.a(mutableContextWrapper);
        a2.loadUrl(str + "&page_lifecycle_type=preheat_enabled");
        a2.getPerfData().i = true;
        this.a.put(str, a2);
    }

    public final void k(String lastTab) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, lastTab) == null) {
            Intrinsics.checkNotNullParameter(lastTab, "lastTab");
            if (WriteMsgHolder.isH5PageShowing) {
                HybridLog.getInstance().i("preload", "发布器H5不进行预渲染 isH5PageShowing");
                return;
            }
            TbLog hybridLog = HybridLog.getInstance();
            hybridLog.i("preload", "发布器H5尝试预渲染 " + lastTab);
            if (Intrinsics.areEqual(lastTab, "article")) {
                str = e;
            } else if (Intrinsics.areEqual(lastTab, "help")) {
                str = f;
            } else {
                str = d;
            }
            i(str);
        }
    }
}
