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
    private String[] bIG;
    private int bIH = 0;
    private View.OnClickListener mItemClickListener = new f(this);

    public e(String[] strArr) {
        this.bIG = strArr;
    }

    public String aai() {
        if (this.bIG != null) {
            return this.bIG[this.bIH];
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bIG == null) {
            return 0;
        }
        return this.bIG.length;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        g gVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.hr().inflate(viewGroup.getContext(), r.forbid_list_item, null);
            g gVar2 = new g(null);
            gVar2.bIJ = (TextView) view.findViewById(q.reason_text);
            gVar2.bIK = (ImageView) view.findViewById(q.check_img);
            view.setTag(gVar2);
            view.setOnClickListener(this.mItemClickListener);
            gVar = gVar2;
        } else {
            gVar = (g) view.getTag();
        }
        gVar.mIndex = i;
        gVar.bIJ.setText(this.bIG[i]);
        if (gVar.mIndex == this.bIH) {
            ay.c(gVar.bIK, p.icon_found_information_choose);
            gVar.bIK.setVisibility(0);
            ay.b(gVar.bIJ, com.baidu.tieba.n.forbid_selected_txt, 1);
        } else {
            gVar.bIK.setVisibility(4);
            ay.b(gVar.bIJ, com.baidu.tieba.n.appeal_com_text, 1);
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
