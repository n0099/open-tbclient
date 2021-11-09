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
import b.a.e.e.p.l;
import b.a.q0.f1.n.f;
import b.a.r0.c4.h;
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
/* loaded from: classes9.dex */
public class ExpandableTextView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int OFF_CONTENT_BACK = 1;
    public static final int ON_CONTENT_BACK = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f55494e;

    /* renamed from: f  reason: collision with root package name */
    public SpannableStringBuilder f55495f;

    /* renamed from: g  reason: collision with root package name */
    public SpannableStringBuilder f55496g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnTouchListener f55497h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnTouchListener f55498i;
    public boolean j;
    public boolean k;
    public boolean l;
    public SpannableClickTextView m;
    public TextView n;
    public int o;
    public int p;
    public int q;
    public e r;
    public boolean s;
    public ViewTreeObserver.OnGlobalLayoutListener t;
    public f u;
    public f v;
    public View.OnClickListener w;

    /* loaded from: classes9.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ExpandableTextView f55499e;

        public a(ExpandableTextView expandableTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {expandableTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55499e = expandableTextView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            String substring;
            Object[] spans;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f55499e.m == null || this.f55499e.f55495f == null || !this.f55499e.j || (layout = this.f55499e.m.getLayout()) == null) {
                return;
            }
            if (!this.f55499e.k) {
                if (layout.getLineCount() <= this.f55499e.o) {
                    return;
                }
                if (this.f55499e.f55496g == null) {
                    String spannableStringBuilder = this.f55499e.f55495f.toString();
                    int lineStart = layout.getLineStart(this.f55499e.o - 1);
                    int lineEnd = layout.getLineEnd(this.f55499e.o - 1);
                    String substring2 = spannableStringBuilder.substring(0, lineStart);
                    String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), StringHelper.getChineseAndEnglishLength(substring) - 6, "");
                    this.f55499e.f55496g = new SpannableStringBuilder();
                    this.f55499e.f55496g.append((CharSequence) substring2);
                    this.f55499e.f55496g.append((CharSequence) cutChineseAndEnglishWithSuffix);
                    int length = this.f55499e.f55496g.length();
                    for (Object obj : this.f55499e.f55495f.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                        int spanStart = this.f55499e.f55495f.getSpanStart(obj);
                        int spanEnd = this.f55499e.f55495f.getSpanEnd(obj);
                        if (spanStart < length && spanEnd >= length) {
                            break;
                        }
                        if (obj instanceof SpannableString) {
                            this.f55499e.f55496g.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                        }
                    }
                    this.f55499e.f55496g.append((CharSequence) "...");
                    SpannableString spannableString = new SpannableString("展开");
                    spannableString.setSpan(this.f55499e.u, 0, spannableString.length(), 17);
                    this.f55499e.f55496g.append((CharSequence) spannableString);
                    ExpandableTextView expandableTextView = this.f55499e;
                    expandableTextView.f55498i = new h(expandableTextView.f55496g);
                    ((h) this.f55499e.f55498i).a(R.color.transparent);
                }
                this.f55499e.n.setVisibility(8);
                this.f55499e.m.setOnTouchListener(this.f55499e.f55498i);
                this.f55499e.m.setText(this.f55499e.f55496g);
                if (this.f55499e.s) {
                    this.f55499e.t();
                }
            } else if (!this.f55499e.l) {
                this.f55499e.l = true;
                if (this.f55499e.f55494e == 2) {
                    int lineCount = layout.getLineCount();
                    int lineEnd2 = layout.getLineEnd(0);
                    int i2 = lineCount - 1;
                    int lineEnd3 = layout.getLineEnd(i2) - layout.getLineStart(i2);
                    SpannableString spannableString2 = new SpannableString("收起");
                    spannableString2.setSpan(this.f55499e.v, 0, spannableString2.length(), 17);
                    int i3 = lineEnd2 - lineEnd3;
                    if (i3 > 2) {
                        this.f55499e.f55495f.append((CharSequence) spannableString2);
                    } else {
                        int i4 = i3 + 1;
                        for (int i5 = 0; i5 < i4; i5++) {
                            this.f55499e.f55495f.append((CharSequence) GlideException.IndentedAppendable.INDENT);
                        }
                        this.f55499e.f55495f.append((CharSequence) spannableString2);
                    }
                    ((h) this.f55499e.f55497h).a(R.color.transparent);
                    this.f55499e.m.setOnTouchListener(this.f55499e.f55497h);
                    this.f55499e.m.setText(this.f55499e.f55495f);
                    this.f55499e.n.setVisibility(8);
                    return;
                }
                int lineCount2 = layout.getLineCount();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f55499e.n.getLayoutParams();
                if (this.f55499e.n.getWidth() + layout.getLineWidth(lineCount2 - 1) > layout.getWidth()) {
                    layoutParams.addRule(3, R.id.expandable_view_title);
                    layoutParams.addRule(8, 0);
                } else {
                    layoutParams.addRule(8, R.id.expandable_view_title);
                    layoutParams.addRule(3, 0);
                }
                this.f55499e.n.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ExpandableTextView l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ExpandableTextView expandableTextView, int i2, String str) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {expandableTextView, Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = expandableTextView;
        }

        @Override // b.a.q0.f1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.l.t();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ExpandableTextView l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ExpandableTextView expandableTextView, int i2, String str) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {expandableTextView, Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = expandableTextView;
        }

        @Override // b.a.q0.f1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.l.u();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ExpandableTextView f55500e;

        public d(ExpandableTextView expandableTextView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {expandableTextView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55500e = expandableTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f55500e.u();
            }
        }
    }

    /* loaded from: classes9.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55494e = 1;
        this.j = true;
        this.k = false;
        this.l = false;
        this.o = 2;
        this.p = Integer.MAX_VALUE;
        this.s = false;
        this.t = new a(this);
        this.u = new b(this, 2, null);
        this.v = new c(this, 2, null);
        this.w = new d(this);
        v(context);
    }

    public TextView getContentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.m : (TextView) invokeV.objValue;
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setViewTextColor(this.m, this.q, 1);
        }
    }

    public void setData(CharSequence charSequence, boolean z, WorksInfoData worksInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{charSequence, Boolean.valueOf(z), worksInfoData}) == null) {
            if (charSequence == null) {
                charSequence = "";
            }
            this.s = z;
            this.f55495f = new SpannableStringBuilder(charSequence);
            if (worksInfoData != null && worksInfoData.isWorks) {
                if (TextUtils.isEmpty(charSequence)) {
                    this.f55495f = new SpannableStringBuilder(" ");
                }
                ThreadCardUtils.setWorksPrefix(this.f55495f);
            }
            this.f55497h = new h(this.f55495f);
            this.m.setText(this.f55495f);
            this.m.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            this.m.setOnTouchListener(this.f55497h);
            SkinManager.setViewTextColor(this.m, this.q, 1);
        }
    }

    public void setExpandType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f55494e = i2;
        }
    }

    public void setExpandable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.j = z;
            if (!z) {
                if (Build.VERSION.SDK_INT < 16) {
                    this.m.getViewTreeObserver().removeGlobalOnLayoutListener(this.t);
                } else {
                    this.m.getViewTreeObserver().removeOnGlobalLayoutListener(this.t);
                }
                this.m.setMaxLines(this.p);
                this.m.setEllipsize(TextUtils.TruncateAt.END);
                this.m.setText(this.f55495f);
                this.m.setOnTouchListener(null);
                this.n.setVisibility(8);
                return;
            }
            this.m.getViewTreeObserver().addOnGlobalLayoutListener(this.t);
            this.m.setMaxLines(Integer.MAX_VALUE);
            this.m.setEllipsize(null);
        }
    }

    public void setHasDown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b.a.q0.s.u.c.d(this.m).y(R.array.S_O_X001);
        }
    }

    public void setLimitLine(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.o = i2;
        }
    }

    public void setLineSpacingExtra(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            float f2 = i2;
            this.m.setLineSpacing(f2, 1.0f);
            this.n.setLineSpacing(f2, 1.0f);
        }
    }

    public void setOnStatusChangedListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            this.r = eVar;
        }
    }

    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.q = i2;
            SkinManager.setViewTextColor(this.m, i2, 1);
        }
    }

    public void setTextMaxLine(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.p = i2;
        }
    }

    public void setTextSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            float f2 = i2;
            this.m.setTextSize(0, f2);
            this.n.setTextSize(0, f2);
        }
    }

    public void setTitleUpViewPadding(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048588, this, i2, i3, i4, i5) == null) {
            this.n.setPadding(i2, i3, i4, i5);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.k = true;
            e eVar = this.r;
            if (eVar != null) {
                eVar.a(true);
            }
            this.m.setOnTouchListener(this.f55497h);
            this.m.setText(this.f55495f);
            if (this.f55494e == 1) {
                this.n.setVisibility(0);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.k = false;
            e eVar = this.r;
            if (eVar != null) {
                eVar.a(false);
            }
            this.m.setOnTouchListener(this.f55498i);
            this.m.setText(this.f55496g);
            this.n.setVisibility(8);
        }
    }

    public final void v(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
            SpannableClickTextView spannableClickTextView = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
            this.m = spannableClickTextView;
            spannableClickTextView.setTextSize(0, TbConfig.getContentSize());
            this.m.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
            TextView textView = (TextView) findViewById(R.id.expandable_view_title_up);
            this.n = textView;
            textView.setOnClickListener(this.w);
            l.g(context, R.dimen.tbfontsize42);
            this.q = R.color.CAM_X0101;
            l.g(context, R.dimen.tbds6);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f55494e = 1;
        this.j = true;
        this.k = false;
        this.l = false;
        this.o = 2;
        this.p = Integer.MAX_VALUE;
        this.s = false;
        this.t = new a(this);
        this.u = new b(this, 2, null);
        this.v = new c(this, 2, null);
        this.w = new d(this);
        v(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpandableTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f55494e = 1;
        this.j = true;
        this.k = false;
        this.l = false;
        this.o = 2;
        this.p = Integer.MAX_VALUE;
        this.s = false;
        this.t = new a(this);
        this.u = new b(this, 2, null);
        this.v = new c(this, 2, null);
        this.w = new d(this);
        v(context);
    }
}
