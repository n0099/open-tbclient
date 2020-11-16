package com.baidu.tieba.screenlocknotify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class c extends BaseAdapter {
    private Context mContext;
    private boolean mHasMore = true;
    private List<d> mDV = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mDV != null) {
            return this.mDV.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: IR */
    public d getItem(int i) {
        if (this.mDV == null || i >= this.mDV.size()) {
            return null;
        }
        return this.mDV.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.mDV.get(i), view, viewGroup);
    }

    public View a(d dVar, View view, ViewGroup viewGroup) {
        View inflate;
        a dM;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            dM = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(R.layout.screenlock_show_item_view_4, viewGroup, false);
            dM = dM(inflate);
            inflate.setTag(dM);
        }
        if (dVar == null) {
            return inflate;
        }
        dM.mDW.setText(dVar.title);
        dM.mDX.setText(dVar.content);
        dM.mDY.setDefaultErrorResource(R.drawable.screen_notify_default_bg);
        dM.mDY.setDefaultResource(R.drawable.screen_notify_default_bg);
        dM.mDY.a(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void fD(List<d> list) {
        if (list != null && list.size() != 0) {
            this.mDV.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class a {
        TextView mDW;
        TextView mDX;
        TbImageView mDY;
        View mLine;

        private a() {
        }
    }

    private a dM(View view) {
        a aVar = new a();
        aVar.mDW = (TextView) view.findViewById(R.id.push_msg_title);
        aVar.mDX = (TextView) view.findViewById(R.id.push_msg_content);
        aVar.mDY = (TbImageView) view.findViewById(R.id.push_msg_pic);
        aVar.mDY.setAutoChangeStyle(false);
        aVar.mLine = view.findViewById(R.id.line);
        return aVar;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
