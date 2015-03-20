package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends com.baidu.tieba.im.h<PersonalSettingItemData> {
    private final /* synthetic */ long ayb;
    final /* synthetic */ s bpS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar, long j) {
        this.bpS = sVar;
        this.ayb = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Ud */
    public PersonalSettingItemData doInBackground() {
        return com.baidu.tieba.im.settingcache.j.Tq().aE(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.ayb));
    }
}
