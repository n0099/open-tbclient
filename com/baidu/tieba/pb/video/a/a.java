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
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a {
    private static final int jNT = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds33);

    public static void a(Context context, TextView textView, String str, final String str2, final String str3) {
        int dimens;
        if (context != null && textView != null && !StringUtils.isNull(str)) {
            int color = ap.getColor(R.color.CAM_X0107);
            String str4 = str + "  ";
            TextPaint paint = textView.getPaint();
            int dimens2 = l.getScreenDimensions(context)[0] - (l.getDimens(context, R.dimen.tbds48) * 2);
            int dimens3 = l.getDimens(context, R.dimen.tbds116);
            int textWidth = l.getTextWidth(paint, " 广告");
            int textWidth2 = l.getTextWidth(paint, "...  ");
            int textWidth3 = l.getTextWidth(paint, str4);
            int dimens4 = textWidth3 + dimens3 + textWidth + l.getDimens(context, R.dimen.tbds30);
            if (dimens4 >= dimens2 * 2) {
                str4 = a(paint, str4, ((((dimens2 * 2) - dimens3) - textWidth) - textWidth2) - dimens) + "...  ";
            } else if (dimens4 >= dimens2 && textWidth3 < dimens2 && dimens4 >= dimens2) {
                str4 = str4.trim() + "\n";
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str4);
            SpannableString spannableString = new SpannableString(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            Drawable drawable = ap.getDrawable(R.drawable.icon_video_pb_ad_link);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            spannableString.setSpan(new C0842a(drawable, 0), 0, 1, 17);
            spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.tieba.pb.video.a.a.1
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    if (!StringUtils.isNull(str2)) {
                        ar arVar = new ar("c13313");
                        arVar.dR("tid", str3);
                        TiebaStatic.log(arVar);
                        com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str2);
                    }
                }
            }, 0, 1, 17);
            spannableString.setSpan(new BackgroundColorSpan(0), 0, 1, 17);
            SpannableString spannableString2 = new SpannableString(" 广告");
            spannableString2.setSpan(new b(jNT, color), 0, " 广告".length(), 17);
            spannableStringBuilder.append((CharSequence) spannableString).append((CharSequence) spannableString2);
            textView.setHighlightColor(0);
            textView.setText(spannableStringBuilder);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            ar arVar = new ar("c13312");
            arVar.dR("tid", str3);
            TiebaStatic.log(arVar);
        }
    }

    public static String a(Paint paint, String str, int i) {
        String str2 = str;
        for (int length = str.length() - 1; l.getTextWidth(paint, str2) > i && length > 0; length--) {
            str2 = str.substring(0, length);
        }
        return str2;
    }

    /* loaded from: classes2.dex */
    private static class b extends ReplacementSpan {
        private int jNV;
        private int jNW;

        public b(int i, int i2) {
            this.jNV = i;
            this.jNW = i2;
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            return (int) c(paint).measureText(charSequence.subSequence(i, i2).toString());
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            CharSequence subSequence = charSequence.subSequence(i, i2);
            TextPaint c = c(paint);
            Paint.FontMetricsInt fontMetricsInt = c.getFontMetricsInt();
            canvas.drawText(subSequence.toString(), f, i4 - (((fontMetricsInt.ascent + ((fontMetricsInt.descent + i4) + i4)) / 2) - ((i5 + i3) / 2)), c);
        }

        private TextPaint c(Paint paint) {
            TextPaint textPaint = new TextPaint(paint);
            textPaint.setTextSize(this.jNV);
            textPaint.setColor(this.jNW);
            return textPaint;
        }
    }

    /* renamed from: com.baidu.tieba.pb.video.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0842a extends ImageSpan {
        public C0842a(Drawable drawable, int i) {
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
