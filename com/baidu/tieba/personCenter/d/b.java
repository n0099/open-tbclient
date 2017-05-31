package com.baidu.tieba.personCenter.d;

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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.personCenter.view.ReplyLinearLayout;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b extends z.a implements View.OnClickListener {
    private static String eHA;
    private static com.baidu.adp.widget.a.a eHz;
    private TbPageContext<?> ajh;
    public TextView alW;
    public TextView alu;
    private View bCa;
    private boolean beq;
    private View bottomLine;
    public TextView bzo;
    public TextView dIq;
    private int eHB;
    public LinearLayout eHC;
    public HeadImageView eHD;
    public ReplyLinearLayout eHt;
    public TextView eHu;
    protected final LinearLayout eHv;
    private final LinearLayout eHw;
    protected final ColumnLayout eHx;
    protected final ColumnLayout eHy;
    private final LinearLayout mLayout;

    public b(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.ajh = tbPageContext;
        this.beq = z;
        this.eHt = (ReplyLinearLayout) view.findViewById(w.h.content_container);
        this.eHt.setIsHost(this.beq);
        this.eHu = (TextView) view.findViewById(w.h.original_post_title);
        this.bCa = view.findViewById(w.h.reply_top_line);
        this.bottomLine = view.findViewById(w.h.reply_bottom_line);
        this.eHC = (LinearLayout) view.findViewById(w.h.top_line);
        this.eHD = (HeadImageView) view.findViewById(w.h.portrait);
        this.alW = (TextView) view.findViewById(w.h.username);
        this.alu = (TextView) view.findViewById(w.h.reply_time);
        this.bzo = (TextView) view.findViewById(w.h.forum_name);
        this.dIq = (TextView) view.findViewById(w.h.reply_count);
        this.eHw = (LinearLayout) view.findViewById(w.h.item_content);
        this.eHx = (ColumnLayout) view.findViewById(w.h.item_header);
        this.eHy = (ColumnLayout) view.findViewById(w.h.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(w.h.person_thread);
        this.eHv = (LinearLayout) view.findViewById(w.h.person_child);
        this.eHB = k.dip2px(view.getContext(), 42.0f);
        if (this.eHw != null) {
            this.eHw.setOnClickListener(this);
        }
        this.eHD.setOnClickListener(this);
        this.alW.setOnClickListener(this);
        this.bzo.setOnClickListener(this);
        this.dIq.setOnClickListener(this);
        this.eHx.setOnClickListener(this);
        this.eHy.setOnClickListener(this);
        this.eHu.setOnClickListener(this);
    }

    public void dj(int i) {
        aq.j(this.eHu, w.e.cp_bg_line_e);
        aq.k(getView(), w.e.cp_bg_line_c);
        aq.j(this.eHv, w.g.daily_recommend_item_selector);
        aq.c(this.alW, w.e.cp_cont_d, 1);
        aq.c(this.alu, w.e.cp_cont_d, 1);
        aq.c(this.bzo, w.e.cp_cont_d, 1);
        aq.c(this.dIq, w.e.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new as("c12043").r("obj_type", this.beq ? 1 : 2));
        if (view == this.bzo) {
            if (this.ajh != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.ajh.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.eHu && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
            if ("0".equals(strArr[2]) || strArr[1] == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ajh.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_post_reply")));
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x00e0 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0008 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x003b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003d A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008d  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v9 */
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
                            String str7 = postInfoList.user_name;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.post_id);
                            String q = au.q(postInfoList.create_time * 1000);
                            String str8 = postInfoList.forum_name;
                            String valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            str4 = str7;
                            str3 = q;
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
                            str3 = au.q(postInfoList.create_time * 1000);
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
            this.alW.setText(str4);
            this.alu.setText(str3);
            this.bzo.setText(str2);
            this.bzo.setTag(str2);
            this.dIq.setText(String.format(TbadkCoreApplication.m9getInst().getContext().getString(w.l.comment_num_tip), new Object[]{str6}));
            this.bzo.setOnClickListener(this);
            eF(str);
            if (this.eHw != null) {
                this.eHw.setTag(strArr);
            }
            this.eHx.setTag(strArr);
            this.eHy.setTag(strArr);
        }
    }

    private void eF(String str) {
        if (eHA != null && !eHA.equals(str)) {
            eHz = null;
        }
        if (eHz != null) {
            this.eHD.setImageBitmap(eHz.kR());
            eHA = str;
            return;
        }
        this.eHD.a(str, 12, this.eHB, this.eHB, false);
    }
}
