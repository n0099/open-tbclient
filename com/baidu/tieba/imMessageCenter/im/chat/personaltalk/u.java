package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.util.m<PersonalSettingItemData> {
    private final /* synthetic */ long aJW;
    final /* synthetic */ r ced;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar, long j) {
        this.ced = rVar;
        this.aJW = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: acF */
    public PersonalSettingItemData doInBackground() {
        return com.baidu.tieba.im.settingcache.j.abO().aJ(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aJW));
    }
}
