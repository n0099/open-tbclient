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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private static int gBv = 3;
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
            aVar.wV();
            aVar.b(this.mDataList.get(i));
        }
        return view;
    }

    /* loaded from: classes.dex */
    public static class a {
        public TextView bEo;
        public CheckBox gBw;
        public BarImageView gBx;
        private Drawable gBy;
        private Drawable gBz;
        public int mSkinType = 3;

        public a(View view) {
            if (view != null) {
                this.bEo = (TextView) view.findViewById(d.h.transmit_forum_name);
                this.gBw = (CheckBox) view.findViewById(d.h.transmit_check_box);
                this.gBx = (BarImageView) view.findViewById(d.h.forum_avatar);
            }
        }

        public void b(TransmitForumData transmitForumData) {
            if (transmitForumData != null) {
                this.bEo.setText(transmitForumData.forumName);
                this.gBw.setChecked(transmitForumData.ZM);
                this.gBx.c(transmitForumData.avatar, 10, false);
                if (transmitForumData.ZN) {
                    this.gBw.setButtonDrawable(this.gBy);
                } else {
                    this.gBw.setButtonDrawable(this.gBz);
                }
            }
        }

        public void wV() {
            if (b.gBv != this.mSkinType) {
                ai.i(this.bEo, d.e.cp_cont_b);
                this.gBy = ai.getDrawable(d.g.icon_list_confirm_d);
                this.gBz = ai.getDrawable(d.g.transmit_check_box);
            }
            this.mSkinType = b.gBv;
        }
    }

    public void Z(List<TransmitForumData> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void un(int i) {
        if (gBv != i) {
            notifyDataSetChanged();
        }
        gBv = i;
    }
}
