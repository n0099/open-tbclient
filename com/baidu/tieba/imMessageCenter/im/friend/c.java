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
    private final TbPageContextSupport fuv;
    private TbCheckBox.a ksr;
    private boolean kst;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;
    private b kss = null;
    private ViewGroup mParent = null;

    /* loaded from: classes22.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.fuv = tbPageContextSupport;
        this.kst = z;
    }

    public void a(b bVar) {
        this.kss = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.ksr = aVar;
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
            aVar2 = cWb();
        } else {
            aVar2 = (a) obj;
        }
        if (this.kss != null) {
            this.kss.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.getUserPortrait());
        aVar2.hCp.setText(aVar.bxr());
        if (this.kst) {
            aVar2.ksu.setVisibility(8);
        } else {
            aVar2.ksu.setTagData(aVar);
        }
        if (this.fuv instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.fuv).getLayoutMode().onModeChanged(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.krY.setTag(str);
            aVar2.krY.startLoad(str, 12, false);
        }
    }

    private a cWb() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.fuv.getPageContext().getContext()).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        aVar.krY = (HeadImageView) aVar.rootView.findViewById(R.id.photo);
        aVar.krY.setIsRound(false);
        aVar.hCp = (TextView) aVar.rootView.findViewById(R.id.txt_user_name);
        aVar.ksu = (TbCheckBox) aVar.rootView.findViewById(R.id.ckb_select);
        if (this.ksr != null) {
            aVar.ksu.setStatedChangedListener(this.ksr);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes22.dex */
    public class a {
        public TextView hCp;
        public HeadImageView krY;
        public TbCheckBox ksu;
        public View rootView;

        public a() {
        }
    }
}
