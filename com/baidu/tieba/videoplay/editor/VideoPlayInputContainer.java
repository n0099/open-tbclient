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
import c.a.s0.t.c.w;
import c.a.s0.x.n;
import c.a.t0.m4.i;
import c.a.t0.p4.s;
import c.a.t0.y0.b;
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
/* loaded from: classes13.dex */
public class VideoPlayInputContainer extends LinearLayout implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f48893e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f48894f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f48895g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f48896h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f48897i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f48898j;
    public LinearLayout k;
    public View l;
    public int m;
    public boolean n;
    public boolean o;
    public int p;
    public int q;

    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayInputContainer f48899e;

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
            this.f48899e = videoPlayInputContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f48899e.f48898j = true;
                this.f48899e.sendAction(new c.a.s0.x.a(1, 5, null));
            }
        }
    }

    /* loaded from: classes13.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayInputContainer f48900e;

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
            this.f48900e = videoPlayInputContainer;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer videoPlayInputContainer = this.f48900e;
                    videoPlayInputContainer.sendAction(new c.a.s0.x.a(4, -1, videoPlayInputContainer.f48894f.getText().toString()));
                }
                this.f48900e.f48895g.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                this.f48900e.i();
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f48900e.o) {
                return;
            }
            this.f48900e.o = true;
            if (this.f48900e.p != -1) {
                this.f48900e.f48894f.setSelection(this.f48900e.p);
                this.f48900e.p = -1;
            }
        }
    }

    /* loaded from: classes13.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayInputContainer f48901e;

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
            this.f48901e = videoPlayInputContainer;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.f48901e.sendAction(new c.a.s0.x.a(5, -1, null));
                    this.f48901e.f48894f.requestFocus();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes13.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayInputContainer f48902e;

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
            this.f48902e = videoPlayInputContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f48902e.sendAction(new c.a.s0.x.a(8, -1, null));
            }
        }
    }

    /* loaded from: classes13.dex */
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

        @Override // c.a.t0.y0.b.g
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.a.f48894f.setText(spannableStringBuilder);
                this.a.f48894f.setSelection(this.a.f48894f.getText().length());
                this.a.sendAction(new c.a.s0.x.a(5, -1, null));
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

    @Override // c.a.s0.x.n
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            EditText editText = this.f48894f;
            if (editText != null) {
                editText.setFocusable(true);
                this.f48894f.setFocusableInTouchMode(true);
                this.f48894f.requestFocus();
                c.a.d.f.p.n.L(getContext(), this.f48894f);
            }
            setVisibility(0);
        }
    }

    public EditText getInputView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f48894f : (EditText) invokeV.objValue;
    }

    @Override // c.a.s0.x.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.m : invokeV.intValue;
    }

    @Override // c.a.s0.x.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setVisibility(8);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f48895g.isEnabled()) {
                SkinManager.setViewTextColor(this.f48895g, c.a.t0.m4.c.CAM_X0302, 1, this.q);
            } else {
                SkinManager.setViewTextColor(this.f48895g, c.a.t0.m4.c.CAM_X0107, 1);
            }
        }
    }

    @Override // c.a.s0.x.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public boolean isEmotionClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f48898j : invokeV.booleanValue;
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            ImageView imageView = new ImageView(context);
            this.f48896h = imageView;
            imageView.setEnabled(true);
            this.f48896h.setPadding(0, 0, c.a.d.f.p.n.f(context, c.a.t0.m4.d.tbds30), c.a.d.f.p.n.f(context, c.a.t0.m4.d.tbds24));
            this.f48896h.setOnClickListener(new a(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 80;
            this.k.addView(this.f48896h, layoutParams);
        }
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            EditText editText = new EditText(context);
            this.f48894f = editText;
            editText.setMinHeight(context.getResources().getDimensionPixelSize(c.a.t0.m4.d.ds32));
            this.f48894f.setMaxLines(4);
            this.f48894f.setGravity(16);
            this.f48894f.setTextSize(0, getResources().getDimensionPixelSize(c.a.t0.m4.d.ds32));
            this.f48894f.setBackgroundResource(c.a.t0.m4.c.common_color_10022);
            s.l(this.f48894f, c.a.t0.m4.e.edittext_cursor);
            this.f48894f.setPadding(0, c.a.d.f.p.n.f(context, c.a.t0.m4.d.ds24), c.a.d.f.p.n.f(context, c.a.t0.m4.d.ds54), c.a.d.f.p.n.f(context, c.a.t0.m4.d.ds24));
            this.f48894f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
            this.f48894f.addTextChangedListener(new b(this));
            this.f48894f.setHint(context.getString(i.reply_something));
            this.f48894f.setOnTouchListener(new c(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            this.k.addView(this.f48894f, layoutParams);
        }
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            TextView textView = new TextView(context);
            this.f48895g = textView;
            textView.setGravity(17);
            this.f48895g.setIncludeFontPadding(false);
            this.f48895g.setEnabled(false);
            this.f48895g.setTextSize(0, context.getResources().getDimensionPixelSize(c.a.t0.m4.d.fontsize32));
            this.f48895g.setText(i.send_replay);
            this.f48895g.setOnClickListener(new d(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, c.a.d.f.p.n.f(context, c.a.t0.m4.d.tbds18));
            layoutParams.gravity = 80;
            this.k.addView(this.f48895g, layoutParams);
        }
    }

    public final void m(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, wVar) == null) {
            if (!this.f48897i || wVar.getType() == EmotionGroupType.LOCAL) {
                String obj = this.f48894f.getText().toString();
                if (this.n && c.a.t0.y0.a.a(obj) >= 10 && getContext() != null) {
                    CustomToast.newInstance().showToast(i.too_many_face);
                } else {
                    c.a.t0.y0.b.b(getContext(), wVar, this.f48894f);
                }
            }
        }
    }

    public final void n(w wVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, wVar) == null) || wVar == null || TextUtils.isEmpty(wVar.c()) || TextUtils.isEmpty(wVar.f())) {
            return;
        }
        String obj = this.f48894f.getText().toString();
        if (this.n && c.a.t0.y0.a.a(obj) >= 10 && getContext() != null) {
            CustomToast.newInstance().showToast(i.too_many_face);
        } else {
            c.a.t0.y0.b.c(getContext(), wVar, this.f48894f);
        }
    }

    @Override // c.a.s0.x.b
    public void onAction(c.a.s0.x.a aVar) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) || aVar == null) {
            return;
        }
        int i2 = aVar.a;
        if (i2 == 3) {
            if (this.f48894f.getSelectionStart() > 0) {
                String substring = this.f48894f.getText().toString().substring(0, this.f48894f.getSelectionStart());
                Matcher matcher = c.a.t0.y0.a.f25373b.matcher(substring);
                if (matcher.find()) {
                    this.f48894f.getText().delete(this.f48894f.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.f48894f.getSelectionStart());
                } else {
                    this.f48894f.getText().delete(this.f48894f.getSelectionStart() - 1, this.f48894f.getSelectionStart());
                }
            }
        } else if (i2 == 6) {
            Object obj2 = aVar.f14320c;
            if (obj2 == null) {
                this.f48894f.setText((CharSequence) null);
            } else if (obj2 instanceof String) {
                if (TextUtils.isEmpty((String) obj2)) {
                    this.f48894f.setText((CharSequence) null);
                } else {
                    c.a.t0.y0.b.e(getContext(), (String) aVar.f14320c, new e(this));
                }
            }
        } else if (i2 == 9) {
            if (((Boolean) aVar.f14320c).booleanValue()) {
                this.f48894f.setText((CharSequence) null);
            }
            this.f48895g.setEnabled(false);
            i();
        } else if (i2 == 24 && (obj = aVar.f14320c) != null && (obj instanceof w)) {
            w wVar = (w) obj;
            if (wVar.getType() == EmotionGroupType.NET_SUG) {
                n(wVar);
            } else {
                m(wVar);
            }
        }
    }

    @Override // c.a.s0.x.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.q = i2;
            SkinManager.setBackgroundColor(this.l, c.a.t0.m4.c.CAM_X0204, i2);
            SkinManager.setViewTextColor(this.f48894f, c.a.t0.m4.c.CAM_X0106, 2, i2);
            SkinManager.setBackgroundColor(this, c.a.t0.m4.c.CAM_X0207, i2);
            if (i2 == 0) {
                s.l(this.f48894f, c.a.t0.m4.e.edittext_cursor);
                this.f48894f.setHintTextColor(getContext().getResources().getColor(c.a.t0.m4.c.CAM_X0109));
            } else {
                s.l(this.f48894f, c.a.t0.m4.e.edittext_cursor_1);
                this.f48894f.setHintTextColor(SkinManager.getColor(i2, c.a.t0.m4.c.CAM_X0109));
            }
            i();
            SkinManager.setImageResource(this.f48896h, c.a.t0.m4.e.pbeditor_face_button);
        }
    }

    @Override // c.a.s0.x.n
    public void sendAction(c.a.s0.x.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) || (editorTools = this.f48893e) == null) {
            return;
        }
        editorTools.sendAction(aVar);
    }

    @Override // c.a.s0.x.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, editorTools) == null) {
            this.f48893e = editorTools;
        }
    }

    public void setEmotionClick(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.f48898j = z;
        }
    }

    @Override // c.a.s0.x.n
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
        this.f48897i = false;
        this.f48898j = false;
        this.n = true;
        this.o = true;
        this.p = -1;
        this.q = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(c.a.t0.m4.d.tbds144));
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.k = linearLayout;
        linearLayout.setOrientation(0);
        this.k.setMinimumHeight(c.a.d.f.p.n.f(context, c.a.t0.m4.d.ds90));
        addView(this.k, new LinearLayout.LayoutParams(-1, -2));
        j(context);
        k(context);
        l(context);
        this.l = new View(getContext());
        this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, c.a.d.f.p.n.f(getContext(), c.a.t0.m4.d.ds1)));
        addView(this.l);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
