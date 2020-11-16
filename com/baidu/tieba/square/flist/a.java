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
/* loaded from: classes22.dex */
public class a extends BaseAdapter {
    Context mActivity;
    private e mQU;
    private int mQV = 0;
    C0850a mQW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0850a {
        ImageView mQX;
        TextView mQY;

        C0850a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mQU == null || this.mQU.mTn == null) {
            return 0;
        }
        return this.mQU.mTn.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mQU == null || this.mQU.mTn == null) {
            return null;
        }
        return this.mQU.mTn.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = dIh();
        }
        if (this.mQU != null) {
            e eVar = this.mQU.mTn.get(i);
            this.mQW = (C0850a) view.getTag();
            if (eVar != null) {
                a(this.mQW, eVar, view, i);
            }
        }
        return view;
    }

    public void JQ(int i) {
        this.mQV = i;
        notifyDataSetChanged();
    }

    public void a(e eVar) {
        this.mQU = eVar;
    }

    public e dIg() {
        return this.mQU;
    }

    private View dIh() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.mQW = new C0850a();
        this.mQW.mQX = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.mQW.mQY = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.mQW);
        return inflate;
    }

    private void a(C0850a c0850a, e eVar, View view, int i) {
        if (c0850a != null && eVar != null) {
            c0850a.mQY.setText("");
            if (i == 0) {
                c0850a.mQY.setText(this.mActivity.getString(R.string.all) + eVar.mRd);
            } else {
                c0850a.mQY.setText(eVar.mRd);
            }
            if (i != this.mQV) {
                c0850a.mQX.setVisibility(4);
                ap.setViewTextColor(c0850a.mQY, R.color.common_color_10200, 1);
                return;
            }
            c0850a.mQX.setVisibility(0);
            ap.setViewTextColor(c0850a.mQY, R.color.common_color_10013, 1);
        }
    }
}
