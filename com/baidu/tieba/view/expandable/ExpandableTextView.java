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
import d.b.b.e.p.l;
import d.b.h0.b1.m.f;
import d.b.i0.t3.i;
/* loaded from: classes5.dex */
public class ExpandableTextView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f22223e;

    /* renamed from: f  reason: collision with root package name */
    public SpannableStringBuilder f22224f;

    /* renamed from: g  reason: collision with root package name */
    public SpannableStringBuilder f22225g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnTouchListener f22226h;
    public View.OnTouchListener i;
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
            if (ExpandableTextView.this.m == null || ExpandableTextView.this.f22224f == null || !ExpandableTextView.this.j || (layout = ExpandableTextView.this.m.getLayout()) == null) {
                return;
            }
            if (!ExpandableTextView.this.k) {
                if (layout.getLineCount() <= ExpandableTextView.this.o) {
                    return;
                }
                if (ExpandableTextView.this.f22225g == null) {
                    String spannableStringBuilder = ExpandableTextView.this.f22224f.toString();
                    int lineStart = layout.getLineStart(ExpandableTextView.this.o - 1);
                    int lineEnd = layout.getLineEnd(ExpandableTextView.this.o - 1);
                    String substring2 = spannableStringBuilder.substring(0, lineStart);
                    String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), StringHelper.getChineseAndEnglishLength(substring) - 6, "");
                    ExpandableTextView.this.f22225g = new SpannableStringBuilder();
                    ExpandableTextView.this.f22225g.append((CharSequence) substring2);
                    ExpandableTextView.this.f22225g.append((CharSequence) cutChineseAndEnglishWithSuffix);
                    int length = ExpandableTextView.this.f22225g.length();
                    for (Object obj : ExpandableTextView.this.f22224f.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                        int spanStart = ExpandableTextView.this.f22224f.getSpanStart(obj);
                        int spanEnd = ExpandableTextView.this.f22224f.getSpanEnd(obj);
                        if (spanStart < length && spanEnd >= length) {
                            break;
                        }
                        if (obj instanceof SpannableString) {
                            ExpandableTextView.this.f22225g.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                        }
                    }
                    ExpandableTextView.this.f22225g.append((CharSequence) StringHelper.STRING_MORE);
                    SpannableString spannableString = new SpannableString("展开");
                    spannableString.setSpan(ExpandableTextView.this.u, 0, spannableString.length(), 17);
                    ExpandableTextView.this.f22225g.append((CharSequence) spannableString);
                    ExpandableTextView expandableTextView = ExpandableTextView.this;
                    expandableTextView.i = new i(expandableTextView.f22225g);
                    ((i) ExpandableTextView.this.i).a(R.color.transparent);
                }
                ExpandableTextView.this.n.setVisibility(8);
                ExpandableTextView.this.m.setOnTouchListener(ExpandableTextView.this.i);
                ExpandableTextView.this.m.setText(ExpandableTextView.this.f22225g);
                if (ExpandableTextView.this.s) {
                    ExpandableTextView.this.t();
                }
            } else if (!ExpandableTextView.this.l) {
                ExpandableTextView.this.l = true;
                if (ExpandableTextView.this.f22223e == 2) {
                    int lineCount = layout.getLineCount();
                    int lineEnd2 = layout.getLineEnd(0);
                    int i = lineCount - 1;
                    int lineEnd3 = layout.getLineEnd(i) - layout.getLineStart(i);
                    SpannableString spannableString2 = new SpannableString("收起");
                    spannableString2.setSpan(ExpandableTextView.this.v, 0, spannableString2.length(), 17);
                    int i2 = lineEnd2 - lineEnd3;
                    if (i2 > 2) {
                        ExpandableTextView.this.f22224f.append((CharSequence) spannableString2);
                    } else {
                        int i3 = i2 + 1;
                        for (int i4 = 0; i4 < i3; i4++) {
                            ExpandableTextView.this.f22224f.append((CharSequence) GlideException.IndentedAppendable.INDENT);
                        }
                        ExpandableTextView.this.f22224f.append((CharSequence) spannableString2);
                    }
                    ((i) ExpandableTextView.this.f22226h).a(R.color.transparent);
                    ExpandableTextView.this.m.setOnTouchListener(ExpandableTextView.this.f22226h);
                    ExpandableTextView.this.m.setText(ExpandableTextView.this.f22224f);
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
        public b(int i, String str) {
            super(i, str);
        }

        @Override // d.b.h0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            ExpandableTextView.this.t();
        }
    }

    /* loaded from: classes5.dex */
    public class c extends f {
        public c(int i, String str) {
            super(i, str);
        }

        @Override // d.b.h0.b1.m.f, android.text.style.ClickableSpan
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
        this.f22223e = 1;
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
        this.f22224f = spannableStringBuilder;
        if (worksInfoData != null && worksInfoData.isWorks) {
            ThreadCardUtils.setWorksPrefix(spannableStringBuilder);
        }
        this.f22226h = new i(this.f22224f);
        this.m.setText(this.f22224f);
        this.m.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        this.m.setOnTouchListener(this.f22226h);
        SkinManager.setViewTextColor(this.m, this.q, 1);
    }

    public void setExpandType(int i) {
        this.f22223e = i;
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
            this.m.setText(this.f22224f);
            this.m.setOnTouchListener(null);
            this.n.setVisibility(8);
            return;
        }
        this.m.getViewTreeObserver().addOnGlobalLayoutListener(this.t);
        this.m.setMaxLines(Integer.MAX_VALUE);
        this.m.setEllipsize(null);
    }

    public void setHasDown() {
        d.b.h0.r.u.c.a(this.m).q(R.array.S_O_X001);
    }

    public void setLineSpacingExtra(int i) {
        float f2 = i;
        this.m.setLineSpacing(f2, 1.0f);
        this.n.setLineSpacing(f2, 1.0f);
    }

    public void setOnStatusChangedListener(e eVar) {
        this.r = eVar;
    }

    public void setTextColor(int i) {
        this.q = i;
        SkinManager.setViewTextColor(this.m, i, 1);
    }

    public void setTextMaxLine(int i) {
        this.p = i;
    }

    public void setTextSize(int i) {
        float f2 = i;
        this.m.setTextSize(0, f2);
        this.n.setTextSize(0, f2);
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.n.setPadding(i, i2, i3, i4);
    }

    public final void t() {
        this.k = true;
        e eVar = this.r;
        if (eVar != null) {
            eVar.a(true);
        }
        this.m.setOnTouchListener(this.f22226h);
        this.m.setText(this.f22224f);
        if (this.f22223e == 1) {
            this.n.setVisibility(0);
        }
    }

    public final void u() {
        this.k = false;
        e eVar = this.r;
        if (eVar != null) {
            eVar.a(false);
        }
        this.m.setOnTouchListener(this.i);
        this.m.setText(this.f22225g);
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
        this.f22223e = 1;
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

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22223e = 1;
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
