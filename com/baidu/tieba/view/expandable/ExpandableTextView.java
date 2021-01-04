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
import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.view.i;
/* loaded from: classes.dex */
public class ExpandableTextView extends RelativeLayout {
    private TextView meb;
    private boolean mef;
    private SpannableStringBuilder mei;
    private SpannableStringBuilder mej;
    private View.OnTouchListener mek;
    private View.OnTouchListener mel;
    private f men;
    private a nVA;
    private boolean nVB;
    private ViewTreeObserver.OnGlobalLayoutListener nVC;
    private f nVD;
    private View.OnClickListener nVE;
    private boolean nVu;
    private boolean nVv;
    private SpannableClickTextView nVw;
    private int nVx;
    private int nVy;
    private int nVz;
    private int textColor;
    private int textSize;
    private int type;

    /* loaded from: classes.dex */
    public interface a {
        void rD(boolean z);
    }

    public ExpandableTextView(Context context) {
        super(context);
        this.type = 1;
        this.nVu = true;
        this.nVv = false;
        this.mef = false;
        this.nVx = 2;
        this.nVy = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.nVB = false;
        this.nVC = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.nVw != null && ExpandableTextView.this.mei != null && ExpandableTextView.this.nVu && (layout = ExpandableTextView.this.nVw.getLayout()) != null) {
                    if (!ExpandableTextView.this.nVv) {
                        if (layout.getLineCount() > ExpandableTextView.this.nVx) {
                            if (ExpandableTextView.this.mej == null) {
                                String spannableStringBuilder = ExpandableTextView.this.mei.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.nVx - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.nVx - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), at.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.mej = new SpannableStringBuilder();
                                ExpandableTextView.this.mej.append((CharSequence) substring2);
                                ExpandableTextView.this.mej.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.mej.length();
                                for (Object obj : ExpandableTextView.this.mei.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.mei.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.mei.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.mej.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.mej.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.men, 0, spannableString.length(), 17);
                                ExpandableTextView.this.mej.append((CharSequence) spannableString);
                                ExpandableTextView.this.mel = new i(ExpandableTextView.this.mej);
                                ((i) ExpandableTextView.this.mel).Mm(R.color.transparent);
                            }
                            ExpandableTextView.this.meb.setVisibility(8);
                            ExpandableTextView.this.nVw.setOnTouchListener(ExpandableTextView.this.mel);
                            ExpandableTextView.this.nVw.setText(ExpandableTextView.this.mej);
                            if (ExpandableTextView.this.nVB) {
                                ExpandableTextView.this.dXL();
                            }
                        }
                    } else if (!ExpandableTextView.this.mef) {
                        ExpandableTextView.this.mef = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.nVD, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.mei.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.mei.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.mei.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.mek).Mm(R.color.transparent);
                            ExpandableTextView.this.nVw.setOnTouchListener(ExpandableTextView.this.mek);
                            ExpandableTextView.this.nVw.setText(ExpandableTextView.this.mei);
                            ExpandableTextView.this.meb.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.meb.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.meb.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.meb.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.men = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dXL();
            }
        };
        this.nVD = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dXM();
            }
        };
        this.nVE = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dXM();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 1;
        this.nVu = true;
        this.nVv = false;
        this.mef = false;
        this.nVx = 2;
        this.nVy = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.nVB = false;
        this.nVC = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.nVw != null && ExpandableTextView.this.mei != null && ExpandableTextView.this.nVu && (layout = ExpandableTextView.this.nVw.getLayout()) != null) {
                    if (!ExpandableTextView.this.nVv) {
                        if (layout.getLineCount() > ExpandableTextView.this.nVx) {
                            if (ExpandableTextView.this.mej == null) {
                                String spannableStringBuilder = ExpandableTextView.this.mei.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.nVx - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.nVx - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), at.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.mej = new SpannableStringBuilder();
                                ExpandableTextView.this.mej.append((CharSequence) substring2);
                                ExpandableTextView.this.mej.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.mej.length();
                                for (Object obj : ExpandableTextView.this.mei.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.mei.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.mei.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.mej.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.mej.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.men, 0, spannableString.length(), 17);
                                ExpandableTextView.this.mej.append((CharSequence) spannableString);
                                ExpandableTextView.this.mel = new i(ExpandableTextView.this.mej);
                                ((i) ExpandableTextView.this.mel).Mm(R.color.transparent);
                            }
                            ExpandableTextView.this.meb.setVisibility(8);
                            ExpandableTextView.this.nVw.setOnTouchListener(ExpandableTextView.this.mel);
                            ExpandableTextView.this.nVw.setText(ExpandableTextView.this.mej);
                            if (ExpandableTextView.this.nVB) {
                                ExpandableTextView.this.dXL();
                            }
                        }
                    } else if (!ExpandableTextView.this.mef) {
                        ExpandableTextView.this.mef = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.nVD, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.mei.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.mei.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.mei.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.mek).Mm(R.color.transparent);
                            ExpandableTextView.this.nVw.setOnTouchListener(ExpandableTextView.this.mek);
                            ExpandableTextView.this.nVw.setText(ExpandableTextView.this.mei);
                            ExpandableTextView.this.meb.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.meb.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.meb.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.meb.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.men = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dXL();
            }
        };
        this.nVD = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dXM();
            }
        };
        this.nVE = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dXM();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 1;
        this.nVu = true;
        this.nVv = false;
        this.mef = false;
        this.nVx = 2;
        this.nVy = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.nVB = false;
        this.nVC = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.nVw != null && ExpandableTextView.this.mei != null && ExpandableTextView.this.nVu && (layout = ExpandableTextView.this.nVw.getLayout()) != null) {
                    if (!ExpandableTextView.this.nVv) {
                        if (layout.getLineCount() > ExpandableTextView.this.nVx) {
                            if (ExpandableTextView.this.mej == null) {
                                String spannableStringBuilder = ExpandableTextView.this.mei.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.nVx - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.nVx - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), at.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.mej = new SpannableStringBuilder();
                                ExpandableTextView.this.mej.append((CharSequence) substring2);
                                ExpandableTextView.this.mej.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.mej.length();
                                for (Object obj : ExpandableTextView.this.mei.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.mei.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.mei.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.mej.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.mej.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.men, 0, spannableString.length(), 17);
                                ExpandableTextView.this.mej.append((CharSequence) spannableString);
                                ExpandableTextView.this.mel = new i(ExpandableTextView.this.mej);
                                ((i) ExpandableTextView.this.mel).Mm(R.color.transparent);
                            }
                            ExpandableTextView.this.meb.setVisibility(8);
                            ExpandableTextView.this.nVw.setOnTouchListener(ExpandableTextView.this.mel);
                            ExpandableTextView.this.nVw.setText(ExpandableTextView.this.mej);
                            if (ExpandableTextView.this.nVB) {
                                ExpandableTextView.this.dXL();
                            }
                        }
                    } else if (!ExpandableTextView.this.mef) {
                        ExpandableTextView.this.mef = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.nVD, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.mei.append((CharSequence) spannableString2);
                            } else {
                                int i2 = (lineEnd2 - lineEnd3) + 1;
                                for (int i22 = 0; i22 < i2; i22++) {
                                    ExpandableTextView.this.mei.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.mei.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.mek).Mm(R.color.transparent);
                            ExpandableTextView.this.nVw.setOnTouchListener(ExpandableTextView.this.mek);
                            ExpandableTextView.this.nVw.setText(ExpandableTextView.this.mei);
                            ExpandableTextView.this.meb.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.meb.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.meb.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.meb.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.men = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dXL();
            }
        };
        this.nVD = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dXM();
            }
        };
        this.nVE = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dXM();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
        this.nVw = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
        this.nVw.setTextSize(0, TbConfig.getContentSize());
        this.nVw.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.meb = (TextView) findViewById(R.id.expandable_view_title_up);
        this.meb.setOnClickListener(this.nVE);
        this.textSize = l.getDimens(context, R.dimen.tbfontsize42);
        this.textColor = R.color.CAM_X0101;
        this.nVz = l.getDimens(context, R.dimen.tbds6);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.nVw.setTextSize(0, i);
        this.meb.setTextSize(0, i);
    }

    public void setTextColor(int i) {
        this.textColor = i;
        ao.setViewTextColor(this.nVw, this.textColor, 1);
    }

    public void setLineSpacingExtra(int i) {
        this.nVz = i;
        this.nVw.setLineSpacing(i, 1.0f);
        this.meb.setLineSpacing(i, 1.0f);
    }

    public void setTextMaxLine(int i) {
        this.nVy = i;
    }

    public void setExpandable(boolean z) {
        this.nVu = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.nVw.getViewTreeObserver().removeGlobalOnLayoutListener(this.nVC);
            } else {
                this.nVw.getViewTreeObserver().removeOnGlobalLayoutListener(this.nVC);
            }
            this.nVw.setMaxLines(this.nVy);
            this.nVw.setEllipsize(TextUtils.TruncateAt.END);
            this.nVw.setText(this.mei);
            this.nVw.setOnTouchListener(null);
            this.meb.setVisibility(8);
            return;
        }
        this.nVw.getViewTreeObserver().addOnGlobalLayoutListener(this.nVC);
        this.nVw.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.nVw.setEllipsize(null);
    }

    public void setExpandType(int i) {
        this.type = i;
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.meb.setPadding(i, i2, i3, i4);
    }

    public void setData(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.nVB = z;
        this.mei = new SpannableStringBuilder(charSequence);
        this.mek = new i(this.mei);
        this.nVw.setText(this.mei);
        this.nVw.setLinkTextColor(ao.getColor(R.color.CAM_X0304));
        this.nVw.setOnTouchListener(this.mek);
        ao.setViewTextColor(this.nVw, this.textColor, 1);
    }

    public TextView getContentView() {
        return this.nVw;
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.nVw, this.textColor, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXL() {
        this.nVv = true;
        if (this.nVA != null) {
            this.nVA.rD(this.nVv);
        }
        this.nVw.setOnTouchListener(this.mek);
        this.nVw.setText(this.mei);
        if (this.type == 1) {
            this.meb.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXM() {
        this.nVv = false;
        if (this.nVA != null) {
            this.nVA.rD(this.nVv);
        }
        this.nVw.setOnTouchListener(this.mel);
        this.nVw.setText(this.mej);
        this.meb.setVisibility(8);
    }

    public void setOnStatusChangedListener(a aVar) {
        this.nVA = aVar;
    }
}
