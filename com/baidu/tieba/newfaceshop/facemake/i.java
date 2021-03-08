package com.baidu.tieba.newfaceshop.facemake;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.BazhuInfoData;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class i extends BaseAdapter {
    private static int lEI = 3;
    private Context mContext;
    private List<BazhuInfoData.BaInfo> mDataList = new ArrayList();

    public i(Context context) {
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
            view = LayoutInflater.from(this.mContext).inflate(R.layout.layout_select__single_forum_item, (ViewGroup) null);
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            Object tag = view.getTag();
            if (tag instanceof a) {
                aVar = (a) tag;
            }
        }
        if (aVar != null) {
            aVar.bus();
            aVar.b(this.mDataList.get(i));
        }
        return view;
    }

    /* loaded from: classes8.dex */
    public static class a {
        public TextView fmq;
        public CheckBox lEJ;
        public BarImageView lEK;
        private Drawable lEL;
        public int mSkinType = 3;

        public a(View view) {
            if (view != null) {
                this.fmq = (TextView) view.findViewById(R.id.transmit_forum_name);
                this.lEJ = (CheckBox) view.findViewById(R.id.transmit_check_box);
                this.lEK = (BarImageView) view.findViewById(R.id.forum_avatar);
            }
        }

        public void b(BazhuInfoData.BaInfo baInfo) {
            if (baInfo != null) {
                this.fmq.setText(baInfo.forum_name);
                this.lEJ.setChecked(baInfo.isChecked);
                this.lEK.startLoad(baInfo.forum_Avatar, 10, false);
                this.lEJ.setButtonDrawable(this.lEL);
            }
        }

        public void bus() {
            if (i.lEI != this.mSkinType) {
                ap.setViewTextColor(this.fmq, R.color.CAM_X0105);
                this.lEL = ap.getDrawable(R.drawable.transmit_check_box);
            }
            this.mSkinType = i.lEI;
        }
    }

    public void eK(List<BazhuInfoData.BaInfo> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void Fl(int i) {
        if (lEI != i) {
            notifyDataSetChanged();
        }
        lEI = i;
    }
}
