package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private cr a;

    public void setTagData(cs csVar) {
        setTag(csVar);
        a();
    }

    public TbCheckBox(Context context) {
        super(context);
        c();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    private void c() {
        setOnClickListener(new cq(this));
        a();
    }

    public void setStatedChangedListener(cr crVar) {
        this.a = crVar;
    }

    public void a() {
        if (TiebaApplication.g().al() == 1) {
            setImageResource(d() ? R.drawable.btn_friend_choose_s_1 : R.drawable.btn_friend_choose_n_1);
        } else {
            setImageResource(d() ? R.drawable.btn_friend_choose_s : R.drawable.btn_friend_choose_n);
        }
    }

    public boolean b() {
        return d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        Object tag = getTag();
        if (tag == null || !(tag instanceof cs)) {
            return false;
        }
        return ((cs) tag).isChecked();
    }

    public void setChecked(boolean z) {
        Object tag = getTag();
        if (tag != null && (tag instanceof cs)) {
            ((cs) tag).setChecked(z);
        }
        a();
        if (this.a != null) {
            this.a.a(this, z, getTag());
        }
    }
}
