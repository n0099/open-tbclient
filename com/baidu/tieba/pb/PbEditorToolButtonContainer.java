package com.baidu.tieba.pb;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PbEditorToolButtonContainer extends com.baidu.tieba.editortool.j {
    public PbEditorToolButtonContainer(Context context) {
        super(context);
    }

    public PbEditorToolButtonContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.baidu.tieba.editortool.j
    protected void e() {
        LayoutInflater.from(this.f1228a).inflate(R.layout.pb_editor_tool_button_container, (ViewGroup) this, true);
    }

    public void a(Bitmap bitmap) {
        this.d.a(bitmap);
    }

    public void l() {
        this.d.setImageResource(TiebaApplication.g().ap() == 1 ? R.drawable.new_pb_camera_btn_1 : R.drawable.new_pb_camera_btn);
        this.d.setTag(null);
    }

    public Bitmap getImage() {
        Object tag = this.d.getTag();
        if (tag == null || !(tag instanceof Bitmap)) {
            return null;
        }
        return (Bitmap) tag;
    }

    public boolean m() {
        return this.d.getTag() != null;
    }
}
