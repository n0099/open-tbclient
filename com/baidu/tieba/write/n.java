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
import com.baidu.tieba.view.cr;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    private Context a;
    private com.baidu.tieba.util.i b;
    private ArrayList<MetaData> c;
    private cr d;
    private p e = null;
    private ViewGroup f = null;
    private boolean g;

    public void a(p pVar) {
        this.e = pVar;
    }

    public n(Context context, boolean z) {
        this.b = null;
        this.g = true;
        this.a = context;
        this.g = z;
        this.b = new com.baidu.tieba.util.i(context);
    }

    public void a(ArrayList<MetaData> arrayList) {
        this.c = arrayList;
    }

    public void a(cr crVar) {
        this.d = crVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.c == null) {
            return 0;
        }
        return this.c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.c == null) {
            return null;
        }
        return this.c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public com.baidu.tieba.util.i a() {
        return this.b;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        o oVar;
        if (this.f == null) {
            this.f = viewGroup;
        }
        MetaData metaData = (MetaData) getItem(i);
        if (metaData != null) {
            oVar = a(view != null ? view.getTag() : null, metaData);
        } else {
            oVar = null;
        }
        if (oVar != null) {
            return oVar.a;
        }
        return null;
    }

    private o a(Object obj, MetaData metaData) {
        o oVar;
        int al = TiebaApplication.g().al();
        if (obj == null) {
            oVar = b();
        } else {
            oVar = (o) obj;
        }
        if (this.e != null) {
            this.e.a(oVar.a, metaData);
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
        com.baidu.adp.widget.ImageView.b c = this.b.c(portrait);
        if (c != null) {
            oVar.b.setTag(null);
            c.a(oVar.b);
        } else {
            oVar.b.setTag(portrait);
            oVar.b.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.photo));
        }
        if (this.a instanceof AtListActivity) {
            ((AtListActivity) this.a).getLayoutMode().a(al == 1);
            ((AtListActivity) this.a).getLayoutMode().a(oVar.a);
        }
        return oVar;
    }

    private o b() {
        o oVar = new o(this, null);
        oVar.a = LayoutInflater.from(this.a).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        oVar.b = (HeadImageView) oVar.a.findViewById(R.id.photo);
        oVar.b.setIsRound(true);
        oVar.c = (TextView) oVar.a.findViewById(R.id.txt_user_name);
        oVar.d = (TbCheckBox) oVar.a.findViewById(R.id.ckb_select);
        if (this.d != null) {
            oVar.d.setStatedChangedListener(this.d);
        }
        oVar.a.setTag(oVar);
        return oVar;
    }
}
