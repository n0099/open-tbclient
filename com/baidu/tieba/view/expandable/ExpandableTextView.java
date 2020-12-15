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
    private TextView lYM;
    private boolean lYQ;
    private SpannableStringBuilder lYT;
    private SpannableStringBuilder lYU;
    private View.OnTouchListener lYV;
    private View.OnTouchListener lYW;
    private f lYX;
    private boolean nRZ;
    private boolean nSa;
    private SpannableClickTextView nSb;
    private int nSc;
    private int nSd;
    private int nSe;
    private a nSf;
    private boolean nSg;
    private ViewTreeObserver.OnGlobalLayoutListener nSh;
    private f nSi;
    private View.OnClickListener nSj;
    private int textColor;
    private int textSize;
    private int type;

    /* loaded from: classes.dex */
    public interface a {
        void re(boolean z);
    }

    public ExpandableTextView(Context context) {
        super(context);
        this.type = 1;
        this.nRZ = true;
        this.nSa = false;
        this.lYQ = false;
        this.nSc = 2;
        this.nSd = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.nSg = false;
        this.nSh = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.nSb != null && ExpandableTextView.this.lYT != null && ExpandableTextView.this.nRZ && (layout = ExpandableTextView.this.nSb.getLayout()) != null) {
                    if (!ExpandableTextView.this.nSa) {
                        if (layout.getLineCount() > ExpandableTextView.this.nSc) {
                            if (ExpandableTextView.this.lYU == null) {
                                String spannableStringBuilder = ExpandableTextView.this.lYT.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.nSc - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.nSc - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), au.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.lYU = new SpannableStringBuilder();
                                ExpandableTextView.this.lYU.append((CharSequence) substring2);
                                ExpandableTextView.this.lYU.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.lYU.length();
                                for (Object obj : ExpandableTextView.this.lYT.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.lYT.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.lYT.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.lYU.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.lYU.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.lYX, 0, spannableString.length(), 17);
                                ExpandableTextView.this.lYU.append((CharSequence) spannableString);
                                ExpandableTextView.this.lYW = new i(ExpandableTextView.this.lYU);
                                ((i) ExpandableTextView.this.lYW).Mz(R.color.transparent);
                            }
                            ExpandableTextView.this.lYM.setVisibility(8);
                            ExpandableTextView.this.nSb.setOnTouchListener(ExpandableTextView.this.lYW);
                            ExpandableTextView.this.nSb.setText(ExpandableTextView.this.lYU);
                            if (ExpandableTextView.this.nSg) {
                                ExpandableTextView.this.dYi();
                            }
                        }
                    } else if (!ExpandableTextView.this.lYQ) {
                        ExpandableTextView.this.lYQ = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.nSi, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.lYT.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.lYT.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.lYT.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.lYV).Mz(R.color.transparent);
                            ExpandableTextView.this.nSb.setOnTouchListener(ExpandableTextView.this.lYV);
                            ExpandableTextView.this.nSb.setText(ExpandableTextView.this.lYT);
                            ExpandableTextView.this.lYM.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.lYM.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.lYM.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.lYM.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.lYX = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dYi();
            }
        };
        this.nSi = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dYj();
            }
        };
        this.nSj = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dYj();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 1;
        this.nRZ = true;
        this.nSa = false;
        this.lYQ = false;
        this.nSc = 2;
        this.nSd = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.nSg = false;
        this.nSh = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.nSb != null && ExpandableTextView.this.lYT != null && ExpandableTextView.this.nRZ && (layout = ExpandableTextView.this.nSb.getLayout()) != null) {
                    if (!ExpandableTextView.this.nSa) {
                        if (layout.getLineCount() > ExpandableTextView.this.nSc) {
                            if (ExpandableTextView.this.lYU == null) {
                                String spannableStringBuilder = ExpandableTextView.this.lYT.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.nSc - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.nSc - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), au.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.lYU = new SpannableStringBuilder();
                                ExpandableTextView.this.lYU.append((CharSequence) substring2);
                                ExpandableTextView.this.lYU.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.lYU.length();
                                for (Object obj : ExpandableTextView.this.lYT.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.lYT.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.lYT.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.lYU.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.lYU.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.lYX, 0, spannableString.length(), 17);
                                ExpandableTextView.this.lYU.append((CharSequence) spannableString);
                                ExpandableTextView.this.lYW = new i(ExpandableTextView.this.lYU);
                                ((i) ExpandableTextView.this.lYW).Mz(R.color.transparent);
                            }
                            ExpandableTextView.this.lYM.setVisibility(8);
                            ExpandableTextView.this.nSb.setOnTouchListener(ExpandableTextView.this.lYW);
                            ExpandableTextView.this.nSb.setText(ExpandableTextView.this.lYU);
                            if (ExpandableTextView.this.nSg) {
                                ExpandableTextView.this.dYi();
                            }
                        }
                    } else if (!ExpandableTextView.this.lYQ) {
                        ExpandableTextView.this.lYQ = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.nSi, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.lYT.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.lYT.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.lYT.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.lYV).Mz(R.color.transparent);
                            ExpandableTextView.this.nSb.setOnTouchListener(ExpandableTextView.this.lYV);
                            ExpandableTextView.this.nSb.setText(ExpandableTextView.this.lYT);
                            ExpandableTextView.this.lYM.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.lYM.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.lYM.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.lYM.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.lYX = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dYi();
            }
        };
        this.nSi = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dYj();
            }
        };
        this.nSj = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dYj();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 1;
        this.nRZ = true;
        this.nSa = false;
        this.lYQ = false;
        this.nSc = 2;
        this.nSd = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.nSg = false;
        this.nSh = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.nSb != null && ExpandableTextView.this.lYT != null && ExpandableTextView.this.nRZ && (layout = ExpandableTextView.this.nSb.getLayout()) != null) {
                    if (!ExpandableTextView.this.nSa) {
                        if (layout.getLineCount() > ExpandableTextView.this.nSc) {
                            if (ExpandableTextView.this.lYU == null) {
                                String spannableStringBuilder = ExpandableTextView.this.lYT.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.nSc - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.nSc - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), au.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.lYU = new SpannableStringBuilder();
                                ExpandableTextView.this.lYU.append((CharSequence) substring2);
                                ExpandableTextView.this.lYU.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.lYU.length();
                                for (Object obj : ExpandableTextView.this.lYT.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.lYT.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.lYT.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.lYU.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.lYU.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.lYX, 0, spannableString.length(), 17);
                                ExpandableTextView.this.lYU.append((CharSequence) spannableString);
                                ExpandableTextView.this.lYW = new i(ExpandableTextView.this.lYU);
                                ((i) ExpandableTextView.this.lYW).Mz(R.color.transparent);
                            }
                            ExpandableTextView.this.lYM.setVisibility(8);
                            ExpandableTextView.this.nSb.setOnTouchListener(ExpandableTextView.this.lYW);
                            ExpandableTextView.this.nSb.setText(ExpandableTextView.this.lYU);
                            if (ExpandableTextView.this.nSg) {
                                ExpandableTextView.this.dYi();
                            }
                        }
                    } else if (!ExpandableTextView.this.lYQ) {
                        ExpandableTextView.this.lYQ = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.nSi, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.lYT.append((CharSequence) spannableString2);
                            } else {
                                int i2 = (lineEnd2 - lineEnd3) + 1;
                                for (int i22 = 0; i22 < i2; i22++) {
                                    ExpandableTextView.this.lYT.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.lYT.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.lYV).Mz(R.color.transparent);
                            ExpandableTextView.this.nSb.setOnTouchListener(ExpandableTextView.this.lYV);
                            ExpandableTextView.this.nSb.setText(ExpandableTextView.this.lYT);
                            ExpandableTextView.this.lYM.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.lYM.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.lYM.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.lYM.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.lYX = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dYi();
            }
        };
        this.nSi = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dYj();
            }
        };
        this.nSj = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dYj();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
        this.nSb = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
        this.nSb.setTextSize(0, TbConfig.getContentSize());
        this.nSb.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.lYM = (TextView) findViewById(R.id.expandable_view_title_up);
        this.lYM.setOnClickListener(this.nSj);
        this.textSize = l.getDimens(context, R.dimen.tbfontsize42);
        this.textColor = R.color.CAM_X0101;
        this.nSe = l.getDimens(context, R.dimen.tbds6);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.nSb.setTextSize(0, i);
        this.lYM.setTextSize(0, i);
    }

    public void setTextColor(int i) {
        this.textColor = i;
        ap.setViewTextColor(this.nSb, this.textColor, 1);
    }

    public void setLineSpacingExtra(int i) {
        this.nSe = i;
        this.nSb.setLineSpacing(i, 1.0f);
        this.lYM.setLineSpacing(i, 1.0f);
    }

    public void setTextMaxLine(int i) {
        this.nSd = i;
    }

    public void setExpandable(boolean z) {
        this.nRZ = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.nSb.getViewTreeObserver().removeGlobalOnLayoutListener(this.nSh);
            } else {
                this.nSb.getViewTreeObserver().removeOnGlobalLayoutListener(this.nSh);
            }
            this.nSb.setMaxLines(this.nSd);
            this.nSb.setEllipsize(TextUtils.TruncateAt.END);
            this.nSb.setText(this.lYT);
            this.nSb.setOnTouchListener(null);
            this.lYM.setVisibility(8);
            return;
        }
        this.nSb.getViewTreeObserver().addOnGlobalLayoutListener(this.nSh);
        this.nSb.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.nSb.setEllipsize(null);
    }

    public void setExpandType(int i) {
        this.type = i;
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.lYM.setPadding(i, i2, i3, i4);
    }

    public void setData(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.nSg = z;
        this.lYT = new SpannableStringBuilder(charSequence);
        this.lYV = new i(this.lYT);
        this.nSb.setText(this.lYT);
        this.nSb.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
        this.nSb.setOnTouchListener(this.lYV);
        ap.setViewTextColor(this.nSb, this.textColor, 1);
    }

    public TextView getContentView() {
        return this.nSb;
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.nSb, this.textColor, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYi() {
        this.nSa = true;
        if (this.nSf != null) {
            this.nSf.re(this.nSa);
        }
        this.nSb.setOnTouchListener(this.lYV);
        this.nSb.setText(this.lYT);
        if (this.type == 1) {
            this.lYM.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYj() {
        this.nSa = false;
        if (this.nSf != null) {
            this.nSf.re(this.nSa);
        }
        this.nSb.setOnTouchListener(this.lYW);
        this.nSb.setText(this.lYU);
        this.lYM.setVisibility(8);
    }

    public void setOnStatusChangedListener(a aVar) {
        this.nSf = aVar;
    }
}
