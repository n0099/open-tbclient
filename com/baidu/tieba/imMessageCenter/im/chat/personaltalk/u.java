package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.util.p<PersonalSettingItemData> {
    private final /* synthetic */ long aNX;
    final /* synthetic */ r cth;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar, long j) {
        this.cth = rVar;
        this.aNX = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.p
    /* renamed from: aji */
    public PersonalSettingItemData doInBackground() {
        return com.baidu.tieba.im.settingcache.j.ain().bb(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aNX));
    }
}
