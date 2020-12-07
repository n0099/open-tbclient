package com.baidu.tieba.write.transmit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private static int ltK = 3;
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
            aVar.bvt();
            aVar.b(this.mDataList.get(i));
        }
        return view;
    }

    /* loaded from: classes3.dex */
    public static class a {
        public TextView fdz;
        public BarImageView ltM;
        public int mSkinType = 3;
        public View nYd;

        public a(View view) {
            if (view != null) {
                this.fdz = (TextView) view.findViewById(R.id.transmit_forum_name);
                this.ltM = (BarImageView) view.findViewById(R.id.forum_avatar);
                this.ltM.setShowOval(true);
                this.nYd = view.findViewById(R.id.divider_line);
            }
        }

        public void b(TransmitForumData transmitForumData) {
            if (transmitForumData != null) {
                this.fdz.setText(transmitForumData.forumName);
                this.ltM.startLoad(transmitForumData.avatar, 10, false);
            }
        }

        public void bvt() {
            if (b.ltK != this.mSkinType) {
                ap.setViewTextColor(this.fdz, R.color.CAM_X0105);
                ap.setBackgroundColor(this.nYd, R.color.CAM_X0204);
            }
            this.mSkinType = b.ltK;
        }
    }

    public void eM(List<TransmitForumData> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        if (ltK != i) {
            notifyDataSetChanged();
        }
        ltK = i;
    }
}
