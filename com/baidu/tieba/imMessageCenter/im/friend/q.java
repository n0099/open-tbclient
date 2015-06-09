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
    private final TbPageContextSupport bvD;
    private s bvE = null;
    private ViewGroup bvF = null;
    private boolean bvG;
    private af mCheckBoxStateChangedListener;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;

    public q(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.bvD = tbPageContextSupport;
        this.bvG = z;
    }

    public void a(s sVar) {
        this.bvE = sVar;
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
        if (this.bvF == null) {
            this.bvF = viewGroup;
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
            rVar = Xb();
        } else {
            rVar = (r) obj;
        }
        if (this.bvE != null) {
            this.bvE.a(rVar.rootView, aVar);
        }
        a(aVar, rVar, aVar.getUserPortrait());
        rVar.aBn.setText(aVar.getUserName());
        if (this.bvG) {
            rVar.bvH.setVisibility(8);
        } else {
            rVar.bvH.setTagData(aVar);
        }
        if (this.bvD instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.bvD).getLayoutMode().j(rVar.rootView);
        }
        return rVar;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, r rVar, String str) {
        if (aVar != null) {
            rVar.bvk.setTag(str);
            rVar.bvk.c(str, 12, false);
        }
    }

    private r Xb() {
        r rVar = new r(this);
        rVar.rootView = com.baidu.adp.lib.g.b.hr().inflate(this.bvD.getPageContext().getContext(), com.baidu.tieba.r.invite_friend_list_item, null);
        rVar.bvk = (HeadImageView) rVar.rootView.findViewById(com.baidu.tieba.q.photo);
        rVar.bvk.setIsRound(false);
        rVar.aBn = (TextView) rVar.rootView.findViewById(com.baidu.tieba.q.txt_user_name);
        rVar.bvH = (TbCheckBox) rVar.rootView.findViewById(com.baidu.tieba.q.ckb_select);
        if (this.mCheckBoxStateChangedListener != null) {
            rVar.bvH.setStatedChangedListener(this.mCheckBoxStateChangedListener);
        }
        rVar.rootView.setTag(rVar);
        return rVar;
    }
}
