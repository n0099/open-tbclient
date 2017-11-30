package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
class c extends BaseAdapter {
    private final TbPageContextSupport aJa;
    private TbCheckBox.a dXA;
    private boolean dXC;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;
    private b dXB = null;
    private ViewGroup byF = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.aJa = tbPageContextSupport;
        this.dXC = z;
    }

    public void a(b bVar) {
        this.dXB = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.dXA = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData == null) {
            return 0;
        }
        return this.mData.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mData == null) {
            return null;
        }
        return this.mData.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.byF == null) {
            this.byF = viewGroup;
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
            aVar2 = aEa();
        } else {
            aVar2 = (a) obj;
        }
        if (this.dXB != null) {
            this.dXB.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.AP());
        aVar2.bWx.setText(aVar.getUserName());
        if (this.dXC) {
            aVar2.dXD.setVisibility(8);
        } else {
            aVar2.dXD.setTagData(aVar);
        }
        if (this.aJa instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.aJa).getLayoutMode().t(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.dXj.setTag(str);
            aVar2.dXj.startLoad(str, 12, false);
        }
    }

    private a aEa() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.aJa.getPageContext().getContext()).inflate(d.h.invite_friend_list_item, (ViewGroup) null);
        aVar.dXj = (HeadImageView) aVar.rootView.findViewById(d.g.photo);
        aVar.dXj.setIsRound(false);
        aVar.bWx = (TextView) aVar.rootView.findViewById(d.g.txt_user_name);
        aVar.dXD = (TbCheckBox) aVar.rootView.findViewById(d.g.ckb_select);
        if (this.dXA != null) {
            aVar.dXD.setStatedChangedListener(this.dXA);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public TextView bWx;
        public TbCheckBox dXD;
        public HeadImageView dXj;
        public View rootView;

        public a() {
        }
    }
}
