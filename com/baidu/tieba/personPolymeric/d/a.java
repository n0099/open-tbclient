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
    private static com.baidu.adp.widget.ImageView.a fhf;
    private static String fhg;
    public TextView amw;
    public TextView ant;
    private View bAC;
    public TextView bKa;
    private View bLP;
    public TextView egA;
    private final LinearLayout erc;
    public ReplyLinearLayout fha;
    public TextView fhb;
    protected final LinearLayout fhc;
    protected final ColumnLayout fhd;
    protected final ColumnLayout fhe;
    private int fhh;
    public LinearLayout fhi;
    public HeadImageView fhj;
    private TbPageContext<?> mH;
    private boolean mIsHost;
    private final LinearLayout mLayout;

    public a(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.mH = tbPageContext;
        this.mIsHost = z;
        this.fha = (ReplyLinearLayout) view.findViewById(d.h.content_container);
        this.fha.setIsHost(this.mIsHost);
        this.fhb = (TextView) view.findViewById(d.h.original_post_title);
        this.bLP = view.findViewById(d.h.reply_top_line);
        this.bAC = view.findViewById(d.h.reply_bottom_line);
        this.fhi = (LinearLayout) view.findViewById(d.h.top_line);
        this.fhj = (HeadImageView) view.findViewById(d.h.portrait);
        this.ant = (TextView) view.findViewById(d.h.username);
        this.amw = (TextView) view.findViewById(d.h.reply_time);
        this.bKa = (TextView) view.findViewById(d.h.forum_name);
        this.egA = (TextView) view.findViewById(d.h.reply_count);
        this.erc = (LinearLayout) view.findViewById(d.h.item_content);
        this.fhd = (ColumnLayout) view.findViewById(d.h.item_header);
        this.fhe = (ColumnLayout) view.findViewById(d.h.item_footer);
        this.mLayout = (LinearLayout) view.findViewById(d.h.person_thread);
        this.fhc = (LinearLayout) view.findViewById(d.h.person_child);
        this.fhh = l.dip2px(view.getContext(), 42.0f);
        if (this.erc != null) {
            this.erc.setOnClickListener(this);
        }
        this.fhj.setOnClickListener(this);
        this.ant.setOnClickListener(this);
        this.bKa.setOnClickListener(this);
        this.egA.setOnClickListener(this);
        this.fhd.setOnClickListener(this);
        this.fhe.setOnClickListener(this);
        this.fhb.setOnClickListener(this);
    }

    public void dy(int i) {
        aj.j(this.fhb, d.e.cp_bg_line_e);
        aj.k(getView(), d.e.cp_bg_line_c);
        aj.j(this.fhc, d.g.daily_recommend_item_selector);
        aj.c(this.ant, d.e.cp_cont_d, 1);
        aj.c(this.amw, d.e.cp_cont_d, 1);
        aj.c(this.bKa, d.e.cp_cont_d, 1);
        aj.c(this.egA, d.e.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new ak("c12043").r("obj_type", this.mIsHost ? 1 : 2));
        if (view == this.bKa) {
            if (this.mH != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mH.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.fhb && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
            if ("0".equals(strArr[2]) || strArr[1] == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mH.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page")));
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
            this.ant.setText(str4);
            this.amw.setText(str3);
            this.bKa.setText(str2);
            this.bKa.setTag(str2);
            this.egA.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(d.l.comment_num_tip), str5));
            this.bKa.setOnClickListener(this);
            fa(str);
            if (this.erc != null) {
                this.erc.setTag(strArr);
            }
            this.fhd.setTag(strArr);
            this.fhe.setTag(strArr);
        }
    }

    private void fa(String str) {
        if (fhg != null && !fhg.equals(str)) {
            fhf = null;
        }
        if (fhf != null) {
            this.fhj.setImageBitmap(fhf.kN());
            fhg = str;
            return;
        }
        this.fhj.a(str, 12, this.fhh, this.fhh, false);
    }
}
