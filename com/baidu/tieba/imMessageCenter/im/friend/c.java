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
/* loaded from: classes7.dex */
class c extends BaseAdapter {
    private final TbPageContextSupport dyL;
    private TbCheckBox.a hKP;
    private boolean hKR;
    private List<com.baidu.tbadk.coreExtra.relationship.a> mData;
    private b hKQ = null;
    private ViewGroup mParent = null;

    /* loaded from: classes7.dex */
    public interface b {
        void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        this.dyL = tbPageContextSupport;
        this.hKR = z;
    }

    public void a(b bVar) {
        this.hKQ = bVar;
    }

    public void setData(List<com.baidu.tbadk.coreExtra.relationship.a> list) {
        this.mData = list;
    }

    public void a(TbCheckBox.a aVar) {
        this.hKP = aVar;
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
            aVar2 = bXs();
        } else {
            aVar2 = (a) obj;
        }
        if (this.hKQ != null) {
            this.hKQ.a(aVar2.rootView, aVar);
        }
        a(aVar, aVar2, aVar.aJR());
        aVar2.fqi.setText(aVar.aJT());
        if (this.hKR) {
            aVar2.hKS.setVisibility(8);
        } else {
            aVar2.hKS.setTagData(aVar);
        }
        if (this.dyL instanceof InviteFriendListActivity) {
            ((InviteFriendListActivity) this.dyL).getLayoutMode().onModeChanged(aVar2.rootView);
        }
        return aVar2;
    }

    private void a(com.baidu.tbadk.coreExtra.relationship.a aVar, a aVar2, String str) {
        if (aVar != null) {
            aVar2.hKx.setTag(str);
            aVar2.hKx.startLoad(str, 12, false);
        }
    }

    private a bXs() {
        a aVar = new a();
        aVar.rootView = LayoutInflater.from(this.dyL.getPageContext().getContext()).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
        aVar.hKx = (HeadImageView) aVar.rootView.findViewById(R.id.photo);
        aVar.hKx.setIsRound(false);
        aVar.fqi = (TextView) aVar.rootView.findViewById(R.id.txt_user_name);
        aVar.hKS = (TbCheckBox) aVar.rootView.findViewById(R.id.ckb_select);
        if (this.hKP != null) {
            aVar.hKS.setStatedChangedListener(this.hKP);
        }
        aVar.rootView.setTag(aVar);
        return aVar;
    }

    /* loaded from: classes7.dex */
    public class a {
        public TextView fqi;
        public TbCheckBox hKS;
        public HeadImageView hKx;
        public View rootView;

        public a() {
        }
    }
}
