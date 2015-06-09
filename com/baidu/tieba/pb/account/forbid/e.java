package com.baidu.tieba.pb.account.forbid;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BaseAdapter {
    private String[] bIH;
    private int bII = 0;
    private View.OnClickListener mItemClickListener = new f(this);

    public e(String[] strArr) {
        this.bIH = strArr;
    }

    public String aaj() {
        if (this.bIH != null) {
            return this.bIH[this.bII];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bIH == null) {
            return 0;
        }
        return this.bIH.length;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        g gVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.hr().inflate(viewGroup.getContext(), r.forbid_list_item, null);
            g gVar2 = new g(null);
            gVar2.bIK = (TextView) view.findViewById(q.reason_text);
            gVar2.bIL = (ImageView) view.findViewById(q.check_img);
            view.setTag(gVar2);
            view.setOnClickListener(this.mItemClickListener);
            gVar = gVar2;
        } else {
            gVar = (g) view.getTag();
        }
        gVar.mIndex = i;
        gVar.bIK.setText(this.bIH[i]);
        if (gVar.mIndex == this.bII) {
            ay.c(gVar.bIL, p.icon_found_information_choose);
            gVar.bIL.setVisibility(0);
            ay.b(gVar.bIK, com.baidu.tieba.n.forbid_selected_txt, 1);
        } else {
            gVar.bIL.setVisibility(4);
            ay.b(gVar.bIK, com.baidu.tieba.n.appeal_com_text, 1);
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
