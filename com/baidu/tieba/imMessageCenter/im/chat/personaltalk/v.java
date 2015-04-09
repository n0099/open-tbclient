package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends com.baidu.tieba.im.h<PersonalSettingItemData> {
    private final /* synthetic */ long ayj;
    final /* synthetic */ s bqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar, long j) {
        this.bqi = sVar;
        this.ayj = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Uq */
    public PersonalSettingItemData doInBackground() {
        return com.baidu.tieba.im.settingcache.j.TD().aE(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.ayj));
    }
}
