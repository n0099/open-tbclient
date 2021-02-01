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
/* loaded from: classes9.dex */
public class i extends BaseAdapter {
    private static int lCs = 3;
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
            aVar.bup();
            aVar.b(this.mDataList.get(i));
        }
        return view;
    }

    /* loaded from: classes9.dex */
    public static class a {
        public TextView fkQ;
        public CheckBox lCt;
        public BarImageView lCu;
        private Drawable lCv;
        public int mSkinType = 3;

        public a(View view) {
            if (view != null) {
                this.fkQ = (TextView) view.findViewById(R.id.transmit_forum_name);
                this.lCt = (CheckBox) view.findViewById(R.id.transmit_check_box);
                this.lCu = (BarImageView) view.findViewById(R.id.forum_avatar);
            }
        }

        public void b(BazhuInfoData.BaInfo baInfo) {
            if (baInfo != null) {
                this.fkQ.setText(baInfo.forum_name);
                this.lCt.setChecked(baInfo.isChecked);
                this.lCu.startLoad(baInfo.forum_Avatar, 10, false);
                this.lCt.setButtonDrawable(this.lCv);
            }
        }

        public void bup() {
            if (i.lCs != this.mSkinType) {
                ap.setViewTextColor(this.fkQ, R.color.CAM_X0105);
                this.lCv = ap.getDrawable(R.drawable.transmit_check_box);
            }
            this.mSkinType = i.lCs;
        }
    }

    public void eK(List<BazhuInfoData.BaInfo> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void Fi(int i) {
        if (lCs != i) {
            notifyDataSetChanged();
        }
        lCs = i;
    }
}
