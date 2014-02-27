package com.baidu.tieba.util;

import android.app.AlertDialog;
import android.content.Context;
import com.baidu.tieba.data.AntiData;
import com.slidingmenu.lib.R;
import java.text.MessageFormat;
/* loaded from: classes.dex */
public final class AntiHelper {

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
        String string;
        String string2;
        String string3;
        String string4;
        String format;
        String string5;
        if (!d(antiData)) {
            com.baidu.tieba.sharedPref.b.a().a("anti_vcode_no_longer_tip");
        }
        if (a(antiData) || c(antiData)) {
            if (antiData.isHas_chance()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(context.getString(R.string.anti_title));
                if (operationType == OperationType.SIGN) {
                    String string6 = context.getString(R.string.anti_appeal_sign_base_tip);
                    if (a(antiData)) {
                        string4 = context.getString(R.string.anti_type_forbid_sys);
                    } else {
                        string4 = b(antiData) ? context.getString(R.string.anti_type_forbid_bawu) : c(antiData) ? context.getString(R.string.anti_type_hide) : context.getString(R.string.anti_type_exception);
                    }
                    string3 = MessageFormat.format(string6, string4, context.getString(R.string.anti_appeal_sign_com_tip));
                } else {
                    string3 = context.getString(R.string.anti_account_exception_tip);
                }
                builder.setMessage(string3);
                builder.setNegativeButton(context.getString(R.string.anti_account_exception_pos), new a(context, pageType));
                builder.setPositiveButton(context.getString(R.string.anti_account_exception_neg), new b());
                builder.create().show();
                return true;
            }
            AlertDialog.Builder builder2 = new AlertDialog.Builder(context);
            builder2.setTitle(context.getString(R.string.anti_title));
            if (operationType == OperationType.SIGN) {
                String string7 = context.getString(R.string.anti_appeal_sign_base_tip);
                if (a(antiData)) {
                    string2 = context.getString(R.string.anti_type_forbid_sys);
                } else {
                    string2 = b(antiData) ? context.getString(R.string.anti_type_forbid_bawu) : c(antiData) ? context.getString(R.string.anti_type_hide) : context.getString(R.string.anti_type_exception);
                }
                string = MessageFormat.format(string7, string2, context.getString(R.string.anti_appeal_sign_no_chance_tip));
            } else {
                string = context.getString(R.string.anti_no_chance_com_tip);
            }
            builder2.setMessage(string);
            builder2.setPositiveButton(context.getString(R.string.anti_no_chance_pos), new e());
            builder2.create().show();
            return true;
        } else if (b(antiData)) {
            AlertDialog.Builder builder3 = new AlertDialog.Builder(context);
            builder3.setTitle(context.getString(R.string.anti_title));
            if (operationType == OperationType.SIGN) {
                String string8 = context.getString(R.string.anti_appeal_sign_base_tip);
                if (a(antiData)) {
                    string5 = context.getString(R.string.anti_type_forbid_sys);
                } else {
                    string5 = b(antiData) ? context.getString(R.string.anti_type_forbid_bawu) : c(antiData) ? context.getString(R.string.anti_type_hide) : context.getString(R.string.anti_type_exception);
                }
                format = MessageFormat.format(string8, string5, context.getString(R.string.anti_appeal_sign_bawu_tip));
            } else {
                format = MessageFormat.format(context.getString(R.string.anti_appeal_com_tip), antiData.getBlock_forum_name(), Integer.valueOf(antiData.getDays_tofree()));
            }
            builder3.setMessage(format);
            builder3.setNegativeButton(context.getString(R.string.anti_appeal_btn_pos), new c(context, antiData));
            builder3.setPositiveButton(context.getString(R.string.anti_appeal_btn_neg), new d());
            builder3.create().show();
            return true;
        } else if (d(antiData) && operationType == OperationType.REPLY) {
            if (!com.baidu.tieba.sharedPref.b.a().a("anti_vcode_no_longer_tip", false)) {
                boolean isHas_chance = antiData.isHas_chance();
                AlertDialog.Builder builder4 = new AlertDialog.Builder(context);
                builder4.setTitle(context.getString(R.string.anti_title));
                builder4.setMessage(context.getString(isHas_chance ? R.string.anti_vocode_on_chance_tip : R.string.anti_vcode_tip));
                if (isHas_chance) {
                    builder4.setNegativeButton(context.getString(R.string.anti_no_chance_pos), new g());
                } else {
                    builder4.setNegativeButton(context.getString(R.string.anti_vcode_pos), new f(context, pageType));
                }
                builder4.setPositiveButton(context.getString(R.string.anti_vcode_neg), new h());
                builder4.create().show();
            }
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
}
