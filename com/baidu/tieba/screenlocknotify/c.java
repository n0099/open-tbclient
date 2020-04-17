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
    private List<d> kAq = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kAq != null) {
            return this.kAq.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: BW */
    public d getItem(int i) {
        if (this.kAq == null || i >= this.kAq.size()) {
            return null;
        }
        return this.kAq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.kAq.get(i), view, viewGroup);
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
        cY.kAr.setText(dVar.title);
        cY.kAs.setText(dVar.content);
        cY.kAt.setDefaultErrorResource(R.drawable.screen_notify_default_bg);
        cY.kAt.setDefaultResource(R.drawable.screen_notify_default_bg);
        cY.kAt.a(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void eq(List<d> list) {
        if (list != null && list.size() != 0) {
            this.kAq.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        TextView kAr;
        TextView kAs;
        TbImageView kAt;
        View mLine;

        private a() {
        }
    }

    private a cY(View view) {
        a aVar = new a();
        aVar.kAr = (TextView) view.findViewById(R.id.push_msg_title);
        aVar.kAs = (TextView) view.findViewById(R.id.push_msg_content);
        aVar.kAt = (TbImageView) view.findViewById(R.id.push_msg_pic);
        aVar.kAt.setAutoChangeStyle(false);
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
