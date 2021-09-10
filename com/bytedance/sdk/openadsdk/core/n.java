package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.JProtect;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.b.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.core.e.m f66762a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f66763b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f66764c;

    /* renamed from: d  reason: collision with root package name */
    public final TTNativeAd f66765d;

    /* renamed from: e  reason: collision with root package name */
    public List<View> f66766e;

    /* renamed from: f  reason: collision with root package name */
    public String f66767f;

    /* renamed from: g  reason: collision with root package name */
    public TTNativeAd.AdInteractionListener f66768g;

    /* renamed from: h  reason: collision with root package name */
    public long f66769h;

    public n(Context context, TTNativeAd tTNativeAd, com.bytedance.sdk.openadsdk.core.e.m mVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, tTNativeAd, mVar, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66766e = new ArrayList();
        this.f66767f = "embeded_ad";
        this.f66765d = tTNativeAd;
        this.f66762a = mVar;
        this.f66764c = context;
        this.f66767f = str;
        if (mVar.X() == 4) {
            this.f66763b = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f66764c, this.f66762a, this.f66767f);
        }
    }

    private EmptyView a(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, viewGroup)) == null) {
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt instanceof EmptyView) {
                    return (EmptyView) childAt;
                }
            }
            return null;
        }
        return (EmptyView) invokeL.objValue;
    }

    public com.bytedance.sdk.openadsdk.downloadnew.core.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f66763b : (com.bytedance.sdk.openadsdk.downloadnew.core.a) invokeV.objValue;
    }

    public void a(@NonNull Activity activity) {
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) || (aVar = this.f66763b) == null) {
            return;
        }
        aVar.a(activity);
    }

    public void a(View view, int i2) {
        TTNativeAd.AdInteractionListener adInteractionListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view, i2) == null) || (adInteractionListener = this.f66768g) == null) {
            return;
        }
        adInteractionListener.onAdCreativeClick(view, this.f66765d);
    }

    public void a(@NonNull ViewGroup viewGroup, List<View> list, List<View> list2, @Nullable List<View> list3, @Nullable View view, TTNativeAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{viewGroup, list, list2, list3, view, adInteractionListener}) == null) {
            this.f66768g = adInteractionListener;
            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.f66763b;
            if (aVar != null) {
                aVar.b();
            }
            com.bytedance.sdk.openadsdk.e.d.a(this.f66762a);
            EmptyView a2 = a(viewGroup);
            if (a2 == null) {
                a2 = new EmptyView(this.f66764c, viewGroup);
                viewGroup.addView(a2);
            }
            a2.a();
            a2.setRefClickViews(list2);
            a2.setRefCreativeViews(list3);
            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar2 = this.f66763b;
            if (aVar2 != null) {
                aVar2.a(a2);
            }
            this.f66766e = list;
            Context context = this.f66764c;
            com.bytedance.sdk.openadsdk.core.e.m mVar = this.f66762a;
            String str = this.f66767f;
            com.bytedance.sdk.openadsdk.core.b.b bVar = new com.bytedance.sdk.openadsdk.core.b.b(context, mVar, str, com.bytedance.sdk.openadsdk.q.q.a(str));
            bVar.a(viewGroup);
            bVar.b(view);
            bVar.a(this.f66763b);
            bVar.a(this.f66765d);
            bVar.a(new b.a(this, adInteractionListener) { // from class: com.bytedance.sdk.openadsdk.core.n.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTNativeAd.AdInteractionListener f66770a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ n f66771b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, adInteractionListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f66771b = this;
                    this.f66770a = adInteractionListener;
                }

                @Override // com.bytedance.sdk.openadsdk.core.b.b.a
                public void a(View view2, int i2) {
                    TTNativeAd.AdInteractionListener adInteractionListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, view2, i2) == null) || (adInteractionListener2 = this.f66770a) == null) {
                        return;
                    }
                    adInteractionListener2.onAdClicked(view2, this.f66771b.f66765d);
                }
            });
            Context context2 = this.f66764c;
            com.bytedance.sdk.openadsdk.core.e.m mVar2 = this.f66762a;
            String str2 = this.f66767f;
            com.bytedance.sdk.openadsdk.core.b.a aVar3 = new com.bytedance.sdk.openadsdk.core.b.a(context2, mVar2, str2, com.bytedance.sdk.openadsdk.q.q.a(str2));
            aVar3.a(viewGroup);
            aVar3.b(view);
            aVar3.a(this.f66763b);
            aVar3.a(this.f66765d);
            aVar3.a(new b.a(this, adInteractionListener) { // from class: com.bytedance.sdk.openadsdk.core.n.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTNativeAd.AdInteractionListener f66772a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ n f66773b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, adInteractionListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f66773b = this;
                    this.f66772a = adInteractionListener;
                }

                @Override // com.bytedance.sdk.openadsdk.core.b.b.a
                public void a(View view2, int i2) {
                    TTNativeAd.AdInteractionListener adInteractionListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, view2, i2) == null) || (adInteractionListener2 = this.f66772a) == null) {
                        return;
                    }
                    adInteractionListener2.onAdCreativeClick(view2, this.f66773b.f66765d);
                }
            });
            a2.a(list2, bVar);
            a2.a(list3, aVar3);
            a2.setCallback(new EmptyView.a(this, viewGroup, adInteractionListener) { // from class: com.bytedance.sdk.openadsdk.core.n.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ ViewGroup f66774a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TTNativeAd.AdInteractionListener f66775b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ n f66776c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, viewGroup, adInteractionListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f66776c = this;
                    this.f66774a = viewGroup;
                    this.f66775b = adInteractionListener;
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f66776c.f66763b == null) {
                        return;
                    }
                    this.f66776c.f66763b.a();
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                @Keep
                @JProtect
                public void a(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                        this.f66776c.f66769h = System.currentTimeMillis();
                        HashMap hashMap = new HashMap();
                        if (this.f66776c.f66766e != null) {
                            JSONArray jSONArray = new JSONArray();
                            for (View view3 : this.f66776c.f66766e) {
                                if (view3 != null) {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("width", view3.getWidth());
                                        jSONObject.put("height", view3.getHeight());
                                        jSONObject.put("alpha", view3.getAlpha());
                                    } catch (Throwable unused) {
                                    }
                                    jSONArray.put(jSONObject);
                                }
                            }
                            hashMap.put("image_view", jSONArray.toString());
                        }
                        if (this.f66774a != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("width", this.f66774a.getWidth());
                                jSONObject2.put("height", this.f66774a.getHeight());
                                jSONObject2.put("alpha", this.f66774a.getAlpha());
                            } catch (Throwable unused2) {
                            }
                            hashMap.put("root_view", jSONObject2.toString());
                        }
                        com.bytedance.sdk.openadsdk.e.d.a(this.f66776c.f66764c, this.f66776c.f66762a, this.f66776c.f66767f, hashMap);
                        com.bytedance.sdk.component.utils.k.e("AdEvent", "pangolin ad show " + com.bytedance.sdk.openadsdk.q.q.a(this.f66776c.f66762a, view2));
                        TTNativeAd.AdInteractionListener adInteractionListener2 = this.f66775b;
                        if (adInteractionListener2 != null) {
                            adInteractionListener2.onAdShow(this.f66776c.f66765d);
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                        if (this.f66776c.f66763b != null) {
                            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar4 = this.f66776c.f66763b;
                            if (z) {
                                aVar4.b();
                            } else {
                                aVar4.c();
                            }
                        }
                        n nVar = this.f66776c;
                        nVar.f66769h = com.bytedance.sdk.openadsdk.e.d.a(nVar.f66769h, z, this.f66776c.f66762a, this.f66776c.f66767f);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        if (this.f66776c.f66763b != null) {
                            this.f66776c.f66763b.d();
                        }
                        n nVar = this.f66776c;
                        nVar.f66769h = com.bytedance.sdk.openadsdk.e.d.a(nVar.f66769h, this.f66776c.f66762a, this.f66776c.f66767f);
                    }
                }
            });
            a2.setNeedCheckingShow(true);
        }
    }

    public void a(TTAppDownloadListener tTAppDownloadListener) {
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tTAppDownloadListener) == null) || (aVar = this.f66763b) == null) {
            return;
        }
        aVar.a(tTAppDownloadListener);
    }
}
