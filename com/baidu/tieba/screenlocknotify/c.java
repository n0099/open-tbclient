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
    private List<e> gSk = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gSk != null) {
            return this.gSk.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: we */
    public e getItem(int i) {
        if (this.gSk == null || i >= this.gSk.size()) {
            return null;
        }
        return this.gSk.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.gSk.get(i), view, viewGroup);
    }

    public View a(e eVar, View view, ViewGroup viewGroup) {
        View inflate;
        a cR;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            cR = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(d.h.screenlock_show_item_view_4, viewGroup, false);
            cR = cR(inflate);
            inflate.setTag(cR);
        }
        if (eVar == null) {
            return inflate;
        }
        cR.gSl.setText(eVar.title);
        cR.gSm.setText(eVar.content);
        cR.gSn.setDefaultErrorResource(d.f.screen_notify_default_bg);
        cR.gSn.setDefaultResource(d.f.screen_notify_default_bg);
        cR.gSn.startLoad(eVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void dx(List<e> list) {
        if (list != null && list.size() != 0) {
            this.gSk.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        TextView gSl;
        TextView gSm;
        TbImageView gSn;
        View mLine;

        private a() {
        }
    }

    private a cR(View view) {
        a aVar = new a();
        aVar.gSl = (TextView) view.findViewById(d.g.push_msg_title);
        aVar.gSm = (TextView) view.findViewById(d.g.push_msg_content);
        aVar.gSn = (TbImageView) view.findViewById(d.g.push_msg_pic);
        aVar.gSn.setAutoChangeStyle(false);
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
