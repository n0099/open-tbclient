package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.s.c.u;
import c.a.o0.w.n;
import c.a.p0.s4.i;
import c.a.p0.z0.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CustomToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
/* loaded from: classes6.dex */
public class VideoPlayInputContainer extends LinearLayout implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f36684b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f36685c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f36686d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36687e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36688f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f36689g;

    /* renamed from: h  reason: collision with root package name */
    public View f36690h;
    public int i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayInputContainer a;

        public a(VideoPlayInputContainer videoPlayInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayInputContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.f36688f = true;
                this.a.d(new c.a.o0.w.a(1, 5, null));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayInputContainer a;

        public b(VideoPlayInputContainer videoPlayInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayInputContainer;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer videoPlayInputContainer = this.a;
                    videoPlayInputContainer.d(new c.a.o0.w.a(4, -1, videoPlayInputContainer.f36684b.getText().toString()));
                }
                this.a.f36685c.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                this.a.l();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) || this.a.k) {
                return;
            }
            this.a.k = true;
            if (this.a.l != -1) {
                this.a.f36684b.setSelection(this.a.l);
                this.a.l = -1;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayInputContainer a;

        public c(VideoPlayInputContainer videoPlayInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayInputContainer;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.a.d(new c.a.o0.w.a(5, -1, null));
                    this.a.f36684b.requestFocus();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayInputContainer a;

        public d(VideoPlayInputContainer videoPlayInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayInputContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.d(new c.a.o0.w.a(8, -1, null));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements b.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayInputContainer a;

        public e(VideoPlayInputContainer videoPlayInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayInputContainer;
        }

        @Override // c.a.p0.z0.b.g
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.a.f36684b.setText(spannableStringBuilder);
                this.a.f36684b.setSelection(this.a.f36684b.getText().length());
                this.a.d(new c.a.o0.w.a(5, -1, null));
                this.a.requestFocus();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoPlayInputContainer(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.o0.w.n
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            EditText editText = this.f36684b;
            if (editText != null) {
                editText.setFocusable(true);
                this.f36684b.setFocusableInTouchMode(true);
                this.f36684b.requestFocus();
                c.a.d.f.p.n.L(getContext(), this.f36684b);
            }
            setVisibility(0);
        }
    }

    @Override // c.a.o0.w.n
    public void d(c.a.o0.w.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || (editorTools = this.a) == null) {
            return;
        }
        editorTools.A(aVar);
    }

    public EditText getInputView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f36684b : (EditText) invokeV.objValue;
    }

    @Override // c.a.o0.w.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.i : invokeV.intValue;
    }

    @Override // c.a.o0.w.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setVisibility(8);
        }
    }

    @Override // c.a.o0.w.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.f36685c.isEnabled()) {
                SkinManager.setViewTextColor(this.f36685c, R.color.CAM_X0302, 1, this.m);
            } else {
                SkinManager.setViewTextColor(this.f36685c, R.color.CAM_X0107, 1);
            }
        }
    }

    public final void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            ImageView imageView = new ImageView(context);
            this.f36686d = imageView;
            imageView.setEnabled(true);
            this.f36686d.setPadding(0, 0, c.a.d.f.p.n.f(context, R.dimen.tbds30), c.a.d.f.p.n.f(context, R.dimen.tbds24));
            this.f36686d.setOnClickListener(new a(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 80;
            this.f36689g.addView(this.f36686d, layoutParams);
        }
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            EditText editText = new EditText(context);
            this.f36684b = editText;
            editText.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207));
            this.f36684b.setMaxLines(4);
            this.f36684b.setGravity(16);
            this.f36684b.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207));
            this.f36684b.setBackgroundResource(R.color.common_color_10022);
            i.l(this.f36684b, R.drawable.obfuscated_res_0x7f0804b8);
            this.f36684b.setPadding(0, c.a.d.f.p.n.f(context, R.dimen.obfuscated_res_0x7f0701e8), c.a.d.f.p.n.f(context, R.dimen.obfuscated_res_0x7f0702d3), c.a.d.f.p.n.f(context, R.dimen.obfuscated_res_0x7f0701e8));
            this.f36684b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
            this.f36684b.addTextChangedListener(new b(this));
            this.f36684b.setHint(context.getString(R.string.obfuscated_res_0x7f0f0f95));
            this.f36684b.setOnTouchListener(new c(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            this.f36689g.addView(this.f36684b, layoutParams);
        }
    }

    public final void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            TextView textView = new TextView(context);
            this.f36685c = textView;
            textView.setGravity(17);
            this.f36685c.setIncludeFontPadding(false);
            this.f36685c.setEnabled(false);
            this.f36685c.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b7));
            this.f36685c.setText(R.string.obfuscated_res_0x7f0f10e2);
            this.f36685c.setOnClickListener(new d(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, c.a.d.f.p.n.f(context, R.dimen.tbds18));
            layoutParams.gravity = 80;
            this.f36689g.addView(this.f36685c, layoutParams);
        }
    }

    @Override // c.a.o0.w.b
    public void onAction(c.a.o0.w.a aVar) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) || aVar == null) {
            return;
        }
        int i = aVar.a;
        if (i == 3) {
            if (this.f36684b.getSelectionStart() > 0) {
                String substring = this.f36684b.getText().toString().substring(0, this.f36684b.getSelectionStart());
                Matcher matcher = c.a.p0.z0.a.f20857b.matcher(substring);
                if (matcher.find()) {
                    this.f36684b.getText().delete(this.f36684b.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.f36684b.getSelectionStart());
                } else {
                    this.f36684b.getText().delete(this.f36684b.getSelectionStart() - 1, this.f36684b.getSelectionStart());
                }
            }
        } else if (i == 6) {
            Object obj2 = aVar.f11499c;
            if (obj2 == null) {
                this.f36684b.setText((CharSequence) null);
            } else if (obj2 instanceof String) {
                if (TextUtils.isEmpty((String) obj2)) {
                    this.f36684b.setText((CharSequence) null);
                } else {
                    c.a.p0.z0.b.e(getContext(), (String) aVar.f11499c, new e(this));
                }
            }
        } else if (i == 9) {
            if (((Boolean) aVar.f11499c).booleanValue()) {
                this.f36684b.setText((CharSequence) null);
            }
            this.f36685c.setEnabled(false);
            l();
        } else if (i == 24 && (obj = aVar.f11499c) != null && (obj instanceof u)) {
            u uVar = (u) obj;
            if (uVar.getType() == EmotionGroupType.NET_SUG) {
                r(uVar);
            } else {
                q(uVar);
            }
        }
    }

    @Override // c.a.o0.w.n
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.m = i;
            SkinManager.setBackgroundColor(this.f36690h, R.color.CAM_X0204, i);
            SkinManager.setViewTextColor(this.f36684b, R.color.CAM_X0106, 2, i);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0207, i);
            if (i == 0) {
                i.l(this.f36684b, R.drawable.obfuscated_res_0x7f0804b8);
                this.f36684b.setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0109));
            } else {
                i.l(this.f36684b, R.drawable.obfuscated_res_0x7f0804b9);
                this.f36684b.setHintTextColor(SkinManager.getColor(i, (int) R.color.CAM_X0109));
            }
            l();
            SkinManager.setImageResource(this.f36686d, R.drawable.pbeditor_face_button);
        }
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f36688f : invokeV.booleanValue;
    }

    public final void q(u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, uVar) == null) {
            if (!this.f36687e || uVar.getType() == EmotionGroupType.LOCAL) {
                String obj = this.f36684b.getText().toString();
                if (this.j && c.a.p0.z0.a.a(obj) >= 10 && getContext() != null) {
                    CustomToast.newInstance().showToast(R.string.obfuscated_res_0x7f0f13fc);
                } else {
                    c.a.p0.z0.b.b(getContext(), uVar, this.f36684b);
                }
            }
        }
    }

    public final void r(u uVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, uVar) == null) || uVar == null || TextUtils.isEmpty(uVar.c()) || TextUtils.isEmpty(uVar.f())) {
            return;
        }
        String obj = this.f36684b.getText().toString();
        if (this.j && c.a.p0.z0.a.a(obj) >= 10 && getContext() != null) {
            CustomToast.newInstance().showToast(R.string.obfuscated_res_0x7f0f13fc);
        } else {
            c.a.p0.z0.b.c(getContext(), uVar, this.f36684b);
        }
    }

    @Override // c.a.o0.w.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, editorTools) == null) {
            this.a = editorTools;
        }
    }

    public void setEmotionClick(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.f36688f = z;
        }
    }

    @Override // c.a.o0.w.n
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.i = i;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f36687e = false;
        this.f36688f = false;
        this.j = true;
        this.k = true;
        this.l = -1;
        this.m = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f36689g = linearLayout;
        linearLayout.setOrientation(0);
        this.f36689g.setMinimumHeight(c.a.d.f.p.n.f(context, R.dimen.obfuscated_res_0x7f070301));
        addView(this.f36689g, new LinearLayout.LayoutParams(-1, -2));
        m(context);
        n(context);
        o(context);
        this.f36690h = new View(getContext());
        this.f36690h.setLayoutParams(new LinearLayout.LayoutParams(-1, c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f070198)));
        addView(this.f36690h);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
