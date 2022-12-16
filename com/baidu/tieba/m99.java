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
import com.baidu.tieba.wr8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class m99 extends k99<na9> implements ea9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public SpanGroupEditText t;
    @Nullable
    public TextView u;
    @Nullable
    public TextView v;

    @Override // com.baidu.tieba.ia9
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m99 a;

        public a(m99 m99Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m99Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m99Var;
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
    public m99(TbPageContext<?> tbPageContext, @NonNull w89 w89Var, @NonNull ob9 ob9Var) {
        super(tbPageContext, na9.class, w89Var, ob9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, w89Var, ob9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (Class) objArr2[1], (w89) objArr2[2], (ob9) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.k99, com.baidu.tieba.ca9, com.baidu.tieba.ha9
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

    @Override // com.baidu.tieba.k99
    public void K(ArrayList<AtSelectData> arrayList) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) && (spanGroupEditText = this.t) != null && spanGroupEditText.getVisibility() == 0) {
            this.t.b(arrayList);
        }
    }

    @Override // com.baidu.tieba.k99
    public void L(ArrayList<AtSelectData> arrayList) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) && (spanGroupEditText = this.t) != null && spanGroupEditText.getVisibility() == 0) {
            this.t.e(arrayList);
        }
    }

    public void T(da9 da9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, da9Var) == null) {
            this.k = da9Var;
        }
    }

    public void Z(wr8.f fVar) {
        lb9 lb9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) && (lb9Var = this.l) != null) {
            lb9Var.p(fVar);
        }
    }

    @Override // com.baidu.tieba.ia9
    public void b(boolean z) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && !z && (spanGroupEditText = this.t) != null) {
            if (spanGroupEditText.getTag(R.id.obfuscated_res_0x7f0910d0) != null) {
                this.t.setTag(R.id.obfuscated_res_0x7f0910d0, null);
            } else {
                this.t.clearFocus();
            }
        }
    }

    @Override // com.baidu.tieba.ha9
    public void e(@NonNull WriteData writeData) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, writeData) == null) && (spanGroupEditText = this.t) != null && spanGroupEditText.getText() != null) {
            writeData.setContent(this.t.getText().toString());
        }
    }

    @Override // com.baidu.tieba.k99, com.baidu.tieba.ca9, com.baidu.tieba.ha9
    public void j(@NonNull ja9 ja9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, ja9Var) == null) {
            super.j(ja9Var);
            da9 da9Var = this.k;
            if (da9Var != null) {
                da9Var.l(this);
            }
        }
    }

    @Override // com.baidu.tieba.k99
    public void H(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            super.H(editable);
            WriteData writeData = this.e;
            if (writeData != null && editable != null) {
                if (12 == writeData.getType()) {
                    U(editable);
                    ja9 ja9Var = this.b;
                    if (ja9Var != null) {
                        ja9Var.i();
                    }
                } else if (14 == this.e.getType()) {
                    Y(editable);
                }
            }
        }
    }

    public final void U(Editable editable) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, editable) != null) || this.v == null) {
            return;
        }
        if (editable.length() > 500) {
            this.v.setText((500 - editable.length()) + "/500");
            this.v.setVisibility(0);
            return;
        }
        this.v.setVisibility(8);
    }

    @Override // com.baidu.tieba.ha9
    public void c(WriteData writeData) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, writeData) == null) && (spanGroupEditText = this.t) != null && spanGroupEditText.getText() != null) {
            writeData.setContent(this.t.getText().toString().replaceAll("\u0000\n", "").replaceAll("\u0000", ""));
        }
    }

    @Override // com.baidu.tieba.k99, com.baidu.tieba.ha9
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
                Y(this.u.getEditableText());
            }
            SkinManager.setViewTextColor(this.v, (int) R.color.CAM_X0301);
        }
    }

    @Override // com.baidu.tieba.k99
    @Nullable
    public ArrayList<AtSelectData> N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.t;
            if (spanGroupEditText != null && spanGroupEditText.getVisibility() == 0) {
                return this.t.getAtDataInText();
            }
            return null;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k99
    @Nullable
    public EditText O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.t;
            if (spanGroupEditText != null && spanGroupEditText.getVisibility() == 0) {
                return this.t;
            }
            return null;
        }
        return (EditText) invokeV.objValue;
    }

    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.t;
            if (spanGroupEditText != null && spanGroupEditText.getVisibility() == 0 && this.t.getSpanGroupManager() != null) {
                return this.t.getSpanGroupManager().w();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.t;
            if (spanGroupEditText != null && spanGroupEditText.h()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ia9
    public void l() {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (spanGroupEditText = this.t) != null) {
            spanGroupEditText.requestFocus();
        }
    }

    @Override // com.baidu.tieba.ia9
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.n.f(this.t, false);
            this.n.a(this.t);
        }
    }

    @Override // com.baidu.tieba.ia9
    public EditText p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.t;
        }
        return (EditText) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ca9, com.baidu.tieba.ha9
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.t;
            if (spanGroupEditText != null && spanGroupEditText.getText() != null && this.t.getText().length() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public LinkedList<j05> W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.t;
            if (spanGroupEditText != null && spanGroupEditText.getVisibility() == 0 && this.t.getSpanGroupManager() != null) {
                return this.t.getSpanGroupManager().C();
            }
            return null;
        }
        return (LinkedList) invokeV.objValue;
    }

    public final void Y(Editable editable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, editable) == null) && this.u != null && this.a.getPageActivity() != null) {
            if (!TextUtils.isEmpty(editable)) {
                SpannableString spannableString = new SpannableString(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f095b, new Object[]{Integer.valueOf(editable.length()), 500}));
                if (editable.length() > 500) {
                    spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)), 0, String.valueOf(editable.length()).length(), 17);
                }
                this.u.setText(spannableString);
                return;
            }
            this.u.setText(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f095b, new Object[]{0, 500}));
        }
    }

    @Override // com.baidu.tieba.ha9
    public void a(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, writeData) != null) || TextUtils.isEmpty(writeData.getContent()) || this.t == null) {
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
            this.t.getSpanGroupManager().q();
            this.t.c();
            ja9 ja9Var = this.b;
            if (ja9Var != null) {
                ja9Var.e(-1, true);
            }
        }
        this.t.setFilters(filters);
        if (this.t.getText() != null) {
            SpanGroupEditText spanGroupEditText = this.t;
            spanGroupEditText.setSelection(spanGroupEditText.getText().length());
        }
    }

    @Override // com.baidu.tieba.ca9, com.baidu.tieba.ha9
    public void h(@Nullable String str, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048593, this, str, writeData) != null) || StringUtils.isNull(str)) {
            return;
        }
        try {
            writeData.setContent(new JSONObject(str).optString("c"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.ca9, com.baidu.tieba.ha9
    public boolean o() {
        InterceptResult invokeV;
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.e == null || (spanGroupEditText = this.t) == null || spanGroupEditText.getText() == null) {
                return true;
            }
            if (14 == this.e.getType() && this.t.getText().toString().length() > 500) {
                ja9 ja9Var = this.b;
                if (ja9Var != null) {
                    ja9Var.d(this.a.getString(R.string.obfuscated_res_0x7f0f0ff8));
                }
                return false;
            } else if (this.t.getText().toString().length() > 1000) {
                TbPageContext<?> tbPageContext = this.a;
                tbPageContext.showToast(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0f57));
                return false;
            } else if (!this.t.getText().toString().contains("ܷ") && !this.t.getText().toString().contains("ܶ")) {
                return true;
            } else {
                TbPageContext<?> tbPageContext2 = this.a;
                tbPageContext2.showToast(tbPageContext2.getString(R.string.post_char_no_support));
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ea9
    public void onUpdate(Object obj) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, obj) == null) {
            if (obj instanceof SelectForumData) {
                SpanGroupEditText spanGroupEditText2 = this.t;
                if (spanGroupEditText2 != null) {
                    spanGroupEditText2.setForumId(xg.g(((SelectForumData) obj).forumId, 0L));
                }
            } else if (!(obj instanceof ma9) || (spanGroupEditText = this.t) == null) {
            } else {
                ma9 ma9Var = (ma9) obj;
                int i = ma9Var.a;
                if (i == 1) {
                    if (!ListUtils.isEmpty(ma9Var.b) && !ListUtils.isEmpty(ma9Var.c)) {
                        this.t.g(ma9Var.b, ma9Var.c);
                    }
                } else if (i == 2) {
                    spanGroupEditText.f(ma9Var.d);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ha9
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d04b3, viewGroup, false);
            this.c = inflate;
            this.g = inflate.findViewById(R.id.obfuscated_res_0x7f091af3);
            this.h = (TbAlphaVideo) this.c.findViewById(R.id.obfuscated_res_0x7f090156);
            this.t = (SpanGroupEditText) this.c.findViewById(R.id.obfuscated_res_0x7f091af2);
            this.u = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091be8);
            this.v = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091af5);
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
                    this.t.setForumId(xg.g(writeData.getForumId(), 0L));
                    this.e.setSpanGroupManager(this.t.getSpanGroupManager());
                    if (!TextUtils.isEmpty(this.e.getContent())) {
                        this.t.setText(TbFaceManager.i().r(this.a.getPageActivity(), this.e.getContent()));
                        if (this.t.getText() != null) {
                            SpanGroupEditText spanGroupEditText2 = this.t;
                            spanGroupEditText2.setSelection(spanGroupEditText2.getText().length());
                        }
                    }
                    if (12 == this.e.getType()) {
                        SpannableString spannableString = new SpannableString(" " + this.a.getString(R.string.write_evalute_hint));
                        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a11, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL);
                        if (pureDrawable != null && this.a.getPageActivity() != null) {
                            pureDrawable.setBounds(0, 0, pureDrawable.getIntrinsicWidth(), pureDrawable.getIntrinsicHeight());
                            spannableString.setSpan(new pf6(pureDrawable, 1, yi.g(this.a.getPageActivity(), R.dimen.tbds4)), 0, 1, 17);
                        }
                        this.t.setHint(spannableString);
                    } else if (14 == this.e.getType()) {
                        this.t.setHint(this.a.getString(R.string.obfuscated_res_0x7f0f0ff7));
                        TextView textView = this.u;
                        if (textView != null) {
                            textView.setVisibility(0);
                            this.u.post(new a(this));
                        }
                    } else {
                        this.t.setHint(R.string.main_body);
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
}
