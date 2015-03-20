package com.baidu.tieba.mainentrance;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.mainentrance.ForumSuggestModel;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private final boolean bys = true;
    private ArrayList<ForumSuggestModel.Forum> byt;
    private final BaseActivity<?> mActivity;

    public a(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.mActivity = baseActivity;
        this.byt = arrayList;
    }

    public void D(ArrayList<ForumSuggestModel.Forum> arrayList) {
        this.byt = arrayList;
        if (this.byt != null) {
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.byt == null) {
            return 0;
        }
        return this.byt.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gJ */
    public ForumSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.byt.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.hH().inflate(this.mActivity.getPageContext().getPageActivity(), com.baidu.tieba.w.square_dialog_search_item, null);
            b bVar2 = new b(this, null);
            bVar2.bxR = (BarImageView) view.findViewById(com.baidu.tieba.v.forum_avatar);
            bVar2.bxR.setGifIconSupport(false);
            bVar2.aEv = (TextView) view.findViewById(com.baidu.tieba.v.name);
            bVar2.bxS = (TextView) view.findViewById(com.baidu.tieba.v.member_count);
            bVar2.bxT = (TextView) view.findViewById(com.baidu.tieba.v.thread_count);
            bVar2.bwr = (TextView) view.findViewById(com.baidu.tieba.v.slogan);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        ForumSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            String str = item.avatar;
            bVar.bxR.setTag(str);
            bVar.bxR.c(str, 10, false);
            bVar.bxR.invalidate();
            if (this.bys) {
                bVar.aEv.setText(this.mActivity.getPageContext().getPageActivity().getString(com.baidu.tieba.y.official_msg_list_name, new Object[]{item.forum_name}));
            } else {
                bVar.aEv.setText(item.forum_name);
            }
            bVar.bxR.setTag(item.avatar);
            bVar.bxS.setText(String.valueOf(this.mActivity.getPageContext().getString(com.baidu.tieba.y.forum_list_attention_tv)) + " " + gK(item.member_num));
            bVar.bxT.setText(String.valueOf(this.mActivity.getPageContext().getString(com.baidu.tieba.y.forum_list_thread_tv)) + " " + gK(item.thread_num));
            bVar.bwr.setText(item.slogan);
            this.mActivity.getLayoutMode().X(skinType == 1);
            this.mActivity.getLayoutMode().h(view);
        }
        return view;
    }

    public String gK(int i) {
        if (i >= 100000) {
            return String.valueOf(String.valueOf(i / 10000)) + this.mActivity.getPageContext().getString(com.baidu.tieba.y.member_count_unit);
        }
        return String.valueOf(i);
    }
}
