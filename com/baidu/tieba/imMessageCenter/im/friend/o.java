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
    private final TbPageContextSupport ayK;
    private b cgQ = null;
    private ViewGroup cgR = null;
    private boolean cgS;
    private TbCheckBox.a mCheckBoxStateChangedListener;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;

    /* loaded from: classes.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public o(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.ayK = tbPageContextSupport;
        this.cgS = z;
    }

    public void a(b bVar) {
        this.cgQ = bVar;
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
        if (this.cgR == null) {
            this.cgR = viewGroup;
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
            aVar2 = adV();
        } else {
            aVar2 = (a) obj;
        }
        if (this.cgQ != null) {
            this.cgQ.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.getUserPortrait());
        aVar2.aLp.setText(aVar.getUserName());
        if (this.cgS) {
            aVar2.cgT.setVisibility(8);
        } else {
            aVar2.cgT.setTagData(aVar);
        }
        if (this.ayK instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.ayK).getLayoutMode().k(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.cgx.setTag(str);
            aVar2.cgx.d(str, 12, false);
        }
    }

    private a adV() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.ayK.getPageContext().getContext()).inflate(n.h.invite_friend_list_item, (ViewGroup) null);
        aVar.cgx = (HeadImageView) aVar.rootView.findViewById(n.g.photo);
        aVar.cgx.setIsRound(false);
        aVar.aLp = (TextView) aVar.rootView.findViewById(n.g.txt_user_name);
        aVar.cgT = (TbCheckBox) aVar.rootView.findViewById(n.g.ckb_select);
        if (this.mCheckBoxStateChangedListener != null) {
            aVar.cgT.setStatedChangedListener(this.mCheckBoxStateChangedListener);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView aLp;
        public TbCheckBox cgT;
        public HeadImageView cgx;
        public View rootView;

        public a() {
        }
    }
}
