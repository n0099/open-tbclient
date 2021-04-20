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
    public View f26452a;

    /* renamed from: b  reason: collision with root package name */
    public View f26453b;

    /* renamed from: c  reason: collision with root package name */
    public a f26454c;

    /* renamed from: d  reason: collision with root package name */
    public b f26455d;

    /* loaded from: classes5.dex */
    public class a extends View {

        /* renamed from: a  reason: collision with root package name */
        public int f26457a;

        /* renamed from: b  reason: collision with root package name */
        public int f26458b;

        /* renamed from: d  reason: collision with root package name */
        public Paint f26460d;

        /* renamed from: e  reason: collision with root package name */
        public Rect f26461e;

        /* renamed from: f  reason: collision with root package name */
        public Path f26462f;

        /* renamed from: g  reason: collision with root package name */
        public int f26463g;

        public a(Context context) {
            super(context);
            this.f26460d = new Paint();
            this.f26461e = new Rect();
            this.f26462f = new Path();
            this.f26463g = 0;
            this.f26457a = 1;
            this.f26458b = 0;
            this.f26463g = DisplayUtils.dip2px(getContext(), 1.0f);
        }

        public void a(int i) {
            this.f26457a = i;
        }

        public void b(int i) {
            this.f26458b = i;
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            float height = (getHeight() - (DisplayUtils.dip2px(getContext(), 6.0f) * 2)) - (((getHeight() - (DisplayUtils.dip2px(getContext(), 6.0f) * 2)) * this.f26458b) / this.f26457a);
            int i = (int) height;
            this.f26461e.set((getWidth() - this.f26463g) / 2, DisplayUtils.dip2px(getContext(), 6.0f), (getWidth() + this.f26463g) / 2, i);
            Path path = this.f26462f;
            Rect rect = this.f26461e;
            path.addRect(new RectF(rect.left, rect.top, rect.right, rect.bottom), Path.Direction.CW);
            this.f26460d.setColor(-1);
            this.f26460d.setAlpha(33);
            canvas.drawRect(this.f26461e, this.f26460d);
            this.f26461e.set((getWidth() - this.f26463g) / 2, i + DisplayUtils.dip2px(getContext(), 6.0f), (getWidth() + this.f26463g) / 2, getHeight() - (DisplayUtils.dip2px(getContext(), 6.0f) * 2));
            Path path2 = this.f26462f;
            Rect rect2 = this.f26461e;
            path2.addRect(new RectF(rect2.left, rect2.top, rect2.right, rect2.bottom), Path.Direction.CW);
            this.f26460d.setColor(-1);
            this.f26460d.setAlpha(127);
            canvas.drawRect(this.f26461e, this.f26460d);
            this.f26460d.setAlpha(255);
            canvas.drawCircle(getWidth() / 2, height + DisplayUtils.dip2px(getContext(), 6.0f), DisplayUtils.dip2px(getContext(), 6.0f), this.f26460d);
            super.draw(canvas);
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();

        void a(int i);
    }

    public ProgressView(Context context) {
        super(context);
        a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar = this.f26455d;
        if (bVar != null) {
            bVar.a();
        }
        if (view == this.f26452a) {
            a aVar = this.f26454c;
            int i = aVar.f26458b + 2;
            int i2 = aVar.f26457a;
            if (i > i2) {
                i = i2;
            }
            this.f26454c.b(i);
            this.f26454c.invalidate();
            b bVar2 = this.f26455d;
            if (bVar2 != null) {
                bVar2.a(this.f26454c.f26458b);
            }
        }
        if (view == this.f26453b) {
            int i3 = this.f26454c.f26458b - 2;
            if (i3 < 0) {
                i3 = 0;
            }
            this.f26454c.b(i3);
            this.f26454c.invalidate();
            b bVar3 = this.f26455d;
            if (bVar3 != null) {
                bVar3.a(this.f26454c.f26458b);
            }
        }
    }

    public void setMaxPregress(int i) {
        this.f26454c.a(i);
    }

    public void setProgress(int i) {
        this.f26454c.b(i);
        this.f26454c.invalidate();
    }

    public void setProgressStatusChangeListener(b bVar) {
        this.f26455d = bVar;
    }

    private void a() {
        View view = new View(getContext());
        this.f26452a = view;
        view.setBackgroundResource(ResUtils.drawable(getContext(), "wallet_qrscanner_progress_add"));
        this.f26452a.setOnClickListener(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DisplayUtils.dip2px(getContext(), 12.0f), DisplayUtils.dip2px(getContext(), 12.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(14, -1);
        layoutParams.topMargin = DisplayUtils.dip2px(getContext(), 6.0f);
        addView(this.f26452a, layoutParams);
        View view2 = new View(getContext());
        this.f26453b = view2;
        view2.setBackgroundResource(ResUtils.drawable(getContext(), "wallet_qrscanner_progress_cut"));
        this.f26453b.setOnClickListener(this);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(DisplayUtils.dip2px(getContext(), 12.0f), DisplayUtils.dip2px(getContext(), 12.0f));
        layoutParams2.addRule(12);
        layoutParams2.addRule(14, -1);
        layoutParams2.bottomMargin = DisplayUtils.dip2px(getContext(), 6.0f);
        addView(this.f26453b, layoutParams2);
        this.f26454c = new a(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(DisplayUtils.dip2px(getContext(), 12.0f), DisplayUtils.dip2px(getContext(), 192.0f));
        layoutParams3.addRule(13, -1);
        addView(this.f26454c, layoutParams3);
        this.f26454c.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.wallet.qrcodescanner.widget.ProgressView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view3, MotionEvent motionEvent) {
                if (ProgressView.this.f26455d != null) {
                    ProgressView.this.f26455d.a();
                }
                if (motionEvent.getAction() == 0) {
                    int height = ProgressView.this.f26454c.getHeight();
                    int[] iArr = new int[2];
                    ProgressView.this.f26454c.getLocationOnScreen(iArr);
                    int i = iArr[1];
                    if (motionEvent.getRawY() >= i) {
                        float f2 = i + height;
                        if (motionEvent.getRawY() <= f2) {
                            int rawY = (int) (((f2 - motionEvent.getRawY()) / height) * ProgressView.this.f26454c.f26457a);
                            ProgressView.this.f26454c.b(rawY);
                            ProgressView.this.f26454c.invalidate();
                            if (ProgressView.this.f26455d != null) {
                                ProgressView.this.f26455d.a(rawY);
                            }
                        }
                    }
                    return true;
                } else if (motionEvent.getAction() == 2) {
                    int height2 = ProgressView.this.f26454c.getHeight();
                    int[] iArr2 = new int[2];
                    ProgressView.this.f26454c.getLocationOnScreen(iArr2);
                    int i2 = iArr2[1];
                    if (motionEvent.getRawY() >= i2) {
                        float f3 = i2 + height2;
                        if (motionEvent.getRawY() <= f3) {
                            int rawY2 = (int) (((f3 - motionEvent.getRawY()) / height2) * ProgressView.this.f26454c.f26457a);
                            ProgressView.this.f26454c.b(rawY2);
                            ProgressView.this.f26454c.invalidate();
                            if (ProgressView.this.f26455d != null) {
                                ProgressView.this.f26455d.a(rawY2);
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
