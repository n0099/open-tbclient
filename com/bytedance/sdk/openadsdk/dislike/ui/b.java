package com.bytedance.sdk.openadsdk.dislike.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.FilterWord;
/* loaded from: classes9.dex */
public class b extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TTDislikeCommentLayout f67578a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.c.b f67579b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.b.b f67580c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull Context context, com.bytedance.sdk.openadsdk.dislike.c.b bVar) {
        super(context, t.g(context, "quick_option_dialog"));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67579b = bVar;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            setCanceledOnTouchOutside(true);
            setCancelable(true);
            Window window = getWindow();
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f67578a.b();
            super.dismiss();
            com.bytedance.sdk.openadsdk.dislike.b.b bVar = this.f67580c;
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(t.f(getContext(), "tt_dislike_comment_layout"));
            TTDislikeCommentLayout tTDislikeCommentLayout = (TTDislikeCommentLayout) findViewById(t.e(getContext(), "tt_dislike_comment_layout"));
            this.f67578a = tTDislikeCommentLayout;
            tTDislikeCommentLayout.a(this.f67579b, new com.bytedance.sdk.openadsdk.dislike.b.a(this) { // from class: com.bytedance.sdk.openadsdk.dislike.ui.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f67581a;

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
                    this.f67581a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.b.a
                public void a(int i2, FilterWord filterWord) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, filterWord) == null) {
                        this.f67581a.f67580c.a(i2, filterWord);
                        this.f67581a.dismiss();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.b.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f67581a.dismiss();
                    }
                }
            });
            b();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.show();
            this.f67578a.a();
            com.bytedance.sdk.openadsdk.dislike.b.b bVar = this.f67580c;
            if (bVar != null) {
                bVar.a();
            }
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            window.setAttributes(attributes);
        }
    }

    public void a(com.bytedance.sdk.openadsdk.dislike.c.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f67579b = bVar;
        TTDislikeCommentLayout tTDislikeCommentLayout = this.f67578a;
        if (tTDislikeCommentLayout != null) {
            tTDislikeCommentLayout.setDislikeModel(bVar);
        }
    }

    public void a() {
        TTDislikeCommentLayout tTDislikeCommentLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (tTDislikeCommentLayout = this.f67578a) == null) {
            return;
        }
        tTDislikeCommentLayout.c();
    }

    public void a(com.bytedance.sdk.openadsdk.dislike.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f67580c = bVar;
        }
    }
}
