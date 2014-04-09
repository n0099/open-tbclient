package com.baidu.tieba.mainentrance;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.model.BarSuggestModel;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class ad extends BaseAdapter {
    private final com.baidu.tbadk.a a;
    private final com.baidu.tbadk.editortool.ab b;
    private final String c;
    private final boolean d = true;
    private ArrayList<BarSuggestModel.Forum> e = null;

    public ad(com.baidu.tbadk.a aVar, ArrayList<BarSuggestModel.Forum> arrayList) {
        this.a = aVar;
        this.c = aVar.getText(com.baidu.tieba.a.k.forum).toString();
        this.b = new com.baidu.tbadk.editortool.ab(aVar);
    }

    public final void a(ArrayList<BarSuggestModel.Forum> arrayList) {
        this.e = arrayList;
        if (this.e != null) {
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.e == null) {
            return 0;
        }
        return this.e.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public BarSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.e.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0158  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        Exception e;
        View view2;
        af afVar;
        BarSuggestModel.Forum item;
        try {
            if (view == null) {
                view = LayoutInflater.from(this.a).inflate(com.baidu.tieba.a.i.square_dialog_search_item, (ViewGroup) null);
                af afVar2 = new af(this, (byte) 0);
                afVar2.b = (HeadImageView) view.findViewById(com.baidu.tieba.a.h.forum_avatar);
                afVar2.b.setGifIconSupport(false);
                afVar2.a = (TextView) view.findViewById(com.baidu.tieba.a.h.name);
                afVar2.c = (TextView) view.findViewById(com.baidu.tieba.a.h.member_count);
                afVar2.d = (TextView) view.findViewById(com.baidu.tieba.a.h.thread_count);
                afVar2.e = (TextView) view.findViewById(com.baidu.tieba.a.h.slogan);
                view.setTag(afVar2);
                afVar = afVar2;
                view2 = view;
            } else {
                afVar = (af) view.getTag();
                view2 = view;
            }
        } catch (Exception e2) {
            e = e2;
            view2 = view;
        }
        try {
            item = getItem(i);
        } catch (Exception e3) {
            e = e3;
            com.baidu.adp.lib.util.f.b(getClass().getName(), "", "SearchAdapter.getView error = " + e.getMessage());
            this.a.getLayoutMode().a(TbadkApplication.j().l() == 1);
            this.a.getLayoutMode().a(view2);
            return view2;
        }
        if (item != null) {
            this.a.getLayoutMode().a(TbadkApplication.j().l() == 1);
            this.a.getLayoutMode().a(view2);
            String str = item.avatar;
            this.b.f(str, new ae(this, afVar.b));
            afVar.b.setTag(str);
            afVar.b.invalidate();
            if (this.d) {
                afVar.a.setText(item.forum_name.concat(this.c));
            } else {
                afVar.a.setText(item.forum_name);
            }
            afVar.b.setTag(item.avatar);
            afVar.c.setText(String.valueOf(this.a.getString(com.baidu.tieba.a.k.forum_list_attention_tv)) + " " + b(item.member_num));
            afVar.d.setText(String.valueOf(this.a.getString(com.baidu.tieba.a.k.forum_list_thread_tv)) + " " + b(item.thread_num));
            afVar.e.setText(item.slogan);
            this.a.getLayoutMode().a(TbadkApplication.j().l() == 1);
            this.a.getLayoutMode().a(view2);
        }
        return view2;
    }

    private String b(int i) {
        if (i >= 100000) {
            return String.valueOf(String.valueOf(i / 10000)) + this.a.getString(com.baidu.tieba.a.k.member_count_unit);
        }
        return String.valueOf(i);
    }
}
