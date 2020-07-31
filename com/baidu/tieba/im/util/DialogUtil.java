package com.baidu.tieba.im.util;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.base.i;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class DialogUtil {
    public static com.baidu.tbadk.core.dialog.a removeMemberDialog(Activity activity, a.b bVar, a.b bVar2) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.xl(TbadkApplication.getInst().getString(R.string.members_dialog_remove_one_message));
        aVar.a(TbadkApplication.getInst().getString(R.string.alert_yes_button), bVar);
        aVar.b(TbadkApplication.getInst().getString(R.string.cancel), bVar2);
        aVar.b(i.G(activity));
        aVar.aYL();
        return aVar;
    }

    public static com.baidu.tbadk.core.dialog.a removeMembersDialog(Activity activity, a.b bVar, a.b bVar2) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.xl(TbadkApplication.getInst().getString(R.string.members_dialog_remove_more_message));
        aVar.a(TbadkApplication.getInst().getString(R.string.alert_yes_button), bVar);
        aVar.b(TbadkApplication.getInst().getString(R.string.cancel), bVar2);
        aVar.b(i.G(activity));
        aVar.aYL();
        return aVar;
    }

    public static com.baidu.tbadk.core.dialog.a deleteGroupActivity(Context context, a.b bVar) {
        if (!(context instanceof Activity)) {
            return null;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((Activity) context);
        aVar.xl(TbadkApplication.getInst().getString(R.string.group_activity_delete_tip));
        aVar.a(TbadkApplication.getInst().getString(R.string.confirm), bVar);
        aVar.b(TbadkApplication.getInst().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.im.util.DialogUtil.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(i.G(context));
        aVar.aYL();
        return aVar;
    }

    public static com.baidu.tbadk.core.dialog.a quitCreateGroupActivity(Context context, boolean z, a.b bVar, a.b bVar2) {
        int i;
        if (z) {
            i = R.string.group_activity_edit_quit;
        } else {
            i = R.string.group_activity_create_quit;
        }
        if (!(context instanceof Activity)) {
            return null;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((Activity) context);
        aVar.xl(TbadkApplication.getInst().getString(i));
        aVar.a(TbadkApplication.getInst().getString(R.string.confirm), bVar);
        aVar.b(TbadkApplication.getInst().getString(R.string.cancel), bVar2);
        aVar.b(i.G(context));
        aVar.aYL();
        return aVar;
    }
}
