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
    private final TbPageContextSupport aBr;
    private List<com.baidu.tbadk.coreExtra.relationship.a> aUV;
    private TbCheckBox.a dxO;
    private boolean dxQ;
    private b dxP = null;
    private ViewGroup cSX = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public o(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.aBr = tbPageContextSupport;
        this.dxQ = z;
    }

    public void a(b bVar) {
        this.dxP = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aUV = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.dxO = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aUV == null) {
            return 0;
        }
        return this.aUV.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aUV == null) {
            return null;
        }
        return this.aUV.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.cSX == null) {
            this.cSX = viewGroup;
        }
        com.baidu.tbadk.coreExtra.relationship.a aVar2 = (com.baidu.tbadk.coreExtra.relationship.a) getItem(i);
        if (aVar2 != null) {
            aVar = a(view != null ? view.getTag() : null, aVar2);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.aBq;
        }
        return null;
    }

    private a a(Object obj, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        a aVar2;
        if (obj == null) {
            aVar2 = aAP();
        } else {
            aVar2 = (a) obj;
        }
        if (this.dxP != null) {
            this.dxP.a(aVar2.aBq, aVar);
        }
        a(aVar, aVar2, aVar.Ay());
        aVar2.aYg.setText(aVar.getUserName());
        if (this.dxQ) {
            aVar2.dxR.setVisibility(8);
        } else {
            aVar2.dxR.setTagData(aVar);
        }
        if (this.aBr instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.aBr).getLayoutMode().x(aVar2.aBq);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.dxy.setTag(str);
            aVar2.dxy.c(str, 12, false);
        }
    }

    private a aAP() {
        a aVar = new a();
        aVar.aBq = LayoutInflater.from(this.aBr.getPageContext().getContext()).inflate(r.h.invite_friend_list_item, (ViewGroup) null);
        aVar.dxy = (HeadImageView) aVar.aBq.findViewById(r.g.photo);
        aVar.dxy.setIsRound(false);
        aVar.aYg = (TextView) aVar.aBq.findViewById(r.g.txt_user_name);
        aVar.dxR = (TbCheckBox) aVar.aBq.findViewById(r.g.ckb_select);
        if (this.dxO != null) {
            aVar.dxR.setStatedChangedListener(this.dxO);
        }
        aVar.aBq.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes.dex */
    public class a {
        public View aBq;
        public TextView aYg;
        public TbCheckBox dxR;
        public HeadImageView dxy;

        public a() {
        }
    }
}
