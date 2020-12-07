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
    private TextView lYK;
    private boolean lYO;
    private SpannableStringBuilder lYR;
    private SpannableStringBuilder lYS;
    private View.OnTouchListener lYT;
    private View.OnTouchListener lYU;
    private f lYV;
    private boolean nRX;
    private boolean nRY;
    private SpannableClickTextView nRZ;
    private int nSa;
    private int nSb;
    private int nSc;
    private a nSd;
    private boolean nSe;
    private ViewTreeObserver.OnGlobalLayoutListener nSf;
    private f nSg;
    private View.OnClickListener nSh;
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
        this.nRX = true;
        this.nRY = false;
        this.lYO = false;
        this.nSa = 2;
        this.nSb = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.nSe = false;
        this.nSf = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.nRZ != null && ExpandableTextView.this.lYR != null && ExpandableTextView.this.nRX && (layout = ExpandableTextView.this.nRZ.getLayout()) != null) {
                    if (!ExpandableTextView.this.nRY) {
                        if (layout.getLineCount() > ExpandableTextView.this.nSa) {
                            if (ExpandableTextView.this.lYS == null) {
                                String spannableStringBuilder = ExpandableTextView.this.lYR.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.nSa - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.nSa - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), au.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.lYS = new SpannableStringBuilder();
                                ExpandableTextView.this.lYS.append((CharSequence) substring2);
                                ExpandableTextView.this.lYS.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.lYS.length();
                                for (Object obj : ExpandableTextView.this.lYR.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.lYR.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.lYR.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.lYS.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.lYS.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.lYV, 0, spannableString.length(), 17);
                                ExpandableTextView.this.lYS.append((CharSequence) spannableString);
                                ExpandableTextView.this.lYU = new i(ExpandableTextView.this.lYS);
                                ((i) ExpandableTextView.this.lYU).Mz(R.color.transparent);
                            }
                            ExpandableTextView.this.lYK.setVisibility(8);
                            ExpandableTextView.this.nRZ.setOnTouchListener(ExpandableTextView.this.lYU);
                            ExpandableTextView.this.nRZ.setText(ExpandableTextView.this.lYS);
                            if (ExpandableTextView.this.nSe) {
                                ExpandableTextView.this.dYh();
                            }
                        }
                    } else if (!ExpandableTextView.this.lYO) {
                        ExpandableTextView.this.lYO = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.nSg, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.lYR.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.lYR.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.lYR.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.lYT).Mz(R.color.transparent);
                            ExpandableTextView.this.nRZ.setOnTouchListener(ExpandableTextView.this.lYT);
                            ExpandableTextView.this.nRZ.setText(ExpandableTextView.this.lYR);
                            ExpandableTextView.this.lYK.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.lYK.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.lYK.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.lYK.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.lYV = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dYh();
            }
        };
        this.nSg = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dYi();
            }
        };
        this.nSh = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dYi();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 1;
        this.nRX = true;
        this.nRY = false;
        this.lYO = false;
        this.nSa = 2;
        this.nSb = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.nSe = false;
        this.nSf = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.nRZ != null && ExpandableTextView.this.lYR != null && ExpandableTextView.this.nRX && (layout = ExpandableTextView.this.nRZ.getLayout()) != null) {
                    if (!ExpandableTextView.this.nRY) {
                        if (layout.getLineCount() > ExpandableTextView.this.nSa) {
                            if (ExpandableTextView.this.lYS == null) {
                                String spannableStringBuilder = ExpandableTextView.this.lYR.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.nSa - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.nSa - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), au.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.lYS = new SpannableStringBuilder();
                                ExpandableTextView.this.lYS.append((CharSequence) substring2);
                                ExpandableTextView.this.lYS.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.lYS.length();
                                for (Object obj : ExpandableTextView.this.lYR.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.lYR.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.lYR.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.lYS.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.lYS.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.lYV, 0, spannableString.length(), 17);
                                ExpandableTextView.this.lYS.append((CharSequence) spannableString);
                                ExpandableTextView.this.lYU = new i(ExpandableTextView.this.lYS);
                                ((i) ExpandableTextView.this.lYU).Mz(R.color.transparent);
                            }
                            ExpandableTextView.this.lYK.setVisibility(8);
                            ExpandableTextView.this.nRZ.setOnTouchListener(ExpandableTextView.this.lYU);
                            ExpandableTextView.this.nRZ.setText(ExpandableTextView.this.lYS);
                            if (ExpandableTextView.this.nSe) {
                                ExpandableTextView.this.dYh();
                            }
                        }
                    } else if (!ExpandableTextView.this.lYO) {
                        ExpandableTextView.this.lYO = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.nSg, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.lYR.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.lYR.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.lYR.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.lYT).Mz(R.color.transparent);
                            ExpandableTextView.this.nRZ.setOnTouchListener(ExpandableTextView.this.lYT);
                            ExpandableTextView.this.nRZ.setText(ExpandableTextView.this.lYR);
                            ExpandableTextView.this.lYK.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.lYK.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.lYK.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.lYK.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.lYV = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dYh();
            }
        };
        this.nSg = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dYi();
            }
        };
        this.nSh = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dYi();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 1;
        this.nRX = true;
        this.nRY = false;
        this.lYO = false;
        this.nSa = 2;
        this.nSb = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.nSe = false;
        this.nSf = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.nRZ != null && ExpandableTextView.this.lYR != null && ExpandableTextView.this.nRX && (layout = ExpandableTextView.this.nRZ.getLayout()) != null) {
                    if (!ExpandableTextView.this.nRY) {
                        if (layout.getLineCount() > ExpandableTextView.this.nSa) {
                            if (ExpandableTextView.this.lYS == null) {
                                String spannableStringBuilder = ExpandableTextView.this.lYR.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.nSa - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.nSa - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), au.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.lYS = new SpannableStringBuilder();
                                ExpandableTextView.this.lYS.append((CharSequence) substring2);
                                ExpandableTextView.this.lYS.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.lYS.length();
                                for (Object obj : ExpandableTextView.this.lYR.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.lYR.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.lYR.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.lYS.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.lYS.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.lYV, 0, spannableString.length(), 17);
                                ExpandableTextView.this.lYS.append((CharSequence) spannableString);
                                ExpandableTextView.this.lYU = new i(ExpandableTextView.this.lYS);
                                ((i) ExpandableTextView.this.lYU).Mz(R.color.transparent);
                            }
                            ExpandableTextView.this.lYK.setVisibility(8);
                            ExpandableTextView.this.nRZ.setOnTouchListener(ExpandableTextView.this.lYU);
                            ExpandableTextView.this.nRZ.setText(ExpandableTextView.this.lYS);
                            if (ExpandableTextView.this.nSe) {
                                ExpandableTextView.this.dYh();
                            }
                        }
                    } else if (!ExpandableTextView.this.lYO) {
                        ExpandableTextView.this.lYO = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.nSg, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.lYR.append((CharSequence) spannableString2);
                            } else {
                                int i2 = (lineEnd2 - lineEnd3) + 1;
                                for (int i22 = 0; i22 < i2; i22++) {
                                    ExpandableTextView.this.lYR.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.lYR.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.lYT).Mz(R.color.transparent);
                            ExpandableTextView.this.nRZ.setOnTouchListener(ExpandableTextView.this.lYT);
                            ExpandableTextView.this.nRZ.setText(ExpandableTextView.this.lYR);
                            ExpandableTextView.this.lYK.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.lYK.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.lYK.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.lYK.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.lYV = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dYh();
            }
        };
        this.nSg = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dYi();
            }
        };
        this.nSh = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dYi();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
        this.nRZ = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
        this.nRZ.setTextSize(0, TbConfig.getContentSize());
        this.nRZ.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.lYK = (TextView) findViewById(R.id.expandable_view_title_up);
        this.lYK.setOnClickListener(this.nSh);
        this.textSize = l.getDimens(context, R.dimen.tbfontsize42);
        this.textColor = R.color.CAM_X0101;
        this.nSc = l.getDimens(context, R.dimen.tbds6);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.nRZ.setTextSize(0, i);
        this.lYK.setTextSize(0, i);
    }

    public void setTextColor(int i) {
        this.textColor = i;
        ap.setViewTextColor(this.nRZ, this.textColor, 1);
    }

    public void setLineSpacingExtra(int i) {
        this.nSc = i;
        this.nRZ.setLineSpacing(i, 1.0f);
        this.lYK.setLineSpacing(i, 1.0f);
    }

    public void setTextMaxLine(int i) {
        this.nSb = i;
    }

    public void setExpandable(boolean z) {
        this.nRX = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.nRZ.getViewTreeObserver().removeGlobalOnLayoutListener(this.nSf);
            } else {
                this.nRZ.getViewTreeObserver().removeOnGlobalLayoutListener(this.nSf);
            }
            this.nRZ.setMaxLines(this.nSb);
            this.nRZ.setEllipsize(TextUtils.TruncateAt.END);
            this.nRZ.setText(this.lYR);
            this.nRZ.setOnTouchListener(null);
            this.lYK.setVisibility(8);
            return;
        }
        this.nRZ.getViewTreeObserver().addOnGlobalLayoutListener(this.nSf);
        this.nRZ.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.nRZ.setEllipsize(null);
    }

    public void setExpandType(int i) {
        this.type = i;
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.lYK.setPadding(i, i2, i3, i4);
    }

    public void setData(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.nSe = z;
        this.lYR = new SpannableStringBuilder(charSequence);
        this.lYT = new i(this.lYR);
        this.nRZ.setText(this.lYR);
        this.nRZ.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
        this.nRZ.setOnTouchListener(this.lYT);
        ap.setViewTextColor(this.nRZ, this.textColor, 1);
    }

    public TextView getContentView() {
        return this.nRZ;
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.nRZ, this.textColor, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYh() {
        this.nRY = true;
        if (this.nSd != null) {
            this.nSd.re(this.nRY);
        }
        this.nRZ.setOnTouchListener(this.lYT);
        this.nRZ.setText(this.lYR);
        if (this.type == 1) {
            this.lYK.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYi() {
        this.nRY = false;
        if (this.nSd != null) {
            this.nSd.re(this.nRY);
        }
        this.nRZ.setOnTouchListener(this.lYU);
        this.nRZ.setText(this.lYS);
        this.lYK.setVisibility(8);
    }

    public void setOnStatusChangedListener(a aVar) {
        this.nSd = aVar;
    }
}
