package com.baidu.tieba.square.flist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.e;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private e lzc;
    private int lzd = 0;
    C0739a lze;
    Context mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0739a {
        ImageView lzf;
        TextView lzg;

        C0739a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lzc == null || this.lzc.lBr == null) {
            return 0;
        }
        return this.lzc.lBr.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.lzc == null || this.lzc.lBr == null) {
            return null;
        }
        return this.lzc.lBr.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = dgq();
        }
        if (this.lzc != null) {
            e eVar = this.lzc.lBr.get(i);
            this.lze = (C0739a) view.getTag();
            if (eVar != null) {
                a(this.lze, eVar, view, i);
            }
        }
        return view;
    }

    public void EH(int i) {
        this.lzd = i;
        notifyDataSetChanged();
    }

    public void a(e eVar) {
        this.lzc = eVar;
    }

    public e dgp() {
        return this.lzc;
    }

    private View dgq() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.lze = new C0739a();
        this.lze.lzf = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.lze.lzg = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.lze);
        return inflate;
    }

    private void a(C0739a c0739a, e eVar, View view, int i) {
        if (c0739a != null && eVar != null) {
            c0739a.lzg.setText("");
            if (i == 0) {
                c0739a.lzg.setText(this.mActivity.getString(R.string.all) + eVar.lzk);
            } else {
                c0739a.lzg.setText(eVar.lzk);
            }
            if (i != this.lzd) {
                c0739a.lzf.setVisibility(4);
                an.setViewTextColor(c0739a.lzg, R.color.common_color_10200, 1);
                return;
            }
            c0739a.lzf.setVisibility(0);
            an.setViewTextColor(c0739a.lzg, R.color.common_color_10013, 1);
        }
    }
}
