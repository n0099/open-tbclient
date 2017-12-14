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
/* loaded from: classes2.dex */
public class c extends BaseAdapter {
    private Context mContext;
    private boolean mHasMore = true;
    private List<e> gef = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gef != null) {
            return this.gef.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tg */
    public e getItem(int i) {
        if (this.gef == null || i >= this.gef.size()) {
            return null;
        }
        return this.gef.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.gef.get(i), view, viewGroup);
    }

    public View a(e eVar, View view, ViewGroup viewGroup) {
        View inflate;
        a bE;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            bE = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(d.h.screenlock_show_item_view_4, viewGroup, false);
            bE = bE(inflate);
            inflate.setTag(bE);
        }
        if (eVar == null) {
            return inflate;
        }
        bE.geg.setText(eVar.title);
        bE.geh.setText(eVar.content);
        bE.gei.setDefaultErrorResource(d.f.screen_notify_default_bg);
        bE.gei.setDefaultResource(d.f.screen_notify_default_bg);
        bE.gei.startLoad(eVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void dm(List<e> list) {
        if (list != null && list.size() != 0) {
            this.gef.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        TextView geg;
        TextView geh;
        TbImageView gei;
        View mLine;

        private a() {
        }
    }

    private a bE(View view) {
        a aVar = new a();
        aVar.geg = (TextView) view.findViewById(d.g.push_msg_title);
        aVar.geh = (TextView) view.findViewById(d.g.push_msg_content);
        aVar.gei = (TbImageView) view.findViewById(d.g.push_msg_pic);
        aVar.gei.setAutoChangeStyle(false);
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
