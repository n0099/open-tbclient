package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.util.l<PersonalSettingItemData> {
    private final /* synthetic */ long aGF;
    final /* synthetic */ r bKD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar, long j) {
        this.bKD = rVar;
        this.aGF = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.l
    /* renamed from: XZ */
    public PersonalSettingItemData doInBackground() {
        return com.baidu.tieba.im.settingcache.j.Xj().aK(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aGF));
    }
}
