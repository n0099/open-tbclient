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
    private final TbPageContextSupport aJG;
    private TbCheckBox.a eli;
    private boolean elk;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;
    private b elj = null;
    private ViewGroup bHh = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view2, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.aJG = tbPageContextSupport;
        this.elk = z;
    }

    public void a(b bVar) {
        this.elj = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.eli = aVar;
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
    public View getView(int i, View view2, ViewGroup viewGroup) {
        a aVar;
        if (this.bHh == null) {
            this.bHh = viewGroup;
        }
        com.baidu.tbadk.coreExtra.relationship.a aVar2 = (com.baidu.tbadk.coreExtra.relationship.a) getItem(i);
        if (aVar2 != null) {
            aVar = a(view2 != null ? view2.getTag() : null, aVar2);
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
            aVar2 = aHR();
        } else {
            aVar2 = (a) obj;
        }
        if (this.elj != null) {
            this.elj.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.BH());
        aVar2.bGp.setText(aVar.getUserName());
        if (this.elk) {
            aVar2.ell.setVisibility(8);
        } else {
            aVar2.ell.setTagData(aVar);
        }
        if (this.aJG instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.aJG).getLayoutMode().u(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.ekR.setTag(str);
            aVar2.ekR.startLoad(str, 12, false);
        }
    }

    private a aHR() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.aJG.getPageContext().getContext()).inflate(d.i.invite_friend_list_item, (ViewGroup) null);
        aVar.ekR = (HeadImageView) aVar.rootView.findViewById(d.g.photo);
        aVar.ekR.setIsRound(false);
        aVar.bGp = (TextView) aVar.rootView.findViewById(d.g.txt_user_name);
        aVar.ell = (TbCheckBox) aVar.rootView.findViewById(d.g.ckb_select);
        if (this.eli != null) {
            aVar.ell.setStatedChangedListener(this.eli);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public TextView bGp;
        public HeadImageView ekR;
        public TbCheckBox ell;
        public View rootView;

        public a() {
        }
    }
}
