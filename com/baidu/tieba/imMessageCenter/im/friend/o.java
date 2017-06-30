package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.w;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class o extends BaseAdapter {
    private final TbPageContextSupport aGt;
    private List<com.baidu.tbadk.coreExtra.relationship.a> aUW;
    private TbCheckBox.a dsB;
    private b dsC = null;
    private ViewGroup dsD = null;
    private boolean dsE;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public o(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.aGt = tbPageContextSupport;
        this.dsE = z;
    }

    public void a(b bVar) {
        this.dsC = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aUW = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.dsB = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aUW == null) {
            return 0;
        }
        return this.aUW.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aUW == null) {
            return null;
        }
        return this.aUW.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.dsD == null) {
            this.dsD = viewGroup;
        }
        com.baidu.tbadk.coreExtra.relationship.a aVar2 = (com.baidu.tbadk.coreExtra.relationship.a) getItem(i);
        if (aVar2 != null) {
            aVar = a(view != null ? view.getTag() : null, aVar2);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.rootView;
        }
        return null;
    }

    private a a(Object obj, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        a aVar2;
        if (obj == null) {
            aVar2 = axf();
        } else {
            aVar2 = (a) obj;
        }
        if (this.dsC != null) {
            this.dsC.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.Av());
        aVar2.bBa.setText(aVar.getUserName());
        if (this.dsE) {
            aVar2.dsF.setVisibility(8);
        } else {
            aVar2.dsF.setTagData(aVar);
        }
        if (this.aGt instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.aGt).getLayoutMode().t(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.dsl.setTag(str);
            aVar2.dsl.c(str, 12, false);
        }
    }

    private a axf() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.aGt.getPageContext().getContext()).inflate(w.j.invite_friend_list_item, (ViewGroup) null);
        aVar.dsl = (HeadImageView) aVar.rootView.findViewById(w.h.photo);
        aVar.dsl.setIsRound(false);
        aVar.bBa = (TextView) aVar.rootView.findViewById(w.h.txt_user_name);
        aVar.dsF = (TbCheckBox) aVar.rootView.findViewById(w.h.ckb_select);
        if (this.dsB != null) {
            aVar.dsF.setStatedChangedListener(this.dsB);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public TextView bBa;
        public TbCheckBox dsF;
        public HeadImageView dsl;
        public View rootView;

        public a() {
        }
    }
}
