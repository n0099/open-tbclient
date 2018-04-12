package com.baidu.tieba.im.util;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.base.i;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class DialogUtil {
    public static com.baidu.tbadk.core.dialog.a removeMemberDialog(Activity activity, a.b bVar, a.b bVar2) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.dc(TbadkApplication.getInst().getString(d.k.members_dialog_remove_one_message));
        aVar.a(TbadkApplication.getInst().getString(d.k.alert_yes_button), bVar);
        aVar.b(TbadkApplication.getInst().getString(d.k.cancel), bVar2);
        aVar.b(i.ab(activity));
        aVar.tD();
        return aVar;
    }

    public static com.baidu.tbadk.core.dialog.b orderMembers(Activity activity, b.InterfaceC0086b interfaceC0086b) {
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(activity);
        bVar.dd(TbadkApplication.getInst().getString(d.k.members_order));
        bVar.a(activity.getResources().getStringArray(d.b.members_order_by), interfaceC0086b);
        bVar.d(i.ab(activity));
        bVar.tG();
        return bVar;
    }

    public static com.baidu.tbadk.core.dialog.a removeMembersDialog(Activity activity, a.b bVar, a.b bVar2) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(activity);
        aVar.dc(TbadkApplication.getInst().getString(d.k.members_dialog_remove_more_message));
        aVar.a(TbadkApplication.getInst().getString(d.k.alert_yes_button), bVar);
        aVar.b(TbadkApplication.getInst().getString(d.k.cancel), bVar2);
        aVar.b(i.ab(activity));
        aVar.tD();
        return aVar;
    }

    public static com.baidu.tbadk.core.dialog.a deleteGroupActivity(Context context, a.b bVar) {
        if (!(context instanceof Activity)) {
            return null;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((Activity) context);
        aVar.dc(TbadkApplication.getInst().getString(d.k.group_activity_delete_tip));
        aVar.a(TbadkApplication.getInst().getString(d.k.confirm), bVar);
        aVar.b(TbadkApplication.getInst().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.im.util.DialogUtil.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(i.ab(context));
        aVar.tD();
        return aVar;
    }

    public static com.baidu.tbadk.core.dialog.a quitCreateGroupActivity(Context context, boolean z, a.b bVar, a.b bVar2) {
        int i;
        if (z) {
            i = d.k.group_activity_edit_quit;
        } else {
            i = d.k.group_activity_create_quit;
        }
        if (!(context instanceof Activity)) {
            return null;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((Activity) context);
        aVar.dc(TbadkApplication.getInst().getString(i));
        aVar.a(TbadkApplication.getInst().getString(d.k.confirm), bVar);
        aVar.b(TbadkApplication.getInst().getString(d.k.cancel), bVar2);
        aVar.b(i.ab(context));
        aVar.tD();
        return aVar;
    }
}
