package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.t;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends BaseAdapter {
    private List<com.baidu.tbadk.coreExtra.relationship.a> aIY;
    private final TbPageContextSupport azB;
    private TbCheckBox.a clq;
    private b clr = null;
    private ViewGroup clt = null;
    private boolean clu;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public o(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.azB = tbPageContextSupport;
        this.clu = z;
    }

    public void a(b bVar) {
        this.clr = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aIY = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.clq = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aIY == null) {
            return 0;
        }
        return this.aIY.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aIY == null) {
            return null;
        }
        return this.aIY.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.clt == null) {
            this.clt = viewGroup;
        }
        com.baidu.tbadk.coreExtra.relationship.a aVar2 = (com.baidu.tbadk.coreExtra.relationship.a) getItem(i);
        if (aVar2 != null) {
            aVar = a(view != null ? view.getTag() : null, aVar2);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.azA;
        }
        return null;
    }

    private a a(Object obj, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        a aVar2;
        if (obj == null) {
            aVar2 = ahf();
        } else {
            aVar2 = (a) obj;
        }
        if (this.clr != null) {
            this.clr.a(aVar2.azA, aVar);
        }
        a(aVar, aVar2, aVar.getUserPortrait());
        aVar2.aMu.setText(aVar.getUserName());
        if (this.clu) {
            aVar2.clv.setVisibility(8);
        } else {
            aVar2.clv.setTagData(aVar);
        }
        if (this.azB instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.azB).getLayoutMode().x(aVar2.azA);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.ckX.setTag(str);
            aVar2.ckX.d(str, 12, false);
        }
    }

    private a ahf() {
        a aVar = new a();
        aVar.azA = LayoutInflater.from(this.azB.getPageContext().getContext()).inflate(t.h.invite_friend_list_item, (ViewGroup) null);
        aVar.ckX = (HeadImageView) aVar.azA.findViewById(t.g.photo);
        aVar.ckX.setIsRound(false);
        aVar.aMu = (TextView) aVar.azA.findViewById(t.g.txt_user_name);
        aVar.clv = (TbCheckBox) aVar.azA.findViewById(t.g.ckb_select);
        if (this.clq != null) {
            aVar.clv.setStatedChangedListener(this.clq);
        }
        aVar.azA.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView aMu;
        public View azA;
        public HeadImageView ckX;
        public TbCheckBox clv;

        public a() {
        }
    }
}
