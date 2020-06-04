package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
class c extends BaseAdapter {
    private final TbPageContextSupport erk;
    private TbCheckBox.a iNS;
    private boolean iNU;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;
    private b iNT = null;
    private ViewGroup mParent = null;

    /* loaded from: classes9.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.erk = tbPageContextSupport;
        this.iNU = z;
    }

    public void a(b bVar) {
        this.iNT = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.iNS = aVar;
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
            aVar2 = cqv();
        } else {
            aVar2 = (a) obj;
        }
        if (this.iNT != null) {
            this.iNT.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.baY());
        aVar2.gnb.setText(aVar.bba());
        if (this.iNU) {
            aVar2.iNV.setVisibility(8);
        } else {
            aVar2.iNV.setTagData(aVar);
        }
        if (this.erk instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.erk).getLayoutMode().onModeChanged(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.iNz.setTag(str);
            aVar2.iNz.startLoad(str, 12, false);
        }
    }

    private a cqv() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.erk.getPageContext().getContext()).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        aVar.iNz = (HeadImageView) aVar.rootView.findViewById(R.id.photo);
        aVar.iNz.setIsRound(false);
        aVar.gnb = (TextView) aVar.rootView.findViewById(R.id.txt_user_name);
        aVar.iNV = (TbCheckBox) aVar.rootView.findViewById(R.id.ckb_select);
        if (this.iNS != null) {
            aVar.iNV.setStatedChangedListener(this.iNS);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes9.dex */
    public class a {
        public TextView gnb;
        public TbCheckBox iNV;
        public HeadImageView iNz;
        public View rootView;

        public a() {
        }
    }
}
