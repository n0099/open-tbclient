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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.view.i;
/* loaded from: classes.dex */
public class ExpandableTextView extends RelativeLayout {
    private TextView lKM;
    private boolean lKQ;
    private SpannableStringBuilder lKT;
    private SpannableStringBuilder lKU;
    private View.OnTouchListener lKV;
    private View.OnTouchListener lKW;
    private f lKX;
    private boolean nDV;
    private boolean nDW;
    private SpannableClickTextView nDX;
    private int nDY;
    private int nDZ;
    private int nEa;
    private a nEb;
    private boolean nEc;
    private ViewTreeObserver.OnGlobalLayoutListener nEd;
    private f nEe;
    private View.OnClickListener nEf;
    private int textColor;
    private int textSize;
    private int type;

    /* loaded from: classes.dex */
    public interface a {
        void qD(boolean z);
    }

    public ExpandableTextView(Context context) {
        super(context);
        this.type = 1;
        this.nDV = true;
        this.nDW = false;
        this.lKQ = false;
        this.nDY = 2;
        this.nDZ = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.nEc = false;
        this.nEd = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.nDX != null && ExpandableTextView.this.lKT != null && ExpandableTextView.this.nDV && (layout = ExpandableTextView.this.nDX.getLayout()) != null) {
                    if (!ExpandableTextView.this.nDW) {
                        if (layout.getLineCount() > ExpandableTextView.this.nDY) {
                            if (ExpandableTextView.this.lKU == null) {
                                String spannableStringBuilder = ExpandableTextView.this.lKT.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.nDY - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.nDY - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), au.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.lKU = new SpannableStringBuilder();
                                ExpandableTextView.this.lKU.append((CharSequence) substring2);
                                ExpandableTextView.this.lKU.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.lKU.length();
                                for (Object obj : ExpandableTextView.this.lKT.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.lKT.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.lKT.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.lKU.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.lKU.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.lKX, 0, spannableString.length(), 17);
                                ExpandableTextView.this.lKU.append((CharSequence) spannableString);
                                ExpandableTextView.this.lKW = new i(ExpandableTextView.this.lKU);
                                ((i) ExpandableTextView.this.lKW).LH(R.color.transparent);
                            }
                            ExpandableTextView.this.lKM.setVisibility(8);
                            ExpandableTextView.this.nDX.setOnTouchListener(ExpandableTextView.this.lKW);
                            ExpandableTextView.this.nDX.setText(ExpandableTextView.this.lKU);
                            if (ExpandableTextView.this.nEc) {
                                ExpandableTextView.this.dSN();
                            }
                        }
                    } else if (!ExpandableTextView.this.lKQ) {
                        ExpandableTextView.this.lKQ = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.nEe, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.lKT.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.lKT.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.lKT.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.lKV).LH(R.color.transparent);
                            ExpandableTextView.this.nDX.setOnTouchListener(ExpandableTextView.this.lKV);
                            ExpandableTextView.this.nDX.setText(ExpandableTextView.this.lKT);
                            ExpandableTextView.this.lKM.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.lKM.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.lKM.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.lKM.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.lKX = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dSN();
            }
        };
        this.nEe = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dSO();
            }
        };
        this.nEf = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dSO();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 1;
        this.nDV = true;
        this.nDW = false;
        this.lKQ = false;
        this.nDY = 2;
        this.nDZ = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.nEc = false;
        this.nEd = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.nDX != null && ExpandableTextView.this.lKT != null && ExpandableTextView.this.nDV && (layout = ExpandableTextView.this.nDX.getLayout()) != null) {
                    if (!ExpandableTextView.this.nDW) {
                        if (layout.getLineCount() > ExpandableTextView.this.nDY) {
                            if (ExpandableTextView.this.lKU == null) {
                                String spannableStringBuilder = ExpandableTextView.this.lKT.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.nDY - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.nDY - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), au.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.lKU = new SpannableStringBuilder();
                                ExpandableTextView.this.lKU.append((CharSequence) substring2);
                                ExpandableTextView.this.lKU.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.lKU.length();
                                for (Object obj : ExpandableTextView.this.lKT.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.lKT.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.lKT.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.lKU.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.lKU.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.lKX, 0, spannableString.length(), 17);
                                ExpandableTextView.this.lKU.append((CharSequence) spannableString);
                                ExpandableTextView.this.lKW = new i(ExpandableTextView.this.lKU);
                                ((i) ExpandableTextView.this.lKW).LH(R.color.transparent);
                            }
                            ExpandableTextView.this.lKM.setVisibility(8);
                            ExpandableTextView.this.nDX.setOnTouchListener(ExpandableTextView.this.lKW);
                            ExpandableTextView.this.nDX.setText(ExpandableTextView.this.lKU);
                            if (ExpandableTextView.this.nEc) {
                                ExpandableTextView.this.dSN();
                            }
                        }
                    } else if (!ExpandableTextView.this.lKQ) {
                        ExpandableTextView.this.lKQ = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.nEe, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.lKT.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.lKT.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.lKT.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.lKV).LH(R.color.transparent);
                            ExpandableTextView.this.nDX.setOnTouchListener(ExpandableTextView.this.lKV);
                            ExpandableTextView.this.nDX.setText(ExpandableTextView.this.lKT);
                            ExpandableTextView.this.lKM.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.lKM.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.lKM.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.lKM.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.lKX = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dSN();
            }
        };
        this.nEe = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dSO();
            }
        };
        this.nEf = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dSO();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 1;
        this.nDV = true;
        this.nDW = false;
        this.lKQ = false;
        this.nDY = 2;
        this.nDZ = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.nEc = false;
        this.nEd = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.nDX != null && ExpandableTextView.this.lKT != null && ExpandableTextView.this.nDV && (layout = ExpandableTextView.this.nDX.getLayout()) != null) {
                    if (!ExpandableTextView.this.nDW) {
                        if (layout.getLineCount() > ExpandableTextView.this.nDY) {
                            if (ExpandableTextView.this.lKU == null) {
                                String spannableStringBuilder = ExpandableTextView.this.lKT.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.nDY - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.nDY - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), au.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.lKU = new SpannableStringBuilder();
                                ExpandableTextView.this.lKU.append((CharSequence) substring2);
                                ExpandableTextView.this.lKU.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.lKU.length();
                                for (Object obj : ExpandableTextView.this.lKT.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.lKT.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.lKT.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.lKU.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.lKU.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.lKX, 0, spannableString.length(), 17);
                                ExpandableTextView.this.lKU.append((CharSequence) spannableString);
                                ExpandableTextView.this.lKW = new i(ExpandableTextView.this.lKU);
                                ((i) ExpandableTextView.this.lKW).LH(R.color.transparent);
                            }
                            ExpandableTextView.this.lKM.setVisibility(8);
                            ExpandableTextView.this.nDX.setOnTouchListener(ExpandableTextView.this.lKW);
                            ExpandableTextView.this.nDX.setText(ExpandableTextView.this.lKU);
                            if (ExpandableTextView.this.nEc) {
                                ExpandableTextView.this.dSN();
                            }
                        }
                    } else if (!ExpandableTextView.this.lKQ) {
                        ExpandableTextView.this.lKQ = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.nEe, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.lKT.append((CharSequence) spannableString2);
                            } else {
                                int i2 = (lineEnd2 - lineEnd3) + 1;
                                for (int i22 = 0; i22 < i2; i22++) {
                                    ExpandableTextView.this.lKT.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.lKT.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.lKV).LH(R.color.transparent);
                            ExpandableTextView.this.nDX.setOnTouchListener(ExpandableTextView.this.lKV);
                            ExpandableTextView.this.nDX.setText(ExpandableTextView.this.lKT);
                            ExpandableTextView.this.lKM.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.lKM.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.lKM.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.lKM.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.lKX = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dSN();
            }
        };
        this.nEe = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dSO();
            }
        };
        this.nEf = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dSO();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
        this.nDX = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
        this.nDX.setTextSize(0, TbConfig.getContentSize());
        this.nDX.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.lKM = (TextView) findViewById(R.id.expandable_view_title_up);
        this.lKM.setOnClickListener(this.nEf);
        this.textSize = l.getDimens(context, R.dimen.tbfontsize42);
        this.textColor = R.color.CAM_X0101;
        this.nEa = l.getDimens(context, R.dimen.tbds6);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.nDX.setTextSize(0, i);
        this.lKM.setTextSize(0, i);
    }

    public void setTextColor(int i) {
        this.textColor = i;
        ap.setViewTextColor(this.nDX, this.textColor, 1);
    }

    public void setLineSpacingExtra(int i) {
        this.nEa = i;
        this.nDX.setLineSpacing(i, 1.0f);
        this.lKM.setLineSpacing(i, 1.0f);
    }

    public void setTextMaxLine(int i) {
        this.nDZ = i;
    }

    public void setExpandable(boolean z) {
        this.nDV = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.nDX.getViewTreeObserver().removeGlobalOnLayoutListener(this.nEd);
            } else {
                this.nDX.getViewTreeObserver().removeOnGlobalLayoutListener(this.nEd);
            }
            this.nDX.setMaxLines(this.nDZ);
            this.nDX.setEllipsize(TextUtils.TruncateAt.END);
            this.nDX.setText(this.lKT);
            this.nDX.setOnTouchListener(null);
            this.lKM.setVisibility(8);
            return;
        }
        this.nDX.getViewTreeObserver().addOnGlobalLayoutListener(this.nEd);
        this.nDX.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.nDX.setEllipsize(null);
    }

    public void setExpandType(int i) {
        this.type = i;
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.lKM.setPadding(i, i2, i3, i4);
    }

    public void setData(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.nEc = z;
        this.lKT = new SpannableStringBuilder(charSequence);
        this.lKV = new i(this.lKT);
        this.nDX.setText(this.lKT);
        this.nDX.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
        this.nDX.setOnTouchListener(this.lKV);
        ap.setViewTextColor(this.nDX, this.textColor, 1);
    }

    public TextView getContentView() {
        return this.nDX;
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.nDX, this.textColor, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSN() {
        this.nDW = true;
        if (this.nEb != null) {
            this.nEb.qD(this.nDW);
        }
        this.nDX.setOnTouchListener(this.lKV);
        this.nDX.setText(this.lKT);
        if (this.type == 1) {
            this.lKM.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSO() {
        this.nDW = false;
        if (this.nEb != null) {
            this.nEb.qD(this.nDW);
        }
        this.nDX.setOnTouchListener(this.lKW);
        this.nDX.setText(this.lKU);
        this.lKM.setVisibility(8);
    }

    public void setOnStatusChangedListener(a aVar) {
        this.nEb = aVar;
    }
}
