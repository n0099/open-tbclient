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
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.image.ILoaderListener;
import com.bytedance.sdk.component.image.ImageResponse;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTInteractionAd;
import com.bytedance.sdk.openadsdk.core.b.b;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.e.d;
import com.bytedance.sdk.openadsdk.img.ImageLoaderWrapper;
import com.bytedance.sdk.openadsdk.q.q;
import java.util.Map;
/* loaded from: classes9.dex */
public class b implements TTInteractionAd {
    public static /* synthetic */ Interceptable $ic;
    public static boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f65527a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f65528b;

    /* renamed from: c  reason: collision with root package name */
    public final m f65529c;

    /* renamed from: d  reason: collision with root package name */
    public Dialog f65530d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.ui.a f65531e;

    /* renamed from: f  reason: collision with root package name */
    public TTInteractionAd.AdInteractionListener f65532f;

    /* renamed from: g  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f65533g;

    /* renamed from: h  reason: collision with root package name */
    public k f65534h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f65535i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f65536j;

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
        this.f65527a = ThreadAchievementShareDialogView.THREAD_INTERACTION_VIEW_TYPE;
        this.f65528b = context;
        this.f65529c = mVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            m mVar = this.f65529c;
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
            m mVar = this.f65529c;
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
            this.f65532f = adInteractionListener;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, tTAppDownloadListener) == null) || (aVar = this.f65533g) == null) {
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
        this.f65531e.setDislikeInteractionCallback(dislikeInteractionCallback);
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
            try {
                this.f65530d.show();
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        throw new IllegalStateException("不能在子线程调用 TTInteractionAd.showInteractionAd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            ImageLoaderWrapper.from(this.f65529c.ad().get(0)).to(new ILoaderListener<Bitmap>(this) { // from class: com.bytedance.sdk.openadsdk.component.c.b.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f65541a;

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
                    this.f65541a = this;
                }

                @Override // com.bytedance.sdk.component.image.ILoaderListener
                public void onFailed(int i2, String str, @Nullable Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str, th) == null) || this.f65541a.f65534h == null) {
                        return;
                    }
                    this.f65541a.f65534h.b();
                }

                @Override // com.bytedance.sdk.component.image.ILoaderListener
                public void onSuccess(ImageResponse<Bitmap> imageResponse) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageResponse) == null) {
                        if (imageResponse == null || imageResponse.getResult() == null) {
                            if (this.f65541a.f65534h != null) {
                                this.f65541a.f65534h.b();
                                return;
                            }
                            return;
                        }
                        this.f65541a.f65536j.setImageBitmap(imageResponse.getResult());
                        if (this.f65541a.f65534h != null) {
                            this.f65541a.f65534h.a();
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            k = false;
            this.f65530d.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            com.bytedance.sdk.openadsdk.core.b.a aVar = new com.bytedance.sdk.openadsdk.core.b.a(this.f65528b, this.f65529c, ThreadAchievementShareDialogView.THREAD_INTERACTION_VIEW_TYPE, 3);
            aVar.a(this.f65536j);
            aVar.b(this.f65535i);
            aVar.a(this.f65533g);
            aVar.a(new b.a(this) { // from class: com.bytedance.sdk.openadsdk.component.c.b.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f65540a;

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
                    this.f65540a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.b.b.a
                public void a(View view, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, view, i2) == null) {
                        if (this.f65540a.f65532f != null) {
                            this.f65540a.f65532f.onAdClicked();
                        }
                        if (i2 == 2 || i2 == 3 || i2 == 5) {
                            this.f65540a.d();
                            if (this.f65540a.f65532f != null) {
                                this.f65540a.f65532f.onAdDismiss();
                            }
                        }
                    }
                }
            });
            this.f65536j.setOnClickListener(aVar);
            this.f65536j.setOnTouchListener(aVar);
        }
    }

    public void a(@NonNull k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) {
            this.f65534h = kVar;
            d.a(this.f65529c);
            if (getInteractionType() == 4) {
                this.f65533g = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f65528b, this.f65529c, ThreadAchievementShareDialogView.THREAD_INTERACTION_VIEW_TYPE);
            }
            this.f65531e = new com.bytedance.sdk.openadsdk.dislike.ui.a(this.f65528b, this.f65529c.aG(), ThreadAchievementShareDialogView.THREAD_INTERACTION_VIEW_TYPE, false);
            a();
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.f65530d == null) {
            com.bytedance.sdk.openadsdk.core.m mVar = new com.bytedance.sdk.openadsdk.core.m(this.f65528b);
            this.f65530d = mVar;
            mVar.a(this.f65529c.aH());
            this.f65530d.setOnShowListener(new DialogInterface.OnShowListener(this) { // from class: com.bytedance.sdk.openadsdk.component.c.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f65537a;

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
                    this.f65537a = this;
                }

                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) && this.f65537a.f65530d.isShowing()) {
                        com.bytedance.sdk.component.utils.k.e("AdEvent", "pangolin ad show " + q.a(this.f65537a.f65529c, (View) null));
                        d.a(this.f65537a.f65528b, this.f65537a.f65529c, ThreadAchievementShareDialogView.THREAD_INTERACTION_VIEW_TYPE, (Map<String, Object>) null);
                        if (this.f65537a.f65532f != null) {
                            this.f65537a.f65532f.onAdShow();
                        }
                    }
                }
            });
            this.f65530d.setOnDismissListener(new DialogInterface.OnDismissListener(this) { // from class: com.bytedance.sdk.openadsdk.component.c.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f65538a;

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
                    this.f65538a = this;
                }

                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) || this.f65538a.f65533g == null) {
                        return;
                    }
                    this.f65538a.f65533g.d();
                }
            });
            ((com.bytedance.sdk.openadsdk.core.m) this.f65530d).a(this.f65529c);
            ((com.bytedance.sdk.openadsdk.core.m) this.f65530d).a(false, new m.a(this) { // from class: com.bytedance.sdk.openadsdk.component.c.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f65539a;

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
                    this.f65539a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.m.a
                public void a(ImageView imageView, ImageView imageView2, FrameLayout frameLayout) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageView, imageView2, frameLayout) == null) {
                        this.f65539a.f65536j = imageView;
                        this.f65539a.f65535i = imageView2;
                        this.f65539a.b();
                        this.f65539a.c();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.m.a
                public void b(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
                        this.f65539a.f65531e.showDislikeDialog();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.m.a
                public void a(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f65539a.d();
                        d.a(this.f65539a.f65528b, this.f65539a.f65529c, ThreadAchievementShareDialogView.THREAD_INTERACTION_VIEW_TYPE);
                        if (this.f65539a.f65532f != null) {
                            this.f65539a.f65532f.onAdDismiss();
                        }
                        com.bytedance.sdk.component.utils.k.b("TTInteractionAdImpl", "dislike事件发出");
                    }
                }
            });
        }
    }
}
