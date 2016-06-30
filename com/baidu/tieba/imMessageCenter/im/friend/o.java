package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.u;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> aLB;
    private final TbPageContextSupport axb;
    private TbCheckBox.a dcg;
    private b dch = null;
    private ViewGroup dci = null;
    private boolean dcj;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public o(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.axb = tbPageContextSupport;
        this.dcj = z;
    }

    public void a(b bVar) {
        this.dch = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aLB = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.dcg = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aLB == null) {
            return 0;
        }
        return this.aLB.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aLB == null) {
            return null;
        }
        return this.aLB.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.dci == null) {
            this.dci = viewGroup;
        }
        com.baidu.tbadk.coreExtra.relationship.a aVar2 = (com.baidu.tbadk.coreExtra.relationship.a) getItem(i);
        if (aVar2 != null) {
            aVar = a(view != null ? view.getTag() : null, aVar2);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.axa;
        }
        return null;
    }

    private a a(Object obj, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        a aVar2;
        if (obj == null) {
            aVar2 = asU();
        } else {
            aVar2 = (a) obj;
        }
        if (this.dch != null) {
            this.dch.a(aVar2.axa, aVar);
        }
        a(aVar, aVar2, aVar.getUserPortrait());
        aVar2.aOX.setText(aVar.getUserName());
        if (this.dcj) {
            aVar2.dck.setVisibility(8);
        } else {
            aVar2.dck.setTagData(aVar);
        }
        if (this.axb instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.axb).getLayoutMode().w(aVar2.axa);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.dbP.setTag(str);
            aVar2.dbP.c(str, 12, false);
        }
    }

    private a asU() {
        a aVar = new a();
        aVar.axa = LayoutInflater.from(this.axb.getPageContext().getContext()).inflate(u.h.invite_friend_list_item, (ViewGroup) null);
        aVar.dbP = (HeadImageView) aVar.axa.findViewById(u.g.photo);
        aVar.dbP.setIsRound(false);
        aVar.aOX = (TextView) aVar.axa.findViewById(u.g.txt_user_name);
        aVar.dck = (TbCheckBox) aVar.axa.findViewById(u.g.ckb_select);
        if (this.dcg != null) {
            aVar.dck.setStatedChangedListener(this.dcg);
        }
        aVar.axa.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView aOX;
        public View axa;
        public HeadImageView dbP;
        public TbCheckBox dck;

        public a() {
        }
    }
}
