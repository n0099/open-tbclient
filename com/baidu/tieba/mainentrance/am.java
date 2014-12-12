package com.baidu.tieba.mainentrance;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.mainentrance.BarSuggestModel;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class am extends BaseAdapter {
    private final String aBP;
    private final boolean bqO = true;
    private ArrayList<BarSuggestModel.Forum> brK;
    private final BaseActivity<?> mActivity;

    public am(BaseActivity<?> baseActivity, ArrayList<BarSuggestModel.Forum> arrayList) {
        this.mActivity = baseActivity;
        this.aBP = baseActivity.getPageContext().getPageActivity().getText(com.baidu.tieba.z.forum).toString();
        this.brK = arrayList;
    }

    public void F(ArrayList<BarSuggestModel.Forum> arrayList) {
        this.brK = arrayList;
        if (this.brK != null) {
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.brK == null) {
            return 0;
        }
        return this.brK.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gF */
    public BarSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.brK.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception e;
        View view2;
        an anVar;
        BarSuggestModel.Forum item;
        try {
            if (view == null) {
                view = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity.getPageContext().getPageActivity(), com.baidu.tieba.x.square_dialog_search_item, null);
                anVar = new an(this, null);
                anVar.azm = (BarImageView) view.findViewById(com.baidu.tieba.w.forum_avatar);
                anVar.azm.setGifIconSupport(false);
                anVar.azm.setSupportNoImage(false);
                anVar.aPs = (TextView) view.findViewById(com.baidu.tieba.w.name);
                anVar.azq = (TextView) view.findViewById(com.baidu.tieba.w.member_count);
                anVar.azr = (TextView) view.findViewById(com.baidu.tieba.w.thread_count);
                anVar.azs = (TextView) view.findViewById(com.baidu.tieba.w.slogan);
                view.setTag(anVar);
                view2 = view;
            } else {
                anVar = (an) view.getTag();
                view2 = view;
            }
            try {
                item = getItem(i);
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                applyNightMode(view2);
                return view2;
            }
        } catch (Exception e3) {
            e = e3;
            view2 = view;
        }
        if (item != null) {
            this.mActivity.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
            this.mActivity.getLayoutMode().h(view2);
            String str = item.avatar;
            anVar.azm.setTag(str);
            anVar.azm.d(str, 10, false);
            anVar.azm.invalidate();
            if (this.bqO) {
                anVar.aPs.setText(item.forum_name.concat(this.aBP));
            } else {
                anVar.aPs.setText(item.forum_name);
            }
            anVar.azm.setTag(item.avatar);
            anVar.azq.setText(String.valueOf(this.mActivity.getPageContext().getString(com.baidu.tieba.z.forum_list_attention_tv)) + " " + ez(item.member_num));
            anVar.azr.setText(String.valueOf(this.mActivity.getPageContext().getString(com.baidu.tieba.z.forum_list_thread_tv)) + " " + ez(item.thread_num));
            anVar.azs.setText(item.slogan);
            applyNightMode(view2);
        }
        return view2;
    }

    private void applyNightMode(View view) {
        this.mActivity.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        this.mActivity.getLayoutMode().h(view);
    }

    public String ez(int i) {
        if (i >= 100000) {
            return String.valueOf(String.valueOf(i / TbConfig.BIG_IMAGE_MIN_CAPACITY)) + this.mActivity.getPageContext().getString(com.baidu.tieba.z.member_count_unit);
        }
        return String.valueOf(i);
    }
}
