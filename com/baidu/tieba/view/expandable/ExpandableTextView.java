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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.bumptech.glide.load.engine.GlideException;
import d.a.c.e.p.l;
import d.a.i0.b1.m.f;
import d.a.j0.u3.i;
/* loaded from: classes5.dex */
public class ExpandableTextView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f22586e;

    /* renamed from: f  reason: collision with root package name */
    public SpannableStringBuilder f22587f;

    /* renamed from: g  reason: collision with root package name */
    public SpannableStringBuilder f22588g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnTouchListener f22589h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnTouchListener f22590i;
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

    /* loaded from: classes5.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            String substring;
            Object[] spans;
            if (ExpandableTextView.this.m == null || ExpandableTextView.this.f22587f == null || !ExpandableTextView.this.j || (layout = ExpandableTextView.this.m.getLayout()) == null) {
                return;
            }
            if (!ExpandableTextView.this.k) {
                if (layout.getLineCount() <= ExpandableTextView.this.o) {
                    return;
                }
                if (ExpandableTextView.this.f22588g == null) {
                    String spannableStringBuilder = ExpandableTextView.this.f22587f.toString();
                    int lineStart = layout.getLineStart(ExpandableTextView.this.o - 1);
                    int lineEnd = layout.getLineEnd(ExpandableTextView.this.o - 1);
                    String substring2 = spannableStringBuilder.substring(0, lineStart);
                    String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), StringHelper.getChineseAndEnglishLength(substring) - 6, "");
                    ExpandableTextView.this.f22588g = new SpannableStringBuilder();
                    ExpandableTextView.this.f22588g.append((CharSequence) substring2);
                    ExpandableTextView.this.f22588g.append((CharSequence) cutChineseAndEnglishWithSuffix);
                    int length = ExpandableTextView.this.f22588g.length();
                    for (Object obj : ExpandableTextView.this.f22587f.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                        int spanStart = ExpandableTextView.this.f22587f.getSpanStart(obj);
                        int spanEnd = ExpandableTextView.this.f22587f.getSpanEnd(obj);
                        if (spanStart < length && spanEnd >= length) {
                            break;
                        }
                        if (obj instanceof SpannableString) {
                            ExpandableTextView.this.f22588g.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                        }
                    }
                    ExpandableTextView.this.f22588g.append((CharSequence) StringHelper.STRING_MORE);
                    SpannableString spannableString = new SpannableString("展开");
                    spannableString.setSpan(ExpandableTextView.this.u, 0, spannableString.length(), 17);
                    ExpandableTextView.this.f22588g.append((CharSequence) spannableString);
                    ExpandableTextView expandableTextView = ExpandableTextView.this;
                    expandableTextView.f22590i = new i(expandableTextView.f22588g);
                    ((i) ExpandableTextView.this.f22590i).a(R.color.transparent);
                }
                ExpandableTextView.this.n.setVisibility(8);
                ExpandableTextView.this.m.setOnTouchListener(ExpandableTextView.this.f22590i);
                ExpandableTextView.this.m.setText(ExpandableTextView.this.f22588g);
                if (ExpandableTextView.this.s) {
                    ExpandableTextView.this.t();
                }
            } else if (!ExpandableTextView.this.l) {
                ExpandableTextView.this.l = true;
                if (ExpandableTextView.this.f22586e == 2) {
                    int lineCount = layout.getLineCount();
                    int lineEnd2 = layout.getLineEnd(0);
                    int i2 = lineCount - 1;
                    int lineEnd3 = layout.getLineEnd(i2) - layout.getLineStart(i2);
                    SpannableString spannableString2 = new SpannableString("收起");
                    spannableString2.setSpan(ExpandableTextView.this.v, 0, spannableString2.length(), 17);
                    int i3 = lineEnd2 - lineEnd3;
                    if (i3 > 2) {
                        ExpandableTextView.this.f22587f.append((CharSequence) spannableString2);
                    } else {
                        int i4 = i3 + 1;
                        for (int i5 = 0; i5 < i4; i5++) {
                            ExpandableTextView.this.f22587f.append((CharSequence) GlideException.IndentedAppendable.INDENT);
                        }
                        ExpandableTextView.this.f22587f.append((CharSequence) spannableString2);
                    }
                    ((i) ExpandableTextView.this.f22589h).a(R.color.transparent);
                    ExpandableTextView.this.m.setOnTouchListener(ExpandableTextView.this.f22589h);
                    ExpandableTextView.this.m.setText(ExpandableTextView.this.f22587f);
                    ExpandableTextView.this.n.setVisibility(8);
                    return;
                }
                int lineCount2 = layout.getLineCount();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.n.getLayoutParams();
                if (ExpandableTextView.this.n.getWidth() + layout.getLineWidth(lineCount2 - 1) > layout.getWidth()) {
                    layoutParams.addRule(3, R.id.expandable_view_title);
                    layoutParams.addRule(8, 0);
                } else {
                    layoutParams.addRule(8, R.id.expandable_view_title);
                    layoutParams.addRule(3, 0);
                }
                ExpandableTextView.this.n.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends f {
        public b(int i2, String str) {
            super(i2, str);
        }

        @Override // d.a.i0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            ExpandableTextView.this.t();
        }
    }

    /* loaded from: classes5.dex */
    public class c extends f {
        public c(int i2, String str) {
            super(i2, str);
        }

        @Override // d.a.i0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            ExpandableTextView.this.u();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ExpandableTextView.this.u();
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(boolean z);
    }

    public ExpandableTextView(Context context) {
        super(context);
        this.f22586e = 1;
        this.j = true;
        this.k = false;
        this.l = false;
        this.o = 2;
        this.p = Integer.MAX_VALUE;
        this.s = false;
        this.t = new a();
        this.u = new b(2, null);
        this.v = new c(2, null);
        this.w = new d();
        v(context);
    }

    public TextView getContentView() {
        return this.m;
    }

    public void setData(CharSequence charSequence, boolean z, WorksInfoData worksInfoData) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.s = z;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        this.f22587f = spannableStringBuilder;
        if (worksInfoData != null && worksInfoData.isWorks) {
            ThreadCardUtils.setWorksPrefix(spannableStringBuilder);
        }
        this.f22589h = new i(this.f22587f);
        this.m.setText(this.f22587f);
        this.m.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        this.m.setOnTouchListener(this.f22589h);
        SkinManager.setViewTextColor(this.m, this.q, 1);
    }

    public void setExpandType(int i2) {
        this.f22586e = i2;
    }

    public void setExpandable(boolean z) {
        this.j = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.m.getViewTreeObserver().removeGlobalOnLayoutListener(this.t);
            } else {
                this.m.getViewTreeObserver().removeOnGlobalLayoutListener(this.t);
            }
            this.m.setMaxLines(this.p);
            this.m.setEllipsize(TextUtils.TruncateAt.END);
            this.m.setText(this.f22587f);
            this.m.setOnTouchListener(null);
            this.n.setVisibility(8);
            return;
        }
        this.m.getViewTreeObserver().addOnGlobalLayoutListener(this.t);
        this.m.setMaxLines(Integer.MAX_VALUE);
        this.m.setEllipsize(null);
    }

    public void setHasDown() {
        d.a.i0.r.u.c.d(this.m).t(R.array.S_O_X001);
    }

    public void setLineSpacingExtra(int i2) {
        float f2 = i2;
        this.m.setLineSpacing(f2, 1.0f);
        this.n.setLineSpacing(f2, 1.0f);
    }

    public void setOnStatusChangedListener(e eVar) {
        this.r = eVar;
    }

    public void setTextColor(int i2) {
        this.q = i2;
        SkinManager.setViewTextColor(this.m, i2, 1);
    }

    public void setTextMaxLine(int i2) {
        this.p = i2;
    }

    public void setTextSize(int i2) {
        float f2 = i2;
        this.m.setTextSize(0, f2);
        this.n.setTextSize(0, f2);
    }

    public void setTitleUpViewPadding(int i2, int i3, int i4, int i5) {
        this.n.setPadding(i2, i3, i4, i5);
    }

    public final void t() {
        this.k = true;
        e eVar = this.r;
        if (eVar != null) {
            eVar.a(true);
        }
        this.m.setOnTouchListener(this.f22589h);
        this.m.setText(this.f22587f);
        if (this.f22586e == 1) {
            this.n.setVisibility(0);
        }
    }

    public final void u() {
        this.k = false;
        e eVar = this.r;
        if (eVar != null) {
            eVar.a(false);
        }
        this.m.setOnTouchListener(this.f22590i);
        this.m.setText(this.f22588g);
        this.n.setVisibility(8);
    }

    public final void v(Context context) {
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

    public void w() {
        SkinManager.setViewTextColor(this.m, this.q, 1);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22586e = 1;
        this.j = true;
        this.k = false;
        this.l = false;
        this.o = 2;
        this.p = Integer.MAX_VALUE;
        this.s = false;
        this.t = new a();
        this.u = new b(2, null);
        this.v = new c(2, null);
        this.w = new d();
        v(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f22586e = 1;
        this.j = true;
        this.k = false;
        this.l = false;
        this.o = 2;
        this.p = Integer.MAX_VALUE;
        this.s = false;
        this.t = new a();
        this.u = new b(2, null);
        this.v = new c(2, null);
        this.w = new d();
        v(context);
    }
}
