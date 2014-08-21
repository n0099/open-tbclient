package com.baidu.tieba.pb.image;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.data.an;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class x extends BaseAdapter {
    private com.baidu.tieba.data.v b;
    private Context c;
    private boolean f;
    private int j;
    private com.baidu.tieba.data.x a = null;
    private boolean d = true;
    private int e = 0;
    private int h = 0;
    private int i = 0;
    private View.OnClickListener k = null;
    private ArrayList<ProgressBar> g = new ArrayList<>();

    public x(Context context, com.baidu.tieba.data.v vVar) {
        this.b = null;
        this.c = null;
        this.j = 0;
        this.c = context;
        this.b = vVar;
        this.j = com.baidu.adp.lib.util.j.b(this.c);
    }

    public void a() {
        if (this.g != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.g.size()) {
                    try {
                        this.g.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.g.clear();
                    return;
                }
            }
        }
    }

    public boolean b() {
        if (this.a == null || !this.d) {
            return false;
        }
        return this.a.e();
    }

    public boolean c() {
        return !this.d || this.a == null || this.a.d();
    }

    public int d() {
        if (this.a == null || this.a.a() == null) {
            return 1;
        }
        return (this.a.a().size() / 10) + 1;
    }

    public com.baidu.tieba.data.v e() {
        return this.b;
    }

    public void a(com.baidu.tieba.data.x xVar) {
        this.a = xVar;
    }

    public void a(boolean z) {
        this.f = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        this.d = true;
        if (this.b == null) {
            return 0;
        }
        if (this.a == null || this.a.a() == null) {
            return 1;
        }
        if (this.a.a().size() != this.e) {
            this.e = this.a.a().size();
            notifyDataSetChanged();
            return 0;
        } else if (this.a.a().size() == 0 || this.a.c() == 0) {
            this.d = false;
            return 2;
        } else if (b()) {
            return this.a.a().size() + 2;
        } else {
            return this.a.a().size() + 1;
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.a == null || this.a.a() == null || i >= this.a.a().size()) {
            return null;
        }
        return this.a.a().get(i + 1);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int b = this.a != null ? this.a.b() : 0;
        if (i == 0) {
            return 2;
        }
        return (i == b + 1 || !this.d) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        aa aaVar;
        View view2;
        LinearLayout.LayoutParams layoutParams;
        Object obj;
        View view3;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            if (itemViewType == 0) {
                View a = com.baidu.adp.lib.e.b.a().a(this.c, com.baidu.tieba.v.image_pb_list_item, null);
                aa aaVar2 = new aa(this, null);
                aaVar2.a = (TextView) a.findViewById(com.baidu.tieba.u.image_pb_item_comment);
                aaVar2.b = (TextView) a.findViewById(com.baidu.tieba.u.image_pb_item_auther);
                aaVar2.c = (TextView) a.findViewById(com.baidu.tieba.u.image_pb_item_time);
                aaVar2.d = (LinearLayout) a.findViewById(com.baidu.tieba.u.seg);
                obj = aaVar2;
                view3 = a;
            } else if (itemViewType == 2) {
                View a2 = com.baidu.adp.lib.e.b.a().a(this.c, com.baidu.tieba.v.image_pb_list_header, null);
                aa aaVar3 = new aa(this, null);
                aaVar3.g = (LinearLayout) a2.findViewById(com.baidu.tieba.u.header);
                aaVar3.i = (TextView) a2.findViewById(com.baidu.tieba.u.image_pb_comment);
                aaVar3.j = (TextView) a2.findViewById(com.baidu.tieba.u.image_pb_author);
                aaVar3.k = (TextView) a2.findViewById(com.baidu.tieba.u.image_pb_reply_number);
                aaVar3.l = (LinearLayout) a2.findViewById(com.baidu.tieba.u.seg);
                aaVar3.h = (ImagePbImageView) a2.findViewById(com.baidu.tieba.u.image_pb_image);
                obj = aaVar3;
                view3 = a2;
            } else {
                View a3 = com.baidu.adp.lib.e.b.a().a(this.c, com.baidu.tieba.v.page_item, null);
                aa aaVar4 = new aa(this, null);
                aaVar4.e = (TextView) a3.findViewById(com.baidu.tieba.u.page_text);
                aaVar4.f = (ProgressBar) a3.findViewById(com.baidu.tieba.u.progress);
                this.g.add(aaVar4.f);
                obj = aaVar4;
                view3 = a3;
            }
            view3.setTag(obj);
            aaVar = obj;
            view2 = view3;
        } else {
            aaVar = (aa) view.getTag();
            view2 = view;
        }
        if (itemViewType == 0) {
            aaVar.a.setGravity(3);
            aaVar.a.setMovementMethod(LinkMovementMethod.getInstance());
            aaVar.a.setTextColor(this.c.getResources().getColor(com.baidu.tieba.r.reg_font_color));
            an anVar = this.a.a().get(i - 1);
            aaVar.c.setVisibility(0);
            aaVar.b.setVisibility(0);
            aaVar.b.setText(anVar.g().getUserName());
            aaVar.b.setOnClickListener(new y(this, anVar.g().getUserId(), anVar.g().getUserName()));
            aaVar.c.setText(ba.a(anVar.o_()));
            aaVar.d.removeAllViews();
            ArrayList<com.baidu.tieba.data.g> k = anVar.k();
            com.baidu.tieba.util.j jVar = new com.baidu.tieba.util.j(this.c);
            jVar.a(-13421773);
            jVar.a(aaVar.a, aaVar.d, k, false);
            aaVar.d.setVisibility(8);
            aaVar.a.setTextSize(2, 13.0f);
            b(aaVar);
        } else if (itemViewType == 1) {
            if (aaVar.f == null || aaVar.e == null) {
                return view2;
            }
            aaVar.e.setTextSize(2, 13.0f);
            if (this.f) {
                aaVar.f.setVisibility(0);
                aaVar.e.setText(com.baidu.tieba.x.data_loading_1);
                a(aaVar, true);
            } else {
                aaVar.f.setVisibility(8);
                if (!this.d) {
                    aaVar.e.setText(this.c.getString(com.baidu.tieba.x.image_pb_noreply));
                    aaVar.e.setFocusable(true);
                    aaVar.e.setTextColor(this.c.getResources().getColor(com.baidu.tieba.r.gray));
                    a(aaVar, false);
                } else {
                    aaVar.e.setText(com.baidu.tieba.x.load_more);
                    a(aaVar, true);
                }
            }
        } else if (itemViewType == 2) {
            ArrayList<com.baidu.tieba.data.g> k2 = this.b.a().k();
            com.baidu.tieba.util.j jVar2 = new com.baidu.tieba.util.j(this.c);
            aaVar.i.setMovementMethod(LinkMovementMethod.getInstance());
            jVar2.a(true);
            jVar2.a(aaVar.i, aaVar.l, k2, false);
            aaVar.i.setTextSize(2, 13.0f);
            if (aaVar.i.getText().toString().trim().length() == 0) {
                aaVar.i.setVisibility(8);
            }
            aaVar.j.setText(this.b.e());
            aaVar.j.setOnClickListener(new z(this, this.b.i(), this.b.e()));
            aaVar.h.setTag(this.b.b());
            if (this.k != null) {
                aaVar.h.setOnClickListener(this.k);
            }
            if (this.a != null) {
                a(this.a.c(), aaVar.k);
            }
            int g = this.b.g();
            int f = this.b.f();
            if (f > 0.6f * this.j) {
                aaVar.h.setIsScale(true);
                g = (g * this.j) / f;
            } else {
                aaVar.h.setIsScale(false);
            }
            if (g >= this.i) {
                aaVar.h.setScale(1);
                layoutParams = new LinearLayout.LayoutParams(this.j, this.i);
            } else if (g <= this.h) {
                aaVar.h.setScale(0);
                layoutParams = new LinearLayout.LayoutParams(this.j, this.h);
            } else {
                aaVar.h.setScale(1);
                layoutParams = new LinearLayout.LayoutParams(this.j, g);
            }
            aaVar.h.setLayoutParams(layoutParams);
            a(aaVar);
        }
        return view2;
    }

    private void a(aa aaVar) {
        try {
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                aaVar.i.setTextColor(ay.a(1));
                aaVar.k.setTextColor(ay.b(1));
                aaVar.g.setBackgroundColor(ay.d(1));
            } else {
                aaVar.i.setTextColor(-13421773);
                aaVar.k.setTextColor(-6710887);
                aaVar.g.setBackgroundColor(-1);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void b(aa aaVar) {
        try {
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                aaVar.a.setTextColor(ay.a(1));
                aaVar.c.setTextColor(ay.b(1));
            } else {
                aaVar.a.setTextColor(-13421773);
                aaVar.c.setTextColor(-6710887);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void a(aa aaVar, boolean z) {
        try {
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                if (z) {
                    aaVar.e.setTextColor(ay.a(1));
                } else {
                    aaVar.e.setTextColor(ay.c(1));
                }
            } else if (z) {
                aaVar.e.setTextColor(-13421773);
            } else {
                aaVar.e.setTextColor(this.c.getResources().getColor(com.baidu.tieba.r.gray));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void a(int i, TextView textView) {
        if (i == 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setText(String.valueOf(String.valueOf(i)) + this.c.getString(com.baidu.tieba.x.comment_number));
        textView.setVisibility(0);
    }

    public void a(int i, int i2) {
        this.h = i;
        this.i = i2;
    }

    public void a(View.OnClickListener onClickListener) {
        this.k = onClickListener;
    }
}
