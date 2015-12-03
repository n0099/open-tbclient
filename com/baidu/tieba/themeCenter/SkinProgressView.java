package com.baidu.tieba.themeCenter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
import com.baidu.tieba.themeCenter.background.BackgroundSetRequestMessage;
/* loaded from: classes.dex */
public class SkinProgressView extends View {
    private String ZR;
    private Paint aqx;
    private int aqy;
    private Paint dDV;
    private int dDW;
    private float dDX;
    private float dDY;
    private boolean dDZ;
    private boolean dEa;
    private CustomMessageListener dEb;
    private float height;
    private Context mContext;
    private int mFontSize;
    private Paint mPaint;
    private b mSkinData;
    private int mTextColor;
    private int radius;
    private float width;

    public SkinProgressView(Context context) {
        super(context);
        this.dDZ = false;
        this.dEa = false;
        this.dEb = new h(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
        this.mContext = context;
        initView();
    }

    public SkinProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dDZ = false;
        this.dEa = false;
        this.dEb = new h(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
        this.mContext = context;
        initView();
    }

    public SkinProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dDZ = false;
        this.dEa = false;
        this.dEb = new h(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.radius = com.baidu.adp.lib.util.k.d(this.mContext, n.d.ds6);
        this.mFontSize = com.baidu.adp.lib.util.k.d(this.mContext, n.d.fontsize24);
        this.dDW = n.c.cp_link_tip_a;
        this.mTextColor = n.c.cp_cont_c;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.aqx = new Paint();
        this.aqx.setAntiAlias(true);
        this.dDV = new Paint();
        this.dDV.setAntiAlias(true);
        this.dDV.setTextSize(this.mFontSize);
        this.dDV.setTextAlign(Paint.Align.CENTER);
        MessageManager.getInstance().registerListener(this.dEb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFk() {
        if (this.mSkinData.aFf() != 4 && this.mSkinData.aFf() != 0) {
            if (this.mSkinData.aFh()) {
                TbadkCoreApplication.m411getInst().setUsedTheme(this.mSkinData.getId(), this.mSkinData.aFe());
                e(0, 0.0f);
                this.mSkinData.mP(0);
                BackgroundSetRequestMessage backgroundSetRequestMessage = new BackgroundSetRequestMessage();
                backgroundSetRequestMessage.setPropId(this.mSkinData.getId());
                MessageManager.getInstance().sendMessage(backgroundSetRequestMessage);
            } else {
                e(4, 0.0f);
                this.mSkinData.mP(4);
            }
            if (this.mSkinData.getNewVersionCode() > 0) {
                this.mSkinData.setVersionCode(this.mSkinData.getNewVersionCode());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_INSERT_SKINT_DATA_TO_DB, this.mSkinData));
        }
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
        if (this.dDZ) {
            RectF rectF = new RectF(0.0f, 0.0f, this.width, this.height);
            this.aqx.setColor(as.getColor(this.aqy));
            canvas.drawRoundRect(rectF, this.radius, this.radius, this.aqx);
        }
        RectF rectF2 = new RectF(0.0f, 0.0f, this.width * this.dDX, this.height);
        this.mPaint.setColor(as.getColor(this.dDW));
        canvas.drawRoundRect(rectF2, this.radius, this.radius, this.mPaint);
        if (!StringUtils.isNull(this.ZR)) {
            this.dDV.setColor(as.getColor(this.mTextColor));
            this.dDV.setTextSize(this.mFontSize);
            this.dDY = this.dDV.getFontMetrics().bottom - this.dDV.getFontMetrics().top;
            canvas.drawText(this.ZR, this.width / 2.0f, (this.height - ((this.height - this.dDY) / 2.0f)) - this.dDV.getFontMetrics().bottom, this.dDV);
        }
    }

    public void e(int i, float f) {
        int i2;
        int i3 = 0;
        if (this.dEa) {
            if (this.mSkinData != null) {
                i2 = this.mSkinData.aFe();
                i3 = this.mSkinData.getActivityFinish();
            } else {
                i2 = 0;
            }
            b(i, f, i2, i3);
            return;
        }
        setEnabled(true);
        switch (i) {
            case 0:
                setText(n.i.theme_in_use);
                setTextColor(n.c.cp_cont_c);
                setEnabled(false);
                break;
            case 1:
                setText(n.i.theme_download);
                setTextColor(n.c.cp_cont_b);
                break;
            case 2:
                setText(n.i.theme_cancel_download);
                if (f > 0.5d) {
                    setTextColor(n.c.cp_cont_i);
                    break;
                } else {
                    setTextColor(n.c.cp_cont_b);
                    break;
                }
            case 3:
                setText(n.i.theme_download);
                setTextColor(n.c.cp_cont_b);
                break;
            case 4:
                setText(n.i.theme_use);
                setTextColor(n.c.cp_cont_b);
                break;
            case 5:
                setText(n.i.theme_need_update);
                setTextColor(n.c.cp_cont_b);
                break;
            case 6:
                setText(n.i.theme_activity);
                setTextColor(n.c.cp_cont_b);
                break;
        }
        if (this.mSkinData != null && this.mSkinData.XG() == 7) {
            setEnabled(false);
        }
        setProgress(f);
        invalidate();
    }

    public void b(int i, float f, int i2, int i3) {
        this.dDZ = false;
        setEnabled(true);
        switch (i) {
            case 0:
                setText(n.i.theme_in_use);
                setTextColor(n.c.cp_cont_c);
                setEnabled(false);
                break;
            case 1:
                if (i2 == 0) {
                    setText(n.i.download_free);
                    setTextColor(n.c.cp_cont_b);
                    break;
                } else {
                    setTextColor(n.c.cp_cont_i);
                    setBgColor(n.c.cp_other_f);
                    this.dDZ = true;
                    if (i2 == 100) {
                        if (i3 == 0) {
                            setText(n.i.btn_activity_skin_free);
                            setBgColor(n.c.cp_link_tip_a);
                            break;
                        } else {
                            setText(n.i.theme_download);
                            setBgColor(n.c.cp_link_tip_a);
                            break;
                        }
                    } else if (i2 == 101) {
                        setText(n.i.btn_annual_download_free);
                        break;
                    } else if (i2 <= 1) {
                        setText(n.i.become_member_download_free);
                        break;
                    } else {
                        setText(String.format(this.mContext.getString(n.i.btn_vip_can_download_free), Integer.valueOf(i2)));
                        break;
                    }
                }
            case 2:
                setText(n.i.theme_cancel_download);
                if (f > 0.5d) {
                    setTextColor(n.c.cp_cont_i);
                    break;
                } else {
                    setTextColor(n.c.cp_cont_b);
                    break;
                }
            case 3:
                if (i2 == 0) {
                    setText(n.i.download_free);
                    setTextColor(n.c.cp_cont_b);
                    break;
                } else {
                    setText(n.i.become_member_download_free);
                    setTextColor(n.c.cp_cont_i);
                    setBgColor(n.c.cp_other_f);
                    this.dDZ = true;
                    break;
                }
            case 4:
                setText(n.i.use_immediately);
                setTextColor(n.c.cp_cont_b);
                break;
            case 5:
                setText(n.i.theme_need_update);
                setTextColor(n.c.cp_cont_b);
                break;
            case 6:
                setText(n.i.activity_free_use);
                setTextColor(n.c.cp_cont_b);
                setBgColor(n.c.cp_link_tip_a);
                this.dDZ = true;
                break;
            case 9:
                if (i2 == 0) {
                    setText(n.i.use_freely);
                    setTextColor(n.c.cp_cont_b);
                } else {
                    setTextColor(n.c.cp_cont_i);
                    setBgColor(n.c.cp_other_f);
                    this.dDZ = true;
                    if (i2 == 100) {
                        if (i3 == 0) {
                            setText(n.i.activity_free_use);
                            setBgColor(n.c.cp_link_tip_a);
                        } else {
                            setText(n.i.use_immediately);
                            setBgColor(n.c.cp_link_tip_a);
                        }
                    } else if (i2 == 101) {
                        setText(n.i.become_annual_free_use);
                    } else if (i2 > 1) {
                        setText(String.format(this.mContext.getString(n.i.become_vip_free_use), Integer.valueOf(i2)));
                    } else {
                        setText(n.i.become_member_free_use);
                    }
                }
                setEnabled(true);
                break;
        }
        setProgress(f);
        invalidate();
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.dEb != null) {
            this.dEb.setTag(bdUniqueId);
        }
    }

    public void setSkinData(b bVar) {
        this.mSkinData = bVar;
    }

    public b getSkinData() {
        return this.mSkinData;
    }

    public void setProgress(float f) {
        this.dDX = f;
    }

    public int getDrawColor() {
        return this.dDW;
    }

    public void setDrawColor(int i) {
        this.dDW = i;
    }

    public void setText(int i) {
        this.ZR = this.mContext.getResources().getString(i);
    }

    public void setText(String str) {
        this.ZR = str;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public int getBgColor() {
        return this.aqy;
    }

    public void setBgColor(int i) {
        this.aqy = i;
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int i) {
        this.radius = i;
    }

    public int getFontSize() {
        return this.mFontSize;
    }

    public void setFontSize(int i) {
        this.mFontSize = i;
    }

    public void setNeedBg(boolean z) {
        this.dDZ = z;
    }

    public void setSkinDetailPage(boolean z) {
        this.dEa = z;
    }
}
