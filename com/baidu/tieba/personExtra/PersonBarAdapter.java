package com.baidu.tieba.personExtra;

import com.baidu.tbadk.core.BaseFragment;
/* loaded from: classes6.dex */
public class PersonBarAdapter extends BasePersonInfoAdapter {
    public PersonBarAdapter(BasePersonInfoActivity basePersonInfoActivity, boolean z) {
        super(basePersonInfoActivity, z);
    }

    @Override // com.baidu.tieba.personExtra.BasePersonInfoAdapter
    protected BaseFragment cbD() {
        return new PersonBarFragment();
    }
}
