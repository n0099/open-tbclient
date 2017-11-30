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
    private List<e> gbz = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gbz != null) {
            return this.gbz.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sV */
    public e getItem(int i) {
        if (this.gbz == null || i >= this.gbz.size()) {
            return null;
        }
        return this.gbz.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.gbz.get(i), view, viewGroup);
    }

    public View a(e eVar, View view, ViewGroup viewGroup) {
        View inflate;
        a bB;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            bB = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(d.h.screenlock_show_item_view_4, viewGroup, false);
            bB = bB(inflate);
            inflate.setTag(bB);
        }
        if (eVar == null) {
            return inflate;
        }
        bB.gbA.setText(eVar.title);
        bB.gbB.setText(eVar.content);
        bB.gbC.setDefaultErrorResource(d.f.screen_notify_default_bg);
        bB.gbC.setDefaultResource(d.f.screen_notify_default_bg);
        bB.gbC.startLoad(eVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void dn(List<e> list) {
        if (list != null && list.size() != 0) {
            this.gbz.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        TextView gbA;
        TextView gbB;
        TbImageView gbC;
        View mLine;

        private a() {
        }
    }

    private a bB(View view) {
        a aVar = new a();
        aVar.gbA = (TextView) view.findViewById(d.g.push_msg_title);
        aVar.gbB = (TextView) view.findViewById(d.g.push_msg_content);
        aVar.gbC = (TbImageView) view.findViewById(d.g.push_msg_pic);
        aVar.gbC.setAutoChangeStyle(false);
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
