package com.bytedance.sdk.openadsdk.dislike.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;
import com.bytedance.sdk.openadsdk.dislike.ui.d;
/* loaded from: classes9.dex */
public class TTDislikeLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f67893a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f67894b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f67895c;

    /* renamed from: d  reason: collision with root package name */
    public TTDislikeListView f67896d;

    /* renamed from: e  reason: collision with root package name */
    public d f67897e;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.c.b f67898f;

    /* renamed from: g  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.b.c f67899g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TTDislikeLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void setDislikeInfo(com.bytedance.sdk.openadsdk.dislike.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f67898f = bVar;
            if (this.f67897e != null) {
                this.f67896d.setDislikeInfo(bVar);
                this.f67897e.a(bVar.b());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TTDislikeLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            if (this.f67898f.a() != null) {
                this.f67893a.setVisibility(0);
                this.f67894b.setText(this.f67898f.a().getName());
                this.f67893a.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.dislike.ui.TTDislikeLayout.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TTDislikeLayout f67902a;

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
                        this.f67902a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f67902a.f67899g == null) {
                            return;
                        }
                        this.f67902a.f67899g.b();
                    }
                });
            }
            d dVar = new d(getContext(), this.f67898f.b());
            this.f67897e = dVar;
            dVar.a(new d.a(this) { // from class: com.bytedance.sdk.openadsdk.dislike.ui.TTDislikeLayout.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTDislikeLayout f67903a;

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
                    this.f67903a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.dislike.ui.d.a
                public void a(int i2, FilterWord filterWord) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, filterWord) == null) {
                        if (this.f67903a.f67899g != null) {
                            this.f67903a.f67899g.a(i2, filterWord);
                        }
                        com.bytedance.sdk.openadsdk.dislike.a.a.a().a(this.f67903a.f67898f, filterWord);
                    }
                }
            });
            this.f67896d.setAdapter((ListAdapter) this.f67897e);
            this.f67896d.setDislikeInfo(this.f67898f);
        }
    }

    public void a(com.bytedance.sdk.openadsdk.dislike.c.b bVar, com.bytedance.sdk.openadsdk.dislike.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, cVar) == null) {
            this.f67898f = bVar;
            this.f67899g = cVar;
            a();
            b();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TTDislikeLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.f67893a = findViewById(t.e(getContext(), "tt_personalization_layout"));
            this.f67894b = (TextView) findViewById(t.e(getContext(), "tt_personalization_name"));
            TextView textView = (TextView) findViewById(t.e(getContext(), "tt_edit_suggestion"));
            this.f67895c = textView;
            textView.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.dislike.ui.TTDislikeLayout.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTDislikeLayout f67900a;

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
                    this.f67900a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f67900a.f67899g == null) {
                        return;
                    }
                    this.f67900a.f67899g.a();
                }
            });
            TTDislikeListView tTDislikeListView = (TTDislikeListView) findViewById(t.e(getContext(), "tt_filer_words_lv"));
            this.f67896d = tTDislikeListView;
            tTDislikeListView.setOnItemClickListener(new AdapterView.OnItemClickListener(this) { // from class: com.bytedance.sdk.openadsdk.dislike.ui.TTDislikeLayout.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTDislikeLayout f67901a;

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
                    this.f67901a = this;
                }

                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f67901a.f67899g == null) {
                        return;
                    }
                    try {
                        this.f67901a.f67899g.a(i2, this.f67901a.f67898f.b().get(i2));
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }
}
