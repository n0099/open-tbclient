package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.util.s<PersonalSettingItemData> {
    private final /* synthetic */ long aWf;
    final /* synthetic */ r daf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar, long j) {
        this.daf = rVar;
        this.aWf = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: aua */
    public PersonalSettingItemData doInBackground() {
        return com.baidu.tieba.im.settingcache.j.atf().bf(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aWf));
    }
}
