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
    private List<d> gEo = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gEo != null) {
            return this.gEo.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sX */
    public d getItem(int i) {
        if (this.gEo == null || i >= this.gEo.size()) {
            return null;
        }
        return this.gEo.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.gEo.get(i), view, viewGroup);
    }

    public View a(d dVar, View view, ViewGroup viewGroup) {
        View inflate;
        a bM;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            bM = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(e.h.screenlock_show_item_view_4, viewGroup, false);
            bM = bM(inflate);
            inflate.setTag(bM);
        }
        if (dVar == null) {
            return inflate;
        }
        bM.gEp.setText(dVar.title);
        bM.gEq.setText(dVar.content);
        bM.gEr.setDefaultErrorResource(e.f.screen_notify_default_bg);
        bM.gEr.setDefaultResource(e.f.screen_notify_default_bg);
        bM.gEr.startLoad(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void dn(List<d> list) {
        if (list != null && list.size() != 0) {
            this.gEo.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView gEp;
        TextView gEq;
        TbImageView gEr;
        View mLine;

        private a() {
        }
    }

    private a bM(View view) {
        a aVar = new a();
        aVar.gEp = (TextView) view.findViewById(e.g.push_msg_title);
        aVar.gEq = (TextView) view.findViewById(e.g.push_msg_content);
        aVar.gEr = (TbImageView) view.findViewById(e.g.push_msg_pic);
        aVar.gEr.setAutoChangeStyle(false);
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
