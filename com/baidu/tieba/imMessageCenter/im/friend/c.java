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
    private final TbPageContextSupport bzh;
    private TbCheckBox.a eQE;
    private boolean eQG;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;
    private b eQF = null;
    private ViewGroup cqU = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.bzh = tbPageContextSupport;
        this.eQG = z;
    }

    public void a(b bVar) {
        this.eQF = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.eQE = aVar;
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
        if (this.cqU == null) {
            this.cqU = viewGroup;
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
            aVar2 = aMV();
        } else {
            aVar2 = (a) obj;
        }
        if (this.eQF != null) {
            this.eQF.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.IS());
        aVar2.cqi.setText(aVar.getUserName());
        if (this.eQG) {
            aVar2.eQH.setVisibility(8);
        } else {
            aVar2.eQH.setTagData(aVar);
        }
        if (this.bzh instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.bzh).getLayoutMode().aM(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.eQn.setTag(str);
            aVar2.eQn.startLoad(str, 12, false);
        }
    }

    private a aMV() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.bzh.getPageContext().getContext()).inflate(d.h.invite_friend_list_item, (ViewGroup) null);
        aVar.eQn = (HeadImageView) aVar.rootView.findViewById(d.g.photo);
        aVar.eQn.setIsRound(false);
        aVar.cqi = (TextView) aVar.rootView.findViewById(d.g.txt_user_name);
        aVar.eQH = (TbCheckBox) aVar.rootView.findViewById(d.g.ckb_select);
        if (this.eQE != null) {
            aVar.eQH.setStatedChangedListener(this.eQE);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public TextView cqi;
        public TbCheckBox eQH;
        public HeadImageView eQn;
        public View rootView;

        public a() {
        }
    }
}
