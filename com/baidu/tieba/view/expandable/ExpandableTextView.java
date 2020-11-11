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
    private SpannableStringBuilder lKB;
    private SpannableStringBuilder lKC;
    private View.OnTouchListener lKD;
    private View.OnTouchListener lKE;
    private f lKF;
    private TextView lKu;
    private boolean lKy;
    private SpannableClickTextView nCA;
    private int nCB;
    private int nCC;
    private int nCD;
    private a nCE;
    private boolean nCF;
    private ViewTreeObserver.OnGlobalLayoutListener nCG;
    private f nCH;
    private View.OnClickListener nCI;
    private boolean nCy;
    private boolean nCz;
    private int textColor;
    private int textSize;
    private int type;

    /* loaded from: classes.dex */
    public interface a {
        void qA(boolean z);
    }

    public ExpandableTextView(Context context) {
        super(context);
        this.type = 1;
        this.nCy = true;
        this.nCz = false;
        this.lKy = false;
        this.nCB = 2;
        this.nCC = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.nCF = false;
        this.nCG = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.nCA != null && ExpandableTextView.this.lKB != null && ExpandableTextView.this.nCy && (layout = ExpandableTextView.this.nCA.getLayout()) != null) {
                    if (!ExpandableTextView.this.nCz) {
                        if (layout.getLineCount() > ExpandableTextView.this.nCB) {
                            if (ExpandableTextView.this.lKC == null) {
                                String spannableStringBuilder = ExpandableTextView.this.lKB.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.nCB - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.nCB - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), at.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.lKC = new SpannableStringBuilder();
                                ExpandableTextView.this.lKC.append((CharSequence) substring2);
                                ExpandableTextView.this.lKC.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.lKC.length();
                                for (Object obj : ExpandableTextView.this.lKB.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.lKB.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.lKB.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.lKC.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.lKC.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.lKF, 0, spannableString.length(), 17);
                                ExpandableTextView.this.lKC.append((CharSequence) spannableString);
                                ExpandableTextView.this.lKE = new i(ExpandableTextView.this.lKC);
                                ((i) ExpandableTextView.this.lKE).Le(R.color.transparent);
                            }
                            ExpandableTextView.this.lKu.setVisibility(8);
                            ExpandableTextView.this.nCA.setOnTouchListener(ExpandableTextView.this.lKE);
                            ExpandableTextView.this.nCA.setText(ExpandableTextView.this.lKC);
                            if (ExpandableTextView.this.nCF) {
                                ExpandableTextView.this.dSO();
                            }
                        }
                    } else if (!ExpandableTextView.this.lKy) {
                        ExpandableTextView.this.lKy = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.nCH, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.lKB.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.lKB.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.lKB.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.lKD).Le(R.color.transparent);
                            ExpandableTextView.this.nCA.setOnTouchListener(ExpandableTextView.this.lKD);
                            ExpandableTextView.this.nCA.setText(ExpandableTextView.this.lKB);
                            ExpandableTextView.this.lKu.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.lKu.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.lKu.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.lKu.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.lKF = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dSO();
            }
        };
        this.nCH = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dSP();
            }
        };
        this.nCI = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dSP();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 1;
        this.nCy = true;
        this.nCz = false;
        this.lKy = false;
        this.nCB = 2;
        this.nCC = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.nCF = false;
        this.nCG = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.nCA != null && ExpandableTextView.this.lKB != null && ExpandableTextView.this.nCy && (layout = ExpandableTextView.this.nCA.getLayout()) != null) {
                    if (!ExpandableTextView.this.nCz) {
                        if (layout.getLineCount() > ExpandableTextView.this.nCB) {
                            if (ExpandableTextView.this.lKC == null) {
                                String spannableStringBuilder = ExpandableTextView.this.lKB.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.nCB - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.nCB - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), at.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.lKC = new SpannableStringBuilder();
                                ExpandableTextView.this.lKC.append((CharSequence) substring2);
                                ExpandableTextView.this.lKC.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.lKC.length();
                                for (Object obj : ExpandableTextView.this.lKB.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.lKB.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.lKB.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.lKC.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.lKC.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.lKF, 0, spannableString.length(), 17);
                                ExpandableTextView.this.lKC.append((CharSequence) spannableString);
                                ExpandableTextView.this.lKE = new i(ExpandableTextView.this.lKC);
                                ((i) ExpandableTextView.this.lKE).Le(R.color.transparent);
                            }
                            ExpandableTextView.this.lKu.setVisibility(8);
                            ExpandableTextView.this.nCA.setOnTouchListener(ExpandableTextView.this.lKE);
                            ExpandableTextView.this.nCA.setText(ExpandableTextView.this.lKC);
                            if (ExpandableTextView.this.nCF) {
                                ExpandableTextView.this.dSO();
                            }
                        }
                    } else if (!ExpandableTextView.this.lKy) {
                        ExpandableTextView.this.lKy = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.nCH, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.lKB.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.lKB.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.lKB.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.lKD).Le(R.color.transparent);
                            ExpandableTextView.this.nCA.setOnTouchListener(ExpandableTextView.this.lKD);
                            ExpandableTextView.this.nCA.setText(ExpandableTextView.this.lKB);
                            ExpandableTextView.this.lKu.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.lKu.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.lKu.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.lKu.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.lKF = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dSO();
            }
        };
        this.nCH = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dSP();
            }
        };
        this.nCI = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dSP();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 1;
        this.nCy = true;
        this.nCz = false;
        this.lKy = false;
        this.nCB = 2;
        this.nCC = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.nCF = false;
        this.nCG = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.nCA != null && ExpandableTextView.this.lKB != null && ExpandableTextView.this.nCy && (layout = ExpandableTextView.this.nCA.getLayout()) != null) {
                    if (!ExpandableTextView.this.nCz) {
                        if (layout.getLineCount() > ExpandableTextView.this.nCB) {
                            if (ExpandableTextView.this.lKC == null) {
                                String spannableStringBuilder = ExpandableTextView.this.lKB.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.nCB - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.nCB - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), at.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.lKC = new SpannableStringBuilder();
                                ExpandableTextView.this.lKC.append((CharSequence) substring2);
                                ExpandableTextView.this.lKC.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.lKC.length();
                                for (Object obj : ExpandableTextView.this.lKB.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.lKB.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.lKB.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.lKC.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.lKC.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.lKF, 0, spannableString.length(), 17);
                                ExpandableTextView.this.lKC.append((CharSequence) spannableString);
                                ExpandableTextView.this.lKE = new i(ExpandableTextView.this.lKC);
                                ((i) ExpandableTextView.this.lKE).Le(R.color.transparent);
                            }
                            ExpandableTextView.this.lKu.setVisibility(8);
                            ExpandableTextView.this.nCA.setOnTouchListener(ExpandableTextView.this.lKE);
                            ExpandableTextView.this.nCA.setText(ExpandableTextView.this.lKC);
                            if (ExpandableTextView.this.nCF) {
                                ExpandableTextView.this.dSO();
                            }
                        }
                    } else if (!ExpandableTextView.this.lKy) {
                        ExpandableTextView.this.lKy = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.nCH, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.lKB.append((CharSequence) spannableString2);
                            } else {
                                int i2 = (lineEnd2 - lineEnd3) + 1;
                                for (int i22 = 0; i22 < i2; i22++) {
                                    ExpandableTextView.this.lKB.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.lKB.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.lKD).Le(R.color.transparent);
                            ExpandableTextView.this.nCA.setOnTouchListener(ExpandableTextView.this.lKD);
                            ExpandableTextView.this.nCA.setText(ExpandableTextView.this.lKB);
                            ExpandableTextView.this.lKu.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.lKu.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.lKu.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.lKu.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.lKF = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dSO();
            }
        };
        this.nCH = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dSP();
            }
        };
        this.nCI = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dSP();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
        this.nCA = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
        this.nCA.setTextSize(0, TbConfig.getContentSize());
        this.nCA.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.lKu = (TextView) findViewById(R.id.expandable_view_title_up);
        this.lKu.setOnClickListener(this.nCI);
        this.textSize = l.getDimens(context, R.dimen.tbfontsize42);
        this.textColor = R.color.cp_cont_a;
        this.nCD = l.getDimens(context, R.dimen.tbds6);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.nCA.setTextSize(0, i);
        this.lKu.setTextSize(0, i);
    }

    public void setTextColor(int i) {
        this.textColor = i;
        ap.setViewTextColor(this.nCA, this.textColor, 1);
    }

    public void setLineSpacingExtra(int i) {
        this.nCD = i;
        this.nCA.setLineSpacing(i, 1.0f);
        this.lKu.setLineSpacing(i, 1.0f);
    }

    public void setTextMaxLine(int i) {
        this.nCC = i;
    }

    public void setExpandable(boolean z) {
        this.nCy = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.nCA.getViewTreeObserver().removeGlobalOnLayoutListener(this.nCG);
            } else {
                this.nCA.getViewTreeObserver().removeOnGlobalLayoutListener(this.nCG);
            }
            this.nCA.setMaxLines(this.nCC);
            this.nCA.setEllipsize(TextUtils.TruncateAt.END);
            this.nCA.setText(this.lKB);
            this.nCA.setOnTouchListener(null);
            this.lKu.setVisibility(8);
            return;
        }
        this.nCA.getViewTreeObserver().addOnGlobalLayoutListener(this.nCG);
        this.nCA.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.nCA.setEllipsize(null);
    }

    public void setExpandType(int i) {
        this.type = i;
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.lKu.setPadding(i, i2, i3, i4);
    }

    public void setData(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.nCF = z;
        this.lKB = new SpannableStringBuilder(charSequence);
        this.lKD = new i(this.lKB);
        this.nCA.setText(this.lKB);
        this.nCA.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
        this.nCA.setOnTouchListener(this.lKD);
        ap.setViewTextColor(this.nCA, this.textColor, 1);
    }

    public TextView getContentView() {
        return this.nCA;
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.nCA, this.textColor, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSO() {
        this.nCz = true;
        if (this.nCE != null) {
            this.nCE.qA(this.nCz);
        }
        this.nCA.setOnTouchListener(this.lKD);
        this.nCA.setText(this.lKB);
        if (this.type == 1) {
            this.lKu.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSP() {
        this.nCz = false;
        if (this.nCE != null) {
            this.nCE.qA(this.nCz);
        }
        this.nCA.setOnTouchListener(this.lKE);
        this.nCA.setText(this.lKC);
        this.lKu.setVisibility(8);
    }

    public void setOnStatusChangedListener(a aVar) {
        this.nCE = aVar;
    }
}
