package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.widget.EditText;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class nc6 {
    public static /* synthetic */ Interceptable $ic;
    public static final KeyEvent a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends yg<on> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditText a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ e15 c;

        public a(EditText editText, Context context, e15 e15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editText, context, e15Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editText;
            this.b = context;
            this.c = e15Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg
        public void onLoaded(on onVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, onVar, str, i) == null) || onVar == null) {
                return;
            }
            int selectionStart = this.a.getSelectionStart();
            nc6.g(this.b, this.a, new SpannableStringBuilder(this.c.d()), selectionStart < 0 ? 0 : selectionStart, onVar, this.c.getType());
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends yg<on> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditText a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ SpannableStringBuilder c;
        public final /* synthetic */ EmotionGroupType d;

        public b(EditText editText, Context context, SpannableStringBuilder spannableStringBuilder, EmotionGroupType emotionGroupType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editText, context, spannableStringBuilder, emotionGroupType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editText;
            this.b = context;
            this.c = spannableStringBuilder;
            this.d = emotionGroupType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg
        public void onLoaded(on onVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, onVar, str, i) == null) {
                super.onLoaded((b) onVar, str, i);
                if (onVar != null) {
                    int selectionStart = this.a.getSelectionStart();
                    nc6.g(this.b, this.a, this.c, selectionStart < 0 ? 0 : selectionStart, onVar, this.d);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends yg<on> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpannableStringBuilder a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int[] d;
        public final /* synthetic */ h e;

        public c(SpannableStringBuilder spannableStringBuilder, int i, int i2, int[] iArr, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spannableStringBuilder, Integer.valueOf(i), Integer.valueOf(i2), iArr, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = spannableStringBuilder;
            this.b = i;
            this.c = i2;
            this.d = iArr;
            this.e = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg
        public void onLoaded(on onVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, onVar, str, i) == null) {
                super.onLoaded((c) onVar, str, i);
                if (onVar != null && onVar.p() != null) {
                    Bitmap p = onVar.p();
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
                    int width = (int) (p.getWidth() * 0.4d);
                    bitmapDrawable.setBounds(0, 0, width, width);
                    bitmapDrawable.setGravity(119);
                    this.a.setSpan(new kn(bitmapDrawable, 1), this.b, this.c, 33);
                    int[] iArr = this.d;
                    int i2 = iArr[0] - 1;
                    iArr[0] = i2;
                    if (i2 == 0) {
                        this.e.a(this.a);
                        return;
                    }
                    return;
                }
                this.a.setSpan("", this.b, this.c, 33);
                int[] iArr2 = this.d;
                int i3 = iArr2[0] - 1;
                iArr2[0] = i3;
                if (i3 == 0) {
                    this.e.a(this.a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d extends yg<on> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpannableStringBuilder a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int[] d;
        public final /* synthetic */ h e;

        public d(SpannableStringBuilder spannableStringBuilder, int i, int i2, int[] iArr, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spannableStringBuilder, Integer.valueOf(i), Integer.valueOf(i2), iArr, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = spannableStringBuilder;
            this.b = i;
            this.c = i2;
            this.d = iArr;
            this.e = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg
        public void onLoaded(on onVar, String str, int i) {
            h hVar;
            h hVar2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, onVar, str, i) == null) {
                super.onLoaded((d) onVar, str, i);
                if (onVar != null) {
                    Bitmap p = onVar.p();
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
                    int width = (int) (p.getWidth() * (UbsABTestHelper.isResizeEmotionABTest() ? 0.4d : 0.5d));
                    bitmapDrawable.setBounds(0, 0, width, width);
                    bitmapDrawable.setGravity(119);
                    this.a.setSpan(new qc6(bitmapDrawable, 1), this.b, this.c, 33);
                    int[] iArr = this.d;
                    int i2 = iArr[0] - 1;
                    iArr[0] = i2;
                    if (i2 != 0 || (hVar2 = this.e) == null) {
                        return;
                    }
                    hVar2.a(this.a);
                    return;
                }
                this.a.setSpan("", this.b, this.c, 33);
                int[] iArr2 = this.d;
                int i3 = iArr2[0] - 1;
                iArr2[0] = i3;
                if (i3 != 0 || (hVar = this.e) == null) {
                    return;
                }
                hVar.a(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e extends yg<on> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ SpannableStringBuilder b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int[] e;
        public final /* synthetic */ h f;

        public e(Context context, SpannableStringBuilder spannableStringBuilder, int i, int i2, int[] iArr, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, spannableStringBuilder, Integer.valueOf(i), Integer.valueOf(i2), iArr, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = spannableStringBuilder;
            this.c = i;
            this.d = i2;
            this.e = iArr;
            this.f = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg
        public void onLoaded(on onVar, String str, int i) {
            h hVar;
            Bitmap p;
            h hVar2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, onVar, str, i) == null) {
                super.onLoaded((e) onVar, str, i);
                if (onVar != null) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(onVar.p());
                    int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070275);
                    int width = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
                    if (width > ej.k(this.a) * 0.6d) {
                        width = (int) (p.getWidth() * 0.5d);
                    }
                    bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                    bitmapDrawable.setGravity(119);
                    this.b.setSpan(new ImageSpan(bitmapDrawable, 0), this.c, this.d, 33);
                    int[] iArr = this.e;
                    int i2 = iArr[0] - 1;
                    iArr[0] = i2;
                    if (i2 != 0 || (hVar2 = this.f) == null) {
                        return;
                    }
                    hVar2.a(this.b);
                    return;
                }
                this.b.setSpan("", this.c, this.d, 33);
                int[] iArr2 = this.e;
                int i3 = iArr2[0] - 1;
                iArr2[0] = i3;
                if (i3 != 0 || (hVar = this.f) == null) {
                    return;
                }
                hVar.a(this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class f extends yg<on> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ SpannableStringBuilder b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int[] e;
        public final /* synthetic */ h f;

        public f(Context context, SpannableStringBuilder spannableStringBuilder, int i, int i2, int[] iArr, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, spannableStringBuilder, Integer.valueOf(i), Integer.valueOf(i2), iArr, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = spannableStringBuilder;
            this.c = i;
            this.d = i2;
            this.e = iArr;
            this.f = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg
        public void onLoaded(on onVar, String str, int i) {
            h hVar;
            Bitmap p;
            h hVar2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, onVar, str, i) == null) {
                super.onLoaded((f) onVar, str, i);
                if (onVar != null) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(onVar.p());
                    int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070275);
                    int width = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
                    if (width > ej.k(this.a) * 0.6d) {
                        width = (int) (p.getWidth() * 0.5d);
                    }
                    bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                    bitmapDrawable.setGravity(119);
                    this.b.setSpan(new ImageSpan(bitmapDrawable, 0), this.c, this.d, 33);
                    int[] iArr = this.e;
                    int i2 = iArr[0] - 1;
                    iArr[0] = i2;
                    if (i2 != 0 || (hVar2 = this.f) == null) {
                        return;
                    }
                    hVar2.a(this.b);
                    return;
                }
                this.b.setSpan("", this.c, this.d, 33);
                int[] iArr2 = this.e;
                int i3 = iArr2[0] - 1;
                iArr2[0] = i3;
                if (i3 != 0 || (hVar = this.f) == null) {
                    return;
                }
                hVar.a(this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class g extends yg<on> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpannableStringBuilder a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int[] d;
        public final /* synthetic */ h e;

        public g(SpannableStringBuilder spannableStringBuilder, int i, int i2, int[] iArr, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spannableStringBuilder, Integer.valueOf(i), Integer.valueOf(i2), iArr, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = spannableStringBuilder;
            this.b = i;
            this.c = i2;
            this.d = iArr;
            this.e = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg
        public void onLoaded(on onVar, String str, int i) {
            h hVar;
            h hVar2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, onVar, str, i) == null) {
                super.onLoaded((g) onVar, str, i);
                if (onVar != null) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(onVar.p());
                    int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds54);
                    bitmapDrawable.setBounds(0, 0, dimenPixelSize, dimenPixelSize);
                    bitmapDrawable.setGravity(119);
                    this.a.setSpan(new kn(bitmapDrawable, 1), this.b, this.c, 33);
                    int[] iArr = this.d;
                    int i2 = iArr[0] - 1;
                    iArr[0] = i2;
                    if (i2 != 0 || (hVar2 = this.e) == null) {
                        return;
                    }
                    hVar2.a(this.a);
                    return;
                }
                this.a.setSpan("", this.b, this.c, 33);
                int[] iArr2 = this.d;
                int i3 = iArr2[0] - 1;
                iArr2[0] = i3;
                if (i3 != 0 || (hVar = this.e) == null) {
                    return;
                }
                hVar.a(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface h {
        void a(SpannableStringBuilder spannableStringBuilder);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947997704, "Lcom/baidu/tieba/nc6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947997704, "Lcom/baidu/tieba/nc6;");
                return;
            }
        }
        a = new KeyEvent(0, 67);
    }

    public static void a(EditText editText) {
        Editable text;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, editText) == null) || editText == null || (text = editText.getText()) == null) {
            return;
        }
        int selectionStart = editText.getSelectionStart() - 1;
        if (selectionStart > 0 && selectionStart < text.length() && text.charAt(selectionStart) == 0) {
            editText.onKeyDown(67, a);
        }
        editText.onKeyDown(67, a);
        int selectionStart2 = editText.getSelectionStart();
        if (text != null) {
            editText.setSelection(selectionStart2);
        }
    }

    public static void b(Context context, e15 e15Var, EditText editText) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, context, e15Var, editText) == null) || e15Var == null || editText == null || e15Var.d() == null) {
            return;
        }
        String d2 = e15Var.d();
        EmotionGroupType type = e15Var.getType();
        if (type != EmotionGroupType.LOCAL && type != EmotionGroupType.USER_COLLECT && !d2.startsWith(SmallTailInfo.EMOTION_PREFIX)) {
            editText.getText().insert(editText.getSelectionStart(), d2);
        } else if (d2 != null) {
            zg.h().k(d2, 20, new b(editText, context, new SpannableStringBuilder(d2), type), 0, 0, BdUniqueId.gen(), null, d2, Boolean.FALSE, null);
        }
    }

    public static void c(Context context, e15 e15Var, EditText editText) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, context, e15Var, editText) == null) || e15Var == null || TextUtils.isEmpty(e15Var.d()) || TextUtils.isEmpty(e15Var.g()) || editText == null) {
            return;
        }
        zg.h().k(e15Var.g(), 10, new a(editText, context, e15Var), 0, 0, BdUniqueId.gen(), new Object[0]);
    }

    public static void d(Context context, CharSequence charSequence, h hVar) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, charSequence, hVar) == null) || context == null || TextUtils.isEmpty(charSequence) || hVar == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        int[] iArr = {mc6.a(charSequence)};
        if (iArr[0] <= 0) {
            if (hVar != null) {
                hVar.a(spannableStringBuilder);
                return;
            }
            return;
        }
        Matcher matcher = mc6.a.matcher(spannableStringBuilder);
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            if (MessageManager.getInstance().findTask(2004609) != null && (runTask = MessageManager.getInstance().runTask(2004609, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue()) {
                zg.h().k(group, 20, new g(spannableStringBuilder, start, end, iArr, hVar), 0, 0, BdUniqueId.gen(), null, group, Boolean.FALSE, null);
            }
        }
    }

    public static void e(Context context, CharSequence charSequence, h hVar) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65541, null, context, charSequence, hVar) == null) || context == null || TextUtils.isEmpty(charSequence) || hVar == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        int[] iArr = {mc6.a(charSequence)};
        if (iArr[0] <= 0) {
            hVar.a(spannableStringBuilder);
            return;
        }
        Matcher matcher = mc6.a.matcher(spannableStringBuilder);
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            if (MessageManager.getInstance().findTask(2004609) != null && (runTask = MessageManager.getInstance().runTask(2004609, Boolean.class, group)) != null && runTask.getData() != null && ((Boolean) runTask.getData()).booleanValue()) {
                zg.h().k(group, 20, new c(spannableStringBuilder, start, end, iArr, hVar), 0, 0, BdUniqueId.gen(), null, group, Boolean.FALSE, null);
            }
        }
    }

    public static void f(Context context, CharSequence charSequence, h hVar) {
        String str;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, context, charSequence, hVar) == null) || context == null || TextUtils.isEmpty(charSequence) || hVar == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        int[] iArr = {mc6.a(charSequence)};
        if (iArr[0] <= 0) {
            if (hVar != null) {
                hVar.a(spannableStringBuilder);
                return;
            }
            return;
        }
        Matcher matcher = mc6.a.matcher(spannableStringBuilder);
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            if (MessageManager.getInstance().findTask(2004609) != null && (runTask = MessageManager.getInstance().runTask(2004609, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue()) {
                zg.h().k(group, 20, new d(spannableStringBuilder, start, end, iArr, hVar), 0, 0, BdUniqueId.gen(), null, group, Boolean.FALSE, null);
            }
        }
        Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableStringBuilder);
        while (true) {
            str = ",";
            if (!matcher2.find()) {
                break;
            }
            String group2 = matcher2.group();
            String[] split = group2.split(",");
            if (split != null && split.length == 5) {
                zg.h().k(group2, 20, new e(context, spannableStringBuilder, matcher2.start(), matcher2.end(), iArr, hVar), 0, 0, BdUniqueId.gen(), null, group2, Boolean.FALSE, null);
            }
        }
        Matcher matcher3 = Pattern.compile("#\\(meme,net_[a-zA-Z0-9_\\-\\.\\%,]+\\)").matcher(spannableStringBuilder);
        while (matcher3.find()) {
            String[] split2 = matcher3.group().split(str);
            if (split2 != null && split2.length == 6) {
                String str2 = str;
                f fVar = new f(context, spannableStringBuilder, matcher3.start(), matcher3.end(), iArr, hVar);
                if (!TextUtils.isEmpty(split2[1])) {
                    zg.h().k(Uri.decode(split2[1].replace("net_", "")), 10, fVar, 0, 0, BdUniqueId.gen(), new Object[0]);
                }
                str = str2;
            }
        }
    }

    public static void g(Context context, EditText editText, SpannableStringBuilder spannableStringBuilder, int i, on onVar, EmotionGroupType emotionGroupType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, editText, spannableStringBuilder, Integer.valueOf(i), onVar, emotionGroupType}) == null) || context == null || editText == null || TextUtils.isEmpty(spannableStringBuilder) || onVar == null) {
            return;
        }
        Bitmap p = onVar.p();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
        int width = p.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            int i2 = UbsABTestHelper.isResizeEmotionABTest() ? (int) (width * 0.4d) : (int) (width * 0.5d);
            bitmapDrawable.setBounds(0, 0, i2, i2);
        } else if (emotionGroupType == EmotionGroupType.USER_COLLECT || spannableStringBuilder.toString().startsWith(SmallTailInfo.EMOTION_PREFIX)) {
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070275);
            int width2 = (int) (p.getWidth() * ((dimensionPixelSize * 1.0d) / p.getHeight()));
            if (width2 > editText.getMeasuredWidth()) {
                width2 = (int) (p.getWidth() * 0.5d);
            }
            bitmapDrawable.setBounds(0, 0, width2, dimensionPixelSize);
        }
        bitmapDrawable.setGravity(119);
        spannableStringBuilder.setSpan(new qc6(bitmapDrawable, 1), 0, spannableStringBuilder.length(), 33);
        editText.getText().insert(i, spannableStringBuilder);
    }
}
