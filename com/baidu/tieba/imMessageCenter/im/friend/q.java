package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BaseAdapter {
    private final TbPageContextSupport bsB;
    private com.baidu.tbadk.core.view.aa bsC;
    private s bsD = null;
    private ViewGroup bsE = null;
    private boolean bsF;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;

    public q(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.bsB = tbPageContextSupport;
        this.bsF = z;
    }

    public void a(s sVar) {
        this.bsD = sVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void a(com.baidu.tbadk.core.view.aa aaVar) {
        this.bsC = aaVar;
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
        r rVar;
        if (this.bsE == null) {
            this.bsE = viewGroup;
        }
        com.baidu.tbadk.coreExtra.relationship.a aVar = (com.baidu.tbadk.coreExtra.relationship.a) getItem(i);
        if (aVar != null) {
            rVar = a(view != null ? view.getTag() : null, aVar);
        } else {
            rVar = null;
        }
        if (rVar != null) {
            return rVar.rootView;
        }
        return null;
    }

    private r a(Object obj, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        r rVar;
        if (obj == null) {
            rVar = Vv();
        } else {
            rVar = (r) obj;
        }
        if (this.bsD != null) {
            this.bsD.a(rVar.rootView, aVar);
        }
        a(aVar, rVar, aVar.getUserPortrait());
        rVar.azt.setText(aVar.getUserName());
        if (this.bsF) {
            rVar.bsG.setVisibility(8);
        } else {
            rVar.bsG.setTagData(aVar);
        }
        if (this.bsB instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.bsB).getLayoutMode().h(rVar.rootView);
        }
        return rVar;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, r rVar, String str) {
        if (aVar != null) {
            rVar.bsi.setTag(str);
            rVar.bsi.c(str, 12, false);
        }
    }

    private r Vv() {
        r rVar = new r(this);
        rVar.rootView = com.baidu.adp.lib.g.b.hH().inflate(this.bsB.getPageContext().getContext(), com.baidu.tieba.w.invite_friend_list_item, null);
        rVar.bsi = (HeadImageView) rVar.rootView.findViewById(com.baidu.tieba.v.photo);
        rVar.bsi.setIsRound(false);
        rVar.azt = (TextView) rVar.rootView.findViewById(com.baidu.tieba.v.txt_user_name);
        rVar.bsG = (TbCheckBox) rVar.rootView.findViewById(com.baidu.tieba.v.ckb_select);
        if (this.bsC != null) {
            rVar.bsG.setStatedChangedListener(this.bsC);
        }
        rVar.rootView.setTag(rVar);
        return rVar;
    }
}
