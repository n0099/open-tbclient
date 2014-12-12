package com.baidu.tieba.tbadkCore.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.z;
import java.text.MessageFormat;
/* loaded from: classes.dex */
public class AntiHelper {

    /* loaded from: classes.dex */
    public enum OperationType {
        ACCOUNT_RESTORE,
        CREATE_THREAD,
        SIGN,
        LIKE,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (bYM) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static OperationType[] valuesCustom() {
            OperationType[] valuesCustom = values();
            int length = valuesCustom.length;
            OperationType[] operationTypeArr = new OperationType[length];
            System.arraycopy(valuesCustom, 0, operationTypeArr, 0, length);
            return operationTypeArr;
        }
    }

    public static boolean a(Context context, AntiData antiData, OperationType operationType, PageType pageType) {
        if (!f(antiData)) {
            ahK();
        }
        if (c(antiData) || e(antiData)) {
            if (antiData.isHas_chance()) {
                b(context, antiData, operationType, pageType);
                return true;
            }
            b(context, antiData, operationType);
            return true;
        } else if (d(antiData)) {
            a(context, antiData, operationType);
            return true;
        } else if (f(antiData) && operationType == OperationType.REPLY) {
            a(context, antiData, pageType);
            return true;
        } else {
            return false;
        }
    }

    public static boolean c(AntiData antiData) {
        return antiData != null && antiData.getBlock_stat() == 2;
    }

    public static boolean d(AntiData antiData) {
        return antiData != null && antiData.getBlock_stat() == 3;
    }

    public static boolean e(AntiData antiData) {
        return antiData != null && antiData.getHide_stat() == 1;
    }

    public static boolean f(AntiData antiData) {
        return antiData != null && antiData.getVcode_stat() == 1;
    }

    private static void b(Context context, AntiData antiData, OperationType operationType, PageType pageType) {
        String string;
        String string2;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(z.anti_title));
        if (operationType == OperationType.SIGN) {
            String string3 = context.getString(z.anti_appeal_sign_base_tip);
            if (c(antiData)) {
                string2 = context.getString(z.anti_type_forbid_sys);
            } else if (d(antiData)) {
                string2 = context.getString(z.anti_type_forbid_bawu);
            } else if (e(antiData)) {
                string2 = context.getString(z.anti_type_hide);
            } else {
                string2 = context.getString(z.anti_type_exception);
            }
            string = MessageFormat.format(string3, string2, context.getString(z.anti_appeal_sign_com_tip));
        } else {
            string = context.getString(z.anti_account_exception_tip);
        }
        builder.setMessage(string);
        builder.setNegativeButton(context.getString(z.anti_account_exception_pos), new a(context, pageType));
        builder.setPositiveButton(context.getString(z.anti_account_exception_neg), new b());
        if (context instanceof Activity) {
            com.baidu.adp.lib.g.k.a(builder.create(), (Activity) context);
        }
    }

    private static void a(Context context, AntiData antiData, OperationType operationType) {
        String format;
        String string;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(z.anti_title));
        if (operationType == OperationType.SIGN) {
            String string2 = context.getString(z.anti_appeal_sign_base_tip);
            if (c(antiData)) {
                string = context.getString(z.anti_type_forbid_sys);
            } else if (d(antiData)) {
                string = context.getString(z.anti_type_forbid_bawu);
            } else if (e(antiData)) {
                string = context.getString(z.anti_type_hide);
            } else {
                string = context.getString(z.anti_type_exception);
            }
            format = MessageFormat.format(string2, string, context.getString(z.anti_appeal_sign_bawu_tip));
        } else {
            format = MessageFormat.format(context.getString(z.anti_appeal_com_tip), antiData.getBlock_forum_name(), Integer.valueOf(antiData.getDays_tofree()));
        }
        builder.setMessage(format);
        builder.setNegativeButton(context.getString(z.anti_appeal_btn_pos), new c(context, antiData));
        builder.setPositiveButton(context.getString(z.anti_appeal_btn_neg), new d());
        if (context instanceof Activity) {
            com.baidu.adp.lib.g.k.a(builder.create(), (Activity) context);
        }
    }

    private static void b(Context context, AntiData antiData, OperationType operationType) {
        String string;
        String string2;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(z.anti_title));
        if (operationType == OperationType.SIGN) {
            String string3 = context.getString(z.anti_appeal_sign_base_tip);
            if (c(antiData)) {
                string2 = context.getString(z.anti_type_forbid_sys);
            } else if (d(antiData)) {
                string2 = context.getString(z.anti_type_forbid_bawu);
            } else if (e(antiData)) {
                string2 = context.getString(z.anti_type_hide);
            } else {
                string2 = context.getString(z.anti_type_exception);
            }
            string = MessageFormat.format(string3, string2, context.getString(z.anti_appeal_sign_no_chance_tip));
        } else {
            string = context.getString(z.anti_no_chance_com_tip);
        }
        builder.setMessage(string);
        builder.setPositiveButton(context.getString(z.anti_no_chance_pos), new e());
        if (context instanceof Activity) {
            com.baidu.adp.lib.g.k.a(builder.create(), (Activity) context);
        }
    }

    private static void a(Context context, AntiData antiData, PageType pageType) {
        if (!com.baidu.tbadk.core.sharedPref.b.og().getBoolean("anti_vcode_no_longer_tip", false)) {
            boolean isHas_chance = antiData.isHas_chance();
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(context.getString(z.anti_title));
            builder.setMessage(context.getString(isHas_chance ? z.anti_vocode_on_chance_tip : z.anti_vcode_tip));
            if (!isHas_chance) {
                builder.setNegativeButton(context.getString(z.anti_vcode_pos), new f(context, pageType));
            } else {
                builder.setNegativeButton(context.getString(z.anti_no_chance_pos), new g());
            }
            builder.setPositiveButton(context.getString(z.anti_vcode_neg), new h());
            if (context instanceof Activity) {
                com.baidu.adp.lib.g.k.a(builder.create(), (Activity) context);
            }
        }
    }

    private static void ahK() {
        com.baidu.tbadk.core.sharedPref.b.og().remove("anti_vcode_no_longer_tip");
    }
}
