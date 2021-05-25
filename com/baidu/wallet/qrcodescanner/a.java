package com.baidu.wallet.qrcodescanner;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes5.dex */
public class a implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public float f26407a;

    /* renamed from: b  reason: collision with root package name */
    public int f26408b = 0;

    /* renamed from: c  reason: collision with root package name */
    public InterfaceC0265a f26409c;

    /* renamed from: com.baidu.wallet.qrcodescanner.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0265a {
        void a();

        void a(boolean z);
    }

    private float a(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    private void b() {
        InterfaceC0265a interfaceC0265a = this.f26409c;
        if (interfaceC0265a != null) {
            interfaceC0265a.a(false);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterfaceC0265a interfaceC0265a = this.f26409c;
        if (interfaceC0265a != null) {
            interfaceC0265a.a();
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f26408b = 1;
        } else if (action == 1) {
            this.f26408b = 0;
        } else if (action != 2) {
            if (action == 5) {
                this.f26407a = a(motionEvent);
                this.f26408b++;
            } else if (action == 6) {
                this.f26408b--;
            }
        } else if (this.f26408b >= 2) {
            float a2 = a(motionEvent);
            if (a2 > this.f26407a) {
                a();
            }
            if (a2 < this.f26407a) {
                b();
            }
        }
        return true;
    }

    private void a() {
        InterfaceC0265a interfaceC0265a = this.f26409c;
        if (interfaceC0265a != null) {
            interfaceC0265a.a(true);
        }
    }

    public void a(InterfaceC0265a interfaceC0265a) {
        this.f26409c = interfaceC0265a;
    }
}
