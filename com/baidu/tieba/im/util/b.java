package com.baidu.tieba.im.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class b {
    public static AlertDialog a(Activity activity, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog create = new AlertDialog.Builder(activity).setTitle(R.string.del_post_tip).setMessage(R.string.members_dialog_remove_one_message).setPositiveButton(R.string.alert_yes_button, onClickListener).setNegativeButton(R.string.alert_no_button, onClickListener2).create();
        create.show();
        return create;
    }

    public static AlertDialog b(Activity activity, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog create = new AlertDialog.Builder(activity).setTitle(R.string.del_post_tip).setMessage(R.string.members_dialog_remove_more_message).setPositiveButton(R.string.alert_yes_button, onClickListener).setNegativeButton(R.string.alert_no_button, onClickListener2).create();
        create.show();
        return create;
    }

    public static AlertDialog a(Activity activity, DialogInterface.OnClickListener onClickListener) {
        AlertDialog create = new AlertDialog.Builder(activity).setTitle(R.string.members_order).setItems(R.array.members_order_by, onClickListener).create();
        create.show();
        return create;
    }

    public static AlertDialog a(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, String str) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(R.string.del_post_tip).setMessage(String.format(context.getString(R.string.url_notify), str)).setPositiveButton(R.string.alert_yes_button, onClickListener).setNegativeButton(R.string.alert_no_button, onClickListener2).create();
        create.show();
        return create;
    }

    public static AlertDialog a(Context context, DialogInterface.OnClickListener onClickListener, String str) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(R.string.bar_code_result).setMessage(str).setPositiveButton(R.string.alert_yes_button, onClickListener).create();
        create.show();
        return create;
    }

    public static AlertDialog a(Context context, DialogInterface.OnClickListener onClickListener) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(R.string.anti_title).setMessage(R.string.msg_album_bug).setPositiveButton(R.string.alert_yes_button, onClickListener).create();
        create.show();
        return create;
    }

    public static AlertDialog a(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(R.string.del_post_tip).setMessage(R.string.rand_chat_waiting_quit_message).setPositiveButton(R.string.rand_chat_waiting_quit_yes, onClickListener).setNegativeButton(R.string.rand_chat_waiting_quit_no, onClickListener2).create();
        create.show();
        return create;
    }

    public static AlertDialog a(Context context, boolean z, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        int i;
        if (z) {
            i = R.string.group_activity_edit_quit;
        } else {
            i = R.string.group_activity_create_quit;
        }
        AlertDialog create = new AlertDialog.Builder(context).setTitle(R.string.quit).setMessage(i).setPositiveButton(R.string.confirm, onClickListener).setNegativeButton(R.string.cancel, onClickListener2).create();
        create.show();
        return create;
    }

    public static AlertDialog b(Context context, DialogInterface.OnClickListener onClickListener) {
        AlertDialog create = new AlertDialog.Builder(context).setTitle(R.string.delete).setMessage(R.string.group_activity_delete_tip).setPositiveButton(R.string.confirm, onClickListener).setNegativeButton(R.string.cancel, new c()).create();
        create.show();
        return create;
    }

    public static AlertDialog b(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog create = new AlertDialog.Builder(context).setMessage(R.string.rand_chat_waiting_change_dialog).setPositiveButton(R.string.alert_yes_btn, onClickListener).setNeutralButton(R.string.alert_no_button, onClickListener2).create();
        create.show();
        return create;
    }
}
