package com.baidu.tieba.tbadkCore.util;

import android.app.Activity;
import android.content.Context;
import com.baidu.tbadk.core.atomData.AppealActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.i;
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

        /* JADX DEBUG: Replace access to removed values field (cTe) with 'values()' method */
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
        if (!g(antiData)) {
            avd();
        }
        if (d(antiData) || f(antiData)) {
            if (antiData.isHas_chance()) {
                b(context, antiData, operationType, pageType);
                return true;
            }
            b(context, antiData, operationType);
            return true;
        } else if (e(antiData)) {
            a(context, antiData, operationType);
            return true;
        } else if (g(antiData) && operationType == OperationType.REPLY) {
            a(context, antiData, pageType);
            return true;
        } else {
            return false;
        }
    }

    public static boolean d(AntiData antiData) {
        return antiData != null && antiData.getBlock_stat() == 2;
    }

    public static boolean e(AntiData antiData) {
        return antiData != null && antiData.getBlock_stat() == 3;
    }

    public static boolean f(AntiData antiData) {
        return antiData != null && antiData.getHide_stat() == 1;
    }

    public static boolean g(AntiData antiData) {
        return antiData != null && antiData.getVcode_stat() == 1;
    }

    private static void b(Context context, AntiData antiData, OperationType operationType, PageType pageType) {
        String string;
        String string2;
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.l.C(context).getPageActivity());
        if (operationType == OperationType.SIGN) {
            String string3 = context.getString(i.h.anti_appeal_sign_base_tip);
            if (d(antiData)) {
                string2 = context.getString(i.h.anti_type_forbid_sys);
            } else if (e(antiData)) {
                string2 = context.getString(i.h.anti_type_forbid_bawu);
            } else if (f(antiData)) {
                string2 = context.getString(i.h.anti_type_hide);
            } else {
                string2 = context.getString(i.h.anti_type_exception);
            }
            string = AppealActivityConfig.isExistActivity ? MessageFormat.format(string3, string2, context.getString(i.h.anti_appeal_sign_com_tip)) : MessageFormat.format(string3, string2, "");
        } else if (AppealActivityConfig.isExistActivity) {
            string = context.getString(i.h.anti_account_exception_tip);
        } else {
            string = context.getString(i.h.anti_account_exception_tip_appealnot);
        }
        aVar.ct(string);
        if (AppealActivityConfig.isExistActivity) {
            aVar.b(context.getString(i.h.anti_vcode_pos), new a(context, pageType));
            aVar.a(context.getString(i.h.anti_account_exception_neg), new b());
        } else {
            aVar.a(context.getString(i.h.confirm), new c());
        }
        if (context instanceof Activity) {
            aVar.b(com.baidu.adp.base.l.C(context)).sU();
        }
    }

    private static void a(Context context, AntiData antiData, OperationType operationType) {
        String format;
        String string;
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.l.C(context).getPageActivity());
        if (operationType == OperationType.SIGN) {
            String string2 = context.getString(i.h.anti_appeal_sign_base_tip);
            if (d(antiData)) {
                string = context.getString(i.h.anti_type_forbid_sys);
            } else if (e(antiData)) {
                string = context.getString(i.h.anti_type_forbid_bawu);
            } else if (f(antiData)) {
                string = context.getString(i.h.anti_type_hide);
            } else {
                string = context.getString(i.h.anti_type_exception);
            }
            format = MessageFormat.format(string2, string, context.getString(i.h.anti_appeal_sign_bawu_tip));
        } else {
            format = MessageFormat.format(context.getString(i.h.anti_appeal_com_tip), antiData.getBlock_forum_name(), Integer.valueOf(antiData.getDays_tofree()));
        }
        aVar.ct(format);
        aVar.b(context.getString(i.h.anti_appeal_btn_pos), new d(context, antiData));
        aVar.a(context.getString(i.h.anti_appeal_btn_neg), new e());
        if (context instanceof Activity) {
            aVar.b(com.baidu.adp.base.l.C(context)).sU();
        }
    }

    private static void b(Context context, AntiData antiData, OperationType operationType) {
        String string;
        String string2;
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.l.C(context).getPageActivity());
        if (operationType == OperationType.SIGN) {
            String string3 = context.getString(i.h.anti_appeal_sign_base_tip);
            if (d(antiData)) {
                string2 = context.getString(i.h.anti_type_forbid_sys);
            } else if (e(antiData)) {
                string2 = context.getString(i.h.anti_type_forbid_bawu);
            } else if (f(antiData)) {
                string2 = context.getString(i.h.anti_type_hide);
            } else {
                string2 = context.getString(i.h.anti_type_exception);
            }
            string = MessageFormat.format(string3, string2, context.getString(i.h.anti_appeal_sign_no_chance_tip));
        } else {
            string = context.getString(i.h.anti_no_chance_com_tip);
        }
        aVar.ct(string);
        aVar.a(context.getString(i.h.anti_no_chance_pos), new f());
        if (context instanceof Activity) {
            aVar.b(com.baidu.adp.base.l.C(context)).sU();
        }
    }

    private static void a(Context context, AntiData antiData, PageType pageType) {
        if (!com.baidu.tbadk.core.sharedPref.b.tx().getBoolean("anti_vcode_no_longer_tip", false)) {
            boolean isHas_chance = antiData.isHas_chance();
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(com.baidu.adp.base.l.C(context).getPageActivity());
            aVar.ct(context.getString(isHas_chance ? i.h.anti_vocode_on_chance_tip : i.h.anti_vcode_tip));
            if (!isHas_chance) {
                aVar.b(context.getString(i.h.anti_vcode_pos), new g(context, pageType));
            } else {
                aVar.b(context.getString(i.h.anti_no_chance_pos), new h());
            }
            aVar.a(context.getString(i.h.anti_vcode_neg), new i());
            if (context instanceof Activity) {
                aVar.b(com.baidu.adp.base.l.C(context)).sU();
            }
        }
    }

    private static void avd() {
        com.baidu.tbadk.core.sharedPref.b.tx().remove("anti_vcode_no_longer_tip");
    }
}
