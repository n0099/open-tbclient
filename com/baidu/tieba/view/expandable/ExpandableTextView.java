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
    private TextView iRT;
    private boolean iRX;
    private SpannableStringBuilder iSa;
    private SpannableStringBuilder iSb;
    private View.OnTouchListener iSc;
    private View.OnTouchListener iSd;
    private f iSe;
    private boolean kFc;
    private boolean kFd;
    private SpannableClickTextView kFe;
    private int kFf;
    private int kFg;
    private int kFh;
    private a kFi;
    private boolean kFj;
    private ViewTreeObserver.OnGlobalLayoutListener kFk;
    private f kFl;
    private View.OnClickListener kFm;
    private int textColor;
    private int textSize;
    private int type;

    /* loaded from: classes.dex */
    public interface a {
        void lZ(boolean z);
    }

    public ExpandableTextView(Context context) {
        super(context);
        this.type = 1;
        this.kFc = true;
        this.kFd = false;
        this.iRX = false;
        this.kFf = 2;
        this.kFg = Integer.MAX_VALUE;
        this.kFj = false;
        this.kFk = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.kFe != null && ExpandableTextView.this.iSa != null && ExpandableTextView.this.kFc && (layout = ExpandableTextView.this.kFe.getLayout()) != null) {
                    if (!ExpandableTextView.this.kFd) {
                        if (layout.getLineCount() > ExpandableTextView.this.kFf) {
                            if (ExpandableTextView.this.iSb == null) {
                                String spannableStringBuilder = ExpandableTextView.this.iSa.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.kFf - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.kFf - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.iSb = new SpannableStringBuilder();
                                ExpandableTextView.this.iSb.append((CharSequence) substring2);
                                ExpandableTextView.this.iSb.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.iSb.length();
                                for (Object obj : ExpandableTextView.this.iSa.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.iSa.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.iSa.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.iSb.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.iSb.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.iSe, 0, spannableString.length(), 17);
                                ExpandableTextView.this.iSb.append((CharSequence) spannableString);
                                ExpandableTextView.this.iSd = new h(ExpandableTextView.this.iSb);
                                ((h) ExpandableTextView.this.iSd).DK(R.color.transparent);
                            }
                            ExpandableTextView.this.iRT.setVisibility(8);
                            ExpandableTextView.this.kFe.setOnTouchListener(ExpandableTextView.this.iSd);
                            ExpandableTextView.this.kFe.setText(ExpandableTextView.this.iSb);
                            if (ExpandableTextView.this.kFj) {
                                ExpandableTextView.this.cRb();
                            }
                        }
                    } else if (!ExpandableTextView.this.iRX) {
                        ExpandableTextView.this.iRX = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.kFl, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.iSa.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.iSa.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.iSa.append((CharSequence) spannableString2);
                            }
                            ((h) ExpandableTextView.this.iSc).DK(R.color.transparent);
                            ExpandableTextView.this.kFe.setOnTouchListener(ExpandableTextView.this.iSc);
                            ExpandableTextView.this.kFe.setText(ExpandableTextView.this.iSa);
                            ExpandableTextView.this.iRT.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.iRT.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.iRT.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.iRT.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.iSe = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cRb();
            }
        };
        this.kFl = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cRc();
            }
        };
        this.kFm = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.cRc();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 1;
        this.kFc = true;
        this.kFd = false;
        this.iRX = false;
        this.kFf = 2;
        this.kFg = Integer.MAX_VALUE;
        this.kFj = false;
        this.kFk = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.kFe != null && ExpandableTextView.this.iSa != null && ExpandableTextView.this.kFc && (layout = ExpandableTextView.this.kFe.getLayout()) != null) {
                    if (!ExpandableTextView.this.kFd) {
                        if (layout.getLineCount() > ExpandableTextView.this.kFf) {
                            if (ExpandableTextView.this.iSb == null) {
                                String spannableStringBuilder = ExpandableTextView.this.iSa.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.kFf - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.kFf - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.iSb = new SpannableStringBuilder();
                                ExpandableTextView.this.iSb.append((CharSequence) substring2);
                                ExpandableTextView.this.iSb.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.iSb.length();
                                for (Object obj : ExpandableTextView.this.iSa.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.iSa.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.iSa.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.iSb.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.iSb.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.iSe, 0, spannableString.length(), 17);
                                ExpandableTextView.this.iSb.append((CharSequence) spannableString);
                                ExpandableTextView.this.iSd = new h(ExpandableTextView.this.iSb);
                                ((h) ExpandableTextView.this.iSd).DK(R.color.transparent);
                            }
                            ExpandableTextView.this.iRT.setVisibility(8);
                            ExpandableTextView.this.kFe.setOnTouchListener(ExpandableTextView.this.iSd);
                            ExpandableTextView.this.kFe.setText(ExpandableTextView.this.iSb);
                            if (ExpandableTextView.this.kFj) {
                                ExpandableTextView.this.cRb();
                            }
                        }
                    } else if (!ExpandableTextView.this.iRX) {
                        ExpandableTextView.this.iRX = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.kFl, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.iSa.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.iSa.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.iSa.append((CharSequence) spannableString2);
                            }
                            ((h) ExpandableTextView.this.iSc).DK(R.color.transparent);
                            ExpandableTextView.this.kFe.setOnTouchListener(ExpandableTextView.this.iSc);
                            ExpandableTextView.this.kFe.setText(ExpandableTextView.this.iSa);
                            ExpandableTextView.this.iRT.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.iRT.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.iRT.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.iRT.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.iSe = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cRb();
            }
        };
        this.kFl = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cRc();
            }
        };
        this.kFm = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.cRc();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 1;
        this.kFc = true;
        this.kFd = false;
        this.iRX = false;
        this.kFf = 2;
        this.kFg = Integer.MAX_VALUE;
        this.kFj = false;
        this.kFk = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.kFe != null && ExpandableTextView.this.iSa != null && ExpandableTextView.this.kFc && (layout = ExpandableTextView.this.kFe.getLayout()) != null) {
                    if (!ExpandableTextView.this.kFd) {
                        if (layout.getLineCount() > ExpandableTextView.this.kFf) {
                            if (ExpandableTextView.this.iSb == null) {
                                String spannableStringBuilder = ExpandableTextView.this.iSa.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.kFf - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.kFf - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.iSb = new SpannableStringBuilder();
                                ExpandableTextView.this.iSb.append((CharSequence) substring2);
                                ExpandableTextView.this.iSb.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.iSb.length();
                                for (Object obj : ExpandableTextView.this.iSa.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.iSa.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.iSa.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.iSb.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.iSb.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.iSe, 0, spannableString.length(), 17);
                                ExpandableTextView.this.iSb.append((CharSequence) spannableString);
                                ExpandableTextView.this.iSd = new h(ExpandableTextView.this.iSb);
                                ((h) ExpandableTextView.this.iSd).DK(R.color.transparent);
                            }
                            ExpandableTextView.this.iRT.setVisibility(8);
                            ExpandableTextView.this.kFe.setOnTouchListener(ExpandableTextView.this.iSd);
                            ExpandableTextView.this.kFe.setText(ExpandableTextView.this.iSb);
                            if (ExpandableTextView.this.kFj) {
                                ExpandableTextView.this.cRb();
                            }
                        }
                    } else if (!ExpandableTextView.this.iRX) {
                        ExpandableTextView.this.iRX = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.kFl, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.iSa.append((CharSequence) spannableString2);
                            } else {
                                int i2 = (lineEnd2 - lineEnd3) + 1;
                                for (int i22 = 0; i22 < i2; i22++) {
                                    ExpandableTextView.this.iSa.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.iSa.append((CharSequence) spannableString2);
                            }
                            ((h) ExpandableTextView.this.iSc).DK(R.color.transparent);
                            ExpandableTextView.this.kFe.setOnTouchListener(ExpandableTextView.this.iSc);
                            ExpandableTextView.this.kFe.setText(ExpandableTextView.this.iSa);
                            ExpandableTextView.this.iRT.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.iRT.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.iRT.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.iRT.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.iSe = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cRb();
            }
        };
        this.kFl = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cRc();
            }
        };
        this.kFm = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.cRc();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
        this.kFe = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
        this.kFe.setTextSize(0, TbConfig.getContentSize());
        this.kFe.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.iRT = (TextView) findViewById(R.id.expandable_view_title_up);
        this.iRT.setOnClickListener(this.kFm);
        this.textSize = l.getDimens(context, R.dimen.tbfontsize42);
        this.textColor = R.color.cp_cont_a;
        this.kFh = l.getDimens(context, R.dimen.tbds6);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.kFe.setTextSize(0, i);
        this.iRT.setTextSize(0, i);
    }

    public void setTextColor(int i) {
        this.textColor = i;
        am.setViewTextColor(this.kFe, this.textColor, 1);
    }

    public void setLineSpacingExtra(int i) {
        this.kFh = i;
        this.kFe.setLineSpacing(i, 1.0f);
        this.iRT.setLineSpacing(i, 1.0f);
    }

    public void setTextMaxLine(int i) {
        this.kFg = i;
    }

    public void setExpandable(boolean z) {
        this.kFc = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.kFe.getViewTreeObserver().removeGlobalOnLayoutListener(this.kFk);
            } else {
                this.kFe.getViewTreeObserver().removeOnGlobalLayoutListener(this.kFk);
            }
            this.kFe.setMaxLines(this.kFg);
            this.kFe.setEllipsize(TextUtils.TruncateAt.END);
            this.kFe.setText(this.iSa);
            this.kFe.setOnTouchListener(null);
            this.iRT.setVisibility(8);
            return;
        }
        this.kFe.getViewTreeObserver().addOnGlobalLayoutListener(this.kFk);
        this.kFe.setMaxLines(Integer.MAX_VALUE);
        this.kFe.setEllipsize(null);
    }

    public void setExpandType(int i) {
        this.type = i;
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.iRT.setPadding(i, i2, i3, i4);
    }

    public void setData(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.kFj = z;
        this.iSa = new SpannableStringBuilder(charSequence);
        this.iSc = new h(this.iSa);
        this.kFe.setText(this.iSa);
        this.kFe.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        this.kFe.setOnTouchListener(this.iSc);
        am.setViewTextColor(this.kFe, this.textColor, 1);
    }

    public TextView getContentView() {
        return this.kFe;
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.kFe, this.textColor, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRb() {
        this.kFd = true;
        if (this.kFi != null) {
            this.kFi.lZ(this.kFd);
        }
        this.kFe.setOnTouchListener(this.iSc);
        this.kFe.setText(this.iSa);
        if (this.type == 1) {
            this.iRT.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRc() {
        this.kFd = false;
        if (this.kFi != null) {
            this.kFi.lZ(this.kFd);
        }
        this.kFe.setOnTouchListener(this.iSd);
        this.kFe.setText(this.iSb);
        this.iRT.setVisibility(8);
    }

    public void setOnStatusChangedListener(a aVar) {
        this.kFi = aVar;
    }
}
