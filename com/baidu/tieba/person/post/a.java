package com.baidu.tieba.person.post;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.person.PersonPostModel;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    private static com.baidu.adp.widget.a.a cQt;
    private static String cQu;
    public TextView aLY;
    public TextView aYC;
    protected final LinearLayout cQp;
    private final LinearLayout cQq;
    protected final ColumnLayout cQr;
    protected final ColumnLayout cQs;
    private InterfaceC0082a cQv;
    public LinearLayout cQw;
    public HeadImageView cQx;
    public TextView cQy;
    public TextView cQz;
    private final LinearLayout ccA;
    private int cvt;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.person.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0082a {
        void am(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.cQw = (LinearLayout) view.findViewById(n.f.top_line);
        this.cQx = (HeadImageView) view.findViewById(n.f.portrait);
        this.cQy = (TextView) view.findViewById(n.f.username);
        this.aYC = (TextView) view.findViewById(n.f.reply_time);
        this.aLY = (TextView) view.findViewById(n.f.forum_name);
        this.cQz = (TextView) view.findViewById(n.f.reply_count);
        this.cQq = (LinearLayout) view.findViewById(n.f.item_content);
        this.cQr = (ColumnLayout) view.findViewById(n.f.item_header);
        this.cQs = (ColumnLayout) view.findViewById(n.f.item_footer);
        this.ccA = (LinearLayout) view.findViewById(n.f.person_thread);
        this.cQp = (LinearLayout) view.findViewById(n.f.person_child);
        this.cvt = com.baidu.adp.lib.util.k.dip2px(view.getContext(), 42.0f);
        if (this.cQq != null) {
            this.cQq.setOnClickListener(this);
        }
        this.cQx.setOnClickListener(this);
        this.cQy.setOnClickListener(this);
        this.aLY.setOnClickListener(this);
        this.cQz.setOnClickListener(this);
        this.cQr.setOnClickListener(this);
        this.cQs.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == n.f.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.cQv != null) {
            this.cQv.am(view);
        }
    }

    public void a(InterfaceC0082a interfaceC0082a) {
        this.cQv = interfaceC0082a;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x00cc */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0008 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x003c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003e A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008f  */
    /* JADX WARN: Type inference failed for: r0v12, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
        String str2;
        String str3;
        String str4;
        String str5 = null;
        String str6 = 4;
        String[] strArr = new String[4];
        try {
            try {
                try {
                    try {
                        if (z) {
                            String str7 = postInfoList.user_name;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.post_id);
                            String s = ax.s(postInfoList.create_time * 1000);
                            String str8 = postInfoList.forum_name;
                            String valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            str4 = str7;
                            str3 = s;
                            str2 = str8;
                            str6 = valueOf;
                            str5 = 1;
                        } else {
                            String str9 = postInfoList.user_name;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            str4 = str9;
                            str3 = ax.s(postInfoList.create_time * 1000);
                            str2 = postInfoList.forum_name;
                            str6 = String.valueOf(postInfoList.reply_num);
                            str5 = 1;
                        }
                    } catch (Exception e) {
                        str4 = str3;
                        str3 = str2;
                        str2 = str6;
                        str6 = str5;
                        str5 = null;
                        if (str5 != null) {
                        }
                    }
                } catch (Exception e2) {
                    str6 = str5;
                    str4 = str3;
                    str3 = str2;
                    str2 = str6;
                    str6 = str5;
                    str5 = null;
                    if (str5 != null) {
                    }
                }
            } catch (Exception e3) {
                str6 = str5;
                str2 = str5;
                str4 = str3;
                str3 = str2;
                str2 = str6;
                str6 = str5;
                str5 = null;
                if (str5 != null) {
                }
            }
        } catch (Exception e4) {
            str6 = str5;
            str2 = str5;
            str3 = str5;
            str4 = str3;
            str3 = str2;
            str2 = str6;
            str6 = str5;
            str5 = null;
            if (str5 != null) {
            }
        }
        if (str5 != null) {
            this.cQy.setText(str4);
            this.aYC.setText(str3);
            this.aLY.setText(str2);
            this.aLY.setTag(str2);
            this.cQz.setText(str6);
            this.aLY.setOnClickListener(this);
            eE(str);
            if (this.cQq != null) {
                this.cQq.setTag(strArr);
            }
            this.cQr.setTag(strArr);
            this.cQs.setTag(strArr);
        }
    }

    private void eE(String str) {
        if (cQu != null && !cQu.equals(str)) {
            cQt = null;
        }
        if (cQt != null) {
            this.cQx.setImageBitmap(cQt.ng());
            cQu = str;
            return;
        }
        this.cQx.a(str, 12, this.cvt, this.cvt, false);
    }

    public void cV(int i) {
        as.b(this.aLY, n.c.cp_cont_d, 1);
        as.b(this.aYC, n.c.cp_cont_d, 1);
        as.b(this.cQy, n.c.cp_cont_f, 1);
        as.i(this.ccA, n.c.cp_bg_line_c);
        as.i(this.cQp, n.e.daily_recommend_item_selector);
        TbadkCoreApplication.m411getInst().getSkinType();
        this.cQz.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        as.b(this.cQz, n.c.cp_link_tip_c, 1);
    }
}
