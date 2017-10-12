package com.baidu.tieba.tbadkCore.util;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AccountRestoreActivityConfig;
import com.baidu.tbadk.core.atomData.AppealActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.d;
import java.text.MessageFormat;
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

    public static boolean tG(int i) {
        return i == 3250002 || i == 3250001 || i == 3250003 || i == 3250004;
    }

    public static com.baidu.tbadk.core.dialog.a at(Context context, String str) {
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
        com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(i.Y(context).getPageActivity());
        if (blockPopInfoData.block_info == null) {
            blockPopInfoData.block_info = "";
        }
        aVar2.cM(blockPopInfoData.block_info);
        if (AppealActivityConfig.isExistActivity) {
            aVar2.a(am.isEmpty(blockPopInfoData.ahead_info) ? context.getString(d.l.anti_vcode_pos) : blockPopInfoData.ahead_info, new a.b() { // from class: com.baidu.tieba.tbadkCore.util.AntiHelper.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                    if (a.this != null) {
                        a.this.onPositiveButtonClick(aVar3);
                    }
                    aVar3.dismiss();
                    com.baidu.tbadk.browser.a.T(context, blockPopInfoData.ahead_url);
                }
            });
            aVar2.b(am.isEmpty(blockPopInfoData.ok_info) ? context.getString(d.l.anti_account_exception_neg) : blockPopInfoData.ok_info, new a.b() { // from class: com.baidu.tieba.tbadkCore.util.AntiHelper.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                    if (a.this != null) {
                        a.this.onNavigationButtonClick(aVar3);
                    }
                    aVar3.dismiss();
                }
            });
        }
        if (context instanceof Activity) {
            aVar2.b(i.Y(context)).ti();
            return aVar2;
        }
        return null;
    }

    public static boolean a(Context context, AntiData antiData, OperationType operationType, PageType pageType) {
        if (!i(antiData)) {
            bsk();
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

    private static void b(final Context context, AntiData antiData, OperationType operationType, PageType pageType) {
        String string;
        String string2;
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(i.Y(context).getPageActivity());
        if (operationType == OperationType.SIGN) {
            String string3 = context.getString(d.l.anti_appeal_sign_base_tip);
            if (f(antiData)) {
                string2 = context.getString(d.l.anti_type_forbid_sys);
            } else if (g(antiData)) {
                string2 = context.getString(d.l.anti_type_forbid_bawu);
            } else if (h(antiData)) {
                string2 = context.getString(d.l.anti_type_hide);
            } else {
                string2 = context.getString(d.l.anti_type_exception);
            }
            string = true == AppealActivityConfig.isExistActivity ? MessageFormat.format(string3, string2, context.getString(d.l.anti_appeal_sign_com_tip)) : MessageFormat.format(string3, string2, "");
        } else if (true == AppealActivityConfig.isExistActivity) {
            string = context.getString(d.l.anti_account_exception_tip);
        } else {
            string = context.getString(d.l.anti_account_exception_tip_appealnot);
        }
        aVar.cM(string);
        if (true == AppealActivityConfig.isExistActivity) {
            aVar.a(context.getString(d.l.anti_vcode_pos), new a.b() { // from class: com.baidu.tieba.tbadkCore.util.AntiHelper.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    com.baidu.tbadk.browser.a.T(context, "http://tieba.baidu.com/mo/q/userappeal");
                }
            });
            aVar.b(context.getString(d.l.anti_account_exception_neg), new a.b() { // from class: com.baidu.tieba.tbadkCore.util.AntiHelper.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
        } else {
            aVar.a(context.getString(d.l.confirm), new a.b() { // from class: com.baidu.tieba.tbadkCore.util.AntiHelper.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
        }
        if (context instanceof Activity) {
            aVar.b(i.Y(context)).ti();
        }
    }

    private static void a(final Context context, AntiData antiData, OperationType operationType) {
        String format;
        String string;
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(i.Y(context).getPageActivity());
        if (operationType == OperationType.SIGN) {
            String string2 = context.getString(d.l.anti_appeal_sign_base_tip);
            if (f(antiData)) {
                string = context.getString(d.l.anti_type_forbid_sys);
            } else if (g(antiData)) {
                string = context.getString(d.l.anti_type_forbid_bawu);
            } else if (h(antiData)) {
                string = context.getString(d.l.anti_type_hide);
            } else {
                string = context.getString(d.l.anti_type_exception);
            }
            format = MessageFormat.format(string2, string, context.getString(d.l.anti_appeal_sign_bawu_tip));
        } else {
            format = MessageFormat.format(context.getString(d.l.anti_appeal_com_tip), antiData.getBlock_forum_name(), Integer.valueOf(antiData.getDays_tofree()));
        }
        aVar.cM(format);
        aVar.a(context.getString(d.l.anti_vcode_pos), new a.b() { // from class: com.baidu.tieba.tbadkCore.util.AntiHelper.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                com.baidu.tbadk.browser.a.T(context, "http://tieba.baidu.com/mo/q/userappeal");
            }
        });
        aVar.b(context.getString(d.l.anti_account_exception_neg), new a.b() { // from class: com.baidu.tieba.tbadkCore.util.AntiHelper.9
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        if (context instanceof Activity) {
            aVar.b(i.Y(context)).ti();
        }
    }

    private static void b(Context context, AntiData antiData, OperationType operationType) {
        String string;
        String string2;
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(i.Y(context).getPageActivity());
        if (operationType == OperationType.SIGN) {
            String string3 = context.getString(d.l.anti_appeal_sign_base_tip);
            if (f(antiData)) {
                string2 = context.getString(d.l.anti_type_forbid_sys);
            } else if (g(antiData)) {
                string2 = context.getString(d.l.anti_type_forbid_bawu);
            } else if (h(antiData)) {
                string2 = context.getString(d.l.anti_type_hide);
            } else {
                string2 = context.getString(d.l.anti_type_exception);
            }
            string = MessageFormat.format(string3, string2, context.getString(d.l.anti_appeal_sign_no_chance_tip));
        } else {
            string = context.getString(d.l.anti_no_chance_com_tip);
        }
        aVar.cM(string);
        aVar.a(context.getString(d.l.confirm), new a.b() { // from class: com.baidu.tieba.tbadkCore.util.AntiHelper.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        if (context instanceof Activity) {
            aVar.b(i.Y(context)).ti();
        }
    }

    private static void a(final Context context, AntiData antiData, final PageType pageType) {
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("anti_vcode_no_longer_tip", false)) {
            boolean isHas_chance = antiData.isHas_chance();
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(i.Y(context).getPageActivity());
            aVar.cM(context.getString(isHas_chance ? d.l.anti_vocode_on_chance_tip : d.l.anti_vcode_tip));
            if (!isHas_chance) {
                aVar.b(context.getString(d.l.anti_vcode_pos), new a.b() { // from class: com.baidu.tieba.tbadkCore.util.AntiHelper.11
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountRestoreActivityConfig(context, pageType)));
                    }
                });
            } else {
                aVar.b(context.getString(d.l.confirm), new a.b() { // from class: com.baidu.tieba.tbadkCore.util.AntiHelper.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
            }
            aVar.a(context.getString(d.l.anti_vcode_neg), new a.b() { // from class: com.baidu.tieba.tbadkCore.util.AntiHelper.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("anti_vcode_no_longer_tip", true);
                    aVar2.dismiss();
                }
            });
            if (context instanceof Activity) {
                aVar.b(i.Y(context)).ti();
            }
        }
    }

    private static void bsk() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().remove("anti_vcode_no_longer_tip");
    }
}
