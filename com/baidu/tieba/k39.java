package com.baidu.tieba;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextUtils;
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
import com.baidu.tbadk.afx.TbAlphaVideo;
import com.baidu.tbadk.core.atomData.AddLinkActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.gm8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class k39 extends i39<i49> implements a49 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public SpanGroupEditText t;
    @Nullable
    public TextView u;
    @Nullable
    public TextView v;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k39 a;

        public a(k39 k39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k39Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.t.setPadding(this.a.t.getPaddingLeft(), this.a.t.getPaddingTop(), this.a.t.getPaddingRight(), this.a.t.getPaddingBottom() + this.a.u.getHeight());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k39(TbPageContext<?> tbPageContext, @NonNull x29 x29Var, @NonNull e59 e59Var) {
        super(tbPageContext, i49.class, x29Var, e59Var);
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
                super((TbPageContext) objArr2[0], (Class) objArr2[1], (x29) objArr2[2], (e59) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.i39
    public void F(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            super.F(editable);
            WriteData writeData = this.e;
            if (writeData == null || editable == null) {
                return;
            }
            if (12 == writeData.getType()) {
                S(editable);
                f49 f49Var = this.b;
                if (f49Var != null) {
                    f49Var.h();
                }
            } else if (14 == this.e.getType()) {
                V(editable);
            }
        }
    }

    @Override // com.baidu.tieba.i39
    public void G(CharSequence charSequence, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            super.G(charSequence, i, i2, i3);
            SpanGroupEditText spanGroupEditText = this.t;
            if (spanGroupEditText == null) {
                return;
            }
            spanGroupEditText.f(i, i2, i3);
        }
    }

    @Override // com.baidu.tieba.i39
    public void I(ArrayList<AtSelectData> arrayList) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) && (spanGroupEditText = this.t) != null && spanGroupEditText.getVisibility() == 0) {
            this.t.b(arrayList);
        }
    }

    @Override // com.baidu.tieba.i39
    public void J(ArrayList<AtSelectData> arrayList) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) && (spanGroupEditText = this.t) != null && spanGroupEditText.getVisibility() == 0) {
            this.t.e(arrayList);
        }
    }

    @Override // com.baidu.tieba.i39
    @Nullable
    public ArrayList<AtSelectData> L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.t;
            if (spanGroupEditText == null || spanGroupEditText.getVisibility() != 0) {
                return null;
            }
            return this.t.getAtDataInText();
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i39
    @Nullable
    public EditText M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.t;
            if (spanGroupEditText == null || spanGroupEditText.getVisibility() != 0) {
                return null;
            }
            return this.t;
        }
        return (EditText) invokeV.objValue;
    }

    public void R(z39 z39Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, z39Var) == null) {
            this.k = z39Var;
        }
    }

    public final void S(Editable editable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, editable) == null) || this.v == null) {
            return;
        }
        if (editable.length() > 500) {
            this.v.setText((500 - editable.length()) + "/500");
            this.v.setVisibility(0);
            return;
        }
        this.v.setVisibility(8);
    }

    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.t;
            if (spanGroupEditText == null || spanGroupEditText.getVisibility() != 0 || this.t.getSpanGroupManager() == null) {
                return 0;
            }
            return this.t.getSpanGroupManager().z();
        }
        return invokeV.intValue;
    }

    public LinkedList<vy4> U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.t;
            if (spanGroupEditText == null || spanGroupEditText.getVisibility() != 0 || this.t.getSpanGroupManager() == null) {
                return null;
            }
            return this.t.getSpanGroupManager().F();
        }
        return (LinkedList) invokeV.objValue;
    }

    public final void V(Editable editable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, editable) == null) || this.u == null || this.a.getPageActivity() == null) {
            return;
        }
        if (!TextUtils.isEmpty(editable)) {
            SpannableString spannableString = new SpannableString(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f090d, new Object[]{Integer.valueOf(editable.length()), 500}));
            if (editable.length() > 500) {
                spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)), 0, String.valueOf(editable.length()).length(), 17);
            }
            this.u.setText(spannableString);
            return;
        }
        this.u.setText(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f090d, new Object[]{0, 500}));
    }

    public void W(gm8.f fVar) {
        b59 b59Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) || (b59Var = this.l) == null) {
            return;
        }
        b59Var.o(fVar);
    }

    @Override // com.baidu.tieba.e49
    public void a(boolean z) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || z || (spanGroupEditText = this.t) == null) {
            return;
        }
        spanGroupEditText.clearFocus();
    }

    @Override // com.baidu.tieba.d49
    public void b(WriteData writeData) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, writeData) == null) || (spanGroupEditText = this.t) == null || spanGroupEditText.getText() == null) {
            return;
        }
        writeData.setContent(this.t.getText().toString().replaceAll("\u0000\n", "").replaceAll("\u0000", ""));
    }

    @Override // com.baidu.tieba.d49
    public void d(@NonNull WriteData writeData) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, writeData) == null) || (spanGroupEditText = this.t) == null || spanGroupEditText.getText() == null) {
            return;
        }
        writeData.setContent(this.t.getText().toString());
    }

    @Override // com.baidu.tieba.e49
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.i39, com.baidu.tieba.y39, com.baidu.tieba.d49
    public void h(@NonNull f49 f49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, f49Var) == null) {
            super.h(f49Var);
            z39 z39Var = this.k;
            if (z39Var != null) {
                z39Var.l(this);
            }
        }
    }

    @Override // com.baidu.tieba.e49
    public void j() {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (spanGroupEditText = this.t) == null) {
            return;
        }
        spanGroupEditText.requestFocus();
    }

    @Override // com.baidu.tieba.d49
    public void k(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, writeData) == null) || TextUtils.isEmpty(writeData.getContent()) || this.t == null) {
            return;
        }
        WriteData writeData2 = this.e;
        if (writeData2 != null) {
            writeData2.setContent(writeData.getContent());
        }
        SpannableString t = TbFaceManager.i().t(this.a.getPageActivity(), writeData.getContent(), this.q);
        InputFilter[] filters = this.t.getFilters();
        this.t.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50000)});
        this.t.setText(t);
        if (this.t.getSpanGroupManager() != null) {
            this.t.i();
            this.t.getSpanGroupManager().t();
            this.t.c();
            f49 f49Var = this.b;
            if (f49Var != null) {
                f49Var.b(-1, true);
            }
        }
        this.t.setFilters(filters);
        if (this.t.getText() != null) {
            SpanGroupEditText spanGroupEditText = this.t;
            spanGroupEditText.setSelection(spanGroupEditText.getText().length());
        }
    }

    @Override // com.baidu.tieba.e49
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.n.f(this.t, false);
            this.n.a(this.t);
        }
    }

    @Override // com.baidu.tieba.y39, com.baidu.tieba.d49
    public boolean n() {
        InterceptResult invokeV;
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.e == null || (spanGroupEditText = this.t) == null || spanGroupEditText.getText() == null) {
                return true;
            }
            if (14 == this.e.getType() && this.t.getText().toString().length() > 31) {
                f49 f49Var = this.b;
                if (f49Var != null) {
                    f49Var.d(this.a.getString(R.string.obfuscated_res_0x7f0f0f90));
                }
                return false;
            } else if (this.t.getText().toString().length() > 1000) {
                TbPageContext<?> tbPageContext = this.a;
                tbPageContext.showToast(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0ef1));
                return false;
            } else if (this.t.getText().toString().contains("ܷ") || this.t.getText().toString().contains("ܶ")) {
                TbPageContext<?> tbPageContext2 = this.a;
                tbPageContext2.showToast(tbPageContext2.getString(R.string.obfuscated_res_0x7f0f0ef0));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.t : (EditText) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i39, com.baidu.tieba.y39, com.baidu.tieba.d49
    public void onActivityResult(int i, int i2, Intent intent) {
        Editable text;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048598, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 != -1 || i != 25049 || intent == null || this.t == null) {
                return;
            }
            String str = intent.getStringExtra(AddLinkActivityConfig.NEW_LINK_CONTENT) + " ";
            int selectionStart = this.t.getSelectionStart();
            int selectionEnd = this.t.getSelectionEnd();
            if (selectionStart < 0 || (text = this.t.getText()) == null) {
                return;
            }
            if (selectionEnd > selectionStart) {
                text.replace(selectionStart, selectionEnd, str);
            } else {
                text.insert(selectionStart, str);
            }
        }
    }

    @Override // com.baidu.tieba.i39, com.baidu.tieba.d49
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            super.onChangeSkinType(i);
            SpanGroupEditText spanGroupEditText = this.t;
            if (spanGroupEditText != null) {
                spanGroupEditText.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
                SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0105);
            }
            TextView textView = this.u;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0110);
                V(this.u.getEditableText());
            }
            SkinManager.setViewTextColor(this.v, (int) R.color.CAM_X0301);
        }
    }

    @Override // com.baidu.tieba.a49
    public void onUpdate(Object obj) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, obj) == null) {
            if (obj instanceof SelectForumData) {
                SpanGroupEditText spanGroupEditText2 = this.t;
                if (spanGroupEditText2 != null) {
                    spanGroupEditText2.setForumId(dh.g(((SelectForumData) obj).forumId, 0L));
                }
            } else if (!(obj instanceof h49) || (spanGroupEditText = this.t) == null) {
            } else {
                h49 h49Var = (h49) obj;
                int i = h49Var.a;
                if (i != 1) {
                    if (i == 2) {
                        spanGroupEditText.g(h49Var.d);
                    }
                } else if (ListUtils.isEmpty(h49Var.b) || ListUtils.isEmpty(h49Var.c)) {
                } else {
                    this.t.h(h49Var.b, h49Var.c);
                }
            }
        }
    }

    @Override // com.baidu.tieba.d49
    public View q(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0495, viewGroup, false);
            this.c = inflate;
            this.g = inflate.findViewById(R.id.obfuscated_res_0x7f091a3c);
            this.h = (TbAlphaVideo) this.c.findViewById(R.id.obfuscated_res_0x7f09014e);
            this.t = (SpanGroupEditText) this.c.findViewById(R.id.obfuscated_res_0x7f091a3b);
            this.u = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091b30);
            this.v = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091a3e);
            SpanGroupEditText spanGroupEditText = this.t;
            if (spanGroupEditText != null) {
                spanGroupEditText.setOnClickListener(this.o);
                this.t.setOnSpanGroupChangedListener(this.p);
                this.t.addTextChangedListener(this.r);
                this.t.setOnFocusChangeListener(this.s);
                this.t.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY);
                this.t.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                WriteData writeData = this.e;
                if (writeData != null) {
                    this.t.setForumId(dh.g(writeData.getForumId(), 0L));
                    this.e.setSpanGroupManager(this.t.getSpanGroupManager());
                    if (!TextUtils.isEmpty(this.e.getContent())) {
                        this.t.setText(TbFaceManager.i().r(this.a.getPageActivity(), this.e.getContent()));
                        if (this.t.getText() != null) {
                            SpanGroupEditText spanGroupEditText2 = this.t;
                            spanGroupEditText2.setSelection(spanGroupEditText2.getText().length());
                        }
                    }
                    if (12 == this.e.getType()) {
                        SpannableString spannableString = new SpannableString(" " + this.a.getString(R.string.obfuscated_res_0x7f0f15f0));
                        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809cb, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL);
                        if (pureDrawable != null && this.a.getPageActivity() != null) {
                            pureDrawable.setBounds(0, 0, pureDrawable.getIntrinsicWidth(), pureDrawable.getIntrinsicHeight());
                            spannableString.setSpan(new dc6(pureDrawable, 1, ej.f(this.a.getPageActivity(), R.dimen.tbds4)), 0, 1, 17);
                        }
                        this.t.setHint(spannableString);
                    } else if (14 == this.e.getType()) {
                        this.t.setHint(this.a.getString(R.string.obfuscated_res_0x7f0f0f8f));
                        TextView textView = this.u;
                        if (textView != null) {
                            textView.setVisibility(0);
                            this.u.post(new a(this));
                        }
                    } else {
                        this.t.setHint(R.string.obfuscated_res_0x7f0f0a97);
                    }
                    if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.e.getFrom())) {
                        String str = this.e.getMoreForumTitle() + " " + this.e.getMoreForumUrl();
                        if (!StringUtils.isNull(str)) {
                            this.t.setText(str);
                        }
                    }
                }
            }
            return this.c;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.tieba.y39, com.baidu.tieba.d49
    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.t;
            return (spanGroupEditText == null || spanGroupEditText.getText() == null || this.t.getText().length() <= 0) ? false : true;
        }
        return invokeV.booleanValue;
    }
}
