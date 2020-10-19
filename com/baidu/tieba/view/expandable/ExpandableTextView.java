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
    private TextView lrZ;
    private boolean lsd;
    private SpannableStringBuilder lsg;
    private SpannableStringBuilder lsh;
    private View.OnTouchListener lsi;
    private View.OnTouchListener lsj;
    private f lsk;
    private boolean nkd;
    private boolean nke;
    private SpannableClickTextView nkf;
    private int nkg;
    private int nkh;
    private int nki;
    private a nkj;
    private boolean nkk;
    private ViewTreeObserver.OnGlobalLayoutListener nkl;
    private f nkm;
    private View.OnClickListener nkn;
    private int textColor;
    private int textSize;
    private int type;

    /* loaded from: classes.dex */
    public interface a {
        void pZ(boolean z);
    }

    public ExpandableTextView(Context context) {
        super(context);
        this.type = 1;
        this.nkd = true;
        this.nke = false;
        this.lsd = false;
        this.nkg = 2;
        this.nkh = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.nkk = false;
        this.nkl = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.nkf != null && ExpandableTextView.this.lsg != null && ExpandableTextView.this.nkd && (layout = ExpandableTextView.this.nkf.getLayout()) != null) {
                    if (!ExpandableTextView.this.nke) {
                        if (layout.getLineCount() > ExpandableTextView.this.nkg) {
                            if (ExpandableTextView.this.lsh == null) {
                                String spannableStringBuilder = ExpandableTextView.this.lsg.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.nkg - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.nkg - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), at.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.lsh = new SpannableStringBuilder();
                                ExpandableTextView.this.lsh.append((CharSequence) substring2);
                                ExpandableTextView.this.lsh.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.lsh.length();
                                for (Object obj : ExpandableTextView.this.lsg.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.lsg.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.lsg.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.lsh.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.lsh.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.lsk, 0, spannableString.length(), 17);
                                ExpandableTextView.this.lsh.append((CharSequence) spannableString);
                                ExpandableTextView.this.lsj = new i(ExpandableTextView.this.lsh);
                                ((i) ExpandableTextView.this.lsj).Kz(R.color.transparent);
                            }
                            ExpandableTextView.this.lrZ.setVisibility(8);
                            ExpandableTextView.this.nkf.setOnTouchListener(ExpandableTextView.this.lsj);
                            ExpandableTextView.this.nkf.setText(ExpandableTextView.this.lsh);
                            if (ExpandableTextView.this.nkk) {
                                ExpandableTextView.this.dNe();
                            }
                        }
                    } else if (!ExpandableTextView.this.lsd) {
                        ExpandableTextView.this.lsd = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.nkm, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.lsg.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.lsg.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.lsg.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.lsi).Kz(R.color.transparent);
                            ExpandableTextView.this.nkf.setOnTouchListener(ExpandableTextView.this.lsi);
                            ExpandableTextView.this.nkf.setText(ExpandableTextView.this.lsg);
                            ExpandableTextView.this.lrZ.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.lrZ.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.lrZ.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.lrZ.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.lsk = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dNe();
            }
        };
        this.nkm = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dNf();
            }
        };
        this.nkn = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dNf();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 1;
        this.nkd = true;
        this.nke = false;
        this.lsd = false;
        this.nkg = 2;
        this.nkh = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.nkk = false;
        this.nkl = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.nkf != null && ExpandableTextView.this.lsg != null && ExpandableTextView.this.nkd && (layout = ExpandableTextView.this.nkf.getLayout()) != null) {
                    if (!ExpandableTextView.this.nke) {
                        if (layout.getLineCount() > ExpandableTextView.this.nkg) {
                            if (ExpandableTextView.this.lsh == null) {
                                String spannableStringBuilder = ExpandableTextView.this.lsg.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.nkg - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.nkg - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), at.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.lsh = new SpannableStringBuilder();
                                ExpandableTextView.this.lsh.append((CharSequence) substring2);
                                ExpandableTextView.this.lsh.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.lsh.length();
                                for (Object obj : ExpandableTextView.this.lsg.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.lsg.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.lsg.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.lsh.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.lsh.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.lsk, 0, spannableString.length(), 17);
                                ExpandableTextView.this.lsh.append((CharSequence) spannableString);
                                ExpandableTextView.this.lsj = new i(ExpandableTextView.this.lsh);
                                ((i) ExpandableTextView.this.lsj).Kz(R.color.transparent);
                            }
                            ExpandableTextView.this.lrZ.setVisibility(8);
                            ExpandableTextView.this.nkf.setOnTouchListener(ExpandableTextView.this.lsj);
                            ExpandableTextView.this.nkf.setText(ExpandableTextView.this.lsh);
                            if (ExpandableTextView.this.nkk) {
                                ExpandableTextView.this.dNe();
                            }
                        }
                    } else if (!ExpandableTextView.this.lsd) {
                        ExpandableTextView.this.lsd = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.nkm, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.lsg.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.lsg.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.lsg.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.lsi).Kz(R.color.transparent);
                            ExpandableTextView.this.nkf.setOnTouchListener(ExpandableTextView.this.lsi);
                            ExpandableTextView.this.nkf.setText(ExpandableTextView.this.lsg);
                            ExpandableTextView.this.lrZ.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.lrZ.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.lrZ.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.lrZ.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.lsk = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dNe();
            }
        };
        this.nkm = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dNf();
            }
        };
        this.nkn = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dNf();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 1;
        this.nkd = true;
        this.nke = false;
        this.lsd = false;
        this.nkg = 2;
        this.nkh = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.nkk = false;
        this.nkl = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.nkf != null && ExpandableTextView.this.lsg != null && ExpandableTextView.this.nkd && (layout = ExpandableTextView.this.nkf.getLayout()) != null) {
                    if (!ExpandableTextView.this.nke) {
                        if (layout.getLineCount() > ExpandableTextView.this.nkg) {
                            if (ExpandableTextView.this.lsh == null) {
                                String spannableStringBuilder = ExpandableTextView.this.lsg.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.nkg - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.nkg - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), at.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.lsh = new SpannableStringBuilder();
                                ExpandableTextView.this.lsh.append((CharSequence) substring2);
                                ExpandableTextView.this.lsh.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.lsh.length();
                                for (Object obj : ExpandableTextView.this.lsg.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.lsg.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.lsg.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.lsh.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.lsh.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.lsk, 0, spannableString.length(), 17);
                                ExpandableTextView.this.lsh.append((CharSequence) spannableString);
                                ExpandableTextView.this.lsj = new i(ExpandableTextView.this.lsh);
                                ((i) ExpandableTextView.this.lsj).Kz(R.color.transparent);
                            }
                            ExpandableTextView.this.lrZ.setVisibility(8);
                            ExpandableTextView.this.nkf.setOnTouchListener(ExpandableTextView.this.lsj);
                            ExpandableTextView.this.nkf.setText(ExpandableTextView.this.lsh);
                            if (ExpandableTextView.this.nkk) {
                                ExpandableTextView.this.dNe();
                            }
                        }
                    } else if (!ExpandableTextView.this.lsd) {
                        ExpandableTextView.this.lsd = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.nkm, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.lsg.append((CharSequence) spannableString2);
                            } else {
                                int i2 = (lineEnd2 - lineEnd3) + 1;
                                for (int i22 = 0; i22 < i2; i22++) {
                                    ExpandableTextView.this.lsg.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.lsg.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.lsi).Kz(R.color.transparent);
                            ExpandableTextView.this.nkf.setOnTouchListener(ExpandableTextView.this.lsi);
                            ExpandableTextView.this.nkf.setText(ExpandableTextView.this.lsg);
                            ExpandableTextView.this.lrZ.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.lrZ.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.lrZ.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.lrZ.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.lsk = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dNe();
            }
        };
        this.nkm = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dNf();
            }
        };
        this.nkn = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dNf();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
        this.nkf = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
        this.nkf.setTextSize(0, TbConfig.getContentSize());
        this.nkf.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.lrZ = (TextView) findViewById(R.id.expandable_view_title_up);
        this.lrZ.setOnClickListener(this.nkn);
        this.textSize = l.getDimens(context, R.dimen.tbfontsize42);
        this.textColor = R.color.cp_cont_a;
        this.nki = l.getDimens(context, R.dimen.tbds6);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.nkf.setTextSize(0, i);
        this.lrZ.setTextSize(0, i);
    }

    public void setTextColor(int i) {
        this.textColor = i;
        ap.setViewTextColor(this.nkf, this.textColor, 1);
    }

    public void setLineSpacingExtra(int i) {
        this.nki = i;
        this.nkf.setLineSpacing(i, 1.0f);
        this.lrZ.setLineSpacing(i, 1.0f);
    }

    public void setTextMaxLine(int i) {
        this.nkh = i;
    }

    public void setExpandable(boolean z) {
        this.nkd = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.nkf.getViewTreeObserver().removeGlobalOnLayoutListener(this.nkl);
            } else {
                this.nkf.getViewTreeObserver().removeOnGlobalLayoutListener(this.nkl);
            }
            this.nkf.setMaxLines(this.nkh);
            this.nkf.setEllipsize(TextUtils.TruncateAt.END);
            this.nkf.setText(this.lsg);
            this.nkf.setOnTouchListener(null);
            this.lrZ.setVisibility(8);
            return;
        }
        this.nkf.getViewTreeObserver().addOnGlobalLayoutListener(this.nkl);
        this.nkf.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.nkf.setEllipsize(null);
    }

    public void setExpandType(int i) {
        this.type = i;
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.lrZ.setPadding(i, i2, i3, i4);
    }

    public void setData(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.nkk = z;
        this.lsg = new SpannableStringBuilder(charSequence);
        this.lsi = new i(this.lsg);
        this.nkf.setText(this.lsg);
        this.nkf.setLinkTextColor(ap.getColor(R.color.cp_link_tip_c));
        this.nkf.setOnTouchListener(this.lsi);
        ap.setViewTextColor(this.nkf, this.textColor, 1);
    }

    public TextView getContentView() {
        return this.nkf;
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.nkf, this.textColor, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNe() {
        this.nke = true;
        if (this.nkj != null) {
            this.nkj.pZ(this.nke);
        }
        this.nkf.setOnTouchListener(this.lsi);
        this.nkf.setText(this.lsg);
        if (this.type == 1) {
            this.lrZ.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNf() {
        this.nke = false;
        if (this.nkj != null) {
            this.nkj.pZ(this.nke);
        }
        this.nkf.setOnTouchListener(this.lsj);
        this.nkf.setText(this.lsh);
        this.lrZ.setVisibility(8);
    }

    public void setOnStatusChangedListener(a aVar) {
        this.nkj = aVar;
    }
}
