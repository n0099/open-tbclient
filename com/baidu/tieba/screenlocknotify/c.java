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
    private List<d> mXv = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mXv != null) {
            return this.mXv.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: JC */
    public d getItem(int i) {
        if (this.mXv == null || i >= this.mXv.size()) {
            return null;
        }
        return this.mXv.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.mXv.get(i), view, viewGroup);
    }

    public View a(d dVar, View view, ViewGroup viewGroup) {
        View inflate;
        a eh;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            eh = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(R.layout.screenlock_show_item_view_4, viewGroup, false);
            eh = eh(inflate);
            inflate.setTag(eh);
        }
        if (dVar == null) {
            return inflate;
        }
        eh.mXw.setText(dVar.title);
        eh.mXx.setText(dVar.content);
        eh.mXy.setDefaultResource(R.drawable.screen_notify_default_bg);
        eh.mXy.a(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void fR(List<d> list) {
        if (list != null && list.size() != 0) {
            this.mXv.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        View mLine;
        TextView mXw;
        TextView mXx;
        TbImageView mXy;

        private a() {
        }
    }

    private a eh(View view) {
        a aVar = new a();
        aVar.mXw = (TextView) view.findViewById(R.id.push_msg_title);
        aVar.mXx = (TextView) view.findViewById(R.id.push_msg_content);
        aVar.mXy = (TbImageView) view.findViewById(R.id.push_msg_pic);
        aVar.mXy.setAutoChangeStyle(false);
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
