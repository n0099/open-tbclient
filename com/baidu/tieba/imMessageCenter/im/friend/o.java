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
    private final TbPageContextSupport aEW;
    private List<com.baidu.tbadk.coreExtra.relationship.a> aVq;
    private TbCheckBox.a dks;
    private boolean dku;
    private b dkt = null;
    private ViewGroup cGE = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public o(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.aEW = tbPageContextSupport;
        this.dku = z;
    }

    public void a(b bVar) {
        this.dkt = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aVq = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.dks = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aVq == null) {
            return 0;
        }
        return this.aVq.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aVq == null) {
            return null;
        }
        return this.aVq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.cGE == null) {
            this.cGE = viewGroup;
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
            aVar2 = auM();
        } else {
            aVar2 = (a) obj;
        }
        if (this.dkt != null) {
            this.dkt.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.Ax());
        aVar2.bsn.setText(aVar.getUserName());
        if (this.dku) {
            aVar2.dkv.setVisibility(8);
        } else {
            aVar2.dkv.setTagData(aVar);
        }
        if (this.aEW instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.aEW).getLayoutMode().t(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.dkc.setTag(str);
            aVar2.dkc.c(str, 12, false);
        }
    }

    private a auM() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.aEW.getPageContext().getContext()).inflate(w.j.invite_friend_list_item, (ViewGroup) null);
        aVar.dkc = (HeadImageView) aVar.rootView.findViewById(w.h.photo);
        aVar.dkc.setIsRound(false);
        aVar.bsn = (TextView) aVar.rootView.findViewById(w.h.txt_user_name);
        aVar.dkv = (TbCheckBox) aVar.rootView.findViewById(w.h.ckb_select);
        if (this.dks != null) {
            aVar.dkv.setStatedChangedListener(this.dks);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView bsn;
        public HeadImageView dkc;
        public TbCheckBox dkv;
        public View rootView;

        public a() {
        }
    }
}
