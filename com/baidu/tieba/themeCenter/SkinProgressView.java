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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class SkinProgressView extends View {
    private String Zf;
    private Paint aoH;
    private int aoI;
    private Paint dgo;
    private int dgp;
    private float dgq;
    private float dgr;
    private boolean dgs;
    private boolean dgt;
    private CustomMessageListener dgu;
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
        this.dgs = false;
        this.dgt = false;
        this.dgu = new h(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
        this.mContext = context;
        initView();
    }

    public SkinProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dgs = false;
        this.dgt = false;
        this.dgu = new h(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
        this.mContext = context;
        initView();
    }

    public SkinProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dgs = false;
        this.dgt = false;
        this.dgu = new h(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.radius = com.baidu.adp.lib.util.k.d(this.mContext, i.d.ds6);
        this.mFontSize = com.baidu.adp.lib.util.k.d(this.mContext, i.d.fontsize24);
        this.dgp = i.c.cp_link_tip_a;
        this.mTextColor = i.c.cp_cont_c;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.aoH = new Paint();
        this.aoH.setAntiAlias(true);
        this.dgo = new Paint();
        this.dgo.setAntiAlias(true);
        this.dgo.setTextSize(this.mFontSize);
        this.dgo.setTextAlign(Paint.Align.CENTER);
        MessageManager.getInstance().registerListener(this.dgu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAd() {
        if (this.mSkinData.azY() != 4 && this.mSkinData.azY() != 0) {
            if (this.mSkinData.aAa()) {
                TbadkCoreApplication.m411getInst().setUsedTheme(this.mSkinData.getId(), this.mSkinData.azX());
                e(0, 0.0f);
                this.mSkinData.lF(0);
            } else {
                e(4, 0.0f);
                this.mSkinData.lF(4);
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
        if (this.dgs) {
            RectF rectF = new RectF(0.0f, 0.0f, this.width, this.height);
            this.aoH.setColor(an.getColor(this.aoI));
            canvas.drawRoundRect(rectF, this.radius, this.radius, this.aoH);
        }
        RectF rectF2 = new RectF(0.0f, 0.0f, this.width * this.dgq, this.height);
        this.mPaint.setColor(an.getColor(this.dgp));
        canvas.drawRoundRect(rectF2, this.radius, this.radius, this.mPaint);
        if (!StringUtils.isNull(this.Zf)) {
            this.dgo.setColor(an.getColor(this.mTextColor));
            this.dgo.setTextSize(this.mFontSize);
            this.dgr = this.dgo.getFontMetrics().bottom - this.dgo.getFontMetrics().top;
            canvas.drawText(this.Zf, this.width / 2.0f, (this.height - ((this.height - this.dgr) / 2.0f)) - this.dgo.getFontMetrics().bottom, this.dgo);
        }
    }

    public void e(int i, float f) {
        if (this.dgt) {
            a(i, f, this.mSkinData != null ? this.mSkinData.azX() : 0);
            return;
        }
        setEnabled(true);
        switch (i) {
            case 0:
                setText(i.h.theme_in_use);
                setTextColor(i.c.cp_cont_c);
                setEnabled(false);
                break;
            case 1:
                setText(i.h.theme_download);
                setTextColor(i.c.cp_cont_b);
                break;
            case 2:
                setText(i.h.theme_cancel_download);
                if (f > 0.5d) {
                    setTextColor(i.c.cp_cont_i);
                    break;
                } else {
                    setTextColor(i.c.cp_cont_b);
                    break;
                }
            case 3:
                setText(i.h.theme_download);
                setTextColor(i.c.cp_cont_b);
                break;
            case 4:
                setText(i.h.theme_use);
                setTextColor(i.c.cp_cont_b);
                break;
            case 5:
                setText(i.h.theme_need_update);
                setTextColor(i.c.cp_cont_b);
                break;
            case 6:
                setText(i.h.theme_activity);
                setTextColor(i.c.cp_cont_b);
                break;
        }
        if (this.mSkinData != null && this.mSkinData.UA() == 7) {
            setEnabled(false);
        }
        setProgress(f);
        invalidate();
    }

    public void a(int i, float f, int i2) {
        this.dgs = false;
        setEnabled(true);
        switch (i) {
            case 0:
                setText(i.h.theme_in_use);
                setTextColor(i.c.cp_cont_c);
                setEnabled(false);
                break;
            case 1:
                if (i2 == 0) {
                    setText(i.h.download_free);
                    setTextColor(i.c.cp_cont_b);
                    break;
                } else {
                    setText(i.h.become_member_download_free);
                    setTextColor(i.c.cp_cont_i);
                    setBgColor(i.c.cp_other_f);
                    this.dgs = true;
                    break;
                }
            case 2:
                setText(i.h.theme_cancel_download);
                if (f > 0.5d) {
                    setTextColor(i.c.cp_cont_i);
                    break;
                } else {
                    setTextColor(i.c.cp_cont_b);
                    break;
                }
            case 3:
                if (i2 == 0) {
                    setText(i.h.download_free);
                    setTextColor(i.c.cp_cont_b);
                    break;
                } else {
                    setText(i.h.become_member_download_free);
                    setTextColor(i.c.cp_cont_i);
                    setBgColor(i.c.cp_other_f);
                    this.dgs = true;
                    break;
                }
            case 4:
                setText(i.h.use_immediately);
                setTextColor(i.c.cp_cont_b);
                break;
            case 5:
                setText(i.h.theme_need_update);
                setTextColor(i.c.cp_cont_b);
                break;
            case 6:
                setText(i.h.activity_free_use);
                setTextColor(i.c.cp_cont_b);
                setBgColor(i.c.cp_other_f);
                this.dgs = true;
                break;
            case 9:
                if (i2 == 0) {
                    setText(i.h.use_freely);
                    setTextColor(i.c.cp_cont_b);
                } else {
                    setText(i.h.become_member_free_use);
                    setTextColor(i.c.cp_cont_i);
                    setBgColor(i.c.cp_other_f);
                    this.dgs = true;
                }
                setEnabled(true);
                break;
        }
        setProgress(f);
        invalidate();
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.dgu != null) {
            this.dgu.setTag(bdUniqueId);
        }
    }

    public void setSkinData(b bVar) {
        this.mSkinData = bVar;
    }

    public b getSkinData() {
        return this.mSkinData;
    }

    public void setProgress(float f) {
        this.dgq = f;
    }

    public int getDrawColor() {
        return this.dgp;
    }

    public void setDrawColor(int i) {
        this.dgp = i;
    }

    public void setText(int i) {
        this.Zf = this.mContext.getResources().getString(i);
    }

    public void setText(String str) {
        this.Zf = str;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public int getBgColor() {
        return this.aoI;
    }

    public void setBgColor(int i) {
        this.aoI = i;
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
        this.dgs = z;
    }

    public void setSkinDetailPage(boolean z) {
        this.dgt = z;
    }
}
