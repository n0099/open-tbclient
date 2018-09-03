package com.baidu.tieba.screenlocknotify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {
    private Context mContext;
    private boolean mHasMore = true;
    private List<d> gwX = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gwX != null) {
            return this.gwX.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sz */
    public d getItem(int i) {
        if (this.gwX == null || i >= this.gwX.size()) {
            return null;
        }
        return this.gwX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.gwX.get(i), view, viewGroup);
    }

    public View a(d dVar, View view, ViewGroup viewGroup) {
        View inflate;
        a bz;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            bz = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(f.h.screenlock_show_item_view_4, viewGroup, false);
            bz = bz(inflate);
            inflate.setTag(bz);
        }
        if (dVar == null) {
            return inflate;
        }
        bz.gwY.setText(dVar.title);
        bz.gwZ.setText(dVar.content);
        bz.gxa.setDefaultErrorResource(f.C0146f.screen_notify_default_bg);
        bz.gxa.setDefaultResource(f.C0146f.screen_notify_default_bg);
        bz.gxa.startLoad(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void dm(List<d> list) {
        if (list != null && list.size() != 0) {
            this.gwX.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView gwY;
        TextView gwZ;
        TbImageView gxa;
        View mLine;

        private a() {
        }
    }

    private a bz(View view) {
        a aVar = new a();
        aVar.gwY = (TextView) view.findViewById(f.g.push_msg_title);
        aVar.gwZ = (TextView) view.findViewById(f.g.push_msg_content);
        aVar.gxa = (TbImageView) view.findViewById(f.g.push_msg_pic);
        aVar.gxa.setAutoChangeStyle(false);
        aVar.mLine = view.findViewById(f.g.line);
        return aVar;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
