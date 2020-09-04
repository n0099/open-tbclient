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
    private TextView kUe;
    private boolean kUi;
    private SpannableStringBuilder kUl;
    private SpannableStringBuilder kUm;
    private View.OnTouchListener kUn;
    private View.OnTouchListener kUo;
    private f kUp;
    private boolean mKN;
    private boolean mKO;
    private SpannableClickTextView mKP;
    private int mKQ;
    private int mKR;
    private int mKS;
    private a mKT;
    private boolean mKU;
    private ViewTreeObserver.OnGlobalLayoutListener mKV;
    private f mKW;
    private View.OnClickListener mKX;
    private int textColor;
    private int textSize;
    private int type;

    /* loaded from: classes.dex */
    public interface a {
        void po(boolean z);
    }

    public ExpandableTextView(Context context) {
        super(context);
        this.type = 1;
        this.mKN = true;
        this.mKO = false;
        this.kUi = false;
        this.mKQ = 2;
        this.mKR = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mKU = false;
        this.mKV = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.mKP != null && ExpandableTextView.this.kUl != null && ExpandableTextView.this.mKN && (layout = ExpandableTextView.this.mKP.getLayout()) != null) {
                    if (!ExpandableTextView.this.mKO) {
                        if (layout.getLineCount() > ExpandableTextView.this.mKQ) {
                            if (ExpandableTextView.this.kUm == null) {
                                String spannableStringBuilder = ExpandableTextView.this.kUl.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.mKQ - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.mKQ - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), at.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.kUm = new SpannableStringBuilder();
                                ExpandableTextView.this.kUm.append((CharSequence) substring2);
                                ExpandableTextView.this.kUm.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.kUm.length();
                                for (Object obj : ExpandableTextView.this.kUl.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.kUl.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.kUl.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.kUm.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.kUm.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.kUp, 0, spannableString.length(), 17);
                                ExpandableTextView.this.kUm.append((CharSequence) spannableString);
                                ExpandableTextView.this.kUo = new i(ExpandableTextView.this.kUm);
                                ((i) ExpandableTextView.this.kUo).Jp(R.color.transparent);
                            }
                            ExpandableTextView.this.kUe.setVisibility(8);
                            ExpandableTextView.this.mKP.setOnTouchListener(ExpandableTextView.this.kUo);
                            ExpandableTextView.this.mKP.setText(ExpandableTextView.this.kUm);
                            if (ExpandableTextView.this.mKU) {
                                ExpandableTextView.this.dFy();
                            }
                        }
                    } else if (!ExpandableTextView.this.kUi) {
                        ExpandableTextView.this.kUi = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.mKW, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.kUl.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.kUl.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.kUl.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.kUn).Jp(R.color.transparent);
                            ExpandableTextView.this.mKP.setOnTouchListener(ExpandableTextView.this.kUn);
                            ExpandableTextView.this.mKP.setText(ExpandableTextView.this.kUl);
                            ExpandableTextView.this.kUe.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.kUe.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.kUe.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.kUe.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.kUp = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dFy();
            }
        };
        this.mKW = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dFz();
            }
        };
        this.mKX = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dFz();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 1;
        this.mKN = true;
        this.mKO = false;
        this.kUi = false;
        this.mKQ = 2;
        this.mKR = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mKU = false;
        this.mKV = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.mKP != null && ExpandableTextView.this.kUl != null && ExpandableTextView.this.mKN && (layout = ExpandableTextView.this.mKP.getLayout()) != null) {
                    if (!ExpandableTextView.this.mKO) {
                        if (layout.getLineCount() > ExpandableTextView.this.mKQ) {
                            if (ExpandableTextView.this.kUm == null) {
                                String spannableStringBuilder = ExpandableTextView.this.kUl.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.mKQ - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.mKQ - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), at.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.kUm = new SpannableStringBuilder();
                                ExpandableTextView.this.kUm.append((CharSequence) substring2);
                                ExpandableTextView.this.kUm.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.kUm.length();
                                for (Object obj : ExpandableTextView.this.kUl.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.kUl.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.kUl.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.kUm.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.kUm.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.kUp, 0, spannableString.length(), 17);
                                ExpandableTextView.this.kUm.append((CharSequence) spannableString);
                                ExpandableTextView.this.kUo = new i(ExpandableTextView.this.kUm);
                                ((i) ExpandableTextView.this.kUo).Jp(R.color.transparent);
                            }
                            ExpandableTextView.this.kUe.setVisibility(8);
                            ExpandableTextView.this.mKP.setOnTouchListener(ExpandableTextView.this.kUo);
                            ExpandableTextView.this.mKP.setText(ExpandableTextView.this.kUm);
                            if (ExpandableTextView.this.mKU) {
                                ExpandableTextView.this.dFy();
                            }
                        }
                    } else if (!ExpandableTextView.this.kUi) {
                        ExpandableTextView.this.kUi = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.mKW, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.kUl.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.kUl.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.kUl.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.kUn).Jp(R.color.transparent);
                            ExpandableTextView.this.mKP.setOnTouchListener(ExpandableTextView.this.kUn);
                            ExpandableTextView.this.mKP.setText(ExpandableTextView.this.kUl);
                            ExpandableTextView.this.kUe.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.kUe.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.kUe.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.kUe.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.kUp = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dFy();
            }
        };
        this.mKW = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dFz();
            }
        };
        this.mKX = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dFz();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 1;
        this.mKN = true;
        this.mKO = false;
        this.kUi = false;
        this.mKQ = 2;
        this.mKR = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mKU = false;
        this.mKV = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.mKP != null && ExpandableTextView.this.kUl != null && ExpandableTextView.this.mKN && (layout = ExpandableTextView.this.mKP.getLayout()) != null) {
                    if (!ExpandableTextView.this.mKO) {
                        if (layout.getLineCount() > ExpandableTextView.this.mKQ) {
                            if (ExpandableTextView.this.kUm == null) {
                                String spannableStringBuilder = ExpandableTextView.this.kUl.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.mKQ - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.mKQ - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), at.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.kUm = new SpannableStringBuilder();
                                ExpandableTextView.this.kUm.append((CharSequence) substring2);
                                ExpandableTextView.this.kUm.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.kUm.length();
                                for (Object obj : ExpandableTextView.this.kUl.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.kUl.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.kUl.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.kUm.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.kUm.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.kUp, 0, spannableString.length(), 17);
                                ExpandableTextView.this.kUm.append((CharSequence) spannableString);
                                ExpandableTextView.this.kUo = new i(ExpandableTextView.this.kUm);
                                ((i) ExpandableTextView.this.kUo).Jp(R.color.transparent);
                            }
                            ExpandableTextView.this.kUe.setVisibility(8);
                            ExpandableTextView.this.mKP.setOnTouchListener(ExpandableTextView.this.kUo);
                            ExpandableTextView.this.mKP.setText(ExpandableTextView.this.kUm);
                            if (ExpandableTextView.this.mKU) {
                                ExpandableTextView.this.dFy();
                            }
                        }
                    } else if (!ExpandableTextView.this.kUi) {
                        ExpandableTextView.this.kUi = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.mKW, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.kUl.append((CharSequence) spannableString2);
                            } else {
                                int i2 = (lineEnd2 - lineEnd3) + 1;
                                for (int i22 = 0; i22 < i2; i22++) {
                                    ExpandableTextView.this.kUl.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.kUl.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.kUn).Jp(R.color.transparent);
                            ExpandableTextView.this.mKP.setOnTouchListener(ExpandableTextView.this.kUn);
                            ExpandableTextView.this.mKP.setText(ExpandableTextView.this.kUl);
                            ExpandableTextView.this.kUe.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.kUe.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.kUe.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.kUe.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.kUp = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dFy();
            }
        };
        this.mKW = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dFz();
            }
        };
        this.mKX = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dFz();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
        this.mKP = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
        this.mKP.setTextSize(0, TbConfig.getContentSize());
        this.mKP.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.kUe = (TextView) findViewById(R.id.expandable_view_title_up);
        this.kUe.setOnClickListener(this.mKX);
        this.textSize = l.getDimens(context, R.dimen.tbfontsize42);
        this.textColor = R.color.cp_cont_a;
        this.mKS = l.getDimens(context, R.dimen.tbds6);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.mKP.setTextSize(0, i);
        this.kUe.setTextSize(0, i);
    }

    public void setTextColor(int i) {
        this.textColor = i;
        ap.setViewTextColor(this.mKP, this.textColor, 1);
    }

    public void setLineSpacingExtra(int i) {
        this.mKS = i;
        this.mKP.setLineSpacing(i, 1.0f);
        this.kUe.setLineSpacing(i, 1.0f);
    }

    public void setTextMaxLine(int i) {
        this.mKR = i;
    }

    public void setExpandable(boolean z) {
        this.mKN = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.mKP.getViewTreeObserver().removeGlobalOnLayoutListener(this.mKV);
            } else {
                this.mKP.getViewTreeObserver().removeOnGlobalLayoutListener(this.mKV);
            }
            this.mKP.setMaxLines(this.mKR);
            this.mKP.setEllipsize(TextUtils.TruncateAt.END);
            this.mKP.setText(this.kUl);
            this.mKP.setOnTouchListener(null);
            this.kUe.setVisibility(8);
            return;
        }
        this.mKP.getViewTreeObserver().addOnGlobalLayoutListener(this.mKV);
        this.mKP.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.mKP.setEllipsize(null);
    }

    public void setExpandType(int i) {
        this.type = i;
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.kUe.setPadding(i, i2, i3, i4);
    }

    public void setData(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.mKU = z;
        this.kUl = new SpannableStringBuilder(charSequence);
        this.kUn = new i(this.kUl);
        this.mKP.setText(this.kUl);
        this.mKP.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
        this.mKP.setOnTouchListener(this.kUn);
        ap.setViewTextColor(this.mKP, this.textColor, 1);
    }

    public TextView getContentView() {
        return this.mKP;
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mKP, this.textColor, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFy() {
        this.mKO = true;
        if (this.mKT != null) {
            this.mKT.po(this.mKO);
        }
        this.mKP.setOnTouchListener(this.kUn);
        this.mKP.setText(this.kUl);
        if (this.type == 1) {
            this.kUe.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFz() {
        this.mKO = false;
        if (this.mKT != null) {
            this.mKT.po(this.mKO);
        }
        this.mKP.setOnTouchListener(this.kUo);
        this.mKP.setText(this.kUm);
        this.kUe.setVisibility(8);
    }

    public void setOnStatusChangedListener(a aVar) {
        this.mKT = aVar;
    }
}
