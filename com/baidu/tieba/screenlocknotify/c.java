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
    private List<d> gNm = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gNm != null) {
            return this.gNm.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tN */
    public d getItem(int i) {
        if (this.gNm == null || i >= this.gNm.size()) {
            return null;
        }
        return this.gNm.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.gNm.get(i), view, viewGroup);
    }

    public View a(d dVar, View view, ViewGroup viewGroup) {
        View inflate;
        a bO;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            bO = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(e.h.screenlock_show_item_view_4, viewGroup, false);
            bO = bO(inflate);
            inflate.setTag(bO);
        }
        if (dVar == null) {
            return inflate;
        }
        bO.gNn.setText(dVar.title);
        bO.gNo.setText(dVar.content);
        bO.gNp.setDefaultErrorResource(e.f.screen_notify_default_bg);
        bO.gNp.setDefaultResource(e.f.screen_notify_default_bg);
        bO.gNp.startLoad(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void dz(List<d> list) {
        if (list != null && list.size() != 0) {
            this.gNm.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView gNn;
        TextView gNo;
        TbImageView gNp;
        View mLine;

        private a() {
        }
    }

    private a bO(View view) {
        a aVar = new a();
        aVar.gNn = (TextView) view.findViewById(e.g.push_msg_title);
        aVar.gNo = (TextView) view.findViewById(e.g.push_msg_content);
        aVar.gNp = (TbImageView) view.findViewById(e.g.push_msg_pic);
        aVar.gNp.setAutoChangeStyle(false);
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
