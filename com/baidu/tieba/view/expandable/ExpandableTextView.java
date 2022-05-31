package com.baidu.tieba.view.expandable;

import android.content.Context;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import com.repackage.li;
import com.repackage.se5;
import com.repackage.wq4;
import com.repackage.ws8;
/* loaded from: classes4.dex */
public class ExpandableTextView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public SpannableStringBuilder b;
    public SpannableStringBuilder c;
    public View.OnTouchListener d;
    public View.OnTouchListener e;
    public boolean f;
    public boolean g;
    public boolean h;
    public SpannableClickTextView i;
    public TextView j;
    public int k;
    public int l;
    public int m;
    public e n;
    public boolean o;
    public ViewTreeObserver.OnGlobalLayoutListener p;
    public se5 q;
    public se5 r;
    public View.OnClickListener s;

    /* loaded from: classes4.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ExpandableTextView a;

        public a(ExpandableTextView expandableTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {expandableTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = expandableTextView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            String substring;
            Object[] spans;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.i == null || this.a.b == null || !this.a.f || (layout = this.a.i.getLayout()) == null) {
                return;
            }
            if (!this.a.g) {
                if (layout.getLineCount() <= this.a.k) {
                    return;
                }
                if (this.a.c == null) {
                    String spannableStringBuilder = this.a.b.toString();
                    int lineStart = layout.getLineStart(this.a.k - 1);
                    int lineEnd = layout.getLineEnd(this.a.k - 1);
                    String substring2 = spannableStringBuilder.substring(0, lineStart);
                    String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), StringHelper.getChineseAndEnglishLength(substring) - 6, "");
                    this.a.c = new SpannableStringBuilder();
                    this.a.c.append((CharSequence) substring2);
                    this.a.c.append((CharSequence) cutChineseAndEnglishWithSuffix);
                    int length = this.a.c.length();
                    for (Object obj : this.a.b.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                        int spanStart = this.a.b.getSpanStart(obj);
                        int spanEnd = this.a.b.getSpanEnd(obj);
                        if (spanStart < length && spanEnd >= length) {
                            break;
                        }
                        if (obj instanceof SpannableString) {
                            this.a.c.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                        }
                    }
                    this.a.c.append((CharSequence) StringHelper.STRING_MORE);
                    SpannableString spannableString = new SpannableString("展开");
                    spannableString.setSpan(this.a.q, 0, spannableString.length(), 17);
                    this.a.c.append((CharSequence) spannableString);
                    ExpandableTextView expandableTextView = this.a;
                    expandableTextView.e = new ws8(expandableTextView.c);
                    ((ws8) this.a.e).a(R.color.transparent);
                }
                this.a.j.setVisibility(8);
                this.a.i.setOnTouchListener(this.a.e);
                this.a.i.setText(this.a.c);
                if (this.a.o) {
                    this.a.t();
                }
            } else if (!this.a.h) {
                this.a.h = true;
                if (this.a.a == 2) {
                    int lineCount = layout.getLineCount();
                    int lineEnd2 = layout.getLineEnd(0);
                    int i = lineCount - 1;
                    int lineEnd3 = layout.getLineEnd(i) - layout.getLineStart(i);
                    SpannableString spannableString2 = new SpannableString("收起");
                    spannableString2.setSpan(this.a.r, 0, spannableString2.length(), 17);
                    int i2 = lineEnd2 - lineEnd3;
                    if (i2 > 2) {
                        this.a.b.append((CharSequence) spannableString2);
                    } else {
                        int i3 = i2 + 1;
                        for (int i4 = 0; i4 < i3; i4++) {
                            this.a.b.append((CharSequence) GlideException.IndentedAppendable.INDENT);
                        }
                        this.a.b.append((CharSequence) spannableString2);
                    }
                    ((ws8) this.a.d).a(R.color.transparent);
                    this.a.i.setOnTouchListener(this.a.d);
                    this.a.i.setText(this.a.b);
                    this.a.j.setVisibility(8);
                    return;
                }
                int lineCount2 = layout.getLineCount();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.j.getLayoutParams();
                if (this.a.j.getWidth() + layout.getLineWidth(lineCount2 - 1) > layout.getWidth()) {
                    layoutParams.addRule(3, R.id.obfuscated_res_0x7f09091e);
                    layoutParams.addRule(8, 0);
                } else {
                    layoutParams.addRule(8, R.id.obfuscated_res_0x7f09091e);
                    layoutParams.addRule(3, 0);
                }
                this.a.j.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends se5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ExpandableTextView h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ExpandableTextView expandableTextView, int i, String str) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {expandableTextView, Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = expandableTextView;
        }

        @Override // com.repackage.se5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.h.t();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends se5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ExpandableTextView h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ExpandableTextView expandableTextView, int i, String str) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {expandableTextView, Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = expandableTextView;
        }

        @Override // com.repackage.se5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.h.u();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ExpandableTextView a;

        public d(ExpandableTextView expandableTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {expandableTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = expandableTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.u();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpandableTextView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 1;
        this.f = true;
        this.g = false;
        this.h = false;
        this.k = 2;
        this.l = Integer.MAX_VALUE;
        this.o = false;
        this.p = new a(this);
        this.q = new b(this, 2, null);
        this.r = new c(this, 2, null);
        this.s = new d(this);
        v(context);
    }

    public TextView getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.i : (TextView) invokeV.objValue;
    }

    public void setData(CharSequence charSequence, boolean z, WorksInfoData worksInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{charSequence, Boolean.valueOf(z), worksInfoData}) == null) {
            if (charSequence == null) {
                charSequence = "";
            }
            this.o = z;
            this.b = new SpannableStringBuilder(charSequence);
            if (worksInfoData != null && worksInfoData.isWorks) {
                if (TextUtils.isEmpty(charSequence)) {
                    this.b = new SpannableStringBuilder(" ");
                }
                ThreadCardUtils.setWorksPrefix(this.b);
            }
            this.d = new ws8(this.b);
            this.i.setText(this.b);
            this.i.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            this.i.setOnTouchListener(this.d);
            SkinManager.setViewTextColor(this.i, this.m, 1);
        }
    }

    public void setExpandType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.a = i;
        }
    }

    public void setExpandable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f = z;
            if (!z) {
                if (Build.VERSION.SDK_INT < 16) {
                    this.i.getViewTreeObserver().removeGlobalOnLayoutListener(this.p);
                } else {
                    this.i.getViewTreeObserver().removeOnGlobalLayoutListener(this.p);
                }
                this.i.setMaxLines(this.l);
                this.i.setEllipsize(TextUtils.TruncateAt.END);
                this.i.setText(this.b);
                this.i.setOnTouchListener(null);
                this.j.setVisibility(8);
                return;
            }
            this.i.getViewTreeObserver().addOnGlobalLayoutListener(this.p);
            this.i.setMaxLines(Integer.MAX_VALUE);
            this.i.setEllipsize(null);
        }
    }

    public void setHasDown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            wq4.d(this.i).y(R.array.S_O_X001);
        }
    }

    public void setLimitLine(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.k = i;
        }
    }

    public void setLineSpacingExtra(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            float f = i;
            this.i.setLineSpacing(f, 1.0f);
            this.j.setLineSpacing(f, 1.0f);
        }
    }

    public void setOnStatusChangedListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            this.n = eVar;
        }
    }

    public void setTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.m = i;
            SkinManager.setViewTextColor(this.i, i, 1);
        }
    }

    public void setTextMaxLine(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.l = i;
        }
    }

    public void setTextSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            float f = i;
            this.i.setTextSize(0, f);
            this.j.setTextSize(0, f);
        }
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048587, this, i, i2, i3, i4) == null) {
            this.j.setPadding(i, i2, i3, i4);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.g = true;
            e eVar = this.n;
            if (eVar != null) {
                eVar.a(true);
            }
            this.i.setOnTouchListener(this.d);
            this.i.setText(this.b);
            if (this.a == 1) {
                this.j.setVisibility(0);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.g = false;
            e eVar = this.n;
            if (eVar != null) {
                eVar.a(false);
            }
            this.i.setOnTouchListener(this.e);
            this.i.setText(this.c);
            this.j.setVisibility(8);
        }
    }

    public final void v(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d089e, this);
            SpannableClickTextView spannableClickTextView = (SpannableClickTextView) findViewById(R.id.obfuscated_res_0x7f09091e);
            this.i = spannableClickTextView;
            spannableClickTextView.setTextSize(0, TbConfig.getContentSize());
            this.i.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09091f);
            this.j = textView;
            textView.setOnClickListener(this.s);
            li.f(context, R.dimen.tbfontsize42);
            this.m = R.color.CAM_X0101;
            li.f(context, R.dimen.tbds6);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 1;
        this.f = true;
        this.g = false;
        this.h = false;
        this.k = 2;
        this.l = Integer.MAX_VALUE;
        this.o = false;
        this.p = new a(this);
        this.q = new b(this, 2, null);
        this.r = new c(this, 2, null);
        this.s = new d(this);
        v(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
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
        this.a = 1;
        this.f = true;
        this.g = false;
        this.h = false;
        this.k = 2;
        this.l = Integer.MAX_VALUE;
        this.o = false;
        this.p = new a(this);
        this.q = new b(this, 2, null);
        this.r = new c(this, 2, null);
        this.s = new d(this);
        v(context);
    }
}
