package com.baidu.wallet.qrcodescanner;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes5.dex */
public class a implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public float f26510a;

    /* renamed from: b  reason: collision with root package name */
    public int f26511b = 0;

    /* renamed from: c  reason: collision with root package name */
    public InterfaceC0267a f26512c;

    /* renamed from: com.baidu.wallet.qrcodescanner.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0267a {
        void a();

        void a(boolean z);
    }

    private float a(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    private void b() {
        InterfaceC0267a interfaceC0267a = this.f26512c;
        if (interfaceC0267a != null) {
            interfaceC0267a.a(false);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterfaceC0267a interfaceC0267a = this.f26512c;
        if (interfaceC0267a != null) {
            interfaceC0267a.a();
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f26511b = 1;
        } else if (action == 1) {
            this.f26511b = 0;
        } else if (action != 2) {
            if (action == 5) {
                this.f26510a = a(motionEvent);
                this.f26511b++;
            } else if (action == 6) {
                this.f26511b--;
            }
        } else if (this.f26511b >= 2) {
            float a2 = a(motionEvent);
            if (a2 > this.f26510a) {
                a();
            }
            if (a2 < this.f26510a) {
                b();
            }
        }
        return true;
    }

    private void a() {
        InterfaceC0267a interfaceC0267a = this.f26512c;
        if (interfaceC0267a != null) {
            interfaceC0267a.a(true);
        }
    }

    public void a(InterfaceC0267a interfaceC0267a) {
        this.f26512c = interfaceC0267a;
    }
}
