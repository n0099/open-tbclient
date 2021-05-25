package com.baidu.wallet.qrcodescanner.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
/* loaded from: classes5.dex */
public class ProgressView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public View f26441a;

    /* renamed from: b  reason: collision with root package name */
    public View f26442b;

    /* renamed from: c  reason: collision with root package name */
    public a f26443c;

    /* renamed from: d  reason: collision with root package name */
    public b f26444d;

    /* loaded from: classes5.dex */
    public class a extends View {

        /* renamed from: a  reason: collision with root package name */
        public int f26446a;

        /* renamed from: b  reason: collision with root package name */
        public int f26447b;

        /* renamed from: d  reason: collision with root package name */
        public Paint f26449d;

        /* renamed from: e  reason: collision with root package name */
        public Rect f26450e;

        /* renamed from: f  reason: collision with root package name */
        public Path f26451f;

        /* renamed from: g  reason: collision with root package name */
        public int f26452g;

        public a(Context context) {
            super(context);
            this.f26449d = new Paint();
            this.f26450e = new Rect();
            this.f26451f = new Path();
            this.f26452g = 0;
            this.f26446a = 1;
            this.f26447b = 0;
            this.f26452g = DisplayUtils.dip2px(getContext(), 1.0f);
        }

        public void a(int i2) {
            this.f26446a = i2;
        }

        public void b(int i2) {
            this.f26447b = i2;
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            float height = (getHeight() - (DisplayUtils.dip2px(getContext(), 6.0f) * 2)) - (((getHeight() - (DisplayUtils.dip2px(getContext(), 6.0f) * 2)) * this.f26447b) / this.f26446a);
            int i2 = (int) height;
            this.f26450e.set((getWidth() - this.f26452g) / 2, DisplayUtils.dip2px(getContext(), 6.0f), (getWidth() + this.f26452g) / 2, i2);
            Path path = this.f26451f;
            Rect rect = this.f26450e;
            path.addRect(new RectF(rect.left, rect.top, rect.right, rect.bottom), Path.Direction.CW);
            this.f26449d.setColor(-1);
            this.f26449d.setAlpha(33);
            canvas.drawRect(this.f26450e, this.f26449d);
            this.f26450e.set((getWidth() - this.f26452g) / 2, i2 + DisplayUtils.dip2px(getContext(), 6.0f), (getWidth() + this.f26452g) / 2, getHeight() - (DisplayUtils.dip2px(getContext(), 6.0f) * 2));
            Path path2 = this.f26451f;
            Rect rect2 = this.f26450e;
            path2.addRect(new RectF(rect2.left, rect2.top, rect2.right, rect2.bottom), Path.Direction.CW);
            this.f26449d.setColor(-1);
            this.f26449d.setAlpha(127);
            canvas.drawRect(this.f26450e, this.f26449d);
            this.f26449d.setAlpha(255);
            canvas.drawCircle(getWidth() / 2, height + DisplayUtils.dip2px(getContext(), 6.0f), DisplayUtils.dip2px(getContext(), 6.0f), this.f26449d);
            super.draw(canvas);
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();

        void a(int i2);
    }

    public ProgressView(Context context) {
        super(context);
        a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar = this.f26444d;
        if (bVar != null) {
            bVar.a();
        }
        if (view == this.f26441a) {
            a aVar = this.f26443c;
            int i2 = aVar.f26447b + 2;
            int i3 = aVar.f26446a;
            if (i2 > i3) {
                i2 = i3;
            }
            this.f26443c.b(i2);
            this.f26443c.invalidate();
            b bVar2 = this.f26444d;
            if (bVar2 != null) {
                bVar2.a(this.f26443c.f26447b);
            }
        }
        if (view == this.f26442b) {
            int i4 = this.f26443c.f26447b - 2;
            if (i4 < 0) {
                i4 = 0;
            }
            this.f26443c.b(i4);
            this.f26443c.invalidate();
            b bVar3 = this.f26444d;
            if (bVar3 != null) {
                bVar3.a(this.f26443c.f26447b);
            }
        }
    }

    public void setMaxPregress(int i2) {
        this.f26443c.a(i2);
    }

    public void setProgress(int i2) {
        this.f26443c.b(i2);
        this.f26443c.invalidate();
    }

    public void setProgressStatusChangeListener(b bVar) {
        this.f26444d = bVar;
    }

    private void a() {
        View view = new View(getContext());
        this.f26441a = view;
        view.setBackgroundResource(ResUtils.drawable(getContext(), "wallet_qrscanner_progress_add"));
        this.f26441a.setOnClickListener(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DisplayUtils.dip2px(getContext(), 12.0f), DisplayUtils.dip2px(getContext(), 12.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(14, -1);
        layoutParams.topMargin = DisplayUtils.dip2px(getContext(), 6.0f);
        addView(this.f26441a, layoutParams);
        View view2 = new View(getContext());
        this.f26442b = view2;
        view2.setBackgroundResource(ResUtils.drawable(getContext(), "wallet_qrscanner_progress_cut"));
        this.f26442b.setOnClickListener(this);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(DisplayUtils.dip2px(getContext(), 12.0f), DisplayUtils.dip2px(getContext(), 12.0f));
        layoutParams2.addRule(12);
        layoutParams2.addRule(14, -1);
        layoutParams2.bottomMargin = DisplayUtils.dip2px(getContext(), 6.0f);
        addView(this.f26442b, layoutParams2);
        this.f26443c = new a(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(DisplayUtils.dip2px(getContext(), 12.0f), DisplayUtils.dip2px(getContext(), 192.0f));
        layoutParams3.addRule(13, -1);
        addView(this.f26443c, layoutParams3);
        this.f26443c.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.wallet.qrcodescanner.widget.ProgressView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view3, MotionEvent motionEvent) {
                if (ProgressView.this.f26444d != null) {
                    ProgressView.this.f26444d.a();
                }
                if (motionEvent.getAction() == 0) {
                    int height = ProgressView.this.f26443c.getHeight();
                    int[] iArr = new int[2];
                    ProgressView.this.f26443c.getLocationOnScreen(iArr);
                    int i2 = iArr[1];
                    if (motionEvent.getRawY() >= i2) {
                        float f2 = i2 + height;
                        if (motionEvent.getRawY() <= f2) {
                            int rawY = (int) (((f2 - motionEvent.getRawY()) / height) * ProgressView.this.f26443c.f26446a);
                            ProgressView.this.f26443c.b(rawY);
                            ProgressView.this.f26443c.invalidate();
                            if (ProgressView.this.f26444d != null) {
                                ProgressView.this.f26444d.a(rawY);
                            }
                        }
                    }
                    return true;
                } else if (motionEvent.getAction() == 2) {
                    int height2 = ProgressView.this.f26443c.getHeight();
                    int[] iArr2 = new int[2];
                    ProgressView.this.f26443c.getLocationOnScreen(iArr2);
                    int i3 = iArr2[1];
                    if (motionEvent.getRawY() >= i3) {
                        float f3 = i3 + height2;
                        if (motionEvent.getRawY() <= f3) {
                            int rawY2 = (int) (((f3 - motionEvent.getRawY()) / height2) * ProgressView.this.f26443c.f26446a);
                            ProgressView.this.f26443c.b(rawY2);
                            ProgressView.this.f26443c.invalidate();
                            if (ProgressView.this.f26444d != null) {
                                ProgressView.this.f26444d.a(rawY2);
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                } else {
                    return false;
                }
            }
        });
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
