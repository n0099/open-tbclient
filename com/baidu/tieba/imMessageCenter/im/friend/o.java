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
    private List<com.baidu.tbadk.coreExtra.relationship.a> aMv;
    private final TbPageContextSupport axP;
    private TbCheckBox.a dfe;
    private b dff = null;
    private ViewGroup dfg = null;
    private boolean dfh;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public o(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.axP = tbPageContextSupport;
        this.dfh = z;
    }

    public void a(b bVar) {
        this.dff = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aMv = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.dfe = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aMv == null) {
            return 0;
        }
        return this.aMv.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aMv == null) {
            return null;
        }
        return this.aMv.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.dfg == null) {
            this.dfg = viewGroup;
        }
        com.baidu.tbadk.coreExtra.relationship.a aVar2 = (com.baidu.tbadk.coreExtra.relationship.a) getItem(i);
        if (aVar2 != null) {
            aVar = a(view != null ? view.getTag() : null, aVar2);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.axO;
        }
        return null;
    }

    private a a(Object obj, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        a aVar2;
        if (obj == null) {
            aVar2 = atG();
        } else {
            aVar2 = (a) obj;
        }
        if (this.dff != null) {
            this.dff.a(aVar2.axO, aVar);
        }
        a(aVar, aVar2, aVar.getUserPortrait());
        aVar2.aPR.setText(aVar.getUserName());
        if (this.dfh) {
            aVar2.dfi.setVisibility(8);
        } else {
            aVar2.dfi.setTagData(aVar);
        }
        if (this.axP instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.axP).getLayoutMode().w(aVar2.axO);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.deN.setTag(str);
            aVar2.deN.c(str, 12, false);
        }
    }

    private a atG() {
        a aVar = new a();
        aVar.axO = LayoutInflater.from(this.axP.getPageContext().getContext()).inflate(u.h.invite_friend_list_item, (ViewGroup) null);
        aVar.deN = (HeadImageView) aVar.axO.findViewById(u.g.photo);
        aVar.deN.setIsRound(false);
        aVar.aPR = (TextView) aVar.axO.findViewById(u.g.txt_user_name);
        aVar.dfi = (TbCheckBox) aVar.axO.findViewById(u.g.ckb_select);
        if (this.dfe != null) {
            aVar.dfi.setStatedChangedListener(this.dfe);
        }
        aVar.axO.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView aPR;
        public View axO;
        public HeadImageView deN;
        public TbCheckBox dfi;

        public a() {
        }
    }
}
