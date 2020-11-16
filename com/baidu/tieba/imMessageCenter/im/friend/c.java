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
/* loaded from: classes21.dex */
class c extends BaseAdapter {
    private final TbPageContextSupport ftF;
    private TbCheckBox.a ktb;
    private boolean ktd;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;
    private b ktc = null;
    private ViewGroup mParent = null;

    /* loaded from: classes21.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.ftF = tbPageContextSupport;
        this.ktd = z;
    }

    public void a(b bVar) {
        this.ktc = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.ktb = aVar;
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
            aVar2 = cVH();
        } else {
            aVar2 = (a) obj;
        }
        if (this.ktc != null) {
            this.ktc.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.getUserPortrait());
        aVar2.hBW.setText(aVar.bwH());
        if (this.ktd) {
            aVar2.kte.setVisibility(8);
        } else {
            aVar2.kte.setTagData(aVar);
        }
        if (this.ftF instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.ftF).getLayoutMode().onModeChanged(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.ksI.setTag(str);
            aVar2.ksI.startLoad(str, 12, false);
        }
    }

    private a cVH() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.ftF.getPageContext().getContext()).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        aVar.ksI = (HeadImageView) aVar.rootView.findViewById(R.id.photo);
        aVar.ksI.setIsRound(false);
        aVar.hBW = (TextView) aVar.rootView.findViewById(R.id.txt_user_name);
        aVar.kte = (TbCheckBox) aVar.rootView.findViewById(R.id.ckb_select);
        if (this.ktb != null) {
            aVar.kte.setStatedChangedListener(this.ktb);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes21.dex */
    public class a {
        public TextView hBW;
        public HeadImageView ksI;
        public TbCheckBox kte;
        public View rootView;

        public a() {
        }
    }
}
