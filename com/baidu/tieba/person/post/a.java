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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.person.PersonPostModel;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    private static com.baidu.adp.widget.a.a csG;
    private static String csH;
    public TextView aNK;
    public TextView aTo;
    private final LinearLayout bNw;
    private int cdr;
    protected final LinearLayout csC;
    private final LinearLayout csD;
    protected final ColumnLayout csE;
    protected final ColumnLayout csF;
    private InterfaceC0073a csI;
    public LinearLayout csJ;
    public HeadImageView csK;
    public TextView csL;
    public TextView csM;
    private TbPageContext<?> mPageContext;

    /* renamed from: com.baidu.tieba.person.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0073a {
        void ad(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.csJ = (LinearLayout) view.findViewById(i.f.top_line);
        this.csK = (HeadImageView) view.findViewById(i.f.portrait);
        this.csL = (TextView) view.findViewById(i.f.username);
        this.aTo = (TextView) view.findViewById(i.f.reply_time);
        this.aNK = (TextView) view.findViewById(i.f.forum_name);
        this.csM = (TextView) view.findViewById(i.f.reply_count);
        this.csD = (LinearLayout) view.findViewById(i.f.item_content);
        this.csE = (ColumnLayout) view.findViewById(i.f.item_header);
        this.csF = (ColumnLayout) view.findViewById(i.f.item_footer);
        this.bNw = (LinearLayout) view.findViewById(i.f.person_thread);
        this.csC = (LinearLayout) view.findViewById(i.f.person_child);
        this.cdr = com.baidu.adp.lib.util.k.dip2px(view.getContext(), 42.0f);
        if (this.csD != null) {
            this.csD.setOnClickListener(this);
        }
        this.csK.setOnClickListener(this);
        this.csL.setOnClickListener(this);
        this.aTo.setOnClickListener(this);
        this.aNK.setOnClickListener(this);
        this.csM.setOnClickListener(this);
        this.csE.setOnClickListener(this);
        this.csF.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == i.f.forum_name) {
            if (this.mPageContext != null) {
                this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.csI != null) {
            this.csI.ad(view);
        }
    }

    public void a(InterfaceC0073a interfaceC0073a) {
        this.csI = interfaceC0073a;
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
                            String m = as.m(postInfoList.create_time * 1000);
                            String str8 = postInfoList.forum_name;
                            String valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            str4 = str7;
                            str3 = m;
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
                            str3 = as.m(postInfoList.create_time * 1000);
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
            this.csL.setText(str4);
            this.aTo.setText(str3);
            this.aNK.setText(str2);
            this.aNK.setTag(str2);
            this.csM.setText(str6);
            this.aNK.setOnClickListener(this);
            eu(str);
            if (this.csD != null) {
                this.csD.setTag(strArr);
            }
            this.csE.setTag(strArr);
            this.csF.setTag(strArr);
        }
    }

    private void eu(String str) {
        if (csH != null && !csH.equals(str)) {
            csG = null;
        }
        if (csG != null) {
            this.csK.setImageBitmap(csG.nb());
            csH = str;
            return;
        }
        this.csK.a(str, 12, this.cdr, this.cdr, false);
    }

    public void cN(int i) {
        an.b(this.aNK, i.c.cp_cont_d, 1);
        an.b(this.aTo, i.c.cp_cont_d, 1);
        an.b(this.csL, i.c.cp_cont_f, 1);
        an.i(this.bNw, i.c.cp_bg_line_c);
        an.i(this.csC, i.e.daily_recommend_item_selector);
        TbadkCoreApplication.m411getInst().getSkinType();
        this.csM.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        an.b(this.csM, i.c.cp_link_tip_c, 1);
    }
}
