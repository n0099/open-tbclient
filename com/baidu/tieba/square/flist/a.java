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
    private e nfb;
    private int nfc = 0;
    C0865a nfd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public class C0865a {
        ImageView nfe;
        TextView nff;

        C0865a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nfb == null || this.nfb.nhp == null) {
            return 0;
        }
        return this.nfb.nhp.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.nfb == null || this.nfb.nhp == null) {
            return null;
        }
        return this.nfb.nhp.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = dNy();
        }
        if (this.nfb != null) {
            e eVar = this.nfb.nhp.get(i);
            this.nfd = (C0865a) view.getTag();
            if (eVar != null) {
                a(this.nfd, eVar, view, i);
            }
        }
        return view;
    }

    public void KG(int i) {
        this.nfc = i;
        notifyDataSetChanged();
    }

    public void a(e eVar) {
        this.nfb = eVar;
    }

    public e dNx() {
        return this.nfb;
    }

    private View dNy() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.nfd = new C0865a();
        this.nfd.nfe = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.nfd.nff = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.nfd);
        return inflate;
    }

    private void a(C0865a c0865a, e eVar, View view, int i) {
        if (c0865a != null && eVar != null) {
            c0865a.nff.setText("");
            if (i == 0) {
                c0865a.nff.setText(this.mActivity.getString(R.string.all) + eVar.nfj);
            } else {
                c0865a.nff.setText(eVar.nfj);
            }
            if (i != this.nfc) {
                c0865a.nfe.setVisibility(4);
                ap.setViewTextColor(c0865a.nff, R.color.common_color_10200, 1);
                return;
            }
            c0865a.nfe.setVisibility(0);
            ap.setViewTextColor(c0865a.nff, R.color.common_color_10013, 1);
        }
    }
}
