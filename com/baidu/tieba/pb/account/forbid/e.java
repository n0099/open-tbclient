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
    private String[] bFL;
    private int bFM = 0;
    private View.OnClickListener bsw = new f(this);

    public e(String[] strArr) {
        this.bFL = strArr;
    }

    public String YI() {
        if (this.bFL != null) {
            return this.bFL[this.bFM];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bFL == null) {
            return 0;
        }
        return this.bFL.length;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        g gVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.hH().inflate(viewGroup.getContext(), w.forbid_list_item, null);
            g gVar2 = new g(null);
            gVar2.bFO = (TextView) view.findViewById(v.reason_text);
            gVar2.bFP = (ImageView) view.findViewById(v.check_img);
            view.setTag(gVar2);
            view.setOnClickListener(this.bsw);
            gVar = gVar2;
        } else {
            gVar = (g) view.getTag();
        }
        gVar.mIndex = i;
        gVar.bFO.setText(this.bFL[i]);
        if (gVar.mIndex == this.bFM) {
            ba.c(gVar.bFP, u.icon_found_information_choose);
            gVar.bFP.setVisibility(0);
            ba.b(gVar.bFO, s.forbid_selected_txt, 1);
        } else {
            gVar.bFP.setVisibility(4);
            ba.b(gVar.bFO, s.appeal_com_text, 1);
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
