package com.baidu.tieba.view.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.j;
import com.baidu.tieba.util.bb;
import com.slidingmenu.lib.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static final HashMap<Integer, Integer[]> m = new HashMap<>(2);
    private String a;
    private List<Object> b;
    private c c;
    private LayoutInflater d;
    private Activity e;
    private ViewGroup f;
    private ViewGroup g;
    private TextView h;
    private int i = -1;
    private int j = -1;
    private boolean k = false;
    private AlertDialog l;

    static {
        m.put(0, new Integer[]{Integer.valueOf((int) R.drawable.dialg_alert_btn_bg), Integer.valueOf((int) R.drawable.dialog_bdalert_button_textcolor_pressed)});
        m.put(1, new Integer[]{Integer.valueOf((int) R.drawable.btn_blue_square), Integer.valueOf((int) R.color.share_copy_pb_url)});
    }

    public a(Activity activity) {
        this.e = activity;
        this.d = (LayoutInflater) activity.getSystemService("layout_inflater");
        this.f = (ViewGroup) this.d.inflate(R.layout.dialog_bdlist, (ViewGroup) null);
        this.h = (TextView) this.f.findViewById(R.id.dialog_title);
        this.g = (ViewGroup) this.f.findViewById(R.id.dialog_content);
    }

    public a a(Object[] objArr, c cVar) {
        if (objArr != null && objArr.length > 0) {
            return a(Arrays.asList(objArr), cVar);
        }
        return this;
    }

    public a a(List<Object> list, c cVar) {
        if (list != null && list.size() > 0) {
            this.b = list;
            if (cVar != null) {
                this.c = cVar;
            }
        }
        return this;
    }

    public a a(int i) {
        this.i = i;
        return this;
    }

    public a b(int i) {
        this.j = i;
        return this;
    }

    public a a() {
        if (!this.k) {
            this.k = true;
            d();
            if (!TextUtils.isEmpty(this.a)) {
                this.h.setText(this.a);
                this.h.setVisibility(0);
                bb.f(this.g, (int) R.drawable.bg_unite_popup_share_down);
            } else {
                this.h.setVisibility(8);
                bb.f(this.g, (int) R.drawable.bg_unite_popup);
            }
            if (this.b != null && this.b.size() > 0) {
                int size = this.b.size();
                for (int i = 0; i < size; i++) {
                    c(i);
                }
            }
        }
        return this;
    }

    public a b() {
        if (!this.k) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.l != null) {
            this.l.show();
        } else {
            this.l = new AlertDialog.Builder(this.e).create();
            this.l.setCanceledOnTouchOutside(true);
            this.l.show();
            Window window = this.l.getWindow();
            if (this.i == -1) {
                this.i = R.style.dialog_ani_b2t;
            }
            window.setWindowAnimations(this.i);
            if (this.j != -1) {
                this.j = 80;
            }
            window.setGravity(this.j);
            window.setLayout(-1, -2);
            window.setContentView(this.f);
        }
        return this;
    }

    private void d() {
        int an = TiebaApplication.h().an();
        if (this.e instanceof j) {
            j jVar = (j) this.e;
            jVar.getLayoutMode().a(an == 1);
            jVar.getLayoutMode().a(this.f);
        } else if (this.e instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) this.e;
            baseFragmentActivity.a().a(an == 1);
            baseFragmentActivity.a().a(this.f);
        }
    }

    public void c() {
        if (this.l != null) {
            this.l.dismiss();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private View c(int i) {
        String valueOf;
        int i2;
        int i3;
        View inflate = LayoutInflater.from(this.e).inflate(R.layout.dialog_bdlist_item, this.g, false);
        Button button = (Button) inflate.findViewById(R.id.dialog_item_btn);
        Object obj = this.b.get(i);
        String str = "";
        int intValue = m.get(0)[0].intValue();
        int intValue2 = m.get(0)[1].intValue();
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            if (length > 0) {
                str = String.valueOf(objArr[0]);
            }
            if (length > 1) {
                try {
                    if (Integer.parseInt(String.valueOf(objArr[1])) == 1) {
                        i2 = m.get(1)[0].intValue();
                        try {
                            i3 = m.get(1)[1].intValue();
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            valueOf = str;
                            button.setText(valueOf);
                            bb.f((View) button, i2);
                            bb.a(button, intValue2, 3);
                            if (this.c != null) {
                            }
                            this.g.addView(inflate);
                            return inflate;
                        }
                    } else {
                        i3 = intValue2;
                        i2 = intValue;
                    }
                    intValue2 = i3;
                } catch (Exception e2) {
                    e = e2;
                    i2 = intValue;
                }
            } else {
                i2 = intValue;
            }
            valueOf = str;
        } else {
            valueOf = String.valueOf(obj);
            i2 = intValue;
        }
        button.setText(valueOf);
        bb.f((View) button, i2);
        bb.a(button, intValue2, 3);
        if (this.c != null) {
            button.setOnClickListener(new b(this, i, button));
        }
        this.g.addView(inflate);
        return inflate;
    }
}
