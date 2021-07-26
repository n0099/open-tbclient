package com.bytedance.sdk.openadsdk.component.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
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
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.activity.base.TTRewardExpressVideoActivity;
import com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.o;
import com.bytedance.sdk.openadsdk.core.t;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class k implements TTRewardVideoAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f29659a;

    /* renamed from: b  reason: collision with root package name */
    public final m f29660b;

    /* renamed from: c  reason: collision with root package name */
    public final AdSlot f29661c;

    /* renamed from: d  reason: collision with root package name */
    public TTRewardVideoAd.RewardAdInteractionListener f29662d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f29663e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f29664f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f29665g;

    /* renamed from: h  reason: collision with root package name */
    public String f29666h;

    /* renamed from: i  reason: collision with root package name */
    public String f29667i;
    public AtomicBoolean j;
    public String k;

    public k(Context context, m mVar, AdSlot adSlot) {
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
        this.f29664f = true;
        this.j = new AtomicBoolean(false);
        this.f29659a = context;
        this.f29660b = mVar;
        this.f29661c = adSlot;
        if (getInteractionType() == 4) {
            this.f29663e = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f29659a, this.f29660b, "rewarded_video");
        }
        this.f29665g = false;
        this.k = com.bytedance.sdk.component.utils.e.a(this.f29660b.hashCode() + this.f29660b.aP().toString());
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            m mVar = this.f29660b;
            if (mVar == null) {
                return -1;
            }
            return mVar.X();
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            m mVar = this.f29660b;
            if (mVar != null) {
                return mVar.av();
            }
            return null;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getRewardVideoAdType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            m mVar = this.f29660b;
            if (mVar == null) {
                return -1;
            }
            if (o.j(mVar)) {
                return 2;
            }
            return o.k(this.f29660b) ? 1 : 0;
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tTAppDownloadListener) == null) || (aVar = this.f29663e) == null) {
            return;
        }
        aVar.a(tTAppDownloadListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardAdInteractionListener(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, rewardAdInteractionListener) == null) {
            this.f29662d = rewardAdInteractionListener;
            a(0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setShowDownLoadBar(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f29664f = z;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, activity) == null) {
            if (activity != null && activity.isFinishing()) {
                com.bytedance.sdk.component.utils.k.f("TTRewardVideoAdImpl", "showRewardVideoAd error1: activity is finishing");
                activity = null;
            }
            if (Looper.getMainLooper() == Looper.myLooper()) {
                if (this.j.get()) {
                    return;
                }
                this.j.set(true);
                m mVar = this.f29660b;
                if (mVar == null || mVar.V() == null) {
                    return;
                }
                Context context = activity == null ? this.f29659a : activity;
                if (context == null) {
                    context = com.bytedance.sdk.openadsdk.core.o.a();
                }
                if (this.f29660b.d() == 2) {
                    intent = new Intent(context, TTRewardExpressVideoActivity.class);
                } else {
                    intent = new Intent(context, TTRewardVideoActivity.class);
                }
                if (activity == null) {
                    intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                }
                intent.putExtra("reward_name", this.f29660b.b());
                intent.putExtra("reward_amount", this.f29660b.c());
                intent.putExtra("media_extra", this.f29661c.getMediaExtra());
                intent.putExtra("user_id", this.f29661c.getUserID());
                intent.putExtra("show_download_bar", this.f29664f);
                intent.putExtra("orientation", this.f29661c.getOrientation());
                if (!TextUtils.isEmpty(this.f29667i)) {
                    intent.putExtra("rit_scene", this.f29667i);
                }
                if (this.f29665g) {
                    intent.putExtra("video_cache_url", this.f29666h);
                }
                com.bytedance.sdk.openadsdk.q.e.e(this.f29660b.aP().toString());
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, this.f29660b.aP().toString());
                    intent.putExtra("multi_process_meta_md5", this.k);
                } else {
                    t.a().g();
                    t.a().a(this.f29660b);
                    t.a().a(this.f29662d);
                    t.a().a(this.f29663e);
                    this.f29662d = null;
                }
                com.bytedance.sdk.component.utils.b.a(context, intent, new b.a(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.k.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ k f29668a;

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
                        this.f29668a = this;
                    }

                    @Override // com.bytedance.sdk.component.utils.b.a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        }
                    }

                    @Override // com.bytedance.sdk.component.utils.b.a
                    public void a(Throwable th) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                            com.bytedance.sdk.component.utils.k.c("TTRewardVideoAdImpl", "show reward video error: ", th);
                        }
                    }
                });
                if (TextUtils.isEmpty(this.f29660b.ao())) {
                    return;
                }
                try {
                    String optString = new JSONObject(this.f29660b.ao()).optString("rit", null);
                    AdSlot b2 = h.a(this.f29659a).b(optString);
                    h.a(this.f29659a).a(optString);
                    if (b2 != null) {
                        if (this.f29665g && !TextUtils.isEmpty(this.f29666h)) {
                            h.a(this.f29659a).b(b2);
                        } else {
                            h.a(this.f29659a).a(b2);
                        }
                    }
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            com.bytedance.sdk.component.utils.k.f("TTRewardVideoAdImpl", "showRewardVideoAd error2: not main looper");
            throw new IllegalStateException("不能在子线程调用 TTRewardVideoAd.showRewardVideoAd");
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.j.get()) {
            return;
        }
        this.f29665g = true;
        this.f29666h = str;
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65538, this, i2) == null) && com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.component.d.e.c(new com.bytedance.sdk.component.d.g(this, "registerMultiProcessListener", i2) { // from class: com.bytedance.sdk.openadsdk.component.reward.k.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f29669a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ k f29670b;

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
                    this.f29670b = this;
                    this.f29669a = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.bytedance.sdk.openadsdk.multipro.aidl.a a2 = com.bytedance.sdk.openadsdk.multipro.aidl.a.a(this.f29670b.f29659a);
                        if (this.f29669a == 0 && this.f29670b.f29662d != null) {
                            com.bytedance.sdk.component.utils.k.b("MultiProcess", "start registerRewardVideoListener ! ");
                            com.bytedance.sdk.openadsdk.multipro.aidl.b.d dVar = new com.bytedance.sdk.openadsdk.multipro.aidl.b.d(this.f29670b.f29662d);
                            IListenerManager asInterface = IListenerManager.Stub.asInterface(a2.a(0));
                            if (asInterface != null) {
                                try {
                                    asInterface.registerRewardVideoListener(this.f29670b.k, dVar);
                                    com.bytedance.sdk.component.utils.k.b("MultiProcess", "end registerRewardVideoListener ! ");
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

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, ritScenes, str) == null) {
            if (ritScenes == null) {
                com.bytedance.sdk.component.utils.k.f("TTRewardVideoAdImpl", "The param ritScenes can not be null!");
                return;
            }
            if (ritScenes == TTAdConstant.RitScenes.CUSTOMIZE_SCENES) {
                this.f29667i = str;
            } else {
                this.f29667i = ritScenes.getScenesName();
            }
            showRewardVideoAd(activity);
        }
    }
}
