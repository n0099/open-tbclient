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
    private List<s> eQN = new ArrayList();

    public q(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eQN != null) {
            return this.eQN.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qq */
    public s getItem(int i) {
        if (this.eQN == null || i >= this.eQN.size()) {
            return null;
        }
        return this.eQN.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.eQN.get(i), view, viewGroup);
    }

    public View a(s sVar, View view, ViewGroup viewGroup) {
        View inflate;
        a bl;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            bl = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(r.h.screenlock_show_item_view_4, viewGroup, false);
            bl = bl(inflate);
            inflate.setTag(bl);
        }
        if (sVar == null) {
            return inflate;
        }
        bl.eQO.setText(sVar.title);
        bl.eQP.setText(sVar.content);
        bl.eQQ.setDefaultErrorResource(r.f.screen_notify_default_bg);
        bl.eQQ.setDefaultResource(r.f.screen_notify_default_bg);
        bl.eQQ.a(sVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void cQ(List<s> list) {
        if (list != null && list.size() != 0) {
            this.eQN.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        View amY;
        TextView eQO;
        TextView eQP;
        TbImageView eQQ;

        private a() {
        }

        /* synthetic */ a(q qVar, a aVar) {
            this();
        }
    }

    private a bl(View view) {
        a aVar = new a(this, null);
        aVar.eQO = (TextView) view.findViewById(r.g.push_msg_title);
        aVar.eQP = (TextView) view.findViewById(r.g.push_msg_content);
        aVar.eQQ = (TbImageView) view.findViewById(r.g.push_msg_pic);
        aVar.eQQ.setAutoChangeStyle(false);
        aVar.amY = view.findViewById(r.g.line);
        return aVar;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
