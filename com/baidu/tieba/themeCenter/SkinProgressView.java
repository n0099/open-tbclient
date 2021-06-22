package com.baidu.tieba.themeCenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.DressItemData;
import d.a.c.e.p.l;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class SkinProgressView extends View {

    /* renamed from: e  reason: collision with root package name */
    public Context f21201e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f21202f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f21203g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f21204h;

    /* renamed from: i  reason: collision with root package name */
    public int f21205i;
    public int j;
    public int k;
    public int l;
    public float m;
    public float n;
    public int o;
    public String p;
    public float q;
    public float r;
    public boolean s;
    public DressItemData t;

    public SkinProgressView(Context context) {
        super(context);
        this.s = false;
        this.f21201e = context;
        a();
    }

    public final void a() {
        this.o = l.g(this.f21201e, R.dimen.ds6);
        this.k = l.g(this.f21201e, R.dimen.fontsize24);
        this.f21205i = R.color.CAM_X0302;
        this.l = R.color.CAM_X0108;
        Paint paint = new Paint();
        this.f21202f = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f21204h = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.f21203g = paint3;
        paint3.setAntiAlias(true);
        this.f21203g.setTextSize(this.k);
        this.f21203g.setTextAlign(Paint.Align.CENTER);
    }

    @SuppressLint({"ResourceAsColor"})
    public void b(int i2, float f2, int i3, int i4, int i5) {
        this.s = false;
        setEnabled(true);
        if (i2 != 9) {
            switch (i2) {
                case 0:
                    if (i5 == 1) {
                        setText(R.string.back_to_home);
                    } else if (i5 == 2) {
                        setText(R.string.back_to_person);
                    } else {
                        setText(R.string.theme_in_use);
                        setEnabled(false);
                    }
                    setTextColor(R.color.CAM_X0105);
                    break;
                case 1:
                    if (i3 == 0) {
                        setText(R.string.download_free);
                        setTextColor(R.color.CAM_X0105);
                        break;
                    } else {
                        setTextColor(R.color.CAM_X0101);
                        setBgColor(R.color.CAM_X0312);
                        this.s = true;
                        if (i3 != 100) {
                            if (i3 != 101) {
                                if (i3 <= 1) {
                                    setText(R.string.become_member_download_free);
                                    break;
                                } else {
                                    setText(String.format(this.f21201e.getString(R.string.btn_vip_can_download_free), Integer.valueOf(i3)));
                                    break;
                                }
                            } else {
                                setText(R.string.btn_annual_download_free);
                                break;
                            }
                        } else if (i4 == 0) {
                            setText(R.string.btn_activity_skin_free);
                            setBgColor(R.color.CAM_X0302);
                            break;
                        } else {
                            setText(R.string.download);
                            setBgColor(R.color.CAM_X0302);
                            break;
                        }
                    }
                case 2:
                    setText(R.string.cancel);
                    if (f2 > 0.5d) {
                        setTextColor(R.color.CAM_X0101);
                        break;
                    } else {
                        setTextColor(R.color.CAM_X0105);
                        break;
                    }
                case 3:
                    if (i3 == 0) {
                        setText(R.string.download_free);
                        setTextColor(R.color.CAM_X0105);
                        break;
                    } else {
                        setText(R.string.become_member_download_free);
                        setTextColor(R.color.CAM_X0101);
                        setBgColor(R.color.CAM_X0312);
                        this.s = true;
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
                    this.s = true;
                    break;
            }
        } else {
            if (i5 == 2 && this.t.getDailyPrevilegeStatus() == 1) {
                setText(R.string.use_immediately);
                setTextColor(R.color.CAM_X0105);
            } else if (i3 == 0) {
                setText(R.string.use_freely);
                setTextColor(R.color.CAM_X0105);
            } else {
                setTextColor(R.color.CAM_X0101);
                setBgColor(R.color.CAM_X0312);
                this.s = true;
                if (i3 == 100) {
                    if (i4 == 0) {
                        setText(R.string.activity_free_use);
                        setBgColor(R.color.CAM_X0302);
                    } else {
                        setText(R.string.use_immediately);
                        setBgColor(R.color.CAM_X0302);
                    }
                } else if (i3 == 101) {
                    setText(R.string.become_annual_free_use);
                } else if (i3 > 1) {
                    setText(String.format(this.f21201e.getString(R.string.become_vip_free_use), Integer.valueOf(i3)));
                } else {
                    setText(R.string.become_member_free_use);
                }
            }
            setEnabled(true);
        }
        setProgress(f2);
        invalidate();
    }

    @SuppressLint({"ResourceAsColor"})
    public void c(int i2, float f2) {
        setEnabled(true);
        switch (i2) {
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
                if (f2 > 0.5d) {
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
        setProgress(f2);
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.s) {
            RectF rectF = new RectF(0.0f, 0.0f, this.m, this.n);
            this.f21204h.setColor(SkinManager.getColor(this.j));
            int i2 = this.o;
            canvas.drawRoundRect(rectF, i2, i2, this.f21204h);
        }
        RectF rectF2 = new RectF(0.0f, 0.0f, this.m * this.q, this.n);
        this.f21202f.setColor(SkinManager.getColor(this.f21205i));
        int i3 = this.o;
        canvas.drawRoundRect(rectF2, i3, i3, this.f21202f);
        if (StringUtils.isNull(this.p)) {
            return;
        }
        this.f21203g.setColor(SkinManager.getColor(this.l));
        this.f21203g.setTextSize(this.k);
        float f2 = this.f21203g.getFontMetrics().bottom - this.f21203g.getFontMetrics().top;
        this.r = f2;
        float f3 = this.n;
        canvas.drawText(this.p, this.m / 2.0f, (f3 - ((f3 - f2) / 2.0f)) - this.f21203g.getFontMetrics().bottom, this.f21203g);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.m = View.MeasureSpec.getSize(i2);
        this.n = View.MeasureSpec.getSize(i3);
    }

    public void setBgColor(int i2) {
        this.j = i2;
    }

    public void setDressData(DressItemData dressItemData) {
        this.t = dressItemData;
    }

    public void setFontSize(int i2) {
        this.k = i2;
    }

    public void setProgress(float f2) {
        this.q = f2;
    }

    public void setText(int i2) {
        this.p = this.f21201e.getResources().getString(i2);
    }

    public void setTextColor(int i2) {
        this.l = i2;
    }

    public void setText(String str) {
        this.p = str;
    }

    public SkinProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.s = false;
        this.f21201e = context;
        a();
    }

    public SkinProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.s = false;
        this.f21201e = context;
        a();
    }
}
