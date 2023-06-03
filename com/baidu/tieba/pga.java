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
import com.baidu.tieba.db5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes7.dex */
public abstract class pga<D> extends hha<D> implements nha {
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
    public iha k;
    @Nullable
    public qia l;
    @NonNull
    public tia m;
    @NonNull
    public bga n;
    public final View.OnClickListener o;
    public final db5.a p;
    public final TbFaceManager.a q;
    public final TextWatcher r;
    public final View.OnFocusChangeListener s;

    public void H(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editable) == null) {
        }
    }

    public void I(CharSequence charSequence, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
        }
    }

    public void J(ad5 ad5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ad5Var) == null) {
        }
    }

    public abstract void K(ArrayList<AtSelectData> arrayList);

    public abstract void L(ArrayList<AtSelectData> arrayList);

    @Nullable
    public abstract ArrayList<AtSelectData> N();

    @Nullable
    public abstract EditText O();

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pga a;

        public a(pga pgaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pgaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pgaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int M;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.b != null) {
                    this.a.b.D(new sh5(5, -1, null));
                }
                if (this.a.O() != null && this.a.O().getText() != null && (M = this.a.M()) >= 0 && M < this.a.O().getText().length()) {
                    this.a.O().setSelection(M);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements db5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pga a;

        public b(pga pgaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pgaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pgaVar;
        }

        @Override // com.baidu.tieba.db5.a
        public void d(int i, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && this.a.b != null) {
                this.a.b.d(i, z);
                this.a.b.w();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements TbFaceManager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(pga pgaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pgaVar};
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
            gn gnVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), gn.class);
                if (runTask != null) {
                    gnVar = (gn) runTask.getData();
                } else {
                    gnVar = null;
                }
                if (gnVar == null) {
                    return null;
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(gnVar.p());
                int r = gnVar.r();
                if (str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                    bitmapDrawable.setBounds(0, 0, r, gnVar.m());
                } else {
                    bitmapDrawable.setBounds(0, 0, r, r);
                }
                bitmapDrawable.setGravity(119);
                return new s95(bitmapDrawable, 0);
            }
            return (ImageSpan) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public final /* synthetic */ pga c;

        public d(pga pgaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pgaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pgaVar;
            this.a = "";
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                EditText O = this.c.O();
                if (editable != null && O != null && O.getText() != null) {
                    int selectionEnd = O.getSelectionEnd();
                    String str = this.a;
                    if (str != null && str.equals(editable.toString())) {
                        O.setSelection(selectionEnd);
                        return;
                    }
                    this.a = O.getText().toString();
                    this.c.n.i(O, false);
                    this.c.H(editable);
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
                this.c.I(charSequence, i, i2, i3);
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
                    pga pgaVar = this.c;
                    pgaVar.m.e(pgaVar.N());
                    this.c.m.b(charSequence, i, i3);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pga a;

        public e(pga pgaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pgaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pgaVar;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            pga pgaVar;
            iha ihaVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) && (ihaVar = (pgaVar = this.a).k) != null) {
                ihaVar.q(pgaVar, z);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pga(TbPageContext<?> tbPageContext, Class<D> cls, @NonNull bga bgaVar, @NonNull tia tiaVar) {
        super(tbPageContext, cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cls, bgaVar, tiaVar};
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
        this.n = bgaVar;
        this.m = tiaVar;
    }

    @Override // com.baidu.tieba.mha
    public void onChangeSkinType(int i) {
        qia qiaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i) == null) && (qiaVar = this.l) != null) {
            qiaVar.m();
        }
    }

    @Override // com.baidu.tieba.hha, com.baidu.tieba.mha
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
        }
    }

    public final void G(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !StringUtils.isNull(str) && O() != null) {
            this.m.f("");
            O().requestFocus();
            if (O().getText() != null && O().getText().length() + str.length() > 5000) {
                this.a.showToast((int) R.string.over_limit_tip);
                return;
            }
            int selectionStart = O().getSelectionStart();
            Editable text = O().getText();
            if (text != null && selectionStart >= 0 && selectionStart <= text.length()) {
                text.insert(selectionStart, str);
            }
        }
    }

    public final void P(ad5 ad5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, ad5Var) == null) && this.a.getPageActivity() != null && O() != null && O().getText() != null) {
            if (((ImageSpan[]) O().getText().getSpans(0, O().getText().length(), ImageSpan.class)).length >= 10) {
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
            j17.c(this.a.getPageActivity(), ad5Var, O());
        }
    }

    public int M() {
        InterceptResult invokeV;
        ImageSpan[] imageSpanArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (O() == null) {
                return -1;
            }
            int selectionEnd = O().getSelectionEnd();
            for (ImageSpan imageSpan : (ImageSpan[]) O().getText().getSpans(0, O().getText().length(), ImageSpan.class)) {
                int spanStart = O().getText().getSpanStart(imageSpan);
                int spanEnd = O().getText().getSpanEnd(imageSpan);
                if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                    return spanEnd;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (O() == null || O().getText() == null || O().getText().length() < 5000) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.hha, com.baidu.tieba.mha
    public void j(@NonNull oha ohaVar) {
        int type;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, ohaVar) == null) {
            super.j(ohaVar);
            WriteData writeData = this.e;
            if (writeData == null) {
                type = -1;
            } else {
                type = writeData.getType();
            }
            this.l = new qia(this.a, this, this.g, this.h, type);
            WriteData writeData2 = this.e;
            if (writeData2 != null && ListUtils.isNotEmpty(writeData2.getInputInsertAtList())) {
                K(new ArrayList<>(this.e.getInputInsertAtList()));
                this.e.setInputInsertAtList(new ArrayList<>());
            }
        }
    }

    @Override // com.baidu.tieba.hha, com.baidu.tieba.mha
    public void m(Bundle bundle, Intent intent, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, bundle, intent, writeData) == null) {
            super.m(bundle, intent, writeData);
            this.m.h(writeData);
        }
    }

    @Override // com.baidu.tieba.hha, com.baidu.tieba.mha
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1) {
                if (i == 12004) {
                    if (O() == null) {
                        return;
                    }
                    O().requestFocus();
                    oha ohaVar = this.b;
                    if (ohaVar != null) {
                        ohaVar.B();
                    }
                    ArrayList<AtSelectData> arrayList = null;
                    if (intent != null) {
                        arrayList = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA);
                    }
                    this.m.e(arrayList);
                    int selectionStart = O().getSelectionStart();
                    if (selectionStart > 0) {
                        int i3 = selectionStart - 1;
                        if (O().getText().toString().charAt(i3) == '@') {
                            O().getEditableText().delete(i3, selectionStart);
                        }
                    }
                    L(arrayList);
                    if (ListUtils.isEmpty(arrayList)) {
                        return;
                    }
                    O().getText().delete(O().getSelectionStart(), O().getSelectionEnd());
                    K(arrayList);
                } else if (i == 25004 && "from_content".equals(this.m.a())) {
                    G(this.m.d(intent));
                }
            } else if (i2 == 0 && i == 25004 && "from_content".equals(this.m.a())) {
                l();
            }
        }
    }

    @Override // com.baidu.tieba.hha, com.baidu.tieba.mha
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
        }
    }

    @Override // com.baidu.tieba.hha, com.baidu.tieba.mha
    public void r(sh5 sh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, sh5Var) == null) {
            super.r(sh5Var);
            int i = sh5Var.a;
            if (i == 3) {
                if (O() != null && O().getText() != null && O().getSelectionStart() > 0) {
                    String substring = O().getText().toString().substring(0, O().getSelectionStart());
                    Matcher matcher = i17.b.matcher(substring);
                    if (matcher.find()) {
                        O().getText().delete(O().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), O().getSelectionStart());
                        return;
                    }
                    O().onKeyDown(67, this.j);
                }
            } else if (i == 16) {
                if (Q()) {
                    this.a.showToast((int) R.string.over_limit_tip);
                    return;
                }
                ArrayList<AtSelectData> N = N();
                oha ohaVar = this.b;
                if (ohaVar != null) {
                    ohaVar.n(N);
                }
            } else if (i == 24) {
                Object obj = sh5Var.c;
                if (!(obj instanceof ad5)) {
                    return;
                }
                ad5 ad5Var = (ad5) obj;
                if (EmotionGroupType.isSendAsPic(ad5Var.getType())) {
                    J(ad5Var);
                    oha ohaVar2 = this.b;
                    if (ohaVar2 != null) {
                        ohaVar2.e();
                    }
                } else if (Q()) {
                    this.a.showToast((int) R.string.over_limit_tip);
                } else {
                    P(ad5Var);
                }
            } else if (i == 25) {
                qia qiaVar = this.l;
                if (qiaVar != null) {
                    qiaVar.n(sh5Var);
                }
            } else if (i == 74 && O() != null) {
                O().setTag(R.id.obfuscated_res_0x7f09120a, Boolean.TRUE);
            }
        }
    }
}
