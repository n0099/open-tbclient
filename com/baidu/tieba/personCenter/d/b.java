package com.baidu.tieba.personCenter.d;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.view.ReplyLinearLayout;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* loaded from: classes.dex */
public class b extends j.a implements View.OnClickListener {
    private static com.baidu.adp.widget.a.a feY;
    private static String feZ;
    private TbPageContext<?> alI;
    public TextView aoS;
    public TextView aof;
    public TextView bFy;
    private View bIk;
    private boolean blJ;
    private View bottomLine;
    public TextView ebe;
    public ReplyLinearLayout feS;
    public TextView feT;
    protected final LinearLayout feU;
    private final LinearLayout feV;
    protected final ColumnLayout feW;
    protected final ColumnLayout feX;
    private int ffa;
    public LinearLayout ffb;
    public HeadImageView ffc;
    private final LinearLayout mLayout;

    public b(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.alI = tbPageContext;
        this.blJ = z;
        this.feS = (ReplyLinearLayout) view.findViewById(d.h.content_container);
        this.feS.setIsHost(this.blJ);
        this.feT = (TextView) view.findViewById(d.h.original_post_title);
        this.bIk = view.findViewById(d.h.reply_top_line);
        this.bottomLine = view.findViewById(d.h.reply_bottom_line);
        this.ffb = (LinearLayout) view.findViewById(d.h.top_line);
        this.ffc = (HeadImageView) view.findViewById(d.h.portrait);
        this.aoS = (TextView) view.findViewById(d.h.username);
        this.aof = (TextView) view.findViewById(d.h.reply_time);
        this.bFy = (TextView) view.findViewById(d.h.forum_name);
        this.ebe = (TextView) view.findViewById(d.h.reply_count);
        this.feV = (LinearLayout) view.findViewById(d.h.item_content);
        this.feW = (ColumnLayout) view.findViewById(d.h.item_header);
        this.feX = (ColumnLayout) view.findViewById(d.h.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(d.h.person_thread);
        this.feU = (LinearLayout) view.findViewById(d.h.person_child);
        this.ffa = k.dip2px(view.getContext(), 42.0f);
        if (this.feV != null) {
            this.feV.setOnClickListener(this);
        }
        this.ffc.setOnClickListener(this);
        this.aoS.setOnClickListener(this);
        this.bFy.setOnClickListener(this);
        this.ebe.setOnClickListener(this);
        this.feW.setOnClickListener(this);
        this.feX.setOnClickListener(this);
        this.feT.setOnClickListener(this);
    }

    public void dp(int i) {
        ai.j(this.feT, d.e.cp_bg_line_e);
        ai.k(getView(), d.e.cp_bg_line_c);
        ai.j(this.feU, d.g.daily_recommend_item_selector);
        ai.c(this.aoS, d.e.cp_cont_d, 1);
        ai.c(this.aof, d.e.cp_cont_d, 1);
        ai.c(this.bFy, d.e.cp_cont_d, 1);
        ai.c(this.ebe, d.e.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new aj("c12043").r("obj_type", this.blJ ? 1 : 2));
        if (view == this.bFy) {
            if (this.alI != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.alI.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.feT && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
            if ("0".equals(strArr[2]) || strArr[1] == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.alI.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page")));
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x00f1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x0008 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0045 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009e  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PersonPostModel.PostInfoList postInfoList, boolean z, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String r;
        String str7;
        String valueOf;
        String str8 = null;
        String str9 = 4;
        String[] strArr = new String[4];
        try {
            try {
                try {
                    try {
                        if (z) {
                            str6 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.post_id);
                            r = al.r(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                        } else {
                            str6 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            r = al.r(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                        }
                        str4 = str6;
                        str3 = r;
                        str2 = str7;
                        str9 = valueOf;
                        str8 = 1;
                        str5 = str9;
                    } catch (Exception e) {
                        str9 = str8;
                        str4 = str3;
                        str3 = str2;
                        str2 = str9;
                        str5 = str8;
                        str8 = null;
                        if (str8 != null) {
                        }
                    }
                } catch (Exception e2) {
                    str9 = str8;
                    str2 = str8;
                    str4 = str3;
                    str3 = str2;
                    str2 = str9;
                    str5 = str8;
                    str8 = null;
                    if (str8 != null) {
                    }
                }
            } catch (Exception e3) {
                str9 = 0;
                str2 = null;
                str3 = null;
                str4 = str3;
                str3 = str2;
                str2 = str9;
                str5 = str8;
                str8 = null;
                if (str8 != null) {
                }
            }
        } catch (Exception e4) {
            str4 = str3;
            str3 = str2;
            str2 = str9;
            str5 = str8;
            str8 = null;
            if (str8 != null) {
            }
        }
        if (str8 != null) {
            this.aoS.setText(str4);
            this.aof.setText(str3);
            this.bFy.setText(str2);
            this.bFy.setTag(str2);
            this.ebe.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(d.l.comment_num_tip), str5));
            this.bFy.setOnClickListener(this);
            fj(str);
            if (this.feV != null) {
                this.feV.setTag(strArr);
            }
            this.feW.setTag(strArr);
            this.feX.setTag(strArr);
        }
    }

    private void fj(String str) {
        if (feZ != null && !feZ.equals(str)) {
            feY = null;
        }
        if (feY != null) {
            this.ffc.setImageBitmap(feY.kX());
            feZ = str;
            return;
        }
        this.ffc.a(str, 12, this.ffa, this.ffa, false);
    }
}
