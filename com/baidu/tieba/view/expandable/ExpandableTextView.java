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
    private TextView jIR;
    private boolean jIV;
    private SpannableStringBuilder jIY;
    private SpannableStringBuilder jIZ;
    private View.OnTouchListener jJa;
    private View.OnTouchListener jJb;
    private f jJc;
    private boolean lvU;
    private boolean lvV;
    private SpannableClickTextView lvW;
    private int lvX;
    private int lvY;
    private int lvZ;
    private a lwa;
    private boolean lwb;
    private ViewTreeObserver.OnGlobalLayoutListener lwc;
    private f lwd;
    private View.OnClickListener lwe;
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
        this.lvU = true;
        this.lvV = false;
        this.jIV = false;
        this.lvX = 2;
        this.lvY = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.lwb = false;
        this.lwc = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.lvW != null && ExpandableTextView.this.jIY != null && ExpandableTextView.this.lvU && (layout = ExpandableTextView.this.lvW.getLayout()) != null) {
                    if (!ExpandableTextView.this.lvV) {
                        if (layout.getLineCount() > ExpandableTextView.this.lvX) {
                            if (ExpandableTextView.this.jIZ == null) {
                                String spannableStringBuilder = ExpandableTextView.this.jIY.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.lvX - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.lvX - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.jIZ = new SpannableStringBuilder();
                                ExpandableTextView.this.jIZ.append((CharSequence) substring2);
                                ExpandableTextView.this.jIZ.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.jIZ.length();
                                for (Object obj : ExpandableTextView.this.jIY.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.jIY.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.jIY.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.jIZ.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.jIZ.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.jJc, 0, spannableString.length(), 17);
                                ExpandableTextView.this.jIZ.append((CharSequence) spannableString);
                                ExpandableTextView.this.jJb = new i(ExpandableTextView.this.jIZ);
                                ((i) ExpandableTextView.this.jJb).EG(R.color.transparent);
                            }
                            ExpandableTextView.this.jIR.setVisibility(8);
                            ExpandableTextView.this.lvW.setOnTouchListener(ExpandableTextView.this.jJb);
                            ExpandableTextView.this.lvW.setText(ExpandableTextView.this.jIZ);
                            if (ExpandableTextView.this.lwb) {
                                ExpandableTextView.this.deL();
                            }
                        }
                    } else if (!ExpandableTextView.this.jIV) {
                        ExpandableTextView.this.jIV = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.lwd, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.jIY.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.jIY.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.jIY.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.jJa).EG(R.color.transparent);
                            ExpandableTextView.this.lvW.setOnTouchListener(ExpandableTextView.this.jJa);
                            ExpandableTextView.this.lvW.setText(ExpandableTextView.this.jIY);
                            ExpandableTextView.this.jIR.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.jIR.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.jIR.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.jIR.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.jJc = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.deL();
            }
        };
        this.lwd = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.deM();
            }
        };
        this.lwe = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.deM();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 1;
        this.lvU = true;
        this.lvV = false;
        this.jIV = false;
        this.lvX = 2;
        this.lvY = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.lwb = false;
        this.lwc = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.lvW != null && ExpandableTextView.this.jIY != null && ExpandableTextView.this.lvU && (layout = ExpandableTextView.this.lvW.getLayout()) != null) {
                    if (!ExpandableTextView.this.lvV) {
                        if (layout.getLineCount() > ExpandableTextView.this.lvX) {
                            if (ExpandableTextView.this.jIZ == null) {
                                String spannableStringBuilder = ExpandableTextView.this.jIY.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.lvX - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.lvX - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.jIZ = new SpannableStringBuilder();
                                ExpandableTextView.this.jIZ.append((CharSequence) substring2);
                                ExpandableTextView.this.jIZ.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.jIZ.length();
                                for (Object obj : ExpandableTextView.this.jIY.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.jIY.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.jIY.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.jIZ.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.jIZ.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.jJc, 0, spannableString.length(), 17);
                                ExpandableTextView.this.jIZ.append((CharSequence) spannableString);
                                ExpandableTextView.this.jJb = new i(ExpandableTextView.this.jIZ);
                                ((i) ExpandableTextView.this.jJb).EG(R.color.transparent);
                            }
                            ExpandableTextView.this.jIR.setVisibility(8);
                            ExpandableTextView.this.lvW.setOnTouchListener(ExpandableTextView.this.jJb);
                            ExpandableTextView.this.lvW.setText(ExpandableTextView.this.jIZ);
                            if (ExpandableTextView.this.lwb) {
                                ExpandableTextView.this.deL();
                            }
                        }
                    } else if (!ExpandableTextView.this.jIV) {
                        ExpandableTextView.this.jIV = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.lwd, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.jIY.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.jIY.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.jIY.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.jJa).EG(R.color.transparent);
                            ExpandableTextView.this.lvW.setOnTouchListener(ExpandableTextView.this.jJa);
                            ExpandableTextView.this.lvW.setText(ExpandableTextView.this.jIY);
                            ExpandableTextView.this.jIR.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.jIR.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.jIR.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.jIR.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.jJc = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.deL();
            }
        };
        this.lwd = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.deM();
            }
        };
        this.lwe = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.deM();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 1;
        this.lvU = true;
        this.lvV = false;
        this.jIV = false;
        this.lvX = 2;
        this.lvY = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.lwb = false;
        this.lwc = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.lvW != null && ExpandableTextView.this.jIY != null && ExpandableTextView.this.lvU && (layout = ExpandableTextView.this.lvW.getLayout()) != null) {
                    if (!ExpandableTextView.this.lvV) {
                        if (layout.getLineCount() > ExpandableTextView.this.lvX) {
                            if (ExpandableTextView.this.jIZ == null) {
                                String spannableStringBuilder = ExpandableTextView.this.jIY.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.lvX - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.lvX - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.jIZ = new SpannableStringBuilder();
                                ExpandableTextView.this.jIZ.append((CharSequence) substring2);
                                ExpandableTextView.this.jIZ.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.jIZ.length();
                                for (Object obj : ExpandableTextView.this.jIY.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.jIY.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.jIY.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.jIZ.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.jIZ.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.jJc, 0, spannableString.length(), 17);
                                ExpandableTextView.this.jIZ.append((CharSequence) spannableString);
                                ExpandableTextView.this.jJb = new i(ExpandableTextView.this.jIZ);
                                ((i) ExpandableTextView.this.jJb).EG(R.color.transparent);
                            }
                            ExpandableTextView.this.jIR.setVisibility(8);
                            ExpandableTextView.this.lvW.setOnTouchListener(ExpandableTextView.this.jJb);
                            ExpandableTextView.this.lvW.setText(ExpandableTextView.this.jIZ);
                            if (ExpandableTextView.this.lwb) {
                                ExpandableTextView.this.deL();
                            }
                        }
                    } else if (!ExpandableTextView.this.jIV) {
                        ExpandableTextView.this.jIV = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.lwd, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.jIY.append((CharSequence) spannableString2);
                            } else {
                                int i2 = (lineEnd2 - lineEnd3) + 1;
                                for (int i22 = 0; i22 < i2; i22++) {
                                    ExpandableTextView.this.jIY.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.jIY.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.jJa).EG(R.color.transparent);
                            ExpandableTextView.this.lvW.setOnTouchListener(ExpandableTextView.this.jJa);
                            ExpandableTextView.this.lvW.setText(ExpandableTextView.this.jIY);
                            ExpandableTextView.this.jIR.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.jIR.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.jIR.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.jIR.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.jJc = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.deL();
            }
        };
        this.lwd = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.deM();
            }
        };
        this.lwe = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.deM();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
        this.lvW = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
        this.lvW.setTextSize(0, TbConfig.getContentSize());
        this.lvW.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.jIR = (TextView) findViewById(R.id.expandable_view_title_up);
        this.jIR.setOnClickListener(this.lwe);
        this.textSize = l.getDimens(context, R.dimen.tbfontsize42);
        this.textColor = R.color.cp_cont_a;
        this.lvZ = l.getDimens(context, R.dimen.tbds6);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.lvW.setTextSize(0, i);
        this.jIR.setTextSize(0, i);
    }

    public void setTextColor(int i) {
        this.textColor = i;
        am.setViewTextColor(this.lvW, this.textColor, 1);
    }

    public void setLineSpacingExtra(int i) {
        this.lvZ = i;
        this.lvW.setLineSpacing(i, 1.0f);
        this.jIR.setLineSpacing(i, 1.0f);
    }

    public void setTextMaxLine(int i) {
        this.lvY = i;
    }

    public void setExpandable(boolean z) {
        this.lvU = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.lvW.getViewTreeObserver().removeGlobalOnLayoutListener(this.lwc);
            } else {
                this.lvW.getViewTreeObserver().removeOnGlobalLayoutListener(this.lwc);
            }
            this.lvW.setMaxLines(this.lvY);
            this.lvW.setEllipsize(TextUtils.TruncateAt.END);
            this.lvW.setText(this.jIY);
            this.lvW.setOnTouchListener(null);
            this.jIR.setVisibility(8);
            return;
        }
        this.lvW.getViewTreeObserver().addOnGlobalLayoutListener(this.lwc);
        this.lvW.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.lvW.setEllipsize(null);
    }

    public void setExpandType(int i) {
        this.type = i;
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.jIR.setPadding(i, i2, i3, i4);
    }

    public void setData(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.lwb = z;
        this.jIY = new SpannableStringBuilder(charSequence);
        this.jJa = new i(this.jIY);
        this.lvW.setText(this.jIY);
        this.lvW.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        this.lvW.setOnTouchListener(this.jJa);
        am.setViewTextColor(this.lvW, this.textColor, 1);
    }

    public TextView getContentView() {
        return this.lvW;
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.lvW, this.textColor, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deL() {
        this.lvV = true;
        if (this.lwa != null) {
            this.lwa.nw(this.lvV);
        }
        this.lvW.setOnTouchListener(this.jJa);
        this.lvW.setText(this.jIY);
        if (this.type == 1) {
            this.jIR.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deM() {
        this.lvV = false;
        if (this.lwa != null) {
            this.lwa.nw(this.lvV);
        }
        this.lvW.setOnTouchListener(this.jJb);
        this.lvW.setText(this.jIZ);
        this.jIR.setVisibility(8);
    }

    public void setOnStatusChangedListener(a aVar) {
        this.lwa = aVar;
    }
}
