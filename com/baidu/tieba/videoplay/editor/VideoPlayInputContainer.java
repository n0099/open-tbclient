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
import b.a.e.f.p.l;
import b.a.q0.t.c.w;
import b.a.q0.x.n;
import b.a.r0.e4.i;
import b.a.r0.r0.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CustomToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
/* loaded from: classes9.dex */
public class VideoPlayInputContainer extends LinearLayout implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f55944e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f55945f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f55946g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f55947h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f55948i;
    public LinearLayout j;
    public View k;
    public int l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayInputContainer f55949e;

        public a(VideoPlayInputContainer videoPlayInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55949e = videoPlayInputContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f55949e.sendAction(new b.a.q0.x.a(1, 5, null));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayInputContainer f55950e;

        public b(VideoPlayInputContainer videoPlayInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55950e = videoPlayInputContainer;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer videoPlayInputContainer = this.f55950e;
                    videoPlayInputContainer.sendAction(new b.a.q0.x.a(4, -1, videoPlayInputContainer.f55945f.getText().toString()));
                }
                this.f55950e.f55946g.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                this.f55950e.h();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f55950e.n) {
                return;
            }
            this.f55950e.n = true;
            if (this.f55950e.o != -1) {
                this.f55950e.f55945f.setSelection(this.f55950e.o);
                this.f55950e.o = -1;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayInputContainer f55951e;

        public c(VideoPlayInputContainer videoPlayInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55951e = videoPlayInputContainer;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.f55951e.sendAction(new b.a.q0.x.a(5, -1, null));
                    this.f55951e.f55945f.requestFocus();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayInputContainer f55952e;

        public d(VideoPlayInputContainer videoPlayInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55952e = videoPlayInputContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f55952e.sendAction(new b.a.q0.x.a(8, -1, null));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayInputContainer f55953a;

        public e(VideoPlayInputContainer videoPlayInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55953a = videoPlayInputContainer;
        }

        @Override // b.a.r0.r0.b.f
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.f55953a.f55945f.setText(spannableStringBuilder);
                this.f55953a.f55945f.setSelection(this.f55953a.f55945f.getText().length());
                this.f55953a.sendAction(new b.a.q0.x.a(5, -1, null));
                this.f55953a.requestFocus();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.q0.x.n
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            EditText editText = this.f55945f;
            if (editText != null) {
                editText.setFocusable(true);
                this.f55945f.setFocusableInTouchMode(true);
                this.f55945f.requestFocus();
                l.K(getContext(), this.f55945f);
            }
            setVisibility(0);
        }
    }

    public EditText getInputView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f55945f : (EditText) invokeV.objValue;
    }

    @Override // b.a.q0.x.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l : invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f55946g.isEnabled()) {
                SkinManager.setViewTextColor(this.f55946g, b.a.r0.c4.c.CAM_X0302, 1, this.p);
            } else {
                SkinManager.setViewTextColor(this.f55946g, b.a.r0.c4.c.CAM_X0107, 1);
            }
        }
    }

    @Override // b.a.q0.x.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setVisibility(8);
        }
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            ImageView imageView = new ImageView(context);
            this.f55947h = imageView;
            imageView.setEnabled(true);
            this.f55947h.setPadding(0, 0, l.g(context, b.a.r0.c4.d.tbds30), l.g(context, b.a.r0.c4.d.tbds24));
            this.f55947h.setOnClickListener(new a(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 80;
            this.j.addView(this.f55947h, layoutParams);
        }
    }

    @Override // b.a.q0.x.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            EditText editText = new EditText(context);
            this.f55945f = editText;
            editText.setMinHeight(context.getResources().getDimensionPixelSize(b.a.r0.c4.d.ds32));
            this.f55945f.setMaxLines(4);
            this.f55945f.setGravity(16);
            this.f55945f.setTextSize(0, getResources().getDimensionPixelSize(b.a.r0.c4.d.ds32));
            this.f55945f.setBackgroundResource(b.a.r0.c4.c.common_color_10022);
            i.o(this.f55945f, b.a.r0.c4.e.edittext_cursor);
            this.f55945f.setPadding(0, l.g(context, b.a.r0.c4.d.ds24), l.g(context, b.a.r0.c4.d.ds54), l.g(context, b.a.r0.c4.d.ds24));
            this.f55945f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
            this.f55945f.addTextChangedListener(new b(this));
            this.f55945f.setHint(context.getString(b.a.r0.c4.i.reply_something));
            this.f55945f.setOnTouchListener(new c(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            this.j.addView(this.f55945f, layoutParams);
        }
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            TextView textView = new TextView(context);
            this.f55946g = textView;
            textView.setGravity(17);
            this.f55946g.setIncludeFontPadding(false);
            this.f55946g.setEnabled(false);
            this.f55946g.setTextSize(0, context.getResources().getDimensionPixelSize(b.a.r0.c4.d.fontsize32));
            this.f55946g.setText(b.a.r0.c4.i.send_replay);
            this.f55946g.setOnClickListener(new d(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, l.g(context, b.a.r0.c4.d.tbds18));
            layoutParams.gravity = 80;
            this.j.addView(this.f55946g, layoutParams);
        }
    }

    public final void l(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, wVar) == null) {
            if (!this.f55948i || wVar.getType() == EmotionGroupType.LOCAL) {
                String obj = this.f55945f.getText().toString();
                if (this.m && b.a.r0.r0.a.a(obj) >= 10 && getContext() != null) {
                    CustomToast.newInstance().showToast(b.a.r0.c4.i.too_many_face);
                } else {
                    b.a.r0.r0.b.b(getContext(), wVar, this.f55945f);
                }
            }
        }
    }

    public final void m(w wVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, wVar) == null) || wVar == null || TextUtils.isEmpty(wVar.c()) || TextUtils.isEmpty(wVar.f())) {
            return;
        }
        String obj = this.f55945f.getText().toString();
        if (this.m && b.a.r0.r0.a.a(obj) >= 10 && getContext() != null) {
            CustomToast.newInstance().showToast(b.a.r0.c4.i.too_many_face);
        } else {
            b.a.r0.r0.b.c(getContext(), wVar, this.f55945f);
        }
    }

    @Override // b.a.q0.x.b
    public void onAction(b.a.q0.x.a aVar) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) || aVar == null) {
            return;
        }
        int i2 = aVar.f14962a;
        if (i2 == 3) {
            if (this.f55945f.getSelectionStart() > 0) {
                String substring = this.f55945f.getText().toString().substring(0, this.f55945f.getSelectionStart());
                Matcher matcher = b.a.r0.r0.a.f24558b.matcher(substring);
                if (matcher.find()) {
                    this.f55945f.getText().delete(this.f55945f.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.f55945f.getSelectionStart());
                } else {
                    this.f55945f.getText().delete(this.f55945f.getSelectionStart() - 1, this.f55945f.getSelectionStart());
                }
            }
        } else if (i2 == 6) {
            Object obj2 = aVar.f14964c;
            if (obj2 == null) {
                this.f55945f.setText((CharSequence) null);
            } else if (obj2 instanceof String) {
                if (TextUtils.isEmpty((String) obj2)) {
                    this.f55945f.setText((CharSequence) null);
                } else {
                    b.a.r0.r0.b.d(getContext(), (String) aVar.f14964c, new e(this));
                }
            }
        } else if (i2 == 9) {
            if (((Boolean) aVar.f14964c).booleanValue()) {
                this.f55945f.setText((CharSequence) null);
            }
            this.f55946g.setEnabled(false);
            h();
        } else if (i2 == 24 && (obj = aVar.f14964c) != null && (obj instanceof w)) {
            w wVar = (w) obj;
            if (wVar.getType() == EmotionGroupType.NET_SUG) {
                m(wVar);
            } else {
                l(wVar);
            }
        }
    }

    @Override // b.a.q0.x.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.p = i2;
            SkinManager.setBackgroundColor(this.k, b.a.r0.c4.c.CAM_X0204);
            SkinManager.setViewTextColor(this.f55945f, b.a.r0.c4.c.CAM_X0106, 2, i2);
            SkinManager.setBackgroundColor(this, b.a.r0.c4.c.CAM_X0201);
            if (i2 == 0) {
                i.o(this.f55945f, b.a.r0.c4.e.edittext_cursor);
                this.f55945f.setHintTextColor(getContext().getResources().getColor(b.a.r0.c4.c.CAM_X0109));
            } else {
                i.o(this.f55945f, b.a.r0.c4.e.edittext_cursor_1);
                this.f55945f.setHintTextColor(SkinManager.getColor(i2, b.a.r0.c4.c.CAM_X0109));
            }
            h();
            SkinManager.setImageResource(this.f55947h, b.a.r0.c4.e.pbeditor_face_button);
        }
    }

    @Override // b.a.q0.x.n
    public void sendAction(b.a.q0.x.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) || (editorTools = this.f55944e) == null) {
            return;
        }
        editorTools.sendAction(aVar);
    }

    @Override // b.a.q0.x.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, editorTools) == null) {
            this.f55944e = editorTools;
        }
    }

    @Override // b.a.q0.x.n
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.l = i2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPlayInputContainer(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f55948i = false;
        this.m = true;
        this.n = true;
        this.o = -1;
        this.p = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(b.a.r0.c4.d.tbds144));
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.j = linearLayout;
        linearLayout.setOrientation(0);
        this.j.setMinimumHeight(l.g(context, b.a.r0.c4.d.ds90));
        addView(this.j, new LinearLayout.LayoutParams(-1, -2));
        i(context);
        j(context);
        k(context);
        this.k = new View(getContext());
        this.k.setLayoutParams(new LinearLayout.LayoutParams(-1, l.g(getContext(), b.a.r0.c4.d.ds1)));
        addView(this.k);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
