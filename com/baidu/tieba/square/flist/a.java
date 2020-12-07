package com.baidu.tieba.square.flist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.e;
/* loaded from: classes23.dex */
public class a extends BaseAdapter {
    Context mActivity;
    private e neZ;
    private int nfa = 0;
    C0865a nfb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public class C0865a {
        ImageView nfc;
        TextView nfd;

        C0865a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.neZ == null || this.neZ.nhn == null) {
            return 0;
        }
        return this.neZ.nhn.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.neZ == null || this.neZ.nhn == null) {
            return null;
        }
        return this.neZ.nhn.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = dNx();
        }
        if (this.neZ != null) {
            e eVar = this.neZ.nhn.get(i);
            this.nfb = (C0865a) view.getTag();
            if (eVar != null) {
                a(this.nfb, eVar, view, i);
            }
        }
        return view;
    }

    public void KG(int i) {
        this.nfa = i;
        notifyDataSetChanged();
    }

    public void a(e eVar) {
        this.neZ = eVar;
    }

    public e dNw() {
        return this.neZ;
    }

    private View dNx() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.nfb = new C0865a();
        this.nfb.nfc = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.nfb.nfd = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.nfb);
        return inflate;
    }

    private void a(C0865a c0865a, e eVar, View view, int i) {
        if (c0865a != null && eVar != null) {
            c0865a.nfd.setText("");
            if (i == 0) {
                c0865a.nfd.setText(this.mActivity.getString(R.string.all) + eVar.nfh);
            } else {
                c0865a.nfd.setText(eVar.nfh);
            }
            if (i != this.nfa) {
                c0865a.nfc.setVisibility(4);
                ap.setViewTextColor(c0865a.nfd, R.color.common_color_10200, 1);
                return;
            }
            c0865a.nfc.setVisibility(0);
            ap.setViewTextColor(c0865a.nfd, R.color.common_color_10013, 1);
        }
    }
}
