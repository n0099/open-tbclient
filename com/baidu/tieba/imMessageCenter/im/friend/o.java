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
    private List<com.baidu.tbadk.coreExtra.relationship.a> aIe;
    private final TbPageContextSupport awl;
    private TbCheckBox.a cwR;
    private b cwS = null;
    private ViewGroup cwT = null;
    private boolean cwU;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public o(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.awl = tbPageContextSupport;
        this.cwU = z;
    }

    public void a(b bVar) {
        this.cwS = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aIe = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.cwR = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aIe == null) {
            return 0;
        }
        return this.aIe.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aIe == null) {
            return null;
        }
        return this.aIe.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.cwT == null) {
            this.cwT = viewGroup;
        }
        com.baidu.tbadk.coreExtra.relationship.a aVar2 = (com.baidu.tbadk.coreExtra.relationship.a) getItem(i);
        if (aVar2 != null) {
            aVar = a(view != null ? view.getTag() : null, aVar2);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.awk;
        }
        return null;
    }

    private a a(Object obj, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        a aVar2;
        if (obj == null) {
            aVar2 = akF();
        } else {
            aVar2 = (a) obj;
        }
        if (this.cwS != null) {
            this.cwS.a(aVar2.awk, aVar);
        }
        a(aVar, aVar2, aVar.getUserPortrait());
        aVar2.aLz.setText(aVar.getUserName());
        if (this.cwU) {
            aVar2.cwV.setVisibility(8);
        } else {
            aVar2.cwV.setTagData(aVar);
        }
        if (this.awl instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.awl).getLayoutMode().x(aVar2.awk);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.cwz.setTag(str);
            aVar2.cwz.c(str, 12, false);
        }
    }

    private a akF() {
        a aVar = new a();
        aVar.awk = LayoutInflater.from(this.awl.getPageContext().getContext()).inflate(t.h.invite_friend_list_item, (ViewGroup) null);
        aVar.cwz = (HeadImageView) aVar.awk.findViewById(t.g.photo);
        aVar.cwz.setIsRound(false);
        aVar.aLz = (TextView) aVar.awk.findViewById(t.g.txt_user_name);
        aVar.cwV = (TbCheckBox) aVar.awk.findViewById(t.g.ckb_select);
        if (this.cwR != null) {
            aVar.cwV.setStatedChangedListener(this.cwR);
        }
        aVar.awk.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView aLz;
        public View awk;
        public TbCheckBox cwV;
        public HeadImageView cwz;

        public a() {
        }
    }
}
