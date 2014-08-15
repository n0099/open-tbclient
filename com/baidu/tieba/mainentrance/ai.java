package com.baidu.tieba.mainentrance;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.model.BarSuggestModel;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ai extends BaseAdapter {
    private final BaseActivity a;
    private final String b;
    private final boolean c = true;
    private ArrayList<BarSuggestModel.Forum> d;

    public ai(BaseActivity baseActivity, ArrayList<BarSuggestModel.Forum> arrayList) {
        this.a = baseActivity;
        this.b = baseActivity.getText(com.baidu.tieba.x.forum).toString();
        this.d = arrayList;
    }

    public void a(ArrayList<BarSuggestModel.Forum> arrayList) {
        this.d = arrayList;
        if (this.d != null) {
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.d == null) {
            return 0;
        }
        return this.d.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public BarSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.d.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception e;
        View view2;
        aj ajVar;
        BarSuggestModel.Forum item;
        try {
            if (view == null) {
                view = LayoutInflater.from(this.a).inflate(com.baidu.tieba.v.square_dialog_search_item, (ViewGroup) null);
                ajVar = new aj(this, null);
                ajVar.b = (BarImageView) view.findViewById(com.baidu.tieba.u.forum_avatar);
                ajVar.b.setGifIconSupport(false);
                ajVar.a = (TextView) view.findViewById(com.baidu.tieba.u.name);
                ajVar.c = (TextView) view.findViewById(com.baidu.tieba.u.member_count);
                ajVar.d = (TextView) view.findViewById(com.baidu.tieba.u.thread_count);
                ajVar.e = (TextView) view.findViewById(com.baidu.tieba.u.slogan);
                view.setTag(ajVar);
                view2 = view;
            } else {
                ajVar = (aj) view.getTag();
                view2 = view;
            }
            try {
                item = getItem(i);
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                a(view2);
                return view2;
            }
        } catch (Exception e3) {
            e = e3;
            view2 = view;
        }
        if (item != null) {
            this.a.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
            this.a.getLayoutMode().a(view2);
            String str = item.avatar;
            ajVar.b.setTag(str);
            ajVar.b.a(str, 10, false);
            ajVar.b.invalidate();
            if (this.c) {
                ajVar.a.setText(item.forum_name.concat(this.b));
            } else {
                ajVar.a.setText(item.forum_name);
            }
            ajVar.b.setTag(item.avatar);
            ajVar.c.setText(String.valueOf(this.a.getString(com.baidu.tieba.x.forum_list_attention_tv)) + " " + b(item.member_num));
            ajVar.d.setText(String.valueOf(this.a.getString(com.baidu.tieba.x.forum_list_thread_tv)) + " " + b(item.thread_num));
            ajVar.e.setText(item.slogan);
            a(view2);
        }
        return view2;
    }

    private void a(View view) {
        this.a.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.a.getLayoutMode().a(view);
    }

    public String b(int i) {
        if (i >= 100000) {
            return String.valueOf(String.valueOf(i / TbConfig.BIG_IMAGE_MIN_CAPACITY)) + this.a.getString(com.baidu.tieba.x.member_count_unit);
        }
        return String.valueOf(i);
    }
}
