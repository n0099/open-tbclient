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
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.PersonalizationPrompt;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class a implements TTAdDislike {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f67909a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.c.b f67910b;

    /* renamed from: c  reason: collision with root package name */
    public c f67911c;

    /* renamed from: d  reason: collision with root package name */
    public b f67912d;

    /* renamed from: e  reason: collision with root package name */
    public TTDislikeToast f67913e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f67914f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67915g;

    /* renamed from: h  reason: collision with root package name */
    public SoftReference<View> f67916h;

    /* renamed from: i  reason: collision with root package name */
    public HandlerC1921a f67917i;

    /* renamed from: j  reason: collision with root package name */
    public TTAdDislike.DislikeInteractionCallback f67918j;

    /* renamed from: com.bytedance.sdk.openadsdk.dislike.ui.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class HandlerC1921a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<Context> f67923a;

        public HandlerC1921a(Context context) {
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
            this.f67923a = new WeakReference<>(context);
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
        this.f67914f = new AtomicBoolean(false);
        bVar.b(str);
        bVar.a("other");
        this.f67909a = context;
        if (!(context instanceof Activity)) {
            k.c("Dislike 初始化必须使用activity,请在TTAdManager.createAdNative(activity)中传入");
            return;
        }
        this.f67910b = bVar;
        this.f67915g = z;
        a();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public boolean isShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f67909a instanceof Activity) {
                c cVar = this.f67911c;
                boolean isShowing = cVar != null ? cVar.isShowing() : false;
                b bVar = this.f67912d;
                return bVar != null ? isShowing | bVar.isShowing() : isShowing;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void resetDislikeStatus() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (this.f67909a instanceof Activity)) {
            c cVar = this.f67911c;
            if (cVar != null) {
                cVar.hide();
            }
            b bVar = this.f67912d;
            if (bVar != null) {
                bVar.a();
            }
            TTDislikeToast tTDislikeToast = this.f67913e;
            if (tTDislikeToast != null) {
                tTDislikeToast.c();
            }
            this.f67914f.set(false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dislikeInteractionCallback) == null) {
            this.f67918j = dislikeInteractionCallback;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeSource(String str) {
        com.bytedance.sdk.openadsdk.dislike.c.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (bVar = this.f67910b) == null) {
            return;
        }
        bVar.a(str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void showDislikeDialog() {
        TTDislikeToast tTDislikeToast;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Context context = this.f67909a;
            boolean z = (context instanceof Activity) && !((Activity) context).isFinishing();
            if (this.f67914f.get() && this.f67915g && (tTDislikeToast = this.f67913e) != null) {
                tTDislikeToast.b();
                return;
            }
            com.bytedance.sdk.openadsdk.dislike.c.b bVar = this.f67910b;
            if (bVar != null && ThreadAchievementShareDialogView.THREAD_INTERACTION_VIEW_TYPE.equals(bVar.i()) && this.f67914f.get()) {
                Context context2 = this.f67909a;
                Toast.makeText(context2, t.a(context2, "tt_dislike_feedback_repeat"), 0).show();
            } else if (!z || isShow()) {
            } else {
                this.f67911c.show();
            }
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            c cVar = new c(this.f67909a, this.f67910b);
            this.f67911c = cVar;
            cVar.a(new com.bytedance.sdk.openadsdk.dislike.b.d(this) { // from class: com.bytedance.sdk.openadsdk.dislike.ui.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f67919a;

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
                    this.f67919a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.b.d
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f67919a.b();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.b.d
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        k.b("TTAdDislikeImpl", "onDislikeShow: ");
                        if (this.f67919a.f67918j != null) {
                            this.f67919a.f67918j.onShow();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.b.d
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        k.f("TTAdDislikeImpl", "onDislikeHide: ");
                        try {
                            if (this.f67919a.f67918j == null || this.f67919a.isShow()) {
                                return;
                            }
                            this.f67919a.f67918j.onCancel();
                        } catch (Throwable th) {
                            k.c("TTAdDislikeImpl", "dislike callback cancel error: ", th);
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.b.d
                public void a(int i2, FilterWord filterWord) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, filterWord) == null) {
                        try {
                            if (!filterWord.hasSecondOptions()) {
                                if (this.f67919a.f67918j != null) {
                                    this.f67919a.f67918j.onSelected(i2, filterWord.getName(), this.f67919a.f67910b != null ? this.f67919a.f67910b.j() : false);
                                }
                                this.f67919a.f67914f.set(true);
                                if (this.f67919a.f67913e != null) {
                                    this.f67919a.f67913e.a();
                                }
                                this.f67919a.c();
                            }
                            k.f("TTAdDislikeImpl", "onDislikeSelected: " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + filterWord.getName());
                        } catch (Throwable th) {
                            k.c("TTAdDislikeImpl", "dislike callback selected error: ", th);
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.b.d
                public void a(PersonalizationPrompt personalizationPrompt) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, personalizationPrompt) == null) {
                        k.b("TTAdDislikeImpl", "onPersonalizePromptClicked");
                    }
                }
            });
            b bVar = new b(this.f67909a, this.f67910b);
            this.f67912d = bVar;
            bVar.a(new com.bytedance.sdk.openadsdk.dislike.b.b(this) { // from class: com.bytedance.sdk.openadsdk.dislike.ui.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f67920a;

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
                    this.f67920a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.b.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        k.b("TTAdDislikeImpl", "onDislikeCommentShow: ");
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.b.b
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        k.b("TTAdDislikeImpl", "onDislikeCommentHide: ");
                        try {
                            if (this.f67920a.f67914f.get()) {
                                return;
                            }
                            this.f67920a.f67911c.show();
                        } catch (Throwable th) {
                            k.c("TTAdDislikeImpl", "dislike callback selected error: ", th);
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
                            if (this.f67920a.f67918j != null) {
                                this.f67920a.f67918j.onSelected(i2, filterWord.getName(), this.f67920a.f67910b != null ? this.f67920a.f67910b.j() : false);
                            }
                            this.f67920a.f67914f.set(true);
                            if (this.f67920a.f67913e != null) {
                                this.f67920a.f67913e.a();
                            }
                            this.f67920a.c();
                        } catch (Throwable th) {
                            k.c("TTAdDislikeImpl", "comment callback selected error: ", th);
                        }
                    }
                }
            });
            if ((this.f67909a instanceof Activity) && this.f67915g) {
                this.f67913e = new TTDislikeToast(this.f67909a);
                ((FrameLayout) ((Activity) this.f67909a).findViewById(16908290)).addView(this.f67913e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            Context context = this.f67909a;
            if ((context instanceof Activity) && (!((Activity) context).isFinishing()) && !this.f67912d.isShowing()) {
                this.f67912d.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.bytedance.sdk.openadsdk.dislike.c.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (bVar = this.f67910b) == null) {
            return;
        }
        String i2 = bVar.i();
        if ("slide_banner_ad".equals(i2) || "banner_ad".equals(i2) || "embeded_ad".equals(i2)) {
            if (this.f67916h.get() != null && this.f67910b.j()) {
                this.f67916h.get().setVisibility(8);
            }
            if (this.f67917i == null) {
                this.f67917i = new HandlerC1921a(this.f67909a);
            }
            this.f67917i.postDelayed(new Runnable(this, i2) { // from class: com.bytedance.sdk.openadsdk.dislike.ui.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f67921a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f67922b;

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
                    this.f67922b = this;
                    this.f67921a = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f67922b.f67910b.b("dislike");
                        if (this.f67922b.f67916h == null || this.f67922b.f67916h.get() == null || !((View) this.f67922b.f67916h.get()).isShown()) {
                            com.bytedance.sdk.openadsdk.dislike.a.a.a().a(this.f67922b.f67909a, this.f67922b.f67910b, "close_success");
                        } else {
                            com.bytedance.sdk.openadsdk.dislike.a.a.a().a(this.f67922b.f67909a, this.f67922b.f67910b, "close_fail");
                        }
                        this.f67922b.f67910b.b(this.f67921a);
                    }
                }
            }, 500L);
        }
    }

    public void a(com.bytedance.sdk.openadsdk.dislike.c.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) && (this.f67909a instanceof Activity) && bVar != null) {
            this.f67911c.setDislikeModel(bVar);
            this.f67912d.a(bVar);
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

    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f67916h = new SoftReference<>(view);
        }
    }
}
