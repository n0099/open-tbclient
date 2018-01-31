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
    private final TbPageContextSupport bxn;
    private TbCheckBox.a eMH;
    private boolean eMJ;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;
    private b eMI = null;
    private ViewGroup cnf = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.bxn = tbPageContextSupport;
        this.eMJ = z;
    }

    public void a(b bVar) {
        this.eMI = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.eMH = aVar;
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
        if (this.cnf == null) {
            this.cnf = viewGroup;
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
            aVar2 = aLu();
        } else {
            aVar2 = (a) obj;
        }
        if (this.eMI != null) {
            this.eMI.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.In());
        aVar2.cQi.setText(aVar.getUserName());
        if (this.eMJ) {
            aVar2.eMK.setVisibility(8);
        } else {
            aVar2.eMK.setTagData(aVar);
        }
        if (this.bxn instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.bxn).getLayoutMode().aM(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.eMq.setTag(str);
            aVar2.eMq.startLoad(str, 12, false);
        }
    }

    private a aLu() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.bxn.getPageContext().getContext()).inflate(d.h.invite_friend_list_item, (ViewGroup) null);
        aVar.eMq = (HeadImageView) aVar.rootView.findViewById(d.g.photo);
        aVar.eMq.setIsRound(false);
        aVar.cQi = (TextView) aVar.rootView.findViewById(d.g.txt_user_name);
        aVar.eMK = (TbCheckBox) aVar.rootView.findViewById(d.g.ckb_select);
        if (this.eMH != null) {
            aVar.eMK.setStatedChangedListener(this.eMH);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public TextView cQi;
        public TbCheckBox eMK;
        public HeadImageView eMq;
        public View rootView;

        public a() {
        }
    }
}
