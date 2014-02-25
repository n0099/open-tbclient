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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.k;
import com.baidu.tieba.util.bq;
import com.slidingmenu.lib.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private static final HashMap<Integer, Integer[]> m = new HashMap<>(2);
    private String a;
    private List<Object> b;
    private f c;
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

    public d(Activity activity) {
        this.e = activity;
        this.d = (LayoutInflater) activity.getSystemService("layout_inflater");
        this.f = (ViewGroup) this.d.inflate(R.layout.dialog_bdlist, (ViewGroup) null);
        this.h = (TextView) this.f.findViewById(R.id.dialog_title);
        this.g = (ViewGroup) this.f.findViewById(R.id.dialog_content);
    }

    public d a(Object[] objArr, f fVar) {
        if (objArr != null && objArr.length > 0) {
            return a(Arrays.asList(objArr), fVar);
        }
        return this;
    }

    public d a(List<Object> list, f fVar) {
        if (list != null && list.size() > 0) {
            this.b = list;
            if (fVar != null) {
                this.c = fVar;
            }
        }
        return this;
    }

    public d a(int i) {
        this.i = i;
        return this;
    }

    public d b(int i) {
        this.j = i;
        return this;
    }

    public d a() {
        if (!this.k) {
            this.k = true;
            d();
            if (!TextUtils.isEmpty(this.a)) {
                this.h.setText(this.a);
                this.h.setVisibility(0);
                bq.f(this.g, (int) R.drawable.bg_unite_popup_share_down);
            } else {
                this.h.setVisibility(8);
                bq.f(this.g, (int) R.drawable.bg_unite_popup);
            }
            if (this.b != null && this.b.size() > 0) {
                int size = this.b.size();
                for (int i = 0; i < size; i++) {
                    d(i);
                }
            }
        }
        return this;
    }

    public d b() {
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
        int al = TiebaApplication.g().al();
        if (this.e instanceof com.baidu.tieba.f) {
            com.baidu.tieba.f fVar = (com.baidu.tieba.f) this.e;
            fVar.getLayoutMode().a(al == 1);
            fVar.getLayoutMode().a((View) this.f);
        } else if (this.e instanceof k) {
            k kVar = (k) this.e;
            kVar.a().a(al == 1);
            kVar.a().a((View) this.f);
        }
    }

    public void c() {
        if (this.l != null) {
            this.l.dismiss();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private View d(int i) {
        int i2;
        String str;
        int i3;
        Exception exc;
        int i4;
        View inflate = LayoutInflater.from(this.e).inflate(R.layout.dialog_bdlist_item, this.g, false);
        Button button = (Button) inflate.findViewById(R.id.dialog_item_btn);
        Object obj = this.b.get(i);
        String str2 = "";
        int intValue = m.get(0)[0].intValue();
        int intValue2 = m.get(0)[1].intValue();
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            if (length > 0) {
                str2 = String.valueOf(objArr[0]);
            }
            if (length > 1) {
                try {
                    if (Integer.parseInt(String.valueOf(objArr[1])) == 1) {
                        i2 = m.get(1)[0].intValue();
                        try {
                            i3 = m.get(1)[1].intValue();
                            str = str2;
                        } catch (Exception e) {
                            i4 = i2;
                            exc = e;
                            exc.printStackTrace();
                            i2 = i4;
                            i3 = intValue2;
                            str = str2;
                            button.setText(str);
                            bq.f((View) button, i2);
                            bq.a(button, i3, 3);
                            if (this.c != null) {
                            }
                            this.g.addView(inflate);
                            return inflate;
                        }
                    }
                } catch (Exception e2) {
                    exc = e2;
                    i4 = intValue;
                }
            }
            i3 = intValue2;
            i2 = intValue;
            str = str2;
        } else {
            String valueOf = String.valueOf(obj);
            i2 = intValue;
            str = valueOf;
            i3 = intValue2;
        }
        button.setText(str);
        bq.f((View) button, i2);
        bq.a(button, i3, 3);
        if (this.c != null) {
            button.setOnClickListener(new e(this, i, button));
        }
        this.g.addView(inflate);
        return inflate;
    }

    public View c(int i) {
        if (this.g == null) {
            return null;
        }
        int childCount = this.g.getChildCount();
        if (i < 0 || i > childCount - 1) {
            return null;
        }
        return this.g.getChildAt(i);
    }
}
