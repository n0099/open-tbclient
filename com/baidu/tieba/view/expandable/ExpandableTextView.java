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
    private TextView mkR;
    private boolean mkV;
    private SpannableStringBuilder mkY;
    private SpannableStringBuilder mkZ;
    private View.OnTouchListener mla;
    private View.OnTouchListener mlb;
    private f mlc;
    private boolean odA;
    private boolean odB;
    private SpannableClickTextView odC;
    private int odD;
    private int odE;
    private int odF;
    private a odG;
    private boolean odH;
    private ViewTreeObserver.OnGlobalLayoutListener odI;
    private f odJ;
    private View.OnClickListener odK;
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
        this.odA = true;
        this.odB = false;
        this.mkV = false;
        this.odD = 2;
        this.odE = Integer.MAX_VALUE;
        this.odH = false;
        this.odI = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.odC != null && ExpandableTextView.this.mkY != null && ExpandableTextView.this.odA && (layout = ExpandableTextView.this.odC.getLayout()) != null) {
                    if (!ExpandableTextView.this.odB) {
                        if (layout.getLineCount() > ExpandableTextView.this.odD) {
                            if (ExpandableTextView.this.mkZ == null) {
                                String spannableStringBuilder = ExpandableTextView.this.mkY.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.odD - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.odD - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), au.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.mkZ = new SpannableStringBuilder();
                                ExpandableTextView.this.mkZ.append((CharSequence) substring2);
                                ExpandableTextView.this.mkZ.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.mkZ.length();
                                for (Object obj : ExpandableTextView.this.mkY.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.mkY.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.mkY.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.mkZ.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.mkZ.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.mlc, 0, spannableString.length(), 17);
                                ExpandableTextView.this.mkZ.append((CharSequence) spannableString);
                                ExpandableTextView.this.mlb = new i(ExpandableTextView.this.mkZ);
                                ((i) ExpandableTextView.this.mlb).Lf(R.color.transparent);
                            }
                            ExpandableTextView.this.mkR.setVisibility(8);
                            ExpandableTextView.this.odC.setOnTouchListener(ExpandableTextView.this.mlb);
                            ExpandableTextView.this.odC.setText(ExpandableTextView.this.mkZ);
                            if (ExpandableTextView.this.odH) {
                                ExpandableTextView.this.dWy();
                            }
                        }
                    } else if (!ExpandableTextView.this.mkV) {
                        ExpandableTextView.this.mkV = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.odJ, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.mkY.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.mkY.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.mkY.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.mla).Lf(R.color.transparent);
                            ExpandableTextView.this.odC.setOnTouchListener(ExpandableTextView.this.mla);
                            ExpandableTextView.this.odC.setText(ExpandableTextView.this.mkY);
                            ExpandableTextView.this.mkR.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.mkR.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.mkR.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.mkR.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.mlc = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dWy();
            }
        };
        this.odJ = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dWz();
            }
        };
        this.odK = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dWz();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 1;
        this.odA = true;
        this.odB = false;
        this.mkV = false;
        this.odD = 2;
        this.odE = Integer.MAX_VALUE;
        this.odH = false;
        this.odI = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.odC != null && ExpandableTextView.this.mkY != null && ExpandableTextView.this.odA && (layout = ExpandableTextView.this.odC.getLayout()) != null) {
                    if (!ExpandableTextView.this.odB) {
                        if (layout.getLineCount() > ExpandableTextView.this.odD) {
                            if (ExpandableTextView.this.mkZ == null) {
                                String spannableStringBuilder = ExpandableTextView.this.mkY.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.odD - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.odD - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), au.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.mkZ = new SpannableStringBuilder();
                                ExpandableTextView.this.mkZ.append((CharSequence) substring2);
                                ExpandableTextView.this.mkZ.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.mkZ.length();
                                for (Object obj : ExpandableTextView.this.mkY.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.mkY.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.mkY.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.mkZ.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.mkZ.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.mlc, 0, spannableString.length(), 17);
                                ExpandableTextView.this.mkZ.append((CharSequence) spannableString);
                                ExpandableTextView.this.mlb = new i(ExpandableTextView.this.mkZ);
                                ((i) ExpandableTextView.this.mlb).Lf(R.color.transparent);
                            }
                            ExpandableTextView.this.mkR.setVisibility(8);
                            ExpandableTextView.this.odC.setOnTouchListener(ExpandableTextView.this.mlb);
                            ExpandableTextView.this.odC.setText(ExpandableTextView.this.mkZ);
                            if (ExpandableTextView.this.odH) {
                                ExpandableTextView.this.dWy();
                            }
                        }
                    } else if (!ExpandableTextView.this.mkV) {
                        ExpandableTextView.this.mkV = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.odJ, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.mkY.append((CharSequence) spannableString2);
                            } else {
                                int i = (lineEnd2 - lineEnd3) + 1;
                                for (int i2 = 0; i2 < i; i2++) {
                                    ExpandableTextView.this.mkY.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.mkY.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.mla).Lf(R.color.transparent);
                            ExpandableTextView.this.odC.setOnTouchListener(ExpandableTextView.this.mla);
                            ExpandableTextView.this.odC.setText(ExpandableTextView.this.mkY);
                            ExpandableTextView.this.mkR.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.mkR.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.mkR.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.mkR.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.mlc = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dWy();
            }
        };
        this.odJ = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dWz();
            }
        };
        this.odK = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dWz();
            }
        };
        init(context);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 1;
        this.odA = true;
        this.odB = false;
        this.mkV = false;
        this.odD = 2;
        this.odE = Integer.MAX_VALUE;
        this.odH = false;
        this.odI = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Layout layout;
                String substring;
                Object[] spans;
                if (ExpandableTextView.this.odC != null && ExpandableTextView.this.mkY != null && ExpandableTextView.this.odA && (layout = ExpandableTextView.this.odC.getLayout()) != null) {
                    if (!ExpandableTextView.this.odB) {
                        if (layout.getLineCount() > ExpandableTextView.this.odD) {
                            if (ExpandableTextView.this.mkZ == null) {
                                String spannableStringBuilder = ExpandableTextView.this.mkY.toString();
                                int lineStart = layout.getLineStart(ExpandableTextView.this.odD - 1);
                                int lineEnd = layout.getLineEnd(ExpandableTextView.this.odD - 1);
                                String substring2 = spannableStringBuilder.substring(0, lineStart);
                                String cutChineseAndEnglishWithSuffix = au.cutChineseAndEnglishWithSuffix(spannableStringBuilder.substring(lineStart, lineEnd), au.getChineseAndEnglishLength(substring) - 6, "");
                                ExpandableTextView.this.mkZ = new SpannableStringBuilder();
                                ExpandableTextView.this.mkZ.append((CharSequence) substring2);
                                ExpandableTextView.this.mkZ.append((CharSequence) cutChineseAndEnglishWithSuffix);
                                int length = ExpandableTextView.this.mkZ.length();
                                for (Object obj : ExpandableTextView.this.mkY.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                                    int spanStart = ExpandableTextView.this.mkY.getSpanStart(obj);
                                    int spanEnd = ExpandableTextView.this.mkY.getSpanEnd(obj);
                                    if (spanStart < length && spanEnd >= length) {
                                        break;
                                    }
                                    if (obj instanceof SpannableString) {
                                        ExpandableTextView.this.mkZ.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                                    }
                                }
                                ExpandableTextView.this.mkZ.append((CharSequence) StringHelper.STRING_MORE);
                                SpannableString spannableString = new SpannableString("展开");
                                spannableString.setSpan(ExpandableTextView.this.mlc, 0, spannableString.length(), 17);
                                ExpandableTextView.this.mkZ.append((CharSequence) spannableString);
                                ExpandableTextView.this.mlb = new i(ExpandableTextView.this.mkZ);
                                ((i) ExpandableTextView.this.mlb).Lf(R.color.transparent);
                            }
                            ExpandableTextView.this.mkR.setVisibility(8);
                            ExpandableTextView.this.odC.setOnTouchListener(ExpandableTextView.this.mlb);
                            ExpandableTextView.this.odC.setText(ExpandableTextView.this.mkZ);
                            if (ExpandableTextView.this.odH) {
                                ExpandableTextView.this.dWy();
                            }
                        }
                    } else if (!ExpandableTextView.this.mkV) {
                        ExpandableTextView.this.mkV = true;
                        if (ExpandableTextView.this.type == 2) {
                            int lineCount = layout.getLineCount();
                            int lineEnd2 = layout.getLineEnd(0);
                            int lineEnd3 = layout.getLineEnd(lineCount - 1) - layout.getLineStart(lineCount - 1);
                            SpannableString spannableString2 = new SpannableString("收起");
                            spannableString2.setSpan(ExpandableTextView.this.odJ, 0, spannableString2.length(), 17);
                            if (lineEnd2 - lineEnd3 > "收起".length()) {
                                ExpandableTextView.this.mkY.append((CharSequence) spannableString2);
                            } else {
                                int i2 = (lineEnd2 - lineEnd3) + 1;
                                for (int i22 = 0; i22 < i2; i22++) {
                                    ExpandableTextView.this.mkY.append((CharSequence) "  ");
                                }
                                ExpandableTextView.this.mkY.append((CharSequence) spannableString2);
                            }
                            ((i) ExpandableTextView.this.mla).Lf(R.color.transparent);
                            ExpandableTextView.this.odC.setOnTouchListener(ExpandableTextView.this.mla);
                            ExpandableTextView.this.odC.setText(ExpandableTextView.this.mkY);
                            ExpandableTextView.this.mkR.setVisibility(8);
                            return;
                        }
                        int lineCount2 = layout.getLineCount();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ExpandableTextView.this.mkR.getLayoutParams();
                        if (layout.getLineWidth(lineCount2 - 1) + ExpandableTextView.this.mkR.getWidth() > layout.getWidth()) {
                            layoutParams.addRule(3, R.id.expandable_view_title);
                            layoutParams.addRule(8, 0);
                        } else {
                            layoutParams.addRule(8, R.id.expandable_view_title);
                            layoutParams.addRule(3, 0);
                        }
                        ExpandableTextView.this.mkR.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        this.mlc = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.2
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dWy();
            }
        };
        this.odJ = new f(2, null) { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.3
            @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
            public void onClick(View view) {
                ExpandableTextView.this.dWz();
            }
        };
        this.odK = new View.OnClickListener() { // from class: com.baidu.tieba.view.expandable.ExpandableTextView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExpandableTextView.this.dWz();
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_expandable_text_view, this);
        this.odC = (SpannableClickTextView) findViewById(R.id.expandable_view_title);
        this.odC.setTextSize(0, TbConfig.getContentSize());
        this.odC.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.mkR = (TextView) findViewById(R.id.expandable_view_title_up);
        this.mkR.setOnClickListener(this.odK);
        this.textSize = l.getDimens(context, R.dimen.tbfontsize42);
        this.textColor = R.color.CAM_X0101;
        this.odF = l.getDimens(context, R.dimen.tbds6);
    }

    public void setTextSize(int i) {
        this.textSize = i;
        this.odC.setTextSize(0, i);
        this.mkR.setTextSize(0, i);
    }

    public void setHasDown() {
        c.br(this.odC).oj(R.array.S_O_X001);
    }

    public void setTextColor(int i) {
        this.textColor = i;
        ap.setViewTextColor(this.odC, this.textColor, 1);
    }

    public void setLineSpacingExtra(int i) {
        this.odF = i;
        this.odC.setLineSpacing(i, 1.0f);
        this.mkR.setLineSpacing(i, 1.0f);
    }

    public void setTextMaxLine(int i) {
        this.odE = i;
    }

    public void setExpandable(boolean z) {
        this.odA = z;
        if (!z) {
            if (Build.VERSION.SDK_INT < 16) {
                this.odC.getViewTreeObserver().removeGlobalOnLayoutListener(this.odI);
            } else {
                this.odC.getViewTreeObserver().removeOnGlobalLayoutListener(this.odI);
            }
            this.odC.setMaxLines(this.odE);
            this.odC.setEllipsize(TextUtils.TruncateAt.END);
            this.odC.setText(this.mkY);
            this.odC.setOnTouchListener(null);
            this.mkR.setVisibility(8);
            return;
        }
        this.odC.getViewTreeObserver().addOnGlobalLayoutListener(this.odI);
        this.odC.setMaxLines(Integer.MAX_VALUE);
        this.odC.setEllipsize(null);
    }

    public void setExpandType(int i) {
        this.type = i;
    }

    public void setTitleUpViewPadding(int i, int i2, int i3, int i4) {
        this.mkR.setPadding(i, i2, i3, i4);
    }

    public void setData(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.odH = z;
        this.mkY = new SpannableStringBuilder(charSequence);
        this.mla = new i(this.mkY);
        this.odC.setText(this.mkY);
        this.odC.setLinkTextColor(ap.getColor(R.color.CAM_X0304));
        this.odC.setOnTouchListener(this.mla);
        ap.setViewTextColor(this.odC, this.textColor, 1);
    }

    public TextView getContentView() {
        return this.odC;
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.odC, this.textColor, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWy() {
        this.odB = true;
        if (this.odG != null) {
            this.odG.rJ(this.odB);
        }
        this.odC.setOnTouchListener(this.mla);
        this.odC.setText(this.mkY);
        if (this.type == 1) {
            this.mkR.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWz() {
        this.odB = false;
        if (this.odG != null) {
            this.odG.rJ(this.odB);
        }
        this.odC.setOnTouchListener(this.mlb);
        this.odC.setText(this.mkZ);
        this.mkR.setVisibility(8);
    }

    public void setOnStatusChangedListener(a aVar) {
        this.odG = aVar;
    }
}
