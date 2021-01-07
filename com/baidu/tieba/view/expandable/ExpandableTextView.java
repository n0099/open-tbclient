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
    private TextView mea;
    private boolean mee;
    private SpannableStringBuilder meh;
    private SpannableStringBuilder mei;
    private View.OnTouchListener mej;
    private View.OnTouchListener mek;
    private f mel;
    private boolean nVA;
    private ViewTreeObserver.OnGlobalLayoutListener nVB;
    private f nVC;
    private View.OnClickListener nVD;
    private boolean nVt;
    private boolean nVu;
    private SpannableClickTextView nVv;
    private int nVw;
    private int nVx;
    private int nVy;
    private a nVz;
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
        this.nVt = true;
        this.nVu = false;
        this.mee = false;
        this.nVw = 2;
        this.nVx = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.nVA = false;
        this.nVB = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.nVv != null && ExpandableTextView.this.meh != null && ExpandableTextView.this.nVt && (layout = ExpandableTextView.this.nVv.getLayout()) != null) {
                    if (!ExpandableTextView.this.nVu) {
                        if (layout.getLineCount() > ExpandableTextView.this.nVw) {
                            if (ExpandableTextView.this.mei == null) {
                                String spannableStringBuilder = ExpandableTextView.this.meh.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.nVw - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.nVw - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), at.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.mei = new SpannableStringBuilder();
                                ExpandableTextView.this.mei.append((CharSequence) substring2);
                                ExpandableTextView.this.mei.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.mei.length();
                                for (Object obj : ExpandableTextView.this.meh.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.meh.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.meh.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.mei.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.mei.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.mel, 0, spannableString.length(), 17);
                                ExpandableTextView.this.mei.append((CharSequence) spannableString);
                                ExpandableTextView.this.mek = new i(ExpandableTextView.this.mei);
                                ((i) ExpandableTextView.this.mek).Mm(R.color.transparent);
                            }
                            ExpandableTextView.this.mea.setVisibility(8);
                            ExpandableTextView.this.nVv.setOnTouchListener(ExpandableTextView.this.mek);
                            ExpandableTextView.this.nVv.setText(ExpandableTextView.this.mei);
                            if (ExpandableTextView.this.nVA) {
                                ExpandableTextView.this.dXM();
                            }
                        }
                    } else if (!ExpandableTextView.this.mee) {
                        ExpandableTextView.this.mee = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.nVC, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.meh.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.meh.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.meh.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.mej).Mm(R.color.transparent);
                            ExpandableTextView.this.nVv.setOnTouchListener(ExpandableTextView.this.mej);
                            ExpandableTextView.this.nVv.setText(ExpandableTextView.this.meh);
                            ExpandableTextView.this.mea.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.mea.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.mea.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.mea.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.mel = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dXM();
            }
        };
        this.nVC = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dXN();
            }
        };
        this.nVD = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dXN();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 1;
        this.nVt = true;
        this.nVu = false;
        this.mee = false;
        this.nVw = 2;
        this.nVx = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.nVA = false;
        this.nVB = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.nVv != null && ExpandableTextView.this.meh != null && ExpandableTextView.this.nVt && (layout = ExpandableTextView.this.nVv.getLayout()) != null) {
                    if (!ExpandableTextView.this.nVu) {
                        if (layout.getLineCount() > ExpandableTextView.this.nVw) {
                            if (ExpandableTextView.this.mei == null) {
                                String spannableStringBuilder = ExpandableTextView.this.meh.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.nVw - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.nVw - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), at.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.mei = new SpannableStringBuilder();
                                ExpandableTextView.this.mei.append((CharSequence) substring2);
                                ExpandableTextView.this.mei.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.mei.length();
                                for (Object obj : ExpandableTextView.this.meh.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.meh.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.meh.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.mei.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.mei.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.mel, 0, spannableString.length(), 17);
                                ExpandableTextView.this.mei.append((CharSequence) spannableString);
                                ExpandableTextView.this.mek = new i(ExpandableTextView.this.mei);
                                ((i) ExpandableTextView.this.mek).Mm(R.color.transparent);
                            }
                            ExpandableTextView.this.mea.setVisibility(8);
                            ExpandableTextView.this.nVv.setOnTouchListener(ExpandableTextView.this.mek);
                            ExpandableTextView.this.nVv.setText(ExpandableTextView.this.mei);
                            if (ExpandableTextView.this.nVA) {
                                ExpandableTextView.this.dXM();
                            }
                        }
                    } else if (!ExpandableTextView.this.mee) {
                        ExpandableTextView.this.mee = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.nVC, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.meh.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.meh.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.meh.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.mej).Mm(R.color.transparent);
                            ExpandableTextView.this.nVv.setOnTouchListener(ExpandableTextView.this.mej);
                            ExpandableTextView.this.nVv.setText(ExpandableTextView.this.meh);
                            ExpandableTextView.this.mea.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.mea.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.mea.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.mea.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.mel = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dXM();
            }
        };
        this.nVC = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dXN();
            }
        };
        this.nVD = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dXN();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 1;
        this.nVt = true;
        this.nVu = false;
        this.mee = false;
        this.nVw = 2;
        this.nVx = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.nVA = false;
        this.nVB = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.nVv != null && ExpandableTextView.this.meh != null && ExpandableTextView.this.nVt && (layout = ExpandableTextView.this.nVv.getLayout()) != null) {
                    if (!ExpandableTextView.this.nVu) {
                        if (layout.getLineCount() > ExpandableTextView.this.nVw) {
                            if (ExpandableTextView.this.mei == null) {
                                String spannableStringBuilder = ExpandableTextView.this.meh.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.nVw - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.nVw - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = at.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), at.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.mei = new SpannableStringBuilder();
                                ExpandableTextView.this.mei.append((CharSequence) substring2);
                                ExpandableTextView.this.mei.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.mei.length();
                                for (Object obj : ExpandableTextView.this.meh.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.meh.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.meh.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.mei.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.mei.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.mel, 0, spannableString.length(), 17);
                                ExpandableTextView.this.mei.append((CharSequence) spannableString);
                                ExpandableTextView.this.mek = new i(ExpandableTextView.this.mei);
                                ((i) ExpandableTextView.this.mek).Mm(R.color.transparent);
                            }
                            ExpandableTextView.this.mea.setVisibility(8);
                            ExpandableTextView.this.nVv.setOnTouchListener(ExpandableTextView.this.mek);
                            ExpandableTextView.this.nVv.setText(ExpandableTextView.this.mei);
                            if (ExpandableTextView.this.nVA) {
                                ExpandableTextView.this.dXM();
                            }
                        }
                    } else if (!ExpandableTextView.this.mee) {
                        ExpandableTextView.this.mee = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.nVC, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.meh.append((CharSequence) spannableString2);
                            } else {
                                int i2 = (lineEnd2 - lineEnd3) + 1;
                                for (int i22 = 0; i22 < i2; i22++) {
                                    ExpandableTextView.this.meh.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.meh.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.mej).Mm(R.color.transparent);
                            ExpandableTextView.this.nVv.setOnTouchListener(ExpandableTextView.this.mej);
                            ExpandableTextView.this.nVv.setText(ExpandableTextView.this.meh);
                            ExpandableTextView.this.mea.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.mea.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.mea.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.mea.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.mel = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dXM();
            }
        };
        this.nVC = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dXN();
            }
        };
        this.nVD = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dXN();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
        this.nVv = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
        this.nVv.setTextSize(0, TbConfig.getContentSize());
        this.nVv.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.mea = (TextView) findViewById(R.id.expandable_view_title_up);
        this.mea.setOnClickListener(this.nVD);
        this.textSize = l.getDimens(context, R.dimen.tbfontsize42);
        this.textColor = R.color.CAM_X0101;
        this.nVy = l.getDimens(context, R.dimen.tbds6);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.nVv.setTextSize(0, i);
        this.mea.setTextSize(0, i);
    }

    public void setTextColor(int i) {
        this.textColor = i;
        ao.setViewTextColor(this.nVv, this.textColor, 1);
    }

    public void setLineSpacingExtra(int i) {
        this.nVy = i;
        this.nVv.setLineSpacing(i, 1.0f);
        this.mea.setLineSpacing(i, 1.0f);
    }

    public void setTextMaxLine(int i) {
        this.nVx = i;
    }

    public void setExpandable(boolean z) {
        this.nVt = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.nVv.getViewTreeObserver().removeGlobalOnLayoutListener(this.nVB);
            } else {
                this.nVv.getViewTreeObserver().removeOnGlobalLayoutListener(this.nVB);
            }
            this.nVv.setMaxLines(this.nVx);
            this.nVv.setEllipsize(TextUtils.TruncateAt.END);
            this.nVv.setText(this.meh);
            this.nVv.setOnTouchListener(null);
            this.mea.setVisibility(8);
            return;
        }
        this.nVv.getViewTreeObserver().addOnGlobalLayoutListener(this.nVB);
        this.nVv.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.nVv.setEllipsize(null);
    }

    public void setExpandType(int i) {
        this.type = i;
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.mea.setPadding(i, i2, i3, i4);
    }

    public void setData(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.nVA = z;
        this.meh = new SpannableStringBuilder(charSequence);
        this.mej = new i(this.meh);
        this.nVv.setText(this.meh);
        this.nVv.setLinkTextColor(ao.getColor(R.color.CAM_X0304));
        this.nVv.setOnTouchListener(this.mej);
        ao.setViewTextColor(this.nVv, this.textColor, 1);
    }

    public TextView getContentView() {
        return this.nVv;
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.nVv, this.textColor, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXM() {
        this.nVu = true;
        if (this.nVz != null) {
            this.nVz.rD(this.nVu);
        }
        this.nVv.setOnTouchListener(this.mej);
        this.nVv.setText(this.meh);
        if (this.type == 1) {
            this.mea.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXN() {
        this.nVu = false;
        if (this.nVz != null) {
            this.nVz.rD(this.nVu);
        }
        this.nVv.setOnTouchListener(this.mek);
        this.nVv.setText(this.mei);
        this.mea.setVisibility(8);
    }

    public void setOnStatusChangedListener(a aVar) {
        this.nVz = aVar;
    }
}
