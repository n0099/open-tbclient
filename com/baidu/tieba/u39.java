package com.baidu.tieba;

import android.content.Intent;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.k29;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class u39 extends y39<r49> implements e49 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public View g;
    @Nullable
    public EditText h;
    @Nullable
    public TextView i;
    @Nullable
    public View j;
    @Nullable
    public z39 k;
    @NonNull
    public final e59 l;
    @NonNull
    public x29 m;
    @Nullable
    public String n;
    public final TextWatcher o;
    public final View.OnFocusChangeListener p;

    /* loaded from: classes6.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ u39 b;

        public a(u39 u39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u39Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || editable == null || this.b.h == null || this.b.h.getText() == null) {
                return;
            }
            if (this.b.n != null && this.b.n.equals(editable.toString())) {
                this.b.h.setSelection(this.b.h.getSelectionEnd());
                return;
            }
            u39 u39Var = this.b;
            u39Var.n = u39Var.h.getText().toString();
            if (this.b.e != null) {
                this.b.e.setTitle(this.b.n);
            }
            if (this.b.b != null) {
                this.b.b.h();
            }
            u39 u39Var2 = this.b;
            u39Var2.m.i(u39Var2.h, true);
            this.b.M(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                this.a = charSequence != null ? charSequence.toString() : "";
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                String str = this.a;
                if ((charSequence != null ? charSequence.toString().length() : 0) > (str != null ? str.length() : 0)) {
                    this.b.l.c(charSequence, i, i3, "from_title");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u39 a;

        public b(u39 u39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u39Var;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) || this.a.k == null) {
                return;
            }
            this.a.k.q(this.a, z);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u39 a;

        public c(u39 u39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u39Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.h.setPadding(this.a.h.getPaddingLeft(), this.a.h.getPaddingTop(), this.a.h.getPaddingRight(), this.a.h.getPaddingBottom() + this.a.i.getHeight());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements k29.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u39 a;

        public d(u39 u39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u39Var;
        }

        @Override // com.baidu.tieba.k29.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ej.N(TbadkCoreApplication.getInst(), String.format(this.a.a.getString(R.string.obfuscated_res_0x7f0f15f8), 31));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u39(@NonNull TbPageContext<?> tbPageContext, @NonNull x29 x29Var, @NonNull e59 e59Var) {
        super(tbPageContext, r49.class);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, x29Var, e59Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (Class) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new a(this);
        this.p = new b(this);
        this.m = x29Var;
        this.l = e59Var;
    }

    public final void J(String str) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || StringUtils.isNull(str) || (editText = this.h) == null || editText.getText() == null) {
            return;
        }
        this.l.f("");
        this.h.requestFocus();
        if (this.h.getText() != null && this.h.getText().length() + str.length() > 31) {
            this.a.showToast((int) R.string.obfuscated_res_0x7f0f0d37);
            return;
        }
        int selectionStart = this.h.getSelectionStart();
        Editable text = this.h.getText();
        if (selectionStart < 0 || selectionStart > text.length()) {
            return;
        }
        text.insert(selectionStart, str);
    }

    public void K(z39 z39Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z39Var) == null) {
            this.k = z39Var;
        }
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            EditText editText = this.h;
            return editText != null && editText.hasFocus();
        }
        return invokeV.booleanValue;
    }

    public final void M(Editable editable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, editable) == null) || this.i == null) {
            return;
        }
        if (!TextUtils.isEmpty(editable)) {
            SpannableString spannableString = new SpannableString(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f090d, new Object[]{Integer.valueOf(editable.length()), 31}));
            if (editable.length() > 31) {
                spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)), 0, String.valueOf(editable.length()).length(), 17);
            }
            this.i.setText(spannableString);
            return;
        }
        this.i.setText(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f090d, new Object[]{0, 31}));
    }

    @Override // com.baidu.tieba.e49
    public void a(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || z || (editText = this.h) == null) {
            return;
        }
        editText.clearFocus();
    }

    @Override // com.baidu.tieba.d49
    public void b(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, writeData) == null) {
            EditText editText = this.h;
            if (editText != null && editText.getVisibility() == 0 && this.h.getText() != null) {
                String obj = this.h.getText().toString();
                writeData.setTitle(obj);
                writeData.setIsNoTitle(TextUtils.isEmpty(obj));
                return;
            }
            writeData.setTitle("");
            writeData.setIsNoTitle(true);
        }
    }

    @Override // com.baidu.tieba.d49
    public void d(@NonNull WriteData writeData) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, writeData) == null) || (editText = this.h) == null || editText.getText() == null) {
            return;
        }
        writeData.setTitle(this.h.getText().toString());
    }

    @Override // com.baidu.tieba.e49
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.y39, com.baidu.tieba.d49
    public void h(@NonNull f49 f49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, f49Var) == null) {
            super.h(f49Var);
            z39 z39Var = this.k;
            if (z39Var != null) {
                z39Var.l(this);
            }
            j();
            f49Var.o(true);
        }
    }

    @Override // com.baidu.tieba.e49
    public void j() {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (editText = this.h) == null) {
            return;
        }
        editText.requestFocus();
    }

    @Override // com.baidu.tieba.d49
    public void k(@NonNull WriteData writeData) {
        WriteData writeData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, writeData) == null) {
            WriteData writeData3 = this.e;
            if (writeData3 != null && dj.isEmpty(writeData3.getTitle())) {
                this.e.setTitle(writeData.getTitle());
            }
            if (this.h == null || (writeData2 = this.e) == null || TextUtils.isEmpty(writeData2.getTitle())) {
                return;
            }
            SpannableString i = ug5.i(this.e.getTitle());
            this.h.setText(i);
            this.h.setSelection(Math.min(Math.min(this.e.getTitle().length(), i.length()), this.h.getText().length()));
        }
    }

    @Override // com.baidu.tieba.e49
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.m.f(this.h, true);
            this.m.a(this.h);
        }
    }

    @Override // com.baidu.tieba.y39, com.baidu.tieba.d49
    public boolean n() {
        InterceptResult invokeV;
        EditText editText;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.e == null || (editText = this.h) == null || editText.getText() == null) {
                return true;
            }
            if (14 == this.e.getType() && this.h.getText().toString().length() > 31) {
                f49 f49Var = this.b;
                if (f49Var != null) {
                    f49Var.d(this.a.getString(R.string.obfuscated_res_0x7f0f0f90));
                }
                return false;
            } else if (TextUtils.isEmpty(this.h.getText().toString()) || this.h.getText().toString().trim().length() < 5) {
                if (this.b != null) {
                    if (14 == this.e.getType()) {
                        string = this.a.getString(R.string.obfuscated_res_0x7f0f0f94);
                    } else {
                        string = this.a.getString(R.string.obfuscated_res_0x7f0f1441);
                    }
                    this.b.d(string);
                }
                return false;
            } else {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.e49
    public EditText o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.h : (EditText) invokeV.objValue;
    }

    @Override // com.baidu.tieba.y39, com.baidu.tieba.d49
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048590, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1) {
                if (i == 25004 && "from_title".equals(this.l.a())) {
                    J(this.l.d(intent));
                }
            } else if (i2 == 0 && i == 25004 && "from_title".equals(this.l.a())) {
                j();
            }
        }
    }

    @Override // com.baidu.tieba.d49
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            EditText editText = this.h;
            if (editText != null) {
                SkinManager.setBackgroundColor(editText, R.color.CAM_X0205);
                this.h.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
                SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0105);
                M(this.h.getEditableText());
            }
            uu4.d(this.j).f(R.color.CAM_X0210);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0110);
        }
    }

    @Override // com.baidu.tieba.d49
    public View q(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0514, viewGroup, false);
            this.g = inflate;
            this.h = (EditText) inflate.findViewById(R.id.obfuscated_res_0x7f091a59);
            this.i = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091b36);
            this.j = this.g.findViewById(R.id.obfuscated_res_0x7f092249);
            EditText editText = this.h;
            if (editText != null) {
                editText.addTextChangedListener(this.o);
                this.h.setOnFocusChangeListener(this.p);
                WriteData writeData = this.e;
                if (writeData != null) {
                    if (14 == writeData.getType()) {
                        this.h.setHint(this.a.getString(R.string.obfuscated_res_0x7f0f0f93));
                        this.h.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
                        this.h.setSingleLine(false);
                        TextView textView = this.i;
                        if (textView != null) {
                            textView.setVisibility(0);
                            this.i.post(new c(this));
                        }
                    } else {
                        this.h.setFilters(new InputFilter[]{new k29.b(this.h, 31, new d(this))});
                        if (13 == this.e.getType()) {
                            this.h.setHint(R.string.obfuscated_res_0x7f0f1440);
                        } else {
                            this.h.setHint(R.string.obfuscated_res_0x7f0f143f);
                        }
                    }
                    if (this.e.getTitle() != null) {
                        this.h.setText(this.e.getTitle());
                        this.h.setSelection(this.e.getTitle().length());
                    }
                }
            }
            return this.g;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.tieba.y39, com.baidu.tieba.d49
    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            EditText editText = this.h;
            return (editText == null || editText.getText() == null || this.h.getText().length() <= 0) ? false : true;
        }
        return invokeV.booleanValue;
    }
}
