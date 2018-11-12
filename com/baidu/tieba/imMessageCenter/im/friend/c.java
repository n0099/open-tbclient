package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes4.dex */
class c extends BaseAdapter {
    private final TbPageContextSupport bbG;
    private TbCheckBox.a eVB;
    private boolean eVD;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;
    private b eVC = null;
    private ViewGroup mParent = null;

    /* loaded from: classes4.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.bbG = tbPageContextSupport;
        this.eVD = z;
    }

    public void a(b bVar) {
        this.eVC = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.eVB = aVar;
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
            aVar2 = aTn();
        } else {
            aVar2 = (a) obj;
        }
        if (this.eVC != null) {
            this.eVC.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.IX());
        aVar2.chp.setText(aVar.IZ());
        if (this.eVD) {
            aVar2.eVE.setVisibility(8);
        } else {
            aVar2.eVE.setTagData(aVar);
        }
        if (this.bbG instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.bbG).getLayoutMode().onModeChanged(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.eVj.setTag(str);
            aVar2.eVj.startLoad(str, 12, false);
        }
    }

    private a aTn() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.bbG.getPageContext().getContext()).inflate(e.h.invite_friend_list_item, (ViewGroup) null);
        aVar.eVj = (HeadImageView) aVar.rootView.findViewById(e.g.photo);
        aVar.eVj.setIsRound(false);
        aVar.chp = (TextView) aVar.rootView.findViewById(e.g.txt_user_name);
        aVar.eVE = (TbCheckBox) aVar.rootView.findViewById(e.g.ckb_select);
        if (this.eVB != null) {
            aVar.eVE.setStatedChangedListener(this.eVB);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes4.dex */
    public class a {
        public TextView chp;
        public TbCheckBox eVE;
        public HeadImageView eVj;
        public View rootView;

        public a() {
        }
    }
}
