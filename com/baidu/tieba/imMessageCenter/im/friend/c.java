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
/* loaded from: classes2.dex */
class c extends BaseAdapter {
    private final TbPageContextSupport fKW;
    private TbCheckBox.a kLG;
    private boolean kLI;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;
    private b kLH = null;
    private ViewGroup mParent = null;

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.fKW = tbPageContextSupport;
        this.kLI = z;
    }

    public void a(b bVar) {
        this.kLH = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.kLG = aVar;
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
            aVar2 = dax();
        } else {
            aVar2 = (a) obj;
        }
        if (this.kLH != null) {
            this.kLH.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.getUserPortrait());
        aVar2.hYe.setText(aVar.bCB());
        if (this.kLI) {
            aVar2.kLJ.setVisibility(8);
        } else {
            aVar2.kLJ.setTagData(aVar);
        }
        if (this.fKW instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.fKW).getLayoutMode().onModeChanged(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.kLo.setTag(str);
            aVar2.kLo.startLoad(str, 12, false);
        }
    }

    private a dax() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.fKW.getPageContext().getContext()).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        aVar.kLo = (HeadImageView) aVar.rootView.findViewById(R.id.photo);
        aVar.kLo.setIsRound(false);
        aVar.hYe = (TextView) aVar.rootView.findViewById(R.id.txt_user_name);
        aVar.kLJ = (TbCheckBox) aVar.rootView.findViewById(R.id.ckb_select);
        if (this.kLG != null) {
            aVar.kLJ.setStatedChangedListener(this.kLG);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public TextView hYe;
        public TbCheckBox kLJ;
        public HeadImageView kLo;
        public View rootView;

        public a() {
        }
    }
}
