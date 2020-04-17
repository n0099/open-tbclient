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
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private static int jif = 3;
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
            view = LayoutInflater.from(this.mContext).inflate(R.layout.layout_select_forum_item, (ViewGroup) null);
            a aVar2 = new a(view);
            view.setTag(R.id.key_select_forum_holder, aVar2);
            aVar = aVar2;
        } else {
            Object tag = view.getTag(R.id.key_select_forum_holder);
            if (tag instanceof a) {
                aVar = (a) tag;
            }
        }
        if (aVar != null) {
            aVar.aQp();
            aVar.b(this.mDataList.get(i));
        }
        return view;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public TextView dIy;
        public BarImageView jih;
        public View lBe;
        public int mSkinType = 3;

        public a(View view) {
            if (view != null) {
                this.dIy = (TextView) view.findViewById(R.id.transmit_forum_name);
                this.jih = (BarImageView) view.findViewById(R.id.forum_avatar);
                this.lBe = view.findViewById(R.id.divider_line);
            }
        }

        public void b(TransmitForumData transmitForumData) {
            if (transmitForumData != null) {
                this.dIy.setText(transmitForumData.forumName);
                this.jih.startLoad(transmitForumData.avatar, 10, false);
            }
        }

        public void aQp() {
            if (b.jif != this.mSkinType) {
                am.setViewTextColor(this.dIy, (int) R.color.cp_cont_b);
                am.setBackgroundColor(this.lBe, R.color.cp_bg_line_c);
            }
            this.mSkinType = b.jif;
        }
    }

    public void dy(List<TransmitForumData> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        if (jif != i) {
            notifyDataSetChanged();
        }
        jif = i;
    }
}
