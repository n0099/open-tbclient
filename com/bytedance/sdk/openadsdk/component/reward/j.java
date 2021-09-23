package com.bytedance.sdk.openadsdk.component.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.b;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.activity.base.TTFullScreenExpressVideoActivity;
import com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.o;
import com.bytedance.sdk.openadsdk.core.t;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class j implements TTFullScreenVideoAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f66224a;

    /* renamed from: b  reason: collision with root package name */
    public final m f66225b;

    /* renamed from: c  reason: collision with root package name */
    public final AdSlot f66226c;

    /* renamed from: d  reason: collision with root package name */
    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f66227d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f66228e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66229f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f66230g;

    /* renamed from: h  reason: collision with root package name */
    public String f66231h;

    /* renamed from: i  reason: collision with root package name */
    public String f66232i;

    /* renamed from: j  reason: collision with root package name */
    public AtomicBoolean f66233j;
    public boolean k;
    public String l;

    public j(Context context, m mVar, AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar, adSlot};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66229f = true;
        this.f66233j = new AtomicBoolean(false);
        this.k = false;
        this.f66224a = context;
        this.f66225b = mVar;
        this.f66226c = adSlot;
        if (getInteractionType() == 4) {
            this.f66228e = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f66224a, this.f66225b, "fullscreen_interstitial_ad");
        }
        this.f66230g = false;
        this.l = com.bytedance.sdk.component.utils.e.a(this.f66225b.hashCode() + this.f66225b.aP().toString());
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getFullVideoAdType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            m mVar = this.f66225b;
            if (mVar == null) {
                return -1;
            }
            if (o.j(mVar)) {
                return 2;
            }
            return o.k(this.f66225b) ? 1 : 0;
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            m mVar = this.f66225b;
            if (mVar == null) {
                return -1;
            }
            return mVar.X();
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            m mVar = this.f66225b;
            if (mVar != null) {
                return mVar.av();
            }
            return null;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, tTAppDownloadListener) == null) || (aVar = this.f66228e) == null) {
            return;
        }
        aVar.a(tTAppDownloadListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fullScreenVideoAdInteractionListener) == null) {
            this.f66227d = fullScreenVideoAdInteractionListener;
            a(1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setShowDownLoadBar(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f66229f = z;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity) == null) {
            if (activity != null && activity.isFinishing()) {
                com.bytedance.sdk.component.utils.k.f("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error1: activity is finishing");
                activity = null;
            }
            if (Looper.getMainLooper() == Looper.myLooper()) {
                if (this.f66233j.get()) {
                    return;
                }
                this.f66233j.set(true);
                m mVar = this.f66225b;
                if (mVar != null) {
                    if (mVar.V() == null && this.f66225b.ad() == null) {
                        return;
                    }
                    Context context = activity == null ? this.f66224a : activity;
                    if (context == null) {
                        context = com.bytedance.sdk.openadsdk.core.o.a();
                    }
                    if (this.f66225b.d() == 2) {
                        intent = new Intent(context, TTFullScreenExpressVideoActivity.class);
                    } else {
                        intent = new Intent(context, TTFullScreenVideoActivity.class);
                    }
                    if (activity == null) {
                        intent.addFlags(268435456);
                    }
                    intent.putExtra("show_download_bar", this.f66229f);
                    intent.putExtra("orientation", this.f66226c.getOrientation());
                    intent.putExtra("is_verity_playable", this.k);
                    if (!TextUtils.isEmpty(this.f66232i)) {
                        intent.putExtra("rit_scene", this.f66232i);
                    }
                    if (this.f66230g) {
                        intent.putExtra("video_cache_url", this.f66231h);
                    }
                    com.bytedance.sdk.openadsdk.q.e.e(this.f66225b.aP().toString());
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, this.f66225b.aP().toString());
                        intent.putExtra("multi_process_meta_md5", this.l);
                    } else {
                        t.a().g();
                        t.a().a(this.f66225b);
                        t.a().a(this.f66227d);
                        t.a().a(this.f66228e);
                        this.f66227d = null;
                    }
                    com.bytedance.sdk.component.utils.b.a(context, intent, new b.a(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.j.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ j f66234a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f66234a = this;
                        }

                        @Override // com.bytedance.sdk.component.utils.b.a
                        public void a() {
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f66234a.k) {
                                try {
                                    com.bytedance.sdk.openadsdk.j.a.a().a(this.f66234a.f66225b.V().j());
                                } catch (Throwable unused) {
                                }
                            }
                        }

                        @Override // com.bytedance.sdk.component.utils.b.a
                        public void a(Throwable th) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                                com.bytedance.sdk.component.utils.k.c("TTFullScreenVideoAdImpl", "show full screen video error: ", th);
                                if (this.f66234a.k) {
                                    try {
                                        com.bytedance.sdk.openadsdk.j.a.a().a(this.f66234a.f66225b.V().j(), -1, th != null ? th.getMessage() : "playable tool error open");
                                    } catch (Throwable unused) {
                                    }
                                }
                            }
                        }
                    });
                    if (TextUtils.isEmpty(this.f66225b.ao())) {
                        return;
                    }
                    try {
                        String optString = new JSONObject(this.f66225b.ao()).optString("rit", null);
                        AdSlot b2 = c.a(this.f66224a).b(optString);
                        c.a(this.f66224a).a(optString);
                        if (b2 != null) {
                            if (this.f66230g && !TextUtils.isEmpty(this.f66231h)) {
                                c.a(this.f66224a).b(b2);
                            } else {
                                c.a(this.f66224a).a(b2);
                            }
                        }
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
                return;
            }
            com.bytedance.sdk.component.utils.k.f("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error2: not main looper");
            throw new IllegalStateException("不能在子线程调用 TTFullScreenVideoAd.showFullScreenVideoAd");
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.k = z;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f66233j.get()) {
            return;
        }
        this.f66230g = true;
        this.f66231h = str;
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65537, this, i2) == null) && com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.component.d.e.c(new com.bytedance.sdk.component.d.g(this, "registerMultiProcessListener", i2) { // from class: com.bytedance.sdk.openadsdk.component.reward.j.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f66235a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ j f66236b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f66236b = this;
                    this.f66235a = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.bytedance.sdk.openadsdk.multipro.aidl.a a2 = com.bytedance.sdk.openadsdk.multipro.aidl.a.a(this.f66236b.f66224a);
                        if (this.f66235a == 1 && this.f66236b.f66227d != null) {
                            com.bytedance.sdk.component.utils.k.b("MultiProcess", "start registerFullScreenVideoListener ! ");
                            com.bytedance.sdk.openadsdk.multipro.aidl.b.c cVar = new com.bytedance.sdk.openadsdk.multipro.aidl.b.c(this.f66236b.f66227d);
                            IListenerManager asInterface = IListenerManager.Stub.asInterface(a2.a(1));
                            if (asInterface != null) {
                                try {
                                    asInterface.registerFullVideoListener(this.f66236b.l, cVar);
                                    com.bytedance.sdk.component.utils.k.b("MultiProcess", "end registerFullScreenVideoListener ! ");
                                } catch (RemoteException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }, 5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, activity, ritScenes, str) == null) {
            if (ritScenes == null) {
                com.bytedance.sdk.component.utils.k.f("TTFullScreenVideoAdImpl", "The param ritScenes can not be null!");
                return;
            }
            if (ritScenes == TTAdConstant.RitScenes.CUSTOMIZE_SCENES) {
                this.f66232i = str;
            } else {
                this.f66232i = ritScenes.getScenesName();
            }
            showFullScreenVideoAd(activity);
        }
    }
}
