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
/* loaded from: classes8.dex */
public class c extends BaseAdapter {
    private Context mContext;
    private boolean mHasMore = true;
    private List<d> kAu = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kAu != null) {
            return this.kAu.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: BW */
    public d getItem(int i) {
        if (this.kAu == null || i >= this.kAu.size()) {
            return null;
        }
        return this.kAu.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.kAu.get(i), view, viewGroup);
    }

    public View a(d dVar, View view, ViewGroup viewGroup) {
        View inflate;
        a cY;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            cY = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(R.layout.screenlock_show_item_view_4, viewGroup, false);
            cY = cY(inflate);
            inflate.setTag(cY);
        }
        if (dVar == null) {
            return inflate;
        }
        cY.kAv.setText(dVar.title);
        cY.kAw.setText(dVar.content);
        cY.kAx.setDefaultErrorResource(R.drawable.screen_notify_default_bg);
        cY.kAx.setDefaultResource(R.drawable.screen_notify_default_bg);
        cY.kAx.a(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void eq(List<d> list) {
        if (list != null && list.size() != 0) {
            this.kAu.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        TextView kAv;
        TextView kAw;
        TbImageView kAx;
        View mLine;

        private a() {
        }
    }

    private a cY(View view) {
        a aVar = new a();
        aVar.kAv = (TextView) view.findViewById(R.id.push_msg_title);
        aVar.kAw = (TextView) view.findViewById(R.id.push_msg_content);
        aVar.kAx = (TbImageView) view.findViewById(R.id.push_msg_pic);
        aVar.kAx.setAutoChangeStyle(false);
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
