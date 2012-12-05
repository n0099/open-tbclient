package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.data.ThreadWaterData;
import com.baidu.tieba.util.BitmapHelper;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class FrsWaterFallItem extends LinearLayout {
    private int mIconX;
    private String mName;
    private int mNameSize;
    private String mNum;
    private int mNumX;
    private int mPadding;
    private TextPaint mTextPaint;
    private String mTitle;
    private int mTitleSize;

    public FrsWaterFallItem(Context context) {
        super(context);
        this.mTextPaint = null;
        this.mTitle = null;
        this.mName = null;
        this.mNum = null;
        this.mNumX = -1;
        this.mIconX = -1;
        this.mTitleSize = 0;
        this.mNameSize = 0;
        this.mPadding = 0;
        init();
    }

    public FrsWaterFallItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mTextPaint = null;
        this.mTitle = null;
        this.mName = null;
        this.mNum = null;
        this.mNumX = -1;
        this.mIconX = -1;
        this.mTitleSize = 0;
        this.mNameSize = 0;
        this.mPadding = 0;
        init();
    }

    public void setSize(int title_size, int name_size, int padding) {
        this.mTitleSize = title_size;
        this.mNameSize = name_size;
        this.mPadding = padding;
    }

    private void init() {
        this.mTextPaint = new TextPaint(1);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            ThreadWaterData data = (ThreadWaterData) getTag();
            int pos_y = (getHeight() - getPaddingBottom()) - this.mNameSize;
            int pos_x = getWidth() - getPaddingRight();
            this.mTextPaint.setTextSize(this.mNameSize);
            this.mTextPaint.setColor(-6908266);
            Paint.FontMetrics fm = this.mTextPaint.getFontMetrics();
            int offset = (int) Math.ceil(fm.ascent);
            if (data.getReplyNum() > 0) {
                if (this.mNum == null) {
                    if (data.getReplyNum() > 999) {
                        this.mNum = "999+";
                    } else {
                        this.mNum = String.valueOf(data.getReplyNum());
                    }
                }
                if (this.mNumX == -1) {
                    int w = (int) Math.ceil(UtilHelper.measureTextWidth(this.mTextPaint, this.mNum));
                    this.mNumX = pos_x - w;
                }
                canvas.drawText(this.mNum, this.mNumX, pos_y - offset, this.mTextPaint);
                pos_x = this.mNumX - UtilHelper.dip2px(getContext(), 2.0f);
            }
            if (this.mNumX != -1) {
                Bitmap bm = BitmapHelper.getCashBitmap(R.drawable.icon_reply);
                this.mIconX = this.mNumX - bm.getWidth();
                pos_x = this.mIconX - this.mPadding;
                canvas.drawBitmap(bm, this.mIconX, ((this.mNameSize - bm.getHeight()) / 2) + pos_y, (Paint) null);
            }
            if (this.mName == null) {
                this.mName = UtilHelper.getTextOmit(this.mTextPaint, data.getName(), pos_x - getPaddingLeft());
            }
            canvas.drawText(data.getName(), getPaddingLeft(), pos_y - offset, this.mTextPaint);
            this.mTextPaint.setTextSize(this.mTitleSize);
            this.mTextPaint.setColor(-13421773);
            this.mTextPaint.getFontMetrics();
            if (this.mTitle == null) {
                this.mTitle = UtilHelper.getTextOmit(this.mTextPaint, data.getTitle(), (getWidth() - getPaddingLeft()) - getPaddingRight());
            }
            canvas.drawText(this.mTitle, getPaddingLeft(), (pos_y - (this.mPadding + this.mTitleSize)) - offset, this.mTextPaint);
        } catch (Exception e) {
        }
    }
}
