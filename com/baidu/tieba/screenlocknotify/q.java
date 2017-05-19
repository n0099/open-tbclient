package com.baidu.tieba.screenlocknotify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class q extends BaseAdapter {
    private Context mContext;
    private boolean mHasMore = true;
    private List<s> fes = new ArrayList();

    public q(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fes != null) {
            return this.fes.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qV */
    public s getItem(int i) {
        if (this.fes == null || i >= this.fes.size()) {
            return null;
        }
        return this.fes.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.fes.get(i), view, viewGroup);
    }

    public View a(s sVar, View view, ViewGroup viewGroup) {
        View inflate;
        a bh;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            bh = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(w.j.screenlock_show_item_view_4, viewGroup, false);
            bh = bh(inflate);
            inflate.setTag(bh);
        }
        if (sVar == null) {
            return inflate;
        }
        bh.fet.setText(sVar.title);
        bh.feu.setText(sVar.content);
        bh.fev.setDefaultErrorResource(w.g.screen_notify_default_bg);
        bh.fev.setDefaultResource(w.g.screen_notify_default_bg);
        bh.fev.a(sVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void cs(List<s> list) {
        if (list != null && list.size() != 0) {
            this.fes.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        View arQ;
        TextView fet;
        TextView feu;
        TbImageView fev;

        private a() {
        }

        /* synthetic */ a(q qVar, a aVar) {
            this();
        }
    }

    private a bh(View view) {
        a aVar = new a(this, null);
        aVar.fet = (TextView) view.findViewById(w.h.push_msg_title);
        aVar.feu = (TextView) view.findViewById(w.h.push_msg_content);
        aVar.fev = (TbImageView) view.findViewById(w.h.push_msg_pic);
        aVar.fev.setAutoChangeStyle(false);
        aVar.arQ = view.findViewById(w.h.line);
        return aVar;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
