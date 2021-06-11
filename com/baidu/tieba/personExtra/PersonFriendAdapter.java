package com.baidu.tieba.personExtra;

import com.baidu.tbadk.core.BaseFragment;
/* loaded from: classes5.dex */
public class PersonFriendAdapter extends BasePersonInfoAdapter {
    public PersonFriendAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity, z);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoAdapter
    public BaseFragment e() {
        return new PersonFriendFragment();
    }
}
