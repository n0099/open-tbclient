package com.baidu.tieba.tbadkCore.util;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.base.n;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.t;
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

        /* JADX DEBUG: Replace access to removed values field (cub) with 'values()' method */
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
            apu();
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
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(n.D(context).getPageActivity());
        if (operationType == OperationType.SIGN) {
            String string3 = context.getString(t.anti_appeal_sign_base_tip);
            if (c(antiData)) {
                string2 = context.getString(t.anti_type_forbid_sys);
            } else if (d(antiData)) {
                string2 = context.getString(t.anti_type_forbid_bawu);
            } else if (e(antiData)) {
                string2 = context.getString(t.anti_type_hide);
            } else {
                string2 = context.getString(t.anti_type_exception);
            }
            string = MessageFormat.format(string3, string2, context.getString(t.anti_appeal_sign_com_tip));
        } else {
            string = context.getString(t.anti_account_exception_tip);
        }
        aVar.cn(string);
        aVar.b(context.getString(t.anti_vcode_pos), new a(context, pageType));
        aVar.a(context.getString(t.anti_account_exception_neg), new b());
        if (context instanceof Activity) {
            aVar.b(n.D(context)).rL();
        }
    }

    private static void a(Context context, AntiData antiData, OperationType operationType) {
        String format;
        String string;
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(n.D(context).getPageActivity());
        if (operationType == OperationType.SIGN) {
            String string2 = context.getString(t.anti_appeal_sign_base_tip);
            if (c(antiData)) {
                string = context.getString(t.anti_type_forbid_sys);
            } else if (d(antiData)) {
                string = context.getString(t.anti_type_forbid_bawu);
            } else if (e(antiData)) {
                string = context.getString(t.anti_type_hide);
            } else {
                string = context.getString(t.anti_type_exception);
            }
            format = MessageFormat.format(string2, string, context.getString(t.anti_appeal_sign_bawu_tip));
        } else {
            format = MessageFormat.format(context.getString(t.anti_appeal_com_tip), antiData.getBlock_forum_name(), Integer.valueOf(antiData.getDays_tofree()));
        }
        aVar.cn(format);
        aVar.b(context.getString(t.anti_appeal_btn_pos), new c(context, antiData));
        aVar.a(context.getString(t.anti_appeal_btn_neg), new d());
        if (context instanceof Activity) {
            aVar.b(n.D(context)).rL();
        }
    }

    private static void b(Context context, AntiData antiData, OperationType operationType) {
        String string;
        String string2;
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(n.D(context).getPageActivity());
        if (operationType == OperationType.SIGN) {
            String string3 = context.getString(t.anti_appeal_sign_base_tip);
            if (c(antiData)) {
                string2 = context.getString(t.anti_type_forbid_sys);
            } else if (d(antiData)) {
                string2 = context.getString(t.anti_type_forbid_bawu);
            } else if (e(antiData)) {
                string2 = context.getString(t.anti_type_hide);
            } else {
                string2 = context.getString(t.anti_type_exception);
            }
            string = MessageFormat.format(string3, string2, context.getString(t.anti_appeal_sign_no_chance_tip));
        } else {
            string = context.getString(t.anti_no_chance_com_tip);
        }
        aVar.cn(string);
        aVar.a(context.getString(t.anti_no_chance_pos), new e());
        if (context instanceof Activity) {
            aVar.b(n.D(context)).rL();
        }
    }

    private static void a(Context context, AntiData antiData, PageType pageType) {
        if (!com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("anti_vcode_no_longer_tip", false)) {
            boolean isHas_chance = antiData.isHas_chance();
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(n.D(context).getPageActivity());
            aVar.cn(context.getString(isHas_chance ? t.anti_vocode_on_chance_tip : t.anti_vcode_tip));
            if (!isHas_chance) {
                aVar.b(context.getString(t.anti_vcode_pos), new f(context, pageType));
            } else {
                aVar.b(context.getString(t.anti_no_chance_pos), new g());
            }
            aVar.a(context.getString(t.anti_vcode_neg), new h());
            if (context instanceof Activity) {
                aVar.b(n.D(context)).rL();
            }
        }
    }

    private static void apu() {
        com.baidu.tbadk.core.sharedPref.b.sl().remove("anti_vcode_no_longer_tip");
    }
}
