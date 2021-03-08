package com.baidu.tieba.newfaceshop.nativemotionmanager;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.NativeEmotionManagerActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.R;
import com.baidu.tieba.newfaceshop.facemake.e;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class CreateNewEmotionFragment extends BaseFragment {
    CustomMessageListener iZC = new CustomMessageListener(CmdConfigCustom.CMD_UPLOAD_FACE_GROUP_FINISH) { // from class: com.baidu.tieba.newfaceshop.nativemotionmanager.CreateNewEmotionFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                if (CreateNewEmotionFragment.this.lES != null) {
                    if (hashMap == null || hashMap.isEmpty()) {
                        if (CreateNewEmotionFragment.this.lES != null) {
                            CreateNewEmotionFragment.this.lES.cAn();
                        }
                    } else if (!hashMap.containsKey("upload_result")) {
                        if (CreateNewEmotionFragment.this.lES != null) {
                            CreateNewEmotionFragment.this.lES.cAn();
                        }
                    } else if (hashMap.get("upload_result") == null || !(hashMap.get("upload_result") instanceof Boolean)) {
                        if (CreateNewEmotionFragment.this.lES != null) {
                            CreateNewEmotionFragment.this.lES.cAn();
                        }
                    } else if (!((Boolean) hashMap.get("upload_result")).booleanValue()) {
                        if (CreateNewEmotionFragment.this.lES != null) {
                            String str = (String) hashMap.get("upload_msg");
                            if (!TextUtils.isEmpty(str)) {
                                l.showLongToast(CreateNewEmotionFragment.this.getActivity(), str);
                            } else {
                                l.showLongToast(CreateNewEmotionFragment.this.getActivity(), CreateNewEmotionFragment.this.getString(R.string.emotion_error_default_net_tip));
                            }
                            CreateNewEmotionFragment.this.lES.cAp();
                        }
                    } else {
                        BdToast.b(CreateNewEmotionFragment.this.getPageContext().getPageActivity(), CreateNewEmotionFragment.this.getPageContext().getPageActivity().getText(R.string.face_group_upload_success)).bqF();
                        if (CreateNewEmotionFragment.this.lES != null) {
                            CreateNewEmotionFragment.this.lES.cAn();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH_MY_EMOTION_PACKAGE));
                    }
                }
            }
        }
    };
    private com.baidu.tieba.newfaceshop.nativemotionmanager.view.a lES;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        registerListener(this.iZC);
        this.lES = new com.baidu.tieba.newfaceshop.nativemotionmanager.view.a(getPageContext(), djg());
        return this.lES.getView();
    }

    private int djg() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getInt(NativeEmotionManagerActivityConfig.KEY, 0);
        }
        return 0;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        czZ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.lES != null) {
            this.lES.onDestroy();
        }
    }

    private void czZ() {
        if (this.lES != null) {
            if (e.diT().diV()) {
                this.lES.cAo();
            } else if (e.diT().diU() == null) {
                this.lES.cAn();
            } else {
                this.lES.Pc(getString(R.string.emotion_draft_tip));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lES != null) {
            this.lES.onChangeSkinType(i);
        }
    }
}
