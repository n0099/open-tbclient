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
    private final String b;
    private final boolean c = true;
    private ArrayList<BarSuggestModel.Forum> d;

    public ad(BaseActivity baseActivity, ArrayList<BarSuggestModel.Forum> arrayList) {
        this.a = baseActivity;
        this.b = baseActivity.getText(com.baidu.tieba.y.forum).toString();
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
        ae aeVar;
        BarSuggestModel.Forum item;
        try {
            if (view == null) {
                view = LayoutInflater.from(this.a).inflate(com.baidu.tieba.w.square_dialog_search_item, (ViewGroup) null);
                aeVar = new ae(this, null);
                aeVar.b = (HeadImageView) view.findViewById(com.baidu.tieba.v.forum_avatar);
                aeVar.b.setGifIconSupport(false);
                aeVar.a = (TextView) view.findViewById(com.baidu.tieba.v.name);
                aeVar.c = (TextView) view.findViewById(com.baidu.tieba.v.member_count);
                aeVar.d = (TextView) view.findViewById(com.baidu.tieba.v.thread_count);
                aeVar.e = (TextView) view.findViewById(com.baidu.tieba.v.slogan);
                view.setTag(aeVar);
                view2 = view;
            } else {
                aeVar = (ae) view.getTag();
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
            aeVar.b.setTag(str);
            aeVar.b.a(str, 10, false);
            aeVar.b.invalidate();
            if (this.c) {
                aeVar.a.setText(item.forum_name.concat(this.b));
            } else {
                aeVar.a.setText(item.forum_name);
            }
            aeVar.b.setTag(item.avatar);
            aeVar.c.setText(String.valueOf(this.a.getString(com.baidu.tieba.y.forum_list_attention_tv)) + " " + b(item.member_num));
            aeVar.d.setText(String.valueOf(this.a.getString(com.baidu.tieba.y.forum_list_thread_tv)) + " " + b(item.thread_num));
            aeVar.e.setText(item.slogan);
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
