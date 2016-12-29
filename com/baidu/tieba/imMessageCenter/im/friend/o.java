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
    private final TbPageContextSupport aAL;
    private List<com.baidu.tbadk.coreExtra.relationship.a> aUm;
    private TbCheckBox.a daN;
    private boolean daP;
    private b daO = null;
    private ViewGroup cyf = null;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public o(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.aAL = tbPageContextSupport;
        this.daP = z;
    }

    public void a(b bVar) {
        this.daO = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aUm = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.daN = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aUm == null) {
            return 0;
        }
        return this.aUm.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aUm == null) {
            return null;
        }
        return this.aUm.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.cyf == null) {
            this.cyf = viewGroup;
        }
        com.baidu.tbadk.coreExtra.relationship.a aVar2 = (com.baidu.tbadk.coreExtra.relationship.a) getItem(i);
        if (aVar2 != null) {
            aVar = a(view != null ? view.getTag() : null, aVar2);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.aAK;
        }
        return null;
    }

    private a a(Object obj, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        a aVar2;
        if (obj == null) {
            aVar2 = aul();
        } else {
            aVar2 = (a) obj;
        }
        if (this.daO != null) {
            this.daO.a(aVar2.aAK, aVar);
        }
        a(aVar, aVar2, aVar.Al());
        aVar2.bbH.setText(aVar.getUserName());
        if (this.daP) {
            aVar2.daQ.setVisibility(8);
        } else {
            aVar2.daQ.setTagData(aVar);
        }
        if (this.aAL instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.aAL).getLayoutMode().x(aVar2.aAK);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.daw.setTag(str);
            aVar2.daw.c(str, 12, false);
        }
    }

    private a aul() {
        a aVar = new a();
        aVar.aAK = LayoutInflater.from(this.aAL.getPageContext().getContext()).inflate(r.h.invite_friend_list_item, (ViewGroup) null);
        aVar.daw = (HeadImageView) aVar.aAK.findViewById(r.g.photo);
        aVar.daw.setIsRound(false);
        aVar.bbH = (TextView) aVar.aAK.findViewById(r.g.txt_user_name);
        aVar.daQ = (TbCheckBox) aVar.aAK.findViewById(r.g.ckb_select);
        if (this.daN != null) {
            aVar.daQ.setStatedChangedListener(this.daN);
        }
        aVar.aAK.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes.dex */
    public class a {
        public View aAK;
        public TextView bbH;
        public TbCheckBox daQ;
        public HeadImageView daw;

        public a() {
        }
    }
}
