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
    private static com.baidu.adp.widget.a.a fqb;
    private static String fqc;
    public TextView amQ;
    public TextView anN;
    private View bHo;
    public TextView bRT;
    private View bTG;
    public TextView eon;
    private final LinearLayout ezI;
    public ReplyLinearLayout fpW;
    public TextView fpX;
    protected final LinearLayout fpY;
    protected final ColumnLayout fpZ;
    protected final ColumnLayout fqa;
    private int fqd;
    public LinearLayout fqe;
    public HeadImageView fqf;
    private boolean mIsHost;
    private final LinearLayout mLayout;
    private TbPageContext<?> mPageContext;

    public a(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.fpW = (ReplyLinearLayout) view.findViewById(d.g.content_container);
        this.fpW.setIsHost(this.mIsHost);
        this.fpX = (TextView) view.findViewById(d.g.original_post_title);
        this.bTG = view.findViewById(d.g.reply_top_line);
        this.bHo = view.findViewById(d.g.reply_bottom_line);
        this.fqe = (LinearLayout) view.findViewById(d.g.top_line);
        this.fqf = (HeadImageView) view.findViewById(d.g.portrait);
        this.anN = (TextView) view.findViewById(d.g.username);
        this.amQ = (TextView) view.findViewById(d.g.reply_time);
        this.bRT = (TextView) view.findViewById(d.g.forum_name);
        this.eon = (TextView) view.findViewById(d.g.reply_count);
        this.ezI = (LinearLayout) view.findViewById(d.g.item_content);
        this.fpZ = (ColumnLayout) view.findViewById(d.g.item_header);
        this.fqa = (ColumnLayout) view.findViewById(d.g.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(d.g.person_thread);
        this.fpY = (LinearLayout) view.findViewById(d.g.person_child);
        this.fqd = l.dip2px(view.getContext(), 42.0f);
        if (this.ezI != null) {
            this.ezI.setOnClickListener(this);
        }
        this.fqf.setOnClickListener(this);
        this.anN.setOnClickListener(this);
        this.bRT.setOnClickListener(this);
        this.eon.setOnClickListener(this);
        this.fpZ.setOnClickListener(this);
        this.fqa.setOnClickListener(this);
        this.fpX.setOnClickListener(this);
    }

    public void dy(int i) {
        aj.j(this.fpX, d.C0080d.cp_bg_line_e);
        aj.k(getView(), d.C0080d.cp_bg_line_c);
        aj.j(this.fpY, d.f.daily_recommend_item_selector);
        aj.c(this.anN, d.C0080d.cp_cont_d, 1);
        aj.c(this.amQ, d.C0080d.cp_cont_d, 1);
        aj.c(this.bRT, d.C0080d.cp_cont_d, 1);
        aj.c(this.eon, d.C0080d.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new ak("c12043").r("obj_type", this.mIsHost ? 1 : 2));
        if (view == this.bRT) {
            if (this.mPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.fpX && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
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
            this.anN.setText(str4);
            this.amQ.setText(str3);
            this.bRT.setText(str2);
            this.bRT.setTag(str2);
            this.eon.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(d.j.comment_num_tip), str5));
            this.bRT.setOnClickListener(this);
            fi(str);
            if (this.ezI != null) {
                this.ezI.setTag(strArr);
            }
            this.fpZ.setTag(strArr);
            this.fqa.setTag(strArr);
        }
    }

    private void fi(String str) {
        if (fqc != null && !fqc.equals(str)) {
            fqb = null;
        }
        if (fqb != null) {
            this.fqf.setImageBitmap(fqb.kK());
            fqc = str;
            return;
        }
        this.fqf.startLoad(str, 12, this.fqd, this.fqd, false);
    }
}
