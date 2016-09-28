package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.util.t<PersonalSettingItemData> {
    private final /* synthetic */ long aUD;
    final /* synthetic */ r dpy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar, long j) {
        this.dpy = rVar;
        this.aUD = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: axD */
    public PersonalSettingItemData doInBackground() {
        return com.baidu.tieba.im.settingcache.j.awJ().bj(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aUD));
    }
}
