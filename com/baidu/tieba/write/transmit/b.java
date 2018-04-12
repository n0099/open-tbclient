package com.baidu.tieba.write.transmit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private static int eWW = 3;
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
    public View getView(int i, View view2, ViewGroup viewGroup) {
        a aVar = null;
        if (view2 == null) {
            view2 = LayoutInflater.from(this.mContext).inflate(d.i.layout_select_forum_item, (ViewGroup) null);
            a aVar2 = new a(view2);
            view2.setTag(d.g.key_select_forum_holder, aVar2);
            aVar = aVar2;
        } else {
            Object tag = view2.getTag(d.g.key_select_forum_holder);
            if (tag instanceof a) {
                aVar = (a) tag;
            }
        }
        if (aVar != null) {
            aVar.wY();
            aVar.a(this.mDataList.get(i));
        }
        return view2;
    }

    /* loaded from: classes3.dex */
    public static class a {
        public TextView apV;
        public BarImageView eWY;
        public View hdV;
        public int mSkinType = 3;

        public a(View view2) {
            if (view2 != null) {
                this.apV = (TextView) view2.findViewById(d.g.transmit_forum_name);
                this.eWY = (BarImageView) view2.findViewById(d.g.forum_avatar);
                this.hdV = view2.findViewById(d.g.divider_line);
            }
        }

        public void a(TransmitForumData transmitForumData) {
            if (transmitForumData != null) {
                this.apV.setText(transmitForumData.forumName);
                this.eWY.startLoad(transmitForumData.avatar, 10, false);
            }
        }

        public void wY() {
            if (b.eWW != this.mSkinType) {
                ak.h(this.apV, d.C0126d.cp_cont_b);
                ak.j(this.hdV, d.C0126d.cp_bg_line_c);
            }
            this.mSkinType = b.eWW;
        }
    }

    public void cr(List<TransmitForumData> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        if (eWW != i) {
            notifyDataSetChanged();
        }
        eWW = i;
    }
}
