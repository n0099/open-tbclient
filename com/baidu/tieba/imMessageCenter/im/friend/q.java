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
    private final TbPageContextSupport bsR;
    private com.baidu.tbadk.core.view.aa bsS;
    private s bsT = null;
    private ViewGroup bsU = null;
    private boolean bsV;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;

    public q(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.bsR = tbPageContextSupport;
        this.bsV = z;
    }

    public void a(s sVar) {
        this.bsT = sVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void a(com.baidu.tbadk.core.view.aa aaVar) {
        this.bsS = aaVar;
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
        if (this.bsU == null) {
            this.bsU = viewGroup;
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
            rVar = VI();
        } else {
            rVar = (r) obj;
        }
        if (this.bsT != null) {
            this.bsT.a(rVar.rootView, aVar);
        }
        a(aVar, rVar, aVar.getUserPortrait());
        rVar.azB.setText(aVar.getUserName());
        if (this.bsV) {
            rVar.bsW.setVisibility(8);
        } else {
            rVar.bsW.setTagData(aVar);
        }
        if (this.bsR instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.bsR).getLayoutMode().h(rVar.rootView);
        }
        return rVar;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, r rVar, String str) {
        if (aVar != null) {
            rVar.bsy.setTag(str);
            rVar.bsy.c(str, 12, false);
        }
    }

    private r VI() {
        r rVar = new r(this);
        rVar.rootView = com.baidu.adp.lib.g.b.hH().inflate(this.bsR.getPageContext().getContext(), com.baidu.tieba.w.invite_friend_list_item, null);
        rVar.bsy = (HeadImageView) rVar.rootView.findViewById(com.baidu.tieba.v.photo);
        rVar.bsy.setIsRound(false);
        rVar.azB = (TextView) rVar.rootView.findViewById(com.baidu.tieba.v.txt_user_name);
        rVar.bsW = (TbCheckBox) rVar.rootView.findViewById(com.baidu.tieba.v.ckb_select);
        if (this.bsS != null) {
            rVar.bsW.setStatedChangedListener(this.bsS);
        }
        rVar.rootView.setTag(rVar);
        return rVar;
    }
}
