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
    private List<e> grR = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.grR != null) {
            return this.grR.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sr */
    public e getItem(int i) {
        if (this.grR == null || i >= this.grR.size()) {
            return null;
        }
        return this.grR.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.grR.get(i), view, viewGroup);
    }

    public View a(e eVar, View view, ViewGroup viewGroup) {
        View inflate;
        a bv;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            bv = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(d.i.screenlock_show_item_view_4, viewGroup, false);
            bv = bv(inflate);
            inflate.setTag(bv);
        }
        if (eVar == null) {
            return inflate;
        }
        bv.grS.setText(eVar.title);
        bv.grT.setText(eVar.content);
        bv.grU.setDefaultErrorResource(d.f.screen_notify_default_bg);
        bv.grU.setDefaultResource(d.f.screen_notify_default_bg);
        bv.grU.startLoad(eVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void dm(List<e> list) {
        if (list != null && list.size() != 0) {
            this.grR.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView grS;
        TextView grT;
        TbImageView grU;
        View mLine;

        private a() {
        }
    }

    private a bv(View view) {
        a aVar = new a();
        aVar.grS = (TextView) view.findViewById(d.g.push_msg_title);
        aVar.grT = (TextView) view.findViewById(d.g.push_msg_content);
        aVar.grU = (TbImageView) view.findViewById(d.g.push_msg_pic);
        aVar.grU.setAutoChangeStyle(false);
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
