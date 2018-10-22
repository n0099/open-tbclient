package com.baidu.tieba.personPolymeric.d;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.ReplyLinearLayout;
/* loaded from: classes3.dex */
public class a extends q.a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a gql;
    private static String gqm;
    public TextView aEH;
    public TextView aFZ;
    public TextView aFu;
    public HeadImageView dTg;
    private final LinearLayout fzc;
    public ReplyLinearLayout gqg;
    public TextView gqh;
    protected final LinearLayout gqi;
    protected final ColumnLayout gqj;
    protected final ColumnLayout gqk;
    private int gqn;
    public LinearLayout gqo;
    public TextView gqp;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public a(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.gqg = (ReplyLinearLayout) view.findViewById(e.g.content_container);
        this.gqg.setIsHost(this.mIsHost);
        this.gqh = (TextView) view.findViewById(e.g.original_post_title);
        this.gqo = (LinearLayout) view.findViewById(e.g.top_line);
        this.dTg = (HeadImageView) view.findViewById(e.g.portrait);
        this.aFZ = (TextView) view.findViewById(e.g.username);
        this.aEH = (TextView) view.findViewById(e.g.reply_time);
        this.aFu = (TextView) view.findViewById(e.g.forum_name);
        this.gqp = (TextView) view.findViewById(e.g.reply_count);
        this.fzc = (LinearLayout) view.findViewById(e.g.item_content);
        this.gqj = (ColumnLayout) view.findViewById(e.g.item_header);
        this.gqk = (ColumnLayout) view.findViewById(e.g.item_footer);
        this.gqi = (LinearLayout) view.findViewById(e.g.person_child);
        this.gqn = l.dip2px(view.getContext(), 42.0f);
        if (this.fzc != null) {
            this.fzc.setOnClickListener(this);
        }
        this.dTg.setOnClickListener(this);
        this.aFZ.setOnClickListener(this);
        this.aFu.setOnClickListener(this);
        this.gqp.setOnClickListener(this);
        this.gqj.setOnClickListener(this);
        this.gqk.setOnClickListener(this);
        this.gqh.setOnClickListener(this);
    }

    public void dW(int i) {
        al.i(this.gqh, e.d.cp_bg_line_e);
        al.j(getView(), e.d.cp_bg_line_c);
        al.i(this.gqi, e.f.daily_recommend_item_selector);
        al.c(this.aFZ, e.d.cp_cont_d, 1);
        al.c(this.aEH, e.d.cp_cont_d, 1);
        al.c(this.aFu, e.d.cp_cont_d, 1);
        al.c(this.gqp, e.d.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new am("c12043").x("obj_type", this.mIsHost ? 1 : 2));
        if (view == this.aFu) {
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
        String C;
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
                            C = ao.C(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                        } else {
                            str6 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            C = ao.C(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                        }
                        str4 = str6;
                        str3 = C;
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
            this.aFZ.setText(str4);
            this.aEH.setText(str3);
            this.aFu.setText(str2);
            this.aFu.setTag(str2);
            this.gqp.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(e.j.comment_num_tip), str5));
            this.aFu.setOnClickListener(this);
            th(str);
            if (this.fzc != null) {
                this.fzc.setTag(strArr);
            }
            this.gqj.setTag(strArr);
            this.gqk.setTag(strArr);
        }
    }

    private void th(String str) {
        if (gqm != null && !gqm.equals(str)) {
            gql = null;
        }
        if (gql != null) {
            this.dTg.setImageBitmap(gql.os());
            gqm = str;
            return;
        }
        this.dTg.startLoad(str, 12, this.gqn, this.gqn, false);
    }
}
