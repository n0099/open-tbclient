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
    private boolean lEC;
    private SpannableStringBuilder lEF;
    private SpannableStringBuilder lEG;
    private View.OnTouchListener lEH;
    private View.OnTouchListener lEI;
    private f lEJ;
    private TextView lEy;
    private boolean nwE;
    private boolean nwF;
    private SpannableClickTextView nwG;
    private int nwH;
    private int nwI;
    private int nwJ;
    private a nwK;
    private boolean nwL;
    private ViewTreeObserver.OnGlobalLayoutListener nwM;
    private f nwN;
    private View.OnClickListener nwO;
    private int textColor;
    private int textSize;
    private int type;

    /* loaded from: classes.dex */
    public interface a {
        void qr(boolean z);
    }

    public ExpandableTextView(Context context) {
        super(context);
        this.type = 1;
        this.nwE = true;
        this.nwF = false;
        this.lEC = false;
        this.nwH = 2;
        this.nwI = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.nwL = false;
        this.nwM = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.nwG != null && ExpandableTextView.this.lEF != null && ExpandableTextView.this.nwE && (layout = ExpandableTextView.this.nwG.getLayout()) != null) {
                    if (!ExpandableTextView.this.nwF) {
                        if (layout.getLineCount() > ExpandableTextView.this.nwH) {
                            if (ExpandableTextView.this.lEG == null) {
                                String spannableStringBuilder = ExpandableTextView.this.lEF.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.nwH - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.nwH - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), at.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.lEG = new SpannableStringBuilder();
                                ExpandableTextView.this.lEG.append((CharSequence) substring2);
                                ExpandableTextView.this.lEG.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.lEG.length();
                                for (Object obj : ExpandableTextView.this.lEF.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.lEF.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.lEF.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.lEG.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.lEG.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.lEJ, 0, spannableString.length(), 17);
                                ExpandableTextView.this.lEG.append((CharSequence) spannableString);
                                ExpandableTextView.this.lEI = new i(ExpandableTextView.this.lEG);
                                ((i) ExpandableTextView.this.lEI).KR(R.color.transparent);
                            }
                            ExpandableTextView.this.lEy.setVisibility(8);
                            ExpandableTextView.this.nwG.setOnTouchListener(ExpandableTextView.this.lEI);
                            ExpandableTextView.this.nwG.setText(ExpandableTextView.this.lEG);
                            if (ExpandableTextView.this.nwL) {
                                ExpandableTextView.this.dQm();
                            }
                        }
                    } else if (!ExpandableTextView.this.lEC) {
                        ExpandableTextView.this.lEC = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.nwN, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.lEF.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.lEF.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.lEF.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.lEH).KR(R.color.transparent);
                            ExpandableTextView.this.nwG.setOnTouchListener(ExpandableTextView.this.lEH);
                            ExpandableTextView.this.nwG.setText(ExpandableTextView.this.lEF);
                            ExpandableTextView.this.lEy.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.lEy.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.lEy.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.lEy.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.lEJ = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dQm();
            }
        };
        this.nwN = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dQn();
            }
        };
        this.nwO = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dQn();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 1;
        this.nwE = true;
        this.nwF = false;
        this.lEC = false;
        this.nwH = 2;
        this.nwI = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.nwL = false;
        this.nwM = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.nwG != null && ExpandableTextView.this.lEF != null && ExpandableTextView.this.nwE && (layout = ExpandableTextView.this.nwG.getLayout()) != null) {
                    if (!ExpandableTextView.this.nwF) {
                        if (layout.getLineCount() > ExpandableTextView.this.nwH) {
                            if (ExpandableTextView.this.lEG == null) {
                                String spannableStringBuilder = ExpandableTextView.this.lEF.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.nwH - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.nwH - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), at.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.lEG = new SpannableStringBuilder();
                                ExpandableTextView.this.lEG.append((CharSequence) substring2);
                                ExpandableTextView.this.lEG.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.lEG.length();
                                for (Object obj : ExpandableTextView.this.lEF.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.lEF.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.lEF.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.lEG.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.lEG.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.lEJ, 0, spannableString.length(), 17);
                                ExpandableTextView.this.lEG.append((CharSequence) spannableString);
                                ExpandableTextView.this.lEI = new i(ExpandableTextView.this.lEG);
                                ((i) ExpandableTextView.this.lEI).KR(R.color.transparent);
                            }
                            ExpandableTextView.this.lEy.setVisibility(8);
                            ExpandableTextView.this.nwG.setOnTouchListener(ExpandableTextView.this.lEI);
                            ExpandableTextView.this.nwG.setText(ExpandableTextView.this.lEG);
                            if (ExpandableTextView.this.nwL) {
                                ExpandableTextView.this.dQm();
                            }
                        }
                    } else if (!ExpandableTextView.this.lEC) {
                        ExpandableTextView.this.lEC = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.nwN, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.lEF.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.lEF.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.lEF.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.lEH).KR(R.color.transparent);
                            ExpandableTextView.this.nwG.setOnTouchListener(ExpandableTextView.this.lEH);
                            ExpandableTextView.this.nwG.setText(ExpandableTextView.this.lEF);
                            ExpandableTextView.this.lEy.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.lEy.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.lEy.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.lEy.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.lEJ = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dQm();
            }
        };
        this.nwN = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dQn();
            }
        };
        this.nwO = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dQn();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 1;
        this.nwE = true;
        this.nwF = false;
        this.lEC = false;
        this.nwH = 2;
        this.nwI = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.nwL = false;
        this.nwM = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.nwG != null && ExpandableTextView.this.lEF != null && ExpandableTextView.this.nwE && (layout = ExpandableTextView.this.nwG.getLayout()) != null) {
                    if (!ExpandableTextView.this.nwF) {
                        if (layout.getLineCount() > ExpandableTextView.this.nwH) {
                            if (ExpandableTextView.this.lEG == null) {
                                String spannableStringBuilder = ExpandableTextView.this.lEF.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.nwH - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.nwH - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), at.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.lEG = new SpannableStringBuilder();
                                ExpandableTextView.this.lEG.append((CharSequence) substring2);
                                ExpandableTextView.this.lEG.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.lEG.length();
                                for (Object obj : ExpandableTextView.this.lEF.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.lEF.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.lEF.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.lEG.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.lEG.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.lEJ, 0, spannableString.length(), 17);
                                ExpandableTextView.this.lEG.append((CharSequence) spannableString);
                                ExpandableTextView.this.lEI = new i(ExpandableTextView.this.lEG);
                                ((i) ExpandableTextView.this.lEI).KR(R.color.transparent);
                            }
                            ExpandableTextView.this.lEy.setVisibility(8);
                            ExpandableTextView.this.nwG.setOnTouchListener(ExpandableTextView.this.lEI);
                            ExpandableTextView.this.nwG.setText(ExpandableTextView.this.lEG);
                            if (ExpandableTextView.this.nwL) {
                                ExpandableTextView.this.dQm();
                            }
                        }
                    } else if (!ExpandableTextView.this.lEC) {
                        ExpandableTextView.this.lEC = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.nwN, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.lEF.append((CharSequence) spannableString2);
                            } else {
                                int i2 = (lineEnd2 - lineEnd3) + 1;
                                for (int i22 = 0; i22 < i2; i22++) {
                                    ExpandableTextView.this.lEF.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.lEF.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.lEH).KR(R.color.transparent);
                            ExpandableTextView.this.nwG.setOnTouchListener(ExpandableTextView.this.lEH);
                            ExpandableTextView.this.nwG.setText(ExpandableTextView.this.lEF);
                            ExpandableTextView.this.lEy.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.lEy.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.lEy.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.lEy.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.lEJ = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dQm();
            }
        };
        this.nwN = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dQn();
            }
        };
        this.nwO = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dQn();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
        this.nwG = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
        this.nwG.setTextSize(0, TbConfig.getContentSize());
        this.nwG.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.lEy = (TextView) findViewById(R.id.expandable_view_title_up);
        this.lEy.setOnClickListener(this.nwO);
        this.textSize = l.getDimens(context, R.dimen.tbfontsize42);
        this.textColor = R.color.cp_cont_a;
        this.nwJ = l.getDimens(context, R.dimen.tbds6);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.nwG.setTextSize(0, i);
        this.lEy.setTextSize(0, i);
    }

    public void setTextColor(int i) {
        this.textColor = i;
        ap.setViewTextColor(this.nwG, this.textColor, 1);
    }

    public void setLineSpacingExtra(int i) {
        this.nwJ = i;
        this.nwG.setLineSpacing(i, 1.0f);
        this.lEy.setLineSpacing(i, 1.0f);
    }

    public void setTextMaxLine(int i) {
        this.nwI = i;
    }

    public void setExpandable(boolean z) {
        this.nwE = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.nwG.getViewTreeObserver().removeGlobalOnLayoutListener(this.nwM);
            } else {
                this.nwG.getViewTreeObserver().removeOnGlobalLayoutListener(this.nwM);
            }
            this.nwG.setMaxLines(this.nwI);
            this.nwG.setEllipsize(TextUtils.TruncateAt.END);
            this.nwG.setText(this.lEF);
            this.nwG.setOnTouchListener(null);
            this.lEy.setVisibility(8);
            return;
        }
        this.nwG.getViewTreeObserver().addOnGlobalLayoutListener(this.nwM);
        this.nwG.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.nwG.setEllipsize(null);
    }

    public void setExpandType(int i) {
        this.type = i;
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.lEy.setPadding(i, i2, i3, i4);
    }

    public void setData(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.nwL = z;
        this.lEF = new SpannableStringBuilder(charSequence);
        this.lEH = new i(this.lEF);
        this.nwG.setText(this.lEF);
        this.nwG.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
        this.nwG.setOnTouchListener(this.lEH);
        ap.setViewTextColor(this.nwG, this.textColor, 1);
    }

    public TextView getContentView() {
        return this.nwG;
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.nwG, this.textColor, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQm() {
        this.nwF = true;
        if (this.nwK != null) {
            this.nwK.qr(this.nwF);
        }
        this.nwG.setOnTouchListener(this.lEH);
        this.nwG.setText(this.lEF);
        if (this.type == 1) {
            this.lEy.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQn() {
        this.nwF = false;
        if (this.nwK != null) {
            this.nwK.qr(this.nwF);
        }
        this.nwG.setOnTouchListener(this.lEI);
        this.nwG.setText(this.lEG);
        this.lEy.setVisibility(8);
    }

    public void setOnStatusChangedListener(a aVar) {
        this.nwK = aVar;
    }
}
