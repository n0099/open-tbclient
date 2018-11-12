package com.baidu.tieba.pb.video.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.text.style.ReplacementSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class a {
    private static final int dYX = l.h(TbadkCoreApplication.getInst(), e.C0200e.tbds33);

    public static void a(Context context, TextView textView, String str, final String str2, final String str3) {
        int h;
        if (context != null && textView != null && !StringUtils.isNull(str)) {
            int color = al.getColor(e.d.cp_cont_j);
            String str4 = str + "  ";
            TextPaint paint = textView.getPaint();
            int h2 = l.aS(context)[0] - (l.h(context, e.C0200e.tbds48) * 2);
            int h3 = l.h(context, e.C0200e.tbds116);
            int c = l.c(paint, " 广告");
            int c2 = l.c(paint, "...  ");
            int c3 = l.c(paint, str4);
            int h4 = c3 + h3 + c + l.h(context, e.C0200e.tbds30);
            if (h4 >= h2 * 2) {
                str4 = a(paint, str4, ((((h2 * 2) - h3) - c) - c2) - h) + "...  ";
            } else if (h4 >= h2 && c3 < h2 && h4 >= h2) {
                str4 = str4.trim() + "\n";
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str4);
            SpannableString spannableString = new SpannableString(BaseRequestAction.SPLITE);
            Drawable drawable = al.getDrawable(e.f.icon_video_pb_ad_link);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            spannableString.setSpan(new C0280a(drawable, 0), 0, 1, 17);
            spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.tieba.pb.video.a.a.1
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    if (!StringUtils.isNull(str2)) {
                        am amVar = new am("c13313");
                        amVar.ax("tid", str3);
                        TiebaStatic.log(amVar);
                        com.baidu.tbadk.browser.a.b(TbadkCoreApplication.getInst().getApplicationContext(), false, str2);
                    }
                }
            }, 0, 1, 17);
            spannableString.setSpan(new BackgroundColorSpan(0), 0, 1, 17);
            SpannableString spannableString2 = new SpannableString(" 广告");
            spannableString2.setSpan(new b(dYX, color), 0, " 广告".length(), 17);
            spannableStringBuilder.append((CharSequence) spannableString).append((CharSequence) spannableString2);
            textView.setHighlightColor(0);
            textView.setText(spannableStringBuilder);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            am amVar = new am("c13312");
            amVar.ax("tid", str3);
            TiebaStatic.log(amVar);
        }
    }

    public static String a(Paint paint, String str, int i) {
        String str2 = str;
        for (int length = str.length() - 1; l.c(paint, str2) > i && length > 0; length--) {
            str2 = str.substring(0, length);
        }
        return str2;
    }

    /* loaded from: classes6.dex */
    private static class b extends ReplacementSpan {
        private int dZa;
        private int dZb;

        public b(int i, int i2) {
            this.dZa = i;
            this.dZb = i2;
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            return (int) a(paint).measureText(charSequence.subSequence(i, i2).toString());
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            CharSequence subSequence = charSequence.subSequence(i, i2);
            TextPaint a = a(paint);
            Paint.FontMetricsInt fontMetricsInt = a.getFontMetricsInt();
            canvas.drawText(subSequence.toString(), f, i4 - (((fontMetricsInt.ascent + ((fontMetricsInt.descent + i4) + i4)) / 2) - ((i5 + i3) / 2)), a);
        }

        private TextPaint a(Paint paint) {
            TextPaint textPaint = new TextPaint(paint);
            textPaint.setTextSize(this.dZa);
            textPaint.setColor(this.dZb);
            return textPaint;
        }
    }

    /* renamed from: com.baidu.tieba.pb.video.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private static class C0280a extends ImageSpan {
        public C0280a(Drawable drawable, int i) {
            super(drawable, i);
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            Rect bounds = getDrawable().getBounds();
            if (fontMetricsInt != null) {
                Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
                int i3 = fontMetricsInt2.bottom - fontMetricsInt2.top;
                int i4 = bounds.bottom - bounds.top;
                int i5 = (i4 / 2) - (i3 / 4);
                int i6 = (i3 / 4) + (i4 / 2);
                fontMetricsInt.ascent = -i6;
                fontMetricsInt.top = -i6;
                fontMetricsInt.bottom = i5;
                fontMetricsInt.descent = i5;
            }
            return bounds.right;
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            Drawable drawable = getDrawable();
            canvas.save();
            canvas.translate(f, (((i5 - i3) - drawable.getBounds().bottom) / 2) + i3);
            drawable.draw(canvas);
            canvas.restore();
        }
    }
}
