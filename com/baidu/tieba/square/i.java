package com.baidu.tieba.square;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bp;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i extends BaseAdapter implements com.baidu.tieba.view.t {
    private final Context b;
    private as c;
    private final com.baidu.tbadk.editortool.ab d;
    private String e = null;
    View.OnClickListener a = new j(this);

    public i(Context context) {
        this.b = context;
        this.d = new com.baidu.tbadk.editortool.ab(context);
        int a = com.baidu.adp.lib.util.h.a(context, 45.0f);
        this.d.a(a, a);
    }

    public void a(as asVar) {
        this.c = asVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.c == null || this.c.d().size() == 0) {
            return 0;
        }
        ArrayList<ar> d = this.c.d();
        if (d == null || d.size() <= 0) {
            return 1;
        }
        return 1 + d.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View findViewById;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = a(i, viewGroup, itemViewType);
            bp.b(view);
        }
        if (itemViewType == 0) {
            if (this.c != null) {
                ((TextView) view.findViewById(com.baidu.tieba.r.title)).setText(this.c.e());
            }
        } else if (itemViewType == 2) {
            bp.a(view);
            a(viewGroup, (n) view.getTag(), i, "all");
        } else if (itemViewType == 1) {
            bp.a(view);
            a(viewGroup, (n) view.getTag(), i, "normal");
        }
        int skinType = TbadkApplication.m252getInst().getSkinType();
        com.baidu.tbadk.core.e eVar = (com.baidu.tbadk.core.e) this.b;
        eVar.a().a(skinType == 1);
        eVar.a().a(view);
        if (itemViewType == 0) {
            View findViewById2 = view.findViewById(com.baidu.tieba.r.post_recommend_line_up);
            View findViewById3 = view.findViewById(com.baidu.tieba.r.post_recommend_line_down);
            if (findViewById2 != null && findViewById3 != null) {
                if (skinType == 1) {
                    findViewById2.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.o.square_dividing_line_1));
                    findViewById3.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.o.square_dividing_line_1));
                } else {
                    findViewById2.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.o.square_dividing_line));
                    findViewById3.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.o.square_dividing_line));
                }
            }
        } else if (itemViewType == 1 && (findViewById = view.findViewById(com.baidu.tieba.r.bar_folder_item_bottom_line)) != null) {
            if (skinType == 1) {
                findViewById.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.o.square_dividing_line_1));
            } else {
                findViewById.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.o.square_dividing_line));
            }
        }
        return view;
    }

    private View a(int i, ViewGroup viewGroup, int i2) {
        LayoutInflater from = LayoutInflater.from(this.b);
        if (i2 == 0) {
            return from.inflate(com.baidu.tieba.s.bar_home_header, (ViewGroup) null);
        }
        if (i2 == 2) {
            View inflate = from.inflate(com.baidu.tieba.s.bar_home_all_dir_item, (ViewGroup) null);
            ar arVar = new ar();
            arVar.f = TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK;
            n nVar = new n();
            nVar.a = (HeadImageView) inflate.findViewById(com.baidu.tieba.r.portrait);
            nVar.b = (TextView) inflate.findViewById(com.baidu.tieba.r.squre_name);
            nVar.c = (BestStringsFitTextView) inflate.findViewById(com.baidu.tieba.r.description);
            nVar.d = arVar;
            inflate.setOnClickListener(this.a);
            inflate.setTag(nVar);
            return inflate;
        }
        View inflate2 = from.inflate(com.baidu.tieba.s.bar_home_first_dir_item, (ViewGroup) null);
        inflate2.setOnClickListener(this.a);
        ar arVar2 = new ar();
        arVar2.f = "0";
        n nVar2 = new n();
        nVar2.a = (HeadImageView) inflate2.findViewById(com.baidu.tieba.r.portrait);
        nVar2.b = (TextView) inflate2.findViewById(com.baidu.tieba.r.squre_name);
        nVar2.c = (BestStringsFitTextView) inflate2.findViewById(com.baidu.tieba.r.description);
        nVar2.d = arVar2;
        inflate2.setTag(nVar2);
        return inflate2;
    }

    private void a(ViewGroup viewGroup, n nVar, int i, String str) {
        ar arVar = this.c.d().get(i - 1);
        arVar.a = i - 1;
        if (arVar.f.equals(TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK) && str.equals("all")) {
            a(viewGroup, nVar, arVar);
        } else if (arVar.f.equals("0") && str.equals("normal")) {
            a(viewGroup, nVar, arVar);
        }
    }

    private void a(ViewGroup viewGroup, n nVar, ar arVar) {
        nVar.d = arVar;
        nVar.b.setText(UtilHelper.getFixedText(arVar.b, 11));
        if (arVar.c != null) {
            nVar.c.setText(arVar.c);
            nVar.c.setVisibility(0);
        } else {
            nVar.c.setVisibility(8);
        }
        if (arVar.e != null) {
            nVar.a.setTag(arVar.e);
            this.d.b(arVar.e, new k(this, viewGroup));
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == getCount() - 1) {
            return 2;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public Context a() {
        return this.b;
    }

    @Override // com.baidu.tieba.view.t
    public void b() {
        this.d.d();
    }

    @Override // com.baidu.tieba.view.t
    public void a(View view, int i, int i2) {
        while (i <= i2) {
            if (getItemViewType(i) == 1) {
                this.d.a();
                ar arVar = this.c.d().get(i - 1);
                if (arVar.e != null && this.d.d(arVar.e) == null) {
                    this.d.b(arVar.e, new m(this, view));
                }
            }
            i++;
        }
    }
}
