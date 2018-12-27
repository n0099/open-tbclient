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
    private List<d> gWX = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gWX != null) {
            return this.gWX.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uu */
    public d getItem(int i) {
        if (this.gWX == null || i >= this.gWX.size()) {
            return null;
        }
        return this.gWX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.gWX.get(i), view, viewGroup);
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
        bR.gWY.setText(dVar.title);
        bR.gWZ.setText(dVar.content);
        bR.gXa.setDefaultErrorResource(e.f.screen_notify_default_bg);
        bR.gXa.setDefaultResource(e.f.screen_notify_default_bg);
        bR.gXa.startLoad(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void dE(List<d> list) {
        if (list != null && list.size() != 0) {
            this.gWX.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView gWY;
        TextView gWZ;
        TbImageView gXa;
        View mLine;

        private a() {
        }
    }

    private a bR(View view) {
        a aVar = new a();
        aVar.gWY = (TextView) view.findViewById(e.g.push_msg_title);
        aVar.gWZ = (TextView) view.findViewById(e.g.push_msg_content);
        aVar.gXa = (TbImageView) view.findViewById(e.g.push_msg_pic);
        aVar.gXa.setAutoChangeStyle(false);
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
