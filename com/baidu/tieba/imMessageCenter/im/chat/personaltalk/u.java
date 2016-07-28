package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.util.t<PersonalSettingItemData> {
    private final /* synthetic */ long aOz;
    final /* synthetic */ r dcr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar, long j) {
        this.dcr = rVar;
        this.aOz = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: asq */
    public PersonalSettingItemData doInBackground() {
        return com.baidu.tieba.im.settingcache.j.arw().bg(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aOz));
    }
}
