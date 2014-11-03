package com.baidu.tieba.mainentrance;

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
public class al extends BaseAdapter {
    private final String aAx;
    private final boolean bmk = true;
    private ArrayList<BarSuggestModel.Forum> bnh;
    private final BaseActivity mActivity;

    public al(BaseActivity baseActivity, ArrayList<BarSuggestModel.Forum> arrayList) {
        this.mActivity = baseActivity;
        this.aAx = baseActivity.getText(com.baidu.tieba.y.forum).toString();
        this.bnh = arrayList;
    }

    public void y(ArrayList<BarSuggestModel.Forum> arrayList) {
        this.bnh = arrayList;
        if (this.bnh != null) {
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bnh == null) {
            return 0;
        }
        return this.bnh.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gu */
    public BarSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.bnh.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception e;
        View view2;
        am amVar;
        BarSuggestModel.Forum item;
        try {
            if (view == null) {
                view = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity, com.baidu.tieba.w.square_dialog_search_item, null);
                amVar = new am(this, null);
                amVar.awf = (BarImageView) view.findViewById(com.baidu.tieba.v.forum_avatar);
                amVar.awf.setGifIconSupport(false);
                amVar.awf.setSupportNoImage(false);
                amVar.axz = (TextView) view.findViewById(com.baidu.tieba.v.name);
                amVar.awj = (TextView) view.findViewById(com.baidu.tieba.v.member_count);
                amVar.awk = (TextView) view.findViewById(com.baidu.tieba.v.thread_count);
                amVar.awl = (TextView) view.findViewById(com.baidu.tieba.v.slogan);
                view.setTag(amVar);
                view2 = view;
            } else {
                amVar = (am) view.getTag();
                view2 = view;
            }
            try {
                item = getItem(i);
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                F(view2);
                return view2;
            }
        } catch (Exception e3) {
            e = e3;
            view2 = view;
        }
        if (item != null) {
            this.mActivity.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
            this.mActivity.getLayoutMode().h(view2);
            String str = item.avatar;
            amVar.awf.setTag(str);
            amVar.awf.c(str, 10, false);
            amVar.awf.invalidate();
            if (this.bmk) {
                amVar.axz.setText(item.forum_name.concat(this.aAx));
            } else {
                amVar.axz.setText(item.forum_name);
            }
            amVar.awf.setTag(item.avatar);
            amVar.awj.setText(String.valueOf(this.mActivity.getString(com.baidu.tieba.y.forum_list_attention_tv)) + " " + eB(item.member_num));
            amVar.awk.setText(String.valueOf(this.mActivity.getString(com.baidu.tieba.y.forum_list_thread_tv)) + " " + eB(item.thread_num));
            amVar.awl.setText(item.slogan);
            F(view2);
        }
        return view2;
    }

    private void F(View view) {
        this.mActivity.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.mActivity.getLayoutMode().h(view);
    }

    public String eB(int i) {
        if (i >= 100000) {
            return String.valueOf(String.valueOf(i / TbConfig.BIG_IMAGE_MIN_CAPACITY)) + this.mActivity.getString(com.baidu.tieba.y.member_count_unit);
        }
        return String.valueOf(i);
    }
}
