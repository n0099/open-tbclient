package com.baidu.tieba.screenlocknotify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {
    private Context mContext;
    private boolean mHasMore = true;
    private List<e> gvI = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gvI != null) {
            return this.gvI.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sB */
    public e getItem(int i) {
        if (this.gvI == null || i >= this.gvI.size()) {
            return null;
        }
        return this.gvI.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.gvI.get(i), view, viewGroup);
    }

    public View a(e eVar, View view, ViewGroup viewGroup) {
        View inflate;
        a bw;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            bw = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(d.i.screenlock_show_item_view_4, viewGroup, false);
            bw = bw(inflate);
            inflate.setTag(bw);
        }
        if (eVar == null) {
            return inflate;
        }
        bw.gvJ.setText(eVar.title);
        bw.gvK.setText(eVar.content);
        bw.gvL.setDefaultErrorResource(d.f.screen_notify_default_bg);
        bw.gvL.setDefaultResource(d.f.screen_notify_default_bg);
        bw.gvL.startLoad(eVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void dq(List<e> list) {
        if (list != null && list.size() != 0) {
            this.gvI.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView gvJ;
        TextView gvK;
        TbImageView gvL;
        View mLine;

        private a() {
        }
    }

    private a bw(View view) {
        a aVar = new a();
        aVar.gvJ = (TextView) view.findViewById(d.g.push_msg_title);
        aVar.gvK = (TextView) view.findViewById(d.g.push_msg_content);
        aVar.gvL = (TbImageView) view.findViewById(d.g.push_msg_pic);
        aVar.gvL.setAutoChangeStyle(false);
        aVar.mLine = view.findViewById(d.g.line);
        return aVar;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
