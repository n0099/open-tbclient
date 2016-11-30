package com.baidu.tieba.screenlocknotify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class q extends BaseAdapter {
    private Context mContext;
    private boolean mHasMore = true;
    private List<s> fmS = new ArrayList();

    public q(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fmS != null) {
            return this.fmS.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: rp */
    public s getItem(int i) {
        if (this.fmS == null || i >= this.fmS.size()) {
            return null;
        }
        return this.fmS.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.fmS.get(i), view, viewGroup);
    }

    public View a(s sVar, View view, ViewGroup viewGroup) {
        View inflate;
        a bm;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            bm = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(r.h.screenlock_show_item_view_4, viewGroup, false);
            bm = bm(inflate);
            inflate.setTag(bm);
        }
        if (sVar == null) {
            return inflate;
        }
        bm.fmT.setText(sVar.title);
        bm.fmU.setText(sVar.content);
        bm.fmV.setDefaultErrorResource(r.f.screen_notify_default_bg);
        bm.fmV.setDefaultResource(r.f.screen_notify_default_bg);
        bm.fmV.a(sVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void da(List<s> list) {
        if (list != null && list.size() != 0) {
            this.fmS.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View anv;
        TextView fmT;
        TextView fmU;
        TbImageView fmV;

        private a() {
        }

        /* synthetic */ a(q qVar, a aVar) {
            this();
        }
    }

    private a bm(View view) {
        a aVar = new a(this, null);
        aVar.fmT = (TextView) view.findViewById(r.g.push_msg_title);
        aVar.fmU = (TextView) view.findViewById(r.g.push_msg_content);
        aVar.fmV = (TbImageView) view.findViewById(r.g.push_msg_pic);
        aVar.fmV.setAutoChangeStyle(false);
        aVar.anv = view.findViewById(r.g.line);
        return aVar;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
