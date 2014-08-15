package com.baidu.tieba.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tieba.x;
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

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static OperationType[] valuesCustom() {
            OperationType[] valuesCustom = values();
            int length = valuesCustom.length;
            OperationType[] operationTypeArr = new OperationType[length];
            System.arraycopy(valuesCustom, 0, operationTypeArr, 0, length);
            return operationTypeArr;
        }
    }

    /* loaded from: classes.dex */
    public enum PageType {
        PERSON_INFO,
        FRS,
        PB,
        IMAGE_PB,
        FLOOR_IN_FLOOR,
        WRITE;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PageType[] valuesCustom() {
            PageType[] valuesCustom = values();
            int length = valuesCustom.length;
            PageType[] pageTypeArr = new PageType[length];
            System.arraycopy(valuesCustom, 0, pageTypeArr, 0, length);
            return pageTypeArr;
        }
    }

    public static boolean a(Context context, AntiData antiData, OperationType operationType, PageType pageType) {
        if (!d(antiData)) {
            a();
        }
        if (a(antiData) || c(antiData)) {
            if (antiData.isHas_chance()) {
                b(context, antiData, operationType, pageType);
                return true;
            }
            b(context, antiData, operationType);
            return true;
        } else if (b(antiData)) {
            a(context, antiData, operationType);
            return true;
        } else if (d(antiData) && operationType == OperationType.REPLY) {
            a(context, antiData, pageType);
            return true;
        } else {
            return false;
        }
    }

    public static boolean a(AntiData antiData) {
        return antiData != null && antiData.getBlock_stat() == 2;
    }

    public static boolean b(AntiData antiData) {
        return antiData != null && antiData.getBlock_stat() == 3;
    }

    public static boolean c(AntiData antiData) {
        return antiData != null && antiData.getHide_stat() == 1;
    }

    public static boolean d(AntiData antiData) {
        return antiData != null && antiData.getVcode_stat() == 1;
    }

    private static void b(Context context, AntiData antiData, OperationType operationType, PageType pageType) {
        String string;
        String string2;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(x.anti_title));
        if (operationType == OperationType.SIGN) {
            String string3 = context.getString(x.anti_appeal_sign_base_tip);
            if (a(antiData)) {
                string2 = context.getString(x.anti_type_forbid_sys);
            } else if (b(antiData)) {
                string2 = context.getString(x.anti_type_forbid_bawu);
            } else if (c(antiData)) {
                string2 = context.getString(x.anti_type_hide);
            } else {
                string2 = context.getString(x.anti_type_exception);
            }
            string = MessageFormat.format(string3, string2, context.getString(x.anti_appeal_sign_com_tip));
        } else {
            string = context.getString(x.anti_account_exception_tip);
        }
        builder.setMessage(string);
        builder.setNegativeButton(context.getString(x.anti_account_exception_pos), new a(context, pageType));
        builder.setPositiveButton(context.getString(x.anti_account_exception_neg), new b());
        if (context instanceof Activity) {
            com.baidu.adp.lib.e.d.a(builder.create(), (Activity) context);
        }
    }

    private static void a(Context context, AntiData antiData, OperationType operationType) {
        String format;
        String string;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(x.anti_title));
        if (operationType == OperationType.SIGN) {
            String string2 = context.getString(x.anti_appeal_sign_base_tip);
            if (a(antiData)) {
                string = context.getString(x.anti_type_forbid_sys);
            } else if (b(antiData)) {
                string = context.getString(x.anti_type_forbid_bawu);
            } else if (c(antiData)) {
                string = context.getString(x.anti_type_hide);
            } else {
                string = context.getString(x.anti_type_exception);
            }
            format = MessageFormat.format(string2, string, context.getString(x.anti_appeal_sign_bawu_tip));
        } else {
            format = MessageFormat.format(context.getString(x.anti_appeal_com_tip), antiData.getBlock_forum_name(), Integer.valueOf(antiData.getDays_tofree()));
        }
        builder.setMessage(format);
        builder.setNegativeButton(context.getString(x.anti_appeal_btn_pos), new c(context, antiData));
        builder.setPositiveButton(context.getString(x.anti_appeal_btn_neg), new d());
        if (context instanceof Activity) {
            com.baidu.adp.lib.e.d.a(builder.create(), (Activity) context);
        }
    }

    private static void b(Context context, AntiData antiData, OperationType operationType) {
        String string;
        String string2;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(x.anti_title));
        if (operationType == OperationType.SIGN) {
            String string3 = context.getString(x.anti_appeal_sign_base_tip);
            if (a(antiData)) {
                string2 = context.getString(x.anti_type_forbid_sys);
            } else if (b(antiData)) {
                string2 = context.getString(x.anti_type_forbid_bawu);
            } else if (c(antiData)) {
                string2 = context.getString(x.anti_type_hide);
            } else {
                string2 = context.getString(x.anti_type_exception);
            }
            string = MessageFormat.format(string3, string2, context.getString(x.anti_appeal_sign_no_chance_tip));
        } else {
            string = context.getString(x.anti_no_chance_com_tip);
        }
        builder.setMessage(string);
        builder.setPositiveButton(context.getString(x.anti_no_chance_pos), new e());
        if (context instanceof Activity) {
            com.baidu.adp.lib.e.d.a(builder.create(), (Activity) context);
        }
    }

    private static void a(Context context, AntiData antiData, PageType pageType) {
        if (!com.baidu.tbadk.core.sharedPref.b.a().a("anti_vcode_no_longer_tip", false)) {
            boolean isHas_chance = antiData.isHas_chance();
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(context.getString(x.anti_title));
            builder.setMessage(context.getString(isHas_chance ? x.anti_vocode_on_chance_tip : x.anti_vcode_tip));
            if (!isHas_chance) {
                builder.setNegativeButton(context.getString(x.anti_vcode_pos), new f(context, pageType));
            } else {
                builder.setNegativeButton(context.getString(x.anti_no_chance_pos), new g());
            }
            builder.setPositiveButton(context.getString(x.anti_vcode_neg), new h());
            if (context instanceof Activity) {
                com.baidu.adp.lib.e.d.a(builder.create(), (Activity) context);
            }
        }
    }

    private static void a() {
        com.baidu.tbadk.core.sharedPref.b.a().a("anti_vcode_no_longer_tip");
    }
}
