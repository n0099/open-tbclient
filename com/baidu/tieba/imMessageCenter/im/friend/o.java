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
    private final TbPageContextSupport aFf;
    private List<com.baidu.tbadk.coreExtra.relationship.a> aTD;
    private TbCheckBox.a dkF;
    private b dkG = null;
    private ViewGroup dkH = null;
    private boolean dkI;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public o(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.aFf = tbPageContextSupport;
        this.dkI = z;
    }

    public void a(b bVar) {
        this.dkG = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aTD = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.dkF = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aTD == null) {
            return 0;
        }
        return this.aTD.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aTD == null) {
            return null;
        }
        return this.aTD.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.dkH == null) {
            this.dkH = viewGroup;
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
            aVar2 = atx();
        } else {
            aVar2 = (a) obj;
        }
        if (this.dkG != null) {
            this.dkG.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.Aa());
        aVar2.bAh.setText(aVar.getUserName());
        if (this.dkI) {
            aVar2.dkJ.setVisibility(8);
        } else {
            aVar2.dkJ.setTagData(aVar);
        }
        if (this.aFf instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.aFf).getLayoutMode().t(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.dkp.setTag(str);
            aVar2.dkp.c(str, 12, false);
        }
    }

    private a atx() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.aFf.getPageContext().getContext()).inflate(w.j.invite_friend_list_item, (ViewGroup) null);
        aVar.dkp = (HeadImageView) aVar.rootView.findViewById(w.h.photo);
        aVar.dkp.setIsRound(false);
        aVar.bAh = (TextView) aVar.rootView.findViewById(w.h.txt_user_name);
        aVar.dkJ = (TbCheckBox) aVar.rootView.findViewById(w.h.ckb_select);
        if (this.dkF != null) {
            aVar.dkJ.setStatedChangedListener(this.dkF);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public TextView bAh;
        public TbCheckBox dkJ;
        public HeadImageView dkp;
        public View rootView;

        public a() {
        }
    }
}
