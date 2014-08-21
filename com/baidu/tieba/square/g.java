package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bp;
import com.baidu.tbadk.core.view.BarImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends BaseAdapter implements com.baidu.tieba.view.s {
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
            bp.b(view);
        }
        if (itemViewType == 0) {
            if (this.c != null) {
                ((TextView) view.findViewById(com.baidu.tieba.u.title)).setText(this.c.e());
            }
        } else if (itemViewType == 2) {
            bp.a(view);
            a(viewGroup, (i) view.getTag(), i, "all");
        } else if (itemViewType == 1) {
            bp.a(view);
            a(viewGroup, (i) view.getTag(), i, "normal");
        }
        int skinType = TbadkApplication.m252getInst().getSkinType();
        BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) this.b;
        baseFragmentActivity.c().a(skinType == 1);
        baseFragmentActivity.c().a(view);
        if (itemViewType == 0) {
            View findViewById2 = view.findViewById(com.baidu.tieba.u.post_recommend_line_up);
            View findViewById3 = view.findViewById(com.baidu.tieba.u.post_recommend_line_down);
            if (findViewById2 != null && findViewById3 != null) {
                if (skinType == 1) {
                    findViewById2.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.r.square_dividing_line_1));
                    findViewById3.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.r.square_dividing_line_1));
                } else {
                    findViewById2.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.r.square_dividing_line));
                    findViewById3.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.r.square_dividing_line));
                }
            }
        } else if (itemViewType == 1 && (findViewById = view.findViewById(com.baidu.tieba.u.bar_folder_item_bottom_line)) != null) {
            if (skinType == 1) {
                findViewById.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.r.square_dividing_line_1));
            } else {
                findViewById.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.r.square_dividing_line));
            }
        }
        return view;
    }

    private View a(int i, ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            return com.baidu.adp.lib.e.b.a().a(this.b, com.baidu.tieba.v.bar_home_header, null);
        }
        if (i2 == 2) {
            View a = com.baidu.adp.lib.e.b.a().a(this.b, com.baidu.tieba.v.bar_home_all_dir_item, null);
            an anVar = new an();
            anVar.f = TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK;
            i iVar = new i();
            iVar.a = (BarImageView) a.findViewById(com.baidu.tieba.u.portrait);
            iVar.b = (TextView) a.findViewById(com.baidu.tieba.u.squre_name);
            iVar.c = (BestStringsFitTextView) a.findViewById(com.baidu.tieba.u.description);
            iVar.d = anVar;
            a.setOnClickListener(this.a);
            a.setTag(iVar);
            return a;
        }
        View a2 = com.baidu.adp.lib.e.b.a().a(this.b, com.baidu.tieba.v.bar_home_first_dir_item, null);
        a2.setOnClickListener(this.a);
        an anVar2 = new an();
        anVar2.f = "0";
        i iVar2 = new i();
        iVar2.a = (BarImageView) a2.findViewById(com.baidu.tieba.u.portrait);
        iVar2.b = (TextView) a2.findViewById(com.baidu.tieba.u.squre_name);
        iVar2.c = (BestStringsFitTextView) a2.findViewById(com.baidu.tieba.u.description);
        iVar2.d = anVar2;
        a2.setTag(iVar2);
        return a2;
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

    @Override // com.baidu.tieba.view.s
    public void b() {
    }

    @Override // com.baidu.tieba.view.s
    public void a(View view, int i, int i2) {
    }
}
