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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.view.i;
/* loaded from: classes.dex */
public class ExpandableTextView extends RelativeLayout {
    private SpannableStringBuilder kvC;
    private SpannableStringBuilder kvD;
    private View.OnTouchListener kvE;
    private View.OnTouchListener kvF;
    private f kvG;
    private TextView kvv;
    private boolean kvz;
    private boolean mkf;
    private boolean mkg;
    private SpannableClickTextView mkh;
    private int mki;
    private int mkj;
    private int mkk;
    private a mkl;
    private boolean mkm;
    private ViewTreeObserver.OnGlobalLayoutListener mkn;
    private f mko;
    private View.OnClickListener mkp;
    private int textColor;
    private int textSize;
    private int type;

    /* loaded from: classes.dex */
    public interface a {
        void od(boolean z);
    }

    public ExpandableTextView(Context context) {
        super(context);
        this.type = 1;
        this.mkf = true;
        this.mkg = false;
        this.kvz = false;
        this.mki = 2;
        this.mkj = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mkm = false;
        this.mkn = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.mkh != null && ExpandableTextView.this.kvC != null && ExpandableTextView.this.mkf && (layout = ExpandableTextView.this.mkh.getLayout()) != null) {
                    if (!ExpandableTextView.this.mkg) {
                        if (layout.getLineCount() > ExpandableTextView.this.mki) {
                            if (ExpandableTextView.this.kvD == null) {
                                String spannableStringBuilder = ExpandableTextView.this.kvC.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.mki - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.mki - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = ar.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), ar.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.kvD = new SpannableStringBuilder();
                                ExpandableTextView.this.kvD.append((CharSequence) substring2);
                                ExpandableTextView.this.kvD.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.kvD.length();
                                for (Object obj : ExpandableTextView.this.kvC.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.kvC.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.kvC.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.kvD.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.kvD.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.kvG, 0, spannableString.length(), 17);
                                ExpandableTextView.this.kvD.append((CharSequence) spannableString);
                                ExpandableTextView.this.kvF = new i(ExpandableTextView.this.kvD);
                                ((i) ExpandableTextView.this.kvF).Gx(R.color.transparent);
                            }
                            ExpandableTextView.this.kvv.setVisibility(8);
                            ExpandableTextView.this.mkh.setOnTouchListener(ExpandableTextView.this.kvF);
                            ExpandableTextView.this.mkh.setText(ExpandableTextView.this.kvD);
                            if (ExpandableTextView.this.mkm) {
                                ExpandableTextView.this.dqD();
                            }
                        }
                    } else if (!ExpandableTextView.this.kvz) {
                        ExpandableTextView.this.kvz = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.mko, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.kvC.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.kvC.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.kvC.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.kvE).Gx(R.color.transparent);
                            ExpandableTextView.this.mkh.setOnTouchListener(ExpandableTextView.this.kvE);
                            ExpandableTextView.this.mkh.setText(ExpandableTextView.this.kvC);
                            ExpandableTextView.this.kvv.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.kvv.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.kvv.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.kvv.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.kvG = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dqD();
            }
        };
        this.mko = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dqE();
            }
        };
        this.mkp = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dqE();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 1;
        this.mkf = true;
        this.mkg = false;
        this.kvz = false;
        this.mki = 2;
        this.mkj = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mkm = false;
        this.mkn = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.mkh != null && ExpandableTextView.this.kvC != null && ExpandableTextView.this.mkf && (layout = ExpandableTextView.this.mkh.getLayout()) != null) {
                    if (!ExpandableTextView.this.mkg) {
                        if (layout.getLineCount() > ExpandableTextView.this.mki) {
                            if (ExpandableTextView.this.kvD == null) {
                                String spannableStringBuilder = ExpandableTextView.this.kvC.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.mki - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.mki - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = ar.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), ar.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.kvD = new SpannableStringBuilder();
                                ExpandableTextView.this.kvD.append((CharSequence) substring2);
                                ExpandableTextView.this.kvD.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.kvD.length();
                                for (Object obj : ExpandableTextView.this.kvC.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.kvC.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.kvC.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.kvD.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.kvD.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.kvG, 0, spannableString.length(), 17);
                                ExpandableTextView.this.kvD.append((CharSequence) spannableString);
                                ExpandableTextView.this.kvF = new i(ExpandableTextView.this.kvD);
                                ((i) ExpandableTextView.this.kvF).Gx(R.color.transparent);
                            }
                            ExpandableTextView.this.kvv.setVisibility(8);
                            ExpandableTextView.this.mkh.setOnTouchListener(ExpandableTextView.this.kvF);
                            ExpandableTextView.this.mkh.setText(ExpandableTextView.this.kvD);
                            if (ExpandableTextView.this.mkm) {
                                ExpandableTextView.this.dqD();
                            }
                        }
                    } else if (!ExpandableTextView.this.kvz) {
                        ExpandableTextView.this.kvz = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.mko, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.kvC.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.kvC.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.kvC.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.kvE).Gx(R.color.transparent);
                            ExpandableTextView.this.mkh.setOnTouchListener(ExpandableTextView.this.kvE);
                            ExpandableTextView.this.mkh.setText(ExpandableTextView.this.kvC);
                            ExpandableTextView.this.kvv.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.kvv.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.kvv.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.kvv.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.kvG = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dqD();
            }
        };
        this.mko = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dqE();
            }
        };
        this.mkp = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dqE();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 1;
        this.mkf = true;
        this.mkg = false;
        this.kvz = false;
        this.mki = 2;
        this.mkj = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mkm = false;
        this.mkn = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.mkh != null && ExpandableTextView.this.kvC != null && ExpandableTextView.this.mkf && (layout = ExpandableTextView.this.mkh.getLayout()) != null) {
                    if (!ExpandableTextView.this.mkg) {
                        if (layout.getLineCount() > ExpandableTextView.this.mki) {
                            if (ExpandableTextView.this.kvD == null) {
                                String spannableStringBuilder = ExpandableTextView.this.kvC.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.mki - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.mki - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = ar.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), ar.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.kvD = new SpannableStringBuilder();
                                ExpandableTextView.this.kvD.append((CharSequence) substring2);
                                ExpandableTextView.this.kvD.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.kvD.length();
                                for (Object obj : ExpandableTextView.this.kvC.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.kvC.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.kvC.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.kvD.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.kvD.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.kvG, 0, spannableString.length(), 17);
                                ExpandableTextView.this.kvD.append((CharSequence) spannableString);
                                ExpandableTextView.this.kvF = new i(ExpandableTextView.this.kvD);
                                ((i) ExpandableTextView.this.kvF).Gx(R.color.transparent);
                            }
                            ExpandableTextView.this.kvv.setVisibility(8);
                            ExpandableTextView.this.mkh.setOnTouchListener(ExpandableTextView.this.kvF);
                            ExpandableTextView.this.mkh.setText(ExpandableTextView.this.kvD);
                            if (ExpandableTextView.this.mkm) {
                                ExpandableTextView.this.dqD();
                            }
                        }
                    } else if (!ExpandableTextView.this.kvz) {
                        ExpandableTextView.this.kvz = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.mko, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.kvC.append((CharSequence) spannableString2);
                            } else {
                                int i2 = (lineEnd2 - lineEnd3) + 1;
                                for (int i22 = 0; i22 < i2; i22++) {
                                    ExpandableTextView.this.kvC.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.kvC.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.kvE).Gx(R.color.transparent);
                            ExpandableTextView.this.mkh.setOnTouchListener(ExpandableTextView.this.kvE);
                            ExpandableTextView.this.mkh.setText(ExpandableTextView.this.kvC);
                            ExpandableTextView.this.kvv.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.kvv.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.kvv.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.kvv.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.kvG = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dqD();
            }
        };
        this.mko = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dqE();
            }
        };
        this.mkp = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dqE();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
        this.mkh = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
        this.mkh.setTextSize(0, TbConfig.getContentSize());
        this.mkh.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.kvv = (TextView) findViewById(R.id.expandable_view_title_up);
        this.kvv.setOnClickListener(this.mkp);
        this.textSize = l.getDimens(context, R.dimen.tbfontsize42);
        this.textColor = R.color.cp_cont_a;
        this.mkk = l.getDimens(context, R.dimen.tbds6);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.mkh.setTextSize(0, i);
        this.kvv.setTextSize(0, i);
    }

    public void setTextColor(int i) {
        this.textColor = i;
        an.setViewTextColor(this.mkh, this.textColor, 1);
    }

    public void setLineSpacingExtra(int i) {
        this.mkk = i;
        this.mkh.setLineSpacing(i, 1.0f);
        this.kvv.setLineSpacing(i, 1.0f);
    }

    public void setTextMaxLine(int i) {
        this.mkj = i;
    }

    public void setExpandable(boolean z) {
        this.mkf = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.mkh.getViewTreeObserver().removeGlobalOnLayoutListener(this.mkn);
            } else {
                this.mkh.getViewTreeObserver().removeOnGlobalLayoutListener(this.mkn);
            }
            this.mkh.setMaxLines(this.mkj);
            this.mkh.setEllipsize(TextUtils.TruncateAt.END);
            this.mkh.setText(this.kvC);
            this.mkh.setOnTouchListener(null);
            this.kvv.setVisibility(8);
            return;
        }
        this.mkh.getViewTreeObserver().addOnGlobalLayoutListener(this.mkn);
        this.mkh.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.mkh.setEllipsize(null);
    }

    public void setExpandType(int i) {
        this.type = i;
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.kvv.setPadding(i, i2, i3, i4);
    }

    public void setData(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.mkm = z;
        this.kvC = new SpannableStringBuilder(charSequence);
        this.kvE = new i(this.kvC);
        this.mkh.setText(this.kvC);
        this.mkh.setLinkTextColor(an.getColor(R.color.cp_link_tip_c));
        this.mkh.setOnTouchListener(this.kvE);
        an.setViewTextColor(this.mkh, this.textColor, 1);
    }

    public TextView getContentView() {
        return this.mkh;
    }

    public void onChangeSkinType() {
        an.setViewTextColor(this.mkh, this.textColor, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqD() {
        this.mkg = true;
        if (this.mkl != null) {
            this.mkl.od(this.mkg);
        }
        this.mkh.setOnTouchListener(this.kvE);
        this.mkh.setText(this.kvC);
        if (this.type == 1) {
            this.kvv.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqE() {
        this.mkg = false;
        if (this.mkl != null) {
            this.mkl.od(this.mkg);
        }
        this.mkh.setOnTouchListener(this.kvF);
        this.mkh.setText(this.kvD);
        this.kvv.setVisibility(8);
    }

    public void setOnStatusChangedListener(a aVar) {
        this.mkl = aVar;
    }
}
