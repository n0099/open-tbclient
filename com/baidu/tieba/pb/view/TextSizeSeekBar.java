package com.baidu.tieba.pb.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class TextSizeSeekBar extends View {
    private int ds12;
    private int ds3;
    private int ds58;
    private int index;
    private Drawable kpk;
    private int lineColor;
    private int mSkinType;
    private int mfX;
    private int mfY;
    private int mfZ;
    private int mga;
    private int mgb;
    private int mgc;
    private String[] mgd;
    private int mge;
    private int mgf;
    private ArrayList<Rect> mgg;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.mgg = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds58 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.mgg = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds58 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.mgg = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds58 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
        init(context);
    }

    private void init(Context context) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds102);
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.kpk = ao.getDrawable(R.drawable.pic_wordsize_n);
        this.mga = dimensionPixelSize;
        this.mgb = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.T_X09);
        this.mgd = new String[]{context.getString(R.string.font_size_small), context.getString(R.string.font_size_mid), context.getString(R.string.font_size_big), context.getString(R.string.font_size_xlarge)};
        this.mge = ao.getColor(R.color.CAM_X0105);
        this.mgf = ao.getColor(R.color.CAM_X0109);
        this.lineColor = ao.getColor(R.color.CAM_X0111);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.kpk = ao.getDrawable(R.drawable.pic_wordsize_n);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mfX == 0 || this.mfY == 0) {
            this.mfX = View.MeasureSpec.getSize(i);
            this.mfY = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds176);
            this.mfZ = (this.mfX - this.mga) / 3;
            this.mgc = this.mfY / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.mgg.add(new Rect(this.mfZ * i3, this.mgc - (this.mgb / 2), (this.mfZ * i3) + this.mga, this.mgc + (this.mgb / 2)));
            }
        }
        setMeasuredDimension(this.mfX, this.mfY);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            default:
                return true;
            case 1:
            case 2:
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 <= 3) {
                        if (!this.mgg.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.Fe(Math.abs(this.index - 3));
                            invalidate();
                            return true;
                        }
                    } else {
                        return true;
                    }
                }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        J(canvas);
        v(canvas);
        an(canvas);
    }

    private void J(Canvas canvas) {
        for (int i = 0; i < this.mgd.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.mge);
            } else {
                this.paint.setColor(this.mgf);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.mgd[i], (this.mfZ * i) + (this.mga / 2), this.mgc - this.ds58, this.paint);
        }
    }

    private void v(Canvas canvas) {
        this.paint.setColor(this.lineColor);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.mga / 2.0d), this.mgc, (float) (this.mfX - (this.mga / 2.0d)), this.mgc, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.mfZ * i) + (this.mga / 2), this.mgc, this.paint);
        }
    }

    private void an(Canvas canvas) {
        Rect rect = (Rect) x.getItem(this.mgg, this.index);
        if (rect != null && this.kpk != null) {
            this.kpk.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.kpk.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.kpk != null) {
            this.kpk.setCallback(null);
            this.kpk = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.kpk != null) {
                this.kpk = ao.getDrawable(R.drawable.pic_wordsize_n);
            }
            this.mge = ao.getColor(R.color.CAM_X0105);
            this.mgf = ao.getColor(R.color.CAM_X0109);
            this.lineColor = ao.getColor(R.color.CAM_X0111);
            invalidate();
        }
    }
}
