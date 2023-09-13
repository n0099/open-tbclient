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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CustomToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.e47;
import com.baidu.tieba.ed5;
import com.baidu.tieba.f47;
import com.baidu.tieba.fj5;
import com.baidu.tieba.si5;
import com.baidu.tieba.write.WriteVideoUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
/* loaded from: classes8.dex */
public class VideoPlayInputContainer extends LinearLayout implements fj5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools a;
    public EditText b;
    public TextView c;
    public ImageView d;
    public boolean e;
    public boolean f;
    public LinearLayout g;
    public View h;
    public int i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;

    @Override // com.baidu.tieba.fj5
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.f = true;
            this.a.U(new si5(1, 5, null));
        }
    }

    /* loaded from: classes8.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayInputContainer a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

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
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (editable != null && editable.toString().trim() != null) {
                    VideoPlayInputContainer videoPlayInputContainer = this.a;
                    videoPlayInputContainer.U(new si5(4, -1, videoPlayInputContainer.b.getText().toString()));
                }
                TextView textView = this.a.c;
                if (editable != null && !StringUtils.isNull(editable.toString().trim())) {
                    z = true;
                } else {
                    z = false;
                }
                textView.setEnabled(z);
                this.a.i();
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) != null) || this.a.k) {
                return;
            }
            this.a.k = true;
            if (this.a.l != -1) {
                this.a.b.setSelection(this.a.l);
                this.a.l = -1;
            }
        }
    }

    /* loaded from: classes8.dex */
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
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.a.U(new si5(5, -1, null));
                    this.a.b.requestFocus();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.U(new si5(8, -1, null));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements f47.i {
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

        @Override // com.baidu.tieba.f47.i
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.a.b.setText(spannableStringBuilder);
                this.a.b.setSelection(this.a.b.getText().length());
                this.a.U(new si5(5, -1, null));
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
        this.e = false;
        this.f = false;
        this.j = true;
        this.k = true;
        this.l = -1;
        this.m = 0;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds144));
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.g = linearLayout;
        linearLayout.setOrientation(0);
        this.g.setMinimumHeight(BdUtilHelper.getDimens(context, R.dimen.obfuscated_res_0x7f070426));
        addView(this.g, new LinearLayout.LayoutParams(-1, -2));
        j(context);
        k(context);
        l(context);
        this.h = new View(getContext());
        this.h.setLayoutParams(new LinearLayout.LayoutParams(-1, BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f070198)));
        addView(this.h);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.fj5
    public void U(si5 si5Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, si5Var) == null) && (editorTools = this.a) != null) {
            editorTools.D(si5Var);
        }
    }

    @Override // com.baidu.tieba.fj5
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, editorTools) == null) {
            this.a = editorTools;
        }
    }

    public void setEmotionClick(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.f = z;
        }
    }

    @Override // com.baidu.tieba.fj5
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.i = i;
        }
    }

    @Override // com.baidu.tieba.ti5
    public void G(si5 si5Var) {
        Object obj;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, si5Var) != null) || si5Var == null) {
            return;
        }
        int i = si5Var.a;
        if (i != 3) {
            if (i != 6) {
                if (i != 9) {
                    if (i == 24 && (obj = si5Var.c) != null && (obj instanceof ed5)) {
                        ed5 ed5Var = (ed5) obj;
                        if (ed5Var.getType() == EmotionGroupType.NET_SUG) {
                            o(ed5Var);
                            return;
                        } else {
                            n(ed5Var);
                            return;
                        }
                    }
                    return;
                }
                if (((Boolean) si5Var.c).booleanValue()) {
                    this.b.setText((CharSequence) null);
                }
                this.c.setEnabled(false);
                i();
                return;
            }
            Object obj2 = si5Var.c;
            if (obj2 == null) {
                this.b.setText((CharSequence) null);
            } else if (obj2 instanceof String) {
                if (TextUtils.isEmpty((String) obj2)) {
                    this.b.setText((CharSequence) null);
                } else {
                    f47.h(getContext(), (String) si5Var.c, new e(this));
                }
            }
        } else if (this.b.getSelectionStart() > 0) {
            String substring = this.b.getText().toString().substring(0, this.b.getSelectionStart());
            Matcher matcher = e47.b.matcher(substring);
            if (matcher.find()) {
                this.b.getText().delete(this.b.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.b.getSelectionStart());
            } else {
                this.b.getText().delete(this.b.getSelectionStart() - 1, this.b.getSelectionStart());
            }
        }
    }

    @Override // com.baidu.tieba.fj5
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            EditText editText = this.b;
            if (editText != null) {
                editText.setFocusable(true);
                this.b.setFocusableInTouchMode(true);
                this.b.requestFocus();
                BdUtilHelper.showSoftKeyPad(getContext(), this.b);
            }
            setVisibility(0);
        }
    }

    public EditText getInputView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (EditText) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fj5
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.fj5
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setVisibility(8);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.c.isEnabled()) {
                SkinManager.setViewTextColor(this.c, R.color.CAM_X0302, 1, this.m);
            } else {
                SkinManager.setViewTextColor(this.c, R.color.CAM_X0107, 1);
            }
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            ImageView imageView = new ImageView(context);
            this.d = imageView;
            imageView.setEnabled(true);
            this.d.setPadding(0, 0, BdUtilHelper.getDimens(context, R.dimen.tbds30), BdUtilHelper.getDimens(context, R.dimen.tbds24));
            this.d.setOnClickListener(new a(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 80;
            this.g.addView(this.d, layoutParams);
        }
    }

    public final void n(ed5 ed5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ed5Var) == null) {
            if (this.e && ed5Var.getType() != EmotionGroupType.LOCAL) {
                return;
            }
            String obj = this.b.getText().toString();
            if (this.j && e47.a(obj) >= 10 && getContext() != null) {
                CustomToast.newInstance().showToast(R.string.too_many_face);
            } else {
                f47.c(getContext(), ed5Var, this.b);
            }
        }
    }

    public final void o(ed5 ed5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, ed5Var) == null) && ed5Var != null && !TextUtils.isEmpty(ed5Var.d()) && !TextUtils.isEmpty(ed5Var.g())) {
            String obj = this.b.getText().toString();
            if (this.j && e47.a(obj) >= 10 && getContext() != null) {
                CustomToast.newInstance().showToast(R.string.too_many_face);
            } else {
                f47.d(getContext(), ed5Var, this.b);
            }
        }
    }

    @Override // com.baidu.tieba.fj5
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.m = i;
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0204, i);
            SkinManager.setViewTextColor(this.b, R.color.CAM_X0106, 2, i);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0207, i);
            if (i == 0) {
                WriteVideoUtil.setCursorColor(this.b, R.drawable.edittext_cursor);
                this.b.setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0109));
            } else {
                WriteVideoUtil.setCursorColor(this.b, R.drawable.edittext_cursor_2);
                this.b.setHintTextColor(SkinManager.getColor(i, (int) R.color.CAM_X0109));
            }
            i();
            SkinManager.setImageResource(this.d, R.drawable.pbeditor_face_button);
        }
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            EditText editText = new EditText(context);
            this.b = editText;
            editText.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207));
            this.b.setMaxLines(4);
            this.b.setGravity(16);
            this.b.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207));
            this.b.setBackgroundResource(R.color.common_color_10022);
            WriteVideoUtil.setCursorColor(this.b, R.drawable.edittext_cursor);
            this.b.setPadding(0, BdUtilHelper.getDimens(context, R.dimen.obfuscated_res_0x7f0701e8), BdUtilHelper.getDimens(context, R.dimen.obfuscated_res_0x7f0703f8), BdUtilHelper.getDimens(context, R.dimen.obfuscated_res_0x7f0701e8));
            this.b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
            this.b.addTextChangedListener(new b(this));
            this.b.setHint(context.getString(R.string.obfuscated_res_0x7f0f1253));
            this.b.setOnTouchListener(new c(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            this.g.addView(this.b, layoutParams);
        }
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            TextView textView = new TextView(context);
            this.c = textView;
            textView.setGravity(17);
            this.c.setIncludeFontPadding(false);
            this.c.setEnabled(false);
            this.c.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b7));
            this.c.setText(R.string.obfuscated_res_0x7f0f1383);
            this.c.setOnClickListener(new d(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, BdUtilHelper.getDimens(context, R.dimen.tbds18));
            layoutParams.gravity = 80;
            this.g.addView(this.c, layoutParams);
        }
    }
}
