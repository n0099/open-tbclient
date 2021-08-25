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
    public final Context f67383a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.c.b f67384b;

    /* renamed from: c  reason: collision with root package name */
    public c f67385c;

    /* renamed from: d  reason: collision with root package name */
    public b f67386d;

    /* renamed from: e  reason: collision with root package name */
    public TTDislikeToast f67387e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f67388f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67389g;

    /* renamed from: h  reason: collision with root package name */
    public SoftReference<View> f67390h;

    /* renamed from: i  reason: collision with root package name */
    public HandlerC1915a f67391i;

    /* renamed from: j  reason: collision with root package name */
    public TTAdDislike.DislikeInteractionCallback f67392j;

    /* renamed from: com.bytedance.sdk.openadsdk.dislike.ui.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class HandlerC1915a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<Context> f67397a;

        public HandlerC1915a(Context context) {
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
            this.f67397a = new WeakReference<>(context);
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
        this.f67388f = new AtomicBoolean(false);
        bVar.b(str);
        bVar.a("other");
        this.f67383a = context;
        if (!(context instanceof Activity)) {
            k.c("Dislike 初始化必须使用activity,请在TTAdManager.createAdNative(activity)中传入");
            return;
        }
        this.f67384b = bVar;
        this.f67389g = z;
        a();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public boolean isShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f67383a instanceof Activity) {
                c cVar = this.f67385c;
                boolean isShowing = cVar != null ? cVar.isShowing() : false;
                b bVar = this.f67386d;
                return bVar != null ? isShowing | bVar.isShowing() : isShowing;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void resetDislikeStatus() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (this.f67383a instanceof Activity)) {
            c cVar = this.f67385c;
            if (cVar != null) {
                cVar.hide();
            }
            b bVar = this.f67386d;
            if (bVar != null) {
                bVar.a();
            }
            TTDislikeToast tTDislikeToast = this.f67387e;
            if (tTDislikeToast != null) {
                tTDislikeToast.c();
            }
            this.f67388f.set(false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dislikeInteractionCallback) == null) {
            this.f67392j = dislikeInteractionCallback;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeSource(String str) {
        com.bytedance.sdk.openadsdk.dislike.c.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (bVar = this.f67384b) == null) {
            return;
        }
        bVar.a(str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void showDislikeDialog() {
        TTDislikeToast tTDislikeToast;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Context context = this.f67383a;
            boolean z = (context instanceof Activity) && !((Activity) context).isFinishing();
            if (this.f67388f.get() && this.f67389g && (tTDislikeToast = this.f67387e) != null) {
                tTDislikeToast.b();
                return;
            }
            com.bytedance.sdk.openadsdk.dislike.c.b bVar = this.f67384b;
            if (bVar != null && ThreadAchievementShareDialogView.THREAD_INTERACTION_VIEW_TYPE.equals(bVar.i()) && this.f67388f.get()) {
                Context context2 = this.f67383a;
                Toast.makeText(context2, t.a(context2, "tt_dislike_feedback_repeat"), 0).show();
            } else if (!z || isShow()) {
            } else {
                this.f67385c.show();
            }
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            c cVar = new c(this.f67383a, this.f67384b);
            this.f67385c = cVar;
            cVar.a(new com.bytedance.sdk.openadsdk.dislike.b.d(this) { // from class: com.bytedance.sdk.openadsdk.dislike.ui.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f67393a;

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
                    this.f67393a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.b.d
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f67393a.b();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.b.d
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        k.b("TTAdDislikeImpl", "onDislikeShow: ");
                        if (this.f67393a.f67392j != null) {
                            this.f67393a.f67392j.onShow();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.b.d
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        k.f("TTAdDislikeImpl", "onDislikeHide: ");
                        try {
                            if (this.f67393a.f67392j == null || this.f67393a.isShow()) {
                                return;
                            }
                            this.f67393a.f67392j.onCancel();
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
                                if (this.f67393a.f67392j != null) {
                                    this.f67393a.f67392j.onSelected(i2, filterWord.getName(), this.f67393a.f67384b != null ? this.f67393a.f67384b.j() : false);
                                }
                                this.f67393a.f67388f.set(true);
                                if (this.f67393a.f67387e != null) {
                                    this.f67393a.f67387e.a();
                                }
                                this.f67393a.c();
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
            b bVar = new b(this.f67383a, this.f67384b);
            this.f67386d = bVar;
            bVar.a(new com.bytedance.sdk.openadsdk.dislike.b.b(this) { // from class: com.bytedance.sdk.openadsdk.dislike.ui.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f67394a;

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
                    this.f67394a = this;
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
                            if (this.f67394a.f67388f.get()) {
                                return;
                            }
                            this.f67394a.f67385c.show();
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
                            if (this.f67394a.f67392j != null) {
                                this.f67394a.f67392j.onSelected(i2, filterWord.getName(), this.f67394a.f67384b != null ? this.f67394a.f67384b.j() : false);
                            }
                            this.f67394a.f67388f.set(true);
                            if (this.f67394a.f67387e != null) {
                                this.f67394a.f67387e.a();
                            }
                            this.f67394a.c();
                        } catch (Throwable th) {
                            k.c("TTAdDislikeImpl", "comment callback selected error: ", th);
                        }
                    }
                }
            });
            if ((this.f67383a instanceof Activity) && this.f67389g) {
                this.f67387e = new TTDislikeToast(this.f67383a);
                ((FrameLayout) ((Activity) this.f67383a).findViewById(16908290)).addView(this.f67387e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            Context context = this.f67383a;
            if ((context instanceof Activity) && (!((Activity) context).isFinishing()) && !this.f67386d.isShowing()) {
                this.f67386d.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.bytedance.sdk.openadsdk.dislike.c.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (bVar = this.f67384b) == null) {
            return;
        }
        String i2 = bVar.i();
        if ("slide_banner_ad".equals(i2) || "banner_ad".equals(i2) || "embeded_ad".equals(i2)) {
            if (this.f67390h.get() != null && this.f67384b.j()) {
                this.f67390h.get().setVisibility(8);
            }
            if (this.f67391i == null) {
                this.f67391i = new HandlerC1915a(this.f67383a);
            }
            this.f67391i.postDelayed(new Runnable(this, i2) { // from class: com.bytedance.sdk.openadsdk.dislike.ui.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f67395a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f67396b;

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
                    this.f67396b = this;
                    this.f67395a = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f67396b.f67384b.b("dislike");
                        if (this.f67396b.f67390h == null || this.f67396b.f67390h.get() == null || !((View) this.f67396b.f67390h.get()).isShown()) {
                            com.bytedance.sdk.openadsdk.dislike.a.a.a().a(this.f67396b.f67383a, this.f67396b.f67384b, "close_success");
                        } else {
                            com.bytedance.sdk.openadsdk.dislike.a.a.a().a(this.f67396b.f67383a, this.f67396b.f67384b, "close_fail");
                        }
                        this.f67396b.f67384b.b(this.f67395a);
                    }
                }
            }, 500L);
        }
    }

    public void a(com.bytedance.sdk.openadsdk.dislike.c.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) && (this.f67383a instanceof Activity) && bVar != null) {
            this.f67385c.setDislikeModel(bVar);
            this.f67386d.a(bVar);
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
            this.f67390h = new SoftReference<>(view);
        }
    }
}
