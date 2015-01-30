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
    private final String aCQ;
    private final boolean bsm = true;
    private ArrayList<BarSuggestModel.Forum> btg;
    private final BaseActivity<?> mActivity;

    public am(BaseActivity<?> baseActivity, ArrayList<BarSuggestModel.Forum> arrayList) {
        this.mActivity = baseActivity;
        this.aCQ = baseActivity.getPageContext().getPageActivity().getText(com.baidu.tieba.z.forum).toString();
        this.btg = arrayList;
    }

    public void G(ArrayList<BarSuggestModel.Forum> arrayList) {
        this.btg = arrayList;
        if (this.btg != null) {
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.btg == null) {
            return 0;
        }
        return this.btg.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gO */
    public BarSuggestModel.Forum getItem(int i) {
        int count = getCount();
        if (count <= 0 || i >= count) {
            return null;
        }
        return this.btg.get(i);
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
            anVar2.aAn = (BarImageView) view.findViewById(com.baidu.tieba.w.forum_avatar);
            anVar2.aAn.setGifIconSupport(false);
            anVar2.aAn.setSupportNoImage(false);
            anVar2.aQx = (TextView) view.findViewById(com.baidu.tieba.w.name);
            anVar2.aAr = (TextView) view.findViewById(com.baidu.tieba.w.member_count);
            anVar2.aAs = (TextView) view.findViewById(com.baidu.tieba.w.thread_count);
            anVar2.aAt = (TextView) view.findViewById(com.baidu.tieba.w.slogan);
            view.setTag(anVar2);
            anVar = anVar2;
        } else {
            anVar = (an) view.getTag();
        }
        BarSuggestModel.Forum item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.m255getInst().getSkinType();
            String str = item.avatar;
            anVar.aAn.setTag(str);
            anVar.aAn.d(str, 10, false);
            anVar.aAn.invalidate();
            if (this.bsm) {
                anVar.aQx.setText(item.forum_name.concat(this.aCQ));
            } else {
                anVar.aQx.setText(item.forum_name);
            }
            anVar.aAn.setTag(item.avatar);
            anVar.aAr.setText(String.valueOf(this.mActivity.getPageContext().getString(com.baidu.tieba.z.forum_list_attention_tv)) + " " + eF(item.member_num));
            anVar.aAs.setText(String.valueOf(this.mActivity.getPageContext().getString(com.baidu.tieba.z.forum_list_thread_tv)) + " " + eF(item.thread_num));
            anVar.aAt.setText(item.slogan);
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
