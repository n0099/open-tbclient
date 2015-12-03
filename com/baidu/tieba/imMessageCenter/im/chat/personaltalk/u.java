package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.util.m<PersonalSettingItemData> {
    private final /* synthetic */ long aIy;
    final /* synthetic */ r cac;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar, long j) {
        this.cac = rVar;
        this.aIy = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: abw */
    public PersonalSettingItemData doInBackground() {
        return com.baidu.tieba.im.settingcache.j.aaG().aO(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aIy));
    }
}
