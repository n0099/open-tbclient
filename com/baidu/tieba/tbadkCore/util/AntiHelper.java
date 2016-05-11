package com.baidu.tieba.tbadkCore.util;

import android.app.Activity;
import android.content.Context;
import com.baidu.tbadk.core.atomData.AppealActivityConfig;
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

        /* JADX DEBUG: Replace access to removed values field (evf) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static OperationType[] valuesCustom() {
            OperationType[] valuesCustom = values();
            int length = valuesCustom.length;
            OperationType[] operationTypeArr = new OperationType[length];
            System.arraycopy(valuesCustom, 0, operationTypeArr, 0, length);
            return operationTypeArr;
        }
    }

    public static boolean pw(int i) {
        return i == 3250002 || i == 3250001 || i == 3250003 || i == 3250004;
    }

    public static com.baidu.tbadk.core.dialog.a O(Context context, String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.l.s(context).getPageActivity());
        if (str == null) {
            str = "";
        }
        aVar.cA(str);
        if (AppealActivityConfig.isExistActivity) {
            aVar.a(context.getString(t.j.anti_vcode_pos), new a(context));
            aVar.b(context.getString(t.j.anti_account_exception_neg), new d());
        }
        if (context instanceof Activity) {
            aVar.b(com.baidu.adp.base.l.s(context)).rU();
            return aVar;
        }
        return null;
    }

    public static boolean a(Context context, AntiData antiData, OperationType operationType, PageType pageType) {
        if (!h(antiData)) {
            aUJ();
        }
        if (e(antiData) || g(antiData)) {
            if (antiData.isHas_chance()) {
                b(context, antiData, operationType, pageType);
                return true;
            }
            b(context, antiData, operationType);
            return true;
        } else if (f(antiData)) {
            a(context, antiData, operationType);
            return true;
        } else if (h(antiData) && operationType == OperationType.REPLY) {
            a(context, antiData, pageType);
            return true;
        } else {
            return false;
        }
    }

    public static boolean e(AntiData antiData) {
        return antiData != null && antiData.getBlock_stat() == 2;
    }

    public static boolean f(AntiData antiData) {
        return antiData != null && antiData.getBlock_stat() == 3;
    }

    public static boolean g(AntiData antiData) {
        return antiData != null && antiData.getHide_stat() == 1;
    }

    public static boolean h(AntiData antiData) {
        return antiData != null && antiData.getVcode_stat() == 1;
    }

    private static void b(Context context, AntiData antiData, OperationType operationType, PageType pageType) {
        String string;
        String string2;
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.l.s(context).getPageActivity());
        if (operationType == OperationType.SIGN) {
            String string3 = context.getString(t.j.anti_appeal_sign_base_tip);
            if (e(antiData)) {
                string2 = context.getString(t.j.anti_type_forbid_sys);
            } else if (f(antiData)) {
                string2 = context.getString(t.j.anti_type_forbid_bawu);
            } else if (g(antiData)) {
                string2 = context.getString(t.j.anti_type_hide);
            } else {
                string2 = context.getString(t.j.anti_type_exception);
            }
            string = AppealActivityConfig.isExistActivity ? MessageFormat.format(string3, string2, context.getString(t.j.anti_appeal_sign_com_tip)) : MessageFormat.format(string3, string2, "");
        } else if (AppealActivityConfig.isExistActivity) {
            string = context.getString(t.j.anti_account_exception_tip);
        } else {
            string = context.getString(t.j.anti_account_exception_tip_appealnot);
        }
        aVar.cA(string);
        if (AppealActivityConfig.isExistActivity) {
            aVar.a(context.getString(t.j.anti_vcode_pos), new e(context));
            aVar.b(context.getString(t.j.anti_account_exception_neg), new f());
        } else {
            aVar.a(context.getString(t.j.confirm), new g());
        }
        if (context instanceof Activity) {
            aVar.b(com.baidu.adp.base.l.s(context)).rU();
        }
    }

    private static void a(Context context, AntiData antiData, OperationType operationType) {
        String format;
        String string;
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.l.s(context).getPageActivity());
        if (operationType == OperationType.SIGN) {
            String string2 = context.getString(t.j.anti_appeal_sign_base_tip);
            if (e(antiData)) {
                string = context.getString(t.j.anti_type_forbid_sys);
            } else if (f(antiData)) {
                string = context.getString(t.j.anti_type_forbid_bawu);
            } else if (g(antiData)) {
                string = context.getString(t.j.anti_type_hide);
            } else {
                string = context.getString(t.j.anti_type_exception);
            }
            format = MessageFormat.format(string2, string, context.getString(t.j.anti_appeal_sign_bawu_tip));
        } else {
            format = MessageFormat.format(context.getString(t.j.anti_appeal_com_tip), antiData.getBlock_forum_name(), Integer.valueOf(antiData.getDays_tofree()));
        }
        aVar.cA(format);
        aVar.a(context.getString(t.j.anti_vcode_pos), new h(context));
        aVar.b(context.getString(t.j.anti_account_exception_neg), new i());
        if (context instanceof Activity) {
            aVar.b(com.baidu.adp.base.l.s(context)).rU();
        }
    }

    private static void b(Context context, AntiData antiData, OperationType operationType) {
        String string;
        String string2;
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.l.s(context).getPageActivity());
        if (operationType == OperationType.SIGN) {
            String string3 = context.getString(t.j.anti_appeal_sign_base_tip);
            if (e(antiData)) {
                string2 = context.getString(t.j.anti_type_forbid_sys);
            } else if (f(antiData)) {
                string2 = context.getString(t.j.anti_type_forbid_bawu);
            } else if (g(antiData)) {
                string2 = context.getString(t.j.anti_type_hide);
            } else {
                string2 = context.getString(t.j.anti_type_exception);
            }
            string = MessageFormat.format(string3, string2, context.getString(t.j.anti_appeal_sign_no_chance_tip));
        } else {
            string = context.getString(t.j.anti_no_chance_com_tip);
        }
        aVar.cA(string);
        aVar.a(context.getString(t.j.anti_no_chance_pos), new j());
        if (context instanceof Activity) {
            aVar.b(com.baidu.adp.base.l.s(context)).rU();
        }
    }

    private static void a(Context context, AntiData antiData, PageType pageType) {
        if (!com.baidu.tbadk.core.sharedPref.b.sQ().getBoolean("anti_vcode_no_longer_tip", false)) {
            boolean isHas_chance = antiData.isHas_chance();
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.l.s(context).getPageActivity());
            aVar.cA(context.getString(isHas_chance ? t.j.anti_vocode_on_chance_tip : t.j.anti_vcode_tip));
            if (!isHas_chance) {
                aVar.b(context.getString(t.j.anti_vcode_pos), new k(context, pageType));
            } else {
                aVar.b(context.getString(t.j.anti_no_chance_pos), new b());
            }
            aVar.a(context.getString(t.j.anti_vcode_neg), new c());
            if (context instanceof Activity) {
                aVar.b(com.baidu.adp.base.l.s(context)).rU();
            }
        }
    }

    private static void aUJ() {
        com.baidu.tbadk.core.sharedPref.b.sQ().remove("anti_vcode_no_longer_tip");
    }
}
