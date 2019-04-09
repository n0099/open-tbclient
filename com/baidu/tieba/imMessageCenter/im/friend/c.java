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
/* loaded from: classes4.dex */
class c extends BaseAdapter {
    private final TbPageContextSupport cpH;
    private TbCheckBox.a gvP;
    private boolean gvR;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;
    private b gvQ = null;
    private ViewGroup mParent = null;

    /* loaded from: classes4.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.cpH = tbPageContextSupport;
        this.gvR = z;
    }

    public void a(b bVar) {
        this.gvQ = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.gvP = aVar;
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
            aVar2 = bwU();
        } else {
            aVar2 = (a) obj;
        }
        if (this.gvQ != null) {
            this.gvQ.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.ajL());
        aVar2.eeB.setText(aVar.ajN());
        if (this.gvR) {
            aVar2.gvS.setVisibility(8);
        } else {
            aVar2.gvS.setTagData(aVar);
        }
        if (this.cpH instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.cpH).getLayoutMode().onModeChanged(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.gvx.setTag(str);
            aVar2.gvx.startLoad(str, 12, false);
        }
    }

    private a bwU() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.cpH.getPageContext().getContext()).inflate(d.h.invite_friend_list_item, (ViewGroup) null);
        aVar.gvx = (HeadImageView) aVar.rootView.findViewById(d.g.photo);
        aVar.gvx.setIsRound(false);
        aVar.eeB = (TextView) aVar.rootView.findViewById(d.g.txt_user_name);
        aVar.gvS = (TbCheckBox) aVar.rootView.findViewById(d.g.ckb_select);
        if (this.gvP != null) {
            aVar.gvS.setStatedChangedListener(this.gvP);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes4.dex */
    public class a {
        public TextView eeB;
        public TbCheckBox gvS;
        public HeadImageView gvx;
        public View rootView;

        public a() {
        }
    }
}
