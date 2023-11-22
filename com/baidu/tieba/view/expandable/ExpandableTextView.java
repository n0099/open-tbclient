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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.jy5;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
/* loaded from: classes8.dex */
public class ExpandableTextView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public SpannableStringBuilder b;
    public SpannableStringBuilder c;
    public boolean d;
    public boolean e;
    public boolean f;
    public SpannableClickTextView g;
    public TextView h;
    public int i;
    public int j;
    public int k;
    public e l;
    public boolean m;
    public ViewTreeObserver.OnGlobalLayoutListener n;
    public jy5 o;
    public jy5 p;
    public View.OnClickListener q;

    /* loaded from: classes8.dex */
    public interface e {
        void a(boolean z);
    }

    /* loaded from: classes8.dex */
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
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.g == null || this.a.b == null || !this.a.d || (layout = this.a.g.getLayout()) == null) {
                return;
            }
            if (!this.a.e) {
                if (layout.getLineCount() <= this.a.i) {
                    return;
                }
                if (this.a.c == null) {
                    String spannableStringBuilder = this.a.b.toString();
                    int lineStart = layout.getLineStart(this.a.i - 1);
                    int lineEnd = layout.getLineEnd(this.a.i - 1);
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
                    this.a.c.append((CharSequence) "...");
                    SpannableString spannableString = new SpannableString("展开");
                    spannableString.setSpan(this.a.o, 0, spannableString.length(), 17);
                    this.a.c.append((CharSequence) spannableString);
                }
                this.a.h.setVisibility(8);
                this.a.g.setText(this.a.c);
                if (!this.a.m) {
                    return;
                }
                this.a.q();
            } else if (!this.a.f) {
                this.a.f = true;
                if (this.a.a == 2) {
                    int lineCount = layout.getLineCount();
                    int lineEnd2 = layout.getLineEnd(0);
                    int i = lineCount - 1;
                    int lineEnd3 = layout.getLineEnd(i) - layout.getLineStart(i);
                    SpannableString spannableString2 = new SpannableString("收起");
                    spannableString2.setSpan(this.a.p, 0, spannableString2.length(), 17);
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
                    this.a.g.setText(this.a.b);
                    this.a.h.setVisibility(8);
                    return;
                }
                int lineCount2 = layout.getLineCount();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.h.getLayoutParams();
                if (this.a.h.getWidth() + layout.getLineWidth(lineCount2 - 1) > layout.getWidth()) {
                    layoutParams.addRule(3, R.id.expandable_view_title);
                    layoutParams.addRule(8, 0);
                } else {
                    layoutParams.addRule(8, R.id.expandable_view_title);
                    layoutParams.addRule(3, 0);
                }
                this.a.h.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends jy5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ExpandableTextView n;

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
            this.n = expandableTextView;
        }

        @Override // com.baidu.tieba.jy5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.n.q();
        }
    }

    /* loaded from: classes8.dex */
    public class c extends jy5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ExpandableTextView n;

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
            this.n = expandableTextView;
        }

        @Override // com.baidu.tieba.jy5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.n.r();
        }
    }

    /* loaded from: classes8.dex */
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
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.r();
        }
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
        this.d = true;
        this.e = false;
        this.f = false;
        this.i = 2;
        this.j = Integer.MAX_VALUE;
        this.m = false;
        this.n = new a(this);
        this.o = new b(this, 2, null);
        this.p = new c(this, 2, null);
        this.q = new d(this);
        s(context);
    }

    public void setExpandable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.d = z;
            if (!z) {
                if (Build.VERSION.SDK_INT < 16) {
                    this.g.getViewTreeObserver().removeGlobalOnLayoutListener(this.n);
                } else {
                    this.g.getViewTreeObserver().removeOnGlobalLayoutListener(this.n);
                }
                this.g.setMaxLines(this.j);
                this.g.setEllipsize(TextUtils.TruncateAt.END);
                this.g.setText(this.b);
                this.h.setVisibility(8);
                return;
            }
            this.g.getViewTreeObserver().addOnGlobalLayoutListener(this.n);
            this.g.setMaxLines(Integer.MAX_VALUE);
            this.g.setEllipsize(null);
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
        this.d = true;
        this.e = false;
        this.f = false;
        this.i = 2;
        this.j = Integer.MAX_VALUE;
        this.m = false;
        this.n = new a(this);
        this.o = new b(this, 2, null);
        this.p = new c(this, 2, null);
        this.q = new d(this);
        s(context);
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
        this.d = true;
        this.e = false;
        this.f = false;
        this.i = 2;
        this.j = Integer.MAX_VALUE;
        this.m = false;
        this.n = new a(this);
        this.o = new b(this, 2, null);
        this.p = new c(this, 2, null);
        this.q = new d(this);
        s(context);
    }

    public void setExpandType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.a = i;
        }
    }

    public void setLimitLine(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.i = i;
        }
    }

    public void setLineSpacingExtra(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            float f = i;
            this.g.setLineSpacing(f, 1.0f);
            this.h.setLineSpacing(f, 1.0f);
        }
    }

    public void setOnStatusChangedListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
            this.l = eVar;
        }
    }

    public void setTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.k = i;
            SkinManager.setViewTextColor(this.g, i, 1);
        }
    }

    public void setTextMaxLine(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.j = i;
        }
    }

    public void setTextSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            float f = i;
            this.g.setTextSize(0, f);
            this.h.setTextSize(0, f);
        }
    }

    public TextView getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (TextView) invokeV.objValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e = true;
            e eVar = this.l;
            if (eVar != null) {
                eVar.a(true);
            }
            this.g.setText(this.b);
            if (this.a == 1) {
                this.h.setVisibility(0);
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e = false;
            e eVar = this.l;
            if (eVar != null) {
                eVar.a(false);
            }
            this.g.setText(this.c);
            this.h.setVisibility(8);
        }
    }

    public void setHasDown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            EMManager.from(this.g).setTextShadow(R.array.S_O_X001);
        }
    }

    public final void s(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
            SpannableClickTextView spannableClickTextView = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
            this.g = spannableClickTextView;
            spannableClickTextView.setTextSize(0, TbConfig.getContentSize());
            this.g.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            this.g.setCustomMovementMethod();
            TextView textView = (TextView) findViewById(R.id.expandable_view_title_up);
            this.h = textView;
            textView.setOnClickListener(this.q);
            BdUtilHelper.getDimens(context, R.dimen.tbfontsize42);
            this.k = R.color.CAM_X0101;
            BdUtilHelper.getDimens(context, R.dimen.tbds6);
        }
    }

    public void setData(CharSequence charSequence, boolean z, WorksInfoData worksInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{charSequence, Boolean.valueOf(z), worksInfoData}) == null) {
            if (charSequence == null) {
                charSequence = "";
            }
            this.m = z;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            this.b = spannableStringBuilder;
            this.g.setText(spannableStringBuilder);
            this.g.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            SkinManager.setViewTextColor(this.g, this.k, 1);
        }
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048590, this, i, i2, i3, i4) == null) {
            this.h.setPadding(i, i2, i3, i4);
        }
    }
}
