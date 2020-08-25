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
/* loaded from: classes2.dex */
public class ExpandableTextView extends RelativeLayout {
    private TextView kTX;
    private boolean kUb;
    private SpannableStringBuilder kUe;
    private SpannableStringBuilder kUf;
    private View.OnTouchListener kUg;
    private View.OnTouchListener kUh;
    private f kUi;
    private int mKA;
    private a mKB;
    private boolean mKC;
    private ViewTreeObserver.OnGlobalLayoutListener mKD;
    private f mKE;
    private View.OnClickListener mKF;
    private boolean mKv;
    private boolean mKw;
    private SpannableClickTextView mKx;
    private int mKy;
    private int mKz;
    private int textColor;
    private int textSize;
    private int type;

    /* loaded from: classes2.dex */
    public interface a {
        void pm(boolean z);
    }

    public ExpandableTextView(Context context) {
        super(context);
        this.type = 1;
        this.mKv = true;
        this.mKw = false;
        this.kUb = false;
        this.mKy = 2;
        this.mKz = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mKC = false;
        this.mKD = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.mKx != null && ExpandableTextView.this.kUe != null && ExpandableTextView.this.mKv && (layout = ExpandableTextView.this.mKx.getLayout()) != null) {
                    if (!ExpandableTextView.this.mKw) {
                        if (layout.getLineCount() > ExpandableTextView.this.mKy) {
                            if (ExpandableTextView.this.kUf == null) {
                                String spannableStringBuilder = ExpandableTextView.this.kUe.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.mKy - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.mKy - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), at.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.kUf = new SpannableStringBuilder();
                                ExpandableTextView.this.kUf.append((CharSequence) substring2);
                                ExpandableTextView.this.kUf.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.kUf.length();
                                for (Object obj : ExpandableTextView.this.kUe.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.kUe.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.kUe.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.kUf.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.kUf.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.kUi, 0, spannableString.length(), 17);
                                ExpandableTextView.this.kUf.append((CharSequence) spannableString);
                                ExpandableTextView.this.kUh = new i(ExpandableTextView.this.kUf);
                                ((i) ExpandableTextView.this.kUh).Jp(R.color.transparent);
                            }
                            ExpandableTextView.this.kTX.setVisibility(8);
                            ExpandableTextView.this.mKx.setOnTouchListener(ExpandableTextView.this.kUh);
                            ExpandableTextView.this.mKx.setText(ExpandableTextView.this.kUf);
                            if (ExpandableTextView.this.mKC) {
                                ExpandableTextView.this.dFp();
                            }
                        }
                    } else if (!ExpandableTextView.this.kUb) {
                        ExpandableTextView.this.kUb = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.mKE, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.kUe.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.kUe.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.kUe.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.kUg).Jp(R.color.transparent);
                            ExpandableTextView.this.mKx.setOnTouchListener(ExpandableTextView.this.kUg);
                            ExpandableTextView.this.mKx.setText(ExpandableTextView.this.kUe);
                            ExpandableTextView.this.kTX.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.kTX.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.kTX.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.kTX.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.kUi = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dFp();
            }
        };
        this.mKE = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dFq();
            }
        };
        this.mKF = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dFq();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 1;
        this.mKv = true;
        this.mKw = false;
        this.kUb = false;
        this.mKy = 2;
        this.mKz = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mKC = false;
        this.mKD = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.mKx != null && ExpandableTextView.this.kUe != null && ExpandableTextView.this.mKv && (layout = ExpandableTextView.this.mKx.getLayout()) != null) {
                    if (!ExpandableTextView.this.mKw) {
                        if (layout.getLineCount() > ExpandableTextView.this.mKy) {
                            if (ExpandableTextView.this.kUf == null) {
                                String spannableStringBuilder = ExpandableTextView.this.kUe.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.mKy - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.mKy - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), at.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.kUf = new SpannableStringBuilder();
                                ExpandableTextView.this.kUf.append((CharSequence) substring2);
                                ExpandableTextView.this.kUf.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.kUf.length();
                                for (Object obj : ExpandableTextView.this.kUe.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.kUe.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.kUe.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.kUf.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.kUf.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.kUi, 0, spannableString.length(), 17);
                                ExpandableTextView.this.kUf.append((CharSequence) spannableString);
                                ExpandableTextView.this.kUh = new i(ExpandableTextView.this.kUf);
                                ((i) ExpandableTextView.this.kUh).Jp(R.color.transparent);
                            }
                            ExpandableTextView.this.kTX.setVisibility(8);
                            ExpandableTextView.this.mKx.setOnTouchListener(ExpandableTextView.this.kUh);
                            ExpandableTextView.this.mKx.setText(ExpandableTextView.this.kUf);
                            if (ExpandableTextView.this.mKC) {
                                ExpandableTextView.this.dFp();
                            }
                        }
                    } else if (!ExpandableTextView.this.kUb) {
                        ExpandableTextView.this.kUb = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.mKE, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.kUe.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.kUe.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.kUe.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.kUg).Jp(R.color.transparent);
                            ExpandableTextView.this.mKx.setOnTouchListener(ExpandableTextView.this.kUg);
                            ExpandableTextView.this.mKx.setText(ExpandableTextView.this.kUe);
                            ExpandableTextView.this.kTX.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.kTX.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.kTX.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.kTX.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.kUi = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dFp();
            }
        };
        this.mKE = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dFq();
            }
        };
        this.mKF = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dFq();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 1;
        this.mKv = true;
        this.mKw = false;
        this.kUb = false;
        this.mKy = 2;
        this.mKz = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mKC = false;
        this.mKD = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.mKx != null && ExpandableTextView.this.kUe != null && ExpandableTextView.this.mKv && (layout = ExpandableTextView.this.mKx.getLayout()) != null) {
                    if (!ExpandableTextView.this.mKw) {
                        if (layout.getLineCount() > ExpandableTextView.this.mKy) {
                            if (ExpandableTextView.this.kUf == null) {
                                String spannableStringBuilder = ExpandableTextView.this.kUe.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.mKy - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.mKy - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), at.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.kUf = new SpannableStringBuilder();
                                ExpandableTextView.this.kUf.append((CharSequence) substring2);
                                ExpandableTextView.this.kUf.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.kUf.length();
                                for (Object obj : ExpandableTextView.this.kUe.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.kUe.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.kUe.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.kUf.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.kUf.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.kUi, 0, spannableString.length(), 17);
                                ExpandableTextView.this.kUf.append((CharSequence) spannableString);
                                ExpandableTextView.this.kUh = new i(ExpandableTextView.this.kUf);
                                ((i) ExpandableTextView.this.kUh).Jp(R.color.transparent);
                            }
                            ExpandableTextView.this.kTX.setVisibility(8);
                            ExpandableTextView.this.mKx.setOnTouchListener(ExpandableTextView.this.kUh);
                            ExpandableTextView.this.mKx.setText(ExpandableTextView.this.kUf);
                            if (ExpandableTextView.this.mKC) {
                                ExpandableTextView.this.dFp();
                            }
                        }
                    } else if (!ExpandableTextView.this.kUb) {
                        ExpandableTextView.this.kUb = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.mKE, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.kUe.append((CharSequence) spannableString2);
                            } else {
                                int i2 = (lineEnd2 - lineEnd3) + 1;
                                for (int i22 = 0; i22 < i2; i22++) {
                                    ExpandableTextView.this.kUe.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.kUe.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.kUg).Jp(R.color.transparent);
                            ExpandableTextView.this.mKx.setOnTouchListener(ExpandableTextView.this.kUg);
                            ExpandableTextView.this.mKx.setText(ExpandableTextView.this.kUe);
                            ExpandableTextView.this.kTX.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.kTX.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.kTX.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.kTX.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.kUi = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dFp();
            }
        };
        this.mKE = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dFq();
            }
        };
        this.mKF = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dFq();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
        this.mKx = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
        this.mKx.setTextSize(0, TbConfig.getContentSize());
        this.mKx.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.kTX = (TextView) findViewById(R.id.expandable_view_title_up);
        this.kTX.setOnClickListener(this.mKF);
        this.textSize = l.getDimens(context, R.dimen.tbfontsize42);
        this.textColor = R.color.cp_cont_a;
        this.mKA = l.getDimens(context, R.dimen.tbds6);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.mKx.setTextSize(0, i);
        this.kTX.setTextSize(0, i);
    }

    public void setTextColor(int i) {
        this.textColor = i;
        ap.setViewTextColor(this.mKx, this.textColor, 1);
    }

    public void setLineSpacingExtra(int i) {
        this.mKA = i;
        this.mKx.setLineSpacing(i, 1.0f);
        this.kTX.setLineSpacing(i, 1.0f);
    }

    public void setTextMaxLine(int i) {
        this.mKz = i;
    }

    public void setExpandable(boolean z) {
        this.mKv = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.mKx.getViewTreeObserver().removeGlobalOnLayoutListener(this.mKD);
            } else {
                this.mKx.getViewTreeObserver().removeOnGlobalLayoutListener(this.mKD);
            }
            this.mKx.setMaxLines(this.mKz);
            this.mKx.setEllipsize(TextUtils.TruncateAt.END);
            this.mKx.setText(this.kUe);
            this.mKx.setOnTouchListener(null);
            this.kTX.setVisibility(8);
            return;
        }
        this.mKx.getViewTreeObserver().addOnGlobalLayoutListener(this.mKD);
        this.mKx.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.mKx.setEllipsize(null);
    }

    public void setExpandType(int i) {
        this.type = i;
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.kTX.setPadding(i, i2, i3, i4);
    }

    public void setData(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.mKC = z;
        this.kUe = new SpannableStringBuilder(charSequence);
        this.kUg = new i(this.kUe);
        this.mKx.setText(this.kUe);
        this.mKx.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
        this.mKx.setOnTouchListener(this.kUg);
        ap.setViewTextColor(this.mKx, this.textColor, 1);
    }

    public TextView getContentView() {
        return this.mKx;
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mKx, this.textColor, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFp() {
        this.mKw = true;
        if (this.mKB != null) {
            this.mKB.pm(this.mKw);
        }
        this.mKx.setOnTouchListener(this.kUg);
        this.mKx.setText(this.kUe);
        if (this.type == 1) {
            this.kTX.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFq() {
        this.mKw = false;
        if (this.mKB != null) {
            this.mKB.pm(this.mKw);
        }
        this.mKx.setOnTouchListener(this.kUh);
        this.mKx.setText(this.kUf);
        this.kTX.setVisibility(8);
    }

    public void setOnStatusChangedListener(a aVar) {
        this.mKB = aVar;
    }
}
