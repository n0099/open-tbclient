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
    private TextView iWQ;
    private boolean iWU;
    private SpannableStringBuilder iWX;
    private SpannableStringBuilder iWY;
    private View.OnTouchListener iWZ;
    private View.OnTouchListener iXa;
    private f iXb;
    private boolean kJD;
    private boolean kJE;
    private SpannableClickTextView kJF;
    private int kJG;
    private int kJH;
    private int kJI;
    private a kJJ;
    private boolean kJK;
    private ViewTreeObserver.OnGlobalLayoutListener kJL;
    private f kJM;
    private View.OnClickListener kJN;
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
        this.kJD = true;
        this.kJE = false;
        this.iWU = false;
        this.kJG = 2;
        this.kJH = Integer.MAX_VALUE;
        this.kJK = false;
        this.kJL = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.kJF != null && ExpandableTextView.this.iWX != null && ExpandableTextView.this.kJD && (layout = ExpandableTextView.this.kJF.getLayout()) != null) {
                    if (!ExpandableTextView.this.kJE) {
                        if (layout.getLineCount() > ExpandableTextView.this.kJG) {
                            if (ExpandableTextView.this.iWY == null) {
                                String spannableStringBuilder = ExpandableTextView.this.iWX.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.kJG - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.kJG - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.iWY = new SpannableStringBuilder();
                                ExpandableTextView.this.iWY.append((CharSequence) substring2);
                                ExpandableTextView.this.iWY.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.iWY.length();
                                for (Object obj : ExpandableTextView.this.iWX.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.iWX.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.iWX.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.iWY.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.iWY.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.iXb, 0, spannableString.length(), 17);
                                ExpandableTextView.this.iWY.append((CharSequence) spannableString);
                                ExpandableTextView.this.iXa = new h(ExpandableTextView.this.iWY);
                                ((h) ExpandableTextView.this.iXa).DW(R.color.transparent);
                            }
                            ExpandableTextView.this.iWQ.setVisibility(8);
                            ExpandableTextView.this.kJF.setOnTouchListener(ExpandableTextView.this.iXa);
                            ExpandableTextView.this.kJF.setText(ExpandableTextView.this.iWY);
                            if (ExpandableTextView.this.kJK) {
                                ExpandableTextView.this.cTB();
                            }
                        }
                    } else if (!ExpandableTextView.this.iWU) {
                        ExpandableTextView.this.iWU = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.kJM, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.iWX.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.iWX.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.iWX.append((CharSequence) spannableString2);
                            }
                            ((h) ExpandableTextView.this.iWZ).DW(R.color.transparent);
                            ExpandableTextView.this.kJF.setOnTouchListener(ExpandableTextView.this.iWZ);
                            ExpandableTextView.this.kJF.setText(ExpandableTextView.this.iWX);
                            ExpandableTextView.this.iWQ.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.iWQ.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.iWQ.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.iWQ.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.iXb = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cTB();
            }
        };
        this.kJM = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cTC();
            }
        };
        this.kJN = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.cTC();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 1;
        this.kJD = true;
        this.kJE = false;
        this.iWU = false;
        this.kJG = 2;
        this.kJH = Integer.MAX_VALUE;
        this.kJK = false;
        this.kJL = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.kJF != null && ExpandableTextView.this.iWX != null && ExpandableTextView.this.kJD && (layout = ExpandableTextView.this.kJF.getLayout()) != null) {
                    if (!ExpandableTextView.this.kJE) {
                        if (layout.getLineCount() > ExpandableTextView.this.kJG) {
                            if (ExpandableTextView.this.iWY == null) {
                                String spannableStringBuilder = ExpandableTextView.this.iWX.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.kJG - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.kJG - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.iWY = new SpannableStringBuilder();
                                ExpandableTextView.this.iWY.append((CharSequence) substring2);
                                ExpandableTextView.this.iWY.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.iWY.length();
                                for (Object obj : ExpandableTextView.this.iWX.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.iWX.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.iWX.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.iWY.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.iWY.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.iXb, 0, spannableString.length(), 17);
                                ExpandableTextView.this.iWY.append((CharSequence) spannableString);
                                ExpandableTextView.this.iXa = new h(ExpandableTextView.this.iWY);
                                ((h) ExpandableTextView.this.iXa).DW(R.color.transparent);
                            }
                            ExpandableTextView.this.iWQ.setVisibility(8);
                            ExpandableTextView.this.kJF.setOnTouchListener(ExpandableTextView.this.iXa);
                            ExpandableTextView.this.kJF.setText(ExpandableTextView.this.iWY);
                            if (ExpandableTextView.this.kJK) {
                                ExpandableTextView.this.cTB();
                            }
                        }
                    } else if (!ExpandableTextView.this.iWU) {
                        ExpandableTextView.this.iWU = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.kJM, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.iWX.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.iWX.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.iWX.append((CharSequence) spannableString2);
                            }
                            ((h) ExpandableTextView.this.iWZ).DW(R.color.transparent);
                            ExpandableTextView.this.kJF.setOnTouchListener(ExpandableTextView.this.iWZ);
                            ExpandableTextView.this.kJF.setText(ExpandableTextView.this.iWX);
                            ExpandableTextView.this.iWQ.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.iWQ.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.iWQ.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.iWQ.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.iXb = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cTB();
            }
        };
        this.kJM = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cTC();
            }
        };
        this.kJN = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.cTC();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 1;
        this.kJD = true;
        this.kJE = false;
        this.iWU = false;
        this.kJG = 2;
        this.kJH = Integer.MAX_VALUE;
        this.kJK = false;
        this.kJL = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.kJF != null && ExpandableTextView.this.iWX != null && ExpandableTextView.this.kJD && (layout = ExpandableTextView.this.kJF.getLayout()) != null) {
                    if (!ExpandableTextView.this.kJE) {
                        if (layout.getLineCount() > ExpandableTextView.this.kJG) {
                            if (ExpandableTextView.this.iWY == null) {
                                String spannableStringBuilder = ExpandableTextView.this.iWX.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.kJG - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.kJG - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.iWY = new SpannableStringBuilder();
                                ExpandableTextView.this.iWY.append((CharSequence) substring2);
                                ExpandableTextView.this.iWY.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.iWY.length();
                                for (Object obj : ExpandableTextView.this.iWX.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.iWX.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.iWX.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.iWY.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.iWY.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.iXb, 0, spannableString.length(), 17);
                                ExpandableTextView.this.iWY.append((CharSequence) spannableString);
                                ExpandableTextView.this.iXa = new h(ExpandableTextView.this.iWY);
                                ((h) ExpandableTextView.this.iXa).DW(R.color.transparent);
                            }
                            ExpandableTextView.this.iWQ.setVisibility(8);
                            ExpandableTextView.this.kJF.setOnTouchListener(ExpandableTextView.this.iXa);
                            ExpandableTextView.this.kJF.setText(ExpandableTextView.this.iWY);
                            if (ExpandableTextView.this.kJK) {
                                ExpandableTextView.this.cTB();
                            }
                        }
                    } else if (!ExpandableTextView.this.iWU) {
                        ExpandableTextView.this.iWU = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.kJM, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.iWX.append((CharSequence) spannableString2);
                            } else {
                                int i2 = (lineEnd2 - lineEnd3) + 1;
                                for (int i22 = 0; i22 < i2; i22++) {
                                    ExpandableTextView.this.iWX.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.iWX.append((CharSequence) spannableString2);
                            }
                            ((h) ExpandableTextView.this.iWZ).DW(R.color.transparent);
                            ExpandableTextView.this.kJF.setOnTouchListener(ExpandableTextView.this.iWZ);
                            ExpandableTextView.this.kJF.setText(ExpandableTextView.this.iWX);
                            ExpandableTextView.this.iWQ.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.iWQ.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.iWQ.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.iWQ.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.iXb = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cTB();
            }
        };
        this.kJM = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cTC();
            }
        };
        this.kJN = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.cTC();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
        this.kJF = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
        this.kJF.setTextSize(0, TbConfig.getContentSize());
        this.kJF.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.iWQ = (TextView) findViewById(R.id.expandable_view_title_up);
        this.iWQ.setOnClickListener(this.kJN);
        this.textSize = l.getDimens(context, R.dimen.tbfontsize42);
        this.textColor = R.color.cp_cont_a;
        this.kJI = l.getDimens(context, R.dimen.tbds6);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.kJF.setTextSize(0, i);
        this.iWQ.setTextSize(0, i);
    }

    public void setTextColor(int i) {
        this.textColor = i;
        am.setViewTextColor(this.kJF, this.textColor, 1);
    }

    public void setLineSpacingExtra(int i) {
        this.kJI = i;
        this.kJF.setLineSpacing(i, 1.0f);
        this.iWQ.setLineSpacing(i, 1.0f);
    }

    public void setTextMaxLine(int i) {
        this.kJH = i;
    }

    public void setExpandable(boolean z) {
        this.kJD = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.kJF.getViewTreeObserver().removeGlobalOnLayoutListener(this.kJL);
            } else {
                this.kJF.getViewTreeObserver().removeOnGlobalLayoutListener(this.kJL);
            }
            this.kJF.setMaxLines(this.kJH);
            this.kJF.setEllipsize(TextUtils.TruncateAt.END);
            this.kJF.setText(this.iWX);
            this.kJF.setOnTouchListener(null);
            this.iWQ.setVisibility(8);
            return;
        }
        this.kJF.getViewTreeObserver().addOnGlobalLayoutListener(this.kJL);
        this.kJF.setMaxLines(Integer.MAX_VALUE);
        this.kJF.setEllipsize(null);
    }

    public void setExpandType(int i) {
        this.type = i;
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.iWQ.setPadding(i, i2, i3, i4);
    }

    public void setData(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.kJK = z;
        this.iWX = new SpannableStringBuilder(charSequence);
        this.iWZ = new h(this.iWX);
        this.kJF.setText(this.iWX);
        this.kJF.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        this.kJF.setOnTouchListener(this.iWZ);
        am.setViewTextColor(this.kJF, this.textColor, 1);
    }

    public TextView getContentView() {
        return this.kJF;
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.kJF, this.textColor, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTB() {
        this.kJE = true;
        if (this.kJJ != null) {
            this.kJJ.mm(this.kJE);
        }
        this.kJF.setOnTouchListener(this.iWZ);
        this.kJF.setText(this.iWX);
        if (this.type == 1) {
            this.iWQ.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTC() {
        this.kJE = false;
        if (this.kJJ != null) {
            this.kJJ.mm(this.kJE);
        }
        this.kJF.setOnTouchListener(this.iXa);
        this.kJF.setText(this.iWY);
        this.iWQ.setVisibility(8);
    }

    public void setOnStatusChangedListener(a aVar) {
        this.kJJ = aVar;
    }
}
