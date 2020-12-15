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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class TextSizeSeekBar extends View {
    private int ds12;
    private int ds3;
    private int ds58;
    private int index;
    private Drawable kgD;
    private int lineColor;
    private int mSkinType;
    private ArrayList<Rect> mfA;
    private int mfr;
    private int mfs;
    private int mft;
    private int mfu;
    private int mfv;
    private int mfw;
    private String[] mfx;
    private int mfy;
    private int mfz;
    private Paint paint;
    private int textSize;

    public TextSizeSeekBar(Context context) {
        super(context);
        this.index = 1;
        this.mfA = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds58 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.index = 1;
        this.mfA = new ArrayList<>(4);
        this.ds3 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds3);
        this.ds12 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ds58 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds58);
        init(context);
    }

    public TextSizeSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.index = 1;
        this.mfA = new ArrayList<>(4);
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
        this.kgD = ap.getDrawable(R.drawable.pic_wordsize_n);
        this.mfu = dimensionPixelSize;
        this.mfv = dimensionPixelSize;
        this.textSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.T_X09);
        this.mfx = new String[]{context.getString(R.string.font_size_small), context.getString(R.string.font_size_mid), context.getString(R.string.font_size_big), context.getString(R.string.font_size_xlarge)};
        this.mfy = ap.getColor(R.color.CAM_X0105);
        this.mfz = ap.getColor(R.color.CAM_X0109);
        this.lineColor = ap.getColor(R.color.CAM_X0111);
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.kgD = ap.getDrawable(R.drawable.pic_wordsize_n);
        this.index = Math.abs(TbadkCoreApplication.getInst().getFontSize() - 3);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mfr == 0 || this.mfs == 0) {
            this.mfr = View.MeasureSpec.getSize(i);
            this.mfs = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds176);
            this.mft = (this.mfr - this.mfu) / 3;
            this.mfw = this.mfs / 2;
            for (int i3 = 0; i3 < 4; i3++) {
                this.mfA.add(new Rect(this.mft * i3, this.mfw - (this.mfv / 2), (this.mft * i3) + this.mfu, this.mfw + (this.mfv / 2)));
            }
        }
        setMeasuredDimension(this.mfr, this.mfs);
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
                        if (!this.mfA.get(i2).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            i = i2 + 1;
                        } else {
                            this.index = i2;
                            com.baidu.tieba.pb.a.b.GS(Math.abs(this.index - 3));
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
        C(canvas);
        o(canvas);
        ah(canvas);
    }

    private void C(Canvas canvas) {
        for (int i = 0; i < this.mfx.length; i++) {
            if (i == this.index) {
                this.paint.setColor(this.mfy);
            } else {
                this.paint.setColor(this.mfz);
            }
            this.paint.setTextSize(this.textSize);
            this.paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.mfx[i], (this.mft * i) + (this.mfu / 2), this.mfw - this.ds58, this.paint);
        }
    }

    private void o(Canvas canvas) {
        this.paint.setColor(this.lineColor);
        this.paint.setStrokeWidth(this.ds3);
        canvas.drawLine((float) (this.mfu / 2.0d), this.mfw, (float) (this.mfr - (this.mfu / 2.0d)), this.mfw, this.paint);
        this.paint.setStrokeWidth(this.ds12);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < 4; i++) {
            canvas.drawPoint((this.mft * i) + (this.mfu / 2), this.mfw, this.paint);
        }
    }

    private void ah(Canvas canvas) {
        Rect rect = (Rect) y.getItem(this.mfA, this.index);
        if (rect != null && this.kgD != null) {
            this.kgD.setBounds(rect.left, rect.top, rect.right, rect.bottom);
            this.kgD.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.kgD != null) {
            this.kgD.setCallback(null);
            this.kgD = null;
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.kgD != null) {
                this.kgD = ap.getDrawable(R.drawable.pic_wordsize_n);
            }
            this.mfy = ap.getColor(R.color.CAM_X0105);
            this.mfz = ap.getColor(R.color.CAM_X0109);
            this.lineColor = ap.getColor(R.color.CAM_X0111);
            invalidate();
        }
    }
}
