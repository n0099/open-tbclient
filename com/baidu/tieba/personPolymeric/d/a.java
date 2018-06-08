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
import com.baidu.tieba.d;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.personPolymeric.view.ReplyLinearLayout;
/* loaded from: classes3.dex */
public class a extends q.a implements View.OnClickListener {
    private static com.baidu.adp.widget.ImageView.a fXb;
    private static String fXc;
    public TextView awA;
    public TextView axo;
    public TextView ayc;
    public TextView eTN;
    public ReplyLinearLayout fWW;
    public TextView fWX;
    protected final LinearLayout fWY;
    protected final ColumnLayout fWZ;
    protected final ColumnLayout fXa;
    private int fXd;
    public LinearLayout fXe;
    public HeadImageView fXf;
    private final LinearLayout ffW;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    public a(View view, TbPageContext<?> tbPageContext, boolean z) {
        super(view);
        this.mPageContext = tbPageContext;
        this.mIsHost = z;
        this.fWW = (ReplyLinearLayout) view.findViewById(d.g.content_container);
        this.fWW.setIsHost(this.mIsHost);
        this.fWX = (TextView) view.findViewById(d.g.original_post_title);
        this.fXe = (LinearLayout) view.findViewById(d.g.top_line);
        this.fXf = (HeadImageView) view.findViewById(d.g.portrait);
        this.axo = (TextView) view.findViewById(d.g.username);
        this.awA = (TextView) view.findViewById(d.g.reply_time);
        this.ayc = (TextView) view.findViewById(d.g.forum_name);
        this.eTN = (TextView) view.findViewById(d.g.reply_count);
        this.ffW = (LinearLayout) view.findViewById(d.g.item_content);
        this.fWZ = (ColumnLayout) view.findViewById(d.g.item_header);
        this.fXa = (ColumnLayout) view.findViewById(d.g.item_footer);
        this.fWY = (LinearLayout) view.findViewById(d.g.person_child);
        this.fXd = l.dip2px(view.getContext(), 42.0f);
        if (this.ffW != null) {
            this.ffW.setOnClickListener(this);
        }
        this.fXf.setOnClickListener(this);
        this.axo.setOnClickListener(this);
        this.ayc.setOnClickListener(this);
        this.eTN.setOnClickListener(this);
        this.fWZ.setOnClickListener(this);
        this.fXa.setOnClickListener(this);
        this.fWX.setOnClickListener(this);
    }

    public void dy(int i) {
        al.i(this.fWX, d.C0141d.cp_bg_line_e);
        al.j(getView(), d.C0141d.cp_bg_line_c);
        al.i(this.fWY, d.f.daily_recommend_item_selector);
        al.c(this.axo, d.C0141d.cp_cont_d, 1);
        al.c(this.awA, d.C0141d.cp_cont_d, 1);
        al.c(this.ayc, d.C0141d.cp_cont_d, 1);
        al.c(this.eTN, d.C0141d.cp_cont_d, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String[] strArr;
        TiebaStatic.log(new am("c12043").r("obj_type", this.mIsHost ? 1 : 2));
        if (view == this.ayc) {
            if (this.mPageContext != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg((String) view.getTag(), "")));
            }
        } else if (view == this.fWX && (strArr = (String[]) view.getTag()) != null && strArr.length >= 4 && strArr[3] != null) {
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
        String v;
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
                            v = ao.v(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                        } else {
                            str6 = TextUtils.isEmpty(postInfoList.name_show) ? postInfoList.user_name : postInfoList.name_show;
                            strArr[0] = String.valueOf(postInfoList.thread_id);
                            strArr[1] = String.valueOf(postInfoList.content[0].post_id);
                            strArr[2] = String.valueOf(postInfoList.content[0].post_type);
                            strArr[3] = String.valueOf(postInfoList.thread_type);
                            v = ao.v(postInfoList.create_time * 1000);
                            str7 = postInfoList.forum_name;
                            valueOf = String.valueOf(postInfoList.reply_num);
                        }
                        str4 = str6;
                        str3 = v;
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
            this.axo.setText(str4);
            this.awA.setText(str3);
            this.ayc.setText(str2);
            this.ayc.setTag(str2);
            this.eTN.setText(String.format(TbadkCoreApplication.getInst().getContext().getString(d.k.comment_num_tip), str5));
            this.ayc.setOnClickListener(this);
            se(str);
            if (this.ffW != null) {
                this.ffW.setTag(strArr);
            }
            this.fWZ.setTag(strArr);
            this.fXa.setTag(strArr);
        }
    }

    private void se(String str) {
        if (fXc != null && !fXc.equals(str)) {
            fXb = null;
        }
        if (fXb != null) {
            this.fXf.setImageBitmap(fXb.mZ());
            fXc = str;
            return;
        }
        this.fXf.startLoad(str, 12, this.fXd, this.fXd, false);
    }
}
