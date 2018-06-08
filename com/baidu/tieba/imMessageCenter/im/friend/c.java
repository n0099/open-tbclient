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
    private final TbPageContextSupport aSi;
    private TbCheckBox.a exE;
    private boolean exG;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;
    private b exF = null;
    private ViewGroup mParent = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.aSi = tbPageContextSupport;
        this.exG = z;
    }

    public void a(b bVar) {
        this.exF = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.exE = aVar;
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
            aVar2 = aMK();
        } else {
            aVar2 = (a) obj;
        }
        if (this.exF != null) {
            this.exF.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.Fg());
        aVar2.bPN.setText(aVar.Fi());
        if (this.exG) {
            aVar2.exH.setVisibility(8);
        } else {
            aVar2.exH.setTagData(aVar);
        }
        if (this.aSi instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.aSi).getLayoutMode().onModeChanged(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.exm.setTag(str);
            aVar2.exm.startLoad(str, 12, false);
        }
    }

    private a aMK() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.aSi.getPageContext().getContext()).inflate(d.i.invite_friend_list_item, (ViewGroup) null);
        aVar.exm = (HeadImageView) aVar.rootView.findViewById(d.g.photo);
        aVar.exm.setIsRound(false);
        aVar.bPN = (TextView) aVar.rootView.findViewById(d.g.txt_user_name);
        aVar.exH = (TbCheckBox) aVar.rootView.findViewById(d.g.ckb_select);
        if (this.exE != null) {
            aVar.exH.setStatedChangedListener(this.exE);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public TextView bPN;
        public TbCheckBox exH;
        public HeadImageView exm;
        public View rootView;

        public a() {
        }
    }
}
