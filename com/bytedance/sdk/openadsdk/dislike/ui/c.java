package com.bytedance.sdk.openadsdk.dislike.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
/* loaded from: classes5.dex */
public class c extends TTDislikeDialogAbstract {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.b.d f31263a;

    /* renamed from: b  reason: collision with root package name */
    public TTDislikeLayout f31264b;

    /* renamed from: c  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.dislike.c.b f31265c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, com.bytedance.sdk.openadsdk.dislike.c.b bVar) {
        super(context, t.g(context, "tt_dislikeDialog_new"));
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
        super.setDislikeModel(bVar);
        this.f31265c = bVar;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            TTDislikeLayout tTDislikeLayout = (TTDislikeLayout) findViewById(t.e(getContext(), "tt_dislike_layout"));
            this.f31264b = tTDislikeLayout;
            if (tTDislikeLayout != null) {
                tTDislikeLayout.a(this.f31265c, new com.bytedance.sdk.openadsdk.dislike.b.c(this) { // from class: com.bytedance.sdk.openadsdk.dislike.ui.c.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ c f31266a;

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
                        this.f31266a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.dislike.b.c
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (this.f31266a.f31263a != null) {
                                this.f31266a.f31263a.a();
                            }
                            this.f31266a.dismiss();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.dislike.b.c
                    public void b() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            if (this.f31266a.f31263a != null) {
                                this.f31266a.f31263a.a(this.f31266a.f31265c.a());
                            }
                            com.bytedance.sdk.openadsdk.dislike.a.a.b().a(this.f31266a.getContext(), this.f31266a.f31265c, false);
                            com.bytedance.sdk.openadsdk.dislike.a.a.a().a(this.f31266a.getContext(), this.f31266a.f31265c, "ad_explation_click");
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.dislike.b.c
                    public void a(int i2, FilterWord filterWord) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, filterWord) == null) {
                            if (this.f31266a.f31263a != null) {
                                this.f31266a.f31263a.a(i2, filterWord);
                            }
                            this.f31266a.dismiss();
                        }
                    }
                });
            }
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.dismiss();
            com.bytedance.sdk.openadsdk.dislike.b.d dVar = this.f31263a;
            if (dVar != null) {
                dVar.c();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? t.f(getContext(), "tt_dislike_dialog_layout") : invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public ViewGroup.LayoutParams getLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new ViewGroup.LayoutParams(com.bytedance.sdk.openadsdk.dislike.a.a.b().a(getContext(), 345.0f), -2) : (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public int[] getTTDislikeListViewIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new int[]{t.e(getContext(), "tt_filer_words_lv")} : (int[]) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract, android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            setCanceledOnTouchOutside(true);
            setCancelable(true);
            b();
            c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public void setDislikeModel(com.bytedance.sdk.openadsdk.dislike.c.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || bVar == null) {
            return;
        }
        super.setDislikeModel(bVar);
        TTDislikeLayout tTDislikeLayout = this.f31264b;
        if (tTDislikeLayout != null) {
            tTDislikeLayout.setDislikeInfo(bVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract, android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.show();
            com.bytedance.sdk.openadsdk.dislike.b.d dVar = this.f31263a;
            if (dVar != null) {
                dVar.b();
            }
        }
    }

    private void b() {
        Window window;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (window = getWindow()) == null) {
            return;
        }
        window.setGravity(17);
        window.setDimAmount(0.34f);
    }

    public void a(com.bytedance.sdk.openadsdk.dislike.b.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            this.f31263a = dVar;
        }
    }
}
