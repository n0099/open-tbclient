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
    private List<e> ggx = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ggx != null) {
            return this.ggx.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sf */
    public e getItem(int i) {
        if (this.ggx == null || i >= this.ggx.size()) {
            return null;
        }
        return this.ggx.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        return a(this.ggx.get(i), view2, viewGroup);
    }

    public View a(e eVar, View view2, ViewGroup viewGroup) {
        View inflate;
        a bs;
        if (view2 != null && view2.getTag() != null && (view2.getTag() instanceof a)) {
            bs = (a) view2.getTag();
            inflate = view2;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(d.i.screenlock_show_item_view_4, viewGroup, false);
            bs = bs(inflate);
            inflate.setTag(bs);
        }
        if (eVar == null) {
            return inflate;
        }
        bs.ggy.setText(eVar.title);
        bs.ggz.setText(eVar.content);
        bs.ggA.setDefaultErrorResource(d.f.screen_notify_default_bg);
        bs.ggA.setDefaultResource(d.f.screen_notify_default_bg);
        bs.ggA.startLoad(eVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void dh(List<e> list) {
        if (list != null && list.size() != 0) {
            this.ggx.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TbImageView ggA;
        TextView ggy;
        TextView ggz;
        View mLine;

        private a() {
        }
    }

    private a bs(View view2) {
        a aVar = new a();
        aVar.ggy = (TextView) view2.findViewById(d.g.push_msg_title);
        aVar.ggz = (TextView) view2.findViewById(d.g.push_msg_content);
        aVar.ggA = (TbImageView) view2.findViewById(d.g.push_msg_pic);
        aVar.ggA.setAutoChangeStyle(false);
        aVar.mLine = view2.findViewById(d.g.line);
        return aVar;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
