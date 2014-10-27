package com.baidu.tieba.im.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.q;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class DialogUtil {
    public static AlertDialog removeMemberDialog(Activity activity, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog create = new AlertDialog.Builder(activity).setTitle(TbadkApplication.m251getInst().getString(y.del_post_tip)).setMessage(TbadkApplication.m251getInst().getString(y.members_dialog_remove_one_message)).setPositiveButton(TbadkApplication.m251getInst().getString(y.alert_yes_button), onClickListener).setNegativeButton(TbadkApplication.m251getInst().getString(y.alert_no_button), onClickListener2).create();
        com.baidu.adp.lib.g.j.a(create, activity);
        return create;
    }

    public static AlertDialog removeMembersDialog(Activity activity, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog create = new AlertDialog.Builder(activity).setTitle(TbadkApplication.m251getInst().getString(y.del_post_tip)).setMessage(TbadkApplication.m251getInst().getString(y.members_dialog_remove_more_message)).setPositiveButton(TbadkApplication.m251getInst().getString(y.alert_yes_button), onClickListener).setNegativeButton(TbadkApplication.m251getInst().getString(y.alert_no_button), onClickListener2).create();
        com.baidu.adp.lib.g.j.a(create, activity);
        return create;
    }

    public static AlertDialog orderMembers(Activity activity, DialogInterface.OnClickListener onClickListener) {
        AlertDialog create = new AlertDialog.Builder(activity).setTitle(TbadkApplication.m251getInst().getString(y.members_order)).setItems(q.members_order_by, onClickListener).create();
        com.baidu.adp.lib.g.j.a(create, activity);
        return create;
    }

    public static AlertDialog quitWaitRandChat(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(TbadkApplication.m251getInst().getString(y.del_post_tip)).setMessage(TbadkApplication.m251getInst().getString(y.rand_chat_waiting_quit_message)).setPositiveButton(TbadkApplication.m251getInst().getString(y.rand_chat_waiting_quit_yes), onClickListener).setNegativeButton(TbadkApplication.m251getInst().getString(y.rand_chat_waiting_quit_no), onClickListener2).create();
        if (context instanceof Activity) {
            com.baidu.adp.lib.g.j.a(create, (Activity) context);
        }
        return create;
    }

    public static AlertDialog quitCreateGroupActivity(Context context, boolean z, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        int i;
        if (z) {
            i = y.group_activity_edit_quit;
        } else {
            i = y.group_activity_create_quit;
        }
        AlertDialog create = new AlertDialog.Builder(context).setTitle(TbadkApplication.m251getInst().getString(y.quit)).setMessage(TbadkApplication.m251getInst().getString(i)).setPositiveButton(TbadkApplication.m251getInst().getString(y.confirm), onClickListener).setNegativeButton(TbadkApplication.m251getInst().getString(y.cancel), onClickListener2).create();
        if (context instanceof Activity) {
            com.baidu.adp.lib.g.j.a(create, (Activity) context);
        }
        return create;
    }

    public static AlertDialog deleteGroupActivity(Context context, DialogInterface.OnClickListener onClickListener) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(TbadkApplication.m251getInst().getString(y.delete)).setMessage(TbadkApplication.m251getInst().getString(y.group_activity_delete_tip)).setPositiveButton(TbadkApplication.m251getInst().getString(y.confirm), onClickListener).setNegativeButton(TbadkApplication.m251getInst().getString(y.cancel), new b()).create();
        if (context instanceof Activity) {
            com.baidu.adp.lib.g.j.a(create, (Activity) context);
        }
        return create;
    }

    public static AlertDialog changeGroup(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog create = new AlertDialog.Builder(context).setMessage(TbadkApplication.m251getInst().getString(y.rand_chat_waiting_change_dialog)).setPositiveButton(TbadkApplication.m251getInst().getString(y.alert_yes_btn), onClickListener).setNeutralButton(TbadkApplication.m251getInst().getString(y.alert_no_button), onClickListener2).create();
        if (context instanceof Activity) {
            com.baidu.adp.lib.g.j.a(create, (Activity) context);
        }
        return create;
    }

    public static AlertDialog deleteItem(Context context, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(TbadkApplication.m251getInst().getString(y.operation));
        builder.setItems(new String[]{TbadkApplication.m251getInst().getString(y.delete_user_chat)}, onClickListener);
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(true);
        if (context instanceof Activity) {
            com.baidu.adp.lib.g.j.a(create, (Activity) context);
        }
        return create;
    }

    public static AlertDialog liveRoomChatMuteUserDialog(Context context, DialogInterface.OnClickListener onClickListener) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(TbadkApplication.m251getInst().getString(y.del_post_tip)).setMessage(TbadkApplication.m251getInst().getString(y.live_chat_room_mute_msg)).setPositiveButton(TbadkApplication.m251getInst().getString(y.confirm), onClickListener).setNegativeButton(TbadkApplication.m251getInst().getString(y.cancel), new c()).create();
        if (context instanceof Activity) {
            com.baidu.adp.lib.g.j.a(create, (Activity) context);
        }
        return create;
    }

    public static AlertDialog frsLiveOperateDialog(Context context, CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
        AlertDialog create = new AlertDialog.Builder(context).setItems(charSequenceArr, onClickListener).create();
        if (context instanceof Activity) {
            com.baidu.adp.lib.g.j.a(create, (Activity) context);
        }
        return create;
    }
}
