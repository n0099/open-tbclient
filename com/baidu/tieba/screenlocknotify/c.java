package com.baidu.tieba.screenlocknotify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {
    private Context mContext;
    private boolean mHasMore = true;
    private List<d> gYc = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gYc != null) {
            return this.gYc.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ux */
    public d getItem(int i) {
        if (this.gYc == null || i >= this.gYc.size()) {
            return null;
        }
        return this.gYc.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.gYc.get(i), view, viewGroup);
    }

    public View a(d dVar, View view, ViewGroup viewGroup) {
        View inflate;
        a bR;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            bR = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(e.h.screenlock_show_item_view_4, viewGroup, false);
            bR = bR(inflate);
            inflate.setTag(bR);
        }
        if (dVar == null) {
            return inflate;
        }
        bR.gYd.setText(dVar.title);
        bR.gYe.setText(dVar.content);
        bR.gYf.setDefaultErrorResource(e.f.screen_notify_default_bg);
        bR.gYf.setDefaultResource(e.f.screen_notify_default_bg);
        bR.gYf.startLoad(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void dF(List<d> list) {
        if (list != null && list.size() != 0) {
            this.gYc.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView gYd;
        TextView gYe;
        TbImageView gYf;
        View mLine;

        private a() {
        }
    }

    private a bR(View view) {
        a aVar = new a();
        aVar.gYd = (TextView) view.findViewById(e.g.push_msg_title);
        aVar.gYe = (TextView) view.findViewById(e.g.push_msg_content);
        aVar.gYf = (TbImageView) view.findViewById(e.g.push_msg_pic);
        aVar.gYf.setAutoChangeStyle(false);
        aVar.mLine = view.findViewById(e.g.line);
        return aVar;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
