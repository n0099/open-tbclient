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
/* loaded from: classes22.dex */
class c extends BaseAdapter {
    private final TbPageContextSupport fgb;
    private TbCheckBox.a jZV;
    private boolean jZX;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;
    private b jZW = null;
    private ViewGroup mParent = null;

    /* loaded from: classes22.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.fgb = tbPageContextSupport;
        this.jZX = z;
    }

    public void a(b bVar) {
        this.jZW = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.jZV = aVar;
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
            aVar2 = cQt();
        } else {
            aVar2 = (a) obj;
        }
        if (this.jZW != null) {
            this.jZW.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.bsX());
        aVar2.hkx.setText(aVar.bsZ());
        if (this.jZX) {
            aVar2.jZY.setVisibility(8);
        } else {
            aVar2.jZY.setTagData(aVar);
        }
        if (this.fgb instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.fgb).getLayoutMode().onModeChanged(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.jZC.setTag(str);
            aVar2.jZC.startLoad(str, 12, false);
        }
    }

    private a cQt() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.fgb.getPageContext().getContext()).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        aVar.jZC = (HeadImageView) aVar.rootView.findViewById(R.id.photo);
        aVar.jZC.setIsRound(false);
        aVar.hkx = (TextView) aVar.rootView.findViewById(R.id.txt_user_name);
        aVar.jZY = (TbCheckBox) aVar.rootView.findViewById(R.id.ckb_select);
        if (this.jZV != null) {
            aVar.jZY.setStatedChangedListener(this.jZV);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes22.dex */
    public class a {
        public TextView hkx;
        public HeadImageView jZC;
        public TbCheckBox jZY;
        public View rootView;

        public a() {
        }
    }
}
