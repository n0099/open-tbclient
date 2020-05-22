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
    private TextView kaC;
    private boolean kaG;
    private SpannableStringBuilder kaJ;
    private SpannableStringBuilder kaK;
    private View.OnTouchListener kaL;
    private View.OnTouchListener kaM;
    private f kaN;
    private boolean lOQ;
    private boolean lOR;
    private SpannableClickTextView lOS;
    private int lOT;
    private int lOU;
    private int lOV;
    private a lOW;
    private boolean lOX;
    private ViewTreeObserver.OnGlobalLayoutListener lOY;
    private f lOZ;
    private View.OnClickListener lPa;
    private int textColor;
    private int textSize;
    private int type;

    /* loaded from: classes.dex */
    public interface a {
        void nR(boolean z);
    }

    public ExpandableTextView(Context context) {
        super(context);
        this.type = 1;
        this.lOQ = true;
        this.lOR = false;
        this.kaG = false;
        this.lOT = 2;
        this.lOU = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.lOX = false;
        this.lOY = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.lOS != null && ExpandableTextView.this.kaJ != null && ExpandableTextView.this.lOQ && (layout = ExpandableTextView.this.lOS.getLayout()) != null) {
                    if (!ExpandableTextView.this.lOR) {
                        if (layout.getLineCount() > ExpandableTextView.this.lOT) {
                            if (ExpandableTextView.this.kaK == null) {
                                String spannableStringBuilder = ExpandableTextView.this.kaJ.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.lOT - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.lOT - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.kaK = new SpannableStringBuilder();
                                ExpandableTextView.this.kaK.append((CharSequence) substring2);
                                ExpandableTextView.this.kaK.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.kaK.length();
                                for (Object obj : ExpandableTextView.this.kaJ.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.kaJ.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.kaJ.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.kaK.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.kaK.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.kaN, 0, spannableString.length(), 17);
                                ExpandableTextView.this.kaK.append((CharSequence) spannableString);
                                ExpandableTextView.this.kaM = new i(ExpandableTextView.this.kaK);
                                ((i) ExpandableTextView.this.kaM).Fr(R.color.transparent);
                            }
                            ExpandableTextView.this.kaC.setVisibility(8);
                            ExpandableTextView.this.lOS.setOnTouchListener(ExpandableTextView.this.kaM);
                            ExpandableTextView.this.lOS.setText(ExpandableTextView.this.kaK);
                            if (ExpandableTextView.this.lOX) {
                                ExpandableTextView.this.dmb();
                            }
                        }
                    } else if (!ExpandableTextView.this.kaG) {
                        ExpandableTextView.this.kaG = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.lOZ, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.kaJ.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.kaJ.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.kaJ.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.kaL).Fr(R.color.transparent);
                            ExpandableTextView.this.lOS.setOnTouchListener(ExpandableTextView.this.kaL);
                            ExpandableTextView.this.lOS.setText(ExpandableTextView.this.kaJ);
                            ExpandableTextView.this.kaC.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.kaC.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.kaC.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.kaC.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.kaN = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dmb();
            }
        };
        this.lOZ = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dmc();
            }
        };
        this.lPa = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dmc();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 1;
        this.lOQ = true;
        this.lOR = false;
        this.kaG = false;
        this.lOT = 2;
        this.lOU = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.lOX = false;
        this.lOY = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.lOS != null && ExpandableTextView.this.kaJ != null && ExpandableTextView.this.lOQ && (layout = ExpandableTextView.this.lOS.getLayout()) != null) {
                    if (!ExpandableTextView.this.lOR) {
                        if (layout.getLineCount() > ExpandableTextView.this.lOT) {
                            if (ExpandableTextView.this.kaK == null) {
                                String spannableStringBuilder = ExpandableTextView.this.kaJ.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.lOT - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.lOT - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.kaK = new SpannableStringBuilder();
                                ExpandableTextView.this.kaK.append((CharSequence) substring2);
                                ExpandableTextView.this.kaK.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.kaK.length();
                                for (Object obj : ExpandableTextView.this.kaJ.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.kaJ.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.kaJ.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.kaK.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.kaK.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.kaN, 0, spannableString.length(), 17);
                                ExpandableTextView.this.kaK.append((CharSequence) spannableString);
                                ExpandableTextView.this.kaM = new i(ExpandableTextView.this.kaK);
                                ((i) ExpandableTextView.this.kaM).Fr(R.color.transparent);
                            }
                            ExpandableTextView.this.kaC.setVisibility(8);
                            ExpandableTextView.this.lOS.setOnTouchListener(ExpandableTextView.this.kaM);
                            ExpandableTextView.this.lOS.setText(ExpandableTextView.this.kaK);
                            if (ExpandableTextView.this.lOX) {
                                ExpandableTextView.this.dmb();
                            }
                        }
                    } else if (!ExpandableTextView.this.kaG) {
                        ExpandableTextView.this.kaG = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.lOZ, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.kaJ.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.kaJ.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.kaJ.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.kaL).Fr(R.color.transparent);
                            ExpandableTextView.this.lOS.setOnTouchListener(ExpandableTextView.this.kaL);
                            ExpandableTextView.this.lOS.setText(ExpandableTextView.this.kaJ);
                            ExpandableTextView.this.kaC.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.kaC.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.kaC.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.kaC.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.kaN = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dmb();
            }
        };
        this.lOZ = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dmc();
            }
        };
        this.lPa = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dmc();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 1;
        this.lOQ = true;
        this.lOR = false;
        this.kaG = false;
        this.lOT = 2;
        this.lOU = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.lOX = false;
        this.lOY = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.lOS != null && ExpandableTextView.this.kaJ != null && ExpandableTextView.this.lOQ && (layout = ExpandableTextView.this.lOS.getLayout()) != null) {
                    if (!ExpandableTextView.this.lOR) {
                        if (layout.getLineCount() > ExpandableTextView.this.lOT) {
                            if (ExpandableTextView.this.kaK == null) {
                                String spannableStringBuilder = ExpandableTextView.this.kaJ.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.lOT - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.lOT - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.kaK = new SpannableStringBuilder();
                                ExpandableTextView.this.kaK.append((CharSequence) substring2);
                                ExpandableTextView.this.kaK.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.kaK.length();
                                for (Object obj : ExpandableTextView.this.kaJ.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.kaJ.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.kaJ.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.kaK.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.kaK.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.kaN, 0, spannableString.length(), 17);
                                ExpandableTextView.this.kaK.append((CharSequence) spannableString);
                                ExpandableTextView.this.kaM = new i(ExpandableTextView.this.kaK);
                                ((i) ExpandableTextView.this.kaM).Fr(R.color.transparent);
                            }
                            ExpandableTextView.this.kaC.setVisibility(8);
                            ExpandableTextView.this.lOS.setOnTouchListener(ExpandableTextView.this.kaM);
                            ExpandableTextView.this.lOS.setText(ExpandableTextView.this.kaK);
                            if (ExpandableTextView.this.lOX) {
                                ExpandableTextView.this.dmb();
                            }
                        }
                    } else if (!ExpandableTextView.this.kaG) {
                        ExpandableTextView.this.kaG = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.lOZ, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.kaJ.append((CharSequence) spannableString2);
                            } else {
                                int i2 = (lineEnd2 - lineEnd3) + 1;
                                for (int i22 = 0; i22 < i2; i22++) {
                                    ExpandableTextView.this.kaJ.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.kaJ.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.kaL).Fr(R.color.transparent);
                            ExpandableTextView.this.lOS.setOnTouchListener(ExpandableTextView.this.kaL);
                            ExpandableTextView.this.lOS.setText(ExpandableTextView.this.kaJ);
                            ExpandableTextView.this.kaC.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.kaC.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.kaC.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.kaC.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.kaN = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dmb();
            }
        };
        this.lOZ = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dmc();
            }
        };
        this.lPa = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dmc();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
        this.lOS = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
        this.lOS.setTextSize(0, TbConfig.getContentSize());
        this.lOS.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.kaC = (TextView) findViewById(R.id.expandable_view_title_up);
        this.kaC.setOnClickListener(this.lPa);
        this.textSize = l.getDimens(context, R.dimen.tbfontsize42);
        this.textColor = R.color.cp_cont_a;
        this.lOV = l.getDimens(context, R.dimen.tbds6);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.lOS.setTextSize(0, i);
        this.kaC.setTextSize(0, i);
    }

    public void setTextColor(int i) {
        this.textColor = i;
        am.setViewTextColor(this.lOS, this.textColor, 1);
    }

    public void setLineSpacingExtra(int i) {
        this.lOV = i;
        this.lOS.setLineSpacing(i, 1.0f);
        this.kaC.setLineSpacing(i, 1.0f);
    }

    public void setTextMaxLine(int i) {
        this.lOU = i;
    }

    public void setExpandable(boolean z) {
        this.lOQ = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.lOS.getViewTreeObserver().removeGlobalOnLayoutListener(this.lOY);
            } else {
                this.lOS.getViewTreeObserver().removeOnGlobalLayoutListener(this.lOY);
            }
            this.lOS.setMaxLines(this.lOU);
            this.lOS.setEllipsize(TextUtils.TruncateAt.END);
            this.lOS.setText(this.kaJ);
            this.lOS.setOnTouchListener(null);
            this.kaC.setVisibility(8);
            return;
        }
        this.lOS.getViewTreeObserver().addOnGlobalLayoutListener(this.lOY);
        this.lOS.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.lOS.setEllipsize(null);
    }

    public void setExpandType(int i) {
        this.type = i;
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.kaC.setPadding(i, i2, i3, i4);
    }

    public void setData(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.lOX = z;
        this.kaJ = new SpannableStringBuilder(charSequence);
        this.kaL = new i(this.kaJ);
        this.lOS.setText(this.kaJ);
        this.lOS.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        this.lOS.setOnTouchListener(this.kaL);
        am.setViewTextColor(this.lOS, this.textColor, 1);
    }

    public TextView getContentView() {
        return this.lOS;
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.lOS, this.textColor, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmb() {
        this.lOR = true;
        if (this.lOW != null) {
            this.lOW.nR(this.lOR);
        }
        this.lOS.setOnTouchListener(this.kaL);
        this.lOS.setText(this.kaJ);
        if (this.type == 1) {
            this.kaC.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmc() {
        this.lOR = false;
        if (this.lOW != null) {
            this.lOW.nR(this.lOR);
        }
        this.lOS.setOnTouchListener(this.kaM);
        this.lOS.setText(this.kaK);
        this.kaC.setVisibility(8);
    }

    public void setOnStatusChangedListener(a aVar) {
        this.lOW = aVar;
    }
}
