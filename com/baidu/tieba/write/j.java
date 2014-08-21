package com.baidu.tieba.write;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class j extends BaseAdapter {
    private final Context a;
    private ArrayList<MetaData> b;
    private com.baidu.tbadk.core.view.t c;
    private l d = null;
    private ViewGroup e = null;
    private boolean f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(l lVar) {
        this.d = lVar;
    }

    public j(Context context, boolean z) {
        this.f = true;
        this.a = context;
        this.f = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ArrayList<MetaData> arrayList) {
        this.b = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tbadk.core.view.t tVar) {
        this.c = tVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null) {
            return 0;
        }
        return this.b.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public MetaData getItem(int i) {
        if (this.b != null && i < this.b.size()) {
            return this.b.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        k kVar;
        if (this.e == null) {
            this.e = viewGroup;
        }
        MetaData item = getItem(i);
        if (item != null) {
            kVar = a(view != null ? view.getTag() : null, item);
        } else {
            kVar = null;
        }
        if (kVar != null) {
            return kVar.a;
        }
        return null;
    }

    private k a(Object obj, MetaData metaData) {
        k kVar;
        int skinType = TbadkApplication.m252getInst().getSkinType();
        if (obj == null) {
            kVar = a();
        } else {
            kVar = (k) obj;
        }
        if (this.d != null) {
            this.d.a(kVar.a, metaData);
        }
        String portrait = metaData.getPortrait();
        kVar.c.setText(metaData.getName_show());
        kVar.d.setTagData(metaData);
        kVar.b.setTag(portrait);
        if (this.f) {
            kVar.d.setVisibility(0);
        } else {
            kVar.d.setVisibility(8);
        }
        kVar.b.a(portrait, 12, false);
        if (this.a instanceof AtListActivity) {
            ((AtListActivity) this.a).getLayoutMode().a(skinType == 1);
            ((AtListActivity) this.a).getLayoutMode().a(kVar.a);
        }
        return kVar;
    }

    private k a() {
        k kVar = new k(this, null);
        kVar.a = com.baidu.adp.lib.e.b.a().a(this.a, com.baidu.tieba.v.invite_friend_list_item, null);
        kVar.b = (HeadImageView) kVar.a.findViewById(com.baidu.tieba.u.photo);
        kVar.b.setIsRound(false);
        kVar.c = (TextView) kVar.a.findViewById(com.baidu.tieba.u.txt_user_name);
        kVar.d = (TbCheckBox) kVar.a.findViewById(com.baidu.tieba.u.ckb_select);
        if (this.c != null) {
            kVar.d.setStatedChangedListener(this.c);
        }
        kVar.a.setTag(kVar);
        return kVar;
    }
}
