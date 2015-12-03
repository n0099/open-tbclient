package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.n;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends BaseAdapter {
    private final TbPageContextSupport axg;
    private b ccQ = null;
    private ViewGroup ccR = null;
    private boolean ccS;
    private TbCheckBox.a mCheckBoxStateChangedListener;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public o(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.axg = tbPageContextSupport;
        this.ccS = z;
    }

    public void a(b bVar) {
        this.ccQ = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void setCheckBoxStateChangedListener(TbCheckBox.a aVar) {
        this.mCheckBoxStateChangedListener = aVar;
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
        if (this.ccR == null) {
            this.ccR = viewGroup;
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
            aVar2 = acM();
        } else {
            aVar2 = (a) obj;
        }
        if (this.ccQ != null) {
            this.ccQ.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.getUserPortrait());
        aVar2.aJR.setText(aVar.getUserName());
        if (this.ccS) {
            aVar2.ccT.setVisibility(8);
        } else {
            aVar2.ccT.setTagData(aVar);
        }
        if (this.axg instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.axg).getLayoutMode().k(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.ccx.setTag(str);
            aVar2.ccx.d(str, 12, false);
        }
    }

    private a acM() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.axg.getPageContext().getContext()).inflate(n.g.invite_friend_list_item, (ViewGroup) null);
        aVar.ccx = (HeadImageView) aVar.rootView.findViewById(n.f.photo);
        aVar.ccx.setIsRound(false);
        aVar.aJR = (TextView) aVar.rootView.findViewById(n.f.txt_user_name);
        aVar.ccT = (TbCheckBox) aVar.rootView.findViewById(n.f.ckb_select);
        if (this.mCheckBoxStateChangedListener != null) {
            aVar.ccT.setStatedChangedListener(this.mCheckBoxStateChangedListener);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView aJR;
        public TbCheckBox ccT;
        public HeadImageView ccx;
        public View rootView;

        public a() {
        }
    }
}
