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
    private TextView kEo;
    private boolean kEs;
    private SpannableStringBuilder kEv;
    private SpannableStringBuilder kEw;
    private View.OnTouchListener kEx;
    private View.OnTouchListener kEy;
    private f kEz;
    private boolean msj;
    private boolean msk;
    private SpannableClickTextView msl;
    private int msm;
    private int msn;
    private int mso;
    private a msp;
    private boolean msq;
    private ViewTreeObserver.OnGlobalLayoutListener msr;
    private f mss;
    private View.OnClickListener mst;
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
        this.msj = true;
        this.msk = false;
        this.kEs = false;
        this.msm = 2;
        this.msn = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.msq = false;
        this.msr = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.msl != null && ExpandableTextView.this.kEv != null && ExpandableTextView.this.msj && (layout = ExpandableTextView.this.msl.getLayout()) != null) {
                    if (!ExpandableTextView.this.msk) {
                        if (layout.getLineCount() > ExpandableTextView.this.msm) {
                            if (ExpandableTextView.this.kEw == null) {
                                String spannableStringBuilder = ExpandableTextView.this.kEv.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.msm - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.msm - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = as.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), as.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.kEw = new SpannableStringBuilder();
                                ExpandableTextView.this.kEw.append((CharSequence) substring2);
                                ExpandableTextView.this.kEw.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.kEw.length();
                                for (Object obj : ExpandableTextView.this.kEv.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.kEv.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.kEv.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.kEw.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.kEw.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.kEz, 0, spannableString.length(), 17);
                                ExpandableTextView.this.kEw.append((CharSequence) spannableString);
                                ExpandableTextView.this.kEy = new i(ExpandableTextView.this.kEw);
                                ((i) ExpandableTextView.this.kEy).GT(R.color.transparent);
                            }
                            ExpandableTextView.this.kEo.setVisibility(8);
                            ExpandableTextView.this.msl.setOnTouchListener(ExpandableTextView.this.kEy);
                            ExpandableTextView.this.msl.setText(ExpandableTextView.this.kEw);
                            if (ExpandableTextView.this.msq) {
                                ExpandableTextView.this.dtT();
                            }
                        }
                    } else if (!ExpandableTextView.this.kEs) {
                        ExpandableTextView.this.kEs = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.mss, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.kEv.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.kEv.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.kEv.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.kEx).GT(R.color.transparent);
                            ExpandableTextView.this.msl.setOnTouchListener(ExpandableTextView.this.kEx);
                            ExpandableTextView.this.msl.setText(ExpandableTextView.this.kEv);
                            ExpandableTextView.this.kEo.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.kEo.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.kEo.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.kEo.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.kEz = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dtT();
            }
        };
        this.mss = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dtU();
            }
        };
        this.mst = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dtU();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 1;
        this.msj = true;
        this.msk = false;
        this.kEs = false;
        this.msm = 2;
        this.msn = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.msq = false;
        this.msr = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.msl != null && ExpandableTextView.this.kEv != null && ExpandableTextView.this.msj && (layout = ExpandableTextView.this.msl.getLayout()) != null) {
                    if (!ExpandableTextView.this.msk) {
                        if (layout.getLineCount() > ExpandableTextView.this.msm) {
                            if (ExpandableTextView.this.kEw == null) {
                                String spannableStringBuilder = ExpandableTextView.this.kEv.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.msm - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.msm - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = as.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), as.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.kEw = new SpannableStringBuilder();
                                ExpandableTextView.this.kEw.append((CharSequence) substring2);
                                ExpandableTextView.this.kEw.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.kEw.length();
                                for (Object obj : ExpandableTextView.this.kEv.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.kEv.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.kEv.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.kEw.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.kEw.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.kEz, 0, spannableString.length(), 17);
                                ExpandableTextView.this.kEw.append((CharSequence) spannableString);
                                ExpandableTextView.this.kEy = new i(ExpandableTextView.this.kEw);
                                ((i) ExpandableTextView.this.kEy).GT(R.color.transparent);
                            }
                            ExpandableTextView.this.kEo.setVisibility(8);
                            ExpandableTextView.this.msl.setOnTouchListener(ExpandableTextView.this.kEy);
                            ExpandableTextView.this.msl.setText(ExpandableTextView.this.kEw);
                            if (ExpandableTextView.this.msq) {
                                ExpandableTextView.this.dtT();
                            }
                        }
                    } else if (!ExpandableTextView.this.kEs) {
                        ExpandableTextView.this.kEs = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.mss, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.kEv.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.kEv.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.kEv.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.kEx).GT(R.color.transparent);
                            ExpandableTextView.this.msl.setOnTouchListener(ExpandableTextView.this.kEx);
                            ExpandableTextView.this.msl.setText(ExpandableTextView.this.kEv);
                            ExpandableTextView.this.kEo.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.kEo.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.kEo.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.kEo.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.kEz = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dtT();
            }
        };
        this.mss = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dtU();
            }
        };
        this.mst = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dtU();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 1;
        this.msj = true;
        this.msk = false;
        this.kEs = false;
        this.msm = 2;
        this.msn = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.msq = false;
        this.msr = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.msl != null && ExpandableTextView.this.kEv != null && ExpandableTextView.this.msj && (layout = ExpandableTextView.this.msl.getLayout()) != null) {
                    if (!ExpandableTextView.this.msk) {
                        if (layout.getLineCount() > ExpandableTextView.this.msm) {
                            if (ExpandableTextView.this.kEw == null) {
                                String spannableStringBuilder = ExpandableTextView.this.kEv.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.msm - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.msm - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = as.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), as.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.kEw = new SpannableStringBuilder();
                                ExpandableTextView.this.kEw.append((CharSequence) substring2);
                                ExpandableTextView.this.kEw.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.kEw.length();
                                for (Object obj : ExpandableTextView.this.kEv.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.kEv.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.kEv.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.kEw.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.kEw.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.kEz, 0, spannableString.length(), 17);
                                ExpandableTextView.this.kEw.append((CharSequence) spannableString);
                                ExpandableTextView.this.kEy = new i(ExpandableTextView.this.kEw);
                                ((i) ExpandableTextView.this.kEy).GT(R.color.transparent);
                            }
                            ExpandableTextView.this.kEo.setVisibility(8);
                            ExpandableTextView.this.msl.setOnTouchListener(ExpandableTextView.this.kEy);
                            ExpandableTextView.this.msl.setText(ExpandableTextView.this.kEw);
                            if (ExpandableTextView.this.msq) {
                                ExpandableTextView.this.dtT();
                            }
                        }
                    } else if (!ExpandableTextView.this.kEs) {
                        ExpandableTextView.this.kEs = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.mss, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.kEv.append((CharSequence) spannableString2);
                            } else {
                                int i2 = (lineEnd2 - lineEnd3) + 1;
                                for (int i22 = 0; i22 < i2; i22++) {
                                    ExpandableTextView.this.kEv.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.kEv.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.kEx).GT(R.color.transparent);
                            ExpandableTextView.this.msl.setOnTouchListener(ExpandableTextView.this.kEx);
                            ExpandableTextView.this.msl.setText(ExpandableTextView.this.kEv);
                            ExpandableTextView.this.kEo.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.kEo.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.kEo.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.kEo.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.kEz = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dtT();
            }
        };
        this.mss = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dtU();
            }
        };
        this.mst = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dtU();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
        this.msl = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
        this.msl.setTextSize(0, TbConfig.getContentSize());
        this.msl.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.kEo = (TextView) findViewById(R.id.expandable_view_title_up);
        this.kEo.setOnClickListener(this.mst);
        this.textSize = l.getDimens(context, R.dimen.tbfontsize42);
        this.textColor = R.color.cp_cont_a;
        this.mso = l.getDimens(context, R.dimen.tbds6);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.msl.setTextSize(0, i);
        this.kEo.setTextSize(0, i);
    }

    public void setTextColor(int i) {
        this.textColor = i;
        ao.setViewTextColor(this.msl, this.textColor, 1);
    }

    public void setLineSpacingExtra(int i) {
        this.mso = i;
        this.msl.setLineSpacing(i, 1.0f);
        this.kEo.setLineSpacing(i, 1.0f);
    }

    public void setTextMaxLine(int i) {
        this.msn = i;
    }

    public void setExpandable(boolean z) {
        this.msj = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.msl.getViewTreeObserver().removeGlobalOnLayoutListener(this.msr);
            } else {
                this.msl.getViewTreeObserver().removeOnGlobalLayoutListener(this.msr);
            }
            this.msl.setMaxLines(this.msn);
            this.msl.setEllipsize(TextUtils.TruncateAt.END);
            this.msl.setText(this.kEv);
            this.msl.setOnTouchListener(null);
            this.kEo.setVisibility(8);
            return;
        }
        this.msl.getViewTreeObserver().addOnGlobalLayoutListener(this.msr);
        this.msl.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.msl.setEllipsize(null);
    }

    public void setExpandType(int i) {
        this.type = i;
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.kEo.setPadding(i, i2, i3, i4);
    }

    public void setData(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.msq = z;
        this.kEv = new SpannableStringBuilder(charSequence);
        this.kEx = new i(this.kEv);
        this.msl.setText(this.kEv);
        this.msl.setLinkTextColor(ao.getColor(R.color.cp_link_tip_c));
        this.msl.setOnTouchListener(this.kEx);
        ao.setViewTextColor(this.msl, this.textColor, 1);
    }

    public TextView getContentView() {
        return this.msl;
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.msl, this.textColor, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtT() {
        this.msk = true;
        if (this.msp != null) {
            this.msp.oI(this.msk);
        }
        this.msl.setOnTouchListener(this.kEx);
        this.msl.setText(this.kEv);
        if (this.type == 1) {
            this.kEo.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtU() {
        this.msk = false;
        if (this.msp != null) {
            this.msp.oI(this.msk);
        }
        this.msl.setOnTouchListener(this.kEy);
        this.msl.setText(this.kEw);
        this.kEo.setVisibility(8);
    }

    public void setOnStatusChangedListener(a aVar) {
        this.msp = aVar;
    }
}
