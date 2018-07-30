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
    private final TbPageContextSupport aTe;
    private TbCheckBox.a eFo;
    private boolean eFq;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;
    private b eFp = null;
    private ViewGroup mParent = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.aTe = tbPageContextSupport;
        this.eFq = z;
    }

    public void a(b bVar) {
        this.eFp = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.eFo = aVar;
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
        if (this.mParent == null) {
            this.mParent = viewGroup;
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
            aVar2 = aOq();
        } else {
            aVar2 = (a) obj;
        }
        if (this.eFp != null) {
            this.eFp.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.Fu());
        aVar2.bSR.setText(aVar.Fw());
        if (this.eFq) {
            aVar2.eFr.setVisibility(8);
        } else {
            aVar2.eFr.setTagData(aVar);
        }
        if (this.aTe instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.aTe).getLayoutMode().onModeChanged(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.eEW.setTag(str);
            aVar2.eEW.startLoad(str, 12, false);
        }
    }

    private a aOq() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.aTe.getPageContext().getContext()).inflate(d.h.invite_friend_list_item, (ViewGroup) null);
        aVar.eEW = (HeadImageView) aVar.rootView.findViewById(d.g.photo);
        aVar.eEW.setIsRound(false);
        aVar.bSR = (TextView) aVar.rootView.findViewById(d.g.txt_user_name);
        aVar.eFr = (TbCheckBox) aVar.rootView.findViewById(d.g.ckb_select);
        if (this.eFo != null) {
            aVar.eFr.setStatedChangedListener(this.eFo);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public TextView bSR;
        public HeadImageView eEW;
        public TbCheckBox eFr;
        public View rootView;

        public a() {
        }
    }
}
