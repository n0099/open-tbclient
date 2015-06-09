package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends com.baidu.tieba.im.h<PersonalSettingItemData> {
    private final /* synthetic */ long azV;
    final /* synthetic */ s bsO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar, long j) {
        this.bsO = sVar;
        this.azV = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: VI */
    public PersonalSettingItemData doInBackground() {
        return com.baidu.tieba.im.settingcache.j.UR().aJ(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.azV));
    }
}
