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
import d.a.c.e.p.l;
import d.a.r0.s.c.v;
import d.a.r0.w.n;
import d.a.s0.a4.i;
import d.a.s0.o0.b;
import java.util.regex.Matcher;
/* loaded from: classes5.dex */
public class VideoPlayInputContainer extends LinearLayout implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f21839e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f21840f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21841g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f21842h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21843i;
    public LinearLayout j;
    public View k;
    public int l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayInputContainer f21844e;

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
            this.f21844e = videoPlayInputContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21844e.d(new d.a.r0.w.a(1, 5, null));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayInputContainer f21845e;

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
            this.f21845e = videoPlayInputContainer;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer videoPlayInputContainer = this.f21845e;
                    videoPlayInputContainer.d(new d.a.r0.w.a(4, -1, videoPlayInputContainer.f21840f.getText().toString()));
                }
                this.f21845e.f21841g.setEnabled((editable == null || StringUtils.isNull(editable.toString().trim())) ? false : true);
                this.f21845e.k();
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f21845e.n) {
                return;
            }
            this.f21845e.n = true;
            if (this.f21845e.o != -1) {
                this.f21845e.f21840f.setSelection(this.f21845e.o);
                this.f21845e.o = -1;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayInputContainer f21846e;

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
            this.f21846e = videoPlayInputContainer;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.f21846e.d(new d.a.r0.w.a(5, -1, null));
                    this.f21846e.f21840f.requestFocus();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayInputContainer f21847e;

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
            this.f21847e = videoPlayInputContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21847e.d(new d.a.r0.w.a(8, -1, null));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayInputContainer f21848a;

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
            this.f21848a = videoPlayInputContainer;
        }

        @Override // d.a.s0.o0.b.f
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.f21848a.f21840f.setText(spannableStringBuilder);
                this.f21848a.f21840f.setSelection(this.f21848a.f21840f.getText().length());
                this.f21848a.d(new d.a.r0.w.a(5, -1, null));
                this.f21848a.requestFocus();
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

    @Override // d.a.r0.w.n
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            EditText editText = this.f21840f;
            if (editText != null) {
                editText.setFocusable(true);
                this.f21840f.setFocusableInTouchMode(true);
                this.f21840f.requestFocus();
                l.K(getContext(), this.f21840f);
            }
            setVisibility(0);
        }
    }

    @Override // d.a.r0.w.n
    public void d(d.a.r0.w.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || (editorTools = this.f21839e) == null) {
            return;
        }
        editorTools.A(aVar);
    }

    public EditText getInputView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21840f : (EditText) invokeV.objValue;
    }

    @Override // d.a.r0.w.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l : invokeV.intValue;
    }

    @Override // d.a.r0.w.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setVisibility(8);
        }
    }

    @Override // d.a.r0.w.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.f21841g.isEnabled()) {
                SkinManager.setViewTextColor(this.f21841g, R.color.CAM_X0302, 1, this.p);
            } else {
                SkinManager.setViewTextColor(this.f21841g, R.color.CAM_X0107, 1);
            }
        }
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            ImageView imageView = new ImageView(context);
            this.f21842h = imageView;
            imageView.setEnabled(true);
            this.f21842h.setPadding(0, 0, l.g(context, R.dimen.tbds30), l.g(context, R.dimen.tbds24));
            this.f21842h.setOnClickListener(new a(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 80;
            this.j.addView(this.f21842h, layoutParams);
        }
    }

    public final void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            EditText editText = new EditText(context);
            this.f21840f = editText;
            editText.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
            this.f21840f.setMaxLines(4);
            this.f21840f.setGravity(16);
            this.f21840f.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
            this.f21840f.setBackgroundResource(R.color.common_color_10022);
            i.e(this.f21840f, R.drawable.edittext_cursor);
            this.f21840f.setPadding(0, l.g(context, R.dimen.ds24), l.g(context, R.dimen.ds54), l.g(context, R.dimen.ds24));
            this.f21840f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
            this.f21840f.addTextChangedListener(new b(this));
            this.f21840f.setHint(context.getString(R.string.reply_something));
            this.f21840f.setOnTouchListener(new c(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            this.j.addView(this.f21840f, layoutParams);
        }
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            TextView textView = new TextView(context);
            this.f21841g = textView;
            textView.setGravity(17);
            this.f21841g.setIncludeFontPadding(false);
            this.f21841g.setEnabled(false);
            this.f21841g.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize32));
            this.f21841g.setText(R.string.send_replay);
            this.f21841g.setOnClickListener(new d(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, l.g(context, R.dimen.tbds18));
            layoutParams.gravity = 80;
            this.j.addView(this.f21841g, layoutParams);
        }
    }

    public final void o(v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, vVar) == null) {
            if (!this.f21843i || vVar.f() == EmotionGroupType.LOCAL) {
                String obj = this.f21840f.getText().toString();
                if (this.m && d.a.s0.o0.a.a(obj) >= 10 && getContext() != null) {
                    CustomToast.newInstance().showToast(R.string.too_many_face);
                } else {
                    d.a.s0.o0.b.b(getContext(), vVar, this.f21840f);
                }
            }
        }
    }

    @Override // d.a.r0.w.b
    public void onAction(d.a.r0.w.a aVar) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) || aVar == null) {
            return;
        }
        int i2 = aVar.f56766a;
        if (i2 == 3) {
            if (this.f21840f.getSelectionStart() > 0) {
                String substring = this.f21840f.getText().toString().substring(0, this.f21840f.getSelectionStart());
                Matcher matcher = d.a.s0.o0.a.f64300b.matcher(substring);
                if (matcher.find()) {
                    this.f21840f.getText().delete(this.f21840f.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.f21840f.getSelectionStart());
                } else {
                    this.f21840f.getText().delete(this.f21840f.getSelectionStart() - 1, this.f21840f.getSelectionStart());
                }
            }
        } else if (i2 == 6) {
            Object obj2 = aVar.f56768c;
            if (obj2 == null) {
                this.f21840f.setText((CharSequence) null);
            } else if (obj2 instanceof String) {
                if (TextUtils.isEmpty((String) obj2)) {
                    this.f21840f.setText((CharSequence) null);
                } else {
                    d.a.s0.o0.b.d(getContext(), (String) aVar.f56768c, new e(this));
                }
            }
        } else if (i2 == 9) {
            if (((Boolean) aVar.f56768c).booleanValue()) {
                this.f21840f.setText((CharSequence) null);
            }
            this.f21841g.setEnabled(false);
            k();
        } else if (i2 == 24 && (obj = aVar.f56768c) != null && (obj instanceof v)) {
            v vVar = (v) obj;
            if (vVar.f() == EmotionGroupType.NET_SUG) {
                p(vVar);
            } else {
                o(vVar);
            }
        }
    }

    @Override // d.a.r0.w.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.p = i2;
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f21840f, R.color.CAM_X0106, 2, i2);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            if (i2 == 0) {
                i.e(this.f21840f, R.drawable.edittext_cursor);
                this.f21840f.setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0109));
            } else {
                i.e(this.f21840f, R.drawable.edittext_cursor_1);
                this.f21840f.setHintTextColor(SkinManager.getColor(i2, R.color.CAM_X0109));
            }
            k();
            SkinManager.setImageResource(this.f21842h, R.drawable.pbeditor_face_button);
        }
    }

    public final void p(v vVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, vVar) == null) || vVar == null || TextUtils.isEmpty(vVar.c()) || TextUtils.isEmpty(vVar.g())) {
            return;
        }
        String obj = this.f21840f.getText().toString();
        if (this.m && d.a.s0.o0.a.a(obj) >= 10 && getContext() != null) {
            CustomToast.newInstance().showToast(R.string.too_many_face);
        } else {
            d.a.s0.o0.b.c(getContext(), vVar, this.f21840f);
        }
    }

    @Override // d.a.r0.w.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, editorTools) == null) {
            this.f21839e = editorTools;
        }
    }

    @Override // d.a.r0.w.n
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
        this.f21843i = false;
        this.m = true;
        this.n = true;
        this.o = -1;
        this.p = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.j = linearLayout;
        linearLayout.setOrientation(0);
        this.j.setMinimumHeight(l.g(context, R.dimen.ds90));
        addView(this.j, new LinearLayout.LayoutParams(-1, -2));
        l(context);
        m(context);
        n(context);
        this.k = new View(getContext());
        this.k.setLayoutParams(new LinearLayout.LayoutParams(-1, l.g(getContext(), R.dimen.ds1)));
        addView(this.k);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
