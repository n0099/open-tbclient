package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.util.m<PersonalSettingItemData> {
    private final /* synthetic */ long aLb;
    final /* synthetic */ r ciC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar, long j) {
        this.ciC = rVar;
        this.aLb = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: afO */
    public PersonalSettingItemData doInBackground() {
        return com.baidu.tieba.im.settingcache.j.aeU().aO(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aLb));
    }
}
