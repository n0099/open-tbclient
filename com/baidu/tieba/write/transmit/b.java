package com.baidu.tieba.write.transmit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private static int fDU = 3;
    private Context mContext;
    private List<TransmitForumData> mDataList = new ArrayList();

    public b(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDataList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar = null;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(e.h.layout_select_forum_item, (ViewGroup) null);
            a aVar2 = new a(view);
            view.setTag(e.g.key_select_forum_holder, aVar2);
            aVar = aVar2;
        } else {
            Object tag = view.getTag(e.g.key_select_forum_holder);
            if (tag instanceof a) {
                aVar = (a) tag;
            }
        }
        if (aVar != null) {
            aVar.Ef();
            aVar.a(this.mDataList.get(i));
        }
        return view;
    }

    /* loaded from: classes3.dex */
    public static class a {
        public TextView aGk;
        public BarImageView fDW;
        public View hNC;
        public int mSkinType = 3;

        public a(View view) {
            if (view != null) {
                this.aGk = (TextView) view.findViewById(e.g.transmit_forum_name);
                this.fDW = (BarImageView) view.findViewById(e.g.forum_avatar);
                this.hNC = view.findViewById(e.g.divider_line);
            }
        }

        public void a(TransmitForumData transmitForumData) {
            if (transmitForumData != null) {
                this.aGk.setText(transmitForumData.forumName);
                this.fDW.startLoad(transmitForumData.avatar, 10, false);
            }
        }

        public void Ef() {
            if (b.fDU != this.mSkinType) {
                al.h(this.aGk, e.d.cp_cont_b);
                al.j(this.hNC, e.d.cp_bg_line_c);
            }
            this.mSkinType = b.fDU;
        }
    }

    public void cR(List<TransmitForumData> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        if (fDU != i) {
            notifyDataSetChanged();
        }
        fDU = i;
    }
}
