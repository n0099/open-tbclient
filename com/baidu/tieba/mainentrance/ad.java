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
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.model.BarSuggestModel;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ad extends BaseAdapter {
    private final BaseActivity a;
    private final com.baidu.tbadk.editortool.ab b;
    private final String c;
    private final boolean d = true;
    private ArrayList<BarSuggestModel.Forum> e;

    public ad(BaseActivity baseActivity, ArrayList<BarSuggestModel.Forum> arrayList) {
        this.a = baseActivity;
        this.c = baseActivity.getText(com.baidu.tieba.y.forum).toString();
        this.e = arrayList;
        this.b = new com.baidu.tbadk.editortool.ab(baseActivity);
    }

    public void a(ArrayList<BarSuggestModel.Forum> arrayList) {
        this.e = arrayList;
        if (this.e != null) {
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.e == null) {
            return 0;
        }
        return this.e.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
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
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception e;
        View view2;
        af afVar;
        BarSuggestModel.Forum item;
        try {
            if (view == null) {
                view = LayoutInflater.from(this.a).inflate(com.baidu.tieba.w.square_dialog_search_item, (ViewGroup) null);
                afVar = new af(this, null);
                afVar.b = (HeadImageView) view.findViewById(com.baidu.tieba.v.forum_avatar);
                afVar.b.setGifIconSupport(false);
                afVar.a = (TextView) view.findViewById(com.baidu.tieba.v.name);
                afVar.c = (TextView) view.findViewById(com.baidu.tieba.v.member_count);
                afVar.d = (TextView) view.findViewById(com.baidu.tieba.v.thread_count);
                afVar.e = (TextView) view.findViewById(com.baidu.tieba.v.slogan);
                view.setTag(afVar);
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
            BdLog.e(getClass().getName(), "", "SearchAdapter.getView error = " + e.getMessage());
            a(view2);
            return view2;
        }
        if (item != null) {
            this.a.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
            this.a.getLayoutMode().a(view2);
            String str = item.avatar;
            this.b.e(str, new ae(this, afVar.b));
            afVar.b.setTag(str);
            afVar.b.invalidate();
            if (this.d) {
                afVar.a.setText(item.forum_name.concat(this.c));
            } else {
                afVar.a.setText(item.forum_name);
            }
            afVar.b.setTag(item.avatar);
            afVar.c.setText(String.valueOf(this.a.getString(com.baidu.tieba.y.forum_list_attention_tv)) + " " + b(item.member_num));
            afVar.d.setText(String.valueOf(this.a.getString(com.baidu.tieba.y.forum_list_thread_tv)) + " " + b(item.thread_num));
            afVar.e.setText(item.slogan);
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
            return String.valueOf(String.valueOf(i / TbConfig.BIG_IMAGE_MIN_CAPACITY)) + this.a.getString(com.baidu.tieba.y.member_count_unit);
        }
        return String.valueOf(i);
    }
}
