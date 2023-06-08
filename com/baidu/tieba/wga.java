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
import com.baidu.adp.log.DefaultLog;
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
import com.baidu.tieba.hz4;
import com.baidu.tieba.ux9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class wga extends uga<xha> implements oha {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public SpanGroupEditText t;
    @Nullable
    public TextView u;
    @Nullable
    public TextView v;
    public hz4.c w;

    @Override // com.baidu.tieba.sha
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wga a;

        public a(wga wgaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wgaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wgaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.t.setPadding(this.a.t.getPaddingLeft(), this.a.t.getPaddingTop(), this.a.t.getPaddingRight(), this.a.t.getPaddingBottom() + this.a.u.getHeight());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements hz4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wga a;

        @Override // com.baidu.tieba.hz4.c
        public String getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "setPostContent" : (String) invokeV.objValue;
        }

        public b(wga wgaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wgaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wgaVar;
        }

        @Override // com.baidu.tieba.hz4.c
        public void a(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                zq8 defaultLog = DefaultLog.getInstance();
                defaultLog.c("write", "收到H5通知，更新发帖内容：" + str);
                try {
                    str = new JSONObject(str).optString("data", str);
                } catch (Exception e) {
                    zq8 defaultLog2 = DefaultLog.getInstance();
                    defaultLog2.c("write", "更新发帖内容失败" + e);
                }
                if (!TextUtils.isEmpty(str)) {
                    this.a.t.setText(TbFaceManager.i().r(this.a.a.getPageActivity(), str));
                    if (this.a.t.getText() != null) {
                        this.a.t.setSelection(this.a.t.getText().length());
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wga(TbPageContext<?> tbPageContext, @NonNull gga ggaVar, @NonNull yia yiaVar) {
        super(tbPageContext, xha.class, ggaVar, yiaVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, ggaVar, yiaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (Class) objArr2[1], (gga) objArr2[2], (yia) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = new b(this);
    }

    @Override // com.baidu.tieba.uga, com.baidu.tieba.mha, com.baidu.tieba.rha
    public void onActivityResult(int i, int i2, Intent intent) {
        Editable text;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048600, this, i, i2, intent) == null) {
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

    @Override // com.baidu.tieba.uga
    public void K(ArrayList<AtSelectData> arrayList) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) && (spanGroupEditText = this.t) != null && spanGroupEditText.getVisibility() == 0) {
            this.t.b(arrayList);
        }
    }

    @Override // com.baidu.tieba.uga
    public void L(ArrayList<AtSelectData> arrayList) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) && (spanGroupEditText = this.t) != null && spanGroupEditText.getVisibility() == 0) {
            this.t.e(arrayList);
        }
    }

    public void U(nha nhaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, nhaVar) == null) {
            this.k = nhaVar;
        }
    }

    @Override // com.baidu.tieba.sha
    public void b(boolean z) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && !z && (spanGroupEditText = this.t) != null) {
            if (spanGroupEditText.getTag(R.id.obfuscated_res_0x7f09120a) != null) {
                this.t.setTag(R.id.obfuscated_res_0x7f09120a, null);
            } else {
                this.t.clearFocus();
            }
        }
    }

    public void b0(ux9.f fVar) {
        via viaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, fVar) == null) && (viaVar = this.l) != null) {
            viaVar.p(fVar);
        }
    }

    @Override // com.baidu.tieba.rha
    public void e(@NonNull WriteData writeData) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, writeData) == null) && (spanGroupEditText = this.t) != null && spanGroupEditText.getText() != null) {
            writeData.setContent(this.t.getText().toString());
        }
    }

    @Override // com.baidu.tieba.uga, com.baidu.tieba.mha, com.baidu.tieba.rha
    public void j(@NonNull tha thaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, thaVar) == null) {
            super.j(thaVar);
            nha nhaVar = this.k;
            if (nhaVar != null) {
                nhaVar.l(this);
            }
            hz4.a().c(this.w);
        }
    }

    @Override // com.baidu.tieba.uga, com.baidu.tieba.mha, com.baidu.tieba.rha
    public void r(uh5 uh5Var) {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, uh5Var) == null) {
            super.r(uh5Var);
            if (uh5Var.a == 77 && (writeData = this.e) != null) {
                writeData.onPostDataParse(x().a());
            }
        }
    }

    @Override // com.baidu.tieba.uga
    public void H(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            super.H(editable);
            WriteData writeData = this.e;
            if (writeData != null && editable != null) {
                if (12 == writeData.getType()) {
                    V(editable);
                    tha thaVar = this.b;
                    if (thaVar != null) {
                        thaVar.i();
                    }
                } else if (14 == this.e.getType()) {
                    a0(editable);
                }
            }
        }
    }

    public final void V(Editable editable) {
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

    @Override // com.baidu.tieba.rha
    public void c(WriteData writeData) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, writeData) == null) && (spanGroupEditText = this.t) != null && spanGroupEditText.getText() != null) {
            writeData.setContent(this.t.getText().toString().replaceAll("\u0000\n", "").replaceAll("\u0000", ""));
        }
    }

    @Override // com.baidu.tieba.uga, com.baidu.tieba.rha
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            super.onChangeSkinType(i);
            SpanGroupEditText spanGroupEditText = this.t;
            if (spanGroupEditText != null) {
                spanGroupEditText.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
                SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0105);
            }
            TextView textView = this.u;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0110);
                a0(this.u.getEditableText());
            }
            SkinManager.setViewTextColor(this.v, (int) R.color.CAM_X0301);
            Z();
        }
    }

    @Override // com.baidu.tieba.uga
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

    @Override // com.baidu.tieba.uga
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

    public int W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.t;
            if (spanGroupEditText != null && spanGroupEditText.getVisibility() == 0 && this.t.getSpanGroupManager() != null) {
                return this.t.getSpanGroupManager().z();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean Y() {
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

    @Override // com.baidu.tieba.mha, com.baidu.tieba.rha
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.d();
            SpanGroupEditText spanGroupEditText = this.t;
            if (spanGroupEditText != null) {
                spanGroupEditText.i();
                this.t.removeTextChangedListener(this.r);
            }
            hz4.a().d(this.w);
        }
    }

    @Override // com.baidu.tieba.sha
    public void l() {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (spanGroupEditText = this.t) != null) {
            spanGroupEditText.requestFocus();
        }
    }

    @Override // com.baidu.tieba.sha
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.n.f(this.t, false);
            this.n.a(this.t);
        }
    }

    @Override // com.baidu.tieba.sha
    public EditText p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.t;
        }
        return (EditText) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mha, com.baidu.tieba.rha
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.t;
            if (spanGroupEditText != null && spanGroupEditText.getText() != null && this.t.getText().length() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public LinkedList<fb5> X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.t;
            if (spanGroupEditText != null && spanGroupEditText.getVisibility() == 0 && this.t.getSpanGroupManager() != null) {
                return this.t.getSpanGroupManager().F();
            }
            return null;
        }
        return (LinkedList) invokeV.objValue;
    }

    public final void Z() {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (spanGroupEditText = this.t) != null && spanGroupEditText.getSpanGroupManager() != null) {
            List<jb5> x = this.t.getSpanGroupManager().x();
            if (ListUtils.isEmpty(x)) {
                return;
            }
            for (jb5 jb5Var : x) {
                jb5Var.t();
            }
        }
    }

    @Override // com.baidu.tieba.rha
    public void a(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, writeData) != null) || TextUtils.isEmpty(writeData.getContent()) || this.t == null) {
            return;
        }
        WriteData writeData2 = this.e;
        if (writeData2 != null) {
            writeData2.setContent(writeData.getContent());
        }
        SpannableString u = TbFaceManager.i().u(this.a.getPageActivity(), writeData.getContent());
        InputFilter[] filters = this.t.getFilters();
        this.t.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50000)});
        this.t.setText(u);
        if (this.t.getSpanGroupManager() != null) {
            this.t.i();
            this.t.getSpanGroupManager().t();
            this.t.c();
            tha thaVar = this.b;
            if (thaVar != null) {
                thaVar.d(-1, true);
            }
        }
        this.t.setFilters(filters);
        if (this.t.getText() != null) {
            SpanGroupEditText spanGroupEditText = this.t;
            spanGroupEditText.setSelection(spanGroupEditText.getText().length());
        }
    }

    public final void a0(Editable editable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, editable) == null) && this.u != null && this.a.getPageActivity() != null) {
            if (!TextUtils.isEmpty(editable)) {
                SpannableString spannableString = new SpannableString(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0a7a, new Object[]{Integer.valueOf(editable.length()), 500}));
                if (editable.length() > 500) {
                    spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)), 0, String.valueOf(editable.length()).length(), 17);
                }
                this.u.setText(spannableString);
                return;
            }
            this.u.setText(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0a7a, new Object[]{0, 500}));
        }
    }

    @Override // com.baidu.tieba.mha, com.baidu.tieba.rha
    public void h(@Nullable String str, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048595, this, str, writeData) != null) || StringUtils.isNull(str)) {
            return;
        }
        try {
            writeData.setContent(new JSONObject(str).optString("c"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.mha, com.baidu.tieba.rha
    public boolean o() {
        InterceptResult invokeV;
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.e == null || (spanGroupEditText = this.t) == null || spanGroupEditText.getText() == null) {
                return true;
            }
            if (14 == this.e.getType() && this.t.getText().toString().length() > 500) {
                tha thaVar = this.b;
                if (thaVar != null) {
                    thaVar.c(this.a.getString(R.string.obfuscated_res_0x7f0f1178));
                }
                return false;
            } else if (this.t.getText().toString().length() > 2000) {
                TbPageContext<?> tbPageContext = this.a;
                tbPageContext.showToast(tbPageContext.getString(R.string.obfuscated_res_0x7f0f10d2));
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

    @Override // com.baidu.tieba.oha
    public void onUpdate(Object obj) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, obj) == null) {
            if (obj instanceof SelectForumData) {
                SpanGroupEditText spanGroupEditText2 = this.t;
                if (spanGroupEditText2 != null) {
                    spanGroupEditText2.setForumId(tg.g(((SelectForumData) obj).forumId, 0L));
                }
            } else if (!(obj instanceof wha) || (spanGroupEditText = this.t) == null) {
            } else {
                wha whaVar = (wha) obj;
                int i = whaVar.a;
                if (i == 1) {
                    if (!ListUtils.isEmpty(whaVar.b) && !ListUtils.isEmpty(whaVar.c)) {
                        this.t.g(whaVar.b, whaVar.c);
                    }
                } else if (i == 2) {
                    spanGroupEditText.f(whaVar.d);
                }
            }
        }
    }

    @Override // com.baidu.tieba.rha
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0502, viewGroup, false);
            this.c = inflate;
            this.g = inflate.findViewById(R.id.obfuscated_res_0x7f091c58);
            this.h = (TbAlphaVideo) this.c.findViewById(R.id.obfuscated_res_0x7f09015b);
            this.t = (SpanGroupEditText) this.c.findViewById(R.id.obfuscated_res_0x7f091c57);
            this.u = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091d52);
            this.v = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091c5a);
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
                    this.t.setForumId(tg.g(writeData.getForumId(), 0L));
                    ((xha) this.d).b(this.t.getSpanGroupManager());
                    if (!TextUtils.isEmpty(this.e.getContent())) {
                        this.t.setText(TbFaceManager.i().r(this.a.getPageActivity(), this.e.getContent()));
                        if (this.t.getText() != null) {
                            SpanGroupEditText spanGroupEditText2 = this.t;
                            spanGroupEditText2.setSelection(spanGroupEditText2.getText().length());
                        }
                    }
                    if (!TextUtils.isEmpty(this.e.getHintText())) {
                        this.t.setHint(this.e.getHintText());
                    } else if (12 == this.e.getType()) {
                        SpannableString spannableString = new SpannableString(" " + this.a.getString(R.string.write_evalute_hint));
                        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080ba3, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL);
                        if (pureDrawable != null && this.a.getPageActivity() != null) {
                            pureDrawable.setBounds(0, 0, pureDrawable.getIntrinsicWidth(), pureDrawable.getIntrinsicHeight());
                            spannableString.setSpan(new o17(pureDrawable, 1, vi.g(this.a.getPageActivity(), R.dimen.tbds4)), 0, 1, 17);
                        }
                        this.t.setHint(spannableString);
                    } else if (14 == this.e.getType()) {
                        this.t.setHint(this.a.getString(R.string.obfuscated_res_0x7f0f1177));
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
