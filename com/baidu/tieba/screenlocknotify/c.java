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
    private List<d> gLN = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gLN != null) {
            return this.gLN.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tu */
    public d getItem(int i) {
        if (this.gLN == null || i >= this.gLN.size()) {
            return null;
        }
        return this.gLN.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.gLN.get(i), view, viewGroup);
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
        bM.gLO.setText(dVar.title);
        bM.gLP.setText(dVar.content);
        bM.gLQ.setDefaultErrorResource(e.f.screen_notify_default_bg);
        bM.gLQ.setDefaultResource(e.f.screen_notify_default_bg);
        bM.gLQ.startLoad(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void dB(List<d> list) {
        if (list != null && list.size() != 0) {
            this.gLN.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView gLO;
        TextView gLP;
        TbImageView gLQ;
        View mLine;

        private a() {
        }
    }

    private a bM(View view) {
        a aVar = new a();
        aVar.gLO = (TextView) view.findViewById(e.g.push_msg_title);
        aVar.gLP = (TextView) view.findViewById(e.g.push_msg_content);
        aVar.gLQ = (TbImageView) view.findViewById(e.g.push_msg_pic);
        aVar.gLQ.setAutoChangeStyle(false);
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
