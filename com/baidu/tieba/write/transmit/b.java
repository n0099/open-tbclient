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
    private static int eCB = 3;
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
            aVar.wB();
            aVar.b(this.mDataList.get(i));
        }
        return view;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public TextView bRG;
        public CheckBox eCC;
        public BarImageView eCD;
        private Drawable eCE;
        private Drawable gSG;
        public int mSkinType = 3;

        public a(View view) {
            if (view != null) {
                this.bRG = (TextView) view.findViewById(d.g.transmit_forum_name);
                this.eCC = (CheckBox) view.findViewById(d.g.transmit_check_box);
                this.eCD = (BarImageView) view.findViewById(d.g.forum_avatar);
            }
        }

        public void b(TransmitForumData transmitForumData) {
            if (transmitForumData != null) {
                this.bRG.setText(transmitForumData.forumName);
                this.eCC.setChecked(transmitForumData.checked);
                this.eCD.startLoad(transmitForumData.avatar, 10, false);
                if (transmitForumData.aaB) {
                    this.eCC.setButtonDrawable(this.gSG);
                } else {
                    this.eCC.setButtonDrawable(this.eCE);
                }
            }
        }

        public void wB() {
            if (b.eCB != this.mSkinType) {
                aj.i(this.bRG, d.C0080d.cp_cont_b);
                this.gSG = aj.getDrawable(d.f.icon_list_confirm_d);
                this.eCE = aj.getDrawable(d.f.transmit_check_box);
            }
            this.mSkinType = b.eCB;
        }
    }

    public void Z(List<TransmitForumData> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void pj(int i) {
        if (eCB != i) {
            notifyDataSetChanged();
        }
        eCB = i;
    }
}
