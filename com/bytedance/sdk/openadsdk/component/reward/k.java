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
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.activity.base.TTRewardExpressVideoActivity;
import com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.o;
import com.bytedance.sdk.openadsdk.core.t;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class k implements TTRewardVideoAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f65746a;

    /* renamed from: b  reason: collision with root package name */
    public final m f65747b;

    /* renamed from: c  reason: collision with root package name */
    public final AdSlot f65748c;

    /* renamed from: d  reason: collision with root package name */
    public TTRewardVideoAd.RewardAdInteractionListener f65749d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f65750e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f65751f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f65752g;

    /* renamed from: h  reason: collision with root package name */
    public String f65753h;

    /* renamed from: i  reason: collision with root package name */
    public String f65754i;

    /* renamed from: j  reason: collision with root package name */
    public AtomicBoolean f65755j;
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
        this.f65751f = true;
        this.f65755j = new AtomicBoolean(false);
        this.f65746a = context;
        this.f65747b = mVar;
        this.f65748c = adSlot;
        if (getInteractionType() == 4) {
            this.f65750e = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f65746a, this.f65747b, "rewarded_video");
        }
        this.f65752g = false;
        this.k = com.bytedance.sdk.component.utils.e.a(this.f65747b.hashCode() + this.f65747b.aP().toString());
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            m mVar = this.f65747b;
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
            m mVar = this.f65747b;
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
            m mVar = this.f65747b;
            if (mVar == null) {
                return -1;
            }
            if (o.j(mVar)) {
                return 2;
            }
            return o.k(this.f65747b) ? 1 : 0;
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tTAppDownloadListener) == null) || (aVar = this.f65750e) == null) {
            return;
        }
        aVar.a(tTAppDownloadListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardAdInteractionListener(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, rewardAdInteractionListener) == null) {
            this.f65749d = rewardAdInteractionListener;
            a(0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setShowDownLoadBar(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f65751f = z;
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
                if (this.f65755j.get()) {
                    return;
                }
                this.f65755j.set(true);
                m mVar = this.f65747b;
                if (mVar == null || mVar.V() == null) {
                    return;
                }
                Context context = activity == null ? this.f65746a : activity;
                if (context == null) {
                    context = com.bytedance.sdk.openadsdk.core.o.a();
                }
                if (this.f65747b.d() == 2) {
                    intent = new Intent(context, TTRewardExpressVideoActivity.class);
                } else {
                    intent = new Intent(context, TTRewardVideoActivity.class);
                }
                if (activity == null) {
                    intent.addFlags(268435456);
                }
                intent.putExtra("reward_name", this.f65747b.b());
                intent.putExtra("reward_amount", this.f65747b.c());
                intent.putExtra("media_extra", this.f65748c.getMediaExtra());
                intent.putExtra("user_id", this.f65748c.getUserID());
                intent.putExtra("show_download_bar", this.f65751f);
                intent.putExtra("orientation", this.f65748c.getOrientation());
                if (!TextUtils.isEmpty(this.f65754i)) {
                    intent.putExtra("rit_scene", this.f65754i);
                }
                if (this.f65752g) {
                    intent.putExtra("video_cache_url", this.f65753h);
                }
                com.bytedance.sdk.openadsdk.q.e.e(this.f65747b.aP().toString());
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, this.f65747b.aP().toString());
                    intent.putExtra("multi_process_meta_md5", this.k);
                } else {
                    t.a().g();
                    t.a().a(this.f65747b);
                    t.a().a(this.f65749d);
                    t.a().a(this.f65750e);
                    this.f65749d = null;
                }
                com.bytedance.sdk.component.utils.b.a(context, intent, new b.a(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.k.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ k f65756a;

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
                        this.f65756a = this;
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
                if (TextUtils.isEmpty(this.f65747b.ao())) {
                    return;
                }
                try {
                    String optString = new JSONObject(this.f65747b.ao()).optString("rit", null);
                    AdSlot b2 = h.a(this.f65746a).b(optString);
                    h.a(this.f65746a).a(optString);
                    if (b2 != null) {
                        if (this.f65752g && !TextUtils.isEmpty(this.f65753h)) {
                            h.a(this.f65746a).b(b2);
                        } else {
                            h.a(this.f65746a).a(b2);
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
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f65755j.get()) {
            return;
        }
        this.f65752g = true;
        this.f65753h = str;
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65538, this, i2) == null) && com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.component.d.e.c(new com.bytedance.sdk.component.d.g(this, "registerMultiProcessListener", i2) { // from class: com.bytedance.sdk.openadsdk.component.reward.k.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f65757a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ k f65758b;

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
                    this.f65758b = this;
                    this.f65757a = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.bytedance.sdk.openadsdk.multipro.aidl.a a2 = com.bytedance.sdk.openadsdk.multipro.aidl.a.a(this.f65758b.f65746a);
                        if (this.f65757a == 0 && this.f65758b.f65749d != null) {
                            com.bytedance.sdk.component.utils.k.b("MultiProcess", "start registerRewardVideoListener ! ");
                            com.bytedance.sdk.openadsdk.multipro.aidl.b.d dVar = new com.bytedance.sdk.openadsdk.multipro.aidl.b.d(this.f65758b.f65749d);
                            IListenerManager asInterface = IListenerManager.Stub.asInterface(a2.a(0));
                            if (asInterface != null) {
                                try {
                                    asInterface.registerRewardVideoListener(this.f65758b.k, dVar);
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
                this.f65754i = str;
            } else {
                this.f65754i = ritScenes.getScenesName();
            }
            showRewardVideoAd(activity);
        }
    }
}
