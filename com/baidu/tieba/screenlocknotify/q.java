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
    private List<s> feE = new ArrayList();

    public q(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.feE != null) {
            return this.feE.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qZ */
    public s getItem(int i) {
        if (this.feE == null || i >= this.feE.size()) {
            return null;
        }
        return this.feE.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.feE.get(i), view, viewGroup);
    }

    public View a(s sVar, View view, ViewGroup viewGroup) {
        View inflate;
        a bn;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            bn = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(w.j.screenlock_show_item_view_4, viewGroup, false);
            bn = bn(inflate);
            inflate.setTag(bn);
        }
        if (sVar == null) {
            return inflate;
        }
        bn.feF.setText(sVar.title);
        bn.feG.setText(sVar.content);
        bn.feH.setDefaultErrorResource(w.g.screen_notify_default_bg);
        bn.feH.setDefaultResource(w.g.screen_notify_default_bg);
        bn.feH.a(sVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void cC(List<s> list) {
        if (list != null && list.size() != 0) {
            this.feE.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View ary;
        TextView feF;
        TextView feG;
        TbImageView feH;

        private a() {
        }

        /* synthetic */ a(q qVar, a aVar) {
            this();
        }
    }

    private a bn(View view) {
        a aVar = new a(this, null);
        aVar.feF = (TextView) view.findViewById(w.h.push_msg_title);
        aVar.feG = (TextView) view.findViewById(w.h.push_msg_content);
        aVar.feH = (TbImageView) view.findViewById(w.h.push_msg_pic);
        aVar.feH.setAutoChangeStyle(false);
        aVar.ary = view.findViewById(w.h.line);
        return aVar;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
