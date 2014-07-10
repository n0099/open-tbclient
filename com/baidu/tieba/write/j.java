package com.baidu.tieba.write;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import java.util.List;
/* loaded from: classes.dex */
public class j extends BaseAdapter {
    private final Context a;
    private List<com.baidu.tbadk.coreExtra.relationship.b> b;
    private com.baidu.tbadk.core.view.o c;
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
    public void a(List<com.baidu.tbadk.coreExtra.relationship.b> list) {
        this.b = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.tbadk.core.view.o oVar) {
        this.c = oVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null) {
            return 0;
        }
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.b == null) {
            return null;
        }
        return this.b.get(i);
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
        com.baidu.tbadk.coreExtra.relationship.b bVar = (com.baidu.tbadk.coreExtra.relationship.b) getItem(i);
        if (bVar != null) {
            kVar = a(view != null ? view.getTag() : null, bVar);
        } else {
            kVar = null;
        }
        if (kVar != null) {
            return kVar.a;
        }
        return null;
    }

    private k a(Object obj, com.baidu.tbadk.coreExtra.relationship.b bVar) {
        k kVar;
        int skinType = TbadkApplication.m252getInst().getSkinType();
        if (obj == null) {
            kVar = a();
        } else {
            kVar = (k) obj;
        }
        if (this.d != null) {
            this.d.a(kVar.a, bVar);
        }
        String d = bVar.d();
        kVar.c.setText(bVar.b());
        kVar.d.setTagData(bVar);
        kVar.b.setTag(d);
        if (this.f) {
            kVar.d.setVisibility(0);
        } else {
            kVar.d.setVisibility(8);
        }
        kVar.b.a(d, 12, false);
        if (this.a instanceof AtListActivity) {
            ((AtListActivity) this.a).getLayoutMode().a(skinType == 1);
            ((AtListActivity) this.a).getLayoutMode().a(kVar.a);
        }
        return kVar;
    }

    private k a() {
        k kVar = new k(this, null);
        kVar.a = LayoutInflater.from(this.a).inflate(com.baidu.tieba.w.invite_friend_list_item, (ViewGroup) null);
        kVar.b = (HeadImageView) kVar.a.findViewById(com.baidu.tieba.v.photo);
        kVar.b.setIsRound(false);
        kVar.c = (TextView) kVar.a.findViewById(com.baidu.tieba.v.txt_user_name);
        kVar.d = (TbCheckBox) kVar.a.findViewById(com.baidu.tieba.v.ckb_select);
        if (this.c != null) {
            kVar.d.setStatedChangedListener(this.c);
        }
        kVar.a.setTag(kVar);
        return kVar;
    }
}
