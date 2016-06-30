package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.util.s<PersonalSettingItemData> {
    private final /* synthetic */ long aNF;
    final /* synthetic */ r cZu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar, long j) {
        this.cZu = rVar;
        this.aNF = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: arE */
    public PersonalSettingItemData doInBackground() {
        return com.baidu.tieba.im.settingcache.j.aqK().bf(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aNF));
    }
}
