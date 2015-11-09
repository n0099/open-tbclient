package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.util.l<PersonalSettingItemData> {
    private final /* synthetic */ long aFz;
    final /* synthetic */ r bKY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar, long j) {
        this.bKY = rVar;
        this.aFz = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.l
    /* renamed from: Yq */
    public PersonalSettingItemData doInBackground() {
        return com.baidu.tieba.im.settingcache.j.XA().aJ(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aFz));
    }
}
