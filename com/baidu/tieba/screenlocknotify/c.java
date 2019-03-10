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
    private List<d> ipT = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ipT != null) {
            return this.ipT.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ym */
    public d getItem(int i) {
        if (this.ipT == null || i >= this.ipT.size()) {
            return null;
        }
        return this.ipT.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.ipT.get(i), view, viewGroup);
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
        cE.ipU.setText(dVar.title);
        cE.ipV.setText(dVar.content);
        cE.ipW.setDefaultErrorResource(d.f.screen_notify_default_bg);
        cE.ipW.setDefaultResource(d.f.screen_notify_default_bg);
        cE.ipW.startLoad(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void dT(List<d> list) {
        if (list != null && list.size() != 0) {
            this.ipT.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView ipU;
        TextView ipV;
        TbImageView ipW;
        View mLine;

        private a() {
        }
    }

    private a cE(View view) {
        a aVar = new a();
        aVar.ipU = (TextView) view.findViewById(d.g.push_msg_title);
        aVar.ipV = (TextView) view.findViewById(d.g.push_msg_content);
        aVar.ipW = (TbImageView) view.findViewById(d.g.push_msg_pic);
        aVar.ipW.setAutoChangeStyle(false);
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
