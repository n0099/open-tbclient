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
/* loaded from: classes.dex */
public class q extends BaseAdapter {
    private Context mContext;
    private boolean mHasMore = true;
    private List<s> fiy = new ArrayList();

    public q(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fiy != null) {
            return this.fiy.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: rd */
    public s getItem(int i) {
        if (this.fiy == null || i >= this.fiy.size()) {
            return null;
        }
        return this.fiy.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.fiy.get(i), view, viewGroup);
    }

    public View a(s sVar, View view, ViewGroup viewGroup) {
        View inflate;
        a bl;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            bl = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(w.j.screenlock_show_item_view_4, viewGroup, false);
            bl = bl(inflate);
            inflate.setTag(bl);
        }
        if (sVar == null) {
            return inflate;
        }
        bl.fiz.setText(sVar.title);
        bl.fiA.setText(sVar.content);
        bl.fiB.setDefaultErrorResource(w.g.screen_notify_default_bg);
        bl.fiB.setDefaultResource(w.g.screen_notify_default_bg);
        bl.fiB.a(sVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void cC(List<s> list) {
        if (list != null && list.size() != 0) {
            this.fiy.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View arO;
        TextView fiA;
        TbImageView fiB;
        TextView fiz;

        private a() {
        }

        /* synthetic */ a(q qVar, a aVar) {
            this();
        }
    }

    private a bl(View view) {
        a aVar = new a(this, null);
        aVar.fiz = (TextView) view.findViewById(w.h.push_msg_title);
        aVar.fiA = (TextView) view.findViewById(w.h.push_msg_content);
        aVar.fiB = (TbImageView) view.findViewById(w.h.push_msg_pic);
        aVar.fiB.setAutoChangeStyle(false);
        aVar.arO = view.findViewById(w.h.line);
        return aVar;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
