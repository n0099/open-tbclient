package com.baidu.tieba.write.transmit;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private static int euG = 3;
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
            view = LayoutInflater.from(this.mContext).inflate(d.j.layout_select_forum_item, (ViewGroup) null);
            a aVar2 = new a(view);
            view.setTag(d.h.key_select_forum_holder, aVar2);
            aVar = aVar2;
        } else {
            Object tag = view.getTag(d.h.key_select_forum_holder);
            if (tag instanceof a) {
                aVar = (a) tag;
            }
        }
        if (aVar != null) {
            aVar.wB();
            aVar.b(this.mDataList.get(i));
        }
        return view;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public TextView bKm;
        public CheckBox euH;
        public BarImageView euI;
        private Drawable euJ;
        private Drawable gIX;
        public int mSkinType = 3;

        public a(View view) {
            if (view != null) {
                this.bKm = (TextView) view.findViewById(d.h.transmit_forum_name);
                this.euH = (CheckBox) view.findViewById(d.h.transmit_check_box);
                this.euI = (BarImageView) view.findViewById(d.h.forum_avatar);
            }
        }

        public void b(TransmitForumData transmitForumData) {
            if (transmitForumData != null) {
                this.bKm.setText(transmitForumData.forumName);
                this.euH.setChecked(transmitForumData.checked);
                this.euI.c(transmitForumData.avatar, 10, false);
                if (transmitForumData.aaq) {
                    this.euH.setButtonDrawable(this.gIX);
                } else {
                    this.euH.setButtonDrawable(this.euJ);
                }
            }
        }

        public void wB() {
            if (b.euG != this.mSkinType) {
                aj.i(this.bKm, d.e.cp_cont_b);
                this.gIX = aj.getDrawable(d.g.icon_list_confirm_d);
                this.euJ = aj.getDrawable(d.g.transmit_check_box);
            }
            this.mSkinType = b.euG;
        }
    }

    public void Z(List<TransmitForumData> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void oQ(int i) {
        if (euG != i) {
            notifyDataSetChanged();
        }
        euG = i;
    }
}
