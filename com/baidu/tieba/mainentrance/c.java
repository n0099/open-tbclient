package com.baidu.tieba.mainentrance;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.BarImageView;
import java.util.List;
/* loaded from: classes.dex */
public class c extends BaseAdapter {
    private List<e> bBx;
    private BaseActivity<?> mActivity;

    public c(BaseActivity<?> baseActivity) {
        this.mActivity = baseActivity;
    }

    public void aM(List<e> list) {
        this.bBx = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bBx == null) {
            return 0;
        }
        return this.bBx.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: he */
    public e getItem(int i) {
        int count = getCount();
        if (i < 0 || i >= count) {
            return null;
        }
        return this.bBx.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        d dVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.hr().inflate(this.mActivity.getPageContext().getPageActivity(), com.baidu.tieba.r.square_dialog_search_item, null);
            d dVar2 = new d(this, null);
            dVar2.bAS = (BarImageView) view.findViewById(com.baidu.tieba.q.forum_avatar);
            dVar2.bAS.setGifIconSupport(false);
            dVar2.aGI = (TextView) view.findViewById(com.baidu.tieba.q.name);
            dVar2.bAT = (TextView) view.findViewById(com.baidu.tieba.q.member_count);
            dVar2.bAU = (TextView) view.findViewById(com.baidu.tieba.q.thread_count);
            view.setTag(dVar2);
            dVar = dVar2;
        } else {
            dVar = (d) view.getTag();
        }
        e item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            String Yg = item.Yg();
            dVar.bAS.setTag(Yg);
            dVar.bAS.c(Yg, 10, false);
            dVar.aGI.setText(item.getForumName());
            dVar.bAT.setText(String.valueOf(this.mActivity.getPageContext().getString(com.baidu.tieba.t.forum_list_attention_tv)) + ai(item.Yh()));
            dVar.bAU.setText(String.valueOf(this.mActivity.getPageContext().getString(com.baidu.tieba.t.forum_list_thread_tv)) + ai(item.Yi()));
            if (i == getCount() - 1) {
                view.findViewById(com.baidu.tieba.q.square_lv_search_forum_divider).setVisibility(8);
            } else {
                view.findViewById(com.baidu.tieba.q.square_lv_search_forum_divider).setVisibility(0);
            }
            this.mActivity.getLayoutMode().ab(skinType == 1);
            this.mActivity.getLayoutMode().j(view);
        }
        return view;
    }

    public String ai(long j) {
        if (j >= 100000) {
            return bb.s(j);
        }
        return String.valueOf(j);
    }
}
