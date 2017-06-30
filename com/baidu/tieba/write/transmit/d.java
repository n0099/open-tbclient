package com.baidu.tieba.write.transmit;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d extends BaseAdapter {
    private static int ghw = 3;
    private Context mContext;
    private List<TransmitForumData> mDataList = new ArrayList();

    public d(Context context) {
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
            view = LayoutInflater.from(this.mContext).inflate(w.j.layout_select_forum_item, (ViewGroup) null);
            a aVar2 = new a(view);
            view.setTag(w.h.key_select_forum_holder, aVar2);
            aVar = aVar2;
        } else {
            Object tag = view.getTag(w.h.key_select_forum_holder);
            if (tag instanceof a) {
                aVar = (a) tag;
            }
        }
        if (aVar != null) {
            aVar.wK();
            aVar.b(this.mDataList.get(i));
        }
        return view;
    }

    /* loaded from: classes.dex */
    public static class a {
        public TextView bAh;
        private Drawable ghA;
        public CheckBox ghx;
        public BarImageView ghy;
        private Drawable ghz;
        public int mSkinType = 3;

        public a(View view) {
            if (view != null) {
                this.bAh = (TextView) view.findViewById(w.h.transmit_forum_name);
                this.ghx = (CheckBox) view.findViewById(w.h.transmit_check_box);
                this.ghy = (BarImageView) view.findViewById(w.h.forum_avatar);
            }
        }

        public void b(TransmitForumData transmitForumData) {
            if (transmitForumData != null) {
                this.bAh.setText(transmitForumData.forumName);
                this.ghx.setChecked(transmitForumData.aaP);
                this.ghy.c(transmitForumData.avatar, 10, false);
                if (transmitForumData.ghN) {
                    this.ghx.setButtonDrawable(this.ghz);
                } else {
                    this.ghx.setButtonDrawable(this.ghA);
                }
            }
        }

        public void wK() {
            if (d.ghw != this.mSkinType) {
                as.i(this.bAh, w.e.cp_cont_b);
                this.ghz = as.getDrawable(w.g.icon_list_confirm_d);
                this.ghA = as.getDrawable(w.g.transmit_check_box);
            }
            this.mSkinType = d.ghw;
        }
    }

    public void U(List<TransmitForumData> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void tL(int i) {
        if (ghw != i) {
            notifyDataSetChanged();
        }
        ghw = i;
    }
}
