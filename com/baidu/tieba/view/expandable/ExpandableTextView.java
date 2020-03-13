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
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.view.h;
/* loaded from: classes.dex */
public class ExpandableTextView extends RelativeLayout {
    private TextView iXe;
    private boolean iXi;
    private SpannableStringBuilder iXl;
    private SpannableStringBuilder iXm;
    private View.OnTouchListener iXn;
    private View.OnTouchListener iXo;
    private f iXp;
    private boolean kJR;
    private boolean kJS;
    private SpannableClickTextView kJT;
    private int kJU;
    private int kJV;
    private int kJW;
    private a kJX;
    private boolean kJY;
    private ViewTreeObserver.OnGlobalLayoutListener kJZ;
    private f kKa;
    private View.OnClickListener kKb;
    private int textColor;
    private int textSize;
    private int type;

    /* loaded from: classes.dex */
    public interface a {
        void mm(boolean z);
    }

    public ExpandableTextView(Context context) {
        super(context);
        this.type = 1;
        this.kJR = true;
        this.kJS = false;
        this.iXi = false;
        this.kJU = 2;
        this.kJV = Integer.MAX_VALUE;
        this.kJY = false;
        this.kJZ = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.kJT != null && ExpandableTextView.this.iXl != null && ExpandableTextView.this.kJR && (layout = ExpandableTextView.this.kJT.getLayout()) != null) {
                    if (!ExpandableTextView.this.kJS) {
                        if (layout.getLineCount() > ExpandableTextView.this.kJU) {
                            if (ExpandableTextView.this.iXm == null) {
                                String spannableStringBuilder = ExpandableTextView.this.iXl.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.kJU - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.kJU - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.iXm = new SpannableStringBuilder();
                                ExpandableTextView.this.iXm.append((CharSequence) substring2);
                                ExpandableTextView.this.iXm.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.iXm.length();
                                for (Object obj : ExpandableTextView.this.iXl.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.iXl.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.iXl.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.iXm.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.iXm.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.iXp, 0, spannableString.length(), 17);
                                ExpandableTextView.this.iXm.append((CharSequence) spannableString);
                                ExpandableTextView.this.iXo = new h(ExpandableTextView.this.iXm);
                                ((h) ExpandableTextView.this.iXo).DW(R.color.transparent);
                            }
                            ExpandableTextView.this.iXe.setVisibility(8);
                            ExpandableTextView.this.kJT.setOnTouchListener(ExpandableTextView.this.iXo);
                            ExpandableTextView.this.kJT.setText(ExpandableTextView.this.iXm);
                            if (ExpandableTextView.this.kJY) {
                                ExpandableTextView.this.cTE();
                            }
                        }
                    } else if (!ExpandableTextView.this.iXi) {
                        ExpandableTextView.this.iXi = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.kKa, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.iXl.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.iXl.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.iXl.append((CharSequence) spannableString2);
                            }
                            ((h) ExpandableTextView.this.iXn).DW(R.color.transparent);
                            ExpandableTextView.this.kJT.setOnTouchListener(ExpandableTextView.this.iXn);
                            ExpandableTextView.this.kJT.setText(ExpandableTextView.this.iXl);
                            ExpandableTextView.this.iXe.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.iXe.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.iXe.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.iXe.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.iXp = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cTE();
            }
        };
        this.kKa = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cTF();
            }
        };
        this.kKb = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.cTF();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 1;
        this.kJR = true;
        this.kJS = false;
        this.iXi = false;
        this.kJU = 2;
        this.kJV = Integer.MAX_VALUE;
        this.kJY = false;
        this.kJZ = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.kJT != null && ExpandableTextView.this.iXl != null && ExpandableTextView.this.kJR && (layout = ExpandableTextView.this.kJT.getLayout()) != null) {
                    if (!ExpandableTextView.this.kJS) {
                        if (layout.getLineCount() > ExpandableTextView.this.kJU) {
                            if (ExpandableTextView.this.iXm == null) {
                                String spannableStringBuilder = ExpandableTextView.this.iXl.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.kJU - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.kJU - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.iXm = new SpannableStringBuilder();
                                ExpandableTextView.this.iXm.append((CharSequence) substring2);
                                ExpandableTextView.this.iXm.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.iXm.length();
                                for (Object obj : ExpandableTextView.this.iXl.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.iXl.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.iXl.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.iXm.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.iXm.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.iXp, 0, spannableString.length(), 17);
                                ExpandableTextView.this.iXm.append((CharSequence) spannableString);
                                ExpandableTextView.this.iXo = new h(ExpandableTextView.this.iXm);
                                ((h) ExpandableTextView.this.iXo).DW(R.color.transparent);
                            }
                            ExpandableTextView.this.iXe.setVisibility(8);
                            ExpandableTextView.this.kJT.setOnTouchListener(ExpandableTextView.this.iXo);
                            ExpandableTextView.this.kJT.setText(ExpandableTextView.this.iXm);
                            if (ExpandableTextView.this.kJY) {
                                ExpandableTextView.this.cTE();
                            }
                        }
                    } else if (!ExpandableTextView.this.iXi) {
                        ExpandableTextView.this.iXi = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.kKa, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.iXl.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.iXl.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.iXl.append((CharSequence) spannableString2);
                            }
                            ((h) ExpandableTextView.this.iXn).DW(R.color.transparent);
                            ExpandableTextView.this.kJT.setOnTouchListener(ExpandableTextView.this.iXn);
                            ExpandableTextView.this.kJT.setText(ExpandableTextView.this.iXl);
                            ExpandableTextView.this.iXe.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.iXe.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.iXe.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.iXe.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.iXp = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cTE();
            }
        };
        this.kKa = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cTF();
            }
        };
        this.kKb = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.cTF();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 1;
        this.kJR = true;
        this.kJS = false;
        this.iXi = false;
        this.kJU = 2;
        this.kJV = Integer.MAX_VALUE;
        this.kJY = false;
        this.kJZ = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.kJT != null && ExpandableTextView.this.iXl != null && ExpandableTextView.this.kJR && (layout = ExpandableTextView.this.kJT.getLayout()) != null) {
                    if (!ExpandableTextView.this.kJS) {
                        if (layout.getLineCount() > ExpandableTextView.this.kJU) {
                            if (ExpandableTextView.this.iXm == null) {
                                String spannableStringBuilder = ExpandableTextView.this.iXl.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.kJU - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.kJU - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.iXm = new SpannableStringBuilder();
                                ExpandableTextView.this.iXm.append((CharSequence) substring2);
                                ExpandableTextView.this.iXm.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.iXm.length();
                                for (Object obj : ExpandableTextView.this.iXl.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.iXl.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.iXl.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.iXm.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.iXm.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.iXp, 0, spannableString.length(), 17);
                                ExpandableTextView.this.iXm.append((CharSequence) spannableString);
                                ExpandableTextView.this.iXo = new h(ExpandableTextView.this.iXm);
                                ((h) ExpandableTextView.this.iXo).DW(R.color.transparent);
                            }
                            ExpandableTextView.this.iXe.setVisibility(8);
                            ExpandableTextView.this.kJT.setOnTouchListener(ExpandableTextView.this.iXo);
                            ExpandableTextView.this.kJT.setText(ExpandableTextView.this.iXm);
                            if (ExpandableTextView.this.kJY) {
                                ExpandableTextView.this.cTE();
                            }
                        }
                    } else if (!ExpandableTextView.this.iXi) {
                        ExpandableTextView.this.iXi = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.kKa, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.iXl.append((CharSequence) spannableString2);
                            } else {
                                int i2 = (lineEnd2 - lineEnd3) + 1;
                                for (int i22 = 0; i22 < i2; i22++) {
                                    ExpandableTextView.this.iXl.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.iXl.append((CharSequence) spannableString2);
                            }
                            ((h) ExpandableTextView.this.iXn).DW(R.color.transparent);
                            ExpandableTextView.this.kJT.setOnTouchListener(ExpandableTextView.this.iXn);
                            ExpandableTextView.this.kJT.setText(ExpandableTextView.this.iXl);
                            ExpandableTextView.this.iXe.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.iXe.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.iXe.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.iXe.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.iXp = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cTE();
            }
        };
        this.kKa = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cTF();
            }
        };
        this.kKb = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.cTF();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
        this.kJT = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
        this.kJT.setTextSize(0, TbConfig.getContentSize());
        this.kJT.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.iXe = (TextView) findViewById(R.id.expandable_view_title_up);
        this.iXe.setOnClickListener(this.kKb);
        this.textSize = l.getDimens(context, R.dimen.tbfontsize42);
        this.textColor = R.color.cp_cont_a;
        this.kJW = l.getDimens(context, R.dimen.tbds6);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.kJT.setTextSize(0, i);
        this.iXe.setTextSize(0, i);
    }

    public void setTextColor(int i) {
        this.textColor = i;
        am.setViewTextColor(this.kJT, this.textColor, 1);
    }

    public void setLineSpacingExtra(int i) {
        this.kJW = i;
        this.kJT.setLineSpacing(i, 1.0f);
        this.iXe.setLineSpacing(i, 1.0f);
    }

    public void setTextMaxLine(int i) {
        this.kJV = i;
    }

    public void setExpandable(boolean z) {
        this.kJR = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.kJT.getViewTreeObserver().removeGlobalOnLayoutListener(this.kJZ);
            } else {
                this.kJT.getViewTreeObserver().removeOnGlobalLayoutListener(this.kJZ);
            }
            this.kJT.setMaxLines(this.kJV);
            this.kJT.setEllipsize(TextUtils.TruncateAt.END);
            this.kJT.setText(this.iXl);
            this.kJT.setOnTouchListener(null);
            this.iXe.setVisibility(8);
            return;
        }
        this.kJT.getViewTreeObserver().addOnGlobalLayoutListener(this.kJZ);
        this.kJT.setMaxLines(Integer.MAX_VALUE);
        this.kJT.setEllipsize(null);
    }

    public void setExpandType(int i) {
        this.type = i;
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.iXe.setPadding(i, i2, i3, i4);
    }

    public void setData(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.kJY = z;
        this.iXl = new SpannableStringBuilder(charSequence);
        this.iXn = new h(this.iXl);
        this.kJT.setText(this.iXl);
        this.kJT.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        this.kJT.setOnTouchListener(this.iXn);
        am.setViewTextColor(this.kJT, this.textColor, 1);
    }

    public TextView getContentView() {
        return this.kJT;
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.kJT, this.textColor, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTE() {
        this.kJS = true;
        if (this.kJX != null) {
            this.kJX.mm(this.kJS);
        }
        this.kJT.setOnTouchListener(this.iXn);
        this.kJT.setText(this.iXl);
        if (this.type == 1) {
            this.iXe.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTF() {
        this.kJS = false;
        if (this.kJX != null) {
            this.kJX.mm(this.kJS);
        }
        this.kJT.setOnTouchListener(this.iXo);
        this.kJT.setText(this.iXm);
        this.iXe.setVisibility(8);
    }

    public void setOnStatusChangedListener(a aVar) {
        this.kJX = aVar;
    }
}
