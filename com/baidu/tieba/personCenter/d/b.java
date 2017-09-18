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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.view.ReplyLinearLayout;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* loaded from: classes.dex */
public class b extends j.a implements View.OnClickListener {
    private static com.baidu.adp.widget.a.a fgc;
    private static String fgd;
    public TextView any;
    public TextView aoq;
    public TextView bJT;
    private View bME;
    private boolean bmn;
    private View bottomLine;
    public TextView ekD;
    public ReplyLinearLayout ffW;
    public TextView ffX;
    protected final LinearLayout ffY;
    private final LinearLayout ffZ;
    protected final ColumnLayout fga;
    protected final ColumnLayout fgb;
    private int fge;
    public LinearLayout fgf;
    public HeadImageView fgg;
    private TbPageContext<?> mF;
    private final LinearLayout mLayout;

    public b(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.mF = tbPageContext;
        this.bmn = z;
        this.ffW = (ReplyLinearLayout) view.findViewById(d.h.content_container);
        this.ffW.setIsHost(this.bmn);
        this.ffX = (TextView) view.findViewById(d.h.original_post_title);
        this.bME = view.findViewById(d.h.reply_top_line);
        this.bottomLine = view.findViewById(d.h.reply_bottom_line);
        this.fgf = (LinearLayout) view.findViewById(d.h.top_line);
        this.fgg = (HeadImageView) view.findViewById(d.h.portrait);
        this.aoq = (TextView) view.findViewById(d.h.username);
        this.any = (TextView) view.findViewById(d.h.reply_time);
        this.bJT = (TextView) view.findViewById(d.h.forum_name);
        this.ekD = (TextView) view.findViewById(d.h.reply_count);
        this.ffZ = (LinearLayout) view.findViewById(d.h.item_content);
        this.fga = (ColumnLayout) view.findViewById(d.h.item_header);
        this.fgb = (ColumnLayout) view.findViewById(d.h.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(d.h.person_thread);
        this.ffY = (LinearLayout) view.findViewById(d.h.person_child);
        this.fge = k.dip2px(view.getContext(), 42.0f);
        if (this.ffZ != null) {
            this.ffZ.setOnClickListener(this);
        }
        this.fgg.setOnClickListener(this);
        this.aoq.setOnClickListener(this);
        this.bJT.setOnClickListener(this);
        this.ekD.setOnClickListener(this);
        this.fga.setOnClickListener(this);
        this.fgb.setOnClickListener(this);
        this.ffX.setOnClickListener(this);
    }

    public void dq(int i) {
        aj.j(this.ffX, d.e.cp_bg_line_e);
        aj.k(getView(), d.e.cp_bg_line_c);
        aj.j(this.ffY, d.g.daily_recommend_item_selector);
        aj.c(this.aoq, d.e.cp_cont_d, 1);
        aj.c(this.any, d.e.cp_cont_d, 1);
        aj.c(this.bJT, d.e.cp_cont_d, 1);
        aj.c(this.ekD, d.e.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new ak("c12043").r("obj_type", this.bmn ? 1 : 2));
        if (view == this.bJT) {
            if (this.mF != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mF.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.ffX && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
            if ("0".equals(strArr[2]) || strArr[1] == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mF.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page")));
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
                            r = am.r(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                        } else {
                            str6 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            r = am.r(postInfoList.create_time * 1000);
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
            this.aoq.setText(str4);
            this.any.setText(str3);
            this.bJT.setText(str2);
            this.bJT.setTag(str2);
            this.ekD.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(d.l.comment_num_tip), str5));
            this.bJT.setOnClickListener(this);
            fi(str);
            if (this.ffZ != null) {
                this.ffZ.setTag(strArr);
            }
            this.fga.setTag(strArr);
            this.fgb.setTag(strArr);
        }
    }

    private void fi(String str) {
        if (fgd != null && !fgd.equals(str)) {
            fgc = null;
        }
        if (fgc != null) {
            this.fgg.setImageBitmap(fgc.kO());
            fgd = str;
            return;
        }
        this.fgg.a(str, 12, this.fge, this.fge, false);
    }
}
