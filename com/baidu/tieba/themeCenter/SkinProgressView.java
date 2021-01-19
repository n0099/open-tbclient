package com.baidu.tieba.themeCenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.DressItemData;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class SkinProgressView extends View {
    private Paint bew;
    private float height;
    private int mBgColor;
    private Context mContext;
    private int mFontSize;
    private Paint mPaint;
    private String mText;
    private int mTextColor;
    private Paint nvI;
    private int nvJ;
    private float nvK;
    private boolean nvL;
    private DressItemData nvM;
    private float progress;
    private int radius;
    private float width;

    public SkinProgressView(Context context) {
        super(context);
        this.nvL = false;
        this.mContext = context;
        initView();
    }

    public SkinProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nvL = false;
        this.mContext = context;
        initView();
    }

    public SkinProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nvL = false;
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.radius = l.getDimens(this.mContext, R.dimen.ds6);
        this.mFontSize = l.getDimens(this.mContext, R.dimen.fontsize24);
        this.nvJ = R.color.CAM_X0302;
        this.mTextColor = R.color.CAM_X0108;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.bew = new Paint();
        this.bew.setAntiAlias(true);
        this.nvI = new Paint();
        this.nvI.setAntiAlias(true);
        this.nvI.setTextSize(this.mFontSize);
        this.nvI.setTextAlign(Paint.Align.CENTER);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.width = View.MeasureSpec.getSize(i);
        this.height = View.MeasureSpec.getSize(i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.nvL) {
            RectF rectF = new RectF(0.0f, 0.0f, this.width, this.height);
            this.bew.setColor(ao.getColor(this.mBgColor));
            canvas.drawRoundRect(rectF, this.radius, this.radius, this.bew);
        }
        RectF rectF2 = new RectF(0.0f, 0.0f, this.width * this.progress, this.height);
        this.mPaint.setColor(ao.getColor(this.nvJ));
        canvas.drawRoundRect(rectF2, this.radius, this.radius, this.mPaint);
        if (!StringUtils.isNull(this.mText)) {
            this.nvI.setColor(ao.getColor(this.mTextColor));
            this.nvI.setTextSize(this.mFontSize);
            this.nvK = this.nvI.getFontMetrics().bottom - this.nvI.getFontMetrics().top;
            canvas.drawText(this.mText, this.width / 2.0f, (this.height - ((this.height - this.nvK) / 2.0f)) - this.nvI.getFontMetrics().bottom, this.nvI);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void n(int i, float f) {
        setEnabled(true);
        switch (i) {
            case 0:
                setText(R.string.theme_in_use);
                setTextColor(R.color.CAM_X0105);
                setEnabled(false);
                break;
            case 1:
                setText(R.string.download);
                setTextColor(R.color.CAM_X0105);
                break;
            case 2:
                setText(R.string.cancel);
                if (f > 0.5d) {
                    setTextColor(R.color.CAM_X0101);
                    break;
                } else {
                    setTextColor(R.color.CAM_X0105);
                    break;
                }
            case 3:
                setText(R.string.download);
                setTextColor(R.color.CAM_X0105);
                break;
            case 4:
                setText(R.string.theme_use);
                setTextColor(R.color.CAM_X0105);
                break;
            case 5:
                setText(R.string.theme_need_update);
                setTextColor(R.color.CAM_X0105);
                break;
            case 6:
                setText(R.string.card_promotion_text);
                setTextColor(R.color.CAM_X0105);
                break;
        }
        setProgress(f);
        invalidate();
    }

    @SuppressLint({"ResourceAsColor"})
    public void b(int i, float f, int i2, int i3, int i4) {
        this.nvL = false;
        setEnabled(true);
        switch (i) {
            case 0:
                if (i4 == 1) {
                    setText(R.string.back_to_home);
                } else if (i4 == 2) {
                    setText(R.string.back_to_person);
                } else {
                    setText(R.string.theme_in_use);
                    setEnabled(false);
                }
                setTextColor(R.color.CAM_X0105);
                break;
            case 1:
                if (i2 == 0) {
                    setText(R.string.download_free);
                    setTextColor(R.color.CAM_X0105);
                    break;
                } else {
                    setTextColor(R.color.CAM_X0101);
                    setBgColor(R.color.CAM_X0312);
                    this.nvL = true;
                    if (i2 == 100) {
                        if (i3 == 0) {
                            setText(R.string.btn_activity_skin_free);
                            setBgColor(R.color.CAM_X0302);
                            break;
                        } else {
                            setText(R.string.download);
                            setBgColor(R.color.CAM_X0302);
                            break;
                        }
                    } else if (i2 == 101) {
                        setText(R.string.btn_annual_download_free);
                        break;
                    } else if (i2 <= 1) {
                        setText(R.string.become_member_download_free);
                        break;
                    } else {
                        setText(String.format(this.mContext.getString(R.string.btn_vip_can_download_free), Integer.valueOf(i2)));
                        break;
                    }
                }
            case 2:
                setText(R.string.cancel);
                if (f > 0.5d) {
                    setTextColor(R.color.CAM_X0101);
                    break;
                } else {
                    setTextColor(R.color.CAM_X0105);
                    break;
                }
            case 3:
                if (i2 == 0) {
                    setText(R.string.download_free);
                    setTextColor(R.color.CAM_X0105);
                    break;
                } else {
                    setText(R.string.become_member_download_free);
                    setTextColor(R.color.CAM_X0101);
                    setBgColor(R.color.CAM_X0312);
                    this.nvL = true;
                    break;
                }
            case 4:
                setText(R.string.use_immediately);
                setTextColor(R.color.CAM_X0105);
                break;
            case 5:
                setText(R.string.theme_need_update);
                setTextColor(R.color.CAM_X0105);
                break;
            case 6:
                setText(R.string.activity_free_use);
                setTextColor(R.color.CAM_X0105);
                setBgColor(R.color.CAM_X0302);
                this.nvL = true;
                break;
            case 9:
                if (i4 == 2 && this.nvM.getDailyPrevilegeStatus() == 1) {
                    setText(R.string.use_immediately);
                    setTextColor(R.color.CAM_X0105);
                } else if (i2 == 0) {
                    setText(R.string.use_freely);
                    setTextColor(R.color.CAM_X0105);
                } else {
                    setTextColor(R.color.CAM_X0101);
                    setBgColor(R.color.CAM_X0312);
                    this.nvL = true;
                    if (i2 == 100) {
                        if (i3 == 0) {
                            setText(R.string.activity_free_use);
                            setBgColor(R.color.CAM_X0302);
                        } else {
                            setText(R.string.use_immediately);
                            setBgColor(R.color.CAM_X0302);
                        }
                    } else if (i2 == 101) {
                        setText(R.string.become_annual_free_use);
                    } else if (i2 > 1) {
                        setText(String.format(this.mContext.getString(R.string.become_vip_free_use), Integer.valueOf(i2)));
                    } else {
                        setText(R.string.become_member_free_use);
                    }
                }
                setEnabled(true);
                break;
        }
        setProgress(f);
        invalidate();
    }

    public void setDressData(DressItemData dressItemData) {
        this.nvM = dressItemData;
    }

    public void setProgress(float f) {
        this.progress = f;
    }

    public void setText(int i) {
        this.mText = this.mContext.getResources().getString(i);
    }

    public void setText(String str) {
        this.mText = str;
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void setBgColor(int i) {
        this.mBgColor = i;
    }

    public void setFontSize(int i) {
        this.mFontSize = i;
    }
}
