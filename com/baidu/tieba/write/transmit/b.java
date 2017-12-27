package com.baidu.tieba.write.transmit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private static int fwN = 3;
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
            view = LayoutInflater.from(this.mContext).inflate(d.h.layout_select_forum_item, (ViewGroup) null);
            a aVar2 = new a(view);
            view.setTag(d.g.key_select_forum_holder, aVar2);
            aVar = aVar2;
        } else {
            Object tag = view.getTag(d.g.key_select_forum_holder);
            if (tag instanceof a) {
                aVar = (a) tag;
            }
        }
        if (aVar != null) {
            aVar.Ea();
            aVar.a(this.mDataList.get(i));
        }
        return view;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public TextView bcI;
        public BarImageView fwP;
        public View hPG;
        public int mSkinType = 3;

        public a(View view) {
            if (view != null) {
                this.bcI = (TextView) view.findViewById(d.g.transmit_forum_name);
                this.fwP = (BarImageView) view.findViewById(d.g.forum_avatar);
                this.hPG = view.findViewById(d.g.divider_line);
            }
        }

        public void a(TransmitForumData transmitForumData) {
            if (transmitForumData != null) {
                this.bcI.setText(transmitForumData.forumName);
                this.fwP.startLoad(transmitForumData.avatar, 10, false);
            }
        }

        public void Ea() {
            if (b.fwN != this.mSkinType) {
                aj.r(this.bcI, d.C0108d.cp_cont_b);
                aj.t(this.hPG, d.C0108d.cp_bg_line_c);
            }
            this.mSkinType = b.fwN;
        }
    }

    public void aw(List<TransmitForumData> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        if (fwN != i) {
            notifyDataSetChanged();
        }
        fwN = i;
    }
}
