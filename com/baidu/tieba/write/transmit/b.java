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
    private static int eBr = 3;
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
            aVar.xc();
            aVar.b(this.mDataList.get(i));
        }
        return view;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public TextView bJT;
        public CheckBox eBs;
        public BarImageView eBt;
        private Drawable eBu;
        private Drawable gEc;
        public int mSkinType = 3;

        public a(View view) {
            if (view != null) {
                this.bJT = (TextView) view.findViewById(d.h.transmit_forum_name);
                this.eBs = (CheckBox) view.findViewById(d.h.transmit_check_box);
                this.eBt = (BarImageView) view.findViewById(d.h.forum_avatar);
            }
        }

        public void b(TransmitForumData transmitForumData) {
            if (transmitForumData != null) {
                this.bJT.setText(transmitForumData.forumName);
                this.eBs.setChecked(transmitForumData.checked);
                this.eBt.c(transmitForumData.avatar, 10, false);
                if (transmitForumData.aaq) {
                    this.eBs.setButtonDrawable(this.gEc);
                } else {
                    this.eBs.setButtonDrawable(this.eBu);
                }
            }
        }

        public void xc() {
            if (b.eBr != this.mSkinType) {
                aj.i(this.bJT, d.e.cp_cont_b);
                this.gEc = aj.getDrawable(d.g.icon_list_confirm_d);
                this.eBu = aj.getDrawable(d.g.transmit_check_box);
            }
            this.mSkinType = b.eBr;
        }
    }

    public void Z(List<TransmitForumData> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void oY(int i) {
        if (eBr != i) {
            notifyDataSetChanged();
        }
        eBr = i;
    }
}
