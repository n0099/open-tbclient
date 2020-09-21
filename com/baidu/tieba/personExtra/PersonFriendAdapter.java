package com.baidu.tieba.personExtra;

import com.baidu.tbadk.core.BaseFragment;
/* loaded from: classes23.dex */
public class PersonFriendAdapter extends BasePersonInfoAdapter {
    public PersonFriendAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity, z);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoAdapter
    protected BaseFragment dkK() {
        return new PersonFriendFragment();
    }
}
