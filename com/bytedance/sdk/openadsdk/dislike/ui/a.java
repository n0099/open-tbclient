package com.bytedance.sdk.openadsdk.dislike.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.component.utils.r;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.PersonalizationPrompt;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a implements TTAdDislike {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f30953a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.c.b f30954b;

    /* renamed from: c  reason: collision with root package name */
    public c f30955c;

    /* renamed from: d  reason: collision with root package name */
    public b f30956d;

    /* renamed from: e  reason: collision with root package name */
    public TTDislikeToast f30957e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f30958f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f30959g;

    /* renamed from: h  reason: collision with root package name */
    public SoftReference<View> f30960h;

    /* renamed from: i  reason: collision with root package name */
    public HandlerC0347a f30961i;
    public TTAdDislike.DislikeInteractionCallback j;

    /* renamed from: com.bytedance.sdk.openadsdk.dislike.ui.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class HandlerC0347a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<Context> f30966a;

        public HandlerC0347a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30966a = new WeakReference<>(context);
        }
    }

    public a(Context context, com.bytedance.sdk.openadsdk.dislike.c.b bVar, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar, str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30958f = new AtomicBoolean(false);
        bVar.b(str);
        bVar.a("other");
        n.a(context, "Dislike 初始化必须使用activity,请在TTAdManager.createAdNative(activity)中传入");
        this.f30953a = context;
        this.f30954b = bVar;
        this.f30959g = z;
        a();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public boolean isShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c cVar = this.f30955c;
            boolean isShowing = cVar != null ? cVar.isShowing() : false;
            b bVar = this.f30956d;
            return bVar != null ? isShowing | bVar.isShowing() : isShowing;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void resetDislikeStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b bVar = this.f30956d;
            if (bVar != null) {
                bVar.a();
            }
            TTDislikeToast tTDislikeToast = this.f30957e;
            if (tTDislikeToast != null) {
                tTDislikeToast.c();
            }
            this.f30958f.set(false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dislikeInteractionCallback) == null) {
            this.j = dislikeInteractionCallback;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeSource(String str) {
        com.bytedance.sdk.openadsdk.dislike.c.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (bVar = this.f30954b) == null) {
            return;
        }
        bVar.a(str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void showDislikeDialog() {
        TTDislikeToast tTDislikeToast;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Context context = this.f30953a;
            boolean z = (context instanceof Activity) && !((Activity) context).isFinishing();
            if (this.f30958f.get() && this.f30959g && (tTDislikeToast = this.f30957e) != null) {
                tTDislikeToast.b();
                return;
            }
            com.bytedance.sdk.openadsdk.dislike.c.b bVar = this.f30954b;
            if (bVar != null && "interaction".equals(bVar.i()) && this.f30958f.get()) {
                Context context2 = this.f30953a;
                Toast.makeText(context2, r.a(context2, "tt_dislike_feedback_repeat"), 0).show();
            } else if (!z || isShow()) {
            } else {
                this.f30955c.show();
            }
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            c cVar = new c(this.f30953a, this.f30954b);
            this.f30955c = cVar;
            cVar.a(new com.bytedance.sdk.openadsdk.dislike.b.d(this) { // from class: com.bytedance.sdk.openadsdk.dislike.ui.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f30962a;

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
                    this.f30962a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.b.d
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f30962a.b();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.b.d
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        j.b("TTAdDislikeImpl", "onDislikeShow: ");
                        if (this.f30962a.j != null) {
                            this.f30962a.j.onShow();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.b.d
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        j.f("TTAdDislikeImpl", "onDislikeHide: ");
                        try {
                            if (this.f30962a.j == null || this.f30962a.isShow()) {
                                return;
                            }
                            this.f30962a.j.onCancel();
                        } catch (Throwable th) {
                            j.c("TTAdDislikeImpl", "dislike callback cancel error: ", th);
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.b.d
                public void a(int i2, FilterWord filterWord) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, filterWord) == null) {
                        try {
                            if (!filterWord.hasSecondOptions()) {
                                if (this.f30962a.j != null) {
                                    this.f30962a.j.onSelected(i2, filterWord.getName(), this.f30962a.f30954b != null ? this.f30962a.f30954b.j() : false);
                                }
                                this.f30962a.f30958f.set(true);
                                if (this.f30962a.f30957e != null) {
                                    this.f30962a.f30957e.a();
                                }
                                this.f30962a.c();
                            }
                            j.f("TTAdDislikeImpl", "onDislikeSelected: " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + filterWord.getName());
                        } catch (Throwable th) {
                            j.c("TTAdDislikeImpl", "dislike callback selected error: ", th);
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.b.d
                public void a(PersonalizationPrompt personalizationPrompt) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, personalizationPrompt) == null) {
                        j.b("TTAdDislikeImpl", "onPersonalizePromptClicked");
                    }
                }
            });
            b bVar = new b(this.f30953a, this.f30954b);
            this.f30956d = bVar;
            bVar.a(new com.bytedance.sdk.openadsdk.dislike.b.b(this) { // from class: com.bytedance.sdk.openadsdk.dislike.ui.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f30963a;

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
                    this.f30963a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.b.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        j.b("TTAdDislikeImpl", "onDislikeCommentShow: ");
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.b.b
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        j.b("TTAdDislikeImpl", "onDislikeCommentHide: ");
                        try {
                            if (this.f30963a.f30958f.get()) {
                                return;
                            }
                            this.f30963a.f30955c.show();
                        } catch (Throwable th) {
                            j.c("TTAdDislikeImpl", "dislike callback selected error: ", th);
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.b.b
                public void a(int i2, FilterWord filterWord) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, filterWord) == null) {
                        try {
                            if (filterWord.hasSecondOptions()) {
                                return;
                            }
                            if (this.f30963a.j != null) {
                                this.f30963a.j.onSelected(i2, filterWord.getName(), this.f30963a.f30954b != null ? this.f30963a.f30954b.j() : false);
                            }
                            this.f30963a.f30958f.set(true);
                            if (this.f30963a.f30957e != null) {
                                this.f30963a.f30957e.a();
                            }
                            this.f30963a.c();
                        } catch (Throwable th) {
                            j.c("TTAdDislikeImpl", "comment callback selected error: ", th);
                        }
                    }
                }
            });
            if ((this.f30953a instanceof Activity) && this.f30959g) {
                this.f30957e = new TTDislikeToast(this.f30953a);
                ((FrameLayout) ((Activity) this.f30953a).findViewById(16908290)).addView(this.f30957e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            Context context = this.f30953a;
            if (!((context instanceof Activity) && !((Activity) context).isFinishing()) || this.f30956d.isShowing()) {
                return;
            }
            this.f30956d.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.bytedance.sdk.openadsdk.dislike.c.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (bVar = this.f30954b) == null) {
            return;
        }
        String i2 = bVar.i();
        if ("slide_banner_ad".equals(i2) || "banner_ad".equals(i2) || "embeded_ad".equals(i2)) {
            if (this.f30960h.get() != null && this.f30954b.j()) {
                this.f30960h.get().setVisibility(8);
            }
            if (this.f30961i == null) {
                this.f30961i = new HandlerC0347a(this.f30953a);
            }
            this.f30961i.postDelayed(new Runnable(this, i2) { // from class: com.bytedance.sdk.openadsdk.dislike.ui.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f30964a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f30965b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, i2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f30965b = this;
                    this.f30964a = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f30965b.f30954b.b("dislike");
                        if (this.f30965b.f30960h == null || this.f30965b.f30960h.get() == null || !((View) this.f30965b.f30960h.get()).isShown()) {
                            com.bytedance.sdk.openadsdk.dislike.a.a.a().a(this.f30965b.f30953a, this.f30965b.f30954b, "close_success");
                        } else {
                            com.bytedance.sdk.openadsdk.dislike.a.a.a().a(this.f30965b.f30953a, this.f30965b.f30954b, "close_fail");
                        }
                        this.f30965b.f30954b.b(this.f30964a);
                    }
                }
            }, 500L);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(Context context, com.bytedance.sdk.openadsdk.dislike.c.b bVar, boolean z) {
        this(context, bVar, null, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (com.bytedance.sdk.openadsdk.dislike.c.b) objArr2[1], (String) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void a(com.bytedance.sdk.openadsdk.dislike.c.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f30955c.setDislikeModel(bVar);
        this.f30956d.a(bVar);
    }

    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f30960h = new SoftReference<>(view);
        }
    }
}
