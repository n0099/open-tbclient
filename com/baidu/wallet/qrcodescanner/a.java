package com.baidu.wallet.qrcodescanner;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes5.dex */
public class a implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public float f26478a;

    /* renamed from: b  reason: collision with root package name */
    public int f26479b = 0;

    /* renamed from: c  reason: collision with root package name */
    public InterfaceC0264a f26480c;

    /* renamed from: com.baidu.wallet.qrcodescanner.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0264a {
        void a();

        void a(boolean z);
    }

    private float a(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    private void b() {
        InterfaceC0264a interfaceC0264a = this.f26480c;
        if (interfaceC0264a != null) {
            interfaceC0264a.a(false);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterfaceC0264a interfaceC0264a = this.f26480c;
        if (interfaceC0264a != null) {
            interfaceC0264a.a();
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f26479b = 1;
        } else if (action == 1) {
            this.f26479b = 0;
        } else if (action != 2) {
            if (action == 5) {
                this.f26478a = a(motionEvent);
                this.f26479b++;
            } else if (action == 6) {
                this.f26479b--;
            }
        } else if (this.f26479b >= 2) {
            float a2 = a(motionEvent);
            if (a2 > this.f26478a) {
                a();
            }
            if (a2 < this.f26478a) {
                b();
            }
        }
        return true;
    }

    private void a() {
        InterfaceC0264a interfaceC0264a = this.f26480c;
        if (interfaceC0264a != null) {
            interfaceC0264a.a(true);
        }
    }

    public void a(InterfaceC0264a interfaceC0264a) {
        this.f26480c = interfaceC0264a;
    }
}
