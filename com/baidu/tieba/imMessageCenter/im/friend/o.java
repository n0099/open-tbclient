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
    private final TbPageContextSupport aFm;
    private List<com.baidu.tbadk.coreExtra.relationship.a> aVD;
    private TbCheckBox.a diR;
    private boolean diT;
    private b diS = null;
    private ViewGroup cFd = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public o(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.aFm = tbPageContextSupport;
        this.diT = z;
    }

    public void a(b bVar) {
        this.diS = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aVD = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.diR = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aVD == null) {
            return 0;
        }
        return this.aVD.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aVD == null) {
            return null;
        }
        return this.aVD.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.cFd == null) {
            this.cFd = viewGroup;
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
            aVar2 = auF();
        } else {
            aVar2 = (a) obj;
        }
        if (this.diS != null) {
            this.diS.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.AW());
        aVar2.bsf.setText(aVar.getUserName());
        if (this.diT) {
            aVar2.diU.setVisibility(8);
        } else {
            aVar2.diU.setTagData(aVar);
        }
        if (this.aFm instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.aFm).getLayoutMode().t(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.diB.setTag(str);
            aVar2.diB.c(str, 12, false);
        }
    }

    private a auF() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.aFm.getPageContext().getContext()).inflate(w.j.invite_friend_list_item, (ViewGroup) null);
        aVar.diB = (HeadImageView) aVar.rootView.findViewById(w.h.photo);
        aVar.diB.setIsRound(false);
        aVar.bsf = (TextView) aVar.rootView.findViewById(w.h.txt_user_name);
        aVar.diU = (TbCheckBox) aVar.rootView.findViewById(w.h.ckb_select);
        if (this.diR != null) {
            aVar.diU.setStatedChangedListener(this.diR);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView bsf;
        public HeadImageView diB;
        public TbCheckBox diU;
        public View rootView;

        public a() {
        }
    }
}
