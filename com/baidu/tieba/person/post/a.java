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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    private static com.baidu.adp.widget.a.a dAU;
    private static String dAV;
    private TbPageContext<?> ND;
    public TextView aRQ;
    public TextView ahr;
    public TextView cPU;
    private final LinearLayout cvF;
    protected final LinearLayout dAQ;
    private final LinearLayout dAR;
    protected final ColumnLayout dAS;
    protected final ColumnLayout dAT;
    private InterfaceC0077a dAW;
    private int dAX;
    public LinearLayout dAY;
    public HeadImageView dAZ;
    public TextView dBa;

    /* renamed from: com.baidu.tieba.person.post.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0077a {
        void aQ(View view);
    }

    public a(View view, TbPageContext<?> tbPageContext) {
        this.ND = tbPageContext;
        this.dAY = (LinearLayout) view.findViewById(t.g.top_line);
        this.dAZ = (HeadImageView) view.findViewById(t.g.portrait);
        this.dBa = (TextView) view.findViewById(t.g.username);
        this.ahr = (TextView) view.findViewById(t.g.reply_time);
        this.aRQ = (TextView) view.findViewById(t.g.forum_name);
        this.cPU = (TextView) view.findViewById(t.g.reply_count);
        this.dAR = (LinearLayout) view.findViewById(t.g.item_content);
        this.dAS = (ColumnLayout) view.findViewById(t.g.item_header);
        this.dAT = (ColumnLayout) view.findViewById(t.g.item_footer);
        this.cvF = (LinearLayout) view.findViewById(t.g.person_thread);
        this.dAQ = (LinearLayout) view.findViewById(t.g.person_child);
        this.dAX = com.baidu.adp.lib.util.k.dip2px(view.getContext(), 42.0f);
        if (this.dAR != null) {
            this.dAR.setOnClickListener(this);
        }
        this.dAZ.setOnClickListener(this);
        this.dBa.setOnClickListener(this);
        this.aRQ.setOnClickListener(this);
        this.cPU.setOnClickListener(this);
        this.dAS.setOnClickListener(this);
        this.dAT.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == t.g.forum_name) {
            if (this.ND != null) {
                this.ND.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.ND.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (this.dAW != null) {
            this.dAW.aQ(view);
        }
    }

    public void a(InterfaceC0077a interfaceC0077a) {
        this.dAW = interfaceC0077a;
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
                            String w = ay.w(postInfoList.create_time * 1000);
                            String str8 = postInfoList.forum_name;
                            String valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            str4 = str7;
                            str3 = w;
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
                            str3 = ay.w(postInfoList.create_time * 1000);
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
            this.dBa.setText(str4);
            this.ahr.setText(str3);
            this.aRQ.setText(str2);
            this.aRQ.setTag(str2);
            this.cPU.setText(str6);
            this.aRQ.setOnClickListener(this);
            eN(str);
            if (this.dAR != null) {
                this.dAR.setTag(strArr);
            }
            this.dAS.setTag(strArr);
            this.dAT.setTag(strArr);
        }
    }

    private void eN(String str) {
        if (dAV != null && !dAV.equals(str)) {
            dAU = null;
        }
        if (dAU != null) {
            this.dAZ.setImageBitmap(dAU.mK());
            dAV = str;
            return;
        }
        this.dAZ.a(str, 12, this.dAX, this.dAX, false);
    }

    public void dj(int i) {
        at.b(this.aRQ, t.d.cp_cont_d, 1);
        at.b(this.ahr, t.d.cp_cont_d, 1);
        at.b(this.dBa, t.d.cp_cont_f, 1);
        at.k(this.cvF, t.d.cp_bg_line_c);
        at.k(this.dAQ, t.f.daily_recommend_item_selector);
        TbadkCoreApplication.m411getInst().getSkinType();
        this.cPU.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        at.b(this.cPU, t.d.cp_link_tip_c, 1);
    }
}
