package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class u extends com.baidu.tbadk.util.v<PersonalSettingItemData> {
    private final /* synthetic */ long aWf;
    final /* synthetic */ r djZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar, long j) {
        this.djZ = rVar;
        this.aWf = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.v
    /* renamed from: atn */
    public PersonalSettingItemData doInBackground() {
        return com.baidu.tieba.im.settingcache.j.ass().bd(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aWf));
    }
}
