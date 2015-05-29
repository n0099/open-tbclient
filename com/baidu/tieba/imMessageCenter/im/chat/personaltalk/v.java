package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends com.baidu.tieba.im.h<PersonalSettingItemData> {
    private final /* synthetic */ long azU;
    final /* synthetic */ s bsN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar, long j) {
        this.bsN = sVar;
        this.azU = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: VH */
    public PersonalSettingItemData doInBackground() {
        return com.baidu.tieba.im.settingcache.j.UQ().aJ(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.azU));
    }
}
