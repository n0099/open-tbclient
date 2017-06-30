package com.baidu.tieba.personCenter.d;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.personCenter.view.ReplyLinearLayout;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b extends z.a implements View.OnClickListener {
    private static com.baidu.adp.widget.a.a eRn;
    private static String eRo;
    private TbPageContext<?> ajP;
    public TextView amO;
    public TextView ami;
    public TextView bAh;
    private View bCT;
    private boolean bhl;
    private View bottomLine;
    public TextView dQP;
    public ReplyLinearLayout eRh;
    public TextView eRi;
    protected final LinearLayout eRj;
    private final LinearLayout eRk;
    protected final ColumnLayout eRl;
    protected final ColumnLayout eRm;
    private int eRp;
    public LinearLayout eRq;
    public HeadImageView eRr;
    private final LinearLayout mLayout;

    public b(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.ajP = tbPageContext;
        this.bhl = z;
        this.eRh = (ReplyLinearLayout) view.findViewById(w.h.content_container);
        this.eRh.setIsHost(this.bhl);
        this.eRi = (TextView) view.findViewById(w.h.original_post_title);
        this.bCT = view.findViewById(w.h.reply_top_line);
        this.bottomLine = view.findViewById(w.h.reply_bottom_line);
        this.eRq = (LinearLayout) view.findViewById(w.h.top_line);
        this.eRr = (HeadImageView) view.findViewById(w.h.portrait);
        this.amO = (TextView) view.findViewById(w.h.username);
        this.ami = (TextView) view.findViewById(w.h.reply_time);
        this.bAh = (TextView) view.findViewById(w.h.forum_name);
        this.dQP = (TextView) view.findViewById(w.h.reply_count);
        this.eRk = (LinearLayout) view.findViewById(w.h.item_content);
        this.eRl = (ColumnLayout) view.findViewById(w.h.item_header);
        this.eRm = (ColumnLayout) view.findViewById(w.h.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(w.h.person_thread);
        this.eRj = (LinearLayout) view.findViewById(w.h.person_child);
        this.eRp = k.dip2px(view.getContext(), 42.0f);
        if (this.eRk != null) {
            this.eRk.setOnClickListener(this);
        }
        this.eRr.setOnClickListener(this);
        this.amO.setOnClickListener(this);
        this.bAh.setOnClickListener(this);
        this.dQP.setOnClickListener(this);
        this.eRl.setOnClickListener(this);
        this.eRm.setOnClickListener(this);
        this.eRi.setOnClickListener(this);
    }

    public void dl(int i) {
        as.j(this.eRi, w.e.cp_bg_line_e);
        as.k(getView(), w.e.cp_bg_line_c);
        as.j(this.eRj, w.g.daily_recommend_item_selector);
        as.c(this.amO, w.e.cp_cont_d, 1);
        as.c(this.ami, w.e.cp_cont_d, 1);
        as.c(this.bAh, w.e.cp_cont_d, 1);
        as.c(this.dQP, w.e.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new au("c12043").r("obj_type", this.bhl ? 1 : 2));
        if (view == this.bAh) {
            if (this.ajP != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.ajP.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.eRi && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
            if ("0".equals(strArr[2]) || strArr[1] == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ajP.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_post_reply")));
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x00f6 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x0008 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x0043 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0045 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a3  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object[]] */
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
                            String str7 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.post_id);
                            String q = aw.q(postInfoList.create_time * 1000);
                            String str8 = postInfoList.forum_name;
                            String valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            str4 = str7;
                            str3 = q;
                            str2 = str8;
                            str6 = valueOf;
                            str5 = 1;
                        } else {
                            String str9 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            str4 = str9;
                            str3 = aw.q(postInfoList.create_time * 1000);
                            str2 = postInfoList.forum_name;
                            str6 = String.valueOf(postInfoList.reply_num);
                            str5 = 1;
                        }
                    } catch (Exception e) {
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
                } catch (Exception e2) {
                    str6 = 0;
                    str2 = null;
                    str3 = null;
                    str4 = str3;
                    str3 = str2;
                    str2 = str6;
                    str6 = str5;
                    str5 = null;
                    if (str5 != null) {
                    }
                }
            } catch (Exception e3) {
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
            str4 = str3;
            str3 = str2;
            str2 = str6;
            str6 = str5;
            str5 = null;
            if (str5 != null) {
            }
        }
        if (str5 != null) {
            this.amO.setText(str4);
            this.ami.setText(str3);
            this.bAh.setText(str2);
            this.bAh.setTag(str2);
            this.dQP.setText(String.format(TbadkCoreApplication.m9getInst().getContext().getString(w.l.comment_num_tip), new Object[]{str6}));
            this.bAh.setOnClickListener(this);
            eZ(str);
            if (this.eRk != null) {
                this.eRk.setTag(strArr);
            }
            this.eRl.setTag(strArr);
            this.eRm.setTag(strArr);
        }
    }

    private void eZ(String str) {
        if (eRo != null && !eRo.equals(str)) {
            eRn = null;
        }
        if (eRn != null) {
            this.eRr.setImageBitmap(eRn.kP());
            eRo = str;
            return;
        }
        this.eRr.a(str, 12, this.eRp, this.eRp, false);
    }
}
