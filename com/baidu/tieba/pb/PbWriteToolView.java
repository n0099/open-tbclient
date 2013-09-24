package com.baidu.tieba.pb;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.write.AudioIcon;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PbWriteToolView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f1517a;
    private boolean b;
    private ImageView c;
    private ImageView d;
    private ImageView e;
    private AudioIcon f;

    public PbWriteToolView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = false;
        this.f1517a = context;
        h();
        a(attributeSet);
    }

    public void a() {
        setVisibility(8);
    }

    public void b() {
        setVisibility(0);
    }

    private void h() {
        LayoutInflater.from(this.f1517a).inflate(R.layout.pb_write_tool_view, (ViewGroup) this, true);
        this.c = (ImageView) findViewById(R.id.pb_button_camera1);
        this.d = (ImageView) findViewById(R.id.pb_button_face1);
        this.e = (ImageView) findViewById(R.id.pb_button_at1);
        this.f = (AudioIcon) findViewById(R.id.audio_button1);
        a(TiebaApplication.g().ap());
        this.f.d();
        setPadding(UtilHelper.a(this.f1517a, 6.0f), 0, UtilHelper.a(this.f1517a, 6.0f), 0);
    }

    public void a(int i) {
        this.f.a(i);
        if (i == 1) {
            this.c.setImageResource(R.drawable.new_pb_camera_btn_1);
            this.d.setImageResource(this.b ? R.drawable.new_pb_keyboard_btn_1 : R.drawable.new_pb_face_btn_1);
            this.e.setImageResource(R.drawable.new_pb_at_btn_1);
        } else {
            this.c.setImageResource(R.drawable.new_pb_camera_btn);
            this.d.setImageResource(this.b ? R.drawable.new_pb_keyboard_btn : R.drawable.new_pb_face_btn);
            this.e.setImageResource(R.drawable.new_pb_at_btn);
        }
        this.d.setBackgroundDrawable(null);
    }

    public void c() {
        this.b = true;
        if (TiebaApplication.g().ap() == 1) {
            this.d.setImageResource(R.drawable.new_pb_keyboard_btn_1);
        } else {
            this.d.setImageResource(R.drawable.new_pb_keyboard_btn);
        }
        this.d.setBackgroundDrawable(null);
    }

    public void d() {
        this.b = false;
        if (TiebaApplication.g().ap() == 1) {
            this.d.setImageResource(R.drawable.new_pb_face_btn_1);
        } else {
            this.d.setImageResource(R.drawable.new_pb_face_btn);
        }
        this.d.setBackgroundDrawable(null);
    }

    public void e() {
        d();
        f();
    }

    public void f() {
        this.f.e();
    }

    public void g() {
        this.f.f();
    }

    public AudioIcon getAudioButton() {
        return this.f;
    }

    public View getCameraButton() {
        return this.c;
    }

    public View getAtButton() {
        return this.e;
    }

    public View getFaceButton() {
        return this.d;
    }

    public void setActionListener(com.baidu.tieba.more.aa aaVar) {
        da daVar = new da(this, aaVar);
        this.c.setOnClickListener(daVar);
        this.d.setOnClickListener(daVar);
        this.e.setOnClickListener(daVar);
        this.f.setOnClickListener(daVar);
    }

    private void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f1517a.obtainStyledAttributes(attributeSet, com.baidu.tieba.ag.PbWriteToolView);
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        boolean z2 = obtainStyledAttributes.getBoolean(1, false);
        boolean z3 = obtainStyledAttributes.getBoolean(3, false);
        boolean z4 = obtainStyledAttributes.getBoolean(2, false);
        this.f.setVisibility(z2 ? 8 : 0);
        this.c.setVisibility(z ? 8 : 0);
        this.e.setVisibility(z3 ? 8 : 0);
        this.d.setVisibility(z4 ? 8 : 0);
    }
}
