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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    private static com.baidu.adp.widget.a.a emU;
    private static String emV;
    private TbPageContext<?> Ea;
    public TextView adE;
    public TextView bad;
    public TextView dwB;
    protected final LinearLayout emQ;
    private final LinearLayout emR;
    protected final ColumnLayout emS;
    protected final ColumnLayout emT;
    private InterfaceC0074a emW;
    private int emX;
    public LinearLayout emY;
    public HeadImageView emZ;
    public TextView ena;
    private final LinearLayout mLayout;

    /* renamed from: com.baidu.tieba.person.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0074a {
        void bc(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.Ea = tbPageContext;
        this.emY = (LinearLayout) view.findViewById(u.g.top_line);
        this.emZ = (HeadImageView) view.findViewById(u.g.portrait);
        this.ena = (TextView) view.findViewById(u.g.username);
        this.adE = (TextView) view.findViewById(u.g.reply_time);
        this.bad = (TextView) view.findViewById(u.g.forum_name);
        this.dwB = (TextView) view.findViewById(u.g.reply_count);
        this.emR = (LinearLayout) view.findViewById(u.g.item_content);
        this.emS = (ColumnLayout) view.findViewById(u.g.item_header);
        this.emT = (ColumnLayout) view.findViewById(u.g.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(u.g.person_thread);
        this.emQ = (LinearLayout) view.findViewById(u.g.person_child);
        this.emX = com.baidu.adp.lib.util.k.dip2px(view.getContext(), 42.0f);
        if (this.emR != null) {
            this.emR.setOnClickListener(this);
        }
        this.emZ.setOnClickListener(this);
        this.ena.setOnClickListener(this);
        this.bad.setOnClickListener(this);
        this.dwB.setOnClickListener(this);
        this.emS.setOnClickListener(this);
        this.emT.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == u.g.forum_name) {
            if (this.Ea != null) {
                this.Ea.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.Ea.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.emW != null) {
            this.emW.bc(view);
        }
    }

    public void a(InterfaceC0074a interfaceC0074a) {
        this.emW = interfaceC0074a;
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
                            String y = ba.y(postInfoList.create_time * 1000);
                            String str8 = postInfoList.forum_name;
                            String valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            str4 = str7;
                            str3 = y;
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
                            str3 = ba.y(postInfoList.create_time * 1000);
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
            this.ena.setText(str4);
            this.adE.setText(str3);
            this.bad.setText(str2);
            this.bad.setTag(str2);
            this.dwB.setText(str6);
            this.bad.setOnClickListener(this);
            eO(str);
            if (this.emR != null) {
                this.emR.setTag(strArr);
            }
            this.emS.setTag(strArr);
            this.emT.setTag(strArr);
        }
    }

    private void eO(String str) {
        if (emV != null && !emV.equals(str)) {
            emU = null;
        }
        if (emU != null) {
            this.emZ.setImageBitmap(emU.jb());
            emV = str;
            return;
        }
        this.emZ.a(str, 12, this.emX, this.emX, false);
    }

    public void cT(int i) {
        av.c(this.bad, u.d.cp_cont_d, 1);
        av.c(this.adE, u.d.cp_cont_d, 1);
        av.c(this.ena, u.d.cp_cont_f, 1);
        av.k(this.mLayout, u.d.cp_bg_line_c);
        av.k(this.emQ, u.f.daily_recommend_item_selector);
        TbadkCoreApplication.m9getInst().getSkinType();
        this.dwB.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        av.c(this.dwB, u.d.cp_link_tip_c, 1);
    }
}
