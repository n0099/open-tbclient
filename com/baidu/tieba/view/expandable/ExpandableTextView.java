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
    private TextView kbI;
    private boolean kbM;
    private SpannableStringBuilder kbP;
    private SpannableStringBuilder kbQ;
    private View.OnTouchListener kbR;
    private View.OnTouchListener kbS;
    private f kbT;
    private boolean lPY;
    private boolean lPZ;
    private SpannableClickTextView lQa;
    private int lQb;
    private int lQc;
    private int lQd;
    private a lQe;
    private boolean lQf;
    private ViewTreeObserver.OnGlobalLayoutListener lQg;
    private f lQh;
    private View.OnClickListener lQi;
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
        this.lPY = true;
        this.lPZ = false;
        this.kbM = false;
        this.lQb = 2;
        this.lQc = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.lQf = false;
        this.lQg = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.lQa != null && ExpandableTextView.this.kbP != null && ExpandableTextView.this.lPY && (layout = ExpandableTextView.this.lQa.getLayout()) != null) {
                    if (!ExpandableTextView.this.lPZ) {
                        if (layout.getLineCount() > ExpandableTextView.this.lQb) {
                            if (ExpandableTextView.this.kbQ == null) {
                                String spannableStringBuilder = ExpandableTextView.this.kbP.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.lQb - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.lQb - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.kbQ = new SpannableStringBuilder();
                                ExpandableTextView.this.kbQ.append((CharSequence) substring2);
                                ExpandableTextView.this.kbQ.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.kbQ.length();
                                for (Object obj : ExpandableTextView.this.kbP.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.kbP.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.kbP.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.kbQ.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.kbQ.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.kbT, 0, spannableString.length(), 17);
                                ExpandableTextView.this.kbQ.append((CharSequence) spannableString);
                                ExpandableTextView.this.kbS = new i(ExpandableTextView.this.kbQ);
                                ((i) ExpandableTextView.this.kbS).Ft(R.color.transparent);
                            }
                            ExpandableTextView.this.kbI.setVisibility(8);
                            ExpandableTextView.this.lQa.setOnTouchListener(ExpandableTextView.this.kbS);
                            ExpandableTextView.this.lQa.setText(ExpandableTextView.this.kbQ);
                            if (ExpandableTextView.this.lQf) {
                                ExpandableTextView.this.dmq();
                            }
                        }
                    } else if (!ExpandableTextView.this.kbM) {
                        ExpandableTextView.this.kbM = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.lQh, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.kbP.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.kbP.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.kbP.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.kbR).Ft(R.color.transparent);
                            ExpandableTextView.this.lQa.setOnTouchListener(ExpandableTextView.this.kbR);
                            ExpandableTextView.this.lQa.setText(ExpandableTextView.this.kbP);
                            ExpandableTextView.this.kbI.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.kbI.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.kbI.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.kbI.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.kbT = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dmq();
            }
        };
        this.lQh = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dmr();
            }
        };
        this.lQi = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dmr();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 1;
        this.lPY = true;
        this.lPZ = false;
        this.kbM = false;
        this.lQb = 2;
        this.lQc = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.lQf = false;
        this.lQg = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.lQa != null && ExpandableTextView.this.kbP != null && ExpandableTextView.this.lPY && (layout = ExpandableTextView.this.lQa.getLayout()) != null) {
                    if (!ExpandableTextView.this.lPZ) {
                        if (layout.getLineCount() > ExpandableTextView.this.lQb) {
                            if (ExpandableTextView.this.kbQ == null) {
                                String spannableStringBuilder = ExpandableTextView.this.kbP.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.lQb - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.lQb - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.kbQ = new SpannableStringBuilder();
                                ExpandableTextView.this.kbQ.append((CharSequence) substring2);
                                ExpandableTextView.this.kbQ.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.kbQ.length();
                                for (Object obj : ExpandableTextView.this.kbP.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.kbP.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.kbP.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.kbQ.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.kbQ.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.kbT, 0, spannableString.length(), 17);
                                ExpandableTextView.this.kbQ.append((CharSequence) spannableString);
                                ExpandableTextView.this.kbS = new i(ExpandableTextView.this.kbQ);
                                ((i) ExpandableTextView.this.kbS).Ft(R.color.transparent);
                            }
                            ExpandableTextView.this.kbI.setVisibility(8);
                            ExpandableTextView.this.lQa.setOnTouchListener(ExpandableTextView.this.kbS);
                            ExpandableTextView.this.lQa.setText(ExpandableTextView.this.kbQ);
                            if (ExpandableTextView.this.lQf) {
                                ExpandableTextView.this.dmq();
                            }
                        }
                    } else if (!ExpandableTextView.this.kbM) {
                        ExpandableTextView.this.kbM = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.lQh, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.kbP.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.kbP.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.kbP.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.kbR).Ft(R.color.transparent);
                            ExpandableTextView.this.lQa.setOnTouchListener(ExpandableTextView.this.kbR);
                            ExpandableTextView.this.lQa.setText(ExpandableTextView.this.kbP);
                            ExpandableTextView.this.kbI.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.kbI.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.kbI.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.kbI.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.kbT = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dmq();
            }
        };
        this.lQh = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dmr();
            }
        };
        this.lQi = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dmr();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 1;
        this.lPY = true;
        this.lPZ = false;
        this.kbM = false;
        this.lQb = 2;
        this.lQc = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.lQf = false;
        this.lQg = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.lQa != null && ExpandableTextView.this.kbP != null && ExpandableTextView.this.lPY && (layout = ExpandableTextView.this.lQa.getLayout()) != null) {
                    if (!ExpandableTextView.this.lPZ) {
                        if (layout.getLineCount() > ExpandableTextView.this.lQb) {
                            if (ExpandableTextView.this.kbQ == null) {
                                String spannableStringBuilder = ExpandableTextView.this.kbP.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.lQb - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.lQb - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.kbQ = new SpannableStringBuilder();
                                ExpandableTextView.this.kbQ.append((CharSequence) substring2);
                                ExpandableTextView.this.kbQ.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.kbQ.length();
                                for (Object obj : ExpandableTextView.this.kbP.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.kbP.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.kbP.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.kbQ.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.kbQ.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.kbT, 0, spannableString.length(), 17);
                                ExpandableTextView.this.kbQ.append((CharSequence) spannableString);
                                ExpandableTextView.this.kbS = new i(ExpandableTextView.this.kbQ);
                                ((i) ExpandableTextView.this.kbS).Ft(R.color.transparent);
                            }
                            ExpandableTextView.this.kbI.setVisibility(8);
                            ExpandableTextView.this.lQa.setOnTouchListener(ExpandableTextView.this.kbS);
                            ExpandableTextView.this.lQa.setText(ExpandableTextView.this.kbQ);
                            if (ExpandableTextView.this.lQf) {
                                ExpandableTextView.this.dmq();
                            }
                        }
                    } else if (!ExpandableTextView.this.kbM) {
                        ExpandableTextView.this.kbM = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.lQh, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.kbP.append((CharSequence) spannableString2);
                            } else {
                                int i2 = (lineEnd2 - lineEnd3) + 1;
                                for (int i22 = 0; i22 < i2; i22++) {
                                    ExpandableTextView.this.kbP.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.kbP.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.kbR).Ft(R.color.transparent);
                            ExpandableTextView.this.lQa.setOnTouchListener(ExpandableTextView.this.kbR);
                            ExpandableTextView.this.lQa.setText(ExpandableTextView.this.kbP);
                            ExpandableTextView.this.kbI.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.kbI.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.kbI.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.kbI.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.kbT = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dmq();
            }
        };
        this.lQh = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dmr();
            }
        };
        this.lQi = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dmr();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
        this.lQa = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
        this.lQa.setTextSize(0, TbConfig.getContentSize());
        this.lQa.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.kbI = (TextView) findViewById(R.id.expandable_view_title_up);
        this.kbI.setOnClickListener(this.lQi);
        this.textSize = l.getDimens(context, R.dimen.tbfontsize42);
        this.textColor = R.color.cp_cont_a;
        this.lQd = l.getDimens(context, R.dimen.tbds6);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.lQa.setTextSize(0, i);
        this.kbI.setTextSize(0, i);
    }

    public void setTextColor(int i) {
        this.textColor = i;
        am.setViewTextColor(this.lQa, this.textColor, 1);
    }

    public void setLineSpacingExtra(int i) {
        this.lQd = i;
        this.lQa.setLineSpacing(i, 1.0f);
        this.kbI.setLineSpacing(i, 1.0f);
    }

    public void setTextMaxLine(int i) {
        this.lQc = i;
    }

    public void setExpandable(boolean z) {
        this.lPY = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.lQa.getViewTreeObserver().removeGlobalOnLayoutListener(this.lQg);
            } else {
                this.lQa.getViewTreeObserver().removeOnGlobalLayoutListener(this.lQg);
            }
            this.lQa.setMaxLines(this.lQc);
            this.lQa.setEllipsize(TextUtils.TruncateAt.END);
            this.lQa.setText(this.kbP);
            this.lQa.setOnTouchListener(null);
            this.kbI.setVisibility(8);
            return;
        }
        this.lQa.getViewTreeObserver().addOnGlobalLayoutListener(this.lQg);
        this.lQa.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.lQa.setEllipsize(null);
    }

    public void setExpandType(int i) {
        this.type = i;
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.kbI.setPadding(i, i2, i3, i4);
    }

    public void setData(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.lQf = z;
        this.kbP = new SpannableStringBuilder(charSequence);
        this.kbR = new i(this.kbP);
        this.lQa.setText(this.kbP);
        this.lQa.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        this.lQa.setOnTouchListener(this.kbR);
        am.setViewTextColor(this.lQa, this.textColor, 1);
    }

    public TextView getContentView() {
        return this.lQa;
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.lQa, this.textColor, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmq() {
        this.lPZ = true;
        if (this.lQe != null) {
            this.lQe.nR(this.lPZ);
        }
        this.lQa.setOnTouchListener(this.kbR);
        this.lQa.setText(this.kbP);
        if (this.type == 1) {
            this.kbI.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmr() {
        this.lPZ = false;
        if (this.lQe != null) {
            this.lQe.nR(this.lPZ);
        }
        this.lQa.setOnTouchListener(this.kbS);
        this.lQa.setText(this.kbQ);
        this.kbI.setVisibility(8);
    }

    public void setOnStatusChangedListener(a aVar) {
        this.lQe = aVar;
    }
}
