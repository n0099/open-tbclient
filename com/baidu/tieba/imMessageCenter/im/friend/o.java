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
/* loaded from: classes.dex */
public class o extends BaseAdapter {
    private final TbPageContextSupport aFo;
    private List<com.baidu.tbadk.coreExtra.relationship.a> aVF;
    private TbCheckBox.a dli;
    private boolean dlk;
    private b dlj = null;
    private ViewGroup cHu = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public o(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.aFo = tbPageContextSupport;
        this.dlk = z;
    }

    public void a(b bVar) {
        this.dlj = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aVF = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.dli = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aVF == null) {
            return 0;
        }
        return this.aVF.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aVF == null) {
            return null;
        }
        return this.aVF.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.cHu == null) {
            this.cHu = viewGroup;
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
            aVar2 = avG();
        } else {
            aVar2 = (a) obj;
        }
        if (this.dlj != null) {
            this.dlj.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.AW());
        aVar2.bux.setText(aVar.getUserName());
        if (this.dlk) {
            aVar2.dll.setVisibility(8);
        } else {
            aVar2.dll.setTagData(aVar);
        }
        if (this.aFo instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.aFo).getLayoutMode().t(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.dkS.setTag(str);
            aVar2.dkS.c(str, 12, false);
        }
    }

    private a avG() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.aFo.getPageContext().getContext()).inflate(w.j.invite_friend_list_item, (ViewGroup) null);
        aVar.dkS = (HeadImageView) aVar.rootView.findViewById(w.h.photo);
        aVar.dkS.setIsRound(false);
        aVar.bux = (TextView) aVar.rootView.findViewById(w.h.txt_user_name);
        aVar.dll = (TbCheckBox) aVar.rootView.findViewById(w.h.ckb_select);
        if (this.dli != null) {
            aVar.dll.setStatedChangedListener(this.dli);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView bux;
        public HeadImageView dkS;
        public TbCheckBox dll;
        public View rootView;

        public a() {
        }
    }
}
