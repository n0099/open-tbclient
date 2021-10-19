package com.bytedance.sdk.openadsdk.dislike.ui;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.FilterWord;
/* loaded from: classes9.dex */
public class TTDislikeCommentLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f67884a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f67885b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f67886c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f67887d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.c.b f67888e;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.b.a f67889f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TTDislikeCommentLayout(Context context) {
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

    public static void setEditTextInputSpace(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, editText) == null) {
            editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.bytedance.sdk.openadsdk.dislike.ui.TTDislikeCommentLayout.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // android.text.InputFilter
                public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{charSequence, Integer.valueOf(i2), Integer.valueOf(i3), spanned, Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
                        while (i2 < i3) {
                            int type = Character.getType(charSequence.charAt(i2));
                            if (type == 19 || type == 28) {
                                return "";
                            }
                            i2++;
                        }
                        return null;
                    }
                    return (CharSequence) invokeCommon.objValue;
                }
            }, new InputFilter.LengthFilter(500)});
        }
    }

    public void setDislikeModel(com.bytedance.sdk.openadsdk.dislike.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f67888e = bVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TTDislikeCommentLayout(Context context, @Nullable AttributeSet attributeSet) {
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

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            EditText editText = (EditText) findViewById(t.e(getContext(), "tt_comment_content"));
            this.f67885b = editText;
            setEditTextInputSpace(editText);
            TextView textView = (TextView) findViewById(t.e(getContext(), "tt_comment_commit"));
            this.f67886c = textView;
            textView.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.dislike.ui.TTDislikeCommentLayout.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTDislikeCommentLayout f67890a;

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
                    this.f67890a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        String obj = this.f67890a.f67885b.getText().toString();
                        if (obj.length() <= 0 || obj.isEmpty()) {
                            return;
                        }
                        FilterWord filterWord = new FilterWord("0:00", obj);
                        com.bytedance.sdk.openadsdk.dislike.a.a.a().a(this.f67890a.f67888e, filterWord);
                        if (this.f67890a.f67889f != null) {
                            try {
                                this.f67890a.f67889f.a(0, filterWord);
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            });
            ImageView imageView = (ImageView) findViewById(t.e(getContext(), "tt_comment_close"));
            this.f67884a = imageView;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.dislike.ui.TTDislikeCommentLayout.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTDislikeCommentLayout f67891a;

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
                    this.f67891a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f67891a.f67889f.a();
                    }
                }
            });
            this.f67887d = (TextView) findViewById(t.e(getContext(), "tt_comment_number"));
            this.f67885b.addTextChangedListener(new TextWatcher(this) { // from class: com.bytedance.sdk.openadsdk.dislike.ui.TTDislikeCommentLayout.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTDislikeCommentLayout f67892a;

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
                    this.f67892a = this;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) {
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                        int round = Math.round(charSequence.length());
                        this.f67892a.f67887d.setText(round + "");
                        if (round > 0) {
                            this.f67892a.f67886c.setTextColor(-16777216);
                            this.f67892a.f67886c.setClickable(true);
                            return;
                        }
                        this.f67892a.f67886c.setTextColor(-7829368);
                        this.f67892a.f67886c.setClickable(false);
                    }
                }
            });
        }
    }

    public void a(com.bytedance.sdk.openadsdk.dislike.c.b bVar, com.bytedance.sdk.openadsdk.dislike.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, aVar) == null) {
            this.f67888e = bVar;
            this.f67889f = aVar;
            d();
        }
    }

    public void b() {
        InputMethodManager inputMethodManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (inputMethodManager = (InputMethodManager) this.f67885b.getContext().getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    }

    public void c() {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (editText = this.f67885b) == null) {
            return;
        }
        editText.setText((CharSequence) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TTDislikeCommentLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
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

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f67885b.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            }
            this.f67885b.clearFocus();
        }
    }
}
