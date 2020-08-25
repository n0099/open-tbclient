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
/* loaded from: classes16.dex */
class c extends BaseAdapter {
    private final TbPageContextSupport eQY;
    private TbCheckBox.a jCq;
    private boolean jCs;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;
    private b jCr = null;
    private ViewGroup mParent = null;

    /* loaded from: classes16.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.eQY = tbPageContextSupport;
        this.jCs = z;
    }

    public void a(b bVar) {
        this.jCr = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.jCq = aVar;
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
            aVar2 = cJe();
        } else {
            aVar2 = (a) obj;
        }
        if (this.jCr != null) {
            this.jCr.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.bps());
        aVar2.gRO.setText(aVar.bpu());
        if (this.jCs) {
            aVar2.jCt.setVisibility(8);
        } else {
            aVar2.jCt.setTagData(aVar);
        }
        if (this.eQY instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.eQY).getLayoutMode().onModeChanged(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.jBX.setTag(str);
            aVar2.jBX.startLoad(str, 12, false);
        }
    }

    private a cJe() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.eQY.getPageContext().getContext()).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        aVar.jBX = (HeadImageView) aVar.rootView.findViewById(R.id.photo);
        aVar.jBX.setIsRound(false);
        aVar.gRO = (TextView) aVar.rootView.findViewById(R.id.txt_user_name);
        aVar.jCt = (TbCheckBox) aVar.rootView.findViewById(R.id.ckb_select);
        if (this.jCq != null) {
            aVar.jCt.setStatedChangedListener(this.jCq);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes16.dex */
    public class a {
        public TextView gRO;
        public HeadImageView jBX;
        public TbCheckBox jCt;
        public View rootView;

        public a() {
        }
    }
}
