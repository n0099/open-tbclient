package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.core.view.af;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BaseAdapter {
    private final TbPageContextSupport bvC;
    private s bvD = null;
    private ViewGroup bvE = null;
    private boolean bvF;
    private af mCheckBoxStateChangedListener;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;

    public q(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.bvC = tbPageContextSupport;
        this.bvF = z;
    }

    public void a(s sVar) {
        this.bvD = sVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void setCheckBoxStateChangedListener(af afVar) {
        this.mCheckBoxStateChangedListener = afVar;
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
        if (this.bvE == null) {
            this.bvE = viewGroup;
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
            rVar = Xa();
        } else {
            rVar = (r) obj;
        }
        if (this.bvD != null) {
            this.bvD.a(rVar.rootView, aVar);
        }
        a(aVar, rVar, aVar.getUserPortrait());
        rVar.aBm.setText(aVar.getUserName());
        if (this.bvF) {
            rVar.bvG.setVisibility(8);
        } else {
            rVar.bvG.setTagData(aVar);
        }
        if (this.bvC instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.bvC).getLayoutMode().j(rVar.rootView);
        }
        return rVar;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, r rVar, String str) {
        if (aVar != null) {
            rVar.bvj.setTag(str);
            rVar.bvj.c(str, 12, false);
        }
    }

    private r Xa() {
        r rVar = new r(this);
        rVar.rootView = com.baidu.adp.lib.g.b.hr().inflate(this.bvC.getPageContext().getContext(), com.baidu.tieba.r.invite_friend_list_item, null);
        rVar.bvj = (HeadImageView) rVar.rootView.findViewById(com.baidu.tieba.q.photo);
        rVar.bvj.setIsRound(false);
        rVar.aBm = (TextView) rVar.rootView.findViewById(com.baidu.tieba.q.txt_user_name);
        rVar.bvG = (TbCheckBox) rVar.rootView.findViewById(com.baidu.tieba.q.ckb_select);
        if (this.mCheckBoxStateChangedListener != null) {
            rVar.bvG.setStatedChangedListener(this.mCheckBoxStateChangedListener);
        }
        rVar.rootView.setTag(rVar);
        return rVar;
    }
}
