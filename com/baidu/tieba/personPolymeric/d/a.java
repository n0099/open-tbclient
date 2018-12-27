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
    private static com.baidu.adp.widget.ImageView.a gBr;
    private static String gBs;
    public TextView aIY;
    public TextView aJM;
    public TextView aKr;
    public HeadImageView edG;
    private final LinearLayout fKh;
    public ReplyLinearLayout gBm;
    public TextView gBn;
    protected final LinearLayout gBo;
    protected final ColumnLayout gBp;
    protected final ColumnLayout gBq;
    private int gBt;
    public LinearLayout gBu;
    public TextView gBv;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public a(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.gBm = (ReplyLinearLayout) view.findViewById(e.g.content_container);
        this.gBm.setIsHost(this.mIsHost);
        this.gBn = (TextView) view.findViewById(e.g.original_post_title);
        this.gBu = (LinearLayout) view.findViewById(e.g.top_line);
        this.edG = (HeadImageView) view.findViewById(e.g.portrait);
        this.aKr = (TextView) view.findViewById(e.g.username);
        this.aIY = (TextView) view.findViewById(e.g.reply_time);
        this.aJM = (TextView) view.findViewById(e.g.forum_name);
        this.gBv = (TextView) view.findViewById(e.g.reply_count);
        this.fKh = (LinearLayout) view.findViewById(e.g.item_content);
        this.gBp = (ColumnLayout) view.findViewById(e.g.item_header);
        this.gBq = (ColumnLayout) view.findViewById(e.g.item_footer);
        this.gBo = (LinearLayout) view.findViewById(e.g.person_child);
        this.gBt = l.dip2px(view.getContext(), 42.0f);
        if (this.fKh != null) {
            this.fKh.setOnClickListener(this);
        }
        this.edG.setOnClickListener(this);
        this.aKr.setOnClickListener(this);
        this.aJM.setOnClickListener(this);
        this.gBv.setOnClickListener(this);
        this.gBp.setOnClickListener(this);
        this.gBq.setOnClickListener(this);
        this.gBn.setOnClickListener(this);
    }

    public void ey(int i) {
        al.i(this.gBn, e.d.cp_bg_line_e);
        al.j(getView(), e.d.cp_bg_line_c);
        al.i(this.gBo, e.f.daily_recommend_item_selector);
        al.c(this.aKr, e.d.cp_cont_d, 1);
        al.c(this.aIY, e.d.cp_cont_d, 1);
        al.c(this.aJM, e.d.cp_cont_d, 1);
        al.c(this.gBv, e.d.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new am("c12043").x("obj_type", this.mIsHost ? 1 : 2));
        if (view == this.aJM) {
            if (this.mPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.gBn && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
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
        String M;
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
                            M = ao.M(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                        } else {
                            str6 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            M = ao.M(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                        }
                        str4 = str6;
                        str3 = M;
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
            this.aKr.setText(str4);
            this.aIY.setText(str3);
            this.aJM.setText(str2);
            this.aJM.setTag(str2);
            this.gBv.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(e.j.comment_num_tip), str5));
            this.aJM.setOnClickListener(this);
            tR(str);
            if (this.fKh != null) {
                this.fKh.setTag(strArr);
            }
            this.gBp.setTag(strArr);
            this.gBq.setTag(strArr);
        }
    }

    private void tR(String str) {
        if (gBs != null && !gBs.equals(str)) {
            gBr = null;
        }
        if (gBr != null) {
            this.edG.setImageBitmap(gBr.op());
            gBs = str;
            return;
        }
        this.edG.startLoad(str, 12, this.gBt, this.gBt, false);
    }
}
