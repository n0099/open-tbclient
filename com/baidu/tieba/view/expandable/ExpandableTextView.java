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
    private TextView iYF;
    private boolean iYJ;
    private SpannableStringBuilder iYM;
    private SpannableStringBuilder iYN;
    private View.OnTouchListener iYO;
    private View.OnTouchListener iYP;
    private f iYQ;
    private SpannableClickTextView kLA;
    private int kLB;
    private int kLC;
    private int kLD;
    private a kLE;
    private boolean kLF;
    private ViewTreeObserver.OnGlobalLayoutListener kLG;
    private f kLH;
    private View.OnClickListener kLI;
    private boolean kLy;
    private boolean kLz;
    private int textColor;
    private int textSize;
    private int type;

    /* loaded from: classes.dex */
    public interface a {
        void ms(boolean z);
    }

    public ExpandableTextView(Context context) {
        super(context);
        this.type = 1;
        this.kLy = true;
        this.kLz = false;
        this.iYJ = false;
        this.kLB = 2;
        this.kLC = Integer.MAX_VALUE;
        this.kLF = false;
        this.kLG = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.kLA != null && ExpandableTextView.this.iYM != null && ExpandableTextView.this.kLy && (layout = ExpandableTextView.this.kLA.getLayout()) != null) {
                    if (!ExpandableTextView.this.kLz) {
                        if (layout.getLineCount() > ExpandableTextView.this.kLB) {
                            if (ExpandableTextView.this.iYN == null) {
                                String spannableStringBuilder = ExpandableTextView.this.iYM.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.kLB - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.kLB - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.iYN = new SpannableStringBuilder();
                                ExpandableTextView.this.iYN.append((CharSequence) substring2);
                                ExpandableTextView.this.iYN.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.iYN.length();
                                for (Object obj : ExpandableTextView.this.iYM.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.iYM.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.iYM.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.iYN.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.iYN.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.iYQ, 0, spannableString.length(), 17);
                                ExpandableTextView.this.iYN.append((CharSequence) spannableString);
                                ExpandableTextView.this.iYP = new h(ExpandableTextView.this.iYN);
                                ((h) ExpandableTextView.this.iYP).Ee(R.color.transparent);
                            }
                            ExpandableTextView.this.iYF.setVisibility(8);
                            ExpandableTextView.this.kLA.setOnTouchListener(ExpandableTextView.this.iYP);
                            ExpandableTextView.this.kLA.setText(ExpandableTextView.this.iYN);
                            if (ExpandableTextView.this.kLF) {
                                ExpandableTextView.this.cTY();
                            }
                        }
                    } else if (!ExpandableTextView.this.iYJ) {
                        ExpandableTextView.this.iYJ = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.kLH, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.iYM.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.iYM.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.iYM.append((CharSequence) spannableString2);
                            }
                            ((h) ExpandableTextView.this.iYO).Ee(R.color.transparent);
                            ExpandableTextView.this.kLA.setOnTouchListener(ExpandableTextView.this.iYO);
                            ExpandableTextView.this.kLA.setText(ExpandableTextView.this.iYM);
                            ExpandableTextView.this.iYF.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.iYF.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.iYF.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.iYF.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.iYQ = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cTY();
            }
        };
        this.kLH = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cTZ();
            }
        };
        this.kLI = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.cTZ();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 1;
        this.kLy = true;
        this.kLz = false;
        this.iYJ = false;
        this.kLB = 2;
        this.kLC = Integer.MAX_VALUE;
        this.kLF = false;
        this.kLG = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.kLA != null && ExpandableTextView.this.iYM != null && ExpandableTextView.this.kLy && (layout = ExpandableTextView.this.kLA.getLayout()) != null) {
                    if (!ExpandableTextView.this.kLz) {
                        if (layout.getLineCount() > ExpandableTextView.this.kLB) {
                            if (ExpandableTextView.this.iYN == null) {
                                String spannableStringBuilder = ExpandableTextView.this.iYM.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.kLB - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.kLB - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.iYN = new SpannableStringBuilder();
                                ExpandableTextView.this.iYN.append((CharSequence) substring2);
                                ExpandableTextView.this.iYN.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.iYN.length();
                                for (Object obj : ExpandableTextView.this.iYM.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.iYM.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.iYM.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.iYN.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.iYN.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.iYQ, 0, spannableString.length(), 17);
                                ExpandableTextView.this.iYN.append((CharSequence) spannableString);
                                ExpandableTextView.this.iYP = new h(ExpandableTextView.this.iYN);
                                ((h) ExpandableTextView.this.iYP).Ee(R.color.transparent);
                            }
                            ExpandableTextView.this.iYF.setVisibility(8);
                            ExpandableTextView.this.kLA.setOnTouchListener(ExpandableTextView.this.iYP);
                            ExpandableTextView.this.kLA.setText(ExpandableTextView.this.iYN);
                            if (ExpandableTextView.this.kLF) {
                                ExpandableTextView.this.cTY();
                            }
                        }
                    } else if (!ExpandableTextView.this.iYJ) {
                        ExpandableTextView.this.iYJ = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.kLH, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.iYM.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.iYM.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.iYM.append((CharSequence) spannableString2);
                            }
                            ((h) ExpandableTextView.this.iYO).Ee(R.color.transparent);
                            ExpandableTextView.this.kLA.setOnTouchListener(ExpandableTextView.this.iYO);
                            ExpandableTextView.this.kLA.setText(ExpandableTextView.this.iYM);
                            ExpandableTextView.this.iYF.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.iYF.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.iYF.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.iYF.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.iYQ = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cTY();
            }
        };
        this.kLH = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cTZ();
            }
        };
        this.kLI = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.cTZ();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 1;
        this.kLy = true;
        this.kLz = false;
        this.iYJ = false;
        this.kLB = 2;
        this.kLC = Integer.MAX_VALUE;
        this.kLF = false;
        this.kLG = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.kLA != null && ExpandableTextView.this.iYM != null && ExpandableTextView.this.kLy && (layout = ExpandableTextView.this.kLA.getLayout()) != null) {
                    if (!ExpandableTextView.this.kLz) {
                        if (layout.getLineCount() > ExpandableTextView.this.kLB) {
                            if (ExpandableTextView.this.iYN == null) {
                                String spannableStringBuilder = ExpandableTextView.this.iYM.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.kLB - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.kLB - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.iYN = new SpannableStringBuilder();
                                ExpandableTextView.this.iYN.append((CharSequence) substring2);
                                ExpandableTextView.this.iYN.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.iYN.length();
                                for (Object obj : ExpandableTextView.this.iYM.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.iYM.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.iYM.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.iYN.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.iYN.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.iYQ, 0, spannableString.length(), 17);
                                ExpandableTextView.this.iYN.append((CharSequence) spannableString);
                                ExpandableTextView.this.iYP = new h(ExpandableTextView.this.iYN);
                                ((h) ExpandableTextView.this.iYP).Ee(R.color.transparent);
                            }
                            ExpandableTextView.this.iYF.setVisibility(8);
                            ExpandableTextView.this.kLA.setOnTouchListener(ExpandableTextView.this.iYP);
                            ExpandableTextView.this.kLA.setText(ExpandableTextView.this.iYN);
                            if (ExpandableTextView.this.kLF) {
                                ExpandableTextView.this.cTY();
                            }
                        }
                    } else if (!ExpandableTextView.this.iYJ) {
                        ExpandableTextView.this.iYJ = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.kLH, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.iYM.append((CharSequence) spannableString2);
                            } else {
                                int i2 = (lineEnd2 - lineEnd3) + 1;
                                for (int i22 = 0; i22 < i2; i22++) {
                                    ExpandableTextView.this.iYM.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.iYM.append((CharSequence) spannableString2);
                            }
                            ((h) ExpandableTextView.this.iYO).Ee(R.color.transparent);
                            ExpandableTextView.this.kLA.setOnTouchListener(ExpandableTextView.this.iYO);
                            ExpandableTextView.this.kLA.setText(ExpandableTextView.this.iYM);
                            ExpandableTextView.this.iYF.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.iYF.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.iYF.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.iYF.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.iYQ = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cTY();
            }
        };
        this.kLH = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cTZ();
            }
        };
        this.kLI = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.cTZ();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
        this.kLA = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
        this.kLA.setTextSize(0, TbConfig.getContentSize());
        this.kLA.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.iYF = (TextView) findViewById(R.id.expandable_view_title_up);
        this.iYF.setOnClickListener(this.kLI);
        this.textSize = l.getDimens(context, R.dimen.tbfontsize42);
        this.textColor = R.color.cp_cont_a;
        this.kLD = l.getDimens(context, R.dimen.tbds6);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.kLA.setTextSize(0, i);
        this.iYF.setTextSize(0, i);
    }

    public void setTextColor(int i) {
        this.textColor = i;
        am.setViewTextColor(this.kLA, this.textColor, 1);
    }

    public void setLineSpacingExtra(int i) {
        this.kLD = i;
        this.kLA.setLineSpacing(i, 1.0f);
        this.iYF.setLineSpacing(i, 1.0f);
    }

    public void setTextMaxLine(int i) {
        this.kLC = i;
    }

    public void setExpandable(boolean z) {
        this.kLy = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.kLA.getViewTreeObserver().removeGlobalOnLayoutListener(this.kLG);
            } else {
                this.kLA.getViewTreeObserver().removeOnGlobalLayoutListener(this.kLG);
            }
            this.kLA.setMaxLines(this.kLC);
            this.kLA.setEllipsize(TextUtils.TruncateAt.END);
            this.kLA.setText(this.iYM);
            this.kLA.setOnTouchListener(null);
            this.iYF.setVisibility(8);
            return;
        }
        this.kLA.getViewTreeObserver().addOnGlobalLayoutListener(this.kLG);
        this.kLA.setMaxLines(Integer.MAX_VALUE);
        this.kLA.setEllipsize(null);
    }

    public void setExpandType(int i) {
        this.type = i;
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.iYF.setPadding(i, i2, i3, i4);
    }

    public void setData(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.kLF = z;
        this.iYM = new SpannableStringBuilder(charSequence);
        this.iYO = new h(this.iYM);
        this.kLA.setText(this.iYM);
        this.kLA.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        this.kLA.setOnTouchListener(this.iYO);
        am.setViewTextColor(this.kLA, this.textColor, 1);
    }

    public TextView getContentView() {
        return this.kLA;
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.kLA, this.textColor, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTY() {
        this.kLz = true;
        if (this.kLE != null) {
            this.kLE.ms(this.kLz);
        }
        this.kLA.setOnTouchListener(this.iYO);
        this.kLA.setText(this.iYM);
        if (this.type == 1) {
            this.iYF.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTZ() {
        this.kLz = false;
        if (this.kLE != null) {
            this.kLE.ms(this.kLz);
        }
        this.kLA.setOnTouchListener(this.iYP);
        this.kLA.setText(this.iYN);
        this.iYF.setVisibility(8);
    }

    public void setOnStatusChangedListener(a aVar) {
        this.kLE = aVar;
    }
}
