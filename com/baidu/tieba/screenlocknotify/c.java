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
    private List<d> ipM = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ipM != null) {
            return this.ipM.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ym */
    public d getItem(int i) {
        if (this.ipM == null || i >= this.ipM.size()) {
            return null;
        }
        return this.ipM.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.ipM.get(i), view, viewGroup);
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
        cE.ipN.setText(dVar.title);
        cE.ipO.setText(dVar.content);
        cE.ipP.setDefaultErrorResource(d.f.screen_notify_default_bg);
        cE.ipP.setDefaultResource(d.f.screen_notify_default_bg);
        cE.ipP.startLoad(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void dT(List<d> list) {
        if (list != null && list.size() != 0) {
            this.ipM.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView ipN;
        TextView ipO;
        TbImageView ipP;
        View mLine;

        private a() {
        }
    }

    private a cE(View view) {
        a aVar = new a();
        aVar.ipN = (TextView) view.findViewById(d.g.push_msg_title);
        aVar.ipO = (TextView) view.findViewById(d.g.push_msg_content);
        aVar.ipP = (TbImageView) view.findViewById(d.g.push_msg_pic);
        aVar.ipP.setAutoChangeStyle(false);
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
