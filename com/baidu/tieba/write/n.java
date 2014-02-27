package com.baidu.tieba.write;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.MetaData;
import com.baidu.tieba.view.HeadImageView;
import com.baidu.tieba.view.TbCheckBox;
import com.baidu.tieba.view.cq;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class n extends BaseAdapter {
    private Context a;
    private com.baidu.tieba.util.i b;
    private ArrayList<MetaData> c;
    private cq d;
    private p e = null;
    private ViewGroup f = null;
    private boolean g;

    public final void a(p pVar) {
        this.e = pVar;
    }

    public n(Context context, boolean z) {
        this.b = null;
        this.g = true;
        this.a = context;
        this.g = z;
        this.b = new com.baidu.tieba.util.i(context);
    }

    public final void a(ArrayList<MetaData> arrayList) {
        this.c = arrayList;
    }

    public final void a(cq cqVar) {
        this.d = cqVar;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.c == null) {
            return 0;
        }
        return this.c.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        if (this.c == null) {
            return null;
        }
        return this.c.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return 0L;
    }

    public final com.baidu.tieba.util.i a() {
        return this.b;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        o oVar;
        if (this.f == null) {
            this.f = viewGroup;
        }
        MetaData metaData = (MetaData) getItem(i);
        if (metaData != null) {
            Object tag = view != null ? view.getTag() : null;
            int ae = TiebaApplication.g().ae();
            if (tag == null) {
                o oVar2 = new o(this, (byte) 0);
                oVar2.a = LayoutInflater.from(this.a).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
                oVar2.b = (HeadImageView) oVar2.a.findViewById(R.id.photo);
                oVar2.b.setIsRound(true);
                oVar2.c = (TextView) oVar2.a.findViewById(R.id.txt_user_name);
                oVar2.d = (TbCheckBox) oVar2.a.findViewById(R.id.ckb_select);
                if (this.d != null) {
                    oVar2.d.setStatedChangedListener(this.d);
                }
                oVar2.a.setTag(oVar2);
                oVar = oVar2;
            } else {
                oVar = (o) tag;
            }
            if (this.e != null) {
                p pVar = this.e;
                View view2 = oVar.a;
                pVar.c(metaData);
            }
            String portrait = metaData.getPortrait();
            oVar.c.setText(metaData.getName_show());
            oVar.d.setTagData(metaData);
            oVar.b.setTag(portrait);
            if (this.g) {
                oVar.d.setVisibility(0);
            } else {
                oVar.d.setVisibility(8);
            }
            com.baidu.tieba.util.i iVar = this.b;
            com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(portrait);
            if (b != null) {
                oVar.b.setTag(null);
                b.a(oVar.b);
            } else {
                oVar.b.setTag(portrait);
                oVar.b.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.photo));
            }
            if (this.a instanceof AtListActivity) {
                ((AtListActivity) this.a).getLayoutMode().a(ae == 1);
                ((AtListActivity) this.a).getLayoutMode().a(oVar.a);
            }
        } else {
            oVar = null;
        }
        if (oVar != null) {
            return oVar.a;
        }
        return null;
    }
}
