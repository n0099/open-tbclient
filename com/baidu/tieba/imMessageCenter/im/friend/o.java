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
    private List<com.baidu.tbadk.coreExtra.relationship.a> aPE;
    private final TbPageContextSupport azD;
    private TbCheckBox.a dia;
    private boolean dic;
    private b dib = null;
    private ViewGroup cFj = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public o(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.azD = tbPageContextSupport;
        this.dic = z;
    }

    public void a(b bVar) {
        this.dib = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aPE = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.dia = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aPE == null) {
            return 0;
        }
        return this.aPE.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aPE == null) {
            return null;
        }
        return this.aPE.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.cFj == null) {
            this.cFj = viewGroup;
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
            aVar2 = avr();
        } else {
            aVar2 = (a) obj;
        }
        if (this.dib != null) {
            this.dib.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.Ag());
        aVar2.blu.setText(aVar.getUserName());
        if (this.dic) {
            aVar2.did.setVisibility(8);
        } else {
            aVar2.did.setTagData(aVar);
        }
        if (this.azD instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.azD).getLayoutMode().v(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.dhK.setTag(str);
            aVar2.dhK.c(str, 12, false);
        }
    }

    private a avr() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.azD.getPageContext().getContext()).inflate(r.j.invite_friend_list_item, (ViewGroup) null);
        aVar.dhK = (HeadImageView) aVar.rootView.findViewById(r.h.photo);
        aVar.dhK.setIsRound(false);
        aVar.blu = (TextView) aVar.rootView.findViewById(r.h.txt_user_name);
        aVar.did = (TbCheckBox) aVar.rootView.findViewById(r.h.ckb_select);
        if (this.dia != null) {
            aVar.did.setStatedChangedListener(this.dia);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView blu;
        public HeadImageView dhK;
        public TbCheckBox did;
        public View rootView;

        public a() {
        }
    }
}
