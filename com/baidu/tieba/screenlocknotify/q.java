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
    private List<s> fmk = new ArrayList();

    public q(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fmk != null) {
            return this.fmk.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: rs */
    public s getItem(int i) {
        if (this.fmk == null || i >= this.fmk.size()) {
            return null;
        }
        return this.fmk.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.fmk.get(i), view, viewGroup);
    }

    public View a(s sVar, View view, ViewGroup viewGroup) {
        View inflate;
        a bm;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            bm = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(w.j.screenlock_show_item_view_4, viewGroup, false);
            bm = bm(inflate);
            inflate.setTag(bm);
        }
        if (sVar == null) {
            return inflate;
        }
        bm.fml.setText(sVar.title);
        bm.fmm.setText(sVar.content);
        bm.fmn.setDefaultErrorResource(w.g.screen_notify_default_bg);
        bm.fmn.setDefaultResource(w.g.screen_notify_default_bg);
        bm.fmn.a(sVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void cv(List<s> list) {
        if (list != null && list.size() != 0) {
            this.fmk.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        View arA;
        TextView fml;
        TextView fmm;
        TbImageView fmn;

        private a() {
        }

        /* synthetic */ a(q qVar, a aVar) {
            this();
        }
    }

    private a bm(View view) {
        a aVar = new a(this, null);
        aVar.fml = (TextView) view.findViewById(w.h.push_msg_title);
        aVar.fmm = (TextView) view.findViewById(w.h.push_msg_content);
        aVar.fmn = (TbImageView) view.findViewById(w.h.push_msg_pic);
        aVar.fmn.setAutoChangeStyle(false);
        aVar.arA = view.findViewById(w.h.line);
        return aVar;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
