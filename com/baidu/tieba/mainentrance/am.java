package com.baidu.tieba.mainentrance;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.mainentrance.BarSuggestModel;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class am extends BaseAdapter {
    private final String aCN;
    private final boolean bsl = true;
    private ArrayList<BarSuggestModel.Forum> btf;
    private final BaseActivity<?> mActivity;

    public am(BaseActivity<?> baseActivity, ArrayList<BarSuggestModel.Forum> arrayList) {
        this.mActivity = baseActivity;
        this.aCN = baseActivity.getPageContext().getPageActivity().getText(com.baidu.tieba.z.forum).toString();
        this.btf = arrayList;
    }

    public void G(ArrayList<BarSuggestModel.Forum> arrayList) {
        this.btf = arrayList;
        if (this.btf != null) {
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.btf == null) {
            return 0;
        }
        return this.btf.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gO */
    public BarSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.btf.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        an anVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.ei().inflate(this.mActivity.getPageContext().getPageActivity(), com.baidu.tieba.x.square_dialog_search_item, null);
            an anVar2 = new an(this, null);
            anVar2.aAk = (BarImageView) view.findViewById(com.baidu.tieba.w.forum_avatar);
            anVar2.aAk.setGifIconSupport(false);
            anVar2.aAk.setSupportNoImage(false);
            anVar2.aQw = (TextView) view.findViewById(com.baidu.tieba.w.name);
            anVar2.aAo = (TextView) view.findViewById(com.baidu.tieba.w.member_count);
            anVar2.aAp = (TextView) view.findViewById(com.baidu.tieba.w.thread_count);
            anVar2.aAq = (TextView) view.findViewById(com.baidu.tieba.w.slogan);
            view.setTag(anVar2);
            anVar = anVar2;
        } else {
            anVar = (an) view.getTag();
        }
        BarSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.m255getInst().getSkinType();
            String str = item.avatar;
            anVar.aAk.setTag(str);
            anVar.aAk.d(str, 10, false);
            anVar.aAk.invalidate();
            if (this.bsl) {
                anVar.aQw.setText(item.forum_name.concat(this.aCN));
            } else {
                anVar.aQw.setText(item.forum_name);
            }
            anVar.aAk.setTag(item.avatar);
            anVar.aAo.setText(String.valueOf(this.mActivity.getPageContext().getString(com.baidu.tieba.z.forum_list_attention_tv)) + " " + eF(item.member_num));
            anVar.aAp.setText(String.valueOf(this.mActivity.getPageContext().getString(com.baidu.tieba.z.forum_list_thread_tv)) + " " + eF(item.thread_num));
            anVar.aAq.setText(item.slogan);
            this.mActivity.getLayoutMode().ab(skinType == 1);
            this.mActivity.getLayoutMode().h(view);
        }
        return view;
    }

    public String eF(int i) {
        if (i >= 100000) {
            return String.valueOf(String.valueOf(i / TbConfig.BIG_IMAGE_MIN_CAPACITY)) + this.mActivity.getPageContext().getString(com.baidu.tieba.z.member_count_unit);
        }
        return String.valueOf(i);
    }
}
