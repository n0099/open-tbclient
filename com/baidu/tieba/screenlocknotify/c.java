package com.baidu.tieba.screenlocknotify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends BaseAdapter {
    private Context mContext;
    private boolean mHasMore = true;
    private List<d> kTF = new ArrayList();

    public c(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kTF != null) {
            return this.kTF.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: CI */
    public d getItem(int i) {
        if (this.kTF == null || i >= this.kTF.size()) {
            return null;
        }
        return this.kTF.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.kTF.get(i), view, viewGroup);
    }

    public View a(d dVar, View view, ViewGroup viewGroup) {
        View inflate;
        a cZ;
        if (view != null && view.getTag() != null && (view.getTag() instanceof a)) {
            cZ = (a) view.getTag();
            inflate = view;
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(R.layout.screenlock_show_item_view_4, viewGroup, false);
            cZ = cZ(inflate);
            inflate.setTag(cZ);
        }
        if (dVar == null) {
            return inflate;
        }
        cZ.kTG.setText(dVar.title);
        cZ.kTH.setText(dVar.content);
        cZ.kTI.setDefaultErrorResource(R.drawable.screen_notify_default_bg);
        cZ.kTI.setDefaultResource(R.drawable.screen_notify_default_bg);
        cZ.kTI.a(dVar.pic, 10, 0, 0, false);
        return inflate;
    }

    public void ez(List<d> list) {
        if (list != null && list.size() != 0) {
            this.kTF.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        TextView kTG;
        TextView kTH;
        TbImageView kTI;
        View mLine;

        private a() {
        }
    }

    private a cZ(View view) {
        a aVar = new a();
        aVar.kTG = (TextView) view.findViewById(R.id.push_msg_title);
        aVar.kTH = (TextView) view.findViewById(R.id.push_msg_content);
        aVar.kTI = (TbImageView) view.findViewById(R.id.push_msg_pic);
        aVar.kTI.setAutoChangeStyle(false);
        aVar.mLine = view.findViewById(R.id.line);
        return aVar;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
