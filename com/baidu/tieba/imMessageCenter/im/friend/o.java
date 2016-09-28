package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.r;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends BaseAdapter {
    private final TbPageContextSupport aAz;
    private List<com.baidu.tbadk.coreExtra.relationship.a> aSU;
    private TbCheckBox.a dsi;
    private b dsj = null;
    private ViewGroup dsk = null;
    private boolean dsl;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public o(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.aAz = tbPageContextSupport;
        this.dsl = z;
    }

    public void a(b bVar) {
        this.dsj = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aSU = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.dsi = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aSU == null) {
            return 0;
        }
        return this.aSU.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aSU == null) {
            return null;
        }
        return this.aSU.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.dsk == null) {
            this.dsk = viewGroup;
        }
        com.baidu.tbadk.coreExtra.relationship.a aVar2 = (com.baidu.tbadk.coreExtra.relationship.a) getItem(i);
        if (aVar2 != null) {
            aVar = a(view != null ? view.getTag() : null, aVar2);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.aAy;
        }
        return null;
    }

    private a a(Object obj, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        a aVar2;
        if (obj == null) {
            aVar2 = ayS();
        } else {
            aVar2 = (a) obj;
        }
        if (this.dsj != null) {
            this.dsj.a(aVar2.aAy, aVar);
        }
        a(aVar, aVar2, aVar.Ar());
        aVar2.aVU.setText(aVar.getUserName());
        if (this.dsl) {
            aVar2.dsm.setVisibility(8);
        } else {
            aVar2.dsm.setTagData(aVar);
        }
        if (this.aAz instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.aAz).getLayoutMode().x(aVar2.aAy);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.drR.setTag(str);
            aVar2.drR.c(str, 12, false);
        }
    }

    private a ayS() {
        a aVar = new a();
        aVar.aAy = LayoutInflater.from(this.aAz.getPageContext().getContext()).inflate(r.h.invite_friend_list_item, (ViewGroup) null);
        aVar.drR = (HeadImageView) aVar.aAy.findViewById(r.g.photo);
        aVar.drR.setIsRound(false);
        aVar.aVU = (TextView) aVar.aAy.findViewById(r.g.txt_user_name);
        aVar.dsm = (TbCheckBox) aVar.aAy.findViewById(r.g.ckb_select);
        if (this.dsi != null) {
            aVar.dsm.setStatedChangedListener(this.dsi);
        }
        aVar.aAy.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes.dex */
    public class a {
        public View aAy;
        public TextView aVU;
        public HeadImageView drR;
        public TbCheckBox dsm;

        public a() {
        }
    }
}
