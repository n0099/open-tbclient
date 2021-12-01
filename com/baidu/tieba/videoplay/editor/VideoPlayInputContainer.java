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
import c.a.d.f.p.l;
import c.a.q0.t.c.w;
import c.a.q0.x.n;
import c.a.r0.l4.i;
import c.a.r0.x0.b;
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
/* loaded from: classes11.dex */
public class VideoPlayInputContainer extends LinearLayout implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f50037e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f50038f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f50039g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f50040h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f50041i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f50042j;

    /* renamed from: k  reason: collision with root package name */
    public LinearLayout f50043k;
    public View l;
    public int m;
    public boolean n;
    public boolean o;
    public int p;
    public int q;

    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayInputContainer f50044e;

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
            this.f50044e = videoPlayInputContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50044e.f50042j = true;
                this.f50044e.sendAction(new c.a.q0.x.a(1, 5, null));
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayInputContainer f50045e;

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
            this.f50045e = videoPlayInputContainer;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer videoPlayInputContainer = this.f50045e;
                    videoPlayInputContainer.sendAction(new c.a.q0.x.a(4, -1, videoPlayInputContainer.f50038f.getText().toString()));
                }
                this.f50045e.f50039g.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                this.f50045e.i();
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f50045e.o) {
                return;
            }
            this.f50045e.o = true;
            if (this.f50045e.p != -1) {
                this.f50045e.f50038f.setSelection(this.f50045e.p);
                this.f50045e.p = -1;
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayInputContainer f50046e;

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
            this.f50046e = videoPlayInputContainer;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.f50046e.sendAction(new c.a.q0.x.a(5, -1, null));
                    this.f50046e.f50038f.requestFocus();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayInputContainer f50047e;

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
            this.f50047e = videoPlayInputContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50047e.sendAction(new c.a.q0.x.a(8, -1, null));
            }
        }
    }

    /* loaded from: classes11.dex */
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

        @Override // c.a.r0.x0.b.g
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.a.f50038f.setText(spannableStringBuilder);
                this.a.f50038f.setSelection(this.a.f50038f.getText().length());
                this.a.sendAction(new c.a.q0.x.a(5, -1, null));
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

    @Override // c.a.q0.x.n
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            EditText editText = this.f50038f;
            if (editText != null) {
                editText.setFocusable(true);
                this.f50038f.setFocusableInTouchMode(true);
                this.f50038f.requestFocus();
                l.K(getContext(), this.f50038f);
            }
            setVisibility(0);
        }
    }

    public EditText getInputView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f50038f : (EditText) invokeV.objValue;
    }

    @Override // c.a.q0.x.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.m : invokeV.intValue;
    }

    @Override // c.a.q0.x.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setVisibility(8);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f50039g.isEnabled()) {
                SkinManager.setViewTextColor(this.f50039g, c.a.r0.j4.c.CAM_X0302, 1, this.q);
            } else {
                SkinManager.setViewTextColor(this.f50039g, c.a.r0.j4.c.CAM_X0107, 1);
            }
        }
    }

    @Override // c.a.q0.x.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public boolean isEmotionClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f50042j : invokeV.booleanValue;
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            ImageView imageView = new ImageView(context);
            this.f50040h = imageView;
            imageView.setEnabled(true);
            this.f50040h.setPadding(0, 0, l.f(context, c.a.r0.j4.d.tbds30), l.f(context, c.a.r0.j4.d.tbds24));
            this.f50040h.setOnClickListener(new a(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 80;
            this.f50043k.addView(this.f50040h, layoutParams);
        }
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            EditText editText = new EditText(context);
            this.f50038f = editText;
            editText.setMinHeight(context.getResources().getDimensionPixelSize(c.a.r0.j4.d.ds32));
            this.f50038f.setMaxLines(4);
            this.f50038f.setGravity(16);
            this.f50038f.setTextSize(0, getResources().getDimensionPixelSize(c.a.r0.j4.d.ds32));
            this.f50038f.setBackgroundResource(c.a.r0.j4.c.common_color_10022);
            i.n(this.f50038f, c.a.r0.j4.e.edittext_cursor);
            this.f50038f.setPadding(0, l.f(context, c.a.r0.j4.d.ds24), l.f(context, c.a.r0.j4.d.ds54), l.f(context, c.a.r0.j4.d.ds24));
            this.f50038f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
            this.f50038f.addTextChangedListener(new b(this));
            this.f50038f.setHint(context.getString(c.a.r0.j4.i.reply_something));
            this.f50038f.setOnTouchListener(new c(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            this.f50043k.addView(this.f50038f, layoutParams);
        }
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            TextView textView = new TextView(context);
            this.f50039g = textView;
            textView.setGravity(17);
            this.f50039g.setIncludeFontPadding(false);
            this.f50039g.setEnabled(false);
            this.f50039g.setTextSize(0, context.getResources().getDimensionPixelSize(c.a.r0.j4.d.fontsize32));
            this.f50039g.setText(c.a.r0.j4.i.send_replay);
            this.f50039g.setOnClickListener(new d(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, l.f(context, c.a.r0.j4.d.tbds18));
            layoutParams.gravity = 80;
            this.f50043k.addView(this.f50039g, layoutParams);
        }
    }

    public final void m(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, wVar) == null) {
            if (!this.f50041i || wVar.getType() == EmotionGroupType.LOCAL) {
                String obj = this.f50038f.getText().toString();
                if (this.n && c.a.r0.x0.a.a(obj) >= 10 && getContext() != null) {
                    CustomToast.newInstance().showToast(c.a.r0.j4.i.too_many_face);
                } else {
                    c.a.r0.x0.b.b(getContext(), wVar, this.f50038f);
                }
            }
        }
    }

    public final void n(w wVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, wVar) == null) || wVar == null || TextUtils.isEmpty(wVar.c()) || TextUtils.isEmpty(wVar.f())) {
            return;
        }
        String obj = this.f50038f.getText().toString();
        if (this.n && c.a.r0.x0.a.a(obj) >= 10 && getContext() != null) {
            CustomToast.newInstance().showToast(c.a.r0.j4.i.too_many_face);
        } else {
            c.a.r0.x0.b.c(getContext(), wVar, this.f50038f);
        }
    }

    @Override // c.a.q0.x.b
    public void onAction(c.a.q0.x.a aVar) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) || aVar == null) {
            return;
        }
        int i2 = aVar.a;
        if (i2 == 3) {
            if (this.f50038f.getSelectionStart() > 0) {
                String substring = this.f50038f.getText().toString().substring(0, this.f50038f.getSelectionStart());
                Matcher matcher = c.a.r0.x0.a.f25322b.matcher(substring);
                if (matcher.find()) {
                    this.f50038f.getText().delete(this.f50038f.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.f50038f.getSelectionStart());
                } else {
                    this.f50038f.getText().delete(this.f50038f.getSelectionStart() - 1, this.f50038f.getSelectionStart());
                }
            }
        } else if (i2 == 6) {
            Object obj2 = aVar.f13679c;
            if (obj2 == null) {
                this.f50038f.setText((CharSequence) null);
            } else if (obj2 instanceof String) {
                if (TextUtils.isEmpty((String) obj2)) {
                    this.f50038f.setText((CharSequence) null);
                } else {
                    c.a.r0.x0.b.e(getContext(), (String) aVar.f13679c, new e(this));
                }
            }
        } else if (i2 == 9) {
            if (((Boolean) aVar.f13679c).booleanValue()) {
                this.f50038f.setText((CharSequence) null);
            }
            this.f50039g.setEnabled(false);
            i();
        } else if (i2 == 24 && (obj = aVar.f13679c) != null && (obj instanceof w)) {
            w wVar = (w) obj;
            if (wVar.getType() == EmotionGroupType.NET_SUG) {
                n(wVar);
            } else {
                m(wVar);
            }
        }
    }

    @Override // c.a.q0.x.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.q = i2;
            SkinManager.setBackgroundColor(this.l, c.a.r0.j4.c.CAM_X0204, i2);
            SkinManager.setViewTextColor(this.f50038f, c.a.r0.j4.c.CAM_X0106, 2, i2);
            SkinManager.setBackgroundColor(this, c.a.r0.j4.c.CAM_X0207, i2);
            if (i2 == 0) {
                i.n(this.f50038f, c.a.r0.j4.e.edittext_cursor);
                this.f50038f.setHintTextColor(getContext().getResources().getColor(c.a.r0.j4.c.CAM_X0109));
            } else {
                i.n(this.f50038f, c.a.r0.j4.e.edittext_cursor_1);
                this.f50038f.setHintTextColor(SkinManager.getColor(i2, c.a.r0.j4.c.CAM_X0109));
            }
            i();
            SkinManager.setImageResource(this.f50040h, c.a.r0.j4.e.pbeditor_face_button);
        }
    }

    @Override // c.a.q0.x.n
    public void sendAction(c.a.q0.x.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) || (editorTools = this.f50037e) == null) {
            return;
        }
        editorTools.sendAction(aVar);
    }

    @Override // c.a.q0.x.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, editorTools) == null) {
            this.f50037e = editorTools;
        }
    }

    public void setEmotionClick(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.f50042j = z;
        }
    }

    @Override // c.a.q0.x.n
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
        this.f50041i = false;
        this.f50042j = false;
        this.n = true;
        this.o = true;
        this.p = -1;
        this.q = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(c.a.r0.j4.d.tbds144));
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f50043k = linearLayout;
        linearLayout.setOrientation(0);
        this.f50043k.setMinimumHeight(l.f(context, c.a.r0.j4.d.ds90));
        addView(this.f50043k, new LinearLayout.LayoutParams(-1, -2));
        j(context);
        k(context);
        l(context);
        this.l = new View(getContext());
        this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, l.f(getContext(), c.a.r0.j4.d.ds1)));
        addView(this.l);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
