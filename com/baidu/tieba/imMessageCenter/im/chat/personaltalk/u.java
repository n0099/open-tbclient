package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.util.s<PersonalSettingItemData> {
    private final /* synthetic */ long aKh;
    final /* synthetic */ r cuf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar, long j) {
        this.cuf = rVar;
        this.aKh = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: ajo */
    public PersonalSettingItemData doInBackground() {
        return com.baidu.tieba.im.settingcache.j.aiu().bf(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aKh));
    }
}
