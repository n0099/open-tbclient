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
    private static com.baidu.adp.widget.a.a ffj;
    private static String ffk;
    public TextView anA;
    public TextView aos;
    public TextView bJc;
    private View bLN;
    private boolean bmo;
    private View bottomLine;
    public TextView ejJ;
    public ReplyLinearLayout ffd;
    public TextView ffe;
    protected final LinearLayout fff;
    private final LinearLayout ffg;
    protected final ColumnLayout ffh;
    protected final ColumnLayout ffi;
    private int ffl;
    public LinearLayout ffm;
    public HeadImageView ffn;
    private TbPageContext<?> mF;
    private final LinearLayout mLayout;

    public b(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.mF = tbPageContext;
        this.bmo = z;
        this.ffd = (ReplyLinearLayout) view.findViewById(d.h.content_container);
        this.ffd.setIsHost(this.bmo);
        this.ffe = (TextView) view.findViewById(d.h.original_post_title);
        this.bLN = view.findViewById(d.h.reply_top_line);
        this.bottomLine = view.findViewById(d.h.reply_bottom_line);
        this.ffm = (LinearLayout) view.findViewById(d.h.top_line);
        this.ffn = (HeadImageView) view.findViewById(d.h.portrait);
        this.aos = (TextView) view.findViewById(d.h.username);
        this.anA = (TextView) view.findViewById(d.h.reply_time);
        this.bJc = (TextView) view.findViewById(d.h.forum_name);
        this.ejJ = (TextView) view.findViewById(d.h.reply_count);
        this.ffg = (LinearLayout) view.findViewById(d.h.item_content);
        this.ffh = (ColumnLayout) view.findViewById(d.h.item_header);
        this.ffi = (ColumnLayout) view.findViewById(d.h.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(d.h.person_thread);
        this.fff = (LinearLayout) view.findViewById(d.h.person_child);
        this.ffl = k.dip2px(view.getContext(), 42.0f);
        if (this.ffg != null) {
            this.ffg.setOnClickListener(this);
        }
        this.ffn.setOnClickListener(this);
        this.aos.setOnClickListener(this);
        this.bJc.setOnClickListener(this);
        this.ejJ.setOnClickListener(this);
        this.ffh.setOnClickListener(this);
        this.ffi.setOnClickListener(this);
        this.ffe.setOnClickListener(this);
    }

    public void dq(int i) {
        aj.j(this.ffe, d.e.cp_bg_line_e);
        aj.k(getView(), d.e.cp_bg_line_c);
        aj.j(this.fff, d.g.daily_recommend_item_selector);
        aj.c(this.aos, d.e.cp_cont_d, 1);
        aj.c(this.anA, d.e.cp_cont_d, 1);
        aj.c(this.bJc, d.e.cp_cont_d, 1);
        aj.c(this.ejJ, d.e.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new ak("c12043").r("obj_type", this.bmo ? 1 : 2));
        if (view == this.bJc) {
            if (this.mF != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mF.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.ffe && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
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
            this.aos.setText(str4);
            this.anA.setText(str3);
            this.bJc.setText(str2);
            this.bJc.setTag(str2);
            this.ejJ.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(d.l.comment_num_tip), str5));
            this.bJc.setOnClickListener(this);
            fi(str);
            if (this.ffg != null) {
                this.ffg.setTag(strArr);
            }
            this.ffh.setTag(strArr);
            this.ffi.setTag(strArr);
        }
    }

    private void fi(String str) {
        if (ffk != null && !ffk.equals(str)) {
            ffj = null;
        }
        if (ffj != null) {
            this.ffn.setImageBitmap(ffj.kO());
            ffk = str;
            return;
        }
        this.ffn.a(str, 12, this.ffl, this.ffl, false);
    }
}
