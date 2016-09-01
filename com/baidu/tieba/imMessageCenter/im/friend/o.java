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
    private final TbPageContextSupport aAW;
    private List<com.baidu.tbadk.coreExtra.relationship.a> aRP;
    private TbCheckBox.a dqL;
    private b dqM = null;
    private ViewGroup dqN = null;
    private boolean dqO;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public o(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.aAW = tbPageContextSupport;
        this.dqO = z;
    }

    public void a(b bVar) {
        this.dqM = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.aRP = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.dqL = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aRP == null) {
            return 0;
        }
        return this.aRP.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aRP == null) {
            return null;
        }
        return this.aRP.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.dqN == null) {
            this.dqN = viewGroup;
        }
        com.baidu.tbadk.coreExtra.relationship.a aVar2 = (com.baidu.tbadk.coreExtra.relationship.a) getItem(i);
        if (aVar2 != null) {
            aVar = a(view != null ? view.getTag() : null, aVar2);
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.aAV;
        }
        return null;
    }

    private a a(Object obj, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        a aVar2;
        if (obj == null) {
            aVar2 = ayu();
        } else {
            aVar2 = (a) obj;
        }
        if (this.dqM != null) {
            this.dqM.a(aVar2.aAV, aVar);
        }
        a(aVar, aVar2, aVar.Ao());
        aVar2.aVl.setText(aVar.getUserName());
        if (this.dqO) {
            aVar2.dqP.setVisibility(8);
        } else {
            aVar2.dqP.setTagData(aVar);
        }
        if (this.aAW instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.aAW).getLayoutMode().x(aVar2.aAV);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.dqu.setTag(str);
            aVar2.dqu.c(str, 12, false);
        }
    }

    private a ayu() {
        a aVar = new a();
        aVar.aAV = LayoutInflater.from(this.aAW.getPageContext().getContext()).inflate(t.h.invite_friend_list_item, (ViewGroup) null);
        aVar.dqu = (HeadImageView) aVar.aAV.findViewById(t.g.photo);
        aVar.dqu.setIsRound(false);
        aVar.aVl = (TextView) aVar.aAV.findViewById(t.g.txt_user_name);
        aVar.dqP = (TbCheckBox) aVar.aAV.findViewById(t.g.ckb_select);
        if (this.dqL != null) {
            aVar.dqP.setStatedChangedListener(this.dqL);
        }
        aVar.aAV.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes.dex */
    public class a {
        public View aAV;
        public TextView aVl;
        public TbCheckBox dqP;
        public HeadImageView dqu;

        public a() {
        }
    }
}
