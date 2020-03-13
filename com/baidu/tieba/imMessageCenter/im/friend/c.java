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
    private final TbPageContextSupport dCZ;
    private TbCheckBox.a hNb;
    private boolean hNd;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;
    private b hNc = null;
    private ViewGroup mParent = null;

    /* loaded from: classes9.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.dCZ = tbPageContextSupport;
        this.hNd = z;
    }

    public void a(b bVar) {
        this.hNc = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.hNb = aVar;
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
            aVar2 = bYW();
        } else {
            aVar2 = (a) obj;
        }
        if (this.hNc != null) {
            this.hNc.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.aMo());
        aVar2.fsZ.setText(aVar.aMq());
        if (this.hNd) {
            aVar2.hNe.setVisibility(8);
        } else {
            aVar2.hNe.setTagData(aVar);
        }
        if (this.dCZ instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.dCZ).getLayoutMode().onModeChanged(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.hMJ.setTag(str);
            aVar2.hMJ.startLoad(str, 12, false);
        }
    }

    private a bYW() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.dCZ.getPageContext().getContext()).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        aVar.hMJ = (HeadImageView) aVar.rootView.findViewById(R.id.photo);
        aVar.hMJ.setIsRound(false);
        aVar.fsZ = (TextView) aVar.rootView.findViewById(R.id.txt_user_name);
        aVar.hNe = (TbCheckBox) aVar.rootView.findViewById(R.id.ckb_select);
        if (this.hNb != null) {
            aVar.hNe.setStatedChangedListener(this.hNb);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes9.dex */
    public class a {
        public TextView fsZ;
        public HeadImageView hMJ;
        public TbCheckBox hNe;
        public View rootView;

        public a() {
        }
    }
}
