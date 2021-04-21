package com.baidu.wallet.qrcodescanner;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes5.dex */
public class a implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public float f26426a;

    /* renamed from: b  reason: collision with root package name */
    public int f26427b = 0;

    /* renamed from: c  reason: collision with root package name */
    public InterfaceC0282a f26428c;

    /* renamed from: com.baidu.wallet.qrcodescanner.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0282a {
        void a();

        void a(boolean z);
    }

    private float a(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    private void b() {
        InterfaceC0282a interfaceC0282a = this.f26428c;
        if (interfaceC0282a != null) {
            interfaceC0282a.a(false);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterfaceC0282a interfaceC0282a = this.f26428c;
        if (interfaceC0282a != null) {
            interfaceC0282a.a();
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f26427b = 1;
        } else if (action == 1) {
            this.f26427b = 0;
        } else if (action != 2) {
            if (action == 5) {
                this.f26426a = a(motionEvent);
                this.f26427b++;
            } else if (action == 6) {
                this.f26427b--;
            }
        } else if (this.f26427b >= 2) {
            float a2 = a(motionEvent);
            if (a2 > this.f26426a) {
                a();
            }
            if (a2 < this.f26426a) {
                b();
            }
        }
        return true;
    }

    private void a() {
        InterfaceC0282a interfaceC0282a = this.f26428c;
        if (interfaceC0282a != null) {
            interfaceC0282a.a(true);
        }
    }

    public void a(InterfaceC0282a interfaceC0282a) {
        this.f26428c = interfaceC0282a;
    }
}
