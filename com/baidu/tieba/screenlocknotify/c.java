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
    private List<d> lVp = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lVp != null) {
            return this.lVp.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: He */
    public d getItem(int i) {
        if (this.lVp == null || i >= this.lVp.size()) {
            return null;
        }
        return this.lVp.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.lVp.get(i), view, viewGroup);
    }

    public View a(d dVar, View view, ViewGroup viewGroup) {
        View inflate;
        a ds;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            ds = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(R.layout.screenlock_show_item_view_4, viewGroup, false);
            ds = ds(inflate);
            inflate.setTag(ds);
        }
        if (dVar == null) {
            return inflate;
        }
        ds.lVq.setText(dVar.title);
        ds.lVr.setText(dVar.content);
        ds.lVs.setDefaultErrorResource(R.drawable.screen_notify_default_bg);
        ds.lVs.setDefaultResource(R.drawable.screen_notify_default_bg);
        ds.lVs.a(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void fj(List<d> list) {
        if (list != null && list.size() != 0) {
            this.lVp.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class a {
        TextView lVq;
        TextView lVr;
        TbImageView lVs;
        View mLine;

        private a() {
        }
    }

    private a ds(View view) {
        a aVar = new a();
        aVar.lVq = (TextView) view.findViewById(R.id.push_msg_title);
        aVar.lVr = (TextView) view.findViewById(R.id.push_msg_content);
        aVar.lVs = (TbImageView) view.findViewById(R.id.push_msg_pic);
        aVar.lVs.setAutoChangeStyle(false);
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
