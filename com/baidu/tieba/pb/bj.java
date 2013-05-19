package com.baidu.tieba.pb;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class bj extends BaseAdapter {
    private Context b;
    private com.baidu.tieba.d.a c;
    private ArrayList a = null;
    private View.OnClickListener d = null;
    private View.OnClickListener e = null;
    private View.OnClickListener f = null;
    private int g = 0;
    private boolean h = false;
    private boolean i = true;

    public bj(Context context) {
        this.b = null;
        this.c = null;
        this.b = context;
        this.c = new com.baidu.tieba.d.a(this.b);
    }

    public com.baidu.tieba.d.a a() {
        return this.c;
    }

    public void a(ArrayList arrayList) {
        this.a = arrayList;
    }

    public void a(View.OnClickListener onClickListener) {
        this.d = onClickListener;
    }

    public void b(View.OnClickListener onClickListener) {
        this.e = onClickListener;
    }

    public void c(View.OnClickListener onClickListener) {
        this.f = onClickListener;
    }

    public void a(int i, boolean z) {
        this.g = i;
        this.h = z;
    }

    public void a(boolean z) {
        this.i = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.a == null) {
            return 0;
        }
        return this.a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.a == null || i < 0 || i >= this.a.size()) {
            return null;
        }
        return this.a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = b();
        }
        bk bkVar = (bk) view.getTag();
        if (getItem(i) != null) {
            a(bkVar, (com.baidu.tieba.a.aq) getItem(i), getCount() - i > 1);
        }
        return view;
    }

    public View b() {
        bk bkVar = new bk(this);
        View inflate = LayoutInflater.from(this.b).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        bkVar.a = inflate;
        bkVar.b = (ImageView) inflate.findViewById(R.id.photo);
        bkVar.c = (TextView) inflate.findViewById(R.id.time);
        bkVar.d = (Button) inflate.findViewById(R.id.manage_btn);
        bkVar.e = (TbRichTextView) inflate.findViewById(R.id.richText);
        bkVar.f = inflate.findViewById(R.id.line_divider);
        int ai = TiebaApplication.d().ai();
        bkVar.e.setTextSize(com.baidu.tieba.a.i.o());
        com.baidu.tieba.d.ac.d(bkVar.c, ai);
        if (TiebaApplication.d().ai() == 1) {
            bkVar.e.setTextColor(this.b.getResources().getColor(R.color.gray_night_3));
            bkVar.f.setBackgroundResource(R.drawable.line_comment_1);
        } else {
            bkVar.e.setTextColor(this.b.getResources().getColor(R.color.gray_day_3));
            bkVar.f.setBackgroundResource(R.drawable.line_comment);
        }
        bkVar.d.setOnClickListener(this.f);
        if (!this.i) {
            bkVar.b.setVisibility(8);
        }
        inflate.setTag(bkVar);
        return inflate;
    }

    public void a(bk bkVar, com.baidu.tieba.a.aq aqVar, boolean z) {
        boolean z2;
        boolean z3;
        if (bkVar != null && aqVar != null) {
            bkVar.b.setTag(null);
            bkVar.b.setTag(R.id.tag_photo_userid, null);
            bkVar.b.setTag(R.id.tag_photo_username, null);
            bkVar.b.setOnClickListener(this.d);
            if (aqVar.h() != null) {
                String c = aqVar.h().c();
                String a = aqVar.h().a();
                bkVar.a.setTag(R.id.tag_photo_username, c);
                bkVar.a.setTag(R.id.tag_clip_board, aqVar);
                bkVar.b.setTag(R.id.tag_photo_userid, a);
                bkVar.b.setTag(R.id.tag_photo_username, c);
                String e = aqVar.h().e();
                Bitmap b = this.c.b(e);
                if (b != null) {
                    bkVar.b.setImageBitmap(b);
                } else {
                    bkVar.b.setTag(e);
                    bkVar.b.setImageBitmap(com.baidu.tieba.d.e.a((int) R.drawable.photo));
                }
            }
            if (z) {
                bkVar.f.setVisibility(0);
            } else {
                bkVar.f.setVisibility(8);
            }
            bkVar.e.setText(aqVar.b(this.b));
            bkVar.c.setText(com.baidu.tieba.d.ad.d(new Date(aqVar.g())));
            if (this.g != 0) {
                String a2 = aqVar.h().a();
                boolean z4 = a2 == null || !a2.equals(TiebaApplication.z());
                if (a2 == null || a2.equals("0") || a2.length() == 0) {
                    z2 = true;
                    z3 = false;
                } else {
                    z3 = z4;
                    z2 = true;
                }
            } else if (this.h) {
                z2 = true;
                z3 = false;
            } else {
                z2 = false;
                z3 = false;
            }
            int ai = TiebaApplication.d().ai();
            if (z2 && z3) {
                bkVar.d.setVisibility(0);
                if (ai == 1) {
                    bkVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_manage_selector_1, 0, 0, 0);
                } else {
                    bkVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_manage_selector, 0, 0, 0);
                }
            } else if (z2) {
                bkVar.d.setVisibility(0);
                if (ai == 1) {
                    bkVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_delete_selector_1, 0, 0, 0);
                } else {
                    bkVar.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_delete_selector, 0, 0, 0);
                }
            } else {
                bkVar.d.setVisibility(8);
            }
            if (bkVar.d.getVisibility() == 0) {
                bkVar.d.setTag(R.id.tag_manage_user_identity, Integer.valueOf(this.g));
            }
            if (z2) {
                bkVar.d.setTag(R.id.tag_del_post_type, 2);
                bkVar.d.setTag(R.id.tag_del_post_id, aqVar.d());
            } else {
                bkVar.d.setTag(R.id.tag_del_post_type, 0);
                bkVar.d.setTag(R.id.tag_del_post_id, "");
            }
            if (z3) {
                bkVar.d.setTag(R.id.tag_forbid_user_name, aqVar.h().c());
            } else {
                bkVar.d.setTag(R.id.tag_forbid_user_name, "");
            }
        }
    }
}
