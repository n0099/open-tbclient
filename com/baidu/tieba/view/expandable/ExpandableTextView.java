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
    private TextView miA;
    private boolean miE;
    private SpannableStringBuilder miH;
    private SpannableStringBuilder miI;
    private View.OnTouchListener miJ;
    private View.OnTouchListener miK;
    private f miL;
    private boolean oaT;
    private boolean oaU;
    private SpannableClickTextView oaV;
    private int oaW;
    private int oaX;
    private int oaY;
    private a oaZ;
    private boolean oba;
    private ViewTreeObserver.OnGlobalLayoutListener obb;
    private f obc;
    private View.OnClickListener obd;
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
        this.oaT = true;
        this.oaU = false;
        this.miE = false;
        this.oaW = 2;
        this.oaX = Integer.MAX_VALUE;
        this.oba = false;
        this.obb = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.oaV != null && ExpandableTextView.this.miH != null && ExpandableTextView.this.oaT && (layout = ExpandableTextView.this.oaV.getLayout()) != null) {
                    if (!ExpandableTextView.this.oaU) {
                        if (layout.getLineCount() > ExpandableTextView.this.oaW) {
                            if (ExpandableTextView.this.miI == null) {
                                String spannableStringBuilder = ExpandableTextView.this.miH.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.oaW - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.oaW - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), au.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.miI = new SpannableStringBuilder();
                                ExpandableTextView.this.miI.append((CharSequence) substring2);
                                ExpandableTextView.this.miI.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.miI.length();
                                for (Object obj : ExpandableTextView.this.miH.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.miH.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.miH.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.miI.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.miI.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.miL, 0, spannableString.length(), 17);
                                ExpandableTextView.this.miI.append((CharSequence) spannableString);
                                ExpandableTextView.this.miK = new i(ExpandableTextView.this.miI);
                                ((i) ExpandableTextView.this.miK).La(R.color.transparent);
                            }
                            ExpandableTextView.this.miA.setVisibility(8);
                            ExpandableTextView.this.oaV.setOnTouchListener(ExpandableTextView.this.miK);
                            ExpandableTextView.this.oaV.setText(ExpandableTextView.this.miI);
                            if (ExpandableTextView.this.oba) {
                                ExpandableTextView.this.dWi();
                            }
                        }
                    } else if (!ExpandableTextView.this.miE) {
                        ExpandableTextView.this.miE = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.obc, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.miH.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.miH.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.miH.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.miJ).La(R.color.transparent);
                            ExpandableTextView.this.oaV.setOnTouchListener(ExpandableTextView.this.miJ);
                            ExpandableTextView.this.oaV.setText(ExpandableTextView.this.miH);
                            ExpandableTextView.this.miA.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.miA.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.miA.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.miA.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.miL = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dWi();
            }
        };
        this.obc = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dWj();
            }
        };
        this.obd = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dWj();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 1;
        this.oaT = true;
        this.oaU = false;
        this.miE = false;
        this.oaW = 2;
        this.oaX = Integer.MAX_VALUE;
        this.oba = false;
        this.obb = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.oaV != null && ExpandableTextView.this.miH != null && ExpandableTextView.this.oaT && (layout = ExpandableTextView.this.oaV.getLayout()) != null) {
                    if (!ExpandableTextView.this.oaU) {
                        if (layout.getLineCount() > ExpandableTextView.this.oaW) {
                            if (ExpandableTextView.this.miI == null) {
                                String spannableStringBuilder = ExpandableTextView.this.miH.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.oaW - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.oaW - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), au.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.miI = new SpannableStringBuilder();
                                ExpandableTextView.this.miI.append((CharSequence) substring2);
                                ExpandableTextView.this.miI.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.miI.length();
                                for (Object obj : ExpandableTextView.this.miH.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.miH.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.miH.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.miI.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.miI.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.miL, 0, spannableString.length(), 17);
                                ExpandableTextView.this.miI.append((CharSequence) spannableString);
                                ExpandableTextView.this.miK = new i(ExpandableTextView.this.miI);
                                ((i) ExpandableTextView.this.miK).La(R.color.transparent);
                            }
                            ExpandableTextView.this.miA.setVisibility(8);
                            ExpandableTextView.this.oaV.setOnTouchListener(ExpandableTextView.this.miK);
                            ExpandableTextView.this.oaV.setText(ExpandableTextView.this.miI);
                            if (ExpandableTextView.this.oba) {
                                ExpandableTextView.this.dWi();
                            }
                        }
                    } else if (!ExpandableTextView.this.miE) {
                        ExpandableTextView.this.miE = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.obc, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.miH.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.miH.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.miH.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.miJ).La(R.color.transparent);
                            ExpandableTextView.this.oaV.setOnTouchListener(ExpandableTextView.this.miJ);
                            ExpandableTextView.this.oaV.setText(ExpandableTextView.this.miH);
                            ExpandableTextView.this.miA.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.miA.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.miA.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.miA.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.miL = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dWi();
            }
        };
        this.obc = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dWj();
            }
        };
        this.obd = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dWj();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 1;
        this.oaT = true;
        this.oaU = false;
        this.miE = false;
        this.oaW = 2;
        this.oaX = Integer.MAX_VALUE;
        this.oba = false;
        this.obb = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.oaV != null && ExpandableTextView.this.miH != null && ExpandableTextView.this.oaT && (layout = ExpandableTextView.this.oaV.getLayout()) != null) {
                    if (!ExpandableTextView.this.oaU) {
                        if (layout.getLineCount() > ExpandableTextView.this.oaW) {
                            if (ExpandableTextView.this.miI == null) {
                                String spannableStringBuilder = ExpandableTextView.this.miH.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.oaW - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.oaW - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), au.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.miI = new SpannableStringBuilder();
                                ExpandableTextView.this.miI.append((CharSequence) substring2);
                                ExpandableTextView.this.miI.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.miI.length();
                                for (Object obj : ExpandableTextView.this.miH.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.miH.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.miH.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.miI.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.miI.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.miL, 0, spannableString.length(), 17);
                                ExpandableTextView.this.miI.append((CharSequence) spannableString);
                                ExpandableTextView.this.miK = new i(ExpandableTextView.this.miI);
                                ((i) ExpandableTextView.this.miK).La(R.color.transparent);
                            }
                            ExpandableTextView.this.miA.setVisibility(8);
                            ExpandableTextView.this.oaV.setOnTouchListener(ExpandableTextView.this.miK);
                            ExpandableTextView.this.oaV.setText(ExpandableTextView.this.miI);
                            if (ExpandableTextView.this.oba) {
                                ExpandableTextView.this.dWi();
                            }
                        }
                    } else if (!ExpandableTextView.this.miE) {
                        ExpandableTextView.this.miE = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.obc, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.miH.append((CharSequence) spannableString2);
                            } else {
                                int i2 = (lineEnd2 - lineEnd3) + 1;
                                for (int i22 = 0; i22 < i2; i22++) {
                                    ExpandableTextView.this.miH.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.miH.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.miJ).La(R.color.transparent);
                            ExpandableTextView.this.oaV.setOnTouchListener(ExpandableTextView.this.miJ);
                            ExpandableTextView.this.oaV.setText(ExpandableTextView.this.miH);
                            ExpandableTextView.this.miA.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.miA.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.miA.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.miA.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.miL = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dWi();
            }
        };
        this.obc = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dWj();
            }
        };
        this.obd = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dWj();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
        this.oaV = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
        this.oaV.setTextSize(0, TbConfig.getContentSize());
        this.oaV.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.miA = (TextView) findViewById(R.id.expandable_view_title_up);
        this.miA.setOnClickListener(this.obd);
        this.textSize = l.getDimens(context, R.dimen.tbfontsize42);
        this.textColor = R.color.CAM_X0101;
        this.oaY = l.getDimens(context, R.dimen.tbds6);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.oaV.setTextSize(0, i);
        this.miA.setTextSize(0, i);
    }

    public void setHasDown() {
        c.br(this.oaV).oi(R.array.S_O_X001);
    }

    public void setTextColor(int i) {
        this.textColor = i;
        ap.setViewTextColor(this.oaV, this.textColor, 1);
    }

    public void setLineSpacingExtra(int i) {
        this.oaY = i;
        this.oaV.setLineSpacing(i, 1.0f);
        this.miA.setLineSpacing(i, 1.0f);
    }

    public void setTextMaxLine(int i) {
        this.oaX = i;
    }

    public void setExpandable(boolean z) {
        this.oaT = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.oaV.getViewTreeObserver().removeGlobalOnLayoutListener(this.obb);
            } else {
                this.oaV.getViewTreeObserver().removeOnGlobalLayoutListener(this.obb);
            }
            this.oaV.setMaxLines(this.oaX);
            this.oaV.setEllipsize(TextUtils.TruncateAt.END);
            this.oaV.setText(this.miH);
            this.oaV.setOnTouchListener(null);
            this.miA.setVisibility(8);
            return;
        }
        this.oaV.getViewTreeObserver().addOnGlobalLayoutListener(this.obb);
        this.oaV.setMaxLines(Integer.MAX_VALUE);
        this.oaV.setEllipsize(null);
    }

    public void setExpandType(int i) {
        this.type = i;
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.miA.setPadding(i, i2, i3, i4);
    }

    public void setData(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.oba = z;
        this.miH = new SpannableStringBuilder(charSequence);
        this.miJ = new i(this.miH);
        this.oaV.setText(this.miH);
        this.oaV.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
        this.oaV.setOnTouchListener(this.miJ);
        ap.setViewTextColor(this.oaV, this.textColor, 1);
    }

    public TextView getContentView() {
        return this.oaV;
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.oaV, this.textColor, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWi() {
        this.oaU = true;
        if (this.oaZ != null) {
            this.oaZ.rJ(this.oaU);
        }
        this.oaV.setOnTouchListener(this.miJ);
        this.oaV.setText(this.miH);
        if (this.type == 1) {
            this.miA.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWj() {
        this.oaU = false;
        if (this.oaZ != null) {
            this.oaZ.rJ(this.oaU);
        }
        this.oaV.setOnTouchListener(this.miK);
        this.oaV.setText(this.miI);
        this.miA.setVisibility(8);
    }

    public void setOnStatusChangedListener(a aVar) {
        this.oaZ = aVar;
    }
}
