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
    private static com.baidu.adp.widget.a.a fgR;
    private static String fgS;
    public TextView aoT;
    public TextView aog;
    public TextView bGh;
    private View bIT;
    private boolean blR;
    private View bottomLine;
    public TextView eda;
    public ReplyLinearLayout fgL;
    public TextView fgM;
    protected final LinearLayout fgN;
    private final LinearLayout fgO;
    protected final ColumnLayout fgP;
    protected final ColumnLayout fgQ;
    private int fgT;
    public LinearLayout fgU;
    public HeadImageView fgV;
    private final LinearLayout mLayout;
    private TbPageContext<?> oV;

    public b(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.oV = tbPageContext;
        this.blR = z;
        this.fgL = (ReplyLinearLayout) view.findViewById(d.h.content_container);
        this.fgL.setIsHost(this.blR);
        this.fgM = (TextView) view.findViewById(d.h.original_post_title);
        this.bIT = view.findViewById(d.h.reply_top_line);
        this.bottomLine = view.findViewById(d.h.reply_bottom_line);
        this.fgU = (LinearLayout) view.findViewById(d.h.top_line);
        this.fgV = (HeadImageView) view.findViewById(d.h.portrait);
        this.aoT = (TextView) view.findViewById(d.h.username);
        this.aog = (TextView) view.findViewById(d.h.reply_time);
        this.bGh = (TextView) view.findViewById(d.h.forum_name);
        this.eda = (TextView) view.findViewById(d.h.reply_count);
        this.fgO = (LinearLayout) view.findViewById(d.h.item_content);
        this.fgP = (ColumnLayout) view.findViewById(d.h.item_header);
        this.fgQ = (ColumnLayout) view.findViewById(d.h.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(d.h.person_thread);
        this.fgN = (LinearLayout) view.findViewById(d.h.person_child);
        this.fgT = k.dip2px(view.getContext(), 42.0f);
        if (this.fgO != null) {
            this.fgO.setOnClickListener(this);
        }
        this.fgV.setOnClickListener(this);
        this.aoT.setOnClickListener(this);
        this.bGh.setOnClickListener(this);
        this.eda.setOnClickListener(this);
        this.fgP.setOnClickListener(this);
        this.fgQ.setOnClickListener(this);
        this.fgM.setOnClickListener(this);
    }

    public void dp(int i) {
        ai.j(this.fgM, d.e.cp_bg_line_e);
        ai.k(getView(), d.e.cp_bg_line_c);
        ai.j(this.fgN, d.g.daily_recommend_item_selector);
        ai.c(this.aoT, d.e.cp_cont_d, 1);
        ai.c(this.aog, d.e.cp_cont_d, 1);
        ai.c(this.bGh, d.e.cp_cont_d, 1);
        ai.c(this.eda, d.e.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new aj("c12043").r("obj_type", this.blR ? 1 : 2));
        if (view == this.bGh) {
            if (this.oV != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.oV.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.fgM && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
            if ("0".equals(strArr[2]) || strArr[1] == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.oV.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page")));
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
            this.aoT.setText(str4);
            this.aog.setText(str3);
            this.bGh.setText(str2);
            this.bGh.setTag(str2);
            this.eda.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(d.l.comment_num_tip), str5));
            this.bGh.setOnClickListener(this);
            fj(str);
            if (this.fgO != null) {
                this.fgO.setTag(strArr);
            }
            this.fgP.setTag(strArr);
            this.fgQ.setTag(strArr);
        }
    }

    private void fj(String str) {
        if (fgS != null && !fgS.equals(str)) {
            fgR = null;
        }
        if (fgR != null) {
            this.fgV.setImageBitmap(fgR.kX());
            fgS = str;
            return;
        }
        this.fgV.a(str, 12, this.fgT, this.fgT, false);
    }
}
