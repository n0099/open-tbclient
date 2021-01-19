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
import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.view.i;
/* loaded from: classes.dex */
public class ExpandableTextView extends RelativeLayout {
    private SpannableStringBuilder lZA;
    private SpannableStringBuilder lZB;
    private View.OnTouchListener lZC;
    private View.OnTouchListener lZD;
    private f lZE;
    private TextView lZt;
    private boolean lZx;
    private boolean nQP;
    private boolean nQQ;
    private SpannableClickTextView nQR;
    private int nQS;
    private int nQT;
    private int nQU;
    private a nQV;
    private boolean nQW;
    private ViewTreeObserver.OnGlobalLayoutListener nQX;
    private f nQY;
    private View.OnClickListener nQZ;
    private int textColor;
    private int textSize;
    private int type;

    /* loaded from: classes.dex */
    public interface a {
        void rz(boolean z);
    }

    public ExpandableTextView(Context context) {
        super(context);
        this.type = 1;
        this.nQP = true;
        this.nQQ = false;
        this.lZx = false;
        this.nQS = 2;
        this.nQT = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.nQW = false;
        this.nQX = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.nQR != null && ExpandableTextView.this.lZA != null && ExpandableTextView.this.nQP && (layout = ExpandableTextView.this.nQR.getLayout()) != null) {
                    if (!ExpandableTextView.this.nQQ) {
                        if (layout.getLineCount() > ExpandableTextView.this.nQS) {
                            if (ExpandableTextView.this.lZB == null) {
                                String spannableStringBuilder = ExpandableTextView.this.lZA.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.nQS - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.nQS - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), at.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.lZB = new SpannableStringBuilder();
                                ExpandableTextView.this.lZB.append((CharSequence) substring2);
                                ExpandableTextView.this.lZB.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.lZB.length();
                                for (Object obj : ExpandableTextView.this.lZA.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.lZA.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.lZA.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.lZB.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.lZB.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.lZE, 0, spannableString.length(), 17);
                                ExpandableTextView.this.lZB.append((CharSequence) spannableString);
                                ExpandableTextView.this.lZD = new i(ExpandableTextView.this.lZB);
                                ((i) ExpandableTextView.this.lZD).KF(R.color.transparent);
                            }
                            ExpandableTextView.this.lZt.setVisibility(8);
                            ExpandableTextView.this.nQR.setOnTouchListener(ExpandableTextView.this.lZD);
                            ExpandableTextView.this.nQR.setText(ExpandableTextView.this.lZB);
                            if (ExpandableTextView.this.nQW) {
                                ExpandableTextView.this.dTU();
                            }
                        }
                    } else if (!ExpandableTextView.this.lZx) {
                        ExpandableTextView.this.lZx = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.nQY, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.lZA.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.lZA.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.lZA.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.lZC).KF(R.color.transparent);
                            ExpandableTextView.this.nQR.setOnTouchListener(ExpandableTextView.this.lZC);
                            ExpandableTextView.this.nQR.setText(ExpandableTextView.this.lZA);
                            ExpandableTextView.this.lZt.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.lZt.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.lZt.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.lZt.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.lZE = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dTU();
            }
        };
        this.nQY = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dTV();
            }
        };
        this.nQZ = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dTV();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 1;
        this.nQP = true;
        this.nQQ = false;
        this.lZx = false;
        this.nQS = 2;
        this.nQT = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.nQW = false;
        this.nQX = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.nQR != null && ExpandableTextView.this.lZA != null && ExpandableTextView.this.nQP && (layout = ExpandableTextView.this.nQR.getLayout()) != null) {
                    if (!ExpandableTextView.this.nQQ) {
                        if (layout.getLineCount() > ExpandableTextView.this.nQS) {
                            if (ExpandableTextView.this.lZB == null) {
                                String spannableStringBuilder = ExpandableTextView.this.lZA.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.nQS - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.nQS - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), at.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.lZB = new SpannableStringBuilder();
                                ExpandableTextView.this.lZB.append((CharSequence) substring2);
                                ExpandableTextView.this.lZB.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.lZB.length();
                                for (Object obj : ExpandableTextView.this.lZA.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.lZA.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.lZA.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.lZB.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.lZB.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.lZE, 0, spannableString.length(), 17);
                                ExpandableTextView.this.lZB.append((CharSequence) spannableString);
                                ExpandableTextView.this.lZD = new i(ExpandableTextView.this.lZB);
                                ((i) ExpandableTextView.this.lZD).KF(R.color.transparent);
                            }
                            ExpandableTextView.this.lZt.setVisibility(8);
                            ExpandableTextView.this.nQR.setOnTouchListener(ExpandableTextView.this.lZD);
                            ExpandableTextView.this.nQR.setText(ExpandableTextView.this.lZB);
                            if (ExpandableTextView.this.nQW) {
                                ExpandableTextView.this.dTU();
                            }
                        }
                    } else if (!ExpandableTextView.this.lZx) {
                        ExpandableTextView.this.lZx = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.nQY, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.lZA.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.lZA.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.lZA.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.lZC).KF(R.color.transparent);
                            ExpandableTextView.this.nQR.setOnTouchListener(ExpandableTextView.this.lZC);
                            ExpandableTextView.this.nQR.setText(ExpandableTextView.this.lZA);
                            ExpandableTextView.this.lZt.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.lZt.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.lZt.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.lZt.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.lZE = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dTU();
            }
        };
        this.nQY = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dTV();
            }
        };
        this.nQZ = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dTV();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 1;
        this.nQP = true;
        this.nQQ = false;
        this.lZx = false;
        this.nQS = 2;
        this.nQT = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.nQW = false;
        this.nQX = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.nQR != null && ExpandableTextView.this.lZA != null && ExpandableTextView.this.nQP && (layout = ExpandableTextView.this.nQR.getLayout()) != null) {
                    if (!ExpandableTextView.this.nQQ) {
                        if (layout.getLineCount() > ExpandableTextView.this.nQS) {
                            if (ExpandableTextView.this.lZB == null) {
                                String spannableStringBuilder = ExpandableTextView.this.lZA.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.nQS - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.nQS - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), at.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.lZB = new SpannableStringBuilder();
                                ExpandableTextView.this.lZB.append((CharSequence) substring2);
                                ExpandableTextView.this.lZB.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.lZB.length();
                                for (Object obj : ExpandableTextView.this.lZA.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.lZA.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.lZA.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.lZB.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.lZB.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.lZE, 0, spannableString.length(), 17);
                                ExpandableTextView.this.lZB.append((CharSequence) spannableString);
                                ExpandableTextView.this.lZD = new i(ExpandableTextView.this.lZB);
                                ((i) ExpandableTextView.this.lZD).KF(R.color.transparent);
                            }
                            ExpandableTextView.this.lZt.setVisibility(8);
                            ExpandableTextView.this.nQR.setOnTouchListener(ExpandableTextView.this.lZD);
                            ExpandableTextView.this.nQR.setText(ExpandableTextView.this.lZB);
                            if (ExpandableTextView.this.nQW) {
                                ExpandableTextView.this.dTU();
                            }
                        }
                    } else if (!ExpandableTextView.this.lZx) {
                        ExpandableTextView.this.lZx = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.nQY, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.lZA.append((CharSequence) spannableString2);
                            } else {
                                int i2 = (lineEnd2 - lineEnd3) + 1;
                                for (int i22 = 0; i22 < i2; i22++) {
                                    ExpandableTextView.this.lZA.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.lZA.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.lZC).KF(R.color.transparent);
                            ExpandableTextView.this.nQR.setOnTouchListener(ExpandableTextView.this.lZC);
                            ExpandableTextView.this.nQR.setText(ExpandableTextView.this.lZA);
                            ExpandableTextView.this.lZt.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.lZt.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.lZt.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.lZt.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.lZE = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dTU();
            }
        };
        this.nQY = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dTV();
            }
        };
        this.nQZ = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dTV();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
        this.nQR = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
        this.nQR.setTextSize(0, TbConfig.getContentSize());
        this.nQR.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.lZt = (TextView) findViewById(R.id.expandable_view_title_up);
        this.lZt.setOnClickListener(this.nQZ);
        this.textSize = l.getDimens(context, R.dimen.tbfontsize42);
        this.textColor = R.color.CAM_X0101;
        this.nQU = l.getDimens(context, R.dimen.tbds6);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.nQR.setTextSize(0, i);
        this.lZt.setTextSize(0, i);
    }

    public void setTextColor(int i) {
        this.textColor = i;
        ao.setViewTextColor(this.nQR, this.textColor, 1);
    }

    public void setLineSpacingExtra(int i) {
        this.nQU = i;
        this.nQR.setLineSpacing(i, 1.0f);
        this.lZt.setLineSpacing(i, 1.0f);
    }

    public void setTextMaxLine(int i) {
        this.nQT = i;
    }

    public void setExpandable(boolean z) {
        this.nQP = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.nQR.getViewTreeObserver().removeGlobalOnLayoutListener(this.nQX);
            } else {
                this.nQR.getViewTreeObserver().removeOnGlobalLayoutListener(this.nQX);
            }
            this.nQR.setMaxLines(this.nQT);
            this.nQR.setEllipsize(TextUtils.TruncateAt.END);
            this.nQR.setText(this.lZA);
            this.nQR.setOnTouchListener(null);
            this.lZt.setVisibility(8);
            return;
        }
        this.nQR.getViewTreeObserver().addOnGlobalLayoutListener(this.nQX);
        this.nQR.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.nQR.setEllipsize(null);
    }

    public void setExpandType(int i) {
        this.type = i;
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.lZt.setPadding(i, i2, i3, i4);
    }

    public void setData(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.nQW = z;
        this.lZA = new SpannableStringBuilder(charSequence);
        this.lZC = new i(this.lZA);
        this.nQR.setText(this.lZA);
        this.nQR.setLinkTextColor(ao.getColor(R.color.CAM_X0304));
        this.nQR.setOnTouchListener(this.lZC);
        ao.setViewTextColor(this.nQR, this.textColor, 1);
    }

    public TextView getContentView() {
        return this.nQR;
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.nQR, this.textColor, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTU() {
        this.nQQ = true;
        if (this.nQV != null) {
            this.nQV.rz(this.nQQ);
        }
        this.nQR.setOnTouchListener(this.lZC);
        this.nQR.setText(this.lZA);
        if (this.type == 1) {
            this.lZt.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTV() {
        this.nQQ = false;
        if (this.nQV != null) {
            this.nQV.rz(this.nQQ);
        }
        this.nQR.setOnTouchListener(this.lZD);
        this.nQR.setText(this.lZB);
        this.lZt.setVisibility(8);
    }

    public void setOnStatusChangedListener(a aVar) {
        this.nQV = aVar;
    }
}
