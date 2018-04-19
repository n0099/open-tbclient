package com.baidu.tieba.tbadkCore.util;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AccountRestoreActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.d;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AntiHelper {

    /* loaded from: classes.dex */
    public enum OperationType {
        ACCOUNT_RESTORE,
        CREATE_THREAD,
        SIGN,
        LIKE,
        REPLY
    }

    /* loaded from: classes.dex */
    public interface a {
        void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar);

        void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar);
    }

    public static boolean tt(int i) {
        return i == 3250002 || i == 3250001 || i == 3250003 || i == 3250004;
    }

    public static com.baidu.tbadk.core.dialog.a am(Context context, String str) {
        return g(context, str, 0);
    }

    public static com.baidu.tbadk.core.dialog.a g(Context context, String str, int i) {
        if (str == null) {
            str = "";
        }
        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
        blockPopInfoData.block_info = str;
        blockPopInfoData.ahead_url = i == 0 ? "http://tieba.baidu.com/mo/q/userappeal" : "http://tieba.baidu.com/mo/q/userappeal?block_errno=" + i;
        return a(context, blockPopInfoData);
    }

    public static com.baidu.tbadk.core.dialog.a a(Context context, String str, int i, a aVar) {
        if (str == null) {
            str = "";
        }
        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
        blockPopInfoData.block_info = str;
        blockPopInfoData.ahead_url = i == 0 ? "http://tieba.baidu.com/mo/q/userappeal" : "http://tieba.baidu.com/mo/q/userappeal?block_errno=" + i;
        return a(context, blockPopInfoData, aVar);
    }

    public static com.baidu.tbadk.core.dialog.a a(Context context, BlockPopInfoData blockPopInfoData) {
        return a(context, blockPopInfoData, (a) null);
    }

    public static com.baidu.tbadk.core.dialog.a a(final Context context, final BlockPopInfoData blockPopInfoData, final a aVar) {
        if (blockPopInfoData == null) {
            return null;
        }
        com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(i.ab(context).getPageActivity());
        if (blockPopInfoData.block_info == null) {
            blockPopInfoData.block_info = "";
        }
        aVar2.dc(blockPopInfoData.block_info);
        aVar2.a(an.isEmpty(blockPopInfoData.ahead_info) ? context.getString(d.k.anti_vcode_pos) : blockPopInfoData.ahead_info, new a.b() { // from class: com.baidu.tieba.tbadkCore.util.AntiHelper.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                if (a.this != null) {
                    a.this.onPositiveButtonClick(aVar3);
                }
                aVar3.dismiss();
                com.baidu.tbadk.browser.a.M(context, blockPopInfoData.ahead_url);
            }
        });
        aVar2.b(an.isEmpty(blockPopInfoData.ok_info) ? context.getString(d.k.anti_account_exception_neg) : blockPopInfoData.ok_info, new a.b() { // from class: com.baidu.tieba.tbadkCore.util.AntiHelper.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                if (a.this != null) {
                    a.this.onNavigationButtonClick(aVar3);
                }
                aVar3.dismiss();
            }
        });
        if (context instanceof Activity) {
            aVar2.b(i.ab(context)).tD();
            return aVar2;
        }
        return null;
    }

    public static boolean a(Context context, AntiData antiData, OperationType operationType, PageType pageType) {
        if (!g(antiData)) {
            bsL();
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

    private static void b(final Context context, AntiData antiData, OperationType operationType, PageType pageType) {
        String string;
        String string2;
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(i.ab(context).getPageActivity());
        if (operationType == OperationType.SIGN) {
            String string3 = context.getString(d.k.anti_appeal_sign_base_tip);
            if (d(antiData)) {
                string2 = context.getString(d.k.anti_type_forbid_sys);
            } else if (e(antiData)) {
                string2 = context.getString(d.k.anti_type_forbid_bawu);
            } else if (f(antiData)) {
                string2 = context.getString(d.k.anti_type_hide);
            } else {
                string2 = context.getString(d.k.anti_type_exception);
            }
            string = MessageFormat.format(string3, string2, context.getString(d.k.anti_appeal_sign_com_tip));
        } else {
            string = context.getString(d.k.anti_account_exception_tip);
        }
        aVar.dc(string);
        aVar.a(context.getString(d.k.anti_vcode_pos), new a.b() { // from class: com.baidu.tieba.tbadkCore.util.AntiHelper.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                com.baidu.tbadk.browser.a.M(context, "http://tieba.baidu.com/mo/q/userappeal");
            }
        });
        aVar.b(context.getString(d.k.anti_account_exception_neg), new a.b() { // from class: com.baidu.tieba.tbadkCore.util.AntiHelper.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        if (context instanceof Activity) {
            aVar.b(i.ab(context)).tD();
        }
    }

    private static void a(final Context context, AntiData antiData, OperationType operationType) {
        String format;
        String string;
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(i.ab(context).getPageActivity());
        if (operationType == OperationType.SIGN) {
            String string2 = context.getString(d.k.anti_appeal_sign_base_tip);
            if (d(antiData)) {
                string = context.getString(d.k.anti_type_forbid_sys);
            } else if (e(antiData)) {
                string = context.getString(d.k.anti_type_forbid_bawu);
            } else if (f(antiData)) {
                string = context.getString(d.k.anti_type_hide);
            } else {
                string = context.getString(d.k.anti_type_exception);
            }
            format = MessageFormat.format(string2, string, context.getString(d.k.anti_appeal_sign_bawu_tip));
        } else {
            format = MessageFormat.format(context.getString(d.k.anti_appeal_com_tip), antiData.getBlock_forum_name(), Integer.valueOf(antiData.getDays_tofree()));
        }
        aVar.dc(format);
        aVar.a(context.getString(d.k.anti_vcode_pos), new a.b() { // from class: com.baidu.tieba.tbadkCore.util.AntiHelper.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                com.baidu.tbadk.browser.a.M(context, "http://tieba.baidu.com/mo/q/userappeal");
            }
        });
        aVar.b(context.getString(d.k.anti_account_exception_neg), new a.b() { // from class: com.baidu.tieba.tbadkCore.util.AntiHelper.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        if (context instanceof Activity) {
            aVar.b(i.ab(context)).tD();
        }
    }

    private static void b(Context context, AntiData antiData, OperationType operationType) {
        String string;
        String string2;
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(i.ab(context).getPageActivity());
        if (operationType == OperationType.SIGN) {
            String string3 = context.getString(d.k.anti_appeal_sign_base_tip);
            if (d(antiData)) {
                string2 = context.getString(d.k.anti_type_forbid_sys);
            } else if (e(antiData)) {
                string2 = context.getString(d.k.anti_type_forbid_bawu);
            } else if (f(antiData)) {
                string2 = context.getString(d.k.anti_type_hide);
            } else {
                string2 = context.getString(d.k.anti_type_exception);
            }
            string = MessageFormat.format(string3, string2, context.getString(d.k.anti_appeal_sign_no_chance_tip));
        } else {
            string = context.getString(d.k.anti_no_chance_com_tip);
        }
        aVar.dc(string);
        aVar.a(context.getString(d.k.confirm), new a.b() { // from class: com.baidu.tieba.tbadkCore.util.AntiHelper.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        if (context instanceof Activity) {
            aVar.b(i.ab(context)).tD();
        }
    }

    private static void a(final Context context, AntiData antiData, final PageType pageType) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("anti_vcode_no_longer_tip", false)) {
            boolean isHas_chance = antiData.isHas_chance();
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(i.ab(context).getPageActivity());
            aVar.dc(context.getString(isHas_chance ? d.k.anti_vocode_on_chance_tip : d.k.anti_vcode_tip));
            if (!isHas_chance) {
                aVar.b(context.getString(d.k.anti_vcode_pos), new a.b() { // from class: com.baidu.tieba.tbadkCore.util.AntiHelper.9
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountRestoreActivityConfig(context, pageType)));
                    }
                });
            } else {
                aVar.b(context.getString(d.k.confirm), new a.b() { // from class: com.baidu.tieba.tbadkCore.util.AntiHelper.10
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
            }
            aVar.a(context.getString(d.k.anti_vcode_neg), new a.b() { // from class: com.baidu.tieba.tbadkCore.util.AntiHelper.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("anti_vcode_no_longer_tip", true);
                    aVar2.dismiss();
                }
            });
            if (context instanceof Activity) {
                aVar.b(i.ab(context)).tD();
            }
        }
    }

    public static boolean e(Context context, int i, String str) {
        if (tu(i)) {
            an(context, str);
            return true;
        }
        return false;
    }

    public static boolean tu(int i) {
        return i == 3250012;
    }

    public static void an(Context context, String str) {
        if (context != null && !an.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair("nomenu", "1"));
            arrayList.add(new Pair("noshare", "1"));
            com.baidu.tbadk.browser.a.M(context, com.baidu.tbadk.browser.a.b(str, arrayList));
        }
    }

    private static void bsL() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().remove("anti_vcode_no_longer_tip");
    }
}
