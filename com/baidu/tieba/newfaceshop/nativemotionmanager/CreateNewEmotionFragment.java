package com.baidu.tieba.newfaceshop.nativemotionmanager;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.NativeEmotionManagerActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.i0.y1.g.e;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class CreateNewEmotionFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.y1.h.f.a f18941e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f18942f = new a(2921040);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof HashMap)) {
                return;
            }
            HashMap hashMap = (HashMap) customResponsedMessage.getData();
            if (CreateNewEmotionFragment.this.f18941e == null) {
                return;
            }
            if (hashMap == null || hashMap.isEmpty()) {
                if (CreateNewEmotionFragment.this.f18941e != null) {
                    CreateNewEmotionFragment.this.f18941e.i();
                }
            } else if (!hashMap.containsKey("upload_result")) {
                if (CreateNewEmotionFragment.this.f18941e != null) {
                    CreateNewEmotionFragment.this.f18941e.i();
                }
            } else if (hashMap.get("upload_result") == null || !(hashMap.get("upload_result") instanceof Boolean)) {
                if (CreateNewEmotionFragment.this.f18941e != null) {
                    CreateNewEmotionFragment.this.f18941e.i();
                }
            } else if (!((Boolean) hashMap.get("upload_result")).booleanValue()) {
                if (CreateNewEmotionFragment.this.f18941e != null) {
                    String str = (String) hashMap.get("upload_msg");
                    if (!TextUtils.isEmpty(str)) {
                        l.I(CreateNewEmotionFragment.this.getActivity(), str);
                    } else {
                        l.I(CreateNewEmotionFragment.this.getActivity(), CreateNewEmotionFragment.this.getString(R.string.emotion_error_default_net_tip));
                    }
                    CreateNewEmotionFragment.this.f18941e.l();
                }
            } else {
                BdToast.c(CreateNewEmotionFragment.this.getPageContext().getPageActivity(), CreateNewEmotionFragment.this.getPageContext().getPageActivity().getText(R.string.face_group_upload_success)).q();
                if (CreateNewEmotionFragment.this.f18941e != null) {
                    CreateNewEmotionFragment.this.f18941e.i();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
            }
        }
    }

    public final void F0() {
        if (this.f18941e == null) {
            return;
        }
        if (e.l().r()) {
            this.f18941e.j();
        } else if (e.l().k() == null) {
            this.f18941e.i();
        } else {
            this.f18941e.m(getString(R.string.emotion_draft_tip));
        }
    }

    public final int G0() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getInt(NativeEmotionManagerActivityConfig.KEY, 0);
        }
        return 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        d.b.i0.y1.h.f.a aVar = this.f18941e;
        if (aVar != null) {
            aVar.g(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        registerListener(this.f18942f);
        d.b.i0.y1.h.f.a aVar = new d.b.i0.y1.h.f.a(getPageContext(), G0());
        this.f18941e = aVar;
        return aVar.f();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.b.i0.y1.h.f.a aVar = this.f18941e;
        if (aVar != null) {
            aVar.h();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        F0();
    }
}
