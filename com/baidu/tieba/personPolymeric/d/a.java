package com.baidu.tieba.personPolymeric.d;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.ReplyLinearLayout;
/* loaded from: classes3.dex */
public class a extends r.a implements View.OnClickListener {
    private static com.baidu.adp.widget.a.a gql;
    private static String gqm;
    public TextView bdP;
    public TextView bda;
    public TextView beF;
    public TextView fmM;
    private final LinearLayout fyP;
    public ReplyLinearLayout gqg;
    public TextView gqh;
    protected final LinearLayout gqi;
    protected final ColumnLayout gqj;
    protected final ColumnLayout gqk;
    private int gqn;
    public LinearLayout gqo;
    public HeadImageView gqp;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public a(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.gqg = (ReplyLinearLayout) view.findViewById(d.g.content_container);
        this.gqg.setIsHost(this.mIsHost);
        this.gqh = (TextView) view.findViewById(d.g.original_post_title);
        this.gqo = (LinearLayout) view.findViewById(d.g.top_line);
        this.gqp = (HeadImageView) view.findViewById(d.g.portrait);
        this.bdP = (TextView) view.findViewById(d.g.username);
        this.bda = (TextView) view.findViewById(d.g.reply_time);
        this.beF = (TextView) view.findViewById(d.g.forum_name);
        this.fmM = (TextView) view.findViewById(d.g.reply_count);
        this.fyP = (LinearLayout) view.findViewById(d.g.item_content);
        this.gqj = (ColumnLayout) view.findViewById(d.g.item_header);
        this.gqk = (ColumnLayout) view.findViewById(d.g.item_footer);
        this.gqi = (LinearLayout) view.findViewById(d.g.person_child);
        this.gqn = l.dip2px(view.getContext(), 42.0f);
        if (this.fyP != null) {
            this.fyP.setOnClickListener(this);
        }
        this.gqp.setOnClickListener(this);
        this.bdP.setOnClickListener(this);
        this.beF.setOnClickListener(this);
        this.fmM.setOnClickListener(this);
        this.gqj.setOnClickListener(this);
        this.gqk.setOnClickListener(this);
        this.gqh.setOnClickListener(this);
    }

    public void gx(int i) {
        aj.s(this.gqh, d.C0141d.cp_bg_line_e);
        aj.t(getView(), d.C0141d.cp_bg_line_c);
        aj.s(this.gqi, d.f.daily_recommend_item_selector);
        aj.e(this.bdP, d.C0141d.cp_cont_d, 1);
        aj.e(this.bda, d.C0141d.cp_cont_d, 1);
        aj.e(this.beF, d.C0141d.cp_cont_d, 1);
        aj.e(this.fmM, d.C0141d.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new ak("c12043").s("obj_type", this.mIsHost ? 1 : 2));
        if (view == this.beF) {
            if (this.mPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.gqh && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
            if ("0".equals(strArr[2]) || strArr[1] == null) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                createNormalCfg.setStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
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
        String z2;
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
                            z2 = am.z(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                        } else {
                            str6 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            z2 = am.z(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                        }
                        str4 = str6;
                        str3 = z2;
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
            this.bdP.setText(str4);
            this.bda.setText(str3);
            this.beF.setText(str2);
            this.beF.setTag(str2);
            this.fmM.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(d.j.comment_num_tip), str5));
            this.beF.setOnClickListener(this);
            fM(str);
            if (this.fyP != null) {
                this.fyP.setTag(strArr);
            }
            this.gqj.setTag(strArr);
            this.gqk.setTag(strArr);
        }
    }

    private void fM(String str) {
        if (gqm != null && !gqm.equals(str)) {
            gql = null;
        }
        if (gql != null) {
            this.gqp.setImageBitmap(gql.sh());
            gqm = str;
            return;
        }
        this.gqp.startLoad(str, 12, this.gqn, this.gqn, false);
    }
}
