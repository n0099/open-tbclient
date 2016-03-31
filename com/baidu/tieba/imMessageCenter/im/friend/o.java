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
    private final TbPageContextSupport aAi;
    private List<com.baidu.tbadk.coreExtra.relationship.a> aLU;
    private TbCheckBox.a cvU;
    private b cvV = null;
    private ViewGroup cvW = null;
    private boolean cvX;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public o(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.aAi = tbPageContextSupport;
        this.cvX = z;
    }

    public void a(b bVar) {
        this.cvV = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aLU = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.cvU = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aLU == null) {
            return 0;
        }
        return this.aLU.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aLU == null) {
            return null;
        }
        return this.aLU.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.cvW == null) {
            this.cvW = viewGroup;
        }
        com.baidu.tbadk.coreExtra.relationship.a aVar2 = (com.baidu.tbadk.coreExtra.relationship.a) getItem(i);
        if (aVar2 != null) {
            aVar = a(view != null ? view.getTag() : null, aVar2);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.aAh;
        }
        return null;
    }

    private a a(Object obj, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        a aVar2;
        if (obj == null) {
            aVar2 = akz();
        } else {
            aVar2 = (a) obj;
        }
        if (this.cvV != null) {
            this.cvV.a(aVar2.aAh, aVar);
        }
        a(aVar, aVar2, aVar.getUserPortrait());
        aVar2.aPp.setText(aVar.getUserName());
        if (this.cvX) {
            aVar2.cvY.setVisibility(8);
        } else {
            aVar2.cvY.setTagData(aVar);
        }
        if (this.aAi instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.aAi).getLayoutMode().x(aVar2.aAh);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.cvC.setTag(str);
            aVar2.cvC.c(str, 12, false);
        }
    }

    private a akz() {
        a aVar = new a();
        aVar.aAh = LayoutInflater.from(this.aAi.getPageContext().getContext()).inflate(t.h.invite_friend_list_item, (ViewGroup) null);
        aVar.cvC = (HeadImageView) aVar.aAh.findViewById(t.g.photo);
        aVar.cvC.setIsRound(false);
        aVar.aPp = (TextView) aVar.aAh.findViewById(t.g.txt_user_name);
        aVar.cvY = (TbCheckBox) aVar.aAh.findViewById(t.g.ckb_select);
        if (this.cvU != null) {
            aVar.cvY.setStatedChangedListener(this.cvU);
        }
        aVar.aAh.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes.dex */
    public class a {
        public View aAh;
        public TextView aPp;
        public HeadImageView cvC;
        public TbCheckBox cvY;

        public a() {
        }
    }
}
