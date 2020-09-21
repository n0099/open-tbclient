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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.view.i;
/* loaded from: classes.dex */
public class ExpandableTextView extends RelativeLayout {
    private TextView lcI;
    private boolean lcM;
    private SpannableStringBuilder lcP;
    private SpannableStringBuilder lcQ;
    private View.OnTouchListener lcR;
    private View.OnTouchListener lcS;
    private f lcT;
    private boolean mUE;
    private boolean mUF;
    private SpannableClickTextView mUG;
    private int mUH;
    private int mUI;
    private int mUJ;
    private a mUK;
    private boolean mUL;
    private ViewTreeObserver.OnGlobalLayoutListener mUM;
    private f mUN;
    private View.OnClickListener mUO;
    private int textColor;
    private int textSize;
    private int type;

    /* loaded from: classes.dex */
    public interface a {
        void pu(boolean z);
    }

    public ExpandableTextView(Context context) {
        super(context);
        this.type = 1;
        this.mUE = true;
        this.mUF = false;
        this.lcM = false;
        this.mUH = 2;
        this.mUI = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mUL = false;
        this.mUM = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.mUG != null && ExpandableTextView.this.lcP != null && ExpandableTextView.this.mUE && (layout = ExpandableTextView.this.mUG.getLayout()) != null) {
                    if (!ExpandableTextView.this.mUF) {
                        if (layout.getLineCount() > ExpandableTextView.this.mUH) {
                            if (ExpandableTextView.this.lcQ == null) {
                                String spannableStringBuilder = ExpandableTextView.this.lcP.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.mUH - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.mUH - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), at.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.lcQ = new SpannableStringBuilder();
                                ExpandableTextView.this.lcQ.append((CharSequence) substring2);
                                ExpandableTextView.this.lcQ.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.lcQ.length();
                                for (Object obj : ExpandableTextView.this.lcP.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.lcP.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.lcP.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.lcQ.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.lcQ.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.lcT, 0, spannableString.length(), 17);
                                ExpandableTextView.this.lcQ.append((CharSequence) spannableString);
                                ExpandableTextView.this.lcS = new i(ExpandableTextView.this.lcQ);
                                ((i) ExpandableTextView.this.lcS).JT(R.color.transparent);
                            }
                            ExpandableTextView.this.lcI.setVisibility(8);
                            ExpandableTextView.this.mUG.setOnTouchListener(ExpandableTextView.this.lcS);
                            ExpandableTextView.this.mUG.setText(ExpandableTextView.this.lcQ);
                            if (ExpandableTextView.this.mUL) {
                                ExpandableTextView.this.dJs();
                            }
                        }
                    } else if (!ExpandableTextView.this.lcM) {
                        ExpandableTextView.this.lcM = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.mUN, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.lcP.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.lcP.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.lcP.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.lcR).JT(R.color.transparent);
                            ExpandableTextView.this.mUG.setOnTouchListener(ExpandableTextView.this.lcR);
                            ExpandableTextView.this.mUG.setText(ExpandableTextView.this.lcP);
                            ExpandableTextView.this.lcI.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.lcI.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.lcI.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.lcI.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.lcT = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dJs();
            }
        };
        this.mUN = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dJt();
            }
        };
        this.mUO = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dJt();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 1;
        this.mUE = true;
        this.mUF = false;
        this.lcM = false;
        this.mUH = 2;
        this.mUI = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mUL = false;
        this.mUM = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.mUG != null && ExpandableTextView.this.lcP != null && ExpandableTextView.this.mUE && (layout = ExpandableTextView.this.mUG.getLayout()) != null) {
                    if (!ExpandableTextView.this.mUF) {
                        if (layout.getLineCount() > ExpandableTextView.this.mUH) {
                            if (ExpandableTextView.this.lcQ == null) {
                                String spannableStringBuilder = ExpandableTextView.this.lcP.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.mUH - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.mUH - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), at.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.lcQ = new SpannableStringBuilder();
                                ExpandableTextView.this.lcQ.append((CharSequence) substring2);
                                ExpandableTextView.this.lcQ.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.lcQ.length();
                                for (Object obj : ExpandableTextView.this.lcP.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.lcP.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.lcP.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.lcQ.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.lcQ.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.lcT, 0, spannableString.length(), 17);
                                ExpandableTextView.this.lcQ.append((CharSequence) spannableString);
                                ExpandableTextView.this.lcS = new i(ExpandableTextView.this.lcQ);
                                ((i) ExpandableTextView.this.lcS).JT(R.color.transparent);
                            }
                            ExpandableTextView.this.lcI.setVisibility(8);
                            ExpandableTextView.this.mUG.setOnTouchListener(ExpandableTextView.this.lcS);
                            ExpandableTextView.this.mUG.setText(ExpandableTextView.this.lcQ);
                            if (ExpandableTextView.this.mUL) {
                                ExpandableTextView.this.dJs();
                            }
                        }
                    } else if (!ExpandableTextView.this.lcM) {
                        ExpandableTextView.this.lcM = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.mUN, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.lcP.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.lcP.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.lcP.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.lcR).JT(R.color.transparent);
                            ExpandableTextView.this.mUG.setOnTouchListener(ExpandableTextView.this.lcR);
                            ExpandableTextView.this.mUG.setText(ExpandableTextView.this.lcP);
                            ExpandableTextView.this.lcI.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.lcI.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.lcI.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.lcI.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.lcT = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dJs();
            }
        };
        this.mUN = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dJt();
            }
        };
        this.mUO = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dJt();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 1;
        this.mUE = true;
        this.mUF = false;
        this.lcM = false;
        this.mUH = 2;
        this.mUI = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mUL = false;
        this.mUM = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.mUG != null && ExpandableTextView.this.lcP != null && ExpandableTextView.this.mUE && (layout = ExpandableTextView.this.mUG.getLayout()) != null) {
                    if (!ExpandableTextView.this.mUF) {
                        if (layout.getLineCount() > ExpandableTextView.this.mUH) {
                            if (ExpandableTextView.this.lcQ == null) {
                                String spannableStringBuilder = ExpandableTextView.this.lcP.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.mUH - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.mUH - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), at.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.lcQ = new SpannableStringBuilder();
                                ExpandableTextView.this.lcQ.append((CharSequence) substring2);
                                ExpandableTextView.this.lcQ.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.lcQ.length();
                                for (Object obj : ExpandableTextView.this.lcP.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.lcP.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.lcP.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.lcQ.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.lcQ.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.lcT, 0, spannableString.length(), 17);
                                ExpandableTextView.this.lcQ.append((CharSequence) spannableString);
                                ExpandableTextView.this.lcS = new i(ExpandableTextView.this.lcQ);
                                ((i) ExpandableTextView.this.lcS).JT(R.color.transparent);
                            }
                            ExpandableTextView.this.lcI.setVisibility(8);
                            ExpandableTextView.this.mUG.setOnTouchListener(ExpandableTextView.this.lcS);
                            ExpandableTextView.this.mUG.setText(ExpandableTextView.this.lcQ);
                            if (ExpandableTextView.this.mUL) {
                                ExpandableTextView.this.dJs();
                            }
                        }
                    } else if (!ExpandableTextView.this.lcM) {
                        ExpandableTextView.this.lcM = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.mUN, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.lcP.append((CharSequence) spannableString2);
                            } else {
                                int i2 = (lineEnd2 - lineEnd3) + 1;
                                for (int i22 = 0; i22 < i2; i22++) {
                                    ExpandableTextView.this.lcP.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.lcP.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.lcR).JT(R.color.transparent);
                            ExpandableTextView.this.mUG.setOnTouchListener(ExpandableTextView.this.lcR);
                            ExpandableTextView.this.mUG.setText(ExpandableTextView.this.lcP);
                            ExpandableTextView.this.lcI.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.lcI.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.lcI.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.lcI.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.lcT = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dJs();
            }
        };
        this.mUN = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dJt();
            }
        };
        this.mUO = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dJt();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
        this.mUG = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
        this.mUG.setTextSize(0, TbConfig.getContentSize());
        this.mUG.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.lcI = (TextView) findViewById(R.id.expandable_view_title_up);
        this.lcI.setOnClickListener(this.mUO);
        this.textSize = l.getDimens(context, R.dimen.tbfontsize42);
        this.textColor = R.color.cp_cont_a;
        this.mUJ = l.getDimens(context, R.dimen.tbds6);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.mUG.setTextSize(0, i);
        this.lcI.setTextSize(0, i);
    }

    public void setTextColor(int i) {
        this.textColor = i;
        ap.setViewTextColor(this.mUG, this.textColor, 1);
    }

    public void setLineSpacingExtra(int i) {
        this.mUJ = i;
        this.mUG.setLineSpacing(i, 1.0f);
        this.lcI.setLineSpacing(i, 1.0f);
    }

    public void setTextMaxLine(int i) {
        this.mUI = i;
    }

    public void setExpandable(boolean z) {
        this.mUE = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.mUG.getViewTreeObserver().removeGlobalOnLayoutListener(this.mUM);
            } else {
                this.mUG.getViewTreeObserver().removeOnGlobalLayoutListener(this.mUM);
            }
            this.mUG.setMaxLines(this.mUI);
            this.mUG.setEllipsize(TextUtils.TruncateAt.END);
            this.mUG.setText(this.lcP);
            this.mUG.setOnTouchListener(null);
            this.lcI.setVisibility(8);
            return;
        }
        this.mUG.getViewTreeObserver().addOnGlobalLayoutListener(this.mUM);
        this.mUG.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.mUG.setEllipsize(null);
    }

    public void setExpandType(int i) {
        this.type = i;
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.lcI.setPadding(i, i2, i3, i4);
    }

    public void setData(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.mUL = z;
        this.lcP = new SpannableStringBuilder(charSequence);
        this.lcR = new i(this.lcP);
        this.mUG.setText(this.lcP);
        this.mUG.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
        this.mUG.setOnTouchListener(this.lcR);
        ap.setViewTextColor(this.mUG, this.textColor, 1);
    }

    public TextView getContentView() {
        return this.mUG;
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mUG, this.textColor, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJs() {
        this.mUF = true;
        if (this.mUK != null) {
            this.mUK.pu(this.mUF);
        }
        this.mUG.setOnTouchListener(this.lcR);
        this.mUG.setText(this.lcP);
        if (this.type == 1) {
            this.lcI.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJt() {
        this.mUF = false;
        if (this.mUK != null) {
            this.mUK.pu(this.mUF);
        }
        this.mUG.setOnTouchListener(this.lcS);
        this.mUG.setText(this.lcQ);
        this.lcI.setVisibility(8);
    }

    public void setOnStatusChangedListener(a aVar) {
        this.mUK = aVar;
    }
}
