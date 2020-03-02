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
    private TextView iWS;
    private boolean iWW;
    private SpannableStringBuilder iWZ;
    private SpannableStringBuilder iXa;
    private View.OnTouchListener iXb;
    private View.OnTouchListener iXc;
    private f iXd;
    private boolean kJF;
    private boolean kJG;
    private SpannableClickTextView kJH;
    private int kJI;
    private int kJJ;
    private int kJK;
    private a kJL;
    private boolean kJM;
    private ViewTreeObserver.OnGlobalLayoutListener kJN;
    private f kJO;
    private View.OnClickListener kJP;
    private int textColor;
    private int textSize;
    private int type;

    /* loaded from: classes.dex */
    public interface a {
        void mm(boolean z);
    }

    public ExpandableTextView(Context context) {
        super(context);
        this.type = 1;
        this.kJF = true;
        this.kJG = false;
        this.iWW = false;
        this.kJI = 2;
        this.kJJ = Integer.MAX_VALUE;
        this.kJM = false;
        this.kJN = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.kJH != null && ExpandableTextView.this.iWZ != null && ExpandableTextView.this.kJF && (layout = ExpandableTextView.this.kJH.getLayout()) != null) {
                    if (!ExpandableTextView.this.kJG) {
                        if (layout.getLineCount() > ExpandableTextView.this.kJI) {
                            if (ExpandableTextView.this.iXa == null) {
                                String spannableStringBuilder = ExpandableTextView.this.iWZ.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.kJI - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.kJI - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.iXa = new SpannableStringBuilder();
                                ExpandableTextView.this.iXa.append((CharSequence) substring2);
                                ExpandableTextView.this.iXa.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.iXa.length();
                                for (Object obj : ExpandableTextView.this.iWZ.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.iWZ.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.iWZ.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.iXa.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.iXa.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.iXd, 0, spannableString.length(), 17);
                                ExpandableTextView.this.iXa.append((CharSequence) spannableString);
                                ExpandableTextView.this.iXc = new h(ExpandableTextView.this.iXa);
                                ((h) ExpandableTextView.this.iXc).DW(R.color.transparent);
                            }
                            ExpandableTextView.this.iWS.setVisibility(8);
                            ExpandableTextView.this.kJH.setOnTouchListener(ExpandableTextView.this.iXc);
                            ExpandableTextView.this.kJH.setText(ExpandableTextView.this.iXa);
                            if (ExpandableTextView.this.kJM) {
                                ExpandableTextView.this.cTD();
                            }
                        }
                    } else if (!ExpandableTextView.this.iWW) {
                        ExpandableTextView.this.iWW = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.kJO, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.iWZ.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.iWZ.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.iWZ.append((CharSequence) spannableString2);
                            }
                            ((h) ExpandableTextView.this.iXb).DW(R.color.transparent);
                            ExpandableTextView.this.kJH.setOnTouchListener(ExpandableTextView.this.iXb);
                            ExpandableTextView.this.kJH.setText(ExpandableTextView.this.iWZ);
                            ExpandableTextView.this.iWS.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.iWS.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.iWS.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.iWS.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.iXd = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cTD();
            }
        };
        this.kJO = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cTE();
            }
        };
        this.kJP = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.cTE();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 1;
        this.kJF = true;
        this.kJG = false;
        this.iWW = false;
        this.kJI = 2;
        this.kJJ = Integer.MAX_VALUE;
        this.kJM = false;
        this.kJN = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.kJH != null && ExpandableTextView.this.iWZ != null && ExpandableTextView.this.kJF && (layout = ExpandableTextView.this.kJH.getLayout()) != null) {
                    if (!ExpandableTextView.this.kJG) {
                        if (layout.getLineCount() > ExpandableTextView.this.kJI) {
                            if (ExpandableTextView.this.iXa == null) {
                                String spannableStringBuilder = ExpandableTextView.this.iWZ.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.kJI - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.kJI - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.iXa = new SpannableStringBuilder();
                                ExpandableTextView.this.iXa.append((CharSequence) substring2);
                                ExpandableTextView.this.iXa.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.iXa.length();
                                for (Object obj : ExpandableTextView.this.iWZ.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.iWZ.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.iWZ.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.iXa.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.iXa.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.iXd, 0, spannableString.length(), 17);
                                ExpandableTextView.this.iXa.append((CharSequence) spannableString);
                                ExpandableTextView.this.iXc = new h(ExpandableTextView.this.iXa);
                                ((h) ExpandableTextView.this.iXc).DW(R.color.transparent);
                            }
                            ExpandableTextView.this.iWS.setVisibility(8);
                            ExpandableTextView.this.kJH.setOnTouchListener(ExpandableTextView.this.iXc);
                            ExpandableTextView.this.kJH.setText(ExpandableTextView.this.iXa);
                            if (ExpandableTextView.this.kJM) {
                                ExpandableTextView.this.cTD();
                            }
                        }
                    } else if (!ExpandableTextView.this.iWW) {
                        ExpandableTextView.this.iWW = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.kJO, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.iWZ.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.iWZ.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.iWZ.append((CharSequence) spannableString2);
                            }
                            ((h) ExpandableTextView.this.iXb).DW(R.color.transparent);
                            ExpandableTextView.this.kJH.setOnTouchListener(ExpandableTextView.this.iXb);
                            ExpandableTextView.this.kJH.setText(ExpandableTextView.this.iWZ);
                            ExpandableTextView.this.iWS.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.iWS.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.iWS.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.iWS.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.iXd = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cTD();
            }
        };
        this.kJO = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cTE();
            }
        };
        this.kJP = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.cTE();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 1;
        this.kJF = true;
        this.kJG = false;
        this.iWW = false;
        this.kJI = 2;
        this.kJJ = Integer.MAX_VALUE;
        this.kJM = false;
        this.kJN = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.kJH != null && ExpandableTextView.this.iWZ != null && ExpandableTextView.this.kJF && (layout = ExpandableTextView.this.kJH.getLayout()) != null) {
                    if (!ExpandableTextView.this.kJG) {
                        if (layout.getLineCount() > ExpandableTextView.this.kJI) {
                            if (ExpandableTextView.this.iXa == null) {
                                String spannableStringBuilder = ExpandableTextView.this.iWZ.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.kJI - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.kJI - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = aq.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), aq.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.iXa = new SpannableStringBuilder();
                                ExpandableTextView.this.iXa.append((CharSequence) substring2);
                                ExpandableTextView.this.iXa.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.iXa.length();
                                for (Object obj : ExpandableTextView.this.iWZ.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.iWZ.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.iWZ.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.iXa.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.iXa.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.iXd, 0, spannableString.length(), 17);
                                ExpandableTextView.this.iXa.append((CharSequence) spannableString);
                                ExpandableTextView.this.iXc = new h(ExpandableTextView.this.iXa);
                                ((h) ExpandableTextView.this.iXc).DW(R.color.transparent);
                            }
                            ExpandableTextView.this.iWS.setVisibility(8);
                            ExpandableTextView.this.kJH.setOnTouchListener(ExpandableTextView.this.iXc);
                            ExpandableTextView.this.kJH.setText(ExpandableTextView.this.iXa);
                            if (ExpandableTextView.this.kJM) {
                                ExpandableTextView.this.cTD();
                            }
                        }
                    } else if (!ExpandableTextView.this.iWW) {
                        ExpandableTextView.this.iWW = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.kJO, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.iWZ.append((CharSequence) spannableString2);
                            } else {
                                int i2 = (lineEnd2 - lineEnd3) + 1;
                                for (int i22 = 0; i22 < i2; i22++) {
                                    ExpandableTextView.this.iWZ.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.iWZ.append((CharSequence) spannableString2);
                            }
                            ((h) ExpandableTextView.this.iXb).DW(R.color.transparent);
                            ExpandableTextView.this.kJH.setOnTouchListener(ExpandableTextView.this.iXb);
                            ExpandableTextView.this.kJH.setText(ExpandableTextView.this.iWZ);
                            ExpandableTextView.this.iWS.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.iWS.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.iWS.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.iWS.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.iXd = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cTD();
            }
        };
        this.kJO = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.cTE();
            }
        };
        this.kJP = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.cTE();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
        this.kJH = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
        this.kJH.setTextSize(0, TbConfig.getContentSize());
        this.kJH.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.iWS = (TextView) findViewById(R.id.expandable_view_title_up);
        this.iWS.setOnClickListener(this.kJP);
        this.textSize = l.getDimens(context, R.dimen.tbfontsize42);
        this.textColor = R.color.cp_cont_a;
        this.kJK = l.getDimens(context, R.dimen.tbds6);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.kJH.setTextSize(0, i);
        this.iWS.setTextSize(0, i);
    }

    public void setTextColor(int i) {
        this.textColor = i;
        am.setViewTextColor(this.kJH, this.textColor, 1);
    }

    public void setLineSpacingExtra(int i) {
        this.kJK = i;
        this.kJH.setLineSpacing(i, 1.0f);
        this.iWS.setLineSpacing(i, 1.0f);
    }

    public void setTextMaxLine(int i) {
        this.kJJ = i;
    }

    public void setExpandable(boolean z) {
        this.kJF = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.kJH.getViewTreeObserver().removeGlobalOnLayoutListener(this.kJN);
            } else {
                this.kJH.getViewTreeObserver().removeOnGlobalLayoutListener(this.kJN);
            }
            this.kJH.setMaxLines(this.kJJ);
            this.kJH.setEllipsize(TextUtils.TruncateAt.END);
            this.kJH.setText(this.iWZ);
            this.kJH.setOnTouchListener(null);
            this.iWS.setVisibility(8);
            return;
        }
        this.kJH.getViewTreeObserver().addOnGlobalLayoutListener(this.kJN);
        this.kJH.setMaxLines(Integer.MAX_VALUE);
        this.kJH.setEllipsize(null);
    }

    public void setExpandType(int i) {
        this.type = i;
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.iWS.setPadding(i, i2, i3, i4);
    }

    public void setData(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.kJM = z;
        this.iWZ = new SpannableStringBuilder(charSequence);
        this.iXb = new h(this.iWZ);
        this.kJH.setText(this.iWZ);
        this.kJH.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        this.kJH.setOnTouchListener(this.iXb);
        am.setViewTextColor(this.kJH, this.textColor, 1);
    }

    public TextView getContentView() {
        return this.kJH;
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.kJH, this.textColor, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTD() {
        this.kJG = true;
        if (this.kJL != null) {
            this.kJL.mm(this.kJG);
        }
        this.kJH.setOnTouchListener(this.iXb);
        this.kJH.setText(this.iWZ);
        if (this.type == 1) {
            this.iWS.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTE() {
        this.kJG = false;
        if (this.kJL != null) {
            this.kJL.mm(this.kJG);
        }
        this.kJH.setOnTouchListener(this.iXc);
        this.kJH.setText(this.iXa);
        this.iWS.setVisibility(8);
    }

    public void setOnStatusChangedListener(a aVar) {
        this.kJL = aVar;
    }
}
