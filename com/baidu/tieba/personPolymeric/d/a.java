package com.baidu.tieba.personPolymeric.d;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
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
public class a extends j.a implements View.OnClickListener {
    private static com.baidu.adp.widget.a.a fpE;
    private static String fpF;
    public TextView amR;
    public TextView anO;
    private View bHb;
    public TextView bRG;
    private View bTt;
    public TextView eoj;
    private final LinearLayout ezo;
    public TextView fpA;
    protected final LinearLayout fpB;
    protected final ColumnLayout fpC;
    protected final ColumnLayout fpD;
    private int fpG;
    public LinearLayout fpH;
    public HeadImageView fpI;
    public ReplyLinearLayout fpz;
    private boolean mIsHost;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    public a(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.fpz = (ReplyLinearLayout) view.findViewById(d.g.content_container);
        this.fpz.setIsHost(this.mIsHost);
        this.fpA = (TextView) view.findViewById(d.g.original_post_title);
        this.bTt = view.findViewById(d.g.reply_top_line);
        this.bHb = view.findViewById(d.g.reply_bottom_line);
        this.fpH = (LinearLayout) view.findViewById(d.g.top_line);
        this.fpI = (HeadImageView) view.findViewById(d.g.portrait);
        this.anO = (TextView) view.findViewById(d.g.username);
        this.amR = (TextView) view.findViewById(d.g.reply_time);
        this.bRG = (TextView) view.findViewById(d.g.forum_name);
        this.eoj = (TextView) view.findViewById(d.g.reply_count);
        this.ezo = (LinearLayout) view.findViewById(d.g.item_content);
        this.fpC = (ColumnLayout) view.findViewById(d.g.item_header);
        this.fpD = (ColumnLayout) view.findViewById(d.g.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(d.g.person_thread);
        this.fpB = (LinearLayout) view.findViewById(d.g.person_child);
        this.fpG = l.dip2px(view.getContext(), 42.0f);
        if (this.ezo != null) {
            this.ezo.setOnClickListener(this);
        }
        this.fpI.setOnClickListener(this);
        this.anO.setOnClickListener(this);
        this.bRG.setOnClickListener(this);
        this.eoj.setOnClickListener(this);
        this.fpC.setOnClickListener(this);
        this.fpD.setOnClickListener(this);
        this.fpA.setOnClickListener(this);
    }

    public void dz(int i) {
        aj.j(this.fpA, d.C0080d.cp_bg_line_e);
        aj.k(getView(), d.C0080d.cp_bg_line_c);
        aj.j(this.fpB, d.f.daily_recommend_item_selector);
        aj.c(this.anO, d.C0080d.cp_cont_d, 1);
        aj.c(this.amR, d.C0080d.cp_cont_d, 1);
        aj.c(this.bRG, d.C0080d.cp_cont_d, 1);
        aj.c(this.eoj, d.C0080d.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new ak("c12043").r("obj_type", this.mIsHost ? 1 : 2));
        if (view == this.bRG) {
            if (this.mPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.fpA && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
            if ("0".equals(strArr[2]) || strArr[1] == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page")));
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
            this.anO.setText(str4);
            this.amR.setText(str3);
            this.bRG.setText(str2);
            this.bRG.setTag(str2);
            this.eoj.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(d.j.comment_num_tip), str5));
            this.bRG.setOnClickListener(this);
            fh(str);
            if (this.ezo != null) {
                this.ezo.setTag(strArr);
            }
            this.fpC.setTag(strArr);
            this.fpD.setTag(strArr);
        }
    }

    private void fh(String str) {
        if (fpF != null && !fpF.equals(str)) {
            fpE = null;
        }
        if (fpE != null) {
            this.fpI.setImageBitmap(fpE.kK());
            fpF = str;
            return;
        }
        this.fpI.startLoad(str, 12, this.fpG, this.fpG, false);
    }
}
