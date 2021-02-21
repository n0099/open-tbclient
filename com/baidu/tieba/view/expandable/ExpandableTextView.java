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
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.view.i;
/* loaded from: classes.dex */
public class ExpandableTextView extends RelativeLayout {
    private TextView miP;
    private boolean miT;
    private SpannableStringBuilder miW;
    private SpannableStringBuilder miX;
    private View.OnTouchListener miY;
    private View.OnTouchListener miZ;
    private f mja;
    private a obA;
    private boolean obB;
    private ViewTreeObserver.OnGlobalLayoutListener obC;
    private f obD;
    private View.OnClickListener obE;
    private boolean obu;
    private boolean obv;
    private SpannableClickTextView obw;
    private int obx;
    private int oby;
    private int obz;
    private int textColor;
    private int textSize;
    private int type;

    /* loaded from: classes.dex */
    public interface a {
        void rJ(boolean z);
    }

    public ExpandableTextView(Context context) {
        super(context);
        this.type = 1;
        this.obu = true;
        this.obv = false;
        this.miT = false;
        this.obx = 2;
        this.oby = Integer.MAX_VALUE;
        this.obB = false;
        this.obC = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.obw != null && ExpandableTextView.this.miW != null && ExpandableTextView.this.obu && (layout = ExpandableTextView.this.obw.getLayout()) != null) {
                    if (!ExpandableTextView.this.obv) {
                        if (layout.getLineCount() > ExpandableTextView.this.obx) {
                            if (ExpandableTextView.this.miX == null) {
                                String spannableStringBuilder = ExpandableTextView.this.miW.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.obx - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.obx - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), au.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.miX = new SpannableStringBuilder();
                                ExpandableTextView.this.miX.append((CharSequence) substring2);
                                ExpandableTextView.this.miX.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.miX.length();
                                for (Object obj : ExpandableTextView.this.miW.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.miW.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.miW.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.miX.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.miX.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.mja, 0, spannableString.length(), 17);
                                ExpandableTextView.this.miX.append((CharSequence) spannableString);
                                ExpandableTextView.this.miZ = new i(ExpandableTextView.this.miX);
                                ((i) ExpandableTextView.this.miZ).Lb(R.color.transparent);
                            }
                            ExpandableTextView.this.miP.setVisibility(8);
                            ExpandableTextView.this.obw.setOnTouchListener(ExpandableTextView.this.miZ);
                            ExpandableTextView.this.obw.setText(ExpandableTextView.this.miX);
                            if (ExpandableTextView.this.obB) {
                                ExpandableTextView.this.dWq();
                            }
                        }
                    } else if (!ExpandableTextView.this.miT) {
                        ExpandableTextView.this.miT = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.obD, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.miW.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.miW.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.miW.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.miY).Lb(R.color.transparent);
                            ExpandableTextView.this.obw.setOnTouchListener(ExpandableTextView.this.miY);
                            ExpandableTextView.this.obw.setText(ExpandableTextView.this.miW);
                            ExpandableTextView.this.miP.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.miP.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.miP.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.miP.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.mja = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dWq();
            }
        };
        this.obD = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dWr();
            }
        };
        this.obE = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dWr();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 1;
        this.obu = true;
        this.obv = false;
        this.miT = false;
        this.obx = 2;
        this.oby = Integer.MAX_VALUE;
        this.obB = false;
        this.obC = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.obw != null && ExpandableTextView.this.miW != null && ExpandableTextView.this.obu && (layout = ExpandableTextView.this.obw.getLayout()) != null) {
                    if (!ExpandableTextView.this.obv) {
                        if (layout.getLineCount() > ExpandableTextView.this.obx) {
                            if (ExpandableTextView.this.miX == null) {
                                String spannableStringBuilder = ExpandableTextView.this.miW.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.obx - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.obx - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), au.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.miX = new SpannableStringBuilder();
                                ExpandableTextView.this.miX.append((CharSequence) substring2);
                                ExpandableTextView.this.miX.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.miX.length();
                                for (Object obj : ExpandableTextView.this.miW.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.miW.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.miW.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.miX.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.miX.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.mja, 0, spannableString.length(), 17);
                                ExpandableTextView.this.miX.append((CharSequence) spannableString);
                                ExpandableTextView.this.miZ = new i(ExpandableTextView.this.miX);
                                ((i) ExpandableTextView.this.miZ).Lb(R.color.transparent);
                            }
                            ExpandableTextView.this.miP.setVisibility(8);
                            ExpandableTextView.this.obw.setOnTouchListener(ExpandableTextView.this.miZ);
                            ExpandableTextView.this.obw.setText(ExpandableTextView.this.miX);
                            if (ExpandableTextView.this.obB) {
                                ExpandableTextView.this.dWq();
                            }
                        }
                    } else if (!ExpandableTextView.this.miT) {
                        ExpandableTextView.this.miT = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.obD, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.miW.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.miW.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.miW.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.miY).Lb(R.color.transparent);
                            ExpandableTextView.this.obw.setOnTouchListener(ExpandableTextView.this.miY);
                            ExpandableTextView.this.obw.setText(ExpandableTextView.this.miW);
                            ExpandableTextView.this.miP.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.miP.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.miP.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.miP.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.mja = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dWq();
            }
        };
        this.obD = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dWr();
            }
        };
        this.obE = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dWr();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 1;
        this.obu = true;
        this.obv = false;
        this.miT = false;
        this.obx = 2;
        this.oby = Integer.MAX_VALUE;
        this.obB = false;
        this.obC = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.obw != null && ExpandableTextView.this.miW != null && ExpandableTextView.this.obu && (layout = ExpandableTextView.this.obw.getLayout()) != null) {
                    if (!ExpandableTextView.this.obv) {
                        if (layout.getLineCount() > ExpandableTextView.this.obx) {
                            if (ExpandableTextView.this.miX == null) {
                                String spannableStringBuilder = ExpandableTextView.this.miW.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.obx - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.obx - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), au.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.miX = new SpannableStringBuilder();
                                ExpandableTextView.this.miX.append((CharSequence) substring2);
                                ExpandableTextView.this.miX.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.miX.length();
                                for (Object obj : ExpandableTextView.this.miW.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.miW.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.miW.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.miX.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.miX.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.mja, 0, spannableString.length(), 17);
                                ExpandableTextView.this.miX.append((CharSequence) spannableString);
                                ExpandableTextView.this.miZ = new i(ExpandableTextView.this.miX);
                                ((i) ExpandableTextView.this.miZ).Lb(R.color.transparent);
                            }
                            ExpandableTextView.this.miP.setVisibility(8);
                            ExpandableTextView.this.obw.setOnTouchListener(ExpandableTextView.this.miZ);
                            ExpandableTextView.this.obw.setText(ExpandableTextView.this.miX);
                            if (ExpandableTextView.this.obB) {
                                ExpandableTextView.this.dWq();
                            }
                        }
                    } else if (!ExpandableTextView.this.miT) {
                        ExpandableTextView.this.miT = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.obD, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.miW.append((CharSequence) spannableString2);
                            } else {
                                int i2 = (lineEnd2 - lineEnd3) + 1;
                                for (int i22 = 0; i22 < i2; i22++) {
                                    ExpandableTextView.this.miW.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.miW.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.miY).Lb(R.color.transparent);
                            ExpandableTextView.this.obw.setOnTouchListener(ExpandableTextView.this.miY);
                            ExpandableTextView.this.obw.setText(ExpandableTextView.this.miW);
                            ExpandableTextView.this.miP.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.miP.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.miP.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.miP.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.mja = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dWq();
            }
        };
        this.obD = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dWr();
            }
        };
        this.obE = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dWr();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
        this.obw = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
        this.obw.setTextSize(0, TbConfig.getContentSize());
        this.obw.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.miP = (TextView) findViewById(R.id.expandable_view_title_up);
        this.miP.setOnClickListener(this.obE);
        this.textSize = l.getDimens(context, R.dimen.tbfontsize42);
        this.textColor = R.color.CAM_X0101;
        this.obz = l.getDimens(context, R.dimen.tbds6);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.obw.setTextSize(0, i);
        this.miP.setTextSize(0, i);
    }

    public void setHasDown() {
        c.br(this.obw).oi(R.array.S_O_X001);
    }

    public void setTextColor(int i) {
        this.textColor = i;
        ap.setViewTextColor(this.obw, this.textColor, 1);
    }

    public void setLineSpacingExtra(int i) {
        this.obz = i;
        this.obw.setLineSpacing(i, 1.0f);
        this.miP.setLineSpacing(i, 1.0f);
    }

    public void setTextMaxLine(int i) {
        this.oby = i;
    }

    public void setExpandable(boolean z) {
        this.obu = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.obw.getViewTreeObserver().removeGlobalOnLayoutListener(this.obC);
            } else {
                this.obw.getViewTreeObserver().removeOnGlobalLayoutListener(this.obC);
            }
            this.obw.setMaxLines(this.oby);
            this.obw.setEllipsize(TextUtils.TruncateAt.END);
            this.obw.setText(this.miW);
            this.obw.setOnTouchListener(null);
            this.miP.setVisibility(8);
            return;
        }
        this.obw.getViewTreeObserver().addOnGlobalLayoutListener(this.obC);
        this.obw.setMaxLines(Integer.MAX_VALUE);
        this.obw.setEllipsize(null);
    }

    public void setExpandType(int i) {
        this.type = i;
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.miP.setPadding(i, i2, i3, i4);
    }

    public void setData(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.obB = z;
        this.miW = new SpannableStringBuilder(charSequence);
        this.miY = new i(this.miW);
        this.obw.setText(this.miW);
        this.obw.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
        this.obw.setOnTouchListener(this.miY);
        ap.setViewTextColor(this.obw, this.textColor, 1);
    }

    public TextView getContentView() {
        return this.obw;
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.obw, this.textColor, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWq() {
        this.obv = true;
        if (this.obA != null) {
            this.obA.rJ(this.obv);
        }
        this.obw.setOnTouchListener(this.miY);
        this.obw.setText(this.miW);
        if (this.type == 1) {
            this.miP.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWr() {
        this.obv = false;
        if (this.obA != null) {
            this.obA.rJ(this.obv);
        }
        this.obw.setOnTouchListener(this.miZ);
        this.obw.setText(this.miX);
        this.miP.setVisibility(8);
    }

    public void setOnStatusChangedListener(a aVar) {
        this.obA = aVar;
    }
}
