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
    private TextView iVB;
    private boolean iVF;
    private SpannableStringBuilder iVI;
    private SpannableStringBuilder iVJ;
    private View.OnTouchListener iVK;
    private View.OnTouchListener iVL;
    private f iVM;
    private boolean kII;
    private boolean kIJ;
    private SpannableClickTextView kIK;
    private int kIL;
    private int kIM;
    private int kIN;
    private a kIO;
    private boolean kIP;
    private ViewTreeObserver.OnGlobalLayoutListener kIQ;
    private f kIR;
    private View.OnClickListener kIS;
    private int textColor;
    private int textSize;
    private int type;

    /* loaded from: classes.dex */
    public interface a {
        void mk(boolean z);
    }

    public ExpandableTextView(Context context) {
        super(context);
        this.type = 1;
        this.kII = true;
        this.kIJ = false;
        this.iVF = false;
        this.kIL = 2;
        this.kIM = Integer.MAX_VALUE;
        this.kIP = false;
        this.kIQ = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.kIK != null && ExpandableTextView.this.iVI != null && ExpandableTextView.this.kII && (layout = ExpandableTextView.this.kIK.getLayout()) != null) {
                    if (!ExpandableTextView.this.kIJ) {
                        if (layout.getLineCount() > ExpandableTextView.this.kIL) {
                            if (ExpandableTextView.this.iVJ == null) {
                                String spannableStringBuilder = ExpandableTextView.this.iVI.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.kIL - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.kIL - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.iVJ = new SpannableStringBuilder();
                                ExpandableTextView.this.iVJ.append((CharSequence) substring2);
                                ExpandableTextView.this.iVJ.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.iVJ.length();
                                for (Object obj : ExpandableTextView.this.iVI.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.iVI.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.iVI.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.iVJ.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.iVJ.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.iVM, 0, spannableString.length(), 17);
                                ExpandableTextView.this.iVJ.append((CharSequence) spannableString);
                                ExpandableTextView.this.iVL = new h(ExpandableTextView.this.iVJ);
                                ((h) ExpandableTextView.this.iVL).DQ(R.color.transparent);
                            }
                            ExpandableTextView.this.iVB.setVisibility(8);
                            ExpandableTextView.this.kIK.setOnTouchListener(ExpandableTextView.this.iVL);
                            ExpandableTextView.this.kIK.setText(ExpandableTextView.this.iVJ);
                            if (ExpandableTextView.this.kIP) {
                                ExpandableTextView.this.cSg();
                            }
                        }
                    } else if (!ExpandableTextView.this.iVF) {
                        ExpandableTextView.this.iVF = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.kIR, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.iVI.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.iVI.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.iVI.append((CharSequence) spannableString2);
                            }
                            ((h) ExpandableTextView.this.iVK).DQ(R.color.transparent);
                            ExpandableTextView.this.kIK.setOnTouchListener(ExpandableTextView.this.iVK);
                            ExpandableTextView.this.kIK.setText(ExpandableTextView.this.iVI);
                            ExpandableTextView.this.iVB.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.iVB.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.iVB.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.iVB.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.iVM = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cSg();
            }
        };
        this.kIR = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cSh();
            }
        };
        this.kIS = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.cSh();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 1;
        this.kII = true;
        this.kIJ = false;
        this.iVF = false;
        this.kIL = 2;
        this.kIM = Integer.MAX_VALUE;
        this.kIP = false;
        this.kIQ = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.kIK != null && ExpandableTextView.this.iVI != null && ExpandableTextView.this.kII && (layout = ExpandableTextView.this.kIK.getLayout()) != null) {
                    if (!ExpandableTextView.this.kIJ) {
                        if (layout.getLineCount() > ExpandableTextView.this.kIL) {
                            if (ExpandableTextView.this.iVJ == null) {
                                String spannableStringBuilder = ExpandableTextView.this.iVI.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.kIL - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.kIL - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.iVJ = new SpannableStringBuilder();
                                ExpandableTextView.this.iVJ.append((CharSequence) substring2);
                                ExpandableTextView.this.iVJ.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.iVJ.length();
                                for (Object obj : ExpandableTextView.this.iVI.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.iVI.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.iVI.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.iVJ.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.iVJ.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.iVM, 0, spannableString.length(), 17);
                                ExpandableTextView.this.iVJ.append((CharSequence) spannableString);
                                ExpandableTextView.this.iVL = new h(ExpandableTextView.this.iVJ);
                                ((h) ExpandableTextView.this.iVL).DQ(R.color.transparent);
                            }
                            ExpandableTextView.this.iVB.setVisibility(8);
                            ExpandableTextView.this.kIK.setOnTouchListener(ExpandableTextView.this.iVL);
                            ExpandableTextView.this.kIK.setText(ExpandableTextView.this.iVJ);
                            if (ExpandableTextView.this.kIP) {
                                ExpandableTextView.this.cSg();
                            }
                        }
                    } else if (!ExpandableTextView.this.iVF) {
                        ExpandableTextView.this.iVF = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.kIR, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.iVI.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.iVI.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.iVI.append((CharSequence) spannableString2);
                            }
                            ((h) ExpandableTextView.this.iVK).DQ(R.color.transparent);
                            ExpandableTextView.this.kIK.setOnTouchListener(ExpandableTextView.this.iVK);
                            ExpandableTextView.this.kIK.setText(ExpandableTextView.this.iVI);
                            ExpandableTextView.this.iVB.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.iVB.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.iVB.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.iVB.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.iVM = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cSg();
            }
        };
        this.kIR = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cSh();
            }
        };
        this.kIS = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.cSh();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 1;
        this.kII = true;
        this.kIJ = false;
        this.iVF = false;
        this.kIL = 2;
        this.kIM = Integer.MAX_VALUE;
        this.kIP = false;
        this.kIQ = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.kIK != null && ExpandableTextView.this.iVI != null && ExpandableTextView.this.kII && (layout = ExpandableTextView.this.kIK.getLayout()) != null) {
                    if (!ExpandableTextView.this.kIJ) {
                        if (layout.getLineCount() > ExpandableTextView.this.kIL) {
                            if (ExpandableTextView.this.iVJ == null) {
                                String spannableStringBuilder = ExpandableTextView.this.iVI.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.kIL - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.kIL - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.iVJ = new SpannableStringBuilder();
                                ExpandableTextView.this.iVJ.append((CharSequence) substring2);
                                ExpandableTextView.this.iVJ.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.iVJ.length();
                                for (Object obj : ExpandableTextView.this.iVI.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.iVI.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.iVI.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.iVJ.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.iVJ.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.iVM, 0, spannableString.length(), 17);
                                ExpandableTextView.this.iVJ.append((CharSequence) spannableString);
                                ExpandableTextView.this.iVL = new h(ExpandableTextView.this.iVJ);
                                ((h) ExpandableTextView.this.iVL).DQ(R.color.transparent);
                            }
                            ExpandableTextView.this.iVB.setVisibility(8);
                            ExpandableTextView.this.kIK.setOnTouchListener(ExpandableTextView.this.iVL);
                            ExpandableTextView.this.kIK.setText(ExpandableTextView.this.iVJ);
                            if (ExpandableTextView.this.kIP) {
                                ExpandableTextView.this.cSg();
                            }
                        }
                    } else if (!ExpandableTextView.this.iVF) {
                        ExpandableTextView.this.iVF = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.kIR, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.iVI.append((CharSequence) spannableString2);
                            } else {
                                int i2 = (lineEnd2 - lineEnd3) + 1;
                                for (int i22 = 0; i22 < i2; i22++) {
                                    ExpandableTextView.this.iVI.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.iVI.append((CharSequence) spannableString2);
                            }
                            ((h) ExpandableTextView.this.iVK).DQ(R.color.transparent);
                            ExpandableTextView.this.kIK.setOnTouchListener(ExpandableTextView.this.iVK);
                            ExpandableTextView.this.kIK.setText(ExpandableTextView.this.iVI);
                            ExpandableTextView.this.iVB.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.iVB.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.iVB.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.iVB.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.iVM = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cSg();
            }
        };
        this.kIR = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cSh();
            }
        };
        this.kIS = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.cSh();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
        this.kIK = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
        this.kIK.setTextSize(0, TbConfig.getContentSize());
        this.kIK.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.iVB = (TextView) findViewById(R.id.expandable_view_title_up);
        this.iVB.setOnClickListener(this.kIS);
        this.textSize = l.getDimens(context, R.dimen.tbfontsize42);
        this.textColor = R.color.cp_cont_a;
        this.kIN = l.getDimens(context, R.dimen.tbds6);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.kIK.setTextSize(0, i);
        this.iVB.setTextSize(0, i);
    }

    public void setTextColor(int i) {
        this.textColor = i;
        am.setViewTextColor(this.kIK, this.textColor, 1);
    }

    public void setLineSpacingExtra(int i) {
        this.kIN = i;
        this.kIK.setLineSpacing(i, 1.0f);
        this.iVB.setLineSpacing(i, 1.0f);
    }

    public void setTextMaxLine(int i) {
        this.kIM = i;
    }

    public void setExpandable(boolean z) {
        this.kII = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.kIK.getViewTreeObserver().removeGlobalOnLayoutListener(this.kIQ);
            } else {
                this.kIK.getViewTreeObserver().removeOnGlobalLayoutListener(this.kIQ);
            }
            this.kIK.setMaxLines(this.kIM);
            this.kIK.setEllipsize(TextUtils.TruncateAt.END);
            this.kIK.setText(this.iVI);
            this.kIK.setOnTouchListener(null);
            this.iVB.setVisibility(8);
            return;
        }
        this.kIK.getViewTreeObserver().addOnGlobalLayoutListener(this.kIQ);
        this.kIK.setMaxLines(Integer.MAX_VALUE);
        this.kIK.setEllipsize(null);
    }

    public void setExpandType(int i) {
        this.type = i;
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.iVB.setPadding(i, i2, i3, i4);
    }

    public void setData(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.kIP = z;
        this.iVI = new SpannableStringBuilder(charSequence);
        this.iVK = new h(this.iVI);
        this.kIK.setText(this.iVI);
        this.kIK.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        this.kIK.setOnTouchListener(this.iVK);
        am.setViewTextColor(this.kIK, this.textColor, 1);
    }

    public TextView getContentView() {
        return this.kIK;
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.kIK, this.textColor, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSg() {
        this.kIJ = true;
        if (this.kIO != null) {
            this.kIO.mk(this.kIJ);
        }
        this.kIK.setOnTouchListener(this.iVK);
        this.kIK.setText(this.iVI);
        if (this.type == 1) {
            this.iVB.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSh() {
        this.kIJ = false;
        if (this.kIO != null) {
            this.kIO.mk(this.kIJ);
        }
        this.kIK.setOnTouchListener(this.iVL);
        this.kIK.setText(this.iVJ);
        this.iVB.setVisibility(8);
    }

    public void setOnStatusChangedListener(a aVar) {
        this.kIO = aVar;
    }
}
