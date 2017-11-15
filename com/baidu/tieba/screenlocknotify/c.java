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
    private List<e> fRT = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fRT != null) {
            return this.fRT.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sI */
    public e getItem(int i) {
        if (this.fRT == null || i >= this.fRT.size()) {
            return null;
        }
        return this.fRT.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.fRT.get(i), view, viewGroup);
    }

    public View a(e eVar, View view, ViewGroup viewGroup) {
        View inflate;
        a bG;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            bG = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(d.h.screenlock_show_item_view_4, viewGroup, false);
            bG = bG(inflate);
            inflate.setTag(bG);
        }
        if (eVar == null) {
            return inflate;
        }
        bG.fRU.setText(eVar.title);
        bG.fRV.setText(eVar.content);
        bG.fRW.setDefaultErrorResource(d.f.screen_notify_default_bg);
        bG.fRW.setDefaultResource(d.f.screen_notify_default_bg);
        bG.fRW.startLoad(eVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void db(List<e> list) {
        if (list != null && list.size() != 0) {
            this.fRT.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        TextView fRU;
        TextView fRV;
        TbImageView fRW;
        View mLine;

        private a() {
        }
    }

    private a bG(View view) {
        a aVar = new a();
        aVar.fRU = (TextView) view.findViewById(d.g.push_msg_title);
        aVar.fRV = (TextView) view.findViewById(d.g.push_msg_content);
        aVar.fRW = (TbImageView) view.findViewById(d.g.push_msg_pic);
        aVar.fRW.setAutoChangeStyle(false);
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
