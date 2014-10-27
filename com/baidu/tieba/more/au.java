package com.baidu.tieba.more;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.Hao123Model;
import java.util.ArrayList;
/* loaded from: classes.dex */
class au extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ SystemHelpSettingActivity bsJ;

    private au(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.bsJ = systemHelpSettingActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ au(SystemHelpSettingActivity systemHelpSettingActivity, au auVar) {
        this(systemHelpSettingActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (TextUtils.isEmpty(Hao123Model.getHao123Cache())) {
            Hao123Model.setHao123Cache(Hao123Model.getHao123JosnStr(Hao123Model.parserLikeForumsProtoBuf(new ArrayList())));
            return null;
        }
        return null;
    }
}
