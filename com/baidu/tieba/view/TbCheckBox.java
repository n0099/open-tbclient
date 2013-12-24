package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class TbCheckBox extends ImageView {
    private bo a;

    public void setTagData(bp bpVar) {
        setTag(bpVar);
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
        setOnClickListener(new bn(this));
        a();
    }

    public void setStatedChangedListener(bo boVar) {
        this.a = boVar;
    }

    public void a() {
        if (TiebaApplication.h().an() == 1) {
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
        if (tag == null || !(tag instanceof bp)) {
            return false;
        }
        return ((bp) tag).d();
    }

    public void setChecked(boolean z) {
        Object tag = getTag();
        if (tag != null && (tag instanceof bp)) {
            ((bp) tag).a(z);
        }
        a();
        if (this.a != null) {
            this.a.a(this, z, getTag());
        }
    }
}
