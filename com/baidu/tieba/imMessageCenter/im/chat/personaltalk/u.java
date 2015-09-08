package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends com.baidu.tieba.im.h<PersonalSettingItemData> {
    private final /* synthetic */ long aHB;
    final /* synthetic */ r bHn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar, long j) {
        this.bHn = rVar;
        this.aHB = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Xr */
    public PersonalSettingItemData doInBackground() {
        return com.baidu.tieba.im.settingcache.j.WA().aL(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aHB));
    }
}
