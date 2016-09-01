package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.util.t<PersonalSettingItemData> {
    private final /* synthetic */ long aTT;
    final /* synthetic */ r dnZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar, long j) {
        this.dnZ = rVar;
        this.aTT = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: axe */
    public PersonalSettingItemData doInBackground() {
        return com.baidu.tieba.im.settingcache.j.awk().bh(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aTT));
    }
}
