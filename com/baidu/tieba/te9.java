package com.baidu.tieba;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.afx.TbAlphaVideo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.u05;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes6.dex */
public abstract class te9<D> extends lf9<D> implements rf9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public View g;
    @Nullable
    public TbAlphaVideo h;
    @Nullable
    public Toast i;
    public final KeyEvent j;
    @Nullable
    public mf9 k;
    @Nullable
    public ug9 l;
    @NonNull
    public xg9 m;
    @NonNull
    public fe9 n;
    public final View.OnClickListener o;
    public final u05.a p;
    public final TbFaceManager.a q;
    public final TextWatcher r;
    public final View.OnFocusChangeListener s;

    public void L(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editable) == null) {
        }
    }

    public void M(CharSequence charSequence, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
        }
    }

    public void N(r25 r25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, r25Var) == null) {
        }
    }

    public abstract void O(ArrayList<AtSelectData> arrayList);

    public abstract void P(ArrayList<AtSelectData> arrayList);

    @Nullable
    public abstract ArrayList<AtSelectData> R();

    @Nullable
    public abstract EditText S();

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ te9 a;

        public a(te9 te9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {te9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = te9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int Q;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.b != null) {
                    this.a.b.D(new z65(5, -1, null));
                }
                if (this.a.S() != null && this.a.S().getText() != null && (Q = this.a.Q()) >= 0 && Q < this.a.S().getText().length()) {
                    this.a.S().setSelection(Q);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements u05.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ te9 a;

        public b(te9 te9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {te9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = te9Var;
        }

        @Override // com.baidu.tieba.u05.a
        public void e(int i, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && this.a.b != null) {
                this.a.b.e(i, z);
                this.a.b.w();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements TbFaceManager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(te9 te9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {te9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan a(String str) {
            InterceptResult invokeL;
            jn jnVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), jn.class);
                if (runTask != null) {
                    jnVar = (jn) runTask.getData();
                } else {
                    jnVar = null;
                }
                if (jnVar == null) {
                    return null;
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(jnVar.p());
                int r = jnVar.r();
                if (str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                    bitmapDrawable.setBounds(0, 0, r, jnVar.m());
                } else {
                    bitmapDrawable.setBounds(0, 0, r, r);
                }
                bitmapDrawable.setGravity(119);
                return new jz4(bitmapDrawable, 0);
            }
            return (ImageSpan) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public final /* synthetic */ te9 c;

        public d(te9 te9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {te9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = te9Var;
            this.a = "";
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                EditText S = this.c.S();
                if (editable != null && S != null && S.getText() != null) {
                    int selectionEnd = S.getSelectionEnd();
                    String str = this.a;
                    if (str != null && str.equals(editable.toString())) {
                        S.setSelection(selectionEnd);
                        return;
                    }
                    this.a = S.getText().toString();
                    this.c.n.i(S, false);
                    this.c.L(editable);
                    if (this.c.b != null) {
                        this.c.b.i();
                    }
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                if (charSequence != null) {
                    str = charSequence.toString();
                } else {
                    str = "";
                }
                this.b = str;
                this.c.M(charSequence, i, i2, i3);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                String str = this.b;
                int i5 = 0;
                if (str != null) {
                    i4 = str.length();
                } else {
                    i4 = 0;
                }
                if (charSequence != null) {
                    i5 = charSequence.toString().length();
                }
                if (i5 > i4) {
                    this.c.m.c(charSequence, i, i3, "from_content");
                    te9 te9Var = this.c;
                    te9Var.m.e(te9Var.R());
                    this.c.m.b(charSequence, i, i3);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ te9 a;

        public e(te9 te9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {te9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = te9Var;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (z && this.a.e != null && !ListUtils.isEmpty(this.a.e.getInputInsertAtList())) {
                    this.a.O(new ArrayList<>(this.a.e.getInputInsertAtList()));
                    this.a.e.setInputInsertAtList(new ArrayList<>());
                }
                te9 te9Var = this.a;
                mf9 mf9Var = te9Var.k;
                if (mf9Var != null) {
                    mf9Var.q(te9Var, z);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public te9(TbPageContext<?> tbPageContext, Class<D> cls, @NonNull fe9 fe9Var, @NonNull xg9 xg9Var) {
        super(tbPageContext, cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cls, fe9Var, xg9Var};
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
        this.j = new KeyEvent(0, 67);
        this.o = new a(this);
        this.p = new b(this);
        this.q = new c(this);
        this.r = new d(this);
        this.s = new e(this);
        this.n = fe9Var;
        this.m = xg9Var;
    }

    @Override // com.baidu.tieba.lf9, com.baidu.tieba.qf9
    public void j(@NonNull sf9 sf9Var) {
        int type;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, sf9Var) == null) {
            super.j(sf9Var);
            WriteData writeData = this.e;
            if (writeData == null) {
                type = -1;
            } else {
                type = writeData.getType();
            }
            this.l = new ug9(this.a, this, this.g, this.h, type);
        }
    }

    @Override // com.baidu.tieba.qf9
    public void onChangeSkinType(int i) {
        ug9 ug9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i) == null) && (ug9Var = this.l) != null) {
            ug9Var.m();
        }
    }

    @Override // com.baidu.tieba.lf9, com.baidu.tieba.qf9
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
        }
    }

    public final void K(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !StringUtils.isNull(str) && S() != null) {
            this.m.f("");
            S().requestFocus();
            if (S().getText() != null && S().getText().length() + str.length() > 5000) {
                this.a.showToast((int) R.string.over_limit_tip);
                return;
            }
            int selectionStart = S().getSelectionStart();
            Editable text = S().getText();
            if (text != null && selectionStart >= 0 && selectionStart <= text.length()) {
                text.insert(selectionStart, str);
            }
        }
    }

    public final void T(r25 r25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, r25Var) == null) && this.a.getPageActivity() != null && S() != null && S().getText() != null) {
            if (((ImageSpan[]) S().getText().getSpans(0, S().getText().length(), ImageSpan.class)).length >= 10) {
                if (this.i == null) {
                    this.i = Toast.makeText(this.a.getPageActivity(), (int) R.string.too_many_face, 0);
                }
                if (Build.VERSION.SDK_INT >= 28 && this.i.getView().isShown()) {
                    this.i.cancel();
                }
                GreyUtil.grey(this.i);
                this.i.show();
                return;
            }
            ui6.b(this.a.getPageActivity(), r25Var, S());
        }
    }

    public int Q() {
        InterceptResult invokeV;
        ImageSpan[] imageSpanArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (S() == null) {
                return -1;
            }
            int selectionEnd = S().getSelectionEnd();
            for (ImageSpan imageSpan : (ImageSpan[]) S().getText().getSpans(0, S().getText().length(), ImageSpan.class)) {
                int spanStart = S().getText().getSpanStart(imageSpan);
                int spanEnd = S().getText().getSpanEnd(imageSpan);
                if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                    return spanEnd;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (S() == null || S().getText() == null || S().getText().length() < 5000) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lf9, com.baidu.tieba.qf9
    public void m(Bundle bundle, Intent intent, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, bundle, intent, writeData) == null) {
            super.m(bundle, intent, writeData);
            this.m.h(writeData);
        }
    }

    @Override // com.baidu.tieba.lf9, com.baidu.tieba.qf9
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1) {
                if (i == 12004) {
                    if (S() == null) {
                        return;
                    }
                    S().requestFocus();
                    sf9 sf9Var = this.b;
                    if (sf9Var != null) {
                        sf9Var.C();
                    }
                    ArrayList<AtSelectData> arrayList = null;
                    if (intent != null) {
                        arrayList = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA);
                    }
                    this.m.e(arrayList);
                    int selectionStart = S().getSelectionStart();
                    if (selectionStart > 0) {
                        int i3 = selectionStart - 1;
                        if (S().getText().toString().charAt(i3) == '@') {
                            S().getEditableText().delete(i3, selectionStart);
                        }
                    }
                    P(arrayList);
                    if (ListUtils.isEmpty(arrayList)) {
                        return;
                    }
                    S().getText().delete(S().getSelectionStart(), S().getSelectionEnd());
                    O(arrayList);
                } else if (i == 25004 && "from_content".equals(this.m.a())) {
                    K(this.m.d(intent));
                }
            } else if (i2 == 0 && i == 25004 && "from_content".equals(this.m.a())) {
                l();
            }
        }
    }

    @Override // com.baidu.tieba.lf9, com.baidu.tieba.qf9
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
        }
    }

    @Override // com.baidu.tieba.lf9, com.baidu.tieba.qf9
    public void r(z65 z65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, z65Var) == null) {
            super.r(z65Var);
            int i = z65Var.a;
            if (i == 3) {
                if (S() != null && S().getText() != null && S().getSelectionStart() > 0) {
                    String substring = S().getText().toString().substring(0, S().getSelectionStart());
                    Matcher matcher = ti6.b.matcher(substring);
                    if (matcher.find()) {
                        S().getText().delete(S().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), S().getSelectionStart());
                        return;
                    }
                    S().onKeyDown(67, this.j);
                }
            } else if (i == 16) {
                if (U()) {
                    this.a.showToast((int) R.string.over_limit_tip);
                    return;
                }
                ArrayList<AtSelectData> R = R();
                sf9 sf9Var = this.b;
                if (sf9Var != null) {
                    sf9Var.n(R);
                }
            } else if (i == 24) {
                Object obj = z65Var.c;
                if (!(obj instanceof r25)) {
                    return;
                }
                r25 r25Var = (r25) obj;
                if (EmotionGroupType.isSendAsPic(r25Var.getType())) {
                    N(r25Var);
                    sf9 sf9Var2 = this.b;
                    if (sf9Var2 != null) {
                        sf9Var2.c();
                    }
                } else if (U()) {
                    this.a.showToast((int) R.string.over_limit_tip);
                } else {
                    T(r25Var);
                }
            } else if (i == 25) {
                ug9 ug9Var = this.l;
                if (ug9Var != null) {
                    ug9Var.n(z65Var);
                }
            } else if (i == 74 && S() != null) {
                S().setTag(R.id.obfuscated_res_0x7f0910db, Boolean.TRUE);
            }
        }
    }
}
