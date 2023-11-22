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
import com.baidu.adp.widget.ImageView.BdImage;
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
import com.baidu.tieba.o65;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes8.dex */
public abstract class rdb<D> extends jeb<D> implements peb {
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
    public keb k;
    @Nullable
    public sfb l;
    @NonNull
    public vfb m;
    @NonNull
    public ddb n;
    public final View.OnClickListener o;
    public final o65.a p;
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

    public void J(m85 m85Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, m85Var) == null) {
        }
    }

    public abstract void K(ArrayList<AtSelectData> arrayList);

    public abstract void L(ArrayList<AtSelectData> arrayList);

    @Nullable
    public abstract ArrayList<AtSelectData> N();

    @Nullable
    public abstract EditText O();

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rdb a;

        public a(rdb rdbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rdbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rdbVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int M;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.b != null) {
                    this.a.b.C(new yd5(5, -1, null));
                }
                if (this.a.O() != null && this.a.O().getText() != null && (M = this.a.M()) >= 0 && M < this.a.O().getText().length()) {
                    this.a.O().setSelection(M);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements o65.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rdb a;

        public b(rdb rdbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rdbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rdbVar;
        }

        @Override // com.baidu.tieba.o65.a
        public void f(int i, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && this.a.b != null) {
                this.a.b.f(i, z);
                this.a.b.w();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements TbFaceManager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(rdb rdbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rdbVar};
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
            BdImage bdImage;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), BdImage.class);
                if (runTask != null) {
                    bdImage = (BdImage) runTask.getData();
                } else {
                    bdImage = null;
                }
                if (bdImage == null) {
                    return null;
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bdImage.getRawBitmap());
                int width = bdImage.getWidth();
                if (str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                    bitmapDrawable.setBounds(0, 0, width, bdImage.getHeight());
                } else {
                    bitmapDrawable.setBounds(0, 0, width, width);
                }
                bitmapDrawable.setGravity(119);
                return new e55(bitmapDrawable, 0);
            }
            return (ImageSpan) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public final /* synthetic */ rdb c;

        public d(rdb rdbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rdbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rdbVar;
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
                        this.c.b.j();
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
                    rdb rdbVar = this.c;
                    rdbVar.m.e(rdbVar.N());
                    this.c.m.b(charSequence, i, i3);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rdb a;

        public e(rdb rdbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rdbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rdbVar;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            rdb rdbVar;
            keb kebVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) && (kebVar = (rdbVar = this.a).k) != null) {
                kebVar.q(rdbVar, z);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rdb(TbPageContext<?> tbPageContext, Class<D> cls, @NonNull ddb ddbVar, @NonNull vfb vfbVar) {
        super(tbPageContext, cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cls, ddbVar, vfbVar};
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
        this.n = ddbVar;
        this.m = vfbVar;
    }

    @Override // com.baidu.tieba.oeb
    public void onChangeSkinType(int i) {
        sfb sfbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i) == null) && (sfbVar = this.l) != null) {
            sfbVar.m();
        }
    }

    @Override // com.baidu.tieba.jeb, com.baidu.tieba.oeb
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

    public final void P(m85 m85Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, m85Var) == null) && this.a.getPageActivity() != null && O() != null && O().getText() != null) {
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
            m07.c(this.a.getPageActivity(), m85Var, O());
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

    @Override // com.baidu.tieba.jeb, com.baidu.tieba.oeb
    public void j(@NonNull qeb qebVar) {
        int type;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, qebVar) == null) {
            super.j(qebVar);
            WriteData writeData = this.e;
            if (writeData == null) {
                type = -1;
            } else {
                type = writeData.getType();
            }
            this.l = new sfb(this.a, this, this.g, this.h, type);
            WriteData writeData2 = this.e;
            if (writeData2 != null && ListUtils.isNotEmpty(writeData2.getInputInsertAtList())) {
                K(new ArrayList<>(this.e.getInputInsertAtList()));
                this.e.setInputInsertAtList(new ArrayList<>());
            }
        }
    }

    @Override // com.baidu.tieba.jeb, com.baidu.tieba.oeb
    public void m(Bundle bundle, Intent intent, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, bundle, intent, writeData) == null) {
            super.m(bundle, intent, writeData);
            this.m.h(writeData);
        }
    }

    @Override // com.baidu.tieba.jeb, com.baidu.tieba.oeb
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
                    qeb qebVar = this.b;
                    if (qebVar != null) {
                        qebVar.B();
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

    @Override // com.baidu.tieba.jeb, com.baidu.tieba.oeb
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
        }
    }

    @Override // com.baidu.tieba.jeb, com.baidu.tieba.oeb
    public void r(yd5 yd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, yd5Var) == null) {
            super.r(yd5Var);
            int i = yd5Var.a;
            if (i == 3) {
                if (O() != null && O().getText() != null && O().getSelectionStart() > 0) {
                    String substring = O().getText().toString().substring(0, O().getSelectionStart());
                    Matcher matcher = l07.b.matcher(substring);
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
                qeb qebVar = this.b;
                if (qebVar != null) {
                    qebVar.n(N);
                }
            } else if (i == 24) {
                Object obj = yd5Var.c;
                if (!(obj instanceof m85)) {
                    return;
                }
                m85 m85Var = (m85) obj;
                if (EmotionGroupType.isSendAsPic(m85Var.g())) {
                    J(m85Var);
                    qeb qebVar2 = this.b;
                    if (qebVar2 != null) {
                        qebVar2.c();
                    }
                } else if (Q()) {
                    this.a.showToast((int) R.string.over_limit_tip);
                } else {
                    P(m85Var);
                }
            } else if (i == 25) {
                sfb sfbVar = this.l;
                if (sfbVar != null) {
                    sfbVar.n(yd5Var);
                }
            } else if (i == 74 && O() != null) {
                O().setTag(R.id.obfuscated_res_0x7f0912a9, Boolean.TRUE);
            }
        }
    }
}
