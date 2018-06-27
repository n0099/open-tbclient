package com.baidu.tieba.write.transmit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private static int fnr = 3;
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
            view = LayoutInflater.from(this.mContext).inflate(d.i.layout_select_forum_item, (ViewGroup) null);
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
            aVar.AP();
            aVar.a(this.mDataList.get(i));
        }
        return view;
    }

    /* loaded from: classes3.dex */
    public static class a {
        public TextView ayV;
        public BarImageView fnt;
        public View hva;
        public int mSkinType = 3;

        public a(View view) {
            if (view != null) {
                this.ayV = (TextView) view.findViewById(d.g.transmit_forum_name);
                this.fnt = (BarImageView) view.findViewById(d.g.forum_avatar);
                this.hva = view.findViewById(d.g.divider_line);
            }
        }

        public void a(TransmitForumData transmitForumData) {
            if (transmitForumData != null) {
                this.ayV.setText(transmitForumData.forumName);
                this.fnt.startLoad(transmitForumData.avatar, 10, false);
            }
        }

        public void AP() {
            if (b.fnr != this.mSkinType) {
                am.h(this.ayV, d.C0142d.cp_cont_b);
                am.j(this.hva, d.C0142d.cp_bg_line_c);
            }
            this.mSkinType = b.fnr;
        }
    }

    public void cD(List<TransmitForumData> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        if (fnr != i) {
            notifyDataSetChanged();
        }
        fnr = i;
    }
}
