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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.view.i;
/* loaded from: classes.dex */
public class ExpandableTextView extends RelativeLayout {
    private View.OnTouchListener kEA;
    private f kEB;
    private TextView kEq;
    private boolean kEu;
    private SpannableStringBuilder kEx;
    private SpannableStringBuilder kEy;
    private View.OnTouchListener kEz;
    private boolean msl;
    private boolean msm;
    private SpannableClickTextView msn;
    private int mso;
    private int msp;
    private int msq;
    private a msr;
    private boolean mss;
    private ViewTreeObserver.OnGlobalLayoutListener mst;
    private f msu;
    private View.OnClickListener msv;
    private int textColor;
    private int textSize;
    private int type;

    /* loaded from: classes.dex */
    public interface a {
        void oI(boolean z);
    }

    public ExpandableTextView(Context context) {
        super(context);
        this.type = 1;
        this.msl = true;
        this.msm = false;
        this.kEu = false;
        this.mso = 2;
        this.msp = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mss = false;
        this.mst = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.msn != null && ExpandableTextView.this.kEx != null && ExpandableTextView.this.msl && (layout = ExpandableTextView.this.msn.getLayout()) != null) {
                    if (!ExpandableTextView.this.msm) {
                        if (layout.getLineCount() > ExpandableTextView.this.mso) {
                            if (ExpandableTextView.this.kEy == null) {
                                String spannableStringBuilder = ExpandableTextView.this.kEx.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.mso - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.mso - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = as.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), as.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.kEy = new SpannableStringBuilder();
                                ExpandableTextView.this.kEy.append((CharSequence) substring2);
                                ExpandableTextView.this.kEy.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.kEy.length();
                                for (Object obj : ExpandableTextView.this.kEx.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.kEx.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.kEx.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.kEy.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.kEy.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.kEB, 0, spannableString.length(), 17);
                                ExpandableTextView.this.kEy.append((CharSequence) spannableString);
                                ExpandableTextView.this.kEA = new i(ExpandableTextView.this.kEy);
                                ((i) ExpandableTextView.this.kEA).GT(R.color.transparent);
                            }
                            ExpandableTextView.this.kEq.setVisibility(8);
                            ExpandableTextView.this.msn.setOnTouchListener(ExpandableTextView.this.kEA);
                            ExpandableTextView.this.msn.setText(ExpandableTextView.this.kEy);
                            if (ExpandableTextView.this.mss) {
                                ExpandableTextView.this.dtU();
                            }
                        }
                    } else if (!ExpandableTextView.this.kEu) {
                        ExpandableTextView.this.kEu = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.msu, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.kEx.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.kEx.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.kEx.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.kEz).GT(R.color.transparent);
                            ExpandableTextView.this.msn.setOnTouchListener(ExpandableTextView.this.kEz);
                            ExpandableTextView.this.msn.setText(ExpandableTextView.this.kEx);
                            ExpandableTextView.this.kEq.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.kEq.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.kEq.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.kEq.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.kEB = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dtU();
            }
        };
        this.msu = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dtV();
            }
        };
        this.msv = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dtV();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 1;
        this.msl = true;
        this.msm = false;
        this.kEu = false;
        this.mso = 2;
        this.msp = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mss = false;
        this.mst = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.msn != null && ExpandableTextView.this.kEx != null && ExpandableTextView.this.msl && (layout = ExpandableTextView.this.msn.getLayout()) != null) {
                    if (!ExpandableTextView.this.msm) {
                        if (layout.getLineCount() > ExpandableTextView.this.mso) {
                            if (ExpandableTextView.this.kEy == null) {
                                String spannableStringBuilder = ExpandableTextView.this.kEx.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.mso - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.mso - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = as.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), as.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.kEy = new SpannableStringBuilder();
                                ExpandableTextView.this.kEy.append((CharSequence) substring2);
                                ExpandableTextView.this.kEy.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.kEy.length();
                                for (Object obj : ExpandableTextView.this.kEx.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.kEx.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.kEx.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.kEy.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.kEy.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.kEB, 0, spannableString.length(), 17);
                                ExpandableTextView.this.kEy.append((CharSequence) spannableString);
                                ExpandableTextView.this.kEA = new i(ExpandableTextView.this.kEy);
                                ((i) ExpandableTextView.this.kEA).GT(R.color.transparent);
                            }
                            ExpandableTextView.this.kEq.setVisibility(8);
                            ExpandableTextView.this.msn.setOnTouchListener(ExpandableTextView.this.kEA);
                            ExpandableTextView.this.msn.setText(ExpandableTextView.this.kEy);
                            if (ExpandableTextView.this.mss) {
                                ExpandableTextView.this.dtU();
                            }
                        }
                    } else if (!ExpandableTextView.this.kEu) {
                        ExpandableTextView.this.kEu = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.msu, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.kEx.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.kEx.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.kEx.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.kEz).GT(R.color.transparent);
                            ExpandableTextView.this.msn.setOnTouchListener(ExpandableTextView.this.kEz);
                            ExpandableTextView.this.msn.setText(ExpandableTextView.this.kEx);
                            ExpandableTextView.this.kEq.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.kEq.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.kEq.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.kEq.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.kEB = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dtU();
            }
        };
        this.msu = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dtV();
            }
        };
        this.msv = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dtV();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 1;
        this.msl = true;
        this.msm = false;
        this.kEu = false;
        this.mso = 2;
        this.msp = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mss = false;
        this.mst = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.msn != null && ExpandableTextView.this.kEx != null && ExpandableTextView.this.msl && (layout = ExpandableTextView.this.msn.getLayout()) != null) {
                    if (!ExpandableTextView.this.msm) {
                        if (layout.getLineCount() > ExpandableTextView.this.mso) {
                            if (ExpandableTextView.this.kEy == null) {
                                String spannableStringBuilder = ExpandableTextView.this.kEx.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.mso - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.mso - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = as.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), as.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.kEy = new SpannableStringBuilder();
                                ExpandableTextView.this.kEy.append((CharSequence) substring2);
                                ExpandableTextView.this.kEy.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.kEy.length();
                                for (Object obj : ExpandableTextView.this.kEx.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.kEx.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.kEx.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.kEy.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.kEy.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.kEB, 0, spannableString.length(), 17);
                                ExpandableTextView.this.kEy.append((CharSequence) spannableString);
                                ExpandableTextView.this.kEA = new i(ExpandableTextView.this.kEy);
                                ((i) ExpandableTextView.this.kEA).GT(R.color.transparent);
                            }
                            ExpandableTextView.this.kEq.setVisibility(8);
                            ExpandableTextView.this.msn.setOnTouchListener(ExpandableTextView.this.kEA);
                            ExpandableTextView.this.msn.setText(ExpandableTextView.this.kEy);
                            if (ExpandableTextView.this.mss) {
                                ExpandableTextView.this.dtU();
                            }
                        }
                    } else if (!ExpandableTextView.this.kEu) {
                        ExpandableTextView.this.kEu = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.msu, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.kEx.append((CharSequence) spannableString2);
                            } else {
                                int i2 = (lineEnd2 - lineEnd3) + 1;
                                for (int i22 = 0; i22 < i2; i22++) {
                                    ExpandableTextView.this.kEx.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.kEx.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.kEz).GT(R.color.transparent);
                            ExpandableTextView.this.msn.setOnTouchListener(ExpandableTextView.this.kEz);
                            ExpandableTextView.this.msn.setText(ExpandableTextView.this.kEx);
                            ExpandableTextView.this.kEq.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.kEq.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.kEq.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.kEq.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.kEB = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dtU();
            }
        };
        this.msu = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dtV();
            }
        };
        this.msv = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dtV();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
        this.msn = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
        this.msn.setTextSize(0, TbConfig.getContentSize());
        this.msn.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.kEq = (TextView) findViewById(R.id.expandable_view_title_up);
        this.kEq.setOnClickListener(this.msv);
        this.textSize = l.getDimens(context, R.dimen.tbfontsize42);
        this.textColor = R.color.cp_cont_a;
        this.msq = l.getDimens(context, R.dimen.tbds6);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.msn.setTextSize(0, i);
        this.kEq.setTextSize(0, i);
    }

    public void setTextColor(int i) {
        this.textColor = i;
        ao.setViewTextColor(this.msn, this.textColor, 1);
    }

    public void setLineSpacingExtra(int i) {
        this.msq = i;
        this.msn.setLineSpacing(i, 1.0f);
        this.kEq.setLineSpacing(i, 1.0f);
    }

    public void setTextMaxLine(int i) {
        this.msp = i;
    }

    public void setExpandable(boolean z) {
        this.msl = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.msn.getViewTreeObserver().removeGlobalOnLayoutListener(this.mst);
            } else {
                this.msn.getViewTreeObserver().removeOnGlobalLayoutListener(this.mst);
            }
            this.msn.setMaxLines(this.msp);
            this.msn.setEllipsize(TextUtils.TruncateAt.END);
            this.msn.setText(this.kEx);
            this.msn.setOnTouchListener(null);
            this.kEq.setVisibility(8);
            return;
        }
        this.msn.getViewTreeObserver().addOnGlobalLayoutListener(this.mst);
        this.msn.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.msn.setEllipsize(null);
    }

    public void setExpandType(int i) {
        this.type = i;
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.kEq.setPadding(i, i2, i3, i4);
    }

    public void setData(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.mss = z;
        this.kEx = new SpannableStringBuilder(charSequence);
        this.kEz = new i(this.kEx);
        this.msn.setText(this.kEx);
        this.msn.setLinkTextColor(ao.getColor(R.color.cp_link_tip_c));
        this.msn.setOnTouchListener(this.kEz);
        ao.setViewTextColor(this.msn, this.textColor, 1);
    }

    public TextView getContentView() {
        return this.msn;
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.msn, this.textColor, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtU() {
        this.msm = true;
        if (this.msr != null) {
            this.msr.oI(this.msm);
        }
        this.msn.setOnTouchListener(this.kEz);
        this.msn.setText(this.kEx);
        if (this.type == 1) {
            this.kEq.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtV() {
        this.msm = false;
        if (this.msr != null) {
            this.msr.oI(this.msm);
        }
        this.msn.setOnTouchListener(this.kEA);
        this.msn.setText(this.kEy);
        this.kEq.setVisibility(8);
    }

    public void setOnStatusChangedListener(a aVar) {
        this.msr = aVar;
    }
}
