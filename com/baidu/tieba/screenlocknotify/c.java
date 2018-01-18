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
    private List<e> gHt = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gHt != null) {
            return this.gHt.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uF */
    public e getItem(int i) {
        if (this.gHt == null || i >= this.gHt.size()) {
            return null;
        }
        return this.gHt.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.gHt.get(i), view, viewGroup);
    }

    public View a(e eVar, View view, ViewGroup viewGroup) {
        View inflate;
        a cN;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            cN = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(d.h.screenlock_show_item_view_4, viewGroup, false);
            cN = cN(inflate);
            inflate.setTag(cN);
        }
        if (eVar == null) {
            return inflate;
        }
        cN.gHu.setText(eVar.title);
        cN.gHv.setText(eVar.content);
        cN.gHw.setDefaultErrorResource(d.f.screen_notify_default_bg);
        cN.gHw.setDefaultResource(d.f.screen_notify_default_bg);
        cN.gHw.startLoad(eVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void dg(List<e> list) {
        if (list != null && list.size() != 0) {
            this.gHt.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        TextView gHu;
        TextView gHv;
        TbImageView gHw;
        View mLine;

        private a() {
        }
    }

    private a cN(View view) {
        a aVar = new a();
        aVar.gHu = (TextView) view.findViewById(d.g.push_msg_title);
        aVar.gHv = (TextView) view.findViewById(d.g.push_msg_content);
        aVar.gHw = (TbImageView) view.findViewById(d.g.push_msg_pic);
        aVar.gHw.setAutoChangeStyle(false);
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
