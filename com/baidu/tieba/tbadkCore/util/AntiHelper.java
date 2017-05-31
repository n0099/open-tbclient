package com.baidu.tieba.tbadkCore.util;

import android.app.Activity;
import android.content.Context;
import com.baidu.tbadk.core.atomData.AppealActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.w;
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

        /* JADX DEBUG: Replace access to removed values field (fEv) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static OperationType[] valuesCustom() {
            OperationType[] valuesCustom = values();
            int length = valuesCustom.length;
            OperationType[] operationTypeArr = new OperationType[length];
            System.arraycopy(valuesCustom, 0, operationTypeArr, 0, length);
            return operationTypeArr;
        }
    }

    public static boolean sr(int i) {
        return i == 3250002 || i == 3250001 || i == 3250003 || i == 3250004;
    }

    public static com.baidu.tbadk.core.dialog.a ap(Context context, String str) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.k.Z(context).getPageActivity());
        if (str == null) {
            str = "";
        }
        aVar.cB(str);
        if (AppealActivityConfig.isExistActivity) {
            aVar.a(context.getString(w.l.anti_vcode_pos), new a(context));
            aVar.b(context.getString(w.l.anti_account_exception_neg), new d());
        }
        if (context instanceof Activity) {
            aVar.b(com.baidu.adp.base.k.Z(context)).tc();
            return aVar;
        }
        return null;
    }

    public static boolean a(Context context, AntiData antiData, OperationType operationType, PageType pageType) {
        if (!i(antiData)) {
            biT();
        }
        if (f(antiData) || h(antiData)) {
            if (antiData.isHas_chance()) {
                b(context, antiData, operationType, pageType);
                return true;
            }
            b(context, antiData, operationType);
            return true;
        } else if (g(antiData)) {
            a(context, antiData, operationType);
            return true;
        } else if (i(antiData) && operationType == OperationType.REPLY) {
            a(context, antiData, pageType);
            return true;
        } else {
            return false;
        }
    }

    public static boolean f(AntiData antiData) {
        return antiData != null && antiData.getBlock_stat() == 2;
    }

    public static boolean g(AntiData antiData) {
        return antiData != null && antiData.getBlock_stat() == 3;
    }

    public static boolean h(AntiData antiData) {
        return antiData != null && antiData.getHide_stat() == 1;
    }

    public static boolean i(AntiData antiData) {
        return antiData != null && antiData.getVcode_stat() == 1;
    }

    private static void b(Context context, AntiData antiData, OperationType operationType, PageType pageType) {
        String string;
        String string2;
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.k.Z(context).getPageActivity());
        if (operationType == OperationType.SIGN) {
            String string3 = context.getString(w.l.anti_appeal_sign_base_tip);
            if (f(antiData)) {
                string2 = context.getString(w.l.anti_type_forbid_sys);
            } else if (g(antiData)) {
                string2 = context.getString(w.l.anti_type_forbid_bawu);
            } else if (h(antiData)) {
                string2 = context.getString(w.l.anti_type_hide);
            } else {
                string2 = context.getString(w.l.anti_type_exception);
            }
            string = AppealActivityConfig.isExistActivity ? MessageFormat.format(string3, string2, context.getString(w.l.anti_appeal_sign_com_tip)) : MessageFormat.format(string3, string2, "");
        } else if (AppealActivityConfig.isExistActivity) {
            string = context.getString(w.l.anti_account_exception_tip);
        } else {
            string = context.getString(w.l.anti_account_exception_tip_appealnot);
        }
        aVar.cB(string);
        if (AppealActivityConfig.isExistActivity) {
            aVar.a(context.getString(w.l.anti_vcode_pos), new e(context));
            aVar.b(context.getString(w.l.anti_account_exception_neg), new f());
        } else {
            aVar.a(context.getString(w.l.confirm), new g());
        }
        if (context instanceof Activity) {
            aVar.b(com.baidu.adp.base.k.Z(context)).tc();
        }
    }

    private static void a(Context context, AntiData antiData, OperationType operationType) {
        String format;
        String string;
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.k.Z(context).getPageActivity());
        if (operationType == OperationType.SIGN) {
            String string2 = context.getString(w.l.anti_appeal_sign_base_tip);
            if (f(antiData)) {
                string = context.getString(w.l.anti_type_forbid_sys);
            } else if (g(antiData)) {
                string = context.getString(w.l.anti_type_forbid_bawu);
            } else if (h(antiData)) {
                string = context.getString(w.l.anti_type_hide);
            } else {
                string = context.getString(w.l.anti_type_exception);
            }
            format = MessageFormat.format(string2, string, context.getString(w.l.anti_appeal_sign_bawu_tip));
        } else {
            format = MessageFormat.format(context.getString(w.l.anti_appeal_com_tip), antiData.getBlock_forum_name(), Integer.valueOf(antiData.getDays_tofree()));
        }
        aVar.cB(format);
        aVar.a(context.getString(w.l.anti_vcode_pos), new h(context));
        aVar.b(context.getString(w.l.anti_account_exception_neg), new i());
        if (context instanceof Activity) {
            aVar.b(com.baidu.adp.base.k.Z(context)).tc();
        }
    }

    private static void b(Context context, AntiData antiData, OperationType operationType) {
        String string;
        String string2;
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.k.Z(context).getPageActivity());
        if (operationType == OperationType.SIGN) {
            String string3 = context.getString(w.l.anti_appeal_sign_base_tip);
            if (f(antiData)) {
                string2 = context.getString(w.l.anti_type_forbid_sys);
            } else if (g(antiData)) {
                string2 = context.getString(w.l.anti_type_forbid_bawu);
            } else if (h(antiData)) {
                string2 = context.getString(w.l.anti_type_hide);
            } else {
                string2 = context.getString(w.l.anti_type_exception);
            }
            string = MessageFormat.format(string3, string2, context.getString(w.l.anti_appeal_sign_no_chance_tip));
        } else {
            string = context.getString(w.l.anti_no_chance_com_tip);
        }
        aVar.cB(string);
        aVar.a(context.getString(w.l.confirm), new j());
        if (context instanceof Activity) {
            aVar.b(com.baidu.adp.base.k.Z(context)).tc();
        }
    }

    private static void a(Context context, AntiData antiData, PageType pageType) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("anti_vcode_no_longer_tip", false)) {
            boolean isHas_chance = antiData.isHas_chance();
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.k.Z(context).getPageActivity());
            aVar.cB(context.getString(isHas_chance ? w.l.anti_vocode_on_chance_tip : w.l.anti_vcode_tip));
            if (!isHas_chance) {
                aVar.b(context.getString(w.l.anti_vcode_pos), new k(context, pageType));
            } else {
                aVar.b(context.getString(w.l.confirm), new b());
            }
            aVar.a(context.getString(w.l.anti_vcode_neg), new c());
            if (context instanceof Activity) {
                aVar.b(com.baidu.adp.base.k.Z(context)).tc();
            }
        }
    }

    private static void biT() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().remove("anti_vcode_no_longer_tip");
    }
}
