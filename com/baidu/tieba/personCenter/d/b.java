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
    private static com.baidu.adp.widget.a.a fgT;
    private static String fgU;
    public TextView aoT;
    public TextView aog;
    public TextView bGi;
    private View bIU;
    private boolean blT;
    private View bottomLine;
    public TextView eda;
    public ReplyLinearLayout fgN;
    public TextView fgO;
    protected final LinearLayout fgP;
    private final LinearLayout fgQ;
    protected final ColumnLayout fgR;
    protected final ColumnLayout fgS;
    private int fgV;
    public LinearLayout fgW;
    public HeadImageView fgX;
    private final LinearLayout mLayout;
    private TbPageContext<?> oW;

    public b(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.oW = tbPageContext;
        this.blT = z;
        this.fgN = (ReplyLinearLayout) view.findViewById(d.h.content_container);
        this.fgN.setIsHost(this.blT);
        this.fgO = (TextView) view.findViewById(d.h.original_post_title);
        this.bIU = view.findViewById(d.h.reply_top_line);
        this.bottomLine = view.findViewById(d.h.reply_bottom_line);
        this.fgW = (LinearLayout) view.findViewById(d.h.top_line);
        this.fgX = (HeadImageView) view.findViewById(d.h.portrait);
        this.aoT = (TextView) view.findViewById(d.h.username);
        this.aog = (TextView) view.findViewById(d.h.reply_time);
        this.bGi = (TextView) view.findViewById(d.h.forum_name);
        this.eda = (TextView) view.findViewById(d.h.reply_count);
        this.fgQ = (LinearLayout) view.findViewById(d.h.item_content);
        this.fgR = (ColumnLayout) view.findViewById(d.h.item_header);
        this.fgS = (ColumnLayout) view.findViewById(d.h.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(d.h.person_thread);
        this.fgP = (LinearLayout) view.findViewById(d.h.person_child);
        this.fgV = k.dip2px(view.getContext(), 42.0f);
        if (this.fgQ != null) {
            this.fgQ.setOnClickListener(this);
        }
        this.fgX.setOnClickListener(this);
        this.aoT.setOnClickListener(this);
        this.bGi.setOnClickListener(this);
        this.eda.setOnClickListener(this);
        this.fgR.setOnClickListener(this);
        this.fgS.setOnClickListener(this);
        this.fgO.setOnClickListener(this);
    }

    public void dp(int i) {
        ai.j(this.fgO, d.e.cp_bg_line_e);
        ai.k(getView(), d.e.cp_bg_line_c);
        ai.j(this.fgP, d.g.daily_recommend_item_selector);
        ai.c(this.aoT, d.e.cp_cont_d, 1);
        ai.c(this.aog, d.e.cp_cont_d, 1);
        ai.c(this.bGi, d.e.cp_cont_d, 1);
        ai.c(this.eda, d.e.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new aj("c12043").r("obj_type", this.blT ? 1 : 2));
        if (view == this.bGi) {
            if (this.oW != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.oW.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.fgO && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
            if ("0".equals(strArr[2]) || strArr[1] == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.oW.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page")));
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
            this.bGi.setText(str2);
            this.bGi.setTag(str2);
            this.eda.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(d.l.comment_num_tip), str5));
            this.bGi.setOnClickListener(this);
            fn(str);
            if (this.fgQ != null) {
                this.fgQ.setTag(strArr);
            }
            this.fgR.setTag(strArr);
            this.fgS.setTag(strArr);
        }
    }

    private void fn(String str) {
        if (fgU != null && !fgU.equals(str)) {
            fgT = null;
        }
        if (fgT != null) {
            this.fgX.setImageBitmap(fgT.kW());
            fgU = str;
            return;
        }
        this.fgX.a(str, 12, this.fgV, this.fgV, false);
    }
}
