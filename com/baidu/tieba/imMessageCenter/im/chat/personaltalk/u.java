package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class u extends com.baidu.tbadk.util.w<PersonalSettingItemData> {
    private final /* synthetic */ long aXy;
    final /* synthetic */ r drV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar, long j) {
        this.drV = rVar;
        this.aXy = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.w
    /* renamed from: awV */
    public PersonalSettingItemData doInBackground() {
        return com.baidu.tieba.im.settingcache.j.awd().bk(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aXy));
    }
}
