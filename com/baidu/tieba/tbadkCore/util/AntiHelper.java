package com.baidu.tieba.tbadkCore.util;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountRestoreActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.R;
import com.baidu.tieba.video.VideoItemData;
import d.b.c.e.p.l;
import d.b.h0.r.q.a2;
import d.b.h0.r.s.a;
import java.text.MessageFormat;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class AntiHelper {

    /* loaded from: classes5.dex */
    public enum OperationType {
        ACCOUNT_RESTORE,
        CREATE_THREAD,
        SIGN,
        LIKE,
        REPLY
    }

    /* loaded from: classes5.dex */
    public static class a implements a.e {
        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            d.b.h0.r.d0.b.j().t("anti_vcode_no_longer_tip", true);
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f21089e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f21090f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ BlockPopInfoData f21091g;

        public b(k kVar, Context context, BlockPopInfoData blockPopInfoData) {
            this.f21089e = kVar;
            this.f21090f = context;
            this.f21091g = blockPopInfoData;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            k kVar = this.f21089e;
            if (kVar != null) {
                kVar.onPositiveButtonClick(aVar);
            }
            aVar.dismiss();
            d.b.h0.l.a.l(this.f21090f, this.f21091g.ahead_url);
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f21092e;

        public c(k kVar) {
            this.f21092e = kVar;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            k kVar = this.f21092e;
            if (kVar != null) {
                kVar.onNavigationButtonClick(aVar);
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f21093e;

        public d(Context context) {
            this.f21093e = context;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
            d.b.h0.l.a.l(this.f21093e, "http://tieba.baidu.com/mo/q/userappeal");
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements a.e {
        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public static class f implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f21094e;

        public f(Context context) {
            this.f21094e = context;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
            d.b.h0.l.a.l(this.f21094e, "http://tieba.baidu.com/mo/q/userappeal");
        }
    }

    /* loaded from: classes5.dex */
    public static class g implements a.e {
        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public static class h implements a.e {
        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public static class i implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f21095e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PageType f21096f;

        public i(Context context, PageType pageType) {
            this.f21095e = context;
            this.f21096f = pageType;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountRestoreActivityConfig(this.f21095e, this.f21096f)));
        }
    }

    /* loaded from: classes5.dex */
    public static class j implements a.e {
        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public interface k {
        void onNavigationButtonClick(d.b.h0.r.s.a aVar);

        void onPositiveButtonClick(d.b.h0.r.s.a aVar);
    }

    public static void A(Context context, AntiData antiData, OperationType operationType, PageType pageType) {
        String string;
        String string2;
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(d.b.c.a.j.a(context).getPageActivity());
        if (operationType == OperationType.SIGN) {
            String string3 = context.getString(R.string.anti_appeal_sign_base_tip);
            if (n(antiData)) {
                string2 = context.getString(R.string.anti_type_forbid_sys);
            } else if (g(antiData)) {
                string2 = context.getString(R.string.anti_type_forbid_bawu);
            } else if (h(antiData)) {
                string2 = context.getString(R.string.anti_type_hide);
            } else {
                string2 = context.getString(R.string.anti_type_exception);
            }
            string = MessageFormat.format(string3, string2, context.getString(R.string.anti_appeal_sign_com_tip));
        } else {
            string = context.getString(R.string.anti_account_exception_tip);
        }
        aVar.setMessage(string);
        aVar.setPositiveButton(context.getString(R.string.anti_vcode_pos), new d(context));
        aVar.setNegativeButton(context.getString(R.string.anti_account_exception_neg), new e());
        if (context instanceof Activity) {
            aVar.create(d.b.c.a.j.a(context)).show();
        }
    }

    public static boolean a(Context context, int i2, String str) {
        if (i(i2)) {
            p(context, str);
            return true;
        }
        return false;
    }

    public static boolean b(TbPageContext<?> tbPageContext, a2 a2Var) {
        if (tbPageContext == null || !j(a2Var)) {
            return false;
        }
        l.L(tbPageContext.getPageActivity(), StringUtils.isNull(a2Var.e2) ? tbPageContext.getString(R.string.forbiden_comment_text) : a2Var.e2);
        return true;
    }

    public static boolean c(TbPageContext<?> tbPageContext, VideoItemData videoItemData) {
        if (tbPageContext == null || !k(videoItemData)) {
            return false;
        }
        l.L(tbPageContext.getPageActivity(), StringUtils.isNull(videoItemData.noCommetStr) ? tbPageContext.getString(R.string.forbiden_comment_text) : videoItemData.noCommetStr);
        return true;
    }

    public static boolean d(TbPageContext<?> tbPageContext, AntiData antiData) {
        return false;
    }

    public static boolean e(Context context, a2 a2Var) {
        if (context == null || !o(a2Var)) {
            return false;
        }
        l.K(context, R.string.feed_thread_state_under_review_text);
        return true;
    }

    public static boolean f(AntiData antiData) {
        return antiData != null && antiData.getVcode_stat() == 1;
    }

    public static boolean g(AntiData antiData) {
        return antiData != null && antiData.getBlock_stat() == 3;
    }

    public static boolean h(AntiData antiData) {
        return antiData != null && antiData.getHide_stat() == 1;
    }

    public static boolean i(int i2) {
        return i2 == 3250012;
    }

    public static boolean j(a2 a2Var) {
        return a2Var != null && a2Var.y2() && a2Var.d2;
    }

    public static boolean k(VideoItemData videoItemData) {
        return videoItemData != null && videoItemData.isBjhVideo && videoItemData.forbidComment;
    }

    public static boolean l(int i2) {
        return i2 == 3250002 || i2 == 3250001 || i2 == 3250003 || i2 == 3250004 || i2 == 3250013;
    }

    public static boolean m(int i2, String str) {
        if (i2 != 3250013) {
            return i2 == 3250002 || i2 == 3250001 || i2 == 3250003 || i2 == 3250004 || i2 == 3250013;
        }
        if (d.b.c.e.p.k.isEmpty(str)) {
            str = TbadkCoreApplication.getInst().getContext().getString(R.string.anti_account_exception_appealing);
        }
        BdToast.h(TbadkCoreApplication.getInst().getContext(), str, R.drawable.icon_pure_toast_mistake40_svg, 3000, false).q();
        return true;
    }

    public static boolean n(AntiData antiData) {
        return antiData != null && antiData.getBlock_stat() == 2;
    }

    public static boolean o(a2 a2Var) {
        return a2Var != null && a2Var.m1 && a2Var.y2();
    }

    public static void p(Context context, String str) {
        if (context == null || d.b.c.e.p.k.isEmpty(str)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("nomenu", "1"));
        arrayList.add(new Pair("noshare", "1"));
        d.b.h0.l.a.l(context, d.b.h0.l.a.c(str, arrayList));
    }

    public static void q() {
        d.b.h0.r.d0.b.j().C("anti_vcode_no_longer_tip");
    }

    public static void r(Context context, AntiData antiData, PageType pageType) {
        if (d.b.h0.r.d0.b.j().g("anti_vcode_no_longer_tip", false)) {
            return;
        }
        boolean isHas_chance = antiData.isHas_chance();
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(d.b.c.a.j.a(context).getPageActivity());
        aVar.setMessage(context.getString(isHas_chance ? R.string.anti_vocode_on_chance_tip : R.string.anti_vcode_tip));
        if (!isHas_chance) {
            aVar.setNegativeButton(context.getString(R.string.anti_vcode_pos), new i(context, pageType));
        } else {
            aVar.setNegativeButton(context.getString(R.string.confirm), new j());
        }
        aVar.setPositiveButton(context.getString(R.string.anti_vcode_neg), new a());
        if (context instanceof Activity) {
            aVar.create(d.b.c.a.j.a(context)).show();
        }
    }

    public static d.b.h0.r.s.a s(Context context, BlockPopInfoData blockPopInfoData) {
        return t(context, blockPopInfoData, null);
    }

    public static d.b.h0.r.s.a t(Context context, BlockPopInfoData blockPopInfoData, k kVar) {
        if (blockPopInfoData == null) {
            return null;
        }
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(d.b.c.a.j.a(context).getPageActivity());
        if (blockPopInfoData.block_info == null) {
            blockPopInfoData.block_info = "";
        }
        aVar.setMessage(blockPopInfoData.block_info);
        aVar.setPositiveButton(d.b.c.e.p.k.isEmpty(blockPopInfoData.ahead_info) ? context.getString(R.string.anti_vcode_pos) : blockPopInfoData.ahead_info, new b(kVar, context, blockPopInfoData));
        aVar.setNegativeButton(d.b.c.e.p.k.isEmpty(blockPopInfoData.ok_info) ? context.getString(R.string.anti_account_exception_neg) : blockPopInfoData.ok_info, new c(kVar));
        if (context instanceof Activity) {
            aVar.create(d.b.c.a.j.a(context)).show();
            return aVar;
        }
        return null;
    }

    public static d.b.h0.r.s.a u(Context context, String str) {
        return v(context, str, 0);
    }

    public static d.b.h0.r.s.a v(Context context, String str, int i2) {
        String str2;
        if (str == null) {
            str = "";
        }
        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
        blockPopInfoData.block_info = str;
        if (i2 == 0) {
            str2 = "http://tieba.baidu.com/mo/q/userappeal";
        } else {
            str2 = "http://tieba.baidu.com/mo/q/userappeal?block_errno=" + i2;
        }
        blockPopInfoData.ahead_url = str2;
        return s(context, blockPopInfoData);
    }

    public static d.b.h0.r.s.a w(Context context, String str, int i2, k kVar) {
        String str2;
        if (str == null) {
            str = "";
        }
        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
        blockPopInfoData.block_info = str;
        if (i2 == 0) {
            str2 = "http://tieba.baidu.com/mo/q/userappeal";
        } else {
            str2 = "http://tieba.baidu.com/mo/q/userappeal?block_errno=" + i2;
        }
        blockPopInfoData.ahead_url = str2;
        return t(context, blockPopInfoData, kVar);
    }

    public static boolean x(Context context, AntiData antiData, OperationType operationType, PageType pageType) {
        if (!f(antiData)) {
            q();
        }
        if (!n(antiData) && !h(antiData)) {
            if (g(antiData)) {
                y(context, antiData, operationType);
            } else if (!f(antiData) || operationType != OperationType.REPLY) {
                return false;
            } else {
                r(context, antiData, pageType);
            }
        } else if (antiData.isHas_chance()) {
            A(context, antiData, operationType, pageType);
        } else {
            z(context, antiData, operationType);
        }
        return true;
    }

    public static void y(Context context, AntiData antiData, OperationType operationType) {
        String format;
        String string;
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(d.b.c.a.j.a(context).getPageActivity());
        if (operationType == OperationType.SIGN) {
            String string2 = context.getString(R.string.anti_appeal_sign_base_tip);
            if (n(antiData)) {
                string = context.getString(R.string.anti_type_forbid_sys);
            } else if (g(antiData)) {
                string = context.getString(R.string.anti_type_forbid_bawu);
            } else if (h(antiData)) {
                string = context.getString(R.string.anti_type_hide);
            } else {
                string = context.getString(R.string.anti_type_exception);
            }
            format = MessageFormat.format(string2, string, context.getString(R.string.anti_appeal_sign_bawu_tip));
        } else {
            format = MessageFormat.format(context.getString(R.string.anti_appeal_com_tip), antiData.getBlock_forum_name(), Integer.valueOf(antiData.getDays_tofree()));
        }
        aVar.setMessage(format);
        aVar.setPositiveButton(context.getString(R.string.anti_vcode_pos), new f(context));
        aVar.setNegativeButton(context.getString(R.string.anti_account_exception_neg), new g());
        if (context instanceof Activity) {
            aVar.create(d.b.c.a.j.a(context)).show();
        }
    }

    public static void z(Context context, AntiData antiData, OperationType operationType) {
        String string;
        String string2;
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(d.b.c.a.j.a(context).getPageActivity());
        if (operationType == OperationType.SIGN) {
            String string3 = context.getString(R.string.anti_appeal_sign_base_tip);
            if (n(antiData)) {
                string2 = context.getString(R.string.anti_type_forbid_sys);
            } else if (g(antiData)) {
                string2 = context.getString(R.string.anti_type_forbid_bawu);
            } else if (h(antiData)) {
                string2 = context.getString(R.string.anti_type_hide);
            } else {
                string2 = context.getString(R.string.anti_type_exception);
            }
            string = MessageFormat.format(string3, string2, context.getString(R.string.anti_appeal_sign_no_chance_tip));
        } else {
            string = context.getString(R.string.anti_no_chance_com_tip);
        }
        aVar.setMessage(string);
        aVar.setPositiveButton(context.getString(R.string.confirm), new h());
        if (context instanceof Activity) {
            aVar.create(d.b.c.a.j.a(context)).show();
        }
    }
}
