package com.baidu.tieba.square;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bx;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends BaseAdapter implements com.baidu.tieba.view.u {
    private final Context b;
    private ao c;
    private String d = null;
    View.OnClickListener a = new h(this);

    public g(Context context) {
        this.b = context;
    }

    public void a(ao aoVar) {
        this.c = aoVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.c == null || this.c.d().size() == 0) {
            return 0;
        }
        ArrayList<an> d = this.c.d();
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
            bx.b(view);
        }
        if (itemViewType == 0) {
            if (this.c != null) {
                ((TextView) view.findViewById(com.baidu.tieba.v.title)).setText(this.c.e());
            }
        } else if (itemViewType == 2) {
            bx.a(view);
            a(viewGroup, (i) view.getTag(), i, "all");
        } else if (itemViewType == 1) {
            bx.a(view);
            a(viewGroup, (i) view.getTag(), i, "normal");
        }
        int skinType = TbadkApplication.m252getInst().getSkinType();
        BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) this.b;
        baseFragmentActivity.c().a(skinType == 1);
        baseFragmentActivity.c().a(view);
        if (itemViewType == 0) {
            View findViewById2 = view.findViewById(com.baidu.tieba.v.post_recommend_line_up);
            View findViewById3 = view.findViewById(com.baidu.tieba.v.post_recommend_line_down);
            if (findViewById2 != null && findViewById3 != null) {
                if (skinType == 1) {
                    findViewById2.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.s.square_dividing_line_1));
                    findViewById3.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.s.square_dividing_line_1));
                } else {
                    findViewById2.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.s.square_dividing_line));
                    findViewById3.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.s.square_dividing_line));
                }
            }
        } else if (itemViewType == 1 && (findViewById = view.findViewById(com.baidu.tieba.v.bar_folder_item_bottom_line)) != null) {
            if (skinType == 1) {
                findViewById.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.s.square_dividing_line_1));
            } else {
                findViewById.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.s.square_dividing_line));
            }
        }
        return view;
    }

    private View a(int i, ViewGroup viewGroup, int i2) {
        LayoutInflater from = LayoutInflater.from(this.b);
        if (i2 == 0) {
            return from.inflate(com.baidu.tieba.w.bar_home_header, (ViewGroup) null);
        }
        if (i2 == 2) {
            View inflate = from.inflate(com.baidu.tieba.w.bar_home_all_dir_item, (ViewGroup) null);
            an anVar = new an();
            anVar.f = TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK;
            i iVar = new i();
            iVar.a = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.portrait);
            iVar.b = (TextView) inflate.findViewById(com.baidu.tieba.v.squre_name);
            iVar.c = (BestStringsFitTextView) inflate.findViewById(com.baidu.tieba.v.description);
            iVar.d = anVar;
            inflate.setOnClickListener(this.a);
            inflate.setTag(iVar);
            return inflate;
        }
        View inflate2 = from.inflate(com.baidu.tieba.w.bar_home_first_dir_item, (ViewGroup) null);
        inflate2.setOnClickListener(this.a);
        an anVar2 = new an();
        anVar2.f = "0";
        i iVar2 = new i();
        iVar2.a = (HeadImageView) inflate2.findViewById(com.baidu.tieba.v.portrait);
        iVar2.b = (TextView) inflate2.findViewById(com.baidu.tieba.v.squre_name);
        iVar2.c = (BestStringsFitTextView) inflate2.findViewById(com.baidu.tieba.v.description);
        iVar2.d = anVar2;
        inflate2.setTag(iVar2);
        return inflate2;
    }

    private void a(ViewGroup viewGroup, i iVar, int i, String str) {
        an anVar = this.c.d().get(i - 1);
        anVar.a = i - 1;
        if (anVar.f.equals(TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK) && str.equals("all")) {
            a(viewGroup, iVar, anVar);
        } else if (anVar.f.equals("0") && str.equals("normal")) {
            a(viewGroup, iVar, anVar);
        }
    }

    private void a(ViewGroup viewGroup, i iVar, an anVar) {
        iVar.d = anVar;
        iVar.b.setText(UtilHelper.getFixedText(anVar.b, 11));
        if (anVar.c != null) {
            iVar.c.setText(anVar.c);
            iVar.c.setVisibility(0);
        } else {
            iVar.c.setVisibility(8);
        }
        if (anVar.e != null) {
            iVar.a.setTag(anVar.e);
            int a = com.baidu.adp.lib.util.j.a(this.b, 45.0f);
            iVar.a.a(anVar.e, 10, a, a, false);
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

    @Override // com.baidu.tieba.view.u
    public void b() {
    }

    @Override // com.baidu.tieba.view.u
    public void a(View view, int i, int i2) {
    }
}
