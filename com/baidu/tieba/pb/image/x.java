package com.baidu.tieba.pb.image;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.data.ai;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class x extends BaseAdapter {
    private com.baidu.tieba.data.t b;
    private Context c;
    private boolean f;
    private int j;
    private com.baidu.tieba.data.v a = null;
    private boolean d = true;
    private int e = 0;
    private int h = 0;
    private int i = 0;
    private View.OnClickListener k = null;
    private ArrayList<ProgressBar> g = new ArrayList<>();

    public x(Context context, com.baidu.tieba.data.t tVar) {
        this.b = null;
        this.c = null;
        this.j = 0;
        this.c = context;
        this.b = tVar;
        this.j = com.baidu.adp.lib.util.k.b(this.c);
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
                        BdLog.e(getClass().getName(), "releaseProgressBar", e.getMessage());
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

    public com.baidu.tieba.data.t e() {
        return this.b;
    }

    public void a(com.baidu.tieba.data.v vVar) {
        this.a = vVar;
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
            LayoutInflater from = LayoutInflater.from(this.c);
            if (itemViewType == 0) {
                View inflate = from.inflate(com.baidu.tieba.w.image_pb_list_item, (ViewGroup) null);
                aa aaVar2 = new aa(this, null);
                aaVar2.a = (TextView) inflate.findViewById(com.baidu.tieba.v.image_pb_item_comment);
                aaVar2.b = (TextView) inflate.findViewById(com.baidu.tieba.v.image_pb_item_auther);
                aaVar2.c = (TextView) inflate.findViewById(com.baidu.tieba.v.image_pb_item_time);
                aaVar2.d = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.seg);
                obj = aaVar2;
                view3 = inflate;
            } else if (itemViewType == 2) {
                View inflate2 = from.inflate(com.baidu.tieba.w.image_pb_list_header, (ViewGroup) null);
                aa aaVar3 = new aa(this, null);
                aaVar3.g = (LinearLayout) inflate2.findViewById(com.baidu.tieba.v.header);
                aaVar3.i = (TextView) inflate2.findViewById(com.baidu.tieba.v.image_pb_comment);
                aaVar3.j = (TextView) inflate2.findViewById(com.baidu.tieba.v.image_pb_author);
                aaVar3.k = (TextView) inflate2.findViewById(com.baidu.tieba.v.image_pb_reply_number);
                aaVar3.l = (LinearLayout) inflate2.findViewById(com.baidu.tieba.v.seg);
                aaVar3.h = (ImagePbImageView) inflate2.findViewById(com.baidu.tieba.v.image_pb_image);
                obj = aaVar3;
                view3 = inflate2;
            } else {
                View inflate3 = from.inflate(com.baidu.tieba.w.page_item, (ViewGroup) null);
                aa aaVar4 = new aa(this, null);
                aaVar4.e = (TextView) inflate3.findViewById(com.baidu.tieba.v.page_text);
                aaVar4.f = (ProgressBar) inflate3.findViewById(com.baidu.tieba.v.progress);
                this.g.add(aaVar4.f);
                obj = aaVar4;
                view3 = inflate3;
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
            aaVar.a.setTextColor(this.c.getResources().getColor(com.baidu.tieba.s.reg_font_color));
            ai aiVar = this.a.a().get(i - 1);
            aaVar.c.setVisibility(0);
            aaVar.b.setVisibility(0);
            aaVar.b.setText(aiVar.o().getUserName());
            aaVar.b.setOnClickListener(new y(this, aiVar.o().getUserId(), aiVar.o().getUserName()));
            aaVar.c.setText(bg.a(aiVar.n()));
            aaVar.d.removeAllViews();
            ArrayList<com.baidu.tieba.data.f> r = aiVar.r();
            com.baidu.tieba.util.j jVar = new com.baidu.tieba.util.j(this.c);
            jVar.a(-13421773);
            jVar.a(aaVar.a, aaVar.d, r, false);
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
                aaVar.e.setText(com.baidu.tieba.y.data_loading_1);
                a(aaVar, true);
            } else {
                aaVar.f.setVisibility(8);
                if (!this.d) {
                    aaVar.e.setText(this.c.getString(com.baidu.tieba.y.image_pb_noreply));
                    aaVar.e.setFocusable(true);
                    aaVar.e.setTextColor(this.c.getResources().getColor(com.baidu.tieba.s.gray));
                    a(aaVar, false);
                } else {
                    aaVar.e.setText(com.baidu.tieba.y.load_more);
                    a(aaVar, true);
                }
            }
        } else if (itemViewType == 2) {
            ArrayList<com.baidu.tieba.data.f> r2 = this.b.a().r();
            com.baidu.tieba.util.j jVar2 = new com.baidu.tieba.util.j(this.c);
            aaVar.i.setMovementMethod(LinkMovementMethod.getInstance());
            jVar2.a(true);
            jVar2.a(aaVar.i, aaVar.l, r2, false);
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
                aaVar.i.setTextColor(be.a(1));
                aaVar.k.setTextColor(be.b(1));
                aaVar.g.setBackgroundColor(be.d(1));
            } else {
                aaVar.i.setTextColor(-13421773);
                aaVar.k.setTextColor(-6710887);
                aaVar.g.setBackgroundColor(-1);
            }
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "setHeaderSkin", e.getMessage());
        }
    }

    private void b(aa aaVar) {
        try {
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                aaVar.a.setTextColor(be.a(1));
                aaVar.c.setTextColor(be.b(1));
            } else {
                aaVar.a.setTextColor(-13421773);
                aaVar.c.setTextColor(-6710887);
            }
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "setNormalSkin", e.getMessage());
        }
    }

    private void a(aa aaVar, boolean z) {
        try {
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                if (z) {
                    aaVar.e.setTextColor(be.a(1));
                } else {
                    aaVar.e.setTextColor(be.c(1));
                }
            } else if (z) {
                aaVar.e.setTextColor(-13421773);
            } else {
                aaVar.e.setTextColor(this.c.getResources().getColor(com.baidu.tieba.s.gray));
            }
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "setPageSkin", e.getMessage());
        }
    }

    private void a(int i, TextView textView) {
        if (i == 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setText(String.valueOf(String.valueOf(i)) + this.c.getString(com.baidu.tieba.y.comment_number));
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
