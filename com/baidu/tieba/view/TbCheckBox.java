package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private cq a;

    public void setTagData(cr crVar) {
        setTag(crVar);
        c();
    }

    public TbCheckBox(Context context) {
        super(context);
        b();
    }

    public TbCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    private void b() {
        setOnClickListener(new cp(this));
        c();
    }

    public void setStatedChangedListener(cq cqVar) {
        this.a = cqVar;
    }

    private void c() {
        if (TiebaApplication.g().ae() == 1) {
            setImageResource(d() ? R.drawable.btn_friend_choose_s_1 : R.drawable.btn_friend_choose_n_1);
        } else {
            setImageResource(d() ? R.drawable.btn_friend_choose_s : R.drawable.btn_friend_choose_n);
        }
    }

    public final boolean a() {
        return d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        Object tag = getTag();
        if (tag == null || !(tag instanceof cr)) {
            return false;
        }
        return ((cr) tag).isChecked();
    }

    public void setChecked(boolean z) {
        Object tag = getTag();
        if (tag != null && (tag instanceof cr)) {
            ((cr) tag).setChecked(z);
        }
        c();
        if (this.a != null) {
            this.a.a(this, z, getTag());
        }
    }
}
