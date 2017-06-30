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
    private List<s> fwy = new ArrayList();

    public q(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fwy != null) {
            return this.fwy.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: rL */
    public s getItem(int i) {
        if (this.fwy == null || i >= this.fwy.size()) {
            return null;
        }
        return this.fwy.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.fwy.get(i), view, viewGroup);
    }

    public View a(s sVar, View view, ViewGroup viewGroup) {
        View inflate;
        a bo;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            bo = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(w.j.screenlock_show_item_view_4, viewGroup, false);
            bo = bo(inflate);
            inflate.setTag(bo);
        }
        if (sVar == null) {
            return inflate;
        }
        bo.fwz.setText(sVar.title);
        bo.fwA.setText(sVar.content);
        bo.fwB.setDefaultErrorResource(w.g.screen_notify_default_bg);
        bo.fwB.setDefaultResource(w.g.screen_notify_default_bg);
        bo.fwB.a(sVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void cK(List<s> list) {
        if (list != null && list.size() != 0) {
            this.fwy.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        View asD;
        TextView fwA;
        TbImageView fwB;
        TextView fwz;

        private a() {
        }

        /* synthetic */ a(q qVar, a aVar) {
            this();
        }
    }

    private a bo(View view) {
        a aVar = new a(this, null);
        aVar.fwz = (TextView) view.findViewById(w.h.push_msg_title);
        aVar.fwA = (TextView) view.findViewById(w.h.push_msg_content);
        aVar.fwB = (TbImageView) view.findViewById(w.h.push_msg_pic);
        aVar.fwB.setAutoChangeStyle(false);
        aVar.asD = view.findViewById(w.h.line);
        return aVar;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
