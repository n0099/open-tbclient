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
import c.a.d.f.p.m;
import c.a.r0.t.c.w;
import c.a.r0.x.n;
import c.a.s0.l4.i;
import c.a.s0.n4.s;
import c.a.s0.x0.b;
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
/* loaded from: classes12.dex */
public class VideoPlayInputContainer extends LinearLayout implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f50555e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f50556f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f50557g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f50558h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f50559i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f50560j;

    /* renamed from: k  reason: collision with root package name */
    public LinearLayout f50561k;
    public View l;
    public int m;
    public boolean n;
    public boolean o;
    public int p;
    public int q;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayInputContainer f50562e;

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
            this.f50562e = videoPlayInputContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50562e.f50560j = true;
                this.f50562e.sendAction(new c.a.r0.x.a(1, 5, null));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayInputContainer f50563e;

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
            this.f50563e = videoPlayInputContainer;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer videoPlayInputContainer = this.f50563e;
                    videoPlayInputContainer.sendAction(new c.a.r0.x.a(4, -1, videoPlayInputContainer.f50556f.getText().toString()));
                }
                this.f50563e.f50557g.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                this.f50563e.i();
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f50563e.o) {
                return;
            }
            this.f50563e.o = true;
            if (this.f50563e.p != -1) {
                this.f50563e.f50556f.setSelection(this.f50563e.p);
                this.f50563e.p = -1;
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayInputContainer f50564e;

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
            this.f50564e = videoPlayInputContainer;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.f50564e.sendAction(new c.a.r0.x.a(5, -1, null));
                    this.f50564e.f50556f.requestFocus();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayInputContainer f50565e;

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
            this.f50565e = videoPlayInputContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50565e.sendAction(new c.a.r0.x.a(8, -1, null));
            }
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayInputContainer;
        }

        @Override // c.a.s0.x0.b.g
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.a.f50556f.setText(spannableStringBuilder);
                this.a.f50556f.setSelection(this.a.f50556f.getText().length());
                this.a.sendAction(new c.a.r0.x.a(5, -1, null));
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

    @Override // c.a.r0.x.n
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            EditText editText = this.f50556f;
            if (editText != null) {
                editText.setFocusable(true);
                this.f50556f.setFocusableInTouchMode(true);
                this.f50556f.requestFocus();
                m.K(getContext(), this.f50556f);
            }
            setVisibility(0);
        }
    }

    public EditText getInputView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f50556f : (EditText) invokeV.objValue;
    }

    @Override // c.a.r0.x.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.m : invokeV.intValue;
    }

    @Override // c.a.r0.x.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setVisibility(8);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f50557g.isEnabled()) {
                SkinManager.setViewTextColor(this.f50557g, c.a.s0.l4.c.CAM_X0302, 1, this.q);
            } else {
                SkinManager.setViewTextColor(this.f50557g, c.a.s0.l4.c.CAM_X0107, 1);
            }
        }
    }

    @Override // c.a.r0.x.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public boolean isEmotionClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f50560j : invokeV.booleanValue;
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            ImageView imageView = new ImageView(context);
            this.f50558h = imageView;
            imageView.setEnabled(true);
            this.f50558h.setPadding(0, 0, m.f(context, c.a.s0.l4.d.tbds30), m.f(context, c.a.s0.l4.d.tbds24));
            this.f50558h.setOnClickListener(new a(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 80;
            this.f50561k.addView(this.f50558h, layoutParams);
        }
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            EditText editText = new EditText(context);
            this.f50556f = editText;
            editText.setMinHeight(context.getResources().getDimensionPixelSize(c.a.s0.l4.d.ds32));
            this.f50556f.setMaxLines(4);
            this.f50556f.setGravity(16);
            this.f50556f.setTextSize(0, getResources().getDimensionPixelSize(c.a.s0.l4.d.ds32));
            this.f50556f.setBackgroundResource(c.a.s0.l4.c.common_color_10022);
            s.n(this.f50556f, c.a.s0.l4.e.edittext_cursor);
            this.f50556f.setPadding(0, m.f(context, c.a.s0.l4.d.ds24), m.f(context, c.a.s0.l4.d.ds54), m.f(context, c.a.s0.l4.d.ds24));
            this.f50556f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
            this.f50556f.addTextChangedListener(new b(this));
            this.f50556f.setHint(context.getString(i.reply_something));
            this.f50556f.setOnTouchListener(new c(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            this.f50561k.addView(this.f50556f, layoutParams);
        }
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            TextView textView = new TextView(context);
            this.f50557g = textView;
            textView.setGravity(17);
            this.f50557g.setIncludeFontPadding(false);
            this.f50557g.setEnabled(false);
            this.f50557g.setTextSize(0, context.getResources().getDimensionPixelSize(c.a.s0.l4.d.fontsize32));
            this.f50557g.setText(i.send_replay);
            this.f50557g.setOnClickListener(new d(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, m.f(context, c.a.s0.l4.d.tbds18));
            layoutParams.gravity = 80;
            this.f50561k.addView(this.f50557g, layoutParams);
        }
    }

    public final void m(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, wVar) == null) {
            if (!this.f50559i || wVar.getType() == EmotionGroupType.LOCAL) {
                String obj = this.f50556f.getText().toString();
                if (this.n && c.a.s0.x0.a.a(obj) >= 10 && getContext() != null) {
                    CustomToast.newInstance().showToast(i.too_many_face);
                } else {
                    c.a.s0.x0.b.b(getContext(), wVar, this.f50556f);
                }
            }
        }
    }

    public final void n(w wVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, wVar) == null) || wVar == null || TextUtils.isEmpty(wVar.c()) || TextUtils.isEmpty(wVar.f())) {
            return;
        }
        String obj = this.f50556f.getText().toString();
        if (this.n && c.a.s0.x0.a.a(obj) >= 10 && getContext() != null) {
            CustomToast.newInstance().showToast(i.too_many_face);
        } else {
            c.a.s0.x0.b.c(getContext(), wVar, this.f50556f);
        }
    }

    @Override // c.a.r0.x.b
    public void onAction(c.a.r0.x.a aVar) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) || aVar == null) {
            return;
        }
        int i2 = aVar.a;
        if (i2 == 3) {
            if (this.f50556f.getSelectionStart() > 0) {
                String substring = this.f50556f.getText().toString().substring(0, this.f50556f.getSelectionStart());
                Matcher matcher = c.a.s0.x0.a.f25362b.matcher(substring);
                if (matcher.find()) {
                    this.f50556f.getText().delete(this.f50556f.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.f50556f.getSelectionStart());
                } else {
                    this.f50556f.getText().delete(this.f50556f.getSelectionStart() - 1, this.f50556f.getSelectionStart());
                }
            }
        } else if (i2 == 6) {
            Object obj2 = aVar.f14019c;
            if (obj2 == null) {
                this.f50556f.setText((CharSequence) null);
            } else if (obj2 instanceof String) {
                if (TextUtils.isEmpty((String) obj2)) {
                    this.f50556f.setText((CharSequence) null);
                } else {
                    c.a.s0.x0.b.e(getContext(), (String) aVar.f14019c, new e(this));
                }
            }
        } else if (i2 == 9) {
            if (((Boolean) aVar.f14019c).booleanValue()) {
                this.f50556f.setText((CharSequence) null);
            }
            this.f50557g.setEnabled(false);
            i();
        } else if (i2 == 24 && (obj = aVar.f14019c) != null && (obj instanceof w)) {
            w wVar = (w) obj;
            if (wVar.getType() == EmotionGroupType.NET_SUG) {
                n(wVar);
            } else {
                m(wVar);
            }
        }
    }

    @Override // c.a.r0.x.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.q = i2;
            SkinManager.setBackgroundColor(this.l, c.a.s0.l4.c.CAM_X0204, i2);
            SkinManager.setViewTextColor(this.f50556f, c.a.s0.l4.c.CAM_X0106, 2, i2);
            SkinManager.setBackgroundColor(this, c.a.s0.l4.c.CAM_X0207, i2);
            if (i2 == 0) {
                s.n(this.f50556f, c.a.s0.l4.e.edittext_cursor);
                this.f50556f.setHintTextColor(getContext().getResources().getColor(c.a.s0.l4.c.CAM_X0109));
            } else {
                s.n(this.f50556f, c.a.s0.l4.e.edittext_cursor_1);
                this.f50556f.setHintTextColor(SkinManager.getColor(i2, c.a.s0.l4.c.CAM_X0109));
            }
            i();
            SkinManager.setImageResource(this.f50558h, c.a.s0.l4.e.pbeditor_face_button);
        }
    }

    @Override // c.a.r0.x.n
    public void sendAction(c.a.r0.x.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) || (editorTools = this.f50555e) == null) {
            return;
        }
        editorTools.sendAction(aVar);
    }

    @Override // c.a.r0.x.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, editorTools) == null) {
            this.f50555e = editorTools;
        }
    }

    public void setEmotionClick(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.f50560j = z;
        }
    }

    @Override // c.a.r0.x.n
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.m = i2;
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
        this.f50559i = false;
        this.f50560j = false;
        this.n = true;
        this.o = true;
        this.p = -1;
        this.q = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(c.a.s0.l4.d.tbds144));
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f50561k = linearLayout;
        linearLayout.setOrientation(0);
        this.f50561k.setMinimumHeight(m.f(context, c.a.s0.l4.d.ds90));
        addView(this.f50561k, new LinearLayout.LayoutParams(-1, -2));
        j(context);
        k(context);
        l(context);
        this.l = new View(getContext());
        this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, m.f(getContext(), c.a.s0.l4.d.ds1)));
        addView(this.l);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
