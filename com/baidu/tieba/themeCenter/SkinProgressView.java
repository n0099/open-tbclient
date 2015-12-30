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
    private String aav;
    private Paint asb;
    private int asc;
    private int dLA;
    private float dLB;
    private float dLC;
    private boolean dLD;
    private boolean dLE;
    private CustomMessageListener dLF;
    private Paint dLz;
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
        this.dLD = false;
        this.dLE = false;
        this.dLF = new h(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
        this.mContext = context;
        initView();
    }

    public SkinProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dLD = false;
        this.dLE = false;
        this.dLF = new h(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
        this.mContext = context;
        initView();
    }

    public SkinProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dLD = false;
        this.dLE = false;
        this.dLF = new h(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.radius = com.baidu.adp.lib.util.k.d(this.mContext, n.e.ds6);
        this.mFontSize = com.baidu.adp.lib.util.k.d(this.mContext, n.e.fontsize24);
        this.dLA = n.d.cp_link_tip_a;
        this.mTextColor = n.d.cp_cont_c;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.asb = new Paint();
        this.asb.setAntiAlias(true);
        this.dLz = new Paint();
        this.dLz.setAntiAlias(true);
        this.dLz.setTextSize(this.mFontSize);
        this.dLz.setTextAlign(Paint.Align.CENTER);
        MessageManager.getInstance().registerListener(this.dLF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHz() {
        if (this.mSkinData.aHu() != 4 && this.mSkinData.aHu() != 0) {
            if (this.mSkinData.aHw()) {
                TbadkCoreApplication.m411getInst().setUsedTheme(this.mSkinData.getId(), this.mSkinData.aHt());
                e(0, 0.0f);
                this.mSkinData.nr(0);
                BackgroundSetRequestMessage backgroundSetRequestMessage = new BackgroundSetRequestMessage();
                backgroundSetRequestMessage.setPropId(this.mSkinData.getId());
                MessageManager.getInstance().sendMessage(backgroundSetRequestMessage);
            } else {
                e(4, 0.0f);
                this.mSkinData.nr(4);
            }
            if (this.mSkinData.getNewVersionCode() > 0) {
                this.mSkinData.setVersionCode(this.mSkinData.getNewVersionCode());
            }
            TbadkCoreApplication.m411getInst().deleteThemeFromWaitDownloadQuene(this.mSkinData.getId());
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
        if (this.dLD) {
            RectF rectF = new RectF(0.0f, 0.0f, this.width, this.height);
            this.asb.setColor(as.getColor(this.asc));
            canvas.drawRoundRect(rectF, this.radius, this.radius, this.asb);
        }
        RectF rectF2 = new RectF(0.0f, 0.0f, this.width * this.dLB, this.height);
        this.mPaint.setColor(as.getColor(this.dLA));
        canvas.drawRoundRect(rectF2, this.radius, this.radius, this.mPaint);
        if (!StringUtils.isNull(this.aav)) {
            this.dLz.setColor(as.getColor(this.mTextColor));
            this.dLz.setTextSize(this.mFontSize);
            this.dLC = this.dLz.getFontMetrics().bottom - this.dLz.getFontMetrics().top;
            canvas.drawText(this.aav, this.width / 2.0f, (this.height - ((this.height - this.dLC) / 2.0f)) - this.dLz.getFontMetrics().bottom, this.dLz);
        }
    }

    public void e(int i, float f) {
        int i2;
        int i3 = 0;
        if (this.dLE) {
            if (this.mSkinData != null) {
                i2 = this.mSkinData.aHt();
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
                setText(n.j.theme_in_use);
                setTextColor(n.d.cp_cont_c);
                setEnabled(false);
                break;
            case 1:
                setText(n.j.theme_download);
                setTextColor(n.d.cp_cont_b);
                break;
            case 2:
                setText(n.j.theme_cancel_download);
                if (f > 0.5d) {
                    setTextColor(n.d.cp_cont_i);
                    break;
                } else {
                    setTextColor(n.d.cp_cont_b);
                    break;
                }
            case 3:
                setText(n.j.theme_download);
                setTextColor(n.d.cp_cont_b);
                break;
            case 4:
                setText(n.j.theme_use);
                setTextColor(n.d.cp_cont_b);
                break;
            case 5:
                setText(n.j.theme_need_update);
                setTextColor(n.d.cp_cont_b);
                break;
            case 6:
                setText(n.j.theme_activity);
                setTextColor(n.d.cp_cont_b);
                break;
        }
        if (this.mSkinData != null && this.mSkinData.YL() == 7) {
            setEnabled(false);
        }
        setProgress(f);
        invalidate();
    }

    public void b(int i, float f, int i2, int i3) {
        this.dLD = false;
        setEnabled(true);
        switch (i) {
            case 0:
                setText(n.j.theme_in_use);
                setTextColor(n.d.cp_cont_c);
                setEnabled(false);
                break;
            case 1:
                if (i2 == 0) {
                    setText(n.j.download_free);
                    setTextColor(n.d.cp_cont_b);
                    break;
                } else {
                    setTextColor(n.d.cp_cont_i);
                    setBgColor(n.d.cp_other_f);
                    this.dLD = true;
                    if (i2 == 100) {
                        if (i3 == 0) {
                            setText(n.j.btn_activity_skin_free);
                            setBgColor(n.d.cp_link_tip_a);
                            break;
                        } else {
                            setText(n.j.theme_download);
                            setBgColor(n.d.cp_link_tip_a);
                            break;
                        }
                    } else if (i2 == 101) {
                        setText(n.j.btn_annual_download_free);
                        break;
                    } else if (i2 <= 1) {
                        setText(n.j.become_member_download_free);
                        break;
                    } else {
                        setText(String.format(this.mContext.getString(n.j.btn_vip_can_download_free), Integer.valueOf(i2)));
                        break;
                    }
                }
            case 2:
                setText(n.j.theme_cancel_download);
                if (f > 0.5d) {
                    setTextColor(n.d.cp_cont_i);
                    break;
                } else {
                    setTextColor(n.d.cp_cont_b);
                    break;
                }
            case 3:
                if (i2 == 0) {
                    setText(n.j.download_free);
                    setTextColor(n.d.cp_cont_b);
                    break;
                } else {
                    setText(n.j.become_member_download_free);
                    setTextColor(n.d.cp_cont_i);
                    setBgColor(n.d.cp_other_f);
                    this.dLD = true;
                    break;
                }
            case 4:
                setText(n.j.use_immediately);
                setTextColor(n.d.cp_cont_b);
                break;
            case 5:
                setText(n.j.theme_need_update);
                setTextColor(n.d.cp_cont_b);
                break;
            case 6:
                setText(n.j.activity_free_use);
                setTextColor(n.d.cp_cont_b);
                setBgColor(n.d.cp_link_tip_a);
                this.dLD = true;
                break;
            case 9:
                if (i2 == 0) {
                    setText(n.j.use_freely);
                    setTextColor(n.d.cp_cont_b);
                } else {
                    setTextColor(n.d.cp_cont_i);
                    setBgColor(n.d.cp_other_f);
                    this.dLD = true;
                    if (i2 == 100) {
                        if (i3 == 0) {
                            setText(n.j.activity_free_use);
                            setBgColor(n.d.cp_link_tip_a);
                        } else {
                            setText(n.j.use_immediately);
                            setBgColor(n.d.cp_link_tip_a);
                        }
                    } else if (i2 == 101) {
                        setText(n.j.become_annual_free_use);
                    } else if (i2 > 1) {
                        setText(String.format(this.mContext.getString(n.j.become_vip_free_use), Integer.valueOf(i2)));
                    } else {
                        setText(n.j.become_member_free_use);
                    }
                }
                setEnabled(true);
                break;
        }
        setProgress(f);
        invalidate();
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.dLF != null) {
            this.dLF.setTag(bdUniqueId);
        }
    }

    public void setSkinData(b bVar) {
        this.mSkinData = bVar;
    }

    public b getSkinData() {
        return this.mSkinData;
    }

    public void setProgress(float f) {
        this.dLB = f;
    }

    public int getDrawColor() {
        return this.dLA;
    }

    public void setDrawColor(int i) {
        this.dLA = i;
    }

    public void setText(int i) {
        this.aav = this.mContext.getResources().getString(i);
    }

    public void setText(String str) {
        this.aav = str;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public int getBgColor() {
        return this.asc;
    }

    public void setBgColor(int i) {
        this.asc = i;
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
        this.dLD = z;
    }

    public void setSkinDetailPage(boolean z) {
        this.dLE = z;
    }
}
