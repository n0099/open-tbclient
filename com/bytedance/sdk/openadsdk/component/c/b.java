package com.bytedance.sdk.openadsdk.component.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.d.g;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTInteractionAd;
import com.bytedance.sdk.openadsdk.core.b.b;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.e.d;
import com.bytedance.sdk.openadsdk.r.o;
import java.util.Map;
/* loaded from: classes5.dex */
public class b implements TTInteractionAd {
    public static /* synthetic */ Interceptable $ic;
    public static boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f29347a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f29348b;

    /* renamed from: c  reason: collision with root package name */
    public final m f29349c;

    /* renamed from: d  reason: collision with root package name */
    public Dialog f29350d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.ui.a f29351e;

    /* renamed from: f  reason: collision with root package name */
    public TTInteractionAd.AdInteractionListener f29352f;

    /* renamed from: g  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f29353g;

    /* renamed from: h  reason: collision with root package name */
    public k f29354h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f29355i;
    public ImageView j;

    public b(Context context, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29347a = "interaction";
        this.f29348b = context;
        this.f29349c = mVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            m mVar = this.f29349c;
            if (mVar == null) {
                return -1;
            }
            return mVar.X();
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public Map<String, Object> getMediaExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            m mVar = this.f29349c;
            if (mVar != null) {
                return mVar.av();
            }
            return null;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public void setAdInteractionListener(TTInteractionAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, adInteractionListener) == null) {
            this.f29352f = adInteractionListener;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tTAppDownloadListener) == null) || (aVar = this.f29353g) == null) {
            return;
        }
        aVar.a(tTAppDownloadListener);
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public void setShowDislikeIcon(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dislikeInteractionCallback) == null) || dislikeInteractionCallback == null) {
            return;
        }
        this.f29351e.setDislikeInteractionCallback(dislikeInteractionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    @MainThread
    public void showInteractionAd(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, activity) == null) || activity.isFinishing()) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (k) {
                return;
            }
            k = true;
            this.f29350d.show();
            return;
        }
        throw new IllegalStateException("不能在子线程调用 TTInteractionAd.showInteractionAd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            com.bytedance.sdk.openadsdk.g.a.a(this.f29349c.ad().get(0)).a(new g<Bitmap>(this) { // from class: com.bytedance.sdk.openadsdk.component.c.b.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f29360a;

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
                    this.f29360a = this;
                }

                @Override // com.bytedance.sdk.component.d.g
                public void a(com.bytedance.sdk.component.d.m<Bitmap> mVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar) == null) {
                        if (mVar == null || mVar.a() == null) {
                            if (this.f29360a.f29354h != null) {
                                this.f29360a.f29354h.b();
                                return;
                            }
                            return;
                        }
                        this.f29360a.j.setImageBitmap(mVar.a());
                        if (this.f29360a.f29354h != null) {
                            this.f29360a.f29354h.a();
                        }
                    }
                }

                @Override // com.bytedance.sdk.component.d.g
                public void a(int i2, String str, @Nullable Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str, th) == null) || this.f29360a.f29354h == null) {
                        return;
                    }
                    this.f29360a.f29354h.b();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            k = false;
            this.f29350d.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            com.bytedance.sdk.openadsdk.core.b.a aVar = new com.bytedance.sdk.openadsdk.core.b.a(this.f29348b, this.f29349c, "interaction", 3);
            aVar.a(this.j);
            aVar.b(this.f29355i);
            aVar.a(this.f29353g);
            aVar.a(new b.a(this) { // from class: com.bytedance.sdk.openadsdk.component.c.b.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f29359a;

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
                    this.f29359a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.b.b.a
                public void a(View view, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, view, i2) == null) {
                        if (this.f29359a.f29352f != null) {
                            this.f29359a.f29352f.onAdClicked();
                        }
                        if (i2 == 2 || i2 == 3 || i2 == 5) {
                            this.f29359a.d();
                            if (this.f29359a.f29352f != null) {
                                this.f29359a.f29352f.onAdDismiss();
                            }
                        }
                    }
                }
            });
            this.j.setOnClickListener(aVar);
            this.j.setOnTouchListener(aVar);
        }
    }

    public void a(@NonNull k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) {
            this.f29354h = kVar;
            d.a(this.f29349c);
            if (getInteractionType() == 4) {
                this.f29353g = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f29348b, this.f29349c, "interaction");
            }
            this.f29351e = new com.bytedance.sdk.openadsdk.dislike.ui.a(this.f29348b, this.f29349c.aG(), "interaction", false);
            a();
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.f29350d == null) {
            com.bytedance.sdk.openadsdk.core.m mVar = new com.bytedance.sdk.openadsdk.core.m(this.f29348b);
            this.f29350d = mVar;
            mVar.a(this.f29349c.aH());
            this.f29350d.setOnShowListener(new DialogInterface.OnShowListener(this) { // from class: com.bytedance.sdk.openadsdk.component.c.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f29356a;

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
                    this.f29356a = this;
                }

                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) && this.f29356a.f29350d.isShowing()) {
                        j.e("AdEvent", "pangolin ad show " + o.a(this.f29356a.f29349c, (View) null));
                        d.a(this.f29356a.f29348b, this.f29356a.f29349c, "interaction", (Map<String, Object>) null);
                        if (this.f29356a.f29352f != null) {
                            this.f29356a.f29352f.onAdShow();
                        }
                    }
                }
            });
            this.f29350d.setOnDismissListener(new DialogInterface.OnDismissListener(this) { // from class: com.bytedance.sdk.openadsdk.component.c.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f29357a;

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
                    this.f29357a = this;
                }

                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) || this.f29357a.f29353g == null) {
                        return;
                    }
                    this.f29357a.f29353g.d();
                }
            });
            ((com.bytedance.sdk.openadsdk.core.m) this.f29350d).a(false, new m.a(this) { // from class: com.bytedance.sdk.openadsdk.component.c.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f29358a;

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
                    this.f29358a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.m.a
                public void a(ImageView imageView, ImageView imageView2, FrameLayout frameLayout) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageView, imageView2, frameLayout) == null) {
                        this.f29358a.j = imageView;
                        this.f29358a.f29355i = imageView2;
                        this.f29358a.b();
                        this.f29358a.c();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.m.a
                public void b(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
                        this.f29358a.f29351e.showDislikeDialog();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.m.a
                public void a(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f29358a.d();
                        d.a(this.f29358a.f29348b, this.f29358a.f29349c, "interaction");
                        if (this.f29358a.f29352f != null) {
                            this.f29358a.f29352f.onAdDismiss();
                        }
                        j.b("TTInteractionAdImpl", "dislike事件发出");
                    }
                }
            });
        }
    }
}
