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
    private static com.baidu.adp.widget.ImageView.a gCv;
    private static String gCw;
    public TextView aJA;
    public TextView aKT;
    public TextView aKo;
    public HeadImageView eem;
    private final LinearLayout fLb;
    public ReplyLinearLayout gCq;
    public TextView gCr;
    protected final LinearLayout gCs;
    protected final ColumnLayout gCt;
    protected final ColumnLayout gCu;
    private int gCx;
    public LinearLayout gCy;
    public TextView gCz;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public a(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.gCq = (ReplyLinearLayout) view.findViewById(e.g.content_container);
        this.gCq.setIsHost(this.mIsHost);
        this.gCr = (TextView) view.findViewById(e.g.original_post_title);
        this.gCy = (LinearLayout) view.findViewById(e.g.top_line);
        this.eem = (HeadImageView) view.findViewById(e.g.portrait);
        this.aKT = (TextView) view.findViewById(e.g.username);
        this.aJA = (TextView) view.findViewById(e.g.reply_time);
        this.aKo = (TextView) view.findViewById(e.g.forum_name);
        this.gCz = (TextView) view.findViewById(e.g.reply_count);
        this.fLb = (LinearLayout) view.findViewById(e.g.item_content);
        this.gCt = (ColumnLayout) view.findViewById(e.g.item_header);
        this.gCu = (ColumnLayout) view.findViewById(e.g.item_footer);
        this.gCs = (LinearLayout) view.findViewById(e.g.person_child);
        this.gCx = l.dip2px(view.getContext(), 42.0f);
        if (this.fLb != null) {
            this.fLb.setOnClickListener(this);
        }
        this.eem.setOnClickListener(this);
        this.aKT.setOnClickListener(this);
        this.aKo.setOnClickListener(this);
        this.gCz.setOnClickListener(this);
        this.gCt.setOnClickListener(this);
        this.gCu.setOnClickListener(this);
        this.gCr.setOnClickListener(this);
    }

    public void ey(int i) {
        al.i(this.gCr, e.d.cp_bg_line_e);
        al.j(getView(), e.d.cp_bg_line_c);
        al.i(this.gCs, e.f.daily_recommend_item_selector);
        al.c(this.aKT, e.d.cp_cont_d, 1);
        al.c(this.aJA, e.d.cp_cont_d, 1);
        al.c(this.aKo, e.d.cp_cont_d, 1);
        al.c(this.gCz, e.d.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new am("c12043").y("obj_type", this.mIsHost ? 1 : 2));
        if (view == this.aKo) {
            if (this.mPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.gCr && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
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
            this.aKT.setText(str4);
            this.aJA.setText(str3);
            this.aKo.setText(str2);
            this.aKo.setTag(str2);
            this.gCz.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(e.j.comment_num_tip), str5));
            this.aKo.setOnClickListener(this);
            uh(str);
            if (this.fLb != null) {
                this.fLb.setTag(strArr);
            }
            this.gCt.setTag(strArr);
            this.gCu.setTag(strArr);
        }
    }

    private void uh(String str) {
        if (gCw != null && !gCw.equals(str)) {
            gCv = null;
        }
        if (gCv != null) {
            this.eem.setImageBitmap(gCv.ot());
            gCw = str;
            return;
        }
        this.eem.startLoad(str, 12, this.gCx, this.gCx, false);
    }
}
