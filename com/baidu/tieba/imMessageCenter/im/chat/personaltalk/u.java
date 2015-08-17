package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends com.baidu.tieba.im.h<PersonalSettingItemData> {
    private final /* synthetic */ long aHo;
    final /* synthetic */ r bGG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar, long j) {
        this.bGG = rVar;
        this.aHo = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Xp */
    public PersonalSettingItemData doInBackground() {
        return com.baidu.tieba.im.settingcache.j.Wy().aJ(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aHo));
    }
}
