package com.baidu.tieba.screenlocknotify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {
    private Context mContext;
    private boolean mHasMore = true;
    private List<d> ipS = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ipS != null) {
            return this.ipS.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ym */
    public d getItem(int i) {
        if (this.ipS == null || i >= this.ipS.size()) {
            return null;
        }
        return this.ipS.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.ipS.get(i), view, viewGroup);
    }

    public View a(d dVar, View view, ViewGroup viewGroup) {
        View inflate;
        a cE;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            cE = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(d.h.screenlock_show_item_view_4, viewGroup, false);
            cE = cE(inflate);
            inflate.setTag(cE);
        }
        if (dVar == null) {
            return inflate;
        }
        cE.ipT.setText(dVar.title);
        cE.ipU.setText(dVar.content);
        cE.ipV.setDefaultErrorResource(d.f.screen_notify_default_bg);
        cE.ipV.setDefaultResource(d.f.screen_notify_default_bg);
        cE.ipV.startLoad(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void dT(List<d> list) {
        if (list != null && list.size() != 0) {
            this.ipS.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView ipT;
        TextView ipU;
        TbImageView ipV;
        View mLine;

        private a() {
        }
    }

    private a cE(View view) {
        a aVar = new a();
        aVar.ipT = (TextView) view.findViewById(d.g.push_msg_title);
        aVar.ipU = (TextView) view.findViewById(d.g.push_msg_content);
        aVar.ipV = (TbImageView) view.findViewById(d.g.push_msg_pic);
        aVar.ipV.setAutoChangeStyle(false);
        aVar.mLine = view.findViewById(d.g.line);
        return aVar;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
