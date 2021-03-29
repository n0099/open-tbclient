package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.utils.AccessibilityUtils;
/* loaded from: classes5.dex */
public class SwitchButton extends ImageButton {

    /* renamed from: a  reason: collision with root package name */
    public boolean f26453a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f26454b;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z);
    }

    public SwitchButton(Context context) {
        super(context);
        this.f26454b = false;
        a();
    }

    public boolean isChanged() {
        return this.f26453a == this.f26454b;
    }

    public boolean isChecked() {
        return this.f26453a;
    }

    public void resetChecked() {
        this.f26454b = this.f26453a;
    }

    public void setChecked(boolean z) {
        if (z) {
            setBackgroundResource(ResUtils.drawable(getContext(), "wallet_base_btn_pressed_on"));
        } else {
            setBackgroundResource(ResUtils.drawable(getContext(), "wallet_base_btn_default_off"));
        }
        this.f26453a = z;
        AccessibilityUtils.setContentDescription(this, !z ? "开" : "关");
    }

    public void setOnCheckedListener(final a aVar) {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.widget.SwitchButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(!SwitchButton.this.f26453a);
                }
            }
        });
    }

    private void a() {
        setBackgroundResource(ResUtils.drawable(getContext(), "wallet_base_btn_default_off"));
        AccessibilityUtils.setContentDescription(this, !this.f26453a ? "开" : "关");
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f26454b = false;
        a();
    }
}
