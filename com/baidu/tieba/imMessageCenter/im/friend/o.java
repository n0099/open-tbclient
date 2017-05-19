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
    private final TbPageContextSupport aFs;
    private List<com.baidu.tbadk.coreExtra.relationship.a> aWb;
    private TbCheckBox.a dfl;
    private b dfm = null;
    private ViewGroup dfn = null;
    private boolean dfo;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public o(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.aFs = tbPageContextSupport;
        this.dfo = z;
    }

    public void a(b bVar) {
        this.dfm = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aWb = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.dfl = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aWb == null) {
            return 0;
        }
        return this.aWb.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aWb == null) {
            return null;
        }
        return this.aWb.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.dfn == null) {
            this.dfn = viewGroup;
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
            aVar2 = asB();
        } else {
            aVar2 = (a) obj;
        }
        if (this.dfm != null) {
            this.dfm.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.Ah());
        aVar2.but.setText(aVar.getUserName());
        if (this.dfo) {
            aVar2.dfp.setVisibility(8);
        } else {
            aVar2.dfp.setTagData(aVar);
        }
        if (this.aFs instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.aFs).getLayoutMode().t(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.deV.setTag(str);
            aVar2.deV.c(str, 12, false);
        }
    }

    private a asB() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.aFs.getPageContext().getContext()).inflate(w.j.invite_friend_list_item, (ViewGroup) null);
        aVar.deV = (HeadImageView) aVar.rootView.findViewById(w.h.photo);
        aVar.deV.setIsRound(false);
        aVar.but = (TextView) aVar.rootView.findViewById(w.h.txt_user_name);
        aVar.dfp = (TbCheckBox) aVar.rootView.findViewById(w.h.ckb_select);
        if (this.dfl != null) {
            aVar.dfp.setStatedChangedListener(this.dfl);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public TextView but;
        public HeadImageView deV;
        public TbCheckBox dfp;
        public View rootView;

        public a() {
        }
    }
}
