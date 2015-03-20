package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BaseAdapter {
    private String[] bFy;
    private int bFz = 0;
    private View.OnClickListener bsg = new f(this);

    public e(String[] strArr) {
        this.bFy = strArr;
    }

    public String Yw() {
        if (this.bFy != null) {
            return this.bFy[this.bFz];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bFy == null) {
            return 0;
        }
        return this.bFy.length;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        g gVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.hH().inflate(viewGroup.getContext(), w.forbid_list_item, null);
            g gVar2 = new g(null);
            gVar2.bFB = (TextView) view.findViewById(v.reason_text);
            gVar2.bFC = (ImageView) view.findViewById(v.check_img);
            view.setTag(gVar2);
            view.setOnClickListener(this.bsg);
            gVar = gVar2;
        } else {
            gVar = (g) view.getTag();
        }
        gVar.mIndex = i;
        gVar.bFB.setText(this.bFy[i]);
        if (gVar.mIndex == this.bFz) {
            ba.c(gVar.bFC, u.icon_found_information_choose);
            gVar.bFC.setVisibility(0);
            ba.b(gVar.bFB, s.forbid_selected_txt, 1);
        } else {
            gVar.bFC.setVisibility(4);
            ba.b(gVar.bFB, s.appeal_com_text, 1);
        }
        return view;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }
}
