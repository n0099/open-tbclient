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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.ReplyLinearLayout;
/* loaded from: classes3.dex */
public class a extends q.a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a fKJ;
    private static String fKK;
    public TextView aos;
    public TextView apV;
    public TextView apg;
    public TextView eHm;
    private final LinearLayout eTx;
    public ReplyLinearLayout fKE;
    public TextView fKF;
    protected final LinearLayout fKG;
    protected final ColumnLayout fKH;
    protected final ColumnLayout fKI;
    private int fKL;
    public LinearLayout fKM;
    public HeadImageView fKN;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public a(View view2, TbPageContext<?> tbPageContext, boolean z) {
        super(view2);
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.fKE = (ReplyLinearLayout) view2.findViewById(d.g.content_container);
        this.fKE.setIsHost(this.mIsHost);
        this.fKF = (TextView) view2.findViewById(d.g.original_post_title);
        this.fKM = (LinearLayout) view2.findViewById(d.g.top_line);
        this.fKN = (HeadImageView) view2.findViewById(d.g.portrait);
        this.apg = (TextView) view2.findViewById(d.g.username);
        this.aos = (TextView) view2.findViewById(d.g.reply_time);
        this.apV = (TextView) view2.findViewById(d.g.forum_name);
        this.eHm = (TextView) view2.findViewById(d.g.reply_count);
        this.eTx = (LinearLayout) view2.findViewById(d.g.item_content);
        this.fKH = (ColumnLayout) view2.findViewById(d.g.item_header);
        this.fKI = (ColumnLayout) view2.findViewById(d.g.item_footer);
        this.fKG = (LinearLayout) view2.findViewById(d.g.person_child);
        this.fKL = l.dip2px(view2.getContext(), 42.0f);
        if (this.eTx != null) {
            this.eTx.setOnClickListener(this);
        }
        this.fKN.setOnClickListener(this);
        this.apg.setOnClickListener(this);
        this.apV.setOnClickListener(this);
        this.eHm.setOnClickListener(this);
        this.fKH.setOnClickListener(this);
        this.fKI.setOnClickListener(this);
        this.fKF.setOnClickListener(this);
    }

    public void dv(int i) {
        ak.i(this.fKF, d.C0126d.cp_bg_line_e);
        ak.j(getView(), d.C0126d.cp_bg_line_c);
        ak.i(this.fKG, d.f.daily_recommend_item_selector);
        ak.c(this.apg, d.C0126d.cp_cont_d, 1);
        ak.c(this.aos, d.C0126d.cp_cont_d, 1);
        ak.c(this.apV, d.C0126d.cp_cont_d, 1);
        ak.c(this.eHm, d.C0126d.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        String[] strArr;
        TiebaStatic.log(new al("c12043").r("obj_type", this.mIsHost ? 1 : 2));
        if (view2 == this.apV) {
            if (this.mPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view2.getTag(), "")));
            }
        } else if (view2 == this.fKF && (strArr = (String[]) view2.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
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
        String s;
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
                            s = an.s(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                        } else {
                            str6 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            s = an.s(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                        }
                        str4 = str6;
                        str3 = s;
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
            this.apg.setText(str4);
            this.aos.setText(str3);
            this.apV.setText(str2);
            this.apV.setTag(str2);
            this.eHm.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(d.k.comment_num_tip), str5));
            this.apV.setOnClickListener(this);
            rk(str);
            if (this.eTx != null) {
                this.eTx.setTag(strArr);
            }
            this.fKH.setTag(strArr);
            this.fKI.setTag(strArr);
        }
    }

    private void rk(String str) {
        if (fKK != null && !fKK.equals(str)) {
            fKJ = null;
        }
        if (fKJ != null) {
            this.fKN.setImageBitmap(fKJ.km());
            fKK = str;
            return;
        }
        this.fKN.startLoad(str, 12, this.fKL, this.fKL, false);
    }
}
