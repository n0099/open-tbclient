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
    private boolean iVA;
    private SpannableStringBuilder iVD;
    private SpannableStringBuilder iVE;
    private View.OnTouchListener iVF;
    private View.OnTouchListener iVG;
    private f iVH;
    private TextView iVw;
    private boolean kID;
    private boolean kIE;
    private SpannableClickTextView kIF;
    private int kIG;
    private int kIH;
    private int kII;
    private a kIJ;
    private boolean kIK;
    private ViewTreeObserver.OnGlobalLayoutListener kIL;
    private f kIM;
    private View.OnClickListener kIN;
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
        this.kID = true;
        this.kIE = false;
        this.iVA = false;
        this.kIG = 2;
        this.kIH = Integer.MAX_VALUE;
        this.kIK = false;
        this.kIL = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.kIF != null && ExpandableTextView.this.iVD != null && ExpandableTextView.this.kID && (layout = ExpandableTextView.this.kIF.getLayout()) != null) {
                    if (!ExpandableTextView.this.kIE) {
                        if (layout.getLineCount() > ExpandableTextView.this.kIG) {
                            if (ExpandableTextView.this.iVE == null) {
                                String spannableStringBuilder = ExpandableTextView.this.iVD.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.kIG - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.kIG - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.iVE = new SpannableStringBuilder();
                                ExpandableTextView.this.iVE.append((CharSequence) substring2);
                                ExpandableTextView.this.iVE.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.iVE.length();
                                for (Object obj : ExpandableTextView.this.iVD.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.iVD.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.iVD.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.iVE.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.iVE.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.iVH, 0, spannableString.length(), 17);
                                ExpandableTextView.this.iVE.append((CharSequence) spannableString);
                                ExpandableTextView.this.iVG = new h(ExpandableTextView.this.iVE);
                                ((h) ExpandableTextView.this.iVG).DQ(R.color.transparent);
                            }
                            ExpandableTextView.this.iVw.setVisibility(8);
                            ExpandableTextView.this.kIF.setOnTouchListener(ExpandableTextView.this.iVG);
                            ExpandableTextView.this.kIF.setText(ExpandableTextView.this.iVE);
                            if (ExpandableTextView.this.kIK) {
                                ExpandableTextView.this.cSe();
                            }
                        }
                    } else if (!ExpandableTextView.this.iVA) {
                        ExpandableTextView.this.iVA = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.kIM, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.iVD.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.iVD.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.iVD.append((CharSequence) spannableString2);
                            }
                            ((h) ExpandableTextView.this.iVF).DQ(R.color.transparent);
                            ExpandableTextView.this.kIF.setOnTouchListener(ExpandableTextView.this.iVF);
                            ExpandableTextView.this.kIF.setText(ExpandableTextView.this.iVD);
                            ExpandableTextView.this.iVw.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.iVw.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.iVw.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.iVw.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.iVH = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cSe();
            }
        };
        this.kIM = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cSf();
            }
        };
        this.kIN = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.cSf();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 1;
        this.kID = true;
        this.kIE = false;
        this.iVA = false;
        this.kIG = 2;
        this.kIH = Integer.MAX_VALUE;
        this.kIK = false;
        this.kIL = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.kIF != null && ExpandableTextView.this.iVD != null && ExpandableTextView.this.kID && (layout = ExpandableTextView.this.kIF.getLayout()) != null) {
                    if (!ExpandableTextView.this.kIE) {
                        if (layout.getLineCount() > ExpandableTextView.this.kIG) {
                            if (ExpandableTextView.this.iVE == null) {
                                String spannableStringBuilder = ExpandableTextView.this.iVD.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.kIG - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.kIG - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.iVE = new SpannableStringBuilder();
                                ExpandableTextView.this.iVE.append((CharSequence) substring2);
                                ExpandableTextView.this.iVE.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.iVE.length();
                                for (Object obj : ExpandableTextView.this.iVD.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.iVD.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.iVD.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.iVE.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.iVE.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.iVH, 0, spannableString.length(), 17);
                                ExpandableTextView.this.iVE.append((CharSequence) spannableString);
                                ExpandableTextView.this.iVG = new h(ExpandableTextView.this.iVE);
                                ((h) ExpandableTextView.this.iVG).DQ(R.color.transparent);
                            }
                            ExpandableTextView.this.iVw.setVisibility(8);
                            ExpandableTextView.this.kIF.setOnTouchListener(ExpandableTextView.this.iVG);
                            ExpandableTextView.this.kIF.setText(ExpandableTextView.this.iVE);
                            if (ExpandableTextView.this.kIK) {
                                ExpandableTextView.this.cSe();
                            }
                        }
                    } else if (!ExpandableTextView.this.iVA) {
                        ExpandableTextView.this.iVA = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.kIM, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.iVD.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.iVD.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.iVD.append((CharSequence) spannableString2);
                            }
                            ((h) ExpandableTextView.this.iVF).DQ(R.color.transparent);
                            ExpandableTextView.this.kIF.setOnTouchListener(ExpandableTextView.this.iVF);
                            ExpandableTextView.this.kIF.setText(ExpandableTextView.this.iVD);
                            ExpandableTextView.this.iVw.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.iVw.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.iVw.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.iVw.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.iVH = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cSe();
            }
        };
        this.kIM = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cSf();
            }
        };
        this.kIN = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.cSf();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 1;
        this.kID = true;
        this.kIE = false;
        this.iVA = false;
        this.kIG = 2;
        this.kIH = Integer.MAX_VALUE;
        this.kIK = false;
        this.kIL = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.kIF != null && ExpandableTextView.this.iVD != null && ExpandableTextView.this.kID && (layout = ExpandableTextView.this.kIF.getLayout()) != null) {
                    if (!ExpandableTextView.this.kIE) {
                        if (layout.getLineCount() > ExpandableTextView.this.kIG) {
                            if (ExpandableTextView.this.iVE == null) {
                                String spannableStringBuilder = ExpandableTextView.this.iVD.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.kIG - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.kIG - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.iVE = new SpannableStringBuilder();
                                ExpandableTextView.this.iVE.append((CharSequence) substring2);
                                ExpandableTextView.this.iVE.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.iVE.length();
                                for (Object obj : ExpandableTextView.this.iVD.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.iVD.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.iVD.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.iVE.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.iVE.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.iVH, 0, spannableString.length(), 17);
                                ExpandableTextView.this.iVE.append((CharSequence) spannableString);
                                ExpandableTextView.this.iVG = new h(ExpandableTextView.this.iVE);
                                ((h) ExpandableTextView.this.iVG).DQ(R.color.transparent);
                            }
                            ExpandableTextView.this.iVw.setVisibility(8);
                            ExpandableTextView.this.kIF.setOnTouchListener(ExpandableTextView.this.iVG);
                            ExpandableTextView.this.kIF.setText(ExpandableTextView.this.iVE);
                            if (ExpandableTextView.this.kIK) {
                                ExpandableTextView.this.cSe();
                            }
                        }
                    } else if (!ExpandableTextView.this.iVA) {
                        ExpandableTextView.this.iVA = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.kIM, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.iVD.append((CharSequence) spannableString2);
                            } else {
                                int i2 = (lineEnd2 - lineEnd3) + 1;
                                for (int i22 = 0; i22 < i2; i22++) {
                                    ExpandableTextView.this.iVD.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.iVD.append((CharSequence) spannableString2);
                            }
                            ((h) ExpandableTextView.this.iVF).DQ(R.color.transparent);
                            ExpandableTextView.this.kIF.setOnTouchListener(ExpandableTextView.this.iVF);
                            ExpandableTextView.this.kIF.setText(ExpandableTextView.this.iVD);
                            ExpandableTextView.this.iVw.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.iVw.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.iVw.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.iVw.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.iVH = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cSe();
            }
        };
        this.kIM = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cSf();
            }
        };
        this.kIN = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.cSf();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
        this.kIF = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
        this.kIF.setTextSize(0, TbConfig.getContentSize());
        this.kIF.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.iVw = (TextView) findViewById(R.id.expandable_view_title_up);
        this.iVw.setOnClickListener(this.kIN);
        this.textSize = l.getDimens(context, R.dimen.tbfontsize42);
        this.textColor = R.color.cp_cont_a;
        this.kII = l.getDimens(context, R.dimen.tbds6);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.kIF.setTextSize(0, i);
        this.iVw.setTextSize(0, i);
    }

    public void setTextColor(int i) {
        this.textColor = i;
        am.setViewTextColor(this.kIF, this.textColor, 1);
    }

    public void setLineSpacingExtra(int i) {
        this.kII = i;
        this.kIF.setLineSpacing(i, 1.0f);
        this.iVw.setLineSpacing(i, 1.0f);
    }

    public void setTextMaxLine(int i) {
        this.kIH = i;
    }

    public void setExpandable(boolean z) {
        this.kID = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.kIF.getViewTreeObserver().removeGlobalOnLayoutListener(this.kIL);
            } else {
                this.kIF.getViewTreeObserver().removeOnGlobalLayoutListener(this.kIL);
            }
            this.kIF.setMaxLines(this.kIH);
            this.kIF.setEllipsize(TextUtils.TruncateAt.END);
            this.kIF.setText(this.iVD);
            this.kIF.setOnTouchListener(null);
            this.iVw.setVisibility(8);
            return;
        }
        this.kIF.getViewTreeObserver().addOnGlobalLayoutListener(this.kIL);
        this.kIF.setMaxLines(Integer.MAX_VALUE);
        this.kIF.setEllipsize(null);
    }

    public void setExpandType(int i) {
        this.type = i;
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.iVw.setPadding(i, i2, i3, i4);
    }

    public void setData(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.kIK = z;
        this.iVD = new SpannableStringBuilder(charSequence);
        this.iVF = new h(this.iVD);
        this.kIF.setText(this.iVD);
        this.kIF.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        this.kIF.setOnTouchListener(this.iVF);
        am.setViewTextColor(this.kIF, this.textColor, 1);
    }

    public TextView getContentView() {
        return this.kIF;
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.kIF, this.textColor, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSe() {
        this.kIE = true;
        if (this.kIJ != null) {
            this.kIJ.mk(this.kIE);
        }
        this.kIF.setOnTouchListener(this.iVF);
        this.kIF.setText(this.iVD);
        if (this.type == 1) {
            this.iVw.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSf() {
        this.kIE = false;
        if (this.kIJ != null) {
            this.kIJ.mk(this.kIE);
        }
        this.kIF.setOnTouchListener(this.iVG);
        this.kIF.setText(this.iVE);
        this.iVw.setVisibility(8);
    }

    public void setOnStatusChangedListener(a aVar) {
        this.kIJ = aVar;
    }
}
