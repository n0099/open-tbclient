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
/* loaded from: classes15.dex */
public class c extends BaseAdapter {
    private Context mContext;
    private boolean mHasMore = true;
    private List<d> luV = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.luV != null) {
            return this.luV.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Eg */
    public d getItem(int i) {
        if (this.luV == null || i >= this.luV.size()) {
            return null;
        }
        return this.luV.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.luV.get(i), view, viewGroup);
    }

    public View a(d dVar, View view, ViewGroup viewGroup) {
        View inflate;
        a dg;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            dg = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(R.layout.screenlock_show_item_view_4, viewGroup, false);
            dg = dg(inflate);
            inflate.setTag(dg);
        }
        if (dVar == null) {
            return inflate;
        }
        dg.luW.setText(dVar.title);
        dg.luX.setText(dVar.content);
        dg.luY.setDefaultErrorResource(R.drawable.screen_notify_default_bg);
        dg.luY.setDefaultResource(R.drawable.screen_notify_default_bg);
        dg.luY.a(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void eT(List<d> list) {
        if (list != null && list.size() != 0) {
            this.luV.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a {
        TextView luW;
        TextView luX;
        TbImageView luY;
        View mLine;

        private a() {
        }
    }

    private a dg(View view) {
        a aVar = new a();
        aVar.luW = (TextView) view.findViewById(R.id.push_msg_title);
        aVar.luX = (TextView) view.findViewById(R.id.push_msg_content);
        aVar.luY = (TbImageView) view.findViewById(R.id.push_msg_pic);
        aVar.luY.setAutoChangeStyle(false);
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
