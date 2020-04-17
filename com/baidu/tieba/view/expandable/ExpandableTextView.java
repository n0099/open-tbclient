package com.baidu.tieba.view.expandable;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.ActivityChooserView;
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
import com.baidu.tieba.view.i;
/* loaded from: classes.dex */
public class ExpandableTextView extends RelativeLayout {
    private TextView jIN;
    private boolean jIR;
    private SpannableStringBuilder jIU;
    private SpannableStringBuilder jIV;
    private View.OnTouchListener jIW;
    private View.OnTouchListener jIX;
    private f jIY;
    private boolean lvQ;
    private boolean lvR;
    private SpannableClickTextView lvS;
    private int lvT;
    private int lvU;
    private int lvV;
    private a lvW;
    private boolean lvX;
    private ViewTreeObserver.OnGlobalLayoutListener lvY;
    private f lvZ;
    private View.OnClickListener lwa;
    private int textColor;
    private int textSize;
    private int type;

    /* loaded from: classes.dex */
    public interface a {
        void nw(boolean z);
    }

    public ExpandableTextView(Context context) {
        super(context);
        this.type = 1;
        this.lvQ = true;
        this.lvR = false;
        this.jIR = false;
        this.lvT = 2;
        this.lvU = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.lvX = false;
        this.lvY = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.lvS != null && ExpandableTextView.this.jIU != null && ExpandableTextView.this.lvQ && (layout = ExpandableTextView.this.lvS.getLayout()) != null) {
                    if (!ExpandableTextView.this.lvR) {
                        if (layout.getLineCount() > ExpandableTextView.this.lvT) {
                            if (ExpandableTextView.this.jIV == null) {
                                String spannableStringBuilder = ExpandableTextView.this.jIU.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.lvT - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.lvT - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.jIV = new SpannableStringBuilder();
                                ExpandableTextView.this.jIV.append((CharSequence) substring2);
                                ExpandableTextView.this.jIV.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.jIV.length();
                                for (Object obj : ExpandableTextView.this.jIU.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.jIU.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.jIU.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.jIV.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.jIV.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.jIY, 0, spannableString.length(), 17);
                                ExpandableTextView.this.jIV.append((CharSequence) spannableString);
                                ExpandableTextView.this.jIX = new i(ExpandableTextView.this.jIV);
                                ((i) ExpandableTextView.this.jIX).EG(R.color.transparent);
                            }
                            ExpandableTextView.this.jIN.setVisibility(8);
                            ExpandableTextView.this.lvS.setOnTouchListener(ExpandableTextView.this.jIX);
                            ExpandableTextView.this.lvS.setText(ExpandableTextView.this.jIV);
                            if (ExpandableTextView.this.lvX) {
                                ExpandableTextView.this.deN();
                            }
                        }
                    } else if (!ExpandableTextView.this.jIR) {
                        ExpandableTextView.this.jIR = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.lvZ, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.jIU.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.jIU.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.jIU.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.jIW).EG(R.color.transparent);
                            ExpandableTextView.this.lvS.setOnTouchListener(ExpandableTextView.this.jIW);
                            ExpandableTextView.this.lvS.setText(ExpandableTextView.this.jIU);
                            ExpandableTextView.this.jIN.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.jIN.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.jIN.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.jIN.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.jIY = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.deN();
            }
        };
        this.lvZ = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.deO();
            }
        };
        this.lwa = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.deO();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 1;
        this.lvQ = true;
        this.lvR = false;
        this.jIR = false;
        this.lvT = 2;
        this.lvU = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.lvX = false;
        this.lvY = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.lvS != null && ExpandableTextView.this.jIU != null && ExpandableTextView.this.lvQ && (layout = ExpandableTextView.this.lvS.getLayout()) != null) {
                    if (!ExpandableTextView.this.lvR) {
                        if (layout.getLineCount() > ExpandableTextView.this.lvT) {
                            if (ExpandableTextView.this.jIV == null) {
                                String spannableStringBuilder = ExpandableTextView.this.jIU.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.lvT - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.lvT - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.jIV = new SpannableStringBuilder();
                                ExpandableTextView.this.jIV.append((CharSequence) substring2);
                                ExpandableTextView.this.jIV.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.jIV.length();
                                for (Object obj : ExpandableTextView.this.jIU.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.jIU.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.jIU.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.jIV.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.jIV.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.jIY, 0, spannableString.length(), 17);
                                ExpandableTextView.this.jIV.append((CharSequence) spannableString);
                                ExpandableTextView.this.jIX = new i(ExpandableTextView.this.jIV);
                                ((i) ExpandableTextView.this.jIX).EG(R.color.transparent);
                            }
                            ExpandableTextView.this.jIN.setVisibility(8);
                            ExpandableTextView.this.lvS.setOnTouchListener(ExpandableTextView.this.jIX);
                            ExpandableTextView.this.lvS.setText(ExpandableTextView.this.jIV);
                            if (ExpandableTextView.this.lvX) {
                                ExpandableTextView.this.deN();
                            }
                        }
                    } else if (!ExpandableTextView.this.jIR) {
                        ExpandableTextView.this.jIR = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.lvZ, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.jIU.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.jIU.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.jIU.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.jIW).EG(R.color.transparent);
                            ExpandableTextView.this.lvS.setOnTouchListener(ExpandableTextView.this.jIW);
                            ExpandableTextView.this.lvS.setText(ExpandableTextView.this.jIU);
                            ExpandableTextView.this.jIN.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.jIN.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.jIN.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.jIN.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.jIY = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.deN();
            }
        };
        this.lvZ = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.deO();
            }
        };
        this.lwa = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.deO();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 1;
        this.lvQ = true;
        this.lvR = false;
        this.jIR = false;
        this.lvT = 2;
        this.lvU = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.lvX = false;
        this.lvY = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.lvS != null && ExpandableTextView.this.jIU != null && ExpandableTextView.this.lvQ && (layout = ExpandableTextView.this.lvS.getLayout()) != null) {
                    if (!ExpandableTextView.this.lvR) {
                        if (layout.getLineCount() > ExpandableTextView.this.lvT) {
                            if (ExpandableTextView.this.jIV == null) {
                                String spannableStringBuilder = ExpandableTextView.this.jIU.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.lvT - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.lvT - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.jIV = new SpannableStringBuilder();
                                ExpandableTextView.this.jIV.append((CharSequence) substring2);
                                ExpandableTextView.this.jIV.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.jIV.length();
                                for (Object obj : ExpandableTextView.this.jIU.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.jIU.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.jIU.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.jIV.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.jIV.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.jIY, 0, spannableString.length(), 17);
                                ExpandableTextView.this.jIV.append((CharSequence) spannableString);
                                ExpandableTextView.this.jIX = new i(ExpandableTextView.this.jIV);
                                ((i) ExpandableTextView.this.jIX).EG(R.color.transparent);
                            }
                            ExpandableTextView.this.jIN.setVisibility(8);
                            ExpandableTextView.this.lvS.setOnTouchListener(ExpandableTextView.this.jIX);
                            ExpandableTextView.this.lvS.setText(ExpandableTextView.this.jIV);
                            if (ExpandableTextView.this.lvX) {
                                ExpandableTextView.this.deN();
                            }
                        }
                    } else if (!ExpandableTextView.this.jIR) {
                        ExpandableTextView.this.jIR = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.lvZ, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.jIU.append((CharSequence) spannableString2);
                            } else {
                                int i2 = (lineEnd2 - lineEnd3) + 1;
                                for (int i22 = 0; i22 < i2; i22++) {
                                    ExpandableTextView.this.jIU.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.jIU.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.jIW).EG(R.color.transparent);
                            ExpandableTextView.this.lvS.setOnTouchListener(ExpandableTextView.this.jIW);
                            ExpandableTextView.this.lvS.setText(ExpandableTextView.this.jIU);
                            ExpandableTextView.this.jIN.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.jIN.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.jIN.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.jIN.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.jIY = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.deN();
            }
        };
        this.lvZ = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.deO();
            }
        };
        this.lwa = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.deO();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
        this.lvS = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
        this.lvS.setTextSize(0, TbConfig.getContentSize());
        this.lvS.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.jIN = (TextView) findViewById(R.id.expandable_view_title_up);
        this.jIN.setOnClickListener(this.lwa);
        this.textSize = l.getDimens(context, R.dimen.tbfontsize42);
        this.textColor = R.color.cp_cont_a;
        this.lvV = l.getDimens(context, R.dimen.tbds6);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.lvS.setTextSize(0, i);
        this.jIN.setTextSize(0, i);
    }

    public void setTextColor(int i) {
        this.textColor = i;
        am.setViewTextColor(this.lvS, this.textColor, 1);
    }

    public void setLineSpacingExtra(int i) {
        this.lvV = i;
        this.lvS.setLineSpacing(i, 1.0f);
        this.jIN.setLineSpacing(i, 1.0f);
    }

    public void setTextMaxLine(int i) {
        this.lvU = i;
    }

    public void setExpandable(boolean z) {
        this.lvQ = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.lvS.getViewTreeObserver().removeGlobalOnLayoutListener(this.lvY);
            } else {
                this.lvS.getViewTreeObserver().removeOnGlobalLayoutListener(this.lvY);
            }
            this.lvS.setMaxLines(this.lvU);
            this.lvS.setEllipsize(TextUtils.TruncateAt.END);
            this.lvS.setText(this.jIU);
            this.lvS.setOnTouchListener(null);
            this.jIN.setVisibility(8);
            return;
        }
        this.lvS.getViewTreeObserver().addOnGlobalLayoutListener(this.lvY);
        this.lvS.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.lvS.setEllipsize(null);
    }

    public void setExpandType(int i) {
        this.type = i;
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.jIN.setPadding(i, i2, i3, i4);
    }

    public void setData(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.lvX = z;
        this.jIU = new SpannableStringBuilder(charSequence);
        this.jIW = new i(this.jIU);
        this.lvS.setText(this.jIU);
        this.lvS.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        this.lvS.setOnTouchListener(this.jIW);
        am.setViewTextColor(this.lvS, this.textColor, 1);
    }

    public TextView getContentView() {
        return this.lvS;
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.lvS, this.textColor, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deN() {
        this.lvR = true;
        if (this.lvW != null) {
            this.lvW.nw(this.lvR);
        }
        this.lvS.setOnTouchListener(this.jIW);
        this.lvS.setText(this.jIU);
        if (this.type == 1) {
            this.jIN.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deO() {
        this.lvR = false;
        if (this.lvW != null) {
            this.lvW.nw(this.lvR);
        }
        this.lvS.setOnTouchListener(this.jIX);
        this.lvS.setText(this.jIV);
        this.jIN.setVisibility(8);
    }

    public void setOnStatusChangedListener(a aVar) {
        this.lvW = aVar;
    }
}
