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
    private List<e> gfu = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gfu != null) {
            return this.gfu.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sg */
    public e getItem(int i) {
        if (this.gfu == null || i >= this.gfu.size()) {
            return null;
        }
        return this.gfu.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        return a(this.gfu.get(i), view2, viewGroup);
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
        bs.gfv.setText(eVar.title);
        bs.gfw.setText(eVar.content);
        bs.gfx.setDefaultErrorResource(d.f.screen_notify_default_bg);
        bs.gfx.setDefaultResource(d.f.screen_notify_default_bg);
        bs.gfx.startLoad(eVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void de(List<e> list) {
        if (list != null && list.size() != 0) {
            this.gfu.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {
        TextView gfv;
        TextView gfw;
        TbImageView gfx;
        View mLine;

        private a() {
        }
    }

    private a bs(View view2) {
        a aVar = new a();
        aVar.gfv = (TextView) view2.findViewById(d.g.push_msg_title);
        aVar.gfw = (TextView) view2.findViewById(d.g.push_msg_content);
        aVar.gfx = (TbImageView) view2.findViewById(d.g.push_msg_pic);
        aVar.gfx.setAutoChangeStyle(false);
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
