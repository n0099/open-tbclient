package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.util.s<PersonalSettingItemData> {
    private final /* synthetic */ long aYh;
    final /* synthetic */ r dkC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar, long j) {
        this.dkC = rVar;
        this.aYh = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: avv */
    public PersonalSettingItemData doInBackground() {
        return com.baidu.tieba.im.settingcache.j.auA().bf(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aYh));
    }
}
